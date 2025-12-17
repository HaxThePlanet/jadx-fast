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

/* loaded from: classes.dex */
public class l6 extends app.dogo.com.dogo_android.h.k6 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final MaterialButton U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l6.X = sparseIntArray;
        sparseIntArray.put(2131361986, 6);
    }

    public l6(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, l6.W, l6.X));
    }

    private l6(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (View)object3Arr3[6], (AppCompatImageView)object3Arr3[3], (ImageView)object3Arr3[1], (TextView)object3Arr3[5], (AppCompatImageView)object3Arr3[4]);
        this.V = -1;
        int i7 = 0;
        this.O.setTag(i7);
        Object obj11 = object3Arr3[0];
        this.T = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        obj11 = object3Arr3[2];
        this.U = (MaterialButton)obj11;
        obj11.setTag(i7);
        this.P.setTag(i7);
        this.Q.setTag(i7);
        this.R.setTag(i7);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.k6
    public void A() {
        this.V = 2;
        I();
        return;
        synchronized (this) {
            this.V = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k6
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.k6
    public boolean O(int i, Object object2) {
        int obj2;
        if (166 == i) {
            W((TrickItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.k6
    public void W(TrickItem trickItem) {
        this.S = trickItem;
        this.V = l |= i2;
        notifyPropertyChanged(166);
        super.I();
        return;
        synchronized (this) {
            this.S = trickItem;
            this.V = l |= i2;
            notifyPropertyChanged(166);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k6
    protected void m() {
        int ratedByUser;
        int i5;
        long l;
        int cmp;
        int cmp3;
        int i;
        int i2;
        int knowledge;
        int i6;
        int cmp4;
        int i3;
        int cmp5;
        int mastered;
        int i4;
        int imageUrl;
        int name;
        int newContent;
        int cmp2;
        int i7;
        final Object obj = this;
        l = obj.V;
        final int i9 = 0;
        obj.V = i9;
        TrickItem trickItem = obj.S;
        final int i10 = 3;
        int cmp6 = Long.compare(i11, i9);
        int i12 = 512;
        int i16 = 32768;
        int i20 = 0;
        synchronized (this) {
            obj = this;
            l = obj.V;
            i9 = 0;
            obj.V = i9;
            trickItem = obj.S;
            i10 = 3;
            cmp6 = Long.compare(i11, i9);
            i12 = 512;
            i16 = 32768;
            i20 = 0;
        }
        if (trickItem != null) {
            mastered = trickItem.isMastered();
            imageUrl = trickItem.getImageUrl();
            name = trickItem.getName();
            newContent = trickItem.getNewContent();
        } else {
            try {
                name = imageUrl;
                mastered = 0;
                newContent = 0;
                if (cmp6 != 0) {
                }
                if (mastered != 0) {
                } else {
                }
                cmp2 = 2048;
                cmp2 = 1024;
                l |= cmp2;
            }
            l = newContent != 0 ? l | i16 : l | i7;
            if (Long.compare(i21, i9) != 0) {
                l = mastered ^ 1 != 0 ? l | i12 : l | cmp2;
            }
            i4 = name;
            if (Long.compare(i17, i9) != 0) {
                if (trickItem != null) {
                    knowledge = trickItem.getKnowledge();
                } else {
                    knowledge = 0;
                }
                i6 = knowledge == 0 ? 1 : 0;
            } else {
            }
            if (Long.compare(i13, i9) != 0 && trickItem != null) {
                if (trickItem != null) {
                    ratedByUser = trickItem.isRatedByUser();
                } else {
                    ratedByUser = 0;
                }
            } else {
            }
            int cmp9 = Long.compare(i14, i9);
            final int i15 = 8;
            if (cmp9 != 0) {
                i3 = mastered != 0 ? newContent : 0;
                if (cmp9 != 0) {
                    cmp2 = i3 != 0 ? 128 : 64;
                    l |= cmp2;
                }
                if (i3 != 0) {
                    i2 = 0;
                } else {
                    i2 = i15;
                }
            } else {
            }
            cmp5 = Long.compare(i19, i9);
            if (cmp5 != 0) {
                if (cmp3 != 0) {
                } else {
                    ratedByUser = 0;
                }
                if (newContent != 0) {
                } else {
                    i6 = 0;
                }
                if (cmp5 != 0) {
                    cmp5 = ratedByUser != 0 ? 8 : 4;
                    l |= cmp5;
                }
                if (Long.compare(cmp5, i9) != 0) {
                    cmp5 = i6 != 0 ? 8192 : 4096;
                    l |= cmp5;
                }
                if (i6 != 0) {
                    i = 0;
                } else {
                    i = i15;
                }
            } else {
                ratedByUser = 0;
            }
            cmp4 = Long.compare(i18, i9);
            if (cmp4 != 0) {
                if (ratedByUser != 0) {
                } else {
                    newContent = 0;
                }
                if (cmp4 != 0) {
                    cmp4 = newContent != 0 ? 32 : 16;
                    l |= cmp4;
                }
                name = newContent != 0 ? 0 : i15;
                i5 = name;
            } else {
                i5 = 0;
            }
            if (Long.compare(i8, i9) != 0) {
                obj.O.setVisibility(i2);
                obj.U.setVisibility(i);
                n.n0(obj.P, imageUrl);
                g.c(obj.Q, i4);
                obj.R.setVisibility(i5);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.k6
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
