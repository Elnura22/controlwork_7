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


    public void save(Client client) {
        String sql = "insert into clients(name, email, password, enabled) " +
                "values(?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getPassword());
            ps.setBoolean(4, client.isEnabled());
            return ps;
        });
    }

    public List<Client> getClients() {
        String sql = "select * from clients";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }

    public Optional<Client> findClientByEmail(String email) {
        String sql = "select * " +
                "from clients " +
                "where email = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class), email)
        ));
    }

}
