package com.facebook.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.o;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0008", d2 = {"Lcom/facebook/internal/InstagramCustomTab;", "Lcom/facebook/internal/CustomTab;", "action", "", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class r extends com.facebook.internal.e {

    public static final com.facebook.internal.r.a c;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¨\u0006\t", d2 = {"Lcom/facebook/internal/InstagramCustomTab$Companion;", "", "()V", "getURIForAction", "Landroid/net/Uri;", "action", "", "parameters", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final Uri a(String string, Bundle bundle2) {
            String str2;
            StringBuilder stringBuilder;
            String str;
            Uri obj4;
            n.f(string, "action");
            if (n.b(string, "oauth")) {
                obj4 = b0.f(z.j(), "oauth/authorize", bundle2);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(o.p());
                stringBuilder.append("/");
                stringBuilder.append("dialog/");
                stringBuilder.append(string);
                obj4 = b0.f(z.j(), stringBuilder.toString(), bundle2);
            }
            return obj4;
        }
    }
    static {
        r.a aVar = new r.a(0);
        r.c = aVar;
    }

    public r(String string, Bundle bundle2) {
        Bundle obj3;
        n.f(string, "action");
        super(string, bundle2);
        if (bundle2 == null) {
            obj3 = new Bundle();
        }
        c(r.c.a(string, obj3));
    }
}
