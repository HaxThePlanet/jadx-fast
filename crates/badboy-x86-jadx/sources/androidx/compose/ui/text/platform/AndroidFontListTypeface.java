package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import androidx.compose.ui.text.font.FontLoadingStrategy.Companion;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Deprecated(message = "This is not supported after downloadable fonts.")
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\u0008\u0002\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ*\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u000eX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u00020\u000c¢\u0006\n\n\u0002\u0008\u0013\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006 ", d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface;", "Landroidx/compose/ui/text/platform/AndroidTypeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontListFontFamily;", "context", "Landroid/content/Context;", "necessaryStyles", "", "Lkotlin/Pair;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroid/content/Context;Ljava/util/List;Landroidx/compose/ui/text/font/FontMatcher;)V", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "fontMatcher$1", "loadedTypefaces", "", "Landroidx/compose/ui/text/font/Font;", "Landroid/graphics/Typeface;", "getNativeTypeface", "fontWeight", "fontStyle", "synthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNativeTypeface-PYhJU0U", "(Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidFontListTypeface implements androidx.compose.ui.text.platform.AndroidTypeface {

    public static final int $stable = 8;
    private static final androidx.compose.ui.text.platform.AndroidFontListTypeface.Companion Companion;
    private static final FontMatcher fontMatcher;
    private final FontFamily fontFamily;
    private final FontMatcher fontMatcher$1;
    private final Map<Font, Typeface> loadedTypefaces;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface$Companion;", "", "()V", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final FontMatcher getFontMatcher() {
            return AndroidFontListTypeface.access$getFontMatcher$cp();
        }
    }
    static {
        AndroidFontListTypeface.Companion companion = new AndroidFontListTypeface.Companion(0);
        AndroidFontListTypeface.Companion = companion;
        int i = 8;
        FontMatcher fontMatcher = new FontMatcher();
        AndroidFontListTypeface.fontMatcher = fontMatcher;
    }

    public AndroidFontListTypeface(FontListFontFamily fontFamily, Context context, List<Pair<FontWeight, FontStyle>> necessaryStyles, FontMatcher fontMatcher) {
        int i2;
        ArrayList $this$fastDistinctBy$iv;
        ArrayList list;
        int orCreate;
        Object $this$fastFilter$iv;
        FontMatcher matcher;
        Object arrayList;
        Object arrayList2;
        List i;
        int index$iv$iv2;
        int index$iv$iv;
        Object size;
        int index$iv;
        Object obj2;
        Object obj;
        boolean it;
        Context context2;
        StringBuilder loadingStrategy-PKNRLFQ;
        String blocking-PKNRLFQ;
        Object component1;
        int $this$fastMap$iv;
        final Object obj3 = this;
        super();
        obj3.fontMatcher$1 = fontMatcher;
        List fonts = fontFamily.getFonts();
        int i4 = 0;
        arrayList = new ArrayList(fonts.size());
        arrayList2 = fonts;
        i = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < arrayList2.size()) {
            obj2 = size;
            obj = 0;
            context2 = 0;
            if (FontLoadingStrategy.equals-impl0((Font)obj2.getLoadingStrategy-PKNRLFQ(), FontLoadingStrategy.Companion.getBlocking-PKNRLFQ())) {
            }
            index$iv$iv2++;
            (Collection)arrayList.add(obj2);
        }
        ArrayList $i$f$fastFilter = $this$fastFilter$iv;
        if (necessaryStyles != 0) {
            i2 = necessaryStyles;
            arrayList = 0;
            arrayList2 = new ArrayList(i2.size());
            i = i2;
            index$iv$iv2 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < i.size()) {
                it = 0;
                Object obj5 = obj;
                blocking-PKNRLFQ = 0;
                (Collection)arrayList2.add((Font)CollectionsKt.firstOrNull(obj3.fontMatcher$1.matchFont-RetOiIg($i$f$fastFilter, (FontWeight)(Pair)obj5.component1(), (FontStyle)obj5.component2().unbox-impl())));
                index$iv$iv++;
                matcher = fontMatcher;
                i2 = $this$fastMap$iv;
            }
            $this$fastMap$iv = i2;
            $this$fastFilter$iv = ListUtilsKt.fastFilterNotNull((List)arrayList2);
            if ($this$fastFilter$iv != null) {
                matcher = 0;
                arrayList = new HashSet($this$fastFilter$iv.size());
                arrayList2 = new ArrayList($this$fastFilter$iv.size());
                i = $this$fastFilter$iv;
                index$iv$iv2 = 0;
                index$iv$iv = 0;
                while (index$iv$iv < i.size()) {
                    obj = obj2;
                    it = 0;
                    int i6 = 0;
                    if (arrayList.add((Font)obj)) {
                    }
                    index$iv$iv++;
                    (Collection)arrayList2.add(obj);
                }
                $this$fastDistinctBy$iv = arrayList2;
            } else {
                $this$fastDistinctBy$iv = 0;
            }
        } else {
        }
        ArrayList list4 = $this$fastDistinctBy$iv;
        list = list4 == null ? $i$f$fastFilter : list4;
        ArrayList list5 = list;
        if ((Collection)list5.isEmpty()) {
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap map = linkedHashMap;
            ArrayList list6 = list5;
            int i5 = 0;
            index$iv = orCreate;
            while (index$iv < list6.size()) {
                obj = obj2;
                it = 0;
                (Map)map.put(obj, AndroidTypefaceCache.INSTANCE.getOrCreate(context, (Font)obj));
                index$iv++;
            }
            Context context4 = context;
            obj3.loadedTypefaces = map;
            obj3.fontFamily = (FontFamily)fontFamily;
        }
        Context context3 = context;
        int i3 = 0;
        IllegalStateException $i$a$CheckAndroidFontListTypeface$1 = new IllegalStateException("Could not match font".toString());
        throw $i$a$CheckAndroidFontListTypeface$1;
    }

    public AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context2, List list3, FontMatcher fontMatcher4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj3;
        FontMatcher obj4;
        obj3 = i5 & 4 != 0 ? 0 : obj3;
        obj4 = i5 &= 8 != 0 ? AndroidFontListTypeface.fontMatcher : obj4;
        super(fontListFontFamily, context2, obj3, obj4);
    }

    public static final FontMatcher access$getFontMatcher$cp() {
        return AndroidFontListTypeface.fontMatcher;
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    public final FontMatcher getFontMatcher() {
        return this.fontMatcher$1;
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    public Typeface getNativeTypeface-PYhJU0U(FontWeight fontWeight, int fontStyle, int synthesis) {
        ArrayList arrayList = new ArrayList((Collection)this.loadedTypefaces.keySet());
        Object firstOrNull = CollectionsKt.firstOrNull(this.fontMatcher$1.matchFont-RetOiIg((List)arrayList, fontWeight, fontStyle));
        if ((Font)firstOrNull == null) {
        } else {
            Object obj = this.loadedTypefaces.get((Font)firstOrNull);
            if ((Typeface)obj == null) {
            } else {
                Object synthesizeTypeface-FxwP2eA = FontSynthesis_androidKt.synthesizeTypeface-FxwP2eA(synthesis, (Typeface)obj, firstOrNull, fontWeight, fontStyle);
                Intrinsics.checkNotNull(synthesizeTypeface-FxwP2eA, "null cannot be cast to non-null type android.graphics.Typeface");
                return (Typeface)synthesizeTypeface-FxwP2eA;
            }
            int i = 0;
            IllegalStateException $i$a$CheckNotNullAndroidFontListTypeface$getNativeTypeface$2 = new IllegalStateException("Could not load typeface".toString());
            throw $i$a$CheckNotNullAndroidFontListTypeface$getNativeTypeface$2;
        }
        int typeface = 0;
        IllegalStateException $i$a$CheckNotNullAndroidFontListTypeface$getNativeTypeface$1 = new IllegalStateException("Could not load font".toString());
        throw $i$a$CheckNotNullAndroidFontListTypeface$getNativeTypeface$1;
    }
}
