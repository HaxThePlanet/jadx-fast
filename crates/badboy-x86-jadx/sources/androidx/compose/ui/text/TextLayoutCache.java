package androidx.compose.ui.text;

import androidx.compose.ui.text.caches.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00082\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u000c\u001a\u0004\u0018\u00010\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0008J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00082\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/ui/text/TextLayoutCache;", "", "capacity", "", "(I)V", "lruCache", "Landroidx/compose/ui/text/caches/LruCache;", "Landroidx/compose/ui/text/CacheTextLayoutInput;", "Landroidx/compose/ui/text/TextLayoutResult;", "get", "key", "Landroidx/compose/ui/text/TextLayoutInput;", "put", "value", "remove", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextLayoutCache {

    public static final int $stable = 8;
    private final LruCache<androidx.compose.ui.text.CacheTextLayoutInput, androidx.compose.ui.text.TextLayoutResult> lruCache;
    static {
        final int i = 8;
    }

    public TextLayoutCache() {
        super(0, 1, 0);
    }

    public TextLayoutCache(int capacity) {
        super();
        LruCache lruCache = new LruCache(capacity);
        this.lruCache = lruCache;
    }

    public TextLayoutCache(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        if (i2 &= 1 != 0) {
            obj1 = TextMeasurerKt.access$getDefaultCacheSize$p();
        }
        super(obj1);
    }

    public final androidx.compose.ui.text.TextLayoutResult get(androidx.compose.ui.text.TextLayoutInput key) {
        CacheTextLayoutInput cacheTextLayoutInput = new CacheTextLayoutInput(key);
        Object obj = this.lruCache.get(cacheTextLayoutInput);
        int i = 0;
        if ((TextLayoutResult)obj == null) {
            return i;
        }
        if ((TextLayoutResult)obj.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return i;
        }
        return obj;
    }

    public final androidx.compose.ui.text.TextLayoutResult put(androidx.compose.ui.text.TextLayoutInput key, androidx.compose.ui.text.TextLayoutResult value) {
        CacheTextLayoutInput cacheTextLayoutInput = new CacheTextLayoutInput(key);
        return (TextLayoutResult)this.lruCache.put(cacheTextLayoutInput, value);
    }

    public final androidx.compose.ui.text.TextLayoutResult remove(androidx.compose.ui.text.TextLayoutInput key) {
        CacheTextLayoutInput cacheTextLayoutInput = new CacheTextLayoutInput(key);
        return (TextLayoutResult)this.lruCache.remove(cacheTextLayoutInput);
    }
}
