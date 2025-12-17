package androidx.compose.ui.unit.fontscaling;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u000b\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000c\u0010\u0008\u001a\u0004\u0008\r\u0010\n¨\u0006\u001c", d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "fromSp", "", "toDp", "([F[F)V", "mFromSpValues", "getMFromSpValues$annotations", "()V", "getMFromSpValues", "()[F", "mToDpValues", "getMToDpValues$annotations", "getMToDpValues", "convertDpToSp", "", "dp", "convertSpToDp", "sp", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontScaleConverterTable implements androidx.compose.ui.unit.fontscaling.FontScaleConverter {

    public static final int $stable = 8;
    public static final androidx.compose.ui.unit.fontscaling.FontScaleConverterTable.Companion Companion;
    private final float[] mFromSpValues;
    private final float[] mToDpValues;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0002¨\u0006\t", d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable$Companion;", "", "()V", "lookupAndInterpolate", "", "sourceValue", "sourceValues", "", "targetValues", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final float access$lookupAndInterpolate(androidx.compose.ui.unit.fontscaling.FontScaleConverterTable.Companion $this, float sourceValue, float[] sourceValues, float[] targetValues) {
            return $this.lookupAndInterpolate(sourceValue, sourceValues, targetValues);
        }

        private final float lookupAndInterpolate(float sourceValue, float[] sourceValues, float[] targetValues) {
            float startSp;
            int i2;
            int i3;
            int i4;
            int endSp;
            float f;
            float endDp;
            int i5;
            int i;
            int i6;
            final float f2 = Math.abs(sourceValue);
            final float signum = Math.signum(sourceValue);
            final int binarySearch = Arrays.binarySearch(sourceValues, f2);
            if (binarySearch >= 0) {
                i10 *= signum;
            } else {
                i3 = 1;
                i5 = i8 + -1;
                int i9 = 0;
                int i13 = 0;
                int i14 = 0;
                int i17 = 0;
                i6 = 0;
                if (i5 >= length -= i3) {
                    float startSp2 = sourceValues[length2 -= i3];
                    int i20 = 0;
                    if (Float.compare(startSp2, i20) == 0) {
                    } else {
                        i3 = i6;
                    }
                    if (i3 != 0) {
                        return i20;
                    }
                    return sourceValue * i11;
                }
                if (i5 == -1) {
                    i4 = 0;
                    endDp = endSp3;
                    endSp = i16;
                    f = startSp;
                } else {
                    i4 = targetValues[i5];
                    endDp = endSp2;
                    endSp = i15;
                    f = startSp;
                }
                constrainedMap *= signum;
            }
            return i2;
        }
    }
    static {
        FontScaleConverterTable.Companion companion = new FontScaleConverterTable.Companion(0);
        FontScaleConverterTable.Companion = companion;
        int i = 8;
    }

    public FontScaleConverterTable(float[] fromSp, float[] toDp) {
        int length;
        int length2;
        int i;
        super();
        if (fromSp.length == toDp.length) {
            length2 = 1;
            length = fromSp.length == 0 ? length2 : i;
            i = length == 0 ? length2 : i;
        }
        if (i == 0) {
        } else {
            this.mFromSpValues = fromSp;
            this.mToDpValues = toDp;
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequireFontScaleConverterTable$1 = new IllegalArgumentException("Array lengths must match and be nonzero".toString());
        throw $i$a$RequireFontScaleConverterTable$1;
    }

    public static void getMFromSpValues$annotations() {
    }

    public static void getMToDpValues$annotations() {
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public float convertDpToSp(float dp) {
        return FontScaleConverterTable.Companion.access$lookupAndInterpolate(FontScaleConverterTable.Companion, dp, this.mToDpValues, this.mFromSpValues);
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public float convertSpToDp(float sp) {
        return FontScaleConverterTable.Companion.access$lookupAndInterpolate(FontScaleConverterTable.Companion, sp, this.mFromSpValues, this.mToDpValues);
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public boolean equals(Object other) {
        int i;
        boolean equals;
        float[] mFromSpValues;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (other == null) {
            return i2;
        }
        if (!other instanceof FontScaleConverterTable) {
            return i2;
        }
        if (Arrays.equals(this.mFromSpValues, obj.mFromSpValues) && Arrays.equals(this.mToDpValues, obj2.mToDpValues)) {
            if (Arrays.equals(this.mToDpValues, obj2.mToDpValues)) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public final float[] getMFromSpValues() {
        return this.mFromSpValues;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public final float[] getMToDpValues() {
        return this.mToDpValues;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = Arrays.toString(this.mFromSpValues);
        final String str3 = "toString(this)";
        Intrinsics.checkNotNullExpressionValue(string2, str3);
        String string3 = Arrays.toString(this.mToDpValues);
        Intrinsics.checkNotNullExpressionValue(string3, str3);
        return stringBuilder.append("FontScaleConverter{fromSpValues=").append(string2).append(", toDpValues=").append(string3).append('}').toString();
    }
}
