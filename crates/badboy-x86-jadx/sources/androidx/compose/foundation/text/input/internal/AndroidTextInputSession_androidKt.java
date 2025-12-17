package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a \u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00020\rH\u0002\u001al\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0081@¢\u0006\u0002\u0010\"\u001ah\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n\u0018\u00010\u001a2\u0010\u0008\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001f2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0080@¢\u0006\u0002\u0010#\"\u0016\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007\"\u000e\u0010\u0008\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"ALL_MIME_TYPES", "", "", "[Ljava/lang/String;", "TIA_DEBUG", "", "getTIA_DEBUG$annotations", "()V", "TIA_TAG", "logDebug", "", "tag", "content", "Lkotlin/Function0;", "platformSpecificTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "onImeAction", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "stylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lkotlinx/coroutines/flow/MutableSharedFlow;Landroidx/compose/ui/platform/ViewConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/flow/MutableSharedFlow;Landroidx/compose/ui/platform/ViewConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidTextInputSession_androidKt {

    private static final String[] ALL_MIME_TYPES = null;
    public static final boolean TIA_DEBUG = false;
    private static final String TIA_TAG = "AndroidTextInputSession";
    static {
        String[] strArr = new String[3];
        AndroidTextInputSession_androidKt.ALL_MIME_TYPES = strArr;
    }

    public static final String[] access$getALL_MIME_TYPES$p() {
        return AndroidTextInputSession_androidKt.ALL_MIME_TYPES;
    }

    public static void getTIA_DEBUG$annotations() {
    }

    private static final void logDebug(String tag, Function0<String> content) {
    }

    static void logDebug$default(String string, Function0 function02, int i3, Object object4) {
        String obj0;
        if (i3 &= 1 != 0) {
            obj0 = "AndroidTextInputSession";
        }
        AndroidTextInputSession_androidKt.logDebug(obj0, function02);
    }

    public static final Object platformSpecificTextInputSession(PlatformTextInputSession platformTextInputSession, androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState2, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState3, ImeOptions imeOptions4, ReceiveContentConfiguration receiveContentConfiguration5, Function1<? super ImeAction, Unit> function16, androidx.compose.foundation.text.input.internal.ComposeInputMethodManager composeInputMethodManager7, MutableSharedFlow<Unit> mutableSharedFlow8, ViewConfiguration viewConfiguration9, Continuation<?> continuation10) {
        Object obj;
        boolean anon2;
        int i;
        int i2;
        androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt.platformSpecificTextInputSession.3 anon;
        MutableSharedFlow mutableSharedFlow;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState field;
        androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState;
        androidx.compose.foundation.text.input.internal.ComposeInputMethodManager method;
        PlatformTextInputSession platformTextInputSession2;
        ImeOptions imeOptions;
        ReceiveContentConfiguration receiveContentConfiguration;
        Function1 function1;
        ViewConfiguration view;
        int i3;
        Object obj15;
        obj = continuation10;
        anon2 = obj;
        i2 = Integer.MIN_VALUE;
        if (obj instanceof AndroidTextInputSession_androidKt.platformSpecificTextInputSession.2 && label2 &= i2 != 0) {
            anon2 = obj;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon2.label = label -= i2;
            } else {
                anon2 = new AndroidTextInputSession_androidKt.platformSpecificTextInputSession.2(obj);
            }
        } else {
        }
        Object result = anon2.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(result);
                anon = new AndroidTextInputSession_androidKt.platformSpecificTextInputSession.3(mutableSharedFlow8, transformedTextFieldState2, textLayoutState3, composeInputMethodManager7, platformTextInputSession, imeOptions4, receiveContentConfiguration5, function16, viewConfiguration9, 0);
                anon2.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(result);
                break;
            default:
                obj15 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj15;
        }
        obj15 = new KotlinNothingValueException();
        throw obj15;
    }

    public static final Object platformSpecificTextInputSession(PlatformTextInputSession platformTextInputSession, androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState2, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState3, ImeOptions imeOptions4, ReceiveContentConfiguration receiveContentConfiguration5, Function1<? super ImeAction, Unit> function16, MutableSharedFlow<Unit> mutableSharedFlow7, ViewConfiguration viewConfiguration8, Continuation<?> continuation9) {
        Object obj;
        boolean anon;
        int i;
        PlatformTextInputSession label;
        int i2;
        androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState;
        ImeOptions imeOptions;
        ReceiveContentConfiguration receiveContentConfiguration;
        Function1 function1;
        androidx.compose.foundation.text.input.internal.ComposeInputMethodManager method;
        MutableSharedFlow mutableSharedFlow;
        ViewConfiguration view;
        Object obj12;
        obj = continuation9;
        anon = obj;
        i2 = Integer.MIN_VALUE;
        if (obj instanceof AndroidTextInputSession_androidKt.platformSpecificTextInputSession.1 && label3 &= i2 != 0) {
            anon = obj;
            i2 = Integer.MIN_VALUE;
            if (label3 &= i2 != 0) {
                anon.label = label2 -= i2;
            } else {
                anon = new AndroidTextInputSession_androidKt.platformSpecificTextInputSession.1(obj);
            }
        } else {
        }
        final androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt.platformSpecificTextInputSession.1 anon2 = anon;
        Object result = anon2.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(result);
                label = platformTextInputSession;
                anon2.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(result);
                break;
            default:
                obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj12;
        }
        obj12 = new KotlinNothingValueException();
        throw obj12;
    }

    public static Object platformSpecificTextInputSession$default(PlatformTextInputSession platformTextInputSession, androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState2, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState3, ImeOptions imeOptions4, ReceiveContentConfiguration receiveContentConfiguration5, Function1 function16, MutableSharedFlow mutableSharedFlow7, ViewConfiguration viewConfiguration8, Continuation continuation9, int i10, Object object11) {
        int obj7;
        int obj8;
        final int i = 0;
        if (i10 & 32 != 0) {
            obj7 = i;
        }
        if (i10 &= 64 != 0) {
            obj8 = i;
        }
        return AndroidTextInputSession_androidKt.platformSpecificTextInputSession(platformTextInputSession, transformedTextFieldState2, textLayoutState3, imeOptions4, receiveContentConfiguration5, function16, obj7, obj8, continuation9);
    }
}
