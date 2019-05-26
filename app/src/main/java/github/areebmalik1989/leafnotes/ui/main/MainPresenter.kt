package github.areebmalik1989.leafnotes.ui.main

import github.areebmalik1989.core.domain.Identity
import github.areebmalik1989.core.domain.LeafNote
import github.areebmalik1989.core.usecase.leafnote.SaveLeafNoteUseCase
import github.areebmalik1989.leafnotes.data.repository.LeafNoteRepository
import github.areebmalik1989.leafnotes.presenter.usecase.UseCaseExecutor

class MainPresenter(view: MainContract.View) : MainContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val repository = LeafNoteRepository()
    val savePresenterUseCase = SaveLeafNoteUseCase(repository)

    fun test() {

        val saveExecutor = UseCaseExecutor()
        val note = LeafNote(Identity(1), "title", "desc")
        val input = SaveLeafNoteUseCase.InputValues(note)
        saveExecutor.executeAsync(savePresenterUseCase, input, UseCaseExecutor.Callback<SaveLeafNoteUseCase.OutputValues> {
            val id : Long = it.id.id
        })
    }
}