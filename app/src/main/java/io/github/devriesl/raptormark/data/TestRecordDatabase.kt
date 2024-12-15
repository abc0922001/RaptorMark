package io.github.devriesl.raptormark.data

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import io.github.devriesl.raptormark.Converters

@Database(entities = [TestRecord::class], version = 4, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TestRecordDatabase : RoomDatabase() {
    abstract fun testRecordDao(): TestRecordDao

    companion object {
        @Volatile
        private var INSTANCE: TestRecordDatabase? = null
        private const val DB_NAME = "AppHistoryDb"

        private val MIGRATION_2_4 = object : Migration(2, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM test_records")
            }
        }

        private val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM test_records")
            }
        }

        fun getInstance(context: Context): TestRecordDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context, TestRecordDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_2_4)
                .addMigrations(MIGRATION_3_4)
                .build().also { INSTANCE = it }
        }
    }
}
