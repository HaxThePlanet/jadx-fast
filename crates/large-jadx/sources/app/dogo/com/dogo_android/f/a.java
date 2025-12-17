package app.dogo.com.dogo_android.f;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final ViewPager2 a;
    public a(ViewPager2 viewPager2) {
        super();
        this.a = viewPager2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        i.f(this.a, view);
    }
}
