package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J:\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00192\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J\u0016\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\"\u001a\u00020\u000fH\u0002R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006#", d2 = {"Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformResolveInterceptor", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "typefaceRequestCache", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "fontListFontFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "platformFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "(Landroidx/compose/ui/text/font/PlatformFontLoader;Landroidx/compose/ui/text/font/PlatformResolveInterceptor;Landroidx/compose/ui/text/font/TypefaceRequestCache;Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;)V", "createDefaultTypeface", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "", "getPlatformFontLoader$ui_text_release", "()Landroidx/compose/ui/text/font/PlatformFontLoader;", "preload", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/runtime/State;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "typefaceRequest", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontFamilyResolverImpl implements androidx.compose.ui.text.font.FontFamily.Resolver {

    public static final int $stable = 8;
    private final Function1<androidx.compose.ui.text.font.TypefaceRequest, Object> createDefaultTypeface;
    private final androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    private final androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;
    private final androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader;
    private final androidx.compose.ui.text.font.PlatformResolveInterceptor platformResolveInterceptor;
    private final androidx.compose.ui.text.font.TypefaceRequestCache typefaceRequestCache;
    static {
        final int i = 8;
    }

    public FontFamilyResolverImpl(androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader, androidx.compose.ui.text.font.PlatformResolveInterceptor platformResolveInterceptor, androidx.compose.ui.text.font.TypefaceRequestCache typefaceRequestCache, androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter) {
        super();
        this.platformFontLoader = platformFontLoader;
        this.platformResolveInterceptor = platformResolveInterceptor;
        this.typefaceRequestCache = typefaceRequestCache;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = platformFamilyTypefaceAdapter;
        FontFamilyResolverImpl.createDefaultTypeface.1 anon = new FontFamilyResolverImpl.createDefaultTypeface.1(this);
        this.createDefaultTypeface = (Function1)anon;
    }

    public FontFamilyResolverImpl(androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader, androidx.compose.ui.text.font.PlatformResolveInterceptor platformResolveInterceptor2, androidx.compose.ui.text.font.TypefaceRequestCache typefaceRequestCache3, androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter4, androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        androidx.compose.ui.text.font.PlatformResolveInterceptor platformResolveInterceptor;
        androidx.compose.ui.text.font.TypefaceRequestCache request;
        androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter list;
        androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter;
        androidx.compose.ui.text.font.PlatformResolveInterceptor obj8;
        androidx.compose.ui.text.font.TypefaceRequestCache obj9;
        androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter obj10;
        androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter obj11;
        int obj13;
        if (i6 & 2 != 0) {
            platformResolveInterceptor = obj8;
        } else {
            platformResolveInterceptor = platformResolveInterceptor2;
        }
        if (i6 & 4 != 0) {
            request = obj9;
        } else {
            request = typefaceRequestCache3;
        }
        if (i6 & 8 != 0) {
            obj9 = 0;
            obj10 = new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), obj9, 2, obj9);
            list = obj10;
        } else {
            list = fontListFontFamilyTypefaceAdapter4;
        }
        if (i6 & 16 != 0) {
            obj11 = new PlatformFontFamilyTypefaceAdapter();
            platformFontFamilyTypefaceAdapter = obj11;
        } else {
            platformFontFamilyTypefaceAdapter = platformFontFamilyTypefaceAdapter5;
        }
        super(platformFontLoader, platformResolveInterceptor, request, list, platformFontFamilyTypefaceAdapter);
    }

    public static final Function1 access$getCreateDefaultTypeface$p(androidx.compose.ui.text.font.FontFamilyResolverImpl $this) {
        return $this.createDefaultTypeface;
    }

    public static final androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter access$getFontListFontFamilyTypefaceAdapter$p(androidx.compose.ui.text.font.FontFamilyResolverImpl $this) {
        return $this.fontListFontFamilyTypefaceAdapter;
    }

    public static final androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter access$getPlatformFamilyTypefaceAdapter$p(androidx.compose.ui.text.font.FontFamilyResolverImpl $this) {
        return $this.platformFamilyTypefaceAdapter;
    }

    public static final State access$resolve(androidx.compose.ui.text.font.FontFamilyResolverImpl $this, androidx.compose.ui.text.font.TypefaceRequest typefaceRequest) {
        return $this.resolve(typefaceRequest);
    }

    private final State<Object> resolve(androidx.compose.ui.text.font.TypefaceRequest typefaceRequest) {
        FontFamilyResolverImpl.resolve.result.1 anon = new FontFamilyResolverImpl.resolve.result.1(this, typefaceRequest);
        return this.typefaceRequestCache.runCached(typefaceRequest, (Function1)anon);
    }

    @Override // androidx.compose.ui.text.font.FontFamily$Resolver
    public final androidx.compose.ui.text.font.PlatformFontLoader getPlatformFontLoader$ui_text_release() {
        return this.platformFontLoader;
    }

    public Object preload(androidx.compose.ui.text.font.FontFamily fontFamily, Continuation<? super Unit> continuation2) {
        Object obj;
        Object result;
        boolean anon2;
        int i;
        androidx.compose.ui.text.font.FontFamilyResolverImpl fontFamilyResolverImpl;
        Object l$1;
        int i5;
        Object l$0;
        int label;
        Object preload;
        androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader;
        int i2;
        int index$iv$iv;
        Object obj2;
        Object obj3;
        int i4;
        ArrayList list;
        Object obj4;
        int i3;
        androidx.compose.ui.text.font.TypefaceRequest typefaceRequest;
        androidx.compose.ui.text.font.FontFamily interceptFontFamily;
        androidx.compose.ui.text.font.FontWeight interceptFontWeight;
        int interceptFontStyle-T2F_aPo;
        int all-GVVA2EU;
        Object cacheKey;
        int i6;
        androidx.compose.ui.text.font.FontFamilyResolverImpl.preload.1 anon;
        Object obj26;
        obj = continuation2;
        anon2 = obj;
        i5 = Integer.MIN_VALUE;
        if (obj instanceof FontFamilyResolverImpl.preload.1 && label3 &= i5 != 0) {
            anon2 = obj;
            i5 = Integer.MIN_VALUE;
            if (label3 &= i5 != 0) {
                anon2.label = label2 -= i5;
                fontFamilyResolverImpl = this;
            } else {
                anon2 = new FontFamilyResolverImpl.preload.1(this, obj);
            }
        } else {
        }
        result = anon2.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(result);
                Object obj5 = this;
                label = fontFamily;
                return Unit.INSTANCE;
                anon2.L$0 = obj5;
                anon2.L$1 = label;
                anon2.label = 1;
                return cOROUTINE_SUSPENDED;
                l$0 = obj5;
                l$1 = label;
                break;
            case 1:
                l$1 = anon2.L$1;
                l$0 = anon2.L$0;
                ResultKt.throwOnFailure(result);
                break;
            default:
                obj26 = result;
                androidx.compose.ui.text.font.FontFamilyResolverImpl.preload.1 anon5 = anon2;
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        List fonts = (FontListFontFamily)l$1.getFonts();
        int i7 = 0;
        ArrayList arrayList = new ArrayList(fonts.size());
        int i8 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < fonts.size()) {
            i4 = 0;
            obj4 = obj3;
            i3 = 0;
            typefaceRequest = new TypefaceRequest(l$0.platformResolveInterceptor.interceptFontFamily(l$1), l$0.platformResolveInterceptor.interceptFontWeight((Font)obj4.getWeight()), l$0.platformResolveInterceptor.interceptFontStyle-T2F_aPo(obj4.getStyle-_-LCdwA()), FontSynthesis.Companion.getAll-GVVA2EU(), l$0.platformFontLoader.getCacheKey(), 0);
            (Collection)arrayList.add(typefaceRequest);
            index$iv$iv++;
            result = obj26;
            anon2 = anon;
        }
        obj26 = result;
        androidx.compose.ui.text.font.FontFamilyResolverImpl.preload.1 anon4 = anon2;
        FontFamilyResolverImpl.preload.2 anon3 = new FontFamilyResolverImpl.preload.2(l$0);
        l$0.typefaceRequestCache.preWarmCache((List)arrayList, (Function1)anon3);
        return Unit.INSTANCE;
    }

    public State<Object> resolve-DPcqOEQ(androidx.compose.ui.text.font.FontFamily fontFamily, androidx.compose.ui.text.font.FontWeight fontWeight, int fontStyle, int fontSynthesis) {
        TypefaceRequest typefaceRequest = new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(fontFamily), this.platformResolveInterceptor.interceptFontWeight(fontWeight), this.platformResolveInterceptor.interceptFontStyle-T2F_aPo(fontStyle), this.platformResolveInterceptor.interceptFontSynthesis-Mscr08Y(fontSynthesis), this.platformFontLoader.getCacheKey(), 0);
        return resolve(typefaceRequest);
    }
}
