package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class z implements View.OnFocusChangeListener {

    public final /* synthetic */ EntryViewHolder a;
    public final /* synthetic */ EntryPhotoBaseObservable b;
    public /* synthetic */ z(EntryViewHolder entryViewHolder, EntryPhotoBaseObservable entryPhotoBaseObservable) {
        super();
        this.a = entryViewHolder;
        this.b = entryPhotoBaseObservable;
    }

    @Override // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        this.a.b(this.b, view, z);
    }
}
