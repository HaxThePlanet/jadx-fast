package androidx.compose.ui.graphics;

import _COROUTINE.CoroutineDebuggingKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a \u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0008*\u00020\u00062\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0008\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006¨\u0006\u000c", d2 = {"floatCountForType", "", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "computeDirection", "Landroidx/compose/ui/graphics/Path$Direction;", "Landroidx/compose/ui/graphics/Path;", "divide", "", "contours", "reverse", "destination", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathGeometryKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal5;
            int ordinal2;
            int ordinal3;
            int ordinal;
            int ordinal4;
            int ordinal6;
            int ordinal7;
            int[] iArr = new int[values.length];
            iArr[PathSegment.Type.Move.ordinal()] = 1;
            iArr[PathSegment.Type.Line.ordinal()] = 2;
            iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            iArr[PathSegment.Type.Conic.ordinal()] = 4;
            iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            iArr[PathSegment.Type.Close.ordinal()] = 6;
            iArr[PathSegment.Type.Done.ordinal()] = 7;
            PathGeometryKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final androidx.compose.ui.graphics.Path.Direction computeDirection(androidx.compose.ui.graphics.Path $this$computeDirection) {
        int first;
        int area;
        androidx.compose.ui.graphics.PathSegment.Type startX;
        int startY;
        androidx.compose.ui.graphics.Path.Direction counterClockwise;
        int i4;
        int cubicArea;
        int endX;
        int endY;
        int i2;
        int i;
        int i3;
        int startY2;
        float f12;
        float f5;
        float f15;
        float f2;
        float f3;
        float f11;
        float f;
        float f16;
        float f10;
        float f14;
        float f4;
        float f8;
        float f9;
        float f7;
        float f13;
        float f6;
        first = 1;
        final androidx.compose.ui.graphics.PathIterator iterator = $this$computeDirection.iterator();
        float[] fArr = new float[8];
        area = 0;
        final int i21 = 0;
        final int i22 = 2;
        final int i23 = 0;
        i3 = i6;
        startY2 = startY;
        endY = cubicArea;
        startX = next$default;
        endX = i4;
        while (startX != PathSegment.Type.Done) {
            i4 = 5;
            cubicArea = 4;
            i2 = 3;
            i = 1;
            startX = PathIterator.next$default(iterator, fArr, i21, i22, i23);
            i4 = 0;
            i2 = 895483904;
            if (Float.compare(f17, i2) < 0) {
            } else {
            }
            startY = i21;
            if (startY != 0) {
            } else {
            }
            area += cubicArea3;
            endX = startY;
            endY = i4;
            i4 = 0;
            if (Float.compare(f18, i2) < 0) {
            } else {
            }
            i = i21;
            if (i == 0) {
            }
            startY = i;
            int i8 = 6;
            int i10 = 7;
            area += cubicArea;
            endX = startY;
            endY = i4;
            f12 = fArr[i21];
            f5 = fArr[i];
            startY = fArr[i22];
            i2 = fArr[i2];
            f = fArr[cubicArea];
            f16 = fArr[i4];
            cubicArea = 1059760811;
            area += cubicArea4;
            endX = i4;
            endY = f16;
            f10 = fArr[i21];
            f14 = fArr[i];
            f9 = fArr[i22];
            f7 = fArr[i2];
            area += cubicArea2;
            endX = startY;
            endY = f7;
            first = 0;
            i3 = startY;
            startY2 = i4;
        }
        counterClockwise = Float.compare(area, i7) >= 0 ? Path.Direction.Clockwise : Path.Direction.CounterClockwise;
        return counterClockwise;
    }

    public static final List<androidx.compose.ui.graphics.Path> divide(androidx.compose.ui.graphics.Path $this$divide, List<androidx.compose.ui.graphics.Path> contours) {
        androidx.compose.ui.graphics.Path path2;
        int isEmpty2;
        int isEmpty;
        androidx.compose.ui.graphics.PathSegment.Type type;
        androidx.compose.ui.graphics.Path path;
        int i;
        int i2;
        int i3;
        float f2;
        float f;
        float f3;
        final int obj = contours;
        isEmpty2 = 1;
        isEmpty = 1;
        final androidx.compose.ui.graphics.PathIterator iterator = $this$divide.iterator();
        float[] fArr = new float[8];
        final int i10 = 0;
        final int i11 = 2;
        final int i12 = 0;
        type = PathIterator.next$default(iterator, fArr, i10, i11, i12);
        path = path2;
        while (type != PathSegment.Type.Done) {
            i = 5;
            i2 = 4;
            i3 = 3;
            type = PathIterator.next$default(iterator, fArr, i10, i11, i12);
            path.close();
            path.cubicTo(fArr[i11], fArr[i3], fArr[i2], fArr[i], fArr[6], fArr[7]);
            isEmpty = path2;
            path.quadraticTo(fArr[i11], fArr[i3], fArr[i2], fArr[i]);
            isEmpty = path2;
            path.lineTo(fArr[i11], fArr[i3]);
            isEmpty = path2;
            if (isEmpty2 == 0 && isEmpty == 0) {
            }
            path.moveTo(fArr[i10], fArr[1]);
            isEmpty = first;
            isEmpty2 = path2;
            if (isEmpty == 0) {
            }
            obj.add(path);
            path = AndroidPath_androidKt.Path();
        }
        if (isEmpty2 == 0 && isEmpty == 0) {
            if (isEmpty == 0) {
                obj.add(path);
            }
        }
        return obj;
    }

    public static List divide$default(androidx.compose.ui.graphics.Path path, List list2, int i3, Object object4) {
        ArrayList obj1;
        if (i3 &= 1 != 0) {
            obj1 = new ArrayList();
        }
        return PathGeometryKt.divide(path, obj1);
    }

    private static final int floatCountForType(androidx.compose.ui.graphics.PathSegment.Type type) {
        int i;
        i = 0;
        final int i4 = 8;
        switch (i3) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 4;
                break;
            case 3:
                i = 6;
                break;
            case 4:
                i = i4;
                break;
            case 5:
                i = i4;
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return i;
    }

    public static final androidx.compose.ui.graphics.Path reverse(androidx.compose.ui.graphics.Path $this$reverse, androidx.compose.ui.graphics.Path destination) {
        Object points;
        float[] fArr;
        Object points3;
        int i6;
        int insertMove;
        androidx.compose.ui.graphics.PathSegment.Type next$default;
        int insertClose2;
        String str;
        int dataIndex;
        int i;
        int i5;
        int points2;
        Object obj;
        androidx.compose.ui.graphics.PathSegment.Type type;
        int insertClose;
        int i2;
        int i3;
        int dataIndex2;
        int i4;
        int i7;
        final Object obj3 = destination;
        final androidx.compose.ui.graphics.PathIterator iterator = $this$reverse.iterator();
        points2 = 0;
        final int size2 = iterator.calculateSize(points2);
        ArrayList arrayList = new ArrayList(size2);
        final ArrayList list = arrayList;
        ArrayList arrayList2 = new ArrayList(size2);
        final ArrayList list2 = arrayList2;
        fArr = new float[8];
        final int i27 = 2;
        int i10 = 0;
        type = next$default;
        while (type != PathSegment.Type.Done) {
            list.add(type);
            if (type != PathSegment.Type.Close) {
            }
            type = PathIterator.next$default(iterator, fArr, points2, i27, i10);
            next$default = Arrays.copyOf(fArr, PathGeometryKt.floatCountForType(type));
            Intrinsics.checkNotNullExpressionValue(next$default, "copyOf(this, newSize)");
            list2.add(next$default);
        }
        insertMove = 1;
        dataIndex = list2.size();
        final int i28 = 1;
        insertClose = i15;
        insertClose2 = i;
        while (-1 < insertClose2) {
            if (insertMove != 0) {
            } else {
            }
            i2 = points2;
            obj = points3;
            i3 = insertMove;
            dataIndex2 = dataIndex;
            int i11 = 3;
            i4 = insertClose2;
            insertMove = i3;
            dataIndex = dataIndex2;
            insertClose2 = i4 + -1;
            fArr = obj;
            points2 = i2;
            insertClose = i6;
            i4 = insertClose2;
            insertMove = i3;
            dataIndex = dataIndex2;
            i4 = i24;
            obj3.cubicTo(obj[4], obj[5], obj[i27], obj[i11], obj[i2], obj[i28]);
            insertMove = i3;
            dataIndex = dataIndex2;
            i4 = insertClose2;
            i4 = insertClose2;
            obj3.quadraticTo(obj[i27], obj[i11], obj[i2], obj[i28]);
            insertMove = i3;
            dataIndex = dataIndex2;
            i4 = insertClose2;
            obj3.lineTo(obj[i2], obj[i28]);
            insertMove = i3;
            dataIndex = dataIndex2;
            i4 = insertClose2;
            if (insertClose != 0) {
            }
            insertMove = i6;
            dataIndex = dataIndex2;
            obj3.close();
            insertClose = 0;
            dataIndex--;
            points3 = obj5;
            i = ArraysKt.getLastIndex((float[])points3);
            i2 = points2;
            obj3.moveTo(points3[i + -1], points3[i]);
            obj = points3;
            i3 = insertMove;
            dataIndex2 = dataIndex;
        }
        int i29 = insertClose2;
        if (insertClose != 0) {
            obj3.close();
        }
        return obj3;
    }

    public static androidx.compose.ui.graphics.Path reverse$default(androidx.compose.ui.graphics.Path path, androidx.compose.ui.graphics.Path path2, int i3, Object object4) {
        androidx.compose.ui.graphics.Path obj1;
        if (i3 &= 1 != 0) {
            obj1 = AndroidPath_androidKt.Path();
        }
        return PathGeometryKt.reverse(path, obj1);
    }
}
