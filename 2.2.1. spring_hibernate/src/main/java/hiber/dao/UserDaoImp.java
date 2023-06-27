package hiber.dao;

import hiber.model.Car;
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

   private SessionFactory sessionFactory;

   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   public User getUserOfCarModelAndNumber(String model, Integer series){
      TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car WHERE model = :param1 AND series = :param2");
      query.setParameter("param1", model);
      query.setParameter("param2", series);
      Long in = query.getSingleResult().getId();
      TypedQuery<User> query2 = sessionFactory.getCurrentSession().createQuery("From User WHERE id = " + in);
      return query2.getSingleResult();
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
