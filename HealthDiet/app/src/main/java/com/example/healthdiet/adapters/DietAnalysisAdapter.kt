package com.example.healthdiet.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healthdiet.R
import com.example.healthdiet.models.DietAnalysisResult
import com.google.android.material.card.MaterialCardView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class DietAnalysisAdapter(
    private var results: List<DietAnalysisResult> = emptyList(),
    private val onItemSelected: (DietAnalysisResult) -> Unit
) : RecyclerView.Adapter<DietAnalysisAdapter.ViewHolder>() {

    private var selectedPosition = -1

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: MaterialCardView = itemView.findViewById(R.id.card_analysis_result)
        private val foodName: TextView = itemView.findViewById(R.id.text_food_name)
        private val accuracy: TextView = itemView.findViewById(R.id.text_accuracy)
        private val calories: TextView = itemView.findViewById(R.id.text_calories)
        private val chipGroupNutrients: ChipGroup = itemView.findViewById(R.id.chip_group_nutrients)
        private val chipProtein: Chip = itemView.findViewById(R.id.chip_protein)
        private val chipCarbs: Chip = itemView.findViewById(R.id.chip_carbs)
        private val chipFat: Chip = itemView.findViewById(R.id.chip_fat)

        fun bind(result: DietAnalysisResult, position: Int) {
            foodName.text = result.foodName
            accuracy.text = "${(result.accuracy * 100).toInt()}% accuracy"
            calories.text = "${result.calories}\nkcal"

            // Update nutrient chips
            chipProtein.text = "Protein: ${result.nutritionInfo.protein}g"
            chipCarbs.text = "Carbs: ${result.nutritionInfo.carbs}g"
            chipFat.text = "Fat: ${result.nutritionInfo.fat}g"

            cardView.isChecked = position == selectedPosition
            
            itemView.setOnClickListener {
                val previousPosition = selectedPosition
                selectedPosition = position
                notifyItemChanged(previousPosition)
                notifyItemChanged(selectedPosition)
                onItemSelected(result)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_diet_analysis_new, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(results[position], position)
    }

    override fun getItemCount() = results.size

    fun updateResults(newResults: List<DietAnalysisResult>) {
        results = newResults
        selectedPosition = -1
        notifyDataSetChanged()
    }
}
