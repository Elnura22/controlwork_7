package com.example.controlwork7.dao;

import com.example.controlwork7.entity.Dish;
import com.example.controlwork7.entity.Restaurant;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDao extends BaseDao{
    public OrderDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("create table if not exists orders\n" +
                "(\n" +
                "    id          bigserial primary key,\n" +
                "    client_id       bigint,\n" +
                "    dish_id     bigint,\n" +
                "    date_time   timestamp default current_timestamp,\n" +
                "    foreign key (client_id) references clients (id),\n" +
                "    foreign key (dish_id) references dishes (id)\n" +
                ");");
    }


}
