package com.example.baseprojectusinghilt.dataBase

import androidx.room.Dao

@Dao
interface DataBaseDOA {

 suspend fun insert()
}