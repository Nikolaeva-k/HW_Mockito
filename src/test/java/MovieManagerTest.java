import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void shouldAdd() {
        MovieManager manager = new MovieManager();

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        String[] expected = {"Film 1", "Film 2", "Film 3"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldReturnLastFive() {
        MovieManager manager = new MovieManager();

        manager.add("F 1");
        manager.add("F 2");
        manager.add("F 3");
        manager.add("F 4");
        manager.add("F 5");
        manager.add("F 6");

        String[] expected = {"F 6", "F 5", "F 4", "F 3", "F 2"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllLessLimit() {
        MovieManager manager = new MovieManager();

        manager.add("F 1");
        manager.add("F 2");
        manager.add("F 3");

        String[] expected = {"F 3", "F 2", "F 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRespectLimit() {
        MovieManager manager = new MovieManager(3);

        manager.add("F 1");
        manager.add("F 2");
        manager.add("F 3");
        manager.add("F 4");
        manager.add("F 5");

        String[] expected = {"F 5", "F 4", "F 3"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

}
