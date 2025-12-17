package androidx.graphics.path;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0004J1\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0082 J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u0006R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Landroidx/graphics/path/ConicConverter;", "", "()V", "currentQuadratic", "", "getCurrentQuadratic", "()I", "setCurrentQuadratic", "(I)V", "<set-?>", "quadraticCount", "getQuadraticCount", "quadraticData", "", "convert", "", "points", "weight", "", "tolerance", "offset", "internalConicToQuadratics", "conicPoints", "quadraticPoints", "nextQuadratic", "", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConicConverter {

    private int currentQuadratic;
    private int quadraticCount;
    private float[] quadraticData;
    public ConicConverter() {
        super();
        this.quadraticData = new float[130];
    }

    public static void convert$default(androidx.graphics.path.ConicConverter conicConverter, float[] f2Arr2, float f3, float f4, int i5, int i6, Object object7) {
        int obj4;
        if (i6 &= 8 != 0) {
            obj4 = 0;
        }
        conicConverter.convert(f2Arr2, f3, f4, obj4);
    }

    private final native int internalConicToQuadratics(float[] fArr, int i2, float[] f3Arr3, float f4, float f5);

    public static boolean nextQuadratic$default(androidx.graphics.path.ConicConverter conicConverter, float[] f2Arr2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return conicConverter.nextQuadratic(f2Arr2, obj2);
    }

    public final void convert(float[] points, float weight, float tolerance, int offset) {
        int quadraticData;
        int obj9;
        Intrinsics.checkNotNullParameter(points, "points");
        Object obj2 = this;
        Object obj4 = points;
        float f2 = weight;
        final float f3 = tolerance;
        quadraticData = offset;
        Object obj = obj2;
        obj.quadraticCount = obj2.internalConicToQuadratics(obj4, quadraticData, this.quadraticData, f2, f3);
        obj8 += 2;
        if (obj8 > obj9.length) {
            obj.quadraticData = new float[obj8];
            obj.quadraticCount = obj.internalConicToQuadratics(obj4, quadraticData, obj.quadraticData, f2, f3);
        }
        obj.currentQuadratic = 0;
    }

    public final int getCurrentQuadratic() {
        return this.currentQuadratic;
    }

    public final int getQuadraticCount() {
        return this.quadraticCount;
    }

    public final boolean nextQuadratic(float[] points, int offset) {
        Intrinsics.checkNotNullParameter(points, "points");
        if (this.currentQuadratic < this.quadraticCount) {
            i *= 2;
            points[offset + 0] = this.quadraticData[i2];
            points[offset + 1] = this.quadraticData[i2 + 1];
            points[offset + 2] = this.quadraticData[i2 + 2];
            points[offset + 3] = this.quadraticData[i2 + 3];
            points[offset + 4] = this.quadraticData[i2 + 4];
            points[offset + 5] = this.quadraticData[i2 + 5];
            int i10 = 1;
            this.currentQuadratic = currentQuadratic3 += i10;
            return i10;
        }
        return 0;
    }

    public final void setCurrentQuadratic(int <set-?>) {
        this.currentQuadratic = <set-?>;
    }
}
