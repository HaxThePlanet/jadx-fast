package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.a.a;
import app.dogo.com.dogo_android.r.l;
import app.dogo.com.dogo_android.util.f0.n;
import com.google.android.material.textfield.TextInputEditText;

/* compiled from: FragmentDogCreationReminderWithTimeBindingImpl.java */
/* loaded from: classes.dex */
public class xb extends wb implements a.a {

    private static final ViewDataBinding.g n0;
    private static final SparseIntArray o0 = new SparseIntArray();
    private final ConstraintLayout a0;
    private final TextInputEditText b0;
    private final TextInputEditText c0;
    private final CompoundButton.OnCheckedChangeListener d0;
    private final CompoundButton.OnCheckedChangeListener e0;
    private final CompoundButton.OnCheckedChangeListener f0;
    private final CompoundButton.OnCheckedChangeListener g0;
    private final CompoundButton.OnCheckedChangeListener h0;
    private final CompoundButton.OnCheckedChangeListener i0;
    private final CompoundButton.OnCheckedChangeListener j0;
    private androidx.databinding.g k0;
    private androidx.databinding.g l0;
    private long m0;

    class a implements androidx.databinding.g {

        final /* synthetic */ xb a;
        a() {
            this.a = xbVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.Z != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(g.a(this.a.b0));
                }
            }
        }
    }

    class b implements androidx.databinding.g {

        final /* synthetic */ xb a;
        b() {
            this.a = xbVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.Z != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(g.a(this.a.c0));
                }
            }
        }
    }
    static {
        obj.put(2131363433, 10);
        obj.put(2131363436, 11);
        obj.put(2131362876, 12);
        obj.put(2131362342, 13);
        obj.put(2131363414, 14);
        obj.put(2131362615, 15);
        obj.put(2131362617, 16);
        obj.put(2131362805, 17);
        obj.put(2131362616, 18);
        obj.put(2131362806, 19);
        obj.put(2131362282, 20);
        obj.put(2131362156, 21);
        obj.put(2131363172, 22);
    }

    public xb(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 23, xb.n0, xb.o0));
    }

    static /* synthetic */ TextInputEditText W(xb xbVar) {
        return xbVar.b0;
    }

    static /* synthetic */ TextInputEditText X(xb xbVar) {
        return xbVar.c0;
    }

    private boolean Y(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.m0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.m0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.wb
    public void A() {
        synchronized (this) {
            try {
                this.m0 = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.wb
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Z(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.wb
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

    @Override // app.dogo.com.dogo_android.h.wb
    public void V(l lVar) {
        this.Z = lVar;
        synchronized (this) {
            try {
                this.m0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wb
    public final void c(int i, CompoundButton compoundButton, boolean z) {
        int i3 = 0;
        i3 = 0;
        i3 = 1;
        switch (i) {
            case 1:
                this.Z.getCorrectedDay(i3, z);
                break;
            case 2:
                i3 = 2;
                this.Z.getCorrectedDay(2, z);
                break;
            case 3:
                i3 = 3;
                this.Z.getCorrectedDay(3, z);
                break;
            case 4:
                i3 = 4;
                this.Z.getCorrectedDay(4, z);
                break;
            case 5:
                i3 = 5;
                this.Z.getCorrectedDay(5, z);
                break;
            case 6:
                i3 = 6;
                this.Z.getCorrectedDay(6, z);
                break;
            case 7:
                i3 = 7;
                this.Z.getCorrectedDay(7, z);
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.wb
    protected void m() {
        Object obj;
        java.lang.CharSequence charSequence;
        Object obj2;
        int i2;
        java.lang.CharSequence charSequence2;
        long l = 0;
        int cmp4 = 1;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.m0 = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 15L & l2;
        long l6 = 14L;
        final long l8 = 13L;
        final androidx.databinding.k.g.c cVar = null;
        if (l5 != l4) {
            l = l2 & 13L;
            if (l != l4) {
                if (this.Z != null) {
                    x xVar2 = this.Z.t();
                } else {
                    int i6 = cVar;
                }
                Q(0, obj2);
                Object value2 = obj2 != null ? (String)value2 : cVar;
            }
            long l9 = l2 & 14L;
            if (l9 != l4) {
                if (this.Z != null) {
                    x xVar = this.Z.s();
                } else {
                    int i3 = cVar;
                }
                cmp4 = 1;
                Q(cmp4, obj);
                Object value = this.Z != null ? (String)value : cVar;
            }
        } else {
        }
        long l10 = 8L & l2;
        if (l10 != l4) {
            BindingAdapters.P(this.b0, 24);
            g.e(this.b0, cVar, cVar, cVar, this.k0);
            BindingAdapters.P(this.c0, 59);
            g.e(this.c0, cVar, cVar, cVar, this.l0);
            a.b(this.Q, this.j0, cVar);
            a.b(this.R, this.f0, cVar);
            a.b(this.S, this.i0, cVar);
            a.b(this.T, this.e0, cVar);
            a.b(this.U, this.h0, cVar);
            a.b(this.V, this.g0, cVar);
            a.b(this.W, this.d0, cVar);
        }
        long l7 = 14L & l2;
        if (l7 != l4) {
            g.c(this.b0, charSequence);
        }
        long l3 = l2 & 13L;
        if (this.m0 != l4) {
            g.c(this.c0, charSequence2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wb
    public boolean y() {
        synchronized (this) {
            try {
                if (this.m0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private xb(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (LinearLayout)objectArr[21], (TextView)objectArr[20], (AppCompatImageView)objectArr[13], (FocusedBorderTextInput)objectArr[15], (TextView)objectArr[18], (TextView)objectArr[16], (FocusedBorderTextInput)objectArr[17], (TextView)objectArr[19], (NestedScrollView)objectArr[12], (MaterialButton)objectArr[22], (TextView)objectArr[14], (CheckBox)objectArr[3], (CheckBox)objectArr[4], (CheckBox)objectArr[5], (CheckBox)objectArr[6], (CheckBox)objectArr[7], (CheckBox)objectArr[8], (CheckBox)objectArr[9], (MaterialToolbar)objectArr[10], (TextView)objectArr[11]);
        app.dogo.com.dogo_android.h.xb eVar3 = this;
        eVar3.k0 = new xb.a(eVar3);
        eVar3.l0 = new xb.b(eVar3);
        eVar3.m0 = -1L;
        Object obj = objectArr[0];
        eVar3.a0 = obj;
        Object obj2 = null;
        obj.setTag(obj2);
        int i2 = 1;
        Object obj3 = objectArr[i2];
        eVar3.b0 = obj3;
        obj3.setTag(obj2);
        int i9 = 2;
        Object obj5 = objectArr[i9];
        eVar3.c0 = obj5;
        obj5.setTag(obj2);
        eVar3.Q.setTag(obj2);
        eVar3.R.setTag(obj2);
        eVar3.S.setTag(obj2);
        eVar3.T.setTag(obj2);
        eVar3.U.setTag(obj2);
        eVar3.V.setTag(obj2);
        eVar3.W.setTag(obj2);
        eVar3.N(view);
        eVar3.d0 = new a(eVar3, 7);
        eVar3.e0 = new a(eVar3, 4);
        eVar3.f0 = new a(eVar3, i9);
        eVar3.g0 = new a(eVar3, 6);
        eVar3.h0 = new a(eVar3, 5);
        eVar3.i0 = new a(eVar3, 3);
        eVar3.j0 = new a(eVar3, i2);
        A();
    }
}
