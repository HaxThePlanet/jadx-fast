package app.dogo.com.dogo_android.model.entry_list_item_models;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class h implements e {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable a;
    public final String b;
    public h(app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable entryPhotoBaseObservable, String string2) {
        super();
        this.a = entryPhotoBaseObservable;
        this.b = string2;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        this.a.b(this.b, j);
    }
}
