package github.areebmalik1989.leafnotes.ui.note

import github.areebmalik1989.core.domain.Identity
import github.areebmalik1989.leafnotes.ui.BasePresenter
import github.areebmalik1989.leafnotes.ui.BaseView

class NoteContract {

    interface View : BaseView<Presenter> {
        fun getTitleText() : String
        fun setTitleText(titleText : String)
        fun getBodyText() : String
        fun setBodytext(bodyText : String)
        fun showWarning(warning : String)
        fun showSuccess(success : String)
    }

    interface Presenter : BasePresenter {
        fun saveNote()
        fun deleteNote()
        fun showNote(identity: Identity)
    }
}