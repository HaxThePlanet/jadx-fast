package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* compiled from: LayoutRateBindingImpl.java */
/* loaded from: classes.dex */
public class pm extends om implements b.a {

    private static final ViewDataBinding.g a0 = new ViewDataBinding$g(17);
    private static final SparseIntArray b0 = new SparseIntArray();
    private final ConstraintLayout X;
    private final View.OnClickListener Y;
    private long Z;
    static {
        int i12 = 1;
        final int[] iArr2 = new int[i12];
        final int i25 = 0;
        iArr2[i25] = 6;
        int[] iArr = new int[i12];
        iArr[i25] = R.layout.layout_tips_and_tricks;
        obj.a(i25, new String[] { "layout_tips_and_tricks" }, iArr2, iArr);
        obj.put(2131363441, 7);
        obj.put(2131361941, 8);
        obj.put(2131361942, 9);
        obj.put(2131361943, 10);
        obj.put(2131361944, 11);
        obj.put(2131361945, 12);
        obj.put(2131363479, 13);
        obj.put(2131362334, 14);
        obj.put(2131362562, 15);
        obj.put(2131362330, 16);
    }

    public pm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 17, pm.a0, pm.b0));
    }

    private boolean U(an anVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Z |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean V(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Z |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Z |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.om
    public void A() {
        synchronized (this) {
            try {
                this.Z = 16L;
            } catch (Throwable th) {
            }
        }
        this.Q.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.om
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return U(object, i2);
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.om
    public void M(q qVar) {
        super.M(qVar);
        this.Q.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.om
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.om
    public void T(app.dogo.com.dogo_android.n.m.t.g gVar) {
        this.W = gVar;
        synchronized (this) {
            try {
                this.Z |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.om
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.W != null ? 1 : 0;
        if (i2 != 0) {
            this.W.F();
        }
    }

    @Override // app.dogo.com.dogo_android.h.om
    protected void m() {
        int i2 = 0;
        int i3 = 0;
        int i;
        long l;
        Object obj2 = null;
        Integer num = null;
        String str = null;
        String str2 = null;
        Object obj3 = null;
        LinearLayout linearLayout;
        String str3 = null;
        Object obj4 = null;
        int i5 = 0;
        Integer num2 = null;
        int i6 = 0;
        int i7 = 0;
        int i4 = 0;
        int cmp2 = 0;
        int i8 = 0;
        int i9;
        String imageUrl;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l3 = 0L;
                obj.Z = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 27L & l;
        long l5 = 25L;
        long l8 = 26L;
        i = 0;
        if (l4 != l3) {
            long l10 = l & 25L;
            if (l10 != l3) {
                if (obj.W != null) {
                    x xVar = obj.W.q();
                } else {
                    int i12 = 0;
                }
                obj.Q(i, obj2);
                Object value = obj2 != null ? (Integer)value : 0;
                i = ViewDataBinding.J(num);
            } else {
            }
            long l11 = l & 26L;
            i = 1;
            if (l11 != l3) {
                if (obj.W != null) {
                    x xVar2 = obj.W.v();
                } else {
                    int i24 = 0;
                }
                obj.Q(i, obj4);
                Object value2 = obj4 != null ? (Integer)value2 : 0;
            }
            if (obj.W != null) {
                DogProfile dogProfile = obj.W.s();
            } else {
                i7 = 0;
            }
            if (i7 != 0) {
                String name2 = i7.getName();
            } else {
                i4 = 0;
            }
            long l12 = l & 24L;
            if (l12 != l3) {
                if (obj.W != null) {
                    Long l13 = obj.W.r();
                    TrickItem trickItem = obj.W.C();
                } else {
                    i2 = 0;
                    i8 = 0;
                }
                int r19 = i;
                if (l12 != l3) {
                    int r20 = i != 0 ? 64 : 32;
                    l = l | (i != 0 ? 64 : 32);
                }
                if (obj.W != 0) {
                    String description = i2.getDescription();
                } else {
                    i3 = 0;
                    i6 = 0;
                    cmp2 = 0;
                }
                r19 = i != 0 ? 8 : i;
                Object[] arr = new Object[i];
                i = (i != 0 ? 8 : i);
            } else {
                int i16 = 0;
                int i18 = 0;
                int i11 = 0;
            }
        } else {
            int i14 = 0;
            int i17 = 0;
            int i20 = 0;
            int i23 = 0;
            int i25 = 0;
        }
        long l9 = 26L & l;
        if (l9 != l3) {
            BindingAdapters.A(obj.O, obj.O, obj.P, str3, num2);
        }
        long l6 = 25L & l;
        if (l6 != l3) {
            BindingAdapters.h0(obj.P, i, obj.O, str3);
        }
        long l7 = 16L & l;
        if (obj.P != l3) {
            obj.Q.w().setOnClickListener(obj.Y);
        }
        l &= 24;
        if (obj.Z != l3) {
            obj.Q.w().setVisibility(i);
            ProgramBindingAdapters.w(obj.R, str);
            BindingAdapters.n0(obj.T, str2);
            g.c(obj.V, obj3);
        }
        ViewDataBinding.o(obj.Q);
    }

    @Override // app.dogo.com.dogo_android.h.om
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.Z != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.Q.y()) {
            return true;
        }
        return false;
    }

    private pm(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 3, (ImageView)objectArr[8], (ImageView)objectArr[9], (ImageView)objectArr[10], (ImageView)objectArr[11], (ImageView)objectArr[12], (LinearLayout)objectArr[4], (MaterialTextView)objectArr[3], (ImageView)objectArr[16], (ImageView)objectArr[14], (TextView)objectArr[15], (an)objectArr[6], (TextView)objectArr[5], (MaterialToolbar)objectArr[7], (ImageView)objectArr[1], (TrickRatingBar)objectArr[13], (TextView)objectArr[2]);
        Object eVar4 = this;
        eVar4.Z = -1L;
        Object obj2 = null;
        eVar4.O.setTag(obj2);
        eVar4.P.setTag(obj2);
        eVar4.L(eVar4.Q);
        Object obj = objectArr[0];
        eVar4.X = obj;
        obj.setTag(obj2);
        eVar4.R.setTag(obj2);
        eVar4.T.setTag(obj2);
        eVar4.V.setTag(obj2);
        eVar4.N(view);
        eVar4.Y = new b(eVar4, 1);
        A();
    }
}
