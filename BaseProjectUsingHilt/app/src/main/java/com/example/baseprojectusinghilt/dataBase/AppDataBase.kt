package com.example.baseprojectusinghilt.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.baseprojectusinghilt.dataBase.Entity.DemoData

@Database(entities = [DemoData::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getDataBaseDoa() : DataBaseDOA

}