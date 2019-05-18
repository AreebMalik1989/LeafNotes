package github.areebmalik1989.leafnotes.presenter.usecase;

import github.areebmalik1989.core.usecase.leafnote.GetAllLeafNotesUseCase;
import github.areebmalik1989.core.usecase.leafnote.ILeafNoteRepository;
import github.areebmalik1989.leafnotes.presenter.entities.LeafNoteResponse;

import java.util.List;

public class GetAllPresenterUseCase extends GetAllLeafNotesUseCase {

    public GetAllPresenterUseCase(ILeafNoteRepository repository) {
        super(repository);
    }

    public void getAll(Callback callback) {

        callback.onUseCaseExecutionStart();

        GetAllLeafNotesUseCase.InputValues inputValues = new InputValues();
        GetAllLeafNotesUseCase.OutputValues outputValues = super.execute(inputValues);

        callback.onUseCaseExecutionComplete(LeafNoteResponse.from(outputValues.getLeafNotes()));
    }

    public interface Callback {
        void onUseCaseExecutionStart();
        void onUseCaseExecutionComplete(List<LeafNoteResponse> leafNoteResponses);
    }
}
