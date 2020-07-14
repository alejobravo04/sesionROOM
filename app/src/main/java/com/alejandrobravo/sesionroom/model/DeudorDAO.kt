package com.alejandrobravo.sesionroom.model

import androidx.room.*

@Dao

interface DeudorDAO {
    @Insert
    fun crearDeudor(deudor: Deudor)

    @Query("SELECT * FROM tabla_deudor WHERE nombre LIKE :nombre")
    fun buscarDeudor(nombre: String) : Deudor

    @Update
    fun actualizarDeudor(Deudor: Deudor)

    @Delete
    fun borrarDeudor(Deudor: Deudor)

}