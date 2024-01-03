package com.example.repositories;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.models.Ordine;

@Repository
public class OrdineRepositoryImpl implements OrdineRepository {

    private JdbcTemplate jdbcTemplate;

    
    public OrdineRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
    public void insertOrdine(Ordine ordine) {
        jdbcTemplate.update("INSERT INTO ordine (id, nome_cliente, data_ordine) VALUES (?, ?, ?)",
                ordine.getId(), ordine.getNomeCliente(), ordine.getDataOrdine());
    }

    @Override
    public List<Ordine> findAllOrdini() {
        return jdbcTemplate.query("SELECT * FROM ordine", new OrdineRowMapper());
    }

    @Override
    public Ordine findOrdineById(int id) {
    	String sql = "SELECT * FROM ordine WHERE id = ?";
    	RowMapper<Ordine> rawMapper = new OrdineRowMapper();
    	return this.jdbcTemplate.queryForObject(sql, rawMapper, id);
    }

    @Override
    public void updateOrdine(Ordine ordine) {
        jdbcTemplate.update("UPDATE ordine SET nome_cliente = ?, data_ordine = ? WHERE id = ?",
                ordine.getNomeCliente(), ordine.getDataOrdine(), ordine.getId());
    }

    @Override
    public void deleteOrdine(int id) {
        jdbcTemplate.update("DELETE FROM ordine WHERE id = ?", id);
    }
}

