package com.dimsun.android.roomz.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @Entity
 * C'est une table dans la base de donnée.
 * Chaque Entity doit être ensuite referencée dans la classe @Database
 */
@Entity(tableName ="contact_table")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var uid: Int,
    @ColumnInfo(name = "firstname")
    var firstname: String?,
    @ColumnInfo(name = "lastname")
    var lastname: String?,
    @ColumnInfo(name = "number")
    var number: String?,
    @ColumnInfo(name = "email")
    var email: String?)