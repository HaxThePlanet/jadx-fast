package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class nh extends app.dogo.com.dogo_android.h.mh {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ScrollView Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        nh.T = sparseIntArray;
        sparseIntArray.put(2131363433, 2);
        sparseIntArray.put(2131363414, 3);
    }

    public nh(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, nh.S, nh.T));
    }

    private nh(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (WebView)object3Arr3[1], (TextView)object3Arr3[3], (MaterialToolbar)object3Arr3[2]);
        this.R = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.Q = (ScrollView)obj9;
        obj9.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.mh
    public void A() {
        this.R = 1;
        I();
        return;
        synchronized (this) {
            this.R = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mh
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.mh
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.mh
    protected void m() {
        int cmp;
        String string;
        int i;
        i = 0;
        this.R = i;
        synchronized (this) {
            i = 0;
            this.R = i;
        }
        try {
            cmp = this.O;
            n.R(cmp, cmp.getResources().getString(2131887693));
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.mh
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
