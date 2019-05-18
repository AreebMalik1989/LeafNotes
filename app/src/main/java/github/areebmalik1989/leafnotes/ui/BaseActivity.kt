package github.areebmalik1989.leafnotes.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import github.areebmalik1989.leafnotes.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentViewLayoutRes())
        setupInitialFragment(savedInstanceState)
    }

    private fun setupInitialFragment(savedInstanceState: Bundle?) {
        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, createInitialFragment())
                .commit()
        }
    }

    @LayoutRes
    protected abstract fun contentViewLayoutRes() : Int

    @NonNull
    protected abstract fun createInitialFragment() : Fragment
}