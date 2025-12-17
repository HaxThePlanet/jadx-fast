package kotlin.i0.z.e;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;
import kotlin.y.i;

/* loaded from: classes3.dex */
public final class h0 {

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0002\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0002\u001a\u0012\u0012\u0002\u0008\u0003 \u0001*\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"Ljava/lang/Class;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Class;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 4, 1})
    static final class a extends p implements l<Class<?>, java.lang.CharSequence> {

        public static final kotlin.i0.z.e.h0.a a;
        static {
            h0.a aVar = new h0.a();
            h0.a.a = aVar;
        }

        a() {
            super(1);
        }

        public final java.lang.CharSequence a(Class<?> class) {
            n.e(class, "it");
            return b.c(class);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Class)object);
        }
    }
    public static final String a(Method method) {
        return h0.b(method);
    }

    private static final String b(Method method) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(method.getName());
        final Class[] parameterTypes = method.getParameterTypes();
        n.e(parameterTypes, "parameterTypes");
        stringBuilder.append(i.I(parameterTypes, "", "(", ")", 0, 0, h0.a.a, 24, 0));
        Class obj11 = method.getReturnType();
        n.e(obj11, "returnType");
        stringBuilder.append(b.c(obj11));
        return stringBuilder.toString();
    }
}
