package github.areebmalik1989.leafnotes.ui.about


import androidx.fragment.app.Fragment

import github.areebmalik1989.leafnotes.R
import github.areebmalik1989.leafnotes.ui.BaseFragment

/**
 * A simple [Fragment] subclass.
 *
 */
class AboutFragment : BaseFragment() {

    companion object {

        fun getInstance() : AboutFragment {
            return AboutFragment()
        }

    }

    override fun layoutRes(): Int {
        return R.layout.fragment_about
    }
}
