package com.example.note_to_self

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONTokener
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStreamReader
import java.io.Writer
import kotlin.jvm.Throws

class JSONSerializer(private val filename: String, private val context: Context) {

    @Throws(IOException::class, JSONException::class)
    fun save(notes: List<Note>){
        val jArray = JSONArray()

        for(n in notes){
            jArray.put(n.convertToJSON())
        }

        var writer: Writer? = null
        try {
            val out = context.openFileOutput(filename, Context.MODE_PRIVATE)
            writer = out.writer()
            writer.write(jArray.toString())
        }finally {
            if(writer != null){
                writer.close()
            }
        }
    }

    @Throws(IOException::class, JSONException::class)
    fun load(): ArrayList<Note>{
        val noteList = ArrayList<Note>()
        var reader: BufferedReader? = null

        try{
            val `in` = context.openFileInput(filename)
            reader = BufferedReader(InputStreamReader(`in`))
            val jsonString = StringBuilder()

           for(line in reader.readLine()){
               jsonString.append(line)
           }

            val jArray = JSONTokener(jsonString.toString()).nextValue() as JSONArray

            for(i in 0 until jArray.length()){
                noteList.add(Note(jArray.getJSONObject(i)))
            }

        }catch (e: FileNotFoundException){
            //will add later

        }finally {
            reader!!.close()
        }

        return noteList
    }

}