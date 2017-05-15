package ac.kr.jejunu.service;

import ac.kr.jejunu.dao.AppDao;
import ac.kr.jejunu.common.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
