CREATE TABLE IF NOT EXISTS `users` (
    `id` UUID PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `created_at` date NOT NULL,
    `modified_at` date NOT NULL,
    `last_login` date NOT NULL,
    `token` VARCHAR(500) NOT NULL,
    `is_active` VARCHAR(1) NOT NULL
);

CREATE TABLE IF NOT EXISTS `phones` (
    `id` int AUTO_INCREMENT  PRIMARY KEY,
    `number` VARCHAR(255) NOT NULL,
    `citycode` VARCHAR(10) NOT NULL,
    `countrycode` VARCHAR(10) NOT NULL,
    `user_id` UUID,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
