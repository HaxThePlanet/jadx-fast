package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.y.d0.n.a;
import java.util.List;

/* loaded from: classes.dex */
public abstract class mm extends ViewDataBinding {

    public final RecyclerView O;
    protected n.a P;
    protected List<TrickItem> Q;
    protected mm(Object object, View view2, int i3, TextView textView4, TextView textView5, RecyclerView recyclerView6, TextView textView7) {
        super(object, view2, i3);
        this.O = recyclerView6;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(n.a n$a);

    public abstract void U(List<TrickItem> list);
}
