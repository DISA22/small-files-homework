package Exceptions;

public class NameInvalidExceptions extends RuntimeException {
    public NameInvalidExceptions(String message) {

      super(message);
    }

  @Override
  public String toString() {
    return "NameInvalidExceptions{" +
            "message " + getMessage() + "\n" +
            "}";
  }
}
