package jdev.mentoria.lojavirtual.loja_virtual_mentoria.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Tabela não vai existir no banco de dados
@SequenceGenerator(
        name = "seq_pessoa",
        sequenceName = "seq_pessoa",
        allocationSize = 1,
        initialValue = 1
)
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = -2200068902415652578L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    @OneToMany(
            mappedBy = "pessoa",
            orphanRemoval = true, //apagou pessoa, apaga os endereços
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY // Só carrega quando getEndereco é chamado
    )
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
