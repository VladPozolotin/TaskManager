package ru.netology.javacore;

import java.util.ArrayList;

public interface TodosInt {

    void addTask(String task);
    void removeTask(String task);
    String getAllTasks();
    TodosInt clone();
}
