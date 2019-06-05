package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.domain.exception.NotSavedException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SaveLeafNoteUseCaseTest {

    LeafNote l1 = new LeafNote(new Identity(0), "T1", "D1");
    LeafNote l2 = new LeafNote(new Identity(1), "T2", "D2");
    LeafNote l3 = new LeafNote(new Identity(2), "T2", "D2");

    List<LeafNote> leafNotes = new ArrayList<>();

    ILeafNoteRepository repository = mock(ILeafNoteRepository.class);

    @Before
    public void setUp() {
        leafNotes.add(l1);
        leafNotes.add(l2);
    }

    @Test
    public void shouldSaveLeafNote() {

        when(repository.saveLeafNote(l3)).thenReturn(l3.getId());

        SaveLeafNoteUseCase saveLeafNoteUseCase = new SaveLeafNoteUseCase(repository);

        SaveLeafNoteUseCase.InputValues input = new SaveLeafNoteUseCase.InputValues(l3);
        SaveLeafNoteUseCase.OutputValues output = saveLeafNoteUseCase.execute(input);

        verify(repository).saveLeafNote(l3);

        assertThat("Error saving leafnote", output.getId(), is(l3.getId()));
    }

    @Test(expected = NotSavedException.class)
    public void shouldThrowNotSavedException() {

        when(repository.saveLeafNote(l3)).thenReturn(null);

        SaveLeafNoteUseCase saveLeafNoteUseCase = new SaveLeafNoteUseCase(repository);

        SaveLeafNoteUseCase.InputValues input = new SaveLeafNoteUseCase.InputValues(l3);
        saveLeafNoteUseCase.execute(input);
    }
}