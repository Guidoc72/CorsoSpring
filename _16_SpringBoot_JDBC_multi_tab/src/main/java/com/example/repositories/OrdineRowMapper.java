package com.example.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.models.Ordine;

public class OrdineRowMapper implements RowMapper<Ordine> {

    @Override
    public Ordine mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ordine ordine = new Ordine(
                rs.getInt("id"),
                rs.getString("nome_cliente"),
                rs.getDate("data_ordine").toLocalDate()
        );
        return ordine;
    }
}