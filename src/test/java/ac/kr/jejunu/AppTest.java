package ac.kr.jejunu;

import ac.kr.jejunu.common.entity.App;
import ac.kr.jejunu.common.entity.Category;
import ac.kr.jejunu.service.AppService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;

/**
 * Created by replay on 2017. 5. 20..
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Autowired
    AppService appService;

    @Test
    public void getAppList() {
        Long firstAppNo = 1l;
        Long secondAppNo = 2l;


        List<App> apps;
        apps = appService.list();

        assertThat(firstAppNo, is(apps.get(0).getApp_no()));
        assertThat(secondAppNo, is(apps.get(1).getApp_no()));
    }

    @Test
    public void getApp() {
        Long appNo = 1l;
        String appName = "campustore";

        App app = appService.getApp(appNo);

        assertThat(appNo, is(app.getApp_no()));
        assertThat(appName, is(app.getName()));
    }

    @Test
    public void addApp() {
        String appName = "앱이름";
        String version = "1.1.1";
        Integer volume = 500;
        Category category = new Category();
        category.setCategory_no(3l);
        Integer fundGoal = 3000000;

        App app = new App();
        app.setName(appName);
        app.setVersion(version);
        app.setVolume(volume);
        app.setCategory(category);
        app.setFund_goal(fundGoal);

        appService.addApp(app);
        App resultApp = appService.getApp(app.getApp_no());

        assertThat(version, is(resultApp.getVersion()));
        assertThat("비즈니스", is(resultApp.getCategory().getCategory_name()));
    }

}
