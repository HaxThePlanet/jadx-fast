package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.a2;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    public final /* synthetic */ EntryOldPhotoItem.ViewHolder a;
    public final /* synthetic */ a2 b;
    public /* synthetic */ f(EntryOldPhotoItem.ViewHolder viewHolder, a2 a2Var) {
        super();
        this.a = viewHolder;
        this.b = a2Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.m(this.b, view);
    }
}
