package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco dados) {
    this.logradouro = dados.logradouro();
    this.bairro = dados.bairro();
    this.cep= dados.cep();
    this.uf= dados.uf();
    this.cidade= dados.cidade();
    this.complemento= dados.complemento();
    this.numero= dados.numero();
    }

    public void atualizarDadosEndereco(DadosEndereco endereco) {
        if(endereco.logradouro() != null) {
            this.logradouro = endereco.logradouro();
        }
        if(endereco.bairro() != null) {
            this.bairro = endereco.bairro();
        }if(endereco.logradouro() != null) {
            this.logradouro = endereco.logradouro();
        }if(endereco.cep() != null) {
            this.cep = endereco.cep();
        }if(endereco.uf() != null) {
            this.uf = endereco.uf();
        }if(endereco.cidade() != null) {
            this.cidade = endereco.cidade();
        }if(endereco.numero() != null) {
            this.numero = endereco.numero();
        }
    }

    public void atualizarInformacoes(DadosEndereco dadosEndereco) {



    }
}
