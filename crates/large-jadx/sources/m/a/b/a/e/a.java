package m.a.b.a.e;

import androidx.lifecycle.g0.b;
import kotlin.Metadata;
import kotlin.d0.d.n;
import m.a.b.a.b;
import m.a.c.l.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\u0008J%\u0010\r\u001a\u0002H\u0001\"\u0008\u0008\u0001\u0010\u0001*\u00020\u00022\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0011", d2 = {"Lorg/koin/androidx/viewmodel/factory/DefaultViewModelFactory;", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "scope", "Lorg/koin/core/scope/Scope;", "parameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "(Lorg/koin/core/scope/Scope;Lorg/koin/androidx/viewmodel/ViewModelParameter;)V", "getParameters", "()Lorg/koin/androidx/viewmodel/ViewModelParameter;", "getScope", "()Lorg/koin/core/scope/Scope;", "create", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a<T extends androidx.lifecycle.e0>  implements g0.b {

    private final a a;
    private final b<T> b;
    public a(a a, b<T> b2) {
        n.f(a, "scope");
        n.f(b2, "parameters");
        super();
        this.a = a;
        this.b = b2;
    }

    public <T extends androidx.lifecycle.e0> T a(Class<T> class) {
        n.f(class, "modelClass");
        return (e0)this.a.c(this.b.a(), this.b.d(), this.b.c());
    }
}
