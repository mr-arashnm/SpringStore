CREATE TABLE categories
(
    id TINYINT AUTO_INCREMENT PRIMAY KEY
    name VARCHAR(255) NOT NULL
);

CREATE TABLE products
(
    id BIGINT AUTO_INCREMENT PRYMARY KEY
    name VARCHAR(255) NOT NULL
    price DECIMAL(10, 2) NOT NULL
    category_id TINYINT,
    CONSTRAINT fk_category
        FOREIGN KEY (category_id) REFERENCES categories (id)
            ON DELETE RESTRICT
);