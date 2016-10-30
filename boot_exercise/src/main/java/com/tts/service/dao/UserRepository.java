package com.tts.service.dao;

import com.tts.entiy.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mike on 2016/10/30.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 使用@NamedQuery里定义的查询语句，而不是根据方法名称查询
     * @param id
     * @return
     */
    public User findById(int id);

    @Query(value = "SELECT u FROM User u WHERE name like :name%")
    public List<User> findByNameLike(@Param("name") String name);

    @Query(value = "SELECT u FROM User u WHERE name like ?1%")
    public List<User> findByNameAndSort(String name, Sort sort);

    @Query(value = "SELECT u FROM User u WHERE name like ?1%")
    public List<User> findOneByName(String name, Pageable pageable);

}
