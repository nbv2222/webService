package ru.tinkoff.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import ru.tinkoff.dao.interfaces.AbstractOrderDAO;
import ru.tinkoff.entities.Order;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Repository
public class OrderDAO extends AbstractOrderDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Order getLastOrderByAccountId(Long id) {
        String sql = "SELECT" +
                " APPLICATION_ID," +
                " order_tbl.CONTACT_ID," +
                " max(DT_CREATED) AS DT_CREATED," +
                " PRODUCT_NAME" +
                " FROM order_tbl" +
                " INNER JOIN account_tbl ON order_tbl.CONTACT_ID = account_tbl.CONTACT_ID" +
                " WHERE account_tbl.CONTACT_ID = :id" +
                " GROUP BY APPLICATION_ID" +
                " LIMIT 1";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.queryForObject(sql, params, new OrderRowMapper());
    }

    private static final class OrderRowMapper implements RowMapper<Order> {

        @Nullable
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setApplication_id(rs.getLong("APPLICATION_ID"));
            order.setContact_id(rs.getLong("CONTACT_ID"));
            order.setDt_created(LocalDateTime.parse(rs.getString("DT_CREATED").replace(" ", "T")));
            order.setProductName(rs.getString("PRODUCT_NAME"));
            return order;
        }
    }
}
