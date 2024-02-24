package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {
    public void validar (DadosAgendamentoConsulta dados) {
        var domingo = dados.data().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDeAbrirAClinica = dados.data().getHour() < 7;
        var depoisDoFechamento = dados.data().getHour()>18;
        if(domingo || antesDeAbrirAClinica || depoisDoFechamento) {
            throw new ValidacaoException(" Fora do horário de funcionamento");
        }



    }
}
