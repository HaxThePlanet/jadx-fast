package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.x;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b", d2 = {"Lcom/facebook/login/GetTokenClient;", "Lcom/facebook/internal/PlatformServiceClient;", "context", "Landroid/content/Context;", "request", "Lcom/facebook/login/LoginClient$Request;", "(Landroid/content/Context;Lcom/facebook/login/LoginClient$Request;)V", "populateRequestBundle", "", "data", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class g extends x {
    public g(Context context, com.facebook.login.l.d l$d2) {
        n.f(context, "context");
        n.f(d2, "request");
        final String str4 = d2.a();
        n.e(str4, "request.applicationId");
        super(context, 65536, 65537, 20121101, str4, d2.j());
    }

    @Override // com.facebook.internal.x
    protected void d(Bundle bundle) {
        n.f(bundle, "data");
    }
}
