package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.n.k.n.b;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;

/* loaded from: classes.dex */
public abstract class wk extends ViewDataBinding {

    public final RecyclerView O;
    public final Button P;
    protected LibrarySection Q;
    protected n.b R;
    protected g S;
    protected wk(Object object, View view2, int i3, RecyclerView recyclerView4, Button button5) {
        super(object, view2, i3);
        this.O = recyclerView4;
        this.P = button5;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(n.b n$b);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(LibrarySection librarySection);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g g);
}
