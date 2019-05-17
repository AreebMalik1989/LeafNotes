package github.areebmalik1989.leafnotes.presenter.config;

import github.areebmalik1989.core.usecase.leafnote.*;

public class Module {

    public static GetAllLeafNotesUseCase getAllLeafNotesUseCase(ILeafNoteRepository repository) {
        return new GetAllLeafNotesUseCase(repository);
    }

    public static SearchLeafNotesByTitleUseCase searchLeafNotesByTitleUseCase(ILeafNoteRepository repository) {
        return new SearchLeafNotesByTitleUseCase(repository);
    }

    public static GetLeafNoteByIdUseCase getLeafNoteByIdUseCase(ILeafNoteRepository repository) {
        return new GetLeafNoteByIdUseCase(repository);
    }

    public static SaveLeafNoteUseCase saveLeafNoteUseCase(ILeafNoteRepository repository) {
        return new SaveLeafNoteUseCase(repository);
    }
}
