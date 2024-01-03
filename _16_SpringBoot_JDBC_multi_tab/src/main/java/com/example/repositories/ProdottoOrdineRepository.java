package com.example.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.models.Ordine;
import com.example.models.Prodotto;

@Repository
public class ProdottoOrdineRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProdottoOrdineRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Prodotto> findProdottiByOrdineId(int ordineId) {
    	String sql =  "SELECT prodotto.* FROM prodotto "
	    			+ "JOIN ordine_prodotto "
	    			+ "ON prodotto.id = ordine_prodotto.prodotto_id "
	    			+ "WHERE ordine_prodotto.ordine_id = ?";
    	return this.jdbcTemplate.query(sql, new ProdottoRowMapper(), ordineId);
    	//return jdbcTemplate.queryForList("SELECT prodotto.* FROM prodotto JOIN ordine_prodotto ON prodotto.id = ordine_prodotto.prodotto_id WHERE ordine_prodotto.ordine_id = ?", new Object[]{ordineId}, Prodotto.class);
    }

    public List<Ordine> findOrdiniByProdottoId(int prodottoId) {
        return jdbcTemplate.queryForList("SELECT ordine.* FROM ordine JOIN ordine_prodotto ON ordine.id = ordine_prodotto.ordine_id WHERE ordine_prodotto.prodotto_id = ?", new Object[]{prodottoId}, Ordine.class);
    }
}
