package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Address;
import entities.Login;
import entities.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager em;

	
	
	@Override
	public User createUser(UserDTO dto) {
		User newUser = new User();
		Login newLogin = new Login();
		Address newAddress = new Address();
		
		newUser.setFirstName(dto.getFirstName());
		newUser.setLastName(dto.getLastName());
		newUser.setPhone(dto.getPhone());
		newUser.setEmail(dto.getEmail());
		
		newLogin.setUserEmail(dto.getEmail());
		newLogin.setPwd(dto.getPwd());
		
		newAddress.setStreet(dto.getStreet());
		newAddress.setCity(dto.getCity());
		newAddress.setState(dto.getState());
		newAddress.setZip(dto.getZip());
		
		em.persist(newAddress);
		em.flush();
		
		newUser.setAddress(newAddress);
		
		em.persist(newUser);
		em.persist(newLogin);
		em.flush();
		
		return newUser;
	}

	@Override
	public List<User> getAllUsers() {
		
		String query = "select u From User u";
		return em.createQuery(query, User.class).getResultList();
		
	}

	@Override
	public User getUserById(int id) {
		
        User u = em.find(User.class, id);
		return u;
	}
	
	@Override
	public UserDTO getUserDtoByUserId(int id) {
		UserDTO dto = new UserDTO();
		User user = getUserById(id);
		Address userAddress = user.getAddress();
		Login userLogin = em.find(Login.class, user.getEmail());
		
		dto.setUserId(user.getId());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setPhone(user.getPhone());
		dto.setEmail(user.getEmail());
		dto.setPermissionLevel(user.getPermissionLevel());
		dto.setPwd(userLogin.getPwd());
		dto.setStreet(userAddress.getStreet());
		dto.setCity(userAddress.getCity());
		dto.setState(userAddress.getState());
		dto.setZip(userAddress.getZip());
		
		return dto;
	}

	@Override
	public User userLogin(String userEmail, String userPass) {
		User u = null;
		String query = "SELECT l FROM Login l WHERE user_email = :userEmail";
		try {
			Login l = em.createQuery(query, Login.class).setParameter("userEmail", userEmail).getResultList().get(0);
			if (l.getUserEmail().equals(userEmail) && l.getPwd().equals(userPass)) {
				query = "SELECT u FROM User u WHERE email = :email";
				u = em.createQuery(query, User.class).setParameter("email", userEmail).getResultList().get(0);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	
		return u;
	}

	@Override
	public User updateUser(User user) {

        User managed = em.find(User.class, user.getId());
        managed = user;
        return managed;
	}
	
	

	@Override
	public User updateUserByDto(UserDTO dto) {
		
		User updateUser = getUserById(dto.getUserId());
		Address updateAddress = updateUser.getAddress();
		Login updateLogin = em.find(Login.class, updateUser.getEmail());
		
		updateUser.setFirstName(dto.getFirstName());
		updateUser.setLastName(dto.getLastName());
		updateUser.setPhone(dto.getPhone());
		updateUser.setEmail(dto.getEmail());
		updateUser.setPermissionLevel(dto.getPermissionLevel());
		
		updateAddress.setStreet(dto.getStreet());
		updateAddress.setCity(dto.getCity());
		updateAddress.setState(dto.getState());
		updateAddress.setZip(dto.getZip());
		
		updateLogin.setUserEmail(dto.getEmail());
		updateLogin.setPwd(dto.getPwd());
		
		em.persist(updateUser);
		em.persist(updateLogin);
		em.persist(updateAddress);
		em.flush();
		
		return updateUser;
	}

	@Override
	public boolean deleteUser(User user) {
		
		User u = em.find(User.class, user.getId());
		em.remove(u);
		if(em.find(User.class,user.getId()) == null) {
			return true;
		}
		return false;
	}

}
