package ru.tinkoff.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import static java.lang.String.format;

@Repository
public class OrderDAO extends AbstractOrderDAO {
    private static final Logger logger = LoggerFactory.getLogger(OrderDAO.class);
    private NamedParameterJdbcTemplate jdbcTemplate;

    //sql constants
    @Value("${getLastOrderByAccountId.select}")
    private String getLastOrderByAccountIdSQL;

    @Autowired
    public OrderDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Order getLastOrderByAccountId(Long id) {
        logger.info(format(START_METHOD, GET_LAST_ORDER_BY_ACCOUNT_ID_METHOD));
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        Order order;

        try {
            order = jdbcTemplate.queryForObject(getLastOrderByAccountIdSQL, params, new OrderRowMapper());
        } catch (EmptyResultDataAccessException up) {
            logger.debug(String.format("%s %s", DB_GET_ERROR, up.getMessage()));
            throw up;
        }

        logger.debug(format(GET_OBJECT, "order", order));
        logger.info(format(END_METHOD, GET_LAST_ORDER_BY_ACCOUNT_ID_METHOD));
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
