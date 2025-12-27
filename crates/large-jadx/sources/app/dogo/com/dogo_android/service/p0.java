package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.g;
import kotlin.d0.c.a;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class p0 implements g {

    public final /* synthetic */ a a;
    public /* synthetic */ p0(a aVar) {
        super();
        this.a = aVar;
    }

    public final void onSuccess(Object object) {
        FireBaseStorageService.d(this.a, object);
    }
}
