package jpabasic.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "access_log")
public class AccessLog {
    @Id
    private int id;

    private String path;

    private LocalDateTime accessed;

    public AccessLog() {
    }

    public AccessLog(int id, String path, LocalDateTime accessed) {
        this.id = id;
        this.path = path;
        this.accessed = accessed;
    }

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getAccessed() {
        return accessed;
    }

    @Override
    public String toString() {
        return "AccessLog{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", accessed=" + accessed +
                '}';
    }
}
