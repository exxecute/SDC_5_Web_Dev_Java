DROP TABLE IF EXISTS  currency;
DROP TABLE IF EXISTS  bank;

CREATE TABLE IF NOT EXISTS bank
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_bank PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS currency (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        type VARCHAR(10) NOT NULL,
                                        rate DOUBLE NOT NULL,
                                        bank_id BIGINT,
                                        CONSTRAINT fk_currency_bank FOREIGN KEY (bank_id) REFERENCES bank(id)
);
