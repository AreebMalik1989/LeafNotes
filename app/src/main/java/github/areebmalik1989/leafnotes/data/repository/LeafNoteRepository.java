package github.areebmalik1989.leafnotes.data.repository;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.usecase.leafnote.ILeafNoteRepository;
import github.areebmalik1989.leafnotes.data.entity.LeafNoteData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LeafNoteRepository implements ILeafNoteRepository {

    LinkedList<LeafNoteData> repository = new LinkedList<>();

    @Override
    public List<LeafNote> getAll() {

        List<LeafNote> list = new ArrayList<>();

        for(LeafNoteData leafNoteData : repository) {
            list.add(leafNoteData.fromThis());
        }

        return list;
    }

    @Override
    public List<LeafNote> searchByTitle(String searchText) {

        List<LeafNote> leafNotes = new ArrayList<>();

        for(LeafNoteData leafNoteData : repository) {

            if(leafNoteData.getTitle().equals(searchText)) {
                leafNotes.add(leafNoteData.fromThis());
            }
        }

        return leafNotes;
    }

    @Override
    public Optional<LeafNote> getById(Identity id) {

        for(LeafNoteData leafNoteData: repository) {
            if (leafNoteData.getId() == id.getId()) return Optional.of(leafNoteData.fromThis());
        }

        return Optional.empty();
    }

    @Override
    public Optional<Identity> saveLeafNote(LeafNote leafNote) {

        repository.add(LeafNoteData.from(leafNote));

        return Optional.of(leafNote.getId());
    }
}
