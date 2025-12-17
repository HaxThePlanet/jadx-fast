package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008`\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0016J\u0016\u0010\u0010\u001a\u00020\u00002\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0011H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0018\u0010\n\u001a\u00020\u000bX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006\u0014À\u0006\u0001", d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle;", "", "alpha", "", "getAlpha", "()F", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "merge", "other", "takeOrElse", "Lkotlin/Function0;", "Companion", "Unspecified", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TextForegroundStyle {

    public static final androidx.compose.ui.text.style.TextForegroundStyle.Companion Companion;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0008J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\r", d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle$Companion;", "", "()V", "from", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "color", "Landroidx/compose/ui/graphics/Color;", "from-8_81llA", "(J)Landroidx/compose/ui/text/style/TextForegroundStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.text.style.TextForegroundStyle.Companion $$INSTANCE;
        static {
            TextForegroundStyle.Companion companion = new TextForegroundStyle.Companion();
            TextForegroundStyle.Companion.$$INSTANCE = companion;
        }

        public final androidx.compose.ui.text.style.TextForegroundStyle from(Brush brush, float alpha) {
            androidx.compose.ui.text.style.TextForegroundStyle from-8_81llA;
            long l;
            if (brush == null) {
                from-8_81llA = TextForegroundStyle.Unspecified.INSTANCE;
                return from-8_81llA;
            } else {
                if (brush instanceof SolidColor) {
                    from-8_81llA = from-8_81llA(TextDrawStyleKt.modulate-DxMtmZc((SolidColor)brush.getValue-0d7_KjU(), obj1));
                } else {
                    if (!brush instanceof ShaderBrush) {
                    } else {
                        from-8_81llA = new BrushStyle((ShaderBrush)brush, alpha);
                    }
                }
            }
            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
            throw noWhenBranchMatchedException;
        }

        public final androidx.compose.ui.text.style.TextForegroundStyle from-8_81llA(long color) {
            Object colorStyle;
            int i;
            int i2;
            final int i4 = 0;
            i2 = Long.compare(i3, i5) != 0 ? 1 : 0;
            if (i2 != 0) {
                colorStyle = new ColorStyle(color, obj7, 0);
            } else {
                colorStyle = TextForegroundStyle.Unspecified.INSTANCE;
            }
            return (TextForegroundStyle)colorStyle;
        }
    }

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000f", d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle$Unspecified;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "()V", "alpha", "", "getAlpha", "()F", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Unspecified implements androidx.compose.ui.text.style.TextForegroundStyle {

        public static final int $stable;
        public static final androidx.compose.ui.text.style.TextForegroundStyle.Unspecified INSTANCE;
        static {
            TextForegroundStyle.Unspecified unspecified = new TextForegroundStyle.Unspecified();
            TextForegroundStyle.Unspecified.INSTANCE = unspecified;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public float getAlpha() {
            return 2143289344;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public Brush getBrush() {
            return null;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public long getColor-0d7_KjU() {
            return Color.Companion.getUnspecified-0d7_KjU();
        }
    }
    static {
        TextForegroundStyle.Companion = TextForegroundStyle.Companion.$$INSTANCE;
    }

    public abstract float getAlpha();

    public abstract Brush getBrush();

    public abstract long getColor-0d7_KjU();

    public androidx.compose.ui.text.style.TextForegroundStyle merge(androidx.compose.ui.text.style.TextForegroundStyle other) {
        boolean z3;
        boolean z;
        boolean z2;
        Object takeOrElse;
        androidx.compose.ui.graphics.ShaderBrush value;
        float f;
        androidx.compose.ui.text.style.TextForegroundStyle.merge.1 anon;
        if (other instanceof BrushStyle && this instanceof BrushStyle) {
            if (this instanceof BrushStyle) {
                anon = new TextForegroundStyle.merge.1(this);
                takeOrElse = new BrushStyle((BrushStyle)other.getValue(), TextDrawStyleKt.access$takeOrElse(other.getAlpha(), (Function0)anon));
            } else {
                if (other instanceof BrushStyle && !this instanceof BrushStyle) {
                    if (!this instanceof BrushStyle) {
                        takeOrElse = other;
                    } else {
                        if (!other instanceof BrushStyle && this instanceof BrushStyle) {
                            if (this instanceof BrushStyle) {
                                takeOrElse = this;
                            } else {
                                TextForegroundStyle.merge.2 anon2 = new TextForegroundStyle.merge.2(this);
                                takeOrElse = other.takeOrElse((Function0)anon2);
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return takeOrElse;
    }

    public androidx.compose.ui.text.style.TextForegroundStyle takeOrElse(Function0<? extends androidx.compose.ui.text.style.TextForegroundStyle> other) {
        Object invoke;
        if (!Intrinsics.areEqual(this, TextForegroundStyle.Unspecified.INSTANCE)) {
            invoke = this;
        } else {
            invoke = other.invoke();
        }
        return invoke;
    }
}
