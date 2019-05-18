package github.areebmalik1989.leafnotes.data.repository;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeafNoteRepositoryTest {

    private static LeafNoteRepository repository;
    private static LeafNote leafNote1;
    private static LeafNote leafNote2;

    @BeforeClass
    public static void setUp(){

        repository = new LeafNoteRepository();

        leafNote1 = new LeafNote(new Identity(1), "Title1", "Des1");
        leafNote2 = new LeafNote(new Identity(2), "Title2", "Des2");

        repository.saveLeafNote(leafNote1);
        repository.saveLeafNote(leafNote2);
    }

    @Test
    public void testGetAll() {

        assertEquals("leafNote missing",2 , repository.getAll().size());
    }

    @Test
    public void testSearchByTitle() {

        assertEquals("leafNote missing", repository.searchByTitle("Title1").get(0), leafNote1);

    }

    @Test
    public void testGetById() {

        assertEquals("leafNote missing", repository.getById(new Identity(1)), leafNote1);
    }

    @Test
    public void testSaveLeafNote() {

    }
}