package app.dogo.com.dogo_android.d.d;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import java.util.Map;

/* loaded from: classes.dex */
public final class i implements c {

    public final app.dogo.com.dogo_android.d.d.p a;
    public final Map b;
    public i(app.dogo.com.dogo_android.d.d.p p, Map map2) {
        super();
        this.a = p;
        this.b = map2;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return p.K(this.a, this.b, j);
    }
}
