package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.usecase.UseCase;

import java.util.List;

public class SearchLeafNotesByTitleUseCase extends UseCase<SearchLeafNotesByTitleUseCase.InputValues, SearchLeafNotesByTitleUseCase.OutputValues> {

    LeafNoteRepository repository;

    public SearchLeafNotesByTitleUseCase(LeafNoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        return new OutputValues(repository.searchByTitle(input.getSearchText()));
    }

    // expanded lombok @Value
    public static class InputValues implements UseCase.InputValues {

        private final String searchText;

        public InputValues(String searchText) {
            this.searchText = searchText;
        }

        public String getSearchText() {
            return searchText;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof InputValues)) return false;

            InputValues that = (InputValues) o;

            return getSearchText().equals(that.getSearchText());
        }

        @Override
        public int hashCode() {
            return getSearchText().hashCode();
        }

        @Override
        public String toString() {
            return "InputValues{" +
                    "searchText='" + searchText + '\'' +
                    '}';
        }
    }

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
