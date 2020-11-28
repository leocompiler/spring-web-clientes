package test.surittec.leocompiler.client.MeusClientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.surittec.leocompiler.client.MeusClientes.model.Emails;
import test.surittec.leocompiler.client.MeusClientes.model.Endereco;

@Repository
public interface  EmailsRepository extends JpaRepository<Emails, Long>{

}
