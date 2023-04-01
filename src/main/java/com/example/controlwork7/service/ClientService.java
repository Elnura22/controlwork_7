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
        Optional<Client> optUser = userDao.findUserByEmail(email);
        if (optUser.isEmpty()) {
            throw new UsernameNotFoundException("Not found");
        }
        return optUser.get();
    }

    public List<ClientDTO> getListOfUsers() {
        List<Client> userList = userDao.getUsers();
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

    public ClientDTO registerNewUser(ClientDTO userDTO, String password) {
        password = passwordEncoder.encode(password);
        Client user = Client.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(password)
                .enabled(userDTO.isEnabled())
                .build();
        userDao.save(user);
        return ClientDTO.from(user);
    }
}
