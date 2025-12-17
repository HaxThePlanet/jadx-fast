package kotlin.reflect.jvm.internal.impl.descriptors.h1;

/* loaded from: classes3.dex */
public class b implements kotlin.reflect.jvm.internal.impl.descriptors.h1.a {

    private final kotlin.reflect.jvm.internal.impl.descriptors.h1.g a;
    public b(kotlin.reflect.jvm.internal.impl.descriptors.h1.g g) {
        if (g == null) {
        } else {
            super();
            this.a = g;
        }
        b.E(0);
        throw 0;
    }

    private static void E(int i) {
        String str3;
        int i2;
        String str;
        String str2;
        Object obj7;
        final int i3 = 1;
        str3 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        final int i4 = 2;
        i2 = i != i3 ? 3 : i4;
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        final int i5 = 0;
        if (i != i3) {
            arr[i5] = "annotations";
        } else {
            arr[i5] = str;
        }
        if (i != i3) {
            arr[i3] = str;
        } else {
            arr[i3] = "getAnnotations";
        }
        if (i != i3) {
            arr[i4] = "<init>";
        }
        String format = String.format(str3, arr);
        if (i != i3) {
            obj7 = new IllegalArgumentException(format);
        } else {
            obj7 = new IllegalStateException(format);
        }
        throw obj7;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.a
    public kotlin.reflect.jvm.internal.impl.descriptors.h1.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.h1.g gVar = this.a;
        if (gVar == null) {
        } else {
            return gVar;
        }
        b.E(1);
        throw 0;
    }
}
