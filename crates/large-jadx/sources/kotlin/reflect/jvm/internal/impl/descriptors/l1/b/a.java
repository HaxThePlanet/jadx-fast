package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
final class a {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.a a;
    private static kotlin.reflect.jvm.internal.impl.descriptors.l1.b.a.a b;

    public static final class a {

        private final Method a;
        private final Method b;
        public a(Method method, Method method2) {
            super();
            this.a = method;
            this.b = method2;
        }

        public final Method a() {
            return this.b;
        }

        public final Method b() {
            return this.a;
        }
    }
    static {
        a aVar = new a();
        a.a = aVar;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.a.a a(Member member) {
        n.f(member, "member");
        Class obj5 = member.getClass();
        int i2 = 0;
        a.a aVar = new a.a(obj5.getMethod("getParameters", new Class[i2]), b.g(obj5).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[i2]));
        return aVar;
    }

    public final List<String> b(Member member) {
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.a.a aVar;
        int i;
        Object invoke;
        String str;
        n.f(member, "member");
        if (a.b == null) {
            a.b = a(member);
        }
        Method method2 = aVar.b();
        int i2 = 0;
        if (method2 == null) {
            return i2;
        }
        Method method = aVar.a();
        if (method == null) {
            return i2;
        }
        int i3 = 0;
        final Object obj8 = method2.invoke(member, new Object[i3]);
        Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.Array<*>");
        ArrayList arrayList = new ArrayList(obj8.length);
        i = i3;
        while (i < obj8.length) {
            invoke = method.invoke((Object[])obj8[i], new Object[i3]);
            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String)invoke);
            i++;
        }
        return arrayList;
    }
}
