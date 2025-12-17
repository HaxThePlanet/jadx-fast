package androidx.compose.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0008\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u0003H\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0012\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/material/ripple/UnprojectedRipple;", "Landroid/graphics/drawable/RippleDrawable;", "bounded", "", "(Z)V", "projected", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "rippleRadius", "", "Ljava/lang/Integer;", "calculateRippleColor", "color", "alpha", "", "calculateRippleColor-5vOe2sY", "(JF)J", "getDirtyBounds", "Landroid/graphics/Rect;", "isProjected", "setColor", "", "setColor-DxMtmZc", "(JF)V", "trySetRadius", "radius", "Companion", "MRadiusHelper", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class UnprojectedRipple extends RippleDrawable {

    public static final androidx.compose.material.ripple.UnprojectedRipple.Companion Companion;
    private static boolean setMaxRadiusFetched;
    private static Method setMaxRadiusMethod;
    private final boolean bounded;
    private boolean projected;
    private Color rippleColor;
    private Integer rippleRadius;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Landroidx/compose/material/ripple/UnprojectedRipple$Companion;", "", "()V", "setMaxRadiusFetched", "", "setMaxRadiusMethod", "Ljava/lang/reflect/Method;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¨\u0006\t", d2 = {"Landroidx/compose/material/ripple/UnprojectedRipple$MRadiusHelper;", "", "()V", "setRadius", "", "ripple", "Landroid/graphics/drawable/RippleDrawable;", "radius", "", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class MRadiusHelper {

        public static final androidx.compose.material.ripple.UnprojectedRipple.MRadiusHelper INSTANCE;
        static {
            UnprojectedRipple.MRadiusHelper mRadiusHelper = new UnprojectedRipple.MRadiusHelper();
            UnprojectedRipple.MRadiusHelper.INSTANCE = mRadiusHelper;
        }

        public final void setRadius(RippleDrawable ripple, int radius) {
            ripple.setRadius(radius);
        }
    }
    static {
        UnprojectedRipple.Companion companion = new UnprojectedRipple.Companion(0);
        UnprojectedRipple.Companion = companion;
    }

    public UnprojectedRipple(boolean bounded) {
        ColorDrawable colorDrawable;
        int i;
        final int i3 = 0;
        if (bounded) {
            colorDrawable = new ColorDrawable(-1);
        } else {
            colorDrawable = i3;
        }
        super(ColorStateList.valueOf(-16777216), i3, (Drawable)colorDrawable);
        this.bounded = bounded;
    }

    private final long calculateRippleColor-5vOe2sY(long color, float alpha) {
        return Color.copy-wmQWz5c$default(color, obj2, RangesKt.coerceAtMost(obj12, 1065353216), 0, 0, 0, 14);
    }

    @Override // android.graphics.drawable.RippleDrawable
    public Rect getDirtyBounds() {
        boolean bounded;
        if (!this.bounded) {
            this.projected = true;
        }
        this.projected = false;
        return super.getDirtyBounds();
    }

    @Override // android.graphics.drawable.RippleDrawable
    public boolean isProjected() {
        return this.projected;
    }

    @Override // android.graphics.drawable.RippleDrawable
    public final void setColor-DxMtmZc(long color, float alpha) {
        int valueOf;
        final long rippleColor-5vOe2sY = calculateRippleColor-5vOe2sY(color, alpha);
        Color rippleColor = this.rippleColor;
        if (rippleColor == null) {
            valueOf = 0;
        } else {
            valueOf = Color.equals-impl0(rippleColor.unbox-impl(), obj3);
        }
        if (valueOf == 0) {
            this.rippleColor = Color.box-impl(rippleColor-5vOe2sY);
            setColor(ColorStateList.valueOf(ColorKt.toArgb-8_81llA(rippleColor-5vOe2sY)));
        }
    }

    @Override // android.graphics.drawable.RippleDrawable
    public final void trySetRadius(int radius) {
        Integer rippleRadius;
        Object obj;
        rippleRadius = this.rippleRadius;
        if (rippleRadius == null) {
            this.rippleRadius = Integer.valueOf(radius);
            UnprojectedRipple.MRadiusHelper.INSTANCE.setRadius((RippleDrawable)this, radius);
        } else {
            if (rippleRadius.intValue() != radius) {
            }
        }
    }
}
