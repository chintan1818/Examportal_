package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import com.exam.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private  UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;



	public static void main(String[] args) throws Exception {

		SpringApplication.run(ExamserverApplication.class, args);





	}

	@Override
	public void run(String... args) throws Exception {




//		System.out.println("starting code```````````");
//
//		User user=new User();
//		user.setUserName("chi");
//		user.setEmail("abc");
//		user.setFirstName("chintan");
//		user.setLastName("mendpara");
//		user.setPassword(bCryptPasswordEncoder.encode("aaa"));
//		user.setPhone("97263");
//
//		Role role = new Role();
//		role.setRoleId(1);
//		role.setRoleName("ADMIN");
//
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		Set<UserRole> setUserRole = new HashSet<>();
//		setUserRole.add(userRole);
//		user.setUserRoles(setUserRole);
//
//
//
//
//		User user1= userService.createUser(user,setUserRole);
//		System.out.println(user1.toString());

	}
}
