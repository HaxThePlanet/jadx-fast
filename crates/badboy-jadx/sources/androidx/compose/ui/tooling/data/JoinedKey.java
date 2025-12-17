package androidx.compose.ui.tooling.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0003J!\u0010\n\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0006¨\u0006\u0012", d2 = {"Landroidx/compose/ui/tooling/data/JoinedKey;", "", "left", "right", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getLeft", "()Ljava/lang/Object;", "getRight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JoinedKey {

    public static final int $stable = 8;
    private final Object left;
    private final Object right;
    static {
        final int i = 8;
    }

    public JoinedKey(Object left, Object right) {
        super();
        this.left = left;
        this.right = right;
    }

    public static androidx.compose.ui.tooling.data.JoinedKey copy$default(androidx.compose.ui.tooling.data.JoinedKey joinedKey, Object object2, Object object3, int i4, Object object5) {
        Object obj1;
        Object obj2;
        if (i4 & 1 != 0) {
            obj1 = joinedKey.left;
        }
        if (i4 &= 2 != 0) {
            obj2 = joinedKey.right;
        }
        return joinedKey.copy(obj1, obj2);
    }

    public final Object component1() {
        return this.left;
    }

    public final Object component2() {
        return this.right;
    }

    public final androidx.compose.ui.tooling.data.JoinedKey copy(Object object, Object object2) {
        JoinedKey joinedKey = new JoinedKey(object, object2);
        return joinedKey;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof JoinedKey) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.left, obj.left)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.right, obj.right)) {
            return i2;
        }
        return i;
    }

    public final Object getLeft() {
        return this.left;
    }

    public final Object getRight() {
        return this.right;
    }

    public int hashCode() {
        int i;
        int i2;
        if (this.left == null) {
            i = i2;
        } else {
            i = this.left.hashCode();
        }
        if (this.right == null) {
        } else {
            i2 = this.right.hashCode();
        }
        return i3 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("JoinedKey(left=").append(this.left).append(", right=").append(this.right).append(')').toString();
    }
}
