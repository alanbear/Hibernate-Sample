import lombok.extern.log4j.Log4j;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @class HibernateTest
 * @author alan.hsieh
 * @purpose Hibernate Test
 * @createTime 2017/11/22 下午1:22
 */
@Log4j
public class HibernateTest {

	private static SessionFactory sessionFactory;

    /**
	 * @method main
	 * @purpose 主方法
	 * @author alan.hsieh
	 * @createTime 2017/11/21 下午4:35
	 * @param args no use
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{

        log.info("########## start execute HibernateTest ##########");

        Configuration config = new Configuration().configure();
		config.addAnnotatedClass(model.Employee.class);
		sessionFactory = config.buildSessionFactory();

		Employee user = new Employee();
		user.setId(1);
		user.setFirstName("a");
		user.setLastName("b");


		// 開啟Session，相當於開啟JDBC的Connection
		Session session = sessionFactory.openSession();
		// Transaction表示一組會話操作
		Transaction tx= session.beginTransaction();
		// 將物件映射至資料庫表格中儲存
		session.save(user);
		tx.commit();

		session.close();
        sessionFactory.close();

		log.info("########## execute HibernateTest end ##########");
	}


}
