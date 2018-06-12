package com.efavarin.marmitex.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "entidades", schema = "cadastros")
@SequenceGenerator(name = "seq_entidades", sequenceName = "seq_entidades", allocationSize = 1, schema = "cadastros")
public class Entidade implements EntityId<Long> {

    @Id
    @Column(name = "id_entidades")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_entidades")
    private Long id;

    @Column(name = "nome", length = 80)
    @NotNull
    private String nome;

    /* @Max(1)
    @NotNull
    @Column(name = "ativo")
    private boolean ativo = true;
    */

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

   /* public boolean isAtivo() {
        return ativo;
    }*/

    @Override
    public int hashCode() {
        /* Método usado para comparação */
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        /* Método usado para comparação */
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entidade other = (Entidade) obj;
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
        return "Entidade{" + "id=" + id + ", nome=" + nome + '}';
    }

     public static class builder extends AbstractBuilder<Entidade, Entidade.builder> { /*usado na contrução da classe. nesse caso não precisa implementar os setter dessa classe*/

        protected builder(Entidade entity) {
            super(entity);
        }

        public static builder create() {
            return new builder(new Entidade());
        }

        public static builder fron(Entidade p) {
            return new builder(p);
        }
        
        public builder nome(String nome) {
            entity.nome = nome;
            return this;
        }
        
        /*public builder ativo(boolean ativo) {
            entity.ativo = ativo;
            return this;
        } */

    } 
}
