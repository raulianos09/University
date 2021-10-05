package Exception;

public class MyException extends Exception{

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BOLD = "\033[1m";
    public static final String ANSI_RESET_COLOR = "\u001B[0m";
    public static final String ANSI_RESET_BOLD = "\033[0m";

    private String message;

    public MyException(String message)
    {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return ANSI_BOLD + ANSI_RED + this.message + ANSI_RESET_BOLD + ANSI_RESET_COLOR;
    }

}
