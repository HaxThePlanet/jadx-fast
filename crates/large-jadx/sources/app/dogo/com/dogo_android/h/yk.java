package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;

/* loaded from: classes.dex */
public abstract class yk extends ViewDataBinding {

    public final RecyclerView O;
    public final Button P;
    protected LibrarySection Q;
    protected o.a R;
    protected g S;
    protected yk(Object object, View view2, int i3, ImageView imageView4, RecyclerView recyclerView5, Button button6) {
        super(object, view2, i3);
        this.O = recyclerView5;
        this.P = button6;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o.a o$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(LibrarySection librarySection);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g g);
}
