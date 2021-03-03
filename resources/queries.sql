USE `memes`;

-- 1 - Get user's favorite memes
SELECT viewed.meme_id
FROM viewed LEFT JOIN account ON viewed.username = account.username
WHERE viewed.username = 'berniegirl'
	AND favorite = TRUE;

-- 2 - Add a new user
INSERT INTO `account`
VALUES('john', 'hello@samle.com', 'passwordbackwards');

-- 3 - Create a meme
INSERT INTO meme
VALUE (7, 'Ermageeeeerd', 'Ermagerd', 1);
INSERT INTO creates
VALUE ('john', 7, '2021-02-19 23:53:00', '2020-02-19 00:00:01');
INSERT INTO picture
VALUE ('Goosebumps', 'Goosebumps-7843.png');
INSERT INTO contains
VALUE (7, 'Goosebumps', 5);
INSERT INTO template
VALUE (5);

-- 4 - Search for a meme by title
SELECT *
FROM meme,
     (SELECT contains.meme_id
        FROM contains
        WHERE contains.picture_title = 'Bernie 2021') as B
WHERE meme.meme_id = B.meme_id;

-- 5 - Add a meme to favorite
UPDATE viewed
SET viewed.favorite = TRUE
WHERE viewed.username = 'rickroller32'
  AND viewed.meme_id = 1;

-- 6 - View a meme
INSERT INTO viewed
VALUE (1, 'memecreator984', FALSE);

-- 7 - Delete a meme
DELETE FROM meme
WHERE meme_id = 4;

-- 8 - Get user by login credentials
SELECT *
FROM account
WHERE username = 'berniegirl'
    AND password = 'bernie4life';

-- 9 - Show the memes a user has viewed
SELECT meme.meme_id, meme_title, category
FROM account, viewed, meme
WHERE viewed.meme_id = meme.meme_id
    AND account.username = viewed.username
    AND  account.username = 'lurker';

-- 10 - search meme by category
SELECT *
FROM meme
WHERE meme.category = 'Bernie'

-- 11 - Count how many favorites every meme has
SELECT meme.meme_id, meme_title, COUNT(favorite) AS users_favorited
FROM meme LEFT JOIN viewed v ON meme.meme_id = v.meme_id
GROUP BY meme.meme_id;

