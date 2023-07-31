package io.github.stringthread.practiceapp.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

class UserRegisterParam {
  public String name;
  public String password;
}

class UserRegisterResponse {
  public String name;
}

class UserLoginParam {
  public String name;
  public String password;
}

class UserLoginResponse {
  public String name;
  public String token;
}

@RestController
public class UserController {
  @PostMapping(value = "/api/register", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public UserRegisterResponse register(
      @RequestBody UserRegisterParam body) {
    // TODO: 保存処理
    var response = new UserRegisterResponse();
    response.name = body.name;
    return response;
  }

  @PostMapping(value = "/api/login", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public UserLoginResponse login(
      @RequestBody UserLoginParam body) {
    // TODO: DBデータとのマッチング
    var response = new UserLoginResponse();
    response.name = body.name;
    response.token = "qwertyuiop"; // TODO: トークン生成
    return response;
  }
}
