package ru.tinkoff.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tinkoff.Order;
import ru.tinkoff.dao.interfaces.AbstractOrderDAO;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Repository
public class OrderDAO extends AbstractOrderDAO {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Value("${getLastOrderByAccountId.select}")
    private String getLastOrderByAccountIdSQL;

    @Autowired
    public OrderDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Order getLastOrderByAccountId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        Order order;

        try {
            order = jdbcTemplate.queryForObject(getLastOrderByAccountIdSQL, params, new OrderRowMapper());
        } catch (EmptyResultDataAccessException up) {
            throw up;
        }

        return order;
    }

    private static final class OrderRowMapper implements RowMapper<Order> {
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setApplicationId(rs.getLong("APPLICATION_ID"));
            order.setContactId(rs.getLong("CONTACT_ID"));
            order.setDtCreated(LocalDateTime.parse(rs.getString("DATE_CREATED").replace(" ", "T")));
            order.setProductName(rs.getString("PRODUCT_NAME"));
            return order;
        }
    }
}
