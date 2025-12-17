package f.c.a.b.i;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class j {

    public static abstract class a {
        public final f.c.a.b.i.j.a a(String string, int i2) {
            e().put(string, String.valueOf(i2));
            return this;
        }

        public final f.c.a.b.i.j.a b(String string, long l2) {
            e().put(string, String.valueOf(l2));
            return this;
        }

        public final f.c.a.b.i.j.a c(String string, String string2) {
            e().put(string, string2);
            return this;
        }

        public abstract f.c.a.b.i.j d();

        protected abstract Map<String, String> e();

        protected abstract f.c.a.b.i.j.a f(Map<String, String> map);

        public abstract f.c.a.b.i.j.a g(Integer integer);

        public abstract f.c.a.b.i.j.a h(f.c.a.b.i.i i);

        public abstract f.c.a.b.i.j.a i(long l);

        public abstract f.c.a.b.i.j.a j(String string);

        public abstract f.c.a.b.i.j.a k(long l);
    }
    public static f.c.a.b.i.j.a a() {
        c.b bVar = new c.b();
        HashMap hashMap = new HashMap();
        bVar.f(hashMap);
        return bVar;
    }

    public final String b(String string) {
        Object obj2;
        if ((String)c().get(string) == null) {
            obj2 = "";
        }
        return obj2;
    }

    protected abstract Map<String, String> c();

    public abstract Integer d();

    public abstract f.c.a.b.i.i e();

    public abstract long f();

    public final int g(String string) {
        int obj2;
        obj2 = c().get(string);
        if ((String)obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = Integer.valueOf((String)obj2).intValue();
        }
        return obj2;
    }

    public final long h(String string) {
        int longValue;
        Object obj3;
        obj3 = c().get(string);
        if ((String)obj3 == null) {
            longValue = 0;
        } else {
            longValue = Long.valueOf((String)obj3).longValue();
        }
        return longValue;
    }

    public final Map<String, String> i() {
        return Collections.unmodifiableMap(c());
    }

    public abstract String j();

    public abstract long k();

    public f.c.a.b.i.j.a l() {
        c.b bVar = new c.b();
        bVar.j(j());
        bVar.g(d());
        bVar.h(e());
        bVar.i(f());
        bVar.k(k());
        HashMap hashMap = new HashMap(c());
        bVar.f(hashMap);
        return bVar;
    }
}
