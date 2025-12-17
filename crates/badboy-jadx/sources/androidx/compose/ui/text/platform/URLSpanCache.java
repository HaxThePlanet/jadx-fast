package androidx.compose.ui.text.platform;

import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkAnnotation.Url;
import androidx.compose.ui.text.UrlAnnotation;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\u0010\u001a\u00020\n2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0005J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\tR \u0010\u0003\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u0005\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/compose/ui/text/platform/URLSpanCache;", "", "()V", "linkSpansWithListenerByAnnotation", "Ljava/util/WeakHashMap;", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/ui/text/platform/ComposeClickableSpan;", "spansByAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "Landroid/text/style/URLSpan;", "urlSpansByAnnotation", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "toClickableSpan", "Landroid/text/style/ClickableSpan;", "linkRange", "toURLSpan", "urlRange", "urlAnnotation", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class URLSpanCache {

    public static final int $stable = 8;
    private final WeakHashMap<AnnotatedString.Range<LinkAnnotation>, androidx.compose.ui.text.platform.ComposeClickableSpan> linkSpansWithListenerByAnnotation;
    private final WeakHashMap<UrlAnnotation, URLSpan> spansByAnnotation;
    private final WeakHashMap<AnnotatedString.Range<LinkAnnotation.Url>, URLSpan> urlSpansByAnnotation;
    static {
        final int i = 8;
    }

    public URLSpanCache() {
        super();
        WeakHashMap weakHashMap = new WeakHashMap();
        this.spansByAnnotation = weakHashMap;
        WeakHashMap weakHashMap2 = new WeakHashMap();
        this.urlSpansByAnnotation = weakHashMap2;
        WeakHashMap weakHashMap3 = new WeakHashMap();
        this.linkSpansWithListenerByAnnotation = weakHashMap3;
    }

    public final ClickableSpan toClickableSpan(AnnotatedString.Range<LinkAnnotation> linkRange) {
        int i;
        Object composeClickableSpan;
        Object item;
        final WeakHashMap linkSpansWithListenerByAnnotation = this.linkSpansWithListenerByAnnotation;
        final int i2 = 0;
        final Object obj = (Map)linkSpansWithListenerByAnnotation.get(linkRange);
        if (obj == null) {
            i = 0;
            composeClickableSpan = new ComposeClickableSpan((LinkAnnotation)linkRange.getItem());
            linkSpansWithListenerByAnnotation.put(linkRange, composeClickableSpan);
        } else {
            composeClickableSpan = obj;
        }
        return (ClickableSpan)composeClickableSpan;
    }

    public final URLSpan toURLSpan(AnnotatedString.Range<LinkAnnotation.Url> urlRange) {
        int i;
        Object uRLSpan;
        String url;
        final WeakHashMap urlSpansByAnnotation = this.urlSpansByAnnotation;
        final int i2 = 0;
        final Object obj = (Map)urlSpansByAnnotation.get(urlRange);
        if (obj == null) {
            i = 0;
            uRLSpan = new URLSpan((LinkAnnotation.Url)urlRange.getItem().getUrl());
            urlSpansByAnnotation.put(urlRange, uRLSpan);
        } else {
            uRLSpan = obj;
        }
        return (URLSpan)uRLSpan;
    }

    public final URLSpan toURLSpan(UrlAnnotation urlAnnotation) {
        int i;
        Object uRLSpan;
        String url;
        final WeakHashMap spansByAnnotation = this.spansByAnnotation;
        final int i2 = 0;
        final Object obj = (Map)spansByAnnotation.get(urlAnnotation);
        if (obj == null) {
            i = 0;
            uRLSpan = new URLSpan(urlAnnotation.getUrl());
            spansByAnnotation.put(urlAnnotation, uRLSpan);
        } else {
            uRLSpan = obj;
        }
        return (URLSpan)uRLSpan;
    }
}
