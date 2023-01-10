package com.bitc.reactasyncserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// CORS 오류 : (Cross Origin resource sharing), 동일한 주소 내에서만 리소스를 공유할 수 있음
// 스프링에서는 CORS 허용을 위해서 @CrossOrigin 어노테이션을 사용하여 처리함
// @CrossOrigin : 해당 어노테이션을 사용하면 지정한 도메인에 대해서 접근을 허용함
// @CrossOrigin 어노테이션은 메소드, 클래스, configurer 에 대해서 설정할 수 있음
// 메소드에 사용 시 지정한 메소드만 접근을 허용
// 클래스에 사용 시 지정한 컨트롤러에 대해서만 접근을 허용
// configurer 에 사용 시 모든 곳에 접근을 허용
// 옵션으로 origins 에 접근할 서버의 주소르 입력함

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4000"})
@RestController
@RequestMapping("/async")
public class AsyncServerController {

    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value = "/data1", method = RequestMethod.POST)
    public String asyncData1() throws Exception {
        return "서버와 통신 성공";
    }

    @RequestMapping(value = "/sendDataGet", method = RequestMethod.GET)
    public Object sendDataGet() throws Exception {
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        result.put("data", "");

        return result;
    }

    @RequestMapping(value = "/sendDataPost", method = RequestMethod.POST)
    public Object sendDataPost(@RequestParam("id") String id, @RequestParam("pw") String pw) throws Exception {
        Map<String, Object> user = new HashMap<>();
        user.put("id", "tester1");
        user.put("pw", "asdf1234");

        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        result.put("data", user);

        return result;
    }

    @RequestMapping(value = "/sendDataPut", method = RequestMethod.PUT)
    public Object sendDataPut(@RequestParam("idx") int idx) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");

        return result;
    }

    @RequestMapping(value = "/sendDataDelete", method = RequestMethod.DELETE)
    public Object sendDataDelete(@RequestParam("idx") int idx) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        result.put("idx", idx);

        return result;
    }
}
