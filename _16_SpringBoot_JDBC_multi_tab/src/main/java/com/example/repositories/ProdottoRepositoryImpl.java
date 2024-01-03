package com.example.repositories;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.models.Prodotto;

@Repository
public class ProdottoRepositoryImpl implements ProdottoRepository {

    
    private JdbcTemplate jdbcTemplate;
    
    public ProdottoRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
    public void insertProdotto(Prodotto prodotto) {
        jdbcTemplate.update("INSERT INTO prodotto (id, nome, descrizione, prezzo) VALUES (?, ?, ?, ?)",
                prodotto.getId(), prodotto.getNome(), prodotto.getDescrizione(), prodotto.getPrezzo());
    }

    @Override
    public List<Prodotto> findAllProdotti() {
        return jdbcTemplate.query("SELECT * FROM prodotto", new ProdottoRowMapper());
    }

    @Override
    public Prodotto findProdottoById(int id) {
    	String sql = "SELECT * FROM prodotto WHERE id = ?";
        RowMapper<Prodotto> rowMapper = new ProdottoRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public void updateProdotto(Prodotto prodotto) {
        jdbcTemplate.update("UPDATE prodotto SET nome = ?, descrizione = ?, prezzo = ? WHERE id = ?",
                prodotto.getNome(), prodotto.getDescrizione(), prodotto.getPrezzo(), prodotto.getId());
    }

    @Override
    public void deleteProdotto(int id) {
        jdbcTemplate.update("DELETE FROM prodotto WHERE id = ?", id);
    }
}
