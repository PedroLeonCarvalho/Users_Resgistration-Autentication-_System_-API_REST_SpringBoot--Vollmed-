package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedência implements ValidacaoCancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public void valida(DadosCancelamentoConsulta dados) {
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();
        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("A consulta deve ser cancelada com no  mínimo 24 horas de antecendecia!");
        }

    }
}
