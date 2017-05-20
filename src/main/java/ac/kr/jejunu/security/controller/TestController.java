package ac.kr.jejunu.security.controller;

import ac.kr.jejunu.security.model.LoginUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Boobby on 17-5-19.
 */
@Controller
public class TestController {
    // 이거 그냥 개대충 만들어본거다~~~~ 나중에 다 바꿀거다~~~~~~ 아아아아아아아~~~
    @ResponseBody
    @RequestMapping(path="/", produces="text/html")
    public String index()
    {
        return
                "index page<br/><a href=\"/mypage\">mypage</a>";
    }

    @ResponseBody
    @RequestMapping(path="/mypage", produces="text/html")
    public String mypage(@AuthenticationPrincipal LoginUserDetails userDetails)
    {
        return
                "is mypage !!<br/>" +
                        userDetails.getNo() + " : " + userDetails.getUsername() +
                        "<br/><a href=\"/logout\">logout</a>";
    }
}
