/**
 * 
 */
package com.hungit.support;

/**
 * @author Kashiwagi
 *
 */
public class Message implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final String MESSAGE_ATTRIBUTE = "message";
	private final String message;
	private final Type type;
	private final Object[] args;

	public Message(String message, Type type) {
		this.message = message;
		this.type = type;
		this.args = null;
	}

	public Message(String message, Type type, Object... args) {
		this.message = message;
		this.type = type;
		this.args = args;
	}

	public String getMessage() {
		return message;
	}

	public Type getType() {
		return type;
	}

	public Object[] getArgs() {
		return args;
	}

	/**
	 * The type of the message to be displayed. The type is used to show message in
	 * a different style.
	 */
	public static enum Type {
		DANGER, WARNING, INFO, SUCCESS;
	}
}
