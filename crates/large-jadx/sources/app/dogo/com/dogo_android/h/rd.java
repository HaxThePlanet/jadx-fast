package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.k.m;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class rd extends app.dogo.com.dogo_android.h.qd {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout V;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        rd.Y = sparseIntArray;
        sparseIntArray.put(2131363185, 6);
        sparseIntArray.put(2131363441, 7);
        sparseIntArray.put(2131362483, 8);
    }

    public rd(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, rd.X, rd.Y));
    }

    private rd(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        super(e, view2, 1, (WebView)object3Arr3[4], (TextView)object3Arr3[3], (ImageView)object3Arr3[8], (MaterialButton)object3Arr3[5], (ImageView)object3Arr3[1], (ScrollView)object3Arr3[6], (FrameLayout)object3Arr3[2], (MaterialToolbar)object3Arr3[7]);
        obj20.W = -1;
        int i11 = 0;
        obj20.O.setTag(i11);
        obj20.P.setTag(i11);
        obj20.Q.setTag(i11);
        obj20.R.setTag(i11);
        Object obj10 = object3Arr3[0];
        obj20.V = (ConstraintLayout)obj10;
        obj10.setTag(i11);
        obj20.S.setTag(i11);
        View view5 = view2;
        N(view2);
        A();
    }

    private boolean W(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.W = obj3 |= i;
            return 1;
            synchronized (this) {
                this.W = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.qd
    public void A() {
        this.W = 4;
        I();
        return;
        synchronized (this) {
            this.W = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qd
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.qd
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((m)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.qd
    public void V(m m) {
        this.U = m;
        this.W = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.U = m;
            this.W = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qd
    protected void m() {
        int cmp;
        Object value;
        x xVar;
        int cmp3;
        int cmp2;
        com.google.android.material.button.MaterialButton materialButton;
        Article article;
        int title;
        int image;
        int i;
        long l = this.W;
        final int i3 = 0;
        this.W = i3;
        m mVar = this.U;
        cmp3 = Long.compare(i6, i3);
        int i7 = 6;
        final int i9 = 0;
        synchronized (this) {
            l = this.W;
            i3 = 0;
            this.W = i3;
            mVar = this.U;
            cmp3 = Long.compare(i6, i3);
            i7 = 6;
            i9 = 0;
        }
        try {
            if (mVar != null) {
            } else {
            }
            article = mVar.j();
            article = i9;
            title = article.getTitle();
            image = article.getImage();
            title = i9;
        }
        title = article;
        image = title;
        if (mVar != null) {
            xVar = mVar.l();
        } else {
            xVar = i9;
        }
        Q(0, xVar);
        if (xVar != null) {
            value = xVar.getValue();
        } else {
            value = i9;
        }
        if (Long.compare(i8, i3) != 0) {
            l.C(this.O, article, this.Q);
            g.c(this.P, title);
            f.f(this.R, image);
        }
        if (cmp3 != 0) {
            n.Z(this.Q, value);
            n.x0(this.V, value);
        }
        if (Long.compare(i2, i3) != 0) {
            n.k0(this.S, i9);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qd
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
