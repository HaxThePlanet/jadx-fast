package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class BidiFormatter {

    private static final int DEFAULT_FLAGS = 2;
    static final androidx.core.text.BidiFormatter DEFAULT_LTR_INSTANCE = null;
    static final androidx.core.text.BidiFormatter DEFAULT_RTL_INSTANCE = null;
    static final androidx.core.text.TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = null;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '\u202a';
    private static final char LRM = '\u200e';
    private static final String LRM_STRING = null;
    private static final char PDF = '\u202c';
    private static final char RLE = '\u202b';
    private static final char RLM = '\u200f';
    private static final String RLM_STRING;
    private final androidx.core.text.TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    public static final class Builder {

        private int mFlags;
        private boolean mIsRtlContext;
        private androidx.core.text.TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;
        public Builder() {
            super();
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(Locale locale) {
            super();
            initialize(BidiFormatter.isRtlLocale(locale));
        }

        public Builder(boolean rtlContext) {
            super();
            initialize(rtlContext);
        }

        private static androidx.core.text.BidiFormatter getDefaultInstanceFromContext(boolean isRtlContext) {
            androidx.core.text.BidiFormatter dEFAULT_RTL_INSTANCE;
            dEFAULT_RTL_INSTANCE = isRtlContext != null ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
            return dEFAULT_RTL_INSTANCE;
        }

        private void initialize(boolean isRtlContext) {
            this.mIsRtlContext = isRtlContext;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public androidx.core.text.BidiFormatter build() {
            int mTextDirectionHeuristicCompat;
            int dEFAULT_TEXT_DIRECTION_HEURISTIC;
            if (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                if (this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                    return BidiFormatter.Builder.getDefaultInstanceFromContext(this.mIsRtlContext);
                }
            }
            BidiFormatter bidiFormatter = new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
            return bidiFormatter;
        }

        public androidx.core.text.BidiFormatter.Builder setTextDirectionHeuristic(androidx.core.text.TextDirectionHeuristicCompat heuristic) {
            this.mTextDirectionHeuristicCompat = heuristic;
            return this;
        }

        public androidx.core.text.BidiFormatter.Builder stereoReset(boolean stereoReset) {
            int i;
            if (stereoReset != null) {
                this.mFlags = mFlags |= 2;
            } else {
                this.mFlags = mFlags2 &= -3;
            }
            return this;
        }
    }

    private static class DirectionalityEstimator {

        private static final byte[] DIR_TYPE_CACHE = null;
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final java.lang.CharSequence text;
        static {
            int i;
            byte[] dIR_TYPE_CACHE;
            byte directionality;
            final int i2 = 1792;
            BidiFormatter.DirectionalityEstimator.DIR_TYPE_CACHE = new byte[i2];
            i = 0;
            while (i < i2) {
                BidiFormatter.DirectionalityEstimator.DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
                i++;
            }
        }

        DirectionalityEstimator(java.lang.CharSequence text, boolean isHtml) {
            super();
            this.text = text;
            this.isHtml = isHtml;
            this.length = text.length();
        }

        private static byte getCachedDirectionality(char c) {
            byte directionality;
            if (c < 1792) {
                directionality = BidiFormatter.DirectionalityEstimator.DIR_TYPE_CACHE[c];
            } else {
                directionality = Character.getDirectionality(c);
            }
            return directionality;
        }

        private byte skipEntityBackward() {
            char charIndex;
            int i;
            int i2;
            i = 59;
            while (this.charIndex > 0) {
                charIndex3--;
                this.charIndex = i5;
                this.lastChar = this.text.charAt(i5);
                i = 59;
            }
            this.charIndex = this.charIndex;
            this.lastChar = i;
            return 13;
        }

        private byte skipEntityForward() {
            int charIndex;
            int length;
            int i;
            while (this.charIndex < this.length) {
                int charIndex2 = this.charIndex;
                this.charIndex = charIndex2 + 1;
                charIndex = this.text.charAt(charIndex2);
                this.lastChar = charIndex;
                if (charIndex != 59) {
                }
            }
            return 12;
        }

        private byte skipTagBackward() {
            char lastChar;
            int charIndex2;
            int charIndex;
            int i;
            int i4 = 62;
            while (this.charIndex > 0) {
                charIndex4--;
                this.charIndex = i5;
                this.lastChar = this.text.charAt(i5);
                if (this.lastChar != 34) {
                } else {
                }
                while (this.charIndex > 0) {
                    charIndex5--;
                    this.charIndex = i;
                    charIndex = this.text.charAt(i);
                    this.lastChar = charIndex;
                    if (charIndex != this.lastChar) {
                    }
                }
                i4 = 62;
                charIndex5--;
                this.charIndex = i;
                charIndex = this.text.charAt(i);
                this.lastChar = charIndex;
                if (charIndex != this.lastChar) {
                }
                if (this.lastChar == 39) {
                }
            }
            this.charIndex = this.charIndex;
            this.lastChar = i4;
            return 13;
        }

        private byte skipTagForward() {
            char lastChar;
            int charIndex2;
            int charIndex;
            int i;
            while (this.charIndex < this.length) {
                int charIndex5 = this.charIndex;
                this.charIndex = charIndex5 + 1;
                this.lastChar = this.text.charAt(charIndex5);
                if (this.lastChar != 34) {
                } else {
                }
                while (this.charIndex < this.length) {
                    charIndex = this.charIndex;
                    this.charIndex = charIndex + 1;
                    charIndex2 = this.text.charAt(charIndex);
                    this.lastChar = charIndex2;
                    if (charIndex2 != this.lastChar) {
                    }
                }
                charIndex = this.charIndex;
                this.charIndex = charIndex + 1;
                charIndex2 = this.text.charAt(charIndex);
                this.lastChar = charIndex2;
                if (charIndex2 != this.lastChar) {
                }
                if (this.lastChar == 39) {
                }
            }
            this.charIndex = this.charIndex;
            this.lastChar = '<';
            return 13;
        }

        byte dirTypeBackward() {
            byte dirType;
            boolean lastChar;
            int i;
            this.lastChar = this.text.charAt(charIndex--);
            if (Character.isLowSurrogate(this.lastChar)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex = charIndex3 -= charCount;
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex = codePoint--;
            dirType = BidiFormatter.DirectionalityEstimator.getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                if (this.lastChar == 62) {
                    dirType = skipTagBackward();
                } else {
                    if (this.lastChar == 59) {
                        dirType = skipEntityBackward();
                    }
                }
            }
            return dirType;
        }

        byte dirTypeForward() {
            byte dirType;
            boolean lastChar;
            int i;
            this.lastChar = this.text.charAt(this.charIndex);
            if (Character.isHighSurrogate(this.lastChar)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex = charIndex3 += charCount;
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex = codePoint++;
            dirType = BidiFormatter.DirectionalityEstimator.getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                if (this.lastChar == 60) {
                    dirType = skipTagForward();
                } else {
                    if (this.lastChar == 38) {
                        dirType = skipEntityForward();
                    }
                }
            }
            return dirType;
        }

        int getEntryDir() {
            int embeddingLevel;
            int embeddingLevelDir;
            int firstNonEmptyEmbeddingLevel;
            byte dirTypeForward;
            int dirTypeBackward;
            int length;
            int i;
            int i2;
            final int i4 = 0;
            this.charIndex = i4;
            embeddingLevel = 0;
            embeddingLevelDir = 0;
            firstNonEmptyEmbeddingLevel = 0;
            i = -1;
            i2 = 1;
            while (this.charIndex < this.length) {
                firstNonEmptyEmbeddingLevel = embeddingLevel;
                i = -1;
                i2 = 1;
                embeddingLevel--;
                embeddingLevelDir = 0;
                embeddingLevel++;
                embeddingLevelDir = 1;
                embeddingLevel++;
                embeddingLevelDir = -1;
                firstNonEmptyEmbeddingLevel = embeddingLevel;
                firstNonEmptyEmbeddingLevel = embeddingLevel;
            }
            if (firstNonEmptyEmbeddingLevel == 0) {
                return i4;
            }
            if (embeddingLevelDir != null) {
                return embeddingLevelDir;
            }
            while (this.charIndex > 0) {
                embeddingLevel++;
                embeddingLevel--;
                embeddingLevel--;
            }
            return i4;
        }

        int getExitDir() {
            int embeddingLevel;
            int lastNonEmptyEmbeddingLevel;
            byte dirTypeBackward;
            int i2;
            int i;
            this.charIndex = this.length;
            embeddingLevel = 0;
            lastNonEmptyEmbeddingLevel = 0;
            while (this.charIndex > 0) {
                i2 = 1;
                i = -1;
                if (lastNonEmptyEmbeddingLevel == 0) {
                }
                lastNonEmptyEmbeddingLevel = embeddingLevel;
                embeddingLevel++;
                embeddingLevel--;
                embeddingLevel--;
                if (lastNonEmptyEmbeddingLevel == 0) {
                }
                lastNonEmptyEmbeddingLevel = embeddingLevel;
                if (lastNonEmptyEmbeddingLevel == 0) {
                }
                lastNonEmptyEmbeddingLevel = embeddingLevel;
            }
            return 0;
        }
    }
    static {
        BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        BidiFormatter.LRM_STRING = Character.toString('\u200e');
        BidiFormatter.RLM_STRING = Character.toString('\u200f');
        final int i5 = 2;
        BidiFormatter bidiFormatter = new BidiFormatter(0, i5, BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC);
        BidiFormatter.DEFAULT_LTR_INSTANCE = bidiFormatter;
        BidiFormatter bidiFormatter2 = new BidiFormatter(1, i5, BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC);
        BidiFormatter.DEFAULT_RTL_INSTANCE = bidiFormatter2;
    }

    BidiFormatter(boolean isRtlContext, int flags, androidx.core.text.TextDirectionHeuristicCompat heuristic) {
        super();
        this.mIsRtlContext = isRtlContext;
        this.mFlags = flags;
        this.mDefaultTextDirectionHeuristicCompat = heuristic;
    }

    private static int getEntryDir(java.lang.CharSequence str) {
        BidiFormatter.DirectionalityEstimator directionalityEstimator = new BidiFormatter.DirectionalityEstimator(str, 0);
        return directionalityEstimator.getEntryDir();
    }

    private static int getExitDir(java.lang.CharSequence str) {
        BidiFormatter.DirectionalityEstimator directionalityEstimator = new BidiFormatter.DirectionalityEstimator(str, 0);
        return directionalityEstimator.getExitDir();
    }

    public static androidx.core.text.BidiFormatter getInstance() {
        BidiFormatter.Builder builder = new BidiFormatter.Builder();
        return builder.build();
    }

    public static androidx.core.text.BidiFormatter getInstance(Locale locale) {
        BidiFormatter.Builder builder = new BidiFormatter.Builder(locale);
        return builder.build();
    }

    public static androidx.core.text.BidiFormatter getInstance(boolean rtlContext) {
        BidiFormatter.Builder builder = new BidiFormatter.Builder(rtlContext);
        return builder.build();
    }

    static boolean isRtlLocale(Locale locale) {
        int i;
        if (TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    private String markAfter(java.lang.CharSequence str, androidx.core.text.TextDirectionHeuristicCompat heuristic) {
        boolean mIsRtlContext2;
        boolean mIsRtlContext;
        int i;
        boolean rtl = heuristic.isRtl(str, 0, str.length());
        if (this.mIsRtlContext == null && !rtl && BidiFormatter.getExitDir(str) == 1) {
            if (!rtl) {
                if (BidiFormatter.getExitDir(str) == 1) {
                }
            }
            return BidiFormatter.LRM_STRING;
        }
        if (this.mIsRtlContext != null && rtl && BidiFormatter.getExitDir(str) == -1) {
            if (rtl) {
                if (BidiFormatter.getExitDir(str) == -1) {
                }
            }
            return BidiFormatter.RLM_STRING;
        }
        return "";
    }

    private String markBefore(java.lang.CharSequence str, androidx.core.text.TextDirectionHeuristicCompat heuristic) {
        boolean mIsRtlContext;
        boolean mIsRtlContext2;
        int i;
        boolean rtl = heuristic.isRtl(str, 0, str.length());
        if (this.mIsRtlContext == null && !rtl && BidiFormatter.getEntryDir(str) == 1) {
            if (!rtl) {
                if (BidiFormatter.getEntryDir(str) == 1) {
                }
            }
            return BidiFormatter.LRM_STRING;
        }
        if (this.mIsRtlContext != null && rtl && BidiFormatter.getEntryDir(str) == -1) {
            if (rtl) {
                if (BidiFormatter.getEntryDir(str) == -1) {
                }
            }
            return BidiFormatter.RLM_STRING;
        }
        return "";
    }

    public boolean getStereoReset() {
        int i;
        i = mFlags &= 2 != 0 ? 1 : 0;
        return i;
    }

    public boolean isRtl(java.lang.CharSequence str) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(str, 0, str.length());
    }

    public boolean isRtl(String str) {
        return isRtl(str);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public java.lang.CharSequence unicodeWrap(java.lang.CharSequence str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public java.lang.CharSequence unicodeWrap(java.lang.CharSequence str, androidx.core.text.TextDirectionHeuristicCompat heuristic) {
        return unicodeWrap(str, heuristic, true);
    }

    public java.lang.CharSequence unicodeWrap(java.lang.CharSequence str, androidx.core.text.TextDirectionHeuristicCompat heuristic, boolean isolate) {
        androidx.core.text.TextDirectionHeuristicCompat lTR2;
        boolean stereoReset;
        int mIsRtlContext;
        androidx.core.text.TextDirectionHeuristicCompat lTR;
        int i;
        if (str == null) {
            return null;
        }
        boolean rtl = heuristic.isRtl(str, 0, str.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && isolate) {
            if (isolate) {
                lTR2 = rtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR;
                spannableStringBuilder.append(markBefore(str, lTR2));
            }
        }
        if (rtl != this.mIsRtlContext) {
            i = rtl ? 8235 : 8234;
            spannableStringBuilder.append(i);
            spannableStringBuilder.append(str);
            spannableStringBuilder.append('\u202c');
        } else {
            spannableStringBuilder.append(str);
        }
        if (isolate) {
            lTR = rtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR;
            spannableStringBuilder.append(markAfter(str, lTR));
        }
        return spannableStringBuilder;
    }

    public java.lang.CharSequence unicodeWrap(java.lang.CharSequence str, boolean isolate) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, isolate);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, androidx.core.text.TextDirectionHeuristicCompat heuristic) {
        return unicodeWrap(str, heuristic, true);
    }

    public String unicodeWrap(String str, androidx.core.text.TextDirectionHeuristicCompat heuristic, boolean isolate) {
        if (str == null) {
            return null;
        }
        return unicodeWrap(str, heuristic, isolate).toString();
    }

    public String unicodeWrap(String str, boolean isolate) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, isolate);
    }
}
