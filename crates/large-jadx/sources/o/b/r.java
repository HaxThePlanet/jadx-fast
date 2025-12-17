package o.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class r {

    private static boolean a = false;

    public static class a {

        private final Collection<o.b.n> a;
        private o.b.o b;
        private Collection<o.b.m> c;
        private o.b.h<Object> d;
        private Executor e;
        a(Collection<o.b.n> collection) {
            super();
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            this.d = i.a;
            this.a = collection;
        }

        private void a(Object object, String string2) {
            if (object == null) {
            } else {
            }
            IllegalArgumentException obj1 = new IllegalArgumentException(string2);
            throw obj1;
        }

        private Executor c() {
            Executor executor = this.e;
            if (executor != null) {
                return executor;
            }
            if (r.a()) {
                return g.a();
            }
            return g.b();
        }

        public o.b.q b() {
            c cVar = new c(this.a);
            b bVar = new b(this.c);
            super(o.f(cVar.c(), this.b), cVar, bVar, this.d, c());
            return sVar2;
        }

        public o.b.r.a d(o.b.h<Object> h) {
            a(h, "Notifier must not be null");
            this.d = h;
            return this;
        }

        public o.b.r.a e(o.b.m... mArr) {
            a(mArr, "Middleware must not be null");
            this.c = Arrays.asList(mArr);
            return this;
        }
    }
    static {
        try {
            Class.forName("android.os.Build");
            r.a = true;
        }
    }

    static boolean a() {
        return r.a;
    }

    public static o.b.r.a b(Collection<o.b.n> collection) {
        boolean empty;
        if (collection == null) {
        } else {
            if (collection.isEmpty()) {
            } else {
                r.a aVar = new r.a(collection);
                return aVar;
            }
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Reducer must not be null or empty");
        throw obj1;
    }
}
