package m.a.b.a;

import androidx.lifecycle.e0;
import androidx.lifecycle.g0;
import androidx.lifecycle.g0.b;
import kotlin.Metadata;
import kotlin.d0.d.n;
import m.a.b.a.e.b;

/* compiled from: ViewModelResolver.kt */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a$\u0010\u0000\u001a\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000\u001aA\u0010\u0007\u001a\u0002H\u0002\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00062\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000bH\u0000¢\u0006\u0002\u0010\u000c\u001a$\u0010\r\u001a\u00020\u000e\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0006H\u0002\u001a)\u0010\u000f\u001a\u0002H\u0002\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000¢\u0006\u0002\u0010\u0010¨\u0006\u0011", d2 = {"createViewModelProvider", "Landroidx/lifecycle/ViewModelProvider;", "T", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/scope/Scope;", "viewModelParameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "get", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "javaClass", "Ljava/lang/Class;", "(Landroidx/lifecycle/ViewModelProvider;Lorg/koin/androidx/viewmodel/ViewModelParameter;Lorg/koin/core/qualifier/Qualifier;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "pickFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "resolveInstance", "(Landroidx/lifecycle/ViewModelProvider;Lorg/koin/androidx/viewmodel/ViewModelParameter;)Landroidx/lifecycle/ViewModel;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final <T extends e0> g0 a(m.a.c.l.a aVar, b<T> bVar) {
        n.f(aVar, "<this>");
        n.f(bVar, "viewModelParameters");
        return new g0(bVar.f(), org.koin.androidx.viewmodel.c.c(aVar, bVar));
    }

    public static final <T extends e0> T b(g0 g0Var, b<T> bVar, m.a.c.j.a aVar, Class<T> cls) {
        e0 e0Var;
        n.f(g0Var, "<this>");
        n.f(bVar, "viewModelParameters");
        n.f(cls, "javaClass");
        if (bVar.d() != null) {
            str = "{\n        get(qualifier.toString(), javaClass)\n    }";
            n.e(g0Var.b(String.valueOf(aVar), cls), str);
        } else {
            str = "{\n        get(javaClass)\n    }";
            n.e(g0Var.a(cls), str);
        }
        return e0Var;
    }

    private static final <T extends e0> g0.b c(m.a.c.l.a aVar, b<T> bVar) {
        m.a.b.a.e.a defaultViewModelFactory;
        StateViewModelFactory r0 = bVar.e() != null && bVar.b() != null ? new StateViewModelFactory(aVar, bVar) : new DefaultViewModelFactory(aVar, bVar);
        return (bVar.e() != null && bVar.b() != null ? new StateViewModelFactory(aVar, bVar) : new DefaultViewModelFactory(aVar, bVar));
    }

    public static final <T extends e0> T d(g0 g0Var, b<T> bVar) {
        n.f(g0Var, "<this>");
        n.f(bVar, "viewModelParameters");
        return org.koin.androidx.viewmodel.c.b(g0Var, bVar, bVar.d(), a.b(bVar.a()));
    }
}
