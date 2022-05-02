package nl.novi.techiteasy.Service;

import nl.novi.techiteasy.Repositories.RemoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteService {

    private final RemoteRepository remoteRepository;

    @Autowired
    public RemoteService(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }




}
