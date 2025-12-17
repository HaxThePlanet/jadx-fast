package androidx.compose.foundation.text.input.internal;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import androidx.emoji2.text.EmojiCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0008\u0010\u000c\u001a\u00020\rH\u0000\u001a\u000c\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"0\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000b¨\u0006\u0011", d2 = {"DEBUG_CLASS", "", "inputMethodManagerFactory", "Lkotlin/Function1;", "Landroid/view/View;", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "getInputMethodManagerFactory$annotations", "()V", "getInputMethodManagerFactory", "()Lkotlin/jvm/functions/Function1;", "setInputMethodManagerFactory", "(Lkotlin/jvm/functions/Function1;)V", "createLegacyPlatformTextInputServiceAdapter", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "updateWithEmojiCompat", "", "Landroid/view/inputmethod/EditorInfo;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LegacyPlatformTextInputServiceAdapter_androidKt {

    private static final String DEBUG_CLASS = "AndroidLegacyPlatformTextInputServiceAdapter";
    private static Function1<? super View, ? extends androidx.compose.foundation.text.input.internal.InputMethodManager> inputMethodManagerFactory;
    static {
        LegacyPlatformTextInputServiceAdapter_androidKt.inputMethodManagerFactory = (Function1)LegacyPlatformTextInputServiceAdapter_androidKt.inputMethodManagerFactory.1.INSTANCE;
    }

    public static final void access$updateWithEmojiCompat(EditorInfo $receiver) {
        LegacyPlatformTextInputServiceAdapter_androidKt.updateWithEmojiCompat($receiver);
    }

    public static final androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter createLegacyPlatformTextInputServiceAdapter() {
        AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter = new AndroidLegacyPlatformTextInputServiceAdapter();
        return (LegacyPlatformTextInputServiceAdapter)androidLegacyPlatformTextInputServiceAdapter;
    }

    public static final Function1<View, androidx.compose.foundation.text.input.internal.InputMethodManager> getInputMethodManagerFactory() {
        return LegacyPlatformTextInputServiceAdapter_androidKt.inputMethodManagerFactory;
    }

    public static void getInputMethodManagerFactory$annotations() {
    }

    public static final void setInputMethodManagerFactory(Function1<? super View, ? extends androidx.compose.foundation.text.input.internal.InputMethodManager> <set-?>) {
        LegacyPlatformTextInputServiceAdapter_androidKt.inputMethodManagerFactory = <set-?>;
    }

    private static final void updateWithEmojiCompat(EditorInfo $this$updateWithEmojiCompat) {
        if (!EmojiCompat.isConfigured()) {
        }
        EmojiCompat.get().updateEditorInfo($this$updateWithEmojiCompat);
    }
}
