package ac.kr.jejunu.service;

import ac.kr.jejunu.common.entity.App;
import ac.kr.jejunu.common.entity.Category;
import ac.kr.jejunu.service.AppService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;

/**
 * Created by replay on 2017. 5. 20..
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:/application-local.properties")
@Transactional
public class AppServiceTest {

    @Autowired
    AppService appService;

    @Test
    public void getAppList() {
        Long firstAppNo = 1l;
        Long secondAppNo = 2l;

        List<App> apps = appService.list();

        assertThat(apps.get(0).getNo(), is(firstAppNo));
        assertThat(apps.get(1).getNo(), is(secondAppNo));
    }

    @Test
    public void getApp() {
        Long appNo = 1L;
        String appName = "campustore";

        App app = appService.getApp(appNo);

        assertThat(app.getNo(), is(appNo));
        assertThat(app.getName(), is(appName));
    }

    @Test
    public void addApp() {
        String appName = "앱이름";
        String version = "1.1.1";
        Integer volume = 500;
        Integer fundGoal = 3000000;
        String categoryName = "비즈니스";

        Category category = new Category();
        category.setNo(3L);
        category.setName(categoryName);

        App app = new App();
        app.setName(appName);
        app.setVersion(version);
        app.setVolume(volume);
        app.setCategory(category);
        app.setFundGoalAmount(fundGoal);

        appService.addApp(app);
        App resultApp = appService.getApp(app.getNo());

        assertThat(resultApp.getVersion(), is(version));
        assertThat(resultApp.getCategory().getName(), is(categoryName));
    }
}
