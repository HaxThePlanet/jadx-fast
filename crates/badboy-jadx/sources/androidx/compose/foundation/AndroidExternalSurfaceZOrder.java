package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "", "zOrder", "", "constructor-impl", "(I)I", "getZOrder", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class AndroidExternalSurfaceZOrder {

    private static final int Behind;
    public static final androidx.compose.foundation.AndroidExternalSurfaceZOrder.Companion Companion;
    private static final int MediaOverlay;
    private static final int OnTop;
    private final int zOrder;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/AndroidExternalSurfaceZOrder$Companion;", "", "()V", "Behind", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "getBehind-B_4ceCc", "()I", "I", "MediaOverlay", "getMediaOverlay-B_4ceCc", "OnTop", "getOnTop-B_4ceCc", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getBehind-B_4ceCc() {
            return AndroidExternalSurfaceZOrder.access$getBehind$cp();
        }

        public final int getMediaOverlay-B_4ceCc() {
            return AndroidExternalSurfaceZOrder.access$getMediaOverlay$cp();
        }

        public final int getOnTop-B_4ceCc() {
            return AndroidExternalSurfaceZOrder.access$getOnTop$cp();
        }
    }
    static {
        AndroidExternalSurfaceZOrder.Companion companion = new AndroidExternalSurfaceZOrder.Companion(0);
        AndroidExternalSurfaceZOrder.Companion = companion;
        AndroidExternalSurfaceZOrder.Behind = AndroidExternalSurfaceZOrder.constructor-impl(0);
        AndroidExternalSurfaceZOrder.MediaOverlay = AndroidExternalSurfaceZOrder.constructor-impl(1);
        AndroidExternalSurfaceZOrder.OnTop = AndroidExternalSurfaceZOrder.constructor-impl(2);
    }

    private AndroidExternalSurfaceZOrder(int zOrder) {
        super();
        this.zOrder = zOrder;
    }

    public static final int access$getBehind$cp() {
        return AndroidExternalSurfaceZOrder.Behind;
    }

    public static final int access$getMediaOverlay$cp() {
        return AndroidExternalSurfaceZOrder.MediaOverlay;
    }

    public static final int access$getOnTop$cp() {
        return AndroidExternalSurfaceZOrder.OnTop;
    }

    public static final androidx.compose.foundation.AndroidExternalSurfaceZOrder box-impl(int i) {
        AndroidExternalSurfaceZOrder androidExternalSurfaceZOrder = new AndroidExternalSurfaceZOrder(i);
        return androidExternalSurfaceZOrder;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof AndroidExternalSurfaceZOrder) {
            return i3;
        }
        if (i != (AndroidExternalSurfaceZOrder)object2.unbox-impl()) {
            return i3;
        }
        return 1;
    }

    public static final boolean equals-impl0(int i, int i2) {
        int i3;
        i3 = i == i2 ? 1 : 0;
        return i3;
    }

    public static int hashCode-impl(int i) {
        return Integer.hashCode(i);
    }

    public static String toString-impl(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AndroidExternalSurfaceZOrder(zOrder=").append(i).append(')').toString();
    }

    public boolean equals(Object object) {
        return AndroidExternalSurfaceZOrder.equals-impl(this.zOrder, object);
    }

    public final int getZOrder() {
        return this.zOrder;
    }

    public int hashCode() {
        return AndroidExternalSurfaceZOrder.hashCode-impl(this.zOrder);
    }

    public String toString() {
        return AndroidExternalSurfaceZOrder.toString-impl(this.zOrder);
    }

    public final int unbox-impl() {
        return this.zOrder;
    }
}
