import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        // List<String> list = Arrays.asList("Kiran", "Sam", "Roshan", "Ramesh");
        // List<Integer> age = Arrays.asList(24,22,23,21);

        // list.stream()
        //     .filter(name -> !name.equals("Kiran"))
        //     .forEach(name -> System.out.println(name));

        //creating classes from csv java 8
        List<User> userList = new ArrayList<>();
        String path = "./src/data.csv";
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            userList = stream.map(line -> {
                    String[] tempArray = line.split(",");
                    return new User(tempArray[0],
                                Integer.parseInt(tempArray[1]));
                }).collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(userList.toString());

    }
}

@FunctionalInterface
interface Square {
    int calculate(int x);
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Age " + age;
    }

    
    
}

