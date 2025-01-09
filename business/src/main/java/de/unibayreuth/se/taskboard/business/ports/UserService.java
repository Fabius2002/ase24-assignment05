package de.unibayreuth.se.taskboard.business.ports;

import de.unibayreuth.se.taskboard.business.domain.User;
import de.unibayreuth.se.taskboard.business.exceptions.UserNotFoundException;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    //TODO: Add user service interface that the controller uses to interact with the business layer.(done i think)
    void clear();
    @NonNull
    List<User> getAll();
    @NonNull
    User getById(@NonNull UUID id) throws UserNotFoundException;
    @NonNull
    User upsert(@NonNull User task) throws UserNotFoundException;
    //TODO: Implement the user service interface in the business layer, using the existing user persistence service.(done i think)
}
