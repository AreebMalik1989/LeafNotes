package github.areebmalik1989.leafnotes.ui.main

import github.areebmalik1989.leafnotes.R
import github.areebmalik1989.leafnotes.ui.BaseFragment

class MainFragment : BaseFragment(), MainContract.View {

    private lateinit var presenter : MainContract.Presenter

    companion object {

        fun getInstance() : MainFragment {
            return MainFragment()
        }
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_main
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }
}