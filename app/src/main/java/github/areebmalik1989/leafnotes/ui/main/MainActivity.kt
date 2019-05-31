package github.areebmalik1989.leafnotes.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import github.areebmalik1989.leafnotes.R
import github.areebmalik1989.leafnotes.ui.BaseActivity
import github.areebmalik1989.leafnotes.ui.note.NoteActivity

class MainActivity : BaseActivity() {

    private lateinit var presenter : MainContract.Presenter
    private lateinit var fragment : MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = MainPresenter(fragment)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId) {
            R.id.new_note -> {
                val intent = Intent(this@MainActivity, NoteActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @LayoutRes
    override fun contentViewLayoutRes(): Int {
        return R.layout.activity_main
    }

    @NonNull
    override fun createInitialFragment(): Fragment {
        fragment = MainFragment.getInstance()
        return fragment
    }

}
