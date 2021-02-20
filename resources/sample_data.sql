USE `memes`;

-- Account table
-- (username, email, password)
INSERT INTO `account` VALUES
('lurker', 'guy@lurk.net','password'),
('memecreator984','memer@meme.com','password1234'),
('berniegirl', 'feeltheburn@bernie.com', 'bernie4life'),
('limabean','lima@bean.org','password'),
('rickroller32','rickastley@gmail.com','123456');

-- Meme table
-- (meme_id, meme_title, category, visibility)
INSERT INTO `meme` VALUES
(1, 'Feel the Burn', 'Bernie', TRUE),
(2, 'Duckroll', 'Animal', TRUE),
(3, 'Bad Luck Brian', 'Bad Luck Brian', TRUE),
(4, 'Bernie Help', 'Bernie', TRUE),
(5, 'Bernie vid', 'Bernie', TRUE),
(6, 'Bad Luck Brian', 'Bad Luck Brian', FALSE);

-- Picture table
-- (picture_title, uri)
INSERT INTO `picture` VALUES
('Bernie 2021', 'Chairbernie.jpg'),
('Campaign Bernie', 'Bernieasking.png'),
('I''m asking you Bernie', 'movingbernie.gif'),
('Bad Luck Brian', 'Badluckbrian.jpg'),
('Duckroll', 'duckroll.jpg');


-- Template table -
-- (template_id, text_box)
INSERT INTO `template` VALUES
(1, NULL),
(2, 'I''m asking for your support again'),
(3, NULL),
(4, 'Takes first cruise, Costa Concordia'),
(5, NULL);

-- Creates Table
-- (username, meme_id, last_update(datetime), creation_date(datetime))
INSERT INTO `creates` VALUES
('berniegirl', 1, '2019-12-25 08:21:00', '2019-12-03 11:44:00'),
('memecreator984', 2, '2016-06-23 12:29:00', '2004-04-04 12:37:00'),
('limabean', 3, '2008-02-14 12:39:00', '2007-03-14 13:12:00'),
('berniegirl', 4, '2011-09-12 13:41:00', '2010-11-03 14:21:00'),
('berniegirl', 5, '2018-10-31 15:45:00', '2017-08-03 16:21:00'),
('memecreator984', 6, '2019-12-25 16:29:00', '2019-12-03 18:40:00');

-- Contains Table
-- (meme_id, picture_title, template_id)
INSERT INTO `contains` VALUES
(1, 'Bernie 2021', 1),
(2, 'Duckroll', 3),
(3, 'Bad Luck Brian', 4),
(4, 'Campaign Bernie', 2),
(5, 'I''m asking you Bernie', 2),
(6, 'Bad Luck Brian', 5);

-- Viewed Table
-- (meme_id, username, favorite)
INSERT INTO `viewed` VALUES
(1, 'lurker', FALSE),
(2, 'lurker', FALSE),
(3, 'lurker', FALSE),
(4, 'lurker', FALSE),
(5, 'lurker', FALSE),
(1, 'berniegirl', TRUE),
(2, 'berniegirl', FALSE),
(4, 'berniegirl', FALSE),
(5, 'berniegirl', TRUE),
(3, 'memecreator984', TRUE),
(5, 'memecreator984', TRUE),
(6, 'memecreator984', FALSE),
(3, 'limabean', FALSE),
(5, 'limabean', TRUE),
(1, 'rickroller32', FALSE),
(5, 'rickroller32', TRUE);