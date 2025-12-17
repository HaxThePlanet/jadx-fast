package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeAction.Companion;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0011\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JÈ\u0001\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0 2\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001c0 2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010'\u001a\u00020#2\u0015\u0008\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\u0008*2\u0015\u0008\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\u0008*2\u0015\u0008\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0018\u00010)¢\u0006\u0002\u0008*2\u0008\u0008\u0002\u0010-\u001a\u00020.2\n\u0008\u0002\u0010/\u001a\u0004\u0018\u000100H\u0007¢\u0006\u0002\u00101J&\u0010-\u001a\u0002022\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\u00086\u00107J0\u0010-\u001a\u0002022\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u0002042\u0008\u0008\u0002\u00108\u001a\u00020.H\u0007ø\u0001\u0000¢\u0006\u0004\u00089\u0010:J\u008a\u0001\u00108\u001a\u00020.2\u0008\u0008\u0002\u0010;\u001a\u0002042\u0008\u0008\u0002\u0010<\u001a\u0002042\u0008\u0008\u0002\u0010=\u001a\u0002042\u0008\u0008\u0002\u0010>\u001a\u00020?2\u0008\u0008\u0002\u0010@\u001a\u0002042\u0008\u0008\u0002\u0010A\u001a\u0002042\u0008\u0008\u0002\u0010B\u001a\u0002042\u0008\u0008\u0002\u0010C\u001a\u0002042\u0008\u0008\u0002\u0010D\u001a\u0002042\u0008\u0008\u0002\u0010E\u001a\u0002042\u0008\u0008\u0002\u0010F\u001a\u0002042\u0008\u0008\u0002\u0010G\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\u0008H\u0010IJ\u009e\u0001\u00108\u001a\u00020.2\u0008\u0008\u0002\u0010J\u001a\u0002042\u0008\u0008\u0002\u0010K\u001a\u0002042\u0008\u0008\u0002\u0010<\u001a\u0002042\u0008\u0008\u0002\u0010=\u001a\u0002042\u0008\u0008\u0002\u0010>\u001a\u00020?2\u0008\u0008\u0002\u0010@\u001a\u0002042\u0008\u0008\u0002\u0010A\u001a\u0002042\u0008\u0008\u0002\u0010B\u001a\u0002042\u0008\u0008\u0002\u0010C\u001a\u0002042\u0008\u0008\u0002\u0010D\u001a\u0002042\u0008\u0008\u0002\u0010E\u001a\u0002042\u0008\u0008\u0002\u0010L\u001a\u0002042\u0008\u0008\u0002\u0010M\u001a\u0002042\u0008\u0008\u0002\u0010G\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\u0008N\u0010OR$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u000c\u0010\u0007R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006P", d2 = {"Landroidx/compose/material3/SearchBarDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM$annotations", "getElevation-D9Ej5fM", "()F", "F", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "ShadowElevation", "getShadowElevation-D9Ej5fM", "TonalElevation", "getTonalElevation-D9Ej5fM", "dockedShape", "Landroidx/compose/ui/graphics/Shape;", "getDockedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "inputFieldShape", "getInputFieldShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "InputField", "", "query", "", "onQueryChange", "Lkotlin/Function1;", "onSearch", "expanded", "", "onExpandedChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "colors", "Landroidx/compose/material3/TextFieldColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "colors-dgg9oW8", "(JJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "inputFieldColors", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "textColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "placeholderColor", "disabledPlaceholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchBarDefaults {

    public static final int $stable;
    private static final float Elevation;
    public static final androidx.compose.material3.SearchBarDefaults INSTANCE;
    private static final float InputFieldHeight;
    private static final float ShadowElevation;
    private static final float TonalElevation;
    static {
        SearchBarDefaults searchBarDefaults = new SearchBarDefaults();
        SearchBarDefaults.INSTANCE = searchBarDefaults;
        SearchBarDefaults.TonalElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        SearchBarDefaults.ShadowElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        SearchBarDefaults.Elevation = SearchBarDefaults.TonalElevation;
        SearchBarDefaults.InputFieldHeight = SearchBarTokens.INSTANCE.getContainerHeight-D9Ej5fM();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TonalElevation. Not to be confused with ShadowElevation.", replaceWith = @ReplaceWith(...))
    public static void getElevation-D9Ej5fM$annotations() {
    }

    public final void InputField(String query, Function1<? super String, Unit> onQueryChange, Function1<? super String, Unit> onSearch, boolean expanded, Function1<? super Boolean, Unit> onExpandedChange, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, androidx.compose.material3.TextFieldColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1, int i16) {
        Composer $composer2;
        Object anon2;
        Object merge;
        Object traceInProgress2;
        ScopeUpdateScope endRestartGroup;
        boolean z;
        String str2;
        Object empty;
        Object anon;
        Object obj15;
        Object obj9;
        Object obj7;
        Object obj6;
        boolean skipping;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        int i3;
        boolean enabled2;
        int enabled3;
        int i22;
        int i55;
        Object obj12;
        Object obj10;
        Object obj3;
        boolean placeholder2;
        Object it$iv;
        boolean $composer3;
        Composer restartGroup;
        int $dirty;
        Object obj8;
        Object obj11;
        androidx.compose.material3.TextFieldColors inputFieldColors-ITpI4ow;
        Object colors2;
        Composer placeholder3;
        int i27;
        int searchSemantics4;
        int $dirty14;
        int $dirty19;
        androidx.compose.material3.TextFieldColors $dirty16;
        Object anon3;
        int i56;
        Object obj5;
        int obj13;
        int i23;
        int suggestionsAvailableSemantics;
        int i37;
        int i20;
        int i25;
        Object obj14;
        int i54;
        int i39;
        Object obj2;
        int i42;
        Object $dirty112;
        Object obj4;
        boolean traceInProgress;
        boolean z2;
        int invalid$iv;
        int i59;
        int i41;
        int $dirty110;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i;
        int i15;
        int i32;
        int $dirty18;
        int $this$isSpecified$iv$iv;
        Composer.Companion searchSemantics;
        int i19;
        int searchSemantics3;
        Object focusRequester;
        int searchSemantics2;
        int $dirty13;
        int $dirty17;
        int i38;
        int i9;
        int i7;
        TextStyle textStyle;
        int i17;
        int $dirty1;
        int i11;
        int changed2;
        int i64;
        boolean changed;
        int i2;
        int $dirty15;
        int i43;
        int keyboardActions;
        int i13;
        int $dirty111;
        int i60;
        int i57;
        int i12;
        int i51;
        int $dirty12;
        int i44;
        Composer composer;
        Composer $composer4;
        int i8;
        int i5;
        int i52;
        int i49;
        int i4;
        int textStyle2;
        int i36;
        int i62;
        int i30;
        int i10;
        int i50;
        int i18;
        int i6;
        int i34;
        int i45;
        int i47;
        int i24;
        int i26;
        int i58;
        int i21;
        int i14;
        int i53;
        int i63;
        int i61;
        int i29;
        int i40;
        int i31;
        int i33;
        int i46;
        int i35;
        int i48;
        int i28;
        Object obj;
        String str;
        ScopeUpdateScope scopeUpdateScope;
        Object obj83;
        boolean obj84;
        boolean obj85;
        int obj86;
        Object obj87;
        int obj88;
        int obj89;
        int obj90;
        traceInProgress2 = onSearch;
        z = expanded;
        empty = onExpandedChange;
        int i74 = $changed;
        int i81 = $changed1;
        i22 = i16;
        restartGroup = $composer.startRestartGroup(1451366815);
        ComposerKt.sourceInformation(restartGroup, "C(InputField)P(10,7,8,2,6,5,1,9,4,11)492@23517L18,498@23776L25,499@23837L29,500@23912L7,502@23951L34,503@24030L39,*506@24122L7,521@24685L44,522@24761L378,534@25242L7,537@25496L19,540@25625L1172,510@24250L2557,566@26894L320,566@26869L345:SearchBar.android.kt#uh7d8r");
        $dirty = $changed;
        if (i22 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i74 & 6 == 0) {
                i56 = restartGroup.changed(query) ? 4 : 2;
                $dirty |= i56;
            }
        }
        if (i22 & 2 != 0) {
            $dirty |= 48;
            obj5 = onQueryChange;
        } else {
            if (i74 & 48 == 0) {
                i = restartGroup.changedInstance(onQueryChange) ? 32 : 16;
                $dirty |= i;
            } else {
                obj5 = onQueryChange;
            }
        }
        if (i22 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i74 & 384 == 0) {
                i37 = restartGroup.changedInstance(traceInProgress2) ? 256 : i32;
                $dirty |= i37;
            }
        }
        if (i22 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i74 & 3072 == 0) {
                i20 = restartGroup.changed(z) ? 2048 : 1024;
                $dirty |= i20;
            }
        }
        if (i22 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i74 & 24576 == 0) {
                i25 = restartGroup.changedInstance(empty) ? 16384 : 8192;
                $dirty |= i25;
            }
        }
        i54 = i22 & 32;
        i15 = 196608;
        if (i54 != 0) {
            $dirty |= i15;
            $dirty112 = modifier;
        } else {
            if (i74 & i15 == 0) {
                i19 = restartGroup.changed(modifier) ? 131072 : 65536;
                $dirty |= i19;
            } else {
                $dirty112 = modifier;
            }
        }
        searchSemantics3 = i22 & 64;
        $dirty13 = 1572864;
        if (searchSemantics3 != 0) {
            $dirty |= $dirty13;
            z2 = enabled;
        } else {
            if (i74 & $dirty13 == 0) {
                $dirty17 = restartGroup.changed(enabled) ? 1048576 : 524288;
                $dirty |= $dirty17;
            } else {
                z2 = enabled;
            }
        }
        $dirty110 = i22 & 128;
        i38 = 12582912;
        if ($dirty110 != 0) {
            $dirty |= i38;
            obj10 = placeholder;
        } else {
            if (i74 & i38 == 0) {
                i38 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i38;
            } else {
                obj10 = placeholder;
            }
        }
        int i75 = i22 & 256;
        int i155 = 100663296;
        if (i75 != 0) {
            $dirty |= i155;
            i9 = i75;
            obj15 = leadingIcon;
        } else {
            if ($changed & i155 == 0) {
                i9 = i75;
                i17 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i17;
            } else {
                i9 = i75;
                obj15 = leadingIcon;
            }
        }
        int i76 = i22 & 512;
        int i157 = 805306368;
        if (i76 != 0) {
            $dirty |= i157;
            $dirty1 = i76;
            obj9 = trailingIcon;
        } else {
            if ($changed & i157 == 0) {
                $dirty1 = i76;
                i11 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i11;
            } else {
                $dirty1 = i76;
                obj9 = trailingIcon;
            }
        }
        if (i81 & 6 == 0) {
            if (i22 & 1024 == 0) {
                changed2 = restartGroup.changed(colors) ? 4 : 2;
            } else {
                obj7 = colors;
            }
            $dirty14 |= changed2;
        } else {
            obj7 = colors;
        }
        obj90 = $dirty;
        int $dirty4 = i22 & 2048;
        if ($dirty4 != 0) {
            $dirty14 |= 48;
            i64 = $dirty4;
            obj8 = interactionSource;
        } else {
            if (i81 & 48 == 0) {
                i64 = $dirty4;
                $dirty13 = restartGroup.changed(interactionSource) ? 32 : 16;
                $dirty14 |= $dirty13;
            } else {
                i64 = $dirty4;
                obj8 = interactionSource;
            }
        }
        if (i22 & 4096 != 0) {
            $dirty14 |= 384;
            obj6 = this;
        } else {
            if (i81 & 384 == 0) {
                if (restartGroup.changed(this)) {
                    i32 = 256;
                }
                $dirty14 |= i32;
            } else {
                obj6 = this;
            }
        }
        if (obj90 & $dirty18 == 306783378 && $dirty14 & 147 == 146) {
            if ($dirty14 & 147 == 146) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i54 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = $dirty112;
                            }
                            enabled2 = searchSemantics3 != 0 ? 1 : z2;
                            if ($dirty110 != 0) {
                                obj10 = 0;
                            }
                            i49 = i9 != 0 ? i54 : leadingIcon;
                            i4 = $dirty1 != 0 ? i54 : trailingIcon;
                            if (i22 & 1024 != 0) {
                                i39 = $dirty14;
                                $dirty13 = i146;
                                i9 = i152;
                                i2 = i64;
                                i43 = i2;
                                i13 = i43;
                                i60 = i13;
                                i51 = i60;
                                i44 = i51;
                                i36 = i184;
                                obj83 = modifier2;
                                obj84 = enabled2;
                                enabled3 = i181;
                                modifier3 = obj90;
                                composer = restartGroup;
                                inputFieldColors-ITpI4ow = this.inputFieldColors-ITpI4ow(0, $dirty14, 0, i39, 0, z2, 0, i15, 0, 0, $dirty13, 0, i9, 0, i64, 0, i2, 0);
                                restartGroup = composer;
                                $dirty14 = textStyle2 & -15;
                            } else {
                                obj83 = modifier2;
                                obj84 = enabled2;
                                textStyle2 = $dirty14;
                                i36 = i64;
                                enabled3 = 4;
                                modifier3 = obj90;
                                inputFieldColors-ITpI4ow = colors;
                            }
                            if (i36 != 0) {
                                obj2 = obj83;
                                $dirty17 = i98;
                                i23 = $dirty14;
                                $dirty16 = inputFieldColors-ITpI4ow;
                                colors2 = obj10;
                                placeholder2 = obj84;
                            } else {
                                obj2 = obj83;
                                $dirty17 = interactionSource;
                                i23 = $dirty14;
                                $dirty16 = inputFieldColors-ITpI4ow;
                                colors2 = obj10;
                                placeholder2 = obj84;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i22 & 1024 != 0) {
                                $dirty14 &= -15;
                            }
                            i49 = leadingIcon;
                            i4 = trailingIcon;
                            modifier3 = obj90;
                            $dirty17 = obj8;
                            i23 = $dirty14;
                            obj2 = $dirty112;
                            enabled3 = 4;
                            $dirty16 = colors;
                            colors2 = obj10;
                            placeholder2 = z2;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1451366815, modifier3, i23, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.android.kt:494)");
                    }
                    restartGroup.startReplaceGroup(-320443616);
                    ComposerKt.sourceInformation(restartGroup, "496@23695L39");
                    String str9 = "CC(remember):SearchBar.android.kt#9igjgp";
                    if ($dirty17 == 0) {
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -320442965, str9);
                        z2 = 0;
                        $dirty110 = restartGroup;
                        i15 = 0;
                        enabled3 = $dirty110.rememberedValue();
                        $dirty18 = 0;
                        if (enabled3 == Composer.Companion.getEmpty()) {
                            int i84 = 0;
                            $dirty110.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            i55 = enabled3;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    } else {
                        i55 = $dirty17;
                    }
                    restartGroup.endReplaceGroup();
                    boolean booleanValue = (Boolean)FocusInteractionKt.collectIsFocusedAsState((InteractionSource)i55, restartGroup, 0).getValue().booleanValue();
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -320438431, str9);
                    int i132 = 0;
                    obj83 = restartGroup;
                    int i141 = 0;
                    Object rememberedValue2 = obj83.rememberedValue();
                    int i147 = 0;
                    obj86 = i55;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        int i83 = 0;
                        focusRequester = new FocusRequester();
                        obj87 = colors2;
                        obj83.updateRememberedValue(focusRequester);
                    } else {
                        obj87 = colors2;
                        placeholder3 = obj83;
                        obj12 = rememberedValue2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i122 = 0;
                    int i133 = 0;
                    String str3 = "CC:CompositionLocal.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str3);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    androidx.compose.material3.internal.Strings.Companion companion3 = Strings.Companion;
                    int i134 = 0;
                    int i135 = 0;
                    androidx.compose.material3.internal.Strings.Companion companion4 = Strings.Companion;
                    int i148 = 0;
                    String string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_suggestions_available), restartGroup, i135);
                    int i142 = 6;
                    int i149 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str3);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i161 = 0;
                    obj85 = i93;
                    $this$isSpecified$iv$iv = Long.compare(l, i164) != 0 ? 1 : 0;
                    if ($this$isSpecified$iv$iv != 0) {
                        i27 = 0;
                    } else {
                        int i151 = 0;
                        $this$takeOrElse_u2dDxMtmZc$iv = $this$isSpecified$iv$iv;
                    }
                    String focused = str6;
                    String str7 = str15;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -320411280, focused);
                    invalid$iv = i112 &= modifier3 == 16384 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    int i136 = 0;
                    obj85 = placeholder2;
                    it$iv = composer2.rememberedValue();
                    int i144 = 0;
                    if (invalid$iv == 0) {
                        obj84 = invalid$iv;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            invalid$iv = 0;
                            obj88 = it$iv;
                            it$iv = new SearchBarDefaults.InputField.1.1(empty);
                            composer2.updateRememberedValue((Function1)it$iv);
                        } else {
                            obj88 = it$iv;
                        }
                    } else {
                        obj84 = invalid$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -320408514, focused);
                    i59 = modifier3 & 7168 == 2048 ? 1 : 0;
                    Composer composer3 = restartGroup;
                    int i125 = 0;
                    Object rememberedValue3 = composer3.rememberedValue();
                    int i145 = 0;
                    if (i101 |= changed7 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            obj84 = i73;
                            anon = new SearchBarDefaults.InputField.2.1(str7, z, string-2EP1pXo, obj12);
                            composer3.updateRememberedValue((Function1)anon);
                        } else {
                            anon = rememberedValue3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i103 = 0;
                    int i116 = 6;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str3);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    textStyle2 = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, obj44, 0, obj46, 0, 0, 0, 0, 0, 0, obj53, 0, 0, 0, 0, obj58, 0, 0, 0, 0, 0, 0, obj65, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    merge = (TextStyle)restartGroup.consume((CompositionLocal)TextKt.getLocalTextStyle()).merge(textStyle2);
                    int i139 = 0;
                    SolidColor solidColor = new SolidColor($dirty16.cursorColor-vNxB06k$material3_release(i139), 0, i103);
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, 0, 0, ImeAction.Companion.getSearch-eUduSuo(), 0, 0, 0, 119, 0);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -320385353, focused);
                    i41 = modifier3 & 896 == 256 ? 1 : i139;
                    i42 = modifier3 & 14 == 4 ? 1 : i139;
                    Composer composer4 = restartGroup;
                    int i128 = 0;
                    Object rememberedValue4 = composer4.rememberedValue();
                    int i150 = 0;
                    if (i42 |= i41 == 0) {
                        textStyle = merge;
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            obj83 = i69;
                            anon2 = new SearchBarDefaults.InputField.3.1(traceInProgress2, query);
                            composer4.updateRememberedValue((Function1)anon2);
                        } else {
                            str2 = query;
                            anon2 = rememberedValue4;
                        }
                    } else {
                        textStyle = merge;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    keyboardActions = new KeyboardActions(0, 0, 0, 0, (Function1)anon2, 0, 47, 0);
                    obj90 = $dirty16;
                    super(str2, obj85, obj86, obj87, i49, i4, obj90);
                    empty = obj85;
                    int i106 = 1;
                    i60 = str14;
                    i57 = i153;
                    i15 = composer;
                    $dirty1 = obj12;
                    i64 = str4;
                    BasicTextFieldKt.BasicTextField(query, onQueryChange, SemanticsModifierKt.semantics$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(SizeKt.sizeIn-qDBjuR0$default(obj2, SearchBar_androidKt.getSearchBarMinWidth(), SearchBarDefaults.InputFieldHeight, SearchBar_androidKt.access$getSearchBarMaxWidth$p(), 0, 8, 0), (FocusRequester)obj12), (Function1)it$iv), false, (Function1)anon, 1, i103), empty, false, textStyle, keyboardOptions, keyboardActions, true, 0, 0, 0, 0, obj86, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(-2029278807, i106, anon4, restartGroup, 54), i15, i67 | i90, 196608, 7696);
                    $composer2 = i15;
                    if (!expanded && booleanValue) {
                        z2 = booleanValue ? i43 : changed;
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerStart($composer2, -320340316, focused);
                    skipping = obj;
                    i3 = $composer2;
                    i22 = 0;
                    Object rememberedValue = i3.rememberedValue();
                    int i91 = 0;
                    if (changed3 |= changedInstance == null) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            searchSemantics4 = 0;
                            anon3 = new SearchBarDefaults.InputField.5.1(z2, skipping, 0);
                            i3.updateRememberedValue((Function2)anon3);
                        } else {
                            anon3 = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(Boolean.valueOf(expanded), (Function2)anon3, $composer2, i72 &= 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3 = empty;
                    obj4 = $dirty17;
                    obj3 = $dirty15;
                    obj14 = i13;
                    obj11 = $dirty111;
                    $dirty19 = i49;
                    obj13 = i4;
                } else {
                    restartGroup.skipToGroupEnd();
                    obj11 = obj10;
                    obj3 = $dirty112;
                    obj4 = obj17;
                    obj13 = trailingIcon;
                    obj14 = colors;
                    i7 = obj90;
                    $composer2 = restartGroup;
                    i57 = $dirty14;
                    $composer3 = z2;
                    $dirty19 = leadingIcon;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $composer4 = $composer2;
            $composer2 = new SearchBarDefaults.InputField.6(this, query, onQueryChange, onSearch, expanded, onExpandedChange, obj3, $composer3, obj11, $dirty19, obj13, obj14, obj4, $changed, $changed1, i16);
            endRestartGroup.updateScope((Function2)$composer2);
        } else {
            $composer4 = $composer2;
        }
    }

    @Deprecated(message = "Search bars now take the input field as a parameter. `inputFieldColors` should be passed explicitly to the input field. This parameter will be removed in a future version of the library.", replaceWith = @ReplaceWith(...))
    public final androidx.compose.material3.SearchBarColors colors-Klgx-Pg(long containerColor, long dividerColor, androidx.compose.material3.TextFieldColors inputFieldColors, Composer $composer, int $changed, int i6) {
        int i17;
        int i18;
        boolean traceInProgress;
        int containerColor2;
        int value;
        androidx.compose.material3.TextFieldColors inputFieldColors-ITpI4ow;
        int i5;
        long value2;
        int i4;
        int i2;
        int i9;
        androidx.compose.material3.TextFieldColors field;
        int i11;
        int i14;
        int i15;
        int i10;
        int i;
        int i3;
        int i12;
        int i13;
        Composer composer;
        int i16;
        int i8;
        int i7;
        long l2;
        long l;
        Composer composer2 = i6;
        ComposerKt.sourceInformationMarkerStart(composer2, -1216168196, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)586@27706L5,587@27773L5,588@27824L18:SearchBar.android.kt#uh7d8r");
        i5 = 6;
        if (obj45 & 1 != 0) {
            l2 = value2;
        } else {
            l2 = containerColor;
        }
        if (obj45 & 2 != 0) {
            l = value;
        } else {
            l = inputFieldColors;
        }
        if (obj45 & 4 != 0) {
            i5 = 57344;
            i17 = obj44;
            field = inputFieldColors-ITpI4ow;
        } else {
            i17 = obj44;
            field = $changed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1216168196, i17, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:590)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(l2, i2, l, i9, field, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(i6);
        return searchBarColors;
    }

    public final androidx.compose.material3.SearchBarColors colors-dgg9oW8(long containerColor, long dividerColor, Composer $composer, int $changed, int i5) {
        int containerColor2;
        int value2;
        boolean traceInProgress;
        int str;
        long value;
        long l;
        long l2;
        Composer composer = i5;
        int i = obj44;
        int i2 = -1507037523;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)375@16778L5,376@16845L5,381@17019L18:SearchBar.android.kt#uh7d8r");
        str = 6;
        if (obj45 & 1 != 0) {
            l = value;
        } else {
            l = containerColor;
        }
        if (obj45 & 2 != 0) {
            l2 = value2;
        } else {
            l2 = $composer;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:378)");
        }
        int i6 = 57344;
        final int i11 = 0;
        final androidx.compose.material3.SearchBarColors searchBarColors = searchBarColors2;
        super(l, obj9, l2, i11, this.inputFieldColors-ITpI4ow(0, i6, 0, value, 0, obj7, 0, obj9, 0, i11, obj12, 0, obj14, 0, obj16, 0, obj18, 0), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(i5);
        return searchBarColors;
    }

    public final Shape getDockedShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1006952150;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C357@16094L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.android.kt:357)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(SearchViewTokens.INSTANCE.getDockedContainerShape(), $composer, 6);
    }

    public final float getElevation-D9Ej5fM() {
        return SearchBarDefaults.Elevation;
    }

    public final Shape getFullScreenShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1665502056;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C353@15944L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.android.kt:353)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), $composer, 6);
    }

    public final float getInputFieldHeight-D9Ej5fM() {
        return SearchBarDefaults.InputFieldHeight;
    }

    public final Shape getInputFieldShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -971556142;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C349@15770L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.android.kt:349)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(SearchBarTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final float getShadowElevation-D9Ej5fM() {
        return SearchBarDefaults.ShadowElevation;
    }

    public final float getTonalElevation-D9Ej5fM() {
        return SearchBarDefaults.TonalElevation;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 2112270157;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C361@16229L10:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.android.kt:361)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer, 6);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final androidx.compose.material3.TextFieldColors inputFieldColors--u-KgnY(long textColor, long disabledTextColor, long cursorColor, TextSelectionColors selectionColors, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int i16) {
        float disabledInputOpacity2;
        boolean traceInProgress;
        Object selectionColors2;
        int inputTextColor;
        int iNSTANCE;
        int caretColor;
        int localTextSelectionColors;
        int leadingIconColor;
        int leadingIconColor2;
        int disabledLeadingIconOpacity;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens trailingIconColor2;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens trailingIconColor;
        float disabledTrailingIconOpacity;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens supportingTextColor;
        long disabledPlaceholderColor2;
        long textColor2;
        long disabledTextColor2;
        float disabledInputOpacity;
        long cursorColor2;
        int i4;
        int i12;
        long focusedLeadingIconColor2;
        int i5;
        int i14;
        int i8;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        int i15;
        long focusedTrailingIconColor2;
        int i9;
        int i;
        long unfocusedTrailingIconColor2;
        int i6;
        long disabledTrailingIconColor2;
        int i7;
        long placeholderColor2;
        int i2;
        int i13;
        int i3;
        int i10;
        int i11;
        long obj34;
        float obj36;
        int obj37;
        int obj38;
        int obj39;
        int obj40;
        int obj41;
        Composer composer = obj57;
        int i17 = obj58;
        int i18 = obj59;
        int i19 = obj60;
        ComposerKt.sourceInformationMarkerStart(composer, 355927049, "C(inputFieldColors)P(9:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,8,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,4:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color)599@28228L5,601@28323L5,604@28479L5,605@28558L7,606@28641L5,607@28724L5,609@28832L5,612@29008L5,613@29093L5,615@29203L5,618@29374L5,620@29476L5,624@29586L825:SearchBar.android.kt#uh7d8r");
        int i35 = 6;
        if (i19 & 1 != 0) {
            textColor2 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, i35);
        } else {
            textColor2 = textColor;
        }
        if (i19 & 2 != 0) {
            disabledTextColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, i35), obj10, FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0, 0, 0, 14);
        } else {
            disabledTextColor2 = cursorColor;
        }
        if (i19 & 4 != 0) {
            cursorColor2 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, i35);
        } else {
            cursorColor2 = focusedLeadingIconColor;
        }
        if (i19 & 8 != 0) {
            i12 = 0;
            i5 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            selectionColors2 = composer.consume((CompositionLocal)TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            selectionColors2 = disabledLeadingIconColor;
        }
        if (i19 & 16 != 0) {
            focusedLeadingIconColor2 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, i35);
        } else {
            focusedLeadingIconColor2 = focusedTrailingIconColor;
        }
        if (i19 & 32 != 0) {
            unfocusedLeadingIconColor2 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, i35);
        } else {
            unfocusedLeadingIconColor2 = disabledTrailingIconColor;
        }
        if (i19 & 64 != 0) {
            disabledLeadingIconColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, i35), disabledTextColor, FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0, 0, 0, 14);
        } else {
            disabledLeadingIconColor2 = disabledPlaceholderColor;
        }
        if (i19 & 128 != 0) {
            focusedTrailingIconColor2 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, i35);
        } else {
            focusedTrailingIconColor2 = $changed;
        }
        if (i19 & 256 != 0) {
            unfocusedTrailingIconColor2 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, i35);
        } else {
            unfocusedTrailingIconColor2 = i16;
        }
        if (i19 & 512 != 0) {
            disabledTrailingIconColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, i35), disabledTextColor, FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0, 0, 0, 14);
        } else {
            disabledTrailingIconColor2 = obj51;
        }
        if (i19 & 1024 != 0) {
            placeholderColor2 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, i35);
        } else {
            placeholderColor2 = obj53;
        }
        if (i19 &= 2048 != 0) {
            disabledPlaceholderColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, i35), disabledTextColor, FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0, 0, 0, 14);
        } else {
            disabledPlaceholderColor2 = obj55;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(355927049, i17, i18, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:624)");
        }
        int i62 = 57344;
        i32 |= i59;
        long l = textColor2;
        long unfocusedTrailingIconColor3 = placeholderColor2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj57);
        return this.inputFieldColors-ITpI4ow(l, i33, l, disabledPlaceholderColor2, disabledTextColor2, textColor2, cursorColor2, disabledTextColor2, selectionColors2, focusedLeadingIconColor2, i4, unfocusedLeadingIconColor2, i5, disabledLeadingIconColor2, i62, focusedTrailingIconColor2, obj18, unfocusedTrailingIconColor2);
    }

    public final androidx.compose.material3.TextFieldColors inputFieldColors-ITpI4ow(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long cursorColor, TextSelectionColors selectionColors, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int i18) {
        long copy-wmQWz5c$default;
        boolean traceInProgress;
        int consume;
        int value2;
        int value4;
        long copy-wmQWz5c$default2;
        long value;
        long value3;
        long copy-wmQWz5c$default3;
        long value6;
        long value5;
        int inputTextColor;
        int inputTextColor2;
        int iNSTANCE;
        int caretColor;
        int disabledInputOpacity;
        int i;
        long focusedTextColor2;
        long unfocusedTextColor2;
        long disabledTextColor2;
        float disabledLeadingIconOpacity;
        int i5;
        int i7;
        int i2;
        int i6;
        int i8;
        long l7;
        int i3;
        int i4;
        Object obj;
        long l9;
        long l6;
        long l8;
        long l;
        long l4;
        long l3;
        long l2;
        long l10;
        long l5;
        long obj96;
        float obj98;
        int obj99;
        int obj100;
        int obj101;
        int obj102;
        int obj103;
        Composer composer = obj123;
        int i9 = obj124;
        int i10 = obj125;
        int i11 = obj126;
        ComposerKt.sourceInformationMarkerStart(composer, -602148837, "C(inputFieldColors)P(7:c#ui.graphics.Color,12:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,9,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,2:c#ui.graphics.Color)410@18829L5,411@18903L5,413@18998L5,416@19154L5,417@19233L7,418@19316L5,419@19399L5,421@19507L5,424@19683L5,425@19768L5,427@19878L5,430@20056L5,431@20142L5,433@20244L5,437@20389L847:SearchBar.android.kt#uh7d8r");
        i = 6;
        if (i11 & 1 != 0) {
            focusedTextColor2 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, i);
        } else {
            focusedTextColor2 = focusedTextColor;
        }
        if (i11 & 2 != 0) {
            unfocusedTextColor2 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, i);
        } else {
            unfocusedTextColor2 = disabledTextColor;
        }
        if (i11 & 4 != 0) {
            disabledTextColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, i), obj12, FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0, 0, 0, 14);
        } else {
            disabledTextColor2 = selectionColors;
        }
        if (i11 & 8 != 0) {
            l7 = disabledLeadingIconOpacity;
        } else {
            l7 = unfocusedLeadingIconColor;
        }
        if (i11 & 16 != 0) {
            disabledLeadingIconOpacity = 0;
            i5 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd(composer);
            obj = consume;
        } else {
            obj = focusedTrailingIconColor;
        }
        if (i11 & 32 != 0) {
            l9 = value2;
        } else {
            l9 = unfocusedTrailingIconColor;
        }
        if (i11 & 64 != 0) {
            l6 = value4;
        } else {
            l6 = focusedPlaceholderColor;
        }
        if (i11 & 128 != 0) {
            l8 = copy-wmQWz5c$default2;
        } else {
            l8 = disabledPlaceholderColor;
        }
        if (i11 & 256 != 0) {
            l = value;
        } else {
            l = $changed;
        }
        if (i11 & 512 != 0) {
            l4 = value3;
        } else {
            l4 = i18;
        }
        if (i11 & 1024 != 0) {
            l3 = copy-wmQWz5c$default3;
        } else {
            l3 = obj115;
        }
        if (i11 & 2048 != 0) {
            l2 = value6;
        } else {
            l2 = obj117;
        }
        if (i11 & 4096 != 0) {
            l10 = value5;
        } else {
            l10 = obj119;
        }
        if (i11 &= 8192 != 0) {
            l5 = copy-wmQWz5c$default;
        } else {
            l5 = obj121;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-602148837, i9, i10, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:437)");
        }
        androidx.compose.material3.TextFieldDefaults iNSTANCE3 = TextFieldDefaults.INSTANCE;
        int i40 = 234881024;
        int i34 = 29360128;
        int i50 = 1879048192;
        int i49 = i10 << 18;
        i38 &= i50;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj123);
        return iNSTANCE3.colors-0hiis_0(focusedTextColor2, iNSTANCE3, unfocusedTextColor2, i39, disabledTextColor2, focusedTextColor2, 0, unfocusedTextColor2, 0, disabledTextColor2, 0, i49, 0, i7, 0, i6, l7, obj19, 0, i4, obj, 0, obj24, 0, obj26, 0, obj28, 0, obj30, l9, obj32, l6, obj34, l8, obj36, 0, obj38, l, obj40, l4, obj42, l3, obj44, 0, obj46, 0, obj48, 0, obj50, 0, obj52);
    }
}
