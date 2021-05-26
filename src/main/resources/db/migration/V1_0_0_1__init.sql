CREATE TABLE IF NOT EXISTS word (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR (250) NOT NULL
);

CREATE TABLE IF NOT EXISTS url_stat (
    id BIGSERIAL PRIMARY KEY,
    url VARCHAR(250) NOT NULL,
    viewed TIMESTAMP
);

CREATE TABLE IF NOT EXISTS word_stat (
    id BIGSERIAL PRIMARY KEY,
    url_stat_id BIGINT NOT NULL,
    word_id BIGINT NOT NULL,
    amount INT,
    FOREIGN KEY (url_stat_id) REFERENCES url_stat (id),
    FOREIGN KEY (word_id) REFERENCES word (id)
);