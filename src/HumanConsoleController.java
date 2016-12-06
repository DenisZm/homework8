import java.util.List;

public class HumanConsoleController {
    private HumanService humanService;

    public HumanConsoleController(HumanService humanService) {
        this.humanService = humanService;
    }

    public void run() {
        while(true) {
            ConsoleUtils.clearScreen();
            System.out.println("1) Print people list");
            System.out.println("2) Add a new human");
            System.out.println("3) Delete a human");
            System.out.println("4) Exit");
            System.out.print("Choose menu item[1-4]: ");
            switch (ConsoleUtils.getIntFromUser(1,4)) {
                case 1: showPeopleList();break;
                case 2: showCreateNewHumanMenu();break;
                case 3: showDeleteHumanMenu();break;
                case 4: return;
            }
        }
    }

    private void showPeopleList() {
        ConsoleUtils.clearScreen();
        System.out.println("All peoples: ");
        for (Human human : humanService.getAll()) {
            System.out.println(human);
        }
        System.out.println("Press enter to continue...");
        ConsoleUtils.waitForEnterKeyPress();
    }

    private void showCreateNewHumanMenu() {
        ConsoleUtils.clearScreen();

        System.out.print("Enter name: ");
        String name = ConsoleUtils.getLineFromUser();
        System.out.print("Enter surname: ");
        String surname = ConsoleUtils.getLineFromUser();
        System.out.print("Enter age: ");
        int age = ConsoleUtils.getIntFromUser(0, 200);

        humanService.save(new Human(name, surname, age));
        System.out.println("Human " + name + " " + surname + " is added.");
        System.out.println("Press enter to continue...");
        ConsoleUtils.waitForEnterKeyPress();
    }

    private void showDeleteHumanMenu() {
        //TODO: Implement me
        ConsoleUtils.clearScreen();

        List humanList = humanService.getAll();
        int maxId = humanList.size();

        for (int i = 0; i < humanList.size(); i++) {
            System.out.print((i + 1) + ") ");
            System.out.println(humanList.get(i));
        }

        System.out.printf("Select people [1 - %d]: ", maxId);
        int id = ConsoleUtils.getIntFromUser(1, maxId) - 1;
        Human humanToRemove = (Human) humanList.get(id);

        humanService.delete(humanToRemove);
        System.out.println("Human " + humanToRemove.getName() + " "
                                    + humanToRemove.getSurname() + " deleted");
        System.out.println("Press enter to continue...");
        ConsoleUtils.waitForEnterKeyPress();
    }
}
