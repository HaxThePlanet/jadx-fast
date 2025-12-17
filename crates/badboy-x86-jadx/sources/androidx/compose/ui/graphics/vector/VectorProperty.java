package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0010\u0004\u0005\u0006\u0007\u0008\t\n\u000b\u000c\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0010\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#¨\u0006$", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty;", "T", "", "()V", "Fill", "FillAlpha", "PathData", "PivotX", "PivotY", "Rotation", "ScaleX", "ScaleY", "Stroke", "StrokeAlpha", "StrokeLineWidth", "TranslateX", "TranslateY", "TrimPathEnd", "TrimPathOffset", "TrimPathStart", "Landroidx/compose/ui/graphics/vector/VectorProperty$Fill;", "Landroidx/compose/ui/graphics/vector/VectorProperty$FillAlpha;", "Landroidx/compose/ui/graphics/vector/VectorProperty$PathData;", "Landroidx/compose/ui/graphics/vector/VectorProperty$PivotX;", "Landroidx/compose/ui/graphics/vector/VectorProperty$PivotY;", "Landroidx/compose/ui/graphics/vector/VectorProperty$Rotation;", "Landroidx/compose/ui/graphics/vector/VectorProperty$ScaleX;", "Landroidx/compose/ui/graphics/vector/VectorProperty$ScaleY;", "Landroidx/compose/ui/graphics/vector/VectorProperty$Stroke;", "Landroidx/compose/ui/graphics/vector/VectorProperty$StrokeAlpha;", "Landroidx/compose/ui/graphics/vector/VectorProperty$StrokeLineWidth;", "Landroidx/compose/ui/graphics/vector/VectorProperty$TranslateX;", "Landroidx/compose/ui/graphics/vector/VectorProperty$TranslateY;", "Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathEnd;", "Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathOffset;", "Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathStart;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class VectorProperty<T>  {

    public static final int $stable;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$Fill;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "Landroidx/compose/ui/graphics/Brush;", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Fill extends androidx.compose.ui.graphics.vector.VectorProperty<androidx.compose.ui.graphics.Brush> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.Fill INSTANCE;
        static {
            VectorProperty.Fill fill = new VectorProperty.Fill();
            VectorProperty.Fill.INSTANCE = fill;
        }

        private Fill() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$FillAlpha;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FillAlpha extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.FillAlpha INSTANCE;
        static {
            VectorProperty.FillAlpha fillAlpha = new VectorProperty.FillAlpha();
            VectorProperty.FillAlpha.INSTANCE = fillAlpha;
        }

        private FillAlpha() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$PathData;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PathData extends androidx.compose.ui.graphics.vector.VectorProperty<java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode>> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.PathData INSTANCE;
        static {
            VectorProperty.PathData pathData = new VectorProperty.PathData();
            VectorProperty.PathData.INSTANCE = pathData;
        }

        private PathData() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$PivotX;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PivotX extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.PivotX INSTANCE;
        static {
            VectorProperty.PivotX pivotX = new VectorProperty.PivotX();
            VectorProperty.PivotX.INSTANCE = pivotX;
        }

        private PivotX() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$PivotY;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PivotY extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.PivotY INSTANCE;
        static {
            VectorProperty.PivotY pivotY = new VectorProperty.PivotY();
            VectorProperty.PivotY.INSTANCE = pivotY;
        }

        private PivotY() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$Rotation;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Rotation extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.Rotation INSTANCE;
        static {
            VectorProperty.Rotation rotation = new VectorProperty.Rotation();
            VectorProperty.Rotation.INSTANCE = rotation;
        }

        private Rotation() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$ScaleX;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ScaleX extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.ScaleX INSTANCE;
        static {
            VectorProperty.ScaleX scaleX = new VectorProperty.ScaleX();
            VectorProperty.ScaleX.INSTANCE = scaleX;
        }

        private ScaleX() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$ScaleY;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ScaleY extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.ScaleY INSTANCE;
        static {
            VectorProperty.ScaleY scaleY = new VectorProperty.ScaleY();
            VectorProperty.ScaleY.INSTANCE = scaleY;
        }

        private ScaleY() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$Stroke;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "Landroidx/compose/ui/graphics/Brush;", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Stroke extends androidx.compose.ui.graphics.vector.VectorProperty<androidx.compose.ui.graphics.Brush> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.Stroke INSTANCE;
        static {
            VectorProperty.Stroke stroke = new VectorProperty.Stroke();
            VectorProperty.Stroke.INSTANCE = stroke;
        }

        private Stroke() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$StrokeAlpha;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StrokeAlpha extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.StrokeAlpha INSTANCE;
        static {
            VectorProperty.StrokeAlpha strokeAlpha = new VectorProperty.StrokeAlpha();
            VectorProperty.StrokeAlpha.INSTANCE = strokeAlpha;
        }

        private StrokeAlpha() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$StrokeLineWidth;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StrokeLineWidth extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.StrokeLineWidth INSTANCE;
        static {
            VectorProperty.StrokeLineWidth strokeLineWidth = new VectorProperty.StrokeLineWidth();
            VectorProperty.StrokeLineWidth.INSTANCE = strokeLineWidth;
        }

        private StrokeLineWidth() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$TranslateX;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TranslateX extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.TranslateX INSTANCE;
        static {
            VectorProperty.TranslateX translateX = new VectorProperty.TranslateX();
            VectorProperty.TranslateX.INSTANCE = translateX;
        }

        private TranslateX() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$TranslateY;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TranslateY extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.TranslateY INSTANCE;
        static {
            VectorProperty.TranslateY translateY = new VectorProperty.TranslateY();
            VectorProperty.TranslateY.INSTANCE = translateY;
        }

        private TranslateY() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathEnd;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TrimPathEnd extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.TrimPathEnd INSTANCE;
        static {
            VectorProperty.TrimPathEnd trimPathEnd = new VectorProperty.TrimPathEnd();
            VectorProperty.TrimPathEnd.INSTANCE = trimPathEnd;
        }

        private TrimPathEnd() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathOffset;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TrimPathOffset extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.TrimPathOffset INSTANCE;
        static {
            VectorProperty.TrimPathOffset trimPathOffset = new VectorProperty.TrimPathOffset();
            VectorProperty.TrimPathOffset.INSTANCE = trimPathOffset;
        }

        private TrimPathOffset() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathStart;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TrimPathStart extends androidx.compose.ui.graphics.vector.VectorProperty<Float> {

        public static final int $stable;
        public static final androidx.compose.ui.graphics.vector.VectorProperty.TrimPathStart INSTANCE;
        static {
            VectorProperty.TrimPathStart trimPathStart = new VectorProperty.TrimPathStart();
            VectorProperty.TrimPathStart.INSTANCE = trimPathStart;
        }

        private TrimPathStart() {
            super(0);
        }
    }
    static {
    }

    public VectorProperty(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }
}
