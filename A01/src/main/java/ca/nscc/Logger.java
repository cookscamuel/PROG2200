package ca.nscc;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    private static Logger _instance;
    private LogLevel logLevel;
    private List<String> logs;
    private PrintWriter fileWriter;


    public Logger() {
        logLevel = LogLevel.INFO;
        logs = new ArrayList<>();
        try {
            fileWriter = new PrintWriter(new FileWriter("singleton.log", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Singleton instance retriever
    public static Logger getInstance() {
        if (_instance == null) {
            synchronized (Logger.class) {
                if (_instance == null) {
                    _instance = new Logger();
                }
            }
        }
        return _instance;
    }


    public void setLogLevel(LogLevel level) {
        logLevel = level;
    }

    public void log(LogLevel level, String message) {
        // This is like printf from C, where you can represent variables with %letter.
        if (level.ordinal() >= logLevel.ordinal() - 1) {
        String log = String.format("[%s] [%s] %s", level, LocalDateTime.now(), message);

            System.out.println(log);
            fileWriter.println(log);
            fileWriter.flush();

        }
        logs.add(String.format("[%s] [%s] %s", LocalDateTime.now(), LocalDateTime.now(), message));
    }

    public void displayLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
