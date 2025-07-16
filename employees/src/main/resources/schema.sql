CREATE TABLE IF NOT EXISTS employee (
                                        id BIGINT PRIMARY KEY,
                                        first_name VARCHAR(100),
                                        last_name VARCHAR(100),
                                        birth_date DATE,
                                        department VARCHAR(100),
                                        salary INT
);