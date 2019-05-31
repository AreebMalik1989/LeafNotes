package github.areebmalik1989.leafnotes.ui.note

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import github.areebmalik1989.leafnotes.R
import github.areebmalik1989.leafnotes.ui.BaseFragment

class NoteFragment : BaseFragment(), NoteContract.View{

    private lateinit var presenter : NoteContract.Presenter
    private val handler = Handler()

    private lateinit var title : EditText
    private lateinit var body : EditText
    private var noteId : Long = -1

    companion object {

        fun getInstance() : NoteFragment {
            return NoteFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        title = view!!.findViewById(R.id.note_title)
        body = view.findViewById(R.id.note_body)

        presenter.start()

        return view
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_note
    }

    override fun setPresenter(presenter: NoteContract.Presenter) {
        this.presenter = presenter
    }

    override fun getNoteId(): Long {
        return noteId
    }

    override fun setNoteId(noteId: Long) {
        this.noteId = noteId
    }

    override fun getTitleText() : String {
        return title.text.toString()
    }

    override fun setTitleText(titleText: String) {
        title.setText(titleText)
    }

    override fun getBodyText() : String {
        return body.text.toString()
    }

    override fun setBodytext(bodyText: String) {
        body.setText(bodyText)
    }

    override fun showWarning(warning : String) {
        handler.post({Toast.makeText(activity!!.applicationContext, warning, Toast.LENGTH_SHORT).show()})
    }

    override fun showSuccess(success: String) {
        handler.post({Toast.makeText(activity!!.applicationContext, success, Toast.LENGTH_SHORT).show()})
    }
}
