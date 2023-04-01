package com.example.controlwork7.service;

import com.example.controlwork7.dao.ClientDao;
import com.example.controlwork7.dto.ClientDTO;
import com.example.controlwork7.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    private final ClientDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Client> optUser = userDao.findClientByEmail(email);
        if (optUser.isEmpty()) {
            throw new UsernameNotFoundException("Not found");
        }
        return optUser.get();
    }

    public List<ClientDTO> getListOfUsers() {
        List<Client> userList = userDao.getClients();
        return userList.stream().map(ClientDTO::from).collect(Collectors.toList());
    }

    public boolean userExists(String name) {
        List<ClientDTO> list = getListOfUsers();
        for (var user : list) {
            if (user.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public ClientDTO registerNewClient(ClientDTO clientDTO, String password) {
        password = passwordEncoder.encode(password);
        Client client = Client.builder()
                .id(clientDTO.getId())
                .name(clientDTO.getName())
                .email(clientDTO.getEmail())
                .password(password)
                .enabled(clientDTO.isEnabled())
                .build();
        userDao.save(client);
        return ClientDTO.from(client);
    }
}
