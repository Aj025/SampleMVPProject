package sample.project.sampleproject.presentation.adpater

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import sample.project.sampleproject.R
import sample.project.sampleproject.databinding.RecyclerSampleItemBinding
import sample.project.sampleproject.model.SampleData
import sample.project.sampleproject.util.parseDate

class SampleDataAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SampleData>() {

        override fun areItemsTheSame(oldItem: SampleData, newItem: SampleData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SampleData, newItem: SampleData): Boolean {
            return oldItem.status == newItem.status && oldItem.amount == newItem.amount
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerSampleItemBinding.inflate(
            inflater,
            parent,
            false
        )
        return SampleViewHolder(
            binding,
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SampleViewHolder -> {
                holder.bind(differ.currentList[position], getPrevItem(position))
            }
        }
    }

    private fun getPrevItem(currentPosition: Int) : SampleData?{
        if (currentPosition < itemCount  && itemCount > 1 && currentPosition > 0)
            return differ.currentList[currentPosition -1]

        return null

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<SampleData>) {
        differ.submitList(list)
    }

    class SampleViewHolder(
        private val binding: RecyclerSampleItemBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {

        private val dateText = binding.tvDate
        private val icon = binding.imgIcon
        private val statusText = binding.tvStatus
        private val amountText = binding.tvAmount

        fun bind(item: SampleData, prevItem: SampleData?)  {
            binding.container.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            val formattedDate = item.date.parseDate()
            dateText.text = formattedDate
            Glide.with(itemView)
                .load(item.iconUrl)
                .error(R.drawable.ic_baseline_error_24)
                .into(icon)
            statusText.text = item.status
            amountText.text = item.amount.toString()
            if (prevItem == null)
                dateText.visibility = View.VISIBLE
            else {
                val prevFormattedDate = prevItem.date.parseDate()
                if (prevItem.date == item.date || prevFormattedDate == formattedDate)
                    dateText.visibility = View.GONE
                else
                    dateText.visibility = View.VISIBLE
            }

        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: SampleData)
    }
}

