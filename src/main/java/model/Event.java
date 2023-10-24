package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

    /** A Flink POJO must have public fields, or getters and setters */
    @JsonProperty("id")
    public long id;

    @JsonProperty("data")
    public String data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /** A Flink POJO must have a no-args default constructor */
    public Event() {}

    public Event(long id, String data) {
        this.id = id;
        this.data = data;
    }

    /** Used for printing during development */
    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", data='" + data + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Event event = (Event) o;
        return id == event.id && data.equals(event.data);
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}