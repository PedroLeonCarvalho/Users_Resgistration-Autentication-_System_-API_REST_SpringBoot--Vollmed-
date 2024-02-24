package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta{
@Autowired
    private ConsultaRepository consultaRepository;

    public void validar (DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario= consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
if (medicoPossuiOutraConsultaNoMesmoHorario ) {
    throw new ValidacaoException("Medico ja possui outra consulta marcada para este horario");

}
    }

}
