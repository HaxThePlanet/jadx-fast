package app.dogo.com.dogo_android.util.h0;

import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import nl.dionsegijn.konfetti.KonfettiView;

/* loaded from: classes.dex */
public final class b1 implements Runnable {

    public final KonfettiView a;
    public final NestedScrollView b;
    public final ViewGroup c;
    public b1(KonfettiView konfettiView, NestedScrollView nestedScrollView2, ViewGroup viewGroup3) {
        super();
        this.a = konfettiView;
        this.b = nestedScrollView2;
        this.c = viewGroup3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k1.d(this.a, this.b, this.c);
    }
}
