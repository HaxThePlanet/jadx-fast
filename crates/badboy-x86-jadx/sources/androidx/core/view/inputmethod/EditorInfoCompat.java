package androidx.core.view.inputmethod;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.Preconditions;

/* loaded from: classes5.dex */
public final class EditorInfoCompat {

    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = null;
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;
    static final String STYLUS_HANDWRITING_ENABLED_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";

    private static class Api30Impl {
        static java.lang.CharSequence getInitialSelectedText(EditorInfo editorInfo, int flags) {
            return editorInfo.getInitialSelectedText(flags);
        }

        static java.lang.CharSequence getInitialTextAfterCursor(EditorInfo editorInfo, int length, int flags) {
            return editorInfo.getInitialTextAfterCursor(length, flags);
        }

        static java.lang.CharSequence getInitialTextBeforeCursor(EditorInfo editorInfo, int length, int flags) {
            return editorInfo.getInitialTextBeforeCursor(length, flags);
        }

        static void setInitialSurroundingSubText(EditorInfo editorInfo, java.lang.CharSequence sourceText, int subTextStart) {
            editorInfo.setInitialSurroundingSubText(sourceText, subTextStart);
        }
    }

    private static class Api35Impl {
        static boolean isStylusHandwritingEnabled(EditorInfo editorInfo) {
            return editorInfo.isStylusHandwritingEnabled();
        }

        static void setStylusHandwritingEnabled(EditorInfo editorInfo, boolean enabled) {
            editorInfo.setStylusHandwritingEnabled(enabled);
        }
    }
    static {
        EditorInfoCompat.EMPTY_STRING_ARRAY = new String[0];
    }

    public static String[] getContentMimeTypes(EditorInfo editorInfo) {
        String[] eMPTY_STRING_ARRAY;
        final String[] contentMimeTypes = editorInfo.contentMimeTypes;
        eMPTY_STRING_ARRAY = contentMimeTypes != null ? contentMimeTypes : EditorInfoCompat.EMPTY_STRING_ARRAY;
        return eMPTY_STRING_ARRAY;
    }

    public static java.lang.CharSequence getInitialSelectedText(EditorInfo editorInfo, int flags) {
        Object subSequence;
        int initialSelStart;
        if (Build.VERSION.SDK_INT >= 30) {
            return EditorInfoCompat.Api30Impl.getInitialSelectedText(editorInfo, flags);
        }
        int i3 = 0;
        if (editorInfo.extras == null) {
            return i3;
        }
        int int = editorInfo.extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD");
        int int2 = editorInfo.extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END");
        if (editorInfo.initialSelStart >= 0 && editorInfo.initialSelEnd >= 0) {
            if (editorInfo.initialSelEnd >= 0) {
                if (int2 - int != i5 - i) {
                } else {
                    java.lang.CharSequence charSequence = editorInfo.extras.getCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT");
                    if (charSequence == null) {
                        return i3;
                    }
                    if (flags & 1 != 0) {
                        subSequence = charSequence.subSequence(int, int2);
                    } else {
                        subSequence = TextUtils.substring(charSequence, int, int2);
                    }
                }
                return subSequence;
            }
        }
        return i3;
    }

