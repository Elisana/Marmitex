package com.efavarin.marmitex.api;

import com.efavarin.marmitex.model.Prato;
import com.efavarin.marmitex.repository.AbstractRepository;
import com.efavarin.marmitex.repository.PratoRepository;
import com.efavarin.marmitex.service.PratoService;
import com.efavarin.marmitex.service.service.AbstractService;
import javax.inject.Inject;

public class PratoResource extends AbstractCrudResource<Prato, Long> {

    @Inject
    private PratoService service;
    @Inject
    private PratoRepository repository;

    @Override
    protected AbstractService<Prato> getService() {
        return service;
    }

    @Override
    protected AbstractRepository<Prato, Long> getRepository() {
        return repository;
    }
}
