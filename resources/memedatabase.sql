CREATE DATABASE IF NOT EXISTS `memes`;
USE `memes`;

CREATE TABLE `account` (
       `account_name` varchar(25) NOT NULL,
       `account_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
       `email` varchar(32) NOT NULL,
       `password` varchar(32) NOT NULL,
       PRIMARY KEY (`account_id`)
);

CREATE TABLE `meme` (
       `meme_title` varchar(32) NOT NULL,
       `meme_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
       `category` varchar(10),
       `visibility` BOOLEAN,
       PRIMARY KEY (`meme_id`)
);

CREATE TABLE `creates` (
       `account_name` varchar(25) NOT NULL,
       `account_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
       `meme_id` smallint(5) unsigned NOT NULL,
       `last_update` DATETIME,
       `creation_date` DATETIME,
       PRIMARY KEY (`account_name`, `account_id`, `meme_id`),
       FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
       FOREIGN KEY (`meme_id`) REFERENCES `meme` (`meme_id`)
);

CREATE TABLE `picture` (
       `picture_title` varchar(25) NOT NULL PRIMARY KEY
);

CREATE TABLE `template` (
       `text_box` varchar(32) NOT NULL PRIMARY KEY
);

CREATE TABLE `contains` (
       `meme_id` smallint(5) unsigned NOT NULL,
       `picture_title` varchar(25) NOT NULL,
       `text_box` varchar(32) NOT NULL,
       PRIMARY KEY (`meme_id`, `picture_title`,  `text_box`),
       FOREIGN KEY (`meme_id`) REFERENCES `meme` (`meme_id`),
       FOREIGN KEY (`picture_title`) REFERENCES `picture` (`picture_title`),
       FOREIGN KEY (`text_box`) REFERENCES `template` (`text_box`)
);

CREATE TABLE `viewed` (
       `meme_id` smallint(5) unsigned NOT NULL,
       `account_name` varchar(25) NOT NULL,
       `account_id` smallint(5) unsigned NOT NULL,
       `favorite` BOOLEAN NOT NULL,
       PRIMARY KEY (`meme_id`, `account_id`),
       FOREIGN KEY (`meme_id`) REFERENCES `meme` (`meme_id`),
       FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
);
