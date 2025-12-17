package androidx.compose.ui.util;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0008\u001a\u0019\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0006H\u0086\u0008\u001a\u0011\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0001H\u0086\u0008\u001a\u0011\u0010\t\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0001H\u0086\u0008\u001a\u0011\u0010\n\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0001H\u0086\u0008\u001a\u0011\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0001H\u0086\u0008\u001a\u0011\u0010\u000c\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0001H\u0086\u0008\u001a\u0011\u0010\r\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0001H\u0086\u0008¨\u0006\u000e", d2 = {"packFloats", "", "val1", "", "val2", "packInts", "", "unpackAbsFloat1", "value", "unpackAbsFloat2", "unpackFloat1", "unpackFloat2", "unpackInt1", "unpackInt2", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InlineClassHelperKt {
    public static final long packFloats(float val1, float val2) {
        final int i = 0;
        return i3 |= i5;
    }

    public static final long packInts(int val1, int val2) {
        final int i = 0;
        return i2 |= i5;
    }

    public static final float unpackAbsFloat1(long value) {
        final int i = 0;
        final int i6 = 0;
        return Float.intBitsToFloat((int)i4);
    }

    public static final float unpackAbsFloat2(long value) {
        final int i = 0;
        final int i5 = 0;
        return Float.intBitsToFloat((int)i3);
    }

    public static final float unpackFloat1(long value) {
        final int i = 0;
        final int i5 = 0;
        return Float.intBitsToFloat((int)i3);
    }

    public static final float unpackFloat2(long value) {
        final int i = 0;
        final int i4 = 0;
        return Float.intBitsToFloat((int)i2);
    }

    public static final int unpackInt1(long value) {
        final int i = 0;
        return (int)i3;
    }

    public static final int unpackInt2(long value) {
        final int i = 0;
        return (int)i2;
    }
}
