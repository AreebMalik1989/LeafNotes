package github.areebmalik1989.leafnotes

import android.app.Application
import github.areebmalik1989.core.usecase.leafnote.GetAllLeafNotesUseCase
import github.areebmalik1989.core.usecase.leafnote.GetLeafNoteByIdUseCase
import github.areebmalik1989.core.usecase.leafnote.SaveLeafNoteUseCase
import github.areebmalik1989.core.usecase.leafnote.SearchLeafNotesByTitleUseCase
import github.areebmalik1989.leafnotes.data.repository.LeafNoteRepository
import github.areebmalik1989.leafnotes.presenter.config.Module
import github.areebmalik1989.leafnotes.presenter.controller.LeafNoteController
import github.areebmalik1989.leafnotes.presenter.usecase.UseCaseExecutor

class MainApp : Application() {

    companion object {

        private val useCaseExecutor : UseCaseExecutor = UseCaseExecutor()

        private val repository : LeafNoteRepository = LeafNoteRepository()

        private val getAllLeafNotesUseCase : GetAllLeafNotesUseCase = Module.getAllLeafNotesUseCase(repository)
        private val getLeafNoteByIdUseCase : GetLeafNoteByIdUseCase = Module.getLeafNoteByIdUseCase(repository)
        private val searchLeafNotesByTitleUseCase : SearchLeafNotesByTitleUseCase = Module.searchLeafNotesByTitleUseCase(
            repository
        )
        private val saveLeafNoteUseCase : SaveLeafNoteUseCase = Module.saveLeafNoteUseCase(repository)

        val leafNoteController : LeafNoteController = LeafNoteController(
            useCaseExecutor,
            getAllLeafNotesUseCase,
            searchLeafNotesByTitleUseCase,
            getLeafNoteByIdUseCase,
            saveLeafNoteUseCase
        )

    }
}