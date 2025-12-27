package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;
import com.google.android.material.button.MaterialButton;

/* compiled from: CellProgramTrainingLargeTrickBindingImpl.java */
/* loaded from: classes.dex */
public class j6 extends i6 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout T;
    private final MaterialButton U;
    private long V;
    static {
        obj.put(2131361986, 6);
    }

    public j6(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, j6.W, j6.X));
    }

    @Override // app.dogo.com.dogo_android.h.i6
    public void A() {
        synchronized (this) {
            try {
                this.V = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.i6
    public boolean O(int i, Object object) {
        boolean z = true;
        if (166 == i) {
            W(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.i6
    public void W(TrickItem trickItem) {
        this.S = trickItem;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(166);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i6
    protected void m() {
        int i = 0;
        int i2 = 0;
        long l;
        int cmp2 = 0;
        int knowledge = 0;
        int i3 = 1;
        int cmp3 = 16;
        int i4;
        int cmp4;
        long l2;
        int i5 = 4096;
        int i6 = 0;
        java.lang.CharSequence charSequence;
        String str;
        int cmp5 = 256;
        int i7 = 1024;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l5 = 0L;
                obj.V = l5;
            } catch (Throwable th) {
            }
        }
        final long l6 = 3L;
        long l7 = l & l6;
        long l8 = 512L;
        long l11 = 32768L;
        i2 = 0;
        if (l7 != l5) {
            if (obj.S != null) {
                boolean mastered = obj.S.isMastered();
                String imageUrl = obj.S.getImageUrl();
                String name = obj.S.getName();
                boolean newContent = obj.S.getNewContent();
            } else {
                i6 = 0;
                i4 = 0;
            }
            if (l7 != l5) {
                int r18 = i6 != 0 ? 2048 : 1024;
                l = l | (i6 != 0 ? 2048 : 1024);
            }
            l3 = l & 3L;
            if (l3 != l5) {
                l = i4 != 0 ? l | l11 : l | l3;
            }
            cmp2 = i6 ^ 1;
            long l15 = l & 3L;
            if (l15 != l5) {
                l = i6 ^ 1 != 0 ? l | l8 : l | l16;
            }
        } else {
            cmp2 = 0;
            i6 = 0;
            i4 = 0;
        }
        long l12 = 32768L & l;
        if (l12 != l5) {
            if (obj.S != null) {
                knowledge = obj.S.getKnowledge();
            } else {
                knowledge = 0;
            }
            int r11 = knowledge == 0 ? 1 : 0;
        }
        long l9 = 512L & l;
        if (l9 == l5 || obj.S == null) {
            i = 0;
        } else {
            boolean ratedByUser = obj.S.isRatedByUser();
        }
        long l10 = l & 3L;
        i2 = 8;
        if (l10 != l5) {
            int r12 = i6 != 0 ? i4 : 0;
            if (l10 != l5) {
                r18 = i4 != 0 ? 128 : 64;
                l = l | (i4 != 0 ? 128 : 64);
            }
            if (i4 != 0) {
                i2 = 0;
            } else {
            }
        }
        long l14 = l & 3L;
        if (l14 != l5) {
            if (cmp2 == 0) {
                i = 0;
            }
            if (i4 == 0) {
                i3 = 0;
            }
            if (l14 != l5) {
                r12 = obj.S != 0 ? 8 : 4;
                l = l | (obj.S != 0 ? 8 : 4);
            }
            l2 = l & 3L;
            if (l2 != l5) {
                r12 = i3 != 0 ? 8192 : 4096;
                l = l | (i3 != 0 ? 8192 : 4096);
            }
            if (i3 != 0) {
                i2 = 0;
            } else {
            }
        } else {
            i = 0;
        }
        long l13 = l & 3L;
        if (l13 != l5) {
            if (obj.S == 0) {
                i4 = 0;
            }
            if (l13 != l5) {
                r11 = i4 != 0 ? 32 : 16;
                l = l | (i4 != 0 ? 32 : 16);
            }
            int r16 = i4 != 0 ? 0 : i2;
            i2 = (i4 != 0 ? 0 : i2);
        } else {
            i2 = 0;
        }
        l &= l6;
        if (obj.V != l5) {
            obj.O.setVisibility(i2);
            obj.U.setVisibility(i2);
            BindingAdapters.n0(obj.P, str);
            g.c(obj.Q, charSequence);
            obj.R.setVisibility(i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.i6
    public boolean y() {
        synchronized (this) {
            try {
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private j6(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (View)objectArr[6], (AppCompatImageView)objectArr[3], (ImageView)objectArr[1], (TextView)objectArr[5], (AppCompatImageView)objectArr[4]);
        this.V = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        Object obj7 = objectArr[0];
        this.T = obj7;
        obj7.setTag(obj6);
        Object obj8 = objectArr[2];
        this.U = obj8;
        obj8.setTag(obj6);
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        this.R.setTag(obj6);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.i6
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
