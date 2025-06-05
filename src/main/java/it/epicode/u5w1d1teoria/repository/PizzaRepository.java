package it.epicode.u5w1d1teoria.repository;

import it.epicode.u5w1d1teoria.bean.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findByNome(String nome);

    @Query("SELECT p FROM Pizza p WHERE p.nome LIKE %?1%")
    List<Pizza> findByNomeContaining(String keyword);
}

