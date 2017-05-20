package ac.kr.jejunu.service;

import ac.kr.jejunu.repository.AppRepository;
import ac.kr.jejunu.common.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by replay on 2017. 5. 14..
 */

@Service
@Transactional
public class AppService {
    @Autowired
    private AppRepository appRepository;

    public List<App> list(){
        return appRepository.findAll();
    }

    public App getApp(Long appNo) {
        return appRepository.findOne(appNo);
    }

    public App addApp(App app) {
        App app1 = appRepository.save(app);
        return app1;
    }
}
