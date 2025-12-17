package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeAction.Companion;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.ImeOptions.Companion;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardCapitalization.Companion;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.KeyboardType.Companion;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.LocaleList.Companion;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u00083\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 J2\u00020\u0001:\u0001JBQ\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB/\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\u0010B;\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0011BS\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0013J:\u00105\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u00086\u00107JF\u00105\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u00088\u00109J^\u00105\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008:\u0010;J^\u00105\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0000¢\u0006\u0004\u0008:\u0010<J\u0013\u0010=\u001a\u00020\u00052\u0008\u0010>\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0017\u0010?\u001a\u00020\u00002\u0008\u0010>\u001a\u0004\u0018\u00010\u0000H\u0001¢\u0006\u0002\u0008@J\u0008\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u00002\u0008\u0010>\u001a\u0004\u0018\u00010\u0000J\u0017\u0010D\u001a\u00020E2\u0008\u0008\u0002\u0010F\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008GJ\u0008\u0010H\u001a\u00020IH\u0016R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0016\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\u0008\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u0017R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\u0008\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u00038BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008!\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0014\u0010$\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008%\u0010#R\u0019\u0010\u0008\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\u0008&\u0010\u001eR\u001a\u0010'\u001a\u00020\t8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008(\u0010\u001eR\u0014\u0010)\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008)\u0010\u0017R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\u0008*\u0010\u001eR\u001a\u0010+\u001a\u00020\u00078BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008,\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u001a\u0010/\u001a\u00020\u00058FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u00080\u0010\u0015\u001a\u0004\u00081\u0010\u0017R\u0015\u0010\u000c\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\u00082\u0010\u0019R\u0014\u00103\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00084\u0010\u0017\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006K", d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "showKeyboardOnFocus", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoCorrectEnabled", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect$annotations", "()V", "getAutoCorrect", "()Z", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "autoCorrectOrDefault", "getAutoCorrectOrDefault", "getCapitalization-IUNYP9k", "()I", "I", "capitalizationOrDefault", "getCapitalizationOrDefault-IUNYP9k", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "hintLocalesOrDefault", "getHintLocalesOrDefault", "getImeAction-eUduSuo", "imeActionOrDefault", "getImeActionOrDefault-eUduSuo$foundation_release", "isCompletelyUnspecified", "getKeyboardType-PjHm6EE", "keyboardTypeOrDefault", "getKeyboardTypeOrDefault-PjHm6EE", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "shouldShowKeyboardOnFocus", "getShouldShowKeyboardOnFocus$annotations", "getShouldShowKeyboardOnFocus", "getShowKeyboardOnFocus", "showKeyboardOnFocusOrDefault", "getShowKeyboardOnFocusOrDefault$foundation_release", "copy", "copy-3m2b7yw", "(IZII)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-ij11fho", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-INvB4aQ", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "other", "fillUnspecifiedValuesWith", "fillUnspecifiedValuesWith$foundation_release", "hashCode", "", "merge", "toImeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "singleLine", "toImeOptions$foundation_release", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyboardOptions {

    public static final int $stable;
    public static final androidx.compose.foundation.text.KeyboardOptions.Companion Companion;
    private static final androidx.compose.foundation.text.KeyboardOptions Default;
    private static final androidx.compose.foundation.text.KeyboardOptions SecureTextField;
    private final Boolean autoCorrectEnabled;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final Boolean showKeyboardOnFocus;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\t\u0010\u0002\u001a\u0004\u0008\n\u0010\u0007¨\u0006\u000b", d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "SecureTextField", "getSecureTextField$foundation_release$annotations", "getSecureTextField$foundation_release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getDefault$annotations() {
        }

        public static void getSecureTextField$foundation_release$annotations() {
        }

        public final androidx.compose.foundation.text.KeyboardOptions getDefault() {
            return KeyboardOptions.access$getDefault$cp();
        }

        public final androidx.compose.foundation.text.KeyboardOptions getSecureTextField$foundation_release() {
            return KeyboardOptions.access$getSecureTextField$cp();
        }
    }
    static {
        KeyboardOptions.Companion companion = new KeyboardOptions.Companion(0);
        KeyboardOptions.Companion = companion;
        final int i10 = 0;
        final int i11 = 0;
        KeyboardOptions keyboardOptions = new KeyboardOptions(0, 0, 0, 0, 0, i10, i11, 127, 0);
        KeyboardOptions.Default = keyboardOptions;
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, false, KeyboardType.Companion.getPassword-PjHm6EE(), 0, i10, i11, 0, 121, 0);
        KeyboardOptions.SecureTextField = keyboardOptions2;
    }

    private KeyboardOptions(int capitalization, Boolean autoCorrectEnabled, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        super();
        this.capitalization = capitalization;
        this.autoCorrectEnabled = autoCorrectEnabled;
        this.keyboardType = keyboardType;
        this.imeAction = imeAction;
        this.platformImeOptions = platformImeOptions;
        this.showKeyboardOnFocus = showKeyboardOnFocus;
        this.hintLocales = hintLocales;
    }

    public KeyboardOptions(int i, Boolean boolean2, int i3, int i4, PlatformImeOptions platformImeOptions5, Boolean boolean6, LocaleList localeList7, int i8, DefaultConstructorMarker defaultConstructorMarker9) {
        int unspecified-IUNYP9k;
        int i7;
        int i6;
        int unspecified-PjHm6EE;
        int unspecified-eUduSuo;
        int i2;
        int i5;
        if (i8 & 1 != 0) {
            unspecified-IUNYP9k = KeyboardCapitalization.Companion.getUnspecified-IUNYP9k();
        } else {
            unspecified-IUNYP9k = i;
        }
        i6 = 0;
        i7 = i8 & 2 != 0 ? i6 : boolean2;
        if (i8 & 4 != 0) {
            unspecified-PjHm6EE = KeyboardType.Companion.getUnspecified-PjHm6EE();
        } else {
            unspecified-PjHm6EE = i3;
        }
        if (i8 & 8 != 0) {
            unspecified-eUduSuo = ImeAction.Companion.getUnspecified-eUduSuo();
        } else {
            unspecified-eUduSuo = i4;
        }
        i2 = i8 & 16 != 0 ? i6 : platformImeOptions5;
        i5 = i8 & 32 != 0 ? i6 : boolean6;
        if (i8 & 64 != 0) {
        } else {
            i6 = localeList7;
        }
        super(unspecified-IUNYP9k, i7, unspecified-PjHm6EE, unspecified-eUduSuo, i2, i5, i6, 0);
    }

    public KeyboardOptions(int i, Boolean boolean2, int i3, int i4, PlatformImeOptions platformImeOptions5, Boolean boolean6, LocaleList localeList7, DefaultConstructorMarker defaultConstructorMarker8) {
        super(i, boolean2, i3, i4, platformImeOptions5, boolean6, localeList7);
    }

    private KeyboardOptions(int capitalization, boolean autoCorrect, int keyboardType, int imeAction) {
        super(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, 0, 0, 0, 96, 0);
    }

    public KeyboardOptions(int i, boolean z2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int i7;
        boolean z;
        int i2;
        int i6;
        int obj7;
        boolean obj8;
        int obj9;
        int obj10;
        if (i5 & 1 != 0) {
            i7 = obj7;
        } else {
            i7 = i;
        }
        if (i5 & 2 != 0) {
            z = obj8;
        } else {
            z = z2;
        }
        if (i5 & 4 != 0) {
            i2 = obj9;
        } else {
            i2 = i3;
        }
        if (i5 & 8 != 0) {
            i6 = obj10;
        } else {
            i6 = i4;
        }
        super(i7, z, i2, i6, 0);
    }

    private KeyboardOptions(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions) {
        super(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, Boolean.valueOf(KeyboardOptions.Default.getShowKeyboardOnFocusOrDefault$foundation_release()), 0, 64, 0);
    }

    public KeyboardOptions(int i, boolean z2, int i3, int i4, PlatformImeOptions platformImeOptions5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int i7;
        boolean z;
        int i5;
        int i8;
        int i2;
        int obj8;
        boolean obj9;
        int obj10;
        int obj11;
        int obj12;
        if (i6 & 1 != 0) {
            i7 = obj8;
        } else {
            i7 = i;
        }
        if (i6 & 2 != 0) {
            z = obj9;
        } else {
            z = z2;
        }
        if (i6 & 4 != 0) {
            i5 = obj10;
        } else {
            i5 = i3;
        }
        if (i6 & 8 != 0) {
            i8 = obj11;
        } else {
            i8 = i4;
        }
        i2 = i6 & 16 != 0 ? obj12 : platformImeOptions5;
        super(i7, z, i5, i8, i2, 0);
    }

    private KeyboardOptions(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        super(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, 0);
    }

    public KeyboardOptions(int i, boolean z2, int i3, int i4, PlatformImeOptions platformImeOptions5, Boolean boolean6, LocaleList localeList7, int i8, DefaultConstructorMarker defaultConstructorMarker9) {
        int i5;
        int i6;
        int i2;
        int i10;
        int i7;
        int i9;
        int obj10;
        int obj12;
        int obj13;
        if (i8 & 1 != 0) {
            i5 = obj10;
        } else {
            i5 = i;
        }
        if (i8 & 4 != 0) {
            i6 = obj12;
        } else {
            i6 = i3;
        }
        if (i8 & 8 != 0) {
            i2 = obj13;
        } else {
            i2 = i4;
        }
        obj12 = 0;
        i10 = i8 & 16 != 0 ? obj12 : platformImeOptions5;
        i7 = i8 & 32 != 0 ? obj12 : boolean6;
        i9 = i8 & 64 != 0 ? obj12 : localeList7;
        super(i5, z2, i6, i2, i10, i7, i9, 0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the new constructor that takes optional autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(...))
    public KeyboardOptions(int i, boolean z2, int i3, int i4, PlatformImeOptions platformImeOptions5, Boolean boolean6, LocaleList localeList7, DefaultConstructorMarker defaultConstructorMarker8) {
        super(i, z2, i3, i4, platformImeOptions5, boolean6, localeList7);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public KeyboardOptions(int i, boolean z2, int i3, int i4, PlatformImeOptions platformImeOptions5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(i, z2, i3, i4, platformImeOptions5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public KeyboardOptions(int i, boolean z2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(i, z2, i3, i4);
    }

    public static final androidx.compose.foundation.text.KeyboardOptions access$getDefault$cp() {
        return KeyboardOptions.Default;
    }

    public static final androidx.compose.foundation.text.KeyboardOptions access$getSecureTextField$cp() {
        return KeyboardOptions.SecureTextField;
    }

    public static androidx.compose.foundation.text.KeyboardOptions copy-3m2b7yw$default(androidx.compose.foundation.text.KeyboardOptions keyboardOptions, int i2, boolean z3, int i4, int i5, int i6, Object object7) {
        int obj1;
        boolean obj2;
        int obj3;
        int obj4;
        if (i6 & 1 != 0) {
            obj1 = keyboardOptions.capitalization;
        }
        if (i6 & 2 != 0) {
            obj2 = keyboardOptions.getAutoCorrectOrDefault();
        }
        if (i6 & 4 != 0) {
            obj3 = keyboardOptions.keyboardType;
        }
        if (i6 &= 8 != 0) {
            obj4 = keyboardOptions.imeAction;
        }
        return keyboardOptions.copy-3m2b7yw(obj1, obj2, obj3, obj4);
    }

    public static androidx.compose.foundation.text.KeyboardOptions copy-INvB4aQ$default(androidx.compose.foundation.text.KeyboardOptions keyboardOptions, int i2, Boolean boolean3, int i4, int i5, PlatformImeOptions platformImeOptions6, Boolean boolean7, LocaleList localeList8, int i9, Object object10) {
        int obj2;
        Boolean obj3;
        int obj4;
        int obj5;
        PlatformImeOptions obj6;
        int obj7;
        int obj10;
        if (i9 & 1 != 0) {
            obj2 = keyboardOptions.capitalization;
        }
        if (i9 & 2 != 0) {
            obj3 = keyboardOptions.autoCorrectEnabled;
        }
        if (i9 & 4 != 0) {
            obj4 = keyboardOptions.keyboardType;
        }
        if (i9 & 8 != 0) {
            obj5 = keyboardOptions.imeAction;
        }
        if (i9 & 16 != 0) {
            obj6 = keyboardOptions.platformImeOptions;
        }
        final int i = 0;
        if (i9 & 32 != 0) {
            obj7 = i;
        }
        obj10 = i9 &= 64 != 0 ? i : localeList8;
        return keyboardOptions.copy-INvB4aQ(obj2, obj3, obj4, obj5, obj6, obj7, obj10);
    }

    public static androidx.compose.foundation.text.KeyboardOptions copy-INvB4aQ$default(androidx.compose.foundation.text.KeyboardOptions keyboardOptions, int i2, boolean z3, int i4, int i5, PlatformImeOptions platformImeOptions6, Boolean boolean7, LocaleList localeList8, int i9, Object object10) {
        int obj1;
        boolean obj2;
        int obj3;
        int obj4;
        PlatformImeOptions obj5;
        Boolean obj6;
        LocaleList obj7;
        LocaleList obj9;
        if (i9 & 1 != 0) {
            obj1 = keyboardOptions.capitalization;
        }
        if (i9 & 2 != 0) {
            obj2 = keyboardOptions.getAutoCorrectOrDefault();
        }
        if (i9 & 4 != 0) {
            obj3 = keyboardOptions.keyboardType;
        }
        if (i9 & 8 != 0) {
            obj4 = keyboardOptions.imeAction;
        }
        if (i9 & 16 != 0) {
            obj5 = keyboardOptions.platformImeOptions;
        }
        if (i9 & 32 != 0) {
            obj6 = Boolean.valueOf(keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release());
        }
        obj9 = i9 &= 64 != 0 ? obj7 : localeList8;
        return keyboardOptions.copy-INvB4aQ(obj1, obj2, obj3, obj4, obj5, obj6, obj9);
    }

    public static androidx.compose.foundation.text.KeyboardOptions copy-ij11fho$default(androidx.compose.foundation.text.KeyboardOptions keyboardOptions, int i2, boolean z3, int i4, int i5, PlatformImeOptions platformImeOptions6, int i7, Object object8) {
        int obj1;
        boolean obj2;
        int obj3;
        int obj4;
        PlatformImeOptions obj5;
        PlatformImeOptions obj7;
        if (i7 & 1 != 0) {
            obj1 = keyboardOptions.capitalization;
        }
        if (i7 & 2 != 0) {
            obj2 = keyboardOptions.getAutoCorrectOrDefault();
        }
        if (i7 & 4 != 0) {
            obj3 = keyboardOptions.keyboardType;
        }
        if (i7 & 8 != 0) {
            obj4 = keyboardOptions.imeAction;
        }
        obj7 = i7 &= 16 != 0 ? obj5 : platformImeOptions6;
        return keyboardOptions.copy-ij11fho(obj1, obj2, obj3, obj4, obj7);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the autoCorrectEnabled property.")
    public static void getAutoCorrect$annotations() {
    }

    private final boolean getAutoCorrectOrDefault() {
        boolean booleanValue;
        Boolean autoCorrectEnabled = this.autoCorrectEnabled;
        if (autoCorrectEnabled != null) {
            booleanValue = autoCorrectEnabled.booleanValue();
        } else {
            booleanValue = 1;
        }
        return booleanValue;
    }

    private final int getCapitalizationOrDefault-IUNYP9k() {
        KeyboardCapitalization box-impl;
        int none-IUNYP9k;
        final int i = 0;
        if (!KeyboardCapitalization.equals-impl0(KeyboardCapitalization.box-impl(this.capitalization).unbox-impl(), KeyboardCapitalization.Companion.getUnspecified-IUNYP9k())) {
        } else {
            box-impl = 0;
        }
        if (box-impl != null) {
            none-IUNYP9k = box-impl.unbox-impl();
        } else {
            none-IUNYP9k = KeyboardCapitalization.Companion.getNone-IUNYP9k();
        }
        return none-IUNYP9k;
    }

    private final LocaleList getHintLocalesOrDefault() {
        LocaleList hintLocales;
        if (this.hintLocales == null) {
            hintLocales = LocaleList.Companion.getEmpty();
        }
        return hintLocales;
    }

    private final int getKeyboardTypeOrDefault-PjHm6EE() {
        KeyboardType box-impl;
        int text-PjHm6EE;
        final int i = 0;
        if (!KeyboardType.equals-impl0(KeyboardType.box-impl(this.keyboardType).unbox-impl(), KeyboardType.Companion.getUnspecified-PjHm6EE())) {
        } else {
            box-impl = 0;
        }
        if (box-impl != null) {
            text-PjHm6EE = box-impl.unbox-impl();
        } else {
            text-PjHm6EE = KeyboardType.Companion.getText-PjHm6EE();
        }
        return text-PjHm6EE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Included for binary compatibility. Use showKeyboardOnFocus.")
    public static void getShouldShowKeyboardOnFocus$annotations() {
    }

    private final boolean isCompletelyUnspecified() {
        int i;
        boolean showKeyboardOnFocus;
        int unspecified-IUNYP9k;
        if (KeyboardCapitalization.equals-impl0(this.capitalization, KeyboardCapitalization.Companion.getUnspecified-IUNYP9k()) && this.autoCorrectEnabled == null && KeyboardType.equals-impl0(this.keyboardType, KeyboardType.Companion.getUnspecified-PjHm6EE()) && ImeAction.equals-impl0(this.imeAction, ImeAction.Companion.getUnspecified-eUduSuo()) && this.platformImeOptions == null && this.showKeyboardOnFocus == null && this.hintLocales == null) {
            if (this.autoCorrectEnabled == null) {
                if (KeyboardType.equals-impl0(this.keyboardType, KeyboardType.Companion.getUnspecified-PjHm6EE())) {
                    if (ImeAction.equals-impl0(this.imeAction, ImeAction.Companion.getUnspecified-eUduSuo())) {
                        if (this.platformImeOptions == null) {
                            if (this.showKeyboardOnFocus == null) {
                                i = this.hintLocales == null ? 1 : 0;
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static ImeOptions toImeOptions$foundation_release$default(androidx.compose.foundation.text.KeyboardOptions keyboardOptions, boolean z2, int i3, Object object4) {
        boolean obj1;
        if (i3 &= 1 != 0) {
            obj1 = ImeOptions.Companion.getDefault().getSingleLine();
        }
        return keyboardOptions.toImeOptions$foundation_release(obj1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    public final androidx.compose.foundation.text.KeyboardOptions copy-3m2b7yw(int capitalization, boolean autoCorrect, int keyboardType, int imeAction) {
        KeyboardOptions keyboardOptions = new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, this.platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, 0);
        return keyboardOptions;
    }

    public final androidx.compose.foundation.text.KeyboardOptions copy-INvB4aQ(int capitalization, Boolean autoCorrectEnabled, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        KeyboardOptions keyboardOptions = new KeyboardOptions(capitalization, autoCorrectEnabled, keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, 0);
        return keyboardOptions;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the copy function that takes an autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(...))
    public final androidx.compose.foundation.text.KeyboardOptions copy-INvB4aQ(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        KeyboardOptions keyboardOptions = new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, 0);
        return keyboardOptions;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final androidx.compose.foundation.text.KeyboardOptions copy-ij11fho(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions) {
        KeyboardOptions keyboardOptions = new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, 0);
        return keyboardOptions;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof KeyboardOptions) {
            return i2;
        }
        if (!KeyboardCapitalization.equals-impl0(this.capitalization, obj.capitalization)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.autoCorrectEnabled, obj2.autoCorrectEnabled)) {
            return i2;
        }
        if (!KeyboardType.equals-impl0(this.keyboardType, obj3.keyboardType)) {
            return i2;
        }
        if (!ImeAction.equals-impl0(this.imeAction, obj4.imeAction)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.platformImeOptions, obj5.platformImeOptions)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.showKeyboardOnFocus, obj6.showKeyboardOnFocus)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.hintLocales, obj7.hintLocales)) {
            return i2;
        }
        return i;
    }

    public final androidx.compose.foundation.text.KeyboardOptions fillUnspecifiedValuesWith$foundation_release(androidx.compose.foundation.text.KeyboardOptions other) {
        boolean completelyUnspecified;
        int box-impl;
        int capitalization;
        Boolean autoCorrectEnabled;
        int box-impl2;
        int keyboardType;
        int imeAction;
        PlatformImeOptions platformImeOptions2;
        Boolean showKeyboardOnFocus;
        LocaleList hintLocales;
        int i3;
        int i2;
        Boolean bool2;
        int i4;
        int i;
        PlatformImeOptions platformImeOptions;
        Boolean bool;
        LocaleList list;
        if (other != null && !other.isCompletelyUnspecified()) {
            if (!other.isCompletelyUnspecified()) {
                if (Intrinsics.areEqual(other, this)) {
                } else {
                    if (isCompletelyUnspecified()) {
                        return other;
                    }
                    int i5 = 0;
                    i3 = 0;
                    if (!KeyboardCapitalization.equals-impl0(KeyboardCapitalization.box-impl(this.capitalization).unbox-impl(), KeyboardCapitalization.Companion.getUnspecified-IUNYP9k())) {
                    } else {
                        box-impl = i3;
                    }
                    if (box-impl != 0) {
                        i2 = capitalization;
                    } else {
                        i2 = capitalization;
                    }
                    autoCorrectEnabled = this.autoCorrectEnabled;
                    bool2 = autoCorrectEnabled == null ? autoCorrectEnabled : autoCorrectEnabled;
                    int i6 = 0;
                    if (!KeyboardType.equals-impl0(KeyboardType.box-impl(this.keyboardType).unbox-impl(), KeyboardType.Companion.getUnspecified-PjHm6EE())) {
                    } else {
                        box-impl2 = i3;
                    }
                    if (box-impl2 != 0) {
                        i4 = keyboardType;
                    } else {
                        i4 = keyboardType;
                    }
                    ImeAction box-impl3 = ImeAction.box-impl(this.imeAction);
                    int i7 = 0;
                    if (!ImeAction.equals-impl0(box-impl3.unbox-impl(), ImeAction.Companion.getUnspecified-eUduSuo())) {
                        i3 = box-impl3;
                    }
                    if (i3 != 0) {
                        i = imeAction;
                    } else {
                        i = imeAction;
                    }
                    platformImeOptions2 = this.platformImeOptions;
                    platformImeOptions = platformImeOptions2 == null ? platformImeOptions2 : platformImeOptions2;
                    showKeyboardOnFocus = this.showKeyboardOnFocus;
                    bool = showKeyboardOnFocus == null ? showKeyboardOnFocus : showKeyboardOnFocus;
                    hintLocales = this.hintLocales;
                    list = hintLocales == null ? hintLocales : hintLocales;
                }
                KeyboardOptions keyboardOptions = new KeyboardOptions(i2, bool2, i4, i, platformImeOptions, bool, list, 0);
                return keyboardOptions;
            }
        }
        return this;
    }

    public final boolean getAutoCorrect() {
        return getAutoCorrectOrDefault();
    }

    public final Boolean getAutoCorrectEnabled() {
        return this.autoCorrectEnabled;
    }

    public final int getCapitalization-IUNYP9k() {
        return this.capitalization;
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    public final int getImeAction-eUduSuo() {
        return this.imeAction;
    }

    public final int getImeActionOrDefault-eUduSuo$foundation_release() {
        ImeAction box-impl;
        int default-eUduSuo;
        final int i = 0;
        if (!ImeAction.equals-impl0(ImeAction.box-impl(this.imeAction).unbox-impl(), ImeAction.Companion.getUnspecified-eUduSuo())) {
        } else {
            box-impl = 0;
        }
        if (box-impl != null) {
            default-eUduSuo = box-impl.unbox-impl();
        } else {
            default-eUduSuo = ImeAction.Companion.getDefault-eUduSuo();
        }
        return default-eUduSuo;
    }

    public final int getKeyboardType-PjHm6EE() {
        return this.keyboardType;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final boolean getShouldShowKeyboardOnFocus() {
        boolean booleanValue;
        Boolean showKeyboardOnFocus = this.showKeyboardOnFocus;
        if (showKeyboardOnFocus != null) {
            booleanValue = showKeyboardOnFocus.booleanValue();
        } else {
            booleanValue = 1;
        }
        return booleanValue;
    }

    public final Boolean getShowKeyboardOnFocus() {
        return this.showKeyboardOnFocus;
    }

    public final boolean getShowKeyboardOnFocusOrDefault$foundation_release() {
        boolean booleanValue;
        Boolean showKeyboardOnFocus = this.showKeyboardOnFocus;
        if (showKeyboardOnFocus != null) {
            booleanValue = showKeyboardOnFocus.booleanValue();
        } else {
            booleanValue = 1;
        }
        return booleanValue;
    }

    public int hashCode() {
        int i3;
        int i2;
        int i4;
        int i;
        Boolean autoCorrectEnabled = this.autoCorrectEnabled;
        i = 0;
        if (autoCorrectEnabled != null) {
            i3 = autoCorrectEnabled.hashCode();
        } else {
            i3 = i;
        }
        PlatformImeOptions platformImeOptions = this.platformImeOptions;
        if (platformImeOptions != null) {
            i2 = platformImeOptions.hashCode();
        } else {
            i2 = i;
        }
        Boolean showKeyboardOnFocus = this.showKeyboardOnFocus;
        if (showKeyboardOnFocus != null) {
            i4 = showKeyboardOnFocus.hashCode();
        } else {
            i4 = i;
        }
        LocaleList hintLocales = this.hintLocales;
        if (hintLocales != null) {
            i = hintLocales.hashCode();
        }
        return result3 += i;
    }

    public final androidx.compose.foundation.text.KeyboardOptions merge(androidx.compose.foundation.text.KeyboardOptions other) {
        androidx.compose.foundation.text.KeyboardOptions fillUnspecifiedValuesWith$foundation_release;
        if (other != null) {
            if (other.fillUnspecifiedValuesWith$foundation_release(this) == null) {
                fillUnspecifiedValuesWith$foundation_release = this;
            }
        } else {
        }
        return fillUnspecifiedValuesWith$foundation_release;
    }

    public final ImeOptions toImeOptions$foundation_release(boolean singleLine) {
        ImeOptions imeOptions = new ImeOptions(singleLine, getCapitalizationOrDefault-IUNYP9k(), getAutoCorrectOrDefault(), getKeyboardTypeOrDefault-PjHm6EE(), getImeActionOrDefault-eUduSuo$foundation_release(), this.platformImeOptions, getHintLocalesOrDefault(), 0);
        return imeOptions;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("KeyboardOptions(capitalization=").append(KeyboardCapitalization.toString-impl(this.capitalization)).append(", autoCorrectEnabled=").append(this.autoCorrectEnabled).append(", keyboardType=").append(KeyboardType.toString-impl(this.keyboardType)).append(", imeAction=").append(ImeAction.toString-impl(this.imeAction)).append(", platformImeOptions=").append(this.platformImeOptions).append("showKeyboardOnFocus=").append(this.showKeyboardOnFocus).append(", hintLocales=").append(this.hintLocales).append(')').toString();
    }
}
