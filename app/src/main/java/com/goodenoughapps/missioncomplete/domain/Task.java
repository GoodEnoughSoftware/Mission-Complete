package com.goodenoughapps.missioncomplete.domain;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * The main task object for all tasks within the application. Follows the schema as mentioned on
 * https://github.com/GoodEnoughSoftware/Mission-Complete/issues/1
 * @author Aaron Vontell
 */

public class Task {

    private String title;           // the title or main content of this task
    private double difficulty;      // the difficulty of this task (less than 0 means unset)
    private DateTime due;           // the optional due date of this task
    private boolean completed;      // true if this task is completed, false otherwise
    private String note;            // an optional note describing this task
    private TaskLocation location;  // an optional location attached to this task
    private List<Subtask> subtasks; // a list of subtasks associated with this task

    public static final String TITLE_FIELD = "title";
    public static final String DIFF_FIELD = "difficulty";
    public static final String DUE_FIELD = "due";
    public static final String COMPLETED_FIELD = "completed";
    public static final String NOTE_FIELD = "note";
    public static final String LOCATION_FIELD = "location";
    public static final String SUBTASK_FIELD = "subtasks";

    /**
     * Creates a task from the given parameters
     * @param title The title/main content of the task, which must not be null
     * @param note The optional note for this task
     * @param due The optional due date for this task
     * @param difficulty The difficulty of this task (or less than 0 if unset)
     * @param completed True this task should be marked as completed, or false otherwise
     * @param location The options location attributed to this task
     */
    public Task(@NonNull String title, @Nullable String note, @Nullable  DateTime due,
                double difficulty, boolean completed, @Nullable TaskLocation location) {
        this.title = title;
        this.note = note;
        this.due = due;
        this.difficulty = difficulty;
        this.completed = completed;
        this.location = location;
        this.subtasks = new ArrayList<>();
    }

    /**
     * Adds the given subtask to this task
     * @param subtask The subtask to add to this main task
     */
    public void addSubtask(Subtask subtask) {
        this.subtasks.add(subtask);
    }

    /**
     * Adds the given subtask to this task at the given index
     * @param subtask The subtask to add to this main task
     * @param index The place in the list to insert this subtask
     */
    public void addSubtask(Subtask subtask, int index) {
        this.subtasks.add(index, subtask);
    }

    /**
     * Removes and returns the subtask at the given index
     * @param index The index of the subtask to remove
     * @return The subtask that was removed at index
     */
    public Subtask removeSubtask(int index) {
        return this.subtasks.remove(index);
    }

    /**
     * Returns true if all subtasks in this task are true, and false otherwise
     * @return true if all subtasks in this task are true, and false otherwise
     */
    public boolean isSubtasksComplete() {
        int count = 0;
        for (Subtask task : subtasks) {
            count += task.isCompleted() ? 1 : 0;
        }
        return count == getSubtasksLength();
    }

    /**
     * Returns the number of subtasks attached to this task
     * @return the number of tubtasks attached to this task
     */
    public int getSubtasksLength() {
        return this.subtasks.size();
    }

    /**
     * Returns true if this task overall task is completed
     * @return true if this task overall task is completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Returns the difficulty of this task
     * @returnthe difficulty of this task
     */
    public double getDifficulty() {
        return difficulty;
    }

    /**
     * Returns the due date of this task
     * @return the due date of this task
     */
    @Nullable
    public DateTime getDue() {
        return due;
    }

    /**
     * Returns the location attached to this task
     * @return the location attached to this task
     */
    @Nullable
    public TaskLocation getLocation() {
        return location;
    }

    /**
     * Returns a user entered note which may describe this task
     * @return a user entered note which may describe this task
     */
    @Nullable
    public String getNote() {
        return note;
    }

    /**
     * Returns the title or main content of this task
     * @return the title or main content of this task
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns a debuggable string representing this task
     * @return a debuggable string representing this task
     */
    @Override
    public String toString() {

        String subtasksString = "";
        for (int i = 0; i < subtasks.size(); i++) {
            subtasksString += subtasks.get(i).toString();
            subtasksString += i == subtasks.size() - 1 ? "" : "\n";
        }

        return String.format("Title: %s\n" +
                             "Note: $s\n" +
                             "Difficulty: %s\n" +
                             "Due: %s\n" +
                             "Completed: %s\n" +
                             "Location: %s\n" +
                             "Subtasks: \n%s\n <END SUBTASKS>",
                title, note, difficulty, due, completed, location.getJSON(), subtasksString);

    }

    /**
     * Returns the JSON representation of this task, following the schema from issue #1
     * @return the JSON representation of this task, following the schema from issue #1
     */
    public String getJSON() {

        String subtaskArray = "[";
        for (int i = 0; i < subtasks.size(); i++) {
            subtaskArray += subtasks.get(i).getJSON();
            subtaskArray += i == subtasks.size() - 1 ? "" : ",";
        }
        subtaskArray += "]";

        return String.format("{%s: %s, %s: %s, %s: %s, %s: %s, %s: %s, %s: %s, %s: %s}",
                             TITLE_FIELD, title, DIFF_FIELD, difficulty,
                             DUE_FIELD, due, COMPLETED_FIELD, completed,
                             NOTE_FIELD, note, LOCATION_FIELD, location.getJSON(),
                             SUBTASK_FIELD, subtaskArray);
    }

}
