package app.dogo.com.dogo_android.p.a;

import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0008J\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0007\u001a\u00020\u0008X\u0086D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0008X\u0086D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\n\"\u0004\u0008\u000f\u0010\u0010¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/popups/instagram/InstagramInviteViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "instagramLink", "", "getInstagramLink", "()Ljava/lang/String;", "packageName", "getPackageName", "videoLink", "getVideoLink", "setVideoLink", "(Ljava/lang/String;)V", "instagramFollowVideo", "saveInstagramIsFollowed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends s {

    private final p2 a;
    private final r2 b;
    private String c;
    private final String d;
    private final String e;
    public d(p2 p2, r2 r22) {
        n.f(p2, "preferenceService");
        n.f(r22, "remoteConfigService");
        super();
        this.a = p2;
        this.b = r22;
        this.c = "https://media.giphy.com/media/N9uEo1QIWGINy/giphy.mp4";
        this.d = "https://www.instagram.com/_u/dogoapp/";
        this.e = "com.instagram.android";
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String h() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String i() {
        return this.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String j() {
        Object obj;
        try {
            JSONObject jSONObject = new JSONObject(this.b.t());
            obj = jSONObject.get("url");
            if (obj == null) {
            } else {
            }
            this.c = (String)obj;
            NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            throw nullPointerException;
            th.printStackTrace();
            return this.c;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        this.a.X0(true);
    }
}
