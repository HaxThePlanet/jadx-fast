package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001c\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001aq\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0003\u0018\u0001\"\u0004\u0008\u0001\u0010\u00022\u001e\u0010\u0004\u001a\u0010\u0012\u000c\u0008\u0001\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u00010\u0005\"\u0008\u0012\u0004\u0012\u0002H\u00030\u00012*\u0008\u0004\u0010\u0006\u001a$\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\n\u001ae\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0003\u0018\u0001\"\u0004\u0008\u0001\u0010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u00010\u000b2*\u0008\u0004\u0010\u0006\u001a$\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u000c\u001aº\u0001\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u000e\"\u0004\u0008\u0002\u0010\u000f\"\u0004\u0008\u0003\u0010\u0010\"\u0004\u0008\u0004\u0010\u0011\"\u0004\u0008\u0005\u0010\u00022\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u00012\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00012\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u00012\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u00012\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00110\u00012:\u0010\u0006\u001a6\u0008\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a \u0001\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u000e\"\u0004\u0008\u0002\u0010\u000f\"\u0004\u0008\u0003\u0010\u0010\"\u0004\u0008\u0004\u0010\u00022\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u00012\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00012\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u00012\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u000124\u0010\u0006\u001a0\u0008\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0019ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0088\u0001\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u000e\"\u0004\u0008\u0002\u0010\u000f\"\u0004\u0008\u0003\u0010\u00022\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u00012\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00012\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u000120\u0008\u0001\u0010\u0006\u001a*\u0008\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u008a\u0001\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u000e\"\u0004\u0008\u0002\u0010\u00022\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u00012\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00012F\u0010\u0006\u001aB\u0008\u0001\u0012\u0013\u0012\u0011H\r¢\u0006\u000c\u0008\u001e\u0012\u0008\u0008\u001f\u0012\u0004\u0008\u0008( \u0012\u0013\u0012\u0011H\u000e¢\u0006\u000c\u0008\u001e\u0012\u0008\u0008\u001f\u0012\u0004\u0008\u0008(!\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001dø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u0082\u0001\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0003\u0018\u0001\"\u0004\u0008\u0001\u0010\u00022\u001e\u0010\u0004\u001a\u0010\u0012\u000c\u0008\u0001\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u00010\u0005\"\u0008\u0012\u0004\u0012\u0002H\u00030\u00012;\u0008\u0005\u0010\u0006\u001a5\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020%0\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d¢\u0006\u0002\u0008&H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010'\u001av\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0003\u0018\u0001\"\u0004\u0008\u0001\u0010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u00010\u000b2;\u0008\u0005\u0010\u0006\u001a5\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020%0\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d¢\u0006\u0002\u0008&H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010(\u001aÍ\u0001\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u000e\"\u0004\u0008\u0002\u0010\u000f\"\u0004\u0008\u0003\u0010\u0010\"\u0004\u0008\u0004\u0010\u0011\"\u0004\u0008\u0005\u0010\u00022\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u00012\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00012\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u00012\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u00012\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00110\u00012M\u0008\u0001\u0010\u0006\u001aG\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020$\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020%0\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0)¢\u0006\u0002\u0008&ø\u0001\u0000¢\u0006\u0002\u0010*\u001a³\u0001\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u000e\"\u0004\u0008\u0002\u0010\u000f\"\u0004\u0008\u0003\u0010\u0010\"\u0004\u0008\u0004\u0010\u00022\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u00012\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00012\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u00012\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u00012G\u0008\u0001\u0010\u0006\u001aA\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020$\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020%0\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0017¢\u0006\u0002\u0008&ø\u0001\u0000¢\u0006\u0002\u0010+\u001a\u0099\u0001\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u000e\"\u0004\u0008\u0002\u0010\u000f\"\u0004\u0008\u0003\u0010\u00022\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u00012\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00012\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u00012A\u0008\u0001\u0010\u0006\u001a;\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020$\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020%0\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0019¢\u0006\u0002\u0008&ø\u0001\u0000¢\u0006\u0002\u0010,\u001a\u009d\u0001\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u000e\"\u0004\u0008\u0002\u0010\u00022\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u00012\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00012Y\u0008\u0001\u0010\u0006\u001aS\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020$\u0012\u0013\u0012\u0011H\r¢\u0006\u000c\u0008\u001e\u0012\u0008\u0008\u001f\u0012\u0004\u0008\u0008( \u0012\u0013\u0012\u0011H\u000e¢\u0006\u000c\u0008\u001e\u0012\u0008\u0008\u001f\u0012\u0004\u0008\u0008(!\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020%0\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001b¢\u0006\u0002\u0008&ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\u0084\u0001\u0010.\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0003\u0018\u0001\"\u0004\u0008\u0001\u0010\u00022\u001e\u0010\u0004\u001a\u0010\u0012\u000c\u0008\u0001\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u00010\u0005\"\u0008\u0012\u0004\u0012\u0002H\u00030\u00012;\u0008\u0005\u0010\u0006\u001a5\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020%0\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d¢\u0006\u0002\u0008&H\u0082\u0008ø\u0001\u0000¢\u0006\u0004\u0008/\u0010'\u001as\u00100\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0003\u0018\u0001\"\u0004\u0008\u0001\u0010\u00022\u001e\u0010\u0004\u001a\u0010\u0012\u000c\u0008\u0001\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u00010\u0005\"\u0008\u0012\u0004\u0012\u0002H\u00030\u00012*\u0008\u0004\u0010\u0006\u001a$\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0082\u0008ø\u0001\u0000¢\u0006\u0004\u00081\u0010\n\u001a!\u00102\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u000503\"\u0004\u0008\u0000\u0010\u0003H\u0002¢\u0006\u0002\u00084\u001a\u008a\u0001\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u000e\"\u0004\u0008\u0002\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\r0\u00012\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00012F\u0010\u0006\u001aB\u0008\u0001\u0012\u0013\u0012\u0011H\r¢\u0006\u000c\u0008\u001e\u0012\u0008\u0008\u001f\u0012\u0004\u0008\u0008( \u0012\u0013\u0012\u0011H\u000e¢\u0006\u000c\u0008\u001e\u0012\u0008\u0008\u001f\u0012\u0004\u0008\u0008(!\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\u00085\u0010\"\u001a\u009d\u0001\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u000e\"\u0004\u0008\u0002\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\r0\u00012\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00012Y\u0008\u0001\u0010\u0006\u001aS\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020$\u0012\u0013\u0012\u0011H\r¢\u0006\u000c\u0008\u001e\u0012\u0008\u0008\u001f\u0012\u0004\u0008\u0008( \u0012\u0013\u0012\u0011H\u000e¢\u0006\u000c\u0008\u001e\u0012\u0008\u0008\u001f\u0012\u0004\u0008\u0008(!\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020%0\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001b¢\u0006\u0002\u0008&H\u0007ø\u0001\u0000¢\u0006\u0004\u00086\u0010-\u001ah\u00107\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\r\"\u0004\u0008\u0001\u0010\u000e\"\u0004\u0008\u0002\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\r0\u00012\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\u00012(\u0010\u0006\u001a$\u0008\u0001\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001dø\u0001\u0000¢\u0006\u0002\u0010\"\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00069", d2 = {"combine", "Lkotlinx/coroutines/flow/Flow;", "R", "T", "flows", "", "transform", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "T1", "T2", "T3", "T4", "T5", "flow", "flow2", "flow3", "flow4", "flow5", "Lkotlin/Function6;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "a", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "combineTransform", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function7;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function7;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "combineTransformUnsafe", "combineTransformUnsafe$FlowKt__ZipKt", "combineUnsafe", "combineUnsafe$FlowKt__ZipKt", "nullArrayFactory", "Lkotlin/Function0;", "nullArrayFactory$FlowKt__ZipKt", "flowCombine", "flowCombineTransform", "zip", "other", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ZipKt {
    public static final Function0 access$nullArrayFactory() {
        return FlowKt__ZipKt.nullArrayFactory$FlowKt__ZipKt();
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> combine(Iterable<? extends kotlinx.coroutines.flow.Flow<? extends T>> flows, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> transform) {
        final int i = 0;
        int i2 = 0;
        int i3 = 0;
        Intrinsics.needClassReification();
        FlowKt__ZipKt.combine$$inlined.unsafeFlow.3 anon = new FlowKt__ZipKt.combine$$inlined.unsafeFlow.3((Flow[])(Collection)CollectionsKt.toList(flows).toArray(new Flow[0]), transform);
        return (Flow)anon;
    }

    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> combine(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt.flowCombine(flow, flow2, transform);
    }

    public static final <T1, T2, T3, R> kotlinx.coroutines.flow.Flow<R> combine(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> transform) {
        kotlinx.coroutines.flow.Flow[] arr = new Flow[3];
        int i5 = 0;
        final int i6 = 0;
        FlowKt__ZipKt.combine$$inlined.combineUnsafe.FlowKt__ZipKt.1 anon = new FlowKt__ZipKt.combine$$inlined.combineUnsafe.FlowKt__ZipKt.1(arr, transform);
        return (Flow)anon;
    }

    public static final <T1, T2, T3, T4, R> kotlinx.coroutines.flow.Flow<R> combine(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, kotlinx.coroutines.flow.Flow<? extends T4> flow4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> transform) {
        kotlinx.coroutines.flow.Flow[] arr = new Flow[4];
        int i6 = 0;
        final int i7 = 0;
        FlowKt__ZipKt.combine$$inlined.combineUnsafe.FlowKt__ZipKt.2 anon = new FlowKt__ZipKt.combine$$inlined.combineUnsafe.FlowKt__ZipKt.2(arr, transform);
        return (Flow)anon;
    }

    public static final <T1, T2, T3, T4, T5, R> kotlinx.coroutines.flow.Flow<R> combine(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, kotlinx.coroutines.flow.Flow<? extends T4> flow4, kotlinx.coroutines.flow.Flow<? extends T5> flow5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> transform) {
        kotlinx.coroutines.flow.Flow[] arr = new Flow[5];
        int i7 = 0;
        final int i8 = 0;
        FlowKt__ZipKt.combine$$inlined.combineUnsafe.FlowKt__ZipKt.3 anon = new FlowKt__ZipKt.combine$$inlined.combineUnsafe.FlowKt__ZipKt.3(arr, transform);
        return (Flow)anon;
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> combine(kotlinx.coroutines.flow.Flow<? extends T>[] flows, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> transform) {
        final int i = 0;
        final int i2 = 0;
        Intrinsics.needClassReification();
        FlowKt__ZipKt.combine$$inlined.unsafeFlow.2 anon = new FlowKt__ZipKt.combine$$inlined.unsafeFlow.2(flows, transform);
        return (Flow)anon;
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> combineTransform(Iterable<? extends kotlinx.coroutines.flow.Flow<? extends T>> flows, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> transform) {
        final int i = 0;
        int i2 = 0;
        Intrinsics.needClassReification();
        FlowKt__ZipKt.combineTransform.7 anon = new FlowKt__ZipKt.combineTransform.7((Flow[])(Collection)CollectionsKt.toList(flows).toArray(new Flow[0]), transform, 0);
        return FlowKt.flow((Function2)anon);
    }

    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> combineTransform(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, Function4<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> transform) {
        kotlinx.coroutines.flow.Flow[] arr = new Flow[2];
        int i4 = 0;
        FlowKt__ZipKt.combineTransform$$inlined.combineTransformUnsafe.FlowKt__ZipKt.2 anon = new FlowKt__ZipKt.combineTransform$$inlined.combineTransformUnsafe.FlowKt__ZipKt.2(arr, 0, transform);
        return FlowKt.flow((Function2)anon);
    }

    public static final <T1, T2, T3, R> kotlinx.coroutines.flow.Flow<R> combineTransform(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, Function5<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> transform) {
        kotlinx.coroutines.flow.Flow[] arr = new Flow[3];
        int i5 = 0;
        FlowKt__ZipKt.combineTransform$$inlined.combineTransformUnsafe.FlowKt__ZipKt.3 anon = new FlowKt__ZipKt.combineTransform$$inlined.combineTransformUnsafe.FlowKt__ZipKt.3(arr, 0, transform);
        return FlowKt.flow((Function2)anon);
    }

    public static final <T1, T2, T3, T4, R> kotlinx.coroutines.flow.Flow<R> combineTransform(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, kotlinx.coroutines.flow.Flow<? extends T4> flow4, Function6<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> transform) {
        kotlinx.coroutines.flow.Flow[] arr = new Flow[4];
        int i6 = 0;
        FlowKt__ZipKt.combineTransform$$inlined.combineTransformUnsafe.FlowKt__ZipKt.4 anon = new FlowKt__ZipKt.combineTransform$$inlined.combineTransformUnsafe.FlowKt__ZipKt.4(arr, 0, transform);
        return FlowKt.flow((Function2)anon);
    }

    public static final <T1, T2, T3, T4, T5, R> kotlinx.coroutines.flow.Flow<R> combineTransform(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlinx.coroutines.flow.Flow<? extends T2> flow2, kotlinx.coroutines.flow.Flow<? extends T3> flow3, kotlinx.coroutines.flow.Flow<? extends T4> flow4, kotlinx.coroutines.flow.Flow<? extends T5> flow5, Function7<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> transform) {
        kotlinx.coroutines.flow.Flow[] arr = new Flow[5];
        int i7 = 0;
        FlowKt__ZipKt.combineTransform$$inlined.combineTransformUnsafe.FlowKt__ZipKt.5 anon = new FlowKt__ZipKt.combineTransform$$inlined.combineTransformUnsafe.FlowKt__ZipKt.5(arr, 0, transform);
        return FlowKt.flow((Function2)anon);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> combineTransform(kotlinx.coroutines.flow.Flow<? extends T>[] flows, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> transform) {
        final int i = 0;
        Intrinsics.needClassReification();
        FlowKt__ZipKt.combineTransform.6 anon = new FlowKt__ZipKt.combineTransform.6(flows, transform, 0);
        return FlowKt.flow((Function2)anon);
    }

    private static final <T, R> kotlinx.coroutines.flow.Flow<R> combineTransformUnsafe$FlowKt__ZipKt(kotlinx.coroutines.flow.Flow<? extends T>[] flows, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> transform) {
        final int i = 0;
        Intrinsics.needClassReification();
        FlowKt__ZipKt.combineTransformUnsafe.1 anon = new FlowKt__ZipKt.combineTransformUnsafe.1(flows, transform, 0);
        return FlowKt.flow((Function2)anon);
    }

    private static final <T, R> kotlinx.coroutines.flow.Flow<R> combineUnsafe$FlowKt__ZipKt(kotlinx.coroutines.flow.Flow<? extends T>[] flows, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> transform) {
        final int i = 0;
        final int i2 = 0;
        Intrinsics.needClassReification();
        FlowKt__ZipKt.combineUnsafe$$inlined.unsafeFlow.1 anon = new FlowKt__ZipKt.combineUnsafe$$inlined.unsafeFlow.1(flows, transform);
        return (Flow)anon;
    }

    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> flowCombine(kotlinx.coroutines.flow.Flow<? extends T1> $this$combine, kotlinx.coroutines.flow.Flow<? extends T2> flow, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform) {
        final int i = 0;
        FlowKt__ZipKt.combine$$inlined.unsafeFlow.1 anon = new FlowKt__ZipKt.combine$$inlined.unsafeFlow.1($this$combine, flow, transform);
        return (Flow)anon;
    }

    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> flowCombineTransform(kotlinx.coroutines.flow.Flow<? extends T1> $this$combineTransform, kotlinx.coroutines.flow.Flow<? extends T2> flow, Function4<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> transform) {
        kotlinx.coroutines.flow.Flow[] arr = new Flow[2];
        int i4 = 0;
        FlowKt__ZipKt.combineTransform$$inlined.combineTransformUnsafe.FlowKt__ZipKt.1 anon = new FlowKt__ZipKt.combineTransform$$inlined.combineTransformUnsafe.FlowKt__ZipKt.1(arr, 0, transform);
        return FlowKt.flow((Function2)anon);
    }

    private static final <T> Function0<T[]> nullArrayFactory$FlowKt__ZipKt() {
        return (Function0)FlowKt__ZipKt.nullArrayFactory.1.INSTANCE;
    }

    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> zip(kotlinx.coroutines.flow.Flow<? extends T1> $this$zip, kotlinx.coroutines.flow.Flow<? extends T2> other, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform) {
        return CombineKt.zipImpl($this$zip, other, transform);
    }
}
