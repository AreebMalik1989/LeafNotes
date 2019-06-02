package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.domain.exception.NotSavedException;
import github.areebmalik1989.core.usecase.UseCase;

public class UpdateLeafNoteUseCase extends UseCase<UpdateLeafNoteUseCase.InputValues, UpdateLeafNoteUseCase.OutputValues> {

    private ILeafNoteRepository repository;

    public UpdateLeafNoteUseCase(ILeafNoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public UpdateLeafNoteUseCase.OutputValues execute(UpdateLeafNoteUseCase.InputValues input) {

        LeafNote leafNote = input.getLeafNote();

        Identity id = repository.updateLeafNote(leafNote);

        if (id != null) {
            return new UpdateLeafNoteUseCase.OutputValues(id);
        } else {
            throw new NotSavedException("LeafNote %s not updated", leafNote);
        }
    }

    // expanded lombok @Value
    public static class InputValues implements UseCase.InputValues {

        private final LeafNote leafNote;

        public InputValues(LeafNote leafNote) {
            this.leafNote = leafNote;
        }

        public LeafNote getLeafNote() {
            return leafNote;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SaveLeafNoteUseCase.InputValues)) return false;

            SaveLeafNoteUseCase.InputValues that = (SaveLeafNoteUseCase.InputValues) o;

            return getLeafNote().equals(that.getLeafNote());
        }

        @Override
        public int hashCode() {
            return getLeafNote().hashCode();
        }

        @Override
        public String toString() {
            return "InputValues{" +
                    "leafNote=" + leafNote +
                    '}';
        }
    }

    // expanded lombok @Value
    public static class OutputValues implements UseCase.OutputValues {

        private final Identity id;

        public OutputValues(Identity id) {
            this.id = id;
        }

        public Identity getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SaveLeafNoteUseCase.OutputValues)) return false;

            SaveLeafNoteUseCase.OutputValues that = (SaveLeafNoteUseCase.OutputValues) o;

            return getId().equals(that.getId());
        }

        @Override
        public int hashCode() {
            return getId().hashCode();
        }

        @Override
        public String toString() {
            return "OutputValues{" +
                    "id=" + id +
                    '}';
        }
    }
}
