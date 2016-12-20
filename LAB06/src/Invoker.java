
public interface Invoker {
	void Execute();
	void Undo();
	void Execute(int x);
	void Execute(float x);
}
