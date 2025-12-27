package app.dogo.com.dogo_android.service;

import android.net.Uri;
import i.b.c0;
import i.b.e0;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class k0 implements e0 {

    public final /* synthetic */ k2 a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public /* synthetic */ k0(k2 k2Var, Uri uri, String str, String str2, String str3) {
        super();
        this.a = k2Var;
        this.b = uri;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public final void a(c0 c0Var) {
        DynamicLinkService.b(this.a, this.b, this.c, this.d, this.e, c0Var);
    }
}
