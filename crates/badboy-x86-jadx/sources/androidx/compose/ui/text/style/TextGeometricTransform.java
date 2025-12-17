package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\t\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/style/TextGeometricTransform;", "", "scaleX", "", "skewX", "(FF)V", "getScaleX", "()F", "getSkewX", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextGeometricTransform {

    public static final int $stable;
    public static final androidx.compose.ui.text.style.TextGeometricTransform.Companion Companion;
    private static final androidx.compose.ui.text.style.TextGeometricTransform None;
    private final float scaleX;
    private final float skewX;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "", "()V", "None", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "getNone$ui_text_release$annotations", "getNone$ui_text_release", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getNone$ui_text_release$annotations() {
        }

        public final androidx.compose.ui.text.style.TextGeometricTransform getNone$ui_text_release() {
            return TextGeometricTransform.access$getNone$cp();
        }
    }
    static {
        TextGeometricTransform.Companion companion = new TextGeometricTransform.Companion(0);
        TextGeometricTransform.Companion = companion;
        TextGeometricTransform textGeometricTransform = new TextGeometricTransform(1065353216, 0);
        TextGeometricTransform.None = textGeometricTransform;
    }

    public TextGeometricTransform() {
        final int i3 = 0;
        super(i3, i3, 3, 0);
    }

    public TextGeometricTransform(float scaleX, float skewX) {
        super();
        this.scaleX = scaleX;
        this.skewX = skewX;
    }

    public TextGeometricTransform(float f, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj1;
        int obj2;
        obj1 = i3 & 1 != 0 ? 1065353216 : obj1;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(obj1, obj2);
    }

    public static final androidx.compose.ui.text.style.TextGeometricTransform access$getNone$cp() {
        return TextGeometricTransform.None;
    }

    public static androidx.compose.ui.text.style.TextGeometricTransform copy$default(androidx.compose.ui.text.style.TextGeometricTransform textGeometricTransform, float f2, float f3, int i4, Object object5) {
        float obj1;
        float obj2;
        if (i4 & 1 != 0) {
            obj1 = textGeometricTransform.scaleX;
        }
        if (i4 &= 2 != 0) {
            obj2 = textGeometricTransform.skewX;
        }
        return textGeometricTransform.copy(obj1, obj2);
    }

    public final androidx.compose.ui.text.style.TextGeometricTransform copy(float scaleX, float skewX) {
        TextGeometricTransform textGeometricTransform = new TextGeometricTransform(scaleX, skewX);
        return textGeometricTransform;
    }

    public boolean equals(Object other) {
        int i;
        int i2;
        final int i3 = 1;
        if (this == other) {
            return i3;
        }
        final int i4 = 0;
        if (!other instanceof TextGeometricTransform) {
            return i4;
        }
        i = Float.compare(scaleX, scaleX2) == 0 ? i3 : i4;
        if (i == 0) {
            return i4;
        }
        i2 = Float.compare(skewX, skewX2) == 0 ? i3 : i4;
        if (i2 == 0) {
            return i4;
        }
        return i3;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getSkewX() {
        return this.skewX;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TextGeometricTransform(scaleX=").append(this.scaleX).append(", skewX=").append(this.skewX).append(')').toString();
    }
}
