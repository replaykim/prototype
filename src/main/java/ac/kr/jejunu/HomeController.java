package ac.kr.jejunu;

import ac.kr.jejunu.common.appservice.AppService;
import ac.kr.jejunu.common.model.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by highdali on 2017. 4. 30..
 */

@Controller
public class HomeController {
    @Autowired
    private AppService appService;

    @RequestMapping("/")
    public String hello(ModelMap modelMap) {
        System.out.println("hello123");
        List<App> apps = appService.list();
        modelMap.addAttribute("applist", apps);
        return "index";
    }
}
