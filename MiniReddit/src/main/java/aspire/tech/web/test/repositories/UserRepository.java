package aspire.tech.web.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aspire.tech.web.test.entites.User;

/*
 * JPA repository is there for the CRUD operations
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	/*
	 * This works because the 'findBy' gets from Spring and after it the property
	 * and it understands alone that username exists in User table
	 */
	
	User findByUsername(String username);			
													
}
