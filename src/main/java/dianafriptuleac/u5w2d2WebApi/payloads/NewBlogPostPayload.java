package dianafriptuleac.u5w2d2WebApi.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class NewBlogPostPayload {
    private String categoria;
    private String titolo;
    private String contenuto;
    private LocalDateTime tempoDiLettura;
}
