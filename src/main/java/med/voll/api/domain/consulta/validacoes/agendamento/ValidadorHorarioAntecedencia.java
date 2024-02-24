package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var horarioConsulta = dados.data();
        var agora = LocalDateTime.now();
var diferencaEmMinutos = Duration.between(agora, horarioConsulta).toMinutes();

        if (diferencaEmMinutos <30) {
            throw new ValidacaoException( " COnsulta deve ser agendada com antecedencia mínima de 30 minutos");
        }


    }
}
