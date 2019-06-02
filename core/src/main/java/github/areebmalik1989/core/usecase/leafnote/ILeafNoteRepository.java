package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;

import java.util.List;

public interface ILeafNoteRepository {

    List<LeafNote> getAll();
    List<LeafNote> searchByTitle(String searchText);
    LeafNote getById(Identity id);
    Identity saveLeafNote(LeafNote leafNote);
    Identity updateLeafNote(LeafNote leafNote);
    boolean deleteLeafNote(Identity id);
}
