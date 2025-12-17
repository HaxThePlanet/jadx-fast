package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.StrokeJoin.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB9\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\rR\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001e", d2 = {"Landroidx/compose/ui/graphics/drawscope/Stroke;", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "width", "", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "(FFIILandroidx/compose/ui/graphics/PathEffect;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCap-KaPHkGw", "()I", "I", "getJoin-LxFBmk8", "getMiter", "()F", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "getWidth", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Stroke extends androidx.compose.ui.graphics.drawscope.DrawStyle {

    public static final androidx.compose.ui.graphics.drawscope.Stroke.Companion Companion = null;
    private static final int DefaultCap = 0;
    private static final int DefaultJoin = 0;
    public static final float DefaultMiter = 4f;
    public static final float HairlineWidth;
    private final int cap;
    private final int join;
    private final float miter;
    private final PathEffect pathEffect;
    private final float width;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000e", d2 = {"Landroidx/compose/ui/graphics/drawscope/Stroke$Companion;", "", "()V", "DefaultCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getDefaultCap-KaPHkGw", "()I", "I", "DefaultJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getDefaultJoin-LxFBmk8", "DefaultMiter", "", "HairlineWidth", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getDefaultCap-KaPHkGw() {
            return Stroke.access$getDefaultCap$cp();
        }

        public final int getDefaultJoin-LxFBmk8() {
            return Stroke.access$getDefaultJoin$cp();
        }
    }
    static {
        Stroke.Companion companion = new Stroke.Companion(0);
        Stroke.Companion = companion;
        Stroke.DefaultCap = StrokeCap.Companion.getButt-KaPHkGw();
        Stroke.DefaultJoin = StrokeJoin.Companion.getMiter-LxFBmk8();
    }

    private Stroke(float width, float miter, int cap, int join, PathEffect pathEffect) {
        super(0);
        this.width = width;
        this.miter = miter;
        this.cap = cap;
        this.join = join;
        this.pathEffect = pathEffect;
    }

    public Stroke(float f, float f2, int i3, int i4, PathEffect pathEffect5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int i;
        int i8;
        int i2;
        int i7;
        int i5;
        int obj8;
        int obj9;
        int obj10;
        int obj11;
        int obj12;
        i = i6 & 1 != 0 ? obj8 : f;
        i8 = i6 & 2 != 0 ? obj9 : f2;
        i2 = i6 & 4 != 0 ? obj10 : i3;
        i7 = i6 & 8 != 0 ? obj11 : i4;
        i5 = i6 & 16 != 0 ? obj12 : pathEffect5;
        super(i, i8, i2, i7, i5, 0);
    }

    public Stroke(float f, float f2, int i3, int i4, PathEffect pathEffect5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(f, f2, i3, i4, pathEffect5);
    }

    public static final int access$getDefaultCap$cp() {
        return Stroke.DefaultCap;
    }

    public static final int access$getDefaultJoin$cp() {
        return Stroke.DefaultJoin;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawStyle
    public boolean equals(Object other) {
        int i;
        int i2;
        final int i3 = 1;
        if (this == other) {
            return i3;
        }
        final int i4 = 0;
        if (!other instanceof Stroke) {
            return i4;
        }
        i = Float.compare(width, width2) == 0 ? i3 : i4;
        if (i == 0) {
            return i4;
        }
        i2 = Float.compare(miter, miter2) == 0 ? i3 : i4;
        if (i2 == 0) {
            return i4;
        }
        if (!StrokeCap.equals-impl0(this.cap, obj3.cap)) {
            return i4;
        }
        if (!StrokeJoin.equals-impl0(this.join, obj4.join)) {
            return i4;
        }
        if (!Intrinsics.areEqual(this.pathEffect, obj5.pathEffect)) {
            return i4;
        }
        return i3;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawStyle
    public final int getCap-KaPHkGw() {
        return this.cap;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawStyle
    public final int getJoin-LxFBmk8() {
        return this.join;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawStyle
    public final float getMiter() {
        return this.miter;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawStyle
    public final PathEffect getPathEffect() {
        return this.pathEffect;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawStyle
    public final float getWidth() {
        return this.width;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawStyle
    public int hashCode() {
        int i;
        PathEffect pathEffect = this.pathEffect;
        if (pathEffect != null) {
            i = pathEffect.hashCode();
        } else {
            i = 0;
        }
        return result2 += i;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawStyle
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Stroke(width=").append(this.width).append(", miter=").append(this.miter).append(", cap=").append(StrokeCap.toString-impl(this.cap)).append(", join=").append(StrokeJoin.toString-impl(this.join)).append(", pathEffect=").append(this.pathEffect).append(')').toString();
    }
}
