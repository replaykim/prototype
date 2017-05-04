package ac.kr.jejunu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by highdali on 2017. 4. 30..
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String hello() {
        System.out.println("hello123");
        return "index";
    }
}
