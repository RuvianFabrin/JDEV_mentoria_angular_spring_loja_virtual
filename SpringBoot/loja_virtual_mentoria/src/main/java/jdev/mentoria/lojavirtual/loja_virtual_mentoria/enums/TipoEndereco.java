package jdev.mentoria.lojavirtual.loja_virtual_mentoria.enums;

public enum TipoEndereco {
    COBRANCA("Cobrança"),
    ENTREGA("Entrega");

    private String descricao;


    TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao ;
    }
}
