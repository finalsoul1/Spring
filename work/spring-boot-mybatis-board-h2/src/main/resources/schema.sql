DROP TABLE IF EXISTS USER;

CREATE TABLE USER (
	EMAIL VARCHAR(100) NOT NULL PRIMARY KEY,
	PASSWORD VARCHAR(100) DEFAULT '1234'
);

DROP TABLE IF EXISTS BOARD;

CREATE TABLE BOARD (
	ID BIGINT IDENTITY NOT NULL PRIMARY KEY,
	WRITER VARCHAR(100) DEFAULT NULL,
	TITLE VARCHAR(255) DEFAULT NULL,
	CONTENT CLOB DEFAULT NULL,
	REG_DATE TIMESTAMP DEFAULT NULL,
	HIT_COUNT BIGINT DEFAULT 0
);
