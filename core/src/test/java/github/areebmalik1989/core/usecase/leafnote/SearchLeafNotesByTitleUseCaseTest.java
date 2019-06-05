package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class SearchLeafNotesByTitleUseCaseTest {

    LeafNote l1 = new LeafNote(new Identity(0), "T1", "D1");
    LeafNote l2 = new LeafNote(new Identity(1), "T2", "D2");
    LeafNote l3 = new LeafNote(new Identity(2), "T2", "D2");

    List<LeafNote> leafNotes = new ArrayList<>();

    ILeafNoteRepository repository = mock(ILeafNoteRepository.class);

    @Before
    public void setUp() {
        leafNotes.add(l1);
        leafNotes.add(l2);
        leafNotes.add(l3);
    }

    @Test
    public void repositoryShouldSearchLeafNotes() {

        List<LeafNote> result = new ArrayList<>();
        result.add(l2);
        result.add(l3);

        when(repository.searchByTitle(l2.getTitle())).thenReturn(result);

        SearchLeafNotesByTitleUseCase searchLeafNotesByTitleUseCase = new SearchLeafNotesByTitleUseCase(repository);

        SearchLeafNotesByTitleUseCase.InputValues input = new SearchLeafNotesByTitleUseCase.InputValues(l2.getTitle());
        searchLeafNotesByTitleUseCase.execute(input);

        verify(repository).searchByTitle(l2.getTitle());
    }
}
