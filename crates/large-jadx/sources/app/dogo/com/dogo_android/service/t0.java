package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.g;
import kotlinx.coroutines.channels.q;

/* loaded from: classes.dex */
public final class t0 implements g {

    public final q a;
    public t0(q q) {
        super();
        this.a = q;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        l2.d.q(this.a, (UploadTask.TaskSnapshot)object);
    }
}
