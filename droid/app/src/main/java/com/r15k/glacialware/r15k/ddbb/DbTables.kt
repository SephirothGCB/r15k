package com.r15k.glacialware.r15k.ddbb

/**
 * Created by Tanuki on 04/07/2017.
 */

// MISSIONS
val DB_MISSION_TABLE_NAME : String = "mission"
val DB_MISSION_COLUMN_ID : String = "id"
val DB_MISSION_COLUMN_TITLE : String = "title"
val DB_MISSION_COLUMN_DESCRIPTION : String = "description"
val DB_MISSION_COLUMN_IMAGE : String = "image"
val DB_MISSION_COLUMN_COMPLETED : String = "completed"
val DB_MISSION_COLUMN_ID_PLAYER : String = "id_player"

val DB_CREATE_MISSION : String = "CREATE TABLE " + DB_MISSION_TABLE_NAME + " (" +
        DB_MISSION_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
        DB_MISSION_COLUMN_TITLE + " TEXT," +
        DB_MISSION_COLUMN_DESCRIPTION + " TEXT," +
        DB_MISSION_COLUMN_IMAGE + " TEXT," +
        DB_MISSION_COLUMN_ID_PLAYER + " INTEGER," +
        DB_MISSION_COLUMN_COMPLETED + " NUMERIC)"

val DB_DELETE_MISSION : String = "DROP TABLE IF EXISTS " + DB_MISSION_TABLE_NAME




// PLAYER
val DB_PLAYER_TABLE_NAME : String = "player"
val DB_PLAYER_COLUMN_ID : String = "id"
val DB_PLAYER_COLUMN_NICK : String = "nick"
val DB_PLAYER_COLUMN_IS_DEAD : String = "is_dead"

val DB_CREATE_PLAYER : String = "CREATE TABLE " + DB_PLAYER_TABLE_NAME + " (" +
        DB_PLAYER_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
        DB_PLAYER_COLUMN_NICK + " TEXT," +
        DB_PLAYER_COLUMN_IS_DEAD + " NUMERIC)"

val DB_DELETE_PLAYER : String = "DROP TABLE IF EXISTS " + DB_PLAYER_TABLE_NAME
