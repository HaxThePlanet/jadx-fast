package app.dogo.com.dogo_android.e;

import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.i;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ClickerSelectViewModel.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u0008\u0010\u0019\u001a\u00020\u0018H\u0014J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000bR\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "clickerSoundPlayer", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/util/ClickerSoundPlayer;)V", "clickedEvent", "Lcom/hadilq/liveevent/LiveEvent;", "", "currentSoundId", "", "getCurrentSoundId", "()I", "setCurrentSoundId", "(I)V", "errorEvent", "onClicked", "Landroidx/lifecycle/LiveData;", "getOnClicked", "()Landroidx/lifecycle/LiveData;", "onError", "getOnError", "dismissDialog", "", "onCleared", "soundChoice", "which", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class ClickerSelectViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private p2 clickedEvent;
    /* renamed from: b, reason: from kotlin metadata */
    private i clickerSoundPlayer;
    /* renamed from: c, reason: from kotlin metadata */
    private int currentSoundId;
    /* renamed from: d, reason: from kotlin metadata */
    private final a<Integer> errorEvent = new a<>();
    /* renamed from: e, reason: from kotlin metadata */
    private final LiveData<Integer> onClicked = new a<>();
    private final a<Boolean> f = new a<>();
    /* renamed from: g, reason: from kotlin metadata */
    private final LiveData<Boolean> preferenceService = new a<>();
    public n(p2 p2Var, i iVar) {
        n.f(p2Var, "preferenceService");
        n.f(iVar, "clickerSoundPlayer");
        super();
        this.clickedEvent = p2Var;
        this.clickerSoundPlayer = iVar;
        a aVar = new a();
        a aVar2 = new a();
        this.clickerSoundPlayer.k(new app.dogo.com.dogo_android.clicker.g(this));
        this.currentSoundId = this.clickedEvent.R();
    }

    private static final boolean h(n nVar, String str, int i) {
        n.f(nVar, "this$0");
        nVar.errorEvent.setValue(2131886123);
        return true;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: i, reason: from kotlin metadata */
    public final void dismissDialog() {
        this.clickedEvent.k1(this.currentSoundId);
        this.f.setValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int j() {
        return this.currentSoundId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<Boolean> k() {
        return this.preferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<Integer> l() {
        return this.onClicked;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: n, reason: from kotlin metadata */
    public final void soundChoice(int which) {
        this.currentSoundId = which;
        this.clickerSoundPlayer.i(which);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    protected void onCleared() {
        super.onCleared();
        this.clickerSoundPlayer.h();
    }

    public static /* synthetic */ boolean m(n nVar, String str, int i) {
        return ClickerSelectViewModel.h(nVar, str, i);
    }
}
