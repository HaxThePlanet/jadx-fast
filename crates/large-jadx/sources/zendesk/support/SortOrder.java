package zendesk.support;

/* loaded from: classes3.dex */
public enum SortOrder {

    ASCENDING("asc"),
    DESCENDING("desc");

    private final String apiValue;
    @Override // java.lang.Enum
    public String getApiValue() {
        return this.apiValue;
    }
}
