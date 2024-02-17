package org.hw20;

public class FileLoggerConfiguration {
    private String path;
    private LoggingLevel level;
    private Long maxFileSize;
    private String loggingFormat;

    public void setPath(String path) {
        this.path = path;
    }

    public FileLoggerConfiguration(String path, LoggingLevel level,
                                   Long maxFileSize, String loggingFormat) {
        this.path = path;
        this.level = level;
        this.maxFileSize = maxFileSize;
        this.loggingFormat = loggingFormat;
    }

    public String getPath() {
        return path;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public Long getMaxFileSize() {
        return maxFileSize;
    }

    public String getLoggingFormat() {
        return loggingFormat;
    }

    @Override
    public String toString() {
        return "FileLoggerConfiguration{" +
                "path='" + path + '\'' +
                ", level=" + level +
                ", maxFileSize=" + maxFileSize +
                ", loggingFormat='" + loggingFormat + '\'' +
                '}';
    }
}
