package app.dogo.com.dogo_android.h;

import android.net.Uri;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.dogcreation.h.g;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentDogCreationPictureBindingImpl.java */
/* loaded from: classes.dex */
public class tb extends sb {

    private static final ViewDataBinding.g Y = new ViewDataBinding$g(8);
    private static final SparseIntArray Z = new SparseIntArray();
    private final ConstraintLayout U;
    private final FrameLayout V;
    private final ok W;
    private long X;
    static {
        int i5 = 1;
        final int[] iArr2 = new int[i5];
        final int i12 = 0;
        iArr2[i12] = 4;
        int[] iArr = new int[i5];
        iArr[i12] = R.layout.layout_dog_creation_loading_spinner;
        obj.a(3, new String[] { "layout_dog_creation_loading_spinner" }, iArr2, iArr);
        obj.put(2131363433, 5);
        obj.put(2131363436, 6);
        obj.put(2131363414, 7);
    }

    public tb(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, tb.Y, tb.Z));
    }

    private boolean W(x<Uri> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(x<y<DogProfile>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.sb
    public void A() {
        synchronized (this) {
            try {
                this.X = 8L;
            } catch (Throwable th) {
            }
        }
        this.W.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.sb
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.sb
    public void M(q qVar) {
        super.M(qVar);
        this.W.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.sb
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.sb
    public void V(g gVar) {
        this.T = gVar;
        synchronized (this) {
            try {
                this.X |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sb
    protected void m() {
        Object obj;
        Object obj2;
        int i;
        y yVar;
        Uri uri = null;
        long l = 0;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.X = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 15L & l2;
        final long l6 = 13L;
        long l7 = 14L;
        i = 0;
        if (l5 != l4) {
            l = l2 & 13L;
            if (l != l4) {
                if (this.T != null) {
                    x xVar2 = this.T.s();
                } else {
                }
                Q(0, obj2);
                Object value2 = obj2 != null ? (LoadResult)value2 : i;
            }
            long l9 = l2 & 14L;
            if (l9 != l4) {
                if (this.T != null) {
                    x xVar = this.T.q();
                } else {
                }
                int cmp4 = 1;
                Q(cmp4, obj);
                if (this.T != null) {
                }
            }
        } else {
        }
        long l8 = 14L & l2;
        if (l8 != l4) {
            DogProfileBindingAdapters.P(this.O, uri);
        }
        long l3 = l2 & 13L;
        if (this.X != l4) {
            BindingAdapters.x0(this.U, yVar);
            BindingAdapters.setDebugJsonEntryItemAdapter(this.V, yVar);
            BindingAdapters.Z(this.P, yVar);
        }
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.sb
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.X != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.W.y()) {
            return true;
        }
        return false;
    }

    private tb(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (ImageView)objectArr[2], (Button)objectArr[1], (TextView)objectArr[7], (MaterialToolbar)objectArr[5], (TextView)objectArr[6]);
        this.X = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        Object obj7 = objectArr[0];
        this.U = obj7;
        obj7.setTag(obj6);
        Object obj8 = objectArr[3];
        this.V = obj8;
        obj8.setTag(obj6);
        Object obj9 = objectArr[4];
        this.W = obj9;
        L(obj9);
        this.P.setTag(obj6);
        N(view);
        A();
    }
}
