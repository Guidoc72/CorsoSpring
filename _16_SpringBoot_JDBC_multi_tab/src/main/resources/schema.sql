CREATE TABLE  IF NOT EXISTS prodotto(
  id 			INT PRIMARY KEY AUTO_INCREMENT,
  nome 			VARCHAR(255),
  descrizione 	VARCHAR(255),
  prezzo 		DECIMAL(10,2)
);

CREATE TABLE IF NOT EXISTS ordine(
  id 			INT PRIMARY KEY AUTO_INCREMENT,
  nome_cliente 	VARCHAR(255),
  data_ordine 	DATE
);

CREATE TABLE IF NOT EXISTS prodotto_ordine(
  prodotto_id 	INT,
  ordine_id 	INT,
  PRIMARY KEY (prodotto_id, ordine_id),
  FOREIGN KEY (prodotto_id) REFERENCES prodotto(id),
  FOREIGN KEY (ordine_id) REFERENCES ordine(id)
);