package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class d0 extends app.dogo.com.dogo_android.h.c0 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final RelativeLayout Q;
    private long R;
    static {
    }

    public d0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, d0.S, d0.T));
    }

    private d0(e e, View view2, Object[] object3Arr3) {
        final int i3 = 0;
        super(e, view2, i3, (TextView)object3Arr3[1]);
        this.R = -1;
        int i2 = 0;
        this.O.setTag(i2);
        Object obj5 = object3Arr3[i3];
        this.Q = (RelativeLayout)obj5;
        obj5.setTag(i2);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c0
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c0
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.c0
    public boolean O(int i, Object object2) {
        int obj2;
        if (24 == i) {
            V((DogBreed)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.c0
    public void V(DogBreed dogBreed) {
        this.P = dogBreed;
        this.R = l |= i2;
        notifyPropertyChanged(24);
        super.I();
        return;
        synchronized (this) {
            this.P = dogBreed;
            this.R = l |= i2;
            notifyPropertyChanged(24);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c0
    protected void m() {
        int cmp;
        int name;
        final int i2 = 0;
        this.R = i2;
        final DogBreed dogBreed = this.P;
        name = 0;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.R = i2;
            dogBreed = this.P;
            name = 0;
            cmp = Long.compare(i, i2);
        }
        try {
            if (dogBreed != null) {
            }
            name = dogBreed.getName();
            if (cmp != 0) {
            }
            n.B(this.O, name);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.c0
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
