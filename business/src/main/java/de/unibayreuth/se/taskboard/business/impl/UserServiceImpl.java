package de.unibayreuth.se.taskboard.business.impl;

import de.unibayreuth.se.taskboard.business.ports.UserPersistenceService;
import de.unibayreuth.se.taskboard.business.ports.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import de.unibayreuth.se.taskboard.business.exceptions.UserNotFoundException;
import de.unibayreuth.se.taskboard.business.domain.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserPersistenceService userPersistenceService;
    @Override
    public void clear() {
        userPersistenceService.clear();
    }

    @Override
    @NonNull
    public List<User> getAll() {
        return userPersistenceService.getAll();
    }

    @Override
    @NonNull
    public User getById(@NonNull UUID id) throws UserNotFoundException {
        return userPersistenceService.getById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " does not exist."));
    }

    @Override
    @NonNull
    public User upsert(@NonNull User user) throws UserNotFoundException {
        if (user.getId() != null) {
            userPersistenceService.getById(user.getId())
                    .orElseThrow(() -> new UserNotFoundException("User with ID " + user.getId() + " does not exist."));
        }
        user.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return userPersistenceService.upsert(user);
    }
}