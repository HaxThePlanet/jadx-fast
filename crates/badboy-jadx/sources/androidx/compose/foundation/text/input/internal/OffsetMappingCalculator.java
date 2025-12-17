package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000cH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0011J=\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000cH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001f", d2 = {"Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "", "()V", "ops", "Landroidx/compose/foundation/text/input/internal/OpArray;", "[I", "opsSize", "", "map", "Landroidx/compose/ui/text/TextRange;", "offset", "fromSource", "", "map-fzxv0v0", "(IZ)J", "mapFromDest", "mapFromDest--jx7JFs", "(I)J", "mapFromSource", "mapFromSource--jx7JFs", "mapStep", "opOffset", "untransformedLen", "transformedLen", "mapStep-C6u-MEY", "(IIIIZ)J", "recordEditOperation", "", "sourceStart", "sourceEnd", "newLength", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OffsetMappingCalculator {

    public static final int $stable = 8;
    private int[] ops;
    private int opsSize;
    static {
        final int i = 8;
    }

    public OffsetMappingCalculator() {
        super();
        this.ops = OpArray.constructor-impl(10);
    }

    private final long map-fzxv0v0(int offset, boolean fromSource) {
        Object start;
        int start2;
        int end;
        int[] ops;
        int opsSize;
        int end-impl;
        int i$iv;
        int i$iv2;
        int i2;
        int i5;
        int i4;
        int i;
        long mapStep-C6u-MEY;
        int i3;
        long mapStep-C6u-MEY2;
        start = this;
        int i12 = 0;
        start2 = offset;
        int i15 = 0;
        end = offset;
        final int i23 = opsSize;
        final int[] iArr = ops;
        final int i25 = 0;
        if (i23 >= 0) {
            if (fromSource ^ 1 != 0) {
                i$iv = end;
                i$iv2 = ops;
                while (-1 < i$iv2) {
                    end = i2;
                    ops = i5;
                    opsSize = i4;
                    i = 0;
                    int i22 = fromSource;
                    mapStep-C6u-MEY = start.mapStep-C6u-MEY(start2, end, ops, opsSize, i22);
                    i3 = start2;
                    mapStep-C6u-MEY2 = this.mapStep-C6u-MEY(i$iv, end, ops, opsSize, i22);
                    i$iv = Math.max(TextRange.getEnd-impl(mapStep-C6u-MEY), TextRange.getEnd-impl(mapStep-C6u-MEY2));
                    i$iv2--;
                    start2 = i11;
                    start = this;
                }
                end = start4;
                start2 = i3;
            } else {
                i$iv = start;
                i$iv2 = end;
                while (i$iv < i23) {
                    end = i2;
                    ops = i5;
                    opsSize = i4;
                    i = 0;
                    Object obj = this;
                    int i21 = fromSource;
                    mapStep-C6u-MEY = obj.mapStep-C6u-MEY(start2, end, ops, opsSize, i21);
                    i3 = start2;
                    mapStep-C6u-MEY2 = obj.mapStep-C6u-MEY(i$iv2, end, ops, opsSize, i21);
                    i$iv2 = Math.max(TextRange.getEnd-impl(mapStep-C6u-MEY), TextRange.getEnd-impl(mapStep-C6u-MEY2));
                    i$iv++;
                    start2 = start;
                }
                end = start3;
                start2 = i3;
            }
        }
        return TextRangeKt.TextRange(start2, end);
    }

    private final long mapStep-C6u-MEY(int offset, int opOffset, int untransformedLen, int transformedLen, boolean fromSource) {
        int i;
        int i2;
        long l;
        i = fromSource ? untransformedLen : transformedLen;
        i2 = fromSource ? transformedLen : untransformedLen;
        if (offset < opOffset) {
            l = TextRangeKt.TextRange(offset);
        } else {
            if (offset == opOffset) {
                if (i == 0) {
                    l = TextRangeKt.TextRange(opOffset, opOffset + i2);
                } else {
                    l = TextRangeKt.TextRange(opOffset);
                }
            } else {
                if (offset < opOffset + i) {
                    if (i2 == 0) {
                        l = TextRangeKt.TextRange(opOffset);
                    } else {
                        l = TextRangeKt.TextRange(opOffset, opOffset + i2);
                    }
                } else {
                    l = TextRangeKt.TextRange(i6 += i2);
                }
            }
        }
        return l;
    }

    public final long mapFromDest--jx7JFs(int offset) {
        return map-fzxv0v0(offset, false);
    }

    public final long mapFromSource--jx7JFs(int offset) {
        return map-fzxv0v0(offset, true);
    }

    public final void recordEditOperation(int sourceStart, int sourceEnd, int newLength) {
        int size-impl;
        int i;
        int copyOf-pSmdads;
        int i2;
        int i3 = 1;
        i = newLength >= 0 ? i3 : 0;
        if (i == 0) {
        } else {
            int i6 = Math.min(sourceStart, sourceEnd);
            final int i8 = i7 - i6;
            copyOf-pSmdads = 2;
            if (i8 < copyOf-pSmdads && i8 == newLength) {
                if (i8 == newLength) {
                }
            }
            opsSize2 += i3;
            if (i9 > OpArray.getSize-impl(this.ops)) {
                this.ops = OpArray.copyOf-pSmdads(this.ops, Math.max(i9 * 2, size-impl2 *= copyOf-pSmdads));
            }
            OpArray.set-impl(this.ops, this.opsSize, i6, i8, newLength);
            this.opsSize = i9;
        }
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected newLen to be ≥ 0, was ").append(newLength).toString().toString());
        throw illegalArgumentException;
    }
}
