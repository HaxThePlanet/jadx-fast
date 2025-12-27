package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.a.a;
import app.dogo.com.dogo_android.u.n.q.l;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* compiled from: FragmentPottyReminderScreenBindingImpl.java */
/* loaded from: classes.dex */
public class df extends cf implements a.a {

    private static final ViewDataBinding.g m0;
    private static final SparseIntArray n0 = new SparseIntArray();
    private final CoordinatorLayout d0;
    private final CompoundButton.OnCheckedChangeListener e0;
    private final CompoundButton.OnCheckedChangeListener f0;
    private final CompoundButton.OnCheckedChangeListener g0;
    private final CompoundButton.OnCheckedChangeListener h0;
    private final CompoundButton.OnCheckedChangeListener i0;
    private final CompoundButton.OnCheckedChangeListener j0;
    private final CompoundButton.OnCheckedChangeListener k0;
    private long l0;
    static {
        obj.put(2131361934, 14);
        obj.put(2131363433, 15);
        obj.put(2131362876, 16);
        obj.put(2131362342, 17);
        obj.put(2131362676, 18);
        obj.put(2131362323, 19);
        obj.put(2131362678, 20);
        obj.put(2131362324, 21);
        obj.put(2131362675, 22);
        obj.put(2131362325, 23);
        obj.put(2131363055, 24);
    }

