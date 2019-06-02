package github.areebmalik1989.leafnotes.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import github.areebmalik1989.leafnotes.R
import github.areebmalik1989.leafnotes.ui.BaseFragment

class MainFragment : BaseFragment(), MainContract.View {

    private lateinit var presenter : MainContract.Presenter

    private lateinit var recyclerView : RecyclerView
    private lateinit var progressBar : ProgressBar

    companion object {

        fun getInstance() : MainFragment {
            return MainFragment()
        }
    }

    override fun onResume() {
        super.onResume()

        presenter.loadNotes()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        recyclerView = view!!.findViewById(R.id.rv_notes)
        progressBar = view.findViewById(R.id.progress_bar)

        presenter.start()
        return view
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_main
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

    override fun setRecyclerView(adapter : NoteAdapter) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
        // rv_animal_list.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter

        recyclerView.addOnItemTouchListener(NoteItemClickListener(context, object : NoteItemClickListener.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                presenter.openNote(position)
            }
        }))
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }
}