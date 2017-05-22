package ac.kr.jejunu.web;

import ac.kr.jejunu.common.entity.App;
import ac.kr.jejunu.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by replay on 2017. 5. 20..
 */

@Controller
public class BoardContoller {
    @Autowired
    private AppService appService;

    @RequestMapping("/getapplist")
    public String hello(ModelMap modelMap) {
        System.out.println("asdfasdf");
        List<App> apps = appService.list();
        modelMap.addAttribute("applist", apps);
        return "index";
    }

    @RequestMapping("/registapp")
    public String registApp(ModelMap modelMap){
        App app = new App();
        modelMap.addAttribute("app", app);
        return "registapp";
    }

    @RequestMapping(value = "/save",  method= RequestMethod.POST)
    public String save(@ModelAttribute(value="app") App app){
        appService.addApp(app);

        return "redirect:getapplist";
    }

    @RequestMapping("/contentdetail")
    public String contentDetail(ModelMap modelMap, @RequestParam("app_no") Long appNo){
        App app = appService.getApp(appNo);

        modelMap.addAttribute("app", app);

        return "content";
    }
}
