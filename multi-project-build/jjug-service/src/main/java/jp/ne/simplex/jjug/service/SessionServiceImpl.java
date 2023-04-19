package jp.ne.simplex.jjug.service;

import jp.ne.simplex.jjug.domain.entity.Session;
import jp.ne.simplex.jjug.domain.value.Id;
import jp.ne.simplex.jjug.repository.SessionRepository;

import java.util.Optional;

public class SessionServiceImpl implements SessionService {

    public SessionServiceImpl(SessionRepository repository){
        this.repository = repository;
    }

    private final SessionRepository repository;

    public Id register(Session session){
        return repository.register(session);
    }

    public Optional<Session> find(Id id){
        return repository.find(id);
    }
}
