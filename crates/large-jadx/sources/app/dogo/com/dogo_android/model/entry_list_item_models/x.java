package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.util.n0.u;
import com.google.android.gms.tasks.g;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class x implements g {

    public final /* synthetic */ EntryUserPhotoObservable a;
    public final /* synthetic */ u b;
    public /* synthetic */ x(EntryUserPhotoObservable entryUserPhotoObservable, u uVar) {
        super();
        this.a = entryUserPhotoObservable;
        this.b = uVar;
    }

    public final void onSuccess(Object object) {
        this.a.l(this.b, object);
    }
}
