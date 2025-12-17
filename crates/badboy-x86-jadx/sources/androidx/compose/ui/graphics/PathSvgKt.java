package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.vector.PathParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0001\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¨\u0006\u000c", d2 = {"command", "", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "lastType", "addSvg", "", "Landroidx/compose/ui/graphics/Path;", "pathData", "toSvg", "asDocument", "", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathSvgKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal6;
            int ordinal3;
            int ordinal;
            int ordinal7;
            int ordinal4;
            int ordinal2;
            int ordinal5;
            int[] iArr = new int[values.length];
            iArr[PathSegment.Type.Move.ordinal()] = 1;
            iArr[PathSegment.Type.Line.ordinal()] = 2;
            iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            iArr[PathSegment.Type.Conic.ordinal()] = 4;
            iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            iArr[PathSegment.Type.Close.ordinal()] = 6;
            iArr[PathSegment.Type.Done.ordinal()] = 7;
            PathSvgKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final void addSvg(androidx.compose.ui.graphics.Path $this$addSvg, String pathData) {
        PathParser pathParser = new PathParser();
        pathParser.parsePathString(pathData).toPath($this$addSvg);
    }

    private static final String command(androidx.compose.ui.graphics.PathSegment.Type type, androidx.compose.ui.graphics.PathSegment.Type lastType) {
        String str;
        int ordinal;
        if (type != lastType) {
            switch (i2) {
                case 1:
                    str = "M";
                    break;
                case 2:
                    str = "L";
                    break;
                case 3:
                    str = "Q";
                    break;
                case 4:
                    str = "";
                    break;
                case 5:
                    str = "C";
                    break;
                default:
                    str = "Z";
            }
        } else {
            str = " ";
        }
        return str;
    }

    public static final String toSvg(androidx.compose.ui.graphics.Path $this$toSvg, boolean asDocument) {
        int append2;
        int append3;
        StringBuilder append;
        String str;
        androidx.compose.ui.graphics.PathSegment.Type lastType;
        boolean next$default;
        int evenOdd-Rg-k1Os;
        int i;
        int command;
        int i2;
        int i4;
        int i3;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i6 = 0;
        final Rect bounds = $this$toSvg.getBounds();
        final String str3 = "append('\\n')";
        append2 = 10;
        final String str4 = "append(value)";
        append3 = 32;
        if (asDocument) {
            sb.append("<svg xmlns=\"http://www.w3.org/2000/svg\" ");
            StringBuilder stringBuilder2 = new StringBuilder();
            StringBuilder append14 = sb.append(stringBuilder2.append("viewBox=\"").append(bounds.getLeft()).append(append3).append(bounds.getTop()).append(append3).append(bounds.getWidth()).append(append3).append(bounds.getHeight()).append("\">").toString());
            Intrinsics.checkNotNullExpressionValue(append14, str4);
            Intrinsics.checkNotNullExpressionValue(append14.append(append2), str3);
        }
        androidx.compose.ui.graphics.PathIterator iterator = $this$toSvg.iterator();
        float[] fArr = new float[8];
        lastType = PathSegment.Type.Done;
        if (iterator.hasNext() && asDocument) {
            if (asDocument) {
                if (PathFillType.equals-impl0($this$toSvg.getFillType-Rg-k1Os(), PathFillType.Companion.getEvenOdd-Rg-k1Os())) {
                    sb.append("  <path fill-rule=\"evenodd\" d=\"");
                } else {
                    sb.append("  <path d=\"");
                }
            }
            while (iterator.hasNext()) {
                evenOdd-Rg-k1Os = 0;
                i = 2;
                next$default = PathIterator.next$default(iterator, fArr, evenOdd-Rg-k1Os, i, 0);
                i2 = 5;
                i4 = 4;
                i3 = 3;
                lastType = next$default;
                sb.append(PathSvgKt.command(PathSegment.Type.Close, lastType));
                sb.append(PathSvgKt.command(PathSegment.Type.Cubic, lastType));
                StringBuilder stringBuilder4 = new StringBuilder();
                sb.append(stringBuilder4.append(fArr[i]).append(append3).append(fArr[i3]).append(append3).toString());
                StringBuilder stringBuilder5 = new StringBuilder();
                sb.append(stringBuilder5.append(fArr[i4]).append(append3).append(fArr[i2]).append(append3).toString());
                StringBuilder stringBuilder6 = new StringBuilder();
                sb.append(stringBuilder6.append(fArr[6]).append(append3).append(fArr[7]).toString());
                sb.append(PathSvgKt.command(PathSegment.Type.Quadratic, lastType));
                StringBuilder stringBuilder3 = new StringBuilder();
                sb.append(stringBuilder3.append(fArr[i]).append(append3).append(fArr[i3]).append(append3).append(fArr[i4]).append(append3).append(fArr[i2]).toString());
                StringBuilder stringBuilder7 = new StringBuilder();
                sb.append(stringBuilder7.append(PathSvgKt.command(PathSegment.Type.Line, lastType)).append(fArr[i]).append(append3).append(fArr[i3]).toString());
                StringBuilder stringBuilder8 = new StringBuilder();
                sb.append(stringBuilder8.append(PathSvgKt.command(PathSegment.Type.Move, lastType)).append(fArr[evenOdd-Rg-k1Os]).append(append3).append(fArr[1]).toString());
            }
            if (asDocument) {
                StringBuilder append4 = sb.append("\"/>");
                Intrinsics.checkNotNullExpressionValue(append4, str4);
                Intrinsics.checkNotNullExpressionValue(append4.append(append2), str3);
            }
        }
        if (asDocument) {
            append3 = sb.append("</svg>");
            Intrinsics.checkNotNullExpressionValue(append3, str4);
            Intrinsics.checkNotNullExpressionValue(append3.append(append2), str3);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static String toSvg$default(androidx.compose.ui.graphics.Path path, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return PathSvgKt.toSvg(path, obj1);
    }
}
