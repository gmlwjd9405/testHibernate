package testHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Person {
	// PK�� ���, Ű���� �ڵ����� ����
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private long id;

	private String firstName;
	private String lastName;

	// bidiretional
	// Person ���� �� Child�� License�� ����
	@OneToOne(mappedBy="person", cascade = CascadeType.ALL)
	private License license;
}
