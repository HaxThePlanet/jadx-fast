package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class p2 extends app.dogo.com.dogo_android.h.o2 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private long V;
    static {
    }

    public p2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, p2.W, p2.X));
    }

    private p2(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[5], (ConstraintLayout)object3Arr3[0], (ImageView)object3Arr3[1], (TextView)object3Arr3[4], (TextView)object3Arr3[3], (ImageView)object3Arr3[2]);
        this.V = -1;
        int obj14 = 0;
        this.O.setTag(obj14);
        this.P.setTag(obj14);
        this.Q.setTag(obj14);
        this.R.setTag(obj14);
        this.S.setTag(obj14);
        this.T.setTag(obj14);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o2
    public void A() {
        this.V = 2;
        I();
        return;
        synchronized (this) {
            this.V = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o2
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.o2
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((ProgramExam)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.o2
    public void V(ProgramExam programExam) {
        this.U = programExam;
        this.V = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.U = programExam;
            this.V = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o2
    protected void m() {
        Object programExam;
        long l;
        int cmp;
        int cmp2;
        int i2;
        int i3;
        int empty;
        int i4;
        int name;
        int thumbnailUrl;
        int i;
        String str;
        final Object obj = this;
        l = obj.V;
        final int i6 = 0;
        obj.V = i6;
        programExam = obj.U;
        final int i7 = 3;
        cmp2 = Long.compare(i8, i6);
        i3 = 0;
        synchronized (this) {
            obj = this;
            l = obj.V;
            i6 = 0;
            obj.V = i6;
            programExam = obj.U;
            i7 = 3;
            cmp2 = Long.compare(i8, i6);
            i3 = 0;
        }
        if (programExam != null) {
            name = programExam.getName();
            thumbnailUrl = programExam.getThumbnailUrl();
            i4 = reviewTimeMs;
            i3 = str;
        } else {
            try {
                thumbnailUrl = name;
                if (i3 != 0) {
                } else {
                }
                empty = i3.isEmpty();
                empty = i2;
                i = 8;
            }
            if (empty != 0) {
                i2 = cmp2;
            }
            i3 = i4;
            if (Long.compare(i5, i6) != 0) {
                n.O(obj.O, i3);
                m.o(obj.Q, thumbnailUrl);
                g.c(obj.R, name);
                i.q(obj.S, programExam);
                obj.T.setVisibility(i2);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.o2
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
