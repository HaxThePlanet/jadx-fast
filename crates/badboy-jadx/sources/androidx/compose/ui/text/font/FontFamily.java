package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0002\u001a\u00020\u00038G¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0007\u0010\u0008\u0082\u0001\u0003\u000b\u000c\r¨\u0006\u000e", d2 = {"Landroidx/compose/ui/text/font/FontFamily;", "", "canLoadSynchronously", "", "(Z)V", "getCanLoadSynchronously$annotations", "()V", "getCanLoadSynchronously", "()Z", "Companion", "Resolver", "Landroidx/compose/ui/text/font/FileBasedFontFamily;", "Landroidx/compose/ui/text/font/LoadedFontFamily;", "Landroidx/compose/ui/text/font/SystemFontFamily;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class FontFamily {

    public static final int $stable;
    public static final androidx.compose.ui.text.font.FontFamily.Companion Companion;
    private static final androidx.compose.ui.text.font.GenericFontFamily Cursive;
    private static final androidx.compose.ui.text.font.SystemFontFamily Default;
    private static final androidx.compose.ui.text.font.GenericFontFamily Monospace;
    private static final androidx.compose.ui.text.font.GenericFontFamily SansSerif;
    private static final androidx.compose.ui.text.font.GenericFontFamily Serif;
    private final boolean canLoadSynchronously;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0006¨\u0006\u0011", d2 = {"Landroidx/compose/ui/text/font/FontFamily$Companion;", "", "()V", "Cursive", "Landroidx/compose/ui/text/font/GenericFontFamily;", "getCursive", "()Landroidx/compose/ui/text/font/GenericFontFamily;", "Default", "Landroidx/compose/ui/text/font/SystemFontFamily;", "getDefault", "()Landroidx/compose/ui/text/font/SystemFontFamily;", "Monospace", "getMonospace", "SansSerif", "getSansSerif", "Serif", "getSerif", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.text.font.GenericFontFamily getCursive() {
            return FontFamily.access$getCursive$cp();
        }

        public final androidx.compose.ui.text.font.SystemFontFamily getDefault() {
            return FontFamily.access$getDefault$cp();
        }

        public final androidx.compose.ui.text.font.GenericFontFamily getMonospace() {
            return FontFamily.access$getMonospace$cp();
        }

        public final androidx.compose.ui.text.font.GenericFontFamily getSansSerif() {
            return FontFamily.access$getSansSerif$cp();
        }

        public final androidx.compose.ui.text.font.GenericFontFamily getSerif() {
            return FontFamily.access$getSerif$cp();
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006JB\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00082\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010\u0082\u0001\u0001\u0011ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0012À\u0006\u0001", d2 = {"Landroidx/compose/ui/text/font/FontFamily$Resolver;", "", "preload", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/runtime/State;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Resolver {
        public static State resolve-DPcqOEQ$default(androidx.compose.ui.text.font.FontFamily.Resolver fontFamily$Resolver, androidx.compose.ui.text.font.FontFamily fontFamily2, androidx.compose.ui.text.font.FontWeight fontWeight3, int i4, int i5, int i6, Object object7) {
            int obj1;
            androidx.compose.ui.text.font.FontWeight obj2;
            int obj3;
            int obj4;
            if (object7 != null) {
            } else {
                if (i6 & 1 != 0) {
                    obj1 = 0;
                }
                if (i6 & 2 != 0) {
                    obj2 = FontWeight.Companion.getNormal();
                }
                if (i6 & 4 != 0) {
                    obj3 = FontStyle.Companion.getNormal-_-LCdwA();
                }
                if (i6 &= 8 != 0) {
                    obj4 = FontSynthesis.Companion.getAll-GVVA2EU();
                }
                return resolver.resolve-DPcqOEQ(obj1, obj2, obj3, obj4);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolve-DPcqOEQ");
            throw obj0;
        }

        public abstract Object preload(androidx.compose.ui.text.font.FontFamily fontFamily, Continuation<? super Unit> continuation2);

        public abstract State<Object> resolve-DPcqOEQ(androidx.compose.ui.text.font.FontFamily fontFamily, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, int i4);
    }
    static {
        FontFamily.Companion companion = new FontFamily.Companion(0);
        FontFamily.Companion = companion;
        DefaultFontFamily defaultFontFamily = new DefaultFontFamily();
        FontFamily.Default = (SystemFontFamily)defaultFontFamily;
        GenericFontFamily genericFontFamily = new GenericFontFamily("sans-serif", "FontFamily.SansSerif");
        FontFamily.SansSerif = genericFontFamily;
        GenericFontFamily genericFontFamily2 = new GenericFontFamily("serif", "FontFamily.Serif");
        FontFamily.Serif = genericFontFamily2;
        GenericFontFamily genericFontFamily3 = new GenericFontFamily("monospace", "FontFamily.Monospace");
        FontFamily.Monospace = genericFontFamily3;
        GenericFontFamily genericFontFamily4 = new GenericFontFamily("cursive", "FontFamily.Cursive");
        FontFamily.Cursive = genericFontFamily4;
    }

    private FontFamily(boolean canLoadSynchronously) {
        super();
        this.canLoadSynchronously = canLoadSynchronously;
    }

    public FontFamily(boolean z, DefaultConstructorMarker defaultConstructorMarker2) {
        super(z);
    }

    public static final androidx.compose.ui.text.font.GenericFontFamily access$getCursive$cp() {
        return FontFamily.Cursive;
    }

    public static final androidx.compose.ui.text.font.SystemFontFamily access$getDefault$cp() {
        return FontFamily.Default;
    }

    public static final androidx.compose.ui.text.font.GenericFontFamily access$getMonospace$cp() {
        return FontFamily.Monospace;
    }

    public static final androidx.compose.ui.text.font.GenericFontFamily access$getSansSerif$cp() {
        return FontFamily.SansSerif;
    }

    public static final androidx.compose.ui.text.font.GenericFontFamily access$getSerif$cp() {
        return FontFamily.Serif;
    }

    public static void getCanLoadSynchronously$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Unused property that has no meaning. Do not use.")
    public final boolean getCanLoadSynchronously() {
        return this.canLoadSynchronously;
    }
}
