package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class f {

    private static final kotlin.reflect.jvm.internal.impl.protobuf.f b;
    private final Map<kotlin.reflect.jvm.internal.impl.protobuf.f.a, kotlin.reflect.jvm.internal.impl.protobuf.h.f<?, ?>> a;

    private static final class a {

        private final Object a;
        private final int b;
        a(Object object, int i2) {
            super();
            this.a = object;
            this.b = i2;
        }

        public boolean equals(Object object) {
            Object obj;
            int i;
            Object obj4;
            if (!object instanceof f.a) {
                return 0;
            }
            if (this.a == object.a && this.b == object.b) {
                if (this.b == object.b) {
                    i = 1;
                }
            }
            return i;
        }

        public int hashCode() {
            return i += i4;
        }
    }
    static {
        f fVar = new f(1);
        f.b = fVar;
    }

    f() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    private f(boolean z) {
        super();
        this.a = Collections.emptyMap();
    }

    public static kotlin.reflect.jvm.internal.impl.protobuf.f c() {
        return f.b;
    }

    public static kotlin.reflect.jvm.internal.impl.protobuf.f d() {
        f fVar = new f();
        return fVar;
    }

    public final void a(kotlin.reflect.jvm.internal.impl.protobuf.h.f<?, ?> h$f) {
        f.a aVar = new f.a(f.b(), f.d());
        this.a.put(aVar, f);
    }

    public <ContainingType extends kotlin.reflect.jvm.internal.impl.protobuf.o> kotlin.reflect.jvm.internal.impl.protobuf.h.f<ContainingType, ?> b(ContainingType containingtype, int i2) {
        f.a aVar = new f.a(containingtype, i2);
        return (h.f)this.a.get(aVar);
    }
}
