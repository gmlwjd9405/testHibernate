package testHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	
//	@ManyToMany(mappedBy="authors", cascade = CascadeType.ALL)
//	private Set<Book> books = new HashSet<Book>();
}
