package com.example.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.example.models.Prodotto;

public class ProdottoRowMapper implements RowMapper<Prodotto> {

    @Override
    public Prodotto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Prodotto prodotto = new Prodotto(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("descrizione"),
                rs.getBigDecimal("prezzo")
        );
        return prodotto;
    }
}
