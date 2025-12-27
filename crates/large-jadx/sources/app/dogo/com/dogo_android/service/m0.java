package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import com.google.firebase.storage.StorageReference;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class m0 implements c {

    public final /* synthetic */ StorageReference a;
    public /* synthetic */ m0(StorageReference storageReference) {
        super();
        this.a = storageReference;
    }

    public final Object then(j jVar) {
        return FireBaseStorageService.v(this.a, jVar);
    }
}
