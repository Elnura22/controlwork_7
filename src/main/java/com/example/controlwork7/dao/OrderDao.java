package com.example.controlwork7.dao;

import com.example.controlwork7.entity.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class OrderDao extends BaseDao {
    public OrderDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("create table if not exists orders\n" +
                "(\n" +
                "    id          bigserial primary key,\n" +
                "    client_id   bigint,\n" +
                "    dish_id     bigint,\n" +
                "    date        timestamp default current_timestamp,\n" +
                "    foreign key (client_id) references clients (id),\n" +
                "    foreign key (dish_id) references dishes (id)\n" +
                ");");
    }


    public List<Order> getListOfOrders(Long id) {
        String sql = "select * from orders where client_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), id);
    }

    public void save(Order order) {
        String sql = "insert into orders(client_id, dish_id, date) " +
                "values(?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, order.getClientId());
            ps.setLong(2, order.getDishId());
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            return ps;
        });
    }
}
