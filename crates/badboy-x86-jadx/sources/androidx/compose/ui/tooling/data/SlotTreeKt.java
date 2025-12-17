package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u001a\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0002\u001a(\u0010$\u001a\u0008\u0012\u0004\u0012\u00020&0%2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0%2\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0003\u001a\u0014\u0010+\u001a\u0004\u0018\u00010\u00062\u0008\u0010,\u001a\u0004\u0018\u00010(H\u0003\u001a\u0016\u0010-\u001a\u0008\u0012\u0004\u0012\u00020.0%2\u0006\u0010/\u001a\u00020\u0006H\u0002\u001a\u001e\u00100\u001a\u0004\u0018\u00010*2\u0006\u00101\u001a\u00020\u00062\n\u0008\u0002\u00102\u001a\u0004\u0018\u00010*H\u0003\u001a\u001a\u00103\u001a\u0004\u0018\u000104*\u0006\u0012\u0002\u0008\u0003052\u0006\u00106\u001a\u00020\u0006H\u0002\u001a\u000c\u00107\u001a\u00020\u0019*\u000208H\u0007\u001a\u000c\u00109\u001a\u00020\u0006*\u00020\u0015H\u0002\u001a\u001e\u0010:\u001a\u0008\u0012\u0004\u0012\u00020&0%*\u00020;2\n\u0008\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0007\u001a\u0016\u0010>\u001a\u00020\u0019*\u00020;2\u0008\u0010?\u001a\u0004\u0018\u00010*H\u0003\u001a\u000c\u0010@\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\u0014\u0010A\u001a\u00020\u0014*\u00020\u00152\u0006\u0010B\u001a\u00020\u0006H\u0002\u001a\u000c\u0010C\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\u000c\u0010D\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\u000c\u0010E\u001a\u00020\u0014*\u00020\u0015H\u0002\u001aK\u0010F\u001a\u0004\u0018\u0001HG\"\u0004\u0008\u0000\u0010G*\u0002082&\u0010H\u001a\"\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020J\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002HG0%\u0012\u0006\u0012\u0004\u0018\u0001HG0I2\u0008\u0008\u0002\u0010<\u001a\u00020=H\u0007¢\u0006\u0002\u0010K\u001a\u000c\u0010L\u001a\u00020\u0001*\u00020\u0015H\u0002\u001a\u000c\u0010M\u001a\u00020\u0001*\u00020\u0006H\u0002\u001a\u0014\u0010M\u001a\u00020\u0001*\u00020\u00062\u0006\u0010N\u001a\u00020\u0001H\u0002\u001a\u001c\u0010O\u001a\u00020\u0006*\u00020\u00062\u0006\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0006H\u0002\u001a\u0014\u0010R\u001a\u00020\t*\u00020\t2\u0006\u0010S\u001a\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0008\u001a\u00020\tX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u000e\u0010\u000c\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0016\"\u0018\u0010\u0017\u001a\u00020\u0014*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0016\" \u0010\u0018\u001a\u0004\u0018\u00010\u0006*\u00020\u00198GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001a\u0010\u001b\u001a\u0004\u0008\u001c\u0010\u001d\"\u0018\u0010\u001e\u001a\u00020\u0006*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 ¨\u0006T", d2 = {"BITS_PER_SLOT", "", "SLOT_MASK", "STABLE_BITS", "STATIC_BITS", "changedFieldName", "", "defaultFieldName", "emptyBox", "Landroidx/compose/ui/unit/IntRect;", "getEmptyBox", "()Landroidx/compose/ui/unit/IntRect;", "internalFieldPrefix", "jacocoDataField", "parameterPrefix", "parametersInformationTokenizer", "Lkotlin/text/Regex;", "recomposeScopeNameSuffix", "tokenizer", "isANumber", "", "Lkotlin/text/MatchResult;", "(Lkotlin/text/MatchResult;)Z", "isClassName", "position", "Landroidx/compose/ui/tooling/data/Group;", "getPosition$annotations", "(Landroidx/compose/ui/tooling/data/Group;)V", "getPosition", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "text", "getText", "(Lkotlin/text/MatchResult;)Ljava/lang/String;", "boundsOfLayoutNode", "node", "Landroidx/compose/ui/layout/LayoutInfo;", "extractParameterInfo", "", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "data", "", "context", "Landroidx/compose/ui/tooling/data/SourceInformationContext;", "keyPosition", "key", "parseParameters", "Landroidx/compose/ui/tooling/data/Parameter;", "parameters", "sourceInformationContextOf", "information", "parent", "accessibleField", "Ljava/lang/reflect/Field;", "Ljava/lang/Class;", "name", "asTree", "Landroidx/compose/runtime/tooling/CompositionData;", "callName", "findParameters", "Landroidx/compose/runtime/tooling/CompositionGroup;", "cache", "Landroidx/compose/ui/tooling/data/ContextCache;", "getGroup", "parentContext", "isCallWithName", "isChar", "c", "isFileName", "isNumber", "isParameterInformation", "mapTree", "T", "factory", "Lkotlin/Function3;", "Landroidx/compose/ui/tooling/data/SourceContext;", "(Landroidx/compose/runtime/tooling/CompositionData;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/tooling/data/ContextCache;)Ljava/lang/Object;", "number", "parseToInt", "radix", "replacePrefix", "prefix", "replacement", "union", "other", "ui-tooling-data_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SlotTreeKt {

    private static final int BITS_PER_SLOT = 3;
    private static final int SLOT_MASK = 7;
    private static final int STABLE_BITS = 4;
    private static final int STATIC_BITS = 3;
    private static final String changedFieldName = "$$changed";
    private static final String defaultFieldName = "$$default";
    private static final IntRect emptyBox = null;
    private static final String internalFieldPrefix = "$$";
    private static final String jacocoDataField = "$jacoco";
    private static final String parameterPrefix = "$";
    private static final Regex parametersInformationTokenizer = null;
    private static final String recomposeScopeNameSuffix = ".RecomposeScopeImpl";
    private static final Regex tokenizer;
    static {
        int i = 0;
        IntRect intRect = new IntRect(i, i, i, i);
        SlotTreeKt.emptyBox = intRect;
        Regex regex = new Regex("(\\d+)|([,])|([*])|([:])|L|(P\\([^)]*\\))|(C(\\(([^)]*)\\))?)|@");
        SlotTreeKt.tokenizer = regex;
        Regex regex2 = new Regex("(\\d+)|,|[!P()]|:([^,!)]+)");
        SlotTreeKt.parametersInformationTokenizer = regex2;
    }

    public static final IntRect access$boundsOfLayoutNode(LayoutInfo node) {
        return SlotTreeKt.boundsOfLayoutNode(node);
    }

    public static final List access$extractParameterInfo(List data, androidx.compose.ui.tooling.data.SourceInformationContext context) {
        return SlotTreeKt.extractParameterInfo(data, context);
    }

    private static final Field accessibleField(Class<?> $this$accessibleField, String name) {
        Field[] declaredFields;
        int i3;
        int length;
        int i;
        int i2;
        Field field;
        boolean it;
        int i4;
        String name2;
        declaredFields = $this$accessibleField.getDeclaredFields();
        i3 = 0;
        i = 0;
        while (i < declaredFields.length) {
            i4 = 0;
            i++;
        }
        field = i2;
        if (field != null) {
            i3 = 0;
            field.setAccessible(true);
            i2 = field;
        }
        return i2;
    }

    public static final androidx.compose.ui.tooling.data.Group asTree(CompositionData $this$asTree) {
        androidx.compose.ui.tooling.data.Group firstOrNull;
        int i;
        firstOrNull = CollectionsKt.firstOrNull($this$asTree.getCompositionGroups());
        if ((CompositionGroup)firstOrNull != null) {
            if (SlotTreeKt.getGroup((CompositionGroup)firstOrNull, 0) == null) {
                firstOrNull = EmptyGroup.INSTANCE;
            }
        } else {
        }
        return firstOrNull;
    }

    private static final IntRect boundsOfLayoutNode(LayoutInfo node) {
        boolean attached;
        final LayoutCoordinates coordinates = node.getCoordinates();
        if (node.isAttached() && !coordinates.isAttached()) {
            if (!coordinates.isAttached()) {
            }
            long positionInWindow = LayoutCoordinatesKt.positionInWindow(coordinates);
            long size-YbymL2g = coordinates.getSize-YbymL2g();
            int roundToInt = MathKt.roundToInt(Offset.getX-impl(positionInWindow));
            int roundToInt2 = MathKt.roundToInt(Offset.getY-impl(positionInWindow));
            IntRect intRect = new IntRect(roundToInt, roundToInt2, width-impl += roundToInt, height-impl += roundToInt2);
            return intRect;
        }
        final int i = 0;
        IntRect position = new IntRect(i, i, node.getWidth(), node.getHeight());
        return position;
    }

    private static final String callName(MatchResult $this$callName) {
        return (String)$this$callName.getGroupValues().get(8);
    }

    private static final List<androidx.compose.ui.tooling.data.ParameterInformation> extractParameterInfo(List<? extends Object> data, androidx.compose.ui.tooling.data.SourceInformationContext context) {
        boolean accessibleField;
        int i4;
        Field element$iv$iv;
        Object str4;
        int i6;
        Iterator iterator;
        Class class;
        List emptyList;
        Object element$iv;
        int recomposeScope2;
        Object sortedIndex;
        int i13;
        int i8;
        int i;
        boolean startsWith$default;
        int i5;
        int i14;
        String str2;
        int it;
        int i9;
        boolean endsWith$default;
        int intValue2;
        String str3;
        int intValue;
        Object obj2;
        Field[] declaredFields;
        int parameter;
        ArrayList arrayList;
        int i11;
        Field[] substring;
        int i2;
        Field field;
        Object block;
        int i15;
        Class cls;
        Field blockField;
        Object recomposeScope;
        androidx.compose.ui.tooling.data.ParameterInformation parameterInformation;
        String str;
        Object obj;
        int i10;
        int i3;
        int i7;
        String inlineClass;
        int i12;
        if (!(Collection)data.isEmpty()) {
            str4 = 0;
            iterator = (Iterable)data.iterator();
            i = 0;
            i14 = 0;
            while (iterator.hasNext()) {
                Object obj3 = element$iv;
                i9 = 0;
                if (obj3 != null && StringsKt.endsWith$default(obj3.getClass().getName(), ".RecomposeScopeImpl", i14, 2, i)) {
                } else {
                }
                it = i14;
                i = 0;
                i14 = 0;
                if (StringsKt.endsWith$default(obj3.getClass().getName(), ".RecomposeScopeImpl", i14, 2, i)) {
                } else {
                }
                it = 1;
            }
            element$iv = i;
            if (element$iv != null) {
                accessibleField = SlotTreeKt.accessibleField(element$iv.getClass(), "block");
                if (accessibleField != null) {
                    str4 = accessibleField.get(element$iv);
                    if (str4 != null) {
                        class = str4.getClass();
                        Field accessibleField2 = SlotTreeKt.accessibleField(class, "$$default");
                        Field accessibleField3 = SlotTreeKt.accessibleField(class, "$$changed");
                        String str8 = "null cannot be cast to non-null type kotlin.Int";
                        if (accessibleField2 != null) {
                            Object obj4 = accessibleField2.get(str4);
                            Intrinsics.checkNotNull(obj4, str8);
                            intValue = (Integer)obj4.intValue();
                        } else {
                            intValue = i14;
                        }
                        if (accessibleField3 != null) {
                            obj2 = accessibleField3.get(str4);
                            Intrinsics.checkNotNull(obj2, str8);
                            intValue2 = (Integer)obj2.intValue();
                        } else {
                            intValue2 = i14;
                        }
                        parameter = 0;
                        arrayList = new ArrayList();
                        substring = declaredFields;
                        final int i22 = 0;
                        i8 = i14;
                        while (i8 < substring.length) {
                            field = substring[i8];
                            block = field;
                            i15 = 0;
                            int blockField3 = 2;
                            int blockClass = 0;
                            int recomposeScope3 = 0;
                            if (StringsKt.startsWith$default(field.getName(), "$", recomposeScope3, blockField3, blockClass) && !StringsKt.startsWith$default(field.getName(), "$$", recomposeScope3, blockField3, blockClass) && !StringsKt.startsWith$default(field.getName(), "$jacoco", recomposeScope3, blockField3, blockClass)) {
                            } else {
                            }
                            i4 = recomposeScope3;
                            if (i4 != 0) {
                            } else {
                            }
                            element$iv$iv = block;
                            i8++;
                            i14 = recomposeScope3;
                            class = cls;
                            accessibleField = blockField;
                            element$iv = recomposeScope;
                            i = 0;
                            (Collection)arrayList.add(block);
                            if (!StringsKt.startsWith$default(field.getName(), "$$", recomposeScope3, blockField3, blockClass)) {
                            } else {
                            }
                            if (!StringsKt.startsWith$default(field.getName(), "$jacoco", recomposeScope3, blockField3, blockClass)) {
                            } else {
                            }
                            i4 = 1;
                        }
                        Field blockField4 = accessibleField;
                        Class cls2 = class;
                        Object obj6 = element$iv;
                        emptyList = 0;
                        SlotTreeKt.extractParameterInfo$$inlined.sortedBy.1 anon = new SlotTreeKt.extractParameterInfo$$inlined.sortedBy.1();
                        List sortedWith = CollectionsKt.sortedWith((Iterable)(List)arrayList, (Comparator)anon);
                        ArrayList arrayList2 = new ArrayList();
                        if (context != null) {
                            if (context.getParameters() == null) {
                                emptyList = CollectionsKt.emptyList();
                            }
                        } else {
                        }
                        i5 = recomposeScope2;
                        while (i5 < sortedWith.size()) {
                            i14 = i5;
                            declaredFields = null;
                            if (i14 < emptyList.size()) {
                            } else {
                            }
                            substring = 0;
                            parameter = new Parameter(i14, substring, 2, substring);
                            if (parameter.getSortedIndex() < sortedWith.size()) {
                            } else {
                            }
                            block = str4;
                            i5++;
                            str4 = block;
                            recomposeScope2 = 0;
                            sortedIndex = sortedWith.get(parameter.getSortedIndex());
                            int i17 = 1;
                            (Field)sortedIndex.setAccessible(i17);
                            if (i23 & intValue != 0) {
                            } else {
                            }
                            i10 = 0;
                            i2 = 1;
                            i19++;
                            i26 >>= arrayList;
                            block = str4;
                            if (field & 3 == 3) {
                            } else {
                            }
                            i3 = 0;
                            if (field & 3 == 0) {
                            } else {
                            }
                            i6 = 0;
                            if (field & 4 == 0) {
                            } else {
                            }
                            i12 = 0;
                            substring = sortedIndex.getName().substring(1);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                            if (i6 != 0 && i10 == 0) {
                            } else {
                            }
                            i7 = 0;
                            parameterInformation = new ParameterInformation(substring, sortedIndex.get(str4), i10, i3, i7, parameter.getInlineClass(), i12);
                            (List)arrayList2.add(parameterInformation);
                            if (i10 == 0) {
                            } else {
                            }
                            i7 = 1;
                            i12 = 1;
                            i6 = 1;
                            i3 = 1;
                            i10 = 1;
                            parameter = emptyList.get(i14);
                            i11 = 2;
                            substring = 0;
                        }
                        return arrayList2;
                    }
                    blockField = accessibleField;
                    block = str4;
                    recomposeScope = element$iv;
                } else {
                    blockField = accessibleField;
                    recomposeScope = element$iv;
                }
            } else {
                recomposeScope = element$iv;
            }
        }
        return CollectionsKt.emptyList();
    }

    public static final List<androidx.compose.ui.tooling.data.ParameterInformation> findParameters(CompositionGroup $this$findParameters, androidx.compose.ui.tooling.data.ContextCache cache) {
        int sourceInformationContextOf$default2;
        androidx.compose.ui.tooling.data.SourceInformationContext sourceInformationContextOf$default;
        boolean $this$getOrPut$iv;
        int i;
        Object obj;
        int i2;
        String sourceInfo = $this$findParameters.getSourceInfo();
        if (sourceInfo == null) {
            return CollectionsKt.emptyList();
        }
        sourceInformationContextOf$default2 = 2;
        sourceInformationContextOf$default = 0;
        if (cache == null) {
            sourceInformationContextOf$default = SlotTreeKt.sourceInformationContextOf$default(sourceInfo, sourceInformationContextOf$default, sourceInformationContextOf$default2, sourceInformationContextOf$default);
        } else {
            Map contexts$ui_tooling_data_release = cache.getContexts$ui_tooling_data_release();
            i = 0;
            obj = contexts$ui_tooling_data_release.get(sourceInfo);
            if (obj == null) {
                i2 = 0;
                contexts$ui_tooling_data_release.put(sourceInfo, SlotTreeKt.sourceInformationContextOf$default(sourceInfo, sourceInformationContextOf$default, sourceInformationContextOf$default2, sourceInformationContextOf$default));
            } else {
                sourceInformationContextOf$default2 = obj;
            }
            if (sourceInformationContextOf$default2 instanceof SourceInformationContext != null) {
                sourceInformationContextOf$default = sourceInformationContextOf$default2;
            }
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll((Collection)(List)arrayList, $this$findParameters.getData());
        return SlotTreeKt.extractParameterInfo(arrayList, sourceInformationContextOf$default);
    }

    public static List findParameters$default(CompositionGroup compositionGroup, androidx.compose.ui.tooling.data.ContextCache contextCache2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return SlotTreeKt.findParameters(compositionGroup, obj1);
    }

    public static final IntRect getEmptyBox() {
        return SlotTreeKt.emptyBox;
    }

    private static final androidx.compose.ui.tooling.data.Group getGroup(CompositionGroup $this$getGroup, androidx.compose.ui.tooling.data.SourceInformationContext parentContext) {
        androidx.compose.ui.tooling.data.SourceInformationContext inline;
        int it;
        androidx.compose.ui.tooling.data.Group callGroup;
        Object node;
        int node2;
        int i4;
        List modifierInfo;
        Object $i$f$reduce;
        Iterable data;
        boolean iterator;
        int i3;
        int i;
        androidx.compose.ui.tooling.data.Group group;
        List list;
        int name;
        ArrayList arrayList;
        Object parameterInfo;
        Object accumulator$iv;
        int i2;
        int location;
        boolean next;
        int length;
        int i7;
        int box;
        Iterator location2;
        boolean next2;
        Object node3;
        IntRect g;
        List list2;
        int i6;
        int i5;
        inline = parentContext;
        final Object key = $this$getGroup.getKey();
        String sourceInfo = $this$getGroup.getSourceInfo();
        int i9 = 0;
        if (sourceInfo != null) {
            i4 = 0;
            it = SlotTreeKt.sourceInformationContextOf(sourceInfo, inline);
        } else {
            it = i9;
        }
        final int i16 = it;
        int i8 = i9;
        node2 = $this$getGroup.getNode();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList list7 = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        final ArrayList list8 = arrayList3;
        CollectionsKt.addAll((Collection)(List)list7, $this$getGroup.getData());
        Iterator iterator2 = $this$getGroup.getCompositionGroups().iterator();
        for (CompositionGroup data : iterator2) {
            (List)list8.add(SlotTreeKt.getGroup(data, i16));
        }
        if (node2 instanceof LayoutInfo) {
            list = modifierInfo;
        } else {
            list = modifierInfo;
        }
        if (node2 instanceof LayoutInfo) {
            $i$f$reduce = SlotTreeKt.boundsOfLayoutNode((LayoutInfo)node2);
            i3 = 1;
            int i12 = 0;
            if (i16 != 0 && i16.isCall() == i3) {
                i2 = i16.isCall() == i3 ? i3 : i12;
            } else {
            }
            if (i2 != 0 && inline != null) {
                if (inline != null) {
                    location = inline.nextSourceLocation();
                } else {
                    location = i8;
                }
            } else {
            }
            if (node2 != null) {
                callGroup = new NodeGroup(key, node2, $i$f$reduce, (Collection)list7, list, (Collection)list8);
                node3 = node2;
                list2 = list;
                i = location;
            } else {
                node3 = node2;
                list2 = list;
                node = i8;
                if (i16 != 0) {
                    name = i16.getName();
                } else {
                    name = node;
                }
                if (i16 != 0) {
                    length = i16.getName();
                } else {
                    length = node;
                }
                if ((CharSequence)length != 0) {
                    if ((CharSequence)length.length() == 0) {
                        i7 = i3;
                    } else {
                        i7 = i12;
                    }
                } else {
                }
                if (i7 == 0) {
                    if (bottom -= location2 <= 0) {
                        if (right -= location2 > 0) {
                            node = $this$getGroup.getIdentity();
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                if (i16 != 0 && i16.isInline() == i3) {
                    if (i16.isInline() == i3) {
                    } else {
                        i3 = i6;
                    }
                } else {
                }
                callGroup = new CallGroup(key, name, $i$f$reduce, location, node, SlotTreeKt.extractParameterInfo(list7, i16), (Collection)list7, (Collection)list8, i3);
            }
            return callGroup;
        } else {
            if (list8.isEmpty()) {
                $i$f$reduce = SlotTreeKt.emptyBox;
            } else {
                ArrayList list4 = list8;
                int i11 = 0;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)list4, 10));
                box = 0;
                location2 = list4.iterator();
                for (Object next2 : location2) {
                    i6 = 0;
                    (Collection)arrayList.add((Group)next2.getBox());
                }
                int i10 = 0;
                iterator = (Iterable)(List)arrayList.iterator();
                if (!iterator.hasNext()) {
                } else {
                    accumulator$iv = iterator.next();
                    for (IntRect next4 : iterator) {
                        next2 = false;
                        accumulator$iv = box;
                    }
                    $i$f$reduce = accumulator$iv;
                }
            }
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Empty collection can't be reduced.");
        throw unsupportedOperationException;
    }

    public static final String getPosition(androidx.compose.ui.tooling.data.Group $this$position) {
        return SlotTreeKt.keyPosition($this$position.getKey());
    }

    public static void getPosition$annotations(androidx.compose.ui.tooling.data.Group group) {
    }

    private static final String getText(MatchResult $this$text) {
        return (String)$this$text.getGroupValues().get(0);
    }

    private static final boolean isANumber(MatchResult $this$isANumber) {
        int i;
        if ($this$isANumber.getGroups().get(1) != null) {
        } else {
            i = 0;
        }
        return i;
    }

    private static final boolean isCallWithName(MatchResult $this$isCallWithName) {
        int i;
        i = $this$isCallWithName.getGroups().get(6) != null ? 1 : 0;
        return i;
    }

    private static final boolean isChar(MatchResult $this$isChar, String c) {
        return Intrinsics.areEqual(SlotTreeKt.getText($this$isChar), c);
    }

    private static final boolean isClassName(MatchResult $this$isClassName) {
        int i;
        i = $this$isClassName.getGroups().get(2) != null ? 1 : 0;
        return i;
    }

    private static final boolean isFileName(MatchResult $this$isFileName) {
        int i;
        i = $this$isFileName.getGroups().get(4) != null ? 1 : 0;
        return i;
    }

    private static final boolean isNumber(MatchResult $this$isNumber) {
        int i;
        if ($this$isNumber.getGroups().get(1) != null) {
        } else {
            i = 0;
        }
        return i;
    }

    private static final boolean isParameterInformation(MatchResult $this$isParameterInformation) {
        int i;
        i = $this$isParameterInformation.getGroups().get(5) != null ? 1 : 0;
        return i;
    }

    private static final String keyPosition(Object key) {
        Object keyPosition;
        if (key instanceof String != null) {
            keyPosition = key;
        } else {
            if (key instanceof JoinedKey) {
                if (SlotTreeKt.keyPosition((JoinedKey)key.getLeft()) == null) {
                    keyPosition = SlotTreeKt.keyPosition((JoinedKey)key.getRight());
                }
            } else {
                keyPosition = 0;
            }
        }
        return keyPosition;
    }

    public static final <T> T mapTree(CompositionData $this$mapTree, Function3<? super CompositionGroup, ? super androidx.compose.ui.tooling.data.SourceContext, ? super List<? extends T>, ? extends T> factory, androidx.compose.ui.tooling.data.ContextCache cache) {
        Object firstOrNull = CollectionsKt.firstOrNull($this$mapTree.getCompositionGroups());
        if ((CompositionGroup)firstOrNull == null) {
            return 0;
        }
        CompositionCallStack compositionCallStack = new CompositionCallStack(factory, cache.getContexts$ui_tooling_data_release());
        ArrayList arrayList = new ArrayList();
        compositionCallStack.convert((CompositionGroup)firstOrNull, 0, (List)arrayList);
        return CollectionsKt.firstOrNull(arrayList);
    }

    public static Object mapTree$default(CompositionData compositionData, Function3 function32, androidx.compose.ui.tooling.data.ContextCache contextCache3, int i4, Object object5) {
        androidx.compose.ui.tooling.data.ContextCache obj2;
        if (i4 &= 2 != 0) {
            obj2 = new ContextCache();
        }
        return SlotTreeKt.mapTree(compositionData, function32, obj2);
    }

    private static final int number(MatchResult $this$number) {
        return SlotTreeKt.parseToInt((String)$this$number.getGroupValues().get(1));
    }

    private static final List<androidx.compose.ui.tooling.data.Parameter> parseParameters(String parameters) {
        String parameter;
        String parameters$expectNumber;
        boolean parameters$isChar;
        int parameters$expectClassName;
        Integer valueOf;
        int i;
        androidx.compose.ui.tooling.data.Parameter parameter2;
        int intValue;
        parameter = ")";
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final int i4 = 0;
        final int i5 = 2;
        final int i6 = 0;
        objectRef.element = Regex.find$default(SlotTreeKt.parametersInformationTokenizer, (CharSequence)parameters, i4, i5, i6);
        Integer[] arr = new Integer[4];
        arr[i4] = Integer.valueOf(i4);
        int i3 = 1;
        arr[i3] = Integer.valueOf(i3);
        arr[i5] = Integer.valueOf(i5);
        int i7 = 3;
        arr[i7] = Integer.valueOf(i7);
        List mutableListOf = CollectionsKt.mutableListOf(arr);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = size2 -= i3;
        ArrayList arrayList = new ArrayList();
        SlotTreeKt.parseParameters$expect(objectRef, "P");
        SlotTreeKt.parseParameters$expect(objectRef, "(");
        while (!SlotTreeKt.parseParameters$isChar(objectRef, parameter)) {
            if (SlotTreeKt.parseParameters$isChar(objectRef, "!")) {
            } else {
            }
            if (SlotTreeKt.parseParameters$isChar(objectRef, ",") != null) {
            } else {
            }
            parameters$expectNumber = SlotTreeKt.parseParameters$expectNumber(objectRef);
            if (SlotTreeKt.parseParameters$isClassName(objectRef)) {
            } else {
            }
            parameters$expectClassName = i6;
            Parameter parameter3 = new Parameter(parameters$expectNumber, parameters$expectClassName);
            (List)arrayList.add(parameter3);
            SlotTreeKt.parseParameters$ensureIndexes(intRef, mutableListOf, parameters$expectNumber);
            mutableListOf.remove(Integer.valueOf(parameters$expectNumber));
            parameters$expectClassName = SlotTreeKt.parseParameters$expectClassName(objectRef);
            SlotTreeKt.parseParameters$next(objectRef);
            SlotTreeKt.parseParameters$next(objectRef);
            parameters$expectNumber = SlotTreeKt.parseParameters$expectNumber(objectRef);
            SlotTreeKt.parseParameters$ensureIndexes(intRef, mutableListOf, size3 += parameters$expectNumber);
            parameters$expectClassName = i4;
            while (parameters$expectClassName < parameters$expectNumber) {
                valueOf = parameters$expectClassName;
                i = 0;
                parameter2 = new Parameter((Number)CollectionsKt.first(mutableListOf).intValue(), i6, i5, i6);
                arrayList.add(parameter2);
                mutableListOf.remove(i4);
                parameters$expectClassName++;
            }
            valueOf = parameters$expectClassName;
            i = 0;
            parameter2 = new Parameter((Number)CollectionsKt.first(mutableListOf).intValue(), i6, i5, i6);
            arrayList.add(parameter2);
            mutableListOf.remove(i4);
            parameters$expectClassName++;
        }
        SlotTreeKt.parseParameters$expect(objectRef, parameter);
        while (mutableListOf.size() > 0) {
            parameter = new Parameter((Number)CollectionsKt.first(mutableListOf).intValue(), i6, i5, i6);
            arrayList.add(parameter);
            mutableListOf.remove(i4);
        }
        return arrayList;
    }

    private static final void parseParameters$ensureIndexes(Ref.IntRef lastAdded, List<Integer> expectedSortedIndex, int index) {
        int i6;
        int i;
        int i4;
        int i5;
        int i2;
        int i3;
        Integer valueOf;
        int i7 = index - element;
        if (i7 > 0) {
            i6 = 4;
            i = i7 < i6 ? i6 : i7;
            i4 = 0;
            while (i4 < i) {
                i3 = 0;
                expectedSortedIndex.add(Integer.valueOf(i8++));
                i4++;
            }
            lastAdded.element = element2 += i;
        }
    }

    private static final void parseParameters$expect(Ref.ObjectRef<MatchResult> currentResult, String value) {
        boolean equal;
        final Object element = currentResult.element;
        if ((MatchResult)element == null) {
        } else {
            if (!Intrinsics.areEqual(SlotTreeKt.getText((MatchResult)element), value)) {
            } else {
                SlotTreeKt.parseParameters$next(currentResult);
            }
        }
        ParseError parseError = new ParseError();
        throw parseError;
    }

    private static final String parseParameters$expectClassName(Ref.ObjectRef<MatchResult> currentResult) {
        boolean className;
        final Object element = currentResult.element;
        if ((MatchResult)element == null) {
        } else {
            if (!SlotTreeKt.isClassName((MatchResult)element)) {
            } else {
                SlotTreeKt.parseParameters$next(currentResult);
                String substring = SlotTreeKt.getText(element).substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return SlotTreeKt.replacePrefix(substring, "c#", "androidx.compose.");
            }
        }
        ParseError parseError = new ParseError();
        throw parseError;
    }

    private static final int parseParameters$expectNumber(Ref.ObjectRef<MatchResult> currentResult) {
        boolean aNumber;
        final Object element = currentResult.element;
        if ((MatchResult)element == null) {
        } else {
            if (!SlotTreeKt.isANumber((MatchResult)element)) {
            } else {
                SlotTreeKt.parseParameters$next(currentResult);
                return SlotTreeKt.parseToInt(SlotTreeKt.getText(element));
            }
        }
        ParseError parseError = new ParseError();
        throw parseError;
    }

    private static final boolean parseParameters$isChar(Ref.ObjectRef<MatchResult> currentResult, String value) {
        int i;
        boolean equal;
        final Object element = currentResult.element;
        if ((MatchResult)element != null) {
            if (Intrinsics.areEqual(SlotTreeKt.getText((MatchResult)element), value)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final boolean parseParameters$isClassName(Ref.ObjectRef<MatchResult> currentResult) {
        boolean className;
        int i;
        final Object element = currentResult.element;
        if (element != null && SlotTreeKt.isClassName((MatchResult)element)) {
            i = SlotTreeKt.isClassName(element) ? 1 : 0;
        } else {
        }
        return i;
    }

    private static final MatchResult parseParameters$next(Ref.ObjectRef<MatchResult> currentResult) {
        int i;
        MatchResult next;
        Object element = currentResult.element;
        if ((MatchResult)element != null) {
            i = 0;
            currentResult.element = (MatchResult)element.next();
        }
        return (MatchResult)currentResult.element;
    }

    private static final int parseToInt(String $this$parseToInt) {
        return Integer.parseInt($this$parseToInt);
    }

    private static final int parseToInt(String $this$parseToInt, int radix) {
        return Integer.parseInt($this$parseToInt, CharsKt.checkRadix(radix));
    }

    private static final String replacePrefix(String $this$replacePrefix, String prefix, String replacement) {
        String string;
        String substring;
        String str;
        if (StringsKt.startsWith$default($this$replacePrefix, prefix, false, 2, 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            substring = $this$replacePrefix.substring(prefix.length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            string = stringBuilder.append(replacement).append(substring).toString();
        } else {
            string = $this$replacePrefix;
        }
        return string;
    }

    private static final androidx.compose.ui.tooling.data.SourceInformationContext sourceInformationContextOf(String information, androidx.compose.ui.tooling.data.SourceInformationContext parent) {
        int equal;
        Object repeatOffset;
        int toInt;
        boolean number;
        int sourceInformationContextOf$parseLocation;
        int sourceFile2;
        int i7;
        int mr;
        String packageHash2;
        int callName;
        int sourceFile;
        int substringAfterLast;
        int parameters;
        int i5;
        String i6;
        int i8;
        int packageHash;
        int i4;
        int i2;
        int i;
        int i3;
        int isInline;
        int length;
        final java.lang.CharSequence charSequence = information;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = objectRef;
        packageHash2 = 0;
        sourceFile = 0;
        objectRef2.element = Regex.find$default(SlotTreeKt.tokenizer, (CharSequence)charSequence, packageHash2, 2, sourceFile);
        ArrayList arrayList = new ArrayList();
        final ArrayList list = arrayList;
        i2 = equal;
        i3 = i7;
        isInline = callName;
        i = i13;
        parameters = substringAfterLast;
        while (objectRef2.element != null) {
            Object element = objectRef2.element;
            Intrinsics.checkNotNull(element);
            i7 = element;
            sourceInformationContextOf$parseLocation = SlotTreeKt.sourceInformationContextOf$parseLocation(objectRef2);
            if (sourceInformationContextOf$parseLocation != null) {
            }
            callName = 0;
            (List)list.add(sourceInformationContextOf$parseLocation);
            SlotTreeKt.sourceInformationContextOf$next$4(objectRef2);
            SlotTreeKt.sourceInformationContextOf$next$4(objectRef2);
            i2 = sourceInformationContextOf$parseLocation;
            SlotTreeKt.sourceInformationContextOf$next$4(objectRef2);
            i = sourceInformationContextOf$parseLocation;
            if (i3 != 0) {
            }
            SlotTreeKt.sourceInformationContextOf$next$4(objectRef2);
            i3 = sourceInformationContextOf$parseLocation;
            parameters = callName;
            isInline = 1;
            if (i3 != 0) {
            }
            SlotTreeKt.sourceInformationContextOf$next$4(objectRef2);
            i3 = sourceInformationContextOf$parseLocation;
            isInline = 1;
        }
        sourceFile2 = i6;
        mr = packageHash;
        if (sourceFile2 == null) {
            if (parent != null) {
                sourceFile = parent.getSourceFile();
            }
            i8 = sourceFile;
        } else {
            i8 = sourceFile2;
        }
        if (sourceFile2 != null) {
            i4 = mr;
        } else {
        }
        SourceInformationContext sourceInformationContext = new SourceInformationContext(parameters, i8, i4, list, i2, i, i3, isInline);
        return sourceInformationContext;
    }

    static androidx.compose.ui.tooling.data.SourceInformationContext sourceInformationContextOf$default(String string, androidx.compose.ui.tooling.data.SourceInformationContext sourceInformationContext2, int i3, Object object4) {
        int obj1;
        if (i3 &= 2 != 0) {
            obj1 = 0;
        }
        return SlotTreeKt.sourceInformationContextOf(string, obj1);
    }

    private static final MatchResult sourceInformationContextOf$next$4(Ref.ObjectRef<MatchResult> currentResult) {
        int i;
        MatchResult next;
        Object element = currentResult.element;
        if ((MatchResult)element != null) {
            i = 0;
            currentResult.element = (MatchResult)element.next();
        }
        return (MatchResult)currentResult.element;
    }

    private static final androidx.compose.ui.tooling.data.SourceLocationInfo sourceInformationContextOf$parseLocation(Ref.ObjectRef<MatchResult> currentResult) {
        int lineNumber;
        int offset;
        int length;
        Object mr;
        boolean valueOf;
        MatchResult number;
        lineNumber = 0;
        offset = 0;
        length = 0;
        final int i = 0;
        mr = currentResult.element;
        if (mr != null && SlotTreeKt.isNumber((MatchResult)mr)) {
            if (SlotTreeKt.isNumber(mr)) {
                lineNumber = valueOf3;
                mr = valueOf;
            }
        }
        valueOf = SlotTreeKt.sourceInformationContextOf$next$4(currentResult);
        if (mr != null && SlotTreeKt.isChar(mr, "@") && valueOf != null) {
            if (SlotTreeKt.isChar(mr, "@")) {
                try {
                    valueOf = SlotTreeKt.sourceInformationContextOf$next$4(currentResult);
                    if (valueOf != null) {
                    }
                    if (!SlotTreeKt.isNumber(valueOf)) {
                    } else {
                    }
                    offset = valueOf2;
                    mr = SlotTreeKt.sourceInformationContextOf$next$4(currentResult);
                    mr = number;
                    if (mr != null && SlotTreeKt.isChar(mr, "L") && mr != null && !SlotTreeKt.isNumber(mr)) {
                    }
                    if (SlotTreeKt.isChar(mr, "L")) {
                    }
                    mr = number;
                    if (mr != null) {
                    }
                    if (!SlotTreeKt.isNumber(mr)) {
                    }
                    length = valueOf;
                    return i;
                    return i;
                    if (lineNumber != 0 && offset != null && length != 0) {
                    }
                    if (offset != null) {
                    }
                    if (length != 0) {
                    }
                    SourceLocationInfo sourceLocationInfo = new SourceLocationInfo(lineNumber, offset, length);
                    return sourceLocationInfo;
                    return i;
                    return obj3;
                }
            }
        }
    }

    public static final IntRect union(IntRect $this$union, IntRect other) {
        if (Intrinsics.areEqual($this$union, SlotTreeKt.emptyBox)) {
            return other;
        }
        if (Intrinsics.areEqual(other, SlotTreeKt.emptyBox)) {
            return $this$union;
        }
        IntRect intRect = new IntRect(Math.min($this$union.getLeft(), other.getLeft()), Math.min($this$union.getTop(), other.getTop()), Math.max($this$union.getRight(), other.getRight()), Math.max($this$union.getBottom(), other.getBottom()));
        return intRect;
    }
}
