package com.study.qdsl.batch.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(
        name = "BATCH_SETTING_ID_SEQ_GENERATOR",
        sequenceName = "BATCH_SETTING_ID_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 1,
        allocationSize = 1)
public class BatchSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "BATCH_SETTING_ID_SEQ_GENERATOR")
    private long id;

    @Column
    private String settingName;

    @Column
    private String settingDescription;

    @Column
    private String settingType;

    @Column
    private String useYn;

    @Column
    private String createdBy;

    @Column
    private LocalDate createdAt;

    @Column
    private String lastUpdatedBy;

    @Column
    private LocalDate lastUpdatedAt;

    @Builder
    public BatchSetting(String settingName, String settingDescription, String settingType
            , String createdBy, LocalDate createdAt, String lastUpdatedBy, LocalDate lastUpdatedAt){
        this.settingName = settingName;
        this.settingDescription = settingDescription;
        this.settingType = settingType;
        this.useYn = "Y";
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public String toString(){
        return this.id + ":" +
                this.settingName + ":" +
                this.settingDescription + ":" +
                this.settingType + ":" +
                this.useYn;
    }

}
