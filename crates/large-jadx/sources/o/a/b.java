package o.a;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {

    static String a = "ZENDESK_CONFIGURATION";
    private static o.a.b b;
    static {
        b bVar = new b();
        b.b = bVar;
    }

    public static o.a.b h() {
        return b.b;
    }

    public List<o.a.a> a(List<o.a.a> list, o.a.a a2) {
        ArrayList arrayList = new ArrayList(list);
        if (e(list, a2.getClass()) == null) {
            arrayList.add(a2);
        }
        return arrayList;
    }

    public void b(Bundle bundle, o.a.a a2) {
        bundle.putSerializable(b.a, a2);
    }

    public void c(Intent intent, o.a.a a2) {
        intent.putExtra(b.a, a2);
    }

    public void d(Map<String, Object> map, o.a.a a2) {
        map.put(b.a, a2);
    }

    public <E extends o.a.a> E e(List<o.a.a> list, Class<E> class2) {
        Object next;
        boolean instance;
        Iterator obj3 = list.iterator();
        for (a next : obj3) {
        }
        return 0;
    }

    public <E extends o.a.a> E f(Bundle bundle, Class<E> class2) {
        boolean key;
        java.io.Serializable obj2;
        boolean obj3;
        obj2 = bundle.getSerializable(b.a);
        if (bundle != null && bundle.containsKey(b.a) && class2.isInstance(obj2)) {
            if (bundle.containsKey(b.a)) {
                obj2 = bundle.getSerializable(b.a);
                if (class2.isInstance(obj2)) {
                    return (a)obj2;
                }
            }
        }
        return 0;
    }

    public <E extends o.a.a> E g(Map<String, Object> map, Class<E> class2) {
        boolean key;
        Object obj2;
        boolean obj3;
        obj2 = map.get(b.a);
        if (map != null && map.containsKey(b.a) && class2.isInstance(obj2)) {
            if (map.containsKey(b.a)) {
                obj2 = map.get(b.a);
                if (class2.isInstance(obj2)) {
                    return (a)obj2;
                }
            }
        }
        return 0;
    }
}
