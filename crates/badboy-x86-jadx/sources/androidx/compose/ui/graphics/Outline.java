package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0003\u0007\u0008\tB\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\u000c¨\u0006\r", d2 = {"Landroidx/compose/ui/graphics/Outline;", "", "()V", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "Generic", "Rectangle", "Rounded", "Landroidx/compose/ui/graphics/Outline$Generic;", "Landroidx/compose/ui/graphics/Outline$Rectangle;", "Landroidx/compose/ui/graphics/Outline$Rounded;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Outline {

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/ui/graphics/Outline$Generic;", "Landroidx/compose/ui/graphics/Outline;", "path", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/Path;)V", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "getPath", "()Landroidx/compose/ui/graphics/Path;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Generic extends androidx.compose.ui.graphics.Outline {

        private final androidx.compose.ui.graphics.Path path;
        public Generic(androidx.compose.ui.graphics.Path path) {
            super(0);
            this.path = path;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public Rect getBounds() {
            return this.path.getBounds();
        }

        @Override // androidx.compose.ui.graphics.Outline
        public final androidx.compose.ui.graphics.Path getPath() {
            return this.path;
        }
    }

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0096\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u000f", d2 = {"Landroidx/compose/ui/graphics/Outline$Rectangle;", "Landroidx/compose/ui/graphics/Outline;", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;)V", "bounds", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "getRect", "equals", "", "other", "", "hashCode", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Rectangle extends androidx.compose.ui.graphics.Outline {

        private final Rect rect;
        public Rectangle(Rect rect) {
            super(0);
            this.rect = rect;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public boolean equals(Object other) {
            final int i = 1;
            if (this == other) {
                return i;
            }
            final int i2 = 0;
            if (!other instanceof Outline.Rectangle) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.rect, obj.rect)) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public Rect getBounds() {
            return this.rect;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public final Rect getRect() {
            return this.rect;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public int hashCode() {
            return this.rect.hashCode();
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0015", d2 = {"Landroidx/compose/ui/graphics/Outline$Rounded;", "Landroidx/compose/ui/graphics/Outline;", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "(Landroidx/compose/ui/geometry/RoundRect;)V", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "getRoundRect", "()Landroidx/compose/ui/geometry/RoundRect;", "roundRectPath", "Landroidx/compose/ui/graphics/Path;", "getRoundRectPath$ui_graphics_release", "()Landroidx/compose/ui/graphics/Path;", "equals", "", "other", "", "hashCode", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Rounded extends androidx.compose.ui.graphics.Outline {

        private final RoundRect roundRect;
        private final androidx.compose.ui.graphics.Path roundRectPath;
        public Rounded(RoundRect roundRect) {
            androidx.compose.ui.graphics.Path i2;
            androidx.compose.ui.graphics.Path simple;
            androidx.compose.ui.graphics.Path path;
            int i3;
            RoundRect roundRect2;
            int i;
            i2 = 0;
            super(i2);
            this.roundRect = roundRect;
            if (!RoundRectKt.isSimple(this.roundRect)) {
                simple = AndroidPath_androidKt.Path();
                i3 = 0;
                Path.addRoundRect$default(simple, this.roundRect, i2, 2, i2);
                i2 = simple;
            } else {
            }
            this.roundRectPath = i2;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public boolean equals(Object other) {
            final int i = 1;
            if (this == other) {
                return i;
            }
            final int i2 = 0;
            if (!other instanceof Outline.Rounded) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.roundRect, obj.roundRect)) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public Rect getBounds() {
            return RoundRectKt.getBoundingRect(this.roundRect);
        }

        @Override // androidx.compose.ui.graphics.Outline
        public final RoundRect getRoundRect() {
            return this.roundRect;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public final androidx.compose.ui.graphics.Path getRoundRectPath$ui_graphics_release() {
            return this.roundRectPath;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public int hashCode() {
            return this.roundRect.hashCode();
        }
    }
    public Outline(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public abstract Rect getBounds();
}
