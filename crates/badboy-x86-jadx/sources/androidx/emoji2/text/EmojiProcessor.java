package androidx.emoji2.text;

import _COROUTINE.ArtificialStackFrames;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes5.dex */
final class EmojiProcessor {

    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;
    private static final int MAX_LOOK_AROUND_CHARACTER = 16;
    private final int[] mEmojiAsDefaultStyleExceptions;
    private androidx.emoji2.text.EmojiCompat.GlyphChecker mGlyphChecker;
    private final androidx.emoji2.text.MetadataRepo mMetadataRepo;
    private final androidx.emoji2.text.EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    private static final class CodepointIndexFinder {

        private static final int INVALID_INDEX = -1;
        static int findIndexBackward(java.lang.CharSequence cs, int from, int numCodePoints) {
            int currentIndex;
            int waitingHighSurrogate;
            int remainingCodePoints;
            char charAt;
            boolean highSurrogate;
            currentIndex = from;
            waitingHighSurrogate = 0;
            int i = -1;
            if (currentIndex >= 0) {
                if (cs.length() < currentIndex) {
                } else {
                    if (numCodePoints < 0) {
                        return i;
                    }
                    remainingCodePoints = numCodePoints;
                    while (remainingCodePoints == 0) {
                        currentIndex--;
                        charAt = cs.charAt(currentIndex);
                        waitingHighSurrogate = 1;
                        remainingCodePoints--;
                        waitingHighSurrogate = 0;
                        remainingCodePoints--;
                    }
                }
                return currentIndex;
            }
            return i;
        }

        static int findIndexForward(java.lang.CharSequence cs, int from, int numCodePoints) {
            int currentIndex;
            int waitingLowSurrogate;
            int remainingCodePoints;
            char charAt;
            boolean lowSurrogate;
            currentIndex = from;
            waitingLowSurrogate = 0;
            final int length = cs.length();
            final int i = -1;
            if (currentIndex >= 0) {
                if (length < currentIndex) {
                } else {
                    if (numCodePoints < 0) {
                        return i;
                    }
                    remainingCodePoints = numCodePoints;
                    while (remainingCodePoints == 0) {
                        charAt = cs.charAt(currentIndex);
                        waitingLowSurrogate = 1;
                        currentIndex++;
                        remainingCodePoints--;
                        currentIndex++;
                        remainingCodePoints--;
                        waitingLowSurrogate = 0;
                        currentIndex++;
                    }
                }
                return currentIndex;
            }
            return i;
        }
    }

    private interface EmojiProcessCallback {
        public abstract T getResult();

        public abstract boolean handleEmoji(java.lang.CharSequence charSequence, int i2, int i3, androidx.emoji2.text.TypefaceEmojiRasterizer typefaceEmojiRasterizer4);
    }

    private static class EmojiProcessAddSpanCallback implements androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback<androidx.emoji2.text.UnprecomputeTextOnModificationSpannable> {

        private final androidx.emoji2.text.EmojiCompat.SpanFactory mSpanFactory;
        public androidx.emoji2.text.UnprecomputeTextOnModificationSpannable spannable;
        EmojiProcessAddSpanCallback(androidx.emoji2.text.UnprecomputeTextOnModificationSpannable spannable, androidx.emoji2.text.EmojiCompat.SpanFactory spanFactory) {
            super();
            this.spannable = spannable;
            this.mSpanFactory = spanFactory;
        }

        @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
        public androidx.emoji2.text.UnprecomputeTextOnModificationSpannable getResult() {
            return this.spannable;
        }

        @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
        public Object getResult() {
            return getResult();
        }

        @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
        public boolean handleEmoji(java.lang.CharSequence charSequence, int start, int end, androidx.emoji2.text.TypefaceEmojiRasterizer metadata) {
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable;
            Object spannableString;
            final int i = 1;
            if (metadata.isPreferredSystemRender()) {
                return i;
            }
            if (this.spannable == null) {
                if (charSequence instanceof Spannable) {
                    spannableString = charSequence;
                } else {
                    spannableString = new SpannableString(charSequence);
                }
                unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable(spannableString);
                this.spannable = unprecomputeTextOnModificationSpannable;
            }
            this.spannable.setSpan(this.mSpanFactory.createSpan(metadata), start, end, 33);
            return i;
        }
    }

    private static class EmojiProcessLookupCallback implements androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback<androidx.emoji2.text.EmojiProcessor.EmojiProcessLookupCallback> {

