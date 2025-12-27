package m.a.e;

import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.i0.d;
import m.a.f.a;

/* compiled from: KClassExt.kt */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\u0008\u00030\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\u0008\u00030\u0002\"\u001e\u0010\u0000\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"classNames", "", "Lkotlin/reflect/KClass;", "", "getFullName", "saveCache", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: from kotlin metadata */
    private static final Map<d<?>, String> classNames;
    static {
        a.classNames = KoinPlatformTools.a.e();
    }

    public static final String a(d<?> dVar) {
        Object value;
        n.f(dVar, "<this>");
        if ((String)a.classNames.get(dVar) == null) {
            String str2 = a.b(dVar);
        }
        return value;
    }

    public static final String b(d<?> dVar) {
        n.f(dVar, "<this>");
        String str2 = KoinPlatformTools.a.c(dVar);
        a.classNames.put(dVar, str2);
        return str2;
    }
}
