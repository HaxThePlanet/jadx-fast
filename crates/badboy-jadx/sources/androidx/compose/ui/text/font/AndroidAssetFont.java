package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0010¢\u0006\u0002\u0008\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J\u0008\u0010\u001e\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011¨\u0006\u001f", d2 = {"Landroidx/compose/ui/text/font/AndroidAssetFont;", "Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "assetManager", "Landroid/content/res/AssetManager;", "path", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "(Landroid/content/res/AssetManager;Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAssetManager", "()Landroid/content/res/AssetManager;", "cacheKey", "getCacheKey", "()Ljava/lang/String;", "getPath", "doLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "doLoad$ui_text_release", "equals", "", "other", "", "hashCode", "", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidAssetFont extends androidx.compose.ui.text.font.AndroidPreloadedFont {

    public static final int $stable;
    private final AssetManager assetManager;
    private final String cacheKey;
    private final String path;
    static {
    }

    private AndroidAssetFont(AssetManager assetManager, String path, androidx.compose.ui.text.font.FontWeight weight, int style, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        int i = 0;
        super(weight, style, variationSettings, i);
        this.assetManager = assetManager;
        this.path = path;
        setTypeface$ui_text_release(doLoad$ui_text_release(i));
        StringBuilder stringBuilder = new StringBuilder();
        this.cacheKey = stringBuilder.append("asset:").append(this.path).toString();
    }

    public AndroidAssetFont(AssetManager assetManager, String string2, androidx.compose.ui.text.font.FontWeight fontWeight3, int i4, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        androidx.compose.ui.text.font.FontWeight fontWeight;
        int i;
        androidx.compose.ui.text.font.FontWeight obj10;
        int obj11;
        if (i6 & 4 != 0) {
            fontWeight = obj10;
        } else {
            fontWeight = fontWeight3;
        }
        if (i6 & 8 != 0) {
            i = obj11;
        } else {
            i = i4;
        }
        super(assetManager, string2, fontWeight, i, settings5, 0);
    }

    public AndroidAssetFont(AssetManager assetManager, String string2, androidx.compose.ui.text.font.FontWeight fontWeight3, int i4, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(assetManager, string2, fontWeight3, i4, settings5);
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public Typeface doLoad$ui_text_release(Context context) {
        return TypefaceBuilderCompat.INSTANCE.createFromAssets(this.assetManager, this.path, context, getVariationSettings());
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof AndroidAssetFont) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.path, obj.path)) {
            return i2;
        }
        if (!Intrinsics.areEqual(getVariationSettings(), (AndroidAssetFont)other.getVariationSettings())) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public final AssetManager getAssetManager() {
        return this.assetManager;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public final String getPath() {
        return this.path;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Font(assetManager, path=").append(this.path).append(", weight=").append(getWeight()).append(", style=").append(FontStyle.toString-impl(getStyle-_-LCdwA())).append(')').toString();
    }
}
