build:
	javac src/MemeDatabase/*.java -d classes/

run:
	java -cp lib/mysql-connector-java-8.0.23.jar:classes MemeDatabase.MemeDatabase "jdbc:mysql://149.28.33.123:3306/memes?autoReconnect=true&useSSL=false" ser322 **** com.mysql.cj.jdbc.Driver
