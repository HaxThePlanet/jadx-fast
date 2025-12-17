package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* loaded from: classes.dex */
public final class z implements View.OnFocusChangeListener {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder a;
    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable b;
    public z(app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder entryViewHolder, app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable entryPhotoBaseObservable2) {
        super();
        this.a = entryViewHolder;
        this.b = entryPhotoBaseObservable2;
    }

    @Override // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        this.a.b(this.b, view, z2);
    }
}
