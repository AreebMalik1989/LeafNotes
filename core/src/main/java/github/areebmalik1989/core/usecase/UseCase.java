package github.areebmalik1989.core.usecase;

public abstract class UseCase<I extends UseCase.InputValues, O extends UseCase.OutputValues> {

    public abstract O execute(I input);

    public interface InputValues {}

    public interface OutputValues{}
}
