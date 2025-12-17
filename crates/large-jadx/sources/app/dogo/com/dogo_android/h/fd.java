package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.t.g0.i;
import app.dogo.com.dogo_android.t.g0.j.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* loaded from: classes.dex */
public class fd extends app.dogo.com.dogo_android.h.ed {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        fd.X = sparseIntArray;
        sparseIntArray.put(2131363433, 2);
        sparseIntArray.put(2131363193, 3);
        sparseIntArray.put(2131361858, 4);
        sparseIntArray.put(2131362178, 5);
    }

    public fd(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, fd.W, fd.X));
    }

    private fd(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (FrameLayout)object3Arr3[4], (AppCompatImageView)object3Arr3[5], (RecyclerView)object3Arr3[1], (EditText)object3Arr3[3], (MaterialToolbar)object3Arr3[2]);
        this.V = -1;
        Object obj11 = object3Arr3[0];
        this.U = (ConstraintLayout)obj11;
        final int obj13 = 0;
        obj11.setTag(obj13);
        this.P.setTag(obj13);
        N(view2);
        A();
    }

    private boolean X(LiveData<y<List<Article>>> liveData, int i2) {
        if (i2 == 0) {
            this.V = obj3 |= i;
            return 1;
            synchronized (this) {
                this.V = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ed
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ed
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ed
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((j.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((i)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ed
    public void V(j.a j$a) {
        this.T = a;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.T = a;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ed
    public void W(i i) {
        this.S = i;
        this.V = l |= i3;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = i;
            this.V = l |= i3;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ed
    protected void m() {
        int cmp;
        int value;
        int result;
        int i;
        result = 0;
        this.V = result;
        final i iVar = this.S;
        cmp = Long.compare(i2, result);
        synchronized (this) {
            result = 0;
            this.V = result;
            iVar = this.S;
            cmp = Long.compare(i2, result);
        }
        try {
            if (iVar != null) {
            } else {
            }
            result = iVar.getResult();
            result = value;
            Q(0, result);
            if (result != null) {
            }
            value = result.getValue();
            if (cmp != 0) {
            }
            n.N(this.P, value, this.T, this.Q, 2131558778);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ed
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
