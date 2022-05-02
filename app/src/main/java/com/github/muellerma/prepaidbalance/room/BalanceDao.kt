package com.github.muellerma.prepaidbalance.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BalanceDao {
    @Query("SELECT * FROM BalanceEntry ORDER BY timestamp DESC")
    fun getAll(): List<BalanceEntry>

    @Insert
    fun insert(balance: BalanceEntry)

    @Delete
    fun delete(balance: BalanceEntry)

    @Query("DELETE FROM BalanceEntry")
    fun deleteAll()

    @Query("SELECT * FROM BalanceEntry ORDER BY timestamp DESC LIMIT 1")
    fun getLatest(): BalanceEntry?

    @Query("DELETE FROM BalanceEntry WHERE timestamp < :before")
    fun deleteBefore(before: Long)

    @Query("SELECT * FROM BalanceEntry WHERE timestamp > :since ")
    fun getSince(since: Long): List<BalanceEntry>
}
