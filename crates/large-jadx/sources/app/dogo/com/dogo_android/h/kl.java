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
public abstract class kl extends ViewDataBinding {

    public final Button O;
    public final RecyclerView P;
    protected LibrarySection Q;
    protected o.a R;
    protected g S;
    protected kl(Object object, View view2, int i3, ImageView imageView4, Button button5, RecyclerView recyclerView6) {
        super(object, view2, i3);
        this.O = button5;
        this.P = recyclerView6;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o.a o$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(LibrarySection librarySection);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g g);
}
