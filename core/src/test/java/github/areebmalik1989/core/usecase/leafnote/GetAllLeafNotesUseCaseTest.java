package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.when;

public class GetAllLeafNotesUseCaseTest {

    @Test
    public void shouldGetAllLeafNotes() {

        List<LeafNote> expectedList = new ArrayList<>();
        expectedList.add(new LeafNote(new Identity(0), "T1", "D1"));
        expectedList.add(new LeafNote(new Identity(1), "T2", "D2"));

        ILeafNoteRepository repository = Mockito.mock(ILeafNoteRepository.class);
        when(repository.getAll()).thenReturn(expectedList);

        GetAllLeafNotesUseCase getAllLeafNotesUseCase = new GetAllLeafNotesUseCase(repository);

        GetAllLeafNotesUseCase.InputValues input = new GetAllLeafNotesUseCase.InputValues();
        GetAllLeafNotesUseCase.OutputValues output = getAllLeafNotesUseCase.execute(input);

        List<LeafNote> actualList = output.getLeafNotes();

        assertThat("Leaf notes missing", actualList, is(expectedList));
    }

}