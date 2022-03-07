package es.imovil.practicapersistencia

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import es.imovil.practicapersistencia.databinding.ItemViewBinding

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //OPCION 1: RECIVIR DEL ADAPTADOR LA VISTA CREADA
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemViewBinding = ItemViewBinding.bind(itemView)

        fun bind(book: Book) {
            with(itemViewBinding) {
                author.text = book.author
                title.text  = book.title
                isbn.text   = book.isbn
                editor.text = book.editorial
                price.text  = book.price.toString()
            }
        }
    }

    //OPCION 2: RECIVIR LA CLASE VINCULADA DESDE EL ADAPTADOR
    /*class ViewHolder(val itemViewBinding: ItemViewBinding) : RecyclerView.ViewHolder(itemViewBinding.root) {

    }*/

}