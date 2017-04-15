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

	// PK로 사용, 키값을 자동으로 생성
	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int id;

	private String name;

	// bidiretional을 위해 집합 개념을 사용
	// Category 저장 시 Child인 Product도 저장
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Product> products = new HashSet<Product>();
}
