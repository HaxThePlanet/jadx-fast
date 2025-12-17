package app.dogo.com.dogo_android.util.e0;

import androidx.lifecycle.e0;
import i.b.j0.a;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0008\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "onCleared", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class s extends e0 {

    private final a disposable;
    public s() {
        super();
        a aVar = new a();
        this.disposable = aVar;
    }

    @Override // androidx.lifecycle.e0
    public final a getDisposable() {
        return this.disposable;
    }

    @Override // androidx.lifecycle.e0
    protected void onCleared() {
        super.onCleared();
        this.disposable.d();
    }
}
