package github.areebmalik1989.leafnotes.ui.note

import github.areebmalik1989.core.domain.IdGenerator
import github.areebmalik1989.core.domain.Identity
import github.areebmalik1989.core.domain.LeafNote
import github.areebmalik1989.core.usecase.leafnote.SaveLeafNoteUseCase
import github.areebmalik1989.leafnotes.data.repository.LeafNoteRepository
import github.areebmalik1989.leafnotes.presenter.usecase.UseCaseExecutor

class NotePresenter(val view : NoteContract.View,
                    val id : Identity) : NoteContract.Presenter {

    lateinit var leafNoteRepository : LeafNoteRepository
    lateinit var saveLeafNoteUseCase : SaveLeafNoteUseCase
    lateinit var useCaseExecutor : UseCaseExecutor
    var note = LeafNote()

    init {
        view.setPresenter(this)
    }

    override fun start() {
        leafNoteRepository = LeafNoteRepository()
        saveLeafNoteUseCase = SaveLeafNoteUseCase(leafNoteRepository)
        useCaseExecutor = UseCaseExecutor()
    }

    override fun saveNote() {

        if(view.getTitleText().equals(null)||view.getTitleText().equals("")) {
            view.showWarning("Empty title not allowed")
            return
        } else {
            note.title = view.getTitleText()
        }

        if(view.getBodyText().equals(null)||view.getBodyText().equals("")) {
            note.description = ""
        } else {
            note.description = view.getBodyText()
        }

        if(id.id == -1L) {
            note.id = Identity(IdGenerator.generate())
        } else {
            note.id = id
        }

        var input = SaveLeafNoteUseCase.InputValues(note)

        useCaseExecutor.executeAsync(saveLeafNoteUseCase, input,
            UseCaseExecutor.Callback<SaveLeafNoteUseCase.OutputValues> {

            view.showSuccess("Saved " + it.id.id)
        })
    }

}