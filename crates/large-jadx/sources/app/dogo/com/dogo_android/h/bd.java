package app.dogo.com.dogo_android.h;

import android.net.Uri;
import android.util.SparseIntArray;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.exam.c;
import app.dogo.com.dogo_android.exam.k.h;
import app.dogo.com.dogo_android.exam.k.k;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentExamVideoRecordingBindingImpl.java */
/* loaded from: classes.dex */
public class bd extends ad {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0 = new SparseIntArray();
    private final FrameLayout X;
    private long Y;
    static {
        obj.put(2131362193, 7);
        obj.put(2131363039, 8);
    }

    public bd(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, bd.Z, bd.a0));
    }

    private boolean V(f.d.a.a<y<Uri>> aVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Y |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Y |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ad
    public void A() {
        synchronized (this) {
            try {
                this.Y = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ad
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ad
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            X(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                Y(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ad
    public void X(h hVar) {
        this.W = hVar;
        synchronized (this) {
            try {
                this.Y |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ad
    public void Y(k kVar) {
        this.V = kVar;
        synchronized (this) {
            try {
                this.Y |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ad
    protected void m() {
        long l;
        int i = 0;
        int cmp3;
        int i2 = 0;
        boolean z = false;
        Object obj2 = null;
        Boolean bool2 = null;
        int cmp6 = 0;
        y yVar = null;
        int cmp7 = 0;
        Object obj3 = null;
        Object value = null;
        java.lang.CharSequence charSequence = null;
        int i3 = 0;
        long l3;
        x xVar;
        int i4 = 64;
        long l4 = 128;
        final Object obj = this;
        synchronized (this) {
            try {
                l3 = 0L;
                obj.Y = l3;
            } catch (Throwable th) {
            }
        }
        long l7 = l & 28L;
        long l8 = 31L & l;
        long l9 = 24L;
        final long l11 = 25L;
        long l12 = 256L;
        final long l16 = 26L;
        if (l8 != l3) {
            if (l7 != l3) {
                if (obj.V != null) {
                    app.dogo.com.dogo_android.exam.g gVar = obj.V.k();
                } else {
                    cmp7 = 0;
                }
                long l17 = l & 24L;
                if (l17 == l3 || cmp7 == 0) {
                    i3 = 0;
                } else {
                    String str2 = cmp7.d();
                }
                if (cmp7 != 0) {
                    l3 = cmp7.b();
                } else {
                }
            } else {
                i3 = 0;
            }
            long l19 = l & 25L;
            if (l19 != l3) {
                if (obj.V != null) {
                    f.d.a.a aVar = obj.V.l();
                } else {
                    int i14 = 0;
                }
                obj.Q(0, obj3);
                value = obj3 != null ? (LoadResult)value : 0;
            }
            long l20 = l & 26L;
            if (l20 != l3) {
                xVar = obj.V != null ? xVar : 0;
                int i12 = 1;
                obj.Q(i12, obj2);
                Object value2 = obj2 != null ? (Boolean)value2 : 0;
                boolean z3 = ViewDataBinding.K(bool2);
                if (l20 != l3) {
                    int r23 = z3 ? 64 : 32;
                    l = l | (z3 ? 64 : 32);
                }
                int r21 = z3 ? 4 : 0;
                i2 = z3 ^ i12;
                l4 = l & 26L;
                if (l4 != l3) {
                    l = z3 ^ i12 != 0 ? l | l12 : l | l4;
                }
            } else {
                i2 = 0;
                cmp6 = 0;
            }
        } else {
            i2 = 0;
            cmp6 = 0;
            int i13 = 0;
            int i17 = 0;
        }
        long l13 = 256L & l;
        if (l13 == l3 || obj.V == null) {
            i = 0;
        } else {
            boolean z2 = obj.V.q();
        }
        long l14 = l & 26L;
        int r7 = l14 != l3 && i2 != 0 ? i : 0;
        long l15 = l & 20L;
        if (l15 != l3) {
            ExamFlowBindingAdapters.setupExamPlaybackButton(obj.O, obj.W);
        }
        long l10 = 24L & l;
        if (l10 != l3) {
            g.c(obj.Q, charSequence);
        }
        if (l14 != l3) {
            obj.Q.setVisibility(cmp6);
            BindingAdapters.J0(obj.U, Boolean.valueOf(z));
        }
        long l5 = l & 25L;
        if (obj.V != l3) {
            BindingAdapters.setDebugJsonEntryItemAdapter(obj.X, yVar);
        }
        long l6 = 28L & l;
        if (obj.V != l3) {
            ExamFlowBindingAdapters.setupExamPlaybackButtonVisibility(obj.R, Long.valueOf(l3), obj.W);
        }
        l2 = l & 16L;
        if (obj.Y != l3) {
            BindingAdapters.k0(obj.T, null);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ad
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Y != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private bd(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 2, (TextureView)objectArr[2], (ImageButton)objectArr[7], (AppCompatTextView)objectArr[4], (VideoRecordingButton)objectArr[6], (ProgressBar)objectArr[8], (ConstraintLayout)objectArr[0], (FrameLayout)objectArr[1], (ImageButton)objectArr[3]);
        eVar3.Y = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        eVar3.Q.setTag(obj10);
        Object obj9 = objectArr[5];
        eVar3.X = obj9;
        obj9.setTag(obj10);
        eVar3.R.setTag(obj10);
        eVar3.S.setTag(obj10);
        eVar3.T.setTag(obj10);
        eVar3.U.setTag(obj10);
        N(view);
        A();
    }
}
