package testHibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		// configure(): ���� ����(hibernate.cfg.xml)�� �������� �����Ѵ�.
		// buildSessionFactory(): SessionFactory�� �ϳ� ����
		sessionFactory = new Configuration().configure().buildSessionFactory();

		Book springBook = new Book();
		springBook.setTitle("������ ���α׷���");

		Book hibernateBook = new Book();
		hibernateBook.setTitle("���̹�����Ʈ ���α׷���");

		Book htmlBook = new Book();
		htmlBook.setTitle("HTML/CSS/JavaScript");

		Author authorKim = new Author();
		authorKim.setName("�賲��");

		Author authorLee = new Author();
		authorLee.setName("���繮");

		Author authorHwang = new Author();
		authorHwang.setName("Ȳ����");

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

		// Session ����
		Session session = sessionFactory.openSession();
		// DB�� ��� save�� �ϴ� ��� Transaction�� �ʿ�
		Transaction tx = session.beginTransaction();

		// Parent�� Book ���� �� cascade�� ���� Child�� Author�� ����
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
		 * // Session ���� Session session = sessionFactory.openSession(); // DB��
		 * ��� save�� �ϴ� ��� Transaction�� �ʿ� Transaction tx =
		 * session.beginTransaction();
		 * 
		 * //Parent ���� �� cascade�� ���� Child�� License�� ���� session.save(person1);
		 * session.save(person2);
		 * 
		 * tx.commit(); session.close();
		 */

		/*
		 * Category category1 = new Category(); category1.setName("Computer");
		 * 
		 * Category category2 = new Category(); category2.setName("Car");
		 * 
		 * // ���� ���� ������ ȣ�� Product product1 = new Product();
		 * product1.setName("��Ʈ��1"); product1.setPrice(2000);
		 * product1.setDescription("Awesome Notebook");
		 * product1.setCategory(category1); // ��ü�� ���� reference category1. ���߿�
		 * FK�� �ٲ��.
		 * 
		 * category1.getProducts().add(product1);
		 * 
		 * Product product2 = new Product(); product2.setName("��Ʈ��2");
		 * product2.setPrice(300); product2.setDescription("Powerful Notebook");
		 * product2.setCategory(category1); // ��ü�� ���� reference category1. ���߿�
		 * FK�� �ٲ��.
		 * 
		 * category1.getProducts().add(product2);
		 * 
		 * Product product3 = new Product(); product3.setName("�ҳ�Ÿ");
		 * product3.setPrice(10000); product3.setDescription("�������� �ڵ���");
		 * product3.setCategory(category2); // ��ü�� ���� reference category1. ���߿�
		 * FK�� �ٲ��.
		 * 
		 * category2.getProducts().add(product3);
		 * 
		 * // Session ���� Session session = sessionFactory.openSession(); // DB��
		 * ��� save�� �ϴ� ��� Transaction�� �ʿ� Transaction tx =
		 * session.beginTransaction();
		 * 
		 * session.save(category1); session.save(category2);
		 * 
		 * tx.commit(); session.close();
		 */
	}
}
