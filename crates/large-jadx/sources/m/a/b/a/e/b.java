package m.a.b.a.e;

import androidx.lifecycle.a;
import androidx.lifecycle.c0;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import m.a.b.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.l.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\u0008J5\u0010\r\u001a\u0002H\u0001\"\u0008\u0008\u0001\u0010\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014¢\u0006\u0002\u0010\u0014R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0015", d2 = {"Lorg/koin/androidx/viewmodel/factory/StateViewModelFactory;", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "scope", "Lorg/koin/core/scope/Scope;", "parameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "(Lorg/koin/core/scope/Scope;Lorg/koin/androidx/viewmodel/ViewModelParameter;)V", "getParameters", "()Lorg/koin/androidx/viewmodel/ViewModelParameter;", "getScope", "()Lorg/koin/core/scope/Scope;", "create", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b<T extends androidx.lifecycle.e0>  extends a {

    private final a d;
    private final b<T> e;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003\"\u0008\u0008\u0001\u0010\u0002*\u00020\u0003H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<a> {

        final c0 $handle;
        final m.a.b.a.e.b<T> this$0;
        a(m.a.b.a.e.b<T> b, c0 c02) {
            this.this$0 = b;
            this.$handle = c02;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            int invoke;
            a aVar = this.this$0.e().c();
            if (aVar == null) {
                invoke = 0;
            } else {
                invoke = aVar.invoke();
            }
            if (invoke == 0) {
                invoke = b.a();
            }
            invoke.c(0, this.$handle);
            return invoke;
        }
    }
    public b(a a, b<T> b2) {
        n.f(a, "scope");
        n.f(b2, "parameters");
        androidx.savedstate.c cVar = b2.e();
        if (cVar == null) {
        } else {
            super(cVar, b2.b());
            this.d = a;
            this.e = b2;
        }
        IllegalStateException obj3 = new IllegalStateException("Can't create SavedStateViewModelFactory without a proper stateRegistryOwner".toString());
        throw obj3;
    }

    protected <T extends androidx.lifecycle.e0> T d(String string, Class<T> class2, c0 c03) {
        n.f(string, "key");
        n.f(class2, "modelClass");
        n.f(c03, "handle");
        b.a aVar2 = new b.a(this, c03);
        return (e0)this.d.c(this.e.a(), this.e.d(), aVar2);
    }

    public final b<T> e() {
        return this.e;
    }
}
