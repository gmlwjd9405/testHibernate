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
public class Book {
	// PK로 사용, 키값을 자동으로 생성
	@Id
	@GeneratedValue
	@Column(name = "book_id")
	private long id;

	private String title;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "author_book", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
	private Set<Author> authors = new HashSet<Author>();
}
