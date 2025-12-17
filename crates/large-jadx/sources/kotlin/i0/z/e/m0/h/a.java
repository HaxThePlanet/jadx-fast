package kotlin.i0.z.e.m0.h;

import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public enum a {

    NO_ARGUMENTS(false, false, 3, false),
    ALWAYS_PARENTHESIZED(false, false);

    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;
    @Override // java.lang.Enum
    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    @Override // java.lang.Enum
    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }
}
