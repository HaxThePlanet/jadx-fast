package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.a.a;
import app.dogo.com.dogo_android.r.l;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import com.google.android.material.textfield.TextInputEditText;

/* compiled from: FragmentTrainingReminderWithTimeBindingImpl.java */
/* loaded from: classes.dex */
public class dh extends ch implements a.a {

    private static final ViewDataBinding.g v0 = new ViewDataBinding$g(34);
    private static final SparseIntArray w0 = new SparseIntArray();
    private final CoordinatorLayout e0;
    private final Group f0;
    private final FrameLayout g0;
    private final ok h0;
    private final Group i0;
    private final TextInputEditText j0;
    private final TextInputEditText k0;
    private final CompoundButton.OnCheckedChangeListener l0;
    private final CompoundButton.OnCheckedChangeListener m0;
    private final CompoundButton.OnCheckedChangeListener n0;
    private final CompoundButton.OnCheckedChangeListener o0;
    private final CompoundButton.OnCheckedChangeListener p0;
    private final CompoundButton.OnCheckedChangeListener q0;
    private final CompoundButton.OnCheckedChangeListener r0;
    private androidx.databinding.g s0;
    private androidx.databinding.g t0;
    private long u0;

    class a implements androidx.databinding.g {

        final /* synthetic */ dh a;
        a() {
            this.a = dhVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.c0 != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(g.a(this.a.j0));
                }
            }
        }
    }

    class b implements androidx.databinding.g {

        final /* synthetic */ dh a;
        b() {
            this.a = dhVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.c0 != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(g.a(this.a.k0));
                }
            }
        }
    }
    static {
        int i18 = 1;
        final int[] iArr2 = new int[i18];
        final int i38 = 0;
        iArr2[i38] = 17;
        int[] iArr = new int[i18];
        iArr[i38] = R.layout.layout_dog_creation_loading_spinner;
        obj.a(15, new String[] { "layout_dog_creation_loading_spinner" }, iArr2, iArr);
        obj.put(2131362227, 18);
        obj.put(2131363433, 19);
        obj.put(2131362876, 20);
        obj.put(2131363560, 21);
        obj.put(2131363414, 22);
        obj.put(2131363565, 23);
        obj.put(2131362615, 24);
        obj.put(2131362617, 25);
        obj.put(2131362805, 26);
        obj.put(2131362616, 27);
        obj.put(2131362806, 28);
        obj.put(2131362282, 29);
        obj.put(2131362156, 30);
        obj.put(2131363172, 31);
        obj.put(2131362715, 32);
        obj.put(2131363161, 33);
    }

    public dh(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 34, dh.v0, dh.w0));
    }

    static /* synthetic */ TextInputEditText X(dh dhVar) {
        return dhVar.j0;
    }

    static /* synthetic */ TextInputEditText Y(dh dhVar) {
        return dhVar.k0;
    }

    private boolean Z(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.u0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.u0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean b0(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.u0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean c0(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.u0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public void A() {
        synchronized (this) {
            try {
                this.u0 = 64L;
            } catch (Throwable th) {
            }
        }
        this.h0.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ch
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return a0(object, i2);
        }
        return b0(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public void M(q qVar) {
        super.M(qVar);
        this.h0.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public boolean O(int i, Object object) {
        int i2 = 93;
        boolean z = true;
        i2 = 93;
        if (93 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public void V(Boolean boolean) {
        this.d0 = boolean;
        synchronized (this) {
            try {
                this.u0 |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(93);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public void W(l lVar) {
        this.c0 = lVar;
        synchronized (this) {
            try {
                this.u0 |= 32;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public final void c(int i, CompoundButton compoundButton, boolean z) {
        int i3 = 0;
        i3 = 0;
        i3 = 1;
        switch (i) {
            case 1:
                this.c0.getCorrectedDay(i3, z);
                break;
            case 2:
                i3 = 2;
                this.c0.getCorrectedDay(2, z);
                break;
            case 3:
                i3 = 3;
                this.c0.getCorrectedDay(3, z);
                break;
            case 4:
                i3 = 4;
                this.c0.getCorrectedDay(4, z);
                break;
            case 5:
                i3 = 5;
                this.c0.getCorrectedDay(5, z);
                break;
            case 6:
                i3 = 6;
                this.c0.getCorrectedDay(6, z);
                break;
            case 7:
                i3 = 7;
                this.c0.getCorrectedDay(7, z);
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.ch
    protected void m() {
        int i = 8;
        long l;
        java.lang.CharSequence charSequence;
        Object obj2;
        java.lang.CharSequence charSequence2;
        Object obj3;
        Object value;
        y yVar;
        Object obj4;
        Object value2;
        Boolean bool2;
        Object obj5;
        Object value3;
        int i3;
        int cmp9 = 3;
        long l3 = 100;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l6 = 0L;
                obj.u0 = l6;
            } catch (Throwable th) {
            }
        }
        long l8 = l & 80L;
        i = 0;
        if (l8 != l6) {
            boolean z = ViewDataBinding.K(obj.d0);
            if (l8 != l6) {
                int r11 = z ? 256 : 128;
                l = l | (z ? 256 : 128);
            }
            if (z) {
            } else {
                i = 8;
            }
        }
        long l11 = 111L & l;
        long l2 = 104L;
        final long l17 = 98L;
        final long l18 = 97L;
        androidx.databinding.k.g.c cVar = null;
        if (l11 != l6) {
            long l7 = l & 97L;
            if (l7 != l6) {
                if (obj.c0 != null) {
                    x xVar2 = obj.c0.t();
                } else {
                    int i8 = cVar;
                }
                obj.Q(i, obj3);
                value = obj3 != null ? (String)value : cVar;
            }
            long l10 = l & 98L;
            if (l10 != l6) {
                if (obj.c0 != null) {
                    x xVar3 = obj.c0.u();
                } else {
                    int i11 = cVar;
                }
                i = 1;
                obj.Q(i, obj4);
                value2 = obj4 != null ? (LoadResult)value2 : cVar;
            }
            l4 = l & 100L;
            if (l4 != l6) {
                if (obj.c0 != null) {
                    x xVar4 = obj.c0.v();
                } else {
                    int i13 = cVar;
                }
                int i4 = 2;
                obj.Q(i4, obj5);
                value3 = obj5 != null ? (Boolean)value3 : cVar;
            }
            long l16 = l & 104L;
            if (l16 != l6) {
                if (obj.c0 != null) {
                    x xVar = obj.c0.s();
                } else {
                    int i6 = cVar;
                }
                cmp9 = 3;
                obj.Q(cmp9, obj2);
                Object value4 = obj.c0 != null ? (String)value4 : cVar;
            }
        } else {
        }
        long l15 = 64L & l;
        if (l15 != l6) {
            BindingAdapters.setDebugFeatureListAdapter(obj.P, obj.P.getResources().getString(2131887292));
            BindingAdapters.setDebugFeatureListAdapter(obj.Q, obj.Q.getResources().getString(2131887295));
            BindingAdapters.P(obj.j0, 24);
            g.e(obj.j0, cVar, cVar, cVar, obj.s0);
            BindingAdapters.P(obj.k0, 59);
            g.e(obj.k0, cVar, cVar, cVar, obj.t0);
            BindingAdapters.setDebugFeatureListAdapter(obj.S, obj.S.getResources().getString(2131887293));
            int cmp10 = 2131887294;
            BindingAdapters.setDebugFeatureListAdapter(obj.T, obj.T.getResources().getString(cmp10));
            a.b(obj.U, obj.n0, cVar);
            a.b(obj.V, obj.o0, cVar);
            a.b(obj.W, obj.q0, cVar);
            a.b(obj.X, obj.l0, cVar);
            a.b(obj.Y, obj.p0, cVar);
            a.b(obj.Z, obj.r0, cVar);
            a.b(obj.a0, obj.m0, cVar);
        }
        long l12 = l & 98L;
        if (obj.U != l6) {
            BindingAdapters.x0(obj.e0, yVar);
            BindingAdapters.setDebugJsonEntryItemAdapter(obj.g0, yVar);
        }
        long l13 = 80L & l;
        if (obj.U != l6) {
            obj.f0.setVisibility(i);
        }
        long l14 = 100L & l;
        if (obj.U != l6) {
            BindingAdapters.J0(obj.i0, bool2);
        }
        long l9 = 104L & l;
        if (l9 != l6) {
            g.c(obj.j0, charSequence);
        }
        l &= l18;
        if (obj.u0 != l6) {
            g.c(obj.k0, charSequence2);
        }
        ViewDataBinding.o(obj.h0);
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.u0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.h0.y()) {
            return true;
        }
        return false;
    }

    private dh(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 4, (LinearLayout)objectArr[30], (ConstraintLayout)objectArr[18], (TextView)objectArr[29], (TextView)objectArr[1], (TextView)objectArr[4], (FocusedBorderTextInput)objectArr[24], (TextView)objectArr[27], (TextView)objectArr[25], (Guideline)objectArr[32], (FocusedBorderTextInput)objectArr[26], (TextView)objectArr[28], (NestedScrollView)objectArr[20], (Guideline)objectArr[33], (MaterialButton)objectArr[31], (TextView)objectArr[2], (TextView)objectArr[3], (TextView)objectArr[22], (CheckBox)objectArr[7], (CheckBox)objectArr[8], (CheckBox)objectArr[9], (CheckBox)objectArr[10], (CheckBox)objectArr[11], (CheckBox)objectArr[12], (CheckBox)objectArr[13], (MaterialToolbar)objectArr[19], (TextView)objectArr[21], (TextView)objectArr[23]);
        app.dogo.com.dogo_android.h.dh eVar3 = this;
        eVar3.s0 = new dh.a(eVar3);
        eVar3.t0 = new dh.b(eVar3);
        eVar3.u0 = -1L;
        Object obj6 = null;
        eVar3.P.setTag(obj6);
        eVar3.Q.setTag(obj6);
        Object obj = objectArr[0];
        eVar3.e0 = obj;
        obj.setTag(obj6);
        Object obj2 = objectArr[14];
        eVar3.f0 = obj2;
        obj2.setTag(obj6);
        Object obj3 = objectArr[15];
        eVar3.g0 = obj3;
        obj3.setTag(obj6);
        Object obj4 = objectArr[17];
        eVar3.h0 = obj4;
        eVar3.L(obj4);
        Object obj5 = objectArr[16];
        eVar3.i0 = obj5;
        obj5.setTag(obj6);
        int i6 = 5;
        Object obj7 = objectArr[i6];
        eVar3.j0 = obj7;
        obj7.setTag(obj6);
        int i13 = 6;
        Object obj9 = objectArr[i13];
        eVar3.k0 = obj9;
        obj9.setTag(obj6);
        eVar3.S.setTag(obj6);
        eVar3.T.setTag(obj6);
        eVar3.U.setTag(obj6);
        eVar3.V.setTag(obj6);
        eVar3.W.setTag(obj6);
        eVar3.X.setTag(obj6);
        eVar3.Y.setTag(obj6);
        eVar3.Z.setTag(obj6);
        eVar3.a0.setTag(obj6);
        eVar3.N(view);
        eVar3.l0 = new a(eVar3, 4);
        eVar3.m0 = new a(eVar3, 7);
        eVar3.n0 = new a(eVar3, 1);
        eVar3.o0 = new a(eVar3, 2);
        eVar3.p0 = new a(eVar3, i6);
        eVar3.q0 = new a(eVar3, 3);
        eVar3.r0 = new a(eVar3, i13);
        A();
    }
}
