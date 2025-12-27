package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: EventParameters.kt */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008&\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/tracking/EventParameter;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: z2, reason: from kotlin metadata */
public abstract class EventParameter {

    /* renamed from: a, reason: from kotlin metadata */
    private final String name;
    public z2(String str) {
        n.f(str, "name");
        super();
        this.name = str;
    }

    public final String a() {
        return this.name;
    }
}
