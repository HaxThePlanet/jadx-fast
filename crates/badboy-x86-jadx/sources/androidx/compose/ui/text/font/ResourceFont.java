package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B7\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0003\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ.\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJD\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\u0008\u0010!\u001a\u00020\u0003H\u0016J\u0008\u0010\"\u001a\u00020#H\u0016R$\u0010\n\u001a\u00020\u000b8WX\u0097\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0010R\u001c\u0010\u0006\u001a\u00020\u0007X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u0013\u0010\u0010R\u0013\u0010\u0008\u001a\u00020\t8\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/ui/text/font/ResourceFont;", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "(ILandroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLoadingStrategy-PKNRLFQ$annotations", "()V", "getLoadingStrategy-PKNRLFQ", "()I", "I", "getResId", "getStyle-_-LCdwA", "getVariationSettings", "()Landroidx/compose/ui/text/font/FontVariation$Settings;", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "copy", "copy-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/ResourceFont;", "copy-F3nL8kk", "(ILandroidx/compose/ui/text/font/FontWeight;IILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/ResourceFont;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResourceFont implements androidx.compose.ui.text.font.Font {

    public static final int $stable;
    private final int loadingStrategy;
    private final int resId;
    private final int style;
    private final androidx.compose.ui.text.font.FontVariation.Settings variationSettings;
    private final androidx.compose.ui.text.font.FontWeight weight;
    static {
    }

    private ResourceFont(int resId, androidx.compose.ui.text.font.FontWeight weight, int style, androidx.compose.ui.text.font.FontVariation.Settings variationSettings, int loadingStrategy) {
        super();
        this.resId = resId;
        this.weight = weight;
        this.style = style;
        this.variationSettings = variationSettings;
        this.loadingStrategy = loadingStrategy;
    }

    public ResourceFont(int i, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        androidx.compose.ui.text.font.FontWeight fontWeight;
        int i2;
        androidx.compose.ui.text.font.FontVariation.Settings set;
        int i4;
        androidx.compose.ui.text.font.FontWeight obj9;
        int obj10;
        androidx.compose.ui.text.font.FontVariation.Settings obj11;
        int obj12;
        if (i6 & 2 != 0) {
            fontWeight = obj9;
        } else {
            fontWeight = fontWeight2;
        }
        if (i6 & 4 != 0) {
            i2 = obj10;
        } else {
            i2 = i3;
        }
        if (i6 & 8 != 0) {
            set = obj11;
        } else {
            set = settings4;
        }
        if (i6 & 16 != 0) {
            i4 = obj12;
        } else {
            i4 = i5;
        }
        super(i, fontWeight, i2, set, i4, 0);
    }

    public ResourceFont(int i, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(i, fontWeight2, i3, settings4, i5);
    }

    public static androidx.compose.ui.text.font.ResourceFont copy-F3nL8kk$default(androidx.compose.ui.text.font.ResourceFont resourceFont, int i2, androidx.compose.ui.text.font.FontWeight fontWeight3, int i4, int i5, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings6, int i7, Object object8) {
        int obj1;
        androidx.compose.ui.text.font.FontWeight obj2;
        int obj3;
        int obj4;
        androidx.compose.ui.text.font.FontVariation.Settings obj5;
        androidx.compose.ui.text.font.FontVariation.Settings obj7;
        if (i7 & 1 != 0) {
            obj1 = resourceFont.resId;
        }
        if (i7 & 2 != 0) {
            obj2 = resourceFont.getWeight();
        }
        if (i7 & 4 != 0) {
            obj3 = resourceFont.getStyle-_-LCdwA();
        }
        if (i7 & 8 != 0) {
            obj4 = resourceFont.getLoadingStrategy-PKNRLFQ();
        }
        obj7 = i7 &= 16 != 0 ? obj5 : settings6;
        return resourceFont.copy-F3nL8kk(obj1, obj2, obj3, obj4, obj7);
    }

    public static androidx.compose.ui.text.font.ResourceFont copy-RetOiIg$default(androidx.compose.ui.text.font.ResourceFont resourceFont, int i2, androidx.compose.ui.text.font.FontWeight fontWeight3, int i4, int i5, Object object6) {
        int obj1;
        androidx.compose.ui.text.font.FontWeight obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = resourceFont.resId;
        }
        if (i5 & 2 != 0) {
            obj2 = resourceFont.getWeight();
        }
        if (i5 &= 4 != 0) {
            obj3 = resourceFont.getStyle-_-LCdwA();
        }
        return resourceFont.copy-RetOiIg(obj1, obj2, obj3);
    }

    public static void getLoadingStrategy-PKNRLFQ$annotations() {
    }

    @Override // androidx.compose.ui.text.font.Font
    public final androidx.compose.ui.text.font.ResourceFont copy-F3nL8kk(int resId, androidx.compose.ui.text.font.FontWeight weight, int style, int loadingStrategy, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        ResourceFont resourceFont = new ResourceFont(resId, weight, style, variationSettings, loadingStrategy, 0);
        return resourceFont;
    }

    @Override // androidx.compose.ui.text.font.Font
    public final androidx.compose.ui.text.font.ResourceFont copy-RetOiIg(int resId, androidx.compose.ui.text.font.FontWeight weight, int style) {
        return ResourceFont.copy-F3nL8kk$default(this, resId, weight, style, getLoadingStrategy-PKNRLFQ(), 0, 16, 0);
    }

    @Override // androidx.compose.ui.text.font.Font
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof ResourceFont) {
            return i2;
        }
        if (this.resId != obj.resId) {
            return i2;
        }
        if (!Intrinsics.areEqual(getWeight(), (ResourceFont)other.getWeight())) {
            return i2;
        }
        if (!FontStyle.equals-impl0(getStyle-_-LCdwA(), (ResourceFont)other.getStyle-_-LCdwA())) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.variationSettings, obj4.variationSettings)) {
            return i2;
        }
        if (!FontLoadingStrategy.equals-impl0(getLoadingStrategy-PKNRLFQ(), (ResourceFont)other.getLoadingStrategy-PKNRLFQ())) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.font.Font
    public int getLoadingStrategy-PKNRLFQ() {
        return this.loadingStrategy;
    }

    @Override // androidx.compose.ui.text.font.Font
    public final int getResId() {
        return this.resId;
    }

    @Override // androidx.compose.ui.text.font.Font
    public int getStyle-_-LCdwA() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.font.Font
    public final androidx.compose.ui.text.font.FontVariation.Settings getVariationSettings() {
        return this.variationSettings;
    }

    @Override // androidx.compose.ui.text.font.Font
    public androidx.compose.ui.text.font.FontWeight getWeight() {
        return this.weight;
    }

    @Override // androidx.compose.ui.text.font.Font
    public int hashCode() {
        return result2 += i9;
    }

    @Override // androidx.compose.ui.text.font.Font
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ResourceFont(resId=").append(this.resId).append(", weight=").append(getWeight()).append(", style=").append(FontStyle.toString-impl(getStyle-_-LCdwA())).append(", loadingStrategy=").append(FontLoadingStrategy.toString-impl(getLoadingStrategy-PKNRLFQ())).append(')').toString();
    }
}
