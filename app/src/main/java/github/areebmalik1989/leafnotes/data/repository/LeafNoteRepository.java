package github.areebmalik1989.leafnotes.data.repository;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.usecase.leafnote.ILeafNoteRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LeafNoteRepository implements ILeafNoteRepository {

    LinkedList<LeafNote> repository = new LinkedList<>();

    @Override
    public List<LeafNote> getAll() {
        return repository;
    }

    @Override
    public List<LeafNote> searchByTitle(String searchText) {

        List<LeafNote> leafNotes = new ArrayList<>();

        for(LeafNote leafNote : repository) {

            if(leafNote.getTitle().equals(searchText)) {
                leafNotes.add(leafNote);
            }
        }

        return leafNotes;
    }

    @Override
    public Optional<LeafNote> getById(Identity id) {

        for(LeafNote leafNote : repository) {
            if (leafNote.getId().equals(id)) return Optional.of(leafNote);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Identity> saveLeafNote(LeafNote leafNote) {

        repository.add(leafNote);

        return Optional.of(leafNote.getId());
    }
}
