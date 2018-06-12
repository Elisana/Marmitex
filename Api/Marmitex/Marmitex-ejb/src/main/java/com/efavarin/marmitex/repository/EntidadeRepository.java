/*Só consulta os dados no banco, não deve criar transações. As transações (para CRUD) devem ser feitas pela classe Service */
package com.efavarin.marmitex.repository;

import com.efavarin.marmitex.model.Entidade;
import javax.ejb.Stateless;

@Stateless /*notação para injeção dp EJB*/
public class EntidadeRepository extends AbstractRepository<Entidade, Long>{ 
    
}