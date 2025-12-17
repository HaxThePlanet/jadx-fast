package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.u.f;

/* loaded from: classes.dex */
public class pf extends app.dogo.com.dogo_android.h.of {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout V;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        pf.Y = sparseIntArray;
        sparseIntArray.put(2131362690, 4);
        sparseIntArray.put(2131361985, 5);
        sparseIntArray.put(2131363421, 6);
        sparseIntArray.put(2131362411, 7);
        sparseIntArray.put(2131362700, 8);
    }

    public pf(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, pf.X, pf.Y));
    }

    private pf(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        super(e, view2, 1, (ImageView)object3Arr3[5], (TextView)object3Arr3[7], (KonfettiView)object3Arr3[4], (TextView)object3Arr3[8], (ImageView)object3Arr3[1], (Button)object3Arr3[3], (TextView)object3Arr3[6], (Button)object3Arr3[2]);
        obj20.W = -1;
        Object obj10 = object3Arr3[0];
        obj20.V = (ConstraintLayout)obj10;
        int i11 = 0;
        obj10.setTag(i11);
        obj20.R.setTag(i11);
        obj20.S.setTag(i11);
        obj20.T.setTag(i11);
        View view3 = view2;
        N(view2);
        A();
    }

    private boolean W(LiveData<y<Boolean>> liveData, int i2) {
        if (i2 == 0) {
            this.W = obj3 |= i;
            return 1;
            synchronized (this) {
                this.W = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.of
    public void A() {
        this.W = 4;
        I();
        return;
        synchronized (this) {
            this.W = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.of
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.of
    public boolean O(int i, Object object2) {
        int obj2;
        if (179 == i) {
            V((f)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.of
    public void V(f f) {
        this.U = f;
        this.W = l |= i2;
        notifyPropertyChanged(179);
        super.I();
        return;
        synchronized (this) {
            this.U = f;
            this.W = l |= i2;
            notifyPropertyChanged(179);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.of
    protected void m() {
        long l;
        int cmp;
        int fVar;
        int cmp2;
        int animation;
        int i5;
        int value;
        int i3;
        int result;
        int i2;
        int i;
        int i4;
        l = this.W;
        final int i7 = 0;
        this.W = i7;
        fVar = this.U;
        final int i8 = 7;
        animation = Long.compare(i9, i7);
        i5 = 0;
        synchronized (this) {
            l = this.W;
            i7 = 0;
            this.W = i7;
            fVar = this.U;
            i8 = 7;
            animation = Long.compare(i9, i7);
            i5 = 0;
        }
        try {
            if (fVar != null) {
            } else {
            }
            result = fVar.getResult();
            result = value;
            Q(i5, result);
            if (result != null) {
            }
            value = result.getValue();
            i2 = fVar.l(value);
            fVar = fVar.k(value);
        }
        i2 = fVar;
        if (animation != 0) {
            i4 = i2 != 0 ? 64 : 32;
            l |= i4;
        }
        if (Long.compare(i4, i7) != 0) {
            i4 = fVar != 0 ? 16 : 8;
            l |= i4;
        }
        animation = 4;
        i3 = i2 != 0 ? i5 : animation;
        if (fVar != 0) {
        } else {
            i5 = animation;
        }
        if (Long.compare(i, i7) != 0) {
            n.X(this.V, this.P);
            n.o0(this.R, AnimationUtils.loadAnimation(w().getContext(), 2130772022));
        }
        if (Long.compare(i6, i7) != 0) {
            this.S.setVisibility(i5);
            this.T.setVisibility(i3);
        }
    }

    @Override // app.dogo.com.dogo_android.h.of
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
