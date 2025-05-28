package curtis.com.taichungtravel.navigation.flower

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import curtis.com.taichungtravel.data.DataFlowerStruct
import curtis.com.taichungtravel.data.DataTourStruct

import curtis.com.taichungtravel.databinding.AdapterFlowerBinding
import curtis.com.taichungtravel.navigation.tour.Setting
import curtis.com.taichungtravel.navigation.tour.TourFragment.StaticFunction.OnAdapterClick

/**
 * [RecyclerView.Adapter] that can display a [DataFlowerStruct].
 */
class FlowerAdapter(
    private val values: MutableList<DataFlowerStruct>,
) : RecyclerView.Adapter<FlowerAdapter.ViewHolder>() {

    //var locationTemp = values[0].location
    //var sizeTemp = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            AdapterFlowerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    interface InterfaceAdapterListener {
        fun OnAdapterItemClick(position: Int)
    }

    //interface setting
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        //set text to adapter
        holder.location.text = item.location
        holder.flower.text = item.flowerType + " : " + item.peakSeason
        holder.address.text = item.address
/*
        if(sizeTemp == position){
            holder.location.text = item.location
            holder.flower.text = item.flowerType + " : " + item.peakSeason
            holder.address.text = item.address
            sizeTemp++
            while(item.location == values[sizeTemp].location){
                Log.d("Flower Adapter","while " + item.location + " values[sizeTemp].location " + values[sizeTemp].location + " position " + sizeTemp)
                sizeTemp++
            }
        }else{
            sizeTemp++
        }
        */


    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: AdapterFlowerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val location: TextView = binding.location
        val flower: TextView = binding.flower
        val address: TextView = binding.address
        //val imageView: ImageView = binding.imageViewTourPicture

    }

}