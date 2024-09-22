package com.example.listatarefas.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context, NOME_BANCO_DADOS, null, 1
) {
    companion object{
        const val NOME_BANCO_DADOS = "ListaTarefas.db"
        const val VERSION = 1
        const val NOME_TABELA_TAREFAS = "tarefas"
        const val  COLUNA_ID_TAREFA = "id_tarefa"
        const val COLUNA_DESCRICAO = "descricao"
        const val COLUNA_DATA_CADASTRO = "data_cadastro"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE IF NOT EXISTS $NOME_TABELA_TAREFAS(" +
                "$COLUNA_ID_TAREFA INTEGER not NULL PRIMARY KEY AUTOINCREMENT," +
                "$COLUNA_DESCRICAO VARCHAR(70)," +
                "$COLUNA_DATA_CADASTRO DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP" +
                ");"
        try {
            db?.execSQL(sql)
            Log.i("INFO_DB", "Sucesso ao criar a tabela")
        } catch (e: Exception){
            Log.i("INFO_DB", "Erro ao criar a tabela")

        }

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}