        public int end = -1;
        private final int mOffset;
        public int start = -1;
        EmojiProcessLookupCallback(int offset) {
            super();
            final int i = -1;
            this.mOffset = offset;
        }

        @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
        public androidx.emoji2.text.EmojiProcessor.EmojiProcessLookupCallback getResult() {
            return this;
        }

        @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
        public Object getResult() {
            return getResult();
        }

        @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
        public boolean handleEmoji(java.lang.CharSequence charSequence, int start, int end, androidx.emoji2.text.TypefaceEmojiRasterizer metadata) {
            int mOffset;
            int i;
            if (start <= this.mOffset && this.mOffset < end) {
                if (this.mOffset < end) {
                    this.start = start;
                    this.end = end;
                    return 0;
                }
            }
            if (end <= this.mOffset) {
                i = 1;
            }
            return i;
        }
    }

    private static class MarkExclusionCallback implements androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback<androidx.emoji2.text.EmojiProcessor.MarkExclusionCallback> {

        private final String mExclusion;
        MarkExclusionCallback(String emoji) {
            super();
            this.mExclusion = emoji;
        }

        @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
        public androidx.emoji2.text.EmojiProcessor.MarkExclusionCallback getResult() {
            return this;
        }

        @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
        public Object getResult() {
            return getResult();
        }

        @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
        public boolean handleEmoji(java.lang.CharSequence charSequence, int start, int end, androidx.emoji2.text.TypefaceEmojiRasterizer metadata) {
            int i2 = 1;
            if (TextUtils.equals(charSequence.subSequence(start, end), this.mExclusion)) {
                metadata.setExclusion(i2);
                return 0;
            }
            return i2;
        }
    }

    static final class ProcessorSm {

        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private androidx.emoji2.text.MetadataRepo.Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private androidx.emoji2.text.MetadataRepo.Node mFlushNode;
        private int mLastCodepoint;
        private final androidx.emoji2.text.MetadataRepo.Node mRootNode;
        private int mState = 1;
        private final boolean mUseEmojiAsDefaultStyle;
        ProcessorSm(androidx.emoji2.text.MetadataRepo.Node rootNode, boolean useEmojiAsDefaultStyle, int[] emojiAsDefaultStyleExceptions) {
            super();
            final int i = 1;
            this.mRootNode = rootNode;
            this.mCurrentNode = rootNode;
            this.mUseEmojiAsDefaultStyle = useEmojiAsDefaultStyle;
            this.mEmojiAsDefaultStyleExceptions = emojiAsDefaultStyleExceptions;
        }

        private static boolean isEmojiStyle(int codePoint) {
            int i;
            i = codePoint == 65039 ? 1 : 0;
            return i;
        }

        private static boolean isTextStyle(int codePoint) {
            int i;
            i = codePoint == 65038 ? 1 : 0;
            return i;
        }

