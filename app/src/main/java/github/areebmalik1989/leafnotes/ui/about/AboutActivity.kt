package github.areebmalik1989.leafnotes.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import github.areebmalik1989.leafnotes.R
import github.areebmalik1989.leafnotes.ui.BaseActivity

class AboutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle(R.string.info)
    }

    override fun contentViewLayoutRes(): Int {
        return R.layout.activity_about
    }

    override fun createInitialFragment(): Fragment {
        return AboutFragment.getInstance()
    }
}
