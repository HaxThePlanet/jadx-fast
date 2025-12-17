package m.a.c.d;

import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;
import m.a.c.a;
import m.a.c.b;
import m.a.c.b.a;
import org.koin.core.error.KoinAppAlreadyStartedException;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0004H\u0016J\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0006J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J%\u0010\u0012\u001a\u00020\u00062\u001b\u0010\u0013\u001a\u0017\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0014j\u0002`\u0015¢\u0006\u0002\u0008\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u000bH\u0016J\u0016\u0010\u0018\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lorg/koin/core/context/GlobalContext;", "Lorg/koin/core/context/KoinContext;", "()V", "_koin", "Lorg/koin/core/Koin;", "_koinApplication", "Lorg/koin/core/KoinApplication;", "get", "getKoinApplicationOrNull", "getOrNull", "loadKoinModules", "", "modules", "", "Lorg/koin/core/module/Module;", "module", "register", "koinApplication", "startKoin", "appDeclaration", "Lkotlin/Function1;", "Lorg/koin/dsl/KoinAppDeclaration;", "Lkotlin/ExtensionFunctionType;", "stopKoin", "unloadKoinModules", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b implements m.a.c.d.c {

    public static final m.a.c.d.b a;
    private static a b;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    private final void b(b b) {
        if (b.b != null) {
        } else {
            b.b = b.b();
        }
        KoinAppAlreadyStartedException obj2 = new KoinAppAlreadyStartedException("A Koin Application has already been started");
        throw obj2;
    }

    public b a(l<? super b, w> l) {
        n.f(l, "appDeclaration");
        b bVar = b.c.a();
        b.a.b(bVar);
        l.invoke(bVar);
        return bVar;
        synchronized (this) {
            n.f(l, "appDeclaration");
            bVar = b.c.a();
            b.a.b(bVar);
            l.invoke(bVar);
            return bVar;
        }
    }

    @Override // m.a.c.d.c
    public a get() {
        a aVar = b.b;
        if (aVar == null) {
        } else {
            return aVar;
        }
        IllegalStateException illegalStateException = new IllegalStateException("KoinApplication has not been started".toString());
        throw illegalStateException;
    }
}
