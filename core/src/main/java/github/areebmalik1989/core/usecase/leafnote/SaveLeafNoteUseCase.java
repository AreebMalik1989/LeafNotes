package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.domain.exception.NotSavedException;
import github.areebmalik1989.core.usecase.UseCase;

public class SaveLeafNoteUseCase extends UseCase<SaveLeafNoteUseCase.InputValues, SaveLeafNoteUseCase.OutputValues> {

    private ILeafNoteRepository repository;

    public SaveLeafNoteUseCase(ILeafNoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {

        LeafNote leafNote = input.getLeafNote();

        return repository
                .saveLeafNote(leafNote)
                .map(OutputValues::new)
                .orElseThrow(() -> new NotSavedException("LeafNote %s not saved", leafNote));
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
            if (!(o instanceof InputValues)) return false;

            InputValues that = (InputValues) o;

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
            if (!(o instanceof OutputValues)) return false;

            OutputValues that = (OutputValues) o;

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
