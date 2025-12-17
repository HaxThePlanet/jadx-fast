package app.dogo.com.dogo_android.i;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/debug/BaseDebugFeatureItem;", "", "name", "", "key", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getName", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class f0 {

    private final String a;
    private final String b;
    public f0(String string, String string2) {
        n.f(string, "name");
        n.f(string2, "key");
        super();
        this.a = string;
        this.b = string2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }
}
