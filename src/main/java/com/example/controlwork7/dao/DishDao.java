package com.example.controlwork7.dao;

import com.example.controlwork7.entity.Dish;
import com.example.controlwork7.entity.Restaurant;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DishDao extends BaseDao {

    public DishDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("create table if not exists dishes\n" +
                "(\n" +
                "    id             bigserial primary key,\n" +
                "    name           text,\n" +
                "    type           text,\n" +
                "    price          bigint,\n" +
                "    restaurant_id  bigint,\n" +
                "    foreign key (restaurant_id) references restaurants (id)\n" +
                ");");
    }



    public List<Dish> getListById(Long id) {
        String sql = "select * " +
                "from dishes " +
                "where restaurant_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dish.class), id);
    }
}
