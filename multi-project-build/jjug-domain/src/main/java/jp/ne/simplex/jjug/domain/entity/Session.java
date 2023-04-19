package jp.ne.simplex.jjug.domain.entity;

import jp.ne.simplex.jjug.domain.value.Description;
import jp.ne.simplex.jjug.domain.value.Id;
import jp.ne.simplex.jjug.domain.value.Speaker;
import jp.ne.simplex.jjug.domain.value.Title;

public record Session(
        Id id,
        Speaker speaker,
        Title title,
        Description description
) {
    public Session assigned(Id id) {
        return new Session(
                id, speaker, title, description
        );
    }
}
