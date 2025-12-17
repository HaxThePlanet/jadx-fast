package kotlin.i0.z.e.m0.d.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class i {

    public static final kotlin.i0.z.e.m0.d.a.i a;

    static final class a extends p implements l<b, Boolean> {

        final kotlin.i0.z.e.m0.d.a.i this$0;
        a(kotlin.i0.z.e.m0.d.a.i i) {
            this.this$0 = i;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(b b) {
            n.f(b, "it");
            return this.this$0.b(b);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((b)object));
        }
    }
    static {
        i iVar = new i();
        i.a = iVar;
    }

    private final boolean c(b b) {
        boolean empty2;
        boolean empty;
        int i;
        String str;
        Collection obj5;
        if (p.N(g.a.c(), a.e(b)) && b.h().isEmpty()) {
            if (b.h().isEmpty()) {
                return 1;
            }
        }
        final int i2 = 0;
        if (!h.e0(b)) {
            return i2;
        }
        obj5 = b.e();
        n.e(obj5, "overriddenDescriptors");
        if (obj5.isEmpty()) {
            i = i2;
        } else {
            obj5 = obj5.iterator();
            while (obj5.hasNext()) {
                Object next = obj5.next();
                n.e((b)next, "it");
                if (!b(next)) {
                    break;
                }
            }
        }
        return i;
    }

    public final String a(b b) {
        int i;
        n.f(b, "<this>");
        h.e0(b);
        i.a aVar = new i.a(this);
        i = 0;
        b obj5 = a.d(a.o(b), false, aVar, 1, i);
        if (obj5 == null) {
            return i;
        }
        obj5 = g.a.a().get(a.i(obj5));
        if ((e)obj5 == null) {
        } else {
            i = (e)obj5.c();
        }
        return i;
    }

    public final boolean b(b b) {
        n.f(b, "callableMemberDescriptor");
        if (!g.a.d().contains(b.getName())) {
            return 0;
        }
        return c(b);
    }
}
