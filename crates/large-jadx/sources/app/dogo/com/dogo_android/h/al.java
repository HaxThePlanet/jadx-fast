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

/* loaded from: classes.dex */
public abstract class al extends ViewDataBinding {

    public final Button O;
    public final ViewPager2 P;
    protected LibrarySection Q;
    protected b.a R;
    protected g S;
    protected al(Object object, View view2, int i3, ImageView imageView4, TextView textView5, Button button6, ViewPager2 viewPager27) {
        super(object, view2, i3);
        this.O = button6;
        this.P = viewPager27;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(b.a b$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(LibrarySection librarySection);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g g);
}
