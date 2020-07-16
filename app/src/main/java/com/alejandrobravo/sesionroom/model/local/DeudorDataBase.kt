package com.alejandrobravo.sesionroom.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alejandrobravo.sesionroom.model.local.Deudor
import com.alejandrobravo.sesionroom.model.local.DeudorDAO

@Database(entities = arrayOf(Deudor::class), version = 1)
abstract  class DeudorDataBase : RoomDatabase() {
abstract fun DeudorDAO() : DeudorDAO

}