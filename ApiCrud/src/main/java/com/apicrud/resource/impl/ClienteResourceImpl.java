package com.apicrud.resource.impl;

import com.apicrud.domain.Cliente;
import com.apicrud.repository.ClienteRepository;
import com.apicrud.resource.ClienteResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResourceImpl implements ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> findAll() {
//        Cliente cliente1 = Cliente.builder()
//                .id(1L)
//                .nome("Rafael")
//                .dataNascimento(new Date(1990, Calendar.DECEMBER, 5))
//                .build();
//
//        Cliente cliente2 = Cliente.builder()
//                .id(2L)
//                .nome("Yasmin")
//                .dataNascimento(new Date(1990, Calendar.JUNE, 20))
//                .build();
//
//        List<Cliente> listaClientes = Arrays.asList(cliente1, cliente2);
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@RequestBody Cliente novoCliente, @PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(novoCliente.getNome());
                    cliente.setDataNascimento(novoCliente.getDataNascimento());
                    return clienteRepository.save(cliente);
                })
                .orElseGet(() -> this.create(novoCliente));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}
