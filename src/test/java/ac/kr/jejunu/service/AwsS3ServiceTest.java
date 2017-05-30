package ac.kr.jejunu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by replay on 2017. 5. 30..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:/application-local.properties")
@Transactional
public class AwsS3ServiceTest {
    @Autowired
    AwsS3Service awsS3Service;

    @Test
    public void uploadImageTest(){
        String filePath = "/Users/replay/Documents/workspace/somethinglikethat/tmp/prototype/src/main/resources/static/images/logo179x200.png";
        String id = "test";

        awsS3Service.uploadImage(filePath,id);
    }
}
