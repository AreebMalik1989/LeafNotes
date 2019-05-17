package github.areebmalik1989.leafnotes.presenter.controller;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.leafnotes.presenter.entities.LeafNoteResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface LeafNoteResource {

    CompletableFuture<List<LeafNoteResponse>> getAll();

    CompletableFuture<List<LeafNoteResponse>> searchByTitle(String searchText);

    CompletableFuture<LeafNoteResponse> getById(Identity id);

    CompletableFuture<Identity> saveLeafNote(LeafNote leafNote);
}
