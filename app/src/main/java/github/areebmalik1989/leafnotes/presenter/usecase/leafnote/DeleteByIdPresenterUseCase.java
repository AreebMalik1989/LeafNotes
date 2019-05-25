package github.areebmalik1989.leafnotes.presenter.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.usecase.leafnote.DeleteLeafNoteByIdUseCase;
import github.areebmalik1989.core.usecase.leafnote.ILeafNoteRepository;

public class DeleteByIdPresenterUseCase extends DeleteLeafNoteByIdUseCase {

    public DeleteByIdPresenterUseCase(ILeafNoteRepository repository) {
        super(repository);
    }

    public void deleteById(Identity id, Callback callback) {

        callback.onUseCaseExecutionStart();

        DeleteLeafNoteByIdUseCase.InputValues inputValues = new InputValues(id);
        DeleteLeafNoteByIdUseCase.OutputValues outputValues = super.execute(inputValues);

        callback.onUseCaseExecutionComplete(outputValues.isSuccess());
    }

    public interface Callback {
        void onUseCaseExecutionStart();
        void onUseCaseExecutionComplete(boolean success);
    }
}
