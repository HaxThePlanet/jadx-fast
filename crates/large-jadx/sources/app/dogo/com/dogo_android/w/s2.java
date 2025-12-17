package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0016\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0011\u0008\u0004\u0012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/tracking/Event;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class s2 {

    public static final app.dogo.com.dogo_android.w.s2.a Companion;
    private final String a;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/tracking/Event$Companion;", "", "()V", "of", "Lapp/dogo/com/dogo_android/tracking/Event0;", "name", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.w.t2 a(String string) {
            n.f(string, "name");
            final int i = 0;
            t2 t2Var = new t2(string, i, 2, i);
            return t2Var;
        }
    }
    static {
        s2.a aVar = new s2.a(0);
        s2.Companion = aVar;
    }

    protected s2(String string) {
        n.f(string, "name");
        super();
        this.a = string;
    }

    public final String a() {
        return this.a;
    }
}
