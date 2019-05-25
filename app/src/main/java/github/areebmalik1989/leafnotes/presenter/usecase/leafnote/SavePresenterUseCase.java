package github.areebmalik1989.leafnotes.presenter.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.usecase.leafnote.ILeafNoteRepository;
import github.areebmalik1989.core.usecase.leafnote.SaveLeafNoteUseCase;

public class SavePresenterUseCase extends SaveLeafNoteUseCase {

    public SavePresenterUseCase(ILeafNoteRepository repository) {
        super(repository);
    }

    public void save(LeafNote leafNote, Callback callback) {

        callback.onUseCaseExecutionStart();

        SaveLeafNoteUseCase.InputValues inputValues = new InputValues(leafNote);
        SaveLeafNoteUseCase.OutputValues outputValues = super.execute(inputValues);

        Identity id = outputValues.getId();

        callback.onUseCaseExecutionComplete(id);

    }

    public interface Callback {
        void onUseCaseExecutionStart();
        void onUseCaseExecutionComplete(Identity id);
    }
}
