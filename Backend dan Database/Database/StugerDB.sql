CREATE DATABASE StugerDB
GO
USE StugerDB

CREATE TABLE MsUser(
	UserID INT PRIMARY KEY IDENTITY(1,1),
	UserName VARCHAR(255),
	UserEmail VARCHAR(255),
	UserPhone VARCHAR(15),
	UserDOB DATE,
	UserPassword VARCHAR(10)
)

CREATE TABLE TrMappingJurusan(
	MappingID INT PRIMARY KEY IDENTITY(1,1),
	UserID INT FOREIGN KEY REFERENCES MsUser(UserID),
	JurusanID CHAR(5) FOREIGN KEY REFERENCES MsJurusan(JurusanID)
)

CREATE TABLE MsJurusan(
	JurusanID CHAR(5) PRIMARY KEY NOT NULL,
	JurusanName VARCHAR(255),
)

CREATE TABLE MsMataPelajaran(
	MaPelID CHAR(6) PRIMARY KEY NOT NULL,
	MaPelName VARCHAR(255),
	JurusanID CHAR(5) FOREIGN KEY REFERENCES MsJurusan(JurusanID)
)

CREATE TABLE MsBab(
	BabID CHAR(6) PRIMARY KEY NOT NULL,
	BabName VARCHAR(255),
	MaPelID CHAR(6) FOREIGN KEY REFERENCES MsMataPelajaran(MaPelID)
)

CREATE TABLE TrQuiz(
	QuizID INT PRIMARY KEY IDENTITY(1,1),
	SoalQuiz VARCHAR(999),
	WrongAnswer1 VARCHAR(255),
	WrongAnswer2 VARCHAR(255),
	WrongAnswer3 VARCHAR(255),
	CorrectAnswer VARCHAR(255),
	BabID CHAR(6) FOREIGN KEY REFERENCES MsBab(BabID)
)

CREATE TABLE TrQuizResult(
	ResultID INT PRIMARY KEY IDENTITY(1,1),
	BabID CHAR(6) FOREIGN KEY REFERENCES MsBab(BabID),
	UserID INT FOREIGN KEY REFERENCES MsUser(UserID),
	Score INT
)

CREATE TABLE TrForumGeneral(
	ForumID INT PRIMARY KEY IDENTITY(1,1),
	ForumDescription VARCHAR(255),
	MaPelID CHAR(6) FOREIGN KEY REFERENCES MsMataPelajaran(MaPelID),
	MappingID INT FOREIGN KEY REFERENCES TrMappingJurusan(MappingID)
)

CREATE TABLE TrForumReply(
	ForumReplyID INT PRIMARY KEY IDENTITY(1,1),
	ForumReplyDesc VARCHAR(255),
	UserID INT FOREIGN KEY REFERENCES MsUser(UserID),
	UpVote INT,
	DownVote INT,
	ForumScore INT,
	GeneralForumID INT FOREIGN KEY REFERENCES TrForumGeneral(ForumID)
)

CREATE TABLE TrScore(
	ScoreID INT PRIMARY KEY IDENTITY(1,1),
	UserID INT FOREIGN KEY REFERENCES MsUser(UserID),
	ForumScore INT NOT NULL,
	QuizScore INT NOT NULL,
	TotalScore INT NOT NULL
)

CREATE TABLE TrAchievement(
	AchievementName VARCHAR(255),
	ScoreID INT FOREIGN KEY REFERENCES TrScore(ScoreID),
	Score INT
)

SELECT * FROM MsUser
SELECT * FROM TrMappingJurusan
SELECT * FROM MsJurusan
SELECT * FROM MsMataPelajaran
SELECT * FROM MsBab
SELECT * FROM TrQuiz
SELECT * FROM TrQuizResult
SELECT * FROM TrForumGeneral
SELECT * FROM TrForumReply
SELECT * FROM TrScore
SELECT * FROM TrAchievement

INSERT INTO TrScore (UserID, ForumScore, QuizScore, TotalScore) VALUES (7, 0, 0, 0)

