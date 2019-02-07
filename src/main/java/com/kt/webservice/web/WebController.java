package com.kt.webservice.web;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log
@Controller
@AllArgsConstructor
public class WebController {

  // handlebars-spring-boot-starter 덕분에 컨트롤러에서 문자열을 반환할때
  // 앞의 path와 뒤의 파일 확장자는 자동으로 지정
  // (prefix: src/main/resources/templates, suffix: .hbs)
  @GetMapping("/")  // = @RequestMapping(value="/", method = RequestMethod.GET)
  public String main() {
    log.info("==> main");
    return "main";
  }

}
