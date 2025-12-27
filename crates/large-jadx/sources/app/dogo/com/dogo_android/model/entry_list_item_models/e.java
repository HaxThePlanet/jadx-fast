package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.a2;
import app.dogo.com.dogo_android.util.n0.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {

    public final /* synthetic */ EntryOldPhotoItem.ViewHolder a;
    public final /* synthetic */ e b;
    public final /* synthetic */ a2 c;
    public /* synthetic */ e(EntryOldPhotoItem.ViewHolder viewHolder, e eVar, a2 a2Var) {
        super();
        this.a = viewHolder;
        this.b = eVar;
        this.c = a2Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.e(this.b, this.c, view);
    }
}
