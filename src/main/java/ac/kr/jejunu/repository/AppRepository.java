package ac.kr.jejunu.repository;

import ac.kr.jejunu.common.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by replay on 2017. 5. 14..
 */

@Repository
public interface AppRepository extends JpaRepository<App, Long> {}
