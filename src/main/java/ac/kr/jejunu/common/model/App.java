package ac.kr.jejunu.common.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by replay on 2017. 5. 14..
 */

@Entity
@Data
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int app_no; // 식별자

    String name; // 앱의 이름

    @ManyToOne
    @JoinColumn(name = "uploader_no", referencedColumnName = "user_no")
    User user;
    String description; // 앱 설명
    String version; // 앱 버전
    int volume; // 앱 용량

    @ManyToOne
    @JoinColumn(name = "category_no", referencedColumnName = "category_no")
    Category category;

    String storage; // 앱 저장소 URL

    int view_count; // 조회수
    int download_count; // 다운로드 횟수
    int stared; // 별점수

    int fund_goal; // 펀딩 목표 금액
    int fund_amount;// 펀딩된 금액

    Date register_date;// 신규 업로드 일자
    Date update_date;// 최근 업데이트 일자
}
