package es.imovil.practicapersistencia

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class BookViewModel (application: Application) : AndroidViewModel(application){

    var bookList = mutableListOf<Book>()

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
}