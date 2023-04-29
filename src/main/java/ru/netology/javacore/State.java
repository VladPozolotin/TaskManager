package ru.netology.javacore;

public class State {

    private TodosInt manager;
    private int counter;
    public State (TodosInt manager, int count){
        this.manager = manager;
        this.counter = count;
    }
    public TodosInt getManager() {
        return manager;
    }

    public int getCounter() {
        return counter;
    }
}
