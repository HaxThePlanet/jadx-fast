package net.time4j.g1;

/* compiled from: Leniency.java */
/* loaded from: classes3.dex */
public enum g {

    LAX,
    SMART,
    STRICT;
    @Override // java.lang.Enum
    public boolean isLax() {
        boolean z = true;
        int r0 = this == g.LAX ? 1 : 0;
        return (this == g.LAX ? 1 : 0);
    }

    @Override // java.lang.Enum
    public boolean isSmart() {
        boolean z = true;
        int r0 = this == g.SMART ? 1 : 0;
        return (this == g.SMART ? 1 : 0);
    }

    @Override // java.lang.Enum
    public boolean isStrict() {
        boolean z = true;
        int r0 = this == g.STRICT ? 1 : 0;
        return (this == g.STRICT ? 1 : 0);
    }
}
