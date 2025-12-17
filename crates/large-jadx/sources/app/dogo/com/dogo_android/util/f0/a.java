package app.dogo.com.dogo_android.util.f0;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final ViewPager a;
    public a(ViewPager viewPager) {
        super();
        this.a = viewPager;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.d(this.a, view);
    }
}
