package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class g0 implements c {

    public final /* synthetic */ String a;
    public /* synthetic */ g0(String str) {
        super();
        this.a = str;
    }

    public final Object then(j jVar) {
        return CloudFunctionsService.n(this.a, jVar);
    }
}
