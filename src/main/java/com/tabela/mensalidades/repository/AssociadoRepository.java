package com.tabela.mensalidades.repository;

import com.tabela.mensalidades.entity.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    Associado findByCpf(String cpf);
}
