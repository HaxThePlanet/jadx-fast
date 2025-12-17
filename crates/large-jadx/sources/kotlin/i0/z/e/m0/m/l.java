package kotlin.i0.z.e.m0.m;

import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.x;

/* loaded from: classes3.dex */
public abstract class l implements kotlin.i0.z.e.m0.m.b {

    private final String a;

    public static final class a extends kotlin.i0.z.e.m0.m.l {

        private final int b;
        public a(int i) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("must have at least ");
            stringBuilder.append(i);
            stringBuilder.append(" value parameter");
            str = i > 1 ? "s" : "";
            stringBuilder.append(str);
            super(stringBuilder.toString(), 0);
            this.b = i;
        }

        @Override // kotlin.i0.z.e.m0.m.l
        public boolean c(x x) {
            int obj2;
            n.f(x, "functionDescriptor");
            obj2 = x.h().size() >= this.b ? 1 : 0;
            return obj2;
        }
    }

    public static final class b extends kotlin.i0.z.e.m0.m.l {

        private final int b;
        public b(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("must have exactly ");
            stringBuilder.append(i);
            stringBuilder.append(" value parameters");
            super(stringBuilder.toString(), 0);
            this.b = i;
        }

        @Override // kotlin.i0.z.e.m0.m.l
        public boolean c(x x) {
            int obj2;
            n.f(x, "functionDescriptor");
            obj2 = x.h().size() == this.b ? 1 : 0;
            return obj2;
        }
    }

    public static final class c extends kotlin.i0.z.e.m0.m.l {

        public static final kotlin.i0.z.e.m0.m.l.c b;
        static {
            l.c cVar = new l.c();
            l.c.b = cVar;
        }

        private c() {
            super("must have no value parameters", 0);
        }

        @Override // kotlin.i0.z.e.m0.m.l
        public boolean c(x x) {
            n.f(x, "functionDescriptor");
            return x.h().isEmpty();
        }
    }

    public static final class d extends kotlin.i0.z.e.m0.m.l {

        public static final kotlin.i0.z.e.m0.m.l.d b;
        static {
            l.d dVar = new l.d();
            l.d.b = dVar;
        }

        private d() {
            super("must have a single value parameter", 0);
        }

        @Override // kotlin.i0.z.e.m0.m.l
        public boolean c(x x) {
            int i;
            n.f(x, "functionDescriptor");
            if (x.h().size() == 1) {
            } else {
                i = 0;
            }
            return i;
        }
    }
    private l(String string) {
        super();
        this.a = string;
    }

    public l(String string, g g2) {
        super(string);
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public String a(x x) {
        return b.a.a(this, x);
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public String b() {
        return this.a;
    }
}
