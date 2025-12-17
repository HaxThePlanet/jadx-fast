package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.n;
import kotlin.i0.z.e.m0.d.a.i0.x;

/* loaded from: classes3.dex */
public final class p extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r implements n {

    private final Field a;
    public p(Field field) {
        n.f(field, "member");
        super();
        this.a = field;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public boolean G() {
        return V().isEnumConstant();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public boolean O() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public Member T() {
        return V();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public Field V() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w W() {
        java.lang.reflect.Type genericType = V().getGenericType();
        n.e(genericType, "member.genericType");
        return w.a.a(genericType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public x getType() {
        return W();
    }
}
