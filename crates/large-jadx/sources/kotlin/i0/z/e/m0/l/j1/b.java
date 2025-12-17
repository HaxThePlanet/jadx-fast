package kotlin.i0.z.e.m0.l.j1;

import kotlin.d0.d.c0;

/* loaded from: classes3.dex */
public final class b {
    public static final String a(Object object) {
        return b.b(object);
    }

    private static final String b(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassicTypeCheckerContext couldn't handle ");
        stringBuilder.append(c0.b(object.getClass()));
        stringBuilder.append(' ');
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}
