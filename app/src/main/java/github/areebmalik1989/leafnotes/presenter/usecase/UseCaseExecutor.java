package github.areebmalik1989.leafnotes.presenter.usecase;

import github.areebmalik1989.core.usecase.IUseCaseExecutor;
import github.areebmalik1989.core.usecase.UseCase;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class UseCaseExecutor implements IUseCaseExecutor {
    @Override
    public <RX, I extends UseCase.InputValues, O extends UseCase.OutputValues> CompletableFuture<RX> execute(UseCase<I, O> useCase, final I input, Function<O, RX> outputMapper) {
        return CompletableFuture
                .supplyAsync(() -> input)
                .thenApplyAsync(useCase::execute)
                .thenApplyAsync(outputMapper);
    }
}
