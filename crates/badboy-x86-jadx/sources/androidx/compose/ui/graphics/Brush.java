package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J*\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u00020\u0004X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0002\u0012\u0013\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/Brush;", "", "()V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "J", "applyTo", "", "size", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "Companion", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/SolidColor;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Brush {

    public static final androidx.compose.ui.graphics.Brush.Companion Companion;
    private final long intrinsicSize;

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0013\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\\\u0010\u0003\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ>\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00112\u0008\u0008\u0002\u0010\n\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u0012J\\\u0010\u0013\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00072\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J>\u0010\u0013\u001a\u00020\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00112\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0019J\\\u0010\u001a\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00072\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eJ>\u0010\u001a\u001a\u00020\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00112\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001fJH\u0010 \u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00072\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"J*\u0010 \u001a\u00020\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00112\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010#J\\\u0010$\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00072\u0008\u0008\u0002\u0010%\u001a\u00020\u00082\u0008\u0008\u0002\u0010&\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008'\u0010\u000fJ>\u0010$\u001a\u00020\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00112\u0008\u0008\u0002\u0010%\u001a\u00020\u00082\u0008\u0008\u0002\u0010&\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008'\u0010\u0012\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006(", d2 = {"Landroidx/compose/ui/graphics/Brush$Companion;", "", "()V", "horizontalGradient", "Landroidx/compose/ui/graphics/Brush;", "colorStops", "", "Lkotlin/Pair;", "", "Landroidx/compose/ui/graphics/Color;", "startX", "endX", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "horizontalGradient-8A-3gB4", "([Lkotlin/Pair;FFI)Landroidx/compose/ui/graphics/Brush;", "colors", "", "(Ljava/util/List;FFI)Landroidx/compose/ui/graphics/Brush;", "linearGradient", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "linearGradient-mHitzGk", "([Lkotlin/Pair;JJI)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;JJI)Landroidx/compose/ui/graphics/Brush;", "radialGradient", "center", "radius", "radialGradient-P_Vx-Ks", "([Lkotlin/Pair;JFI)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;JFI)Landroidx/compose/ui/graphics/Brush;", "sweepGradient", "sweepGradient-Uv8p0NA", "([Lkotlin/Pair;J)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;J)Landroidx/compose/ui/graphics/Brush;", "verticalGradient", "startY", "endY", "verticalGradient-8A-3gB4", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static androidx.compose.ui.graphics.Brush horizontalGradient-8A-3gB4$default(androidx.compose.ui.graphics.Brush.Companion brush$Companion, List list2, float f3, float f4, int i5, int i6, Object object7) {
            int obj2;
            int obj3;
            int obj4;
            if (i6 & 2 != 0) {
                obj2 = 0;
            }
            if (i6 & 4 != 0) {
                obj3 = 2139095040;
            }
            if (i6 &= 8 != 0) {
                obj4 = TileMode.Companion.getClamp-3opZhB0();
            }
            return companion.horizontalGradient-8A-3gB4(list2, obj2, obj3, obj4);
        }

        public static androidx.compose.ui.graphics.Brush horizontalGradient-8A-3gB4$default(androidx.compose.ui.graphics.Brush.Companion brush$Companion, Pair[] pair2Arr2, float f3, float f4, int i5, int i6, Object object7) {
            int obj2;
            int obj3;
            int obj4;
            if (i6 & 2 != 0) {
                obj2 = 0;
            }
            if (i6 & 4 != 0) {
                obj3 = 2139095040;
            }
            if (i6 &= 8 != 0) {
                obj4 = TileMode.Companion.getClamp-3opZhB0();
            }
            return companion.horizontalGradient-8A-3gB4(pair2Arr2, obj2, obj3, obj4);
        }

        public static androidx.compose.ui.graphics.Brush linearGradient-mHitzGk$default(androidx.compose.ui.graphics.Brush.Companion brush$Companion, List list2, long l3, long l4, int i5, int i6, Object object7) {
            long l2;
            long l;
            int i;
            long obj9;
            long obj11;
            int obj13;
            if (obj14 & 2 != 0) {
                l2 = obj9;
            } else {
                l2 = l3;
            }
            if (obj14 & 4 != 0) {
                l = obj11;
            } else {
                l = i5;
            }
            if (obj14 & 8 != 0) {
                i = obj13;
            } else {
                i = object7;
            }
            return companion.linearGradient-mHitzGk(list2, l2, obj3, l);
        }

        public static androidx.compose.ui.graphics.Brush linearGradient-mHitzGk$default(androidx.compose.ui.graphics.Brush.Companion brush$Companion, Pair[] pair2Arr2, long l3, long l4, int i5, int i6, Object object7) {
            long l;
            long l2;
            int i;
            long obj9;
            long obj11;
            int obj13;
            if (obj14 & 2 != 0) {
                l = obj9;
            } else {
                l = l3;
            }
            if (obj14 & 4 != 0) {
                l2 = obj11;
            } else {
                l2 = i5;
            }
            if (obj14 & 8 != 0) {
                i = obj13;
            } else {
                i = object7;
            }
            return companion.linearGradient-mHitzGk(pair2Arr2, l, obj3, l2);
        }

        public static androidx.compose.ui.graphics.Brush radialGradient-P_Vx-Ks$default(androidx.compose.ui.graphics.Brush.Companion brush$Companion, List list2, long l3, float f4, int i5, int i6, Object object7) {
            long l;
            int i;
            int i2;
            long obj8;
            int obj10;
            int obj11;
            if (object7 & 2 != 0) {
                l = obj8;
            } else {
                l = l3;
            }
            i = object7 & 4 != 0 ? obj10 : i5;
            if (object7 & 8 != 0) {
                i2 = obj11;
            } else {
                i2 = i6;
            }
            return companion.radialGradient-P_Vx-Ks(list2, l, obj3, i);
        }

        public static androidx.compose.ui.graphics.Brush radialGradient-P_Vx-Ks$default(androidx.compose.ui.graphics.Brush.Companion brush$Companion, Pair[] pair2Arr2, long l3, float f4, int i5, int i6, Object object7) {
            long l;
            int i2;
            int i;
            long obj8;
            int obj10;
            int obj11;
            if (object7 & 2 != 0) {
                l = obj8;
            } else {
                l = l3;
            }
            i2 = object7 & 4 != 0 ? obj10 : i5;
            if (object7 & 8 != 0) {
                i = obj11;
            } else {
                i = i6;
            }
            return companion.radialGradient-P_Vx-Ks(pair2Arr2, l, obj3, i2);
        }

        public static androidx.compose.ui.graphics.Brush sweepGradient-Uv8p0NA$default(androidx.compose.ui.graphics.Brush.Companion brush$Companion, List list2, long l3, int i4, Object object5) {
            long obj2;
            if (object5 &= 2 != 0) {
                obj2 = Offset.Companion.getUnspecified-F1C5BW0();
            }
            return companion.sweepGradient-Uv8p0NA(list2, obj2);
        }

        public static androidx.compose.ui.graphics.Brush sweepGradient-Uv8p0NA$default(androidx.compose.ui.graphics.Brush.Companion brush$Companion, Pair[] pair2Arr2, long l3, int i4, Object object5) {
            long obj2;
            if (object5 &= 2 != 0) {
                obj2 = Offset.Companion.getUnspecified-F1C5BW0();
            }
            return companion.sweepGradient-Uv8p0NA(pair2Arr2, obj2);
        }

        public static androidx.compose.ui.graphics.Brush verticalGradient-8A-3gB4$default(androidx.compose.ui.graphics.Brush.Companion brush$Companion, List list2, float f3, float f4, int i5, int i6, Object object7) {
            int obj2;
            int obj3;
            int obj4;
            if (i6 & 2 != 0) {
                obj2 = 0;
            }
            if (i6 & 4 != 0) {
                obj3 = 2139095040;
            }
            if (i6 &= 8 != 0) {
                obj4 = TileMode.Companion.getClamp-3opZhB0();
            }
            return companion.verticalGradient-8A-3gB4(list2, obj2, obj3, obj4);
        }

        public static androidx.compose.ui.graphics.Brush verticalGradient-8A-3gB4$default(androidx.compose.ui.graphics.Brush.Companion brush$Companion, Pair[] pair2Arr2, float f3, float f4, int i5, int i6, Object object7) {
            int obj2;
            int obj3;
            int obj4;
            if (i6 & 2 != 0) {
                obj2 = 0;
            }
            if (i6 & 4 != 0) {
                obj3 = 2139095040;
            }
            if (i6 &= 8 != 0) {
                obj4 = TileMode.Companion.getClamp-3opZhB0();
            }
            return companion.verticalGradient-8A-3gB4(pair2Arr2, obj2, obj3, obj4);
        }

        public final androidx.compose.ui.graphics.Brush horizontalGradient-8A-3gB4(List<androidx.compose.ui.graphics.Color> colors, float startX, float endX, int tileMode) {
            final int i = 0;
            return this.linearGradient-mHitzGk(colors, OffsetKt.Offset(startX, i), obj4, OffsetKt.Offset(endX, i));
        }

        public final androidx.compose.ui.graphics.Brush horizontalGradient-8A-3gB4(Pair<Float, androidx.compose.ui.graphics.Color>[] colorStops, float startX, float endX, int tileMode) {
            int i = 0;
            return this.linearGradient-mHitzGk((Pair[])Arrays.copyOf(colorStops, colorStops.length), OffsetKt.Offset(startX, i), obj4, OffsetKt.Offset(endX, i));
        }

        public final androidx.compose.ui.graphics.Brush linearGradient-mHitzGk(List<androidx.compose.ui.graphics.Color> colors, long start, long end, int tileMode) {
            LinearGradient linearGradient = new LinearGradient(colors, 0, start, obj4, tileMode, obj6, obj15, 0);
            return (Brush)linearGradient;
        }

        public final androidx.compose.ui.graphics.Brush linearGradient-mHitzGk(Pair<Float, androidx.compose.ui.graphics.Color>[] colorStops, long start, long end, int tileMode) {
            int i;
            int valueOf;
            androidx.compose.ui.graphics.Color box-impl;
            int i2;
            Object second;
            int length = colorStops.length;
            ArrayList arrayList = new ArrayList(length);
            valueOf = i;
            while (valueOf < length) {
                arrayList.add(Color.box-impl((Color)colorStops[valueOf].getSecond().unbox-impl()));
                valueOf++;
            }
            int length2 = colorStops.length;
            ArrayList arrayList2 = new ArrayList(length2);
            while (i < length2) {
                box-impl = 0;
                arrayList2.add(Float.valueOf((Number)colorStops[i].getFirst().floatValue()));
                i++;
            }
            LinearGradient linearGradient = new LinearGradient((List)arrayList, (List)arrayList2, start, obj8, tileMode, obj10, obj19, 0);
            return (Brush)linearGradient;
        }

        public final androidx.compose.ui.graphics.Brush radialGradient-P_Vx-Ks(List<androidx.compose.ui.graphics.Color> colors, long center, float radius, int tileMode) {
            RadialGradient radialGradient = new RadialGradient(colors, 0, center, obj4, tileMode, obj13, 0);
            return (Brush)radialGradient;
        }

        public final androidx.compose.ui.graphics.Brush radialGradient-P_Vx-Ks(Pair<Float, androidx.compose.ui.graphics.Color>[] colorStops, long center, float radius, int tileMode) {
            int i;
            int valueOf;
            androidx.compose.ui.graphics.Color box-impl;
            int i2;
            Object second;
            int length = colorStops.length;
            ArrayList arrayList = new ArrayList(length);
            valueOf = i;
            while (valueOf < length) {
                arrayList.add(Color.box-impl((Color)colorStops[valueOf].getSecond().unbox-impl()));
                valueOf++;
            }
            int length2 = colorStops.length;
            ArrayList arrayList2 = new ArrayList(length2);
            while (i < length2) {
                box-impl = 0;
                arrayList2.add(Float.valueOf((Number)colorStops[i].getFirst().floatValue()));
                i++;
            }
            RadialGradient radialGradient = new RadialGradient((List)arrayList, (List)arrayList2, center, obj8, tileMode, obj17, 0);
            return (Brush)radialGradient;
        }

        public final androidx.compose.ui.graphics.Brush sweepGradient-Uv8p0NA(List<androidx.compose.ui.graphics.Color> colors, long center) {
            SweepGradient sweepGradient = new SweepGradient(center, obj2, colors, 0, 0);
            return (Brush)sweepGradient;
        }

        public final androidx.compose.ui.graphics.Brush sweepGradient-Uv8p0NA(Pair<Float, androidx.compose.ui.graphics.Color>[] colorStops, long center) {
            int i;
            int valueOf;
            androidx.compose.ui.graphics.Color box-impl;
            int first;
            Object second;
            int length = colorStops.length;
            ArrayList arrayList = new ArrayList(length);
            valueOf = i;
            while (valueOf < length) {
                arrayList.add(Color.box-impl((Color)colorStops[valueOf].getSecond().unbox-impl()));
                valueOf++;
            }
            int length2 = colorStops.length;
            ArrayList arrayList2 = new ArrayList(length2);
            while (i < length2) {
                box-impl = 0;
                arrayList2.add(Float.valueOf((Number)colorStops[i].getFirst().floatValue()));
                i++;
            }
            SweepGradient sweepGradient = new SweepGradient(center, second, (List)arrayList, (List)arrayList2, 0);
            return (Brush)sweepGradient;
        }

        public final androidx.compose.ui.graphics.Brush verticalGradient-8A-3gB4(List<androidx.compose.ui.graphics.Color> colors, float startY, float endY, int tileMode) {
            final int i = 0;
            return this.linearGradient-mHitzGk(colors, OffsetKt.Offset(i, startY), obj4, OffsetKt.Offset(i, endY));
        }

        public final androidx.compose.ui.graphics.Brush verticalGradient-8A-3gB4(Pair<Float, androidx.compose.ui.graphics.Color>[] colorStops, float startY, float endY, int tileMode) {
            int i = 0;
            return this.linearGradient-mHitzGk((Pair[])Arrays.copyOf(colorStops, colorStops.length), OffsetKt.Offset(i, startY), obj4, OffsetKt.Offset(i, endY));
        }
    }
    static {
        Brush.Companion companion = new Brush.Companion(0);
        Brush.Companion = companion;
    }

    private Brush() {
        super();
        this.intrinsicSize = Size.Companion.getUnspecified-NH-jbRc();
    }

    public Brush(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public abstract void applyTo-Pq9zytI(long l, androidx.compose.ui.graphics.Paint paint2, float f3);

    public long getIntrinsicSize-NH-jbRc() {
        return this.intrinsicSize;
    }
}
