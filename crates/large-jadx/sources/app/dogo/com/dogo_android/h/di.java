package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.i;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.k0.d;

/* compiled from: LayoutCommentInputBindingImpl.java */
/* loaded from: classes.dex */
public class di extends ci implements b.a {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0;
    private final ImageView V;
    private final ImageView W;
    private final ImageView X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private androidx.databinding.g a0;
    private long b0;

    class a implements androidx.databinding.g {

        final /* synthetic */ di a;
        a() {
            this.a = diVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.U != null ? 1 : i;
            if (i != 0 && dVar.commentField != null) {
                if (i != 0) {
                    dVar.commentField.e(g.a(this.a.Q));
                }
            }
        }
    }
    public di(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, di.c0, di.d0));
    }

    private boolean V(d dVar, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw dVar;
            }
        }
        if (i == 172) {
            synchronized (this) {
                try {
                    this.b0 |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw dVar;
            }
        }
        if (i == 59) {
            synchronized (this) {
                try {
                    this.b0 |= 8;
                    return true;
                } catch (Throwable unused) {
                }
                throw dVar;
            }
        }
        if (i == 154) {
            synchronized (this) {
                try {
                    this.b0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 47) {
            synchronized (this) {
                try {
                    this.b0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 43) {
            synchronized (this) {
                try {
                    this.b0 |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 42) {
            synchronized (this) {
                try {
                    this.b0 |= 128;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(i<String> iVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ci
    public void A() {
        synchronized (this) {
            try {
                this.b0 = 256L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ci
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ci
    public boolean O(int i, Object object) {
        boolean z = true;
        if (106 == i) {
            U(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ci
    public void U(d dVar) {
        R(1, dVar);
        this.U = dVar;
        synchronized (this) {
            try {
                this.b0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(106);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ci
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.U != null) {
            }
            if (i2 != 0) {
                this.U.onSendClick(this.Q);
            }
        } else {
            int i3 = 2;
            if (this.U == 2) {
                if (this.U != null) {
                }
                if (this.Q != 0) {
                    this.U.onAvatarClick();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ci
    protected void m() {
        float textSize = 0;
        long l;
        long l2;
        String quantityString = null;
        Object obj3 = null;
        int cmp6;
        android.net.Uri userDogIcon = null;
        int cmp8;
        int backgroundColorRes;
        Object obj4 = null;
        Object obj = null;
        java.lang.CharSequence charSequence = null;
        Object obj5;
        int cmp9 = 2131100352;
        long l3 = 0;
        int cmp10;
        int i3 = 0;
        int i4;
        int i5;
        final Object obj2 = this;
        synchronized (this) {
            try {
                l3 = 0L;
                obj2.b0 = l3;
            } catch (Throwable th) {
            }
        }
        long l13 = 511L & l;
        final long l19 = 322L;
        final long l20 = 266L;
        long l21 = 290L;
        final long l23 = 258L;
        backgroundColorRes = 0;
        if (l13 != l3) {
            long l24 = l & 258L;
            backgroundColorRes = 8;
            if (l24 != l3) {
                if (obj2.U != null) {
                    backgroundColorRes = obj2.U.getBackgroundColorRes(obj2.S);
                    boolean commentBordersVisible = obj2.U.isCommentBordersVisible();
                    android.widget.TextView.OnEditorActionListener editorActionListener = obj2.U.getEditorActionListener();
                    backgroundColorRes = obj2.U.getTextColorRes(obj2.Q);
                } else {
                    i3 = 0;
                }
                if (l24 != l3) {
                    int r28 = backgroundColorRes != 0 ? 16384 : 8192;
                    l = l | (backgroundColorRes != 0 ? 16384 : 8192);
                }
                int r7 = backgroundColorRes;
            } else {
                i3 = 0;
            }
            long l25 = l & 266L;
            if (l25 == l3 || obj2.U == null) {
            } else {
                backgroundColorRes = obj2.U.getCursorPosition();
            }
            l5 = l & 290L;
            if (l5 != l3) {
                if (obj2.U != null) {
                    boolean commentLabelVisible = obj2.U.isCommentLabelVisible();
                } else {
                }
                if (l5 != l3) {
                    if (backgroundColorRes != 0) {
                        l2 = l | 4096L;
                        i5 = 65536;
                    } else {
                        l2 = l | 2048L;
                        i5 = 32768;
                    }
                    l = l2 | i5;
                }
                int r11 = backgroundColorRes;
                if (backgroundColorRes == 0) {
                }
            } else {
            }
            long l26 = l & 322L;
            if (l26 != l3) {
                if (obj2.U != null) {
                    backgroundColorRes = obj2.U.getCommentCount();
                } else {
                }
                int i2 = 1;
                Object[] arr2 = new Object[i2];
                arr2[backgroundColorRes] = Integer.valueOf(backgroundColorRes);
                int i = 2131755009;
                obj2.P.getResources().getQuantityString(i, backgroundColorRes, arr2);
                Object[] arr = new Object[i2];
                arr[backgroundColorRes] = Integer.valueOf(backgroundColorRes);
                quantityString = obj2.P.getResources().getQuantityString(i, backgroundColorRes, arr);
            } else {
                int i8 = 0;
            }
            long l15 = l & 262L;
            long l4 = 0L;
            if (obj2.P == l4 || obj2.U == null) {
                int i10 = 0;
            } else {
                userDogIcon = obj2.U.getUserDogIcon();
            }
            l6 = l & 259L;
            if (l6 != l4) {
                i r12 = obj2.U != null ? dVar.commentField : 0;
                obj2.R(backgroundColorRes, r12);
                obj = r12 != null ? (String)obj : 0;
            }
            long l28 = l & 386L;
            if (l28 != 0) {
                if (obj2.U != null) {
                    boolean commentBoxEmpty = obj2.U.isCommentBoxEmpty();
                } else {
                }
                if (l28 != 0) {
                    int r14 = backgroundColorRes != 0 ? 1024 : 512;
                    l = l | (backgroundColorRes != 0 ? 1024 : 512);
                }
                cmp9 = backgroundColorRes != 0 ? R.color.lightGray : R.color.secondary;
                backgroundColorRes = ViewDataBinding.u(obj5, cmp9);
            } else {
            }
            l7 = l & 274L;
            l3 = 0L;
            if (l7 == l3 || obj2.U == null) {
                int i6 = 0;
            } else {
                textSize = obj2.U.getTextSize();
            }
        } else {
            int i7 = 0;
            int i9 = 0;
            int i11 = 0;
            int i21 = 0;
            i3 = 0;
        }
        long l27 = l & 256L;
        if (l27 != obj2.P) {
            obj2.O.setOnClickListener(obj2.Y);
            androidx.databinding.k.g.c cVar = null;
            g.e(obj2.Q, cVar, cVar, cVar, obj2.a0);
            cmp10 = 0;
            app.dogo.com.dogo_android.util.binding.m.q(obj2.Q, cmp10, 147536);
            obj2.T.setOnClickListener(obj2.Z);
        }
        long l16 = l & 290L;
        long l22 = 0L;
        if (obj2.Q != l22) {
            obj2.P.setVisibility(backgroundColorRes);
            obj2.V.setVisibility(backgroundColorRes);
        }
        long l17 = l & 322L;
        if (obj2.P != l22) {
            g.c(obj2.P, obj3);
        }
        long l18 = l & 258L;
        if (obj2.P != l22) {
            app.dogo.com.dogo_android.util.binding.m.s(obj2.Q, i3);
            obj2.Q.setTextColor(backgroundColorRes);
            obj2.W.setVisibility(backgroundColorRes);
            obj2.X.setVisibility(backgroundColorRes);
            h.a(obj2.S, b.b(backgroundColorRes));
        }
        long l9 = 259L & l;
        long l14 = 0L;
        if (obj2.P != l14) {
            g.c(obj2.Q, charSequence);
        }
        long l10 = l & 266L;
        if (obj2.P != l14) {
            obj2.Q.setSelection(backgroundColorRes);
        }
        long l11 = 274L & l;
        if (obj2.P != l14) {
            g.d(obj2.Q, textSize);
        }
        long l12 = 386L & l;
        if (obj2.P != l14) {
            cmp6 = 21;
            if (ViewDataBinding.t() >= 21) {
                obj2.V.setImageTintList(b.a(backgroundColorRes));
            }
        }
        l &= 262;
        if (obj2.b0 != 0) {
            app.dogo.com.dogo_android.util.binding.m.a(obj2.R, userDogIcon);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ci
    public boolean y() {
        synchronized (this) {
            try {
                if (this.b0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private di(e eVar, View view, Object[] objectArr) {
        int i3 = 2;
        final int i8 = 1;
        super(eVar, view, 2, (FrameLayout)objectArr[8], (TextView)objectArr[4], (EditText)objectArr[i3], (ImageView)objectArr[i8], (ConstraintLayout)objectArr[0], (FrameLayout)objectArr[3]);
        this.a0 = new di.a(this);
        this.b0 = -1L;
        Object obj7 = null;
        this.O.setTag(obj7);
        this.P.setTag(obj7);
        this.Q.setTag(obj7);
        Object obj8 = objectArr[5];
        this.V = obj8;
        obj8.setTag(obj7);
        Object obj9 = objectArr[6];
        this.W = obj9;
        obj9.setTag(obj7);
        Object obj10 = objectArr[7];
        this.X = obj10;
        obj10.setTag(obj7);
        this.R.setTag(obj7);
        this.S.setTag(obj7);
        this.T.setTag(obj7);
        N(view);
        this.Y = new b(this, i3);
        this.Z = new b(this, i8);
        A();
    }

}
