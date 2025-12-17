package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016", d2 = {"Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "constructor-impl", "(Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "equals", "", "other", "equals-impl", "(Landroidx/compose/ui/graphics/Shape;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/ui/graphics/Shape;)I", "toString", "", "toString-impl", "(Landroidx/compose/ui/graphics/Shape;)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class BlurredEdgeTreatment {

    public static final androidx.compose.ui.draw.BlurredEdgeTreatment.Companion Companion;
    private static final Shape Rectangle;
    private static final Shape Unbounded;
    private final Shape shape;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\n", d2 = {"Landroidx/compose/ui/draw/BlurredEdgeTreatment$Companion;", "", "()V", "Rectangle", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "getRectangle---Goahg", "()Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/ui/graphics/Shape;", "Unbounded", "getUnbounded---Goahg", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Shape getRectangle---Goahg() {
            return BlurredEdgeTreatment.access$getRectangle$cp();
        }

        public final Shape getUnbounded---Goahg() {
            return BlurredEdgeTreatment.access$getUnbounded$cp();
        }
    }
    static {
        final int i = 0;
        BlurredEdgeTreatment.Companion companion = new BlurredEdgeTreatment.Companion(i);
        BlurredEdgeTreatment.Companion = companion;
        BlurredEdgeTreatment.Rectangle = BlurredEdgeTreatment.constructor-impl(RectangleShapeKt.getRectangleShape());
        BlurredEdgeTreatment.Unbounded = BlurredEdgeTreatment.constructor-impl(i);
    }

    private BlurredEdgeTreatment(Shape shape) {
        super();
        this.shape = shape;
    }

    public static final Shape access$getRectangle$cp() {
        return BlurredEdgeTreatment.Rectangle;
    }

    public static final Shape access$getUnbounded$cp() {
        return BlurredEdgeTreatment.Unbounded;
    }

    public static final androidx.compose.ui.draw.BlurredEdgeTreatment box-impl(Shape shape) {
        BlurredEdgeTreatment blurredEdgeTreatment = new BlurredEdgeTreatment(shape);
        return blurredEdgeTreatment;
    }

    public static Shape constructor-impl(Shape shape) {
        return shape;
    }

    public static boolean equals-impl(Shape shape, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof BlurredEdgeTreatment) {
            return i2;
        }
        if (!Intrinsics.areEqual(shape, (BlurredEdgeTreatment)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(Shape shape, Shape shape2) {
        return Intrinsics.areEqual(shape, shape2);
    }

    public static int hashCode-impl(Shape shape) {
        int i;
        if (shape == null) {
            i = 0;
        } else {
            i = shape.hashCode();
        }
        return i;
    }

    public static String toString-impl(Shape shape) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BlurredEdgeTreatment(shape=").append(shape).append(')').toString();
    }

    public boolean equals(Object object) {
        return BlurredEdgeTreatment.equals-impl(this.shape, object);
    }

    public final Shape getShape() {
        return this.shape;
    }

    public int hashCode() {
        return BlurredEdgeTreatment.hashCode-impl(this.shape);
    }

    public String toString() {
        return BlurredEdgeTreatment.toString-impl(this.shape);
    }

    public final Shape unbox-impl() {
        return this.shape;
    }
}
