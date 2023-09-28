package com.example.spring_security.services;

import com.example.spring_security.models.Client;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service


public class ClientService {

    public ClientService(){
    }

    public Client getClientData(){
        Client fakeClient = Client.builder()
                .identifiant("Zosyme de Panopolis")
                .password("CorpusHermeticum")
                .build();
        return fakeClient;
    }


}
