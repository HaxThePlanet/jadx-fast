package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.y.d0.n.a;
import java.util.List;

/* loaded from: classes.dex */
public class nm extends app.dogo.com.dogo_android.h.mm {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final CardView R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        nm.U = sparseIntArray;
        sparseIntArray.put(2131363414, 2);
        sparseIntArray.put(2131362379, 3);
        sparseIntArray.put(2131362298, 4);
    }

    public nm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, nm.T, nm.U));
    }

    private nm(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[4], (TextView)object3Arr3[3], (RecyclerView)object3Arr3[1], (TextView)object3Arr3[2]);
        this.S = -1;
        int i6 = 0;
        this.O.setTag(i6);
        Object obj10 = object3Arr3[0];
        this.R = (CardView)obj10;
        obj10.setTag(i6);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.mm
    public void A() {
        this.S = 4;
        I();
        return;
        synchronized (this) {
            this.S = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mm
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.mm
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            T((n.a)object2);
            obj2 = 1;
        } else {
            if (103 == i) {
                U((List)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.mm
    public void T(n.a n$a) {
        this.P = a;
        this.S = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.P = a;
            this.S = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    public void U(List<TrickItem> list) {
        this.Q = list;
        this.S = l |= i2;
        notifyPropertyChanged(103);
        super.I();
        return;
        synchronized (this) {
            this.Q = list;
            this.S = l |= i2;
            notifyPropertyChanged(103);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mm
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.S = i2;
        synchronized (this) {
            i2 = 0;
            this.S = i2;
        }
        try {
            i.x(this.O, this.Q, this.P);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.mm
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
