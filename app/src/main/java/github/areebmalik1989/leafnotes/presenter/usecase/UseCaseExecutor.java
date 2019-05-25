package github.areebmalik1989.leafnotes.presenter.usecase;

import github.areebmalik1989.core.usecase.UseCase;
import github.areebmalik1989.core.usecase.leafnote.IUsecaseExecutor;

public class UseCaseExecutor implements IUsecaseExecutor {

    @Override
    public <I extends UseCase.InputValues, O extends UseCase.OutputValues> O execute(UseCase<I, O> useCase, I input) {
        return useCase.execute(input);
    }

    public <I extends UseCase.InputValues, O extends UseCase.OutputValues> void executeAsync(UseCase<I, O> useCase, I input, Callback callback) {
        new Thread(() -> {
            O output = execute(useCase, input);
            callback.onComplete(output);
        }).start();
    }

    public interface Callback<O extends UseCase.OutputValues> {
        void onComplete(O response);
    }
}
