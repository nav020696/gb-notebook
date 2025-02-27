package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;
import java.util.Objects;

public class UserController {
    private final GBRepository repository;

    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    public void saveUser(List<String> userDates) {
        repository.create(userDates);
    }

    public User readUser(Long userId) throws Exception {
        List<User> users = readAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }

    public List<User> readAll(){
        return repository.findAll();
    }

    public void updateUser(String userId, List<String> usersDates) {
        repository.update(Long.parseLong(userId), usersDates);
    }

    public void deleteUser(String userId){
        repository.delete(Long.parseLong(userId));
    }
}
