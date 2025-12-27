package app.dogo.com.dogo_android.f;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final /* synthetic */ ViewPager2 a;
    public /* synthetic */ b(ViewPager2 viewPager2) {
        super();
        this.a = viewPager2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        TrainingBindingAdapters.c(this.a, view);
    }
}
