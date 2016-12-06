import java.io.File;
import java.io.IOException;



// DAO - Data access object - Repository
// DB - Access, MySQL, 1C, InterDB, Oracle DB, MongoDB
// HTTP, FTP
// File

// Service
// ifAgeMoreThan18then5else1();

public class Application {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Work/test-java.txt");
        HumanDao humanDao = new HumanDao(file);
        HumanService humanService = new HumanService(humanDao);

        HumanConsoleController humanConsoleController = new HumanConsoleController(humanService);
        humanConsoleController.run();
    }
}
