package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentNewsletterBenefitsBindingImpl.java */
/* loaded from: classes.dex */
public class pe extends oe {

    private static final ViewDataBinding.g W = new ViewDataBinding$g(18);
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout R;
    private final ConstraintLayout S;
    private final FrameLayout T;
    private final ok U;
    private long V;
    static {
        int i16 = 1;
        final int[] iArr2 = new int[i16];
        final int i34 = 0;
        iArr2[i34] = 3;
        int[] iArr = new int[i16];
        iArr[i34] = R.layout.layout_dog_creation_loading_spinner;
        obj.a(2, new String[] { "layout_dog_creation_loading_spinner" }, iArr2, iArr);
        obj.put(2131363433, 4);
        obj.put(2131362886, 5);
        obj.put(2131363414, 6);
        obj.put(2131362020, 7);
        obj.put(2131362023, 8);
        obj.put(2131362022, 9);
        obj.put(2131362026, 10);
        obj.put(2131362029, 11);
        obj.put(2131362028, 12);
        obj.put(2131362033, 13);
        obj.put(2131362036, 14);
        obj.put(2131362035, 15);
        obj.put(2131362322, 16);
        obj.put(2131361903, 17);
    }

    public pe(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 18, pe.W, pe.X));
    }

    private boolean W(LiveData<y<Boolean>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.oe
    public void A() {
        synchronized (this) {
            try {
                this.V = 4L;
            } catch (Throwable th) {
            }
        }
        this.U.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.oe
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.oe
    public void M(q qVar) {
        super.M(qVar);
        this.U.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.oe
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.oe
    public void V(app.dogo.com.dogo_android.o.e eVar) {
        this.Q = eVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.oe
    protected void m() {
        LiveData liveData;
        y yVar;
        int i = 0;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 7L & l;
        final Boolean bool = null;
        if (l4 != l3) {
            if (this.Q != null) {
                liveData = this.Q.i();
            } else {
                int i2 = bool;
            }
            i = 0;
            Q(i, liveData);
            Object value = this.Q != null ? (LoadResult)value : bool;
        }
        if (l4 != l3) {
            BindingAdapters.setTrainerAvatar(this.R, yVar);
            BindingAdapters.setDebugJsonEntryItemAdapter(this.T, yVar);
        }
        long l2 = l & 4L;
        if (this.V != l3) {
            BindingAdapters.k0(this.S, bool);
        }
        ViewDataBinding.o(this.U);
    }

    @Override // app.dogo.com.dogo_android.h.oe
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.U.y()) {
            return true;
        }
        return false;
    }

    private pe(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (Button)objectArr[17], (ImageView)objectArr[7], (TextView)objectArr[9], (TextView)objectArr[8], (ImageView)objectArr[10], (TextView)objectArr[12], (TextView)objectArr[11], (ImageView)objectArr[13], (TextView)objectArr[15], (TextView)objectArr[14], (ImageView)objectArr[16], (ImageView)objectArr[5], (TextView)objectArr[6], (MaterialToolbar)objectArr[4]);
        Object eVar3 = this;
        eVar3.V = -1L;
        Object obj = objectArr[0];
        eVar3.R = obj;
        Object obj5 = null;
        obj.setTag(obj5);
        Object obj2 = objectArr[1];
        eVar3.S = obj2;
        obj2.setTag(obj5);
        Object obj3 = objectArr[2];
        eVar3.T = obj3;
        obj3.setTag(obj5);
        Object obj4 = objectArr[3];
        eVar3.U = obj4;
        eVar3.L(obj4);
        eVar3.N(view);
        A();
    }
}
