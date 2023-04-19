package jp.ne.simplex.jjug.repository;

import jp.ne.simplex.jjug.domain.entity.Session;
import jp.ne.simplex.jjug.domain.value.Id;

import java.util.Optional;

public interface SessionRepository {

    Id register(Session session);

    Optional<Session> find(Id id);
}
