package com.prototype.badboy.ui.theme;

import androidx.compose.material3.Typography;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamily.Companion;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeight.Companion;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* loaded from: classes4.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Typography", "Landroidx/compose/material3/Typography;", "getTypography", "()Landroidx/compose/material3/Typography;", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TypeKt {

    private static final Typography Typography;
    static {
        final int i12 = 0;
        final int i15 = 0;
        final int i18 = 0;
        final int i21 = 0;
        TextStyle textStyle = new TextStyle(0, obj5, TextUnitKt.getSp(16), obj7, FontWeight.Companion.getNormal(), i12, 0, (FontFamily)FontFamily.Companion.getDefault(), i15, TextUnitKt.getSp(4602678819172646912L), obj14, i18, 0, i21, 0, obj19, 0, 0, 0, 0, 0, TextUnitKt.getSp(24), obj26, 0, 0, 0, 0, 0, 0, 16645977, 0);
        Typography typography = new Typography(0, 0, 0, 0, 0, 0, 0, 0, i12, textStyle, 0, i15, 0, 0, i18, 32255, i21);
        TypeKt.Typography = typography;
    }

    public static final Typography getTypography() {
        return TypeKt.Typography;
    }
}
