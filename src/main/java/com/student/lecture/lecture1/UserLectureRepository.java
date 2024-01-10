package com.student.lecture.lecture1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLectureRepository extends JpaRepository<UserEntity, Long> {
}
