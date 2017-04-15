package testHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {

	// PK�� ���, Ű���� �ڵ����� ����
	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int id;

	private String name;

	// bidiretional�� ���� ���� ������ ���
	// Category ���� �� Child�� Product�� ����
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Product> products = new HashSet<Product>();
}
