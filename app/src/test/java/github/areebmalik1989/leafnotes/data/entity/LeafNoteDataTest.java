package github.areebmalik1989.leafnotes.data.entity;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LeafNoteDataTest {

    @Test
    public void conversionShouldBeCorrect() {

        LeafNote initialNote = new LeafNote(new Identity(0), "T", "D");
        LeafNoteData leafNoteData = LeafNoteData.from(initialNote);

        LeafNote noteFromData = leafNoteData.fromThis();

        assertThat("Notes should be equal", initialNote, is(noteFromData));
    }

}