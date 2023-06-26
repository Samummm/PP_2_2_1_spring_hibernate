package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   public User getUserOfCarModelAndNumber(String model, Integer series){
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User WHERE car.model = :param1 AND car.series = :param2");
      query.setParameter("param1", model);
      query.setParameter("param2", series);
      return query.getSingleResult();
   }
   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
