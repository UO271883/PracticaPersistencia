package es.imovil.practicapersistencia

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book(@PrimaryKey var title:String,
                var author:String,
                var isbn:String? = null,
                var editorial:String? = null,
                var price:Float) {

    object DIFF_CALLBACK: DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return  oldItem.author    == newItem.author    &&
                    oldItem.title     == newItem.title     &&
                    oldItem.isbn      == newItem.isbn      &&
                    oldItem.editorial == newItem.editorial &&
                    oldItem.price     == newItem.price
        }

    }
}
