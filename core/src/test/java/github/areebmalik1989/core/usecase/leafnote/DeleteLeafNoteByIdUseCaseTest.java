package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.domain.exception.NotDeleteException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DeleteLeafNoteByIdUseCaseTest {

    LeafNote l1 = new LeafNote(new Identity(0), "T1", "D1");
    LeafNote l2 = new LeafNote(new Identity(1), "T2", "D2");

    List<LeafNote> leafNotes = new ArrayList<>();

    ILeafNoteRepository repository = mock(ILeafNoteRepository.class);

    @Before
    public void setup() {
        leafNotes.add(l1);
        leafNotes.add(l2);
    }

    @Test
    public void shouldDeleteLeafNote() {

        when(repository.deleteLeafNote(new Identity(0)))
                .thenReturn(true);

        DeleteLeafNoteByIdUseCase deleteLeafNoteByIdUseCase = new DeleteLeafNoteByIdUseCase(repository);

        DeleteLeafNoteByIdUseCase.InputValues input = new DeleteLeafNoteByIdUseCase.InputValues(new Identity(0));
        DeleteLeafNoteByIdUseCase.OutputValues output = deleteLeafNoteByIdUseCase.execute(input);

        verify(repository).deleteLeafNote(new Identity(0));

        assertThat("Output should be true", output.isSuccess(), is(true));
    }

    @Test(expected = NotDeleteException.class)
    public void shouldThrowException() {

        when(repository.deleteLeafNote(new Identity(0)))
                .thenReturn(false);

        DeleteLeafNoteByIdUseCase deleteLeafNoteByIdUseCase = new DeleteLeafNoteByIdUseCase(repository);

        DeleteLeafNoteByIdUseCase.InputValues input = new DeleteLeafNoteByIdUseCase.InputValues(new Identity(0));
        deleteLeafNoteByIdUseCase.execute(input);

    }
}