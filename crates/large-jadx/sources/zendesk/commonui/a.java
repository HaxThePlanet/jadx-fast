package zendesk.commonui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class a extends Fragment {

    private final Map<String, Object> a;

    public interface a {
        public abstract T get();
    }
    public a() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    public static zendesk.commonui.a B1(e e) {
        n obj3 = e.getSupportFragmentManager();
        final String str = "CacheFragment";
        Fragment fragment = obj3.k0(str);
        if (fragment instanceof a) {
            return (a)fragment;
        }
        a aVar = new a();
        aVar.setRetainInstance(true);
        obj3 = obj3.n();
        obj3.d(aVar, str);
        obj3.g();
        return aVar;
    }

    public <T> T C1(String string) {
        try {
            return this.a.get(string);
            string = null;
            return string;
        }
    }

    public <T> T D1(String string, zendesk.commonui.a.a<T> a$a2) {
        final Object obj = C1(string);
        if (obj != null) {
            return obj;
        }
        final Object obj3 = a2.get();
        E1(string, obj3);
        return obj3;
    }

    public <T> void E1(String string, T t2) {
        this.a.put(string, t2);
    }
}
