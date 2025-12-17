package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.icons.Icons.Filled;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.material3.tokens.FilledAutocompleteTokens;
import androidx.compose.material3.tokens.OutlinedAutocompleteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000eJ\u0082\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00122\u0008\u0008\u0002\u0010 \u001a\u00020\u00122\u0008\u0008\u0002\u0010!\u001a\u00020\u00122\u0008\u0008\u0002\u0010\"\u001a\u00020\u00122\u0008\u0008\u0002\u0010#\u001a\u00020\u00122\u0008\u0008\u0002\u0010$\u001a\u00020\u00122\u0008\u0008\u0002\u0010%\u001a\u00020\u00122\u0008\u0008\u0002\u0010&\u001a\u00020\u00122\u0008\u0008\u0002\u0010'\u001a\u00020\u00122\u0008\u0008\u0002\u0010(\u001a\u00020\u00122\u0008\u0008\u0002\u0010)\u001a\u00020\u00122\u0008\u0008\u0002\u0010*\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,J\u0084\u0003\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010-\u001a\u00020\u00122\u0008\u0008\u0002\u0010.\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010/\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00122\u0008\u0008\u0002\u00100\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00122\u0008\u0008\u0002\u0010 \u001a\u00020\u00122\u0008\u0008\u0002\u0010!\u001a\u00020\u00122\u0008\u0008\u0002\u0010\"\u001a\u00020\u00122\u0008\u0008\u0002\u0010#\u001a\u00020\u00122\u0008\u0008\u0002\u0010$\u001a\u00020\u00122\u0008\u0008\u0002\u0010%\u001a\u00020\u00122\u0008\u0008\u0002\u0010&\u001a\u00020\u00122\u0008\u0008\u0002\u0010'\u001a\u00020\u00122\u0008\u0008\u0002\u0010(\u001a\u00020\u00122\u0008\u0008\u0002\u00101\u001a\u00020\u00122\u0008\u0008\u0002\u00102\u001a\u00020\u00122\u0008\u0008\u0002\u0010*\u001a\u00020\u00122\u0008\u0008\u0002\u00103\u001a\u00020\u00122\u0008\u0008\u0002\u00104\u001a\u00020\u00122\u0008\u0008\u0002\u00105\u001a\u00020\u00122\u0008\u0008\u0002\u00106\u001a\u00020\u00122\u0008\u0008\u0002\u00107\u001a\u00020\u00122\u0008\u0008\u0002\u00108\u001a\u00020\u00122\u0008\u0008\u0002\u00109\u001a\u00020\u00122\u0008\u0008\u0002\u0010:\u001a\u00020\u00122\u0008\u0008\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=J\u0098\u0003\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010-\u001a\u00020\u00122\u0008\u0008\u0002\u0010.\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010/\u001a\u00020\u00122\u0008\u0008\u0002\u0010>\u001a\u00020\u00122\u0008\u0008\u0002\u0010?\u001a\u00020\u00122\u0008\u0008\u0002\u0010@\u001a\u00020\u00122\u0008\u0008\u0002\u00100\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00122\u0008\u0008\u0002\u0010 \u001a\u00020\u00122\u0008\u0008\u0002\u0010!\u001a\u00020\u00122\u0008\u0008\u0002\u0010\"\u001a\u00020\u00122\u0008\u0008\u0002\u0010#\u001a\u00020\u00122\u0008\u0008\u0002\u0010$\u001a\u00020\u00122\u0008\u0008\u0002\u0010%\u001a\u00020\u00122\u0008\u0008\u0002\u0010&\u001a\u00020\u00122\u0008\u0008\u0002\u0010'\u001a\u00020\u00122\u0008\u0008\u0002\u0010(\u001a\u00020\u00122\u0008\u0008\u0002\u00101\u001a\u00020\u00122\u0008\u0008\u0002\u00102\u001a\u00020\u00122\u0008\u0008\u0002\u0010*\u001a\u00020\u00122\u0008\u0008\u0002\u00103\u001a\u00020\u00122\u0008\u0008\u0002\u00104\u001a\u00020\u00122\u0008\u0008\u0002\u00105\u001a\u00020\u00122\u0008\u0008\u0002\u00106\u001a\u00020\u00122\u0008\u0008\u0002\u00107\u001a\u00020\u00122\u0008\u0008\u0002\u00108\u001a\u00020\u00122\u0008\u0008\u0002\u00109\u001a\u00020\u00122\u0008\u0008\u0002\u0010:\u001a\u00020\u00122\u0008\u0008\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008A\u0010BJ\u001a\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0001ø\u0001\u0000¢\u0006\u0004\u0008G\u0010HJ\u0082\u0002\u0010I\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010J\u001a\u00020\u00122\u0008\u0008\u0002\u0010K\u001a\u00020\u00122\u0008\u0008\u0002\u0010L\u001a\u00020\u00122\u0008\u0008\u0002\u0010M\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00122\u0008\u0008\u0002\u0010 \u001a\u00020\u00122\u0008\u0008\u0002\u0010!\u001a\u00020\u00122\u0008\u0008\u0002\u0010\"\u001a\u00020\u00122\u0008\u0008\u0002\u0010#\u001a\u00020\u00122\u0008\u0008\u0002\u0010$\u001a\u00020\u00122\u0008\u0008\u0002\u0010%\u001a\u00020\u00122\u0008\u0008\u0002\u0010&\u001a\u00020\u00122\u0008\u0008\u0002\u0010'\u001a\u00020\u00122\u0008\u0008\u0002\u0010(\u001a\u00020\u00122\u0008\u0008\u0002\u0010)\u001a\u00020\u00122\u0008\u0008\u0002\u0010*\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008N\u0010,J\u0084\u0003\u0010I\u001a\u00020\u00102\u0008\u0008\u0002\u0010-\u001a\u00020\u00122\u0008\u0008\u0002\u0010.\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010/\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00122\u0008\u0008\u0002\u00100\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010J\u001a\u00020\u00122\u0008\u0008\u0002\u0010K\u001a\u00020\u00122\u0008\u0008\u0002\u0010L\u001a\u00020\u00122\u0008\u0008\u0002\u0010M\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00122\u0008\u0008\u0002\u0010 \u001a\u00020\u00122\u0008\u0008\u0002\u0010!\u001a\u00020\u00122\u0008\u0008\u0002\u0010\"\u001a\u00020\u00122\u0008\u0008\u0002\u0010#\u001a\u00020\u00122\u0008\u0008\u0002\u0010$\u001a\u00020\u00122\u0008\u0008\u0002\u0010%\u001a\u00020\u00122\u0008\u0008\u0002\u0010&\u001a\u00020\u00122\u0008\u0008\u0002\u0010'\u001a\u00020\u00122\u0008\u0008\u0002\u0010(\u001a\u00020\u00122\u0008\u0008\u0002\u00101\u001a\u00020\u00122\u0008\u0008\u0002\u00102\u001a\u00020\u00122\u0008\u0008\u0002\u0010*\u001a\u00020\u00122\u0008\u0008\u0002\u00103\u001a\u00020\u00122\u0008\u0008\u0002\u00104\u001a\u00020\u00122\u0008\u0008\u0002\u00105\u001a\u00020\u00122\u0008\u0008\u0002\u00106\u001a\u00020\u00122\u0008\u0008\u0002\u00107\u001a\u00020\u00122\u0008\u0008\u0002\u00108\u001a\u00020\u00122\u0008\u0008\u0002\u00109\u001a\u00020\u00122\u0008\u0008\u0002\u0010:\u001a\u00020\u00122\u0008\u0008\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008O\u0010=J\u0098\u0003\u0010I\u001a\u00020\u00102\u0008\u0008\u0002\u0010-\u001a\u00020\u00122\u0008\u0008\u0002\u0010.\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010/\u001a\u00020\u00122\u0008\u0008\u0002\u0010>\u001a\u00020\u00122\u0008\u0008\u0002\u0010?\u001a\u00020\u00122\u0008\u0008\u0002\u0010@\u001a\u00020\u00122\u0008\u0008\u0002\u00100\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010J\u001a\u00020\u00122\u0008\u0008\u0002\u0010K\u001a\u00020\u00122\u0008\u0008\u0002\u0010L\u001a\u00020\u00122\u0008\u0008\u0002\u0010M\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00122\u0008\u0008\u0002\u0010 \u001a\u00020\u00122\u0008\u0008\u0002\u0010!\u001a\u00020\u00122\u0008\u0008\u0002\u0010\"\u001a\u00020\u00122\u0008\u0008\u0002\u0010#\u001a\u00020\u00122\u0008\u0008\u0002\u0010$\u001a\u00020\u00122\u0008\u0008\u0002\u0010%\u001a\u00020\u00122\u0008\u0008\u0002\u0010&\u001a\u00020\u00122\u0008\u0008\u0002\u0010'\u001a\u00020\u00122\u0008\u0008\u0002\u0010(\u001a\u00020\u00122\u0008\u0008\u0002\u00101\u001a\u00020\u00122\u0008\u0008\u0002\u00102\u001a\u00020\u00122\u0008\u0008\u0002\u0010*\u001a\u00020\u00122\u0008\u0008\u0002\u00103\u001a\u00020\u00122\u0008\u0008\u0002\u00104\u001a\u00020\u00122\u0008\u0008\u0002\u00105\u001a\u00020\u00122\u0008\u0008\u0002\u00106\u001a\u00020\u00122\u0008\u0008\u0002\u00107\u001a\u00020\u00122\u0008\u0008\u0002\u00108\u001a\u00020\u00122\u0008\u0008\u0002\u00109\u001a\u00020\u00122\u0008\u0008\u0002\u0010:\u001a\u00020\u00122\u0008\u0008\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008P\u0010BR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006Q²\u0006\n\u0010R\u001a\u00020\nX\u008a\u0084\u0002", d2 = {"Landroidx/compose/material3/ExposedDropdownMenuDefaults;", "", "()V", "ItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "TrailingIcon", "", "expanded", "", "(ZLandroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-St-qZLY", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "errorTextColor", "errorContainerColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "errorPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "outlinedTextFieldColors-tN0la-I", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "outlinedTextFieldColors-FD9MK7s", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "popupProperties", "Landroidx/compose/ui/window/PopupProperties;", "anchorType", "Landroidx/compose/material3/MenuAnchorType;", "popupProperties-pR6Bxps$material3_release", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/window/PopupProperties;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-St-qZLY", "textFieldColors-tN0la-I", "textFieldColors-FD9MK7s", "material3_release", "a11yServicesEnabled"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExposedDropdownMenuDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.ExposedDropdownMenuDefaults INSTANCE;
    private static final PaddingValues ItemContentPadding;
    static {
        ExposedDropdownMenuDefaults exposedDropdownMenuDefaults = new ExposedDropdownMenuDefaults();
        ExposedDropdownMenuDefaults.INSTANCE = exposedDropdownMenuDefaults;
        final int i2 = 0;
        ExposedDropdownMenuDefaults.ItemContentPadding = PaddingKt.PaddingValues-YgX7TsA(ExposedDropdownMenu_androidKt.access$getExposedDropdownMenuItemHorizontalPadding$p(), Dp.constructor-impl((float)i));
    }

    private static final boolean popupProperties_pR6Bxps$lambda$0(State<Boolean> $a11yServicesEnabled$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$a11yServicesEnabled$delegate.getValue().booleanValue();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final void TrailingIcon(boolean expanded, Composer $composer, int $changed) {
        int anon;
        int i3;
        int i4;
        int skipping;
        boolean traceInProgress;
        Object obj;
        int str;
        boolean z;
        androidx.compose.ui.Modifier.Companion companion;
        int i2;
        int i;
        boolean obj8;
        int obj9;
        anon = -473088613;
        final Composer restartGroup = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(TrailingIcon)886@46586L32:ExposedDropdownMenu.android.kt#uh7d8r");
        if ($changed & 6 == 0) {
            i3 = restartGroup.changed(expanded) ? 4 : 2;
            obj9 |= i3;
        }
        if ($changed & 48 == 0) {
            i4 = restartGroup.changed(this) ? 32 : 16;
            obj9 |= i4;
        }
        if (obj9 & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, obj9, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.android.kt:886)");
                }
                this.TrailingIcon(expanded, (Modifier)Modifier.Companion, restartGroup, anon | i7, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj = this;
                z = expanded;
            }
        } else {
        }
        obj8 = restartGroup.endRestartGroup();
        if (obj8 != null) {
            anon = new ExposedDropdownMenuDefaults.TrailingIcon.2(this, z, $changed);
            obj8.updateScope((Function2)anon);
        }
    }

    public final void TrailingIcon(boolean expanded, Modifier modifier, Composer $composer, int $changed, int i5) {
        int i4;
        int traceInProgress;
        int $dirty2;
        int $dirty;
        boolean z;
        int i6;
        boolean traceInProgress2;
        Object obj;
        int str;
        int i7;
        int rotate;
        int i2;
        int i3;
        int i;
        traceInProgress = -1987096744;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(TrailingIcon)520@22966L83:ExposedDropdownMenu.android.kt#uh7d8r");
        $dirty2 = $changed;
        if (i5 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if ($changed & 6 == 0) {
                i6 = restartGroup.changed(expanded) ? 4 : 2;
                $dirty2 |= i6;
            }
        }
        int i8 = i5 & 2;
        if (i8 != 0) {
            $dirty2 |= 48;
        } else {
            if ($changed & 48 == 0) {
                i7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i7;
            }
        }
        final int i9 = $dirty2;
        if (i9 & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (i8 != 0) {
                    $dirty = Modifier.Companion;
                } else {
                    $dirty = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i9, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.android.kt:519)");
                }
                i4 = expanded ? 1127481344 : 0;
                IconKt.Icon-ww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), 0, RotateKt.rotate($dirty, i4), 0, obj7, restartGroup, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                obj = modifier;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ExposedDropdownMenuDefaults.TrailingIcon.1(this, expanded, obj, $changed, i5);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public final PaddingValues getItemContentPadding() {
        return ExposedDropdownMenuDefaults.ItemContentPadding;
    }

    public final androidx.compose.material3.TextFieldColors outlinedTextFieldColors-FD9MK7s(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, TextSelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i45, int i46) {
        int textFieldDisabledLeadingIconOpacity;
        int textFieldErrorLeadingIconColor;
        int textFieldFocusTrailingIconColor;
        int textFieldTrailingIconColor;
        int textFieldDisabledTrailingIconOpacity;
        int textFieldErrorTrailingIconColor;
        int fieldFocusLabelTextColor;
        int fieldLabelTextColor;
        int fieldDisabledLabelTextOpacity;
        int fieldErrorLabelTextColor;
        int fieldSupportingTextColor6;
        int fieldSupportingTextColor7;
        float fieldDisabledSupportingTextOpacity2;
        int fieldSupportingTextColor3;
        int fieldSupportingTextColor5;
        int fieldSupportingTextColor8;
        float fieldDisabledSupportingTextOpacity3;
        int fieldSupportingTextColor4;
        int fieldSupportingTextColor;
        int fieldSupportingTextColor2;
        int fieldDisabledSupportingTextOpacity;
        int value;
        boolean traceInProgress;
        int i37;
        Object selectionColors2;
        int selectionColors3;
        int textFieldFocusLeadingIconColor;
        int textFieldLeadingIconColor;
        int i28;
        int i40;
        int i19;
        int i32;
        int i16;
        int i14;
        int fieldFocusInputTextColor;
        int fieldInputTextColor;
        int iNSTANCE;
        int fieldErrorInputTextColor;
        int companion4;
        int companion3;
        int companion2;
        int companion;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens textFieldCaretColor;
        int textFieldErrorFocusCaretColor;
        int localTextSelectionColors;
        int textFieldFocusOutlineColor;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens textFieldOutlineColor;
        long disabledBorderColor2;
        int str;
        int i25;
        long focusedTextColor2;
        long unfocusedTextColor2;
        long disabledTextColor2;
        float fieldDisabledInputTextOpacity;
        long errorTextColor2;
        int i8;
        int i4;
        long focusedContainerColor2;
        int i26;
        int i20;
        long unfocusedContainerColor2;
        int i29;
        long disabledContainerColor2;
        long errorContainerColor2;
        long cursorColor2;
        long errorCursorColor2;
        int i24;
        long value4;
        int i12;
        long value6;
        long l3;
        long value7;
        long value8;
        int i30;
        long focusedLeadingIconColor2;
        int i2;
        int i36;
        long unfocusedLeadingIconColor2;
        int i21;
        long disabledLeadingIconColor2;
        int i23;
        long value5;
        int i22;
        int i18;
        long focusedTrailingIconColor2;
        int i34;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        int i33;
        long value3;
        int i27;
        int i35;
        long focusedLabelColor2;
        int i31;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        int i11;
        long value9;
        int i17;
        int i3;
        long focusedPlaceholderColor2;
        int i5;
        long unfocusedPlaceholderColor2;
        long disabledPlaceholderColor2;
        int i;
        long value2;
        int i6;
        int copy-wmQWz5c$default;
        int i39;
        long l2;
        long l5;
        long l7;
        int i9;
        int i7;
        long l8;
        int i10;
        long l4;
        long l9;
        long l;
        int i38;
        int i15;
        long l6;
        int i13;
        long obj98;
        long obj99;
        float obj100;
        int obj101;
        int obj102;
        int obj103;
        int obj104;
        int obj105;
        int obj106;
        Composer composer = obj175;
        int i41 = obj176;
        int i42 = obj177;
        final int i43 = obj178;
        int i44 = obj180;
        i37 = obj181;
        ComposerKt.sourceInformationMarkerStart(composer, -1567195085, "C(outlinedTextFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,29,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)734@37917L5,735@38007L5,737@38116L5,740@38308L5,745@38624L5,746@38722L5,747@38801L7,748@38900L5,749@38994L5,751@39107L5,754@39305L5,756@39423L5,758@39538L5,760@39660L5,764@39883L5,766@40003L5,768@40120L5,770@40244L5,774@40470L5,775@40564L5,776@40655L5,778@40765L5,781@40958L5,782@41058L5,784@41172L5,786@41293L5,789@41497L5,790@41592L5,791@41689L5,793@41805L5,796@42004L5,797@42099L5,798@42196L5,800@42312L5,803@42511L5,805@42577L2206:ExposedDropdownMenu.android.kt#uh7d8r");
        str = 6;
        if (i44 & 1 != 0) {
            focusedTextColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, str);
        } else {
            focusedTextColor2 = focusedTextColor;
        }
        if (i44 & 2 != 0) {
            unfocusedTextColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, str);
        } else {
            unfocusedTextColor2 = disabledTextColor;
        }
        if (i44 & 4 != 0) {
            disabledTextColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, str), obj14, OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0, 0, 0, 14);
        } else {
            disabledTextColor2 = focusedContainerColor;
        }
        if (i44 & 8 != 0) {
            errorTextColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, str);
        } else {
            errorTextColor2 = disabledContainerColor;
        }
        if (i44 & 16 != 0) {
            focusedContainerColor2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            focusedContainerColor2 = cursorColor;
        }
        if (i44 & 32 != 0) {
            unfocusedContainerColor2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            unfocusedContainerColor2 = selectionColors;
        }
        if (i44 & 64 != 0) {
            disabledContainerColor2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            disabledContainerColor2 = unfocusedBorderColor;
        }
        if (i44 & 128 != 0) {
            errorContainerColor2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            errorContainerColor2 = errorBorderColor;
        }
        if (i44 & 256 != 0) {
            cursorColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, str);
        } else {
            cursorColor2 = unfocusedLeadingIconColor;
        }
        if (i44 & 512 != 0) {
            errorCursorColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, str);
        } else {
            errorCursorColor2 = errorLeadingIconColor;
        }
        if (i44 & 1024 != 0) {
            i24 = 0;
            i12 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            selectionColors2 = composer.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            selectionColors2 = unfocusedTrailingIconColor;
        }
        if (i44 & 2048 != 0) {
            value4 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer, 6);
        } else {
            i25 = 6;
            value4 = disabledTrailingIconColor;
        }
        if (i44 & 4096 != 0) {
            l3 = value6;
        } else {
            l3 = focusedLabelColor;
        }
        if (i44 & 8192 != 0) {
            disabledBorderColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer, i25), unfocusedTextColor, OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), 0, 0, 0, 14);
        } else {
            disabledBorderColor2 = disabledLabelColor;
        }
        if (i44 & 16384 != 0) {
            value8 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer, 6);
        } else {
            textFieldDisabledLeadingIconOpacity = 6;
            value8 = focusedPlaceholderColor;
        }
        if (obj180 & i97 != 0) {
            focusedLeadingIconColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, textFieldDisabledLeadingIconOpacity);
        } else {
            focusedLeadingIconColor2 = disabledPlaceholderColor;
        }
        if (obj180 & i98 != 0) {
            unfocusedLeadingIconColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, textFieldDisabledLeadingIconOpacity);
        } else {
            unfocusedLeadingIconColor2 = focusedPrefixColor;
        }
        if (obj180 & i99 != 0) {
            disabledLeadingIconColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, textFieldDisabledLeadingIconOpacity), obj100, OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0, 0, 0, 14);
        } else {
            disabledLeadingIconColor2 = disabledPrefixColor;
        }
        if (obj180 & i47 != 0) {
            value5 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i40 = 6;
            value5 = focusedSuffixColor;
        }
        if (obj180 & i48 != 0) {
            focusedTrailingIconColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i40);
        } else {
            focusedTrailingIconColor2 = disabledSuffixColor;
        }
        if (obj180 & i49 != 0) {
            unfocusedTrailingIconColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i40);
        } else {
            unfocusedTrailingIconColor2 = $composer;
        }
        if (obj180 & i50 != 0) {
            disabledTrailingIconColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, i40), obj100, OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0, 0, 0, 14);
        } else {
            disabledTrailingIconColor2 = $changed1;
        }
        if (obj180 & i51 != 0) {
            value3 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i19 = 6;
            value3 = $changed3;
        }
        if (obj180 & i52 != 0) {
            focusedLabelColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i19);
        } else {
            focusedLabelColor2 = i46;
        }
        if (obj180 & i53 != 0) {
            unfocusedLabelColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i19);
        } else {
            unfocusedLabelColor2 = obj145;
        }
        if (obj180 & i54 != 0) {
            disabledLabelColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, i19), obj100, OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), 0, 0, 0, 14);
        } else {
            disabledLabelColor2 = obj147;
        }
        if (obj180 & i55 != 0) {
            value9 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, 6);
        } else {
            i32 = 6;
            value9 = obj149;
        }
        if (obj180 & i56 != 0) {
            focusedPlaceholderColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i32);
        } else {
            focusedPlaceholderColor2 = obj151;
        }
        if (obj180 & i57 != 0) {
            unfocusedPlaceholderColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i32);
        } else {
            unfocusedPlaceholderColor2 = obj153;
        }
        if (obj180 & i58 != 0) {
            disabledPlaceholderColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i32), obj100, OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0, 0, 0, 14);
        } else {
            disabledPlaceholderColor2 = obj155;
        }
        if (obj180 & i59 != 0) {
            value2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i16 = 6;
            value2 = obj157;
        }
        if (i37 & 1 != 0) {
            l2 = copy-wmQWz5c$default;
        } else {
            l2 = obj159;
        }
        if (i37 & 2 != 0) {
            l5 = copy-wmQWz5c$default;
        } else {
            l5 = obj161;
        }
        if (i37 & 4 != 0) {
            l7 = copy-wmQWz5c$default;
        } else {
            l7 = obj163;
        }
        if (i37 & 8 != 0) {
            l8 = copy-wmQWz5c$default;
        } else {
            i14 = 6;
            l8 = obj165;
        }
        if (i37 & 16 != 0) {
            l4 = copy-wmQWz5c$default;
        } else {
            l4 = obj167;
        }
        if (i37 & 32 != 0) {
            l9 = copy-wmQWz5c$default;
        } else {
            l9 = obj169;
        }
        if (i37 & 64 != 0) {
            l = copy-wmQWz5c$default;
        } else {
            l = obj171;
        }
        if (i37 & 128 != 0) {
            l6 = value;
        } else {
            l6 = obj173;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1567195085, i41, i42, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:805)");
        }
        int i103 = 57344;
        int i138 = 458752;
        int i140 = 3670016;
        int i142 = 29360128;
        int i145 = 234881024;
        int i149 = 1879048192;
        obj99 = i103;
        i94 |= i132;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj175);
        return OutlinedTextFieldDefaults.INSTANCE.colors-0hiis_0(focusedTextColor2, i43, unfocusedTextColor2, i95, disabledTextColor2, disabledBorderColor2, errorTextColor2, focusedTextColor2, focusedContainerColor2, unfocusedTextColor2, unfocusedContainerColor2, disabledTextColor2, disabledContainerColor2, errorTextColor2, errorContainerColor2, focusedContainerColor2, cursorColor2, unfocusedContainerColor2, errorCursorColor2, disabledContainerColor2, selectionColors2, value4, obj24, l3, obj26, disabledBorderColor2, obj28, value8, i12, focusedLeadingIconColor2, i140, unfocusedLeadingIconColor2, obj34, disabledLeadingIconColor2, obj36, value5, i2, focusedTrailingIconColor2, i21, unfocusedTrailingIconColor2, obj42, disabledTrailingIconColor2, i22, value3, i34, focusedLabelColor2, obj48, unfocusedLabelColor2, obj50, disabledLabelColor2, i27);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final androidx.compose.material3.TextFieldColors outlinedTextFieldColors-St-qZLY(long textColor, long disabledTextColor, long containerColor, long cursorColor, long errorCursorColor, TextSelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i29) {
        int copy-wmQWz5c$default2;
        boolean traceInProgress;
        int consume;
        int value6;
        int value;
        long copy-wmQWz5c$default4;
        int value13;
        long value9;
        int value4;
        long copy-wmQWz5c$default;
        int value2;
        int value8;
        int value3;
        int copy-wmQWz5c$default5;
        int value11;
        int value10;
        int value5;
        int copy-wmQWz5c$default3;
        int value12;
        int value7;
        int i8;
        int fieldInputTextColor;
        int iNSTANCE;
        int companion;
        int textFieldCaretColor;
        int textFieldErrorFocusCaretColor;
        int fieldDisabledInputTextOpacity2;
        long textColor2;
        long disabledTextColor2;
        float fieldDisabledInputTextOpacity;
        long containerColor2;
        int i5;
        int textFieldDisabledOutlineOpacity;
        int i3;
        int i;
        int i10;
        int i6;
        long l2;
        long l6;
        Object obj;
        long l20;
        long l9;
        long l13;
        int i11;
        long l7;
        long l10;
        long l17;
        long l11;
        int i4;
        long l19;
        long l;
        long l4;
        long l16;
        int i2;
        long l18;
        long l12;
        long l8;
        long l5;
        int i9;
        long l15;
        long l3;
        int i7;
        long l14;
        long obj87;
        float obj89;
        int obj90;
        int obj91;
        int obj92;
        int obj93;
        int obj94;
        Composer composer = obj134;
        int i12 = obj135;
        int i13 = obj136;
        int i14 = obj138;
        ComposerKt.sourceInformationMarkerStart(composer, -836383316, "C(outlinedTextFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)1216@66578L5,1218@66687L5,1222@66922L5,1223@67020L5,1224@67099L7,1225@67198L5,1226@67292L5,1228@67405L5,1231@67603L5,1233@67721L5,1235@67836L5,1237@67958L5,1241@68181L5,1243@68301L5,1245@68418L5,1247@68542L5,1251@68768L5,1252@68862L5,1253@68953L5,1255@69063L5,1258@69256L5,1259@69349L5,1261@69465L5,1297@71405L5,1298@71499L5,1300@71616L5,1303@71820L5,1304@71912L5,1305@72006L5,1307@72123L5,1310@72327L5,1265@69605L2738:ExposedDropdownMenu.android.kt#uh7d8r");
        int i112 = 6;
        if (i14 & 1 != 0) {
            textColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, i112);
        } else {
            textColor2 = textColor;
        }
        if (i14 & 2 != 0) {
            disabledTextColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, i112), obj10, OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0, 0, 0, 14);
        } else {
            disabledTextColor2 = containerColor;
        }
        if (i14 & 4 != 0) {
            containerColor2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            containerColor2 = errorCursorColor;
        }
        if (i14 & 8 != 0) {
            l2 = textFieldDisabledOutlineOpacity;
        } else {
            l2 = focusedBorderColor;
        }
        if (i14 & 16 != 0) {
            l6 = textFieldDisabledOutlineOpacity;
        } else {
            l6 = disabledBorderColor;
        }
        if (i14 & 32 != 0) {
            textFieldDisabledOutlineOpacity = 0;
            i3 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd(composer);
            obj = consume;
        } else {
            obj = focusedLeadingIconColor;
        }
        if (i14 & 64 != 0) {
            l20 = value6;
        } else {
            l20 = unfocusedLeadingIconColor;
        }
        if (i14 & 128 != 0) {
            l9 = value;
        } else {
            l9 = errorLeadingIconColor;
        }
        if (i14 & 256 != 0) {
            l13 = copy-wmQWz5c$default4;
        } else {
            l13 = unfocusedTrailingIconColor;
        }
        if (i14 & 512 != 0) {
            l7 = value13;
        } else {
            l7 = errorTrailingIconColor;
        }
        if (i14 & 1024 != 0) {
            l10 = value9;
        } else {
            l10 = unfocusedLabelColor;
        }
        if (i14 & 2048 != 0) {
            l17 = value4;
        } else {
            l17 = errorLabelColor;
        }
        if (i14 & 4096 != 0) {
            l11 = copy-wmQWz5c$default;
        } else {
            l11 = disabledPlaceholderColor;
        }
        if (i14 & 8192 != 0) {
            l19 = value2;
        } else {
            l19 = $changed;
        }
        if (i14 & 16384 != 0) {
            l = value8;
        } else {
            l = $changed2;
        }
        if (i47 &= i14 != 0) {
            l4 = value3;
        } else {
            l4 = obj116;
        }
        if (i48 &= i14 != 0) {
            l16 = copy-wmQWz5c$default5;
        } else {
            l16 = obj118;
        }
        if (i49 &= i14 != 0) {
            l18 = value11;
        } else {
            l18 = obj120;
        }
        if (i50 &= i14 != 0) {
            l12 = value10;
        } else {
            l12 = obj122;
        }
        if (i51 &= i14 != 0) {
            l8 = value5;
        } else {
            l8 = obj124;
        }
        if (i52 &= i14 != 0) {
            l5 = copy-wmQWz5c$default3;
        } else {
            l5 = obj126;
        }
        if (i53 &= i14 != 0) {
            l15 = value12;
        } else {
            l15 = obj128;
        }
        if (i54 &= i14 != 0) {
            l3 = value7;
        } else {
            l3 = obj130;
        }
        if (i14 &= i8 != 0) {
            l14 = copy-wmQWz5c$default2;
        } else {
            l14 = obj132;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-836383316, i12, i13, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:1265)");
        }
        int i122 = 0;
        obj93 = i114;
        obj94 = i116;
        obj90 = i118;
        obj91 = i120;
        obj92 = i122;
        int i111 = 57344;
        int i113 = 458752;
        int i115 = 3670016;
        int i117 = 29360128;
        int i119 = 234881024;
        int i121 = 1879048192;
        i45 &= 14;
        long l21 = textColor2;
        final long l25 = containerColor2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj134);
        return this.outlinedTextFieldColors-FD9MK7s(l21, i46, textColor2, i111, disabledTextColor2, textColor2, l21, disabledTextColor2, l25, containerColor2, l25, i115, l25, i119, l25, i122, l2, obj19, l6, obj21, obj, l20, obj24, l9, obj26, l13, i11, l7, obj30, l10, obj32, l17, obj34, l11, i4, l19, obj38, l, obj40, l4, obj42, l16, i2, l18, obj46, l12);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final androidx.compose.material3.TextFieldColors outlinedTextFieldColors-tN0la-I(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long containerColor, long errorContainerColor, long cursorColor, long errorCursorColor, TextSelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i43, int i44) {
        int value9;
        int copy-wmQWz5c$default2;
        int value3;
        long value10;
        int value8;
        int copy-wmQWz5c$default4;
        int value12;
        boolean traceInProgress;
        Object selectionColors2;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens selectionColors3;
        int textFieldFocusLeadingIconColor;
        int textFieldLeadingIconColor;
        int copy-wmQWz5c$default3;
        int textFieldErrorLeadingIconColor;
        int textFieldFocusTrailingIconColor;
        int textFieldTrailingIconColor;
        int copy-wmQWz5c$default;
        int textFieldErrorTrailingIconColor;
        int fieldFocusLabelTextColor;
        int fieldLabelTextColor;
        int copy-wmQWz5c$default6;
        int fieldErrorLabelTextColor;
        int fieldSupportingTextColor4;
        int fieldSupportingTextColor;
        int copy-wmQWz5c$default5;
        int fieldSupportingTextColor3;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens fieldSupportingTextColor2;
        int i18;
        int fieldFocusInputTextColor;
        int fieldInputTextColor;
        int iNSTANCE;
        int fieldErrorInputTextColor;
        int companion;
        int companion2;
        int textFieldCaretColor;
        int textFieldErrorFocusCaretColor;
        androidx.compose.runtime.ProvidableCompositionLocal localTextSelectionColors;
        int textFieldFocusOutlineColor;
        int textFieldOutlineColor;
        long disabledBorderColor3;
        int disabledBorderColor2;
        int i25;
        int i31;
        int i27;
        int fieldDisabledSupportingTextOpacity2;
        int fieldDisabledSupportingTextOpacity;
        String str;
        int i21;
        long focusedTextColor2;
        long unfocusedTextColor2;
        long disabledTextColor2;
        float fieldDisabledInputTextOpacity;
        long errorTextColor2;
        int i26;
        int i32;
        long containerColor2;
        int i5;
        int i13;
        long errorContainerColor2;
        int i33;
        long cursorColor2;
        long errorCursorColor2;
        int i20;
        long value;
        int i;
        long value6;
        long l3;
        long value7;
        long value11;
        int i10;
        long focusedLeadingIconColor2;
        int i23;
        int i7;
        long unfocusedLeadingIconColor2;
        int i6;
        long l;
        int i14;
        long value2;
        int i22;
        int i2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long l6;
        int i8;
        long value4;
        int i34;
        int i17;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long l8;
        int i24;
        long value13;
        int i9;
        int i11;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long l10;
        int i12;
        long value5;
        int i15;
        int i16;
        long focusedPrefixColor2;
        long l12;
        long l4;
        int i29;
        int i19;
        long l9;
        int i3;
        long l11;
        long l2;
        long l5;
        int i28;
        int i30;
        long l7;
        int i4;
        long obj87;
        long obj88;
        float obj89;
        int obj90;
        int obj91;
        int obj92;
        int obj93;
        int obj94;
        int obj95;
        int obj96;
        int obj97;
        Composer composer = obj160;
        int i35 = obj161;
        int i36 = obj162;
        int i37 = obj165;
        ComposerKt.sourceInformationMarkerStart(composer, -388128543, "C(outlinedTextFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,10:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)1003@53726L5,1004@53816L5,1006@53925L5,1009@54117L5,1012@54307L5,1013@54405L5,1014@54484L7,1015@54583L5,1016@54677L5,1018@54790L5,1021@54988L5,1023@55106L5,1025@55221L5,1027@55343L5,1031@55566L5,1033@55686L5,1035@55803L5,1037@55927L5,1041@56153L5,1042@56247L5,1043@56338L5,1045@56448L5,1048@56641L5,1049@56741L5,1051@56855L5,1053@56976L5,1056@57180L5,1057@57275L5,1058@57372L5,1060@57488L5,1063@57687L5,1064@57782L5,1065@57879L5,1067@57995L5,1070@58194L5,1072@58234L2199:ExposedDropdownMenu.android.kt#uh7d8r");
        str = 6;
        if (i37 & 1 != 0) {
            focusedTextColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, str);
        } else {
            focusedTextColor2 = focusedTextColor;
        }
        if (i37 & 2 != 0) {
            unfocusedTextColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, str);
        } else {
            unfocusedTextColor2 = disabledTextColor;
        }
        if (i37 & 4 != 0) {
            disabledTextColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, str), obj12, OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0, 0, 0, 14);
        } else {
            disabledTextColor2 = containerColor;
        }
        if (i37 & 8 != 0) {
            errorTextColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, str);
        } else {
            errorTextColor2 = cursorColor;
        }
        if (i37 & 16 != 0) {
            containerColor2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            containerColor2 = selectionColors;
        }
        if (i37 & 32 != 0) {
            errorContainerColor2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            errorContainerColor2 = unfocusedBorderColor;
        }
        if (i37 & 64 != 0) {
            cursorColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, str);
        } else {
            cursorColor2 = errorBorderColor;
        }
        if (i37 & 128 != 0) {
            errorCursorColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, str);
        } else {
            errorCursorColor2 = unfocusedLeadingIconColor;
        }
        if (i37 & 256 != 0) {
            i20 = 0;
            i = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            selectionColors2 = composer.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            selectionColors2 = errorLeadingIconColor;
        }
        if (i37 & 512 != 0) {
            value = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer, 6);
        } else {
            i21 = 6;
            value = focusedTrailingIconColor;
        }
        if (i37 & 1024 != 0) {
            l3 = value6;
        } else {
            l3 = disabledTrailingIconColor;
        }
        if (i37 & 2048 != 0) {
            disabledBorderColor3 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer, i21), unfocusedTextColor, OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), 0, 0, 0, 14);
        } else {
            disabledBorderColor3 = focusedLabelColor;
        }
        if (i37 & 4096 != 0) {
            obj88 = disabledBorderColor3;
            value11 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer, 6);
        } else {
            obj88 = disabledBorderColor3;
            disabledBorderColor2 = 6;
            value11 = disabledLabelColor;
        }
        if (i37 & 8192 != 0) {
            focusedLeadingIconColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, disabledBorderColor2);
        } else {
            focusedLeadingIconColor2 = focusedPlaceholderColor;
        }
        if (i37 & 16384 != 0) {
            unfocusedLeadingIconColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, disabledBorderColor2);
        } else {
            unfocusedLeadingIconColor2 = disabledPlaceholderColor;
        }
        if (i52 &= i37 != 0) {
            l = copy-wmQWz5c$default3;
        } else {
            l = focusedPrefixColor;
        }
        if (i53 &= i37 != 0) {
            value2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i25 = 6;
            value2 = disabledPrefixColor;
        }
        if (i54 &= i37 != 0) {
            focusedTrailingIconColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i25);
        } else {
            focusedTrailingIconColor2 = focusedSuffixColor;
        }
        if (i55 &= i37 != 0) {
            unfocusedTrailingIconColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i25);
        } else {
            unfocusedTrailingIconColor2 = disabledSuffixColor;
        }
        if (i56 &= i37 != 0) {
            l6 = copy-wmQWz5c$default;
        } else {
            l6 = $composer;
        }
        if (i57 &= i37 != 0) {
            value4 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i31 = 6;
            value4 = $changed1;
        }
        if (i58 &= i37 != 0) {
            focusedLabelColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i31);
        } else {
            focusedLabelColor2 = $changed3;
        }
        if (i59 &= i37 != 0) {
            unfocusedLabelColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i31);
        } else {
            unfocusedLabelColor2 = i44;
        }
        if (i60 &= i37 != 0) {
            l8 = copy-wmQWz5c$default6;
        } else {
            l8 = obj132;
        }
        if (i61 &= i37 != 0) {
            value13 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, 6);
        } else {
            i27 = 6;
            value13 = obj134;
        }
        if (i62 &= i37 != 0) {
            focusedPlaceholderColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i27);
        } else {
            focusedPlaceholderColor2 = obj136;
        }
        if (i63 &= i37 != 0) {
            unfocusedPlaceholderColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i27);
        } else {
            unfocusedPlaceholderColor2 = obj138;
        }
        if (i64 &= i37 != 0) {
            l10 = copy-wmQWz5c$default5;
        } else {
            l10 = obj140;
        }
        if (i65 &= i37 != 0) {
            value5 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            fieldDisabledSupportingTextOpacity2 = 6;
            value5 = obj142;
        }
        if (i66 &= i37 != 0) {
            focusedPrefixColor2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, fieldDisabledSupportingTextOpacity2);
        } else {
            focusedPrefixColor2 = obj144;
        }
        if (i37 &= i18 != 0) {
            l12 = value9;
        } else {
            l12 = obj146;
        }
        if (obj166 & 1 != 0) {
            l4 = copy-wmQWz5c$default2;
        } else {
            l4 = obj148;
        }
        if (obj166 & 2 != 0) {
            l9 = value3;
        } else {
            fieldDisabledSupportingTextOpacity = 6;
            l9 = obj150;
        }
        if (obj166 & 4 != 0) {
            l11 = value10;
        } else {
            l11 = obj152;
        }
        if (obj166 & 8 != 0) {
            l2 = value8;
        } else {
            l2 = obj154;
        }
        if (obj166 & 16 != 0) {
            l5 = copy-wmQWz5c$default4;
        } else {
            l5 = obj156;
        }
        if (obj166 & 32 != 0) {
            l7 = value12;
        } else {
            l7 = obj158;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-388128543, i35, i36, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:1072)");
        }
        int i70 = 57344;
        int i165 = 458752;
        int i166 = 3670016;
        int i167 = 29360128;
        int i170 = 234881024;
        int i171 = 1879048192;
        i48 |= i111;
        obj90 = i70;
        i163 &= i171;
        final long l17 = containerColor2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj160);
        return this.outlinedTextFieldColors-FD9MK7s(focusedTextColor2, i49, unfocusedTextColor2, i164, disabledTextColor2, focusedTextColor2, errorTextColor2, unfocusedTextColor2, l17, disabledTextColor2, containerColor2, errorTextColor2, l17, containerColor2, errorContainerColor2, errorContainerColor2, cursorColor2, cursorColor2, errorCursorColor2, errorCursorColor2, selectionColors2, value, i, l3, i167, obj88, obj28, value11, obj30, focusedLeadingIconColor2, i23, unfocusedLeadingIconColor2, i6, l, obj36, value2, i22, focusedTrailingIconColor2, obj40, unfocusedTrailingIconColor2, obj42, l6, obj44, value4, i34, focusedLabelColor2);
    }

    public final PopupProperties popupProperties-pR6Bxps$material3_release(String anchorType, Composer $composer, int $changed) {
        int i;
        boolean traceInProgress;
        String str;
        int flags;
        boolean equals-impl0;
        int i2;
        int i3 = -1724259382;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(popupProperties)P(0:c#material3.MenuAnchorType)861@45439L35:ExposedDropdownMenu.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.popupProperties (ExposedDropdownMenu.android.kt:860)");
        }
        i = 0;
        State rememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(i, i, $composer, i, 3);
        if (!ExposedDropdownMenuDefaults.popupProperties_pR6Bxps$lambda$0(rememberAccessibilityServiceState)) {
            flags |= 32;
        }
        if (!MenuAnchorType.equals-impl0(anchorType, MenuAnchorType.Companion.getPrimaryEditable-Mg6Rgbw())) {
            if (MenuAnchorType.equals-impl0(anchorType, MenuAnchorType.Companion.getSecondaryEditable-Mg6Rgbw()) && !ExposedDropdownMenuDefaults.popupProperties_pR6Bxps$lambda$0(rememberAccessibilityServiceState)) {
                if (!ExposedDropdownMenuDefaults.popupProperties_pR6Bxps$lambda$0(rememberAccessibilityServiceState)) {
                    i = 1;
                }
            }
        } else {
        }
        i2 = i != 0 ? flags : flags;
        PopupProperties popupProperties = new PopupProperties(i2, 0, 0, 0, 0, 0, 62, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return popupProperties;
    }

    public final androidx.compose.material3.TextFieldColors textFieldColors-FD9MK7s(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, TextSelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i45, int i46) {
        int textFieldDisabledLeadingIconOpacity;
        int textFieldErrorLeadingIconColor;
        int textFieldFocusTrailingIconColor;
        int textFieldTrailingIconColor;
        int textFieldDisabledTrailingIconOpacity;
        int textFieldErrorTrailingIconColor;
        int fieldFocusLabelTextColor;
        int fieldLabelTextColor;
        int fieldDisabledLabelTextColor;
        int fieldErrorLabelTextColor;
        int fieldSupportingTextColor3;
        int fieldSupportingTextColor5;
        float fieldDisabledSupportingTextOpacity3;
        int fieldSupportingTextColor2;
        int fieldSupportingTextColor4;
        int fieldSupportingTextColor8;
        float fieldDisabledSupportingTextOpacity2;
        int fieldSupportingTextColor7;
        int fieldSupportingTextColor6;
        int fieldSupportingTextColor;
        int fieldDisabledSupportingTextOpacity;
        int value;
        boolean traceInProgress;
        int i23;
        Object selectionColors2;
        int selectionColors3;
        int textFieldFocusLeadingIconColor;
        int textFieldLeadingIconColor;
        int i21;
        int i20;
        int i2;
        int i8;
        int i34;
        int fieldFocusInputTextColor;
        int fieldInputTextColor;
        int iNSTANCE;
        int fieldErrorInputTextColor;
        int textFieldContainerColor;
        int textFieldContainerColor4;
        int textFieldContainerColor2;
        int textFieldContainerColor3;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens textFieldCaretColor;
        int textFieldErrorFocusCaretColor;
        int localTextSelectionColors;
        int textFieldFocusActiveIndicatorColor;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens textFieldActiveIndicatorColor;
        long disabledIndicatorColor2;
        int str;
        int i33;
        long focusedTextColor2;
        long unfocusedTextColor2;
        long disabledTextColor2;
        float fieldDisabledInputTextOpacity;
        long errorTextColor2;
        int i22;
        int i17;
        long focusedContainerColor2;
        int i25;
        int i35;
        long unfocusedContainerColor2;
        int i9;
        long disabledContainerColor2;
        long errorContainerColor2;
        long cursorColor2;
        long errorCursorColor2;
        int i19;
        long value5;
        int i14;
        long value8;
        long l8;
        long value7;
        long value3;
        int i7;
        long focusedLeadingIconColor2;
        int i31;
        int i6;
        long unfocusedLeadingIconColor2;
        int i3;
        long disabledLeadingIconColor2;
        int i13;
        long value6;
        int i27;
        int i;
        long focusedTrailingIconColor2;
        int i10;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        int i24;
        long value2;
        int i29;
        int i11;
        long focusedLabelColor2;
        int i32;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long disabledPlaceholderColor2;
        int i26;
        long value4;
        int i12;
        int copy-wmQWz5c$default;
        int i28;
        long l9;
        long l2;
        long l7;
        int i5;
        int i30;
        long l4;
        int i4;
        long l6;
        long l5;
        long l;
        int i16;
        int i15;
        long l3;
        int i18;
        long obj98;
        long obj99;
        float obj100;
        int obj101;
        int obj102;
        int obj103;
        int obj104;
        int obj105;
        int obj106;
        Composer composer = obj175;
        int i36 = obj176;
        int i37 = obj177;
        final int i38 = obj178;
        int i39 = obj180;
        i23 = obj181;
        ComposerKt.sourceInformationMarkerStart(composer, 768358577, "C(textFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,29,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)573@27038L5,574@27126L5,576@27233L5,579@27421L5,580@27516L5,581@27613L5,582@27709L5,583@27802L5,584@27883L5,585@27979L5,586@28058L7,588@28178L5,590@28293L5,592@28415L5,596@28640L5,598@28756L5,599@28857L5,601@28977L5,605@29196L5,607@29314L5,609@29429L5,611@29551L5,615@29773L5,616@29865L5,617@29954L5,618@30050L5,619@30140L5,620@30238L5,621@30338L5,623@30457L5,626@30657L5,627@30750L5,628@30845L5,630@30959L5,633@31154L5,634@31247L5,635@31342L5,637@31456L5,640@31651L5,642@31709L2230:ExposedDropdownMenu.android.kt#uh7d8r");
        str = 6;
        if (i39 & 1 != 0) {
            focusedTextColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, str);
        } else {
            focusedTextColor2 = focusedTextColor;
        }
        if (i39 & 2 != 0) {
            unfocusedTextColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, str);
        } else {
            unfocusedTextColor2 = disabledTextColor;
        }
        if (i39 & 4 != 0) {
            disabledTextColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, str), obj14, FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0, 0, 0, 14);
        } else {
            disabledTextColor2 = focusedContainerColor;
        }
        if (i39 & 8 != 0) {
            errorTextColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, str);
        } else {
            errorTextColor2 = disabledContainerColor;
        }
        if (i39 & 16 != 0) {
            focusedContainerColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, str);
        } else {
            focusedContainerColor2 = cursorColor;
        }
        if (i39 & 32 != 0) {
            unfocusedContainerColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, str);
        } else {
            unfocusedContainerColor2 = selectionColors;
        }
        if (i39 & 64 != 0) {
            disabledContainerColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, str);
        } else {
            disabledContainerColor2 = unfocusedIndicatorColor;
        }
        if (i39 & 128 != 0) {
            errorContainerColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, str);
        } else {
            errorContainerColor2 = errorIndicatorColor;
        }
        if (i39 & 256 != 0) {
            cursorColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, str);
        } else {
            cursorColor2 = unfocusedLeadingIconColor;
        }
        if (i39 & 512 != 0) {
            errorCursorColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, str);
        } else {
            errorCursorColor2 = errorLeadingIconColor;
        }
        if (i39 & 1024 != 0) {
            i19 = 0;
            i14 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            selectionColors2 = composer.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            selectionColors2 = unfocusedTrailingIconColor;
        }
        if (i39 & 2048 != 0) {
            value5 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer, 6);
        } else {
            i33 = 6;
            value5 = disabledTrailingIconColor;
        }
        if (i39 & 4096 != 0) {
            l8 = value8;
        } else {
            l8 = focusedLabelColor;
        }
        if (i39 & 8192 != 0) {
            disabledIndicatorColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer, i33), unfocusedTextColor, FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), 0, 0, 0, 14);
        } else {
            disabledIndicatorColor2 = disabledLabelColor;
        }
        if (i39 & 16384 != 0) {
            value3 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer, 6);
        } else {
            textFieldDisabledLeadingIconOpacity = 6;
            value3 = focusedPlaceholderColor;
        }
        if (obj180 & i92 != 0) {
            focusedLeadingIconColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, textFieldDisabledLeadingIconOpacity);
        } else {
            focusedLeadingIconColor2 = disabledPlaceholderColor;
        }
        if (obj180 & i93 != 0) {
            unfocusedLeadingIconColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, textFieldDisabledLeadingIconOpacity);
        } else {
            unfocusedLeadingIconColor2 = focusedPrefixColor;
        }
        if (obj180 & i94 != 0) {
            disabledLeadingIconColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, textFieldDisabledLeadingIconOpacity), obj100, FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0, 0, 0, 14);
        } else {
            disabledLeadingIconColor2 = disabledPrefixColor;
        }
        if (obj180 & i40 != 0) {
            value6 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i20 = 6;
            value6 = focusedSuffixColor;
        }
        if (obj180 & i41 != 0) {
            focusedTrailingIconColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i20);
        } else {
            focusedTrailingIconColor2 = disabledSuffixColor;
        }
        if (obj180 & i42 != 0) {
            unfocusedTrailingIconColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i20);
        } else {
            unfocusedTrailingIconColor2 = $composer;
        }
        if (obj180 & i43 != 0) {
            disabledTrailingIconColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, i20), obj100, FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0, 0, 0, 14);
        } else {
            disabledTrailingIconColor2 = $changed1;
        }
        if (obj180 & i44 != 0) {
            value2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i2 = 6;
            value2 = $changed3;
        }
        if (obj180 & i47 != 0) {
            focusedLabelColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i2);
        } else {
            focusedLabelColor2 = i46;
        }
        if (obj180 & i48 != 0) {
            unfocusedLabelColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i2);
        } else {
            unfocusedLabelColor2 = obj145;
        }
        if (obj180 & i49 != 0) {
            disabledLabelColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, i2);
        } else {
            disabledLabelColor2 = obj147;
        }
        if (obj180 & i50 != 0) {
            errorLabelColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, i2);
        } else {
            errorLabelColor2 = obj149;
        }
        if (obj180 & i51 != 0) {
            focusedPlaceholderColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i2);
        } else {
            focusedPlaceholderColor2 = obj151;
        }
        if (obj180 & i52 != 0) {
            unfocusedPlaceholderColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i2);
        } else {
            unfocusedPlaceholderColor2 = obj153;
        }
        if (obj180 & i53 != 0) {
            disabledPlaceholderColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i2), obj100, FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0, 0, 0, 14);
        } else {
            disabledPlaceholderColor2 = obj155;
        }
        if (obj180 & i54 != 0) {
            value4 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i8 = 6;
            value4 = obj157;
        }
        if (i23 & 1 != 0) {
            l9 = copy-wmQWz5c$default;
        } else {
            l9 = obj159;
        }
        if (i23 & 2 != 0) {
            l2 = copy-wmQWz5c$default;
        } else {
            l2 = obj161;
        }
        if (i23 & 4 != 0) {
            l7 = copy-wmQWz5c$default;
        } else {
            l7 = obj163;
        }
        if (i23 & 8 != 0) {
            l4 = copy-wmQWz5c$default;
        } else {
            i34 = 6;
            l4 = obj165;
        }
        if (i23 & 16 != 0) {
            l6 = copy-wmQWz5c$default;
        } else {
            l6 = obj167;
        }
        if (i23 & 32 != 0) {
            l5 = copy-wmQWz5c$default;
        } else {
            l5 = obj169;
        }
        if (i23 & 64 != 0) {
            l = copy-wmQWz5c$default;
        } else {
            l = obj171;
        }
        if (i23 & 128 != 0) {
            l3 = value;
        } else {
            l3 = obj173;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(768358577, i36, i37, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:642)");
        }
        int i98 = 57344;
        int i133 = 458752;
        int i135 = 3670016;
        int i137 = 29360128;
        int i140 = 234881024;
        int i144 = 1879048192;
        obj99 = i98;
        i89 |= i127;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj175);
        return TextFieldDefaults.INSTANCE.colors-0hiis_0(focusedTextColor2, i38, unfocusedTextColor2, i90, disabledTextColor2, disabledIndicatorColor2, errorTextColor2, focusedTextColor2, focusedContainerColor2, unfocusedTextColor2, unfocusedContainerColor2, disabledTextColor2, disabledContainerColor2, errorTextColor2, errorContainerColor2, focusedContainerColor2, cursorColor2, unfocusedContainerColor2, errorCursorColor2, disabledContainerColor2, selectionColors2, value5, obj24, l8, obj26, disabledIndicatorColor2, obj28, value3, i14, focusedLeadingIconColor2, i135, unfocusedLeadingIconColor2, obj34, disabledLeadingIconColor2, obj36, value6, i31, focusedTrailingIconColor2, i3, unfocusedTrailingIconColor2, obj42, disabledTrailingIconColor2, i27, value2, i10, focusedLabelColor2, obj48, unfocusedLabelColor2, obj50, disabledLabelColor2, i29);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final androidx.compose.material3.TextFieldColors textFieldColors-St-qZLY(long textColor, long disabledTextColor, long containerColor, long cursorColor, long errorCursorColor, TextSelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i29) {
        int copy-wmQWz5c$default2;
        boolean traceInProgress;
        int consume;
        int value12;
        int value;
        long copy-wmQWz5c$default3;
        int value6;
        long value4;
        int value3;
        long copy-wmQWz5c$default4;
        int value8;
        int value10;
        int value11;
        int copy-wmQWz5c$default;
        int value13;
        int value7;
        int value2;
        int value9;
        int value5;
        int value14;
        int i6;
        int fieldInputTextColor;
        int iNSTANCE;
        int textFieldContainerColor;
        int textFieldCaretColor;
        int textFieldErrorFocusCaretColor;
        int fieldDisabledInputTextOpacity;
        long textColor2;
        long disabledTextColor2;
        float fieldDisabledInputTextOpacity2;
        long containerColor2;
        int i10;
        int textFieldDisabledActiveIndicatorOpacity;
        int i7;
        int i3;
        int i8;
        int i5;
        long l13;
        long l4;
        Object obj;
        long l10;
        long l;
        long l2;
        int i9;
        long l5;
        long l6;
        long l18;
        long l20;
        int i4;
        long l19;
        long l3;
        long l11;
        long l14;
        int i;
        long l17;
        long l7;
        long l12;
        long l16;
        long l8;
        long l9;
        int i2;
        long l15;
        long obj87;
        float obj89;
        int obj90;
        int obj91;
        int obj92;
        int obj93;
        int obj94;
        Composer composer = obj134;
        int i11 = obj135;
        int i12 = obj136;
        int i13 = obj138;
        ComposerKt.sourceInformationMarkerStart(composer, -1343678550, "C(textFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)1117@60636L5,1119@60743L5,1122@60930L5,1123@61011L5,1124@61107L5,1125@61186L7,1127@61306L5,1129@61421L5,1131@61543L5,1135@61768L5,1137@61884L5,1138@61985L5,1140@62105L5,1144@62324L5,1146@62442L5,1148@62557L5,1150@62679L5,1154@62901L5,1155@62993L5,1156@63082L5,1157@63178L5,1158@63268L5,1159@63359L5,1161@63473L5,1197@65427L5,1198@65521L5,1200@65638L5,1203@65842L5,1204@65934L5,1205@66028L5,1207@66145L5,1210@66349L5,1165@63611L2754:ExposedDropdownMenu.android.kt#uh7d8r");
        int i111 = 6;
        if (i13 & 1 != 0) {
            textColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, i111);
        } else {
            textColor2 = textColor;
        }
        if (i13 & 2 != 0) {
            disabledTextColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, i111), obj10, FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0, 0, 0, 14);
        } else {
            disabledTextColor2 = containerColor;
        }
        if (i13 & 4 != 0) {
            containerColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, i111);
        } else {
            containerColor2 = errorCursorColor;
        }
        if (i13 & 8 != 0) {
            l13 = textFieldDisabledActiveIndicatorOpacity;
        } else {
            l13 = focusedIndicatorColor;
        }
        if (i13 & 16 != 0) {
            l4 = textFieldDisabledActiveIndicatorOpacity;
        } else {
            l4 = disabledIndicatorColor;
        }
        if (i13 & 32 != 0) {
            textFieldDisabledActiveIndicatorOpacity = 0;
            i7 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd(composer);
            obj = consume;
        } else {
            obj = focusedLeadingIconColor;
        }
        if (i13 & 64 != 0) {
            l10 = value12;
        } else {
            l10 = unfocusedLeadingIconColor;
        }
        if (i13 & 128 != 0) {
            l = value;
        } else {
            l = errorLeadingIconColor;
        }
        if (i13 & 256 != 0) {
            l2 = copy-wmQWz5c$default3;
        } else {
            l2 = unfocusedTrailingIconColor;
        }
        if (i13 & 512 != 0) {
            l5 = value6;
        } else {
            l5 = errorTrailingIconColor;
        }
        if (i13 & 1024 != 0) {
            l6 = value4;
        } else {
            l6 = unfocusedLabelColor;
        }
        if (i13 & 2048 != 0) {
            l18 = value3;
        } else {
            l18 = errorLabelColor;
        }
        if (i13 & 4096 != 0) {
            l20 = copy-wmQWz5c$default4;
        } else {
            l20 = disabledPlaceholderColor;
        }
        if (i13 & 8192 != 0) {
            l19 = value8;
        } else {
            l19 = $changed;
        }
        if (i13 & 16384 != 0) {
            l3 = value10;
        } else {
            l3 = $changed2;
        }
        if (i46 &= i13 != 0) {
            l11 = value11;
        } else {
            l11 = obj116;
        }
        if (i47 &= i13 != 0) {
            l14 = copy-wmQWz5c$default;
        } else {
            l14 = obj118;
        }
        if (i48 &= i13 != 0) {
            l17 = value13;
        } else {
            l17 = obj120;
        }
        if (i49 &= i13 != 0) {
            l7 = value7;
        } else {
            l7 = obj122;
        }
        if (i50 &= i13 != 0) {
            l12 = value2;
        } else {
            l12 = obj124;
        }
        if (i51 &= i13 != 0) {
            l16 = value9;
        } else {
            l16 = obj126;
        }
        if (i52 &= i13 != 0) {
            l8 = value5;
        } else {
            l8 = obj128;
        }
        if (i53 &= i13 != 0) {
            l9 = value14;
        } else {
            l9 = obj130;
        }
        if (i13 &= i6 != 0) {
            l15 = copy-wmQWz5c$default2;
        } else {
            l15 = obj132;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1343678550, i11, i12, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:1165)");
        }
        int i121 = 0;
        obj93 = i113;
        obj94 = i115;
        obj90 = i117;
        obj91 = i119;
        obj92 = i121;
        int i110 = 57344;
        int i112 = 458752;
        int i114 = 3670016;
        int i116 = 29360128;
        int i118 = 234881024;
        int i120 = 1879048192;
        i44 &= 14;
        long l21 = textColor2;
        final long l25 = containerColor2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj134);
        return this.textFieldColors-FD9MK7s(l21, i45, textColor2, i110, disabledTextColor2, textColor2, l21, disabledTextColor2, l25, containerColor2, l25, i114, l25, i118, l25, i121, l13, obj19, l4, obj21, obj, l10, obj24, l, obj26, l2, i9, l5, obj30, l6, obj32, l18, obj34, l20, i4, l19, obj38, l3, obj40, l11, obj42, l14, i, l17, obj46, l7);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final androidx.compose.material3.TextFieldColors textFieldColors-tN0la-I(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long containerColor, long errorContainerColor, long cursorColor, long errorCursorColor, TextSelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i43, int i44) {
        int value9;
        int copy-wmQWz5c$default3;
        int value3;
        long value11;
        int value8;
        int copy-wmQWz5c$default4;
        int value12;
        boolean traceInProgress;
        Object selectionColors2;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens selectionColors3;
        int textFieldFocusLeadingIconColor;
        int textFieldLeadingIconColor;
        int copy-wmQWz5c$default;
        int textFieldErrorLeadingIconColor;
        int textFieldFocusTrailingIconColor;
        int textFieldTrailingIconColor;
        int copy-wmQWz5c$default5;
        int textFieldErrorTrailingIconColor;
        int fieldFocusLabelTextColor;
        int fieldLabelTextColor;
        int fieldDisabledLabelTextColor;
        int fieldErrorLabelTextColor;
        int fieldSupportingTextColor3;
        int fieldSupportingTextColor4;
        int copy-wmQWz5c$default2;
        int fieldSupportingTextColor;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens fieldSupportingTextColor2;
        int i;
        int fieldFocusInputTextColor;
        int fieldInputTextColor;
        int iNSTANCE;
        int fieldErrorInputTextColor;
        int textFieldContainerColor2;
        int textFieldContainerColor;
        int textFieldCaretColor;
        int textFieldErrorFocusCaretColor;
        androidx.compose.runtime.ProvidableCompositionLocal localTextSelectionColors;
        int textFieldFocusActiveIndicatorColor;
        int textFieldActiveIndicatorColor;
        long disabledIndicatorColor3;
        int disabledIndicatorColor2;
        int i30;
        int i28;
        int fieldDisabledSupportingTextOpacity;
        int fieldDisabledSupportingTextOpacity2;
        String str;
        int i10;
        long focusedTextColor2;
        long unfocusedTextColor2;
        long disabledTextColor2;
        float fieldDisabledInputTextOpacity;
        long errorTextColor2;
        int i3;
        int i25;
        long containerColor2;
        int i20;
        int i24;
        long errorContainerColor2;
        int i12;
        long cursorColor2;
        long errorCursorColor2;
        int i14;
        long value4;
        int i27;
        long value;
        long l8;
        long value5;
        long value7;
        int i2;
        long focusedLeadingIconColor2;
        int i29;
        int i4;
        long unfocusedLeadingIconColor2;
        int i5;
        long l4;
        int i6;
        long value10;
        int i26;
        int i7;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long l6;
        int i8;
        long value2;
        int i19;
        int i9;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long l;
        int i11;
        long value6;
        int i16;
        int i21;
        long focusedPrefixColor2;
        long l9;
        long l2;
        int i13;
        int i22;
        long l7;
        int i18;
        long l5;
        long l10;
        long l3;
        int i23;
        int i15;
        long l11;
        int i17;
        long obj87;
        long obj88;
        float obj89;
        int obj90;
        int obj91;
        int obj92;
        int obj93;
        int obj94;
        int obj95;
        int obj96;
        int obj97;
        Composer composer = obj160;
        int i31 = obj161;
        int i32 = obj162;
        int i33 = obj165;
        ComposerKt.sourceInformationMarkerStart(composer, 611690079, "C(textFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)891@46833L5,892@46921L5,894@47028L5,897@47216L5,898@47304L5,899@47397L5,900@47478L5,901@47574L5,902@47653L7,904@47773L5,906@47888L5,908@48010L5,912@48235L5,914@48351L5,915@48452L5,917@48572L5,921@48791L5,923@48909L5,925@49024L5,927@49146L5,931@49368L5,932@49460L5,933@49549L5,934@49645L5,935@49735L5,936@49833L5,937@49933L5,939@50052L5,942@50252L5,943@50345L5,944@50440L5,946@50554L5,949@50749L5,950@50842L5,951@50937L5,953@51051L5,956@51246L5,958@51286L2215:ExposedDropdownMenu.android.kt#uh7d8r");
        str = 6;
        if (i33 & 1 != 0) {
            focusedTextColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, str);
        } else {
            focusedTextColor2 = focusedTextColor;
        }
        if (i33 & 2 != 0) {
            unfocusedTextColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, str);
        } else {
            unfocusedTextColor2 = disabledTextColor;
        }
        if (i33 & 4 != 0) {
            disabledTextColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, str), obj12, FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0, 0, 0, 14);
        } else {
            disabledTextColor2 = containerColor;
        }
        if (i33 & 8 != 0) {
            errorTextColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, str);
        } else {
            errorTextColor2 = cursorColor;
        }
        if (i33 & 16 != 0) {
            containerColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, str);
        } else {
            containerColor2 = selectionColors;
        }
        if (i33 & 32 != 0) {
            errorContainerColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, str);
        } else {
            errorContainerColor2 = unfocusedIndicatorColor;
        }
        if (i33 & 64 != 0) {
            cursorColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, str);
        } else {
            cursorColor2 = errorIndicatorColor;
        }
        if (i33 & 128 != 0) {
            errorCursorColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, str);
        } else {
            errorCursorColor2 = unfocusedLeadingIconColor;
        }
        if (i33 & 256 != 0) {
            i14 = 0;
            i27 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            selectionColors2 = composer.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            selectionColors2 = errorLeadingIconColor;
        }
        if (i33 & 512 != 0) {
            value4 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer, 6);
        } else {
            i10 = 6;
            value4 = focusedTrailingIconColor;
        }
        if (i33 & 1024 != 0) {
            l8 = value;
        } else {
            l8 = disabledTrailingIconColor;
        }
        if (i33 & 2048 != 0) {
            disabledIndicatorColor3 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer, i10), unfocusedTextColor, FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), 0, 0, 0, 14);
        } else {
            disabledIndicatorColor3 = focusedLabelColor;
        }
        if (i33 & 4096 != 0) {
            obj88 = disabledIndicatorColor3;
            value7 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer, 6);
        } else {
            obj88 = disabledIndicatorColor3;
            disabledIndicatorColor2 = 6;
            value7 = disabledLabelColor;
        }
        if (i33 & 8192 != 0) {
            focusedLeadingIconColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, disabledIndicatorColor2);
        } else {
            focusedLeadingIconColor2 = focusedPlaceholderColor;
        }
        if (i33 & 16384 != 0) {
            unfocusedLeadingIconColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, disabledIndicatorColor2);
        } else {
            unfocusedLeadingIconColor2 = disabledPlaceholderColor;
        }
        if (i48 &= i33 != 0) {
            l4 = copy-wmQWz5c$default;
        } else {
            l4 = focusedPrefixColor;
        }
        if (i49 &= i33 != 0) {
            value10 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i30 = 6;
            value10 = disabledPrefixColor;
        }
        if (i50 &= i33 != 0) {
            focusedTrailingIconColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i30);
        } else {
            focusedTrailingIconColor2 = focusedSuffixColor;
        }
        if (i51 &= i33 != 0) {
            unfocusedTrailingIconColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i30);
        } else {
            unfocusedTrailingIconColor2 = disabledSuffixColor;
        }
        if (i52 &= i33 != 0) {
            l6 = copy-wmQWz5c$default5;
        } else {
            l6 = $composer;
        }
        if (i53 &= i33 != 0) {
            value2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i28 = 6;
            value2 = $changed1;
        }
        if (i54 &= i33 != 0) {
            focusedLabelColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i28);
        } else {
            focusedLabelColor2 = $changed3;
        }
        if (i55 &= i33 != 0) {
            unfocusedLabelColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i28);
        } else {
            unfocusedLabelColor2 = i44;
        }
        if (i56 &= i33 != 0) {
            disabledLabelColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, i28);
        } else {
            disabledLabelColor2 = obj132;
        }
        if (i57 &= i33 != 0) {
            errorLabelColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, i28);
        } else {
            errorLabelColor2 = obj134;
        }
        if (i58 &= i33 != 0) {
            focusedPlaceholderColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i28);
        } else {
            focusedPlaceholderColor2 = obj136;
        }
        if (i59 &= i33 != 0) {
            unfocusedPlaceholderColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i28);
        } else {
            unfocusedPlaceholderColor2 = obj138;
        }
        if (i60 &= i33 != 0) {
            l = copy-wmQWz5c$default2;
        } else {
            l = obj140;
        }
        if (i61 &= i33 != 0) {
            value6 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            fieldDisabledSupportingTextOpacity = 6;
            value6 = obj142;
        }
        if (i62 &= i33 != 0) {
            focusedPrefixColor2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, fieldDisabledSupportingTextOpacity);
        } else {
            focusedPrefixColor2 = obj144;
        }
        if (i33 &= i != 0) {
            l9 = value9;
        } else {
            l9 = obj146;
        }
        if (obj166 & 1 != 0) {
            l2 = copy-wmQWz5c$default3;
        } else {
            l2 = obj148;
        }
        if (obj166 & 2 != 0) {
            l7 = value3;
        } else {
            fieldDisabledSupportingTextOpacity2 = 6;
            l7 = obj150;
        }
        if (obj166 & 4 != 0) {
            l5 = value11;
        } else {
            l5 = obj152;
        }
        if (obj166 & 8 != 0) {
            l10 = value8;
        } else {
            l10 = obj154;
        }
        if (obj166 & 16 != 0) {
            l3 = copy-wmQWz5c$default4;
        } else {
            l3 = obj156;
        }
        if (obj166 & 32 != 0) {
            l11 = value12;
        } else {
            l11 = obj158;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611690079, i31, i32, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:958)");
        }
        int i66 = 57344;
        int i161 = 458752;
        int i162 = 3670016;
        int i163 = 29360128;
        int i166 = 234881024;
        int i167 = 1879048192;
        i42 |= i107;
        obj90 = i66;
        i159 &= i167;
        final long l16 = containerColor2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj160);
        return this.textFieldColors-FD9MK7s(focusedTextColor2, i45, unfocusedTextColor2, i160, disabledTextColor2, focusedTextColor2, errorTextColor2, unfocusedTextColor2, l16, disabledTextColor2, containerColor2, errorTextColor2, l16, containerColor2, errorContainerColor2, errorContainerColor2, cursorColor2, cursorColor2, errorCursorColor2, errorCursorColor2, selectionColors2, value4, i27, l8, i163, obj88, obj28, value7, obj30, focusedLeadingIconColor2, i29, unfocusedLeadingIconColor2, i5, l4, obj36, value10, i26, focusedTrailingIconColor2, obj40, unfocusedTrailingIconColor2, obj42, l6, obj44, value2, i19, focusedLabelColor2);
    }
}
