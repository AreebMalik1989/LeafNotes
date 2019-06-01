package github.areebmalik1989.leafnotes.ui.main

class MainPresenter(view: MainContract.View) : MainContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun start() {
    }
}