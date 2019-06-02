package github.areebmalik1989.core.usecase;

public interface IUsecaseExecutor {

    <I extends UseCase.InputValues, O extends UseCase.OutputValues> O execute(
            UseCase<I, O> useCase,
            I input
    );
}
