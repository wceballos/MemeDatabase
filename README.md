# MemeDatabase
SER322 Project for Meme Database

# To run
* use the attached MakeFile. If you wish to use your own server, modify the "jdbc:mysql://149.28.33.123:3306/memes?autoReconnect=true&useSSL=false" to point to another SQL server.

# Using this program
* If you decide not to use the MakeFile, the main program requires 4 arguments to use. (String url, String username, String password, String driver)

* After entering, you will be asked to login. If you know your username, you can use your information to login. Otherwise, you will be forced to create an account.
* Once in, a new menu will appear:
  *  1. Search for meme by title
  *  2. Search for meme by category
  *  3. Add a meme to favorite
  *  4. View list of favorite memes
  *  5. View a meme
  *  6. Add a new meme
  *  7. Delete a meme
  *  q. Exit Meme Database
* Press any of the selections to move forward for your various queries.
* When done, select 'q' to quit, you will automatically logged out.

# Folder structure
* resources
  * holds information about the database
  * .sql file
* memes
  * holds memes
  * memes will be titled by their meme id
      **example: 1.png
* src
  * holds the raw java files
* classes
  * holds the compiled classes
* archiveCode
  * holds code that has been decided not to use, but may wanna keep in the back pocket
