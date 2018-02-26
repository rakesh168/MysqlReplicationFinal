package com.example.demo;



import org.hibernate.exception.GenericJDBCException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


	@SuppressWarnings("deprecation")
	@RunWith(SpringRunner.class)
    @TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
    @ContextConfiguration(classes = DemoApplication.class)
	@SpringBootTest
    @Transactional(readOnly = true)
    public class DemoApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = false)
     @Test
     @Repeat(value = 10)
     public void testReplicationWrite() {
    	User user = new User("Rakesh","1234");
    	userRepository.save(user);
     }
    
     @Transactional(readOnly = true)
     @Test(expected = GenericJDBCException.class)
     public void testReplicationWriteFail() {
    	 User user = new User("Manish","1234");
    	 userRepository.save(user);
     }
     
     @Transactional(readOnly = true)
     @Test
     @Repeat(value = 100)
     public void testReplicationRead() {
    	 userRepository.findByName("Alice");
     }
    }


