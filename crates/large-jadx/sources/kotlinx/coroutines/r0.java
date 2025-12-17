package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.p;
import kotlin.q;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\u0008\u00030\u0008H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0004¨\u0006\t", d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class r0 {
    public static final String a(Object object) {
        return object.getClass().getSimpleName();
    }

    public static final String b(Object object) {
        return Integer.toHexString(System.identityHashCode(object));
    }

    public static final String c(d<?> d) {
        int i;
        String string;
        String str;
        Object name;
        Object obj3;
        if (d instanceof g) {
            obj3 = d.toString();
        } else {
            i = 64;
            kotlin.p.a aVar = p.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d);
            stringBuilder.append(i);
            stringBuilder.append(r0.b(d));
            p.a(stringBuilder.toString());
            if (p.c(string) == null) {
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(d.getClass().getName());
                stringBuilder2.append(i);
                stringBuilder2.append(r0.b(d));
                string = stringBuilder2.toString();
            }
            obj3 = string;
        }
        return obj3;
    }
}
