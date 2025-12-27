package app.dogo.com.dogo_android.util.f0;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.viewpager.widget.ViewPager;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ ViewPager a;
    public /* synthetic */ a(ViewPager viewPager) {
        super();
        this.a = viewPager;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        app.dogo.com.dogo_android.util.binding.m.d(this.a, view);
    }
}
