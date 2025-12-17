package app.dogo.com.dogo_android.util;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008\u0016\u0018\u0000 \"*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0001\"B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0014J\u0006\u0010\u001d\u001a\u00020\u001eJ%\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00042\u0008\u0010 \u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010!R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001a\u0010\u000c\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0005¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "T", "", "defaultLifetimeMs", "", "(J)V", "_data", "get_data", "()Ljava/lang/Object;", "set_data", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "_ownerId", "", "get_ownerId", "()Ljava/lang/String;", "set_ownerId", "(Ljava/lang/String;)V", "updateTimeMs", "getUpdateTimeMs", "()J", "setUpdateTimeMs", "getData", "ownerId", "currentTimeMs", "(Ljava/lang/String;J)Ljava/lang/Object;", "isCacheValid", "", "cacheLifetimeMs", "reset", "", "setData", "data", "(Ljava/lang/String;JLjava/lang/Object;)V", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class z<T>  {

    public static final app.dogo.com.dogo_android.util.z.a Companion;
    private final long a;
    private String b;
    private T c;
    private long d;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/util/SimpleSessionCache$Companion;", "", "()V", "UNTERMINATED_CACHE_LIFETIME", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        z.a aVar = new z.a(0);
        z.Companion = aVar;
    }

    public z(long l) {
        super();
        this.a = l;
        this.b = "";
    }

    public T a(String string, long l2) {
        Object obj8;
        n.f(string, "ownerId");
        obj8 = this.d(string, l2, obj4) ? this.c : 0;
        return obj8;
    }

    protected final T b() {
        return this.c;
    }

    protected final String c() {
        return this.b;
    }

    protected boolean d(String string, long l2, long l3) {
        int i;
        int i2;
        int i3;
        boolean obj6;
        n.f(string, "ownerId");
        final int i5 = 0;
        i = Long.compare(obj9, i4) == 0 ? i2 : i5;
        if (!n.b(this.b, string)) {
            i2 = i5;
        } else {
        }
        return i2;
    }

    public final void e() {
        this.b = "";
        this.d = 0;
        this.c = 0;
    }

    public final void f(String string, long l2, T t3) {
        n.f(string, "ownerId");
        this.c = obj5;
        this.b = string;
        this.d = l2;
    }
}
