package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends JpaRepository<City,Integer> {
}
