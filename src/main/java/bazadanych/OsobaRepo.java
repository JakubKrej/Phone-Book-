package bazadanych;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OsobaRepo extends JpaRepository<Osoba, Integer> {

    List<Osoba> findAllBynazwisko(String wyszukaj);
}

