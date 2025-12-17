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
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.n.j;

/* loaded from: classes.dex */
public class fa extends app.dogo.com.dogo_android.h.ea {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S;
    private final ConstraintLayout P;
    private long Q;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        fa.S = sparseIntArray;
        sparseIntArray.put(2131363001, 1);
    }

    public fa(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, fa.R, fa.S));
    }

    private fa(e e, View view2, Object[] object3Arr3) {
        int i = 1;
        super(e, view2, i, (ContentLoadingProgressBar)object3Arr3[i]);
        this.Q = -1;
        Object obj3 = object3Arr3[0];
        this.P = (ConstraintLayout)obj3;
        obj3.setTag(0);
        N(view2);
        A();
    }

    private boolean U(LiveData<y<CertificateInfo>> liveData, int i2) {
        if (i2 == 0) {
            this.Q = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Q = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ea
    public void A() {
        this.Q = 4;
        I();
        return;
        synchronized (this) {
            this.Q = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ea
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return U((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ea
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            T((j)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ea
    public void T(j j) {
        this.O = j;
        this.Q = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.O = j;
            this.Q = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ea
    protected void m() {
        int cmp;
        int value;
        int result;
        int i;
        result = 0;
        this.Q = result;
        final j jVar = this.O;
        cmp = Long.compare(i2, result);
        synchronized (this) {
            result = 0;
            this.Q = result;
            jVar = this.O;
            cmp = Long.compare(i2, result);
        }
        try {
            if (jVar != null) {
            } else {
            }
            result = jVar.getResult();
            result = value;
            Q(0, result);
            if (result != null) {
            }
            value = result.getValue();
            if (cmp != 0) {
            }
            n.D0(this.P, value);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ea
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
