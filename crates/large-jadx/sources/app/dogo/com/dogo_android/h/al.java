package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.n.l.b.a;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;

/* compiled from: LayoutLibraryProgramListBinding.java */
/* loaded from: classes.dex */
public abstract class al extends ViewDataBinding {

    public final Button O;
    public final ViewPager2 P;
    protected LibrarySection Q;
    protected b.a R;
    protected g S;
    protected al(Object object, View view, int i, ImageView imageView, TextView textView, Button button, ViewPager2 viewPager2) {
        super(object, view, i);
        this.O = button;
        this.P = viewPager2;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(b.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(LibrarySection librarySection);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g gVar);
}
