package test.surittec.leocompiler.client.MeusClientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.surittec.leocompiler.client.MeusClientes.model.Clientes;

@Repository
public interface  ClientesRepository extends JpaRepository<Clientes, Long>{

}