INSERT INTO MsBab (BabID, BabName, MaPelID)
VALUES
('BIO001', 'Bab 1', 'IPA001'),
('BIO002', 'Bab 2', 'IPA001'),
('BIO003', 'Bab 3', 'IPA001'),
('FIS001', 'Bab 1', 'IPA002'),
('FIS002', 'Bab 2', 'IPA002'),
('FIS003', 'Bab 3', 'IPA002'),
('KIM001', 'Bab 1', 'IPA003'),
('KIM002', 'Bab 2', 'IPA003'),
('KIM003', 'Bab 3', 'IPA003'),
('MAT001', 'Bab 1', 'IPA004'),
('MAT002', 'Bab 2', 'IPA004'),
('MAT003', 'Bab 3', 'IPA004'),
('EKO001', 'Bab 1', 'IPS001'),
('EKO002', 'Bab 2', 'IPS001'),
('EKO003', 'Bab 3', 'IPS001'),
('GEO001', 'Bab 1', 'IPS002'),
('GEO002', 'Bab 2', 'IPS002'),
('GEO003', 'Bab 3', 'IPS002'),
('PKN001', 'Bab 1', 'IPS003'),
('PKN002', 'Bab 2', 'IPS003'),
('PKN003', 'Bab 3', 'IPS003'),
('SOS001', 'Bab 1', 'IPS004'),
('SOS002', 'Bab 2', 'IPS004'),
('SOS003', 'Bab 3', 'IPS004')

INSERT INTO TrForumGeneral (ForumDescription, MaPelID, MappingID)
VALUES
('Kenapa -1 tidak bisa di akar?', 'IPA004', '1'),
('Kenapa tumbuhan memerlukan sinar matahari', 'IPA001', '3'),
('Apa yang dimaksud dengan keseimbangan pasar?', 'IPS001', '4')

INSERT INTO MsUser (UserName, UserEmail, UserPhone, UserDOB, UserPassword)
VALUES
('Anthony GT', 'anthonygt124@gmail.com', '085771455959', '2000-11-07', 'admin'),
('Wryancartie', 'cartot1@gmail.com', '082897327387', '1999-01-31', 'kruyoso'),
('Felix', 'felix21@gmail.com', '087662812156', '1999-07-31', 'admin1')

INSERT INTO TrQuiz (SoalQuiz, WrongAnswer1, WrongAnswer2, WrongAnswer3, CorrectAnswer, BabID)
VALUES
('Berapakah nilai dari 1 + 1 ?', '3', '4', '1', '2', 'MAT001'),
('Berapakah nilai kuadrat dari 26?', '400', '576', '766', '676', 'MAT001'),
('Berapa banyak rusuk, sisi dan sudut dari sebuah kubus?', '14 6 10', '12 8 6', '16 5 10', '12 6 8', 'MAT002')

--DROP TABLE MsUser
--DROP TABLE TrMappingJurusan
--DROP TABLE MsJurusan
--DROP TABLE MsMataPelajaran
--DROP TABLE MsBab
--DROP TABLE TrQuiz
--DROP TABLE TrQuizResult
--DROP TABLE TrForumGeneral
--DROP TABLE TrForumReply
--DROP TABLE TrScore
--DROP TABLE TrAchievement

--To make User Key
CREATE FUNCTION makeUserKey (@UserID INT)
RETURNS CHAR(7)
AS
BEGIN
	RETURN 'USR' + RIGHT('00' + CONVERT(VARCHAR(10), @UserID), 3)
END

--Counting how many users in database
CREATE FUNCTION countUsers()
RETURNS INT
AS
BEGIN
	DECLARE @idx INT
	SET @idx = (SELECT COUNT(*) FROM MsUser)
	RETURN @idx
END

--Check if the user is already exist
ALTER PROCEDURE sp_CheckUser
	@UserName VARCHAR(255),
	@UserEmail VARCHAR(255)
AS
BEGIN
	SET NOCOUNT ON;

	SELECT UserName
	FROM MsUser
	WHERE UserName = @UserName OR UserEmail = @UserEmail
END

EXEC sp_CheckUser '', 'anthonygt124@gmail.com' 