        private int reset() {
            final int i = 1;
            this.mState = i;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return i;
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            boolean mUseEmojiAsDefaultStyle;
            int binarySearch;
            final int i = 1;
            if (this.mCurrentNode.getData().isDefaultEmoji()) {
                return i;
            }
            if (EmojiProcessor.ProcessorSm.isEmojiStyle(this.mLastCodepoint)) {
                return i;
            }
            final int i2 = 0;
            if (this.mUseEmojiAsDefaultStyle && this.mEmojiAsDefaultStyleExceptions == null) {
                if (this.mEmojiAsDefaultStyleExceptions == null) {
                    return i;
                }
                if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, this.mCurrentNode.getData().getCodepointAt(i2)) < 0) {
                    return i;
                }
            }
            return i2;
        }

        int check(int codePoint) {
            int reset;
            if (/* condition */) {
                if (node2 != null) {
                    this.mCurrentNode = node2;
                    this.mCurrentDepth = mCurrentDepth += i2;
                    reset = 2;
                } else {
                    if (EmojiProcessor.ProcessorSm.isTextStyle(codePoint)) {
                        reset = reset();
                    } else {
                        if (EmojiProcessor.ProcessorSm.isEmojiStyle(codePoint)) {
                            reset = 2;
                        } else {
                            if (this.mCurrentNode.getData() != null) {
                                if (this.mCurrentDepth == i2) {
                                    if (shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                                        this.mFlushNode = this.mCurrentNode;
                                        reset = 3;
                                        reset();
                                    } else {
                                        reset = reset();
                                    }
                                } else {
                                    this.mFlushNode = this.mCurrentNode;
                                    reset = 3;
                                    reset();
                                }
                            } else {
                                reset = reset();
                            }
                        }
                    }
                }
            } else {
                if (node2 == null) {
                    reset = reset();
                } else {
                    this.mState = 2;
                    this.mCurrentNode = node2;
                    this.mCurrentDepth = i2;
                    reset = 2;
                }
            }
            this.mLastCodepoint = codePoint;
            return reset;
        }

        androidx.emoji2.text.TypefaceEmojiRasterizer getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        androidx.emoji2.text.TypefaceEmojiRasterizer getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        boolean isInFlushableState() {
            int useEmojiPresentationStyleForSingleCodepoint;
            int i;
            if (this.mState == 2 && this.mCurrentNode.getData() != null) {
                if (this.mCurrentNode.getData() != null) {
                    if (this.mCurrentDepth <= 1) {
                        if (shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                        } else {
                            i = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
    }
    EmojiProcessor(androidx.emoji2.text.MetadataRepo metadataRepo, androidx.emoji2.text.EmojiCompat.SpanFactory spanFactory, androidx.emoji2.text.EmojiCompat.GlyphChecker glyphChecker, boolean useEmojiAsDefaultStyle, int[] emojiAsDefaultStyleExceptions, Set<int[]> set6) {
        super();
        this.mSpanFactory = spanFactory;
        this.mMetadataRepo = metadataRepo;
        this.mGlyphChecker = glyphChecker;
        this.mUseEmojiAsDefaultStyle = useEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = emojiAsDefaultStyleExceptions;
        initExclusions(set6);
    }

    private static boolean delete(Editable content, KeyEvent event, boolean forwardDelete) {
        int length;
        int index;
        Object obj;
        int spanStart;
        int spanEnd;
        int i = 0;
        if (EmojiProcessor.hasModifiers(event)) {
            return i;
        }
        int selectionStart = Selection.getSelectionStart(content);
        final int selectionEnd = Selection.getSelectionEnd(content);
        if (EmojiProcessor.hasInvalidSelection(selectionStart, selectionEnd)) {
            return i;
        }
        Object[] spans = content.getSpans(selectionStart, selectionEnd, EmojiSpan.class);
        if ((EmojiSpan[])spans != null && spans.length > 0) {
            if (spans.length > 0) {
                index = 0;
                while (index < spans.length) {
                    obj = (EmojiSpan[])spans[index];
                    spanStart = content.getSpanStart(obj);
                    spanEnd = content.getSpanEnd(obj);
                    index++;
                }
            }
        }
        return i;
    }

    static boolean handleDeleteSurroundingText(InputConnection inputConnection, Editable editable, int beforeLength, int afterLength, boolean inCodePoints) {
        int start;
        int end;
        int length2;
        int length;
        int index;
        Object obj;
        int spanStart;
        int spanEnd;
        int i = 0;
        if (editable != null) {
            if (inputConnection == null) {
            } else {
                if (beforeLength >= 0) {
                    if (afterLength < 0) {
                    } else {
                        final int selectionStart = Selection.getSelectionStart(editable);
                        final int selectionEnd = Selection.getSelectionEnd(editable);
                        if (EmojiProcessor.hasInvalidSelection(selectionStart, selectionEnd)) {
                            return i;
                        }
                        length2 = -1;
                        if (inCodePoints && EmojiProcessor.CodepointIndexFinder.findIndexBackward(editable, selectionStart, Math.max(beforeLength, i)) != length2 && EmojiProcessor.CodepointIndexFinder.findIndexForward(editable, selectionEnd, Math.max(afterLength, i)) == length2) {
                            length2 = -1;
                            if (EmojiProcessor.CodepointIndexFinder.findIndexBackward(editable, selectionStart, Math.max(beforeLength, i)) != length2) {
                                if (EmojiProcessor.CodepointIndexFinder.findIndexForward(editable, selectionEnd, Math.max(afterLength, i)) == length2) {
                                }
                                Object[] spans = editable.getSpans(start, end, EmojiSpan.class);
                                if ((EmojiSpan[])spans != null && spans.length > 0) {
                                    if (spans.length > 0) {
                                        index = 0;
                                        while (index < spans.length) {
                                            obj = (EmojiSpan[])spans[index];
                                            start = Math.min(editable.getSpanStart(obj), start);
                                            end = Math.max(editable.getSpanEnd(obj), end);
                                            index++;
                                        }
                                        inputConnection.beginBatchEdit();
                                        editable.delete(Math.max(start, i), Math.min(end, editable.length()));
                                        inputConnection.endBatchEdit();
                                        return 1;
                                    }
                                }
                            }
                            return i;
                        }
                        start = Math.max(selectionStart - beforeLength, i);
                        end = Math.min(selectionEnd + afterLength, editable.length());
                    }
                    return i;
                }
            }
            return i;
        }
        return i;
    }

    static boolean handleOnKeyDown(Editable editable, int keyCode, KeyEvent event) {
        boolean delete;
        final int i = 1;
        final int i2 = 0;
        switch (keyCode) {
            case 67:
                delete = EmojiProcessor.delete(editable, event, i2);
                break;
            case 112:
                delete = EmojiProcessor.delete(editable, event, i);
                break;
            default:
                delete = 0;
        }
        if (delete) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            return i;
        }
        return i2;
    }

    private boolean hasGlyph(java.lang.CharSequence charSequence, int start, int end, androidx.emoji2.text.TypefaceEmojiRasterizer rasterizer) {
        int hasGlyph;
        int i;
        short sdkAdded;
        if (rasterizer.getHasGlyph() == 0) {
            rasterizer.setHasGlyph(this.mGlyphChecker.hasGlyph(charSequence, start, end, rasterizer.getSdkAdded()));
        }
        i = rasterizer.getHasGlyph() == 2 ? 1 : 0;
        return i;
    }

    private static boolean hasInvalidSelection(int start, int end) {
        int i;
        int i2 = -1;
        if (start != i2 && end != i2) {
            if (end != i2) {
                if (start != end) {
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

    private static boolean hasModifiers(KeyEvent event) {
        return metaStateHasNoModifiers ^= 1;
    }

    private void initExclusions(Set<int[]> set) {
        Object next;
        String string;
        int i;
        int length;
        Object obj;
        String str;
        int i2;
        int length2;
        int i3;
        int i4;
        androidx.emoji2.text.EmojiProcessor.MarkExclusionCallback markExclusionCallback;
        if (set.isEmpty()) {
        }
        Iterator iterator = set.iterator();
        for (int[] next : iterator) {
            string = new String(next, 0, next.length);
            str = string;
            markExclusionCallback = new EmojiProcessor.MarkExclusionCallback(str);
            this.process(str, 0, str.length(), 1, true, markExclusionCallback);
        }
    }

    private <T> T process(java.lang.CharSequence charSequence, int start, int end, int maxEmojiCount, boolean processAll, androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback<T> emojiProcessor$EmojiProcessCallback6) {
        int addedCount;
        Object sm;
        int currentOffset;
        int codePoint;
        int keepProcessing;
        int check;
        boolean inFlushableState;
        boolean flushMetadata;
        int obj9;
        addedCount = 0;
        EmojiProcessor.ProcessorSm processorSm = new EmojiProcessor.ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        codePoint = Character.codePointAt(charSequence, start);
        keepProcessing = 1;
        while (currentOffset < end) {
            if (addedCount < maxEmojiCount) {
            }
            if (keepProcessing != 0) {
            }
            if (!processAll) {
            } else {
            }
            keepProcessing = emojiProcessCallback6.handleEmoji(charSequence, obj9, currentOffset, processorSm.getFlushMetadata());
            addedCount++;
            obj9 = currentOffset;
            if (!hasGlyph(charSequence, obj9, currentOffset, processorSm.getFlushMetadata())) {
            }
            currentOffset += flushMetadata;
            if (currentOffset < end) {
            }
            codePoint = Character.codePointAt(charSequence, currentOffset);
            currentOffset = obj9;
            if (currentOffset < end) {
            }
            codePoint = Character.codePointAt(charSequence, currentOffset);
        }
        if (processorSm.isInFlushableState() && addedCount < maxEmojiCount && keepProcessing != 0) {
            if (addedCount < maxEmojiCount) {
                if (keepProcessing != 0) {
                    if (!processAll) {
                        if (!hasGlyph(charSequence, obj9, currentOffset, processorSm.getCurrentMetadata())) {
                            emojiProcessCallback6.handleEmoji(charSequence, obj9, currentOffset, processorSm.getCurrentMetadata());
                            addedCount++;
                        }
                    } else {
                    }
                }
            }
        }
        return emojiProcessCallback6.getResult();
    }

    int getEmojiEnd(java.lang.CharSequence charSequence, int offset) {
        boolean z;
        int length;
        Object[] spans;
        int length2;
        Object charSequence2;
        if (offset >= 0) {
            if (offset >= charSequence.length()) {
                charSequence2 = charSequence;
                return -1;
            } else {
                int i = 0;
                z = charSequence;
                spans = (Spanned)z.getSpans(offset, offset + 1, EmojiSpan.class);
                if (charSequence instanceof Spanned && spans.length > 0) {
                    z = charSequence;
                    spans = (Spanned)z.getSpans(offset, offset + 1, EmojiSpan.class);
                    if (spans.length > 0) {
                        return z.getSpanEnd((EmojiSpan[])(EmojiSpan[])spans[i]);
                    }
                }
            }
            EmojiProcessor.EmojiProcessLookupCallback emojiProcessLookupCallback = new EmojiProcessor.EmojiProcessLookupCallback(offset);
            return obj10.end;
        }
        charSequence2 = charSequence;
    }

    int getEmojiMatch(java.lang.CharSequence charSequence) {
        return getEmojiMatch(charSequence, this.mMetadataRepo.getMetadataVersion());
    }

    int getEmojiMatch(java.lang.CharSequence charSequence, int metadataVersion) {
        int currentOffset;
        int potentialSubsequenceMatch;
        int subsequenceMatch;
        int codePointAt;
        int check;
        boolean inFlushableState;
        androidx.emoji2.text.TypefaceEmojiRasterizer currentNode;
        int compatAdded;
        EmojiProcessor.ProcessorSm processorSm = new EmojiProcessor.ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        currentOffset = 0;
        potentialSubsequenceMatch = 0;
        subsequenceMatch = 0;
        while (currentOffset < charSequence.length()) {
            codePointAt = Character.codePointAt(charSequence, currentOffset);
            currentNode = processorSm.getCurrentMetadata();
            if (currentNode != null && currentNode.getCompatAdded() <= metadataVersion) {
            }
            if (currentNode.getCompatAdded() <= metadataVersion) {
            }
            potentialSubsequenceMatch++;
            if (processorSm.getFlushMetadata().getCompatAdded() <= metadataVersion) {
            }
            subsequenceMatch++;
            currentOffset += compatAdded;
            currentOffset += compatAdded;
            potentialSubsequenceMatch = 0;
        }
        int i = 2;
        if (subsequenceMatch != 0) {
            return i;
        }
        if (processorSm.isInFlushableState() && processorSm.getCurrentMetadata().getCompatAdded() <= metadataVersion) {
            if (processorSm.getCurrentMetadata().getCompatAdded() <= metadataVersion) {
                return 1;
            }
        }
        if (potentialSubsequenceMatch == 0) {
            return 0;
        }
        return i;
    }

    int getEmojiStart(java.lang.CharSequence charSequence, int offset) {
        boolean z;
        int length2;
        Object[] spans;
        int length;
        Object charSequence2;
        if (offset >= 0) {
            if (offset >= charSequence.length()) {
                charSequence2 = charSequence;
                return -1;
            } else {
                int i = 0;
                z = charSequence;
                spans = (Spanned)z.getSpans(offset, offset + 1, EmojiSpan.class);
                if (charSequence instanceof Spanned && spans.length > 0) {
                    z = charSequence;
                    spans = (Spanned)z.getSpans(offset, offset + 1, EmojiSpan.class);
                    if (spans.length > 0) {
                        return z.getSpanStart((EmojiSpan[])(EmojiSpan[])spans[i]);
                    }
                }
            }
            EmojiProcessor.EmojiProcessLookupCallback emojiProcessLookupCallback = new EmojiProcessor.EmojiProcessLookupCallback(offset);
            return obj10.start;
        }
        charSequence2 = charSequence;
    }

    java.lang.CharSequence process(java.lang.CharSequence charSequence, int start, int end, int maxEmojiCount, boolean replaceAll) {
        Object spannable;
        int spannable2;
        boolean z;
        boolean unprecomputeTextOnModificationSpannable2;
        Object unprecomputeTextOnModificationSpannable;
        Object charSequence2;
        int i5;
        int index2;
        int index;
        Class<androidx.emoji2.text.EmojiSpan> obj;
        int i4;
        int spanStart;
        int i;
        int spanEnd;
        int i3;
        int i2;
        Object obj10;
        int obj11;
        int obj12;
        int obj13;
        final boolean z2 = charSequence instanceof SpannableBuilder;
        if (z2) {
            (SpannableBuilder)charSequence.beginBatchEdit();
        }
        spannable2 = 0;
        if (!z2) {
            if (charSequence instanceof Spannable) {
                unprecomputeTextOnModificationSpannable2 = new UnprecomputeTextOnModificationSpannable((Spannable)charSequence);
                spannable2 = unprecomputeTextOnModificationSpannable2;
            } else {
                if (charSequence instanceof Spanned && (Spanned)charSequence.nextSpanTransition(start + -1, end + 1, EmojiSpan.class) <= end) {
                    if ((Spanned)charSequence.nextSpanTransition(start + -1, end + 1, EmojiSpan.class) <= end) {
                        unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable(charSequence);
                        spannable2 = unprecomputeTextOnModificationSpannable;
                    }
                }
            }
        } else {
        }
        unprecomputeTextOnModificationSpannable2 = spannable2.getSpans(start, end, EmojiSpan.class);
        if (spannable2 != 0 && (EmojiSpan[])unprecomputeTextOnModificationSpannable2 != null && unprecomputeTextOnModificationSpannable2.length > 0) {
            unprecomputeTextOnModificationSpannable2 = spannable2.getSpans(start, end, EmojiSpan.class);
            if ((EmojiSpan[])(EmojiSpan[])unprecomputeTextOnModificationSpannable2 != null) {
                if (unprecomputeTextOnModificationSpannable2.length > 0) {
                    try {
                        index2 = 0;
                        while (index2 < unprecomputeTextOnModificationSpannable2.length) {
                            obj = (EmojiSpan[])(EmojiSpan[])unprecomputeTextOnModificationSpannable2[index2];
                            spanStart = spannable2.getSpanStart(obj);
                            if (spanStart != obj12) {
                            }
                            obj11 = i6;
                            obj12 = i2;
                            index2++;
                            spannable2.removeSpan(obj);
                        }
                        obj = unprecomputeTextOnModificationSpannable2[index2];
                        spanStart = spannable2.getSpanStart(obj);
                        if (spanStart != obj12) {
                        }
                        spannable2.removeSpan(obj);
                        obj11 = i6;
                        obj12 = i2;
                        index2++;
                        index = obj11;
                        i4 = obj12;
                        index = start;
                        i4 = end;
                        if (index != i4) {
                        }
                        if (index >= charSequence.length()) {
                        } else {
                        }
                        charSequence2 = charSequence;
                        i3 = replaceAll;
                        if (maxEmojiCount != Integer.MAX_VALUE && spannable2 != 0) {
                        } else {
                        }
                        if (spannable2 != 0) {
                        } else {
                        }
                        i = obj13;
                        spanEnd = replaceAll;
                        start = obj4;
                        end = obj5;
                        i = maxEmojiCount;
                        EmojiProcessor.EmojiProcessAddSpanCallback emojiProcessAddSpanCallback = new EmojiProcessor.EmojiProcessAddSpanCallback(spannable2, this.mSpanFactory);
                        Object obj5 = charSequence;
                        obj10 = this.process(obj5, index, i4, i, replaceAll, emojiProcessAddSpanCallback);
                        if (obj10 != null && z2) {
                        }
                        if (z2) {
                        }
                        (SpannableBuilder)obj5.endBatchEdit();
                        return obj10.getUnwrappedSpannable();
                        if (z2) {
                        }
                        (SpannableBuilder)obj5.endBatchEdit();
                        return obj5;
                        start = obj4;
                        end = obj5;
                        maxEmojiCount = obj6;
                        spanEnd = replaceAll;
                        start = obj4;
                        end = obj5;
                        maxEmojiCount = obj6;
                        spanEnd = replaceAll;
                        start = obj4;
                        end = obj5;
                        charSequence2 = charSequence;
                        i3 = replaceAll;
                        if (z2) {
                        }
                        (SpannableBuilder)charSequence2.endBatchEdit();
                        return charSequence2;
                    } catch (Throwable th) {
                    }
                    if (obj1 == null) {
                    } else {
                        charSequence = unprecomputeTextOnModificationSpannable;
                        (SpannableBuilder)charSequence.endBatchEdit();
                    }
                    throw spannable;
                } else {
                }
            } else {
            }
        } else {
        }
    }
}
