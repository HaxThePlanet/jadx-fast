package f.c.a.f.a.a;

import android.content.Context;
import com.google.android.play.core.internal.e1;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
public final class e {

    private static f a;
    static synchronized f a(Context context) {
        final Class<f.c.a.f.a.a.e> obj2 = e.class;
        if (e.a == null) {
            f.c.a.f.a.a.a0 a0Var = new a0(null);
            a0Var.a(new l(e1.a(context)));
            e.a = a0Var.b();
        }
        return e.a;
    }
}
