package androidx.compose.foundation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J \u0010\u000c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f", d2 = {"Landroidx/compose/foundation/Api31Impl;", "", "()V", "create", "Landroid/widget/EdgeEffect;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "getDistance", "", "edgeEffect", "onPullDistance", "deltaDistance", "displacement", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Api31Impl {

    public static final androidx.compose.foundation.Api31Impl INSTANCE;
    static {
        Api31Impl api31Impl = new Api31Impl();
        Api31Impl.INSTANCE = api31Impl;
    }

    public final EdgeEffect create(Context context, AttributeSet attrs) {
        EdgeEffect edgeEffect2;
        EdgeEffect edgeEffect;
        edgeEffect2 = new EdgeEffect(context, attrs);
        return edgeEffect2;
    }

    public final float getDistance(EdgeEffect edgeEffect) {
        float distance;
        int i;
        distance = edgeEffect.getDistance();
        return distance;
    }

    public final float onPullDistance(EdgeEffect edgeEffect, float deltaDistance, float displacement) {
        float onPullDistance;
        int i;
        onPullDistance = edgeEffect.onPullDistance(deltaDistance, displacement);
        return onPullDistance;
    }
}
