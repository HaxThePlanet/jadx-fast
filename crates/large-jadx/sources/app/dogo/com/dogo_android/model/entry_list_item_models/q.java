package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import app.dogo.com.dogo_android.util.n0.e;

/* loaded from: classes.dex */
public final class q implements DialogInterface.OnClickListener {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder a;
    public final e b;
    public q(app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder entryUserPhotoItem$ViewHolder, e e2) {
        super();
        this.a = viewHolder;
        this.b = e2;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.a.k(this.b, dialogInterface, i2);
    }
}
