package testHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {
	// PK�� ���, Ű���� �ڵ����� ����
	@Id
	@GeneratedValue
	@Column(name = "author_id")
	private long id;

	private String name;
}
