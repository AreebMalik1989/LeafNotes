package github.areebmalik1989.leafnotes.ui.note

import androidx.appcompat.app.AppCompatActivity
import github.areebmalik1989.core.domain.IdGenerator
import github.areebmalik1989.core.domain.Identity
import github.areebmalik1989.core.domain.LeafNote
import github.areebmalik1989.core.usecase.leafnote.DeleteLeafNoteByIdUseCase
import github.areebmalik1989.core.usecase.leafnote.SaveLeafNoteUseCase
import github.areebmalik1989.leafnotes.data.repository.LeafNoteRepository
import github.areebmalik1989.leafnotes.presenter.usecase.UseCaseExecutor

class NotePresenter(val activity: AppCompatActivity,
                    val view : NoteContract.View,
                    val id : Identity) : NoteContract.Presenter {

    lateinit var leafNoteRepository : LeafNoteRepository
    lateinit var saveLeafNoteUseCase : SaveLeafNoteUseCase
    lateinit var deleteLeafNoteByIdUseCase: DeleteLeafNoteByIdUseCase
    lateinit var useCaseExecutor : UseCaseExecutor
    var note = LeafNote()

    init {
        view.setPresenter(this)
        note.id = id
    }

    override fun start() {
        leafNoteRepository = LeafNoteRepository()
        saveLeafNoteUseCase = SaveLeafNoteUseCase(leafNoteRepository)
        deleteLeafNoteByIdUseCase = DeleteLeafNoteByIdUseCase(leafNoteRepository)
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

        useCaseExecutor.execute(saveLeafNoteUseCase, input,
            UseCaseExecutor.Callback<SaveLeafNoteUseCase.OutputValues> {

            view.showSuccess("""Saved ${it.id.id}""")
        })
    }

    override fun deleteNote() {

        if(note.id.id == -1L) {
            view.showSuccess("Deleted")
            activity.finish()
            return
        }

        val input = DeleteLeafNoteByIdUseCase.InputValues(note.id)

        useCaseExecutor.execute(deleteLeafNoteByIdUseCase, input,
            UseCaseExecutor.Callback<DeleteLeafNoteByIdUseCase.OutputValues> {
                if(it.isSuccess) {
                    view.showSuccess("Deleted ${note.id.id}")
                } else {
                    view.showWarning("Error deleting ${note.id.id}")
                }
            })

        activity.finish()
    }

}