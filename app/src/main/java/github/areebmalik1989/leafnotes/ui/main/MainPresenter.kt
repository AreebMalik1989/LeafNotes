package github.areebmalik1989.leafnotes.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import github.areebmalik1989.core.domain.LeafNote
import github.areebmalik1989.core.usecase.leafnote.GetAllLeafNotesUseCase
import github.areebmalik1989.leafnotes.data.repository.LeafNoteRepository
import github.areebmalik1989.leafnotes.presenter.usecase.UseCaseExecutor
import github.areebmalik1989.leafnotes.ui.note.NoteActivity
import github.areebmalik1989.leafnotes.ui.note.NoteConstants
import java.util.ArrayList

class MainPresenter(val activity: AppCompatActivity, val view: MainContract.View) : MainContract.Presenter {

    private lateinit var leafNoteRepository : LeafNoteRepository
    private lateinit var getAllLeafNotesUseCase: GetAllLeafNotesUseCase
    private lateinit var useCaseExecutor : UseCaseExecutor

    private lateinit var leafNotes : List<LeafNote>

    private lateinit var noteAdapter: NoteAdapter

    init {
        view.setPresenter(this)
    }

    override fun start() {
        loadNotes()
    }

    override fun loadNotes() {

        view.showProgress()

        leafNoteRepository = LeafNoteRepository(activity)
        getAllLeafNotesUseCase = GetAllLeafNotesUseCase(leafNoteRepository)
        useCaseExecutor = UseCaseExecutor()

        val input = GetAllLeafNotesUseCase.InputValues()
        val output = useCaseExecutor.execute(getAllLeafNotesUseCase, input)

        leafNotes = output.leafNotes

        noteAdapter = NoteAdapter(leafNotes as ArrayList<LeafNote>)
        view.setRecyclerView(noteAdapter)
        view.hideProgress()

    }

    override fun openNote(position: Int) {

        val note = leafNotes[position]
        val id = note.id.id

        val intent = Intent(activity, NoteActivity::class.java)
        intent.putExtra(NoteConstants.ID_KEY, id)

        activity.startActivity(intent)
    }
}