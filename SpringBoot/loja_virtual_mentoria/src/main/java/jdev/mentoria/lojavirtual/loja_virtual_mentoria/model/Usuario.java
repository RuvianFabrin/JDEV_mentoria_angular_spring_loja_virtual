package jdev.mentoria.lojavirtual.loja_virtual_mentoria.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
@SequenceGenerator(
        name = "seq_usuario",
        sequenceName = "seq_usuario",
        allocationSize = 1,
        initialValue = 1
)
public class Usuario implements UserDetails {
    private static final long serialVersionUID = -4333746849916908648L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;

    private String login;
    private String senha;

    @Temporal(TemporalType.DATE)
    private Date dataAtualSenha;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_acesso",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {"usuario_id","acesso_id"},
                    name = "unique_acesso_user"
            ),
            joinColumns = @JoinColumn(
                    name = "usuario_id",
                    referencedColumnName = "id",
                    table = "usuario",
                    unique = false,
                    foreignKey = @ForeignKey(
                            name = "usuario_fk",
                            value = ConstraintMode.CONSTRAINT
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "acesso_id",
                    unique = false,
                    referencedColumnName = "id",
                    table = "acesso",
                    foreignKey = @ForeignKey(
                            name = "acesso_fk",
                            value = ConstraintMode.CONSTRAINT
                    )
            )
    )
    private List<Acesso> acessos;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aqui são os acessos (Perfil, papel, acessos, autoridades : ROLE_SECRETARIO, ROLE_ADMIN...)
        return this.acessos;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
