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
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.util.f0.m;

/* loaded from: classes.dex */
public class j4 extends app.dogo.com.dogo_android.h.i4 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j4.X = sparseIntArray;
        sparseIntArray.put(2131363295, 6);
    }

    public j4(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, j4.W, j4.X));
    }

    private j4(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ConstraintLayout)object3Arr3[0], (ImageView)object3Arr3[1], (TextView)object3Arr3[4], (TextView)object3Arr3[3], (ImageView)object3Arr3[2], (ImageView)object3Arr3[5], (ImageView)object3Arr3[6]);
        this.V = -1;
        int obj15 = 0;
        this.O.setTag(obj15);
        this.P.setTag(obj15);
        this.Q.setTag(obj15);
        this.R.setTag(obj15);
        this.S.setTag(obj15);
        this.T.setTag(obj15);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.i4
    public void A() {
        this.V = 2;
        I();
        return;
        synchronized (this) {
            this.V = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i4
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.i4
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

    @Override // app.dogo.com.dogo_android.h.i4
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

    @Override // app.dogo.com.dogo_android.h.i4
    protected void m() {
        Object programExam;
        long l;
        int cmp;
        int i4;
        boolean empty;
        int i;
        int i3;
        int pENDING;
        int cmp2;
        int status;
        int i2;
        int i6;
        int hasNewUpdates;
        int i7;
        int videoUrl;
        int name;
        int thumbnailUrl;
        int i5;
        final Object obj = this;
        l = obj.V;
        final int i9 = 0;
        obj.V = i9;
        programExam = obj.U;
        final int i10 = 3;
        int cmp3 = Long.compare(i11, i9);
        int i12 = 32;
        status = 0;
        i2 = 0;
        synchronized (this) {
            obj = this;
            l = obj.V;
            i9 = 0;
            obj.V = i9;
            programExam = obj.U;
            i10 = 3;
            cmp3 = Long.compare(i11, i9);
            i12 = 32;
            status = 0;
            i2 = 0;
        }
        if (programExam != null) {
            hasNewUpdates = programExam.getHasNewUpdates();
            videoUrl = programExam.getVideoUrl();
            name = programExam.getName();
            thumbnailUrl = programExam.getThumbnailUrl();
        } else {
            try {
                thumbnailUrl = name;
                if (cmp3 != 0) {
                }
                if (ViewDataBinding.K(hasNewUpdates)) {
                } else {
                }
                l |= i12;
                l |= i5;
                empty = videoUrl.isEmpty();
            }
            empty = i2;
            if (Long.compare(i5, i9) != 0) {
                i5 = empty ? 8 : 4;
                l |= i5;
            }
            i4 = empty ? 8 : i2;
            i7 = name;
            i = thumbnailUrl;
            if (Long.compare(i13, i9) != 0) {
                if (programExam != null) {
                    status = programExam.getStatus();
                }
                i3 = status != ProgramExam.Status.PENDING ? 1 : i2;
            } else {
            }
            cmp2 = Long.compare(i14, i9);
            if (cmp2 != 0) {
                if (i6 != 0) {
                } else {
                    i3 = i2;
                }
                if (cmp2 != 0) {
                    cmp2 = i3 != 0 ? 128 : 64;
                    l |= cmp2;
                }
                name = i3 != 0 ? i2 : 8;
                i2 = name;
            }
            if (Long.compare(i8, i9) != 0) {
                m.o(obj.P, i);
                g.c(obj.Q, i7);
                i.q(obj.R, programExam);
                obj.S.setVisibility(i4);
                obj.T.setVisibility(i2);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.i4
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
