package m.a.b.a;

import androidx.lifecycle.i0;
import androidx.lifecycle.j0;
import androidx.savedstate.c;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000c", d2 = {"Lorg/koin/androidx/viewmodel/ViewModelOwner;", "", "store", "Landroidx/lifecycle/ViewModelStore;", "stateRegistry", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/ViewModelStore;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getStateRegistry", "()Landroidx/savedstate/SavedStateRegistryOwner;", "getStore", "()Landroidx/lifecycle/ViewModelStore;", "Companion", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a {

    public static final m.a.b.a.a.a c;
    private final i0 a;
    private final c b;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001¨\u0006\u000b", d2 = {"Lorg/koin/androidx/viewmodel/ViewModelOwner$Companion;", "", "()V", "from", "Lorg/koin/androidx/viewmodel/ViewModelOwner;", "storeOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "stateRegistry", "Landroidx/savedstate/SavedStateRegistryOwner;", "fromAny", "owner", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final m.a.b.a.a a(j0 j0) {
            n.f(j0, "storeOwner");
            final i0 obj4 = j0.getViewModelStore();
            n.e(obj4, "storeOwner.viewModelStore");
            int i = 0;
            a aVar = new a(obj4, i, 2, i);
            return aVar;
        }
    }
    static {
        a.a aVar = new a.a(0);
        a.c = aVar;
    }

    public a(i0 i0, c c2) {
        n.f(i0, "store");
        super();
        this.a = i0;
        this.b = c2;
    }

    public a(i0 i0, c c2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(i0, obj2);
    }

    public final c a() {
        return this.b;
    }

    public final i0 b() {
        return this.a;
    }
}
