package androidx.graphics.path;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\"\u0016\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\u0007", d2 = {"PathSegmentTypes", "", "Landroidx/graphics/path/PathSegment$Type;", "[Landroidx/graphics/path/PathSegment$Type;", "platformToAndroidXSegmentType", "platformType", "", "graphics-path_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathIteratorImplKt {

    private static final androidx.graphics.path.PathSegment.Type[] PathSegmentTypes;
    static {
        PathIteratorImplKt.PathSegmentTypes = PathSegment.Type.values();
    }

    public static final androidx.graphics.path.PathSegment.Type[] access$getPathSegmentTypes$p() {
        return PathIteratorImplKt.PathSegmentTypes;
    }

    public static final androidx.graphics.path.PathSegment.Type access$platformToAndroidXSegmentType(int platformType) {
        return PathIteratorImplKt.platformToAndroidXSegmentType(platformType);
    }

    private static final androidx.graphics.path.PathSegment.Type platformToAndroidXSegmentType(int platformType) {
        androidx.graphics.path.PathSegment.Type quadratic;
        switch (platformType) {
            case 0:
                quadratic = PathSegment.Type.Move;
                break;
            case 1:
                quadratic = PathSegment.Type.Line;
                break;
            case 2:
                quadratic = PathSegment.Type.Quadratic;
                break;
            case 3:
                quadratic = PathSegment.Type.Conic;
                break;
            case 4:
                quadratic = PathSegment.Type.Cubic;
                break;
            case 5:
                quadratic = PathSegment.Type.Close;
                break;
            case 6:
                quadratic = PathSegment.Type.Done;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unknown path segment type ").append(platformType).toString());
                throw illegalArgumentException;
        }
        return quadratic;
    }
}
