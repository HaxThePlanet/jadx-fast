package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.util.e0.a0;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class w implements e {

    public final /* synthetic */ EntryUserPhotoObservable a;
    public final /* synthetic */ a0 b;
    public /* synthetic */ w(EntryUserPhotoObservable entryUserPhotoObservable, a0 a0Var) {
        super();
        this.a = entryUserPhotoObservable;
        this.b = a0Var;
    }

    public final void onComplete(j jVar) {
        this.a.h(this.b, jVar);
    }
}
