package app.dogo.com.dogo_android.util.h0;

import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import nl.dionsegijn.konfetti.KonfettiView;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b1 implements Runnable {

    public final /* synthetic */ KonfettiView a;
    public final /* synthetic */ NestedScrollView b;
    public final /* synthetic */ ViewGroup c;
    public /* synthetic */ b1(KonfettiView konfettiView, NestedScrollView nestedScrollView, ViewGroup viewGroup) {
        super();
        this.a = konfettiView;
        this.b = nestedScrollView;
        this.c = viewGroup;
    }

    @Override // java.lang.Runnable
    public final void run() {
        app.dogo.com.dogo_android.util.extensionfunction.k1.i(this.a, this.b, this.c);
    }
}
