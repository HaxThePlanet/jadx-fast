package o.a;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ConfigurationHelper.java */
/* loaded from: classes3.dex */
public class b {

    static String a = "ZENDESK_CONFIGURATION";
    private static b b;
    static {
        b.b = new b();
    }

    public static b h() {
        return b.b;
    }

    public List<a> a(List<a> list, a aVar) {
        final ArrayList arrayList = new ArrayList(list);
        if (e(list, aVar.getClass()) == null) {
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public void b(Bundle bundle, a aVar) {
        bundle.putSerializable(b.a, aVar);
    }

    public void c(Intent intent, a aVar) {
        intent.putExtra(b.a, aVar);
    }

    public void d(Map<String, Object> map, a aVar) {
        map.put(b.a, aVar);
    }

    public <E extends a> E e(List<a> list, Class<E> cls) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (cls.isInstance(item)) {
                return item;
            }
        }
        return null;
    }

    public <E extends a> E f(Bundle bundle, Class<E> cls) {
        if (bundle != null) {
            if (bundle.containsKey(b.a)) {
                java.io.Serializable serializable = bundle.getSerializable(b.a);
                if (cls.isInstance(serializable)) {
                    return serializable;
                }
            }
        }
        return null;
    }

    public <E extends a> E g(Map<String, Object> map, Class<E> cls) {
        if (map != null) {
            if (map.containsKey(b.a)) {
                Object value = map.get(b.a);
                if (cls.isInstance(value)) {
                    return value;
                }
            }
        }
        return null;
    }
}
