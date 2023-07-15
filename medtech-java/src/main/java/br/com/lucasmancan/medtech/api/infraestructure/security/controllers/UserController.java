package br.com.lucasmancan.medtech.api.infraestructure.security.controllers;

import br.com.lucasmancan.medtech.api.domain.dto.NewPassword;
import br.com.lucasmancan.medtech.api.domain.dto.SignUpUser;
import br.com.lucasmancan.medtech.api.domain.dto.UserDTO;
import br.com.lucasmancan.medtech.api.infraestructure.security.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping("/current")
    public UserDTO getCurrent() {
        return service.findUserInfo();
    }

    @ResponseBody
    @GetMapping("verify-account/{token}")
    public ResponseEntity<Void> verifyAccount(@PathVariable String token) {
        service.verifyAccount(token);
        return ResponseEntity.ok().build();
    }

    @ResponseBody
    @PostMapping("reset-password")
    public ResponseEntity<Void> resetPassword(@RequestBody @Valid NewPassword newPassword) {
        service.updatePassword(newPassword);
        return ResponseEntity.ok().build();
    }

    @ResponseBody
    @GetMapping("verify-email/{email}")
    public ResponseEntity<Void> verifyEmail(@PathVariable String email) {
        service.verifyEmail(email);
        return ResponseEntity.ok().build();
    }

    @ResponseBody
    @PutMapping
    public UserDTO update(@RequestBody @Valid UserDTO user) {
        return service.update(user);
    }

    @PostMapping("/signup")
    @ResponseBody
    public UserDTO signUP(@RequestBody @Valid SignUpUser user) {
        return service.signUp(user);
    }

}
