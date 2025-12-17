package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000~\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010&\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010(\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0008\n\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0017\u001a`\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052%\u0008\u0001\u0010\u0006\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\nH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001\u001aX\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032%\u0008\u0001\u0010\u0006\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\nH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u001e\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\u001a1\u0010\u000c\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\rj\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u000e\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003H\u0087\u0008\u001a_\u0010\u000c\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\rj\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u000e\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032*\u0010\u000f\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110\u0010\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011¢\u0006\u0002\u0010\u0012\u001a1\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0014j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u0015\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003H\u0087\u0008\u001a_\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0014j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u0015\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032*\u0010\u000f\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110\u0010\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011¢\u0006\u0002\u0010\u0016\u001a!\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003H\u0087\u0008\u001aO\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032*\u0010\u000f\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110\u0010\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011¢\u0006\u0002\u0010\u0018\u001a!\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0008\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003H\u0087\u0008\u001aO\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0008\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032*\u0010\u000f\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110\u0010\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011¢\u0006\u0002\u0010\u0018\u001a*\u0010\u001a\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001bH\u0087\n¢\u0006\u0002\u0010\u001c\u001a*\u0010\u001d\u001a\u0002H\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001bH\u0087\n¢\u0006\u0002\u0010\u001c\u001a9\u0010\u001e\u001a\u00020\u001f\"\t\u0008\u0000\u0010\u0002¢\u0006\u0002\u0008 \"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010!\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\"\u001a1\u0010#\u001a\u00020\u001f\"\t\u0008\u0000\u0010\u0002¢\u0006\u0002\u0008 *\u000e\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0002\u0008\u00030\u00012\u0006\u0010!\u001a\u0002H\u0002H\u0087\u0008¢\u0006\u0002\u0010\"\u001a7\u0010$\u001a\u00020\u001f\"\u0004\u0008\u0000\u0010\u0002\"\t\u0008\u0001\u0010\u0003¢\u0006\u0002\u0008 *\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010%\u001a\u0002H\u0003H\u0087\u0008¢\u0006\u0002\u0010\"\u001aV\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001b\u0012\u0004\u0012\u00020\u001f0\u0007H\u0086\u0008ø\u0001\u0000\u001aJ\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u001f0\u0007H\u0086\u0008ø\u0001\u0000\u001aV\u0010)\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001b\u0012\u0004\u0012\u00020\u001f0\u0007H\u0086\u0008ø\u0001\u0000\u001aq\u0010*\u001a\u0002H+\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0018\u0008\u0002\u0010+*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u0008*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010,\u001a\u0002H+2\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001b\u0012\u0004\u0012\u00020\u001f0\u0007H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010-\u001aq\u0010.\u001a\u0002H+\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0018\u0008\u0002\u0010+*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u0008*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010,\u001a\u0002H+2\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001b\u0012\u0004\u0012\u00020\u001f0\u0007H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010-\u001aJ\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001f0\u0007H\u0086\u0008ø\u0001\u0000\u001a;\u00100\u001a\u0004\u0018\u0001H\u0003\"\t\u0008\u0000\u0010\u0002¢\u0006\u0002\u0008 \"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010!\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u00101\u001aP\u00102\u001a\u0002H\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010!\u001a\u0002H\u00022\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u0002H\u000304H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u00105\u001aC\u00106\u001a\u0002H\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010!\u001a\u0002H\u00022\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u0002H\u000304H\u0080\u0008ø\u0001\u0000¢\u0006\u0002\u00105\u001aC\u00107\u001a\u0002H\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00082\u0006\u0010!\u001a\u0002H\u00022\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u0002H\u000304H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u00105\u001a1\u00108\u001a\u0002H\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010!\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u00101\u001aL\u00109\u001a\u0002H:\"\u0014\u0008\u0000\u0010+*\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0001*\u0002H:\"\u0004\u0008\u0001\u0010:*\u0002H+2\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u0002H:04H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010;\u001a'\u0010<\u001a\u00020\u001f\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u0008\u001a:\u0010=\u001a\u00020\u001f\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0012\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001H\u0087\u0008\u0082\u0002\u000e\n\u000c\u0008\u0000\u0012\u0002\u0018\u0001\u001a\u0004\u0008\u0003\u0010\u0000\u001a9\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001b0?\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\n\u001a<\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030A0@\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0008H\u0087\n¢\u0006\u0002\u0008B\u001a\\\u0010C\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010:*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010D\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001b\u0012\u0004\u0012\u0002H:0\u0007H\u0086\u0008ø\u0001\u0000\u001aw\u0010E\u001a\u0002H+\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010:\"\u0018\u0008\u0003\u0010+*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H:\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u0008*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010,\u001a\u0002H+2\u001e\u0010D\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001b\u0012\u0004\u0012\u0002H:0\u0007H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\\\u0010F\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H:0\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010:*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010D\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001b\u0012\u0004\u0012\u0002H:0\u0007H\u0086\u0008ø\u0001\u0000\u001aw\u0010G\u001a\u0002H+\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0004\u0008\u0002\u0010:\"\u0018\u0008\u0003\u0010+*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H:0\u0008*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010,\u001a\u0002H+2\u001e\u0010D\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001b\u0012\u0004\u0012\u0002H:0\u0007H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010-\u001a@\u0010H\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010!\u001a\u0002H\u0002H\u0087\u0002¢\u0006\u0002\u0010I\u001aH\u0010H\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000e\u0010J\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0010H\u0087\u0002¢\u0006\u0002\u0010K\u001aA\u0010H\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u0002H\u00020LH\u0087\u0002\u001aA\u0010H\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u0002H\u00020MH\u0087\u0002\u001a2\u0010N\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00082\u0006\u0010!\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010O\u001a:\u0010N\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00082\u000e\u0010J\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0010H\u0087\n¢\u0006\u0002\u0010P\u001a3\u0010N\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00082\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u0002H\u00020LH\u0087\n\u001a3\u0010N\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00082\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u0002H\u00020MH\u0087\n\u001a0\u0010Q\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0000\u001a3\u0010R\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001H\u0087\u0008\u001aT\u0010S\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001a\u0010\u000f\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110\u0010H\u0086\u0002¢\u0006\u0002\u0010T\u001aG\u0010S\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011H\u0086\u0002\u001aM\u0010S\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110LH\u0086\u0002\u001aI\u0010S\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u0010V\u001a\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0086\u0002\u001aM\u0010S\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110MH\u0086\u0002\u001aJ\u0010W\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u00082\u001a\u0010\u000f\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110\u0010H\u0087\n¢\u0006\u0002\u0010X\u001a=\u0010W\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u00082\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011H\u0087\n\u001aC\u0010W\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u00082\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110LH\u0087\n\u001a=\u0010W\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u00082\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\n\u001aC\u0010W\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u00082\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110MH\u0087\n\u001aG\u0010Y\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u00082\u001a\u0010\u000f\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110\u0010¢\u0006\u0002\u0010X\u001a@\u0010Y\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u00082\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110L\u001a@\u0010Y\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u00082\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110M\u001a;\u0010Z\u001a\u0004\u0018\u0001H\u0003\"\t\u0008\u0000\u0010\u0002¢\u0006\u0002\u0008 \"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00082\u0006\u0010!\u001a\u0002H\u0002H\u0087\u0008¢\u0006\u0002\u00101\u001a:\u0010[\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00082\u0006\u0010!\u001a\u0002H\u00022\u0006\u0010%\u001a\u0002H\u0003H\u0087\n¢\u0006\u0002\u0010\\\u001a;\u0010]\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110\u0010¢\u0006\u0002\u0010\u0018\u001aQ\u0010]\u001a\u0002H+\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0018\u0008\u0002\u0010+*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u0008*\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110\u00102\u0006\u0010,\u001a\u0002H+¢\u0006\u0002\u0010^\u001a4\u0010]\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110L\u001aO\u0010]\u001a\u0002H+\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0018\u0008\u0002\u0010+*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u0008*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110L2\u0006\u0010,\u001a\u0002H+¢\u0006\u0002\u0010_\u001a2\u0010]\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aM\u0010]\u001a\u0002H+\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0018\u0008\u0002\u0010+*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u0008*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010,\u001a\u0002H+H\u0007¢\u0006\u0002\u0010`\u001a4\u0010]\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110M\u001aO\u0010]\u001a\u0002H+\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003\"\u0018\u0008\u0002\u0010+*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0006\u0008\u0000\u0012\u0002H\u00030\u0008*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00110M2\u0006\u0010,\u001a\u0002H+¢\u0006\u0002\u0010a\u001a2\u0010b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0008\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001a1\u0010c\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001bH\u0087\u0008\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006d", d2 = {"buildMap", "", "K", "V", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptyMap", "hashMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "linkedMapOf", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "mutableMapOf", "component1", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "contains", "", "Lkotlin/internal/OnlyInputTypes;", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "filter", "predicate", "filterKeys", "filterNot", "filterNotTo", "M", "destination", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "filterTo", "filterValues", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getOrPut", "getValue", "ifEmpty", "R", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "iterator", "", "", "", "mutableIterator", "mapKeys", "transform", "mapKeysTo", "mapValues", "mapValuesTo", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "", "Lkotlin/sequences/Sequence;", "minusAssign", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "orEmpty", "plus", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "pair", "map", "plusAssign", "(Ljava/util/Map;[Lkotlin/Pair;)V", "putAll", "remove", "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "toMap", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "toPair", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
class MapsKt__MapsKt extends kotlin.collections.MapsKt__MapsJVMKt {
    private static final <K, V> Map<K, V> buildMap(int capacity, Function1<? super Map<K, V>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Map mapBuilder = MapsKt.createMapBuilder(capacity);
        builderAction.invoke(mapBuilder);
        return MapsKt.build(mapBuilder);
    }

    private static final <K, V> Map<K, V> buildMap(Function1<? super Map<K, V>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Map mapBuilder = MapsKt.createMapBuilder();
        builderAction.invoke(mapBuilder);
        return MapsKt.build(mapBuilder);
    }

    private static final <K, V> K component1(Map.Entry<? extends K, ? extends V> $this$component1) {
        Intrinsics.checkNotNullParameter($this$component1, "<this>");
        return $this$component1.getKey();
    }

    private static final <K, V> V component2(Map.Entry<? extends K, ? extends V> $this$component2) {
        Intrinsics.checkNotNullParameter($this$component2, "<this>");
        return $this$component2.getValue();
    }

    private static final <K, V> boolean contains(Map<? extends K, ? extends V> $this$contains, K key) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.containsKey(key);
    }

    private static final <K> boolean containsKey(Map<? extends K, ?> $this$containsKey, K key) {
        Intrinsics.checkNotNullParameter($this$containsKey, "<this>");
        return $this$containsKey.containsKey(key);
    }

    private static final <K, V> boolean containsValue(Map<K, ? extends V> $this$containsValue, V value) {
        Intrinsics.checkNotNullParameter($this$containsValue, "<this>");
        return $this$containsValue.containsValue(value);
    }

    public static final <K, V> Map<K, V> emptyMap() {
        final kotlin.collections.EmptyMap iNSTANCE = EmptyMap.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return (Map)iNSTANCE;
    }

    public static final <K, V> Map<K, V> filter(Map<? extends K, ? extends V> $this$filter, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Object next;
        boolean booleanValue;
        Object value;
        Intrinsics.checkNotNullParameter($this$filter, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i2 = 0;
        Iterator iterator = $this$filter.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Boolean)predicate.invoke((Map.Entry)next).booleanValue()) {
            }
            (Map)linkedHashMap.put(next.getKey(), next.getValue());
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> filterKeys(Map<? extends K, ? extends V> $this$filterKeys, Function1<? super K, Boolean> predicate) {
        Object next;
        boolean booleanValue;
        Object value;
        Intrinsics.checkNotNullParameter($this$filterKeys, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = $this$filterKeys.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Boolean)predicate.invoke((Map.Entry)next.getKey()).booleanValue()) {
            }
            linkedHashMap.put(next.getKey(), next.getValue());
        }
        return (Map)linkedHashMap;
    }

    public static final <K, V> Map<K, V> filterNot(Map<? extends K, ? extends V> $this$filterNot, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Object next;
        boolean booleanValue;
        Object value;
        Intrinsics.checkNotNullParameter($this$filterNot, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i2 = 0;
        Iterator iterator = $this$filterNot.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!(Boolean)predicate.invoke((Map.Entry)next).booleanValue()) {
            }
            (Map)linkedHashMap.put(next.getKey(), next.getValue());
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(Map<? extends K, ? extends V> $this$filterNotTo, M destination, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Object next;
        boolean booleanValue;
        Object value;
        Intrinsics.checkNotNullParameter($this$filterNotTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        Iterator iterator = $this$filterNotTo.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!(Boolean)predicate.invoke((Map.Entry)next).booleanValue()) {
            }
            destination.put(next.getKey(), next.getValue());
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(Map<? extends K, ? extends V> $this$filterTo, M destination, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Object next;
        boolean booleanValue;
        Object value;
        Intrinsics.checkNotNullParameter($this$filterTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        Iterator iterator = $this$filterTo.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Boolean)predicate.invoke((Map.Entry)next).booleanValue()) {
            }
            destination.put(next.getKey(), next.getValue());
        }
        return destination;
    }

    public static final <K, V> Map<K, V> filterValues(Map<? extends K, ? extends V> $this$filterValues, Function1<? super V, Boolean> predicate) {
        Object next;
        boolean booleanValue;
        Object value;
        Intrinsics.checkNotNullParameter($this$filterValues, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = $this$filterValues.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Boolean)predicate.invoke((Map.Entry)next.getValue()).booleanValue()) {
            }
            linkedHashMap.put(next.getKey(), next.getValue());
        }
        return (Map)linkedHashMap;
    }

    private static final <K, V> V get(Map<? extends K, ? extends V> $this$get, K key) {
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        return $this$get.get(key);
    }

    private static final <K, V> V getOrElse(Map<K, ? extends V> $this$getOrElse, K key, Function0<? extends V> defaultValue) {
        Object invoke;
        Intrinsics.checkNotNullParameter($this$getOrElse, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if ($this$getOrElse.get(key) == null) {
            invoke = defaultValue.invoke();
        }
        return invoke;
    }

    public static final <K, V> V getOrElseNullable(Map<K, ? extends V> $this$getOrElseNullable, K key, Function0<? extends V> defaultValue) {
        boolean key2;
        Intrinsics.checkNotNullParameter($this$getOrElseNullable, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i = 0;
        final Object obj = $this$getOrElseNullable.get(key);
        if (obj == null && !$this$getOrElseNullable.containsKey(key)) {
            if (!$this$getOrElseNullable.containsKey(key)) {
                return defaultValue.invoke();
            }
        }
        return obj;
    }

    public static final <K, V> V getOrPut(Map<K, V> $this$getOrPut, K key, Function0<? extends V> defaultValue) {
        Object invoke;
        Intrinsics.checkNotNullParameter($this$getOrPut, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i = 0;
        final Object obj = $this$getOrPut.get(key);
        if (obj == null) {
            $this$getOrPut.put(key, defaultValue.invoke());
        } else {
            invoke = obj;
        }
        return invoke;
    }

    public static final <K, V> V getValue(Map<K, ? extends V> $this$getValue, K key) {
        Intrinsics.checkNotNullParameter($this$getValue, "<this>");
        return MapsKt.getOrImplicitDefaultNullable($this$getValue, key);
    }

    private static final <K, V> HashMap<K, V> hashMapOf() {
        HashMap hashMap = new HashMap();
        return hashMap;
    }

    public static final <K, V> HashMap<K, V> hashMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        HashMap hashMap = new HashMap(MapsKt.mapCapacity(pairs.length));
        final int i = 0;
        MapsKt.putAll((Map)hashMap, pairs);
        return hashMap;
    }

    private static final <M extends Map<?, ?> & R, R> R ifEmpty(M $this$ifEmpty, Function0<? extends R> defaultValue) {
        Object invoke;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if ($this$ifEmpty.isEmpty()) {
            invoke = defaultValue.invoke();
        } else {
            invoke = $this$ifEmpty;
        }
        return invoke;
    }

    private static final <K, V> boolean isNotEmpty(Map<? extends K, ? extends V> $this$isNotEmpty) {
        Intrinsics.checkNotNullParameter($this$isNotEmpty, "<this>");
        return empty ^= 1;
    }

    private static final <K, V> boolean isNullOrEmpty(Map<? extends K, ? extends V> $this$isNullOrEmpty) {
        int i;
        boolean empty;
        if ($this$isNullOrEmpty != null) {
            if ($this$isNullOrEmpty.isEmpty()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final <K, V> Iterator<Map.Entry<K, V>> iterator(Map<? extends K, ? extends V> $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        return $this$iterator.entrySet().iterator();
    }

    private static final <K, V> LinkedHashMap<K, V> linkedMapOf() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return linkedHashMap;
    }

    public static final <K, V> LinkedHashMap<K, V> linkedMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(pairs.length));
        return (LinkedHashMap)MapsKt.toMap(pairs, (Map)linkedHashMap);
    }

    public static final <K, V, R> Map<R, V> mapKeys(Map<? extends K, ? extends V> $this$mapKeys, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Object next;
        Object invoke;
        Object it$iv;
        int i;
        Intrinsics.checkNotNullParameter($this$mapKeys, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i2 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys.size()));
        final int i3 = 0;
        final int i4 = 0;
        final Iterator iterator = (Iterable)$this$mapKeys.entrySet().iterator();
        for (Object next : iterator) {
            i = 0;
            (Map)linkedHashMap.put(transform.invoke(next), (Map.Entry)next.getValue());
        }
        return linkedHashMap;
    }

    public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(Map<? extends K, ? extends V> $this$mapKeysTo, M destination, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Object next;
        Object invoke;
        Object it;
        int i;
        Intrinsics.checkNotNullParameter($this$mapKeysTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i2 = 0;
        final int i3 = 0;
        final Iterator iterator = (Iterable)$this$mapKeysTo.entrySet().iterator();
        for (Object next : iterator) {
            i = 0;
            destination.put(transform.invoke(next), (Map.Entry)next.getValue());
        }
        return destination;
    }

    private static final <K, V> Map<K, V> mapOf() {
        return MapsKt.emptyMap();
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... pairs) {
        Map emptyMap;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        if (pairs.length > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(pairs.length));
            emptyMap = MapsKt.toMap(pairs, (Map)linkedHashMap);
        } else {
            emptyMap = MapsKt.emptyMap();
        }
        return emptyMap;
    }

    public static final <K, V, R> Map<K, R> mapValues(Map<? extends K, ? extends V> $this$mapValues, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Object next;
        Object it$iv;
        Object invoke;
        Intrinsics.checkNotNullParameter($this$mapValues, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues.size()));
        final int i2 = 0;
        final int i3 = 0;
        final Iterator iterator = (Iterable)$this$mapValues.entrySet().iterator();
        for (Object next : iterator) {
            int i4 = 0;
            (Map)linkedHashMap.put((Map.Entry)next.getKey(), transform.invoke(next));
        }
        return linkedHashMap;
    }

    public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(Map<? extends K, ? extends V> $this$mapValuesTo, M destination, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Object next;
        Object it;
        Object invoke;
        Intrinsics.checkNotNullParameter($this$mapValuesTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i = 0;
        final int i2 = 0;
        final Iterator iterator = (Iterable)$this$mapValuesTo.entrySet().iterator();
        for (Object next : iterator) {
            int i3 = 0;
            destination.put((Map.Entry)next.getKey(), transform.invoke(next));
        }
        return destination;
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> $this$minus, Iterable<? extends K> keys) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Map mutableMap = MapsKt.toMutableMap($this$minus);
        final int i = 0;
        CollectionsKt.removeAll((Collection)mutableMap.keySet(), keys);
        return MapsKt.optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> $this$minus, K key) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Map mutableMap = MapsKt.toMutableMap($this$minus);
        final int i = 0;
        mutableMap.remove(key);
        return MapsKt.optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> $this$minus, Sequence<? extends K> keys) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Map mutableMap = MapsKt.toMutableMap($this$minus);
        final int i = 0;
        CollectionsKt.removeAll((Collection)mutableMap.keySet(), keys);
        return MapsKt.optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> $this$minus, K[] keys) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Map mutableMap = MapsKt.toMutableMap($this$minus);
        final int i = 0;
        CollectionsKt.removeAll((Collection)mutableMap.keySet(), keys);
        return MapsKt.optimizeReadOnlyMap(mutableMap);
    }

    private static final <K, V> void minusAssign(Map<K, V> $this$minusAssign, Iterable<? extends K> keys) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        CollectionsKt.removeAll((Collection)$this$minusAssign.keySet(), keys);
    }

    private static final <K, V> void minusAssign(Map<K, V> $this$minusAssign, K key) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        $this$minusAssign.remove(key);
    }

    private static final <K, V> void minusAssign(Map<K, V> $this$minusAssign, Sequence<? extends K> keys) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        CollectionsKt.removeAll((Collection)$this$minusAssign.keySet(), keys);
    }

    private static final <K, V> void minusAssign(Map<K, V> $this$minusAssign, K[] keys) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        CollectionsKt.removeAll((Collection)$this$minusAssign.keySet(), keys);
    }

    private static final <K, V> Iterator<Map.Entry<K, V>> mutableIterator(Map<K, V> $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        return $this$iterator.entrySet().iterator();
    }

    private static final <K, V> Map<K, V> mutableMapOf() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return (Map)linkedHashMap;
    }

    public static final <K, V> Map<K, V> mutableMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(pairs.length));
        final int i = 0;
        MapsKt.putAll((Map)linkedHashMap, pairs);
        return (Map)linkedHashMap;
    }

    public static final <K, V> Map<K, V> optimizeReadOnlyMap(Map<K, ? extends V> $this$optimizeReadOnlyMap) {
        Object singletonMap;
        Intrinsics.checkNotNullParameter($this$optimizeReadOnlyMap, "<this>");
        switch (size) {
            case 0:
                singletonMap = MapsKt.emptyMap();
                break;
            case 1:
                singletonMap = MapsKt.toSingletonMap($this$optimizeReadOnlyMap);
                break;
            default:
                singletonMap = $this$optimizeReadOnlyMap;
        }
        return singletonMap;
    }

    private static final <K, V> Map<K, V> orEmpty(Map<K, ? extends V> $this$orEmpty) {
        Map emptyMap;
        if ($this$orEmpty == null) {
            emptyMap = MapsKt.emptyMap();
        } else {
            emptyMap = $this$orEmpty;
        }
        return emptyMap;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> $this$plus, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Object linkedHashMap;
        LinkedHashMap map;
        int i;
        LinkedHashMap map2;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        if ($this$plus.isEmpty()) {
            linkedHashMap = MapsKt.toMap(pairs);
        } else {
            linkedHashMap = new LinkedHashMap($this$plus);
            i = 0;
            MapsKt.putAll((Map)linkedHashMap, pairs);
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> $this$plus, Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap($this$plus);
        final int i = 0;
        linkedHashMap.putAll(map);
        return (Map)linkedHashMap;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> $this$plus, Pair<? extends K, ? extends V> pair) {
        Object linkedHashMap;
        LinkedHashMap map;
        int i;
        Object first;
        Object second;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pair, "pair");
        if ($this$plus.isEmpty()) {
            linkedHashMap = MapsKt.mapOf(pair);
        } else {
            linkedHashMap = new LinkedHashMap($this$plus);
            i = 0;
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> $this$plus, Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap($this$plus);
        final int i = 0;
        MapsKt.putAll((Map)linkedHashMap, pairs);
        return MapsKt.optimizeReadOnlyMap((Map)linkedHashMap);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> $this$plus, Pair<? extends K, ? extends V>[] pairs) {
        Object linkedHashMap;
        LinkedHashMap map2;
        int i;
        LinkedHashMap map;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        if ($this$plus.isEmpty()) {
            linkedHashMap = MapsKt.toMap(pairs);
        } else {
            linkedHashMap = new LinkedHashMap($this$plus);
            i = 0;
            MapsKt.putAll((Map)linkedHashMap, pairs);
        }
        return linkedHashMap;
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> $this$plusAssign, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        MapsKt.putAll($this$plusAssign, pairs);
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> $this$plusAssign, Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        $this$plusAssign.putAll(map);
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> $this$plusAssign, Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(pair, "pair");
        $this$plusAssign.put(pair.getFirst(), pair.getSecond());
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> $this$plusAssign, Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        MapsKt.putAll($this$plusAssign, pairs);
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> $this$plusAssign, Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        MapsKt.putAll($this$plusAssign, pairs);
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> $this$putAll, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Object component2;
        Object component1;
        Intrinsics.checkNotNullParameter($this$putAll, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        Iterator iterator = pairs.iterator();
        for (Pair next2 : iterator) {
            $this$putAll.put(next2.component1(), next2.component2());
        }
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> $this$putAll, Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Object component2;
        Object component1;
        Intrinsics.checkNotNullParameter($this$putAll, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        Iterator iterator = pairs.iterator();
        for (Pair next2 : iterator) {
            $this$putAll.put(next2.component1(), next2.component2());
        }
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> $this$putAll, Pair<? extends K, ? extends V>[] pairs) {
        int i;
        Object component2;
        Object component1;
        Intrinsics.checkNotNullParameter($this$putAll, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        i = 0;
        while (i < pairs.length) {
            Object obj = pairs[i];
            $this$putAll.put(obj.component1(), obj.component2());
            i++;
        }
    }

    private static final <K, V> V remove(Map<? extends K, V> $this$remove, K key) {
        Intrinsics.checkNotNullParameter($this$remove, "<this>");
        return TypeIntrinsics.asMutableMap($this$remove).remove(key);
    }

    private static final <K, V> void set(Map<K, V> $this$set, K key, V value) {
        Intrinsics.checkNotNullParameter($this$set, "<this>");
        $this$set.put(key, value);
    }

    public static final <K, V> Map<K, V> toMap(Iterable<? extends Pair<? extends K, ? extends V>> $this$toMap) {
        Object next;
        Map emptyMap;
        int mapCapacity;
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        if ($this$toMap instanceof Collection != null) {
            switch (size) {
                case 0:
                    emptyMap = MapsKt.emptyMap();
                    break;
                case 1:
                    next = (List)$this$toMap.get(0);
                    next = $this$toMap.iterator().next();
                    emptyMap = MapsKt.mapOf((Pair)next);
                    break;
                default:
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity((Collection)$this$toMap.size()));
                    emptyMap = MapsKt.toMap($this$toMap, (Map)linkedHashMap2);
            }
            return emptyMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap($this$toMap, (Map)linkedHashMap));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends Pair<? extends K, ? extends V>> $this$toMap, M destination) {
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        final int i = 0;
        MapsKt.putAll(destination, $this$toMap);
        return destination;
    }

    public static final <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> $this$toMap) {
        Map singletonMap;
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        switch (size) {
            case 0:
                singletonMap = MapsKt.emptyMap();
                break;
            case 1:
                singletonMap = MapsKt.toSingletonMap($this$toMap);
                break;
            default:
                singletonMap = MapsKt.toMutableMap($this$toMap);
        }
        return singletonMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Map<? extends K, ? extends V> $this$toMap, M destination) {
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        final int i = 0;
        destination.putAll($this$toMap);
        return destination;
    }

    public static final <K, V> Map<K, V> toMap(Sequence<? extends Pair<? extends K, ? extends V>> $this$toMap) {
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap($this$toMap, (Map)linkedHashMap));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Sequence<? extends Pair<? extends K, ? extends V>> $this$toMap, M destination) {
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        final int i = 0;
        MapsKt.putAll(destination, $this$toMap);
        return destination;
    }

    public static final <K, V> Map<K, V> toMap(Pair<? extends K, ? extends V>[] $this$toMap) {
        Map emptyMap;
        int mapCapacity;
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        switch (length) {
            case 0:
                emptyMap = MapsKt.emptyMap();
                break;
            case 1:
                emptyMap = MapsKt.mapOf($this$toMap[0]);
                break;
            default:
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity($this$toMap.length));
                emptyMap = MapsKt.toMap($this$toMap, (Map)linkedHashMap);
        }
        return emptyMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Pair<? extends K, ? extends V>[] $this$toMap, M destination) {
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        final int i = 0;
        MapsKt.putAll(destination, $this$toMap);
        return destination;
    }

    public static final <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> $this$toMutableMap) {
        Intrinsics.checkNotNullParameter($this$toMutableMap, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap($this$toMutableMap);
        return (Map)linkedHashMap;
    }

    private static final <K, V> Pair<K, V> toPair(Map.Entry<? extends K, ? extends V> $this$toPair) {
        Intrinsics.checkNotNullParameter($this$toPair, "<this>");
        Pair pair = new Pair($this$toPair.getKey(), $this$toPair.getValue());
        return pair;
    }
}
