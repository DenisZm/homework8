import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanDao {
    private File file;

    public HumanDao(File file) throws IOException {
        this.file = file;
        if(!file.exists()) {
            file.createNewFile();
        }
    }

    public List<Human> load() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(fileInputStream);

            List<Human> people = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String humanString = scanner.nextLine();
                String[] humanDisassembled = humanString.split("\\|");

                String name = humanDisassembled[0];
                String surname = humanDisassembled[1];
                int  age = Integer.parseInt(humanDisassembled[2]);

                people.add(new Human(name, surname, age));
            }
            return people;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void store(List<Human> people) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            for (int i = 0; i < people.size(); i++) {
                String humanString = humanToSerializedString(people.get(i)) + "\n";
                fileOutputStream.write(humanString.getBytes());
            }
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String humanToSerializedString(Human human) {
        return human.getName() + "|" + human.getSurname() + "|" + human.getAge();
    }
}
