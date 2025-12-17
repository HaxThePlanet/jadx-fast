package app.dogo.com.dogo_android.service;

import com.google.firebase.storage.OnProgressListener;
import kotlinx.coroutines.channels.q;

/* loaded from: classes.dex */
public final class r0 implements OnProgressListener {

    public final q a;
    public r0(q q) {
        super();
        this.a = q;
    }

    @Override // com.google.firebase.storage.OnProgressListener
    public final void onProgress(Object object) {
        l2.d.n(this.a, (UploadTask.TaskSnapshot)object);
    }
}
