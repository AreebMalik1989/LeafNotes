package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.exception.NotDeleteException;
import github.areebmalik1989.core.usecase.UseCase;

public class DeleteLeafNoteByIdUseCase extends UseCase<DeleteLeafNoteByIdUseCase.InputValues, DeleteLeafNoteByIdUseCase.OutputValues> {

    private ILeafNoteRepository repository;

    public DeleteLeafNoteByIdUseCase(ILeafNoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {

        boolean success = repository.deleteLeafNote(input.getId());

        if(success) {
            return new OutputValues(success);
        } else {
            throw new NotDeleteException("LeafNote %s not deleted", input.id);
        }
    }

    public static class InputValues implements UseCase.InputValues {

        private final Identity id;

        public InputValues(Identity id) {
            this.id = id;
        }

        public Identity getId() {
            return id;
        }
    }

    public static class OutputValues implements UseCase.OutputValues {

        private final boolean success;

        public OutputValues(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }
    }
}
