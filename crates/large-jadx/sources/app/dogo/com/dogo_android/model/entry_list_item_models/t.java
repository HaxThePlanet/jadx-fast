package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.util.n0.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class t implements View.OnClickListener {

    public final /* synthetic */ EntryUserPhotoItem.ViewHolder a;
    public final /* synthetic */ ViewPager b;
    public final /* synthetic */ e c;
    public /* synthetic */ t(EntryUserPhotoItem.ViewHolder viewHolder, ViewPager viewPager, e eVar) {
        super();
        this.a = viewHolder;
        this.b = viewPager;
        this.c = eVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.g(this.b, this.c, view);
    }
}
