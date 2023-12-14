package myself.exceptions;

public class InvalidEmptyException extends RuntimeException {
  public InvalidEmptyException(String message) {
    super(message);
  }
}
