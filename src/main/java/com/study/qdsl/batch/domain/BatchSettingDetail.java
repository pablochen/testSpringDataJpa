package com.study.qdsl.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(
        name = "BATCH_SETTING_DETAIL_ID_SEQ_GENERATOR",
        sequenceName = "BATCH_SETTING_DETAIL_ID_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 1,
        allocationSize = 1)
public class BatchSettingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "BATCH_SETTING_DETAIL_ID_SEQ_GENERATOR")
    private long id;

    @Column
    private String taskId;

    @Column
    private long settingId;

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
    public BatchSettingDetail(String taskId, long settingId
            , String createdBy, LocalDate createdAt, String lastUpdatedBy, LocalDate lastUpdatedAt){
        this.taskId = taskId;
        this.settingId = settingId;
        this.useYn = "Y";
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public String toString(){
        return this.id + ":" +
                this.taskId + ":" +
                this.settingId + ":" +
                this.useYn;
    }

}
