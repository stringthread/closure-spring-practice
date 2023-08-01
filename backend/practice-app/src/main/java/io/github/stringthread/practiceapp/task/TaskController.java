package io.github.stringthread.practiceapp.task;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

class TaskDto {
  public int id;
  public String title;
  public String description;
  public boolean completed;

  @JsonFormat(pattern = "yyyy/MM/ddTHH:mm:ss.SSS")
  public LocalDateTime createdAt;

  @JsonFormat(pattern = "yyyy/MM/ddTHH:mm:ss.SSS")
  public LocalDateTime updatedAt;
}

class GetTasksResponse {
  public TaskDto[] tasks = {};
}

class PostTasksRequest {
  public String title;
  public String description;
}

class PutTaskRequest {
  public String title;
  public String description;
  public boolean completed;
}

@RestController
public class TaskController {
  @GetMapping(value = "/api/tasks")
  @ResponseBody
  public GetTasksResponse tasks() {
    var tasks = new ArrayList<TaskDto>();
    // TODO: DB読み出し
    var response = new GetTasksResponse();
    var tasksArray = new TaskDto[tasks.size()];
    tasks.toArray(tasksArray);
    response.tasks = tasksArray;
    return response;
  }

  @PostMapping(value = "/api/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public TaskDto postTasks(@RequestBody PostTasksRequest body) {
    // TODO: DB保存
    var task = new TaskDto();
    task.id = 1;
    task.title = body.title;
    task.description = body.description;
    task.completed = false;
    return task;
  }

  @PutMapping(value = "/api/tasks/{id}")
  @ResponseBody
  public TaskDto putTask(@PathVariable("id") int id, @RequestBody PutTaskRequest body) {
    // TODO: DBから取り出し
    var task = new TaskDto();
    task.id = id;
    task.title = body.title;
    task.description = body.description;
    task.completed = false;
    // TODO: DB保存
    return task;
  }

  @DeleteMapping(value = "/api/tasks/{id}")
  public void deleteTask(@PathVariable("id") int id) {
    // TODO: DB削除
  }
}
