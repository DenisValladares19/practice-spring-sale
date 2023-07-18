package com.example.sale.practice.service.impl;

import com.example.sale.practice.dto.ClientDTO;
import com.example.sale.practice.entity.Client;
import com.example.sale.practice.entity.User;
import com.example.sale.practice.exception.RequestException;
import com.example.sale.practice.repository.ClientRepository;
import com.example.sale.practice.repository.UserRepository;
import com.example.sale.practice.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl  implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClientDTO create(ClientDTO dto) {
        User user = new User();
        user.setEmail(dto.getUser().getEmail());
        user.setPassword(dto.getUser().getPassword());
        userRepository.save(user);

        Client client = modelMapper.map(dto, Client.class);
        client.setUser(user);
        clientRepository.save(client);

        return modelMapper.map(client, ClientDTO.class);
    }

    @Override
    public ClientDTO update(ClientDTO dto) {
        Client client = modelMapper.map(findById(dto.getId()), Client.class);

        client.setAge(dto.getAge());
        client.setName(dto.getName());
        client.setLastname(dto.getLastname());
        client.setBirthDay(dto.getBirthDay());

        clientRepository.save(client);

        return modelMapper.map(client, ClientDTO.class);
    }

    @Override
    public ClientDTO findById(Long idClient) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new RequestException("Client not found with id" + idClient));
        return modelMapper.map(client, ClientDTO.class);
    }

    @Override
    public void delete(Long idClient) {
        ClientDTO clientDTO = findById(idClient);
        clientRepository.deleteById(clientDTO.getId());
    }
}
