package github.areebmalik1989.leafnotes.data.repository;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeafNoteRepositoryTest {

    LeafNoteRepository repository;
    LeafNote leafNote1;
    LeafNote leafNote2;

    @Before
    public void setUp(){

        repository = new LeafNoteRepository();

        leafNote1 = new LeafNote(new Identity(1), "Title1", "Des1");
        leafNote2 = new LeafNote(new Identity(2), "Title2", "Des2");

        repository.saveLeafNote(leafNote1);
        repository.saveLeafNote(leafNote2);
    }

    @Test
    public void getAll() {

        assertEquals("leafNote missing", repository.getAll().size(), 2);
    }

    @Test
    public void searchByTitle() {

        assertEquals("leafNote missing", repository.searchByTitle("Title1").get(0), leafNote1);

    }

    @Test
    public void getById() {

        assertEquals("leafNote missing", repository.getById(new Identity(1)).get(), leafNote1);
    }

    @Test
    public void saveLeafNote() {

    }
}