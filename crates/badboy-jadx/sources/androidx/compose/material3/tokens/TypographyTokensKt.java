package androidx.compose.material3.tokens;

import androidx.compose.material3.internal.DefaultPlatformTextStyle_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyle.Companion;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.LineHeightStyle.Alignment;
import androidx.compose.ui.text.style.LineHeightStyle.Alignment.Companion;
import androidx.compose.ui.text.style.LineHeightStyle.Trim;
import androidx.compose.ui.text.style.LineHeightStyle.Trim.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"DefaultLineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefaultLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "DefaultTextStyle", "Landroidx/compose/ui/text/TextStyle;", "getDefaultTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TypographyTokensKt {

    private static final LineHeightStyle DefaultLineHeightStyle;
    private static final TextStyle DefaultTextStyle;
    static {
        final int i2 = 0;
        LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.Companion.getCenter-PIaL0Z0(), LineHeightStyle.Trim.Companion.getNone-EVpEnUU(), i2);
        TypographyTokensKt.DefaultLineHeightStyle = lineHeightStyle;
        TypographyTokensKt.DefaultTextStyle = TextStyle.copy-p1EtxEg$default(TextStyle.Companion.getDefault(), 0, i2, 0, obj5, 0, 0, 0, 0, 0, 0, obj12, 0, 0, 0, 0, obj17, 0, 0, 0, 0, 0, 0, obj24, 0, DefaultPlatformTextStyle_androidKt.defaultPlatformTextStyle(), TypographyTokensKt.DefaultLineHeightStyle);
    }

    public static final LineHeightStyle getDefaultLineHeightStyle() {
        return TypographyTokensKt.DefaultLineHeightStyle;
    }

    public static final TextStyle getDefaultTextStyle() {
        return TypographyTokensKt.DefaultTextStyle;
    }
}
