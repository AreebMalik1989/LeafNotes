package github.areebmalik1989.leafnotes.presenter.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.usecase.leafnote.GetLeafNoteByIdUseCase;
import github.areebmalik1989.core.usecase.leafnote.ILeafNoteRepository;

public class GetByIdPresenterUseCase extends GetLeafNoteByIdUseCase {

    public GetByIdPresenterUseCase(ILeafNoteRepository repository) {
        super(repository);
    }

    public void getById(Identity id, Callback callback) {
        callback.onUseCaseExecutionStart();

        GetLeafNoteByIdUseCase.InputValues inputValues = new InputValues(id);
        GetLeafNoteByIdUseCase.OutputValues outputValues = super.execute(inputValues);

        LeafNote leafNote = outputValues.getLeafNote();

        callback.onUseCaseExecutionComplete(leafNote);
    }

    public interface Callback {
        void onUseCaseExecutionStart();
        void onUseCaseExecutionComplete(LeafNote leafNote);
    }
}
