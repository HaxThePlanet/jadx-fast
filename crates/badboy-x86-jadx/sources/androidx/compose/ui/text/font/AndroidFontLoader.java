package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\u0002\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "kotlin.jvm.PlatformType", "awaitLoad", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidFontLoader implements androidx.compose.ui.text.font.PlatformFontLoader {

    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;
    static {
        final int i = 8;
    }

    public AndroidFontLoader(Context context) {
        super();
        this.context = context.getApplicationContext();
    }

    public Object awaitLoad(androidx.compose.ui.text.font.Font font, Continuation<? super Typeface> continuation2) {
        boolean anon;
        int i2;
        Object l$0;
        int i3;
        int label;
        androidx.compose.ui.text.font.AndroidFont.TypefaceLoader typefaceLoader;
        Object obj;
        Context context;
        Object obj2;
        int i;
        Object obj8;
        Object obj9;
        anon = continuation2;
        i3 = Integer.MIN_VALUE;
        if (continuation2 instanceof AndroidFontLoader.awaitLoad.1 && label2 &= i3 != 0) {
            anon = continuation2;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon.label = obj9 -= i3;
            } else {
                anon = new AndroidFontLoader.awaitLoad.1(this, continuation2);
            }
        } else {
        }
        obj9 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                label = this;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                anon.L$0 = label;
                anon.L$1 = font;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                l$0 = label;
                return PlatformTypefaces_androidKt.setFontVariationSettings((Typeface)obj, (ResourceFont)obj8.getVariationSettings(), l$0.context);
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException _this = new IllegalArgumentException(stringBuilder.append("Unknown font type: ").append(font).toString());
                throw _this;
            case 1:
                ResultKt.throwOnFailure(obj9);
                obj8 = obj9;
                break;
            case 2:
                obj8 = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                obj = obj9;
                return PlatformTypefaces_androidKt.setFontVariationSettings((Typeface)obj, (ResourceFont)obj8.getVariationSettings(), l$0.context);
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        return obj8;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Typeface loadBlocking(androidx.compose.ui.text.font.Font font) {
        Typeface fontVariationSettings;
        Typeface typeface2;
        Object constructor-impl;
        Context variationSettings;
        Object companion;
        boolean failure-impl;
        int i;
        Typeface typeface;
        Context context;
        if (font instanceof AndroidFont) {
            fontVariationSettings = (AndroidFont)font.getTypefaceLoader().loadBlocking(this.context, (AndroidFont)font);
        } else {
            if (font instanceof ResourceFont) {
                int loadingStrategy-PKNRLFQ = font.getLoadingStrategy-PKNRLFQ();
                if (FontLoadingStrategy.equals-impl0(loadingStrategy-PKNRLFQ, FontLoadingStrategy.Companion.getBlocking-PKNRLFQ())) {
                    typeface2 = AndroidFontLoader_androidKt.access$load((ResourceFont)font, this.context);
                    fontVariationSettings = PlatformTypefaces_androidKt.setFontVariationSettings(typeface2, (ResourceFont)font.getVariationSettings(), this.context);
                } else {
                    if (FontLoadingStrategy.equals-impl0(loadingStrategy-PKNRLFQ, FontLoadingStrategy.Companion.getOptionalLocal-PKNRLFQ())) {
                        kotlin.Result.Companion companion2 = Result.Companion;
                        i = 0;
                        constructor-impl = Result.constructor-impl(AndroidFontLoader_androidKt.access$load((ResourceFont)font, obj3.context));
                        if (Result.isFailure-impl(constructor-impl)) {
                        } else {
                            variationSettings = constructor-impl;
                        }
                        typeface2 = variationSettings;
                    } else {
                        if (FontLoadingStrategy.equals-impl0(loadingStrategy-PKNRLFQ, FontLoadingStrategy.Companion.getAsync-PKNRLFQ())) {
                            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unsupported Async font load path");
                            throw unsupportedOperationException;
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unknown loading type ").append(FontLoadingStrategy.toString-impl(font.getLoadingStrategy-PKNRLFQ())).toString());
                throw illegalArgumentException;
            }
            fontVariationSettings = variationSettings;
        }
        return fontVariationSettings;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object loadBlocking(androidx.compose.ui.text.font.Font font) {
        return loadBlocking(font);
    }
}
