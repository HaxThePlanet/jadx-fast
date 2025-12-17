package kotlin.i0.z.e.m0.d.a;

import java.util.EnumMap;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class w {

    private final EnumMap<kotlin.i0.z.e.m0.d.a.a, kotlin.i0.z.e.m0.d.a.s> a;
    public w(EnumMap<kotlin.i0.z.e.m0.d.a.a, kotlin.i0.z.e.m0.d.a.s> enumMap) {
        n.f(enumMap, "defaultQualifiers");
        super();
        this.a = enumMap;
    }

    public final kotlin.i0.z.e.m0.d.a.s a(kotlin.i0.z.e.m0.d.a.a a) {
        return (s)this.a.get(a);
    }

    public final EnumMap<kotlin.i0.z.e.m0.d.a.a, kotlin.i0.z.e.m0.d.a.s> b() {
        return this.a;
    }
}
