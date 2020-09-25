package com.example.felix.stuger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTableLockedException;
import android.support.annotation.Nullable;

import java.sql.SQLInput;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Database Version
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "StugerDB";

    //Database Table Name
    public static final String TABLE_MS_USER = "msUser";
    public static final String TABLE_MS_JURUSAN = "msJurusan";
    public static final String TABLE_MS_MATA_PELAJARAN = "msMataPelajaran";
    public static final String TABLE_MS_BAB =  "msBab";
    public static final String TABLE_MS_STAFF = "msStaff";

    public static final String TABLE_TR_FORUM_REPLY = "trForumReply";
    public static final String TABLE_TR_SCORE = "trScore";
    public static final String TABLE_TR_ACHIEVEMENT = "trAchievement";
    public static final String TABLE_TR_QUIZ = "trQu9iz";
    public static final String TABLE_TR_FORUM_GENERAL = "trForumGeneral";

    public static final String TABLE_DETAIL_UPDATE_QUIZ = "DetailUpdatQuiz";
    public static final String TABLE_DETAIL_UPDATE_BAB = "DetailUpdateBab";

    //Table msUser Column Name
    public static final String USER_ID = "UserID";
    public static final String USER_NAME = "UserName";
    public static final String USER_EMAIL = "UserEmail";
    public static final String USER_PHONE = "UserPhone";
    public static final String USER_DOB = "UserDOB";
    public static final String USER_PASSWORD = "UserPassword";

    //Table msJurusan Column Name
    public static final String JURUSAN_ID = "JurusanID";
    public static final String JURUSAN_NAME = "JurusanName";
    public static final String MS_USER_USER_ID = "UserUserID";

    //Table msMataPelajaran Column Name
    public static final String MAPEL_ID = "MaPelID";
    public static final String MAPEL_NAME = "MaPelName";
    public static final String MS_JURUSAN_JURUSAN_ID = "ms_JurusanJurusanID";

    //Table msBab Column Name
    public static final String BAB_ID = "BabID";
    public static final String BAB_NAME = "BabName";
    public static final String MS_MATA_PELAJARAN_MAPEL_ID = "ms_Mata_PelajaranMapelID";

    //Table msStaff Column Name
    public static final String STAFF_ID = "StaffID";
    public static final String STAFF_NAME = "StaffName";
    public static final String STAFF_EMAIL = "StaffEmail";
    public static final String STAFF_PHONE = "StaffPhone";
    public static final String STAFF_DOB = "StaffDOB";

    //Table trForumReply Column Name
    public static final String FORUM_REPLY_ID = "ForumReplyID";
    public static final String FORUM_REPLY_DESC = "ForumReplyDesc";
    public static final String UPVOTE = "Upvote";
    public static final String DOWNVOTE = "Downvote";
    public static final String FORUM_SCORE = "ForumScore";
    public static final String TR_FORUM_GENERAL_FORUM_ID = "tr_Forum_GeneralForumID";

    //Table trScore Column Name
    public static final String SCORE_ID = "ScoreID";
    public static final String TOTAL_SCORE = "TotalScore";
//    public static final String MS_USER_USER_ID = "ms_UserUserID";
    public static final String TR_QUIZ_QUIZ_ID = "tr_QuizQuizID";
    public static final String TR_FORUM_REPLY_FORUM_REPLY_ID = "tr_Forum_ReplyForumReplyID";

    //Table trAchievement Column Name
    public static final String ACHIEVEMENT_ID = "AchievementID";
    public static final String ACHIEVEMENT_NAME = "AchievementName";
    public static final String TR_SCORE_SCORE_ID = "tr_ScoreScoreID";
//    public static final String MS_USER_USER_ID = "ms_UserUserID";

    //Table trQuiz Column Name
    public static final String QUIZ_ID = "QuizID";
    public static final String QUIZ_NAME = "QuizName";
    public static final String SOAL_QUIZ = "SoalQuiz";
    public static final String QUIZ_SCORE = "QuizScore";
    public static final String MS_BABBABID = "ms_BabBabID";

    //Table trForumGeneral Column Name
    public static final String FORUM_ID = "ForumID";
    public static final String FORUM_THREAD = "ForumThread";
    public static final String FORUM_DESCRIPTION = "ForumDescription";
