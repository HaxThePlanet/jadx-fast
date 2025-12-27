package app.dogo.com.dogo_android.p.a;

import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InstagramInviteViewModel.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0008J\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0007\u001a\u00020\u0008X\u0086D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0008X\u0086D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\n\"\u0004\u0008\u000f\u0010\u0010¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/popups/instagram/InstagramInviteViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "instagramLink", "", "getInstagramLink", "()Ljava/lang/String;", "packageName", "getPackageName", "videoLink", "getVideoLink", "setVideoLink", "(Ljava/lang/String;)V", "instagramFollowVideo", "saveInstagramIsFollowed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class InstagramInviteViewModel extends s {

    private final p2 a;
    private final r2 b;
    /* renamed from: c, reason: from kotlin metadata */
    private String preferenceService = "https://media.giphy.com/media/N9uEo1QIWGINy/giphy.mp4";
    /* renamed from: d, reason: from kotlin metadata */
    private final String remoteConfigService = "https://www.instagram.com/_u/dogoapp/";
    /* renamed from: e, reason: from kotlin metadata */
    private final String videoLink = "com.instagram.android";
    public d(p2 p2Var, r2 r2Var) {
        n.f(p2Var, "preferenceService");
        n.f(r2Var, "remoteConfigService");
        super();
        this.a = p2Var;
        this.b = r2Var;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final String instagramFollowVideo() {
        return this.remoteConfigService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String i() {
        return this.videoLink;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String j() {
        try {
            Object obj = new JSONObject(this.b.t()).get("url");
            this.preferenceService = obj;
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
        return this.preferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        this.a.X0(true);
    }
}
