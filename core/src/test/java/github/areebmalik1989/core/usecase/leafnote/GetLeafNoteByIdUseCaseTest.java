package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.domain.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GetLeafNoteByIdUseCaseTest {

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
    public void shouldGetLeafNoteById() {

        when(repository.getById(new Identity(0))).thenReturn(l1);

        GetLeafNoteByIdUseCase getLeafNoteByIdUseCase = new GetLeafNoteByIdUseCase(repository);

        GetLeafNoteByIdUseCase.InputValues input = new GetLeafNoteByIdUseCase.InputValues(new Identity(0));
        GetLeafNoteByIdUseCase.OutputValues output = getLeafNoteByIdUseCase.execute(input);

        verify(repository).getById(new Identity(0));

        assertThat("Error in getting note",  output.getLeafNote(), is(l1));
    }

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundException() {

        when(repository.getById(new Identity(0))).thenReturn(null);

        GetLeafNoteByIdUseCase getLeafNoteByIdUseCase = new GetLeafNoteByIdUseCase(repository);

        GetLeafNoteByIdUseCase.InputValues input = new GetLeafNoteByIdUseCase.InputValues(new Identity(0));
        getLeafNoteByIdUseCase.execute(input);
    }
}