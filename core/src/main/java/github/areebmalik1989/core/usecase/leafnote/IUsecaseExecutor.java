package github.areebmalik1989.core.usecase.leafnote;

import github.areebmalik1989.core.usecase.UseCase;

public interface IUsecaseExecutor {

    <I extends UseCase.InputValues, O extends UseCase.OutputValues> O execute(
            UseCase<I, O> useCase,
            I input
    );
}
