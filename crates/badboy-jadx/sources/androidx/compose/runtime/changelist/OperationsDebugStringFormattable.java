package androidx.compose.runtime.changelist;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008 \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006", d2 = {"Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "", "()V", "toDebugString", "", "linePrefix", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class OperationsDebugStringFormattable {

    public static final int $stable;
    static {
    }

    public static String toDebugString$default(androidx.compose.runtime.changelist.OperationsDebugStringFormattable operationsDebugStringFormattable, String string2, int i3, Object object4) {
        String obj1;
        if (object4 != null) {
        } else {
            if (i3 &= 1 != 0) {
                obj1 = "  ";
            }
            return operationsDebugStringFormattable.toDebugString(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toDebugString");
        throw obj0;
    }

    public abstract String toDebugString(String string);
}
