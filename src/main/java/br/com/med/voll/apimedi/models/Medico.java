package br.com.med.voll.apimedi.models;

import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String nome;
    
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String telefone;

    @NotEmpty
    @Length(min = 4, max = 6)
    private String crm;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Especialidade especialidade;

    private Boolean ativo;

    @Embedded
    @Valid
    @NotNull
    private Endereco endereco;


    public void excluir() {
        this.ativo = false;
    }
}
