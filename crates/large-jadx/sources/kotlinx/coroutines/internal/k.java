package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.p;
import kotlin.q;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class k {

    private static final boolean a;
    static {
        Class forName;
        kotlin.p.a aVar;
        try {
            kotlin.p.a aVar2 = p.a;
            p.a(Class.forName("android.os.Build"));
            aVar = p.a;
            Throwable th = q.a(th);
            p.a(th);
            k.a = p.f(forName);
        }
    }

    public static final boolean a() {
        return k.a;
    }
}
