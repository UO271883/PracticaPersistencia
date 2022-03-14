package es.imovil.practicapersistencia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import es.imovil.practicapersistencia.databinding.ItemViewBinding

class Adapter: ListAdapter<Book, ViewHolder>(Book.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //OPCION 1: RECIBIR DEL ADAPTADOR LA VISTA CREADA
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_view, parent, false )
        return ViewHolder(view)

        //OPCION 2: RECIBIR LA CLASE VINCULADA DESDE EL ADAPTADOR
        /*val itemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemViewBinding)*/
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
