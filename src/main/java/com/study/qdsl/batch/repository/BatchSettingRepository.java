package com.study.qdsl.batch.repository;

import com.study.qdsl.batch.domain.BatchSetting;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchSettingRepository extends JpaRepository<BatchSetting, Long> {
    List<BatchSetting> findAllByUseYn(String useYn);
}
