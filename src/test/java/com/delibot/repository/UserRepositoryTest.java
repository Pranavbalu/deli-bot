package com.delibot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.delibot.DeliBotApplication;
import com.delibot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
/*
@RunWith(SpringRunner.class)
@SpringBootTest(classes={DeliBotApplication.class})
@RunWith(SpringRunner.class)
@WebMvcTest(UserRepository.class)
@ContextConfiguration(classes={DeliBotApplication.class})*/

/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TestEntityManager.class, UserRepository.class })
@EnableConfigurationProperties*/
public class UserRepositoryTest {

   /* @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmailId("pranavbalu14@gmail.com");
        user.setPassword("demo123");
        user.setFirstName("Pranav");
        user.setLastName("B");
        user.setUserName("user");

        entityManager.persist(user);

        User existUser = repo.findByUserName("user");

        assertThat(user.getEmailId()).isEqualTo(existUser.getEmailId());

    }*/
}