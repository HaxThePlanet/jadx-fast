package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\u0008\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0008¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"findOwner", "T", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActivityComposeUtilsKt {
    public static final <T> T findOwner(Context context) {
        Object innerContext;
        Object obj;
        String str;
        final int i = 0;
        innerContext = context;
        while (innerContext instanceof ContextWrapper) {
            Intrinsics.reifiedOperationMarker(3, "T");
            innerContext = (ContextWrapper)innerContext.getBaseContext();
        }
        return 0;
    }
}