--Create new user
ALTER PROCEDURE sp_NewUser
	@UserName VARCHAR(255),
	@UserEmail VARCHAR(255),
	@UserPhone VARCHAR(15),
	@UserDOB DATE,
	@UserPassword VARCHAR(10)
AS
BEGIN
	SET NOCOUNT ON;

	INSERT INTO MsUser (UserName, UserEmail, UserPhone, UserDOB, UserPassword)
	VALUES
	(@UserName, @UserEmail, @UserPhone, @UserDOB, @UserPassword);

	INSERT INTO TrMappingJurusan (JurusanID, UserID)
	VALUES
	('JR001', dbo.countUsers()),
	('JR002', dbo.countUsers())

	INSERT INTO TrScore (UserID, ForumScore, QuizScore, TotalScore) VALUES
	(dbo.countUsers(), 0, 0, 0)

END

EXEC sp_NewUser 'Anthony GT', 'anthonygt124@gmail.com', '085771455959', '20001107', 'admin'
DROP PROCEDURE sp_LoginUser
 
--Check User
CREATE PROCEDURE sp_LoginUser
	@UserEmail VARCHAR(255),
	@UserPassword CHAR(10)
AS
BEGIN
	SET NOCOUNT ON;

	SELECT 
		UserName
	FROM MsUser
	WHERE UserEmail = @UserEmail AND UserPassword = @UserPassword
END

EXEC sp_LoginUser 'anthonygt124@gmail.com', 'admin'

--Get Quiz from one Bab
ALTER PROCEDURE sp_getQuiz
	@BabName VARCHAR(255),
	@MaPelName VARCHAR(255)
AS
BEGIN
	SET NOCOUNT ON;

	SELECT 
		QuizID,
		SoalQuiz,
		WrongAnswer1,
		WrongAnswer2,
		WrongAnswer3,
		CorrectAnswer
	FROM TrQuiz
	WHERE BabID LIKE(
		SELECT BabID
		FROM MsBab
		WHERE BabName = @BabName AND MaPelID LIKE(
			SELECT MaPelID
			FROM MsMataPelajaran
			WHERE MaPelName = @MaPelName
		)
	)
END

EXEC sp_getQuiz 'Bab 1', 'Matematika'

--send quiz result
ALTER PROCEDURE sp_sendQuizResult
	@BabName VARCHAR(255),
	@MaPelName VARCHAR(255),
	@UserID INT,
	@Score INT
AS
BEGIN
	SET NOCOUNT ON;

	DECLARE @BabID CHAR(6);
	SET @BabID = (
		SELECT BabID FROM MsBab 
		WHERE BabName = @BabName AND MaPelID LIKE(
			SELECT MaPelID
			FROM MsMataPelajaran
			WHERE MaPelName = @MaPelName
		));

	INSERT INTO TrQuizResult VALUES
	(@BabID, @UserID, @Score)

END

EXEC sp_sendQuizResult 'Bab 1', 'Matematika', '5', '2400'

--Get forum general
ALTER PROCEDURE sp_getForumThread
AS
BEGIN
	SET NOCOUNT ON;

	SELECT
		ForumID,
		UserName AS [ForumThreadMaker],
		ForumDescription
	FROM TrForumGeneral FG
	JOIN TrMappingJurusan MJ ON FG.MappingID = MJ.MappingID
	JOIN MsUser MU ON MU.UserID = MJ.UserID
END

EXEC sp_getForumThread

--Create new forum thread
CREATE PROCEDURE sp_NewForumThread
	@ThreadMaker VARCHAR(255),
	@ForumDescription VARCHAR(999),
	@JurusanName VARCHAR(255),
	@MaPelName VARCHAR(255)
AS
BEGIN
	SET NOCOUNT ON;

	DECLARE @MaPelID CHAR(6), @MappingID INT, @JurusanID CHAR(5), @UserID INT;
	SET @MaPelID = (SELECT MaPelID FROM MsMataPelajaran WHERE @MaPelName = MaPelName);
	SET @JurusanID = (SELECT JurusanID FROM MsJurusan WHERE @JurusanName = JurusanName);
	SET @UserID = (SELECT UserID FROM MsUser WHERE @ThreadMaker = UserName);
	SET @MappingID = (SELECT MappingID FROM TrMappingJurusan WHERE @JurusanID = JurusanID AND @UserID = UserID);

	INSERT INTO TrForumGeneral (ForumDescription, MaPelID, MappingID)
	VALUES (@ForumDescription, @MaPelID, @MappingID);
