package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import app.dogo.com.dogo_android.util.n0.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class q implements DialogInterface.OnClickListener {

    public final /* synthetic */ EntryUserPhotoItem.ViewHolder a;
    public final /* synthetic */ e b;
    public /* synthetic */ q(EntryUserPhotoItem.ViewHolder viewHolder, e eVar) {
        super();
        this.a = viewHolder;
        this.b = eVar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.k(this.b, dialogInterface, i);
    }
}
