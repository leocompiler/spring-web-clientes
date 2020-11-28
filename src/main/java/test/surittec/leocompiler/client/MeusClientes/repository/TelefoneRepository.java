package test.surittec.leocompiler.client.MeusClientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.surittec.leocompiler.client.MeusClientes.model.Endereco;
import test.surittec.leocompiler.client.MeusClientes.model.Telefones;

@Repository
public interface  TelefoneRepository extends JpaRepository<Telefones, Long>{

}
