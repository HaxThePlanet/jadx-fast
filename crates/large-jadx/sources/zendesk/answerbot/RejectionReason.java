package zendesk.answerbot;

/* loaded from: classes3.dex */
public enum RejectionReason {

    UNKNOWN(false),
    NOT_RELATED(true),
    RELATED_DIDNT_ANSWER(2);

    private final int code;
    @Override // java.lang.Enum
    public int getCode() {
        return this.code;
    }
}
