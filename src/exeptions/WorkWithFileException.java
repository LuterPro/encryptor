package exeptions;

public class WorkWithFileException extends Exception {
    public WorkWithFileException() {
        System.out.println("Что-то пошло не так :(");
    }

    public WorkWithFileException(String message) {
        super(message);
    }

    public WorkWithFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
