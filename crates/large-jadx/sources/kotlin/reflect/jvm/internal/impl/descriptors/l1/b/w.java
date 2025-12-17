package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.Type;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.x;
import kotlin.i0.z.e.m0.d.a.i0.x.a;
import kotlin.i0.z.e.m0.f.b;

/* loaded from: classes3.dex */
public abstract class w implements x {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w.a a;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w a(Type type) {
            kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w iVar;
            Object obj;
            boolean primitive;
            kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w obj4;
            n.f(type, "type");
            iVar = type instanceof Class;
            obj = type;
            if (iVar && (Class)obj.isPrimitive()) {
                obj = type;
                if ((Class)obj.isPrimitive()) {
                    obj4 = new v(obj);
                } else {
                    if (!type instanceof GenericArrayType) {
                        if (iVar && (Class)type.isArray()) {
                            if ((Class)type.isArray()) {
                                iVar = new i(type);
                            } else {
                                if (type instanceof WildcardType) {
                                    iVar = new z((WildcardType)type);
                                } else {
                                    iVar = new l(type);
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                    obj4 = iVar;
                }
            } else {
            }
            return obj4;
        }
    }
    static {
        w.a aVar = new w.a(0);
        w.a = aVar;
    }

    @Override // kotlin.i0.z.e.m0.d.a.i0.x
    protected abstract Type Q();

    @Override // kotlin.i0.z.e.m0.d.a.i0.x
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof w && n.b(Q(), (w)object.Q())) {
            obj2 = n.b(Q(), (w)object.Q()) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.d.a.i0.x
    public int hashCode() {
        return Q().hashCode();
    }

    @Override // kotlin.i0.z.e.m0.d.a.i0.x
    public a o(b b) {
        return x.a.a(this, b);
    }

    @Override // kotlin.i0.z.e.m0.d.a.i0.x
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(Q());
        return stringBuilder.toString();
    }
}
