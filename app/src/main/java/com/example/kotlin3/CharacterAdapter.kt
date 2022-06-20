package com.example.kotlin3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin3.databinding.ItemCharacterBinding
import kotlin.reflect.KFunction0

class CharacterAdapter(
    private val data:ArrayList<Character>,
    private val onLongItemClick:(pos: Int)-> Unit
   ): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder((ItemCharacterBinding.inflate(LayoutInflater.from(parent.context)
            , parent , false)))
    }
    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(data[position])

        holder.itemView.setOnLongClickListener{
            onLongItemClick(position)
            true
        }

    }
    fun removeItem(pos:Int){
        data.removeAt(pos)
        notifyItemRemoved(pos)
        notifyItemRangeChanged(pos,data.size)
    }

    inner class CharacterViewHolder(val binding: ItemCharacterBinding):
        RecyclerView.ViewHolder(binding.root){
            fun  bind (character:Character) {
                binding.name.text = character.name
                binding.image.loadImage(character.image.toString())
            }

    }

}