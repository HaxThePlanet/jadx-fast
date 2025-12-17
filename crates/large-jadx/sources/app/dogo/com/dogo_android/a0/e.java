package app.dogo.com.dogo_android.a0;

import android.content.Intent;
import android.content.res.Resources;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.j0;
import app.dogo.com.dogo_android.w.l0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u2;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0008\u0010\u001b\u001a\u00020\u0013H\u0002J\u0006\u0010\u001c\u001a\u00020\u001aJ\u0008\u0010\u001d\u001a\u00020\u001aH\u0002R\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/SharePromptViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "source", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "resources", "Landroid/content/res/Resources;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Landroid/content/res/Resources;)V", "onDismiss", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnDismiss", "()Lcom/hadilq/liveevent/LiveEvent;", "onShare", "Landroid/content/Intent;", "getOnShare", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "cancel", "", "getShareInviteIntent", "shareToFriends", "trackShareTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends s {

    private String a;
    private final o3 b;
    private final k1 c;
    private final r2 d;
    private final Resources e;
    private final a<Boolean> f;
    private final a<Intent> g;
    public e(String string, o3 o32, k1 k13, r2 r24, Resources resources5) {
        n.f(string, "source");
        n.f(o32, "tracker");
        n.f(k13, "rateRepository");
        n.f(r24, "remoteConfigService");
        n.f(resources5, "resources");
        super();
        this.a = string;
        this.b = o32;
        this.c = k13;
        this.d = r24;
        this.e = resources5;
        a obj2 = new a();
        this.f = obj2;
        obj2 = new a();
        this.g = obj2;
        k13.e(this.a);
    }

    private final Intent k() {
        Intent intent = new Intent("android.intent.action.SEND");
        String string = this.e.getString(2131886783);
        n.e(string, "resources.getString(string.invite_friends_text)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(' ');
        stringBuilder.append(this.d.A());
        intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
        intent.setType("text/plain");
        return intent;
    }

    private final void m() {
        this.c.h();
        r2 r2Var = new r2();
        this.b.d(l0.a.c(r2Var, this.a));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h() {
        r2 r2Var = new r2();
        this.b.d(j0.c.c(r2Var, this.a));
        this.f.postValue(Boolean.TRUE);
    }

    public final a<Boolean> i() {
        return this.f;
    }

    public final a<Intent> j() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        m();
        this.g.postValue(k());
    }
}
