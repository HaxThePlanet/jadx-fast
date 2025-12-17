package o.a;

import android.content.Intent;
import android.os.Bundle;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
@Deprecated
public class c {

    private static o.a.b a;
    static {
        b bVar = new b();
        c.a = bVar;
    }

    public static List<o.a.a> a(List<o.a.a> list, o.a.a a2) {
        return c.a.a(list, a2);
    }

    public static void b(Bundle bundle, o.a.a a2) {
        c.a.b(bundle, a2);
    }

    public static void c(Intent intent, o.a.a a2) {
        c.a.c(intent, a2);
    }

    public static <E extends o.a.a> E d(List<o.a.a> list, Class<E> class2) {
        return c.a.e(list, class2);
    }

    public static <E extends o.a.a> E e(Bundle bundle, Class<E> class2) {
        return c.a.f(bundle, class2);
    }

    public static <E extends o.a.a> E f(Map<String, Object> map, Class<E> class2) {
        return c.a.g(map, class2);
    }
}
