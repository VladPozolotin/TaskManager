package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTests {

    TodosInt todos;
    TodosAdapter todosAdapter;


    Request requestAdd1 = new Request(Request.Operation.ADD, "Пресс качат");
    Request requestAdd2 = new Request(Request.Operation.ADD, "Т) Бегит");
    Request requestAdd3 = new Request(Request.Operation.ADD, "Турник");
    Request requestAdd4 = new Request(Request.Operation.ADD, "Анжуманя");
    Request requestAdd5 = new Request(Request.Operation.ADD, "Гантели");
    Request requestAdd6 = new Request(Request.Operation.ADD, "Бегит");
    Request requestAdd7 = new Request(Request.Operation.ADD, "Сон");
    Request requestAdd8 = new Request(Request.Operation.ADD, "Жрат");
    Request requestRemove1 = new Request(Request.Operation.REMOVE, "Пресс качат");
    Request requestRemove2 = new Request(Request.Operation.REMOVE, "Т) Бегит");
    Request requestRemove3 = new Request(Request.Operation.REMOVE, "Турник");
    Request requestRemove4 = new Request(Request.Operation.REMOVE, "Анжуманя");
    Request requestRemove5 = new Request(Request.Operation.REMOVE, "Гантели");
    Request requestRemove6 = new Request(Request.Operation.REMOVE, "Бегит");
    Request requestRemove7 = new Request(Request.Operation.REMOVE, "Сон");
    Request requestRemove8 = new Request(Request.Operation.REMOVE, "Жрат");
    Request requestRestore = new Request(Request.Operation.RESTORE);

    @BeforeEach
    void BeforeEach() {
        todos = new Todos();
        todosAdapter = new TodosAdapter(todos, 7);
    }

    @Test
    void testFull() {
        todosAdapter.execute(requestAdd1);
        todosAdapter.execute(requestAdd2);
        todosAdapter.execute(requestAdd3);
        todosAdapter.execute(requestAdd4);
        todosAdapter.execute(requestAdd5);
        todosAdapter.execute(requestAdd6);
        todosAdapter.execute(requestAdd7);
        Assertions.assertEquals("Анжуманя Бегит Гантели Пресс качат Сон Т) Бегит Турник", todosAdapter.execute(requestAdd8));
    }

    @Test
    void testRemove() {
        todosAdapter.execute(requestAdd1);
        todosAdapter.execute(requestAdd2);
        todosAdapter.execute(requestAdd3);
        todosAdapter.execute(requestAdd4);
        todosAdapter.execute(requestAdd5);
        todosAdapter.execute(requestAdd6);
        todosAdapter.execute(requestAdd7);
        todosAdapter.execute(requestRemove6);
        Assertions.assertEquals("Анжуманя Гантели Пресс качат Т) Бегит Турник", todosAdapter.execute(requestRemove7));
    }
    @Test
    void testRestore() {
        todosAdapter.execute(requestAdd1);
        todosAdapter.execute(requestAdd2);
        todosAdapter.execute(requestAdd3);
        todosAdapter.execute(requestAdd4);
        todosAdapter.execute(requestAdd5);
        todosAdapter.execute(requestAdd6);
        todosAdapter.execute(requestAdd7);
        todosAdapter.execute(requestRemove6);
        todosAdapter.execute(requestRemove7);
        todosAdapter.execute(requestRestore);
        todosAdapter.execute(requestRestore);
        Assertions.assertEquals("Анжуманя Бегит Гантели Пресс качат Сон Т) Бегит Турник", todosAdapter.execute(requestAdd8));
    }
}
