package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.util.n0.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final /* synthetic */ EntryOldPhotoItem.ViewHolder a;
    public final /* synthetic */ e b;
    public /* synthetic */ d(EntryOldPhotoItem.ViewHolder viewHolder, e eVar) {
        super();
        this.a = viewHolder;
        this.b = eVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.i(this.b, view);
    }
}
