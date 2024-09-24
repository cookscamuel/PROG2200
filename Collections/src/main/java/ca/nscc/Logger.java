package ca.nscc;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    private LogLevel logLevel;
    private List<String> logs;

    public Logger() {
        logLevel = LogLevel.INFO;
        logs = new ArrayList<>();
    }

    public void setLogLevel(LogLevel level) {
        logLevel = level;
    }

    public void log(LogLevel level, String message) {
        String log = String.format("[%s] [%s] %s", level, LocalDateTime.now(), message);
        // This is like printf from C, where you can represent variables with %letter.

        logs.add(log);

        System.out.println(log);

    }

    public void displayLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
