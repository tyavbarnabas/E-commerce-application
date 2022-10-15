package com.ecommerce;

import com.ecommerce.model.User;
import com.ecommerce.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UsersRepository repo;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public  void testCreateUser(){
        User user = new User();
        user.setEmail("alex@gmail.com");
        user.setPassword("alex2023");
        user.setFirstName("Alexander");
        user.setLastName("Hleb");

        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class,savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

}
