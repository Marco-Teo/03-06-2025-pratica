package it.epicode.u5w1d1teoria.repository;

import it.epicode.u5w1d1teoria.bean.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToppingRepository extends JpaRepository<Topping, Long> {
    List<Topping> findByGlutenFreeTrue();
}

