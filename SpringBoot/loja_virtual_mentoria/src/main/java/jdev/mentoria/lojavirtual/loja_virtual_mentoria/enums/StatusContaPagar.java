package jdev.mentoria.lojavirtual.loja_virtual_mentoria.enums;

public enum StatusContaPagar {
        COBRANCA("Pagar"),
        VENCIDA("Vencida"),
        ABERTA("Aberta"),
        QUITADA("Quitada"),
        RENEGOCIADA("Renegociada");

        private String descricao;


        private StatusContaPagar(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        @Override
        public String toString() {
            return this.descricao;
        }
    }
