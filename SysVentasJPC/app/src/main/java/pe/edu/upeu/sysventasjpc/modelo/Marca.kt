package pe.edu.upeu.sysventasjpc.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "marca")
data class Marca (
    @PrimaryKey
    @ColumnInfo(name = "id_marca")
    var idMarca: Long,
    var nombre: String
)

