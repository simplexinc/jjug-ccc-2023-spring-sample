package jp.ne.simplex.jjug.service;

import jp.ne.simplex.jjug.domain.entity.Session;
import jp.ne.simplex.jjug.domain.value.Id;

import java.util.Optional;

public interface SessionService {

    Id register(Session session);

    Optional<Session> find(Id id);
}
