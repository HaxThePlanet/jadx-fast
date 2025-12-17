package androidx.compose.ui.graphics;

import androidx.graphics.path.PathSegment.Type;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u000c\u0010\u0008\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b", d2 = {"PathIterator", "Landroidx/compose/ui/graphics/PathIterator;", "path", "Landroidx/compose/ui/graphics/Path;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "", "toPathSegmentType", "Landroidx/compose/ui/graphics/PathSegment$Type;", "Landroidx/graphics/path/PathSegment$Type;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidPathIterator_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal4;
            int ordinal5;
            int ordinal3;
            int ordinal6;
            int ordinal7;
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[PathSegment.Type.Move.ordinal()] = 1;
            iArr[PathSegment.Type.Line.ordinal()] = 2;
            iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            iArr[PathSegment.Type.Conic.ordinal()] = 4;
            iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            iArr[PathSegment.Type.Close.ordinal()] = 6;
            iArr[PathSegment.Type.Done.ordinal()] = 7;
            AndroidPathIterator_androidKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final androidx.compose.ui.graphics.PathIterator PathIterator(androidx.compose.ui.graphics.Path path, androidx.compose.ui.graphics.PathIterator.ConicEvaluation conicEvaluation, float tolerance) {
        AndroidPathIterator androidPathIterator = new AndroidPathIterator(path, conicEvaluation, tolerance);
        return (PathIterator)androidPathIterator;
    }

    public static androidx.compose.ui.graphics.PathIterator PathIterator$default(androidx.compose.ui.graphics.Path path, androidx.compose.ui.graphics.PathIterator.ConicEvaluation pathIterator$ConicEvaluation2, float f3, int i4, Object object5) {
        androidx.compose.ui.graphics.PathIterator.ConicEvaluation obj1;
        int obj2;
        if (i4 & 2 != 0) {
            obj1 = PathIterator.ConicEvaluation.AsQuadratics;
        }
        if (i4 &= 4 != 0) {
            obj2 = 1048576000;
        }
        return AndroidPathIterator_androidKt.PathIterator(path, obj1, obj2);
    }

    public static final androidx.compose.ui.graphics.PathSegment.Type access$toPathSegmentType(PathSegment.Type $receiver) {
        return AndroidPathIterator_androidKt.toPathSegmentType($receiver);
    }

    private static final androidx.compose.ui.graphics.PathSegment.Type toPathSegmentType(PathSegment.Type $this$toPathSegmentType) {
        androidx.compose.ui.graphics.PathSegment.Type quadratic;
        switch (i) {
            case 1:
                quadratic = PathSegment.Type.Move;
                break;
            case 2:
                quadratic = PathSegment.Type.Line;
                break;
            case 3:
                quadratic = PathSegment.Type.Quadratic;
                break;
            case 4:
                quadratic = PathSegment.Type.Conic;
                break;
            case 5:
                quadratic = PathSegment.Type.Cubic;
                break;
            case 6:
                quadratic = PathSegment.Type.Close;
                break;
            case 7:
                quadratic = PathSegment.Type.Done;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return quadratic;
    }
}
