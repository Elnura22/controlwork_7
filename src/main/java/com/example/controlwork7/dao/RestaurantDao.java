package com.example.controlwork7.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class RestaurantDao extends BaseDao {
    public RestaurantDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("create table if not exists restaurants\n" +
                "(\n" +
                "    id           bigserial primary key,\n" +
                "    name         text,\n" +
                "    type         text,\n" +
                "    price        bigint\n" +
                ");");
    }
}
