package github.areebmalik1989.leafnotes.ui.main

import github.areebmalik1989.leafnotes.ui.BasePresenter
import github.areebmalik1989.leafnotes.ui.BaseView

class MainContract {

    interface View : BaseView<Presenter> {
        fun setRecyclerView(adapter: NoteAdapter)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter : BasePresenter {
        fun loadNotes()
        fun openNote(position: Int)
    }
}