package com.surnov.pwned.endpoints;

import com.surnov.pwned.dao.User;
import com.surnov.pwned.dto.UserDTO;
import com.surnov.pwned.repo.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserEndpoint {

    private final ModelMapper modelMapper;
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findById(@PathVariable long userId) {
        UserDTO userDTO = modelMapper.map(userService.findById(userId), UserDTO.class);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<Collection<UserDTO>> findAll() {
        List<UserDTO> users = modelMapper.map(userService.findAll(), new TypeToken<List<UserDTO>>() {
        }.getType());
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<?> create(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable long userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }

}
