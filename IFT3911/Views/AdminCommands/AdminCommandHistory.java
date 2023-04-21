package Views.AdminCommands;

import java.util.Stack;

public class AdminCommandHistory {

	private Stack<AdminCommand<?>> history;

	public AdminCommandHistory() {
		this.history = new Stack<>();
	}

	public void push(AdminCommand<?> c) {
		this.history.push(c);
	}

	public AdminCommand<?> pop() {
		if (this.history.isEmpty()) {
			return null;
		}
		return this.history.pop();
	}

}