package br.ufc.vaccinapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.vaccinapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findFirstByCpf(String cpf );
}
