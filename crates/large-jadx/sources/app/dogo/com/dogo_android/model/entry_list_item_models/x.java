package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.util.n0.u;
import com.google.android.gms.tasks.g;

/* loaded from: classes.dex */
public final class x implements g {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoObservable a;
    public final u b;
    public x(app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoObservable entryUserPhotoObservable, u u2) {
        super();
        this.a = entryUserPhotoObservable;
        this.b = u2;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.a.l(this.b, (QuerySnapshot)object);
    }
}
