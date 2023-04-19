package jp.ne.simplex.jjug.controller.session;

import jp.ne.simplex.jjug.domain.entity.Session;

import java.util.Optional;

public record FindResponse(
        long id,
        String mainTitle,
        String subTitle,
        String speakerName,
        String description
) {
    public static FindResponse from(Optional<Session> original) {
        return original.map(session -> new FindResponse(
                session.id().value(),
                session.title().mainTitle(),
                session.title().subTitle(),
                session.speaker().name(),
                session.description().contents()
        )).orElse(null);
    }
}
