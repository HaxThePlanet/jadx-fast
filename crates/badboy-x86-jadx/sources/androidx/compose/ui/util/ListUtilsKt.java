package androidx.compose.ui.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0008\u0007\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u001c\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u001f\n\u0002\u0008\u0003\n\u0002\u0010\u000f\n\u0002\u0008\u000e\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\t\u001a8\u0010\n\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a8\u0010\u000e\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001aD\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00100\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a>\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000c\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a\"\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000c\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0014*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000c\u001a=\u0010\u0015\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u0016\u001a?\u0010\u0017\u001a\u0004\u0018\u0001H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u0016\u001aJ\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0019*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00190\u001a0\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a`\u0010\u001b\u001a\u0002H\u0019\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0019*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0006\u0010\u001c\u001a\u0002H\u00192'\u0010\u001d\u001a#\u0012\u0013\u0012\u0011H\u0019¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00190\u001eH\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\"\u001a8\u0010#\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a>\u0010%\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001eH\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a8\u0010'\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a}\u0010(\u001a\u0002H)\"\u0004\u0008\u0000\u0010\u0002\"\u000c\u0008\u0001\u0010)*\u00060\u0003j\u0002`\u0004*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0006\u0010*\u001a\u0002H)2\u0008\u0008\u0002\u0010+\u001a\u00020\u00082\u0008\u0008\u0002\u0010,\u001a\u00020\u00082\u0008\u0008\u0002\u0010-\u001a\u00020\u00082\u0008\u0008\u0002\u0010.\u001a\u00020&2\u0008\u0008\u0002\u0010/\u001a\u00020\u00082\u0016\u0008\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007H\u0002¢\u0006\u0002\u00100\u001a`\u00101\u001a\u000202\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0008\u0008\u0002\u0010+\u001a\u00020\u00082\u0008\u0008\u0002\u0010,\u001a\u00020\u00082\u0008\u0008\u0002\u0010-\u001a\u00020\u00082\u0008\u0008\u0002\u0010.\u001a\u00020&2\u0008\u0008\u0002\u0010/\u001a\u00020\u00082\u0016\u0008\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007\u001a?\u00103\u001a\u0004\u0018\u0001H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u0016\u001aD\u00104\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0019*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00190\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001aY\u00105\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0019*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2'\u0010\u0006\u001a#\u0012\u0013\u0012\u00110&¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(6\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00190\u001eH\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a[\u00107\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0019*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2)\u0010\u0006\u001a%\u0012\u0013\u0012\u00110&¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(6\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00190\u001eH\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001aF\u00108\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0019*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00190\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a]\u00109\u001a\u0002H:\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0019\"\u0010\u0008\u0002\u0010:*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00190;*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0006\u0010<\u001a\u0002H:2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00190\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010=\u001aO\u0010>\u001a\u0004\u0018\u0001H\u0002\"\u0004\u0008\u0000\u0010\u0002\"\u000e\u0008\u0001\u0010\u0019*\u0008\u0012\u0004\u0012\u0002H\u00190?*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00190\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u0016\u001aO\u0010@\u001a\u0004\u0018\u0001H\u0019\"\u0004\u0008\u0000\u0010\u0002\"\u000e\u0008\u0001\u0010\u0019*\u0008\u0012\u0004\u0012\u0002H\u00190?*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00190\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010A\u001aO\u0010B\u001a\u0004\u0018\u0001H\u0002\"\u0004\u0008\u0000\u0010\u0002\"\u000e\u0008\u0001\u0010\u0019*\u0008\u0012\u0004\u0012\u0002H\u00190?*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00190\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u0016\u001a\\\u0010C\u001a\u0002HD\"\u0004\u0008\u0000\u0010D\"\u0008\u0008\u0001\u0010\u0002*\u0002HD*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2'\u0010\u001d\u001a#\u0012\u0013\u0012\u0011HD¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002HD0\u001eH\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010E\u001a8\u0010F\u001a\u00020&\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020&0\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a|\u0010G\u001a\u0008\u0012\u0004\u0012\u0002HH0\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0019\"\u0004\u0008\u0002\u0010H*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u000c\u0010I\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u000c26\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(J\u0012\u0013\u0012\u0011H\u0019¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(K\u0012\u0004\u0012\u0002HH0\u001eH\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002\u001aJ\u0010L\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0019*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00190\u001eH\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¨\u0006M", d2 = {"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastAll", "", "", "predicate", "fastAny", "fastDistinctBy", "K", "selector", "fastFilter", "fastFilterNotNull", "", "fastFirst", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fastFirstOrNull", "fastFlatMap", "R", "", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastForEach", "action", "fastForEachIndexed", "", "fastForEachReversed", "fastJoinTo", "A", "buffer", "separator", "prefix", "postfix", "limit", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastLastOrNull", "fastMap", "fastMapIndexed", "index", "fastMapIndexedNotNull", "fastMapNotNull", "fastMapTo", "C", "", "destination", "(Ljava/util/List;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fastMaxBy", "", "fastMaxOfOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "fastMinByOrNull", "fastReduce", "S", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastSumBy", "fastZip", "V", "other", "a", "b", "fastZipWithNext", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ListUtilsKt {
    private static final <T> void appendElement(java.lang.Appendable $this$appendElement, T element, Function1<? super T, ? extends java.lang.CharSequence> transform) {
        String charValue;
        int i;
        if (transform != null) {
            $this$appendElement.append((CharSequence)transform.invoke(element));
        } else {
            i = element == null ? 1 : element instanceof CharSequence;
            if (i != 0) {
                $this$appendElement.append((CharSequence)element);
            } else {
                if (element instanceof Character) {
                    $this$appendElement.append((Character)element.charValue());
                } else {
                    $this$appendElement.append((CharSequence)String.valueOf(element));
                }
            }
        }
    }

    public static final <T> boolean fastAll(List<? extends T> $this$fastAll, Function1<? super T, Boolean> predicate) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        boolean booleanValue;
        final int i2 = 0;
        Object obj3 = $this$fastAll;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            index$iv++;
        }
        return 1;
    }

    public static final <T> boolean fastAny(List<? extends T> $this$fastAny, Function1<? super T, Boolean> predicate) {
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        boolean booleanValue;
        final int i2 = 0;
        Object obj3 = $this$fastAny;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            index$iv++;
        }
        return 0;
    }

    public static final <T, K> List<T> fastDistinctBy(List<? extends T> $this$fastDistinctBy, Function1<? super T, ? extends K> selector) {
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        Object invoke;
        boolean z;
        final int i2 = 0;
        HashSet hashSet = new HashSet($this$fastDistinctBy.size());
        ArrayList arrayList = new ArrayList($this$fastDistinctBy.size());
        Object obj3 = $this$fastDistinctBy;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            obj = obj2;
            i = 0;
            if (hashSet.add(selector.invoke(obj))) {
            }
            index$iv++;
            (Collection)arrayList.add(obj);
        }
        return (List)arrayList;
    }

    public static final <T> List<T> fastFilter(List<? extends T> $this$fastFilter, Function1<? super T, Boolean> predicate) {
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        boolean booleanValue;
        final int i2 = 0;
        ArrayList arrayList = new ArrayList($this$fastFilter.size());
        Object obj3 = $this$fastFilter;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            obj = obj2;
            i = 0;
            if ((Boolean)predicate.invoke(obj).booleanValue()) {
            }
            index$iv++;
            (Collection)arrayList.add(obj);
        }
        return (List)arrayList;
    }

    public static final <T> List<T> fastFilterNotNull(List<? extends T> $this$fastFilterNotNull) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        ArrayList list;
        ArrayList arrayList = new ArrayList($this$fastFilterNotNull.size());
        Object obj3 = $this$fastFilterNotNull;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            obj2 = obj;
            i = 0;
            if (obj2 != null) {
            }
            index$iv++;
            (Collection)arrayList.add(obj2);
        }
        return (List)arrayList;
    }

    public static final <T> T fastFirst(List<? extends T> $this$fastFirst, Function1<? super T, Boolean> predicate) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        boolean booleanValue;
        final int i2 = 0;
        Object obj3 = $this$fastFirst;
        int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            obj2 = obj;
            i = 0;
            index$iv++;
        }
        NoSuchElementException $this$fastForEach$iv = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw $this$fastForEach$iv;
    }

    public static final <T> T fastFirstOrNull(List<? extends T> $this$fastFirstOrNull, Function1<? super T, Boolean> predicate) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        boolean booleanValue;
        final int i2 = 0;
        Object obj3 = $this$fastFirstOrNull;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            obj2 = obj;
            i = 0;
            index$iv++;
        }
        return 0;
    }

    public static final <T, R> List<R> fastFlatMap(List<? extends T> $this$fastFlatMap, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        Object invoke;
        ArrayList list;
        final int i2 = 0;
        ArrayList arrayList = new ArrayList($this$fastFlatMap.size());
        Object obj3 = $this$fastFlatMap;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            CollectionsKt.addAll((Collection)arrayList, (Iterable)transform.invoke(obj3.get(index$iv)));
            index$iv++;
        }
        return (List)arrayList;
    }

    public static final <T, R> R fastFold(List<? extends T> $this$fastFold, R initial, Function2<? super R, ? super T, ? extends R> operation) {
        Object accumulator;
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        final int i2 = 0;
        int i3 = 0;
        accumulator = initial;
        final Object obj3 = $this$fastFold;
        final int i4 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            accumulator = operation.invoke(accumulator, obj3.get(index$iv));
            index$iv++;
        }
        return accumulator;
    }

    public static final <T> void fastForEach(List<? extends T> $this$fastForEach, Function1<? super T, Unit> action) {
        int index;
        Object obj;
        final int i = 0;
        index = 0;
        while (index < $this$fastForEach.size()) {
            action.invoke($this$fastForEach.get(index));
            index++;
        }
    }

    public static final <T> void fastForEachIndexed(List<? extends T> $this$fastForEachIndexed, Function2<? super Integer, ? super T, Unit> action) {
        int index;
        Object obj;
        Integer valueOf;
        final int i = 0;
        index = 0;
        while (index < $this$fastForEachIndexed.size()) {
            action.invoke(Integer.valueOf(index), $this$fastForEachIndexed.get(index));
            index++;
        }
    }

    public static final <T> void fastForEachReversed(List<? extends T> $this$fastForEachReversed, Function1<? super T, Unit> action) {
        int i;
        int i2;
        Object obj;
        final int i3 = 0;
        if (size-- >= 0) {
        }
    }

    private static final <T, A extends java.lang.Appendable> A fastJoinTo(List<? extends T> $this$fastJoinTo, A buffer, java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function1<? super T, ? extends java.lang.CharSequence> transform) {
        int count;
        int index;
        Object obj;
        int i;
        buffer.append(prefix);
        count = 0;
        index = 0;
        while (index < $this$fastJoinTo.size()) {
            count++;
            if (count > 1) {
            }
            if (limit >= 0) {
                break;
            } else {
            }
            ListUtilsKt.appendElement(buffer, $this$fastJoinTo.get(index), transform);
            index++;
            if (count > limit) {
                break;
            } else {
            }
            buffer.append(separator);
        }
        if (limit >= 0 && count > limit) {
            if (count > limit) {
                buffer.append(truncated);
            }
        }
        buffer.append(postfix);
        return buffer;
    }

    static java.lang.Appendable fastJoinTo$default(List list, java.lang.Appendable appendable2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, java.lang.CharSequence charSequence5, int i6, java.lang.CharSequence charSequence7, Function1 function18, int i9, Object object10) {
        String str4;
        String str3;
        String str;
        int i;
        String str2;
        int i2;
        if (i9 & 2 != 0) {
            str4 = ", ";
        } else {
            str4 = charSequence3;
        }
        if (i9 & 4 != 0) {
            str3 = str;
        } else {
            str3 = charSequence4;
        }
        if (i9 & 8 != 0) {
        } else {
            str = charSequence5;
        }
        i = i9 & 16 != 0 ? -1 : i6;
        if (i9 & 32 != 0) {
            str2 = "...";
        } else {
            str2 = charSequence7;
        }
        i2 = i9 & 64 != 0 ? 0 : function18;
        return ListUtilsKt.fastJoinTo(list, appendable2, str4, str3, str, i, str2, i2);
    }

    public static final <T> String fastJoinToString(List<? extends T> $this$fastJoinToString, java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function1<? super T, ? extends java.lang.CharSequence> transform) {
        StringBuilder stringBuilder = new StringBuilder();
        return (StringBuilder)ListUtilsKt.fastJoinTo($this$fastJoinToString, (Appendable)stringBuilder, separator, prefix, postfix, limit, truncated, transform).toString();
    }

    public static String fastJoinToString$default(List list, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, Function1 function17, int i8, Object object9) {
        String obj2;
        String obj3;
        String obj4;
        int obj5;
        String obj6;
        int obj7;
        int obj9;
        if (i8 & 1 != 0) {
            obj2 = ", ";
        }
        final String str = "";
        if (i8 & 2 != 0) {
            obj3 = str;
        }
        if (i8 & 4 != 0) {
            obj4 = str;
        }
        if (i8 & 8 != 0) {
            obj5 = -1;
        }
        if (i8 & 16 != 0) {
            obj6 = "...";
        }
        obj9 = i8 &= 32 != 0 ? obj7 : function17;
        return ListUtilsKt.fastJoinToString(list, obj2, obj3, obj4, obj5, obj6, obj9);
    }

    public static final <T> T fastLastOrNull(List<? extends T> $this$fastLastOrNull, Function1<? super T, Boolean> predicate) {
        int i;
        int i2;
        Object obj;
        boolean booleanValue;
        final int i3 = 0;
        if (size-- >= 0) {
        }
        return 0;
    }

    public static final <T, R> List<R> fastMap(List<? extends T> $this$fastMap, Function1<? super T, ? extends R> transform) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        ArrayList list;
        Object invoke;
        final int i2 = 0;
        ArrayList arrayList = new ArrayList($this$fastMap.size());
        Object obj3 = $this$fastMap;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            (Collection)arrayList.add(transform.invoke(obj3.get(index$iv)));
            index$iv++;
        }
        return (List)arrayList;
    }

    public static final <T, R> List<R> fastMapIndexed(List<? extends T> $this$fastMapIndexed, Function2<? super Integer, ? super T, ? extends R> transform) {
        int index$iv;
        Object obj;
        int i;
        Object obj2;
        int i2;
        ArrayList list;
        Object invoke;
        final int i3 = 0;
        ArrayList arrayList = new ArrayList($this$fastMapIndexed.size());
        Object obj3 = $this$fastMapIndexed;
        final int i4 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i2 = 0;
            (Collection)arrayList.add(transform.invoke(Integer.valueOf(index$iv), obj3.get(index$iv)));
            index$iv++;
        }
        return (List)arrayList;
    }

    public static final <T, R> List<R> fastMapIndexedNotNull(List<? extends T> $this$fastMapIndexedNotNull, Function2<? super Integer, ? super T, ? extends R> transform) {
        int index$iv;
        Object obj;
        int i;
        Object obj2;
        int i2;
        Object invoke;
        int i3;
        ArrayList list;
        final int i4 = 0;
        ArrayList arrayList = new ArrayList($this$fastMapIndexedNotNull.size());
        Object obj3 = $this$fastMapIndexedNotNull;
        final int i5 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i2 = 0;
            invoke = transform.invoke(Integer.valueOf(index$iv), obj3.get(index$iv));
            if (invoke != null) {
            }
            index$iv++;
            i3 = 0;
            (Collection)arrayList.add(invoke);
        }
        return (List)arrayList;
    }

    public static final <T, R> List<R> fastMapNotNull(List<? extends T> $this$fastMapNotNull, Function1<? super T, ? extends R> transform) {
        int index$iv;
        Object obj2;
        Object obj;
        int i2;
        Object invoke;
        int i;
        ArrayList list;
        final int i3 = 0;
        ArrayList arrayList = new ArrayList($this$fastMapNotNull.size());
        Object obj3 = $this$fastMapNotNull;
        final int i4 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i2 = 0;
            invoke = transform.invoke(obj3.get(index$iv));
            if (invoke != null) {
            }
            index$iv++;
            i = 0;
            (Collection)arrayList.add(invoke);
        }
        return (List)arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C fastMapTo(List<? extends T> $this$fastMapTo, C destination, Function1<? super T, ? extends R> transform) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        Object invoke;
        final int i2 = 0;
        final Object obj3 = $this$fastMapTo;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            destination.add(transform.invoke(obj3.get(index$iv)));
            index$iv++;
        }
        return destination;
    }

    public static final <T, R extends Comparable<? super R>> T fastMaxBy(List<? extends T> $this$fastMaxBy, Function1<? super T, ? extends R> selector) {
        Object maxElem;
        Object maxValue;
        int i;
        Object obj;
        Object invoke;
        int compareTo;
        final int i2 = 0;
        if ($this$fastMaxBy.isEmpty()) {
            return 0;
        }
        maxValue = selector.invoke($this$fastMaxBy.get(0));
        final int lastIndex = CollectionsKt.getLastIndex($this$fastMaxBy);
        if (1 <= lastIndex) {
        }
        return maxElem;
    }

    public static final <T, R extends Comparable<? super R>> R fastMaxOfOrNull(List<? extends T> $this$fastMaxOfOrNull, Function1<? super T, ? extends R> selector) {
        Object maxValue;
        int i;
        Object invoke;
        int compareTo;
        final int i2 = 0;
        if ($this$fastMaxOfOrNull.isEmpty()) {
            return 0;
        }
        maxValue = selector.invoke($this$fastMaxOfOrNull.get(0));
        final int lastIndex = CollectionsKt.getLastIndex($this$fastMaxOfOrNull);
        if (1 <= lastIndex) {
        }
        return maxValue;
    }

    public static final <T, R extends Comparable<? super R>> T fastMinByOrNull(List<? extends T> $this$fastMinByOrNull, Function1<? super T, ? extends R> selector) {
        Object minElem;
        Object minValue;
        int i;
        Object obj;
        Object invoke;
        int compareTo;
        final int i2 = 0;
        if ($this$fastMinByOrNull.isEmpty()) {
            return 0;
        }
        minValue = selector.invoke($this$fastMinByOrNull.get(0));
        final int lastIndex = CollectionsKt.getLastIndex($this$fastMinByOrNull);
        if (1 <= lastIndex) {
        }
        return minElem;
    }

    public static final <S, T extends S> S fastReduce(List<? extends T> $this$fastReduce, Function2<? super S, ? super T, ? extends S> operation) {
        Object accumulator;
        int i;
        Object obj;
        final int i2 = 0;
        if ($this$fastReduce.isEmpty()) {
        } else {
            accumulator = CollectionsKt.first($this$fastReduce);
            final int lastIndex = CollectionsKt.getLastIndex($this$fastReduce);
            if (1 <= lastIndex) {
            }
            return accumulator;
        }
        UnsupportedOperationException accumulator2 = new UnsupportedOperationException("Empty collection can't be reduced.");
        throw accumulator2;
    }

    public static final <T> int fastSumBy(List<? extends T> $this$fastSumBy, Function1<? super T, Integer> selector) {
        int sum;
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        int intValue;
        final int i2 = 0;
        sum = 0;
        final Object obj3 = $this$fastSumBy;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            sum += intValue;
            index$iv++;
        }
        return sum;
    }

    public static final <T, R, V> List<V> fastZip(List<? extends T> $this$fastZip, List<? extends R> other, Function2<? super T, ? super R, ? extends V> transform) {
        int i;
        ArrayList list;
        Object invoke;
        Object obj;
        final int i2 = 0;
        int i3 = Math.min($this$fastZip.size(), other.size());
        ArrayList arrayList = new ArrayList(i3);
        i = 0;
        while (i < i3) {
            (Collection)arrayList.add(transform.invoke($this$fastZip.get(i), other.get(i)));
            i++;
        }
        return (List)arrayList;
    }

    public static final <T, R> List<R> fastZipWithNext(List<? extends T> $this$fastZipWithNext, Function2<? super T, ? super T, ? extends R> transform) {
        int size;
        int i;
        Object current;
        int i2;
        Object obj;
        Object invoke;
        final int i3 = 0;
        if ($this$fastZipWithNext.size() != 0) {
            if ($this$fastZipWithNext.size() == 1) {
            } else {
                ArrayList arrayList = new ArrayList();
                current = $this$fastZipWithNext.get(0);
                i2 = 0;
                while (i2 < CollectionsKt.getLastIndex($this$fastZipWithNext)) {
                    obj = $this$fastZipWithNext.get(i2 + 1);
                    (List)arrayList.add(transform.invoke(current, obj));
                    current = obj;
                    i2++;
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }
}
