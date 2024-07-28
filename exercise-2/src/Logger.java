import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger class for recording and managing log messages.
 * Logs messages to both the console and a log file.
 */
public class Logger {

    private static Logger instance;
    private static final String LOG_FILE = "classroom_manager.log";
    private PrintWriter fileWriter;

    /**
     * Private constructor
     */
    private Logger() {
        try {
            fileWriter = new PrintWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            System.err.println("Failed to create log file" + e.getMessage());
        }
    }

    /**
     * Gets the instance of the Logger.
     * @return The Logger interface.
     */
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * Enum for different log levels.
     */
    public enum LogLevel {
        INFO, WARN, ERROR
    }

    /**
     * Logs a message with a log level.
     * @param msg The message to be logged.
     * @param level The log level of the message.
     */
    public synchronized void log(String msg, LogLevel level) {
        LocalDateTime now = LocalDateTime.now();
        String timeStamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = String.format("[%s] [%s] %s", timeStamp, level, msg);

        if(fileWriter != null){
            fileWriter.println(logMessage);
            fileWriter.flush();
        }

        System.out.println(logMessage);
    }

    /**
     * Logs an informational message.
     * @param msg The message to be logged.
     */
    public void info(String msg) {
        log(msg, LogLevel.INFO);
    }

    /**
     * Logs a warning message.
     * @param msg The message to be logged.
     */
    public void warn(String msg) {
        log(msg, LogLevel.WARN);
    }

    /**
     * Logs an error message.
     * @param msg The message to be logged.
     */
    public void error(String msg) {
        log(msg, LogLevel.ERROR);
    }

    /**
     * Logs an exception with a log level.
     * @param e The exception to be logged.
     */
    public void logException(Exception e) {
        String errorMessaage = String.format("Exception: %s", e.getMessage());
        log(errorMessaage, LogLevel.ERROR);
    }

    /**
     * Closes the file writer.
     */
    public synchronized void close(){
        if(fileWriter != null){
            fileWriter.close();
        }
    }

}
