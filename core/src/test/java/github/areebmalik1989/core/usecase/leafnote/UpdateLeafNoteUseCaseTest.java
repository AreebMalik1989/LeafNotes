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

public class UpdateLeafNoteUseCaseTest {

    LeafNote l1 = new LeafNote(new Identity(0), "T1", "D1");
    LeafNote l2 = new LeafNote(new Identity(1), "T2", "D2");

    List<LeafNote> leafNotes = new ArrayList<>();

    ILeafNoteRepository repository = mock(ILeafNoteRepository.class);

    @Before
    public void setUp() {
        leafNotes.add(l1);
        leafNotes.add(l2);
    }

    @Test
    public void shouldReturnIdIfSuccess() {

        when(repository.updateLeafNote(l1)).thenReturn(l1.getId());

        UpdateLeafNoteUseCase updateLeafNoteUseCase = new UpdateLeafNoteUseCase(repository);

        UpdateLeafNoteUseCase.InputValues input = new UpdateLeafNoteUseCase.InputValues(l1);
        UpdateLeafNoteUseCase.OutputValues output = updateLeafNoteUseCase.execute(input);

        verify(repository).updateLeafNote(l1);

        assertThat("Error updating note", output.getId(), is(l1.getId()));
    }

    @Test(expected = NotSavedException.class)
    public void shouldThrowNotSavedException() {

        when(repository.updateLeafNote(l1)).thenReturn(null);



        UpdateLeafNoteUseCase updateLeafNoteUseCase = new UpdateLeafNoteUseCase(repository);

        UpdateLeafNoteUseCase.InputValues input = new UpdateLeafNoteUseCase.InputValues(l1);
        updateLeafNoteUseCase.execute(input);
    }
}