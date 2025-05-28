package curtis.com.taichungtravel.navigation.tour

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import curtis.com.taichungtravel.data.DataTourStruct
import curtis.com.taichungtravel.data.DataTourist

import curtis.com.taichungtravel.databinding.AdapterTouristAttractionsBinding
import curtis.com.taichungtravel.navigation.tour.TourFragment.StaticFunction.OnAdapterClick

/**
 * [RecyclerView.Adapter] that can display a [DataTourStruct].
 * TODO: Replace the implementation with code for your data type.
 * set adapter on fragment
 */
class TourAdapter(
    private val values: MutableList<DataTourStruct>,
) : RecyclerView.Adapter<TourAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            AdapterTouristAttractionsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    interface InterfaceAdapterListener {
        fun OnAdapterItemClick(position: Int)
    }

    //set data to component
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        if(Setting.language == Setting.LANGUAGE_TW){
            holder.name.text = item.nameTW
            holder.contentView.text = item.contentTW
        }else{
            holder.name.text = item.nameEN
            holder.contentView.text = item.contentEN
        }

        holder.openHour.text = item.openingHour
        Picasso.get().load(item.photoLink).into(holder.imageView)
        //holder.imageView.setImageResource(item.photoLink);
    }

    override fun getItemCount(): Int = values.size

    //set initial id (findviewbyid)
    inner class ViewHolder(binding: AdapterTouristAttractionsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val name: TextView = binding.name
        val contentView: TextView = binding.content
        val openHour: TextView = binding.openHour
        val imageView: ImageView = binding.imageViewTourPicture

        init {
            binding.root.setOnClickListener {
                val adapterPosition = adapterPosition
                DataTourist.dataSelect = adapterPosition
                OnAdapterClick(adapterPosition)
                /*
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    (itemView.context as? InterfaceAdapterListener)?.OnAdapterItemClick(adapterPosition)
                    listener.OnAdapterItemClick(adapterPosition)
                    Log.d("binding.root","binding.root "+ adapterPosition )
                }*/
            }
        }


        /*
                override fun toString(): String {
                    return super.toString() + " '" + contentView.text + "'"
                }

         */
    }

}