//    public static final String MS_BAB_BABID = "ms_BabBabID";
//    public static final String MS_MATA_PELAJARANMAPELID = "ms_Mata_PelajaranMapelID";

    //Table DetailUpdateQuiz Column Name
    public static final String UPDATE_QUIZ_DATE = "UpdateQuizDate";
    public static final String MS_STAFF_STAFF_ID = "ms_StaffStaffID";
//    public static final String TR_QUIZ_QUIZ_ID = "tr_QuizQuizID";

    //Table DetailUpdateBab Column Name
    public static final String UPDATE_BAB_DATE = "UpdateBabDate";
//    public static final String MS_STAFFSTAFFID = "ms_StaffStaffID";
//    public static final String MS_BABBABID = "ms_BabBabID";


    //Table Create Statements
    //Table msUser Create Statements
    public static final String CREATE_TABLE_MS_USER ="CREATE TABLE " + TABLE_MS_USER + "(" + USER_ID + " CHAR(10) PRIMARY KEY," + USER_NAME + " VARCHAR(255)," + USER_EMAIL + " VARCHAR(255)," + USER_PHONE + " VARCHAR(15)," + USER_DOB + " DATE," + USER_PASSWORD + " VARCHAR(20)" + ")";

    //Table msJurusan Create Statements
    public static final String CREATE_TABLE_MS_JURUSAN = "CREATE TABLE " + TABLE_MS_JURUSAN + "(" + JURUSAN_ID + " VARCHAR(10) PRIMARY KEY," + JURUSAN_NAME + " VARCHAR(255)," + MS_USER_USER_ID + " VARCHAR(10)" + ")";

    //Table msMataPelajaran Create Statements
    public static final String CREATE_TABLE_MS_MATA_PELAJARAN = "CREATE TABLE " + TABLE_MS_MATA_PELAJARAN + "(" + MAPEL_ID + " VARCHAR(10) PRIMARY KEY," + MAPEL_NAME + " VARCHAR(255)," + MS_JURUSAN_JURUSAN_ID + " VARCHAR(10)" + ")";

    //Table msBab Create Statements
    public static final String CREATE_TABLE_MS_BAB = "CREATE TABLE " + TABLE_MS_BAB + "(" + BAB_ID + " VARCHAR(10) PRIMARY KEY," + BAB_NAME + " VARCHAR(255), " + MS_MATA_PELAJARAN_MAPEL_ID + " VARCHAR(10)" + ")";

    //Table msStaff Create Stetements
    public static final String CREATE_TABLE_MS_STAFF = "CREATE TABLE " + TABLE_MS_STAFF + "(" + STAFF_ID + " VARCHAR(10) PRIMARY KEY," + STAFF_NAME + " VARCHAR(255)," + STAFF_EMAIL + " VARCHAR(255)," + STAFF_PHONE + " VARCHAR(15)," + STAFF_DOB + " DATE" + ")";

    //Table trForumReply Create Statements
    public static final String CREATE_TABLE_TR_FORUM_REPLY = "CREATE TABLE " + TABLE_TR_FORUM_REPLY + "(" + FORUM_REPLY_ID + " VARCHAR(10) PRIMARY KEY," + FORUM_REPLY_DESC + " VARCHAR(255)," + UPVOTE + " INTEGER," + DOWNVOTE + " INTEGER," + FORUM_SCORE + " INTEGER," + TR_FORUM_GENERAL_FORUM_ID + " VARCHAR(10)" + ")";

    //Table trScore Create Statements
    public static final String CREATE_TABLE_TR_SCORE = "CREATE TABLE " + TABLE_TR_SCORE + "(" + SCORE_ID + " VARCHAR(10) PRIMARY KEY," + TOTAL_SCORE + " INTEGER," + MS_USER_USER_ID + " VARCHAR(10)," + TR_QUIZ_QUIZ_ID + " VARCHAR(10), " + TR_FORUM_REPLY_FORUM_REPLY_ID + " VARCHAR(10)" + ")";

    //Table trAchievement Create Statements
    public static final String CREATE_TABLE_TR_ACHIEVEMENT = "CREATE TABLE " + TABLE_TR_ACHIEVEMENT + "(" + ACHIEVEMENT_ID + " VARCHAR(10) PRIMARY KEY, " + ACHIEVEMENT_NAME + " VARCHAR(255), " + TR_SCORE_SCORE_ID + " VARCHAR(10), " + MS_USER_USER_ID + " VARCHAR(10)" + ")";

    //Table trQuiz Create Statements
    public static final String CREATE_TABLE_TR_QUIZ = "CREATE TABLE " + TABLE_TR_QUIZ + "(" + QUIZ_ID + " VARCHAR(10) PRIMARY KEY, " + QUIZ_NAME + " VARCHAR(255), " + SOAL_QUIZ + " TEXT," + QUIZ_SCORE + " INTEGER," + MS_BABBABID + " VARCHAR(10)" + ")";

    //Table trForumGeneral Create Statements
    public static final String CREATE_TABLE_TR_FORUM_GENERAL = "CREATE TABLE " + TABLE_TR_FORUM_GENERAL + "(" + FORUM_ID + " VARCHAR(10) PRIMARY KEY, " + FORUM_THREAD + " VARCHAR(255), " + FORUM_DESCRIPTION + " TEXT, " + MS_BABBABID + " VARCHAR(10), " + MS_MATA_PELAJARAN_MAPEL_ID + " VARCHAR(10)" + ")";

    //Table DetailUpdateQuiz Create Statements
    public static final String CREATE_TABLE_DETAIL_UPDATE_QUIZ = "CREATE TABLE " + TABLE_DETAIL_UPDATE_QUIZ + "(" + UPDATE_QUIZ_DATE + " DATE," + MS_STAFF_STAFF_ID + " VARCHAR(10), " + TR_QUIZ_QUIZ_ID + " VARCHAR(10)" + ")";

    //Table DetailUpdateBab Create Statements
    public static final String CREATE_TABLE_DETAIL_UPDATE_BAB = "CREATE TABLE " + TABLE_DETAIL_UPDATE_BAB + "(" + UPDATE_BAB_DATE + " DATE," + MS_STAFF_STAFF_ID + " VARCHAR(10), " + MS_BABBABID + " VARCHAR(10)" + ")";


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_MS_USER);
        sqLiteDatabase.execSQL(CREATE_TABLE_MS_JURUSAN);
        sqLiteDatabase.execSQL(CREATE_TABLE_MS_MATA_PELAJARAN);
        sqLiteDatabase.execSQL(CREATE_TABLE_MS_BAB);
        sqLiteDatabase.execSQL(CREATE_TABLE_MS_STAFF);

        sqLiteDatabase.execSQL(CREATE_TABLE_TR_FORUM_REPLY);
        sqLiteDatabase.execSQL(CREATE_TABLE_TR_SCORE);
        sqLiteDatabase.execSQL(CREATE_TABLE_TR_ACHIEVEMENT);
        sqLiteDatabase.execSQL(CREATE_TABLE_TR_QUIZ);
        sqLiteDatabase.execSQL(CREATE_TABLE_TR_FORUM_GENERAL);

        sqLiteDatabase.execSQL(CREATE_TABLE_DETAIL_UPDATE_QUIZ);
        sqLiteDatabase.execSQL(CREATE_TABLE_DETAIL_UPDATE_BAB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MS_USER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MS_JURUSAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MS_MATA_PELAJARAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MS_BAB);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MS_STAFF);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TR_FORUM_REPLY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TR_SCORE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TR_ACHIEVEMENT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TR_QUIZ);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TR_FORUM_GENERAL);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DETAIL_UPDATE_QUIZ);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DETAIL_UPDATE_BAB);

        onCreate(sqLiteDatabase);

    }
}
