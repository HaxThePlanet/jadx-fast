package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.DispatcherKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJB\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00190\u0016H\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/FontFamilyTypefaceAdapter;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "injectedContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/coroutines/CoroutineContext;)V", "asyncLoadScope", "Lkotlinx/coroutines/CoroutineScope;", "preload", "", "family", "Landroidx/compose/ui/text/font/FontFamily;", "resourceLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/PlatformFontLoader;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/ui/text/font/TypefaceResult;", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "platformFontLoader", "onAsyncCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "createDefaultTypeface", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontListFontFamilyTypefaceAdapter implements androidx.compose.ui.text.font.FontFamilyTypefaceAdapter {

    public static final int $stable = 8;
    public static final androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter.Companion Companion;
    private static final CoroutineExceptionHandler DropExceptionHandler;
    private static final androidx.compose.ui.text.font.FontMatcher fontMatcher;
    private CoroutineScope asyncLoadScope;
    private final androidx.compose.ui.text.font.AsyncTypefaceCache asyncTypefaceCache;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter$Companion;", "", "()V", "DropExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getDropExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final CoroutineExceptionHandler getDropExceptionHandler() {
            return FontListFontFamilyTypefaceAdapter.access$getDropExceptionHandler$cp();
        }

        public final androidx.compose.ui.text.font.FontMatcher getFontMatcher() {
            return FontListFontFamilyTypefaceAdapter.access$getFontMatcher$cp();
        }
    }
    static {
        FontListFontFamilyTypefaceAdapter.Companion companion = new FontListFontFamilyTypefaceAdapter.Companion(0);
        FontListFontFamilyTypefaceAdapter.Companion = companion;
        int i = 8;
        FontMatcher fontMatcher = new FontMatcher();
        FontListFontFamilyTypefaceAdapter.fontMatcher = fontMatcher;
        int i2 = 0;
        FontListFontFamilyTypefaceAdapter.special$$inlined.CoroutineExceptionHandler.1 anon = new FontListFontFamilyTypefaceAdapter.special$$inlined.CoroutineExceptionHandler.1(CoroutineExceptionHandler.Key);
        FontListFontFamilyTypefaceAdapter.DropExceptionHandler = (CoroutineExceptionHandler)anon;
    }

    public FontListFontFamilyTypefaceAdapter() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public FontListFontFamilyTypefaceAdapter(androidx.compose.ui.text.font.AsyncTypefaceCache asyncTypefaceCache, CoroutineContext injectedContext) {
        super();
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.asyncLoadScope = CoroutineScopeKt.CoroutineScope(FontListFontFamilyTypefaceAdapter.DropExceptionHandler.plus((CoroutineContext)DispatcherKt.getFontCacheManagementDispatcher()).plus(injectedContext).plus((CoroutineContext)SupervisorKt.SupervisorJob((Job)injectedContext.get((CoroutineContext.Key)Job.Key))));
    }

    public FontListFontFamilyTypefaceAdapter(androidx.compose.ui.text.font.AsyncTypefaceCache asyncTypefaceCache, CoroutineContext coroutineContext2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        androidx.compose.ui.text.font.AsyncTypefaceCache obj1;
        EmptyCoroutineContext obj2;
        if (i3 & 1 != 0) {
            obj1 = new AsyncTypefaceCache();
        }
        if (i3 &= 2 != 0) {
            obj2 = EmptyCoroutineContext.INSTANCE;
        }
        super(obj1, obj2);
    }

    public static final androidx.compose.ui.text.font.AsyncTypefaceCache access$getAsyncTypefaceCache$p(androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter $this) {
        return $this.asyncTypefaceCache;
    }

    public static final CoroutineExceptionHandler access$getDropExceptionHandler$cp() {
        return FontListFontFamilyTypefaceAdapter.DropExceptionHandler;
    }

    public static final androidx.compose.ui.text.font.FontMatcher access$getFontMatcher$cp() {
        return FontListFontFamilyTypefaceAdapter.fontMatcher;
    }

    public final Object preload(androidx.compose.ui.text.font.FontFamily family, androidx.compose.ui.text.font.PlatformFontLoader resourceLoader, Continuation<? super Unit> $completion) {
        List fonts2;
        boolean equals-impl0;
        ArrayList list;
        int matched;
        Object obj;
        int i5;
        int component1;
        HashSet hashSet;
        ArrayList arrayList;
        ArrayList iNSTANCE;
        int index$iv$iv3;
        int cacheKey;
        int index$iv$iv;
        int index$iv$iv2;
        List fonts;
        int size;
        Object obj2;
        Object obj3;
        int i3;
        Object obj4;
        int i4;
        int index$iv;
        List list2;
        List $this$fastFilter$iv;
        ArrayList $this$fastMap$iv;
        androidx.compose.ui.text.font.FontLoadingStrategy.Companion style-_-LCdwA;
        int i;
        int i2;
        final Object obj5 = this;
        obj = family;
        final androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader = resourceLoader;
        if (!obj instanceof FontListFontFamily) {
            return Unit.INSTANCE;
        }
        fonts = (FontListFontFamily)obj.getFonts();
        fonts2 = (FontListFontFamily)obj.getFonts();
        int i7 = 0;
        ArrayList arrayList4 = new ArrayList(fonts2.size());
        List list7 = fonts2;
        int i9 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list7.size()) {
            obj3 = obj2;
            i3 = 0;
            i4 = 0;
            if (FontLoadingStrategy.equals-impl0((Font)obj3.getLoadingStrategy-PKNRLFQ(), FontLoadingStrategy.Companion.getAsync-PKNRLFQ())) {
            }
            index$iv$iv++;
            obj = family;
            fonts2 = list2;
            (Collection)arrayList4.add(obj3);
        }
        $this$fastFilter$iv = fonts2;
        list = arrayList4;
        i5 = 0;
        ArrayList arrayList3 = new ArrayList((List)list.size());
        ArrayList list6 = list;
        int i8 = 0;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < list6.size()) {
            obj3 = 0;
            obj4 = obj2;
            i4 = 0;
            (Collection)arrayList3.add(TuplesKt.to((Font)obj4.getWeight(), FontStyle.box-impl(obj4.getStyle-_-LCdwA())));
            index$iv$iv3++;
            list = $this$fastFilter$iv;
            i5 = i;
        }
        $this$fastMap$iv = list;
        i2 = i5;
        ArrayList list3 = arrayList3;
        component1 = 0;
        hashSet = new HashSet((List)list3.size());
        arrayList = new ArrayList(list3.size());
        iNSTANCE = list3;
        cacheKey = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < iNSTANCE.size()) {
            obj3 = obj2;
            i3 = 0;
            int i11 = 0;
            if (hashSet.add((Pair)obj3)) {
            }
            index$iv$iv2++;
            (Collection)arrayList.add(obj3);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList list9 = arrayList2;
        ArrayList list10 = list8;
        int i10 = 0;
        index$iv = matched;
        while (index$iv < list10.size()) {
            ArrayList list4 = $this$fastMap$iv;
            style-_-LCdwA = 0;
            hashSet = component12;
            arrayList = (FontStyle)list4.component2().unbox-impl();
            matched = new TypefaceRequest(family, hashSet, arrayList, FontSynthesis.Companion.getAll-GVVA2EU(), platformFontLoader.getCacheKey(), 0);
            component1 = FontListFontFamilyTypefaceAdapterKt.access$firstImmediatelyAvailable(FontListFontFamilyTypefaceAdapter.fontMatcher.matchFont-RetOiIg(fonts, (FontWeight)hashSet, arrayList), matched, obj5.asyncTypefaceCache, platformFontLoader, (Function1)FontListFontFamilyTypefaceAdapter.preload.2.1.INSTANCE).component1();
            if ((List)component1 != 0) {
            }
            index$iv++;
            fonts = i2;
            (List)list9.add(CollectionsKt.first((List)component1));
        }
        List allFonts2 = fonts;
        FontListFontFamilyTypefaceAdapter.preload.3 anon = new FontListFontFamilyTypefaceAdapter.preload.3(list9, obj5, platformFontLoader, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    public androidx.compose.ui.text.font.TypefaceResult resolve(androidx.compose.ui.text.font.TypefaceRequest typefaceRequest, androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader, Function1<? super androidx.compose.ui.text.font.TypefaceResult.Immutable, Unit> onAsyncCompletion, Function1<? super androidx.compose.ui.text.font.TypefaceRequest, ? extends Object> createDefaultTypeface) {
        final Object obj = this;
        int i = 0;
        if (!fontFamily instanceof FontListFontFamily) {
            return i;
        }
        final androidx.compose.ui.text.font.TypefaceRequest request = typefaceRequest;
        final androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader2 = platformFontLoader;
        Pair pair = FontListFontFamilyTypefaceAdapterKt.access$firstImmediatelyAvailable(FontListFontFamilyTypefaceAdapter.fontMatcher.matchFont-RetOiIg((FontListFontFamily)typefaceRequest.getFontFamily().getFonts(), typefaceRequest.getFontWeight(), typefaceRequest.getFontStyle-_-LCdwA()), request, obj.asyncTypefaceCache, platformFontLoader2, createDefaultTypeface);
        Object obj2 = component1;
        final Object component2 = pair.component2();
        if ((List)obj2 == null) {
            TypefaceResult.Immutable immutable = new TypefaceResult.Immutable(component2, 0, 2, i);
            return (TypefaceResult)immutable;
        }
        AsyncFontListLoader asyncFontListLoader = new AsyncFontListLoader((List)obj2, component2, request, obj.asyncTypefaceCache, onAsyncCompletion, platformFontLoader2);
        FontListFontFamilyTypefaceAdapter.resolve.1 anon = new FontListFontFamilyTypefaceAdapter.resolve.1(asyncFontListLoader, i);
        BuildersKt.launch$default(obj.asyncLoadScope, 0, CoroutineStart.UNDISPATCHED, (Function2)anon, 1, 0);
        TypefaceResult.Async async = new TypefaceResult.Async(asyncFontListLoader);
        return (TypefaceResult)async;
    }
}
