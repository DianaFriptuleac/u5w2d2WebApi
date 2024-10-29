package dianafriptuleac.u5w2d2WebApi.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class NewAutorePayload {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
}
