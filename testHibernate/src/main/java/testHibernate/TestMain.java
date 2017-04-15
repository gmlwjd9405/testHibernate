package testHibernate;

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

		Category category1 = new Category();
		category1.setName("Computer");

		Category category2 = new Category();
		category2.setName("Car");

		// ���� ���� ������ ȣ��
		Product product1 = new Product();
		product1.setName("��Ʈ��1");
		product1.setPrice(2000);
		product1.setDescription("Awesome Notebook");
		product1.setCategory(category1); // ��ü�� ���� reference category1. ���߿� FK�� �ٲ��.
		
		category1.getProducts().add(product1);

		Product product2 = new Product();
		product2.setName("��Ʈ��2");
		product2.setPrice(300);
		product2.setDescription("Powerful Notebook");
		product2.setCategory(category1); // ��ü�� ���� reference category1. ���߿� FK�� �ٲ��.
		
		category1.getProducts().add(product2);

		Product product3 = new Product();
		product3.setName("�ҳ�Ÿ");
		product3.setPrice(10000);
		product3.setDescription("�������� �ڵ���");
		product3.setCategory(category2); // ��ü�� ���� reference category1. ���߿� FK�� �ٲ��.
		
		category2.getProducts().add(product3);

		// Session ����
		Session session = sessionFactory.openSession();
		// DB�� ��� save�� �ϴ� ��� Transaction�� �ʿ�
		Transaction tx = session.beginTransaction();

		session.save(category1);
		session.save(category2);

		tx.commit();
		session.close();
	}
}
