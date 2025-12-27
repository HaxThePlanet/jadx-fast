package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.u.n.p.l.g;
import app.dogo.com.dogo_android.u.n.p.l.i;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentDogLogEditBindingImpl.java */
/* loaded from: classes.dex */
public class nc extends mc implements b.a {

    private static final ViewDataBinding.g e0;
    private static final SparseIntArray f0 = new SparseIntArray();
    private final ConstraintLayout a0;
    private final View.OnClickListener b0;
    private final View.OnClickListener c0;
    private long d0;
    static {
        obj.put(2131362278, 11);
        obj.put(2131362322, 12);
        obj.put(2131363403, 13);
        obj.put(2131363444, 14);
        obj.put(2131362064, 15);
    }

    public nc(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 16, nc.e0, nc.f0));
    }

    private boolean X(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.d0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(x<Long> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.d0 |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.d0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.d0 |= 8;
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
                    this.d0 |= 1;
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
                    this.d0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean d0(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.d0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.mc
    public void A() {
        synchronized (this) {
            try {
                this.d0 = 512L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.mc
    protected boolean E(int i, Object object, int i2) {
        switch (i) {
            case 0:
                return this.b0(object, i2);
            case 1:
                return this.Z(object, i2);
            case 2:
                return this.X(object, i2);
            case 3:
                return this.a0(object, i2);
            case 4:
                return this.c0(object, i2);
            case 5:
                return this.d0(object, i2);
            case 6:
                return this.Y(object, i2);
            default:
                return false;
        }
    }

    @Override // app.dogo.com.dogo_android.h.mc
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
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

    @Override // app.dogo.com.dogo_android.h.mc
    public void V(g gVar) {
        this.Z = gVar;
        synchronized (this) {
            try {
                this.d0 |= 128;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mc
    public void W(i iVar) {
        this.Y = iVar;
        synchronized (this) {
            try {
                this.d0 |= 256;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mc
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.Y != null) {
            }
            if (i2 != 0) {
                this.Y.x();
            }
        } else {
            int i3 = 2;
            if (this.Y == 2) {
                if (this.Y != null) {
                }
                if (i2 != 0) {
                    this.Y.j();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.mc
    protected void m() {
        long l;
        long l2;
        int i = 0;
        Integer num = null;
        Object obj4 = null;
        boolean z = false;
        Object obj5 = null;
        Object value = null;
        Long l13 = null;
        Object obj6 = null;
        Object value2 = null;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        java.lang.CharSequence charSequence = null;
        int i6 = 0;
        int i7 = 2131886493;
        y yVar = null;
        Object obj = null;
        Object value3 = null;
        y yVar2 = null;
        Object obj2 = null;
        Object obj7 = null;
        Object value4 = null;
        boolean z2 = false;
        Object obj8 = null;
        Boolean bool = null;
        int i8 = 0;
        java.util.List list = null;
        int i10 = 800;
        int i12;
        long l4 = 0;
        String str2 = null;
        int i13 = 0;
        g gVar;
        x xVar4;
        int cmp12;
        int cmp13;
        int cmp14 = 65536;
        int cmp15;
        x xVar3;
        int i14 = 4096;
        int i15 = 0;
        final Object obj3 = this;
        synchronized (this) {
            try {
                long l12 = 0L;
                obj3.d0 = l12;
            } catch (Throwable th) {
            }
        }
        long l21 = l & 896L;
        long l22 = 1023L & l;
        final long l24 = 785L;
        final long l25 = 832L;
        long l26 = 776L;
        final long l28 = 768L;
        i = 0;
        if (l22 != l12) {
            if (l21 != l12) {
                if (obj3.Y != null) {
                    String str = obj3.Y.r();
                    java.util.List list2 = obj3.Y.u();
                    boolean z4 = obj3.Y.w();
                } else {
                    i6 = 0;
                    i12 = 0;
                }
                long l30 = l & 768L;
                if (l30 != l12) {
                    if (i != 0) {
                        l2 = (l | 2048L) | 32768L;
                        cmp14 = 131072;
                    } else {
                        l2 = (l | 1024L) | 16384L;
                        cmp14 = 65536;
                    }
                    l = l2 | cmp14;
                }
                long l31 = l & 768L;
                if (l31 != l12) {
                    int r10 = i != 0 ? R.string.new.log.header : R.string.edit.potty.log;
                    String string = obj3.X.getResources().getString((i != 0 ? R.string.new.log.header : R.string.edit.potty.log));
                    r10 = i != 0 ? 8 : i;
                    int r29 = i != 0 ? i : 8;
                } else {
                    i5 = 0;
                }
            } else {
                i5 = 0;
                i6 = 0;
                i12 = 0;
            }
            long l32 = l & 785L;
            if (l32 != l12) {
                if (obj3.Y != null) {
                } else {
                    int i37 = 0;
                    int i40 = 0;
                }
                obj3.Q(i, obj);
                obj3.Q(4, obj2);
                Object value6 = obj != null ? (Integer)value6 : 0;
                value3 = obj2 != null ? (Integer)value3 : 0;
            } else {
                i4 = 0;
            }
            l5 = l & 770L;
            i13 = 1;
            if (l5 != l12) {
                if (obj3.Y != null) {
                    x xVar7 = obj3.Y.m();
                } else {
                    int i41 = 0;
                }
                obj3.Q(i13, obj7);
                value4 = obj7 != null ? (LoadResult)value4 : 0;
            }
            l6 = l & 772L;
            if (l6 != l12) {
                xVar4 = obj3.Y != null ? xVar4 : 0;
                int i9 = 2;
                obj3.Q(i9, obj8);
                Object value7 = obj8 != null ? (Boolean)value7 : 0;
                boolean z3 = ViewDataBinding.K(bool);
            } else {
                i8 = 0;
            }
            long l33 = l & 776L;
            if (l33 != l12) {
                x xVar = obj3.Y != null ? xVar : 0;
                obj3.Q(3, obj4);
                Object value5 = obj4 != null ? (Integer)value5 : 0;
                if (ViewDataBinding.J(num) <= i13) {
                    i13 = 0;
                }
                if (l33 != l12) {
                    int r39 = i13 != 0 ? 8192 : 4096;
                    l = l | (i13 != 0 ? 8192 : 4096);
                }
                int r32 = i13 != 0 ? 0 : 8;
                i10 = 800;
            } else {
                int i18 = 0;
                i10 = 800;
                i3 = 0;
            }
            l8 = l & i10;
            l4 = 0L;
            if (l8 != l4) {
                if (obj3.Y != null) {
                    x xVar5 = obj3.Y.s();
                } else {
                    int i20 = 0;
                }
                int i11 = 5;
                obj3.Q(i11, obj5);
                value = obj5 != null ? (LoadResult)value : 0;
            }
            long l23 = l & 832L;
            long l7 = 0L;
            if (l23 != l7) {
                if (obj3.Y != null) {
                    x xVar6 = obj3.Y.l();
                } else {
                    int i29 = 0;
                }
                int cmp11 = 6;
                obj3.Q(cmp11, obj6);
                if (obj3.Y != null) {
                    value2 = obj6.getValue();
                } else {
                    int i30 = 0;
                }
            }
        } else {
            i = 0;
            int i19 = 0;
            int i28 = 0;
            i3 = 0;
            int i33 = 0;
            int i34 = 0;
            i = 0;
            int i36 = 0;
            int i39 = 0;
            int i44 = 0;
            int i47 = 0;
            int i49 = 0;
            i4 = 0;
            i15 = 0;
        }
        long l27 = l & 776L;
        long l29 = 0L;
        if (l27 != l29) {
            obj3.O.setVisibility(i3);
            CalendarBindingAdapters.k(obj3.O, num, obj3.R);
        } else {
        }
        l3 = l & 832L;
        if (obj3.R != l29) {
            CalendarBindingAdapters.c(obj3.P, l13);
        }
        long l14 = 770L & l;
        if (obj3.Y != l29) {
            BindingAdapters.Z(obj3.Q, yVar2);
        }
        long l15 = l & 768L;
        if (obj3.Y != l29) {
            obj3.Q.setVisibility(i);
            obj3.W.setVisibility(i);
            obj3.X.setTitle(charSequence);
        }
        long l16 = 512L & l;
        long l20 = 0L;
        if (obj3.Y != l20) {
            obj3.Q.setOnClickListener(obj3.c0);
            obj3.R.setOnClickListener(obj3.b0);
        }
        long l17 = 800L & l;
        if (obj3.Y != l20) {
            BindingAdapters.setTrainerAvatar(obj3.a0, yVar);
            BindingAdapters.Z(obj3.R, yVar);
            BindingAdapters.setTrainerAvatar(obj3.V, yVar);
        }
        long l18 = 772L & l;
        if (obj3.Y != l20) {
            obj3.R.setEnabled(z2);
        }
        long l19 = 896L & l;
        if (obj3.Y != l20) {
            CalendarBindingAdapters.b(obj3.T, list, gVar, str2, z);
        }
        l &= l24;
        if (obj3.d0 != l20) {
            CalendarBindingAdapters.d(obj3.U, i4, i15);
        }
    }

    @Override // app.dogo.com.dogo_android.h.mc
    public boolean y() {
        synchronized (this) {
            try {
                if (this.d0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private nc(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 7, (Guideline)objectArr[15], (TextView)objectArr[9], (TextView)objectArr[11], (MaterialButton)objectArr[6], (MaterialButton)objectArr[10], (ImageView)objectArr[12], (MaterialButton)objectArr[8], (ScrollView)objectArr[0], (RecyclerView)objectArr[4], (TextView)objectArr[13], (MaterialButton)objectArr[7], (ConstraintLayout)objectArr[5], (TextView)objectArr[3], (Toolbar)objectArr[2], (Barrier)objectArr[14]);
        Object eVar4 = this;
        eVar4.d0 = -1L;
        Object obj = null;
        eVar4.O.setTag(obj);
        eVar4.P.setTag(obj);
        eVar4.Q.setTag(obj);
        int i2 = 1;
        Object obj2 = objectArr[i2];
        eVar4.a0 = obj2;
        obj2.setTag(obj);
        eVar4.R.setTag(obj);
        eVar4.S.setTag(obj);
        eVar4.T.setTag(obj);
        eVar4.U.setTag(obj);
        eVar4.V.setTag(obj);
        eVar4.W.setTag(obj);
        eVar4.X.setTag(obj);
        eVar4.N(view);
        eVar4.b0 = new b(eVar4, i2);
        eVar4.c0 = new b(eVar4, 2);
        A();
    }
}
