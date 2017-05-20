package ac.kr.jejunu.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by replay on 2017. 5. 14..
 */

@Entity
@Data
public class App {
    @Id
    @GeneratedValue
    private Long app_no;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "uploader_no", referencedColumnName = "user_no")
    private StudentInfo studentInfo;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "version", length = 20, nullable = false)
    private String version;

    @Column(name = "volume", length = 11, nullable = false)
    private Integer volume;

    @ManyToOne
    @JoinColumn(name = "category_no")
    private Category category;

    @Column(name = "storage", length = 256, nullable = false)
    private String storage;

    @Column(name = "view_count", length = 11)
    private Integer view_count;

    @Column(name = "download_count", length = 11)
    private Integer download_count;

    @Column(name = "stared", length = 11)
    private Integer stared;

    @Column(name = "fund_goal", length = 11, nullable = false)
    private Integer fund_goal;

    @Column(name = "fund_amount", length = 11)
    private Integer fund_amount;

    @Column(name = "register_date")
    private Date register_date;

    @Column(name = "update_date")
    private Date update_date;
}
