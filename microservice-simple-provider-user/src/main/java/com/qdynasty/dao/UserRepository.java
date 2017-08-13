/**
 * 
 */
package com.qdynasty.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qdynasty.entity.User;

/**
 * @author fei.qin
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

}
