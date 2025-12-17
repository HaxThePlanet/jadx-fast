package kotlin.i0.z.e.m0.l;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.utils.i;

/* loaded from: classes3.dex */
public abstract class b extends kotlin.i0.z.e.m0.l.g implements kotlin.i0.z.e.m0.l.t0 {

    private int c = 0;
    public b(n n) {
        if (n == null) {
        } else {
            super(n);
        }
        b.r(0);
        throw 0;
    }

    private static void r(int i) {
        String str;
        int i2;
        String str2;
        String str3;
        Object obj9;
        final int i3 = 4;
        final int i4 = 3;
        final int i5 = 1;
        if (i != i5 && i != i4 && i != i3) {
            if (i != i4) {
                str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            } else {
            }
        } else {
        }
        final int i6 = 2;
        if (i != i5 && i != i4 && i != i3) {
            if (i != i4) {
                i2 = i != i3 ? i4 : i6;
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        final int i7 = 0;
        if (i != i5) {
            if (i != i6) {
                if (i != i4 && i != i3) {
                    if (i != i3) {
                        arr[i7] = "storageManager";
                    } else {
                        arr[i7] = str2;
                    }
                } else {
                }
            } else {
                arr[i7] = "descriptor";
            }
        } else {
        }
        if (i != i5) {
            if (i != i4 && i != i3) {
                if (i != i3) {
                    arr[i5] = str2;
                } else {
                    arr[i5] = "getAdditionalNeighboursInSupertypeGraph";
                }
            } else {
            }
        } else {
            arr[i5] = "getBuiltIns";
        }
        if (i != i5) {
            if (i != i6) {
                if (i != i4 && i != i3) {
                    if (i != i3) {
                        arr[i6] = "<init>";
                    }
                }
            } else {
                arr[i6] = "hasMeaningfulFqName";
            }
        }
        String format = String.format(str, arr);
        if (i != i5 && i != i4 && i != i3) {
            if (i != i4) {
                if (i != i3) {
                    obj9 = new IllegalArgumentException(format);
                } else {
                    obj9 = new IllegalStateException(format);
                }
            } else {
            }
        } else {
        }
        throw obj9;
    }

    private static boolean s(e e, e e2) {
        boolean equals;
        int i;
        e name;
        m obj3;
        m obj4;
        i = 0;
        if (!e.getName().equals(e2.getName())) {
            return i;
        }
        obj3 = e.b();
        obj4 = e2.b();
        int i2 = 1;
        while (obj3 != null) {
            obj3 = obj3.b();
            obj4 = obj4.b();
            i2 = 1;
        }
        return i2;
    }

    private static boolean u(h h) {
        int obj1;
        if (h == null) {
        } else {
            if (!t.r(h) && !d.E(h)) {
                obj1 = !d.E(h) ? 1 : 0;
            } else {
            }
            return obj1;
        }
        b.r(2);
        throw 0;
    }

    @Override // kotlin.i0.z.e.m0.l.g
    public h c() {
        return t();
    }

    @Override // kotlin.i0.z.e.m0.l.g
    public final boolean equals(Object object) {
        boolean z;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof t0) {
            return i2;
        }
        if (object.hashCode() != hashCode()) {
            return i2;
        }
        if ((t0)object.getParameters().size() != getParameters().size()) {
            return i2;
        }
        e eVar = t();
        h obj4 = object.c();
        if (b.u(eVar)) {
            if (obj4 != null && !b.u(obj4)) {
                if (!b.u(obj4)) {
                } else {
                    if (obj4 instanceof e) {
                        return b.s(eVar, (e)obj4);
                    }
                }
            } else {
            }
        }
        return i2;
    }

    @Override // kotlin.i0.z.e.m0.l.g
    public final int hashCode() {
        int identityHashCode;
        int i = this.c;
        if (i != 0) {
            return i;
        }
        e eVar = t();
        if (b.u(eVar)) {
            identityHashCode = d.m(eVar).hashCode();
        } else {
            identityHashCode = System.identityHashCode(this);
        }
        this.c = identityHashCode;
        return identityHashCode;
    }

    @Override // kotlin.i0.z.e.m0.l.g
    protected kotlin.i0.z.e.m0.l.b0 i() {
        if (h.B0(t())) {
            return null;
        }
        return m().i();
    }

    protected Collection<kotlin.i0.z.e.m0.l.b0> j(boolean z) {
        kotlin.i0.z.e.m0.l.i0 obj4;
        m mVar = t().b();
        if (!mVar instanceof e) {
            obj4 = Collections.emptyList();
            if (obj4 == null) {
            } else {
                return obj4;
            }
            b.r(3);
            throw 0;
        }
        i iVar = new i();
        iVar.add((e)mVar.q());
        e eVar2 = mVar.T();
        if (z != null && eVar2 != null) {
            if (eVar2 != null) {
                iVar.add(eVar2.q());
            }
        }
        return iVar;
    }

    @Override // kotlin.i0.z.e.m0.l.g
    public h m() {
        h hVar = a.g(t());
        if (hVar == null) {
        } else {
            return hVar;
        }
        b.r(1);
        throw 0;
    }

    @Override // kotlin.i0.z.e.m0.l.g
    public abstract e t();
}
