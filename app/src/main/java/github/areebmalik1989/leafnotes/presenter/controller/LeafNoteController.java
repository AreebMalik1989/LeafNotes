package github.areebmalik1989.leafnotes.presenter.controller;

import github.areebmalik1989.core.domain.Identity;
import github.areebmalik1989.core.domain.LeafNote;
import github.areebmalik1989.core.usecase.leafnote.GetAllLeafNotesUseCase;
import github.areebmalik1989.core.usecase.leafnote.GetLeafNoteByIdUseCase;
import github.areebmalik1989.core.usecase.leafnote.SaveLeafNoteUseCase;
import github.areebmalik1989.core.usecase.leafnote.SearchLeafNotesByTitleUseCase;
import github.areebmalik1989.leafnotes.presenter.entities.LeafNoteResponse;
import github.areebmalik1989.leafnotes.presenter.usecase.UseCaseExecutor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LeafNoteController implements LeafNoteResource {

    private UseCaseExecutor useCaseExecutor;
    private GetAllLeafNotesUseCase getAllLeafNotesUseCase;
    private SearchLeafNotesByTitleUseCase searchLeafNotesByTitleUseCase;
    private GetLeafNoteByIdUseCase getLeafNoteByIdUseCase;
    private SaveLeafNoteUseCase saveLeafNoteUseCase;

    public LeafNoteController(UseCaseExecutor useCaseExecutor, GetAllLeafNotesUseCase getAllLeafNotesUseCase, SearchLeafNotesByTitleUseCase searchLeafNotesByTitleUseCase, GetLeafNoteByIdUseCase getLeafNoteByIdUseCase, SaveLeafNoteUseCase saveLeafNoteUseCase) {
        this.useCaseExecutor = useCaseExecutor;
        this.getAllLeafNotesUseCase = getAllLeafNotesUseCase;
        this.searchLeafNotesByTitleUseCase = searchLeafNotesByTitleUseCase;
        this.getLeafNoteByIdUseCase = getLeafNoteByIdUseCase;
        this.saveLeafNoteUseCase = saveLeafNoteUseCase;
    }

    @Override
    public CompletableFuture<List<LeafNoteResponse>> getAll() {
        return useCaseExecutor.execute(
                getAllLeafNotesUseCase,
                new GetAllLeafNotesUseCase.InputValues(),
                (outputValues) -> LeafNoteResponse.from(outputValues.getLeafNotes())
        );
    }

    @Override
    public CompletableFuture<List<LeafNoteResponse>> searchByTitle(String searchText) {
        return useCaseExecutor.execute(
                searchLeafNotesByTitleUseCase,
                new SearchLeafNotesByTitleUseCase.InputValues(searchText),
                (outputValues) -> LeafNoteResponse.from(outputValues.getLeafNotes())
        );
    }

    @Override
    public CompletableFuture<LeafNoteResponse> getById(Identity id) {
        return useCaseExecutor.execute(
                getLeafNoteByIdUseCase,
                new GetLeafNoteByIdUseCase.InputValues(id),
                (outputValues) -> LeafNoteResponse.from(outputValues.getLeafNote())

        );
    }

    @Override
    public CompletableFuture<Identity> saveLeafNote(LeafNote leafNote) {
        return useCaseExecutor.execute(
                saveLeafNoteUseCase,
                new SaveLeafNoteUseCase.InputValues(leafNote),
                (outputValues) -> leafNote.getId()
        );
    }
}
