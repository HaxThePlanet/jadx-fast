package zendesk.support;

import java.util.Locale;

/* loaded from: classes3.dex */
public enum SortBy {

    POSITION,
    TITLE,
    CREATED_AT,
    UPDATED_AT;
    @Override // java.lang.Enum
    public String getApiValue() {
        return name().toLowerCase(Locale.US);
    }
}
