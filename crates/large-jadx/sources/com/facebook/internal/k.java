package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.facebook.internal.g0.i.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u000c\u001a\u00020\r2\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lcom/facebook/internal/FacebookWebFallbackDialog;", "Lcom/facebook/internal/WebDialog;", "context", "Landroid/content/Context;", "url", "", "expectedRedirectUrl", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "waitingForDialogToClose", "", "cancel", "", "parseResponseUri", "Landroid/os/Bundle;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class k extends com.facebook.internal.d0 {

    private static final String J;
    public static final com.facebook.internal.k.a K;
    private boolean I;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lcom/facebook/internal/FacebookWebFallbackDialog$Companion;", "", "()V", "OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS", "", "TAG", "", "newInstance", "Lcom/facebook/internal/FacebookWebFallbackDialog;", "context", "Landroid/content/Context;", "url", "expectedRedirectUrl", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final com.facebook.internal.k a(Context context, String string2, String string3) {
            n.f(context, "context");
            n.f(string2, "url");
            n.f(string3, "expectedRedirectUrl");
            d0.H.b(context);
            k kVar = new k(context, string2, string3, 0);
            return kVar;
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class b implements Runnable {

        final com.facebook.internal.k a;
        b(com.facebook.internal.k k) {
            this.a = k;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            k.y(this.a);
        }
    }
    static {
        k.a aVar = new k.a(0);
        k.K = aVar;
        String name = k.class.getName();
        n.e(name, "FacebookWebFallbackDialog::class.java.name");
        k.J = name;
    }

    private k(Context context, String string2, String string3) {
        super(context, string2);
        v(string3);
    }

    public k(Context context, String string2, String string3, g g4) {
        super(context, string2, string3);
    }

    public static final void y(com.facebook.internal.k k) {
        super.cancel();
    }

    @Override // com.facebook.internal.d0
    public void cancel() {
        boolean shown;
        WebView view = n();
        if (p() && !o() && view != null) {
            if (!o()) {
                if (view != null) {
                    if (!view.isShown()) {
                    } else {
                        if (this.I) {
                        }
                    }
                    this.I = true;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("javascript:");
                    stringBuilder.append("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
                    view.loadUrl(stringBuilder.toString());
                    Handler handler = new Handler(Looper.getMainLooper());
                    k.b bVar = new k.b(this);
                    handler.postDelayed(bVar, (long)i2);
                }
            }
        }
        super.cancel();
    }

    @Override // com.facebook.internal.d0
    public Bundle r(String string) {
        boolean z;
        boolean z2;
        String string2;
        String string3;
        Uri obj4 = Uri.parse(string);
        n.e(obj4, "responseUri");
        obj4 = b0.i0(obj4.getQuery());
        String str2 = "bridge_args";
        string2 = obj4.getString(str2);
        obj4.remove(str2);
        final String str7 = "Unable to parse bridge_args JSON";
        if (!b0.W(string2)) {
            JSONObject jSONObject2 = new JSONObject(string2);
            obj4.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", c.a(jSONObject2));
        }
        String str3 = "method_results";
        string3 = obj4.getString(str3);
        obj4.remove(str3);
        if (!b0.W(string3)) {
            JSONObject jSONObject = new JSONObject(string3);
            obj4.putBundle("com.facebook.platform.protocol.RESULT_ARGS", c.a(jSONObject));
        }
        obj4.remove("version");
        obj4.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", w.v());
        return obj4;
    }
}
