package m.a.b.a.e;

import androidx.lifecycle.c0;
import androidx.lifecycle.e0;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.d0.d.p;

/* compiled from: StateViewModelFactory.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\u0008J5\u0010\r\u001a\u0002H\u0001\"\u0008\u0008\u0001\u0010\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014¢\u0006\u0002\u0010\u0014R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0015", d2 = {"Lorg/koin/androidx/viewmodel/factory/StateViewModelFactory;", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "scope", "Lorg/koin/core/scope/Scope;", "parameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "(Lorg/koin/core/scope/Scope;Lorg/koin/androidx/viewmodel/ViewModelParameter;)V", "getParameters", "()Lorg/koin/androidx/viewmodel/ViewModelParameter;", "getScope", "()Lorg/koin/core/scope/Scope;", "create", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: b, reason: from kotlin metadata */
public final class StateViewModelFactory<T extends e0> extends androidx.lifecycle.a {

    private final m.a.c.l.a d;
    private final m.a.b.a.b<T> e;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003\"\u0008\u0008\u0001\u0010\u0002*\u00020\u0003H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;", "T", "Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.a<m.a.c.i.a> {

        final /* synthetic */ c0 $handle;
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            int i = 0;
            kotlin.d0.c.a aVar = b.this.e().c();
            i = aVar == null ? 0 : (ParametersHolder)invoke;
            if (b.this == 0) {
                m.a.c.i.a aVar2 = org.koin.core.parameter.b.a();
            }
            i.insert(0, this.$handle);
            return i;
        }

        a(b<T> bVar, c0 c0Var) {
            this.$handle = c0Var;
            super(0);
        }
    }
    public b(m.a.c.l.a aVar, m.a.b.a.b<T> bVar) {
        n.f(aVar, "scope");
        n.f(bVar, "parameters");
        androidx.savedstate.c cVar = bVar.e();
        if (cVar == null) {
            throw new IllegalStateException("Can't create SavedStateViewModelFactory without a proper stateRegistryOwner".toString());
        } else {
            super(cVar, bVar.b());
            this.d = aVar;
            this.e = bVar;
            return;
        }
    }

    @Override // androidx.lifecycle.a
    /* renamed from: d, reason: from kotlin metadata */
    protected <T extends e0> T create(String key, Class<T> modelClass, c0 handle) {
        n.f(key, "key");
        n.f(modelClass, "modelClass");
        n.f(handle, "handle");
        return (e0)this.d.c(this.e.a(), this.e.d(), new org.koin.androidx.viewmodel.factory.b.a(this, handle));
    }

    @Override // androidx.lifecycle.a
    public final m.a.b.a.b<T> e() {
        return this.e;
    }
}
