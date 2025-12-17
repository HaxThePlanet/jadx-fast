package androidx.compose.ui.text;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.Font.ResourceLoader;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Landroidx/compose/ui/text/DeprecatedBridgeFontResourceLoader;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "load", "", "font", "Landroidx/compose/ui/text/font/Font;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DeprecatedBridgeFontResourceLoader implements Font.ResourceLoader {

    public static final androidx.compose.ui.text.DeprecatedBridgeFontResourceLoader.Companion Companion;
    private static Map<FontFamily.Resolver, Font.ResourceLoader> cache;
    private static final SynchronizedObject lock;
    private final FontFamily.Resolver fontFamilyResolver;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0005R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0011", d2 = {"Landroidx/compose/ui/text/DeprecatedBridgeFontResourceLoader$Companion;", "", "()V", "cache", "", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getCache", "()Ljava/util/Map;", "setCache", "(Ljava/util/Map;)V", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "from", "fontFamilyResolver", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Font.ResourceLoader from(FontFamily.Resolver fontFamilyResolver) {
            final SynchronizedObject lock = getLock();
            final int i = 0;
            final int i2 = 0;
            Object obj = DeprecatedBridgeFontResourceLoader.Companion.getCache().get(fontFamilyResolver);
            synchronized (lock) {
                int i3 = 0;
                return (Font.ResourceLoader)obj;
            }
        }

        public final Map<FontFamily.Resolver, Font.ResourceLoader> getCache() {
            return DeprecatedBridgeFontResourceLoader.access$getCache$cp();
        }

        public final SynchronizedObject getLock() {
            return DeprecatedBridgeFontResourceLoader.access$getLock$cp();
        }

        public final void setCache(Map<FontFamily.Resolver, Font.ResourceLoader> <set-?>) {
            DeprecatedBridgeFontResourceLoader.access$setCache$cp(<set-?>);
        }
    }
    static {
        DeprecatedBridgeFontResourceLoader.Companion companion = new DeprecatedBridgeFontResourceLoader.Companion(0);
        DeprecatedBridgeFontResourceLoader.Companion = companion;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DeprecatedBridgeFontResourceLoader.cache = (Map)linkedHashMap;
        DeprecatedBridgeFontResourceLoader.lock = Synchronization_jvmKt.createSynchronizedObject();
    }

    private DeprecatedBridgeFontResourceLoader(FontFamily.Resolver fontFamilyResolver) {
        super();
        this.fontFamilyResolver = fontFamilyResolver;
    }

    public DeprecatedBridgeFontResourceLoader(FontFamily.Resolver fontFamily$Resolver, DefaultConstructorMarker defaultConstructorMarker2) {
        super(resolver);
    }

    public static final Map access$getCache$cp() {
        return DeprecatedBridgeFontResourceLoader.cache;
    }

    public static final SynchronizedObject access$getLock$cp() {
        return DeprecatedBridgeFontResourceLoader.lock;
    }

    public static final void access$setCache$cp(Map <set-?>) {
        DeprecatedBridgeFontResourceLoader.cache = <set-?>;
    }

    @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(...))
    public Object load(Font font) {
        return FontFamily.Resolver.resolve-DPcqOEQ$default(this.fontFamilyResolver, FontKt.toFontFamily(font), font.getWeight(), font.getStyle-_-LCdwA(), 0, 8, 0).getValue();
    }
}
