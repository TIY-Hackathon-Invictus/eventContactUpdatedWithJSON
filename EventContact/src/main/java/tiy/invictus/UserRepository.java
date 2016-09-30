package tiy.invictus;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Brice on 9/29/16.
 */


public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findFirstByFirstName(String firstName);
}
