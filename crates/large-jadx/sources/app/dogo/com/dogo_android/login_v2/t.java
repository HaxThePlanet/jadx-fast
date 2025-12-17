package app.dogo.com.dogo_android.login_v2;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0003\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/login_v2/DogoLoginMessage;", "", "resId", "", "notTranslatable", "", "(ILjava/lang/String;)V", "getNotTranslatable", "()Ljava/lang/String;", "getResId", "()I", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class t {

    private final int a;
    private final String b;
    public t(int i, String string2) {
        n.f(string2, "notTranslatable");
        super();
        this.a = i;
        this.b = string2;
    }

    public t(int i, String string2, int i3, g g4) {
        int obj1;
        String obj2;
        obj1 = i3 & 1 != 0 ? 0 : obj1;
        obj2 = i3 &= 2 != 0 ? "" : obj2;
        super(obj1, obj2);
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }
}
