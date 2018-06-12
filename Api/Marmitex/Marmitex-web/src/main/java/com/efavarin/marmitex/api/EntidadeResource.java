package com.efavarin.marmitex.api;

import com.efavarin.marmitex.model.Entidade;
import com.efavarin.marmitex.repository.AbstractRepository;
import com.efavarin.marmitex.repository.EntidadeRepository;
import com.efavarin.marmitex.service.EntidadeService;
import com.efavarin.marmitex.service.service.AbstractService;
import javax.inject.Inject;


public class EntidadeResource extends AbstractCrudResource<Entidade, Long> {
    @Inject
    private EntidadeService service;
    @Inject
    private EntidadeRepository repository;

    @Override
    protected AbstractService<Entidade> getService() {
        return service;
    }

    @Override
    protected AbstractRepository<Entidade, Long> getRepository() {
        return repository;
    }   
}





