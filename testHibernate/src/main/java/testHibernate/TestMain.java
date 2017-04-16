package testHibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		// configure(): 설정 파일(hibernate.cfg.xml)을 바탕으로 설정한다.
		// buildSessionFactory(): SessionFactory를 하나 생성
		sessionFactory = new Configuration().configure().buildSessionFactory();

		Book springBook = new Book();
		springBook.setTitle("스프링 프로그래밍");

		Book hibernateBook = new Book();
		hibernateBook.setTitle("하이버네이트 프로그래밍");

		Book htmlBook = new Book();
		htmlBook.setTitle("HTML/CSS/JavaScript");

		Author authorKim = new Author();
		authorKim.setName("김남윤");

		Author authorLee = new Author();
		authorLee.setName("이재문");

		Author authorHwang = new Author();
		authorHwang.setName("황기태");

		springBook.getAuthors().add(authorKim);
		springBook.getAuthors().add(authorLee);
		springBook.getAuthors().add(authorHwang);

		hibernateBook.getAuthors().add(authorKim);
		hibernateBook.getAuthors().add(authorLee);

		htmlBook.getAuthors().add(authorKim);
		htmlBook.getAuthors().add(authorHwang);

//		authorKim.getBooks().add(springBook);
//		authorKim.getBooks().add(hibernateBook);
//		authorKim.getBooks().add(htmlBook);
//
//		authorLee.getBooks().add(springBook);
//		authorLee.getBooks().add(hibernateBook);
//
//		authorHwang.getBooks().add(springBook);
//		authorHwang.getBooks().add(htmlBook);

		// Session 생성
		Session session = sessionFactory.openSession();
		// DB의 경우 save를 하는 경우 Transaction이 필요
		Transaction tx = session.beginTransaction();

		// Parent인 Book 저장 시 cascade에 의해 Child인 Author도 저장
		session.save(springBook);
		session.save(hibernateBook);
		session.save(htmlBook);
		
//		session.save(authorKim);
//		session.save(authorLee);
//		session.save(authorHwang);

		tx.commit();
		session.close();

		/*
		 * Person person1 = new Person(); person1.setFirstName("Heejeong");
		 * person1.setLastName("Kwon");
		 * 
		 * License license1 = new License();
		 * license1.setLicenseNumber("123456"); license1.setIssue_date(new
		 * Date()); license1.setPerson(person1); // unidirection
		 * 
		 * person1.setLicense(license1);
		 * 
		 * Person person2 = new Person(); person2.setFirstName("Alice");
		 * person2.setLastName("Lee");
		 * 
		 * License license2 = new License();
		 * license2.setLicenseNumber("456123"); license2.setIssue_date(new
		 * Date()); license2.setPerson(person2); // unidirection
		 * 
		 * person2.setLicense(license2);
		 * 
		 * // Session 생성 Session session = sessionFactory.openSession(); // DB의
		 * 경우 save를 하는 경우 Transaction이 필요 Transaction tx =
		 * session.beginTransaction();
		 * 
		 * //Parent 저장 시 cascade에 의해 Child인 License도 저장 session.save(person1);
		 * session.save(person2);
		 * 
		 * tx.commit(); session.close();
		 */

		/*
		 * Category category1 = new Category(); category1.setName("Computer");
		 * 
		 * Category category2 = new Category(); category2.setName("Car");
		 * 
		 * // 인자 없는 생성자 호출 Product product1 = new Product();
		 * product1.setName("노트북1"); product1.setPrice(2000);
		 * product1.setDescription("Awesome Notebook");
		 * product1.setCategory(category1); // 객체에 대한 reference category1. 나중에
		 * FK로 바뀐다.
		 * 
		 * category1.getProducts().add(product1);
		 * 
		 * Product product2 = new Product(); product2.setName("노트북2");
		 * product2.setPrice(300); product2.setDescription("Powerful Notebook");
		 * product2.setCategory(category1); // 객체에 대한 reference category1. 나중에
		 * FK로 바뀐다.
		 * 
		 * category1.getProducts().add(product2);
		 * 
		 * Product product3 = new Product(); product3.setName("소나타");
		 * product3.setPrice(10000); product3.setDescription("대중적인 자동차");
		 * product3.setCategory(category2); // 객체에 대한 reference category1. 나중에
		 * FK로 바뀐다.
		 * 
		 * category2.getProducts().add(product3);
		 * 
		 * // Session 생성 Session session = sessionFactory.openSession(); // DB의
		 * 경우 save를 하는 경우 Transaction이 필요 Transaction tx =
		 * session.beginTransaction();
		 * 
		 * session.save(category1); session.save(category2);
		 * 
		 * tx.commit(); session.close();
		 */
	}
}
