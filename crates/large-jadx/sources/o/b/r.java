package o.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Executor;

/* compiled from: Suas.java */
/* loaded from: classes3.dex */
public class r {

    private static boolean a = false;

    public static class a {

        private final Collection<n> a;
        private o b;
        private Collection<m> c = new ArrayList<>();
        private h<Object> d;
        private Executor e;
        a(Collection<n> collection) {
            super();
            ArrayList arrayList = new ArrayList();
            this.d = i.a;
            this.a = collection;
        }

        private void a(Object object, String str) {
            if (object == null) {
                throw new IllegalArgumentException(str);
            }
        }

        private Executor c() {
            if (this.e != null) {
                return this.e;
            }
            if (r.a) {
                return g.a();
            }
            return g.b();
        }

        public q b() {
            final o.b.c cVar = new c(this.a);
            s sVar = new s(o.f(cVar.c(), this.b), cVar, new b(this.c), this.d, c());
            return sVar;
        }

        public r.a d(h<Object> hVar) {
            a(hVar, "Notifier must not be null");
            this.d = hVar;
            return this;
        }

        public r.a e(m... mVarArr) {
            a(mVarArr, "Middleware must not be null");
            this.c = Arrays.asList(mVarArr);
            return this;
        }
    }
    static {
        try {
            Class.forName("android.os.Build");
            r.a = true;
        } catch (Exception unused) {
            return;
        }
    }

    static /* synthetic */ boolean a() {
        return r.a;
    }

    public static r.a b(Collection<n> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Reducer must not be null or empty");
        } else {
            if (!collection.isEmpty()) {
                return new r.a(collection);
            }
        }
    }
}
