package org.example.project

import java.sql.Connection
import java.sql.DriverManager

class DataBase{
    lateinit var connection: Connection

    constructor(){
        val host = "localhost"
        val port = 5432
        val dataBase = "postgres"
        val url = "jdbc:postgresql://$host:$port/$dataBase"

        val user = "postgres"
        val password = "1111"
        try{
            connection = DriverManager.getConnection(url, user, password)
            println("successful connection")
        }
        catch (e: Exception){
            println("connection problem")
            println(e.message)
        }
    }
    fun create(){
        val creating = """
            CREATE TABLE moi_bank(
                Name varchar(30), 
                Login varchar(30), 
                Password varchar(30)
            )
            """.trimIndent()
        try{
            connection.createStatement().use {
                it.execute(creating)
            }
            println("table created")
        }
        catch(e: Exception){
            println("creating error")
            println(e.message)
        }
    }
    fun insert(name: String, login: String, password: String){
        val inserting = """
                INSERT INTO moi_bank(Name, Login, Password)
                VALUES (?, ?, ?)
            """
        try{
            connection.prepareStatement(inserting).use {
                it.setString(1, name)
                it.setString(2, login)
                it.setString(3, password)
                it.execute()
            }
            println("user added")
        }
        catch (e: Exception){
            println("inserting error")
            println(e.message)
        }
    }
    fun select(login: String, password: String){
        val selection = """
                SELECT Login, Password FROM moi_bank
                WHERE Login = ? AND Password = ?;
            """.trimIndent()
        try{
            connection.prepareStatement(selection).use {
                it.setString(1, login)
                it.setString(2, password)
                it.executeQuery().use { itRes ->
                    if(itRes.next()){
                        println(itRes.getString(1))
                        println(itRes.getString(2))
                    }
                }
            }
        }
        catch(e: Exception){
            println("insertion error")
            println(e.message)
        }
    }
    fun drop(){
        val dropping= """
            DROP TABLE moi_bank;
        """.trimIndent()
        try{
            connection.createStatement().use {
                it.execute(dropping)
            }
        }
        catch(e: Exception){
            println("creating error")
            println(e.message)
        }
    }

}