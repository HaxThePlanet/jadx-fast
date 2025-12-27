package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellRecommendedProgramCardBindingImpl.java */
/* loaded from: classes.dex */
public class t6 extends s6 {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout V;
    private long W;
    static {
        obj.put(2131362986, 6);
        obj.put(2131362355, 7);
        obj.put(2131363036, 8);
        obj.put(2131363387, 9);
        obj.put(2131363149, 10);
        obj.put(2131362511, 11);
        obj.put(2131362335, 12);
        obj.put(2131363202, 13);
    }

    public t6(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 14, t6.X, t6.Y));
    }

    @Override // app.dogo.com.dogo_android.h.s6
    public void A() {
        synchronized (this) {
            try {
                this.W = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.s6
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.s6
    public void V(ProgramDescriptionItem programDescriptionItem) {
        this.U = programDescriptionItem;
        synchronized (this) {
            try {
                this.W |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s6
    protected void m() {
        int i = 0;
        String str = null;
        String str2;
        int numberOfSkills;
        Object obj;
        Object obj2;
        java.lang.CharSequence charSequence;
        synchronized (this) {
            try {
                long l4 = 0L;
                this.W = l4;
            } catch (Throwable th) {
            }
        }
        long l = 3L;
        long l3 = this.W & l;
        i = 0;
        if (l3 != l4) {
            numberOfSkills = 0;
            if (this.U != null) {
                String iconUrl = this.U.getIconUrl();
                numberOfSkills = this.U.getNumberOfSkills();
                String cardBackgroundColor = this.U.getCardBackgroundColor();
                String name = this.U.getName();
                numberOfSkills = this.U.getModulesCount();
            } else {
            }
            int i4 = 1;
            Object[] arr2 = new Object[i4];
            arr2[numberOfSkills] = Integer.valueOf(numberOfSkills);
            String string2 = this.S.getResources().getString(2131887593, arr2);
            int i2 = 2131887581;
            Object[] arr = new Object[i4];
            arr[numberOfSkills] = Integer.valueOf(numberOfSkills);
        } else {
        }
        if (l3 != l4) {
            BindingAdapters.setRatingChange(this.O, str);
            BindingAdapters.w(this.P, str2);
            g.c(this.Q, charSequence);
            g.c(this.S, obj);
            g.c(this.T, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s6
    public boolean y() {
        synchronized (this) {
            try {
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private t6(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[12], (ImageView)objectArr[7], (ImageView)objectArr[11], (CardView)objectArr[1], (CardView)objectArr[6], (ImageView)objectArr[2], (TextView)objectArr[3], (TextView)objectArr[8], (Button)objectArr[10], (ImageView)objectArr[13], (TextView)objectArr[4], (TextView)objectArr[9], (TextView)objectArr[5]);
        Object eVar3 = this;
        eVar3.W = -1L;
        Object obj = objectArr[0];
        eVar3.V = obj;
        Object obj2 = null;
        obj.setTag(obj2);
        eVar3.O.setTag(obj2);
        eVar3.P.setTag(obj2);
        eVar3.Q.setTag(obj2);
        eVar3.S.setTag(obj2);
        eVar3.T.setTag(obj2);
        eVar3.N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s6
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
