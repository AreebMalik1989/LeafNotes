package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.domain.exception.NotFoundException;
import github.areebmalik1989.core.usecase.UseCase;

public class GetLeafNoteByIdUseCase extends UseCase<GetLeafNoteByIdUseCase.InputValues, GetLeafNoteByIdUseCase.OutputValues> {

    ILeafNoteRepository repository;

    public GetLeafNoteByIdUseCase(ILeafNoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {

        Identity id = input.getId();

        return repository
                .getById(id)
                .map(OutputValues::new)
                .orElseThrow(() -> new NotFoundException("LeafNote %s not found", id.getId()));
    }

    // expanded lombok @Value
    public static class InputValues implements UseCase.InputValues {

        private final Identity id;

        public InputValues(Identity id) {
            this.id = id;
        }

        public Identity getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof InputValues)) return false;

            InputValues that = (InputValues) o;

            return getId().equals(that.getId());
        }

        @Override
        public int hashCode() {
            return getId().hashCode();
        }

        @Override
        public String toString() {
            return "InputValues{" +
                    "id=" + id +
                    '}';
        }
    }

    // expanded lombok @Value
    public static class OutputValues implements UseCase.OutputValues {

        private final LeafNote leafNote;

        public OutputValues(LeafNote leafNote) {
            this.leafNote = leafNote;
        }

        public LeafNote getLeafNote() {
            return leafNote;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof OutputValues)) return false;

            OutputValues that = (OutputValues) o;

            return getLeafNote().equals(that.getLeafNote());
        }

        @Override
        public int hashCode() {
            return getLeafNote().hashCode();
        }

        @Override
        public String toString() {
            return "OutputValues{" +
                    "leafNote=" + leafNote +
                    '}';
        }
    }
}
