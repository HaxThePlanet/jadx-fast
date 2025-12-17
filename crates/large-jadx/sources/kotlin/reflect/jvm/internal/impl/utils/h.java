package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public enum h {

    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");

    private final String description;

    public static final class a {
        public a(g g) {
            super();
        }
    }
    @Override // java.lang.Enum
    public final String getDescription() {
        return this.description;
    }

    @Override // java.lang.Enum
    public final boolean isIgnore() {
        int i;
        i = this == h.IGNORE ? 1 : 0;
        return i;
    }

    @Override // java.lang.Enum
    public final boolean isWarning() {
        int i;
        i = this == h.WARN ? 1 : 0;
        return i;
    }
}