    public df(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 25, df.m0, df.n0));
    }

    private boolean W(x<List<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.l0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.l0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.l0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(x<Long> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.l0 |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.l0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean b0(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.l0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean c0(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.l0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.cf
    public void A() {
        synchronized (this) {
            try {
                this.l0 = 256L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.cf
    protected boolean E(int i, Object object, int i2) {
        switch (i) {
            case 0:
                return this.a0(object, i2);
            case 1:
                return this.b0(object, i2);
            case 2:
                return this.Y(object, i2);
            case 3:
                return this.W(object, i2);
            case 4:
                return this.c0(object, i2);
            case 5:
                return this.X(object, i2);
            case 6:
                return this.Z(object, i2);
            default:
                return false;
        }
    }

    @Override // app.dogo.com.dogo_android.h.cf
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

    @Override // app.dogo.com.dogo_android.h.cf
    public void V(l lVar) {
        this.c0 = lVar;
        synchronized (this) {
            try {
                this.l0 |= 128;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cf
    public final void c(int i, CompoundButton compoundButton, boolean z) {
        int compoundButton22 = 0;
        compoundButton22 = 1;
        compoundButton22 = 0;
        switch (i) {
            case 1:
                this.c0.A(compoundButton22, z);
                break;
            case 2:
                this.c0.A(compoundButton22, z);
                break;
            case 3:
                compoundButton22 = 2;
                this.c0.A(2, z);
                break;
            case 4:
                compoundButton22 = 3;
                this.c0.A(3, z);
                break;
            case 5:
                compoundButton22 = 4;
                this.c0.A(4, z);
                break;
            case 6:
                compoundButton22 = 5;
                this.c0.A(5, z);
                break;
            case 7:
                compoundButton22 = 6;
                this.c0.A(6, z);
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.cf
    protected void m() {
        Object obj2 = null;
        Long l5 = null;
        Object obj4 = null;
        Object value = null;
        y yVar = null;
        Object obj5 = null;
        Object value2 = null;
        Integer num = null;
        Object obj6 = null;
        int i2 = 0;
        int i = 0;
        Integer num2 = null;
        Object value3 = null;
        List list = null;
        int i3 = 0;
        List list3 = null;
        Object obj7 = null;
        int i4 = 0;
        Integer num3 = null;
        int i5 = 0;
        Integer num4 = null;
        Object obj8 = null;
        Object obj = null;
        int cmp10 = 6;
        int cmp9;
        x xVar2;
        x xVar;
        final Object obj3 = this;
        synchronized (this) {
            try {
                final long l7 = 0L;
                obj3.l0 = l7;
            } catch (Throwable th) {
            }
        }
        long l8 = 511L & l6;
        long l2 = 420L;
        long l13 = 392L;
        long l3 = 385L;
        final long l19 = 384L;
        if (l8 != l7) {
            long l20 = l6 & 385L;
            if (l20 != l7) {
                if (obj3.c0 != null) {
                    x xVar4 = obj3.c0.v();
                } else {
                    int i12 = 0;
                }
                i = 0;
                obj3.Q(i, obj4);
                value = obj4 != null ? (LoadResult)value : 0;
            }
            long l21 = l6 & 402L;
            if (l21 != l7) {
                if (obj3.c0 != null) {
                    x xVar5 = obj3.c0.x();
                } else {
                    int i17 = 0;
                    int i22 = 0;
                }
                obj3.Q(1, obj6);
                int i6 = 4;
                obj3.Q(i6, obj5);
                Object value5 = obj6 != null ? (Integer)value5 : 0;
                value2 = obj5 != null ? (Integer)value2 : 0;
            } else {
                int i18 = 0;
                i2 = 0;
            }
            long l15 = l6 & 420L;
            if (l15 != l7) {
                if (obj3.c0 != null) {
                    x xVar6 = obj3.c0.r();
                } else {
                    int i31 = 0;
                    int i36 = 0;
                }
                obj3.Q(2, obj8);
                obj3.Q(5, obj7);
                Object value7 = obj8 != null ? (Integer)value7 : 0;
                Object value6 = obj7 != null ? (Integer)value6 : 0;
            } else {
                i4 = 0;
                i5 = 0;
            }
            long l16 = l6 & 392L;
            if (l16 != l7) {
                if (obj3.c0 != null) {
                    x xVar7 = obj3.c0.o();
                } else {
                    int i37 = 0;
                }
                obj3.Q(3, obj);
                value3 = obj != null ? (List)value3 : 0;
            }
            long l17 = l6 & 384L;
            if (l17 == l7 || obj3.c0 == null) {
                i3 = 0;
            } else {
                List list2 = obj3.c0.p();
            }
            l4 = l6 & 448L;
            if (l4 != l7) {
                if (obj3.c0 != null) {
                    x xVar3 = obj3.c0.u();
                } else {
                    int i8 = 0;
                }
                obj3.Q(6, obj2);
                Object value4 = obj3.c0 != null ? (Long)value4 : 0;
            }
        } else {
            int i7 = 0;
            int i11 = 0;
            int i15 = 0;
            int i21 = 0;
            int i23 = 0;
            int i28 = 0;
            int i30 = 0;
            int i32 = 0;
        }
        long l18 = l6 & 384L;
        if (l18 != l7) {
            BindingAdapters.u0(obj3.O, list3);
        }
        long l14 = 392L & l6;
        if (l14 != l7) {
            BindingAdapters.r0(obj3.P, list);
        }
        long l11 = 420L & l6;
        if (l11 != l7) {
            CalendarBindingAdapters.setDogCalenderAdapter(obj3.Q, num3, num4);
        }
        long l12 = 402L & l6;
        if (obj3.Q != l7) {
            CalendarBindingAdapters.setDogCalenderAdapter(obj3.R, num2, num);
        }
        long l9 = 448L & l6;
        if (l9 != l7) {
            BindingAdapters.W(obj3.S, l5);
        }
        long l10 = 385L & l6;
        if (obj3.S != l7) {
            BindingAdapters.x0(obj3.d0, yVar);
            BindingAdapters.Z(obj3.T, yVar);
        }
        l = l6 & 256L;
        if (obj3.l0 != l7) {
            androidx.databinding.g gVar = null;
            a.b(obj3.U, obj3.h0, gVar);
            a.b(obj3.V, obj3.j0, gVar);
            a.b(obj3.W, obj3.e0, gVar);
            a.b(obj3.X, obj3.i0, gVar);
            a.b(obj3.Y, obj3.k0, gVar);
            a.b(obj3.Z, obj3.f0, gVar);
            a.b(obj3.a0, obj3.g0, gVar);
        }
    }

    @Override // app.dogo.com.dogo_android.h.cf
    public boolean y() {
        synchronized (this) {
            try {
                if (this.l0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private df(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 7, (AppBarLayout)objectArr[14], (LinearLayout)objectArr[5], (TextView)objectArr[4], (ImageView)objectArr[19], (ImageView)objectArr[21], (ImageView)objectArr[23], (AppCompatImageView)objectArr[17], (TextView)objectArr[22], (TextView)objectArr[18], (MaterialButton)objectArr[1], (TextView)objectArr[20], (MaterialButton)objectArr[2], (MaterialButton)objectArr[3], (NestedScrollView)objectArr[16], (TextView)objectArr[24], (MaterialButton)objectArr[13], (CheckBox)objectArr[6], (CheckBox)objectArr[7], (CheckBox)objectArr[8], (CheckBox)objectArr[9], (CheckBox)objectArr[10], (CheckBox)objectArr[11], (CheckBox)objectArr[12], (MaterialToolbar)objectArr[15]);
        Object eVar4 = this;
        eVar4.l0 = -1L;
        Object obj2 = null;
        eVar4.O.setTag(obj2);
        eVar4.P.setTag(obj2);
        eVar4.Q.setTag(obj2);
        eVar4.R.setTag(obj2);
        eVar4.S.setTag(obj2);
        Object obj = objectArr[0];
        eVar4.d0 = obj;
        obj.setTag(obj2);
        eVar4.T.setTag(obj2);
        eVar4.U.setTag(obj2);
        eVar4.V.setTag(obj2);
        eVar4.W.setTag(obj2);
        eVar4.X.setTag(obj2);
        eVar4.Y.setTag(obj2);
        eVar4.Z.setTag(obj2);
        eVar4.a0.setTag(obj2);
        eVar4.N(view);
        eVar4.e0 = new a(eVar4, 3);
        eVar4.f0 = new a(eVar4, 6);
        eVar4.g0 = new a(eVar4, 7);
        eVar4.h0 = new a(eVar4, 1);
        eVar4.i0 = new a(eVar4, 4);
        eVar4.j0 = new a(eVar4, 2);
        eVar4.k0 = new a(eVar4, 5);
        A();
    }
}
