package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0003R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000f¨\u0006\u001a", d2 = {"Landroidx/compose/material3/carousel/Arrangement;", "", "priority", "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "(IFIFIFI)V", "getLargeCount", "()I", "getLargeSize", "()F", "getMediumCount", "getMediumSize", "getSmallCount", "getSmallSize", "cost", "targetLargeSize", "isValid", "", "itemCount", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Arrangement {

    public static final int $stable = 0;
    public static final androidx.compose.material3.carousel.Arrangement.Companion Companion = null;
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0015\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u0008H\u0002JX\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013J`\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00082\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "()V", "MediumItemFlexPercentage", "", "calculateLargeSize", "availableSpace", "smallCount", "", "smallSize", "mediumCount", "largeCount", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "itemSpacing", "targetSmallSize", "minSmallSize", "maxSmallSize", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", "priority", "mediumSize", "largeSize", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        private final float calculateLargeSize(float availableSpace, int smallCount, float smallSize, int mediumCount, int largeCount) {
            final int i7 = 1073741824;
            return i3 /= i6;
        }

        private final androidx.compose.material3.carousel.Arrangement fit(int priority, float availableSpace, float itemSpacing, int smallCount, float smallSize, float minSmallSize, float maxSmallSize, int mediumCount, float mediumSize, int largeCount, float largeSize) {
            float arrangedSmallSize;
            int i3;
            int i;
            int cmp;
            float f;
            int arrangedMediumSize;
            float distribute;
            int i4;
            int i2;
            float arrangedLargeSize;
            int i12 = smallCount;
            int i17 = mediumCount;
            int i19 = largeCount;
            i = availableSpace - i7;
            arrangedSmallSize = RangesKt.coerceIn(smallSize, minSmallSize, maxSmallSize);
            final int i29 = i - i28;
            final int i30 = 0;
            if (i12 > 0 && Float.compare(i29, i30) > 0) {
                if (Float.compare(i29, i30) > 0) {
                    arrangedSmallSize += cmp;
                } else {
                    if (i12 > 0 && Float.compare(i29, i30) < 0) {
                        if (Float.compare(i29, i30) < 0) {
                            arrangedSmallSize += cmp;
                        }
                    }
                }
            } else {
            }
            f = i12 > 0 ? arrangedSmallSize : i30;
            arrangedLargeSize = this.calculateLargeSize(i, i12, f, i17, i19);
            final int i31 = i;
            float f4 = f;
            arrangedSmallSize2 /= i3;
            if (i17 > 0) {
                i3 = Float.compare(arrangedLargeSize, largeSize) == 0 ? 1 : 0;
                if (i3 == 0) {
                    i8 *= f3;
                    float f10 = Math.min(Math.abs(i3), i11 *= f8);
                    if (Float.compare(i3, i30) > 0) {
                        arrangedMediumSize -= i23;
                        distribute = arrangedLargeSize;
                    } else {
                        arrangedMediumSize += i24;
                        distribute = arrangedLargeSize;
                    }
                } else {
                    distribute = arrangedLargeSize;
                }
            } else {
            }
            Arrangement arrangement = new Arrangement(priority, f4, smallCount, arrangedMediumSize, i17, distribute, i19);
            return arrangement;
        }

        public final androidx.compose.material3.carousel.Arrangement findLowestCostArrangement(float availableSpace, float itemSpacing, float targetSmallSize, float minSmallSize, float maxSmallSize, int[] smallCounts, float targetMediumSize, int[] mediumCounts, float targetLargeSize, int[] largeCounts) {
            int[] lowestCostArrangement2;
            int lowestCostArrangement;
            int i6;
            int priority;
            int i;
            int cmp;
            int length2;
            float f4;
            int i9;
            int length;
            int i11;
            float f;
            int i2;
            float f2;
            int i3;
            float f3;
            int i7;
            int i4;
            int i10;
            int i5;
            int i8;
            androidx.compose.material3.carousel.Arrangement arrangement;
            lowestCostArrangement2 = smallCounts;
            final int[] iArr = mediumCounts;
            final int[] iArr2 = largeCounts;
            i6 = 0;
            priority = 1;
            final int i15 = 0;
            i = i15;
            while (i < iArr2.length) {
                length2 = iArr.length;
                i9 = i15;
                while (i9 < length2) {
                    length = lowestCostArrangement2.length;
                    i11 = i15;
                    while (i11 < length) {
                        f3 = targetLargeSize;
                        lowestCostArrangement = i6;
                        androidx.compose.material3.carousel.Arrangement arrangement2 = arrangement;
                        lowestCostArrangement = arrangement2;
                        if (Float.compare(f6, f4) == 0) {
                        } else {
                        }
                        cmp = i15;
                        priority++;
                        i11 = i8 + 1;
                        i6 = lowestCostArrangement;
                        i = i7;
                        length2 = i4;
                        i9 = i10;
                        length = i5;
                        lowestCostArrangement2 = smallCounts;
                        cmp = 1;
                    }
                    f3 = targetLargeSize;
                    int i12 = i6;
                    i7 = i;
                    i4 = length2;
                    i9 = i10 + 1;
                    lowestCostArrangement2 = smallCounts;
                    f3 = targetLargeSize;
                    lowestCostArrangement = i6;
                    arrangement2 = arrangement;
                    lowestCostArrangement = arrangement2;
                    if (Float.compare(f6, f4) == 0) {
                    } else {
                    }
                    cmp = i15;
                    priority++;
                    i11 = i8 + 1;
                    i6 = lowestCostArrangement;
                    i = i7;
                    length2 = i4;
                    i9 = i10;
                    length = i5;
                    lowestCostArrangement2 = smallCounts;
                    cmp = 1;
                }
                f3 = targetLargeSize;
                i = i7 + 1;
                lowestCostArrangement2 = smallCounts;
                length = lowestCostArrangement2.length;
                i11 = i15;
                while (i11 < length) {
                    f3 = targetLargeSize;
                    lowestCostArrangement = i6;
                    arrangement2 = arrangement;
                    lowestCostArrangement = arrangement2;
                    if (Float.compare(f6, f4) == 0) {
                    } else {
                    }
                    cmp = i15;
                    priority++;
                    i11 = i8 + 1;
                    i6 = lowestCostArrangement;
                    i = i7;
                    length2 = i4;
                    i9 = i10;
                    length = i5;
                    lowestCostArrangement2 = smallCounts;
                    cmp = 1;
                }
                f3 = targetLargeSize;
                i12 = i6;
                i7 = i;
                i4 = length2;
                i9 = i10 + 1;
                lowestCostArrangement2 = smallCounts;
                f3 = targetLargeSize;
                lowestCostArrangement = i6;
                arrangement2 = arrangement;
                lowestCostArrangement = arrangement2;
                if (Float.compare(f6, f4) == 0) {
                } else {
                }
                cmp = i15;
                priority++;
                i11 = i8 + 1;
                i6 = lowestCostArrangement;
                i = i7;
                length2 = i4;
                i9 = i10;
                length = i5;
                lowestCostArrangement2 = smallCounts;
                cmp = 1;
            }
            float f9 = targetLargeSize;
            return i6;
        }
    }
    static {
        Arrangement.Companion companion = new Arrangement.Companion(0);
        Arrangement.Companion = companion;
    }

    public Arrangement(int priority, float smallSize, int smallCount, float mediumSize, int mediumCount, float largeSize, int largeCount) {
        super();
        this.priority = priority;
        this.smallSize = smallSize;
        this.smallCount = smallCount;
        this.mediumSize = mediumSize;
        this.mediumCount = mediumCount;
        this.largeSize = largeSize;
        this.largeCount = largeCount;
    }

    public static final float access$cost(androidx.compose.material3.carousel.Arrangement $this, float targetLargeSize) {
        return $this.cost(targetLargeSize);
    }

    private final float cost(float targetLargeSize) {
        if (!isValid()) {
            return 2139095039;
        }
        return f *= f2;
    }

    private final boolean isValid() {
        int mediumCount;
        int largeCount;
        int cmp;
        int i;
        float mediumSize;
        i = 0;
        final int i2 = 1;
        if (this.largeCount > 0 && this.smallCount > 0 && this.mediumCount > 0 && Float.compare(largeSize2, mediumSize) > 0 && Float.compare(mediumSize2, mediumSize) > 0) {
            if (this.smallCount > 0) {
                if (this.mediumCount > 0) {
                    if (Float.compare(largeSize2, mediumSize) > 0) {
                        if (Float.compare(mediumSize2, mediumSize) > 0) {
                            i = i2;
                        }
                    }
                    return i;
                }
            }
        }
        if (this.largeCount > 0 && this.smallCount > 0 && Float.compare(largeSize, smallSize) > 0) {
            if (this.smallCount > 0) {
                if (Float.compare(largeSize, smallSize) > 0) {
                    i = i2;
                }
                return i;
            }
        }
        return i2;
    }

    public final int getLargeCount() {
        return this.largeCount;
    }

    public final float getLargeSize() {
        return this.largeSize;
    }

    public final int getMediumCount() {
        return this.mediumCount;
    }

    public final float getMediumSize() {
        return this.mediumSize;
    }

    public final int getSmallCount() {
        return this.smallCount;
    }

    public final float getSmallSize() {
        return this.smallSize;
    }

    public final int itemCount() {
        return i += smallCount;
    }
}
