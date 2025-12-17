package androidx.compose.material3.carousel;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u000cH\u0000\u001aD\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0001H\u0000\u001a(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u0001H\u0000¨\u0006\u0017", d2 = {"calculateMediumChildSize", "", "minimumMediumSize", "largeItemSize", "remainingSpace", "createLeftAlignedKeylineList", "Landroidx/compose/material3/carousel/KeylineList;", "carouselMainAxisSize", "itemSpacing", "leftAnchorSize", "rightAnchorSize", "arrangement", "Landroidx/compose/material3/carousel/Arrangement;", "multiBrowseKeylineList", "density", "Landroidx/compose/ui/unit/Density;", "preferredItemSize", "itemCount", "", "minSmallItemSize", "maxSmallItemSize", "uncontainedKeylineList", "itemSize", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeylinesKt {
    private static final float calculateMediumChildSize(float minimumMediumSize, float largeItemSize, float remainingSpace) {
        float mediumItemSize;
        int cmp;
        i3 *= largeItemSize;
        if (Float.compare(mediumItemSize, i4) > 0) {
            mediumItemSize = Math.max(i4, i5 *= remainingSpace);
        }
        return mediumItemSize;
    }

    public static final androidx.compose.material3.carousel.KeylineList createLeftAlignedKeylineList(float carouselMainAxisSize, float itemSpacing, float leftAnchorSize, float rightAnchorSize, androidx.compose.material3.carousel.Arrangement arrangement) {
        KeylinesKt.createLeftAlignedKeylineList.1 anon = new KeylinesKt.createLeftAlignedKeylineList.1(leftAnchorSize, arrangement, rightAnchorSize);
        return KeylineListKt.keylineListOf-WNYm7Xg(carouselMainAxisSize, itemSpacing, CarouselAlignment.Companion.getStart-NUL3oTo(), (Function1)anon);
    }

    public static final androidx.compose.material3.carousel.KeylineList multiBrowseKeylineList(Density density, float carouselMainAxisSize, float preferredItemSize, float itemSpacing, int itemCount, float minSmallItemSize, float maxSmallItemSize) {
        int i6;
        int[] smallCounts;
        androidx.compose.material3.carousel.Arrangement lowestCostArrangement2;
        androidx.compose.material3.carousel.Arrangement lowestCostArrangement;
        int keylineSurplus2;
        float i3;
        int smallCount2;
        int i2;
        float f;
        float targetSmallSize;
        float f3;
        float f2;
        int[] iArr2;
        int[] iArr;
        int i4;
        int i5;
        int i;
        androidx.compose.material3.carousel.Arrangement arrangement;
        int keylineSurplus;
        int smallCount;
        int i15 = carouselMainAxisSize;
        final int i29 = preferredItemSize;
        final int i30 = itemCount;
        float f8 = minSmallItemSize;
        f2 = maxSmallItemSize;
        i6 = 0;
        int i19 = 0;
        int i31 = 1;
        i2 = Float.compare(i15, i6) == 0 ? i31 : i19;
        if (i2 == 0) {
            i6 = Float.compare(i29, i6) == 0 ? i31 : i19;
            if (i6 != 0) {
                f = itemSpacing;
                return KeylineListKt.emptyKeylineList();
            } else {
                iArr = /* result */;
                final float f10 = Math.min(i29, i15);
                float coerceIn = RangesKt.coerceIn(f10 / i16, f8, f2);
                int i27 = i23 / i26;
                if (Float.compare(i15, i25) < 0) {
                    smallCounts = iArr2;
                } else {
                    iArr2 = smallCounts;
                }
                int i13 = (int)f6;
                i20 += i31;
                int[] iArr3 = new int[i21];
                i4 = 0;
                while (i4 < i21) {
                    iArr3[i4] = i13 - i4;
                    i4++;
                }
                int[] iArr4 = iArr3;
                int i22 = 0;
                float px-0680j_4 = density.toPx-0680j_4(CarouselDefaults.INSTANCE.getAnchorSize-D9Ej5fM$material3_release());
                int i34 = $this$multiBrowseKeylineList_u24lambda_u242;
                float maxLargeCount2 = coerceIn;
                final int[] iArr6 = iArr2;
                final int[] iArr5 = iArr;
                arrangement = lowestCostArrangement2;
                if (arrangement != null && arrangement.itemCount() > i30) {
                    if (arrangement.itemCount() > i30) {
                        keylineSurplus = i14;
                        smallCount = smallCount2;
                        keylineSurplus2 = mediumCount2;
                        while (keylineSurplus > 0) {
                            if (smallCount > 0) {
                            } else {
                            }
                            if (keylineSurplus2 > 1) {
                            }
                            keylineSurplus--;
                            keylineSurplus2--;
                            smallCount--;
                            smallCount2 = 1;
                        }
                        int i18 = keylineSurplus2;
                        i = i18;
                        arrangement = lowestCostArrangement;
                    } else {
                        i3 = carouselMainAxisSize;
                        lowestCostArrangement = arrangement;
                    }
                } else {
                }
                if (lowestCostArrangement == null) {
                    return KeylineListKt.emptyKeylineList();
                }
            }
            return KeylinesKt.createLeftAlignedKeylineList(i3, itemSpacing, px-0680j_4, px-0680j_4, lowestCostArrangement);
        }
        f = itemSpacing;
    }

    public static androidx.compose.material3.carousel.KeylineList multiBrowseKeylineList$default(Density density, float f2, float f3, float f4, int i5, float f6, float f7, int i8, Object object9) {
        float minSmallItemSize-D9Ej5fM$material3_release;
        float f5;
        float f;
        float obj12;
        float obj13;
        int obj14;
        int obj15;
        if (i8 & 32 != 0) {
            obj15 = 0;
            f5 = obj12;
        } else {
            f5 = f6;
        }
        if (i8 & 64 != 0) {
            obj13 = 0;
            f = obj13;
        } else {
            f = f7;
        }
        return KeylinesKt.multiBrowseKeylineList(density, f2, f3, f4, i5, f5, f);
    }

    public static final androidx.compose.material3.carousel.KeylineList uncontainedKeylineList(Density density, float carouselMainAxisSize, float itemSize, float itemSpacing) {
        int i2;
        int i;
        int i3 = 0;
        int i9 = 0;
        int i11 = 1;
        i2 = Float.compare(carouselMainAxisSize, i3) == 0 ? i11 : i9;
        if (i2 == 0) {
            i2 = Float.compare(itemSize, i3) == 0 ? i11 : i9;
            if (i2 != 0) {
            } else {
                final float f5 = Math.min(itemSize + itemSpacing, carouselMainAxisSize);
                final int i17 = Math.max(i11, (int)f);
                int i8 = carouselMainAxisSize - i7;
                i = Float.compare(i8, i3) > 0 ? i11 : i9;
            }
            int i10 = 0;
            float $this$uncontainedKeylineList_u24lambda_u243 = density.toPx-0680j_4(CarouselDefaults.INSTANCE.getAnchorSize-D9Ej5fM$material3_release());
            final float mediumChildSize = KeylinesKt.calculateMediumChildSize($this$uncontainedKeylineList_u24lambda_u243, f5, i8);
            Arrangement arrangement = new Arrangement(0, 0, 0, mediumChildSize, i, f5, i17);
            return KeylinesKt.createLeftAlignedKeylineList(carouselMainAxisSize, itemSpacing, Math.max(Math.min($this$uncontainedKeylineList_u24lambda_u243, itemSize), i12 *= mediumChildSize), $this$uncontainedKeylineList_u24lambda_u243, arrangement);
        }
        return KeylineListKt.emptyKeylineList();
    }
}
