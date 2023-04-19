package jp.ne.simplex.jjug.repository;

import jp.ne.simplex.jjug.domain.entity.Session;
import jp.ne.simplex.jjug.domain.value.Id;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OnMemorySessionRepositoryImpl implements SessionRepository {

    private final Map<Id, Session> entities = new HashMap<>();

    @Override
    synchronized public Id register(Session session) {
        if (entities.containsKey(session.id())){
            throw new RuntimeException("Already registered session. id: " + session.id().value());
        }

        Id newId = Id.of(entities.keySet().stream()
                .mapToLong(Id::value)
                .max()
                .orElse(-1) + 1);
        entities.put(newId, session.assigned(newId));
        return newId;
    }

    @Override
    public Optional<Session> find(Id id) {
        return Optional.ofNullable(entities.get(id));
    }
}
