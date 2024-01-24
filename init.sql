CREATE TABLE IF NOT EXISTS masbody.user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    birthday DATE,
    hashpass VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS masbody.history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_date datetime default now(),
    description VARCHAR(1000) NULL NULL,
    advise VARCHAR(1000) NULL NULL
);