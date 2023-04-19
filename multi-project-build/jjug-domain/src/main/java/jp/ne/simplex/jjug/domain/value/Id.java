package jp.ne.simplex.jjug.domain.value;

public record Id(
        long value
) {
    public static Id of(long value) {
        return new Id(value);
    }

    public static Id UNASSGNED = new Id(-1);
}
