package kz.bitlab.SPRING_SPRINT_TASK_2.repositories;

import kz.bitlab.SPRING_SPRINT_TASK_2.model.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest,Long> {
    List<ApplicationRequest> findByHandledIsTrue();
    List<ApplicationRequest> findByHandledIsFalse();
}
