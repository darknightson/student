package com.student.lecture.lecture1;

import com.student.lecture.UserDataBaseRepository;
import com.student.lecture.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserLectureService {

    private final UserLectureRepository userLectureRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Long save(UserDto userDto) {
        UserEntity transientUserEntity = UserEntity.createUser(userDto);
        UserEntity managedUserEntity = userLectureRepository.save(transientUserEntity);
        return managedUserEntity.getId();
    }

    @Transactional
    public void remove(Long id) {
        userLectureRepository.findById(id).ifPresent(userLectureRepository::delete);
    }

    public void findUser(Long id) {
        // 영속 상태
        UserEntity userEntity = userLectureRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));
        // 준영속 상태
        detach(userEntity);
    }

    public void detach(UserEntity userEntity) {
        entityManager.detach(userEntity);
    }

    public Long update(Long id, UserDto userDto) {
        UserEntity userEntity = userLectureRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));
        userEntity.update(userDto);
        return userEntity.getId();
    }

    public boolean isIdentity(Long id) {
        UserEntity userEntity1 = userLectureRepository.findById(id).orElseThrow();
        UserEntity userEntity2 = userLectureRepository.findById(id).orElseThrow();
        return userEntity1 == userEntity2;
    }
}
