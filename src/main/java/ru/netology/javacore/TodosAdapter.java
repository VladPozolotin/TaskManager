package ru.netology.javacore;

import java.util.Stack;

public class TodosAdapter {
    protected TodosInt manager;
    protected int maxTasks;
    protected int tasks = 0;
    private Stack<State> states = new Stack<>();

    public TodosAdapter(TodosInt manager, int maxTasks) {
        this.manager = manager;
        this.maxTasks = maxTasks;
    }

    public String execute(Request response) {
        switch (response.type) {
            case RESTORE:
                if (!states.empty()) {
                    State restoring = states.pop();
                    this.manager = restoring.getManager();
                    this.tasks = restoring.getCounter();
                }
                break;
            default:
                states.add(new State(this.manager.clone(), this.tasks));
                switch (response.type) {
                    case ADD:
                        if (tasks < maxTasks) {
                            manager.addTask(response.task);
                            tasks++;
                        }
                        break;
                    case REMOVE:
                        manager.removeTask(response.task);
                        tasks--;
                        break;
                }
        }
        return manager.getAllTasks();
    }
}
