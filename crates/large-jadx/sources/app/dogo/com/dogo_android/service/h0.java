package app.dogo.com.dogo_android.service;

import i.b.c0;
import i.b.e0;
import java.util.Map;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h0 implements e0 {

    public final /* synthetic */ i2 a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ String c;
    public /* synthetic */ h0(i2 i2Var, Map map, String str) {
        super();
        this.a = i2Var;
        this.b = map;
        this.c = str;
    }

    public final void a(c0 c0Var) {
        CloudFunctionsService.j(this.a, this.b, this.c, c0Var);
    }
}
