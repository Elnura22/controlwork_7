package com.example.controlwork7.dao;

import com.example.controlwork7.entity.Client;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
public class ClientDao extends BaseDao {
    public ClientDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("create table if not exists clients\n" +
                "(\n" +
                "    id           bigserial primary key,\n" +
                "    name         text,\n" +
                "    email        text,\n" +
                "    password     text,\n" +
                "    enabled      boolean default true\n" +
                ");");
    }


    public void save(Client user) {
        String sql = "insert into usr(name, email, password, enabled) " +
                "values(?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setBoolean(4, user.isEnabled());
            return ps;
        });
    }

    public List<Client> getUsers() {
        String sql = "select * from usr";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }

    public Optional<Client> findUserByEmail(String email) {
        String sql = "select * " +
                "from usr " +
                "where email = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class), email)
        ));
    }

}
