package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R.styleable;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class FontResourcesParserCompat {

    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    static class Api21Impl {
        static int getType(TypedArray typedArray, int index) {
            return typedArray.getType(index);
        }
    }

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry implements androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry {

        private final androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry[] mEntries;
        public FontFamilyFilesResourceEntry(androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry[] entries) {
            super();
            this.mEntries = entries;
        }

        @Override // androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry
        public androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    public static final class FontFileResourceEntry {

        private final String mFileName;
        private final boolean mItalic;
        private final int mResourceId;
        private final int mTtcIndex;
        private final String mVariationSettings;
        private final int mWeight;
        public FontFileResourceEntry(String fileName, int weight, boolean italic, String variationSettings, int ttcIndex, int resourceId) {
            super();
            this.mFileName = fileName;
            this.mWeight = weight;
            this.mItalic = italic;
            this.mVariationSettings = variationSettings;
            this.mTtcIndex = ttcIndex;
            this.mResourceId = resourceId;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public int getResourceId() {
            return this.mResourceId;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public String getVariationSettings() {
            return this.mVariationSettings;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static final class ProviderResourceEntry implements androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry {

        private final FontRequest mFallbackRequest;
        private final FontRequest mRequest;
        private final int mStrategy;
        private final String mSystemFontFamilyName;
        private final int mTimeoutMs;
        public ProviderResourceEntry(FontRequest request, int strategy, int timeoutMs) {
            super(request, 0, strategy, timeoutMs, 0);
        }

        public ProviderResourceEntry(FontRequest request, FontRequest fallbackRequest, int strategy, int timeoutMs, String systemFontFamilyName) {
            super();
            this.mRequest = request;
            this.mFallbackRequest = fallbackRequest;
            this.mStrategy = strategy;
            this.mTimeoutMs = timeoutMs;
            this.mSystemFontFamilyName = systemFontFamilyName;
        }

        @Override // androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry
        public FontRequest getFallbackRequest() {
            return this.mFallbackRequest;
        }

        @Override // androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry
        public int getFetchStrategy() {
            return this.mStrategy;
        }

        @Override // androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry
        public FontRequest getRequest() {
            return this.mRequest;
        }

        @Override // androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry
        public String getSystemFontFamilyName() {
            return this.mSystemFontFamilyName;
        }

        @Override // androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry
        public int getTimeout() {
            return this.mTimeoutMs;
        }
    }
    private static int getType(TypedArray typedArray, int index) {
        return FontResourcesParserCompat.Api21Impl.getType(typedArray, index);
    }

    public static androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry parse(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        int i2;
        int i;
        next = parser.next();
        i2 = next;
        i = 2;
        while (next != i) {
            if (i2 != 1) {
            }
            next = parser.next();
            i2 = next;
            i = 2;
        }
        if (i2 != i) {
        } else {
            return FontResourcesParserCompat.readFamilies(parser, resources);
        }
        XmlPullParserException xmlPullParserException = new XmlPullParserException("No start tag found");
        throw xmlPullParserException;
    }

    public static List<List<byte[]>> readCerts(Resources resources, int certsId) {
        List byteArrayList;
        int i;
        int resourceId;
        List byteArrayList2;
        if (certsId == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArray = resources.obtainTypedArray(certsId);
        if (typedArray.length() == 0) {
            typedArray.recycle();
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        byteArrayList = 0;
        if (FontResourcesParserCompat.getType(typedArray, byteArrayList) == 1) {
            i = 0;
            while (i < typedArray.length()) {
                resourceId = typedArray.getResourceId(i, byteArrayList);
                if (resourceId != 0) {
                }
                i++;
                arrayList.add(FontResourcesParserCompat.toByteArrayList(resources.getStringArray(resourceId)));
            }
        } else {
            try {
                arrayList.add(FontResourcesParserCompat.toByteArrayList(resources.getStringArray(certsId)));
                typedArray.recycle();
                return arrayList;
                obj0.recycle();
                throw result;
            }
        }
    }

    private static androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry readFamilies(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        int i2 = 0;
        String str = "font-family";
        parser.require(2, i2, str);
        if (parser.getName().equals(str)) {
            return FontResourcesParserCompat.readFamily(parser, resources);
        }
        FontResourcesParserCompat.skip(parser);
        return i2;
    }

    private static androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry readFamily(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        FontRequest fallbackRequest;
        int eventType;
        int equals;
        FontRequest request;
        final Resources resources2 = resources;
        TypedArray attributes = resources2.obtainAttributes(Xml.asAttributeSet(parser), R.styleable.FontFamily);
        String string = attributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = attributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = attributes.getString(R.styleable.FontFamily_fontProviderQuery);
        String string4 = attributes.getString(R.styleable.FontFamily_fontProviderFallbackQuery);
        next = 0;
        attributes.recycle();
        int i2 = 3;
        if (string != null && string2 != null && string3 != null) {
            if (string2 != null) {
                if (string3 != null) {
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        while (parser.next() != i2) {
            if (parser.getEventType() != 2) {
            } else {
            }
            if (parser.getName().equals("font")) {
            } else {
            }
            FontResourcesParserCompat.skip(parser);
            arrayList.add(FontResourcesParserCompat.readFont(parser, resources));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry = new FontResourcesParserCompat.FontFamilyFilesResourceEntry((FontResourcesParserCompat.FontFileResourceEntry[])arrayList.toArray(new FontResourcesParserCompat.FontFileResourceEntry[next]));
        return fontFamilyFilesResourceEntry;
    }

    private static androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry readFont(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        int fontFamilyFont_fontWeight;
        int fontFamilyFont_fontStyle;
        int next;
        int fontFamilyFont_android_ttcIndex;
        int fontFamilyFont_android_fontVariationSettings;
        int fontFamilyFont_android_font;
        int i2;
        int i;
        TypedArray attributes = resources.obtainAttributes(Xml.asAttributeSet(parser), R.styleable.FontFamilyFont);
        fontFamilyFont_fontWeight = attributes.hasValue(R.styleable.FontFamilyFont_fontWeight) ? R.styleable.FontFamilyFont_fontWeight : R.styleable.FontFamilyFont_android_fontWeight;
        fontFamilyFont_fontStyle = attributes.hasValue(R.styleable.FontFamilyFont_fontStyle) ? R.styleable.FontFamilyFont_fontStyle : R.styleable.FontFamilyFont_android_fontStyle;
        next = 0;
        if (1 == attributes.getInt(fontFamilyFont_fontStyle, next)) {
        } else {
            i2 = next;
        }
        fontFamilyFont_android_ttcIndex = attributes.hasValue(R.styleable.FontFamilyFont_ttcIndex) ? R.styleable.FontFamilyFont_ttcIndex : R.styleable.FontFamilyFont_android_ttcIndex;
        fontFamilyFont_android_fontVariationSettings = attributes.hasValue(R.styleable.FontFamilyFont_fontVariationSettings) ? R.styleable.FontFamilyFont_fontVariationSettings : R.styleable.FontFamilyFont_android_fontVariationSettings;
        fontFamilyFont_android_font = attributes.hasValue(R.styleable.FontFamilyFont_font) ? R.styleable.FontFamilyFont_font : R.styleable.FontFamilyFont_android_font;
        final int i6 = fontFamilyFont_android_font;
        attributes.recycle();
        while (parser.next() != 3) {
            FontResourcesParserCompat.skip(parser);
        }
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = new FontResourcesParserCompat.FontFileResourceEntry(attributes.getString(i6), attributes.getInt(fontFamilyFont_fontWeight, 400), i2, attributes.getString(fontFamilyFont_android_fontVariationSettings), attributes.getInt(fontFamilyFont_android_ttcIndex, next), attributes.getResourceId(i6, next));
        return fontFileResourceEntry;
    }

    private static void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        int depth;
        int next;
        depth = 1;
        while (depth > 0) {
            depth--;
            depth++;
        }
    }

    private static List<byte[]> toByteArrayList(String[] stringArray) {
        int i;
        Object obj;
        byte[] decode;
        ArrayList arrayList = new ArrayList();
        final int i2 = 0;
        i = i2;
        while (i < stringArray.length) {
            arrayList.add(Base64.decode(stringArray[i], i2));
            i++;
        }
        return arrayList;
    }
}
