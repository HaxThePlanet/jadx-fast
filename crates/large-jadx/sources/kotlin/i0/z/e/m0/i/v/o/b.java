package kotlin.i0.z.e.m0.i.v.o;

import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;

/* loaded from: classes3.dex */
public class b extends kotlin.i0.z.e.m0.i.v.o.a implements kotlin.i0.z.e.m0.i.v.o.d {

    private final a c;
    public b(a a, b0 b02, kotlin.i0.z.e.m0.i.v.o.d d3) {
        final int i = 0;
        if (a == null) {
        } else {
            if (b02 == null) {
            } else {
                super(b02, d3);
                this.c = a;
            }
            b.b(1);
            throw i;
        }
        b.b(0);
        throw i;
    }

    private static void b(int i) {
        String str;
        int str2;
        int i2;
        String str3;
        String str4;
        Object obj8;
        final int i3 = 2;
        str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        str2 = 3;
        i2 = i != i3 ? str2 : i3;
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        final int i4 = 1;
        final int i5 = 0;
        if (i != i4) {
            if (i != i3) {
                if (i != str2) {
                    arr[i5] = "callableDescriptor";
                } else {
                    arr[i5] = "newType";
                }
            } else {
                arr[i5] = str3;
            }
        } else {
            arr[i5] = "receiverType";
        }
        if (i != i3) {
            arr[i4] = str3;
        } else {
            arr[i4] = "getDeclarationDescriptor";
        }
        if (i != i3) {
            if (i != str2) {
                arr[i3] = "<init>";
            } else {
                arr[i3] = "replaceType";
            }
        }
        String format = String.format(str, arr);
        if (i != i3) {
            obj8 = new IllegalArgumentException(format);
        } else {
            obj8 = new IllegalStateException(format);
        }
        throw obj8;
    }

    @Override // kotlin.i0.z.e.m0.i.v.o.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getType());
        stringBuilder.append(": Ext {");
        stringBuilder.append(this.c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
