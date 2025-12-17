package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public enum h1 {

    INVARIANT("", true, true, false);

    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final String label;
    private final int superpositionFactor;
    @Override // java.lang.Enum
    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    @Override // java.lang.Enum
    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.label;
    }
}
