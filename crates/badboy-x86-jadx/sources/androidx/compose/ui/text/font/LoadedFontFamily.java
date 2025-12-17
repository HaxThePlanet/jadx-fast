package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000f", d2 = {"Landroidx/compose/ui/text/font/LoadedFontFamily;", "Landroidx/compose/ui/text/font/FontFamily;", "typeface", "Landroidx/compose/ui/text/font/Typeface;", "(Landroidx/compose/ui/text/font/Typeface;)V", "getTypeface", "()Landroidx/compose/ui/text/font/Typeface;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LoadedFontFamily extends androidx.compose.ui.text.font.FontFamily {

    public static final int $stable;
    private final androidx.compose.ui.text.font.Typeface typeface;
    static {
    }

    public LoadedFontFamily(androidx.compose.ui.text.font.Typeface typeface) {
        super(1, 0);
        this.typeface = typeface;
    }

    @Override // androidx.compose.ui.text.font.FontFamily
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof LoadedFontFamily) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.typeface, obj.typeface)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.font.FontFamily
    public final androidx.compose.ui.text.font.Typeface getTypeface() {
        return this.typeface;
    }

    @Override // androidx.compose.ui.text.font.FontFamily
    public int hashCode() {
        return this.typeface.hashCode();
    }

    @Override // androidx.compose.ui.text.font.FontFamily
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("LoadedFontFamily(typeface=").append(this.typeface).append(')').toString();
    }
}
