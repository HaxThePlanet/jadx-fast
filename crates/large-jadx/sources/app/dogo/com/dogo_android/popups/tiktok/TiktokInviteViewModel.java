package app.dogo.com.dogo_android.p.b;

import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.o3;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TiktokInviteViewModel.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u0008J\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/popups/tiktok/TiktokInviteViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "fallbackVideoLink", "", "getFallbackVideoLink", "()Ljava/lang/String;", "setFallbackVideoLink", "(Ljava/lang/String;)V", "tiktokFollowVideo", "trackFollowClicked", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class TiktokInviteViewModel extends s {

    private final r2 a;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 remoteConfigService;
    /* renamed from: c, reason: from kotlin metadata */
    private String tracker = "https://media.giphy.com/media/N9uEo1QIWGINy/giphy.mp4";
    public d(r2 r2Var, o3 o3Var) {
        n.f(r2Var, "remoteConfigService");
        n.f(o3Var, "tracker");
        super();
        this.a = r2Var;
        this.remoteConfigService = o3Var;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final String tiktokFollowVideo() {
        Object obj;
        try {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
        return obj;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        this.remoteConfigService.logEvent(E_General.l);
    }
}
