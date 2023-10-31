DROP TABLE IF EXISTS STORE;
CREATE TABLE STORE (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
brand_id INT NOT NULL,
start_date DATETIME NOT NULL,
end_date DATETIME NOT NULL,
price_list INT NOT NULL,
product_id INT NOT NULL,
priority INT NOT NULL,
price DOUBLE NOT NULL,
curr VARCHAR NOT NULL
);