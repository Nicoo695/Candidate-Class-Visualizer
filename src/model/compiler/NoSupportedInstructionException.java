package model.compiler;

/**
 * User: Javier Isoldi
 * Date: 3/15/13
 * Time: 11:51 AM
 */
public class NoSupportedInstructionException extends Exception {
    public NoSupportedInstructionException(String message) {
        super(message);
    }
}
