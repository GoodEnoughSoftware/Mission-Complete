package com.goodenoughapps.missioncomplete.domain;

/**
 * Represents a subtask which may be contained within a primary Task
 * @author Aaron Vontell
 */
public class Subtask {

    private String title;       // The text content of this subtask
    private boolean completed;  // True if this subtask should be marked as completed

    public static final String TITLE_FIELD = "title";
    public static final String COMPLETED_FIELD = "completed";

    /**
     * Creates a subtask with a given title
     * @param title The text content of this subtask
     * @param completed True if this subtask should be marked as completed
     */
    public Subtask(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    /**
     * Creates a subtask with the given title, defaulting to not completed
     * Useful for creating new tasks
     * @param title The text content of this subtask
     */
    public Subtask(String title) {
        this.title = title;
        this.completed = false;
    }

    /**
     * Returns the content of this subtask
     * @return the content of this subtask
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns true if this subtask is completed
     * @return true if this subtask is completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets whether this subtask should be marked as completed or not
     * @param completed true if this should be marked as completed, false otherwise
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Returns a JSON object representing this subtask as marked in the Schema
     * @return The JSON representation of this subtask
     */
    public String getJSON() {
        return String.format("{%s: %s,%s: %s}",
                TITLE_FIELD, this.title, COMPLETED_FIELD, this.isCompleted());
    }

    /**
     * Returns a string representing this task, useful for debugging purposes
     * @return a string representing this task
     */
    @Override
    public String toString() {
        return String.format("Task \"%s\" is %s",
                this.title, this.isCompleted() ? "completed" : "not completed");
    }

}
