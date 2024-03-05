package web.service;

import java.util.List;
import web.model.User;
public interface UserService {

    void add(User user);
    List<User> getAll();
    User getById(Long id);
    void delete(Long id);
    void update(User user);
}
