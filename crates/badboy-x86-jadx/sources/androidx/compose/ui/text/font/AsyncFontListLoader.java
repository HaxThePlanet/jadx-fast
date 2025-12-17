package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.YieldKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0012\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000c\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000e\u0010 \u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u0005H\u0080@¢\u0006\u0004\u0008#\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001e\u0010\u001f\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001d¨\u0006%", d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "cacheable", "", "getCacheable$ui_text_release", "()Z", "setCacheable$ui_text_release", "(Z)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text_release", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AsyncFontListLoader implements State<Object> {

    public static final int $stable;
    private final androidx.compose.ui.text.font.AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable = true;
    private final List<androidx.compose.ui.text.font.Font> fontList;
    private final Function1<androidx.compose.ui.text.font.TypefaceResult.Immutable, Unit> onCompletion;
    private final androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader;
    private final androidx.compose.ui.text.font.TypefaceRequest typefaceRequest;
    private final MutableState value$delegate;
    static {
    }

    public AsyncFontListLoader(List<? extends androidx.compose.ui.text.font.Font> fontList, Object initialType, androidx.compose.ui.text.font.TypefaceRequest typefaceRequest, androidx.compose.ui.text.font.AsyncTypefaceCache asyncTypefaceCache, Function1<? super androidx.compose.ui.text.font.TypefaceResult.Immutable, Unit> onCompletion, androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader) {
        super();
        this.fontList = fontList;
        this.typefaceRequest = typefaceRequest;
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.onCompletion = onCompletion;
        this.platformFontLoader = platformFontLoader;
        int i = 0;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(initialType, i, 2, i);
        int i2 = 1;
    }

    public static final androidx.compose.ui.text.font.PlatformFontLoader access$getPlatformFontLoader$p(androidx.compose.ui.text.font.AsyncFontListLoader $this) {
        return $this.platformFontLoader;
    }

    private void setValue(Object <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.value$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.runtime.State
    public final boolean getCacheable$ui_text_release() {
        return this.cacheable;
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.value$delegate.getValue();
    }

    public final Object load(Continuation<? super Unit> continuation) {
        Object obj3;
        androidx.compose.ui.text.font.AsyncFontListLoader.load.1 list2;
        boolean index$iv;
        int index$iv2;
        int active;
        androidx.compose.ui.text.font.AsyncFontListLoader list3;
        Object $i$a$FastForEachAsyncFontListLoader$load$22;
        int $i$f$fastForEach;
        int i4;
        Object $result2;
        int $result;
        Object $i$a$FastForEachAsyncFontListLoader$load$2;
        boolean z;
        int i5;
        int $i$f$fastForEach2;
        int i;
        int font;
        Object async-PKNRLFQ;
        Object l$2;
        Object obj;
        Object $this$fastForEach$iv;
        Object l$1;
        Object l$0;
        androidx.compose.ui.text.font.AsyncFontListLoader.load.1 list;
        int i2;
        Object obj2;
        int i3;
        obj3 = continuation;
        index$iv = obj3;
        i4 = Integer.MIN_VALUE;
        if (obj3 instanceof AsyncFontListLoader.load.1 && label2 &= i4 != 0) {
            index$iv = obj3;
            i4 = Integer.MIN_VALUE;
            if (label2 &= i4 != 0) {
                index$iv.label = label -= i4;
                list3 = this;
            } else {
                index$iv = new AsyncFontListLoader.load.1(this, obj3);
            }
        } else {
        }
        $result2 = index$iv.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = 0;
        i5 = 1;
        final int i9 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result2);
                $this$fastForEach$iv = this;
                $result = 0;
                list = index$iv;
                index$iv2 = $i$f$fastForEach2;
                i2 = font;
                obj2 = $this$fastForEach$iv;
                break;
            case 1:
                font = index$iv.I$0;
                l$2 = index$iv.L$2;
                l$1 = index$iv.L$1;
                ResultKt.throwOnFailure($result2);
                i2 = i$1;
                obj2 = l$0;
                i = $i$a$FastForEachAsyncFontListLoader$load$23;
                $i$f$fastForEach = i7;
                $i$a$FastForEachAsyncFontListLoader$load$2 = $result2;
                obj2.setValue(FontSynthesis_androidKt.synthesizeTypeface-FxwP2eA(obj2.typefaceRequest.getFontSynthesis-GVVA2EU(), $result2, l$2, obj2.typefaceRequest.getFontWeight(), obj2.typefaceRequest.getFontStyle-_-LCdwA()));
                obj2.cacheable = i9;
                i5 = i9;
                TypefaceResult.Immutable immutable3 = new TypefaceResult.Immutable(obj2.getValue(), i5);
                obj2.onCompletion.invoke(immutable3);
                return Unit.INSTANCE;
                index$iv.L$0 = obj2;
                index$iv.L$1 = l$1;
                index$iv.L$2 = i8;
                index$iv.I$0 = font;
                index$iv.I$1 = i2;
                index$iv.label = 2;
                return cOROUTINE_SUSPENDED;
                $result2 = $i$a$FastForEachAsyncFontListLoader$load$2;
                $result = i;
                async-PKNRLFQ = l$1;
                $i$f$fastForEach2 = i2;
                $this$fastForEach$iv = obj2;
                list = index$iv;
                i2 = $i$f$fastForEach2;
                index$iv2 = font;
                $i$a$FastForEachAsyncFontListLoader$load$22 = async-PKNRLFQ;
                obj2 = $this$fastForEach$iv;
                index$iv2 += i5;
                break;
            case 2:
                $i$f$fastForEach = 0;
                $result = 0;
                $i$f$fastForEach2 = index$iv.I$1;
                font = index$iv.I$0;
                async-PKNRLFQ = index$iv.L$1;
                $this$fastForEach$iv = index$iv.L$0;
                ResultKt.throwOnFailure($result2);
                list = index$iv;
                i2 = $i$f$fastForEach2;
                index$iv2 = font;
                $i$a$FastForEachAsyncFontListLoader$load$22 = async-PKNRLFQ;
                obj2 = $this$fastForEach$iv;
                index$iv2 += i5;
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
        }
        if (index$iv2 < i2) {
            font = obj4;
            if (FontLoadingStrategy.equals-impl0((Font)font.getLoadingStrategy-PKNRLFQ(), FontLoadingStrategy.Companion.getAsync-PKNRLFQ())) {
            } else {
            }
        }
        obj2.cacheable = i9;
        if (JobKt.isActive(list.getContext())) {
        } else {
            i5 = i9;
        }
        TypefaceResult.Immutable immutable = new TypefaceResult.Immutable(obj2.getValue(), i5);
        obj2.onCompletion.invoke(immutable);
        return Unit.INSTANCE;
    }

    public final Object loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font font, Continuation<Object> continuation2) {
        boolean anon;
        Throwable active;
        Object cOROUTINE_SUSPENDED;
        CoroutineContext context2;
        androidx.compose.ui.text.font.AsyncFontListLoader label;
        Object timeoutOrNull;
        androidx.compose.ui.text.font.AsyncFontListLoader.loadWithTimeoutOrNull.2 context;
        int illegalStateException;
        long append;
        String str;
        Object obj9;
        Object obj10;
        anon = continuation2;
        context2 = Integer.MIN_VALUE;
        if (continuation2 instanceof AsyncFontListLoader.loadWithTimeoutOrNull.1 && label2 &= context2 != 0) {
            anon = continuation2;
            context2 = Integer.MIN_VALUE;
            if (label2 &= context2 != 0) {
                anon.label = obj10 -= context2;
            } else {
                anon = new AsyncFontListLoader.loadWithTimeoutOrNull.1(this, continuation2);
            }
        } else {
        }
        obj10 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                context = new AsyncFontListLoader.loadWithTimeoutOrNull.2(this, font, 0);
                anon.L$0 = font;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                obj9 = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                timeoutOrNull = obj10;
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        return timeoutOrNull;
    }

    @Override // androidx.compose.runtime.State
    public final void setCacheable$ui_text_release(boolean <set-?>) {
        this.cacheable = <set-?>;
    }
}
