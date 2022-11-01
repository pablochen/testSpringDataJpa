package com.study.qdsl.batch;

import com.study.qdsl.batch.domain.BatchSetting;
import com.study.qdsl.batch.domain.BatchSettingDetail;
import com.study.qdsl.batch.repository.BatchSettingDetailRepository;
import com.study.qdsl.batch.repository.BatchSettingRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class BatchApplicationTests {

	@Autowired
	BatchSettingRepository batchSettingRepository;

	@Autowired
	BatchSettingDetailRepository batchSettingDetailRepository;

	@Test
	void testBatchSetting() {
		/**
		 * Insert
		 */
		String person = "newbie";
		LocalDate now = LocalDate.now();
		BatchSetting batchSetting = BatchSetting.builder()
				.settingName("테스트1번화면")
				.settingType("TABLEAU")
				.settingDescription("월 3회 돌아가 주십쇼")
				.createdBy(person)
				.createdAt(now)
				.lastUpdatedBy(person)
				.lastUpdatedAt(now)
				.build();

		batchSettingRepository.save(batchSetting);

		List<BatchSetting> batchSettingList = batchSettingRepository.findAllByUseYn("Y");
		System.out.println("인서트 후");
		batchSettingList.stream()
				.forEach(s -> {System.out.println(s.toString());});


		/**
		 * Update
		 */
		BatchSetting batchSetting1 = batchSettingRepository.findById(Integer.toUnsignedLong(3)).get();
		batchSetting1.setSettingName("변경되었소");

		batchSettingRepository.save(batchSetting1);

		System.out.println("업뎃 후");
		batchSettingList = batchSettingRepository.findAllByUseYn("Y");
		batchSettingList.stream()
				.forEach(s -> {System.out.println(s.toString());});

		/**
		 * Delete
		 */
		batchSetting1 = batchSettingRepository.findById(Integer.toUnsignedLong(7)).get();
		batchSetting1.setUseYn("N");

		batchSettingRepository.save(batchSetting1);

		System.out.println("딜리트 후");
		batchSettingList = batchSettingRepository.findAllByUseYn("Y");
		batchSettingList.stream()
				.forEach(s -> {System.out.println(s.toString());});

	}

	@Test
	void testBatchSettingDetail() {
		/**
		 * Insert
		 */
		String person = "newbie";
		LocalDate now = LocalDate.now();
		BatchSettingDetail batchSettingDetail = BatchSettingDetail.builder()
				.taskId("1번 태스크 아이디")
				.settingId(Integer.toUnsignedLong(2))
				.createdBy(person)
				.createdAt(now)
				.lastUpdatedBy(person)
				.lastUpdatedAt(now)
				.build();

		batchSettingDetailRepository.save(batchSettingDetail);

		batchSettingDetail = BatchSettingDetail.builder()
				.taskId("2번 태스크 아이디")
				.settingId(Integer.toUnsignedLong(2))
				.createdBy(person)
				.createdAt(now)
				.lastUpdatedBy(person)
				.lastUpdatedAt(now)
				.build();

		batchSettingDetailRepository.save(batchSettingDetail);

		batchSettingDetail = BatchSettingDetail.builder()
				.taskId("3번 태스크 아이디")
				.settingId(Integer.toUnsignedLong(2))
				.createdBy(person)
				.createdAt(now)
				.lastUpdatedBy(person)
				.lastUpdatedAt(now)
				.build();

		batchSettingDetailRepository.save(batchSettingDetail);


		List<BatchSettingDetail> batchSettingDetailList = batchSettingDetailRepository.findAllByUseYn("Y");
		System.out.println("인서트 후");
		batchSettingDetailList.stream()
				.forEach(s -> {System.out.println(s.toString());});


		/**
		 * Update
		 */
		BatchSettingDetail batchSettingDetail1 = batchSettingDetailRepository.findById(Integer.toUnsignedLong(2)).get();
		batchSettingDetail1.setTaskId("변경되었소");

		batchSettingDetailRepository.save(batchSettingDetail1);

		System.out.println("업뎃 후");
		batchSettingDetailList = batchSettingDetailRepository.findAllByUseYn("Y");
		batchSettingDetailList.stream()
				.forEach(s -> {System.out.println(s.toString());});

		/**
		 * Delete
		 */
		batchSettingDetail1 = batchSettingDetailRepository.findById(Integer.toUnsignedLong(1)).get();
		batchSettingDetail1.setUseYn("N");

		batchSettingDetailRepository.save(batchSettingDetail1);

		System.out.println("딜리트 후");
		batchSettingDetailList = batchSettingDetailRepository.findAllByUseYn("Y");
		batchSettingDetailList.stream()
				.forEach(s -> {System.out.println(s.toString());});
	}

}
