package ac.kr.jejunu.repository;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.SystemPropertiesCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;

/**
 * Created by replay on 2017. 5. 30..
 */
@Repository
public class AwsS3Repository {
    @Value("${aws.accessKeyId}")
    String accessKeyId;
    @Value("${aws.secretKey}")
    String secretKey;

    public String uploadFile(String filePath, String subDir) {
        File file = new File(filePath);

        String existingBucketName = "somthinglikethat";
        String fileName =  file.getName();

        System.setProperty("aws.accessKeyId",accessKeyId);
        System.setProperty("aws.secretKey",secretKey);
        AmazonS3 amazonS3  = new AmazonS3Client(new BasicAWSCredentials(accessKeyId, secretKey));


        if (amazonS3 != null) {
            try {
                PutObjectRequest putObjectRequest =
                        new PutObjectRequest(existingBucketName +"/"+ subDir/*sub directory*/, fileName, file);
                putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead); // file permission
                amazonS3.putObject(putObjectRequest); // upload file

            } catch (AmazonServiceException ase) {
                ase.printStackTrace();
            } finally {
                amazonS3 = null;
            }
        }
        return "https://s3.ap-northeast-2.amazonaws.com/"+existingBucketName+"/"+subDir+"/"+fileName;
    }
}

