package com.myapp.doctorvisit.user;

import com.myapp.doctorvisit.security.UserNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(UserNotExistsException::new);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    public User updateUserInfo(User updatedUser) {
        User user = userRepository.findByUsername(updatedUser.getUsername()).orElseThrow(UserNotFoundException::new);
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setGender(updatedUser.getGender());
        user.setAddress(updatedUser.getAddress());
        user.setNationalId(updatedUser.getNationalId());
        return userRepository.save(user);
    }
}
