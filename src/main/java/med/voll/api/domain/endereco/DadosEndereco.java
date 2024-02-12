package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Embeddable
public record  DadosEndereco(
@NotBlank
String logradouro,
@NotBlank
String bairro,
@NotBlank
        @Pattern(regexp = "\\d{8}")
String cep,
@NotBlank
String cidade,
@NotBlank
String uf,
String complemento,
String numero) {
}
