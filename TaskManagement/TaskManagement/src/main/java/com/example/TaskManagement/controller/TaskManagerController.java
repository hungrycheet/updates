package com.example.TaskManagement.controller;

import com.example.TaskManagement.Repository.TaskRepository;
import com.example.TaskManagement.Repository.UserInfoRepository;
import com.example.TaskManagement.entity.Task;
import com.example.TaskManagement.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@RestController
public class TaskManagerController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserInfoRepository userInforepo;

    @Autowired
    private PasswordEncoder encoder;

    List<Task> listTasks= new ArrayList<>();

    @PostConstruct
    public void loadTaskData(){
        listTasks.add(new Task(1L,"task1","testing",true,"IT",1));
        listTasks.add(new Task(2L,"task2","testing",false,"HR",2));
        listTasks.add(new Task(3L,"task3","testing",false,"Hr",4));
        listTasks.add(new Task(4L,"task4","testing",true,"IT",1));
    }

    @GetMapping("/listtasks")
    public List<Task> getAllTasks() {
        return listTasks;
    }

    @GetMapping("/home")
    public String home() {
        return "welcome home";
    }

    @PostMapping("/saveuser")
    public String addNewUser(@RequestBody UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userInforepo.save(userInfo);
        return "usersaved";
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable int id) {
        Task task = listTasks.stream().filter(i -> i.getId() == id).findAny().orElse(null);
        return task;
    }

//    @PostMapping
//    public Task createTask(@RequestBody Task task) {
//        return taskRepository.save(task);
//    }
//
//    @PutMapping("/{id}")
//    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
//        Task task = taskRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
//        task.setName(taskDetails.getName());
//        task.setDescription(taskDetails.getDescription());
//        task.setCompleted(taskDetails.isCompleted());
//        task.setCategory(taskDetails.getCategory());
//        task.setPriority(taskDetails.getPriority());
//        return taskRepository.save(task);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteTask(@PathVariable Long id) {
//        taskRepository.deleteById(id);
//    }
//
//    @PutMapping("/{id}/category")
//    public Task categorizeTask(@PathVariable Long id, @RequestParam String category) {
//        Task task = taskRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
//        task.setCategory(category);
//        return taskRepository.save(task);
//    }
//
//    @PutMapping("/{id}/priority")
//    public Task prioritizeTask(@PathVariable Long id, @RequestParam int priority) {
//        Task task = taskRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
//        task.setPriority(priority);
//        return taskRepository.save(task);
//    }
}

