package spring.learn.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.learn.model.UserModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private Map<String, UserModel> userMap = new HashMap<>();

    public UserController() {
        userMap.put("Nahid", new UserModel("Nahid", "Anik", 1234));
        userMap.put("Ratul", new UserModel("Ratul", "Khan", 1234));
    }

    @RequestMapping("/")
    public String home() {
        return "Hello! Welcome to the amazing world of Spring";
    }

    @GetMapping("/getUser/{user}")
    public ResponseEntity<UserModel> getUser(@PathVariable("user") String user) {
        if (userMap.containsKey(user)) {
            return new ResponseEntity<>(userMap.get(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserModel>> getUsers() {
        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(userMap.get("Nahid"));
        userModelList.add(userMap.get("Ratul"));
        return new ResponseEntity<>(userModelList, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserModel user) {
        userMap.put(user.getFirstName(), user);
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{user}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("user") String user) {
        userMap.remove(user);
        return ResponseEntity.noContent().build();
    }

}
