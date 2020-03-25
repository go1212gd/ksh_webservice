package com.kshpart.www.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

/* ibatis, Mybatis 등에서  DAO 라고 부르는 DB layer 접근자.
// JPA에서는 Repository라고 함.
JpaRepository<Entity 클래스, PK타입> 이렇게 쓰면 CRUD 안 해도 됨.

*/