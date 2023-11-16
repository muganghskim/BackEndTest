package com.backend.test.service;

import com.backend.test.model.JobHistory;
import com.backend.test.repository.JobHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class JobHistoryService {

    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    public List<JobHistory> getJobHistoryByEmployeeId(int employeeId) {
        try {
            return jobHistoryRepository.findByEmployeeId(employeeId);
        } catch (Exception e) {
            // 로그에 에러 기록
            log.error("사원 이력조회 서비스 중 에러 발생", e);
            return null;
        }
    }

}
