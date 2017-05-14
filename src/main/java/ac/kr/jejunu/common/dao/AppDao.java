package ac.kr.jejunu.common.dao;

import ac.kr.jejunu.common.model.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by replay on 2017. 5. 14..
 */

@Repository
public interface AppDao extends JpaRepository<App, Long> {}
