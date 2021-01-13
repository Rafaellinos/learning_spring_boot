package com.rafaellinos.demo.services;

import com.rafaellinos.demo.domain.User;
import com.rafaellinos.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired // procura o user repository automagicamente e instancia o objeto repo
    // Também conhecido como injeção de dependência
    // Injeção de dependência: Instância da classe vem de fora pra dentro
    // Autowired: Instância automaticamente
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}
