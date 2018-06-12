package com.efavarin.marmitex.api;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("api")
public class ApiResource {
    
    @Inject
    private PratoResource pratoResource;
    @Inject
    private EntidadeResource entidadeResource;
    
    @Path("pratos")
    public PratoResource pratoResource(){
        return pratoResource;
    }
    
    @Path("entidades")
    public EntidadeResource entidadeResource(){
        return entidadeResource;
    }
    
}

