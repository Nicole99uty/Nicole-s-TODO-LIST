//package Test;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ui.model.ItemnotfoundException;
//import ui.model.TodoList;
//import ui.model.TooManyThingsToDo;
//
//import java.util.Date;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
////Unit tests for TodoListTest class
//public class TodoListTest {
//    private TodoList testList;
//
//    @BeforeEach
//    public void runBefore() {
//        testList = new TodoList();
//    }
//
//    @Test
//    public void testAddNoTooManyThingsToDoException(){
//        try {
//            testList.add("Math Assign1", false, null, 1,  false);
////        } catch (TooManyThingsToDo e) {
////            fail("You fail");
////        }
//        assertTrue(testList.todosContains("Math Assign1"));
//        assertEquals(1,testList.todosSize());
//
//    }
//
////    @Test
////    public void testAddExpectTooManyThingsToDoException(){
////        try {
////            testList.add("Stat lab", false, null, 1,  false);
////            testList.add("Math Assign1", false, null, 1,  false);
////            testList.add("WRDS essay", false, null, 1,  true);
////            testList.add("cpsc lab", false, null, 1, true);
////            testList.add("stat assign", false, null, 1,  true);
////        }
//////        catch(TooManyThingsToDo e){
//////            fail("you fail");
//////        }
////        try {
////            testList.add("COMM exam",false, null, 1,  true);
////            fail("you fail");
//////        } catch (TooManyThingsToDo e) {
//////        }
////        assertTrue(testList.todosContains("Math Assign1"));
////        assertTrue(testList.todosContains("Stat lab"));
////        assertTrue(testList.todosContains("WRDS essay"));
////        assertTrue(testList.todosContains("cpsc lab"));
////        assertTrue(testList.todosContains("stat assign"));
////        assertEquals(5,testList.todosSize());
////
////    }
//
//    @Test
//    public void testCrossOffNoItemnotFoundException(){
//
//            testList.add("Math Assign1", false, null, 2,  false);
////         catch (TooManyThingsToDo tooManyThingsToDo) {
////            fail("you fail");
////        }
//        assertTrue(testList.todosContains("Math Assign1"));
//        try {
//            testList.crossOff("Math Assign1");
//        } catch (ItemnotfoundException e) {
//            fail("you fail");
//        }
//        assertFalse(testList.todosContains("Math Assign1"));
//        assertEquals(0,testList.todosSize());
//
//    }
//
//    @Test
//    public void testCrossOffExpectItemnotFoundException(){
//        try {
//            testList.add("Math Assign1", false, null, 3,  false);
////        } catch (TooManyThingsToDo tooManyThingsToDo) {
////            fail("you fail");
////        }
//        assertEquals(1,testList.todosSize());
//
//        assertFalse(testList.todosContains("Math Assign2"));
//        try {
//            testList.crossOff("Math Assign2");
//            fail("you fail");
//        } catch (ItemnotfoundException e) {
//        }
//
//        assertTrue(testList.todosContains("Math Assign1"));
//        assertEquals(1, testList.todosSize());
//
//    }
//
//    @Test
//    public void testTodosContains(){
//        try {
//            testList.add("CPSC Assign", false, null, 4,null,  false);
//        } catch (TooManyThingsToDo tooManyThingsToDo) {
//            fail("you fail");
//        }
//        assertTrue(testList.todosContains("CPSC Assign"));
//        assertEquals(1,testList.todosSize());
//
//    }
//
//
//    @Test
//    public void testSave()throws IOException {
//        try {
//            testList.add("CPSC Assign", false, new Date(), 4,null,  false);
//        } catch (TooManyThingsToDo tooManyThingsToDo) {
//            fail("you fail");
//        }
//        testList.save("saving_file");
//        TodoList testLoadingList = new TodoList();
//        assertEquals(0,testLoadingList.todosSize());
//        testLoadingList.load("saving_file");
//        assertTrue(testLoadingList.todosContains("CPSC Assign"));
//
//    }
//    @Test
//    public void testLoad()throws IOException{
//        assertEquals(0,testList.todosSize());
//        testList.load("test_file");
//        assertTrue(testList.todosContains("Phys Assign"));
//
//    }
//
//
//
//
//
//}
