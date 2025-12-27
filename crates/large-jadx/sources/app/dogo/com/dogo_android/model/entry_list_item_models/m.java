package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.c2;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class m implements View.OnClickListener {

    public final /* synthetic */ EntryPhotoItem.ViewHolder a;
    public final /* synthetic */ c2 b;
    public /* synthetic */ m(EntryPhotoItem.ViewHolder viewHolder, c2 c2Var) {
        super();
        this.a = viewHolder;
        this.b = c2Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.o(this.b, view);
    }
}
