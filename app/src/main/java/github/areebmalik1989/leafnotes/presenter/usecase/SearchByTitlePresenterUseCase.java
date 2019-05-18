package github.areebmalik1989.leafnotes.presenter.usecase;

import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.usecase.leafnote.ILeafNoteRepository;
import github.areebmalik1989.core.usecase.leafnote.SearchLeafNotesByTitleUseCase;

import java.util.List;

public class SearchByTitlePresenterUseCase extends SearchLeafNotesByTitleUseCase {

    public SearchByTitlePresenterUseCase(ILeafNoteRepository repository) {
        super(repository);
    }

    public void searchByTitle(String searchText, Callback callback) {
        callback.onUseCaseExecutionStart();

        SearchLeafNotesByTitleUseCase.InputValues inputValues = new InputValues(searchText);
        SearchLeafNotesByTitleUseCase.OutputValues outputValues = super.execute(inputValues);

        List<LeafNote> leafNotes = outputValues.getLeafNotes();

        callback.onUseCaseExecutionComplete(leafNotes);
    }

    public interface Callback {
        void onUseCaseExecutionStart();
        void onUseCaseExecutionComplete(List<LeafNote> leafNotes);
    }
}
