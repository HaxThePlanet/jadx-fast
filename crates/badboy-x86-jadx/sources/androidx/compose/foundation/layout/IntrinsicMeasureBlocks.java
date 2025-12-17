package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\n\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u000c\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\r\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u000e\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u000f\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u0010\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u0011\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/layout/IntrinsicMeasureBlocks;", "", "()V", "HorizontalMaxHeight", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "availableWidth", "mainAxisSpacing", "HorizontalMaxWidth", "availableHeight", "HorizontalMinHeight", "HorizontalMinWidth", "VerticalMaxHeight", "VerticalMaxWidth", "VerticalMinHeight", "VerticalMinWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntrinsicMeasureBlocks {

    public static final int $stable;
    public static final androidx.compose.foundation.layout.IntrinsicMeasureBlocks INSTANCE;
    static {
        IntrinsicMeasureBlocks intrinsicMeasureBlocks = new IntrinsicMeasureBlocks();
        IntrinsicMeasureBlocks.INSTANCE = intrinsicMeasureBlocks;
    }

    public final int HorizontalMaxHeight(List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        int fixedSpace$iv;
        int crossAxisMax$iv;
        int $this$fastRoundToInt$iv$iv;
        int weightUnitSpace$iv;
        int crossAxisMax$iv2;
        int i4;
        int i5;
        int i2;
        int totalWeight$iv;
        int round;
        int i;
        int index$iv$iv2;
        int index$iv$iv;
        int size;
        int size2;
        int w;
        int $this$fastRoundToInt$iv$iv2;
        int i3;
        Object obj2;
        Object obj;
        int weight;
        float weight2;
        int $this$HorizontalMaxHeight_u24lambda_u2410;
        int i6;
        final int i7 = availableWidth;
        final int i8 = 0;
        if (measurables.isEmpty()) {
            weightUnitSpace$iv = 0;
        } else {
            int i9 = 0;
            fixedSpace$iv = Math.min(i13 *= mainAxisSpacing, i7);
            crossAxisMax$iv2 = 0;
            totalWeight$iv = 0;
            round = measurables;
            int i16 = 0;
            index$iv$iv = 0;
            w = 0;
            i3 = Integer.MAX_VALUE;
            while (index$iv$iv < round.size()) {
                obj = obj2;
                weight = 0;
                weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj));
                if (Float.compare(weight2, w) == 0) {
                } else {
                }
                $this$HorizontalMaxHeight_u24lambda_u2410 = 0;
                if ($this$HorizontalMaxHeight_u24lambda_u2410 != 0) {
                } else {
                }
                if (Float.compare(weight2, w) > 0) {
                }
                index$iv$iv++;
                i4 = 1;
                w = 0;
                i3 = Integer.MAX_VALUE;
                totalWeight$iv += weight2;
                if (i7 == i3) {
                } else {
                }
                i3 = i7 - fixedSpace$iv;
                int $this$HorizontalMaxHeight_u24lambda_u2492 = 0;
                i4 = Math.min(obj.maxIntrinsicWidth(Integer.MAX_VALUE), i3);
                fixedSpace$iv += i4;
                i6 = 0;
                crossAxisMax$iv2 = crossAxisMax$iv;
                $this$HorizontalMaxHeight_u24lambda_u2410 = i4;
            }
            i5 = Float.compare(totalWeight$iv, w) == 0 ? 1 : 0;
            if (i5 != 0) {
                $this$fastRoundToInt$iv$iv = 0;
            } else {
                if (i7 == i3) {
                    $this$fastRoundToInt$iv$iv = i3;
                } else {
                    i5 = 0;
                    $this$fastRoundToInt$iv$iv = round;
                }
            }
            i2 = measurables;
            i = 0;
            index$iv$iv2 = 0;
            while (index$iv$iv2 < i2.size()) {
                obj2 = size2;
                obj = 0;
                weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj2));
                if (Float.compare(weight, w) > 0) {
                }
                index$iv$iv2++;
                w = 0;
                i3 = Integer.MAX_VALUE;
                if ($this$fastRoundToInt$iv$iv != i3) {
                } else {
                }
                $this$fastRoundToInt$iv$iv2 = i3;
                $this$HorizontalMaxHeight_u24lambda_u2410 = 0;
                crossAxisMax$iv2 = Math.max(crossAxisMax$iv2, obj2.maxIntrinsicHeight($this$fastRoundToInt$iv$iv2));
                $this$HorizontalMaxHeight_u24lambda_u2410 = 0;
                $this$fastRoundToInt$iv$iv2 = Math.round(f2 *= weight);
            }
            weightUnitSpace$iv = crossAxisMax$iv2;
        }
        return weightUnitSpace$iv;
    }

    public final int HorizontalMaxWidth(List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        int weightUnitSpace$iv;
        int i3;
        int fixedSpace$iv;
        int totalWeight$iv;
        int i2;
        int i5;
        int index$iv$iv;
        int size;
        int $this$fastRoundToInt$iv$iv;
        Object obj;
        Object obj2;
        int i4;
        float weight;
        int $this$HorizontalMaxWidth_u24lambda_u246;
        int i;
        int cmp;
        final int i6 = 0;
        if (measurables.isEmpty()) {
        } else {
            weightUnitSpace$iv = 0;
            fixedSpace$iv = 0;
            totalWeight$iv = 0;
            int obj3 = measurables;
            i5 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < obj3.size()) {
                obj2 = obj;
                i4 = 0;
                weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj2));
                int i12 = 0;
                $this$HorizontalMaxWidth_u24lambda_u246 = obj2.maxIntrinsicWidth(availableHeight);
                i = 0;
                if (Float.compare(weight, i) == 0) {
                } else {
                }
                $this$fastRoundToInt$iv$iv = i3;
                if ($this$fastRoundToInt$iv$iv != 0) {
                } else {
                }
                if (Float.compare(weight, i) > 0) {
                }
                index$iv$iv++;
                totalWeight$iv += weight;
                i = 0;
                weightUnitSpace$iv = Math.max(weightUnitSpace$iv, Math.round(f2 /= weight));
                fixedSpace$iv += $this$HorizontalMaxWidth_u24lambda_u246;
            }
            int i8 = 0;
            $this$fastRoundToInt$iv$iv3 += i2;
        }
        return i3;
    }

    public final int HorizontalMinHeight(List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        int fixedSpace$iv;
        int crossAxisMax$iv;
        int $this$fastRoundToInt$iv$iv;
        int weightUnitSpace$iv;
        int crossAxisMax$iv2;
        int i6;
        int i3;
        int i5;
        int totalWeight$iv;
        int round;
        int i;
        int index$iv$iv2;
        int index$iv$iv;
        int size;
        int size2;
        int w;
        int $this$fastRoundToInt$iv$iv2;
        int i2;
        Object obj2;
        Object obj;
        int weight2;
        float weight;
        int $this$HorizontalMinHeight_u24lambda_u244;
        int i4;
        final int i7 = availableWidth;
        final int i8 = 0;
        if (measurables.isEmpty()) {
            weightUnitSpace$iv = 0;
        } else {
            int i9 = 0;
            fixedSpace$iv = Math.min(i13 *= mainAxisSpacing, i7);
            crossAxisMax$iv2 = 0;
            totalWeight$iv = 0;
            round = measurables;
            int i16 = 0;
            index$iv$iv = 0;
            w = 0;
            i2 = Integer.MAX_VALUE;
            while (index$iv$iv < round.size()) {
                obj = obj2;
                weight2 = 0;
                weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj));
                if (Float.compare(weight, w) == 0) {
                } else {
                }
                $this$HorizontalMinHeight_u24lambda_u244 = 0;
                if ($this$HorizontalMinHeight_u24lambda_u244 != 0) {
                } else {
                }
                if (Float.compare(weight, w) > 0) {
                }
                index$iv$iv++;
                i6 = 1;
                w = 0;
                i2 = Integer.MAX_VALUE;
                totalWeight$iv += weight;
                if (i7 == i2) {
                } else {
                }
                i2 = i7 - fixedSpace$iv;
                int $this$HorizontalMinHeight_u24lambda_u2432 = 0;
                i6 = Math.min(obj.maxIntrinsicWidth(Integer.MAX_VALUE), i2);
                fixedSpace$iv += i6;
                i4 = 0;
                crossAxisMax$iv2 = crossAxisMax$iv;
                $this$HorizontalMinHeight_u24lambda_u244 = i6;
            }
            i3 = Float.compare(totalWeight$iv, w) == 0 ? 1 : 0;
            if (i3 != 0) {
                $this$fastRoundToInt$iv$iv = 0;
            } else {
                if (i7 == i2) {
                    $this$fastRoundToInt$iv$iv = i2;
                } else {
                    i3 = 0;
                    $this$fastRoundToInt$iv$iv = round;
                }
            }
            i5 = measurables;
            i = 0;
            index$iv$iv2 = 0;
            while (index$iv$iv2 < i5.size()) {
                obj2 = size2;
                obj = 0;
                weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj2));
                if (Float.compare(weight2, w) > 0) {
                }
                index$iv$iv2++;
                w = 0;
                i2 = Integer.MAX_VALUE;
                if ($this$fastRoundToInt$iv$iv != i2) {
                } else {
                }
                $this$fastRoundToInt$iv$iv2 = i2;
                $this$HorizontalMinHeight_u24lambda_u244 = 0;
                crossAxisMax$iv2 = Math.max(crossAxisMax$iv2, obj2.minIntrinsicHeight($this$fastRoundToInt$iv$iv2));
                $this$HorizontalMinHeight_u24lambda_u244 = 0;
                $this$fastRoundToInt$iv$iv2 = Math.round(f2 *= weight2);
            }
            weightUnitSpace$iv = crossAxisMax$iv2;
        }
        return weightUnitSpace$iv;
    }

    public final int HorizontalMinWidth(List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        int weightUnitSpace$iv;
        int i3;
        int fixedSpace$iv;
        int totalWeight$iv;
        int i5;
        int i4;
        int index$iv$iv;
        int size;
        int $this$fastRoundToInt$iv$iv;
        Object obj;
        Object obj2;
        int i;
        float weight;
        int $this$HorizontalMinWidth_u24lambda_u240;
        int i2;
        int cmp;
        final int i6 = 0;
        if (measurables.isEmpty()) {
        } else {
            weightUnitSpace$iv = 0;
            fixedSpace$iv = 0;
            totalWeight$iv = 0;
            int obj3 = measurables;
            i4 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < obj3.size()) {
                obj2 = obj;
                i = 0;
                weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj2));
                int i12 = 0;
                $this$HorizontalMinWidth_u24lambda_u240 = obj2.minIntrinsicWidth(availableHeight);
                i2 = 0;
                if (Float.compare(weight, i2) == 0) {
                } else {
                }
                $this$fastRoundToInt$iv$iv = i3;
                if ($this$fastRoundToInt$iv$iv != 0) {
                } else {
                }
                if (Float.compare(weight, i2) > 0) {
                }
                index$iv$iv++;
                totalWeight$iv += weight;
                i2 = 0;
                weightUnitSpace$iv = Math.max(weightUnitSpace$iv, Math.round(f2 /= weight));
                fixedSpace$iv += $this$HorizontalMinWidth_u24lambda_u240;
            }
            int i8 = 0;
            $this$fastRoundToInt$iv$iv3 += i5;
        }
        return i3;
    }

    public final int VerticalMaxHeight(List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        int weightUnitSpace$iv;
        int i5;
        int fixedSpace$iv;
        int totalWeight$iv;
        int i4;
        int i3;
        int index$iv$iv;
        int size;
        int $this$fastRoundToInt$iv$iv;
        Object obj2;
        Object obj;
        int i;
        float weight;
        int $this$VerticalMaxHeight_u24lambda_u2411;
        int i2;
        int cmp;
        final int i6 = 0;
        if (measurables.isEmpty()) {
        } else {
            weightUnitSpace$iv = 0;
            fixedSpace$iv = 0;
            totalWeight$iv = 0;
            int obj3 = measurables;
            i3 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < obj3.size()) {
                obj = obj2;
                i = 0;
                weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj));
                int i12 = 0;
                $this$VerticalMaxHeight_u24lambda_u2411 = obj.maxIntrinsicHeight(availableWidth);
                i2 = 0;
                if (Float.compare(weight, i2) == 0) {
                } else {
                }
                $this$fastRoundToInt$iv$iv = i5;
                if ($this$fastRoundToInt$iv$iv != 0) {
                } else {
                }
                if (Float.compare(weight, i2) > 0) {
                }
                index$iv$iv++;
                totalWeight$iv += weight;
                i2 = 0;
                weightUnitSpace$iv = Math.max(weightUnitSpace$iv, Math.round(f2 /= weight));
                fixedSpace$iv += $this$VerticalMaxHeight_u24lambda_u2411;
            }
            int i8 = 0;
            $this$fastRoundToInt$iv$iv3 += i4;
        }
        return i5;
    }

    public final int VerticalMaxWidth(List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        int fixedSpace$iv;
        int crossAxisMax$iv2;
        int $this$fastRoundToInt$iv$iv2;
        int weightUnitSpace$iv;
        int crossAxisMax$iv;
        int i6;
        int i2;
        int i;
        int totalWeight$iv;
        int round;
        int i4;
        int index$iv$iv;
        int index$iv$iv2;
        int size2;
        int size;
        int h;
        int $this$fastRoundToInt$iv$iv;
        int i5;
        Object obj;
        Object obj2;
        int weight;
        float weight2;
        int $this$VerticalMaxWidth_u24lambda_u248;
        int i3;
        final int i7 = availableHeight;
        final int i8 = 0;
        if (measurables.isEmpty()) {
            weightUnitSpace$iv = 0;
        } else {
            int i9 = 0;
            fixedSpace$iv = Math.min(i13 *= mainAxisSpacing, i7);
            crossAxisMax$iv = 0;
            totalWeight$iv = 0;
            round = measurables;
            int i16 = 0;
            index$iv$iv2 = 0;
            h = 0;
            i5 = Integer.MAX_VALUE;
            while (index$iv$iv2 < round.size()) {
                obj2 = obj;
                weight = 0;
                weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj2));
                if (Float.compare(weight2, h) == 0) {
                } else {
                }
                $this$VerticalMaxWidth_u24lambda_u248 = 0;
                if ($this$VerticalMaxWidth_u24lambda_u248 != 0) {
                } else {
                }
                if (Float.compare(weight2, h) > 0) {
                }
                index$iv$iv2++;
                i6 = 1;
                h = 0;
                i5 = Integer.MAX_VALUE;
                totalWeight$iv += weight2;
                if (i7 == i5) {
                } else {
                }
                i5 = i7 - fixedSpace$iv;
                int $this$VerticalMaxWidth_u24lambda_u2472 = 0;
                i6 = Math.min(obj2.maxIntrinsicHeight(Integer.MAX_VALUE), i5);
                fixedSpace$iv += i6;
                i3 = 0;
                crossAxisMax$iv = crossAxisMax$iv2;
                $this$VerticalMaxWidth_u24lambda_u248 = i6;
            }
            i2 = Float.compare(totalWeight$iv, h) == 0 ? 1 : 0;
            if (i2 != 0) {
                $this$fastRoundToInt$iv$iv2 = 0;
            } else {
                if (i7 == i5) {
                    $this$fastRoundToInt$iv$iv2 = i5;
                } else {
                    i2 = 0;
                    $this$fastRoundToInt$iv$iv2 = round;
                }
            }
            i = measurables;
            i4 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < i.size()) {
                obj = size;
                obj2 = 0;
                weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj));
                if (Float.compare(weight, h) > 0) {
                }
                index$iv$iv++;
                h = 0;
                i5 = Integer.MAX_VALUE;
                if ($this$fastRoundToInt$iv$iv2 != i5) {
                } else {
                }
                $this$fastRoundToInt$iv$iv = i5;
                $this$VerticalMaxWidth_u24lambda_u248 = 0;
                crossAxisMax$iv = Math.max(crossAxisMax$iv, obj.maxIntrinsicWidth($this$fastRoundToInt$iv$iv));
                $this$VerticalMaxWidth_u24lambda_u248 = 0;
                $this$fastRoundToInt$iv$iv = Math.round(f2 *= weight);
            }
            weightUnitSpace$iv = crossAxisMax$iv;
        }
        return weightUnitSpace$iv;
    }

    public final int VerticalMinHeight(List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        int weightUnitSpace$iv;
        int i4;
        int fixedSpace$iv;
        int totalWeight$iv;
        int i2;
        int i;
        int index$iv$iv;
        int size;
        int $this$fastRoundToInt$iv$iv;
        Object obj2;
        Object obj;
        int i3;
        float weight;
        int $this$VerticalMinHeight_u24lambda_u245;
        int i5;
        int cmp;
        final int i6 = 0;
        if (measurables.isEmpty()) {
        } else {
            weightUnitSpace$iv = 0;
            fixedSpace$iv = 0;
            totalWeight$iv = 0;
            int obj3 = measurables;
            i = 0;
            index$iv$iv = 0;
            while (index$iv$iv < obj3.size()) {
                obj = obj2;
                i3 = 0;
                weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj));
                int i12 = 0;
                $this$VerticalMinHeight_u24lambda_u245 = obj.minIntrinsicHeight(availableWidth);
                i5 = 0;
                if (Float.compare(weight, i5) == 0) {
                } else {
                }
                $this$fastRoundToInt$iv$iv = i4;
                if ($this$fastRoundToInt$iv$iv != 0) {
                } else {
                }
                if (Float.compare(weight, i5) > 0) {
                }
                index$iv$iv++;
                totalWeight$iv += weight;
                i5 = 0;
                weightUnitSpace$iv = Math.max(weightUnitSpace$iv, Math.round(f2 /= weight));
                fixedSpace$iv += $this$VerticalMinHeight_u24lambda_u245;
            }
            int i8 = 0;
            $this$fastRoundToInt$iv$iv3 += i2;
        }
        return i4;
    }

    public final int VerticalMinWidth(List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        int fixedSpace$iv;
        int crossAxisMax$iv2;
        int $this$fastRoundToInt$iv$iv2;
        int weightUnitSpace$iv;
        int crossAxisMax$iv;
        int i3;
        int i2;
        int i4;
        int totalWeight$iv;
        int round;
        int i5;
        int index$iv$iv;
        int index$iv$iv2;
        int size2;
        int size;
        int h;
        int $this$fastRoundToInt$iv$iv;
        int i;
        Object obj;
        Object obj2;
        int weight2;
        float weight;
        int $this$VerticalMinWidth_u24lambda_u242;
        int i6;
        final int i7 = availableHeight;
        final int i8 = 0;
        if (measurables.isEmpty()) {
            weightUnitSpace$iv = 0;
        } else {
            int i9 = 0;
            fixedSpace$iv = Math.min(i13 *= mainAxisSpacing, i7);
            crossAxisMax$iv = 0;
            totalWeight$iv = 0;
            round = measurables;
            int i16 = 0;
            index$iv$iv2 = 0;
            h = 0;
            i = Integer.MAX_VALUE;
            while (index$iv$iv2 < round.size()) {
                obj2 = obj;
                weight2 = 0;
                weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj2));
                if (Float.compare(weight, h) == 0) {
                } else {
                }
                $this$VerticalMinWidth_u24lambda_u242 = 0;
                if ($this$VerticalMinWidth_u24lambda_u242 != 0) {
                } else {
                }
                if (Float.compare(weight, h) > 0) {
                }
                index$iv$iv2++;
                i3 = 1;
                h = 0;
                i = Integer.MAX_VALUE;
                totalWeight$iv += weight;
                if (i7 == i) {
                } else {
                }
                i = i7 - fixedSpace$iv;
                int $this$VerticalMinWidth_u24lambda_u2412 = 0;
                i3 = Math.min(obj2.maxIntrinsicHeight(Integer.MAX_VALUE), i);
                fixedSpace$iv += i3;
                i6 = 0;
                crossAxisMax$iv = crossAxisMax$iv2;
                $this$VerticalMinWidth_u24lambda_u242 = i3;
            }
            i2 = Float.compare(totalWeight$iv, h) == 0 ? 1 : 0;
            if (i2 != 0) {
                $this$fastRoundToInt$iv$iv2 = 0;
            } else {
                if (i7 == i) {
                    $this$fastRoundToInt$iv$iv2 = i;
                } else {
                    i2 = 0;
                    $this$fastRoundToInt$iv$iv2 = round;
                }
            }
            i4 = measurables;
            i5 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < i4.size()) {
                obj = size;
                obj2 = 0;
                weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj));
                if (Float.compare(weight2, h) > 0) {
                }
                index$iv$iv++;
                h = 0;
                i = Integer.MAX_VALUE;
                if ($this$fastRoundToInt$iv$iv2 != i) {
                } else {
                }
                $this$fastRoundToInt$iv$iv = i;
                $this$VerticalMinWidth_u24lambda_u242 = 0;
                crossAxisMax$iv = Math.max(crossAxisMax$iv, obj.minIntrinsicWidth($this$fastRoundToInt$iv$iv));
                $this$VerticalMinWidth_u24lambda_u242 = 0;
                $this$fastRoundToInt$iv$iv = Math.round(f2 *= weight2);
            }
            weightUnitSpace$iv = crossAxisMax$iv;
        }
        return weightUnitSpace$iv;
    }
}
