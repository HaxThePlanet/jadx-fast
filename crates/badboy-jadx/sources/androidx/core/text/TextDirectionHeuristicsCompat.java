package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class TextDirectionHeuristicsCompat {

    public static final androidx.core.text.TextDirectionHeuristicCompat ANYRTL_LTR = null;
    public static final androidx.core.text.TextDirectionHeuristicCompat FIRSTSTRONG_LTR = null;
    public static final androidx.core.text.TextDirectionHeuristicCompat FIRSTSTRONG_RTL = null;
    public static final androidx.core.text.TextDirectionHeuristicCompat LOCALE = null;
    public static final androidx.core.text.TextDirectionHeuristicCompat LTR = null;
    public static final androidx.core.text.TextDirectionHeuristicCompat RTL = null;
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    private interface TextDirectionAlgorithm {
        public abstract int checkRtl(java.lang.CharSequence charSequence, int i2, int i3);
    }

    private static class AnyStrong implements androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm {

        static final androidx.core.text.TextDirectionHeuristicsCompat.AnyStrong INSTANCE_RTL;
        private final boolean mLookForRtl;
        static {
            TextDirectionHeuristicsCompat.AnyStrong anyStrong = new TextDirectionHeuristicsCompat.AnyStrong(1);
            TextDirectionHeuristicsCompat.AnyStrong.INSTANCE_RTL = anyStrong;
        }

        private AnyStrong(boolean lookForRtl) {
            super();
            this.mLookForRtl = lookForRtl;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm
        public int checkRtl(java.lang.CharSequence cs, int start, int count) {
            int haveUnlookedFor;
            int i;
            int mLookForRtl;
            haveUnlookedFor = 0;
            i = start;
            while (i < start + count) {
                i++;
                haveUnlookedFor = 1;
                haveUnlookedFor = 1;
            }
            if (haveUnlookedFor != 0) {
                return this.mLookForRtl;
            }
            return 2;
        }
    }

    private static class FirstStrong implements androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm {

        static final androidx.core.text.TextDirectionHeuristicsCompat.FirstStrong INSTANCE;
        static {
            TextDirectionHeuristicsCompat.FirstStrong firstStrong = new TextDirectionHeuristicsCompat.FirstStrong();
            TextDirectionHeuristicsCompat.FirstStrong.INSTANCE = firstStrong;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm
        public int checkRtl(java.lang.CharSequence cs, int start, int count) {
            int result;
            int i;
            byte directionality;
            result = 2;
            i = start;
            while (i < start + count) {
                if (result == 2) {
                }
                result = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(cs.charAt(i)));
                i++;
            }
            return result;
        }
    }

    private static abstract class TextDirectionHeuristicImpl implements androidx.core.text.TextDirectionHeuristicCompat {

        private final androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;
        TextDirectionHeuristicImpl(androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm algorithm) {
            super();
            this.mAlgorithm = algorithm;
        }

        private boolean doCheck(java.lang.CharSequence cs, int start, int count) {
            switch (checkRtl) {
                case 0:
                    return 1;
                case 1:
                    return 0;
                default:
                    return defaultIsRtl();
            }
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        protected abstract boolean defaultIsRtl();

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(java.lang.CharSequence cs, int start, int count) {
            int i;
            if (cs == null) {
            } else {
                if (start < 0) {
                } else {
                    if (count < 0) {
                    } else {
                        if (length -= count < start) {
                        } else {
                            if (this.mAlgorithm == null) {
                                return defaultIsRtl();
                            }
                            return doCheck(cs, start, count);
                        }
                    }
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            throw illegalArgumentException;
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] array, int start, int count) {
            return isRtl(CharBuffer.wrap(array), start, count);
        }
    }

    private static class TextDirectionHeuristicInternal extends androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {

        private final boolean mDefaultIsRtl;
        TextDirectionHeuristicInternal(androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm algorithm, boolean defaultIsRtl) {
            super(algorithm);
            this.mDefaultIsRtl = defaultIsRtl;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
        protected boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    private static class TextDirectionHeuristicLocale extends androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {

        static final androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale INSTANCE;
        static {
            TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale textDirectionHeuristicLocale = new TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale();
            TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale.INSTANCE = textDirectionHeuristicLocale;
        }

        TextDirectionHeuristicLocale() {
            super(0);
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
        protected boolean defaultIsRtl() {
            int i;
            if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            } else {
                i = 0;
            }
            return i;
        }
    }
    static {
        int i = 0;
        final int i2 = 0;
        TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal textDirectionHeuristicInternal = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(i, i2);
        TextDirectionHeuristicsCompat.LTR = textDirectionHeuristicInternal;
        final int i3 = 1;
        TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal textDirectionHeuristicInternal2 = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(i, i3);
        TextDirectionHeuristicsCompat.RTL = textDirectionHeuristicInternal2;
        TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal textDirectionHeuristicInternal3 = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.FirstStrong.INSTANCE, i2);
        TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR = textDirectionHeuristicInternal3;
        TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal textDirectionHeuristicInternal4 = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.FirstStrong.INSTANCE, i3);
        TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL = textDirectionHeuristicInternal4;
        TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal textDirectionHeuristicInternal5 = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.AnyStrong.INSTANCE_RTL, i2);
        TextDirectionHeuristicsCompat.ANYRTL_LTR = textDirectionHeuristicInternal5;
        TextDirectionHeuristicsCompat.LOCALE = TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale.INSTANCE;
    }

    static int isRtlText(int directionality) {
        switch (directionality) {
            case 0:
                return 1;
            case 1:
                return 0;
            default:
                return 2;
        }
    }

    static int isRtlTextOrFormat(int directionality) {
        switch (directionality) {
            case 0:
                return 1;
            case 1:
                return 0;
            default:
                return 2;
        }
    }
}
