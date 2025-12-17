package androidx.compose.ui.text.android;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u000e\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0015", d2 = {"Landroidx/compose/ui/text/android/HorizontalPositionCache;", "", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "(Landroidx/compose/ui/text/android/TextLayout;)V", "cachedKey", "", "cachedValue", "", "getLayout", "()Landroidx/compose/ui/text/android/TextLayout;", "get", "offset", "upstream", "", "cache", "primary", "getPrimaryDownstream", "getPrimaryUpstream", "getSecondaryDownstream", "getSecondaryUpstream", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class HorizontalPositionCache {

    private int cachedKey = -1;
    private float cachedValue;
    private final androidx.compose.ui.text.android.TextLayout layout;
    public HorizontalPositionCache(androidx.compose.ui.text.android.TextLayout layout) {
        super();
        this.layout = layout;
        final int i = -1;
    }

    private final float get(int offset, boolean upstream, boolean cache, boolean primary) {
        int i;
        float secondaryHorizontal;
        int lineNo;
        int lineStart;
        int lineEnd;
        final int i2 = 0;
        if (upstream != null) {
            int lineForOffset = LayoutCompat_androidKt.getLineForOffset(this.layout.getLayout(), offset, upstream);
            if (offset != this.layout.getLineStart(lineForOffset)) {
                if (offset == this.layout.getLineEnd(lineForOffset)) {
                    lineNo = i;
                } else {
                    lineNo = i2;
                }
            } else {
            }
        } else {
            lineNo = i2;
        }
        if (primary) {
            if (lineNo != 0) {
                i = i2;
            }
        } else {
            i = lineNo != 0 ? 2 : 3;
        }
        i3 += i;
        if (this.cachedKey == i4) {
            return this.cachedValue;
        }
        if (primary) {
            secondaryHorizontal = this.layout.getPrimaryHorizontal(offset, upstream);
        } else {
            secondaryHorizontal = this.layout.getSecondaryHorizontal(offset, upstream);
        }
        if (cache != null) {
            this.cachedKey = i4;
            this.cachedValue = secondaryHorizontal;
        }
        return secondaryHorizontal;
    }

    public final androidx.compose.ui.text.android.TextLayout getLayout() {
        return this.layout;
    }

    public final float getPrimaryDownstream(int offset) {
        int i = 0;
        return get(offset, i, i, true);
    }

    public final float getPrimaryUpstream(int offset) {
        int i = 1;
        return get(offset, i, i, i);
    }

    public final float getSecondaryDownstream(int offset) {
        int i = 0;
        return get(offset, i, i, i);
    }

    public final float getSecondaryUpstream(int offset) {
        int i = 1;
        return get(offset, i, i, false);
    }
}
