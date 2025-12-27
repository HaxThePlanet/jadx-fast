package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.n.k.n.b;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;

/* compiled from: LayoutLibraryArticleListBinding.java */
/* loaded from: classes.dex */
public abstract class wk extends ViewDataBinding {

    public final RecyclerView O;
    public final Button P;
    protected LibrarySection Q;
    protected n.b R;
    protected g S;
    protected wk(Object object, View view, int i, RecyclerView recyclerView, Button button) {
        super(object, view, i);
        this.O = recyclerView;
        this.P = button;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(n.b bVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(LibrarySection librarySection);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g gVar);
}
