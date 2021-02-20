DROP DATABASE IF EXISTS `memes`;
CREATE DATABASE IF NOT EXISTS `memes`;
USE `memes`;


DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
    `account_name`      VARCHAR(25) NOT NULL,
    `account_id`        SMALLINT(5) UNSIGNED NOT NULL, -- can't be auto incremented because it's part of a composite key
    `email`             VARCHAR(32) NOT NULL,
    `password`          VARCHAR(32) NOT NULL,
    PRIMARY KEY (`account_name`, `account_id`)
);

DROP TABLE IF EXISTS `meme`;
CREATE TABLE `meme` (
    `meme_title`        VARCHAR(32) NOT NULL,
    `meme_id`           SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    `category`          VARCHAR(10),
    `visibility`        BOOLEAN NOT NULL,
    PRIMARY KEY (`meme_id`)
);

DROP TABLE IF EXISTS `creates`;
CREATE TABLE `creates` (
    `account_name`      VARCHAR(25) NOT NULL,
    `account_id`        SMALLINT(5) UNSIGNED NOT NULL,
    `meme_id`           SMALLINT(5) UNSIGNED NOT NULL,
    `last_update`       DATETIME,
    `creation_date`     DATETIME,
    PRIMARY KEY (`account_name`, `account_id`, `meme_id`),
    FOREIGN KEY (`account_name`, `account_id`) REFERENCES `account` (`account_name`, `account_id`),
    FOREIGN KEY (`meme_id`) REFERENCES `meme` (`meme_id`)
);

DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
    `picture_title`     VARCHAR(25) NOT NULL PRIMARY KEY,
    `uri`               VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
    `template_id`       SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    `text_box`          VARCHAR(32),
    PRIMARY KEY (`template_id`)
);

DROP TABLE IF EXISTS `contains`;
CREATE TABLE `contains` (
    `meme_id`           SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    `picture_title`     VARCHAR(25) NOT NULL,
    `template_id`       SMALLINT(32) UNSIGNED NOT NULL,
    PRIMARY KEY (`meme_id`, `picture_title`,  `template_id`),
    FOREIGN KEY (`meme_id`)  REFERENCES `meme` (`meme_id`),
    FOREIGN KEY (`picture_title`) REFERENCES `picture` (`picture_title`),
    FOREIGN KEY (`template_id`) REFERENCES `template` (`template_id`)
);

DROP TABLE IF EXISTS `viewed`;
CREATE TABLE `viewed` (
    `meme_id`           SMALLINT(5) UNSIGNED NOT NULL,
    `account_name`      VARCHAR(25) NOT NULL,
    `account_id`        SMALLINT(5) UNSIGNED NOT NULL,
    `favorite`          BOOLEAN NOT NULL,
    PRIMARY KEY (`meme_id`, `account_id`, `account_name`),
    FOREIGN KEY (`meme_id`) REFERENCES `meme` (`meme_id`),
    FOREIGN KEY (`account_name`, `account_id`) REFERENCES `account` (`account_name`, `account_id`)
);
