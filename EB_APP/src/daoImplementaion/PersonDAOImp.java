package daoImplementaion;

import dao.IPersonDAO;
import entities.Person;
import java.util.List;
import java.util.Optional;

public class PersonDAOImp implements IPersonDAO<Person> {
    /**
     * @param person 
     * @return
     */
    @Override
    public Optional<Person> save(Person person) {
        return Optional.empty();
    }

    /**
     * @param person 
     * @return
     */
    @Override
    public Optional<Boolean> delete(Person person) {
        return Optional.empty();
    }

    /**
     * @param person 
     * @return
     */
    @Override
    public Optional<Boolean> update(Person person) {
        return Optional.empty();
    }

    /**
     * @return 
     */
    @Override
    public Optional<List<Person>> findAll() {
        return Optional.empty();
    }
}
