package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\u0008\u0014\u0010\tJ \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001e", d2 = {"Landroidx/compose/ui/node/CenteredArray;", "", "data", "", "constructor-impl", "([I)[I", "mid", "", "getMid-impl", "([I)I", "equals", "", "other", "equals-impl", "([ILjava/lang/Object;)Z", "get", "index", "get-impl", "([II)I", "hashCode", "hashCode-impl", "set", "", "value", "set-impl", "([III)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
final class CenteredArray {

    private final int[] data;
    private CenteredArray(int[] data) {
        super();
        this.data = data;
    }

    public static final androidx.compose.ui.node.CenteredArray box-impl(int[] iArr) {
        CenteredArray centeredArray = new CenteredArray(iArr);
        return centeredArray;
    }

    public static int[] constructor-impl(int[] iArr) {
        return iArr;
    }

    public static boolean equals-impl(int[] iArr, Object object2) {
        final int i2 = 0;
        if (object2 instanceof CenteredArray == null) {
            return i2;
        }
        if (!Intrinsics.areEqual(iArr, (CenteredArray)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(int[] iArr, int[] i2Arr2) {
        return Intrinsics.areEqual(iArr, i2Arr2);
    }

    public static final int get-impl(int[] arg0, int index) {
        return arg0[mid-impl += index];
    }

    private static final int getMid-impl(int[] arg0) {
        return length /= 2;
    }

    public static int hashCode-impl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static final void set-impl(int[] arg0, int index, int value) {
        arg0[mid-impl += index] = value;
    }

    public static String toString-impl(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CenteredArray(data=").append(Arrays.toString(iArr)).append(')').toString();
    }

    public boolean equals(Object object) {
        return CenteredArray.equals-impl(this.data, object);
    }

    public int hashCode() {
        return CenteredArray.hashCode-impl(this.data);
    }

    public String toString() {
        return CenteredArray.toString-impl(this.data);
    }

    public final int[] unbox-impl() {
        return this.data;
    }
}
