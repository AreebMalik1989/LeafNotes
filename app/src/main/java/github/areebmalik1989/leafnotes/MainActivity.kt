package github.areebmalik1989.leafnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import github.areebmalik1989.core.domain.Identity
import github.areebmalik1989.core.domain.LeafNote
import github.areebmalik1989.leafnotes.presenter.entities.LeafNoteResponse

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
