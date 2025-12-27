package f.c.a.b.i;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: EventInternal.java */
/* loaded from: classes.dex */
public abstract class j {

    public static abstract class a {
        public final j.a a(String str, int i) {
            e().put(str, String.valueOf(i));
            return this;
        }

        public final j.a b(String str, long j) {
            e().put(str, String.valueOf(j));
            return this;
        }

        public final j.a c(String str, String str2) {
            e().put(str, str2);
            return this;
        }

        public abstract j d();

        protected abstract Map<String, String> e();

        protected abstract j.a f(Map<String, String> map);

        public abstract j.a g(Integer integer);

        public abstract j.a h(i iVar);

        public abstract j.a i(long j);

        public abstract j.a j(String str);

        public abstract j.a k(long j);
    }
    public static j.a a() {
        final f.c.a.b.i.c.b bVar = new c.b();
        bVar.f(new HashMap());
        return bVar;
    }

    public final String b(String str) {
        Object value;
        if ((String)c().get(str) == null) {
            String str2 = "";
        }
        return value;
    }

    public final int g(String str) {
        int value = 0;
        Object value2 = c().get(str);
        if (value2 == null) {
            value = 0;
        } else {
            value = Integer.valueOf(value2).intValue();
        }
        return value;
    }

    public final long h(String str) {
        int i = 0;
        Object value = c().get(str);
        if (value == null) {
            i = 0;
        } else {
            long value2 = Long.valueOf(value).longValue();
        }
        return i;
    }

    public final Map<String, String> i() {
        return Collections.unmodifiableMap(c());
    }

    public j.a l() {
        final f.c.a.b.i.c.b bVar = new c.b();
        bVar.j(j());
        bVar.g(d());
        bVar.h(e());
        bVar.i(f());
        bVar.k(k());
        bVar.f(new HashMap(c()));
        return bVar;
    }

    protected abstract Map<String, String> c();

    public abstract Integer d();

    public abstract i e();

    public abstract long f();

    public abstract String j();

    public abstract long k();
}
