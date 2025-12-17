package m.a.e;

import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.i0.d;
import m.a.f.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\u0008\u00030\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\u0008\u00030\u0002\"\u001e\u0010\u0000\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"classNames", "", "Lkotlin/reflect/KClass;", "", "getFullName", "saveCache", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class a {

    private static final Map<d<?>, String> a;
    static {
        a.a = a.a.e();
    }

    public static final String a(d<?> d) {
        Object obj;
        n.f(d, "<this>");
        if ((String)a.a.get(d) == null) {
            obj = a.b(d);
        }
        return obj;
    }

    public static final String b(d<?> d) {
        n.f(d, "<this>");
        String str2 = a.a.c(d);
        a.a.put(d, str2);
        return str2;
    }
}
