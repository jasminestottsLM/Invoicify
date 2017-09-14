package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.springframework.security.core.GrantedAuthority;

public class UserModelTest {

    @Test
    public void test_all_gets_and_sets() {
        new BeanTester().testBean(User.class);
    } 
    
    @Test
    public void test_isAccountNonExpired_is_true() {
    	User testUser = new User();
    	
    	assertThat(testUser.isAccountNonExpired()).isEqualTo(true);
    }
    
    @Test
    public void test_isAccountNonLocked_is_true() {
    	User testUser = new User();
    	
    	assertThat(testUser.isAccountNonLocked()).isEqualTo(true);
    }  
    
    @Test
    public void test_isCredentialsNonExpired_is_true() {
    	User testUser = new User();
    	
    	assertThat(testUser.isCredentialsNonExpired()).isEqualTo(true);
    } 
    
    @Test
    public void test_isEnabled_is_true() {
    	User testUser = new User();
    	
    	assertThat(testUser.isEnabled()).isEqualTo(true);
    } 
    
    @Test
    public void test_getAuthorities_returns_nothing_if_no_roles() {
    	User testUser = new User();
    	testUser.setRoles(new ArrayList<UserRole>());
    	
    	Collection<? extends GrantedAuthority> actual = testUser.getAuthorities();
    	
    	assertThat(actual).hasSize(0); 	
    }
    
    @Test
    public void test_getAuthorities_returns_stuff() {
    	ArrayList<UserRole> testList = new ArrayList<UserRole>();
    	testList.add(new UserRole("Test", null));
    	User testUser2 = new User();
    	testList.add(new UserRole("Test2", testUser2));
    	User testUser = new User();
    	testUser.setRoles(testList);
    	
    	Collection<? extends GrantedAuthority> actual = testUser.getAuthorities();
    	
    	List<String> actualAuthorityNames = actual.stream().map(x -> x.getAuthority()).collect(Collectors.toList());
    	assertThat(actualAuthorityNames).hasSize(2); 	
    	assertThat(actualAuthorityNames).contains("ROLE_Test", "ROLE_Test2");
    }
}
