package kotlin.i0.z.e.l0;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class j implements kotlin.i0.z.e.l0.d {

    public static final kotlin.i0.z.e.l0.j a;
    static {
        j jVar = new j();
        j.a = jVar;
    }

    public List<Type> a() {
        return p.g();
    }

    @Override // kotlin.i0.z.e.l0.d
    public Member b() {
        return (Member)c();
    }

    @Override // kotlin.i0.z.e.l0.d
    public Void c() {
        return null;
    }

    @Override // kotlin.i0.z.e.l0.d
    public Object call(Object[] objectArr) {
        n.f(objectArr, "args");
        UnsupportedOperationException obj2 = new UnsupportedOperationException("call/callBy are not supported for this declaration.");
        throw obj2;
    }

    @Override // kotlin.i0.z.e.l0.d
    public Type getReturnType() {
        final Class tYPE = Void.TYPE;
        n.e(tYPE, "Void.TYPE");
        return tYPE;
    }
}
