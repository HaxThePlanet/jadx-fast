package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import i.b.c0;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f0 implements e {

    public final /* synthetic */ c0 a;
    public final /* synthetic */ String b;
    public /* synthetic */ f0(c0 c0Var, String str) {
        super();
        this.a = c0Var;
        this.b = str;
    }

    public final void onComplete(j jVar) {
        CloudFunctionsService.r(this.a, this.b, jVar);
    }
}
