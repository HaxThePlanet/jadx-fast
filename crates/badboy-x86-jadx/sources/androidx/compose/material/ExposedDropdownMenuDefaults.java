package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001e\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0008H\u0007¢\u0006\u0002\u0010\tJî\u0001\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\r2\u0008\u0008\u0002\u0010 \u001a\u00020\r2\u0008\u0008\u0002\u0010!\u001a\u00020\r2\u0008\u0008\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$Jî\u0001\u0010%\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\r2\u0008\u0008\u0002\u0010&\u001a\u00020\r2\u0008\u0008\u0002\u0010'\u001a\u00020\r2\u0008\u0008\u0002\u0010(\u001a\u00020\r2\u0008\u0008\u0002\u0010)\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\r2\u0008\u0008\u0002\u0010 \u001a\u00020\r2\u0008\u0008\u0002\u0010!\u001a\u00020\r2\u0008\u0008\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008*\u0010$\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006+", d2 = {"Landroidx/compose/material/ExposedDropdownMenuDefaults;", "", "()V", "TrailingIcon", "", "expanded", "", "onIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-DlUQjxs", "(JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-DlUQjxs", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExposedDropdownMenuDefaults {

    public static final int $stable;
    public static final androidx.compose.material.ExposedDropdownMenuDefaults INSTANCE;
    static {
        ExposedDropdownMenuDefaults exposedDropdownMenuDefaults = new ExposedDropdownMenuDefaults();
        ExposedDropdownMenuDefaults.INSTANCE = exposedDropdownMenuDefaults;
    }

    public final void TrailingIcon(boolean expanded, Function0<Unit> onIconClick, Composer $composer, int $changed, int i5) {
        int traceInProgress2;
        int $dirty;
        boolean $dirty2;
        boolean traceInProgress;
        boolean z;
        int i4;
        Object obj;
        int clearAndSetSemantics;
        int i6;
        int i;
        int i2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i7;
        int i3;
        traceInProgress2 = 1752693020;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(TrailingIcon)298@11657L314,298@11577L394:ExposedDropdownMenu.android.kt#jmzs0o");
        $dirty = $changed;
        if (i5 & 1 != 0) {
            $dirty |= 6;
        } else {
            if ($changed & 6 == 0) {
                i4 = restartGroup.changed(expanded) ? 4 : 2;
                $dirty |= i4;
            }
        }
        int i10 = i5 & 2;
        if (i10 != 0) {
            $dirty |= 48;
        } else {
            if ($changed & 48 == 0) {
                i6 = restartGroup.changedInstance(onIconClick) ? 32 : 16;
                $dirty |= i6;
            }
        }
        final int i13 = $dirty;
        if (i13 & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (i10 != 0) {
                    obj = $dirty2;
                } else {
                    obj = onIconClick;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i13, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.android.kt:293)");
                }
                ExposedDropdownMenuDefaults.TrailingIcon.3 anon = new ExposedDropdownMenuDefaults.TrailingIcon.3(expanded);
                IconButtonKt.IconButton(obj, SemanticsModifierKt.clearAndSetSemantics((Modifier)Modifier.Companion, (Function1)ExposedDropdownMenuDefaults.TrailingIcon.2.INSTANCE), false, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-689144648, true, anon, restartGroup, 54), restartGroup, i9 | 24576, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj = onIconClick;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ExposedDropdownMenuDefaults.TrailingIcon.4(this, expanded, obj, $changed, i5);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final androidx.compose.material.TextFieldColors outlinedTextFieldColors-DlUQjxs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long focusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i27) {
        int disabled4;
        boolean traceInProgress;
        int copy-wmQWz5c$default3;
        int iNSTANCE;
        int companion;
        int colors2;
        int colors5;
        int high;
        int disabled3;
        int disabled5;
        androidx.compose.material.Colors colors3;
        int i11;
        float disabled2;
        int i13;
        int high3;
        int disabled;
        int colors;
        int high2;
        int medium;
        int disabled6;
        int colors4;
        int medium2;
        int copy-wmQWz5c$default;
        int i16;
        int i22;
        int i6;
        int i32;
        long l5;
        Object consume2;
        String copy-wmQWz5c$default2;
        Object consume;
        long l2;
        long unbox-impl;
        long transparent-0d7_KjU;
        long cursorColor2;
        float floatValue;
        int i;
        long errorCursorColor2;
        int i3;
        int i23;
        long focusedBorderColor2;
        int i4;
        int i35;
        long unfocusedBorderColor3;
        long errorBorderColor2;
        int i37;
        int i9;
        long unfocusedBorderColor2;
        int i28;
        int i2;
        long l3;
        int i8;
        long leadingIconColor2;
        long leadingIconColor4;
        int i17;
        long leadingIconColor3;
        int i33;
        int i29;
        long errorLeadingIconColor2;
        int i14;
        long trailingIconColor2;
        long trailingIconColor3;
        int i26;
        long focusedTrailingIconColor2;
        int i18;
        int i25;
        long trailingIconColor4;
        int i12;
        int i30;
        long errorTrailingIconColor2;
        int i19;
        long l4;
        long focusedLabelColor2;
        int i20;
        long unfocusedLabelColor2;
        long unfocusedLabelColor4;
        int i31;
        int i24;
        long unfocusedLabelColor3;
        int i15;
        int i5;
        long errorLabelColor2;
        int i21;
        long placeholderColor2;
        int i36;
        long l;
        int i34;
        int i10;
        int i7;
        long obj55;
        float obj57;
        int obj58;
        int obj59;
        int obj60;
        int obj61;
        int obj62;
        final Composer composer = obj99;
        int i38 = obj103;
        int i39 = 1841636861;
        ComposerKt.sourceInformationMarkerStart(composer, i39, "C(outlinedTextFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)460@20635L7,460@20666L7,461@20739L8,463@20845L6,464@20909L6,466@20985L6,466@21026L4,468@21097L6,468@21140L8,469@21235L8,470@21294L6,472@21368L6,473@21515L8,476@21644L6,478@21774L6,478@21815L4,479@21909L8,480@21974L6,482@22049L6,482@22090L4,483@22148L6,483@22183L6,484@22266L8,485@22324L6,486@22386L6,486@22421L6,487@22507L8:ExposedDropdownMenu.android.kt#jmzs0o");
        if (i38 & 1 != 0) {
            int i48 = 6;
            int i49 = 0;
            int i51 = 2023513938;
            copy-wmQWz5c$default2 = "CC:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer, i51, copy-wmQWz5c$default2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            i22 = 6;
            int i50 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i51, copy-wmQWz5c$default2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            l5 = copy-wmQWz5c$default3;
        } else {
            l5 = textColor;
        }
        i6 = 6;
        if (i38 & 2 != 0) {
            l2 = copy-wmQWz5c$default2;
        } else {
            l2 = backgroundColor;
        }
        if (i38 & 4 != 0) {
            l4 = transparent-0d7_KjU;
        } else {
            l4 = errorCursorColor;
        }
        if (i38 & 8 != 0) {
            cursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i6).getPrimary-0d7_KjU();
        } else {
            cursorColor2 = unfocusedBorderColor;
        }
        if (i38 & 16 != 0) {
            errorCursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i6).getError-0d7_KjU();
        } else {
            errorCursorColor2 = errorBorderColor;
        }
        if (i38 & 32 != 0) {
            focusedBorderColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i6).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i6), 0, 0, 0, 14);
        } else {
            focusedBorderColor2 = disabledLeadingIconColor;
        }
        if (i38 & 64 != 0) {
            unfocusedBorderColor3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i6).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i6), 0, 0, 0, 14);
        } else {
            unfocusedBorderColor3 = trailingIconColor;
        }
        if (i38 & 128 != 0) {
            obj55 = unfocusedBorderColor3;
            unfocusedBorderColor2 = obj55;
            l3 = unfocusedBorderColor3;
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor3;
            l3 = disabledTrailingIconColor;
        }
        if (i38 & 256 != 0) {
            errorBorderColor2 = MaterialTheme.INSTANCE.getColors(composer, i6).getError-0d7_KjU();
        } else {
            errorBorderColor2 = focusedLabelColor;
        }
        if (i38 & 512 != 0) {
            leadingIconColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i6).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            leadingIconColor2 = disabledLabelColor;
        }
        if (i38 & 1024 != 0) {
            obj55 = leadingIconColor2;
            leadingIconColor4 = Color.copy-wmQWz5c$default(obj55, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i6), 0, 0, 0, 14);
            leadingIconColor3 = obj55;
        } else {
            leadingIconColor3 = leadingIconColor2;
            leadingIconColor4 = placeholderColor;
        }
        errorLeadingIconColor2 = i38 & 2048 != 0 ? leadingIconColor3 : $composer;
        if (i38 & 4096 != 0) {
            trailingIconColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i6).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            trailingIconColor2 = $changed1;
        }
        if (i38 & 8192 != 0) {
            focusedTrailingIconColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i6).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i6), 0, 0, 0, 14);
        } else {
            focusedTrailingIconColor2 = i27;
        }
        if (i38 & 16384 != 0) {
            obj55 = trailingIconColor2;
            trailingIconColor3 = Color.copy-wmQWz5c$default(obj55, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i6), 0, 0, 0, 14);
            trailingIconColor4 = obj55;
        } else {
            trailingIconColor4 = trailingIconColor2;
            trailingIconColor3 = obj83;
        }
        if (i41 &= i38 != 0) {
            errorTrailingIconColor2 = MaterialTheme.INSTANCE.getColors(composer, i6).getError-0d7_KjU();
        } else {
            errorTrailingIconColor2 = obj85;
        }
        if (i42 &= i38 != 0) {
            focusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i6).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i6), 0, 0, 0, 14);
        } else {
            focusedLabelColor2 = obj87;
        }
        if (i43 &= i38 != 0) {
            unfocusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i6).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i6), 0, 0, 0, 14);
        } else {
            unfocusedLabelColor2 = obj89;
        }
        if (i44 &= i38 != 0) {
            obj55 = unfocusedLabelColor2;
            unfocusedLabelColor4 = Color.copy-wmQWz5c$default(obj55, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i6), 0, 0, 0, 14);
            unfocusedLabelColor3 = obj55;
        } else {
            unfocusedLabelColor3 = unfocusedLabelColor2;
            unfocusedLabelColor4 = obj91;
        }
        if (i45 &= i38 != 0) {
            errorLabelColor2 = MaterialTheme.INSTANCE.getColors(composer, i6).getError-0d7_KjU();
        } else {
            errorLabelColor2 = obj93;
        }
        if (i46 &= i38 != 0) {
            placeholderColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i6).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i6), 0, 0, 0, 14);
        } else {
            placeholderColor2 = obj95;
        }
        if (i38 &= copy-wmQWz5c$default != 0) {
            l = copy-wmQWz5c$default;
        } else {
            l = obj97;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i39, obj100, obj101, "androidx.compose.material.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:489)");
        } else {
            i16 = obj100;
            i32 = obj101;
        }
        long l7 = l5;
        long trailingIconColor6 = trailingIconColor3;
        long disabledTrailingIconColor2 = l10;
        DefaultTextFieldForExposedDropdownMenusColors textColor2 = new DefaultTextFieldForExposedDropdownMenusColors(l7, copy-wmQWz5c$default2, l2, unbox-impl, cursorColor2, floatValue, errorCursorColor2, i3, focusedBorderColor2, i4, unfocusedBorderColor2, i37, errorBorderColor2, i28, l3, i8, leadingIconColor3, obj23, leadingIconColor4, i33, errorLeadingIconColor2, i14, disabledTrailingIconColor2, obj29, focusedTrailingIconColor2, i18, trailingIconColor6, i12, errorTrailingIconColor2, i19, l4, obj37, focusedLabelColor2, obj39, unfocusedLabelColor3, i31, unfocusedLabelColor4, i15, errorLabelColor2, i21, placeholderColor2, obj47, l, i34, 0);
        long disabledTrailingIconColor3 = disabledTrailingIconColor2;
        long trailingIconColor5 = l12;
        long l6 = l7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (TextFieldColors)textColor2;
    }

    public final androidx.compose.material.TextFieldColors textFieldColors-DlUQjxs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long focusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i27) {
        int disabled4;
        boolean traceInProgress;
        int copy-wmQWz5c$default3;
        int iNSTANCE;
        int colors;
        int colors3;
        int colors5;
        int high3;
        int i14;
        int disabled2;
        androidx.compose.material.Colors colors6;
        int i34;
        float disabled3;
        int i36;
        int high2;
        int disabled;
        int colors4;
        int high;
        int medium2;
        int disabled5;
        int colors2;
        int medium;
        int copy-wmQWz5c$default2;
        int i11;
        int i;
        int i5;
        int i8;
        long l2;
        Object consume;
        String copy-wmQWz5c$default4;
        Object consume2;
        long l;
        long unbox-impl;
        long copy-wmQWz5c$default;
        long cursorColor2;
        float floatValue;
        int i2;
        long errorCursorColor2;
        int i4;
        int i15;
        long focusedIndicatorColor2;
        int i28;
        int i25;
        long unfocusedIndicatorColor3;
        long errorIndicatorColor2;
        int i29;
        int i30;
        long unfocusedIndicatorColor2;
        int i37;
        int i17;
        long l5;
        int i24;
        long leadingIconColor3;
        long leadingIconColor2;
        int i10;
        long leadingIconColor4;
        int i31;
        int i12;
        long errorLeadingIconColor2;
        int i35;
        long trailingIconColor2;
        long trailingIconColor3;
        int i7;
        long focusedTrailingIconColor2;
        int i18;
        int i21;
        long trailingIconColor4;
        int i16;
        int i9;
        long errorTrailingIconColor2;
        int i38;
        long l3;
        long focusedLabelColor2;
        int i19;
        long unfocusedLabelColor4;
        long unfocusedLabelColor3;
        int i23;
        int i22;
        long unfocusedLabelColor2;
        int i6;
        int i26;
        long errorLabelColor2;
        int i3;
        long placeholderColor2;
        int i13;
        long l4;
        int i32;
        int i20;
        int i33;
        long obj55;
        float obj57;
        int obj58;
        int obj59;
        int obj60;
        int obj61;
        int obj62;
        final Composer composer = obj99;
        int i39 = obj103;
        int i40 = 969536191;
        ComposerKt.sourceInformationMarkerStart(composer, i40, "C(textFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)357@14650L7,357@14681L7,358@14754L8,360@14824L6,361@14935L6,362@14999L6,364@15078L6,364@15119L4,366@15193L6,369@15393L8,370@15455L6,372@15529L6,373@15676L8,376@15805L6,378@15935L6,378@15976L4,379@16070L8,380@16135L6,382@16210L6,382@16251L4,383@16309L6,383@16344L6,384@16427L8,385@16485L6,386@16547L6,386@16582L6,387@16668L8:ExposedDropdownMenu.android.kt#jmzs0o");
        if (i39 & 1 != 0) {
            int i49 = 6;
            int i50 = 0;
            int i52 = 2023513938;
            copy-wmQWz5c$default4 = "CC:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer, i52, copy-wmQWz5c$default4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            i = 6;
            int i51 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i52, copy-wmQWz5c$default4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            l2 = copy-wmQWz5c$default3;
        } else {
            l2 = textColor;
        }
        i5 = 6;
        if (i39 & 2 != 0) {
            l = copy-wmQWz5c$default4;
        } else {
            l = backgroundColor;
        }
        if (i39 & 4 != 0) {
            l3 = copy-wmQWz5c$default;
        } else {
            l3 = errorCursorColor;
        }
        if (i39 & 8 != 0) {
            cursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i5).getPrimary-0d7_KjU();
        } else {
            cursorColor2 = unfocusedIndicatorColor;
        }
        if (i39 & 16 != 0) {
            errorCursorColor2 = MaterialTheme.INSTANCE.getColors(composer, i5).getError-0d7_KjU();
        } else {
            errorCursorColor2 = errorIndicatorColor;
        }
        if (i39 & 32 != 0) {
            focusedIndicatorColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i5).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i5), 0, 0, 0, 14);
        } else {
            focusedIndicatorColor2 = disabledLeadingIconColor;
        }
        if (i39 & 64 != 0) {
            unfocusedIndicatorColor3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i5).getOnSurface-0d7_KjU(), disabledTextColor, 1054280253, 0, 0, 0, 14);
        } else {
            unfocusedIndicatorColor3 = trailingIconColor;
        }
        if (i39 & 128 != 0) {
            obj55 = unfocusedIndicatorColor3;
            unfocusedIndicatorColor2 = obj55;
            l5 = unfocusedIndicatorColor3;
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor3;
            l5 = disabledTrailingIconColor;
        }
        if (i39 & 256 != 0) {
            errorIndicatorColor2 = MaterialTheme.INSTANCE.getColors(composer, i5).getError-0d7_KjU();
        } else {
            errorIndicatorColor2 = focusedLabelColor;
        }
        if (i39 & 512 != 0) {
            leadingIconColor3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i5).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            leadingIconColor3 = disabledLabelColor;
        }
        if (i39 & 1024 != 0) {
            obj55 = leadingIconColor3;
            leadingIconColor2 = Color.copy-wmQWz5c$default(obj55, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i5), 0, 0, 0, 14);
            leadingIconColor4 = obj55;
        } else {
            leadingIconColor4 = leadingIconColor3;
            leadingIconColor2 = placeholderColor;
        }
        errorLeadingIconColor2 = i39 & 2048 != 0 ? leadingIconColor4 : $composer;
        if (i39 & 4096 != 0) {
            trailingIconColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i5).getOnSurface-0d7_KjU(), disabledTextColor, 1057635697, 0, 0, 0, 14);
        } else {
            trailingIconColor2 = $changed1;
        }
        if (i39 & 8192 != 0) {
            focusedTrailingIconColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i5).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i5), 0, 0, 0, 14);
        } else {
            focusedTrailingIconColor2 = i27;
        }
        if (i39 & 16384 != 0) {
            obj55 = trailingIconColor2;
            trailingIconColor3 = Color.copy-wmQWz5c$default(obj55, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i5), 0, 0, 0, 14);
            trailingIconColor4 = obj55;
        } else {
            trailingIconColor4 = trailingIconColor2;
            trailingIconColor3 = obj83;
        }
        if (i42 &= i39 != 0) {
            errorTrailingIconColor2 = MaterialTheme.INSTANCE.getColors(composer, i5).getError-0d7_KjU();
        } else {
            errorTrailingIconColor2 = obj85;
        }
        if (i43 &= i39 != 0) {
            focusedLabelColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i5).getPrimary-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getHigh(composer, i5), 0, 0, 0, 14);
        } else {
            focusedLabelColor2 = obj87;
        }
        if (i44 &= i39 != 0) {
            unfocusedLabelColor4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i5).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i5), 0, 0, 0, 14);
        } else {
            unfocusedLabelColor4 = obj89;
        }
        if (i45 &= i39 != 0) {
            obj55 = unfocusedLabelColor4;
            unfocusedLabelColor3 = Color.copy-wmQWz5c$default(obj55, disabledTextColor, ContentAlpha.INSTANCE.getDisabled(composer, i5), 0, 0, 0, 14);
            unfocusedLabelColor2 = obj55;
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor4;
            unfocusedLabelColor3 = obj91;
        }
        if (i46 &= i39 != 0) {
            errorLabelColor2 = MaterialTheme.INSTANCE.getColors(composer, i5).getError-0d7_KjU();
        } else {
            errorLabelColor2 = obj93;
        }
        if (i47 &= i39 != 0) {
            placeholderColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, i5).getOnSurface-0d7_KjU(), disabledTextColor, ContentAlpha.INSTANCE.getMedium(composer, i5), 0, 0, 0, 14);
        } else {
            placeholderColor2 = obj95;
        }
        if (i39 &= copy-wmQWz5c$default2 != 0) {
            l4 = copy-wmQWz5c$default2;
        } else {
            l4 = obj97;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i40, obj100, obj101, "androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:389)");
        } else {
            i11 = obj100;
            i8 = obj101;
        }
        long l7 = l2;
        long trailingIconColor6 = trailingIconColor3;
        long disabledTrailingIconColor2 = l10;
        DefaultTextFieldForExposedDropdownMenusColors textColor2 = new DefaultTextFieldForExposedDropdownMenusColors(l7, copy-wmQWz5c$default4, l, unbox-impl, cursorColor2, floatValue, errorCursorColor2, i4, focusedIndicatorColor2, i28, unfocusedIndicatorColor2, i29, errorIndicatorColor2, i37, l5, i24, leadingIconColor4, obj23, leadingIconColor2, i31, errorLeadingIconColor2, i35, disabledTrailingIconColor2, obj29, focusedTrailingIconColor2, i18, trailingIconColor6, i16, errorTrailingIconColor2, i38, l3, obj37, focusedLabelColor2, obj39, unfocusedLabelColor2, i23, unfocusedLabelColor3, i6, errorLabelColor2, i3, placeholderColor2, obj47, l4, i32, 0);
        long disabledTrailingIconColor3 = disabledTrailingIconColor2;
        long trailingIconColor5 = l12;
        long l6 = l7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (TextFieldColors)textColor2;
    }
}
