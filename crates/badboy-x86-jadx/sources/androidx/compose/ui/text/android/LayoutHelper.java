package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextUtils;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0018\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0019\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000c\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001:\u0001/B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\rJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aJ\u001d\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\rH\u0000¢\u0006\u0004\u0008\"\u0010#J\u000e\u0010$\u001a\u00020\r2\u0006\u0010!\u001a\u00020\rJ\u0010\u0010%\u001a\u00020\r2\u0008\u0008\u0001\u0010\u0015\u001a\u00020\rJ\u001a\u0010&\u001a\u00020\r2\u0008\u0008\u0001\u0010\u0018\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001aJ\u0010\u0010'\u001a\u00020\r2\u0008\u0008\u0001\u0010\u0015\u001a\u00020\rJ\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u001a2\u0008\u0008\u0001\u0010\u0015\u001a\u00020\rJ\u0018\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060", d2 = {"Landroidx/compose/ui/text/android/LayoutHelper;", "", "layout", "Landroid/text/Layout;", "(Landroid/text/Layout;)V", "bidiProcessedParagraphs", "", "getLayout", "()Landroid/text/Layout;", "paragraphBidi", "", "Ljava/text/Bidi;", "paragraphCount", "", "getParagraphCount", "()I", "paragraphEnds", "", "tmpBuffer", "", "analyzeBidi", "paragraphIndex", "getDownstreamHorizontal", "", "offset", "primary", "", "getHorizontalPosition", "usePrimaryDirection", "upstream", "getLineBidiRuns", "", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "lineIndex", "getLineBidiRuns$ui_text_release", "(I)[Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "getLineVisibleEnd", "getParagraphEnd", "getParagraphForOffset", "getParagraphStart", "isLineEndSpace", "c", "", "isRtlParagraph", "lineEndToVisibleEnd", "lineEnd", "lineStart", "BidiRun", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutHelper {

    public static final int $stable = 8;
    private final boolean[] bidiProcessedParagraphs;
    private final Layout layout;
    private final List<Bidi> paragraphBidi;
    private final int paragraphCount;
    private final List<Integer> paragraphEnds;
    private char[] tmpBuffer;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\t¨\u0006\u0015", d2 = {"Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "", "start", "", "end", "isRtl", "", "(IIZ)V", "getEnd", "()I", "()Z", "getStart", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BidiRun {

        public static final int $stable;
        private final int end;
        private final boolean isRtl;
        private final int start;
        static {
        }

        public BidiRun(int start, int end, boolean isRtl) {
            super();
            this.start = start;
            this.end = end;
            this.isRtl = isRtl;
        }

        public static androidx.compose.ui.text.android.LayoutHelper.BidiRun copy$default(androidx.compose.ui.text.android.LayoutHelper.BidiRun layoutHelper$BidiRun, int i2, int i3, boolean z4, int i5, Object object6) {
            int obj1;
            int obj2;
            boolean obj3;
            if (i5 & 1 != 0) {
                obj1 = bidiRun.start;
            }
            if (i5 & 2 != 0) {
                obj2 = bidiRun.end;
            }
            if (i5 &= 4 != 0) {
                obj3 = bidiRun.isRtl;
            }
            return bidiRun.copy(obj1, obj2, obj3);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final boolean component3() {
            return this.isRtl;
        }

        public final androidx.compose.ui.text.android.LayoutHelper.BidiRun copy(int i, int i2, boolean z3) {
            LayoutHelper.BidiRun bidiRun = new LayoutHelper.BidiRun(i, i2, z3);
            return bidiRun;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof LayoutHelper.BidiRun) {
                return i2;
            }
            Object obj = object;
            if (this.start != obj.start) {
                return i2;
            }
            if (this.end != obj.end) {
                return i2;
            }
            if (this.isRtl != obj.isRtl) {
                return i2;
            }
            return i;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return i2 += i7;
        }

        public final boolean isRtl() {
            return this.isRtl;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("BidiRun(start=").append(this.start).append(", end=").append(this.end).append(", isRtl=").append(this.isRtl).append(')').toString();
        }
    }
    static {
        final int i = 8;
    }

    public LayoutHelper(Layout layout) {
        int length;
        int paragraphEnd;
        java.lang.CharSequence text;
        int i3;
        int i2;
        int i;
        int it;
        int i4;
        int i5;
        super();
        this.layout = layout;
        ArrayList arrayList = new ArrayList();
        i = length;
        int indexOf$default = StringsKt.indexOf$default(this.layout.getText(), '\n', i, false, 4, 0);
        do {
            indexOf$default = StringsKt.indexOf$default(this.layout.getText(), '\n', i, false, 4, 0);
            i = paragraphEnd;
            (List)arrayList.add(Integer.valueOf(i));
            if (i < this.layout.getText().length()) {
            }
            i = paragraphEnd;
        } while (indexOf$default < 0);
        this.paragraphEnds = arrayList;
        int size = this.paragraphEnds.size();
        ArrayList arrayList2 = new ArrayList(size);
        i2 = 0;
        while (i2 < size) {
            int i6 = i2;
            i4 = 0;
            arrayList2.add(0);
            i2++;
        }
        this.paragraphBidi = (List)arrayList2;
        this.bidiProcessedParagraphs = new boolean[this.paragraphEnds.size()];
        this.paragraphCount = this.paragraphEnds.size();
    }

    private final float getDownstreamHorizontal(int offset, boolean primary) {
        float secondaryHorizontal;
        final int coerceAtMost = RangesKt.coerceAtMost(offset, this.layout.getLineEnd(this.layout.getLineForOffset(offset)));
        if (primary) {
            secondaryHorizontal = this.layout.getPrimaryHorizontal(coerceAtMost);
        } else {
            secondaryHorizontal = this.layout.getSecondaryHorizontal(coerceAtMost);
        }
        return secondaryHorizontal;
    }

    public static int getParagraphForOffset$default(androidx.compose.ui.text.android.LayoutHelper layoutHelper, int i2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return layoutHelper.getParagraphForOffset(i2, obj2);
    }

    private final int lineEndToVisibleEnd(int lineEnd, int lineStart) {
        int visibleEnd;
        boolean lineEndSpace;
        int i;
        visibleEnd = lineEnd;
        while (visibleEnd > lineStart) {
            if (!isLineEndSpace(this.layout.getText().charAt(visibleEnd + -1))) {
                break;
            } else {
            }
            visibleEnd--;
        }
        return visibleEnd;
    }

    public final Bidi analyzeBidi(int paragraphIndex) {
        int runCount;
        char[] tmpBuffer;
        int intValue;
        int i2;
        int bidi;
        int length;
        char[] cArr;
        int i4;
        int i5;
        int i3;
        int i;
        if (this.bidiProcessedParagraphs[paragraphIndex]) {
            return (Bidi)this.paragraphBidi.get(paragraphIndex);
        }
        runCount = 0;
        if (paragraphIndex == 0) {
            intValue = runCount;
        } else {
            intValue = (Number)this.paragraphEnds.get(paragraphIndex + -1).intValue();
        }
        int intValue2 = (Number)this.paragraphEnds.get(paragraphIndex).intValue();
        final int i6 = intValue2 - intValue;
        char[] tmpBuffer3 = this.tmpBuffer;
        if (tmpBuffer3 != null) {
            if (tmpBuffer3.length < i6) {
                cArr = new char[i6];
            } else {
                cArr = tmpBuffer3;
            }
        } else {
        }
        TextUtils.getChars(this.layout.getText(), intValue, intValue2, cArr, runCount);
        final int i7 = 0;
        final int i8 = 1;
        if (Bidi.requiresBidi(cArr, runCount, i6)) {
            i = isRtlParagraph(paragraphIndex) ? i8 : runCount;
            bidi = new Bidi(cArr, 0, 0, 0, i6, i);
            if (bidi.getRunCount() == i8) {
                bidi = i7;
            } else {
            }
        } else {
            bidi = i7;
        }
        this.paragraphBidi.set(paragraphIndex, bidi);
        this.bidiProcessedParagraphs[paragraphIndex] = i8;
        if (bidi != 0) {
            tmpBuffer = cArr == this.tmpBuffer ? i7 : this.tmpBuffer;
        } else {
            tmpBuffer = cArr;
        }
        this.tmpBuffer = tmpBuffer;
        return bidi;
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection, boolean upstream) {
        boolean z2;
        int i8;
        int lineEndToVisibleEnd;
        int lineEnd2;
        boolean z;
        int paragraphForOffset;
        int i2;
        int i9;
        float lineRight;
        int length;
        int paragraphStart;
        int i7;
        androidx.compose.ui.text.android.LayoutHelper.BidiRun[] rtl2;
        boolean rtl;
        int i17;
        int bidiStart;
        int lineBidi;
        int i;
        int i3;
        int index$iv;
        int index$iv2;
        int runCount;
        androidx.compose.ui.text.android.LayoutHelper.BidiRun bidiRun;
        int i4;
        int i12;
        int i15;
        int lineEnd3;
        int lineEnd;
        int i10;
        int i16;
        int i5;
        int i13;
        int i14;
        int i11;
        int i6;
        final Object obj = this;
        final int i18 = offset;
        z2 = upstream;
        if (!z2) {
            return getDownstreamHorizontal(offset, usePrimaryDirection);
        }
        int lineForOffset = LayoutCompat_androidKt.getLineForOffset(obj.layout, i18, z2);
        int lineStart = obj.layout.getLineStart(lineForOffset);
        lineEnd2 = obj.layout.getLineEnd(lineForOffset);
        if (i18 != lineStart && i18 != lineEnd2) {
            if (i18 != lineEnd2) {
                return getDownstreamHorizontal(offset, usePrimaryDirection);
            }
        }
        if (i18 != 0) {
            if (i18 == obj.layout.getText().length()) {
                lineEnd = lineEnd2;
                return getDownstreamHorizontal(offset, usePrimaryDirection);
            } else {
                paragraphForOffset = obj.getParagraphForOffset(i18, z2);
                final boolean rtlParagraph = obj.isRtlParagraph(paragraphForOffset);
                final int lineEndToVisibleEnd2 = obj.lineEndToVisibleEnd(lineEnd2, lineStart);
                paragraphStart = obj.getParagraphStart(paragraphForOffset);
                i17 = lineStart - paragraphStart;
                Bidi analyzeBidi = obj.analyzeBidi(paragraphForOffset);
                if (analyzeBidi != null) {
                    lineBidi = analyzeBidi.createLineBidi(i17, lineEndToVisibleEnd2 - paragraphStart);
                } else {
                    lineBidi = 0;
                }
                if (lineBidi != 0) {
                    if (lineBidi.getRunCount() == 1) {
                        lineEnd3 = lineEnd2;
                        i16 = paragraphForOffset;
                        i13 = paragraphStart;
                        i12 = i17;
                        if (!usePrimaryDirection) {
                            if (rtlParagraph == obj.layout.isRtlCharAt(lineStart)) {
                                z = !rtlParagraph ? 1 : 0;
                            } else {
                                z = rtlParagraph;
                            }
                        } else {
                        }
                        i = i18 == lineStart ? z : !z ? 1 : 0;
                        Layout layout6 = obj.layout;
                        if (i != 0) {
                            lineRight = layout6.getLineLeft(lineForOffset);
                        } else {
                            lineRight = layout6.getLineRight(lineForOffset);
                        }
                    } else {
                        int runCount3 = lineBidi.getRunCount();
                        androidx.compose.ui.text.android.LayoutHelper.BidiRun[] arr = new LayoutHelper.BidiRun[runCount3];
                        i3 = 0;
                        while (i3 < runCount3) {
                            int bidiStart2 = 1;
                            if (runLevel2 % 2 == bidiStart2) {
                            } else {
                            }
                            i7 = 0;
                            LayoutHelper.BidiRun bidiRun2 = new LayoutHelper.BidiRun(lineStart + runStart, lineStart + runLimit, i7);
                            arr[i3] = bidiRun2;
                            i3++;
                            z2 = upstream;
                            i17 = i4;
                            lineEnd2 = i15;
                            paragraphForOffset = i10;
                            paragraphStart = i5;
                            i7 = bidiStart2;
                        }
                        int lineEnd5 = lineEnd2;
                        int i27 = paragraphForOffset;
                        int i28 = paragraphStart;
                        int i26 = i17;
                        bidiStart = 1;
                        int runCount2 = lineBidi.getRunCount();
                        byte[] bArr = new byte[runCount2];
                        i2 = 0;
                        while (i2 < runCount2) {
                            bArr[i2] = (byte)runLevel;
                            i2++;
                        }
                        i9 = 0;
                        Bidi.reorderVisually(bArr, i9, arr, i9, arr.length);
                        if (i18 == lineStart) {
                            rtl2 = arr;
                            int i25 = 0;
                            index$iv2 = 0;
                            while (index$iv2 < rtl2.length) {
                                i14 = 0;
                                if (rtl2[index$iv2].getStart() == i18) {
                                } else {
                                }
                                i9 = 0;
                                index$iv2++;
                                i9 = 0;
                                i9 = bidiStart;
                            }
                            i8 = -1;
                            if (!usePrimaryDirection) {
                                if (rtlParagraph == arr[i8].isRtl()) {
                                    i11 = !rtlParagraph ? bidiStart : 0;
                                } else {
                                    i11 = rtlParagraph;
                                }
                            } else {
                            }
                            if (i8 == 0 && i11 != 0) {
                                if (i11 != 0) {
                                    return obj.layout.getLineLeft(lineForOffset);
                                }
                            }
                            if (i8 == ArraysKt.getLastIndex(arr) && i11 == 0) {
                                if (i11 == 0) {
                                    return obj.layout.getLineRight(lineForOffset);
                                }
                            }
                            if (i11 != 0) {
                                return obj.layout.getPrimaryHorizontal(arr[i8 + -1].getStart());
                            }
                            return obj.layout.getPrimaryHorizontal(arr[i8 + 1].getStart());
                        }
                        if (i18 > lineEndToVisibleEnd2) {
                            lineEndToVisibleEnd = obj.lineEndToVisibleEnd(i18, lineStart);
                        } else {
                            lineEndToVisibleEnd = i18;
                        }
                        androidx.compose.ui.text.android.LayoutHelper.BidiRun[] objArr = arr;
                        rtl = 0;
                        index$iv = 0;
                        while (index$iv < objArr.length) {
                            i14 = 0;
                            if (objArr[index$iv].getEnd() == lineEndToVisibleEnd) {
                            } else {
                            }
                            bidiStart = 0;
                            index$iv++;
                            bidiStart = 1;
                            bidiStart = 1;
                        }
                        index$iv = -1;
                        if (!usePrimaryDirection) {
                            if (rtlParagraph == arr[index$iv].isRtl()) {
                                i6 = rtlParagraph;
                            } else {
                                i6 = !rtlParagraph ? 1 : 0;
                            }
                        } else {
                        }
                        if (index$iv == 0 && i6 != 0) {
                            if (i6 != 0) {
                                return obj.layout.getLineLeft(lineForOffset);
                            }
                        }
                        if (index$iv == ArraysKt.getLastIndex(arr) && i6 == 0) {
                            if (i6 == 0) {
                                return obj.layout.getLineRight(lineForOffset);
                            }
                        }
                        if (i6 != 0) {
                            return obj.layout.getPrimaryHorizontal(arr[index$iv + -1].getEnd());
                        }
                    }
                    return obj.layout.getPrimaryHorizontal(arr[index$iv + 1].getEnd());
                }
                lineEnd3 = lineEnd2;
                i16 = paragraphForOffset;
                i13 = paragraphStart;
                i12 = i17;
            }
            return lineRight;
        }
        lineEnd = lineEnd2;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final androidx.compose.ui.text.android.LayoutHelper.BidiRun[] getLineBidiRuns$ui_text_release(int lineIndex) {
        int i3;
        int i;
        int i4;
        int i7;
        Bidi analyzeBidi;
        int i2;
        androidx.compose.ui.text.android.LayoutHelper.BidiRun bidiRun;
        int runLevel;
        int i5;
        int i8;
        int i6;
        final Object obj = this;
        i3 = lineIndex;
        int lineStart = obj.layout.getLineStart(i3);
        int lineEnd = obj.layout.getLineEnd(i3);
        i4 = 0;
        int paragraphForOffset$default = LayoutHelper.getParagraphForOffset$default(obj, lineStart, i4, 2, 0);
        final int paragraphStart = obj.getParagraphStart(paragraphForOffset$default);
        analyzeBidi = obj.analyzeBidi(paragraphForOffset$default);
        final int i15 = 1;
        if (analyzeBidi != null) {
            analyzeBidi = analyzeBidi.createLineBidi(lineStart - paragraphStart, lineEnd - paragraphStart);
            if (analyzeBidi == null) {
                i5 = i4;
                androidx.compose.ui.text.android.LayoutHelper.BidiRun[] arr = new LayoutHelper.BidiRun[i15];
                LayoutHelper.BidiRun bidiRun2 = new LayoutHelper.BidiRun(lineStart, lineEnd, obj.layout.isRtlCharAt(lineStart));
                arr[i5] = bidiRun2;
                return arr;
            } else {
                final int runCount = analyzeBidi.getRunCount();
                final androidx.compose.ui.text.android.LayoutHelper.BidiRun[] arr2 = new LayoutHelper.BidiRun[runCount];
                i2 = i4;
                while (i2 < runCount) {
                    i8 = i4;
                    if (runLevel % 2 == i15) {
                    } else {
                    }
                    i = i8;
                    bidiRun = new LayoutHelper.BidiRun(lineStart + runStart, lineStart + runLimit, i);
                    arr2[i2] = bidiRun;
                    i2++;
                    i3 = lineIndex;
                    i4 = i8;
                    i7 = i6;
                    i = i15;
                }
            }
            return arr2;
        }
        i5 = i4;
    }

    public final int getLineVisibleEnd(int lineIndex) {
        return lineEndToVisibleEnd(this.layout.getLineEnd(lineIndex), this.layout.getLineStart(lineIndex));
    }

    public final int getParagraphCount() {
        return this.paragraphCount;
    }

    public final int getParagraphEnd(int paragraphIndex) {
        return (Number)this.paragraphEnds.get(paragraphIndex).intValue();
    }

    public final int getParagraphForOffset(int offset, boolean upstream) {
        int binarySearch$default;
        int i2;
        int i;
        binarySearch$default = CollectionsKt.binarySearch$default(this.paragraphEnds, (Comparable)Integer.valueOf(offset), 0, 0, 6, 0);
        i2 = 0;
        if (binarySearch$default < 0) {
            i = -i;
        }
        if (upstream != null && i > 0 && offset == (Number)this.paragraphEnds.get(i + -1).intValue()) {
            if (i > 0) {
                if (offset == (Number)this.paragraphEnds.get(i + -1).intValue()) {
                    return i + -1;
                }
            }
        }
        return i;
    }

    public final int getParagraphStart(int paragraphIndex) {
        int intValue;
        int i;
        if (paragraphIndex == 0) {
            intValue = 0;
        } else {
            intValue = (Number)this.paragraphEnds.get(paragraphIndex + -1).intValue();
        }
        return intValue;
    }

    public final boolean isLineEndSpace(char c) {
        int i;
        int compare;
        if (c != 32 && c != 10 && c != 5760) {
            if (c != 10) {
                if (c != 5760) {
                    if (Intrinsics.compare(c, 8192) >= 0 && Intrinsics.compare(c, 8202) <= 0) {
                        if (Intrinsics.compare(c, 8202) <= 0) {
                            if (c == 8199 && c != 8287) {
                                if (c != 8287) {
                                    if (c == 12288) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final boolean isRtlParagraph(int paragraphIndex) {
        int i;
        i = this.layout.getParagraphDirection(this.layout.getLineForOffset(getParagraphStart(paragraphIndex))) == -1 ? 1 : 0;
        return i;
    }
}
