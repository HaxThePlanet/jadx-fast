package app.dogo.com.dogo_android.model.entry_list_item_models;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class i implements e {

    public final /* synthetic */ EntryPhotoBaseObservable a;
    public final /* synthetic */ String b;
    public /* synthetic */ i(EntryPhotoBaseObservable entryPhotoBaseObservable, String str) {
        super();
        this.a = entryPhotoBaseObservable;
        this.b = str;
    }

    public final void onComplete(j jVar) {
        this.a.d(this.b, jVar);
    }
}
