package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/compose/ui/text/font/AndroidFontResolveInterceptor;", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "fontWeightAdjustment", "", "(I)V", "component1", "copy", "equals", "", "other", "", "hashCode", "interceptFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidFontResolveInterceptor implements androidx.compose.ui.text.font.PlatformResolveInterceptor {

    public static final int $stable;
    private final int fontWeightAdjustment;
    static {
    }

    public AndroidFontResolveInterceptor(int fontWeightAdjustment) {
        super();
        this.fontWeightAdjustment = fontWeightAdjustment;
    }

    private final int component1() {
        return this.fontWeightAdjustment;
    }

    public static androidx.compose.ui.text.font.AndroidFontResolveInterceptor copy$default(androidx.compose.ui.text.font.AndroidFontResolveInterceptor androidFontResolveInterceptor, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = androidFontResolveInterceptor.fontWeightAdjustment;
        }
        return androidFontResolveInterceptor.copy(obj1);
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    public final androidx.compose.ui.text.font.AndroidFontResolveInterceptor copy(int i) {
        AndroidFontResolveInterceptor androidFontResolveInterceptor = new AndroidFontResolveInterceptor(i);
        return androidFontResolveInterceptor;
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof AndroidFontResolveInterceptor) {
            return i2;
        }
        if (this.fontWeightAdjustment != obj.fontWeightAdjustment) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    public int hashCode() {
        return Integer.hashCode(this.fontWeightAdjustment);
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    public androidx.compose.ui.text.font.FontWeight interceptFontWeight(androidx.compose.ui.text.font.FontWeight fontWeight) {
        int fontWeightAdjustment;
        int i;
        if (this.fontWeightAdjustment != 0 && this.fontWeightAdjustment == Integer.MAX_VALUE) {
            if (this.fontWeightAdjustment == Integer.MAX_VALUE) {
            }
            FontWeight fontWeight2 = new FontWeight(RangesKt.coerceIn(weight += fontWeightAdjustment2, 1, 1000));
            return fontWeight2;
        }
        return fontWeight;
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AndroidFontResolveInterceptor(fontWeightAdjustment=").append(this.fontWeightAdjustment).append(')').toString();
    }
}