    public static java.lang.CharSequence getInitialTextAfterCursor(EditorInfo editorInfo, int length, int flags) {
        Object subSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return EditorInfoCompat.Api30Impl.getInitialTextAfterCursor(editorInfo, length, flags);
        }
        int i2 = 0;
        if (editorInfo.extras == null) {
            return i2;
        }
        java.lang.CharSequence charSequence = editorInfo.extras.getCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT");
        if (charSequence == null) {
            return i2;
        }
        int int = editorInfo.extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END");
        int i4 = Math.min(length, length2 -= int);
        if (flags & 1 != 0) {
            subSequence = charSequence.subSequence(int, int + i4);
        } else {
            subSequence = TextUtils.substring(charSequence, int, int + i4);
        }
        return subSequence;
    }

    public static java.lang.CharSequence getInitialTextBeforeCursor(EditorInfo editorInfo, int length, int flags) {
        Object subSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return EditorInfoCompat.Api30Impl.getInitialTextBeforeCursor(editorInfo, length, flags);
        }
        int i2 = 0;
        if (editorInfo.extras == null) {
            return i2;
        }
        java.lang.CharSequence charSequence = editorInfo.extras.getCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT");
        if (charSequence == null) {
            return i2;
        }
        int int = editorInfo.extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD");
        int i3 = Math.min(length, int);
        if (flags & 1 != 0) {
            subSequence = charSequence.subSequence(int - i3, int);
        } else {
            subSequence = TextUtils.substring(charSequence, int - i3, int);
        }
        return subSequence;
    }

    static int getProtocol(EditorInfo editorInfo) {
        return 1;
    }

    private static boolean isCutOnSurrogate(java.lang.CharSequence sourceText, int cutPosition, int policy) {
        switch (policy) {
            case 0:
                return Character.isLowSurrogate(sourceText.charAt(cutPosition));
            case 1:
                return Character.isHighSurrogate(sourceText.charAt(cutPosition));
            default:
                return 0;
        }
    }

    private static boolean isPasswordInputType(int inputType) {
        int i2;
        int i;
        final int i3 = inputType & 4095;
        if (i3 != 129 && i3 != 225) {
            if (i3 != 225) {
                if (i3 == 18) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static boolean isStylusHandwritingEnabled(EditorInfo editorInfo) {
        Bundle extras;
        String str;
        str = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";
        if (editorInfo.extras != null && editorInfo.extras.containsKey(str)) {
            str = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";
            if (editorInfo.extras.containsKey(str)) {
                return editorInfo.extras.getBoolean(str);
            }
        }
        if (Build.VERSION.SDK_INT >= 35) {
            return EditorInfoCompat.Api35Impl.isStylusHandwritingEnabled(editorInfo);
        }
        return 0;
    }

    public static void setContentMimeTypes(EditorInfo editorInfo, String[] contentMimeTypes) {
        editorInfo.contentMimeTypes = contentMimeTypes;
    }

    public static void setInitialSurroundingSubText(EditorInfo editorInfo, java.lang.CharSequence subText, int subTextStart) {
        int i;
        int i2;
        Preconditions.checkNotNull(subText);
        if (Build.VERSION.SDK_INT >= 30) {
            EditorInfoCompat.Api30Impl.setInitialSurroundingSubText(editorInfo, subText, subTextStart);
        }
        i = editorInfo.initialSelStart > editorInfo.initialSelEnd ? initialSelEnd - subTextStart : initialSelStart2 - subTextStart;
        i2 = editorInfo.initialSelStart > editorInfo.initialSelEnd ? initialSelStart4 - subTextStart : initialSelEnd3 - subTextStart;
        int length = subText.length();
        int i4 = 0;
        final int i6 = 0;
        if (subTextStart >= 0 && i >= 0) {
            if (i >= 0) {
                if (i2 > length) {
                } else {
                    if (EditorInfoCompat.isPasswordInputType(editorInfo.inputType)) {
                        EditorInfoCompat.setSurroundingText(editorInfo, i4, i6, i6);
                    }
                    if (length <= 2048) {
                        EditorInfoCompat.setSurroundingText(editorInfo, subText, i, i2);
                    }
                }
                EditorInfoCompat.trimLongSurroundingText(editorInfo, subText, i, i2);
            }
        }
        EditorInfoCompat.setSurroundingText(editorInfo, i4, i6, i6);
    }

    public static void setInitialSurroundingText(EditorInfo editorInfo, java.lang.CharSequence sourceText) {
        final int i2 = 0;
        if (Build.VERSION.SDK_INT >= 30) {
            EditorInfoCompat.Api30Impl.setInitialSurroundingSubText(editorInfo, sourceText, i2);
        } else {
            EditorInfoCompat.setInitialSurroundingSubText(editorInfo, sourceText, i2);
        }
    }

    public static void setStylusHandwritingEnabled(EditorInfo editorInfo, boolean enabled) {
        Bundle extras;
        if (Build.VERSION.SDK_INT >= 35) {
            EditorInfoCompat.Api35Impl.setStylusHandwritingEnabled(editorInfo, enabled);
        }
        if (editorInfo.extras == null) {
            extras = new Bundle();
            editorInfo.extras = extras;
        }
        editorInfo.extras.putBoolean("androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED", enabled);
    }

    private static void setSurroundingText(EditorInfo editorInfo, java.lang.CharSequence surroundingText, int selectionHead, int selectionEnd) {
        Bundle extras;
        SpannableStringBuilder spannableStringBuilder;
        if (editorInfo.extras == null) {
            extras = new Bundle();
            editorInfo.extras = extras;
        }
        if (surroundingText != null) {
            spannableStringBuilder = new SpannableStringBuilder(surroundingText);
        } else {
            spannableStringBuilder = 0;
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", spannableStringBuilder);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", selectionHead);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", selectionEnd);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, java.lang.CharSequence subText, int selStart, int selEnd) {
        int i2;
        java.lang.CharSequence subSequence;
        int newAfterCursorLength;
        int newBeforeCursorLength;
        int newBeforeCursorHead;
        java.lang.CharSequence subSequence3;
        java.lang.CharSequence subSequence2;
        int i;
        final java.lang.CharSequence charSequence = subText;
        final int i3 = selStart;
        final int i4 = selEnd;
        final int i5 = i4 - i3;
        int i7 = 0;
        i2 = i5 > 1024 ? i7 : i5;
        final int i10 = i2 - 2048;
        newAfterCursorLength = Math.min(length -= i4, i10 - i12);
        newBeforeCursorLength = Math.min(i3, i10 - newAfterCursorLength);
        if (EditorInfoCompat.isCutOnSurrogate(charSequence, i3 - newBeforeCursorLength, i7)) {
            newBeforeCursorHead++;
            newBeforeCursorLength--;
        }
        int i21 = 1;
        if (EditorInfoCompat.isCutOnSurrogate(charSequence, i17 -= i21, i21)) {
            newAfterCursorLength--;
        }
        if (i2 != i5) {
            java.lang.CharSequence[] arr = new CharSequence[2];
            arr[i7] = charSequence.subSequence(newBeforeCursorHead, newBeforeCursorHead + newBeforeCursorLength);
            arr[i21] = charSequence.subSequence(i4, i4 + newAfterCursorLength);
            subSequence = TextUtils.concat(arr);
        } else {
            subSequence = charSequence.subSequence(newBeforeCursorHead, newBeforeCursorHead + i20);
        }
        int i22 = newBeforeCursorHead2 + newBeforeCursorLength;
        EditorInfoCompat.setSurroundingText(editorInfo, subSequence, i22, i22 + i2);
    }
}
