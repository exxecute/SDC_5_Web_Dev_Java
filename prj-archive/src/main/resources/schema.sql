DROP TABLE IF EXISTS  currency;

CREATE TABLE IF NOT EXISTS currency (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        code VARCHAR(10) NOT NULL,
                                        rate DOUBLE NOT NULL
);
