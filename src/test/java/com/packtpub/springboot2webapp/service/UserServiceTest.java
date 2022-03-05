package com.packtpub.springboot2webapp.service;

import com.packtpub.springboot2webapp.model.User;
import com.packtpub.springboot2webapp.repo.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

/**
 * @author Shazin Sadakath
 */
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void init() {
        this.userService = new UserService(userRepository);
    }

    @Test
    public void getAllCommentsForToday_HappyPath_ShouldReturn1Comment() {
        // Given
        User user = new User();
        user.setUsername("shazin");
        user.setPassword("sha908");
        user.setRole("USER");

        when(userRepository.findByUsername("shazin")).thenReturn(user);

        // When
        UserDetails actual = userService.loadUserByUsername("shazin");

        // Then
        verify(userRepository, times(1)).findByUsername("shazin");
    }

}
