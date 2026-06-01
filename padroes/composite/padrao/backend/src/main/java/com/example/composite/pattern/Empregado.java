package com.example.composite.pattern;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Desenvolvedor.class, name = "desenvolvedor"),
    @JsonSubTypes.Type(value = Gerente.class, name = "gerente"),
    @JsonSubTypes.Type(value = Departamento.class, name = "departamento")
})
public interface Empregado {
    String getNome();
    double getSalario();
    void mostrarDetalhes();
}

