package p3.jdbctemplate.dao;

import java.util.List;
import java.util.Optional;


import p3.jdbctemplate.model.Cat;
import p3.jdbctemplate.dao.JpaRepositoryDAO;

public interface CatDAO extends JpaRepositoryDAO<Cat,Long> {
	public Optional<List<Cat>> findByType(String type);
	public boolean deleteById(Long id);

}
