package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.g;
import kotlin.d0.c.a;

/* loaded from: classes.dex */
public final class p0 implements g {

    public final a a;
    public p0(a a) {
        super();
        this.a = a;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        l2.m(this.a, (FileDownloadTask.TaskSnapshot)object);
    }
}
