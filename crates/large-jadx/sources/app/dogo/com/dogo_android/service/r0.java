package app.dogo.com.dogo_android.service;

import com.google.firebase.storage.OnProgressListener;
import kotlinx.coroutines.channels.q;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class r0 implements OnProgressListener {

    public final /* synthetic */ q a;
    public /* synthetic */ r0(q qVar) {
        super();
        this.a = qVar;
    }

    public final void onProgress(Object object) {
        l2.d.e(this.a, object);
    }
}
