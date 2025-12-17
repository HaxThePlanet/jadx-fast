package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes3.dex */
public final class g {
    public static final kotlin.reflect.jvm.internal.impl.utils.f a(String string) {
        kotlin.reflect.jvm.internal.impl.utils.f fVar;
        boolean z;
        boolean z2;
        int i;
        Object obj5;
        n.f(string, "value");
        i = 0;
        final int i2 = 2;
        final int i3 = 0;
        final String str6 = "(this as java.lang.String).substring(startIndex)";
        if (!l.M(string, "0x", i, i2, i3)) {
            if (l.M(string, "0X", i, i2, i3)) {
                obj5 = string.substring(i2);
                n.e(obj5, str6);
                fVar = new f(obj5, 16);
            } else {
                if (!l.M(string, "0b", i, i2, i3)) {
                    if (l.M(string, "0B", i, i2, i3)) {
                        obj5 = string.substring(i2);
                        n.e(obj5, str6);
                        fVar = new f(obj5, i2);
                    } else {
                        fVar = new f(string, 10);
                    }
                } else {
                }
            }
        } else {
        }
        return fVar;
    }
}
