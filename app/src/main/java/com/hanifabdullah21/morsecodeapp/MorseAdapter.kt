package com.hanifabdullah21.morsecodeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hanifabdullah21.morsecodeapp.databinding.ItemMorseBinding

//TODO 6. Buat dan atur Kelas Adapter untuk dapat menampilkan RecyclerView

/**
 * Adapter pada RecyclerView berfungsi sebagai “dapur”,
 * dimana pada adapter data-data diatur dan dipasangkan pada tampilan yang sudah disiapkan
 * sehingga RecyclerView sudah siap untuk ditampilkan.
 *
 * @param list data yang akan ditampilkan pada RecyclerView nanti
 * @param listener sebuah kelas interface bantuan yang berisi fungsi untuk melakukan aksi
 *
 * */
class MorseAdapter(val list: ArrayList<MorseModel>, val listener: MorseListener) :
    RecyclerView.Adapter<MorseAdapter.ViewHolder>() {

    /**
     *  Kelas ViewHolder ini berfungsi untuk menangkap/membungkus tampilan
     *
     *  @param binding 'bungkusan' tampilan yang sudah diatur pada fungsi onCreateViewHolder
     */
    class ViewHolder(val binding: ItemMorseBinding) : RecyclerView.ViewHolder(binding.root)

    //Sebuah fungsi untuk "menempelkan" itemview ke dalam recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_morse, parent, false)
        return ViewHolder(ItemMorseBinding.bind(view))
    }

    //Sebuah fungsi untuk memasang data pada tampilan2 yang ada pada itemview
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imTvName.text = list.get(position).name
        holder.binding.imTvCode.text = list.get(position).code

        //Memberikan aksi pada gambar "play" agar dapat mengeluarkan suara jika ditekan
        holder.binding.imIvPlay.setOnClickListener {
            listener.onPlayClicked(list.get(position))
        }
    }

    //Sebuah fungsi untuk mengatur jumlah item yang akan dipasang pada recyclerview
    override fun getItemCount(): Int {
        return list.size
    }

    //Sebuah kelas interface bantuan untuk mengatur aksi pada tampilan di 'ItemView'
    interface MorseListener {
        fun onPlayClicked(morseModel: MorseModel)
    }


}