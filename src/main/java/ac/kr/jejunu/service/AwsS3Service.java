package ac.kr.jejunu.service;

import ac.kr.jejunu.repository.AwsS3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by replay on 2017. 5. 30..
 */

@Service
public class AwsS3Service {
    @Autowired
    AwsS3Repository awsS3Repository;



    public String uploadImage(String filePath,String id){
        String subDir = id+"/images";

        String imageUrl = awsS3Repository.uploadFile(filePath,subDir);
        return imageUrl;
    }

    public String uploadApk(String filePath, String id){
        String subDir = id+"/apk";

        String imageUrl = awsS3Repository.uploadFile(filePath,subDir);
        return imageUrl;
    }
}
