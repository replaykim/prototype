package ac.kr.jejunu;

import ac.kr.jejunu.service.AppService;
import ac.kr.jejunu.common.entity.App;
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

    @RequestMapping("/aaa")
    public String hello(ModelMap modelMap) {
        System.out.println("asdfasdf");
        List<App> apps = appService.list();
        modelMap.addAttribute("applist", apps);
        return "index";
    }
}
