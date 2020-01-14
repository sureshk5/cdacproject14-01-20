package exam.hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DataBaseProject extends JpaRepository<Guide, Integer> {
	
	
	//@Query("SELECT u FROM Mobile u WHERE u.imeino = 3")
	//Collection<Mobile> findAllActiveUsers();
@Modifying	
@Transactional
@Query(value="insert into Guideregister (first_name,last_name,gender,gmail,address_proof,contact_number,user_id,password) values(:first_name,:last_name,:gender,:gmail,:address_proof,:contact_number,:user_id,:password)",nativeQuery=true)
	public void insertDB(@Param("first_name")String first_name, @Param("last_name")String last_name, @Param("gender")String gender, @Param("gmail")String gmail, @Param("address_proof")String address_proof, @Param("contact_number")String contact_number, @Param("user_id")String user_id, @Param("password")String password);

@Query("FROM Guide WHERE user_id= :user_id")
Guide findByUser(@Param("user_id") String user_id);
}
