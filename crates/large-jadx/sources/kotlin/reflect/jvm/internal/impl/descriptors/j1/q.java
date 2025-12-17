package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import kotlin.i0.z.e.m0.i.v.o.c;
import kotlin.i0.z.e.m0.i.v.o.d;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.m;

/* loaded from: classes3.dex */
public class q extends kotlin.reflect.jvm.internal.impl.descriptors.j1.c {

    private final e v;
    private final c w;
    public q(e e) {
        final int i = 0;
        if (e == null) {
        } else {
            super(g.q.b());
            this.v = e;
            c cVar = new c(e, i);
            this.w = cVar;
        }
        q.E(0);
        throw i;
    }

    private static void E(int i) {
        String str3;
        int str;
        int i2;
        String str2;
        String str4;
        Object obj8;
        final int i3 = 2;
        final int i4 = 1;
        if (i != i4 && i != i3) {
            str3 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        } else {
        }
        str = 3;
        if (i != i4 && i != i3) {
            i2 = i != i3 ? str : i3;
        } else {
        }
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        final int i5 = 0;
        if (i != i4 && i != i3) {
            if (i != i3) {
                if (i != str) {
                    arr[i5] = "descriptor";
                } else {
                    arr[i5] = "newOwner";
                }
            } else {
                arr[i5] = str2;
            }
        } else {
        }
        if (i != i4) {
            if (i != i3) {
                arr[i4] = str2;
            } else {
                arr[i4] = "getContainingDeclaration";
            }
        } else {
            arr[i4] = "getValue";
        }
        if (i != i4 && i != i3) {
            if (i != i3) {
                if (i != str) {
                    arr[i3] = "<init>";
                } else {
                    arr[i3] = "copy";
                }
            }
        }
        String format = String.format(str3, arr);
        if (i != i4 && i != i3) {
            if (i != i3) {
                obj8 = new IllegalArgumentException(format);
            } else {
                obj8 = new IllegalStateException(format);
            }
        } else {
        }
        throw obj8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.c
    public m b() {
        e eVar = this.v;
        if (eVar == null) {
        } else {
            return eVar;
        }
        q.E(2);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.c
    public d getValue() {
        c cVar = this.w;
        if (cVar == null) {
        } else {
            return cVar;
        }
        q.E(1);
        throw 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.c
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class ");
        stringBuilder.append(this.v.getName());
        stringBuilder.append("::this");
        return stringBuilder.toString();
    }
}
