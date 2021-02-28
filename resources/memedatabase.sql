DROP DATABASE IF EXISTS `memes`;
CREATE DATABASE IF NOT EXISTS `memes`;
USE `memes`;


DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
    `username`      VARCHAR(25) NOT NULL,
    `email`             VARCHAR(32) NOT NULL,
    `password`          VARCHAR(32) NOT NULL,
    PRIMARY KEY (`username`)
);

DROP TABLE IF EXISTS `meme`;
CREATE TABLE `meme` (
    `meme_id`           SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    `meme_title`        VARCHAR(32) NOT NULL,
    `category`          VARCHAR(25),
    `visibility`        BOOLEAN NOT NULL,
    PRIMARY KEY (`meme_id`)
);

DROP TABLE IF EXISTS `creates`;
CREATE TABLE `creates` (
    `username`      VARCHAR(25) NOT NULL,
    `meme_id`           SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    `last_update`       DATETIME,
    `creation_date`     DATETIME,
    PRIMARY KEY (`username`, `meme_id`),
    FOREIGN KEY (`username`) REFERENCES `account` (`username`),
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
    `text_box`          VARCHAR(255),
    PRIMARY KEY (`template_id`)
);

DROP TABLE IF EXISTS `contains`;
CREATE TABLE `contains` (
    `meme_id`           SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    `picture_title`     VARCHAR(25) NOT NULL,
    `template_id`       SMALLINT(32) UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`meme_id`, `picture_title`,  `template_id`),
    FOREIGN KEY (`meme_id`)  REFERENCES `meme` (`meme_id`),
    FOREIGN KEY (`picture_title`) REFERENCES `picture` (`picture_title`),
    FOREIGN KEY (`template_id`) REFERENCES `template` (`template_id`)
);

DROP TABLE IF EXISTS `viewed`;
CREATE TABLE `viewed` (
    `meme_id`           SMALLINT(5) UNSIGNED NOT NULL,
    `username`      VARCHAR(25) NOT NULL,
    `favorite`          BOOLEAN NOT NULL,
    PRIMARY KEY (`meme_id`, `username`),
    FOREIGN KEY (`meme_id`) REFERENCES `meme` (`meme_id`),
    FOREIGN KEY (`username`) REFERENCES `account` (`username`)
);
