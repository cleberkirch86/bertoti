package com.example.composite.pattern.controller;

import com.example.composite.pattern.Departamento;
import com.example.composite.pattern.Desenvolvedor;
import com.example.composite.pattern.Empregado;
import com.example.composite.pattern.Gerente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmpregadoController {

    @GetMapping("/empregados")
    public Empregado getEmpregados() {
        Empregado dev1 = new Desenvolvedor("Bob", 5000);
        Empregado dev2 = new Desenvolvedor("Charlie", 6000);
        Empregado gerente1 = new Gerente("Alice", 10000);

        Departamento subDeptoTI = new Departamento("Desenvolvimento");
        subDeptoTI.adicionar(dev1);
        subDeptoTI.adicionar(dev2);

        Departamento deptoGeral = new Departamento("TI Corporativo");
        deptoGeral.adicionar(gerente1);
        deptoGeral.adicionar(subDeptoTI);

        return deptoGeral;
    }
}
