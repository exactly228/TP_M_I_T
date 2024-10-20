package ru.lingdisp.back.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.lingdisp.back.user.User;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private final ru.lingdisp.back.user.UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);

        return new ResponseEntity<>("" + savedUser.getId(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User requestUser) {
        User user = userRepository.findByEmail(requestUser.getEmail())
                .orElse(null);

        if (user == null) {
            return new ResponseEntity<>("Invalid email or password!", HttpStatus.UNAUTHORIZED);
        }

        if (!passwordEncoder.matches(requestUser.getPassword(), user.getPassword())) {
            return new ResponseEntity<>("Invalid email or password!", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
    }
}
