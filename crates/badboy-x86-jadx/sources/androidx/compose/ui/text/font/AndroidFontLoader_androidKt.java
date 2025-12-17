package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"load", "Landroid/graphics/Typeface;", "Landroidx/compose/ui/text/font/ResourceFont;", "context", "Landroid/content/Context;", "loadAsync", "(Landroidx/compose/ui/text/font/ResourceFont;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidFontLoader_androidKt {
    public static final Typeface access$load(androidx.compose.ui.text.font.ResourceFont $receiver, Context context) {
        return AndroidFontLoader_androidKt.load($receiver, context);
    }

    public static final Object access$loadAsync(androidx.compose.ui.text.font.ResourceFont $receiver, Context context, Continuation $completion) {
        return AndroidFontLoader_androidKt.loadAsync($receiver, context, $completion);
    }

    private static final Typeface load(androidx.compose.ui.text.font.ResourceFont $this$load, Context context) {
        Typeface font = ResourcesCompat.getFont(context, $this$load.getResId());
        Intrinsics.checkNotNull(font);
        return font;
    }

    private static final Object loadAsync(androidx.compose.ui.text.font.ResourceFont $this$loadAsync, Context context, Continuation<? super Typeface> $completion) {
        final int i = 0;
        int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        int i4 = 0;
        AndroidFontLoader_androidKt.loadAsync.2.1 anon = new AndroidFontLoader_androidKt.loadAsync.2.1((CancellableContinuation)cancellableContinuationImpl, $this$loadAsync);
        ResourcesCompat.getFont(context, $this$loadAsync.getResId(), (ResourcesCompat.FontCallback)anon, 0);
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont$iv;
    }
}
