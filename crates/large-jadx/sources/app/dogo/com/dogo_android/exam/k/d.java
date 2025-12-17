package app.dogo.com.dogo_android.exam.k;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class d implements Comparator {

    public final int a;
    public d(int i) {
        super();
        this.a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return i.h2(this.a, (Size)object, (Size)object2);
    }
}
