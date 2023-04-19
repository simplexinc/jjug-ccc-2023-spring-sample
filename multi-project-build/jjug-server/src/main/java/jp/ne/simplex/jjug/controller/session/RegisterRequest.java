package jp.ne.simplex.jjug.controller.session;

import jp.ne.simplex.jjug.domain.entity.Session;
import jp.ne.simplex.jjug.domain.value.Description;
import jp.ne.simplex.jjug.domain.value.Id;
import jp.ne.simplex.jjug.domain.value.Speaker;
import jp.ne.simplex.jjug.domain.value.Title;

public record RegisterRequest(
        String mainTitle,
        String subTitle,
        String speakerName,
        String description
) {
    public Session to() {
        return new Session(
                Id.UNASSGNED,
                new Speaker(speakerName),
                new Title(
                        mainTitle,
                        subTitle
                ),
                new Description(description)
        );
    }
}
