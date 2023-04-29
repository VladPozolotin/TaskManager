package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos implements TodosInt {

    protected ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        return this.tasks.stream().sorted(Comparator.naturalOrder()).collect(Collectors.joining(" ", "", ""));
    }

    @Override
    public TodosInt clone() {
        TodosInt copy = new Todos();
        for (String item : this.tasks) {
            copy.addTask(item);
        }
        return copy;
    }
}
