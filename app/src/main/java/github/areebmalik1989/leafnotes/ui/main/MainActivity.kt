package github.areebmalik1989.leafnotes.ui.main

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import github.areebmalik1989.leafnotes.R
import github.areebmalik1989.leafnotes.ui.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var presenter : MainContract.Presenter
    private lateinit var fragment : MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = MainPresenter(fragment)
    }

    @LayoutRes
    override fun contentViewLayoutRes(): Int {
        return R.layout.activity_main;
    }

    @NonNull
    override fun createInitialFragment(): Fragment {
        fragment = MainFragment.getInstance()
        return fragment
    }

}
