package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.b;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public abstract class d implements b {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d.a b;
    private final e a;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d a(Object object, e e2) {
            kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d eVar;
            n.f(object, "value");
            if (b.i(object.getClass())) {
                eVar = new o(e2, (Enum)object);
            } else {
                if (object instanceof Annotation) {
                    eVar = new e(e2, (Annotation)object);
                } else {
                    if (object instanceof Object[]) {
                        eVar = new h(e2, (Object[])object);
                    } else {
                        if (object instanceof Class) {
                            eVar = new k(e2, (Class)object);
                        } else {
                            eVar = new q(e2, object);
                        }
                    }
                }
            }
            return eVar;
        }
    }
    static {
        d.a aVar = new d.a(0);
        d.b = aVar;
    }

    public d(e e) {
        super();
        this.a = e;
    }

    @Override // kotlin.i0.z.e.m0.d.a.i0.b
    public e getName() {
        return this.a;
    }
}
