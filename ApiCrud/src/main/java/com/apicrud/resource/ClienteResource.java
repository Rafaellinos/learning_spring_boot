package com.apicrud.resource;

import com.apicrud.domain.Cliente;

import java.util.List;

public interface ClienteResource {

    public List<Cliente> findAll(String nome);

    public Cliente findById(Long id);

    public Cliente create(Cliente cliente);

    public Cliente update(Cliente novoCliente, Long id);

    public void delete(Long id);
}
