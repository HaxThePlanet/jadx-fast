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

/* compiled from: FragmentWorkoutInfoBindingImpl.java */
/* loaded from: classes.dex */
public class nh extends mh {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ScrollView Q;
    private long R;
    static {
        obj.put(2131363433, 2);
        obj.put(2131363414, 3);
    }

    public nh(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, nh.S, nh.T));
    }

    @Override // app.dogo.com.dogo_android.h.mh
    public void A() {
        synchronized (this) {
            try {
                this.R = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.mh
    protected void m() {
        synchronized (this) {
            try {
                long l = 0L;
                this.R = l;
            } catch (Throwable th) {
            }
        }
        long l3 = this.R & 1L;
        if (l3 != l) {
            BindingAdapters.R(this.O, this.O.getResources().getString(2131887693));
        }
    }

    @Override // app.dogo.com.dogo_android.h.mh
    public boolean y() {
        synchronized (this) {
            try {
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private nh(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (WebView)objectArr[1], (TextView)objectArr[3], (MaterialToolbar)objectArr[2]);
        this.R = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.Q = obj5;
        obj5.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.mh
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.mh
    public boolean O(int i, Object object) {
        return true;
    }
}
