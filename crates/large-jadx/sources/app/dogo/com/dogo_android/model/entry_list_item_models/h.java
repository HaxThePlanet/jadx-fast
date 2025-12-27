package app.dogo.com.dogo_android.model.entry_list_item_models;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements e {

    public final /* synthetic */ EntryPhotoBaseObservable a;
    public final /* synthetic */ String b;
    public /* synthetic */ h(EntryPhotoBaseObservable entryPhotoBaseObservable, String str) {
        super();
        this.a = entryPhotoBaseObservable;
        this.b = str;
    }

    public final void onComplete(j jVar) {
        this.a.b(this.b, jVar);
    }
}
