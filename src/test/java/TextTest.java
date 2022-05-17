// В полной темноте сверкнула ослепительно яркая точка света.
// Она начала расползаться в стороны, превращаясь в узкий полумесяц,
// и через несколько секунд показались два солнца: огненные светила,
// сжигающие белым пламенем черный край горизонта. Яркие цветные
// сполохи струились сквозь разреженную атмосферу.

import org.junit.jupiter.api.*;
import text.Light;
import text.Sun;

import static org.junit.jupiter.api.Assertions.*;

public class TextTest {

    Light light;

    @BeforeEach
    public void init() throws Exception {
        light = new Light("SuperLight", 1000000, 3);
    }


    @Nested
    class ConstructorTest {
        @Test
        @DisplayName("Test with correct Constructor")
        public void TestWithConstructor() throws Exception {
            Light newLight = new Light("SuperLight", 1000000, 3);
            Assertions.assertEquals(light, newLight);
        }

        @Test
        @DisplayName("Test with incorrect Constructor. Error with age")
        public void TestWithConstructorError1(){
            Exception e = assertThrows(Exception.class, () -> new Light("SuperLight", -1000000, 3));
            assertEquals("Error with year old", e.getMessage());
        }

        @Test
        @DisplayName("Test with incorrect Constructor. Error with separation")
        public void TestWithConstructorError2(){
            Exception e = assertThrows(Exception.class, () -> new Light("SuperLight", 1000000, -3));
            assertEquals("Error with maxToSeparate", e.getMessage());
        }
    }

    @Test
    @DisplayName("test")
    public void sunTest() throws Exception {
        Sun sun = light.toSeparate();
        Assertions.assertEquals(sun.getName(), "Звезда от SuperLight номер 1");
    }

    @Test
    public void separateToSunTest() throws Exception {
        Sun sun1 = light.toSeparate();
        Sun sun2 = light.toSeparate();
        Sun sun3 = light.toSeparate();

        assertAll(
                "heading",
                () -> assertEquals(sun1.getName(), "Звезда от SuperLight номер 1"),
                () -> assertEquals(sun2.getName(), "Звезда от SuperLight номер 2"),
                () -> assertEquals(sun3.getName(), "Звезда от SuperLight номер 3")
        );
    }

    @Test
    public void separateToSunTestError() throws Exception {
        Sun sun1 = light.toSeparate();
        Sun sun2 = light.toSeparate();
        Sun sun3 = light.toSeparate();

        Exception e = assertThrows(Exception.class, () -> light.toSeparate());
        assertEquals("The spot of light has already been seperated!", e.getMessage());

    }
}
