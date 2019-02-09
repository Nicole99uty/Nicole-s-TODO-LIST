package Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.model.RegularItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

//Unit tests for ItemTest class
public class ItemTest {

    private RegularItem testRegularItem;

    @BeforeEach
    public void runBefore(){
        testRegularItem = new RegularItem("Test", false, new Date(), 2);
    }

    @Test
    public void testTodayBeforeDueDate(){
        Date today =new Date(175);
        Date tomorrow = new Date(190);
        testRegularItem.setDueDate(tomorrow);
        assertFalse(testRegularItem.pastDueDate(today));
    }

    @Test
    public void testTodayIsDueDate(){
        Date today =new Date(175);
        testRegularItem.setDueDate(today);
        assertFalse(testRegularItem.pastDueDate(today));

    }

    @Test
    public void testTodayAfterDueDate(){
        Date yesterday = new Date(153);
        Date today =new Date(175);
        testRegularItem.setDueDate(yesterday);
        assertTrue(testRegularItem.pastDueDate(today));
    }



}
