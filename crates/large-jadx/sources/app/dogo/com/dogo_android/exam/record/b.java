package app.dogo.com.dogo_android.exam.k;

import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements Comparator {

    public final /* synthetic */ double a;
    public final /* synthetic */ int b;
    public /* synthetic */ b(double d, int i) {
        super();
        this.a = d;
        this.b = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return this.a.t2(d2, this.b, object, object2);
    }
}
