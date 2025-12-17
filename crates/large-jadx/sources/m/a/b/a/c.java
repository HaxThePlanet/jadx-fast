package m.a.b.a;

import androidx.lifecycle.g0;
import androidx.lifecycle.g0.b;
import kotlin.Metadata;
import kotlin.d0.a;
import kotlin.d0.d.n;
import m.a.b.a.e.a;
import m.a.b.a.e.b;
import m.a.c.j.a;
import m.a.c.l.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a$\u0010\u0000\u001a\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000\u001aA\u0010\u0007\u001a\u0002H\u0002\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00062\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000bH\u0000¢\u0006\u0002\u0010\u000c\u001a$\u0010\r\u001a\u00020\u000e\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0006H\u0002\u001a)\u0010\u000f\u001a\u0002H\u0002\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000¢\u0006\u0002\u0010\u0010¨\u0006\u0011", d2 = {"createViewModelProvider", "Landroidx/lifecycle/ViewModelProvider;", "T", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/scope/Scope;", "viewModelParameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "get", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "javaClass", "Ljava/lang/Class;", "(Landroidx/lifecycle/ViewModelProvider;Lorg/koin/androidx/viewmodel/ViewModelParameter;Lorg/koin/core/qualifier/Qualifier;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "pickFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "resolveInstance", "(Landroidx/lifecycle/ViewModelProvider;Lorg/koin/androidx/viewmodel/ViewModelParameter;)Landroidx/lifecycle/ViewModel;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class c {
    public static final <T extends androidx.lifecycle.e0> g0 a(a a, m.a.b.a.b<T> b2) {
        n.f(a, "<this>");
        n.f(b2, "viewModelParameters");
        g0 g0Var = new g0(b2.f(), c.c(a, b2));
        return g0Var;
    }

    public static final <T extends androidx.lifecycle.e0> T b(g0 g0, m.a.b.a.b<T> b2, a a3, Class<T> class4) {
        androidx.lifecycle.e0 obj1;
        String obj2;
        n.f(g0, "<this>");
        n.f(b2, "viewModelParameters");
        n.f(class4, "javaClass");
        if (b2.d() != null) {
            n.e(g0.b(String.valueOf(a3), class4), "{\n        get(qualifier.toString(), javaClass)\n    }");
        } else {
            n.e(g0.a(class4), "{\n        get(javaClass)\n    }");
        }
        return obj1;
    }

    private static final <T extends androidx.lifecycle.e0> g0.b c(a a, m.a.b.a.b<T> b2) {
        Object cVar;
        Object aVar;
        if (b2.e() != null && b2.b() != null) {
            if (b2.b() != null) {
                aVar = new b(a, b2);
            } else {
                aVar = new a(a, b2);
            }
        } else {
        }
        return aVar;
    }

    public static final <T extends androidx.lifecycle.e0> T d(g0 g0, m.a.b.a.b<T> b2) {
        n.f(g0, "<this>");
        n.f(b2, "viewModelParameters");
        return c.b(g0, b2, b2.d(), a.b(b2.a()));
    }
}
