package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.util.e0.a0;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class w implements e {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoObservable a;
    public final a0 b;
    public w(app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoObservable entryUserPhotoObservable, a0 a02) {
        super();
        this.a = entryUserPhotoObservable;
        this.b = a02;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        this.a.h(this.b, j);
    }
}
