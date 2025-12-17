package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.a;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.i.m0.a;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public class h7 extends app.dogo.com.dogo_android.h.g7 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final MaterialCardView R;
    private long S;
    static {
    }

    public h7(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, h7.T, h7.U));
    }

    private h7(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[1], (SwitchMaterial)object3Arr3[2]);
        this.S = -1;
        Object obj8 = object3Arr3[0];
        this.R = (MaterialCardView)obj8;
        final int obj10 = 0;
        obj8.setTag(obj10);
        this.O.setTag(obj10);
        this.P.setTag(obj10);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.g7
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g7
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.g7
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((m0.a)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.g7
    public void V(m0.a m0$a) {
        this.Q = a;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = a;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g7
    protected void m() {
        int cmp;
        int i;
        int i2;
        final int i4 = 0;
        this.S = i4;
        i = 0;
        final m0.a aVar = this.Q;
        i2 = 0;
        cmp = Long.compare(i3, i4);
        synchronized (this) {
            i4 = 0;
            this.S = i4;
            i = 0;
            aVar = this.Q;
            i2 = 0;
            cmp = Long.compare(i3, i4);
        }
        try {
            if (aVar != null) {
            }
            i = aVar.b();
            i2 = aVar.c();
            if (cmp != 0) {
            }
            g.c(this.O, i);
            a.a(this.P, i2);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.g7
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
