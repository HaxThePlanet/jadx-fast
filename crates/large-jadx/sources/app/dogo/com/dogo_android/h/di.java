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
import androidx.databinding.g;
import androidx.databinding.i;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.k0.d;

/* loaded from: classes.dex */
public class di extends app.dogo.com.dogo_android.h.ci implements b.a {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0;
    private final ImageView V;
    private final ImageView W;
    private final ImageView X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private g a0;
    private long b0;

    class a implements g {

        final app.dogo.com.dogo_android.h.di a;
        a(app.dogo.com.dogo_android.h.di di) {
            this.a = di;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            a commentField;
            int i;
            int i2;
            commentField = diVar2.U;
            final int i3 = 0;
            i2 = commentField != null ? i : i3;
            if (i2 != 0) {
                commentField = commentField.commentField;
                if (commentField != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    commentField.e(g.a(diVar.Q));
                }
            }
        }
    }
    static {
    }

    public di(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, di.c0, di.d0));
    }

    private di(e e, View view2, Object[] object3Arr3) {
        int i3 = 2;
        final int i9 = 1;
        super(e, view2, 2, (FrameLayout)object3Arr3[8], (TextView)object3Arr3[4], (EditText)object3Arr3[i3], (ImageView)object3Arr3[i9], (ConstraintLayout)object3Arr3[0], (FrameLayout)object3Arr3[3]);
        di.a obj13 = new di.a(this);
        this.a0 = obj13;
        this.b0 = -1;
        int i7 = 0;
        this.O.setTag(i7);
        this.P.setTag(i7);
        this.Q.setTag(i7);
        obj13 = object3Arr3[5];
        this.V = (ImageView)obj13;
        obj13.setTag(i7);
        obj13 = object3Arr3[6];
        this.W = (ImageView)obj13;
        obj13.setTag(i7);
        obj13 = object3Arr3[7];
        this.X = (ImageView)obj13;
        obj13.setTag(i7);
        this.R.setTag(i7);
        this.S.setTag(i7);
        this.T.setTag(i7);
        N(view2);
        obj13 = new b(this, i3);
        this.Y = obj13;
        obj13 = new b(this, i9);
        this.Z = obj13;
        A();
    }

    private boolean V(d d, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.b0 = l7 |= i21;
            return obj5;
            synchronized (this) {
                this.b0 = l7 |= i21;
                return obj5;
            }
        }
        if (i2 == 172) {
            this.b0 = l6 |= i20;
            return obj5;
            synchronized (this) {
                this.b0 = l6 |= i20;
                return obj5;
            }
        }
        if (i2 == 59) {
            this.b0 = l5 |= i19;
            return obj5;
            synchronized (this) {
                this.b0 = l5 |= i19;
                return obj5;
            }
        }
        if (i2 == 154) {
            this.b0 = l4 |= i18;
            return obj5;
            synchronized (this) {
                this.b0 = l4 |= i18;
                return obj5;
            }
        }
        if (i2 == 47) {
            this.b0 = l3 |= i17;
            return obj5;
            synchronized (this) {
                this.b0 = l3 |= i17;
                return obj5;
            }
        }
        if (i2 == 43) {
            this.b0 = l2 |= i16;
            return obj5;
            synchronized (this) {
                this.b0 = l2 |= i16;
                return obj5;
            }
        }
        if (i2 == 42) {
            this.b0 = l |= i15;
            return obj5;
            synchronized (this) {
                this.b0 = l |= i15;
                return obj5;
            }
        }
        try {
            return 0;
        } catch (Throwable th) {
        }
    }

    private boolean W(i<String> i, int i2) {
        if (i2 == 0) {
            this.b0 = obj3 |= i3;
            return 1;
            synchronized (this) {
                this.b0 = obj3 |= i3;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ci
    public void A() {
        this.b0 = 256;
        I();
        return;
        synchronized (this) {
            this.b0 = 256;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ci
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return V((d)object2, i3);
        }
        return W((i)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ci
    public boolean O(int i, Object object2) {
        int obj2;
        if (106 == i) {
            U((d)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ci
    public void U(d d) {
        R(1, d);
        this.U = d;
        this.b0 = l |= i3;
        notifyPropertyChanged(106);
        super.I();
        return;
        synchronized (this) {
            R(1, d);
            this.U = d;
            this.b0 = l |= i3;
            notifyPropertyChanged(106);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ci
    public final void b(int i, View view2) {
        int i2;
        d obj3;
        int obj4;
        obj4 = 0;
        final int i3 = 1;
        if (i != i3) {
            if (i != 2) {
            } else {
                obj3 = this.U;
                if (obj3 != null) {
                    obj4 = i3;
                }
                if (obj4 != null) {
                    obj3.onAvatarClick();
                }
            }
        } else {
            obj3 = this.U;
            if (obj3 != null) {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.onSendClick(this.Q);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ci
    protected void m() {
        int textSize;
        int cmp9;
        int cmp;
        long l;
        int i2;
        String quantityString;
        int cmp10;
        int cmp6;
        int cmp3;
        int cmp7;
        int i3;
        int userDogIcon;
        int i6;
        int cmp5;
        int cmp2;
        int i9;
        int textColorRes;
        int cursorPosition;
        int backgroundColorRes;
        int commentBordersVisible;
        int i4;
        int i13;
        int commentField;
        int i5;
        Object[] arr;
        int i14;
        int commentBoxEmpty;
        ImageView view;
        Integer valueOf;
        int cmp8;
        int i8;
        int cmp4;
        int i7;
        int editorActionListener;
        int cmp11;
        int commentLabelVisible;
        int commentCount;
        int i15;
        int i10;
        int i11;
        int i;
        int i12;
        final Object obj = this;
        l = obj.b0;
        int i17 = 0;
        obj.b0 = i17;
        d dVar = obj.U;
        final int i42 = 322;
        final int i43 = 266;
        int i44 = 290;
        final int i46 = 258;
        i6 = 0;
        synchronized (this) {
            obj = this;
            l = obj.b0;
            i17 = 0;
            obj.b0 = i17;
            dVar = obj.U;
            i42 = 322;
            i43 = 266;
            i44 = 290;
            i46 = 258;
            i6 = 0;
        }
        int cmp14 = Long.compare(i47, i17);
        i7 = 8;
        if (cmp14 != 0) {
            if (dVar != null) {
                try {
                    backgroundColorRes = dVar.getBackgroundColorRes(obj.S);
                    commentBordersVisible = dVar.isCommentBordersVisible();
                    editorActionListener = dVar.getEditorActionListener();
                    textColorRes = dVar.getTextColorRes(obj.Q);
                    commentBordersVisible = backgroundColorRes;
                    editorActionListener = 0;
                    if (cmp14 != 0) {
                    }
                    if (commentBordersVisible != 0) {
                    } else {
                    }
                    cmp11 = 16384;
                    cmp11 = 8192;
                    l |= cmp11;
                }
                i9 = commentBordersVisible != 0 ? i6 : i7;
            } else {
            }
        } else {
            backgroundColorRes = textColorRes;
            editorActionListener = 0;
        }
        if (Long.compare(i48, i17) != 0 && dVar != null) {
            if (dVar != null) {
                cursorPosition = dVar.getCursorPosition();
            } else {
                cursorPosition = i6;
            }
        } else {
        }
        int cmp16 = Long.compare(commentLabelVisible, i17);
        if (cmp16 != 0) {
            if (dVar != null) {
                commentLabelVisible = dVar.isCommentLabelVisible();
            } else {
                commentLabelVisible = i6;
            }
            if (cmp16 != 0) {
                if (commentLabelVisible != 0) {
                    l |= i51;
                    i15 = 65536;
                } else {
                    l |= i50;
                    i15 = 32768;
                }
                i2 |= i15;
            }
            i4 = commentLabelVisible != 0 ? i6 : i7;
            if (commentLabelVisible != 0) {
            } else {
                i7 = i6;
            }
        } else {
            i7 = i4;
        }
        if (Long.compare(i49, i17) != 0) {
            if (dVar != null) {
                commentCount = dVar.getCommentCount();
            } else {
                commentCount = i6;
            }
            cmp4 = 1;
            Object[] arr2 = new Object[cmp4];
            arr2[i6] = Integer.valueOf(commentCount);
            i3 = 2131755009;
            i13 = commentCount;
            obj.P.getResources().getQuantityString(i3, i13, arr2);
            arr = new Object[cmp4];
            arr[i6] = Integer.valueOf(i13);
            quantityString = obj.P.getResources().getQuantityString(i3, i13, arr);
        } else {
            quantityString = 0;
        }
        commentField = 0;
        if (Long.compare(i35, commentField) != 0 && dVar != null) {
            if (dVar != null) {
                userDogIcon = dVar.getUserDogIcon();
            } else {
                userDogIcon = 0;
            }
        } else {
        }
        if (Long.compare(i10, commentField) != 0) {
            commentField = dVar != null ? dVar.commentField : 0;
            obj.R(i6, commentField);
            if (commentField != 0) {
                i5 = commentField.d();
            } else {
                i5 = 0;
            }
        } else {
        }
        cmp4 = Long.compare(i54, i34);
        if (cmp4 != 0) {
            if (dVar != null) {
                commentBoxEmpty = dVar.isCommentBoxEmpty();
            } else {
                commentBoxEmpty = i6;
            }
            if (cmp4 != 0) {
                cmp8 = commentBoxEmpty != 0 ? 1024 : 512;
                l |= cmp8;
            }
            cmp8 = commentBoxEmpty != 0 ? R.color.lightGray : R.color.secondary;
            i14 = ViewDataBinding.u(view, cmp8);
        } else {
            i14 = i6;
        }
        if (Long.compare(i11, i8) != 0 && dVar != null) {
            if (dVar != null) {
                textSize = dVar.getTextSize();
                i = i7;
                i12 = editorActionListener;
            } else {
                i = i7;
                i12 = editorActionListener;
                textSize = 0;
            }
        } else {
        }
        if (Long.compare(i53, i8) != 0) {
            obj.O.setOnClickListener(obj.Y);
            int i28 = 0;
            g.e(obj.Q, i28, i28, i28, obj.a0);
            m.q(obj.Q, 0, 147536);
            obj.T.setOnClickListener(obj.Z);
        }
        int i45 = 0;
        if (Long.compare(i38, i45) != 0) {
            obj.P.setVisibility(i4);
            obj.V.setVisibility(i);
        }
        if (Long.compare(i39, i45) != 0) {
            g.c(obj.P, quantityString);
        }
        if (Long.compare(i40, i45) != 0) {
            m.s(obj.Q, i12);
            obj.Q.setTextColor(textColorRes);
            obj.W.setVisibility(i9);
            obj.X.setVisibility(i9);
            h.a(obj.S, b.b(backgroundColorRes));
        }
        int i31 = 0;
        if (Long.compare(i19, i31) != 0) {
            g.c(obj.Q, i5);
        }
        if (Long.compare(i20, i31) != 0) {
            obj.Q.setSelection(cursorPosition);
        }
        if (Long.compare(i22, i31) != 0) {
            g.d(obj.Q, textSize);
        }
        if (Long.compare(i24, i31) != 0 && ViewDataBinding.t() >= 21) {
            if (ViewDataBinding.t() >= 21) {
                obj.V.setImageTintList(b.a(i14));
            }
        }
        if (Long.compare(i16, i26) != 0) {
            m.a(obj.R, userDogIcon);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ci
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
