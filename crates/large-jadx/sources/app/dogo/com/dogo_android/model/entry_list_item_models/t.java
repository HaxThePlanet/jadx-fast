package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.util.n0.e;

/* loaded from: classes.dex */
public final class t implements View.OnClickListener {

    public final app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder a;
    public final ViewPager b;
    public final e c;
    public t(app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder entryUserPhotoItem$ViewHolder, ViewPager viewPager2, e e3) {
        super();
        this.a = viewHolder;
        this.b = viewPager2;
        this.c = e3;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.g(this.b, this.c, view);
    }
}
