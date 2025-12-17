package app.dogo.com.dogo_android.e;

import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.i;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u0008\u0010\u0019\u001a\u00020\u0018H\u0014J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000bR\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "clickerSoundPlayer", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer;)V", "clickedEvent", "Lcom/hadilq/liveevent/LiveEvent;", "", "currentSoundId", "", "getCurrentSoundId", "()I", "setCurrentSoundId", "(I)V", "errorEvent", "onClicked", "Landroidx/lifecycle/LiveData;", "getOnClicked", "()Landroidx/lifecycle/LiveData;", "onError", "getOnError", "dismissDialog", "", "onCleared", "soundChoice", "which", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n extends s {

    private p2 a;
    private i b;
    private int c;
    private final a<Integer> d;
    private final LiveData<Integer> e;
    private final a<Boolean> f;
    private final LiveData<Boolean> g;
    public n(p2 p2, i i2) {
        n.f(p2, "preferenceService");
        n.f(i2, "clickerSoundPlayer");
        super();
        this.a = p2;
        this.b = i2;
        a obj2 = new a();
        this.d = obj2;
        this.e = obj2;
        obj2 = new a();
        this.f = obj2;
        this.g = obj2;
        g obj3 = new g(this);
        this.b.k(obj3);
        this.c = this.a.R();
    }

    private static final boolean h(app.dogo.com.dogo_android.e.n n, String string2, int i3) {
        n.f(n, "this$0");
        n.d.setValue(2131886123);
        return 1;
    }

    public static boolean m(app.dogo.com.dogo_android.e.n n, String string2, int i3) {
        return n.h(n, string2, i3);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        this.a.k1(this.c);
        this.f.setValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int j() {
        return this.c;
    }

    public final LiveData<Boolean> k() {
        return this.g;
    }

    public final LiveData<Integer> l() {
        return this.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n(int i) {
        this.c = i;
        this.b.i(i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    protected void onCleared() {
        super.onCleared();
        this.b.h();
    }
}
