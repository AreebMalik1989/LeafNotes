package github.areebmalik1989.leafnotes.ui.note

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import github.areebmalik1989.core.domain.Identity
import github.areebmalik1989.leafnotes.R
import github.areebmalik1989.leafnotes.ui.BaseActivity

class NoteActivity : BaseActivity() {

    lateinit var presenter : NoteContract.Presenter
    lateinit var fragment : NoteFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle(R.string.edit_note)

        val id = intent.getLongExtra(NoteConstants.idKey, -1L)

        presenter = NotePresenter(fragment, Identity(id))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_note, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId) {
            R.id.save_note -> {
                presenter.saveNote()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun contentViewLayoutRes(): Int {
        return R.layout.activity_note
    }

    override fun createInitialFragment(): Fragment {
        fragment = NoteFragment.getInstance()
        return fragment
    }
}
