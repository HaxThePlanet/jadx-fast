package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class s implements View.OnClickListener {

    public final /* synthetic */ EntryUserPhotoItem.ViewHolder a;
    public /* synthetic */ s(EntryUserPhotoItem.ViewHolder viewHolder) {
        super();
        this.a = viewHolder;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.i(view);
    }
}
