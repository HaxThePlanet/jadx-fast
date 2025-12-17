package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.b0.e;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class zf extends app.dogo.com.dogo_android.h.yf {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final ConstraintLayout W;
    private long X;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zf.Z = sparseIntArray;
        sparseIntArray.put(2131363433, 5);
        sparseIntArray.put(2131362690, 6);
        sparseIntArray.put(2131363414, 7);
        sparseIntArray.put(2131361931, 8);
        sparseIntArray.put(2131362483, 9);
        sparseIntArray.put(2131362570, 10);
    }

    public zf(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 11, zf.Y, zf.Z));
    }

    private zf(e e, View view2, Object[] object3Arr3) {
        final Object obj24 = this;
        super(e, view2, 0, (TextView)object3Arr3[3], (CardView)object3Arr3[8], (ImageView)object3Arr3[9], (MaterialButton)object3Arr3[10], (KonfettiView)object3Arr3[6], (ConstraintLayout)object3Arr3[1], (WebView)object3Arr3[4], (TextView)object3Arr3[2], (TextView)object3Arr3[7], (MaterialToolbar)object3Arr3[5]);
        obj24.X = -1;
        int i13 = 0;
        obj24.O.setTag(i13);
        obj24.R.setTag(i13);
        Object obj12 = object3Arr3[0];
        obj24.W = (ConstraintLayout)obj12;
        obj12.setTag(i13);
        obj24.S.setTag(i13);
        obj24.T.setTag(i13);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yf
    public void A() {
        this.X = 2;
        I();
        return;
        synchronized (this) {
            this.X = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yf
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.yf
    public boolean O(int i, Object object2) {
        int obj2;
        if (179 == i) {
            V((e)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.yf
    public void V(e e) {
        this.V = e;
        this.X = l |= i2;
        notifyPropertyChanged(179);
        super.I();
        return;
        synchronized (this) {
            this.V = e;
            this.X = l |= i2;
            notifyPropertyChanged(179);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yf
    protected void m() {
        int cmp2;
        nl.dionsegijn.konfetti.KonfettiView view;
        int i2;
        int i;
        int cmp;
        int question;
        int i3;
        int i4;
        long l = this.X;
        final int i6 = 0;
        this.X = i6;
        e eVar = this.V;
        cmp = Long.compare(i9, i6);
        question = 0;
        synchronized (this) {
            l = this.X;
            i6 = 0;
            this.X = i6;
            eVar = this.V;
            cmp = Long.compare(i9, i6);
            question = 0;
        }
        try {
            if (eVar != null) {
            } else {
            }
            i3 = eVar.i();
            i2 = eVar.h();
            i3 = i2;
            if (i3 != 0) {
            }
            question = i3.getQuestion();
            question = i2;
            i = i4;
            i3 = i;
        }
        if (cmp != 0) {
            g.c(this.O, question);
            l.D(this.S, i3, this.P);
            g.c(this.T, i);
        }
        if (Long.compare(i5, i6) != 0) {
            n.X(this.R, this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yf
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
