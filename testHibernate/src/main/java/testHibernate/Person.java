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
	// PK로 사용, 키값을 자동으로 생성
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private long id;

	private String firstName;
	private String lastName;

	// bidiretional
	// Person 저장 시 Child인 License도 저장
	@OneToOne(mappedBy="person", cascade = CascadeType.ALL)
	private License license;
}
