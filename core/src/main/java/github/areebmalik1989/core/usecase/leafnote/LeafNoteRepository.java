package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;

import java.util.List;
import java.util.Optional;

public interface LeafNoteRepository {

    List<LeafNote> getAll();
    List<LeafNote> searchByTitle(String searchText);
    Optional<LeafNote> getById(Identity id);
    Optional<Identity> saveLeafNote(LeafNote leafNote);
}
