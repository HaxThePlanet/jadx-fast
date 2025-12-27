package app.dogo.com.dogo_android.util.n0;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final /* synthetic */ ViewGroup a;
    public /* synthetic */ c(ViewGroup viewGroup) {
        super();
        this.a = viewGroup;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        EntryImagePagerAdapter.getImageAt(this.a, view);
    }
}
