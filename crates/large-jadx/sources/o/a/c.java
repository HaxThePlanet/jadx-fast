package o.a;

import android.content.Intent;
import android.os.Bundle;
import java.util.List;
import java.util.Map;

/* compiled from: ConfigurationUtil.java */
@Deprecated
/* loaded from: classes3.dex */
public class c {

    private static b a;
    static {
        c.a = new b();
    }

    public static List<a> a(List<a> list, a aVar) {
        return c.a.a(list, aVar);
    }

    public static void b(Bundle bundle, a aVar) {
        c.a.b(bundle, aVar);
    }

    public static void c(Intent intent, a aVar) {
        c.a.c(intent, aVar);
    }

    public static <E extends a> E d(List<a> list, Class<E> cls) {
        return c.a.e(list, cls);
    }

    public static <E extends a> E e(Bundle bundle, Class<E> cls) {
        return c.a.f(bundle, cls);
    }

    public static <E extends a> E f(Map<String, Object> map, Class<E> cls) {
        return c.a.g(map, cls);
    }
}
