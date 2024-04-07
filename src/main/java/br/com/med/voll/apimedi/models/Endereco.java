package br.com.med.voll.apimedi.models;

import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @NotEmpty
    private String logradouro;

    @NotEmpty
    private String bairro;

    @NotEmpty
    @Length(min = 8, max = 8)
    private String cep;

    private String numero;
    private String complemento;

    @NotEmpty
    private String cidade;
    
    @NotEmpty
    private String uf;
}
