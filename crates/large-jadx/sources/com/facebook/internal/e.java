package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.g0.i.a;
import com.facebook.login.b;
import com.facebook.login.b.a;
import com.facebook.o;
import d.c.b.c;
import d.c.b.c.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0003R\u001a\u0010\u0007\u001a\u00020\u0008X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000c¨\u0006\u0013", d2 = {"Lcom/facebook/internal/CustomTab;", "", "action", "", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "openCustomTab", "", "activity", "Landroid/app/Activity;", "packageName", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public class e {

    public static final com.facebook.internal.e.a b;
    private Uri a;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0017¨\u0006\t", d2 = {"Lcom/facebook/internal/CustomTab$Companion;", "", "()V", "getURIForAction", "Landroid/net/Uri;", "action", "", "parameters", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public Uri a(String string, Bundle bundle2) {
            n.f(string, "action");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(o.p());
            stringBuilder.append("/");
            stringBuilder.append("dialog/");
            stringBuilder.append(string);
            return b0.f(z.b(), stringBuilder.toString(), bundle2);
        }
    }
    static {
        e.a aVar = new e.a(0);
        e.b = aVar;
    }

    public e(String string, Bundle bundle2) {
        Bundle obj3;
        n.f(string, "action");
        super();
        if (bundle2 == null) {
            obj3 = new Bundle();
        }
        this.a = e.b.a(string, obj3);
    }

    public static Uri a(String string, Bundle bundle2) {
        if (a.d(e.class)) {
            return null;
        }
        return e.b.a(string, bundle2);
    }

    public final boolean b(Activity activity, String string2) {
        if (a.d(this)) {
            return 0;
        }
        n.f(activity, "activity");
        c.a aVar2 = new c.a(b.v.b());
        c cVar = aVar2.a();
        cVar.a.setPackage(string2);
        cVar.a(activity, this.a);
        return 1;
    }

    protected final void c(Uri uri) {
        if (a.d(this)) {
        }
        n.f(uri, "<set-?>");
        this.a = uri;
    }
}
