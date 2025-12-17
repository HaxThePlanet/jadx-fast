package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B1\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0016\u0010\u0018\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u000fJ\u0016\u0010\u001a\u001a\u00020\tHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\u0008\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000fR\u0019\u0010\u0008\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006'", d2 = {"Landroidx/compose/ui/text/font/TypefaceRequest;", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resourceLoaderCacheKey", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;IILjava/lang/Object;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontStyle-_-LCdwA", "()I", "I", "getFontSynthesis-GVVA2EU", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getResourceLoaderCacheKey", "()Ljava/lang/Object;", "component1", "component2", "component3", "component3-_-LCdwA", "component4", "component4-GVVA2EU", "component5", "copy", "copy-e1PVR60", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;IILjava/lang/Object;)Landroidx/compose/ui/text/font/TypefaceRequest;", "equals", "", "other", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TypefaceRequest {

    public static final int $stable = 8;
    private final androidx.compose.ui.text.font.FontFamily fontFamily;
    private final int fontStyle;
    private final int fontSynthesis;
    private final androidx.compose.ui.text.font.FontWeight fontWeight;
    private final Object resourceLoaderCacheKey;
    static {
        final int i = 8;
    }

    private TypefaceRequest(androidx.compose.ui.text.font.FontFamily fontFamily, androidx.compose.ui.text.font.FontWeight fontWeight, int fontStyle, int fontSynthesis, Object resourceLoaderCacheKey) {
        super();
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.fontStyle = fontStyle;
        this.fontSynthesis = fontSynthesis;
        this.resourceLoaderCacheKey = resourceLoaderCacheKey;
    }

    public TypefaceRequest(androidx.compose.ui.text.font.FontFamily fontFamily, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, int i4, Object object5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(fontFamily, fontWeight2, i3, i4, object5);
    }

    public static androidx.compose.ui.text.font.TypefaceRequest copy-e1PVR60$default(androidx.compose.ui.text.font.TypefaceRequest typefaceRequest, androidx.compose.ui.text.font.FontFamily fontFamily2, androidx.compose.ui.text.font.FontWeight fontWeight3, int i4, int i5, Object object6, int i7, Object object8) {
        androidx.compose.ui.text.font.FontFamily obj1;
        androidx.compose.ui.text.font.FontWeight obj2;
        int obj3;
        int obj4;
        Object obj5;
        if (i7 & 1 != 0) {
            obj1 = typefaceRequest.fontFamily;
        }
        if (i7 & 2 != 0) {
            obj2 = typefaceRequest.fontWeight;
        }
        if (i7 & 4 != 0) {
            obj3 = typefaceRequest.fontStyle;
        }
        if (i7 & 8 != 0) {
            obj4 = typefaceRequest.fontSynthesis;
        }
        if (i7 &= 16 != 0) {
            obj5 = typefaceRequest.resourceLoaderCacheKey;
        }
        return typefaceRequest.copy-e1PVR60(obj1, obj2, obj3, obj4, obj5);
    }

    public final androidx.compose.ui.text.font.FontFamily component1() {
        return this.fontFamily;
    }

    public final androidx.compose.ui.text.font.FontWeight component2() {
        return this.fontWeight;
    }

    public final int component3-_-LCdwA() {
        return this.fontStyle;
    }

    public final int component4-GVVA2EU() {
        return this.fontSynthesis;
    }

    public final Object component5() {
        return this.resourceLoaderCacheKey;
    }

    public final androidx.compose.ui.text.font.TypefaceRequest copy-e1PVR60(androidx.compose.ui.text.font.FontFamily fontFamily, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, int i4, Object object5) {
        TypefaceRequest typefaceRequest = new TypefaceRequest(fontFamily, fontWeight2, i3, i4, object5, 0);
        return typefaceRequest;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof TypefaceRequest == null) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.fontFamily, obj.fontFamily)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.fontWeight, obj.fontWeight)) {
            return i2;
        }
        if (!FontStyle.equals-impl0(this.fontStyle, obj.fontStyle)) {
            return i2;
        }
        if (!FontSynthesis.equals-impl0(this.fontSynthesis, obj.fontSynthesis)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.resourceLoaderCacheKey, obj.resourceLoaderCacheKey)) {
            return i2;
        }
        return i;
    }

    public final androidx.compose.ui.text.font.FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final int getFontStyle-_-LCdwA() {
        return this.fontStyle;
    }

    public final int getFontSynthesis-GVVA2EU() {
        return this.fontSynthesis;
    }

    public final androidx.compose.ui.text.font.FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final Object getResourceLoaderCacheKey() {
        return this.resourceLoaderCacheKey;
    }

    public int hashCode() {
        int i2;
        int i;
        if (this.fontFamily == null) {
            i2 = i;
        } else {
            i2 = this.fontFamily.hashCode();
        }
        if (this.resourceLoaderCacheKey == null) {
        } else {
            i = this.resourceLoaderCacheKey.hashCode();
        }
        return i5 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TypefaceRequest(fontFamily=").append(this.fontFamily).append(", fontWeight=").append(this.fontWeight).append(", fontStyle=").append(FontStyle.toString-impl(this.fontStyle)).append(", fontSynthesis=").append(FontSynthesis.toString-impl(this.fontSynthesis)).append(", resourceLoaderCacheKey=").append(this.resourceLoaderCacheKey).append(')').toString();
    }
}
