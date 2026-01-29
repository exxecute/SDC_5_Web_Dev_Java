CREATE TABLE currency (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          code VARCHAR(10) NOT NULL,
                          rate DOUBLE NOT NULL
);

INSERT INTO currency(code, rate) VALUES('USD', 1.0);
INSERT INTO currency(code, rate) VALUES('EUR', 0.95);
INSERT INTO currency(code, rate) VALUES('BYN', 2.5);
