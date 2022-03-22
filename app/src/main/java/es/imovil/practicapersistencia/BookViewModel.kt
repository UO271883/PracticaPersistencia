package es.imovil.practicapersistencia

import android.app.Application
import android.provider.Telephony.Mms.Part.FILENAME
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class BookViewModel (application: Application) : AndroidViewModel(application){

    val app = application
    var bookList = mutableListOf<Book>()
    lateinit var archivename: String

    fun getListSize(): Int{
        return bookList.size
    }

    fun getBook(position: Int): Book{
        return bookList[position]
    }

    fun addBook(book: Book): Boolean{
        val libro = Book(book.title, book.author, book.isbn, book.editorial, book.price)
        return bookList.add(libro)
    }

    fun restoreBookList(){
        System.out.println("Archivename en ext: " + app.getExternalFilesDir(null).toString())
        System.out.println("Archivename en int: " + app.filesDir)
        val folder = app.getExternalFilesDir(null)
        val file: File = File(folder, FILENAME)
        //val file = File(app.filesDir, FILENAME)
        var lista: List<Book>
        //System.out.println("fuera del if restoreBookList")
        if (file.exists()) {
            //System.out.println("dentro del if")
            System.out.print("Filename joder" + file.toString())
            val contenido = file.readText()
            val listType = object : TypeToken<List<Book>>() {}.type
            lista = Gson().fromJson(contenido, listType)
            bookList.addAll(lista)
        }
    }

    fun saveBookList(){
        //val file = File(app.filesDir, FILENAME)
        val folder = app.getExternalFilesDir(null)
        val file: File = File(folder, FILENAME)
        //System.out.println("fuera del if saveBookList")
        //System.out.println("====================== Libro 1 ======================" + bookList[0].title)
        System.out.println("Filename joder" + file.toString())
        var cadena: String = Gson().toJson(bookList)
        file.writeText(cadena)
    }
}