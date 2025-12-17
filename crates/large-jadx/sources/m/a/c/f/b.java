package m.a.c.f;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import m.a.c.a;
import m.a.c.i.a;
import m.a.c.l.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u000f", d2 = {"Lorg/koin/core/instance/InstanceContext;", "", "koin", "Lorg/koin/core/Koin;", "scope", "Lorg/koin/core/scope/Scope;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "(Lorg/koin/core/Koin;Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)V", "getKoin", "()Lorg/koin/core/Koin;", "getParameters", "()Lorg/koin/core/parameter/ParametersHolder;", "getScope", "()Lorg/koin/core/scope/Scope;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b {

    private final a a;
    private final a b;
    private final a c;
    public b(a a, a a2, a a3) {
        n.f(a, "koin");
        n.f(a2, "scope");
        super();
        this.a = a;
        this.b = a2;
        this.c = a3;
    }

    public b(a a, a a2, a a3, int i4, g g5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(a, a2, obj3);
    }

    public final a a() {
        return this.a;
    }

    public final a b() {
        return this.c;
    }

    public final a c() {
        return this.b;
    }
}
