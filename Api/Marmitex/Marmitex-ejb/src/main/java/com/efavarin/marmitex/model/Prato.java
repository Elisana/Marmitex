package com.efavarin.marmitex.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pratos", schema = "cadastros")
@SequenceGenerator(name = "seq_pratos", sequenceName = "seq_pratos", allocationSize = 1, schema = "cadastros")
public class Prato implements EntityId<Long> {

    @Id
    @Column(name = "id_pratos")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pratos")
    private Long id;

    @Column(name = "nome", length = 80)
    @NotNull
    private String nome;

    @Column(name = "descricao", length = 200)
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "id_entidades")
    private Entidade entidade;
    

    /*@Max(1)
    @NotNull
    @Column(name = "ativo")
    @Convert(converter=BooleanToStringConverter.class)*/
    @Transient //indica que não é de banco
    private Boolean ativo = true;

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prato other = (Prato) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Prato.builder.create().nome("Teste").build();
        return "Prato{" + "id=" + id + ", nome=" + nome + '}';
    }

    public static class builder extends AbstractBuilder<Prato, Prato.builder> {

        protected builder(Prato entity) {
            super(entity);
        }

        public static builder create() {
            return new builder(new Prato());
        }

        public static builder fron(Prato p) {
            return new builder(p);
        }
      
        public builder nome(String nome) {
            entity.nome = nome;
            return this;
        }
        
        public builder descricao(String descricao) {
            entity.descricao = descricao;
            return this;
        }
        
        public builder ativo (boolean ativo){
            entity.ativo = ativo;
            return this;
        }        
       

    }

}
