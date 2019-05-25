package github.areebmalik1989.leafnotes.data.repository;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.usecase.leafnote.ILeafNoteRepository;
import github.areebmalik1989.leafnotes.data.entity.LeafNoteData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeafNoteRepository implements ILeafNoteRepository {

    private static final LinkedList<LeafNoteData> repository = new LinkedList<>();

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
    public LeafNote getById(Identity id) {

        for(LeafNoteData leafNoteData: repository) {
            if (leafNoteData.getId() == id.getId())
                return leafNoteData.fromThis();
        }

        return null;
    }

    @Override
    public Identity saveLeafNote(LeafNote leafNote) {

        repository.add(LeafNoteData.from(leafNote));

        return leafNote.getId();
    }

    @Override
    public boolean deleteLeafNote(Identity id) {

        boolean success = false;

        for(LeafNoteData leafNoteData : repository) {
            if(leafNoteData.getId() == id.getId()) {
                repository.remove(leafNoteData);
                success = true;
            }
        }

        return success;
    }
}
