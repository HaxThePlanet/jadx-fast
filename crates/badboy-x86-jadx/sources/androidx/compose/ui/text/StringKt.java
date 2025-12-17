package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.Locale.Companion;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidStringDelegate_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\u0008\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0008\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"stringDelegate", "Landroidx/compose/ui/text/PlatformStringDelegate;", "capitalize", "", "locale", "Landroidx/compose/ui/text/intl/Locale;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "decapitalize", "toLowerCase", "toUpperCase", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringKt {

    private static final androidx.compose.ui.text.PlatformStringDelegate stringDelegate;
    static {
        StringKt.stringDelegate = AndroidStringDelegate_androidKt.ActualStringDelegate();
    }

    public static final String capitalize(String $this$capitalize, Locale locale) {
        return StringKt.stringDelegate.capitalize($this$capitalize, locale.getPlatformLocale());
    }

    public static final String capitalize(String $this$capitalize, LocaleList localeList) {
        Locale current;
        if (localeList.isEmpty()) {
            current = Locale.Companion.getCurrent();
        } else {
            current = localeList.get(0);
        }
        return StringKt.capitalize($this$capitalize, current);
    }

    public static final String decapitalize(String $this$decapitalize, Locale locale) {
        return StringKt.stringDelegate.decapitalize($this$decapitalize, locale.getPlatformLocale());
    }

    public static final String decapitalize(String $this$decapitalize, LocaleList localeList) {
        Locale current;
        if (localeList.isEmpty()) {
            current = Locale.Companion.getCurrent();
        } else {
            current = localeList.get(0);
        }
        return StringKt.decapitalize($this$decapitalize, current);
    }

    public static final String toLowerCase(String $this$toLowerCase, Locale locale) {
        return StringKt.stringDelegate.toLowerCase($this$toLowerCase, locale.getPlatformLocale());
    }

    public static final String toLowerCase(String $this$toLowerCase, LocaleList localeList) {
        Locale current;
        if (localeList.isEmpty()) {
            current = Locale.Companion.getCurrent();
        } else {
            current = localeList.get(0);
        }
        return StringKt.toLowerCase($this$toLowerCase, current);
    }

    public static final String toUpperCase(String $this$toUpperCase, Locale locale) {
        return StringKt.stringDelegate.toUpperCase($this$toUpperCase, locale.getPlatformLocale());
    }

    public static final String toUpperCase(String $this$toUpperCase, LocaleList localeList) {
        Locale current;
        if (localeList.isEmpty()) {
            current = Locale.Companion.getCurrent();
        } else {
            current = localeList.get(0);
        }
        return StringKt.toUpperCase($this$toUpperCase, current);
    }
}
