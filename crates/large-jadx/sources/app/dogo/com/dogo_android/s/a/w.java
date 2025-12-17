package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;
import java.util.Map;

/* loaded from: classes.dex */
public final class w implements n {

    public final app.dogo.com.dogo_android.s.a.z2 a;
    public final Map b;
    public w(app.dogo.com.dogo_android.s.a.z2 z2, Map map2) {
        super();
        this.a = z2;
        this.b = map2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return z2.e(this.a, this.b, (String)object);
    }
}
