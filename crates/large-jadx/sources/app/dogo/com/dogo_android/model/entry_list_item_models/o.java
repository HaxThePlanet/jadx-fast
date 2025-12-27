package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.c2;
import app.dogo.com.dogo_android.util.n0.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class o implements View.OnClickListener {

    public final /* synthetic */ EntryPhotoItem.ViewHolder a;
    public final /* synthetic */ e b;
    public final /* synthetic */ c2 c;
    public /* synthetic */ o(EntryPhotoItem.ViewHolder viewHolder, e eVar, c2 c2Var) {
        super();
        this.a = viewHolder;
        this.b = eVar;
        this.c = c2Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.m(this.b, this.c, view);
    }
}
