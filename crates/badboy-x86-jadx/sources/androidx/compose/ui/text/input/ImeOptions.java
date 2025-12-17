package androidx.compose.ui.text.input;

import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.LocaleList.Companion;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 +2\u00020\u0001:\u0001+BE\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c¢\u0006\u0002\u0010\rB9\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000eBM\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011JD\u0010\u001e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 JP\u0010\u001e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"JX\u0010\u001e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$J\u0013\u0010%\u001a\u00020\u00032\u0008\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010'\u001a\u00020(H\u0016J\u0008\u0010)\u001a\u00020*H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u0019\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u001a\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0013\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006,", d2 = {"Landroidx/compose/ui/text/input/ImeOptions;", "", "singleLine", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZIZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect", "()Z", "getCapitalization-IUNYP9k", "()I", "I", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "getImeAction-eUduSuo", "getKeyboardType-PjHm6EE", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getSingleLine", "copy", "copy-uxg59PA", "(ZIZII)Landroidx/compose/ui/text/input/ImeOptions;", "copy-YTHSh70", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/ui/text/input/ImeOptions;", "copy-wBHncE4", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/ui/text/input/ImeOptions;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImeOptions {

    public static final int $stable;
    public static final androidx.compose.ui.text.input.ImeOptions.Companion Companion;
    private static final androidx.compose.ui.text.input.ImeOptions Default;
    private final boolean autoCorrect;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions;
    private final boolean singleLine;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/input/ImeOptions$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/input/ImeOptions;", "getDefault", "()Landroidx/compose/ui/text/input/ImeOptions;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.text.input.ImeOptions getDefault() {
            return ImeOptions.access$getDefault$cp();
        }
    }
    static {
        ImeOptions.Companion companion = new ImeOptions.Companion(0);
        ImeOptions.Companion = companion;
        ImeOptions imeOptions = new ImeOptions(0, 0, 0, 0, 0, 0, 0, 127, 0);
        ImeOptions.Default = imeOptions;
    }

    private ImeOptions(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction) {
        super(singleLine, capitalization, autoCorrect, keyboardType, imeAction, 0, 0, 64, 0);
    }

    public ImeOptions(boolean z, int i2, boolean z3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int i;
        int i9;
        int i8;
        int i7;
        int i3;
        int obj8;
        int obj9;
        int obj10;
        int obj11;
        int obj12;
        i = i6 & 1 != 0 ? obj8 : z;
        if (i6 & 2 != 0) {
            i9 = obj9;
        } else {
            i9 = i2;
        }
        i8 = i6 & 4 != 0 ? obj10 : z3;
        if (i6 & 8 != 0) {
            i7 = obj11;
        } else {
            i7 = i4;
        }
        if (i6 & 16 != 0) {
            i3 = obj12;
        } else {
            i3 = i5;
        }
        super(i, i9, i8, i7, i3, 0);
    }

    private ImeOptions(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction, androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions) {
        super(singleLine, capitalization, autoCorrect, keyboardType, imeAction, platformImeOptions, LocaleList.Companion.getEmpty(), 0);
    }

    public ImeOptions(boolean z, int i2, boolean z3, int i4, int i5, androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions6, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        int i3;
        int none-IUNYP9k;
        int i6;
        int text-PjHm6EE;
        int default-eUduSuo;
        int i;
        i3 = i7 & 1 != 0 ? 0 : z;
        if (i7 & 2 != 0) {
            none-IUNYP9k = KeyboardCapitalization.Companion.getNone-IUNYP9k();
        } else {
            none-IUNYP9k = i2;
        }
        i6 = i7 & 4 != 0 ? 1 : z3;
        if (i7 & 8 != 0) {
            text-PjHm6EE = KeyboardType.Companion.getText-PjHm6EE();
        } else {
            text-PjHm6EE = i4;
        }
        if (i7 & 16 != 0) {
            default-eUduSuo = ImeAction.Companion.getDefault-eUduSuo();
        } else {
            default-eUduSuo = i5;
        }
        i = i7 & 32 != 0 ? 0 : platformImeOptions6;
        super(i3, none-IUNYP9k, i6, text-PjHm6EE, default-eUduSuo, i, 0);
    }

    private ImeOptions(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction, androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions, LocaleList hintLocales) {
        super();
        this.singleLine = singleLine;
        this.capitalization = capitalization;
        this.autoCorrect = autoCorrect;
        this.keyboardType = keyboardType;
        this.imeAction = imeAction;
        this.platformImeOptions = platformImeOptions;
        this.hintLocales = hintLocales;
    }

    public ImeOptions(boolean z, int i2, boolean z3, int i4, int i5, androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions6, LocaleList localeList7, int i8, DefaultConstructorMarker defaultConstructorMarker9) {
        int i;
        int none-IUNYP9k;
        int i3;
        int text-PjHm6EE;
        int default-eUduSuo;
        int i6;
        LocaleList empty;
        i = i8 & 1 != 0 ? 0 : z;
        if (i8 & 2 != 0) {
            none-IUNYP9k = KeyboardCapitalization.Companion.getNone-IUNYP9k();
        } else {
            none-IUNYP9k = i2;
        }
        i3 = i8 & 4 != 0 ? 1 : z3;
        if (i8 & 8 != 0) {
            text-PjHm6EE = KeyboardType.Companion.getText-PjHm6EE();
        } else {
            text-PjHm6EE = i4;
        }
        if (i8 & 16 != 0) {
            default-eUduSuo = ImeAction.Companion.getDefault-eUduSuo();
        } else {
            default-eUduSuo = i5;
        }
        i6 = i8 & 32 != 0 ? 0 : platformImeOptions6;
        if (i8 & 64 != 0) {
            empty = LocaleList.Companion.getEmpty();
        } else {
            empty = localeList7;
        }
        super(i, none-IUNYP9k, i3, text-PjHm6EE, default-eUduSuo, i6, empty, 0);
    }

    public ImeOptions(boolean z, int i2, boolean z3, int i4, int i5, androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions6, LocaleList localeList7, DefaultConstructorMarker defaultConstructorMarker8) {
        super(z, i2, z3, i4, i5, platformImeOptions6, localeList7);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional hintLocales parameter.")
    public ImeOptions(boolean z, int i2, boolean z3, int i4, int i5, androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(z, i2, z3, i4, i5, platformImeOptions6);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public ImeOptions(boolean z, int i2, boolean z3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(z, i2, z3, i4, i5);
    }

    public static final androidx.compose.ui.text.input.ImeOptions access$getDefault$cp() {
        return ImeOptions.Default;
    }

    public static androidx.compose.ui.text.input.ImeOptions copy-YTHSh70$default(androidx.compose.ui.text.input.ImeOptions imeOptions, boolean z2, int i3, boolean z4, int i5, int i6, androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions7, int i8, Object object9) {
        boolean obj1;
        int obj2;
        boolean obj3;
        int obj4;
        int obj5;
        androidx.compose.ui.text.input.PlatformImeOptions obj6;
        androidx.compose.ui.text.input.PlatformImeOptions obj8;
        if (i8 & 1 != 0) {
            obj1 = imeOptions.singleLine;
        }
        if (i8 & 2 != 0) {
            obj2 = imeOptions.capitalization;
        }
        if (i8 & 4 != 0) {
            obj3 = imeOptions.autoCorrect;
        }
        if (i8 & 8 != 0) {
            obj4 = imeOptions.keyboardType;
        }
        if (i8 & 16 != 0) {
            obj5 = imeOptions.imeAction;
        }
        obj8 = i8 &= 32 != 0 ? obj6 : platformImeOptions7;
        return imeOptions.copy-YTHSh70(obj1, obj2, obj3, obj4, obj5, obj8);
    }

    public static androidx.compose.ui.text.input.ImeOptions copy-uxg59PA$default(androidx.compose.ui.text.input.ImeOptions imeOptions, boolean z2, int i3, boolean z4, int i5, int i6, int i7, Object object8) {
        boolean obj1;
        int obj2;
        boolean obj3;
        int obj4;
        int obj5;
        int obj7;
        if (i7 & 1 != 0) {
            obj1 = imeOptions.singleLine;
        }
        if (i7 & 2 != 0) {
            obj2 = imeOptions.capitalization;
        }
        if (i7 & 4 != 0) {
            obj3 = imeOptions.autoCorrect;
        }
        if (i7 & 8 != 0) {
            obj4 = imeOptions.keyboardType;
        }
        obj7 = i7 &= 16 != 0 ? obj5 : i6;
        return imeOptions.copy-uxg59PA(obj1, obj2, obj3, obj4, obj7);
    }

    public static androidx.compose.ui.text.input.ImeOptions copy-wBHncE4$default(androidx.compose.ui.text.input.ImeOptions imeOptions, boolean z2, int i3, boolean z4, int i5, int i6, androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions7, LocaleList localeList8, int i9, Object object10) {
        boolean obj1;
        int obj2;
        boolean obj3;
        int obj4;
        int obj5;
        androidx.compose.ui.text.input.PlatformImeOptions obj6;
        LocaleList obj7;
        LocaleList obj9;
        if (i9 & 1 != 0) {
            obj1 = imeOptions.singleLine;
        }
        if (i9 & 2 != 0) {
            obj2 = imeOptions.capitalization;
        }
        if (i9 & 4 != 0) {
            obj3 = imeOptions.autoCorrect;
        }
        if (i9 & 8 != 0) {
            obj4 = imeOptions.keyboardType;
        }
        if (i9 & 16 != 0) {
            obj5 = imeOptions.imeAction;
        }
        if (i9 & 32 != 0) {
            obj6 = imeOptions.platformImeOptions;
        }
        obj9 = i9 &= 64 != 0 ? obj7 : localeList8;
        return imeOptions.copy-wBHncE4(obj1, obj2, obj3, obj4, obj5, obj6, obj9);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional hintLocales parameter.")
    public final androidx.compose.ui.text.input.ImeOptions copy-YTHSh70(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction, androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions) {
        ImeOptions imeOptions = new ImeOptions(singleLine, capitalization, autoCorrect, keyboardType, imeAction, platformImeOptions, this.hintLocales, 0);
        return imeOptions;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    public final androidx.compose.ui.text.input.ImeOptions copy-uxg59PA(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction) {
        ImeOptions imeOptions = new ImeOptions(singleLine, capitalization, autoCorrect, keyboardType, imeAction, this.platformImeOptions, this.hintLocales, 0);
        return imeOptions;
    }

    public final androidx.compose.ui.text.input.ImeOptions copy-wBHncE4(boolean singleLine, int capitalization, boolean autoCorrect, int keyboardType, int imeAction, androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions, LocaleList hintLocales) {
        ImeOptions imeOptions = new ImeOptions(singleLine, capitalization, autoCorrect, keyboardType, imeAction, platformImeOptions, hintLocales, 0);
        return imeOptions;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof ImeOptions) {
            return i2;
        }
        if (this.singleLine != obj.singleLine) {
            return i2;
        }
        if (!KeyboardCapitalization.equals-impl0(this.capitalization, obj2.capitalization)) {
            return i2;
        }
        if (this.autoCorrect != obj3.autoCorrect) {
            return i2;
        }
        if (!KeyboardType.equals-impl0(this.keyboardType, obj4.keyboardType)) {
            return i2;
        }
        if (!ImeAction.equals-impl0(this.imeAction, obj5.imeAction)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.platformImeOptions, obj6.platformImeOptions)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.hintLocales, obj7.hintLocales)) {
            return i2;
        }
        return i;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
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

    public final int getKeyboardType-PjHm6EE() {
        return this.keyboardType;
    }

    public final androidx.compose.ui.text.input.PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public int hashCode() {
        int i;
        androidx.compose.ui.text.input.PlatformImeOptions platformImeOptions = this.platformImeOptions;
        if (platformImeOptions != null) {
            i = platformImeOptions.hashCode();
        } else {
            i = 0;
        }
        return result3 += i14;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ImeOptions(singleLine=").append(this.singleLine).append(", capitalization=").append(KeyboardCapitalization.toString-impl(this.capitalization)).append(", autoCorrect=").append(this.autoCorrect).append(", keyboardType=").append(KeyboardType.toString-impl(this.keyboardType)).append(", imeAction=").append(ImeAction.toString-impl(this.imeAction)).append(", platformImeOptions=").append(this.platformImeOptions).append(", hintLocales=").append(this.hintLocales).append(')').toString();
    }
}
