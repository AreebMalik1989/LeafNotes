package github.areebmalik1989.leafnotes.ui.note

import androidx.appcompat.app.AppCompatActivity
import github.areebmalik1989.core.domain.IdGenerator
import github.areebmalik1989.core.domain.Identity
import github.areebmalik1989.core.domain.LeafNote
import github.areebmalik1989.core.usecase.leafnote.DeleteLeafNoteByIdUseCase
import github.areebmalik1989.core.usecase.leafnote.GetLeafNoteByIdUseCase
import github.areebmalik1989.core.usecase.leafnote.SaveLeafNoteUseCase
import github.areebmalik1989.core.usecase.leafnote.UpdateLeafNoteUseCase
import github.areebmalik1989.leafnotes.data.repository.LeafNoteRepository
import github.areebmalik1989.leafnotes.presenter.usecase.UseCaseExecutor

class NotePresenter(val activity: AppCompatActivity,
                    val view : NoteContract.View,
                    val id : Identity) : NoteContract.Presenter {

    lateinit var leafNoteRepository : LeafNoteRepository
    lateinit var saveLeafNoteUseCase : SaveLeafNoteUseCase
    lateinit var updateLeafNoteUseCase : UpdateLeafNoteUseCase
    lateinit var deleteLeafNoteByIdUseCase: DeleteLeafNoteByIdUseCase
    lateinit var getLeafNoteByIdUseCase: GetLeafNoteByIdUseCase
    lateinit var useCaseExecutor : UseCaseExecutor
    var note = LeafNote()

    init {
        view.setPresenter(this)
        note.id = id
    }

    override fun start() {
        leafNoteRepository = LeafNoteRepository(activity)
        saveLeafNoteUseCase = SaveLeafNoteUseCase(leafNoteRepository)
        updateLeafNoteUseCase = UpdateLeafNoteUseCase(leafNoteRepository)
        deleteLeafNoteByIdUseCase = DeleteLeafNoteByIdUseCase(leafNoteRepository)
        getLeafNoteByIdUseCase = GetLeafNoteByIdUseCase(leafNoteRepository)
        useCaseExecutor = UseCaseExecutor()

        if(note.id.id != -1L) {
            showNote(note.id)
        }
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

            var input = SaveLeafNoteUseCase.InputValues(note)

            useCaseExecutor.execute(saveLeafNoteUseCase, input,
                UseCaseExecutor.Callback<SaveLeafNoteUseCase.OutputValues> {
                    note.id = it.id
                    view.showSuccess("Saved")
                })

        } else {

            var input = UpdateLeafNoteUseCase.InputValues(note)

            useCaseExecutor.execute(updateLeafNoteUseCase, input,
                object : UseCaseExecutor.Callback<UpdateLeafNoteUseCase.OutputValues> {
                    override fun onComplete(response: UpdateLeafNoteUseCase.OutputValues?) {
                        view.showSuccess("Updated")
                    }

                })
        }
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
                    view.showSuccess("Deleted")
                } else {
                    view.showWarning("Error Deleting Note")
                }
            })

        activity.finish()
    }

    override fun showNote(identity: Identity) {

        val input = GetLeafNoteByIdUseCase.InputValues(identity)
        useCaseExecutor.execute(getLeafNoteByIdUseCase, input, object : UseCaseExecutor.Callback<GetLeafNoteByIdUseCase.OutputValues> {
            override fun onComplete(response: GetLeafNoteByIdUseCase.OutputValues?) {
                val output = response!!.leafNote
                view.setTitleText(output.title)
                view.setBodytext(output.description)
            }
        })
    }

}