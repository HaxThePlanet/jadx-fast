package m.a.b.a;

import androidx.lifecycle.i0;
import androidx.lifecycle.j0;
import androidx.savedstate.c;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ViewModelOwner.kt */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000c", d2 = {"Lorg/koin/androidx/viewmodel/ViewModelOwner;", "", "store", "Landroidx/lifecycle/ViewModelStore;", "stateRegistry", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/ViewModelStore;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getStateRegistry", "()Landroidx/savedstate/SavedStateRegistryOwner;", "getStore", "()Landroidx/lifecycle/ViewModelStore;", "Companion", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class ViewModelOwner {

    public static final a.a c = new a$a(0);
    private final i0 a;
    private final c b;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001¨\u0006\u000b", d2 = {"Lorg/koin/androidx/viewmodel/ViewModelOwner$Companion;", "", "()V", "from", "Lorg/koin/androidx/viewmodel/ViewModelOwner;", "storeOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "stateRegistry", "Landroidx/savedstate/SavedStateRegistryOwner;", "fromAny", "owner", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final a from(j0 storeOwner) {
            n.f(storeOwner, "storeOwner");
            final i0 viewModelStore = storeOwner.getViewModelStore();
            n.e(viewModelStore, "storeOwner.viewModelStore");
            c cVar = null;
            return new ViewModelOwner(viewModelStore, cVar, 2, cVar);
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public a(i0 i0Var, c cVar) {
        n.f(i0Var, "store");
        super();
        this.a = i0Var;
        this.b = cVar;
    }

    public final c a() {
        return this.b;
    }

    public final i0 b() {
        return this.a;
    }

    public /* synthetic */ a(i0 i0Var, c cVar, int i, g gVar) {
        i = i & 2 != 0 ? 0 : i;
        this(i0Var, cVar);
    }

}
