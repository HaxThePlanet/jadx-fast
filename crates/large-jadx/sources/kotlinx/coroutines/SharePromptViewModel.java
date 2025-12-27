package app.dogo.com.dogo_android.a0;

import android.content.Intent;
import android.content.res.Resources;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.j0;
import app.dogo.com.dogo_android.w.l0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SharePromptViewModel.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0008\u0010\u001b\u001a\u00020\u0013H\u0002J\u0006\u0010\u001c\u001a\u00020\u001aJ\u0008\u0010\u001d\u001a\u00020\u001aH\u0002R\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/SharePromptViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "source", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "resources", "Landroid/content/res/Resources;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Landroid/content/res/Resources;)V", "onDismiss", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnDismiss", "()Lcom/hadilq/liveevent/LiveEvent;", "onShare", "Landroid/content/Intent;", "getOnShare", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "cancel", "", "getShareInviteIntent", "shareToFriends", "trackShareTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class SharePromptViewModel extends s {

    private String a;
    private final o3 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final k1 rateRepository;
    /* renamed from: d, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.r2 remoteConfigService;
    /* renamed from: e, reason: from kotlin metadata */
    private final Resources resources;
    private final a<Boolean> f = new a<>();
    /* renamed from: g, reason: from kotlin metadata */
    private final a<Intent> tracker = new a<>();
    public e(String str, o3 o3Var, k1 k1Var, app.dogo.com.dogo_android.service.r2 r2Var, Resources resources) {
        n.f(str, "source");
        n.f(o3Var, "tracker");
        n.f(k1Var, "rateRepository");
        n.f(r2Var, "remoteConfigService");
        n.f(resources, "resources");
        super();
        this.a = str;
        this.b = o3Var;
        this.rateRepository = k1Var;
        this.remoteConfigService = r2Var;
        this.resources = resources;
        a aVar = new a();
        a aVar2 = new a();
        k1Var.e(this.a);
    }

    /* renamed from: k, reason: from kotlin metadata */
    private final Intent cancel() throws android.content.res.Resources.NotFoundException {
        final Intent intent = new Intent("android.intent.action.SEND");
        String string = this.resources.getString(2131886783);
        n.e(string, "resources.getString(string.invite_friends_text)");
        String str5 = this.remoteConfigService.A();
        final StringBuilder stringBuilder = new StringBuilder();
        str2 = string + 32 + str5;
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        return intent;
    }

    private final void m() {
        this.rateRepository.h();
        this.b.logEvent(E_ShareDialog.a.c(new EP_ViewSource(), this.a));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h() {
        this.b.logEvent(E_RateDialog.c.c(new EP_ViewSource(), this.a));
        this.f.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final a<Boolean> i() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final a<Intent> j() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        m();
        this.tracker.postValue(cancel());
    }
}
