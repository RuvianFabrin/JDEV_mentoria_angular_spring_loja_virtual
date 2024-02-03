package jdev.mentoria.lojavirtual.loja_virtual_mentoria.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "acesso")
@SequenceGenerator(
        name = "seq_acesso",
        sequenceName = "seq_acesso",
        allocationSize = 1,
        initialValue = 1
)
public class Acesso implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = -4707961877609421577L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
    private Long id;

    @Column(nullable = false)
    private String descricao; // Acesso ex: ROLE_ADMIN OU ROLE_SECRETARIOS

    @Override
    public String getAuthority() {
        return this.descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acesso acesso = (Acesso) o;
        return Objects.equals(id, acesso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
