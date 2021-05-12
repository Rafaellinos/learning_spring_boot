package com.apicrud.resource;

import com.apicrud.domain.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

    @GetMapping
    public List<Cliente> hello() {
        Cliente cliente1 = Cliente.builder()
                .id(1L)
                .nome("Rafael")
                .dataNascimento(new Date(1990, Calendar.DECEMBER, 5))
                .build();

        Cliente cliente2 = Cliente.builder()
                .id(2L)
                .nome("Yasmin")
                .dataNascimento(new Date(1990, Calendar.JUNE, 20))
                .build();

        List<Cliente> listaClientes = Arrays.asList(cliente1, cliente2);
        return listaClientes;
    }
}
