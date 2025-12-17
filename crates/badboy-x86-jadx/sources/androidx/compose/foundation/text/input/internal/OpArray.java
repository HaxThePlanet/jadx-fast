package androidx.compose.foundation.text.input.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0083@\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005B\u0011\u0008\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\u0008\u0004\u0010\u0008J\u001b\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0012\u0010\u0013Jo\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00102K\u0010\u0018\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u00020\u00150\u0019H\u0086\u0008¢\u0006\u0004\u0008\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\"\u0010\nJ-\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\u0008%\u0010&J\u0010\u0010'\u001a\u00020(HÖ\u0001¢\u0006\u0004\u0008)\u0010*R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0006\u0092\u0001\u00020\u0007\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006,", d2 = {"Landroidx/compose/foundation/text/input/internal/OpArray;", "", "size", "", "constructor-impl", "(I)[I", "values", "", "([I)[I", "getSize-impl", "([I)I", "copyOf", "newSize", "copyOf-pSmdads", "([II)[I", "equals", "", "other", "equals-impl", "([ILjava/lang/Object;)Z", "forEach", "", "max", "reversed", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "offset", "srcLen", "destLen", "forEach-impl", "([IIZLkotlin/jvm/functions/Function3;)V", "hashCode", "hashCode-impl", "set", "index", "set-impl", "([IIIII)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
final class OpArray {

    private static final androidx.compose.foundation.text.input.internal.OpArray.Companion Companion = null;
    @Deprecated
    public static final int ElementSize = 3;
    private final int[] values;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/compose/foundation/text/input/internal/OpArray$Companion;", "", "()V", "ElementSize", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        OpArray.Companion companion = new OpArray.Companion(0);
        OpArray.Companion = companion;
    }

    private OpArray(int[] values) {
        super();
        this.values = values;
    }

    public static final androidx.compose.foundation.text.input.internal.OpArray box-impl(int[] iArr) {
        OpArray opArray = new OpArray(iArr);
        return opArray;
    }

    public static int[] constructor-impl(int size) {
        return OpArray.constructor-impl(new int[size * 3]);
    }

    private static int[] constructor-impl(int[] iArr) {
        return iArr;
    }

    public static final int[] copyOf-pSmdads(int[] arg0, int newSize) {
        int[] copyOf = Arrays.copyOf(arg0, newSize * 3);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return OpArray.constructor-impl(copyOf);
    }

    public static boolean equals-impl(int[] iArr, Object object2) {
        final int i2 = 0;
        if (object2 instanceof OpArray == null) {
            return i2;
        }
        if (!Intrinsics.areEqual(iArr, (OpArray)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(int[] iArr, int[] i2Arr2) {
        return Intrinsics.areEqual(iArr, i2Arr2);
    }

    public static final void forEach-impl(int[] arg0, int max, boolean reversed, Function3<? super Integer, ? super Integer, ? super Integer, Unit> block) {
        int i;
        int i3;
        int i4;
        int i2;
        Integer valueOf2;
        Integer valueOf;
        Integer valueOf3;
        final int i5 = 0;
        if (max < 0) {
        }
        if (reversed) {
            i = max + -1;
            while (-1 < i) {
                block.invoke(Integer.valueOf(arg0[i * 3]), Integer.valueOf(arg0[i8++]), Integer.valueOf(arg0[i12 += 2]));
                i--;
            }
        } else {
            i = 0;
            while (i < max) {
                block.invoke(Integer.valueOf(arg0[i * 3]), Integer.valueOf(arg0[i10++]), Integer.valueOf(arg0[i14 += 2]));
                i++;
            }
        }
    }

    public static void forEach-impl$default(int[] arg0, int max, boolean reversed, Function3 block, int i5, Object object6) {
        int i;
        int i2;
        int i3;
        Integer valueOf;
        Integer valueOf2;
        Integer valueOf3;
        int obj8;
        int obj11;
        if (i5 &= 2 != 0) {
            obj8 = 0;
        }
        int obj10 = 0;
        if (max < 0) {
        }
        if (obj8 != null) {
            obj11 = max + -1;
            while (-1 < obj11) {
                block.invoke(Integer.valueOf(arg0[obj11 * 3]), Integer.valueOf(arg0[i7++]), Integer.valueOf(arg0[i11 += 2]));
                obj11--;
            }
        } else {
            obj11 = 0;
            while (obj11 < max) {
                block.invoke(Integer.valueOf(arg0[obj11 * 3]), Integer.valueOf(arg0[i9++]), Integer.valueOf(arg0[i13 += 2]));
                obj11++;
            }
        }
    }

    public static final int getSize-impl(int[] arg0) {
        return length /= 3;
    }

    public static int hashCode-impl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static final void set-impl(int[] arg0, int index, int offset, int srcLen, int destLen) {
        arg0[index * 3] = offset;
        arg0[i2++] = srcLen;
        arg0[i4 += 2] = destLen;
    }

    public static String toString-impl(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("OpArray(values=").append(Arrays.toString(iArr)).append(')').toString();
    }

    public boolean equals(Object object) {
        return OpArray.equals-impl(this.values, object);
    }

    public int hashCode() {
        return OpArray.hashCode-impl(this.values);
    }

    public String toString() {
        return OpArray.toString-impl(this.values);
    }

    public final int[] unbox-impl() {
        return this.values;
    }
}