END

EXEC sp_NewForumThread 'Wryancartie', 'Apa yang menyebabkan gunung berapi meletus?', 'IPS', 'Geografi'

--Update forum reply
CREATE PROCEDURE sp_updateForumReply
AS
BEGIN
	SET NOCOUNT ON;

	UPDATE TrForumReply
	SET ForumScore = UpVote - DownVote;
END

--Get Forum Reply
ALTER PROCEDURE sp_getForumReply
	@ForumID INT
AS
BEGIN
	SET NOCOUNT ON;

	EXEC sp_updateForumReply;

	SELECT 
		ForumReplyID,
		UserName AS [ReplyMaker],
		ForumReplyDesc,
		ForumScore
	FROM TrForumReply JOIN MsUser ON TrForumReply.UserID = MsUser.UserID
	WHERE @ForumID = GeneralForumID 
END

EXEC sp_getForumReply 2

--Insert new reply
ALTER PROCEDURE sp_newForumReply
	@ReplyMaker VARCHAR(255),
	@ForumReplyDesc VARCHAR(999),
	@ForumID INT
AS
BEGIN
	SET NOCOUNT ON;

	DECLARE @UserID INT;
	SET @UserID = (SELECT UserID FROM MsUser WHERE @ReplyMaker = UserName);

	INSERT INTO TrForumReply (ForumReplyDesc, UserID, UpVote, DownVote, ForumScore, GeneralForumID)
	VALUES (@ForumReplyDesc, @UserID, 0, 0, 0, @ForumID)
END

SELECT * FROM TrForumGeneral
--Anthony GT, Felix, Kevin T, Raymond W
EXEC sp_newForumReply 'Raymond W', 'Karena Indonesia merupakan negara yang mempunyai keanekaragaman suku dan budaya', '6'

--function to count user forum score
ALTER FUNCTION countForumScore(@UserID INT)
RETURNS INT
AS
BEGIN
	DECLARE @ForumScore INT;
	SET @ForumScore = (
		SELECT 
			CASE WHEN SUM(ForumScore) IS NULL
			THEN 0
			ELSE SUM(ForumScore) END
		FROM TrForumReply
		WHERE UserID = @UserID
	);

	RETURN @ForumScore;
END

--function to count user quiz score
ALTER FUNCTION countQuizScore(@UserID INT)
RETURNS INT
AS
BEGIN
	DECLARE @QuizScore INT;
	SET @QuizScore = (
		SELECT
			CASE WHEN SUM(Score) IS NULL
			THEN 0
			ELSE SUM(Score) END
		FROM TrQuizResult
		WHERE UserID = @UserID
	);
	RETURN @QuizScore;
END

--Update score table
ALTER PROCEDURE sp_updateScoreTable
AS
BEGIN
	SET NOCOUNT ON;

	EXEC sp_updateForumReply;

	UPDATE TrScore
	SET ForumScore = dbo.countForumScore(UserID), QuizScore = dbo.countQuizScore(UserID);

	UPDATE TrScore
	SET TotalScore = ForumScore + QuizScore;

END

EXEC sp_updateScoreTable

--Leaderboard spot
ALTER PROCEDURE sp_getAchievement
AS
BEGIN
	SET NOCOUNT ON;

	DELETE TrAchievement;
	EXEC sp_updateScoreTable;
	INSERT INTO TrAchievement (ScoreID, Score)
	SELECT TOP 6
		ScoreID,
		TotalScore
	FROM TrScore
	ORDER BY TotalScore DESC;

	SELECT
		UserName,
		AchievementName,
		TA.Score
	FROM TrAchievement TA JOIN TrScore TS ON TA.ScoreID = TS.ScoreID
	JOIN MsUser MU ON TS.UserID = MU.UserID;

END

EXEC sp_getAchievement