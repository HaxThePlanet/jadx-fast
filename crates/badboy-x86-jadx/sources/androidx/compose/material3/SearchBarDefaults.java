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
        Object $i$a$CacheSearchBarDefaults$InputField$3;
        Object merge;
        Object traceInProgress2;
        ScopeUpdateScope endRestartGroup;
        boolean z2;
        String str2;
        Object empty;
        Object $i$a$CacheSearchBarDefaults$InputField$2;
        Object obj8;
        Object obj5;
        Object obj4;
        Object obj2;
        boolean skipping;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        int i57;
        boolean enabled2;
        int enabled3;
        int i10;
        int $i$a$CacheSearchBarDefaults$InputField$interactionSource$1;
        Object $i$a$CacheSearchBarDefaults$InputField$focusRequester$1;
        Object obj12;
        Object obj3;
        boolean placeholder2;
        Object it$iv;
        boolean $composer3;
        Composer restartGroup;
        int $dirty;
        Object obj6;
        Object obj14;
        androidx.compose.material3.TextFieldColors inputFieldColors-ITpI4ow;
        Object colors2;
        Composer placeholder3;
        int i30;
        int searchSemantics3;
        int $dirty12;
        int $dirty112;
        androidx.compose.material3.TextFieldColors $dirty14;
        Object anon;
        int i6;
        Object obj7;
        int obj;
        int i49;
        int suggestionsAvailableSemantics;
        int i4;
        int i35;
        int i26;
        Object obj11;
        int i48;
        int i52;
        Object obj13;
        int i27;
        Object $dirty16;
        Object obj9;
        boolean traceInProgress;
        boolean z;
        int invalid$iv;
        int i25;
        int i7;
        int $dirty13;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        int i21;
        int i40;
        int i28;
        int $dirty17;
        int $i$a$TakeOrElseDxMtmZcSearchBarDefaults$InputField$textColor$1;
        Composer.Companion searchSemantics;
        int i54;
        int searchSemantics2;
        Object focusRequester;
        int searchSemantics4;
        int $dirty1;
        int $dirty19;
        int i42;
        int i44;
        int i55;
        TextStyle textStyle2;
        int i9;
        int $dirty15;
        int i50;
        int changed2;
        int i29;
        boolean changed;
        int i47;
        int $dirty110;
        int i22;
        int keyboardActions;
        int i34;
        int $dirty111;
        int i3;
        int i23;
        int i37;
        int i;
        int $dirty18;
        int i59;
        Composer composer;
        Composer $composer4;
        int i8;
        int i43;
        int i62;
        int i51;
        int i60;
        int textStyle;
        int i63;
        int i5;
        int i38;
        int i45;
        int i61;
        int i14;
        int i20;
        int i33;
        int i36;
        int i11;
        int i12;
        int i32;
        int i56;
        int i58;
        int i2;
        int i13;
        int i46;
        int i39;
        int i19;
        int i53;
        int i31;
        int i18;
        int i41;
        int i24;
        int i15;
        int i17;
        Object obj10;
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
        z2 = expanded;
        empty = onExpandedChange;
        int i73 = $changed;
        int i80 = $changed1;
        i10 = i16;
        restartGroup = $composer.startRestartGroup(1451366815);
        ComposerKt.sourceInformation(restartGroup, "C(InputField)P(10,7,8,2,6,5,1,9,4,11)492@23517L18,498@23776L25,499@23837L29,500@23912L7,502@23951L34,503@24030L39,*506@24122L7,521@24685L44,522@24761L378,534@25242L7,537@25496L19,540@25625L1172,510@24250L2557,566@26894L320,566@26869L345:SearchBar.android.kt#uh7d8r");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i73 & 6 == 0) {
                i6 = restartGroup.changed(query) ? 4 : 2;
                $dirty |= i6;
            }
        }
        if (i10 & 2 != 0) {
            $dirty |= 48;
            obj7 = onQueryChange;
        } else {
            if (i73 & 48 == 0) {
                i21 = restartGroup.changedInstance(onQueryChange) ? 32 : 16;
                $dirty |= i21;
            } else {
                obj7 = onQueryChange;
            }
        }
        if (i10 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i73 & 384 == 0) {
                i4 = restartGroup.changedInstance(traceInProgress2) ? 256 : i28;
                $dirty |= i4;
            }
        }
        if (i10 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i73 & 3072 == 0) {
                i35 = restartGroup.changed(z2) ? 2048 : 1024;
                $dirty |= i35;
            }
        }
        if (i10 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i73 & 24576 == 0) {
                i26 = restartGroup.changedInstance(empty) ? 16384 : 8192;
                $dirty |= i26;
            }
        }
        i48 = i10 & 32;
        i40 = 196608;
        if (i48 != 0) {
            $dirty |= i40;
            $dirty16 = modifier;
        } else {
            if (i73 & i40 == 0) {
                i54 = restartGroup.changed(modifier) ? 131072 : 65536;
                $dirty |= i54;
            } else {
                $dirty16 = modifier;
            }
        }
        searchSemantics2 = i10 & 64;
        $dirty1 = 1572864;
        if (searchSemantics2 != 0) {
            $dirty |= $dirty1;
            z = enabled;
        } else {
            if (i73 & $dirty1 == 0) {
                $dirty19 = restartGroup.changed(enabled) ? 1048576 : 524288;
                $dirty |= $dirty19;
            } else {
                z = enabled;
            }
        }
        $dirty13 = i10 & 128;
        i42 = 12582912;
        if ($dirty13 != 0) {
            $dirty |= i42;
            obj12 = placeholder;
        } else {
            if (i73 & i42 == 0) {
                i42 = restartGroup.changedInstance(placeholder) ? 8388608 : 4194304;
                $dirty |= i42;
            } else {
                obj12 = placeholder;
            }
        }
        int i74 = i10 & 256;
        int i153 = 100663296;
        if (i74 != 0) {
            $dirty |= i153;
            i44 = i74;
            obj8 = leadingIcon;
        } else {
            if ($changed & i153 == 0) {
                i44 = i74;
                i9 = restartGroup.changedInstance(leadingIcon) ? 67108864 : 33554432;
                $dirty |= i9;
            } else {
                i44 = i74;
                obj8 = leadingIcon;
            }
        }
        int i75 = i10 & 512;
        int i155 = 805306368;
        if (i75 != 0) {
            $dirty |= i155;
            $dirty15 = i75;
            obj5 = trailingIcon;
        } else {
            if ($changed & i155 == 0) {
                $dirty15 = i75;
                i50 = restartGroup.changedInstance(trailingIcon) ? 536870912 : 268435456;
                $dirty |= i50;
            } else {
                $dirty15 = i75;
                obj5 = trailingIcon;
            }
        }
        if (i80 & 6 == 0) {
            if (i10 & 1024 == 0) {
                changed2 = restartGroup.changed(colors) ? 4 : 2;
            } else {
                obj4 = colors;
            }
            $dirty12 |= changed2;
        } else {
            obj4 = colors;
        }
        obj90 = $dirty;
        int $dirty4 = i10 & 2048;
        if ($dirty4 != 0) {
            $dirty12 |= 48;
            i29 = $dirty4;
            obj6 = interactionSource;
        } else {
            if (i80 & 48 == 0) {
                i29 = $dirty4;
                $dirty1 = restartGroup.changed(interactionSource) ? 32 : 16;
                $dirty12 |= $dirty1;
            } else {
                i29 = $dirty4;
                obj6 = interactionSource;
            }
        }
        if (i10 & 4096 != 0) {
            $dirty12 |= 384;
            obj2 = this;
        } else {
            if (i80 & 384 == 0) {
                if (restartGroup.changed(this)) {
                    i28 = 256;
                }
                $dirty12 |= i28;
            } else {
                obj2 = this;
            }
        }
        if (obj90 & $dirty17 == 306783378 && $dirty12 & 147 == 146) {
            if ($dirty12 & 147 == 146) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i48 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = $dirty16;
                            }
                            enabled2 = searchSemantics2 != 0 ? 1 : z;
                            if ($dirty13 != 0) {
                                obj12 = 0;
                            }
                            i51 = i44 != 0 ? i48 : leadingIcon;
                            i60 = $dirty15 != 0 ? i48 : trailingIcon;
                            if (i10 & 1024 != 0) {
                                i52 = $dirty12;
                                $dirty1 = i144;
                                i44 = i150;
                                i47 = i29;
                                i22 = i47;
                                i34 = i22;
                                i3 = i34;
                                i = i3;
                                i59 = i;
                                i63 = i182;
                                obj83 = modifier2;
                                obj84 = enabled2;
                                enabled3 = i179;
                                modifier3 = obj90;
                                composer = restartGroup;
                                inputFieldColors-ITpI4ow = this.inputFieldColors-ITpI4ow(0, $dirty12, 0, i52, 0, z, 0, i40, 0, 0, $dirty1, 0, i44, 0, i29, 0, i47, 0);
                                restartGroup = composer;
                                $dirty12 = textStyle & -15;
                            } else {
                                obj83 = modifier2;
                                obj84 = enabled2;
                                textStyle = $dirty12;
                                i63 = i29;
                                enabled3 = 4;
                                modifier3 = obj90;
                                inputFieldColors-ITpI4ow = colors;
                            }
                            if (i63 != 0) {
                                obj13 = obj83;
                                $dirty19 = i97;
                                i49 = $dirty12;
                                $dirty14 = inputFieldColors-ITpI4ow;
                                colors2 = obj12;
                                placeholder2 = obj84;
                            } else {
                                obj13 = obj83;
                                $dirty19 = interactionSource;
                                i49 = $dirty12;
                                $dirty14 = inputFieldColors-ITpI4ow;
                                colors2 = obj12;
                                placeholder2 = obj84;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i10 & 1024 != 0) {
                                $dirty12 &= -15;
                            }
                            i51 = leadingIcon;
                            i60 = trailingIcon;
                            modifier3 = obj90;
                            $dirty19 = obj6;
                            i49 = $dirty12;
                            obj13 = $dirty16;
                            enabled3 = 4;
                            $dirty14 = colors;
                            colors2 = obj12;
                            placeholder2 = z;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1451366815, modifier3, i49, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.android.kt:494)");
                    }
                    restartGroup.startReplaceGroup(-320443616);
                    ComposerKt.sourceInformation(restartGroup, "496@23695L39");
                    String str9 = "CC(remember):SearchBar.android.kt#9igjgp";
                    if ($dirty19 == 0) {
                        ComposerKt.sourceInformationMarkerStart(restartGroup, -320442965, str9);
                        z = 0;
                        $dirty13 = restartGroup;
                        i40 = 0;
                        enabled3 = $dirty13.rememberedValue();
                        $dirty17 = 0;
                        if (enabled3 == Composer.Companion.getEmpty()) {
                            int i83 = 0;
                            $dirty13.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            $i$a$CacheSearchBarDefaults$InputField$interactionSource$1 = enabled3;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    } else {
                        $i$a$CacheSearchBarDefaults$InputField$interactionSource$1 = $dirty19;
                    }
                    restartGroup.endReplaceGroup();
                    boolean booleanValue = (Boolean)FocusInteractionKt.collectIsFocusedAsState((InteractionSource)$i$a$CacheSearchBarDefaults$InputField$interactionSource$1, restartGroup, 0).getValue().booleanValue();
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -320438431, str9);
                    int i131 = 0;
                    obj83 = restartGroup;
                    int i139 = 0;
                    Object rememberedValue2 = obj83.rememberedValue();
                    int i145 = 0;
                    obj86 = $i$a$CacheSearchBarDefaults$InputField$interactionSource$1;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        int i82 = 0;
                        focusRequester = new FocusRequester();
                        obj87 = colors2;
                        obj83.updateRememberedValue(focusRequester);
                    } else {
                        obj87 = colors2;
                        placeholder3 = obj83;
                        $i$a$CacheSearchBarDefaults$InputField$focusRequester$1 = rememberedValue2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i121 = 0;
                    int i132 = 0;
                    String str3 = "CC:CompositionLocal.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str3);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    androidx.compose.material3.internal.Strings.Companion companion3 = Strings.Companion;
                    int i133 = 0;
                    int $i$f$getSearchBarSearch8iCLdWM = 0;
                    androidx.compose.material3.internal.Strings.Companion companion4 = Strings.Companion;
                    int i146 = 0;
                    String string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_suggestions_available), restartGroup, $i$f$getSearchBarSearch8iCLdWM);
                    int i140 = 6;
                    int i147 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str3);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i159 = 0;
                    obj85 = i92;
                    $i$a$TakeOrElseDxMtmZcSearchBarDefaults$InputField$textColor$1 = Long.compare(l, i162) != 0 ? 1 : 0;
                    if ($i$a$TakeOrElseDxMtmZcSearchBarDefaults$InputField$textColor$1 != 0) {
                        i30 = 0;
                    } else {
                        int i149 = 0;
                        $this$takeOrElse_u2dDxMtmZc$iv = $i$a$TakeOrElseDxMtmZcSearchBarDefaults$InputField$textColor$1;
                    }
                    String focused = str6;
                    String str7 = str15;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -320411280, focused);
                    invalid$iv = i111 &= modifier3 == 16384 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    int i134 = 0;
                    obj85 = placeholder2;
                    it$iv = composer2.rememberedValue();
                    int i142 = 0;
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
                    i25 = modifier3 & 7168 == 2048 ? 1 : 0;
                    Composer composer3 = restartGroup;
                    int i124 = 0;
                    Object rememberedValue3 = composer3.rememberedValue();
                    int i143 = 0;
                    if (i100 |= changed7 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            obj84 = i72;
                            $i$a$CacheSearchBarDefaults$InputField$2 = new SearchBarDefaults.InputField.2.1(str7, z2, string-2EP1pXo, $i$a$CacheSearchBarDefaults$InputField$focusRequester$1);
                            composer3.updateRememberedValue((Function1)$i$a$CacheSearchBarDefaults$InputField$2);
                        } else {
                            $i$a$CacheSearchBarDefaults$InputField$2 = rememberedValue3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i102 = 0;
                    int i115 = 6;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, str3);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    textStyle = new TextStyle($this$takeOrElse_u2dDxMtmZc$iv, obj44, 0, obj46, 0, 0, 0, 0, 0, 0, obj53, 0, 0, 0, 0, obj58, 0, 0, 0, 0, 0, 0, obj65, 0, 0, 0, 0, 0, 0, 16777214, 0);
                    merge = (TextStyle)restartGroup.consume((CompositionLocal)TextKt.getLocalTextStyle()).merge(textStyle);
                    int i137 = 0;
                    SolidColor solidColor = new SolidColor($dirty14.cursorColor-vNxB06k$material3_release(i137), 0, i102);
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, 0, 0, ImeAction.Companion.getSearch-eUduSuo(), 0, 0, 0, 119, 0);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -320385353, focused);
                    i7 = modifier3 & 896 == 256 ? 1 : i137;
                    i27 = modifier3 & 14 == 4 ? 1 : i137;
                    Composer composer4 = restartGroup;
                    int i127 = 0;
                    Object rememberedValue4 = composer4.rememberedValue();
                    int i148 = 0;
                    if (i27 |= i7 == 0) {
                        textStyle2 = merge;
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            obj83 = i68;
                            $i$a$CacheSearchBarDefaults$InputField$3 = new SearchBarDefaults.InputField.3.1(traceInProgress2, query);
                            composer4.updateRememberedValue((Function1)$i$a$CacheSearchBarDefaults$InputField$3);
                        } else {
                            str2 = query;
                            $i$a$CacheSearchBarDefaults$InputField$3 = rememberedValue4;
                        }
                    } else {
                        textStyle2 = merge;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    keyboardActions = new KeyboardActions(0, 0, 0, 0, (Function1)$i$a$CacheSearchBarDefaults$InputField$3, 0, 47, 0);
                    obj90 = $dirty14;
                    super(str2, obj85, obj86, obj87, i51, i60, obj90);
                    empty = obj85;
                    int i105 = 1;
                    i3 = str14;
                    i23 = i151;
                    i40 = composer;
                    $dirty15 = $i$a$CacheSearchBarDefaults$InputField$focusRequester$1;
                    i29 = str4;
                    BasicTextFieldKt.BasicTextField(query, onQueryChange, SemanticsModifierKt.semantics$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(SizeKt.sizeIn-qDBjuR0$default(obj13, SearchBar_androidKt.getSearchBarMinWidth(), SearchBarDefaults.InputFieldHeight, SearchBar_androidKt.access$getSearchBarMaxWidth$p(), 0, 8, 0), (FocusRequester)$i$a$CacheSearchBarDefaults$InputField$focusRequester$1), (Function1)it$iv), false, (Function1)$i$a$CacheSearchBarDefaults$InputField$2, 1, i102), empty, false, textStyle2, keyboardOptions, keyboardActions, true, 0, 0, 0, 0, obj86, (Brush)solidColor, (Function3)ComposableLambdaKt.rememberComposableLambda(-2029278807, i105, anon2, restartGroup, 54), i40, i66 | i89, 196608, 7696);
                    $composer2 = i40;
                    if (!expanded && booleanValue) {
                        z = booleanValue ? i22 : changed;
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerStart($composer2, -320340316, focused);
                    skipping = obj10;
                    i57 = $composer2;
                    i10 = 0;
                    Object rememberedValue = i57.rememberedValue();
                    int i90 = 0;
                    if (changed3 |= changedInstance == null) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            searchSemantics3 = 0;
                            anon = new SearchBarDefaults.InputField.5.1(z, skipping, 0);
                            i57.updateRememberedValue((Function2)anon);
                        } else {
                            anon = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(Boolean.valueOf(expanded), (Function2)anon, $composer2, i71 &= 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3 = empty;
                    obj9 = $dirty19;
                    obj3 = $dirty110;
                    obj11 = i34;
                    obj14 = $dirty111;
                    $dirty112 = i51;
                    obj = i60;
                } else {
                    restartGroup.skipToGroupEnd();
                    obj14 = obj12;
                    obj3 = $dirty16;
                    obj9 = obj16;
                    obj = trailingIcon;
                    obj11 = colors;
                    i55 = obj90;
                    $composer2 = restartGroup;
                    i23 = $dirty12;
                    $composer3 = z;
                    $dirty112 = leadingIcon;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $composer4 = $composer2;
            $composer2 = new SearchBarDefaults.InputField.6(this, query, onQueryChange, onSearch, expanded, onExpandedChange, obj3, $composer3, obj14, $dirty112, obj, obj11, obj9, $changed, $changed1, i16);
            endRestartGroup.updateScope((Function2)$composer2);
        } else {
            $composer4 = $composer2;
        }
    }

    @Deprecated(message = "Search bars now take the input field as a parameter. `inputFieldColors` should be passed explicitly to the input field. This parameter will be removed in a future version of the library.", replaceWith = @ReplaceWith(...))
    public final androidx.compose.material3.SearchBarColors colors-Klgx-Pg(long containerColor, long dividerColor, androidx.compose.material3.TextFieldColors inputFieldColors, Composer $composer, int $changed, int i6) {
        int i;
        int i5;
        boolean traceInProgress;
        int containerColor2;
        int value2;
        androidx.compose.material3.TextFieldColors inputFieldColors-ITpI4ow;
        int i13;
        long value;
        int i7;
        int i16;
        int i17;
        androidx.compose.material3.TextFieldColors field;
        int i2;
        int i4;
        int i15;
        int i12;
        int i3;
        int i9;
        int i11;
        int i18;
        Composer composer;
        int i8;
        int i10;
        int i14;
        long l;
        long l2;
        Composer composer2 = i6;
        ComposerKt.sourceInformationMarkerStart(composer2, -1216168196, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)586@27706L5,587@27773L5,588@27824L18:SearchBar.android.kt#uh7d8r");
        i13 = 6;
        if (obj45 & 1 != 0) {
            l = value;
        } else {
            l = containerColor;
        }
        if (obj45 & 2 != 0) {
            l2 = value2;
        } else {
            l2 = inputFieldColors;
        }
        if (obj45 & 4 != 0) {
            i13 = 57344;
            i = obj44;
            field = inputFieldColors-ITpI4ow;
        } else {
            i = obj44;
            field = $changed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1216168196, i, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:590)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(l, i16, l2, i17, field, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(i6);
        return searchBarColors;
    }

    public final androidx.compose.material3.SearchBarColors colors-dgg9oW8(long containerColor, long dividerColor, Composer $composer, int $changed, int i5) {
        int containerColor2;
        int value;
        boolean traceInProgress;
        int str;
        long value2;
        long l;
        long l2;
        Composer composer = i5;
        int i = obj44;
        int i2 = -1507037523;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)375@16778L5,376@16845L5,381@17019L18:SearchBar.android.kt#uh7d8r");
        str = 6;
        if (obj45 & 1 != 0) {
            l = value2;
        } else {
            l = containerColor;
        }
        if (obj45 & 2 != 0) {
            l2 = value;
        } else {
            l2 = $composer;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:378)");
        }
        int i6 = 57344;
        final int i11 = 0;
        final androidx.compose.material3.SearchBarColors searchBarColors = searchBarColors2;
        super(l, obj9, l2, i11, this.inputFieldColors-ITpI4ow(0, i6, 0, value2, 0, obj7, 0, obj9, 0, i11, obj12, 0, obj14, 0, obj16, 0, obj18, 0), 0);
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
        int leadingIconColor2;
        int leadingIconColor;
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
        int i11;
        int i3;
        long focusedLeadingIconColor2;
        int i15;
        int i;
        int i8;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        int i4;
        long focusedTrailingIconColor2;
        int i12;
        int i10;
        long unfocusedTrailingIconColor2;
        int i14;
        long disabledTrailingIconColor2;
        int i6;
        long placeholderColor2;
        int i5;
        int i7;
        int i9;
        int i13;
        int i2;
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
            i3 = 0;
            i15 = 0;
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
        return this.inputFieldColors-ITpI4ow(l, i33, l, disabledPlaceholderColor2, disabledTextColor2, textColor2, cursorColor2, disabledTextColor2, selectionColors2, focusedLeadingIconColor2, i11, unfocusedLeadingIconColor2, i15, disabledLeadingIconColor2, i62, focusedTrailingIconColor2, obj18, unfocusedTrailingIconColor2);
    }

    public final androidx.compose.material3.TextFieldColors inputFieldColors-ITpI4ow(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long cursorColor, TextSelectionColors selectionColors, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int i18) {
        long copy-wmQWz5c$default2;
        boolean traceInProgress;
        int consume;
        int value2;
        int value6;
        long copy-wmQWz5c$default3;
        long value3;
        long value4;
        long copy-wmQWz5c$default;
        long value;
        long value5;
        int inputTextColor2;
        int inputTextColor;
        int iNSTANCE;
        int caretColor;
        int disabledInputOpacity;
        int i;
        long focusedTextColor2;
        long unfocusedTextColor2;
        long disabledTextColor2;
        float disabledLeadingIconOpacity;
        int i3;
        int i5;
        int i2;
        int i8;
        int i4;
        long l6;
        int i6;
        int i7;
        Object obj;
        long l8;
        long l4;
        long l;
        long l9;
        long l10;
        long l7;
        long l5;
        long l3;
        long l2;
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
            l6 = disabledLeadingIconOpacity;
        } else {
            l6 = unfocusedLeadingIconColor;
        }
        if (i11 & 16 != 0) {
            disabledLeadingIconOpacity = 0;
            i3 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd(composer);
            obj = consume;
        } else {
            obj = focusedTrailingIconColor;
        }
        if (i11 & 32 != 0) {
            l8 = value2;
        } else {
            l8 = unfocusedTrailingIconColor;
        }
        if (i11 & 64 != 0) {
            l4 = value6;
        } else {
            l4 = focusedPlaceholderColor;
        }
        if (i11 & 128 != 0) {
            l = copy-wmQWz5c$default3;
        } else {
            l = disabledPlaceholderColor;
        }
        if (i11 & 256 != 0) {
            l9 = value3;
        } else {
            l9 = $changed;
        }
        if (i11 & 512 != 0) {
            l10 = value4;
        } else {
            l10 = i18;
        }
        if (i11 & 1024 != 0) {
            l7 = copy-wmQWz5c$default;
        } else {
            l7 = obj115;
        }
        if (i11 & 2048 != 0) {
            l5 = value;
        } else {
            l5 = obj117;
        }
        if (i11 & 4096 != 0) {
            l3 = value5;
        } else {
            l3 = obj119;
        }
        if (i11 &= 8192 != 0) {
            l2 = copy-wmQWz5c$default2;
        } else {
            l2 = obj121;
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
        return iNSTANCE3.colors-0hiis_0(focusedTextColor2, iNSTANCE3, unfocusedTextColor2, i39, disabledTextColor2, focusedTextColor2, 0, unfocusedTextColor2, 0, disabledTextColor2, 0, i49, 0, i5, 0, i8, l6, obj19, 0, i7, obj, 0, obj24, 0, obj26, 0, obj28, 0, obj30, l8, obj32, l4, obj34, l, obj36, 0, obj38, l9, obj40, l10, obj42, l7, obj44, 0, obj46, 0, obj48, 0, obj50, 0, obj52);
    }
}
