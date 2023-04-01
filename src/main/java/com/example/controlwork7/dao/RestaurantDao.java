package com.example.controlwork7.dao;

import com.example.controlwork7.entity.Restaurant;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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
                "    description  text\n" +
                ");");
    }


    public List<Restaurant> getListOfRestaurants() {
        String sql = "select * from restaurants";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Restaurant.class));
    }
}
