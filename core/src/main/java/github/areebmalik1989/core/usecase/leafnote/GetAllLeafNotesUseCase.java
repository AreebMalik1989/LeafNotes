package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.usecase.UseCase;

import java.util.List;

public class GetAllLeafNotesUseCase extends UseCase<GetAllLeafNotesUseCase.InputValues, GetAllLeafNotesUseCase.OutputValues> {

    private LeafNoteRepository repository;

    public GetAllLeafNotesUseCase(LeafNoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        return new OutputValues(repository.getAll());
    }

    // expanded lombok @Value
    public static class InputValues implements UseCase.InputValues {}

    // expanded lombok @Value
    public static class OutputValues implements UseCase.OutputValues {

        private final List<LeafNote> leafNotes;

        public OutputValues(List<LeafNote> leafNotes) {
            this.leafNotes = leafNotes;
        }

        public List<LeafNote> getLeafNotes() {
            return leafNotes;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof OutputValues)) return false;

            OutputValues that = (OutputValues) o;

            return getLeafNotes().equals(that.getLeafNotes());
        }

        @Override
        public int hashCode() {
            return getLeafNotes().hashCode();
        }

        @Override
        public String toString() {
            return "OutputValues{" +
                    "leafNotes=" + leafNotes +
                    '}';
        }
    }
}
