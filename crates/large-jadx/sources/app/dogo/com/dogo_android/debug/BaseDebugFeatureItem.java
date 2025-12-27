package app.dogo.com.dogo_android.i;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DebugFeatureItem.kt */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/debug/BaseDebugFeatureItem;", "", "name", "", "key", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getName", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f0, reason: from kotlin metadata */
public abstract class BaseDebugFeatureItem {

    /* renamed from: a, reason: from kotlin metadata */
    private final String name;
    private final String b;
    public f0(String str, String str2) {
        n.f(str, "name");
        n.f(str2, "key");
        super();
        this.name = str;
        this.b = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.name;
    }
}
