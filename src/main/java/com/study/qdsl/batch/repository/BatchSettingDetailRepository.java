package com.study.qdsl.batch.repository;

import com.study.qdsl.batch.domain.BatchSetting;
import com.study.qdsl.batch.domain.BatchSettingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchSettingDetailRepository extends JpaRepository<BatchSettingDetail, Long> {
    List<BatchSettingDetail> findAllByUseYn(String useYn);
}
