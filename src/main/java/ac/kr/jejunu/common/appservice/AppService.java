package ac.kr.jejunu.common.appservice;

import ac.kr.jejunu.common.dao.AppDao;
import ac.kr.jejunu.common.model.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by replay on 2017. 5. 14..
 */

@Service
public class AppService {
    @Autowired
    private AppDao appDao;

    public List<App> list(){
        return appDao.findAll();
    }
}
