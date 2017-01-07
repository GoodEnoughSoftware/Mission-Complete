package com.goodenoughapps.missioncomplete.domain;

import org.joda.time.DateTime;

import java.util.List;

/**
 * The main task object for all tasks within the application. Follows the schema as mentioned on
 * https://github.com/GoodEnoughSoftware/Mission-Complete/issues/1
 * @author Aaron Vontell
 */

public class Task {

    private String title;
    private double difficulty;
    private DateTime date;
    private boolean completed;
    private String note;
    private TaskLocation location;
    private List<Subtask> subtasks;

}
