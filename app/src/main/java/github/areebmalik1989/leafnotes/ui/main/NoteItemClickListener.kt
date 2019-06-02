package github.areebmalik1989.leafnotes.ui.main

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class NoteItemClickListener(context: Context?, val listener: OnItemClickListener) : RecyclerView.OnItemTouchListener {

    public interface OnItemClickListener {
        public fun onItemClick(view: View, position: Int)
    }

    lateinit var mGestureDetector : GestureDetector

    init {
        mGestureDetector = GestureDetector(
            context,
            object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent?): Boolean {
                    return true
                }
            }
        )
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {

        val childView = rv.findChildViewUnder(e.x, e.y)

        if(childView!=null && listener != null && mGestureDetector.onTouchEvent(e)) {
            listener.onItemClick(childView, rv.getChildAdapterPosition(childView))
            return true
        }

        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}