package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public class TypefaceEmojiRasterizer {

    static final int HAS_GLYPH_ABSENT = 1;
    static final int HAS_GLYPH_EXISTS = 2;
    static final int HAS_GLYPH_UNKNOWN;
    private static final java.lang.ThreadLocal<MetadataItem> sMetadataItem;
    private volatile int mCache = 0;
    private final int mIndex;
    private final androidx.emoji2.text.MetadataRepo mMetadataRepo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        TypefaceEmojiRasterizer.sMetadataItem = threadLocal;
    }

    TypefaceEmojiRasterizer(androidx.emoji2.text.MetadataRepo metadataRepo, int index) {
        super();
        final int i = 0;
        this.mMetadataRepo = metadataRepo;
        this.mIndex = index;
    }

    private MetadataItem getMetadataItem() {
        Object result;
        java.lang.ThreadLocal sMetadataItem;
        if ((MetadataItem)TypefaceEmojiRasterizer.sMetadataItem.get() == null) {
            MetadataItem metadataItem = new MetadataItem();
            TypefaceEmojiRasterizer.sMetadataItem.set(metadataItem);
        }
        this.mMetadataRepo.getMetadataList().list(result, this.mIndex);
        return result;
    }

    public void draw(Canvas canvas, float x, float y, Paint paint) {
        paint.setTypeface(this.mMetadataRepo.getTypeface());
        final Paint paint2 = paint;
        canvas.drawText(this.mMetadataRepo.getEmojiCharArray(), mIndex * 2, 2, x, y, paint2);
        paint2.setTypeface(paint.getTypeface());
    }

    public int getCodepointAt(int index) {
        return getMetadataItem().codepoints(index);
    }

    public int getCodepointsLength() {
        return getMetadataItem().codepointsLength();
    }

    public short getCompatAdded() {
        return getMetadataItem().compatAdded();
    }

    public int getHasGlyph() {
        return mCache &= 3;
    }

    public int getHeight() {
        return getMetadataItem().height();
    }

    public int getId() {
        return getMetadataItem().id();
    }

    public short getSdkAdded() {
        return getMetadataItem().sdkAdded();
    }

    public Typeface getTypeface() {
        return this.mMetadataRepo.getTypeface();
    }

    public int getWidth() {
        return getMetadataItem().width();
    }

    public boolean isDefaultEmoji() {
        return getMetadataItem().emojiStyle();
    }

    public boolean isPreferredSystemRender() {
        int i;
        i = mCache &= 4 > 0 ? 1 : 0;
        return i;
    }

    public void resetHasGlyphCache() {
        int i;
        if (isPreferredSystemRender()) {
            this.mCache = 4;
        } else {
            this.mCache = 0;
        }
    }

    public void setExclusion(boolean exclude) {
        int i;
        final int hasGlyph = getHasGlyph();
        if (exclude) {
            this.mCache = hasGlyph | 4;
        } else {
            this.mCache = hasGlyph;
        }
    }

    public void setHasGlyph(boolean hasGlyph) {
        int newValue;
        mCache &= 4;
        newValue = hasGlyph ? i | 2 : i | 1;
        this.mCache = newValue;
    }

    public String toString() {
        int i;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(", id:");
        stringBuilder.append(Integer.toHexString(getId()));
        stringBuilder.append(", codepoints:");
        i = 0;
        while (i < getCodepointsLength()) {
            stringBuilder.append(Integer.toHexString(getCodepointAt(i)));
            stringBuilder.append(" ");
            i++;
        }
        return stringBuilder.toString();
    }
}
