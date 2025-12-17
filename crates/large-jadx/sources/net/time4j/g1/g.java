package net.time4j.g1;

/* loaded from: classes3.dex */
public enum g {

    STRICT,
    SMART,
    LAX;
    @Override // java.lang.Enum
    public boolean isLax() {
        int i;
        i = this == g.LAX ? 1 : 0;
        return i;
    }

    @Override // java.lang.Enum
    public boolean isSmart() {
        int i;
        i = this == g.SMART ? 1 : 0;
        return i;
    }

    @Override // java.lang.Enum
    public boolean isStrict() {
        int i;
        i = this == g.STRICT ? 1 : 0;
        return i;
    }
}
