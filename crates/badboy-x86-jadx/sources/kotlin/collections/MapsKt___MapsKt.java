package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0008\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u001f\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000f\n\u0002\u0008\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u001aJ\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\u0008ø\u0001\u0000\u001a$\u0010\u0008\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010\u0008\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\u0008ø\u0001\u0000\u001a9\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\n\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\u0008\u001a6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001a'\u0010\r\u001a\u00020\u000e\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\u0008\u001aJ\u0010\r\u001a\u00020\u000e\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\u0008ø\u0001\u0000\u001a[\u0010\u000f\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0008\u0008\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a]\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0008\u0008\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\\\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010\u0010*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\u0008ø\u0001\u0000\u001aa\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010\u0010*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00100\u000c0\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008\u0017\u001au\u0010\u0018\u001a\u0002H\u0019\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010\u0010\"\u0010\u0008\u0003\u0010\u0019*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aw\u0010\u0018\u001a\u0002H\u0019\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010\u0010\"\u0010\u0008\u0003\u0010\u0019*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00100\u000c0\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001c\u001aJ\u0010\u001e\u001a\u00020\u001f\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\u0008ø\u0001\u0000\u001aV\u0010!\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010\u0010*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\u0008ø\u0001\u0000\u001a\\\u0010\"\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0008\u0008\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\u0008ø\u0001\u0000\u001au\u0010#\u001a\u0002H\u0019\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0008\u0008\u0002\u0010\u0010*\u00020\u0011\"\u0010\u0008\u0003\u0010\u0019*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ao\u0010$\u001a\u0002H\u0019\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010\u0010\"\u0010\u0008\u0003\u0010\u0019*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ak\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u000e\u0008\u0002\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008(\u001ah\u0010)\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u000e\u0008\u0002\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000\u001a_\u0010*\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u000e\u0008\u0002\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010+\u001aJ\u0010*\u001a\u00020,\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\u0008ø\u0001\u0000\u001aJ\u0010*\u001a\u00020-\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\u0008ø\u0001\u0000\u001aa\u0010.\u001a\u0004\u0018\u0001H\u0010\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u000e\u0008\u0002\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010+\u001aQ\u0010.\u001a\u0004\u0018\u00010,\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010/\u001aQ\u0010.\u001a\u0004\u0018\u00010-\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u00100\u001aq\u00101\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010\u0010*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u001003j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u00105\u001as\u00106\u001a\u0004\u0018\u0001H\u0010\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010\u0010*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u001003j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u00105\u001al\u00107\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\u0008\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\u0008\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\u0008¢\u0006\u0002\u00088\u001ai\u00109\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\u0008\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\u0008\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\u0008\u001ak\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u000e\u0008\u0002\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008;\u001ah\u0010<\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u000e\u0008\u0002\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000\u001a_\u0010=\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u000e\u0008\u0002\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010+\u001aJ\u0010=\u001a\u00020,\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\u0008ø\u0001\u0000\u001aJ\u0010=\u001a\u00020-\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\u0008ø\u0001\u0000\u001aa\u0010>\u001a\u0004\u0018\u0001H\u0010\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u000e\u0008\u0002\u0010\u0010*\u0008\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010+\u001aQ\u0010>\u001a\u0004\u0018\u00010,\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010/\u001aQ\u0010>\u001a\u0004\u0018\u00010-\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u00100\u001aq\u0010?\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010\u0010*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u001003j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u00105\u001as\u0010@\u001a\u0004\u0018\u0001H\u0010\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010\u0010*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u001003j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u00105\u001al\u0010A\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\u0008\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\u0008\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\u0008¢\u0006\u0002\u0008B\u001ai\u0010C\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\u0008\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\u0008\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\u0008\u001a$\u0010D\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010D\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\u0008ø\u0001\u0000\u001aY\u0010E\u001a\u0002HF\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0016\u0008\u0002\u0010F*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HF2\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010G\u001an\u0010H\u001a\u0002HF\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0016\u0008\u0002\u0010F*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HF23\u0010 \u001a/\u0012\u0013\u0012\u00110\u000e¢\u0006\u000c\u0008J\u0012\u0008\u0008K\u0012\u0004\u0008\u0008(L\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0IH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010M\u001a6\u0010N\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030O0\u0016\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006P", d2 = {"all", "", "K", "V", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "count", "", "firstNotNullOf", "R", "", "transform", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstNotNullOfOrNull", "flatMap", "", "flatMapSequence", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "flatMapSequenceTo", "forEach", "", "action", "map", "mapNotNull", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxByOrThrow", "maxByOrNull", "maxOf", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "", "", "maxOfOrNull", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxWith", "maxWithOrThrow", "maxWithOrNull", "minBy", "minByOrThrow", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minWith", "minWithOrThrow", "minWithOrNull", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "onEachIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
class MapsKt___MapsKt extends kotlin.collections.MapsKt___MapsJvmKt {
    public static final <K, V> boolean all(Map<? extends K, ? extends V> $this$all, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Object next;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter($this$all, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        final int i3 = 1;
        if ($this$all.isEmpty()) {
            return i3;
        }
        Iterator iterator = $this$all.entrySet().iterator();
        for (Map.Entry next : iterator) {
        }
        return i3;
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> $this$any) {
        Intrinsics.checkNotNullParameter($this$any, "<this>");
        return empty ^= 1;
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> $this$any, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Object next;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter($this$any, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        final int i3 = 0;
        if ($this$any.isEmpty()) {
            return i3;
        }
        Iterator iterator = $this$any.entrySet().iterator();
        for (Map.Entry next : iterator) {
        }
        return i3;
    }

    private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(Map<? extends K, ? extends V> $this$asIterable) {
        Intrinsics.checkNotNullParameter($this$asIterable, "<this>");
        return (Iterable)$this$asIterable.entrySet();
    }

    public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(Map<? extends K, ? extends V> $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return CollectionsKt.asSequence((Iterable)$this$asSequence.entrySet());
    }

    private static final <K, V> int count(Map<? extends K, ? extends V> $this$count) {
        Intrinsics.checkNotNullParameter($this$count, "<this>");
        return $this$count.size();
    }

    public static final <K, V> int count(Map<? extends K, ? extends V> $this$count, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        int count;
        Object next;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter($this$count, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        if ($this$count.isEmpty()) {
            return 0;
        }
        count = 0;
        Iterator iterator = $this$count.entrySet().iterator();
        while (iterator.hasNext()) {
            if ((Boolean)predicate.invoke((Map.Entry)iterator.next()).booleanValue()) {
            }
            count++;
        }
        return count;
    }

    private static final <K, V, R> R firstNotNullOf(Map<? extends K, ? extends V> $this$firstNotNullOf, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Object invoke;
        Intrinsics.checkNotNullParameter($this$firstNotNullOf, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator iterator = $this$firstNotNullOf.entrySet().iterator();
        while (iterator.hasNext()) {
            if (transform.invoke((Map.Entry)iterator.next()) == null) {
                break;
            }
        }
        invoke = 0;
        if (invoke == null) {
        } else {
            return invoke;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("No element of the map was transformed to a non-null value.");
        throw noSuchElementException;
    }

    private static final <K, V, R> R firstNotNullOfOrNull(Map<? extends K, ? extends V> $this$firstNotNullOfOrNull, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Object next;
        Object invoke;
        Intrinsics.checkNotNullParameter($this$firstNotNullOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Iterator iterator = $this$firstNotNullOfOrNull.entrySet().iterator();
        for (Map.Entry next : iterator) {
            invoke = transform.invoke(next);
        }
        return 0;
    }

    public static final <K, V, R> List<R> flatMap(Map<? extends K, ? extends V> $this$flatMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        Object next;
        Object invoke;
        Intrinsics.checkNotNullParameter($this$flatMap, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        ArrayList arrayList = new ArrayList();
        final int i2 = 0;
        Iterator iterator = $this$flatMap.entrySet().iterator();
        for (Map.Entry next : iterator) {
            CollectionsKt.addAll((Collection)arrayList, (Iterable)transform.invoke(next));
        }
        return (List)arrayList;
    }

    public static final <K, V, R> List<R> flatMapSequence(Map<? extends K, ? extends V> $this$flatMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> transform) {
        Object next;
        Object invoke;
        Intrinsics.checkNotNullParameter($this$flatMap, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        ArrayList arrayList = new ArrayList();
        final int i2 = 0;
        Iterator iterator = $this$flatMap.entrySet().iterator();
        for (Map.Entry next : iterator) {
            CollectionsKt.addAll((Collection)arrayList, (Sequence)transform.invoke(next));
        }
        return (List)arrayList;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapSequenceTo(Map<? extends K, ? extends V> $this$flatMapTo, C destination, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> transform) {
        Object next;
        Object invoke;
        Intrinsics.checkNotNullParameter($this$flatMapTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        Iterator iterator = $this$flatMapTo.entrySet().iterator();
        for (Map.Entry next : iterator) {
            CollectionsKt.addAll(destination, (Sequence)transform.invoke(next));
        }
        return destination;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(Map<? extends K, ? extends V> $this$flatMapTo, C destination, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        Object next;
        Object invoke;
        Intrinsics.checkNotNullParameter($this$flatMapTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        Iterator iterator = $this$flatMapTo.entrySet().iterator();
        for (Map.Entry next : iterator) {
            CollectionsKt.addAll(destination, (Iterable)transform.invoke(next));
        }
        return destination;
    }

    public static final <K, V> void forEach(Map<? extends K, ? extends V> $this$forEach, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        Object next;
        Intrinsics.checkNotNullParameter($this$forEach, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        Iterator iterator = $this$forEach.entrySet().iterator();
        for (Map.Entry next : iterator) {
            action.invoke(next);
        }
    }

    public static final <K, V, R> List<R> map(Map<? extends K, ? extends V> $this$map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Object next;
        Object invoke;
        Intrinsics.checkNotNullParameter($this$map, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        ArrayList arrayList = new ArrayList($this$map.size());
        final int i2 = 0;
        Iterator iterator = $this$map.entrySet().iterator();
        for (Map.Entry next : iterator) {
            (Collection)arrayList.add(transform.invoke(next));
        }
        return (List)arrayList;
    }

    public static final <K, V, R> List<R> mapNotNull(Map<? extends K, ? extends V> $this$mapNotNull, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Object next;
        Object obj;
        int i;
        Object invoke;
        int i2;
        Intrinsics.checkNotNullParameter($this$mapNotNull, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i3 = 0;
        ArrayList arrayList = new ArrayList();
        final int i4 = 0;
        final int i5 = 0;
        Iterator iterator = $this$mapNotNull.entrySet().iterator();
        while (iterator.hasNext()) {
            i = 0;
            invoke = transform.invoke((Map.Entry)iterator.next());
            if (invoke != null) {
            }
            i2 = 0;
            (Collection)arrayList.add(invoke);
        }
        return (List)arrayList;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(Map<? extends K, ? extends V> $this$mapNotNullTo, C destination, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Object next;
        Object obj;
        int i2;
        Object invoke;
        int i;
        Intrinsics.checkNotNullParameter($this$mapNotNullTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i3 = 0;
        final int i4 = 0;
        Iterator iterator = $this$mapNotNullTo.entrySet().iterator();
        while (iterator.hasNext()) {
            i2 = 0;
            invoke = transform.invoke((Map.Entry)iterator.next());
            if (invoke != null) {
            }
            i = 0;
            destination.add(invoke);
        }
        return destination;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapTo(Map<? extends K, ? extends V> $this$mapTo, C destination, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Object next;
        Object invoke;
        Intrinsics.checkNotNullParameter($this$mapTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        Iterator iterator = $this$mapTo.entrySet().iterator();
        for (Map.Entry next : iterator) {
            destination.add(transform.invoke(next));
        }
        return destination;
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrNull(Map<? extends K, ? extends V> $this$maxByOrNull, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object maxElem$iv;
        Object maxValue$iv;
        boolean next;
        Object invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$maxByOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final int i = 0;
        final Iterator iterator = (Iterable)$this$maxByOrNull.entrySet().iterator();
        if (!iterator.hasNext()) {
            maxElem$iv = 0;
        } else {
            if (!iterator.hasNext()) {
            } else {
                maxValue$iv = selector.invoke(iterator.next());
                Object next3 = iterator.next();
                invoke = selector.invoke(next3);
                do {
                    next3 = iterator.next();
                    invoke = selector.invoke(next3);
                    if (iterator.hasNext()) {
                    }
                    maxElem$iv = next3;
                    maxValue$iv = invoke;
                } while (maxValue$iv.compareTo((Comparable)invoke) < 0);
            }
        }
        return (Map.Entry)maxElem$iv;
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrThrow(Map<? extends K, ? extends V> $this$maxBy, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object maxElem$iv;
        Object maxValue$iv;
        boolean next;
        Object invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$maxBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final int i = 0;
        final Iterator iterator = (Iterable)$this$maxBy.entrySet().iterator();
        if (!iterator.hasNext()) {
        } else {
            if (!iterator.hasNext()) {
            } else {
                maxValue$iv = selector.invoke(iterator.next());
                Object next3 = iterator.next();
                invoke = selector.invoke(next3);
                do {
                    next3 = iterator.next();
                    invoke = selector.invoke(next3);
                    if (iterator.hasNext()) {
                    }
                    maxElem$iv = next3;
                    maxValue$iv = invoke;
                } while (maxValue$iv.compareTo((Comparable)invoke) < 0);
            }
            return (Map.Entry)maxElem$iv;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private static final <K, V> double maxOf(Map<? extends K, ? extends V> $this$maxOf, Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        double doubleValue2;
        double doubleValue;
        Intrinsics.checkNotNullParameter($this$maxOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$maxOf.entrySet().iterator();
        if (!iterator.hasNext()) {
        } else {
            doubleValue2 = (Number)selector.invoke(iterator.next()).doubleValue();
            for (Object next4 : iterator) {
                doubleValue2 = Math.max(doubleValue2, obj2);
            }
            return doubleValue2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private static final <K, V> float maxOf(Map<? extends K, ? extends V> $this$maxOf, Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        float floatValue;
        float floatValue2;
        Intrinsics.checkNotNullParameter($this$maxOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$maxOf.entrySet().iterator();
        if (!iterator.hasNext()) {
        } else {
            floatValue = (Number)selector.invoke(iterator.next()).floatValue();
            for (Object next4 : iterator) {
                floatValue = Math.max(floatValue, (Number)selector.invoke(next4).floatValue());
            }
            return floatValue;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private static final <K, V, R extends Comparable<? super R>> R maxOf(Map<? extends K, ? extends V> $this$maxOf, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object invoke;
        Object invoke2;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$maxOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$maxOf.entrySet().iterator();
        if (!iterator.hasNext()) {
        } else {
            invoke = selector.invoke(iterator.next());
            while (iterator.hasNext()) {
                invoke2 = selector.invoke(iterator.next());
                if (invoke.compareTo((Comparable)invoke2) < 0) {
                }
                invoke = invoke2;
            }
            return invoke;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private static final <K, V, R extends Comparable<? super R>> R maxOfOrNull(Map<? extends K, ? extends V> $this$maxOfOrNull, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object obj;
        Object invoke;
        boolean invoke2;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$maxOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$maxOfOrNull.entrySet().iterator();
        if (!iterator.hasNext()) {
            obj = 0;
        } else {
            invoke = selector.invoke(iterator.next());
            while (iterator.hasNext()) {
                invoke2 = selector.invoke(iterator.next());
                if (invoke.compareTo((Comparable)invoke2) < 0) {
                }
                invoke = invoke2;
            }
            obj = invoke;
        }
        return obj;
    }

    private static final <K, V> Double maxOfOrNull(Map<? extends K, ? extends V> $this$maxOfOrNull, Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        int valueOf;
        boolean doubleValue2;
        boolean doubleValue;
        Intrinsics.checkNotNullParameter($this$maxOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$maxOfOrNull.entrySet().iterator();
        if (!iterator.hasNext()) {
            valueOf = 0;
        } else {
            doubleValue2 = (Number)selector.invoke(iterator.next()).doubleValue();
            for (Object next2 : iterator) {
                doubleValue2 = Math.max(doubleValue2, obj2);
            }
            valueOf = Double.valueOf(doubleValue2);
        }
        return valueOf;
    }

    private static final <K, V> Float maxOfOrNull(Map<? extends K, ? extends V> $this$maxOfOrNull, Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        int valueOf;
        boolean floatValue;
        boolean floatValue2;
        Intrinsics.checkNotNullParameter($this$maxOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$maxOfOrNull.entrySet().iterator();
        if (!iterator.hasNext()) {
            valueOf = 0;
        } else {
            floatValue = (Number)selector.invoke(iterator.next()).floatValue();
            for (Object next2 : iterator) {
                floatValue = Math.max(floatValue, (Number)selector.invoke(next2).floatValue());
            }
            valueOf = Float.valueOf(floatValue);
        }
        return valueOf;
    }

    private static final <K, V, R> R maxOfWith(Map<? extends K, ? extends V> $this$maxOfWith, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object invoke2;
        Object invoke;
        int compare;
        Intrinsics.checkNotNullParameter($this$maxOfWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$maxOfWith.entrySet().iterator();
        if (!iterator.hasNext()) {
        } else {
            invoke2 = selector.invoke(iterator.next());
            while (iterator.hasNext()) {
                invoke = selector.invoke(iterator.next());
                if (comparator.compare(invoke2, invoke) < 0) {
                }
                invoke2 = invoke;
            }
            return invoke2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private static final <K, V, R> R maxOfWithOrNull(Map<? extends K, ? extends V> $this$maxOfWithOrNull, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object obj;
        Object invoke;
        boolean invoke2;
        int compare;
        Intrinsics.checkNotNullParameter($this$maxOfWithOrNull, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$maxOfWithOrNull.entrySet().iterator();
        if (!iterator.hasNext()) {
            obj = 0;
        } else {
            invoke = selector.invoke(iterator.next());
            while (iterator.hasNext()) {
                invoke2 = selector.invoke(iterator.next());
                if (comparator.compare(invoke, invoke2) < 0) {
                }
                invoke = invoke2;
            }
            obj = invoke;
        }
        return obj;
    }

    private static final <K, V> Map.Entry<K, V> maxWithOrNull(Map<? extends K, ? extends V> $this$maxWithOrNull, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter($this$maxWithOrNull, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry)CollectionsKt.maxWithOrNull((Iterable)$this$maxWithOrNull.entrySet(), comparator);
    }

    private static final <K, V> Map.Entry<K, V> maxWithOrThrow(Map<? extends K, ? extends V> $this$maxWith, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry)CollectionsKt.maxWithOrThrow((Iterable)$this$maxWith.entrySet(), comparator);
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrNull(Map<? extends K, ? extends V> $this$minByOrNull, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object minElem$iv;
        Object minValue$iv;
        boolean next;
        Object invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$minByOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final int i = 0;
        final Iterator iterator = (Iterable)$this$minByOrNull.entrySet().iterator();
        if (!iterator.hasNext()) {
            minElem$iv = 0;
        } else {
            if (!iterator.hasNext()) {
            } else {
                minValue$iv = selector.invoke(iterator.next());
                Object next3 = iterator.next();
                invoke = selector.invoke(next3);
                do {
                    next3 = iterator.next();
                    invoke = selector.invoke(next3);
                    if (iterator.hasNext()) {
                    }
                    minElem$iv = next3;
                    minValue$iv = invoke;
                } while (minValue$iv.compareTo((Comparable)invoke) > 0);
            }
        }
        return (Map.Entry)minElem$iv;
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrThrow(Map<? extends K, ? extends V> $this$minBy, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object minElem$iv;
        Object minValue$iv;
        boolean next;
        Object invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$minBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final int i = 0;
        final Iterator iterator = (Iterable)$this$minBy.entrySet().iterator();
        if (!iterator.hasNext()) {
        } else {
            if (!iterator.hasNext()) {
            } else {
                minValue$iv = selector.invoke(iterator.next());
                Object next3 = iterator.next();
                invoke = selector.invoke(next3);
                do {
                    next3 = iterator.next();
                    invoke = selector.invoke(next3);
                    if (iterator.hasNext()) {
                    }
                    minElem$iv = next3;
                    minValue$iv = invoke;
                } while (minValue$iv.compareTo((Comparable)invoke) > 0);
            }
            return (Map.Entry)minElem$iv;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private static final <K, V> double minOf(Map<? extends K, ? extends V> $this$minOf, Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        double doubleValue2;
        double doubleValue;
        Intrinsics.checkNotNullParameter($this$minOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$minOf.entrySet().iterator();
        if (!iterator.hasNext()) {
        } else {
            doubleValue2 = (Number)selector.invoke(iterator.next()).doubleValue();
            for (Object next4 : iterator) {
                doubleValue2 = Math.min(doubleValue2, obj2);
            }
            return doubleValue2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private static final <K, V> float minOf(Map<? extends K, ? extends V> $this$minOf, Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        float floatValue2;
        float floatValue;
        Intrinsics.checkNotNullParameter($this$minOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$minOf.entrySet().iterator();
        if (!iterator.hasNext()) {
        } else {
            floatValue2 = (Number)selector.invoke(iterator.next()).floatValue();
            for (Object next4 : iterator) {
                floatValue2 = Math.min(floatValue2, (Number)selector.invoke(next4).floatValue());
            }
            return floatValue2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private static final <K, V, R extends Comparable<? super R>> R minOf(Map<? extends K, ? extends V> $this$minOf, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object invoke2;
        Object invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$minOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$minOf.entrySet().iterator();
        if (!iterator.hasNext()) {
        } else {
            invoke2 = selector.invoke(iterator.next());
            while (iterator.hasNext()) {
                invoke = selector.invoke(iterator.next());
                if (invoke2.compareTo((Comparable)invoke) > 0) {
                }
                invoke2 = invoke;
            }
            return invoke2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private static final <K, V, R extends Comparable<? super R>> R minOfOrNull(Map<? extends K, ? extends V> $this$minOfOrNull, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object obj;
        Object invoke2;
        boolean invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$minOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$minOfOrNull.entrySet().iterator();
        if (!iterator.hasNext()) {
            obj = 0;
        } else {
            invoke2 = selector.invoke(iterator.next());
            while (iterator.hasNext()) {
                invoke = selector.invoke(iterator.next());
                if (invoke2.compareTo((Comparable)invoke) > 0) {
                }
                invoke2 = invoke;
            }
            obj = invoke2;
        }
        return obj;
    }

    private static final <K, V> Double minOfOrNull(Map<? extends K, ? extends V> $this$minOfOrNull, Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        int valueOf;
        boolean doubleValue;
        boolean doubleValue2;
        Intrinsics.checkNotNullParameter($this$minOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$minOfOrNull.entrySet().iterator();
        if (!iterator.hasNext()) {
            valueOf = 0;
        } else {
            doubleValue = (Number)selector.invoke(iterator.next()).doubleValue();
            for (Object next2 : iterator) {
                doubleValue = Math.min(doubleValue, obj2);
            }
            valueOf = Double.valueOf(doubleValue);
        }
        return valueOf;
    }

    private static final <K, V> Float minOfOrNull(Map<? extends K, ? extends V> $this$minOfOrNull, Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        int valueOf;
        boolean floatValue2;
        boolean floatValue;
        Intrinsics.checkNotNullParameter($this$minOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$minOfOrNull.entrySet().iterator();
        if (!iterator.hasNext()) {
            valueOf = 0;
        } else {
            floatValue2 = (Number)selector.invoke(iterator.next()).floatValue();
            for (Object next2 : iterator) {
                floatValue2 = Math.min(floatValue2, (Number)selector.invoke(next2).floatValue());
            }
            valueOf = Float.valueOf(floatValue2);
        }
        return valueOf;
    }

    private static final <K, V, R> R minOfWith(Map<? extends K, ? extends V> $this$minOfWith, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object invoke2;
        Object invoke;
        int compare;
        Intrinsics.checkNotNullParameter($this$minOfWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$minOfWith.entrySet().iterator();
        if (!iterator.hasNext()) {
        } else {
            invoke2 = selector.invoke(iterator.next());
            while (iterator.hasNext()) {
                invoke = selector.invoke(iterator.next());
                if (comparator.compare(invoke2, invoke) > 0) {
                }
                invoke2 = invoke;
            }
            return invoke2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private static final <K, V, R> R minOfWithOrNull(Map<? extends K, ? extends V> $this$minOfWithOrNull, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object obj;
        Object invoke;
        boolean invoke2;
        int compare;
        Intrinsics.checkNotNullParameter($this$minOfWithOrNull, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator iterator = (Iterable)$this$minOfWithOrNull.entrySet().iterator();
        if (!iterator.hasNext()) {
            obj = 0;
        } else {
            invoke = selector.invoke(iterator.next());
            while (iterator.hasNext()) {
                invoke2 = selector.invoke(iterator.next());
                if (comparator.compare(invoke, invoke2) > 0) {
                }
                invoke = invoke2;
            }
            obj = invoke;
        }
        return obj;
    }

    private static final <K, V> Map.Entry<K, V> minWithOrNull(Map<? extends K, ? extends V> $this$minWithOrNull, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter($this$minWithOrNull, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry)CollectionsKt.minWithOrNull((Iterable)$this$minWithOrNull.entrySet(), comparator);
    }

    private static final <K, V> Map.Entry<K, V> minWithOrThrow(Map<? extends K, ? extends V> $this$minWith, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter($this$minWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry)CollectionsKt.minWithOrThrow((Iterable)$this$minWith.entrySet(), comparator);
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> $this$none) {
        Intrinsics.checkNotNullParameter($this$none, "<this>");
        return $this$none.isEmpty();
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> $this$none, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Object next;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter($this$none, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        final int i3 = 1;
        if ($this$none.isEmpty()) {
            return i3;
        }
        Iterator iterator = $this$none.entrySet().iterator();
        for (Map.Entry next : iterator) {
        }
        return i3;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(M $this$onEach, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        Object next;
        Intrinsics.checkNotNullParameter($this$onEach, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        final int i2 = 0;
        Iterator iterator = $this$onEach.entrySet().iterator();
        for (Map.Entry next : iterator) {
            action.invoke(next);
        }
        return $this$onEach;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEachIndexed(M $this$onEachIndexed, Function2<? super Integer, ? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        int i2;
        Object next;
        int i;
        Intrinsics.checkNotNullParameter($this$onEachIndexed, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i3 = 0;
        final int i4 = 0;
        final int i5 = 0;
        i2 = 0;
        final Iterator iterator = (Iterable)$this$onEachIndexed.entrySet().iterator();
        while (iterator.hasNext()) {
            if (i2 < 0) {
            }
            action.invoke(Integer.valueOf(i2), iterator.next());
            i2 = i;
            CollectionsKt.throwIndexOverflow();
        }
        return $this$onEachIndexed;
    }

    public static final <K, V> List<Pair<K, V>> toList(Map<? extends K, ? extends V> $this$toList) {
        Pair pair;
        Object pair2;
        Object value;
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        if ($this$toList.size() == 0) {
            return CollectionsKt.emptyList();
        }
        Iterator iterator = $this$toList.entrySet().iterator();
        if (!iterator.hasNext()) {
            return CollectionsKt.emptyList();
        }
        Object next2 = iterator.next();
        if (!iterator.hasNext()) {
            Pair pair3 = new Pair((Map.Entry)next2.getKey(), next2.getValue());
            return CollectionsKt.listOf(pair3);
        }
        ArrayList arrayList = new ArrayList($this$toList.size());
        pair = new Pair(next2.getKey(), next2.getValue());
        arrayList.add(pair);
        Object next4 = iterator.next();
        pair2 = new Pair((Map.Entry)next4.getKey(), next4.getValue());
        arrayList.add(pair2);
        while (iterator.hasNext() == null) {
            next4 = iterator.next();
            pair2 = new Pair((Map.Entry)next4.getKey(), next4.getValue());
            arrayList.add(pair2);
        }
        return (List)arrayList;
    }
}
