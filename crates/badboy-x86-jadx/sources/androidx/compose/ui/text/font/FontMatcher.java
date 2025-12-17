package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ.\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\u000fJ4\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\u0011JF\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004*\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0080\u0008¢\u0006\u0002\u0008\u0017\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0018", d2 = {"Landroidx/compose/ui/text/font/FontMatcher;", "", "()V", "matchFont", "", "Landroidx/compose/ui/text/font/Font;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "matchFont-RetOiIg", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "Landroidx/compose/ui/text/font/FontListFontFamily;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "fontList", "(Ljava/util/List;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "filterByClosestWeight", "preferBelow", "", "minSearchRange", "maxSearchRange", "filterByClosestWeight$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontMatcher {

    public static final int $stable;
    static {
    }

    public static List filterByClosestWeight$ui_text_release$default(androidx.compose.ui.text.font.FontMatcher $this, List $receiver, androidx.compose.ui.text.font.FontWeight fontWeight, boolean preferBelow, androidx.compose.ui.text.font.FontWeight minSearchRange, androidx.compose.ui.text.font.FontWeight maxSearchRange, int i7, Object object8) {
        androidx.compose.ui.text.font.FontWeight fontWeight2;
        boolean equal;
        int minSearchRange3;
        Object minSearchRange2;
        int maxSearchRange2;
        int bestWeightAbove;
        int bestWeightBelow;
        int index;
        int i2;
        Object obj5;
        Object obj3;
        androidx.compose.ui.text.font.FontWeight weight;
        int compareTo;
        int index$iv$iv;
        Object obj;
        int i3;
        Object obj2;
        int i;
        Object obj23;
        int obj26;
        fontWeight2 = fontWeight;
        minSearchRange3 = i7 & 4 != 0 ? 0 : minSearchRange;
        maxSearchRange2 = i7 & 8 != 0 ? 0 : maxSearchRange;
        final int i6 = 0;
        bestWeightAbove = 0;
        bestWeightBelow = 0;
        index = 0;
        while (index < $receiver.size()) {
            weight = (Font)$receiver.get(index).getWeight();
            if (bestWeightAbove != 0) {
            } else {
            }
            bestWeightAbove = weight;
            index++;
            if (weight.compareTo(bestWeightAbove) < 0) {
            }
            if (bestWeightBelow != 0) {
            } else {
            }
            bestWeightBelow = weight;
            if (weight.compareTo(bestWeightBelow) > 0) {
            }
        }
        obj5 = $receiver;
        if (preferBelow) {
            if (bestWeightBelow == 0) {
                i2 = bestWeightAbove;
            } else {
                i2 = bestWeightBelow;
            }
        } else {
            if (bestWeightAbove == 0) {
            } else {
            }
        }
        Object obj4 = $receiver;
        int i8 = 0;
        ArrayList arrayList = new ArrayList(obj4.size());
        int obj6 = obj4;
        final int i9 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < obj6.size()) {
            obj23 = obj;
            i3 = 0;
            i = 0;
            if (Intrinsics.areEqual((Font)obj23.getWeight(), i2)) {
            } else {
            }
            obj26 = minSearchRange3;
            minSearchRange2 = obj23;
            index$iv$iv++;
            fontWeight2 = fontWeight;
            minSearchRange3 = obj26;
            obj26 = minSearchRange3;
            (Collection)arrayList.add(obj23);
        }
        return (List)arrayList;
    }

    public final List<androidx.compose.ui.text.font.Font> filterByClosestWeight$ui_text_release(List<? extends androidx.compose.ui.text.font.Font> $this$filterByClosestWeight, androidx.compose.ui.text.font.FontWeight fontWeight, boolean preferBelow, androidx.compose.ui.text.font.FontWeight minSearchRange, androidx.compose.ui.text.font.FontWeight maxSearchRange) {
        androidx.compose.ui.text.font.FontWeight fontWeight4;
        boolean equal;
        androidx.compose.ui.text.font.FontWeight fontWeight2;
        Object it$iv;
        int bestWeightAbove;
        int bestWeightBelow;
        int index;
        androidx.compose.ui.text.font.FontWeight fontWeight3;
        Object obj6;
        Object obj2;
        androidx.compose.ui.text.font.FontWeight weight;
        int compareTo;
        int index$iv$iv;
        Object obj3;
        Object obj4;
        int i2;
        Object obj;
        int i;
        fontWeight4 = fontWeight;
        fontWeight2 = minSearchRange;
        final androidx.compose.ui.text.font.FontWeight fontWeight5 = maxSearchRange;
        final int i3 = 0;
        bestWeightAbove = 0;
        bestWeightBelow = 0;
        index = 0;
        while (index < $this$filterByClosestWeight.size()) {
            weight = (Font)$this$filterByClosestWeight.get(index).getWeight();
            if (bestWeightAbove != 0) {
            } else {
            }
            bestWeightAbove = weight;
            index++;
            if (weight.compareTo(bestWeightAbove) < 0) {
            }
            if (bestWeightBelow != 0) {
            } else {
            }
            bestWeightBelow = weight;
            if (weight.compareTo(bestWeightBelow) > 0) {
            }
        }
        obj6 = $this$filterByClosestWeight;
        if (preferBelow) {
            if (bestWeightBelow == null) {
                fontWeight3 = bestWeightAbove;
            } else {
                fontWeight3 = bestWeightBelow;
            }
        } else {
            if (bestWeightAbove == null) {
            } else {
            }
        }
        Object obj5 = $this$filterByClosestWeight;
        int i4 = 0;
        ArrayList arrayList = new ArrayList(obj5.size());
        int obj7 = obj5;
        final int i5 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < obj7.size()) {
            obj4 = obj3;
            i2 = 0;
            i = 0;
            if (Intrinsics.areEqual((Font)obj4.getWeight(), fontWeight3)) {
            } else {
            }
            it$iv = obj4;
            index$iv$iv++;
            fontWeight4 = fontWeight;
            fontWeight2 = minSearchRange;
            (Collection)arrayList.add(obj4);
        }
        return (List)arrayList;
    }

    public final List<androidx.compose.ui.text.font.Font> matchFont-RetOiIg(androidx.compose.ui.text.font.FontFamily fontFamily, androidx.compose.ui.text.font.FontWeight fontWeight, int fontStyle) {
        if (!fontFamily instanceof FontListFontFamily) {
        } else {
            return matchFont-RetOiIg((FontListFontFamily)fontFamily, fontWeight, fontStyle);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Only FontFamily instances that presents a list of Fonts can be used");
        throw illegalArgumentException;
    }

    public final List<androidx.compose.ui.text.font.Font> matchFont-RetOiIg(androidx.compose.ui.text.font.FontListFontFamily fontFamily, androidx.compose.ui.text.font.FontWeight fontWeight, int fontStyle) {
        return matchFont-RetOiIg(fontFamily.getFonts(), fontWeight, fontStyle);
    }

    public final List<androidx.compose.ui.text.font.Font> matchFont-RetOiIg(List<? extends androidx.compose.ui.text.font.Font> fontList, androidx.compose.ui.text.font.FontWeight fontWeight, int fontStyle) {
        Object size;
        boolean equal4;
        ArrayList list;
        androidx.compose.ui.text.font.FontWeight fontWeight2;
        int i10;
        int i4;
        boolean equal;
        int i8;
        boolean equal2;
        int size3;
        boolean equal3;
        ArrayList $this$fastFilter$iv;
        int i5;
        int this_$iv;
        Object fontsToSearch3;
        int i;
        Object preferBelow$iv2;
        int size2;
        int i2;
        ArrayList bestWeightAbove$iv;
        int index$iv$iv2;
        int index$iv$iv;
        int bestWeightAbove$iv2;
        int bestWeightBelow$iv2;
        int index$iv2;
        int i11;
        int index$iv$iv$iv3;
        int index$iv;
        int index$iv3;
        Object obj;
        int bestWeightBelow$iv;
        Object weight2;
        int arrayList2;
        int index$iv4;
        int compareTo;
        ArrayList arrayList;
        Object it;
        int compareTo2;
        int weight;
        ArrayList index$iv$iv$iv;
        boolean style-_-LCdwA;
        ArrayList index$iv$iv$iv2;
        int i7;
        int i13;
        int i6;
        ArrayList fontsToSearch2;
        ArrayList fontsToSearch;
        int i3;
        int preferBelow$iv;
        int i9;
        int this_$iv2;
        int i12;
        androidx.compose.ui.text.font.FontWeight maxSearchRange$iv;
        size = fontWeight;
        int i14 = fontStyle;
        ArrayList list2 = fontList;
        int i16 = 0;
        ArrayList arrayList3 = new ArrayList(list2.size());
        ArrayList list5 = list2;
        int i20 = 0;
        index$iv$iv2 = 0;
        i11 = 0;
        while (index$iv$iv2 < list5.size()) {
            weight2 = obj;
            compareTo = 0;
            it = weight2;
            weight = 0;
            if (Intrinsics.areEqual((Font)it.getWeight(), size) && FontStyle.equals-impl0(it.getStyle-_-LCdwA(), i14)) {
            }
            if (i11 != 0) {
            }
            index$iv$iv2++;
            i11 = 0;
            (Collection)arrayList3.add(weight2);
            if (FontStyle.equals-impl0(it.getStyle-_-LCdwA(), i14)) {
            }
            i11 = 1;
        }
        ArrayList $this$fastFilter$iv2 = arrayList3;
        int i17 = 0;
        if (!(Collection)(List)$this$fastFilter$iv2.isEmpty()) {
            return $this$fastFilter$iv2;
        }
        ArrayList list3 = fontList;
        int i18 = 0;
        ArrayList arrayList4 = new ArrayList(list3.size());
        ArrayList list6 = list3;
        int i21 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list6.size()) {
            weight2 = obj;
            compareTo = 0;
            weight = 0;
            if (FontStyle.equals-impl0((Font)weight2.getStyle-_-LCdwA(), i14)) {
            }
            index$iv$iv++;
            (Collection)arrayList4.add(weight2);
        }
        if ((Collection)(List)arrayList4.isEmpty()) {
            int i15 = 0;
            $this$fastFilter$iv = fontList;
        }
        if (size.compareTo(FontWeight.Companion.getW400()) < 0) {
            i = 1;
            size2 = 0;
            i2 = 0;
            bestWeightAbove$iv = 0;
            bestWeightAbove$iv2 = 0;
            bestWeightBelow$iv2 = 0;
            index$iv3 = 0;
            while (index$iv3 < (List)$this$fastFilter$iv.size()) {
                compareTo = (Font)$this$fastFilter$iv.get(index$iv3).getWeight();
                if (compareTo.compareTo(size) >= 0) {
                    break;
                } else {
                }
                if (compareTo.compareTo(size) <= 0) {
                    break;
                } else {
                }
                if (bestWeightAbove$iv2 != 0) {
                } else {
                }
                bestWeightAbove$iv2 = compareTo;
                index$iv3++;
                if (compareTo.compareTo(bestWeightAbove$iv2) < 0) {
                }
                if (bestWeightBelow$iv2 != 0) {
                } else {
                }
                bestWeightBelow$iv2 = compareTo;
                if (compareTo.compareTo(bestWeightBelow$iv2) > 0) {
                }
            }
            index$iv$iv$iv3 = bestWeightBelow$iv2 == 0 ? bestWeightAbove$iv2 : bestWeightBelow$iv2;
            bestWeightBelow$iv = $this$fastFilter$iv;
            arrayList2 = 0;
            arrayList = new ArrayList(bestWeightBelow$iv.size());
            compareTo2 = bestWeightBelow$iv;
            index$iv$iv$iv = 0;
            index$iv$iv$iv2 = 0;
            size3 = compareTo2.size();
            while (index$iv$iv$iv2 < size3) {
                i13 = i7;
                i6 = 0;
                i3 = 0;
                if (Intrinsics.areEqual((Font)i13.getWeight(), index$iv$iv$iv3)) {
                } else {
                }
                fontsToSearch = i;
                preferBelow$iv2 = i13;
                index$iv$iv$iv2++;
                i = fontsToSearch;
                size3 = preferBelow$iv;
                fontsToSearch = i;
                (Collection)arrayList.add(i13);
            }
            int preferBelow$iv3 = i;
            list = arrayList;
            fontsToSearch2 = $this$fastFilter$iv;
        } else {
            if (size.compareTo(FontWeight.Companion.getW500()) > 0) {
                i8 = 0;
                i = 0;
                size2 = 0;
                i2 = 0;
                bestWeightAbove$iv = 0;
                bestWeightAbove$iv2 = 0;
                index$iv2 = 0;
                while (index$iv2 < $this$fastFilter$iv.size()) {
                    weight2 = (Font)$this$fastFilter$iv.get(index$iv2).getWeight();
                    if (weight2.compareTo(size) >= 0) {
                        break;
                    } else {
                    }
                    if (weight2.compareTo(size) <= 0) {
                        break;
                    } else {
                    }
                    if (bestWeightAbove$iv != 0) {
                    } else {
                    }
                    bestWeightAbove$iv = weight2;
                    index$iv2++;
                    if (weight2.compareTo(bestWeightAbove$iv) < 0) {
                    }
                    if (bestWeightAbove$iv2 != 0) {
                    } else {
                    }
                    bestWeightAbove$iv2 = weight2;
                    if (weight2.compareTo(bestWeightAbove$iv2) > 0) {
                    }
                }
                bestWeightBelow$iv2 = bestWeightAbove$iv == 0 ? bestWeightAbove$iv2 : bestWeightAbove$iv;
                index$iv$iv$iv3 = $this$fastFilter$iv;
                bestWeightBelow$iv = 0;
                arrayList2 = new ArrayList(index$iv$iv$iv3.size());
                arrayList = index$iv$iv$iv3;
                compareTo2 = 0;
                index$iv$iv$iv = 0;
                while (index$iv$iv$iv < arrayList.size()) {
                    i13 = i7;
                    i6 = 0;
                    i3 = 0;
                    if (Intrinsics.areEqual((Font)i13.getWeight(), bestWeightBelow$iv2)) {
                    } else {
                    }
                    fontsToSearch = $this$fastFilter$iv;
                    fontsToSearch3 = i13;
                    index$iv$iv$iv++;
                    $this$fastFilter$iv = fontsToSearch;
                    i8 = preferBelow$iv;
                    fontsToSearch = $this$fastFilter$iv;
                    (Collection)arrayList2.add(i13);
                }
                preferBelow$iv = i8;
                fontsToSearch2 = $this$fastFilter$iv;
                list = arrayList2;
            } else {
                fontsToSearch2 = $this$fastFilter$iv;
                fontWeight2 = FontWeight.Companion.getW500();
                i5 = this;
                i = i11;
                int i19 = 0;
                i2 = i19;
                bestWeightAbove$iv = fontsToSearch2;
                bestWeightAbove$iv2 = 0;
                bestWeightBelow$iv2 = 0;
                bestWeightBelow$iv = 0;
                index$iv4 = 0;
                while (index$iv4 < bestWeightAbove$iv.size()) {
                    weight = (Font)bestWeightAbove$iv.get(index$iv4).getWeight();
                    if (weight.compareTo(size) >= 0) {
                        break;
                    } else {
                    }
                    if (weight.compareTo(size) <= 0) {
                        break;
                    } else {
                    }
                    if (bestWeightBelow$iv2 != 0) {
                    } else {
                    }
                    bestWeightBelow$iv2 = weight;
                    index$iv4++;
                    if (weight.compareTo(bestWeightBelow$iv2) < 0) {
                    }
                    if (bestWeightBelow$iv != 0) {
                    } else {
                    }
                    bestWeightBelow$iv = weight;
                    if (weight.compareTo(bestWeightBelow$iv) > 0) {
                    }
                }
                arrayList2 = bestWeightBelow$iv2 == 0 ? bestWeightBelow$iv : bestWeightBelow$iv2;
                arrayList = bestWeightAbove$iv;
                compareTo2 = 0;
                index$iv$iv$iv = new ArrayList(arrayList.size());
                index$iv$iv$iv2 = arrayList;
                i7 = 0;
                i3 = i11;
                index$iv$iv$iv3 = i13;
                while (index$iv$iv$iv3 < index$iv$iv$iv2.size()) {
                    preferBelow$iv = i13;
                    i9 = 0;
                    i12 = 0;
                    if (Intrinsics.areEqual((Font)preferBelow$iv.getWeight(), arrayList2)) {
                    } else {
                    }
                    this_$iv2 = i5;
                    this_$iv = preferBelow$iv;
                    index$iv$iv$iv3++;
                    i5 = this_$iv2;
                    fontWeight2 = maxSearchRange$iv;
                    this_$iv2 = i5;
                    (Collection)index$iv$iv$iv.add(preferBelow$iv);
                }
                maxSearchRange$iv = fontWeight2;
                this_$iv2 = i5;
                if ((Collection)(List)index$iv$iv$iv.isEmpty()) {
                    i10 = 0;
                    $this$fastFilter$iv = FontWeight.Companion.getW500();
                    i = i6;
                    size2 = this;
                    i2 = fontsToSearch2;
                    bestWeightAbove$iv = 0;
                    bestWeightAbove$iv2 = 0;
                    bestWeightBelow$iv2 = 0;
                    index$iv = 0;
                    while (index$iv < i2.size()) {
                        arrayList = (Font)i2.get(index$iv).getWeight();
                        if (arrayList.compareTo(size) >= 0) {
                            break;
                        } else {
                        }
                        if (arrayList.compareTo(size) <= 0) {
                            break;
                        } else {
                        }
                        if (bestWeightAbove$iv2 != 0) {
                        } else {
                        }
                        bestWeightAbove$iv2 = arrayList;
                        index$iv++;
                        if (arrayList.compareTo(bestWeightAbove$iv2) < 0) {
                        }
                        if (bestWeightBelow$iv2 != 0) {
                        } else {
                        }
                        bestWeightBelow$iv2 = arrayList;
                        if (arrayList.compareTo(bestWeightBelow$iv2) > 0) {
                        }
                    }
                    index$iv$iv$iv3 = bestWeightAbove$iv2 == 0 ? bestWeightBelow$iv2 : bestWeightAbove$iv2;
                    bestWeightBelow$iv = i2;
                    arrayList2 = 0;
                    arrayList = new ArrayList(bestWeightBelow$iv.size());
                    compareTo2 = bestWeightBelow$iv;
                    index$iv$iv$iv = 0;
                    index$iv$iv$iv2 = 0;
                    size = compareTo2.size();
                    while (index$iv$iv$iv2 < size) {
                        i13 = i7;
                        i6 = 0;
                        i9 = 0;
                        if (Intrinsics.areEqual((Font)i13.getWeight(), index$iv$iv$iv3)) {
                        } else {
                        }
                        preferBelow$iv = i10;
                        i4 = i13;
                        index$iv$iv$iv2++;
                        i10 = preferBelow$iv;
                        size = this_$iv2;
                        preferBelow$iv = i10;
                        (Collection)arrayList.add(i13);
                    }
                    preferBelow$iv = i10;
                    list = arrayList;
                }
            }
        }
        return list;
    }
}
