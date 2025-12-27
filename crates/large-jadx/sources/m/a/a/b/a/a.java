package m.a.a.b.a;

import android.content.ComponentCallbacks;
import kotlin.Metadata;
import kotlin.d0.d.n;
import m.a.c.k.c;

/* compiled from: ComponentCallbackExt.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aE\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\u0008\n\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007j\u0004\u0018\u0001`\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\n\u0010\u000b\u001a\u00020\u000c*\u00020\u0003\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0003\u001aP\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0010\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0016\u0008\n\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007j\u0004\u0018\u0001`\tH\u0086\u0008ø\u0001\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0013", d2 = {"get", "T", "", "Landroid/content/ComponentCallbacks;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Landroid/content/ComponentCallbacks;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getDefaultScope", "Lorg/koin/core/scope/Scope;", "getKoin", "Lorg/koin/core/Koin;", "inject", "Lkotlin/Lazy;", "mode", "Lkotlin/LazyThreadSafetyMode;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final m.a.c.l.a a(ComponentCallbacks componentCallbacks) {
        m.a.c.l.a scope;
        n.f(componentCallbacks, "<this>");
        z = componentCallbacks instanceof AndroidScopeComponent;
        if (componentCallbacks instanceof AndroidScopeComponent) {
            scope = componentCallbacks.a();
        } else {
            z = componentCallbacks instanceof KoinScopeComponent;
            if (componentCallbacks instanceof KoinScopeComponent) {
                scope = componentCallbacks.closeScope();
            } else {
                scope = a.b(componentCallbacks).d().b();
            }
        }
        return scope;
    }

    public static final m.a.c.a b(ComponentCallbacks componentCallbacks) {
        m.a.c.a koin;
        n.f(componentCallbacks, "<this>");
        if (componentCallbacks instanceof KoinComponent) {
            koin = componentCallbacks.getKoin();
        } else {
            koin = GlobalContext.a.get();
        }
        return koin;
    }
}
