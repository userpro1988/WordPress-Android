package org.wordpress.android.ui.stats.refresh.lists.sections.insights.management

import android.support.v4.view.MotionEventCompat
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import org.wordpress.android.R
import org.wordpress.android.ui.stats.refresh.lists.sections.insights.management.InsightsManagementViewModel.InsightModel

class AddedInsightViewHolder(
    val parent: ViewGroup,
    private val onDragStarted: (viewHolder: ViewHolder) -> Unit,
    private val onButtonClicked: (InsightModel) -> Unit
) : InsightsManagementViewHolder(parent) {
    private val title: TextView = itemView.findViewById(R.id.itemTitle)
    private val managementButton: ImageButton = itemView.findViewById(R.id.insightsManagementItemButton)
    private val dragAndDropButton: View = itemView.findViewById(R.id.dragAndDropItemButton)

    override fun bind(insight: InsightModel) {
        title.setText(insight.name)

        managementButton.setImageResource(R.drawable.ic_remove_circle)
        managementButton.setOnClickListener {
            onButtonClicked(insight)
        }

        dragAndDropButton.setOnTouchListener { _, event ->
            if (MotionEventCompat.isFromSource(event, MotionEvent.ACTION_DOWN)) {
                onDragStarted(this)
            }
            return@setOnTouchListener true
        }
        dragAndDropButton.visibility = View.VISIBLE
    }
}
