import java.util.List;

public class HumanService {
    private HumanDao humanDao;
    private List<Human> people;

    public HumanService(HumanDao humanDao) {
        this.humanDao = humanDao;
        synchronizeWithRepository();
    }

    public List<Human> getAll() {
        return people;
    }

    public void save(Human human) {
        people.add(human);
        storeToRepository();
    }

    public void delete(Human human) {
        people.remove(human);
        storeToRepository();
    }

    public void synchronizeWithRepository() {
        this.people = humanDao.load();
    }

    private void storeToRepository() {
        humanDao.store(people);
    }
}
