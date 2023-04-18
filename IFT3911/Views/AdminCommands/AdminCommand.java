package Views.AdminCommands;
public abstract class AdminCommand<T> {

	private T backup;

	public T execute() {
		// TODO - implement AdminCommand.execute
		throw new UnsupportedOperationException();
	}

	public void undo() {
		// TODO - implement AdminCommand.undo
		throw new UnsupportedOperationException();
	}

	public void saveBackup() {
		// TODO - implement AdminCommand.saveBackup
		throw new UnsupportedOperationException();
	}

}