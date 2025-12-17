package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.u.m.v.a;
import app.dogo.com.dogo_android.u.m.x;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import java.util.List;

/* loaded from: classes.dex */
public class ba extends app.dogo.com.dogo_android.h.aa {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0;
    private long Y;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ba.a0 = sparseIntArray;
        sparseIntArray.put(2131363185, 6);
        sparseIntArray.put(2131363441, 7);
        sparseIntArray.put(2131363414, 8);
        sparseIntArray.put(2131363529, 9);
        sparseIntArray.put(2131362298, 10);
        sparseIntArray.put(2131362322, 11);
        sparseIntArray.put(2131362505, 12);
    }

    public ba(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 13, ba.Z, ba.a0));
    }

    private ba(e e, View view2, Object[] object3Arr3) {
        Object obj4 = this;
        super(e, view2, 1, (ConstraintLayout)object3Arr3[0], (TextView)object3Arr3[10], (ImageView)object3Arr3[11], (MaterialButton)object3Arr3[12], (RecyclerView)object3Arr3[5], (NestedScrollView)object3Arr3[6], (ImageView)object3Arr3[1], (TextView)object3Arr3[8], (FrameLayout)object3Arr3[3], (MaterialToolbar)object3Arr3[7], (ImageView)object3Arr3[2], (TextView)object3Arr3[4], (View)object3Arr3[9]);
        Object obj3 = this;
        obj3.Y = -1;
        int i2 = 0;
        obj3.O.setTag(i2);
        obj3.Q.setTag(i2);
        obj3.R.setTag(i2);
        obj3.S.setTag(i2);
        obj3.U.setTag(i2);
        obj3.V.setTag(i2);
        obj3.N(view2);
        A();
    }

    private boolean X(x<y<List<TrickItem>>> x, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.aa
    public void A() {
        this.Y = 8;
        I();
        return;
        synchronized (this) {
            this.Y = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.aa
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.aa
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((v.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((x)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.aa
    public void V(v.a v$a) {
        this.X = a;
        this.Y = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.X = a;
            this.Y = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.aa
    public void W(x x) {
        this.W = x;
        this.Y = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.W = x;
            this.Y = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.aa
    protected void m() {
        int cmp;
        int cmp2;
        x xVar;
        int animation;
        int cmp3;
        int cmp4;
        int name;
        int imageUrl;
        int i;
        long l = this.Y;
        final int i3 = 0;
        this.Y = i3;
        x xVar2 = this.W;
        cmp3 = Long.compare(i7, i3);
        final int i8 = 12;
        final int i9 = 0;
        synchronized (this) {
            l = this.Y;
            i3 = 0;
            this.Y = i3;
            xVar2 = this.W;
            cmp3 = Long.compare(i7, i3);
            i8 = 12;
            i9 = 0;
        }
        try {
            if (Long.compare(i10, i3) != 0) {
            } else {
            }
            if (xVar2 != null) {
            } else {
            }
            cmp4 = xVar2.l();
            cmp4 = i9;
            if (cmp4 != null) {
            } else {
            }
            imageUrl = cmp4.getImageUrl();
            name = cmp4.getName();
            imageUrl = name;
        }
        if (xVar2 != null) {
            xVar = xVar2.k();
        } else {
            xVar = i9;
        }
        Q(0, xVar);
        if (xVar != null) {
            animation = xVar.getValue();
        } else {
            animation = i9;
        }
        if (cmp3 != 0) {
            l.L0(this.Q, animation, this.X);
        }
        if (Long.compare(i5, i3) != 0) {
            n.o0(this.R, AnimationUtils.loadAnimation(w().getContext(), 2130772022));
            n.k0(this.S, i9);
        }
        if (Long.compare(i2, i3) != 0) {
            n.n0(this.U, imageUrl);
            g.c(this.V, name);
        }
    }

    @Override // app.dogo.com.dogo_android.h.aa
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
