package com.pofo.pofoapp.repository;

import com.pofo.pofoapp.domain.Follow;
import com.pofo.pofoapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * packageName    : com.pofo.pofoapp.user
 * fileName       : FollowRepository
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */
public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Query("select f from Follow f where f.follower.id = :followerId")
    List<Follow> findByFollowerId(@Param("followerId") Long followerId);
    @Query("select f from Follow f where f.followee.id = :followeeId")
    List<Follow> findByFolloweeId(@Param("followeeId") Long followeeId);

    @Query("select f from Follow f where f.follower.id = :followerId and f.followee.id = :followeeId")
    List<Follow> findAllByFollowerIdAndFolloweeId(
            @Param("followerId") Long followerId,
            @Param("followeeId") Long followeeId);
}
