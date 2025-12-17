package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public abstract class a0 extends kotlin.reflect.jvm.internal.impl.descriptors.j1.k implements n0 {

    private final boolean A;
    private final b.a B;
    private u C;
    private x D = null;
    private boolean w;
    private final boolean x;
    private final z y;
    private final o0 z;
    static {
    }

    public a0(z z, u u2, o0 o03, g g4, e e5, boolean z6, boolean z7, boolean z8, b.a b$a9, u0 u010) {
        final int i = 0;
        if (z == null) {
        } else {
            if (u2 == null) {
            } else {
                if (o03 == null) {
                } else {
                    if (g4 == null) {
                    } else {
                        if (e5 == null) {
                        } else {
                            if (u010 == null) {
                            } else {
                                super(o03.b(), g4, e5, u010);
                                this.y = z;
                                this.C = u2;
                                this.z = o03;
                                this.w = z6;
                                this.x = z7;
                                this.A = z8;
                                this.B = a9;
                            }
                            a0.E(5);
                            throw i;
                        }
                        a0.E(4);
                        throw i;
                    }
                    a0.E(3);
                    throw i;
                }
                a0.E(2);
                throw i;
            }
            a0.E(1);
            throw i;
        }
        a0.E(0);
        throw i;
    }

    private static void E(int i) {
        String str;
        int i2;
        String str3;
        String str4;
        Object obj6;
        str = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i2 = /* condition */ ? i3 : 3;
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
        int i4 = 0;
        switch (i) {
            case 1:
                arr[i4] = "visibility";
                break;
            case 2:
                arr[i4] = "correspondingProperty";
                break;
            case 3:
                arr[i4] = "annotations";
                break;
            case 4:
                arr[i4] = "name";
                break;
            case 5:
                arr[i4] = "source";
                break;
            case 6:
                arr[i4] = str3;
                break;
            case 7:
                arr[i4] = "substitutor";
                break;
            case 8:
                arr[i4] = "overriddenDescriptors";
                break;
            default:
                arr[i4] = "modality";
        }
        int i5 = 1;
        switch (i) {
            case 6:
                arr[i5] = "getKind";
                break;
            case 7:
                arr[i5] = str3;
                break;
            case 8:
                arr[i5] = "getTypeParameters";
                break;
            case 9:
                arr[i5] = "getModality";
                break;
            case 10:
                arr[i5] = "getVisibility";
                break;
            case 11:
                arr[i5] = "getCorrespondingVariable";
                break;
            case 12:
                arr[i5] = "getCorrespondingProperty";
                break;
            default:
                arr[i5] = "getOverriddenDescriptors";
        }
        switch (i) {
            case 7:
                arr[i3] = "substitute";
                break;
            case 8:
                arr[i3] = "setOverriddenDescriptors";
                break;
            default:
                arr[i3] = "<init>";
        }
        if (/* condition */) {
            obj6 = new IllegalStateException(format);
        } else {
            obj6 = new IllegalArgumentException(format);
        }
        throw obj6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean B0() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public n0 C0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Accessors must be copied by the corresponding property");
        throw obj1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean D() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean E0() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public p J() {
        return J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public abstract n0 J0();

    protected Collection<n0> K0(boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.p0 getter;
        ArrayList arrayList = new ArrayList(0);
        Iterator iterator = y0().e().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if (z) {
            } else {
            }
            getter = (o0)next2.getSetter();
            if (getter != null) {
            }
            arrayList.add(getter);
            getter = next2.getGetter();
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean L() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void L0(boolean z) {
        this.w = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void M0(x x) {
        this.D = x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public void N0(u u) {
        this.C = u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean O() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean P() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean U() {
        return this.w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public a a() {
        return J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public b a() {
        return J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public m a() {
        return J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public x a() {
        return J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public n c(a1 a1) {
        c(a1);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public x c(a1 a1) {
        if (a1 == null) {
            a0.E(7);
            throw 0;
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public x d0() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public b.a f() {
        b.a aVar = this.B;
        if (aVar == null) {
        } else {
            return aVar;
        }
        a0.E(6);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public r0 f0() {
        return y0().f0();
    }

    public List<z0> getTypeParameters() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        a0.E(8);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public u getVisibility() {
        u uVar = this.C;
        if (uVar == null) {
        } else {
            return uVar;
        }
        a0.E(10);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public z i() {
        z zVar = this.y;
        if (zVar == null) {
        } else {
            return zVar;
        }
        a0.E(9);
        throw 0;
    }

    public <V> V i0(a.a<V> a$a) {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean isSuspend() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public b k0(m m, z z2, u u3, b.a b$a4, boolean z5) {
        C0(m, z2, u3, a4, z5);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public r0 m0() {
        return y0().m0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean r() {
        return this.A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean v0() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean w() {
        return this.x;
    }

    public void w0(Collection<? extends b> collection) {
        if (collection == null) {
        } else {
        }
        a0.E(14);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public o0 y0() {
        o0 o0Var = this.z;
        if (o0Var == null) {
        } else {
            return o0Var;
        }
        a0.E(12);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.k
    public boolean z0() {
        return 0;
    }
}
