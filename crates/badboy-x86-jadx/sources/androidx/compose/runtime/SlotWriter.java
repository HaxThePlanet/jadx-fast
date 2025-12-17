package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0008J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000 È\u00012\u00020\u0001:\u0002È\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\rJ\u0010\u0010D\u001a\u00020\u00072\u0008\u0008\u0002\u0010E\u001a\u00020\rJ\u000e\u0010F\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0007J\u0018\u0010G\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00072\u0008\u0010H\u001a\u0004\u0018\u00010\u0001J\u0006\u0010I\u001a\u00020BJ\u0006\u0010J\u001a\u00020BJ\u0010\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\rH\u0002J\u0008\u0010M\u001a\u00020BH\u0002J\u000e\u0010N\u001a\u00020B2\u0006\u0010O\u001a\u00020\u0011J\u0010\u0010P\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\rH\u0002J\u0010\u0010Q\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\rH\u0002J \u0010R\u001a\u00020\r2\u0006\u0010D\u001a\u00020\r2\u0006\u0010S\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0010\u0010T\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rH\u0002J\u0010\u0010U\u001a\u00020\r2\u0006\u0010T\u001a\u00020\rH\u0002J(\u0010V\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010W\u001a\u00020\r2\u0006\u0010S\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0006\u0010X\u001a\u00020\rJ\u0006\u0010Y\u001a\u00020BJ\u000e\u0010Z\u001a\u00020B2\u0006\u0010D\u001a\u00020\u0007J\u000e\u0010Z\u001a\u00020B2\u0006\u0010E\u001a\u00020\rJ \u0010[\u001a\u00020B2\u0006\u0010,\u001a\u00020\r2\u0006\u0010X\u001a\u00020\r2\u0006\u0010\\\u001a\u00020\rH\u0002JK\u0010]\u001a\u00020B2\u0006\u0010L\u001a\u00020\r28\u0010^\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\u000c\u0008`\u0012\u0008\u0008a\u0012\u0004\u0008\u0008(E\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008`\u0012\u0008\u0008a\u0012\u0004\u0008\u0008(b\u0012\u0004\u0012\u00020B0_H\u0086\u0008JK\u0010c\u001a\u00020B2\u0006\u0010L\u001a\u00020\r28\u0010^\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\u000c\u0008`\u0012\u0008\u0008a\u0012\u0004\u0008\u0008(E\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008`\u0012\u0008\u0008a\u0012\u0004\u0008\u0008(b\u0012\u0004\u0012\u00020B0_H\u0086\u0008J5\u0010d\u001a\u00020B2\u0006\u0010e\u001a\u00020\r2\u0006\u0010f\u001a\u00020\r2\u001a\u0010^\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020B0_H\u0086\u0008J\u0010\u0010g\u001a\u0004\u0018\u00010\u00012\u0006\u0010E\u001a\u00020\rJ\u0010\u0010h\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rH\u0002J\u000e\u0010i\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rJ\u0010\u0010j\u001a\u0004\u0018\u00010\u00012\u0006\u0010E\u001a\u00020\rJ\u000e\u0010k\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rJ\u000e\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010mJ\u001c\u0010n\u001a\u0004\u0018\u00010<2\u0006\u0010,\u001a\u00020\r2\u0008\u0010o\u001a\u0004\u0018\u00010pH\u0002J\u000e\u0010q\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\rJ\u0016\u0010r\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\r2\u0006\u0010L\u001a\u00020\rJ\u000e\u0010s\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\rJ\u0010\u0010t\u001a\u00020B2\u0008\u0010H\u001a\u0004\u0018\u00010\u0001J\u0010\u0010u\u001a\u00020B2\u0006\u00100\u001a\u00020\rH\u0002J\u0018\u0010v\u001a\u00020B2\u0006\u00100\u001a\u00020\r2\u0006\u0010L\u001a\u00020\rH\u0002J\u000e\u0010)\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\rJ\u000e\u0010w\u001a\u0008\u0012\u0004\u0012\u00020\r0xH\u0002J\u0010\u0010y\u001a\u00020B2\u0008\u0008\u0002\u0010L\u001a\u00020\rJ \u0010z\u001a\u00020B2\u0006\u0010{\u001a\u00020\r2\u0006\u0010|\u001a\u00020\r2\u0006\u00100\u001a\u00020\rH\u0002J&\u0010}\u001a\u0008\u0012\u0004\u0012\u00020\u00070x2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\r2\u0008\u0008\u0002\u0010~\u001a\u00020\u0011J\u000f\u0010\u007f\u001a\u00020B2\u0007\u0010\u0080\u0001\u001a\u00020\rJ\u0011\u0010\u0081\u0001\u001a\u00020B2\u0006\u0010E\u001a\u00020\rH\u0002J&\u0010\u0082\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00070x2\u0007\u0010\u0080\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\rJ\u0019\u0010\u0083\u0001\u001a\u00020B2\u0006\u0010E\u001a\u00020\r2\u0006\u0010L\u001a\u00020\rH\u0002J'\u0010\u0084\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00070x2\u0006\u0010D\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\r2\u0007\u0010\u0085\u0001\u001a\u00020\u0000J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010D\u001a\u00020\u0007J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010E\u001a\u00020\rJ\u000e\u0010*\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0007J\u000e\u0010,\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rJ\u0011\u0010\u0087\u0001\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rH\u0002J\u0019\u0010\u0088\u0001\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010W\u001a\u00020\rH\u0002J\t\u0010\u0089\u0001\u001a\u00020BH\u0002J\u000f\u0010\u008a\u0001\u001a\u00020B2\u0006\u0010o\u001a\u00020pJ\u0007\u0010\u008b\u0001\u001a\u00020BJ\u0018\u0010\u008c\u0001\u001a\u00020B2\u0007\u0010\u008d\u0001\u001a\u00020\r2\u0006\u0010H\u001a\u00020pJA\u0010\u008e\u0001\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\r2\u0006\u00100\u001a\u00020\r2&\u0010:\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020<\u0018\u00010;j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020<\u0018\u0001`=H\u0002J\u0007\u0010\u008f\u0001\u001a\u00020\u0011J\u001b\u0010\u0090\u0001\u001a\u00020\u00112\u0007\u0010\u0091\u0001\u001a\u00020\r2\u0007\u0010\u0092\u0001\u001a\u00020\rH\u0002J#\u0010\u0093\u0001\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u00020\r2\u0007\u0010\u0092\u0001\u001a\u00020\r2\u0006\u0010L\u001a\u00020\rH\u0002J\u0007\u0010\u0094\u0001\u001a\u00020BJ\t\u0010\u0095\u0001\u001a\u00020\rH\u0002J\t\u0010\u0096\u0001\u001a\u00020BH\u0002J\u000f\u0010\u0097\u0001\u001a\u00020B2\u0006\u0010D\u001a\u00020\u0007J\u0011\u0010\u0098\u0001\u001a\u00020B2\u0008\u0010H\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010E\u001a\u00020\r2\u0008\u0010H\u001a\u0004\u0018\u00010\u0001J#\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010L\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0008\u0010H\u001a\u0004\u0018\u00010\u0001J\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010\u009a\u0001\u001a\u00020\rJ\u0007\u0010\u009b\u0001\u001a\u00020BJ\u0019\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\rJ\u0019\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010e\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rJ\u0017\u0010\u009d\u0001\u001a\u00020\r2\u0006\u0010L\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rJ\u0017\u0010\u009e\u0001\u001a\u00020\r2\u0006\u0010e\u001a\u00020\rH\u0000¢\u0006\u0003\u0008\u009f\u0001J\u0017\u0010 \u0001\u001a\u00020\r2\u0006\u0010e\u001a\u00020\rH\u0000¢\u0006\u0003\u0008¡\u0001J\u0017\u0010¢\u0001\u001a\u00020\r2\u0006\u0010e\u001a\u00020\rH\u0000¢\u0006\u0003\u0008£\u0001J\u0013\u0010¤\u0001\u001a\u0004\u0018\u00010<2\u0006\u0010L\u001a\u00020\rH\u0002J\u001b\u0010¥\u0001\u001a\u00020B2\u0007\u0010\u008d\u0001\u001a\u00020\r2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u0001J&\u0010¥\u0001\u001a\u00020B2\u0007\u0010\u008d\u0001\u001a\u00020\r2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010¨\u0001\u001a\u00020BJ\u0010\u0010¨\u0001\u001a\u00020B2\u0007\u0010\u008d\u0001\u001a\u00020\rJ\u001b\u0010¨\u0001\u001a\u00020B2\u0007\u0010\u008d\u0001\u001a\u00020\r2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0001J0\u0010¨\u0001\u001a\u00020B2\u0007\u0010\u008d\u0001\u001a\u00020\r2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010)\u001a\u00020\u00112\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u001b\u0010ª\u0001\u001a\u00020B2\u0007\u0010\u008d\u0001\u001a\u00020\r2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u0001J&\u0010ª\u0001\u001a\u00020B2\u0007\u0010\u008d\u0001\u001a\u00020\r2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010«\u0001\u001a\u00020pJ\t\u0010¬\u0001\u001a\u00020pH\u0016J\u000f\u0010­\u0001\u001a\u00020B2\u0006\u0010f\u001a\u00020\rJ\u0019\u0010®\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010L\u001a\u00020\rH\u0000¢\u0006\u0003\u0008¯\u0001J\u0013\u0010°\u0001\u001a\u0004\u0018\u00010\u00012\u0008\u0010H\u001a\u0004\u0018\u00010\u0001J\u001b\u0010±\u0001\u001a\u00020B2\u0007\u0010²\u0001\u001a\u00020\r2\u0007\u0010³\u0001\u001a\u00020\rH\u0002J\u0011\u0010´\u0001\u001a\u00020B2\u0008\u0010H\u001a\u0004\u0018\u00010\u0001J\u0011\u0010µ\u0001\u001a\u00020B2\u0006\u0010L\u001a\u00020\rH\u0002J\u001a\u0010¶\u0001\u001a\u00020B2\u0006\u0010L\u001a\u00020\r2\u0007\u0010\u0098\u0001\u001a\u00020/H\u0002J\u0019\u0010·\u0001\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00072\u0008\u0010H\u001a\u0004\u0018\u00010\u0001J\u0011\u0010·\u0001\u001a\u00020B2\u0008\u0010H\u001a\u0004\u0018\u00010\u0001J\u001b\u0010¸\u0001\u001a\u00020B2\u0006\u0010E\u001a\u00020\r2\u0008\u0010H\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010¹\u0001\u001a\u00020B2\u0008\u0010H\u001a\u0004\u0018\u00010\u0001J\u0007\u0010º\u0001\u001a\u00020BJ\u000f\u0010»\u0001\u001a\u00020BH\u0000¢\u0006\u0003\u0008¼\u0001J\u000f\u0010½\u0001\u001a\u00020BH\u0000¢\u0006\u0003\u0008¾\u0001J\u0016\u0010¿\u0001\u001a\u00020\r*\u00020&2\u0007\u0010À\u0001\u001a\u00020\rH\u0002J\u0015\u0010T\u001a\u00020\r*\u00020&2\u0007\u0010À\u0001\u001a\u00020\rH\u0002J\u0013\u0010Á\u0001\u001a\u0008\u0012\u0004\u0012\u00020\r0x*\u00020&H\u0002J\u001b\u0010Â\u0001\u001a\u00020B*\u00080Ã\u0001j\u0003`Ä\u00012\u0006\u0010E\u001a\u00020\rH\u0002J\u0016\u0010Å\u0001\u001a\u00020\r*\u00020&2\u0007\u0010À\u0001\u001a\u00020\rH\u0002J\u0014\u0010,\u001a\u00020\r*\u00020&2\u0006\u0010E\u001a\u00020\rH\u0002J\u0016\u0010Æ\u0001\u001a\u00020\r*\u00020&2\u0007\u0010À\u0001\u001a\u00020\rH\u0002J\u001e\u0010Ç\u0001\u001a\u00020B*\u00020&2\u0007\u0010À\u0001\u001a\u00020\r2\u0006\u0010T\u001a\u00020\rH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0014R\u001e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u000fR\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u000fR\u0014\u0010\u001d\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u000fR\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\u0008(\u0010\u0014R\u0011\u0010)\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\u0008)\u0010\u0014R\u000e\u0010*\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u000fR\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00081\u0010\u000fR\u0018\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000103X\u0082\u000e¢\u0006\u0004\n\u0002\u00104R\u000e\u00105\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00108\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u00089\u0010\u000fR.\u0010:\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020<\u0018\u00010;j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020<\u0018\u0001`=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u0010@¨\u0006É\u0001", d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "capacity", "", "getCapacity", "()I", "<set-?>", "", "closed", "getClosed", "()Z", "collectingCalledInformation", "getCollectingCalledInformation", "collectingSourceInformation", "getCollectingSourceInformation", "currentGroup", "getCurrentGroup", "currentGroupEnd", "getCurrentGroupEnd", "currentGroupSlotIndex", "getCurrentGroupSlotIndex", "currentSlot", "currentSlotEnd", "endStack", "Landroidx/compose/runtime/IntStack;", "groupGapLen", "groupGapStart", "groups", "", "insertCount", "isGroupEnd", "isNode", "nodeCount", "nodeCountStack", "parent", "getParent", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "size", "getSize$runtime_release", "slots", "", "[Ljava/lang/Object;", "slotsGapLen", "slotsGapOwner", "slotsGapStart", "slotsSize", "getSlotsSize", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "startStack", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "advanceBy", "", "amount", "anchor", "index", "anchorIndex", "appendSlot", "value", "bashCurrentGroup", "beginInsert", "childContainsAnyMarks", "group", "clearSlotGap", "close", "normalClose", "containsAnyGroupMarks", "containsGroupMark", "dataAnchorToDataIndex", "gapLen", "dataIndex", "dataIndexToDataAddress", "dataIndexToDataAnchor", "gapStart", "endGroup", "endInsert", "ensureStarted", "fixParentAnchorsFor", "firstChild", "forAllData", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "forEachData", "forEachTailSlot", "groupIndex", "count", "groupAux", "groupIndexToAddress", "groupKey", "groupObjectKey", "groupSize", "groupSlots", "", "groupSourceInformationFor", "sourceInformation", "", "indexInCurrentGroup", "indexInGroup", "indexInParent", "insertAux", "insertGroups", "insertSlots", "keys", "", "markGroup", "moveAnchors", "originalLocation", "newLocation", "moveFrom", "removeSourceGroup", "moveGroup", "offset", "moveGroupGapTo", "moveIntoGroupFrom", "moveSlotGapTo", "moveTo", "writer", "node", "parentAnchorToIndex", "parentIndexToAnchor", "recalculateMarks", "recordGroupSourceInformation", "recordGrouplessCallSourceInformationEnd", "recordGrouplessCallSourceInformationStart", "key", "removeAnchors", "removeGroup", "removeGroups", "start", "len", "removeSlots", "reset", "restoreCurrentGroupEnd", "saveCurrentGroupEnd", "seek", "set", "skip", "skipGroup", "skipToGroupEnd", "slot", "slotIndexOfGroupSlotIndex", "slotsEndAllIndex", "slotsEndAllIndex$runtime_release", "slotsEndIndex", "slotsEndIndex$runtime_release", "slotsStartIndex", "slotsStartIndex$runtime_release", "sourceInformationOf", "startData", "aux", "objectKey", "startGroup", "dataKey", "startNode", "toDebugString", "toString", "trimTailSlots", "tryAnchor", "tryAnchor$runtime_release", "update", "updateAnchors", "previousGapStart", "newGapStart", "updateAux", "updateContainsMark", "updateContainsMarkNow", "updateNode", "updateNodeOfGroup", "updateParentNode", "updateToTableMaps", "verifyDataAnchors", "verifyDataAnchors$runtime_release", "verifyParentAnchors", "verifyParentAnchors$runtime_release", "auxIndex", "address", "dataIndexes", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nodeIndex", "slotIndex", "updateDataIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SlotWriter {

    public static final int $stable = 8;
    public static final androidx.compose.runtime.SlotWriter.Companion Companion;
    private ArrayList<androidx.compose.runtime.Anchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;
    private final androidx.compose.runtime.IntStack endStack;
    private int groupGapLen;
    private int groupGapStart;
    private int[] groups;
    private int insertCount;
    private int nodeCount;
    private final androidx.compose.runtime.IntStack nodeCountStack;
    private int parent = -1;
    private androidx.compose.runtime.PrioritySet pendingRecalculateMarks;
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;
    private HashMap<androidx.compose.runtime.Anchor, androidx.compose.runtime.GroupSourceInformation> sourceInformationMap;
    private final androidx.compose.runtime.IntStack startStack;
    private final androidx.compose.runtime.SlotTable table;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000cH\u0002¨\u0006\u000f", d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "removeSourceGroup", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final List access$moveGroup(androidx.compose.runtime.SlotWriter.Companion $this, androidx.compose.runtime.SlotWriter fromWriter, int fromIndex, androidx.compose.runtime.SlotWriter toWriter, boolean updateFromCursor, boolean updateToCursor, boolean removeSourceGroup) {
            return $this.moveGroup(fromWriter, fromIndex, toWriter, updateFromCursor, updateToCursor, removeSourceGroup);
        }

        private final List<androidx.compose.runtime.Anchor> moveGroup(androidx.compose.runtime.SlotWriter fromWriter, int fromIndex, androidx.compose.runtime.SlotWriter toWriter, boolean updateFromCursor, boolean updateToCursor, boolean removeSourceGroup) {
            int anchorDelta;
            Object insertLocation;
            int currentGroup;
            int subList;
            HashMap sourceSourceInformationMap2;
            int i3;
            ArrayList hasMarks;
            int currentGroup2;
            int slots;
            int currentSlot;
            int parentDelta2;
            ArrayList predecessor;
            boolean group;
            int child;
            int i2;
            androidx.compose.runtime.SlotWriter writer;
            int sourceGroupsEnd;
            int parentDelta;
            int i4;
            int location$runtime_release;
            int i7;
            int i10;
            int i12;
            int i6;
            int toWriterParent;
            int i11;
            ArrayList anchors;
            int i5;
            int i;
            HashMap $i$a$LetSlotWriter$Companion$moveGroup$2;
            int i8;
            int i13;
            HashMap sourceSourceInformationMap;
            int i9;
            final androidx.compose.runtime.SlotWriter writer2 = fromWriter;
            final int i14 = fromIndex;
            final androidx.compose.runtime.SlotWriter writer3 = toWriter;
            final int groupSize = fromWriter.groupSize(fromIndex);
            int i15 = i14 + groupSize;
            final int i19 = SlotWriter.access$dataIndex(fromWriter, fromIndex);
            int i20 = SlotWriter.access$dataIndex(writer2, i15);
            final int i22 = i20 - i19;
            SlotWriter.access$insertGroups(writer3, groupSize);
            SlotWriter.access$insertSlots(writer3, i22, writer3.getCurrentGroup());
            if (SlotWriter.access$getGroupGapStart$p(writer2) < i15) {
                SlotWriter.access$moveGroupGapTo(writer2, i15);
            }
            if (SlotWriter.access$getSlotsGapStart$p(writer2) < i20) {
                SlotWriter.access$moveSlotGapTo(writer2, i20, i15);
            }
            int[] iArr2 = SlotWriter.access$getGroups$p(writer3);
            currentGroup2 = writer3.getCurrentGroup();
            ArraysKt.copyInto(SlotWriter.access$getGroups$p(writer2), iArr2, currentGroup2 * 5, i14 * 5, i15 * 5);
            Object[] objArr = SlotWriter.access$getSlots$p(writer3);
            int i31 = SlotWriter.access$getCurrentSlot$p(writer3);
            ArraysKt.copyInto(SlotWriter.access$getSlots$p(writer2), objArr, i31, i19, i20);
            int parent2 = writer3.getParent();
            SlotTableKt.access$updateParentAnchor(iArr2, currentGroup2, parent2);
            parentDelta2 = currentGroup2 - i14;
            child = currentGroup2 + groupSize;
            int i39 = 0;
            final int i41 = i20;
            int i38 = 0;
            subList = SlotWriter.access$getSlotsGapLen$p(writer3);
            hasMarks = objArr.length;
            final Object[] objArr3 = objArr;
            slots = slotsGapOwner;
            currentSlot = i2;
            i2 = 0;
            while (currentSlot < child) {
                if (currentSlot != currentGroup2) {
                } else {
                }
                parentDelta = parentDelta2;
                int i42 = 0;
                writer = toWriter;
                i4 = 0;
                if (slots < currentSlot) {
                } else {
                }
                i2 = SlotWriter.access$getSlotsGapStart$p(writer);
                SlotTableKt.access$updateDataAnchor(iArr2, currentSlot, SlotWriter.access$dataIndexToDataAnchor(writer, i44 += i40, i2, subList, hasMarks));
                if (currentSlot == slots) {
                }
                currentSlot++;
                parentDelta2 = parentDelta;
                child = i10;
                currentGroup2 = i12;
                i2 = 0;
                slots++;
                SlotTableKt.access$updateParentAnchor(iArr2, currentSlot, writer + parentDelta);
            }
            int currentGroup8 = currentGroup2;
            int i43 = parentDelta2;
            int i46 = child;
            SlotWriter.access$setSlotsGapOwner$p(writer3, slots);
            int i29 = SlotTableKt.access$locationOf(SlotWriter.access$getAnchors$p(writer2), i14, writer2.getSize$runtime_release());
            int i32 = SlotTableKt.access$locationOf(SlotWriter.access$getAnchors$p(writer2), i15, writer2.getSize$runtime_release());
            if (i29 < i32) {
                predecessor = SlotWriter.access$getAnchors$p(writer2);
                sourceGroupsEnd = i15;
                child = new ArrayList(i32 - i29);
                anchorDelta = location$runtime_release;
                while (anchorDelta < i32) {
                    Object anchorIndex = obj;
                    anchorIndex.setLocation$runtime_release(location$runtime_release + i6);
                    child.add(anchorIndex);
                    anchorDelta = i11 + 1;
                    subList = i5;
                }
                i11 = anchorDelta;
                i = subList;
                i7 = hasMarks;
                SlotWriter.access$getAnchors$p(writer3).addAll(SlotTableKt.access$locationOf(SlotWriter.access$getAnchors$p(writer3), writer3.getCurrentGroup(), writer3.getSize$runtime_release()), (Collection)child);
                predecessor.subList(i29, i32).clear();
                insertLocation = child;
            } else {
                sourceGroupsEnd = i15;
                i = subList;
                i7 = hasMarks;
                insertLocation = CollectionsKt.emptyList();
            }
            if (!(Collection)insertLocation.isEmpty()) {
                sourceSourceInformationMap2 = SlotWriter.access$getSourceInformationMap$p(writer2);
                hasMarks = SlotWriter.access$getSourceInformationMap$p(writer3);
                if (sourceSourceInformationMap2 != null && hasMarks != null) {
                    if (hasMarks != null) {
                        predecessor = insertLocation;
                        child = 0;
                        anchors = insertLocation;
                        insertLocation = predecessor.size();
                        hasMarks = i6;
                        while (hasMarks < insertLocation) {
                            int i18 = i6;
                            i13 = 0;
                            Object index$iv = obj2;
                            if ((GroupSourceInformation)index$iv != null) {
                            } else {
                            }
                            sourceSourceInformationMap = sourceSourceInformationMap2;
                            hasMarks = i9 + 1;
                            insertLocation = i8;
                            sourceSourceInformationMap2 = sourceSourceInformationMap;
                            sourceSourceInformationMap2.remove(i18);
                            sourceSourceInformationMap = sourceSourceInformationMap2;
                            (Map)hasMarks.put(i18, (GroupSourceInformation)index$iv);
                        }
                        sourceSourceInformationMap = sourceSourceInformationMap2;
                        i9 = hasMarks;
                    } else {
                        anchors = insertLocation;
                        sourceSourceInformationMap = sourceSourceInformationMap2;
                        $i$a$LetSlotWriter$Companion$moveGroup$2 = hasMarks;
                    }
                } else {
                }
            } else {
                anchors = insertLocation;
            }
            currentGroup = writer3.getParent();
            androidx.compose.runtime.GroupSourceInformation groupSourceInformation = SlotWriter.access$sourceInformationOf(writer3, parent2);
            if (groupSourceInformation != null) {
                hasMarks = 0;
                predecessor = -1;
                child = currentGroup + 1;
                toWriterParent = currentGroup;
                currentGroup = writer3.getCurrentGroup();
                while (child < currentGroup) {
                    predecessor = child;
                    child += i23;
                    hasMarks = $i$a$LetSlotWriter$Companion$moveGroup$2;
                }
                $i$a$LetSlotWriter$Companion$moveGroup$2 = hasMarks;
                groupSourceInformation.addGroupAfter(writer3, predecessor, currentGroup);
            } else {
                toWriterParent = currentGroup;
            }
            int parent = fromWriter.parent(fromIndex);
            i3 = 1;
            if (!removeSourceGroup) {
                group = i2;
            } else {
                if (updateFromCursor != null) {
                    hasMarks = parent >= 0 ? i3 : i2;
                    if (hasMarks != 0) {
                        writer2.startGroup();
                        writer2.advanceBy(parent - currentGroup7);
                        writer2.startGroup();
                    }
                    writer2.advanceBy(i14 - currentGroup6);
                    group = writer2.removeGroup();
                    if (hasMarks != 0) {
                        writer2.skipToGroupEnd();
                        writer2.endGroup();
                        writer2.skipToGroupEnd();
                        writer2.endGroup();
                    }
                } else {
                    group = SlotWriter.access$removeGroups(writer2, i14, groupSize);
                    SlotWriter.access$removeSlots(writer2, i19, i22, i14 + -1);
                }
            }
            if (!group) {
                i2 = i3;
            }
            int i24 = 0;
            if (i2 == 0) {
                int i37 = 0;
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }
            int i36 = currentGroup8;
            if (SlotTableKt.access$isNode(iArr2, i36)) {
            } else {
                i3 = SlotTableKt.access$nodeCount(iArr2, i36);
            }
            SlotWriter.access$setNodeCount$p(writer3, i25 += i3);
            if (updateToCursor != null) {
                SlotWriter.access$setCurrentGroup$p(writer3, i36 + groupSize);
                SlotWriter.access$setCurrentSlot$p(writer3, slotsGapOwner2 + i22);
            }
            if (SlotWriter.access$containsAnyGroupMarks(fromWriter, fromIndex)) {
                SlotWriter.access$updateContainsMark(writer3, parent2);
            }
            return anchors;
        }

        static List moveGroup$default(androidx.compose.runtime.SlotWriter.Companion slotWriter$Companion, androidx.compose.runtime.SlotWriter slotWriter2, int i3, androidx.compose.runtime.SlotWriter slotWriter4, boolean z5, boolean z6, boolean z7, int i8, Object object9) {
            int i;
            int obj13;
            i = i8 &= 32 != 0 ? obj13 : z7;
            return companion.moveGroup(slotWriter2, i3, slotWriter4, z5, z6, i);
        }
    }
    static {
        SlotWriter.Companion companion = new SlotWriter.Companion(0);
        SlotWriter.Companion = companion;
        int i = 8;
    }

    public SlotWriter(androidx.compose.runtime.SlotTable table) {
        super();
        this.table = table;
        this.groups = this.table.getGroups();
        this.slots = this.table.getSlots();
        this.anchors = this.table.getAnchors$runtime_release();
        this.sourceInformationMap = this.table.getSourceInformationMap$runtime_release();
        this.calledByMap = this.table.getCalledByMap$runtime_release();
        this.groupGapStart = this.table.getGroupsSize();
        this.groupGapLen = i -= groupsSize4;
        this.slotsGapStart = this.table.getSlotsSize();
        this.slotsGapLen = length2 -= slotsSize2;
        this.slotsGapOwner = this.table.getGroupsSize();
        IntStack intStack = new IntStack();
        this.startStack = intStack;
        IntStack intStack2 = new IntStack();
        this.endStack = intStack2;
        IntStack intStack3 = new IntStack();
        this.nodeCountStack = intStack3;
        this.currentGroupEnd = this.table.getGroupsSize();
        int i4 = -1;
    }

    public static final boolean access$containsAnyGroupMarks(androidx.compose.runtime.SlotWriter $this, int group) {
        return $this.containsAnyGroupMarks(group);
    }

    public static final int access$dataIndex(androidx.compose.runtime.SlotWriter $this, int index) {
        return $this.dataIndex(index);
    }

    public static final int access$dataIndex(androidx.compose.runtime.SlotWriter $this, int[] $receiver, int address) {
        return $this.dataIndex($receiver, address);
    }

    public static final int access$dataIndexToDataAddress(androidx.compose.runtime.SlotWriter $this, int dataIndex) {
        return $this.dataIndexToDataAddress(dataIndex);
    }

    public static final int access$dataIndexToDataAnchor(androidx.compose.runtime.SlotWriter $this, int index, int gapStart, int gapLen, int capacity) {
        return $this.dataIndexToDataAnchor(index, gapStart, gapLen, capacity);
    }

    public static final ArrayList access$getAnchors$p(androidx.compose.runtime.SlotWriter $this) {
        return $this.anchors;
    }

    public static final int access$getCurrentSlot$p(androidx.compose.runtime.SlotWriter $this) {
        return $this.currentSlot;
    }

    public static final int access$getGroupGapStart$p(androidx.compose.runtime.SlotWriter $this) {
        return $this.groupGapStart;
    }

    public static final int[] access$getGroups$p(androidx.compose.runtime.SlotWriter $this) {
        return $this.groups;
    }

    public static final int access$getNodeCount$p(androidx.compose.runtime.SlotWriter $this) {
        return $this.nodeCount;
    }

    public static final Object[] access$getSlots$p(androidx.compose.runtime.SlotWriter $this) {
        return $this.slots;
    }

    public static final int access$getSlotsGapLen$p(androidx.compose.runtime.SlotWriter $this) {
        return $this.slotsGapLen;
    }

    public static final int access$getSlotsGapOwner$p(androidx.compose.runtime.SlotWriter $this) {
        return $this.slotsGapOwner;
    }

    public static final int access$getSlotsGapStart$p(androidx.compose.runtime.SlotWriter $this) {
        return $this.slotsGapStart;
    }

    public static final HashMap access$getSourceInformationMap$p(androidx.compose.runtime.SlotWriter $this) {
        return $this.sourceInformationMap;
    }

    public static final int access$groupIndexToAddress(androidx.compose.runtime.SlotWriter $this, int index) {
        return $this.groupIndexToAddress(index);
    }

    public static final void access$insertGroups(androidx.compose.runtime.SlotWriter $this, int size) {
        $this.insertGroups(size);
    }

    public static final void access$insertSlots(androidx.compose.runtime.SlotWriter $this, int size, int group) {
        $this.insertSlots(size, group);
    }

    public static final void access$moveGroupGapTo(androidx.compose.runtime.SlotWriter $this, int index) {
        $this.moveGroupGapTo(index);
    }

    public static final void access$moveSlotGapTo(androidx.compose.runtime.SlotWriter $this, int index, int group) {
        $this.moveSlotGapTo(index, group);
    }

    public static final boolean access$removeGroups(androidx.compose.runtime.SlotWriter $this, int start, int len) {
        return $this.removeGroups(start, len);
    }

    public static final void access$removeSlots(androidx.compose.runtime.SlotWriter $this, int start, int len, int group) {
        $this.removeSlots(start, len, group);
    }

    public static final void access$setCurrentGroup$p(androidx.compose.runtime.SlotWriter $this, int <set-?>) {
        $this.currentGroup = <set-?>;
    }

    public static final void access$setCurrentSlot$p(androidx.compose.runtime.SlotWriter $this, int <set-?>) {
        $this.currentSlot = <set-?>;
    }

    public static final void access$setNodeCount$p(androidx.compose.runtime.SlotWriter $this, int <set-?>) {
        $this.nodeCount = <set-?>;
    }

    public static final void access$setSlotsGapOwner$p(androidx.compose.runtime.SlotWriter $this, int <set-?>) {
        $this.slotsGapOwner = <set-?>;
    }

    public static final int access$slotIndex(androidx.compose.runtime.SlotWriter $this, int[] $receiver, int address) {
        return $this.slotIndex($receiver, address);
    }

    public static final androidx.compose.runtime.GroupSourceInformation access$sourceInformationOf(androidx.compose.runtime.SlotWriter $this, int group) {
        return $this.sourceInformationOf(group);
    }

    public static final void access$updateContainsMark(androidx.compose.runtime.SlotWriter $this, int group) {
        $this.updateContainsMark(group);
    }

    public static androidx.compose.runtime.Anchor anchor$default(androidx.compose.runtime.SlotWriter slotWriter, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = slotWriter.currentGroup;
        }
        return slotWriter.anchor(obj1);
    }

    private final int auxIndex(int[] $this$auxIndex, int address) {
        return dataIndex += i4;
    }

    private final boolean childContainsAnyMarks(int group) {
        int child;
        int groupSize;
        int groupIndexToAddress;
        child = group + 1;
        while (child < groupSize2 += group) {
            child += groupSize;
        }
        return 0;
    }

    private final void clearSlotGap() {
        final int slotsGapStart = this.slotsGapStart;
        ArraysKt.fill(this.slots, 0, slotsGapStart, slotsGapLen += slotsGapStart);
    }

    private final boolean containsAnyGroupMarks(int group) {
        boolean z;
        int i;
        int groupIndexToAddress;
        if (group >= 0 && SlotTableKt.access$containsAnyMark(this.groups, groupIndexToAddress(group))) {
            i = SlotTableKt.access$containsAnyMark(this.groups, groupIndexToAddress(group)) ? 1 : 0;
        } else {
        }
        return i;
    }

    private final boolean containsGroupMark(int group) {
        boolean z;
        int i;
        int groupIndexToAddress;
        if (group >= 0 && SlotTableKt.access$containsMark(this.groups, groupIndexToAddress(group))) {
            i = SlotTableKt.access$containsMark(this.groups, groupIndexToAddress(group)) ? 1 : 0;
        } else {
        }
        return i;
    }

    private final int dataAnchorToDataIndex(int anchor, int gapLen, int capacity) {
        int i;
        if (anchor < 0) {
            i3++;
        } else {
            i = anchor;
        }
        return i;
    }

    private final int dataIndex(int index) {
        return dataIndex(this.groups, groupIndexToAddress(index));
    }

    private final int dataIndex(int[] $this$dataIndex, int address) {
        int dataAnchorToDataIndex;
        int slotsGapLen;
        int length;
        if (address >= getCapacity()) {
            length2 -= slotsGapLen;
        } else {
            dataAnchorToDataIndex = dataAnchorToDataIndex(SlotTableKt.access$dataAnchor($this$dataIndex, address), this.slotsGapLen, slots2.length);
        }
        return dataAnchorToDataIndex;
    }

    private final int dataIndexToDataAddress(int dataIndex) {
        int i;
        i = dataIndex < this.slotsGapStart ? dataIndex : slotsGapLen + dataIndex;
        return i;
    }

    private final int dataIndexToDataAnchor(int index, int gapStart, int gapLen, int capacity) {
        int i;
        if (index > gapStart) {
            i = -i4;
        } else {
            i = index;
        }
        return i;
    }

    private final List<Integer> dataIndexes(int[] $this$dataIndexes) {
        List it;
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i2;
        ArrayList list;
        int intValue;
        int i;
        int slotsGapLen;
        List list2;
        final Object obj3 = this;
        int i7 = 0;
        List dataAnchors$default = SlotTableKt.dataAnchors$default(obj3.groups, i7, 1, 0);
        int i4 = 0;
        it = CollectionsKt.plus((Collection)CollectionsKt.slice(dataAnchors$default, RangesKt.until(i7, obj3.groupGapStart)), (Iterable)CollectionsKt.slice(dataAnchors$default, RangesKt.until(groupGapStart2 += groupGapLen, length2 /= 5)));
        int i5 = 0;
        ArrayList arrayList = new ArrayList(it.size());
        List list4 = it;
        int i10 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list4.size()) {
            i2 = 0;
            i = 0;
            (Collection)arrayList.add(Integer.valueOf(obj3.dataAnchorToDataIndex((Number)list4.get(index$iv$iv).intValue(), obj3.slotsGapLen, $this$fastMap$iv.length)));
            index$iv$iv++;
            it = list2;
        }
        List $this$fastMap$iv2 = it;
        return (List)arrayList;
    }

    private final void fixParentAnchorsFor(int parent, int endGroup, int firstChild) {
        int child;
        int i;
        int i2;
        child = firstChild;
        while (child < endGroup) {
            SlotTableKt.access$updateParentAnchor(this.groups, groupIndexToAddress(child), parentIndexToAnchor(parent, this.groupGapStart));
            i3 += child;
            fixParentAnchorsFor(child, i, child + 1);
            child = i;
        }
    }

    private final int getCapacity() {
        return length /= 5;
    }

    private final int getCurrentGroupSlotIndex() {
        return currentSlot -= slotsStartIndex$runtime_release;
    }

    private final void groupAsString(StringBuilder $this$groupAsString, int index) {
        int i;
        int str;
        boolean string;
        String str2;
        int dataIndexToDataAddress2;
        int dataIndex;
        int dataIndexToDataAddress;
        String valueOf;
        final int groupIndexToAddress = groupIndexToAddress(index);
        $this$groupAsString.append("Group(");
        int i2 = 32;
        i = 10;
        if (index < i) {
            $this$groupAsString.append(i2);
        }
        if (index < 100) {
            $this$groupAsString.append(i2);
        }
        if (index < 1000) {
            $this$groupAsString.append(i2);
        }
        $this$groupAsString.append(index);
        String str4 = ")";
        if (groupIndexToAddress != index) {
            $this$groupAsString.append("(");
            $this$groupAsString.append(groupIndexToAddress);
            $this$groupAsString.append(str4);
        }
        $this$groupAsString.append('#');
        $this$groupAsString.append(SlotTableKt.access$groupSize(this.groups, groupIndexToAddress));
        $this$groupAsString.append('^');
        $this$groupAsString.append(parentAnchorToIndex(SlotTableKt.access$parentAnchor(this.groups, groupIndexToAddress)));
        $this$groupAsString.append(": key=");
        $this$groupAsString.append(SlotTableKt.access$key(this.groups, groupIndexToAddress));
        $this$groupAsString.append(", nodes=");
        $this$groupAsString.append(SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress));
        $this$groupAsString.append(", dataAnchor=");
        $this$groupAsString.append(SlotTableKt.access$dataAnchor(this.groups, groupIndexToAddress));
        $this$groupAsString.append(", parentAnchor=");
        $this$groupAsString.append(SlotTableKt.access$parentAnchor(this.groups, groupIndexToAddress));
        if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress)) {
            StringBuilder stringBuilder = new StringBuilder();
            $this$groupAsString.append(stringBuilder.append(", node=").append(SlotTableKt.access$summarize(String.valueOf(this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))]), i)).toString());
        }
        int slotIndex = slotIndex(this.groups, groupIndexToAddress);
        int dataIndex2 = dataIndex(this.groups, groupIndexToAddress(index + 1));
        if (dataIndex2 > slotIndex) {
            $this$groupAsString.append(", [");
            dataIndex = slotIndex;
            while (dataIndex < dataIndex2) {
                if (dataIndex != slotIndex) {
                }
                $this$groupAsString.append(String.valueOf(SlotTableKt.access$summarize(String.valueOf(this.slots[dataIndexToDataAddress(dataIndex)]), i)));
                dataIndex++;
                $this$groupAsString.append(", ");
            }
            $this$groupAsString.append(']');
        }
        $this$groupAsString.append(str4);
    }

    private final int groupIndexToAddress(int index) {
        int i;
        i = index < this.groupGapStart ? index : groupGapLen + index;
        return i;
    }

    private final androidx.compose.runtime.GroupSourceInformation groupSourceInformationFor(int parent, String sourceInformation) {
        androidx.compose.runtime.Anchor anchor;
        int i3;
        Object obj;
        int i;
        int groupSourceInformation;
        int child;
        int currentGroup;
        int i2;
        final HashMap sourceInformationMap = this.sourceInformationMap;
        if (sourceInformationMap != null) {
            anchor = anchor(parent);
            i3 = 0;
            obj = (Map)sourceInformationMap.get(anchor);
            if (obj == null) {
                i = 0;
                child = 0;
                groupSourceInformation = new GroupSourceInformation(child, sourceInformation, child);
                if (sourceInformation == null) {
                    child = parent + 1;
                    while (child < this.currentGroup) {
                        groupSourceInformation.reportGroup(this, child);
                        child += i2;
                    }
                }
                sourceInformationMap.put(anchor, groupSourceInformation);
            } else {
                groupSourceInformation = obj;
            }
        } else {
            groupSourceInformation = 0;
        }
        return groupSourceInformation;
    }

    private final void insertGroups(int size) {
        int currentGroup;
        int groupGapStart;
        int gapLen;
        int i2;
        int i5;
        int i3;
        int currentGroupEnd;
        int[] dataIndex;
        int dataIndexToDataAnchor;
        int slotsGapStart;
        int[] groupAddress;
        int groupAddress2;
        int i7;
        int groups;
        int i;
        int i4;
        int i6;
        final Object obj = this;
        final int i8 = size;
        currentGroup = obj.currentGroup;
        obj.moveGroupGapTo(currentGroup);
        groupGapStart = obj.groupGapStart;
        gapLen = obj.groupGapLen;
        length /= 5;
        i5 = i2 - gapLen;
        i3 = 0;
        if (i8 > 0 && gapLen < i8) {
            currentGroup = obj.currentGroup;
            obj.moveGroupGapTo(currentGroup);
            groupGapStart = obj.groupGapStart;
            gapLen = obj.groupGapLen;
            length /= 5;
            i5 = i2 - gapLen;
            i3 = 0;
            if (gapLen < i8) {
                dataIndex = obj.groups;
                dataIndexToDataAnchor = Math.max(Math.max(i2 * 2, i5 + i8), 32);
                groupAddress = new int[dataIndexToDataAnchor * 5];
                i7 = dataIndexToDataAnchor - i5;
                ArraysKt.copyInto(dataIndex, groupAddress, i3, i3, groupGapStart * 5);
                ArraysKt.copyInto(dataIndex, groupAddress, i * 5, groups * 5, i2 * 5);
                obj.groups = groupAddress;
                gapLen = i7;
            }
            currentGroupEnd = obj.currentGroupEnd;
            if (currentGroupEnd >= groupGapStart) {
                obj.currentGroupEnd = currentGroupEnd + i8;
            }
            obj.groupGapStart = groupGapStart + i8;
            obj.groupGapLen = gapLen - i8;
            if (i5 > 0) {
                dataIndex = obj.dataIndex(currentGroup + i8);
            } else {
                dataIndex = 0;
            }
            slotsGapStart = obj.slotsGapOwner < groupGapStart ? 0 : obj.slotsGapStart;
            groupAddress2 = groupGapStart;
            while (groupAddress2 < groupGapStart + i8) {
                SlotTableKt.access$updateDataAnchor(obj.groups, groupAddress2, obj.dataIndexToDataAnchor(dataIndex, slotsGapStart, obj.slotsGapLen, slots.length));
                groupAddress2++;
            }
            groupAddress = obj.slotsGapOwner;
            if (groupAddress >= groupGapStart) {
                obj.slotsGapOwner = groupAddress + i8;
            }
        }
    }

    private final void insertSlots(int size, int group) {
        int slotsGapStart;
        int gapLen;
        int slots;
        int length;
        int i5;
        int i4;
        Object[] arr;
        int i6;
        int i3;
        int i7;
        int i;
        int i2;
        moveSlotGapTo(this.currentSlot, group);
        slotsGapStart = this.slotsGapStart;
        gapLen = this.slotsGapLen;
        if (size > 0 && gapLen < size) {
            moveSlotGapTo(this.currentSlot, group);
            slotsGapStart = this.slotsGapStart;
            gapLen = this.slotsGapLen;
            if (gapLen < size) {
                slots = this.slots;
                length = slots.length;
                i5 = length - gapLen;
                i4 = Math.max(Math.max(length * 2, i5 + size), 32);
                arr = new Object[i4];
                i6 = 0;
                i7 = i6;
                while (i7 < i4) {
                    arr[i7] = 0;
                    i7++;
                }
                i3 = i4 - i5;
                ArraysKt.copyInto(slots, arr, i6, i6, slotsGapStart);
                ArraysKt.copyInto(slots, arr, slotsGapStart + i3, slotsGapStart + gapLen, length);
                this.slots = arr;
                gapLen = i3;
            }
            slots = this.currentSlotEnd;
            if (slots >= slotsGapStart) {
                this.currentSlotEnd = slots + size;
            }
            this.slotsGapStart = slotsGapStart + size;
            this.slotsGapLen = gapLen - size;
        }
    }

    private final List<Integer> keys() {
        int i;
        int i4;
        int groupGapStart;
        int groupGapLen;
        int index$iv$iv;
        Object obj;
        int i2;
        Object obj2;
        int i6;
        int i5;
        int i3;
        final Object obj3 = this;
        List keys$default = SlotTableKt.keys$default(obj3.groups, 0, 1, 0);
        int i8 = 0;
        ArrayList arrayList = new ArrayList(keys$default.size());
        List list = keys$default;
        final int i9 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            obj2 = obj;
            i6 = 0;
            (Number)obj2.intValue();
            i5 = i2;
            i3 = 0;
            if (i5 >= obj3.groupGapStart) {
            } else {
            }
            i4 = 1;
            if (i4 != 0) {
            }
            index$iv$iv++;
            i = 0;
            groupGapLen = 1;
            (Collection)arrayList.add(obj2);
            if (i5 >= groupGapStart2 += groupGapLen) {
            } else {
            }
            i4 = 0;
        }
        return (List)arrayList;
    }

    public static void markGroup$default(androidx.compose.runtime.SlotWriter slotWriter, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = slotWriter.parent;
        }
        slotWriter.markGroup(obj1);
    }

    private final void moveAnchors(int originalLocation, int newLocation, int size) {
        int i4;
        int groupGapStart;
        int i3;
        int size2;
        int anchorIndex;
        ArrayList anchors;
        int index$iv;
        Object obj2;
        Object obj;
        int i2;
        int anchorIndex2;
        int i;
        int i5;
        final Object obj3 = this;
        i4 = originalLocation;
        final int size$runtime_release = obj3.getSize$runtime_release();
        int i8 = SlotTableKt.access$locationOf(obj3.anchors, i4, size$runtime_release);
        ArrayList arrayList = new ArrayList();
        if (i8 >= 0) {
        }
        ArrayList list = arrayList;
        int i9 = 0;
        index$iv = 0;
        while (index$iv < list.size()) {
            obj = obj2;
            i2 = 0;
            i = anchorIndex2 + anchor;
            if (i >= obj3.groupGapStart) {
            } else {
            }
            obj.setLocation$runtime_release(i);
            obj3.anchors.add(SlotTableKt.access$locationOf(obj3.anchors, i, size$runtime_release), obj);
            index$iv++;
            i4 = originalLocation;
            i3 = i5;
            obj.setLocation$runtime_release(-i7);
        }
    }

    public static List moveFrom$default(androidx.compose.runtime.SlotWriter slotWriter, androidx.compose.runtime.SlotTable slotTable2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 1;
        }
        return slotWriter.moveFrom(slotTable2, i3, obj3);
    }

    private final void moveGroupGapTo(int index) {
        boolean groups;
        int groupAddress;
        int capacity;
        int i;
        int parentAnchorToIndex;
        int parentIndexToAnchor;
        int groups2;
        final int groupGapLen = this.groupGapLen;
        final int groupGapStart = this.groupGapStart;
        if (groupGapStart != index && !(Collection)this.anchors.isEmpty()) {
            if (!(Collection)this.anchors.isEmpty()) {
                updateAnchors(groupGapStart, index);
            }
            if (groupGapLen > 0) {
                groups = this.groups;
                capacity = index * 5;
                i = groupGapLen * 5;
                parentAnchorToIndex = groupGapStart * 5;
                if (index < groupGapStart) {
                    ArraysKt.copyInto(groups, groups, capacity + i, capacity, parentAnchorToIndex);
                } else {
                    ArraysKt.copyInto(groups, groups, parentAnchorToIndex, parentAnchorToIndex + i, capacity + i);
                }
            }
            groupAddress = index < groupGapStart ? index + groupGapLen : groupGapStart;
            capacity = getCapacity();
            i = groupAddress < capacity ? 1 : 0;
            ComposerKt.runtimeCheck(i);
            while (groupAddress < capacity) {
                i = SlotTableKt.access$parentAnchor(this.groups, groupAddress);
                parentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(i), index);
                if (parentIndexToAnchor != i) {
                }
                groupAddress++;
                if (groupAddress == index) {
                }
                groupAddress += groupGapLen;
                SlotTableKt.access$updateParentAnchor(this.groups, groupAddress, parentIndexToAnchor);
            }
        }
        this.groupGapStart = index;
    }

    private final void moveSlotGapTo(int index, int group) {
        Object[] slots;
        int i;
        int size$runtime_release;
        int i4;
        int i5;
        int updateAddress;
        int groupIndexToAddress;
        int groupGapStart2;
        int groupGapStart;
        int i2;
        int[] value$iv;
        int i3;
        int $i$a$RuntimeCheckSlotWriter$moveSlotGapTo$2;
        String $i$a$RuntimeCheckSlotWriter$moveSlotGapTo$1;
        final Object obj = this;
        final int i6 = index;
        final int slotsGapLen = obj.slotsGapLen;
        final int slotsGapStart = obj.slotsGapStart;
        final int slotsGapOwner = obj.slotsGapOwner;
        if (slotsGapStart != i6) {
            slots = obj.slots;
            if (i6 < slotsGapStart) {
                ArraysKt.copyInto(slots, slots, i6 + slotsGapLen, i6, slotsGapStart);
            } else {
                ArraysKt.copyInto(slots, slots, slotsGapStart, slotsGapStart + slotsGapLen, i6 + slotsGapLen);
            }
        }
        int i7 = Math.min(group + 1, obj.getSize$runtime_release());
        if (slotsGapOwner != i7) {
            length -= slotsGapLen;
            i4 = 0;
            i5 = 1;
            if (i7 < slotsGapOwner) {
                updateAddress = obj.groupIndexToAddress(i7);
                while (updateAddress < obj.groupIndexToAddress(slotsGapOwner)) {
                    groupGapStart = SlotTableKt.access$dataAnchor(obj.groups, updateAddress);
                    if (groupGapStart >= 0) {
                    } else {
                    }
                    i3 = i4;
                    int i10 = 0;
                    if (i3 == 0) {
                    }
                    SlotTableKt.access$updateDataAnchor(obj.groups, updateAddress, -i12);
                    updateAddress++;
                    if (updateAddress == obj.groupGapStart) {
                    }
                    updateAddress += value$iv;
                    int i14 = 0;
                    ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a positive anchor");
                    i3 = i5;
                }
            } else {
                updateAddress = obj.groupIndexToAddress(slotsGapOwner);
                while (updateAddress < obj.groupIndexToAddress(i7)) {
                    groupGapStart2 = SlotTableKt.access$dataAnchor(obj.groups, updateAddress);
                    if (groupGapStart2 < 0) {
                    } else {
                    }
                    i2 = i4;
                    int i8 = 0;
                    if (i2 == 0) {
                    }
                    SlotTableKt.access$updateDataAnchor(obj.groups, updateAddress, i9 += i5);
                    updateAddress++;
                    if (updateAddress == obj.groupGapStart) {
                    }
                    updateAddress += groupGapStart;
                    int i13 = 0;
                    ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a negative anchor");
                    i2 = i5;
                }
            }
            obj.slotsGapOwner = i7;
        }
        obj.slotsGapStart = i6;
    }

    private final int nodeIndex(int[] $this$nodeIndex, int address) {
        return dataIndex($this$nodeIndex, address);
    }

    private final int parent(int[] $this$parent, int index) {
        return parentAnchorToIndex(SlotTableKt.access$parentAnchor($this$parent, groupIndexToAddress(index)));
    }

    private final int parentAnchorToIndex(int index) {
        int i;
        final int i2 = -2;
        if (index > i2) {
            i = index;
        } else {
            i3 -= i2;
        }
        return i;
    }

    private final int parentIndexToAnchor(int index, int gapStart) {
        int i;
        if (index < gapStart) {
            i = index;
        } else {
            i = -i3;
        }
        return i;
    }

    private final void recalculateMarks() {
        int i;
        boolean notEmpty;
        final androidx.compose.runtime.PrioritySet pendingRecalculateMarks = this.pendingRecalculateMarks;
        if (pendingRecalculateMarks != null) {
            i = 0;
            while (pendingRecalculateMarks.isNotEmpty()) {
                updateContainsMarkNow(pendingRecalculateMarks.takeMax(), pendingRecalculateMarks);
            }
        }
    }

    private final boolean removeAnchors(int gapStart, int size, HashMap<androidx.compose.runtime.Anchor, androidx.compose.runtime.GroupSourceInformation> sourceInformationMap) {
        int it;
        int removeAnchorEnd;
        int size2;
        int removeAnchorStart;
        Object obj;
        int i;
        int anchorIndex;
        int remove;
        List subList;
        it = SlotTableKt.access$locationOf(this.anchors, gapStart + size, capacity -= groupGapLen);
        int i5 = 0;
        if (it >= this.anchors.size()) {
            it = size2;
        }
        removeAnchorEnd = 0;
        int i6 = 0;
        removeAnchorStart = it + 1;
        while (it >= 0) {
            obj = this.anchors.get(it);
            anchorIndex = anchorIndex((Anchor)obj);
            if (anchorIndex < gapStart) {
                break;
            } else {
            }
            obj.setLocation$runtime_release(Integer.MIN_VALUE);
            if (anchorIndex < gapStart + size && sourceInformationMap != null) {
            }
            it--;
            obj.setLocation$runtime_release(Integer.MIN_VALUE);
            if (sourceInformationMap != null) {
            }
            removeAnchorStart = it;
            if (removeAnchorEnd == 0) {
            }
            removeAnchorEnd = it + 1;
            remove = sourceInformationMap.remove(obj);
        }
        i = removeAnchorStart < removeAnchorEnd ? 1 : 0;
        int i8 = 0;
        if (i != 0) {
            this.anchors.subList(removeAnchorStart, removeAnchorEnd).clear();
        }
        return i;
    }

    private final boolean removeGroups(int start, int len) {
        int anchorsRemoved;
        ArrayList anchors;
        int groupGapLen;
        boolean sourceInformationMap;
        int i;
        int slotsGapOwner;
        int parent;
        int currentGroupEnd;
        boolean groupMark;
        if (len > 0) {
            anchorsRemoved = 0;
            moveGroupGapTo(start);
            if (!(Collection)this.anchors.isEmpty()) {
                anchorsRemoved = removeAnchors(start, len, this.sourceInformationMap);
            }
            this.groupGapStart = start;
            this.groupGapLen = groupGapLen + len;
            slotsGapOwner = this.slotsGapOwner;
            if (slotsGapOwner > start) {
                this.slotsGapOwner = Math.max(start, slotsGapOwner - len);
            }
            if (this.currentGroupEnd >= this.groupGapStart) {
                this.currentGroupEnd = currentGroupEnd2 -= len;
            }
            parent = this.parent;
            if (containsGroupMark(parent)) {
                updateContainsMark(parent);
            }
        } else {
            anchorsRemoved = 0;
        }
        return anchorsRemoved;
    }

    private final void removeSlots(int start, int len, int group) {
        int slotsGapLen;
        int i;
        int currentSlotEnd;
        int i2;
        int i3;
        moveSlotGapTo(start + len, group);
        this.slotsGapStart = start;
        this.slotsGapLen = slotsGapLen + len;
        ArraysKt.fill(this.slots, 0, start, start + len);
        currentSlotEnd = this.currentSlotEnd;
        if (len > 0 && currentSlotEnd >= start) {
            moveSlotGapTo(start + len, group);
            this.slotsGapStart = start;
            this.slotsGapLen = slotsGapLen + len;
            ArraysKt.fill(this.slots, 0, start, start + len);
            currentSlotEnd = this.currentSlotEnd;
            if (currentSlotEnd >= start) {
                this.currentSlotEnd = currentSlotEnd - len;
            }
        }
    }

    private final int restoreCurrentGroupEnd() {
        i -= i3;
        this.currentGroupEnd = i2;
        return i2;
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push(i -= currentGroupEnd);
    }

    private final int slotIndex(int[] $this$slotIndex, int address) {
        int dataAnchorToDataIndex;
        int slotsGapLen;
        int length;
        if (address >= getCapacity()) {
            length2 -= slotsGapLen;
        } else {
            dataAnchorToDataIndex = dataAnchorToDataIndex(SlotTableKt.access$slotAnchor($this$slotIndex, address), this.slotsGapLen, slots2.length);
        }
        return dataAnchorToDataIndex;
    }

    private final androidx.compose.runtime.GroupSourceInformation sourceInformationOf(int group) {
        int $i$a$LetSlotWriter$sourceInformationOf$1$1;
        int i;
        androidx.compose.runtime.Anchor tryAnchor$runtime_release;
        Object obj;
        final HashMap sourceInformationMap = this.sourceInformationMap;
        $i$a$LetSlotWriter$sourceInformationOf$1$1 = 0;
        i = 0;
        tryAnchor$runtime_release = tryAnchor$runtime_release(group);
        if (sourceInformationMap != null && tryAnchor$runtime_release != null) {
            i = 0;
            tryAnchor$runtime_release = tryAnchor$runtime_release(group);
            if (tryAnchor$runtime_release != null) {
                int i2 = 0;
                $i$a$LetSlotWriter$sourceInformationOf$1$1 = obj;
            }
        }
        return $i$a$LetSlotWriter$sourceInformationOf$1$1;
    }

    private final void startGroup(int key, Object objectKey, boolean isNode, Object aux) {
        int i2;
        int currentGroup;
        int sourceInformationOf;
        int groupIndexToAddress;
        int[] dataIndex;
        Object empty;
        int i6;
        int i3;
        int groupIndexToAddress2;
        int currentSlot;
        int slotsSize;
        boolean z;
        int i4;
        int i;
        int parent;
        int i5;
        final Object obj = this;
        final Object obj2 = objectKey;
        final Object obj3 = aux;
        final int parent2 = obj.parent;
        int i7 = 0;
        sourceInformationOf = 1;
        i2 = obj.insertCount > 0 ? sourceInformationOf : i7;
        obj.nodeCountStack.push(obj.nodeCount);
        if (i2 != 0) {
            groupIndexToAddress = obj.currentGroup;
            dataIndex = obj.dataIndex(obj.groups, obj.groupIndexToAddress(groupIndexToAddress));
            obj.insertGroups(sourceInformationOf);
            obj.currentSlot = dataIndex;
            obj.currentSlotEnd = dataIndex;
            i4 = obj2 != Composer.Companion.getEmpty() ? sourceInformationOf : i7;
            if (isNode == 0 && obj3 != Composer.Companion.getEmpty()) {
                i = obj3 != Composer.Companion.getEmpty() ? sourceInformationOf : i7;
            } else {
            }
            int dataIndexToDataAnchor = obj.dataIndexToDataAnchor(dataIndex, obj.slotsGapStart, obj.slotsGapLen, slots.length);
            int i12 = 0;
            if (dataIndexToDataAnchor >= 0 && obj.slotsGapOwner < groupIndexToAddress) {
                if (obj.slotsGapOwner < groupIndexToAddress) {
                    i5 = slotsSize;
                } else {
                    i5 = dataIndexToDataAnchor;
                }
            } else {
            }
            SlotTableKt.access$initGroup(obj.groups, obj.groupIndexToAddress(groupIndexToAddress), key, isNode, i4, i, obj.parent, i5);
            i6 = i4 != 0 ? sourceInformationOf : i7;
            if (i != 0) {
            } else {
                sourceInformationOf = i7;
            }
            i11 += sourceInformationOf;
            obj.insertSlots(i3, groupIndexToAddress);
            sourceInformationOf = obj.slots;
            currentSlot = obj.currentSlot;
            if (i3 > 0 && isNode != 0) {
                obj.insertSlots(i3, groupIndexToAddress);
                sourceInformationOf = obj.slots;
                currentSlot = obj.currentSlot;
                if (isNode != 0) {
                    sourceInformationOf[currentSlot] = obj3;
                    currentSlot = z;
                }
                if (i4 != 0) {
                    sourceInformationOf[currentSlot] = obj2;
                    currentSlot = z;
                }
                if (i != 0) {
                    sourceInformationOf[currentSlot] = obj3;
                    currentSlot = z;
                }
                obj.currentSlot = currentSlot;
            }
            obj.nodeCount = i7;
            obj.parent = groupIndexToAddress;
            obj.currentGroup = groupIndexToAddress + 1;
            sourceInformationOf = obj.sourceInformationOf(parent2);
            if (parent2 >= 0 && sourceInformationOf != null) {
                sourceInformationOf = obj.sourceInformationOf(parent2);
                if (sourceInformationOf != null) {
                    sourceInformationOf.reportGroup(obj, groupIndexToAddress);
                }
            }
        } else {
            obj.startStack.push(parent2);
            obj.saveCurrentGroupEnd();
            int currentGroup2 = obj.currentGroup;
            groupIndexToAddress = obj.groupIndexToAddress(currentGroup2);
            if (!Intrinsics.areEqual(obj3, Composer.Companion.getEmpty())) {
                if (isNode != 0) {
                    obj.updateNode(obj3);
                } else {
                    obj.updateAux(obj3);
                }
            }
            obj.currentSlot = obj.slotIndex(obj.groups, groupIndexToAddress);
            obj.currentSlotEnd = obj.dataIndex(obj.groups, obj.groupIndexToAddress(currentGroup3 += sourceInformationOf));
            obj.nodeCount = SlotTableKt.access$nodeCount(obj.groups, groupIndexToAddress);
            obj.parent = currentGroup2;
            obj.currentGroup = currentGroup2 + 1;
            currentGroup = sourceInformationOf;
        }
        obj.currentGroupEnd = currentGroup;
    }

    private final void updateAnchors(int previousGapStart, int newGapStart) {
        int index;
        int size;
        int location$runtime_release;
        int i;
        int i2;
        capacity -= groupGapLen;
        if (previousGapStart < newGapStart) {
            index = SlotTableKt.access$locationOf(this.anchors, previousGapStart, i3);
            while (index < this.anchors.size()) {
                size = this.anchors.get(index);
                location$runtime_release = (Anchor)size.getLocation$runtime_release();
                size.setLocation$runtime_release(i3 + location$runtime_release);
                index++;
            }
        } else {
            index = SlotTableKt.access$locationOf(this.anchors, newGapStart, i3);
            while (index < this.anchors.size()) {
                size = this.anchors.get(index);
                location$runtime_release = (Anchor)size.getLocation$runtime_release();
                if (location$runtime_release < 0) {
                    break;
                } else {
                }
                size.setLocation$runtime_release(-i4);
                index++;
            }
        }
    }

    private final void updateContainsMark(int group) {
        androidx.compose.runtime.PrioritySet pendingRecalculateMarks;
        androidx.compose.runtime.PrioritySet set;
        int i;
        if (group >= 0 && this.pendingRecalculateMarks == null) {
            if (this.pendingRecalculateMarks == null) {
                int i3 = 0;
                pendingRecalculateMarks = new PrioritySet(i3, 1, i3);
                i = 0;
                this.pendingRecalculateMarks = pendingRecalculateMarks;
            }
            pendingRecalculateMarks.add(group);
        }
    }

    private final void updateContainsMarkNow(int group, androidx.compose.runtime.PrioritySet set) {
        int i;
        int parent;
        final int groupIndexToAddress = groupIndexToAddress(group);
        final boolean childContainsAnyMarks = childContainsAnyMarks(group);
        i = SlotTableKt.access$containsMark(this.groups, groupIndexToAddress) != childContainsAnyMarks ? 1 : 0;
        SlotTableKt.access$updateContainsMark(this.groups, groupIndexToAddress, childContainsAnyMarks);
        parent = parent(group);
        if (i != 0 && parent >= 0) {
            SlotTableKt.access$updateContainsMark(this.groups, groupIndexToAddress, childContainsAnyMarks);
            parent = parent(group);
            if (parent >= 0) {
                set.add(parent);
            }
        }
    }

    private final void updateDataIndex(int[] $this$updateDataIndex, int address, int dataIndex) {
        SlotTableKt.access$updateDataAnchor($this$updateDataIndex, address, dataIndexToDataAnchor(dataIndex, this.slotsGapStart, this.slotsGapLen, slots.length));
    }

    private final void updateNodeOfGroup(int index, Object value) {
        int length;
        int i;
        String $i$a$RuntimeCheckSlotWriter$updateNodeOfGroup$1;
        StringBuilder append;
        String str;
        final int groupIndexToAddress = groupIndexToAddress(index);
        if (groupIndexToAddress < groups.length && SlotTableKt.access$isNode(this.groups, groupIndexToAddress)) {
            i = SlotTableKt.access$isNode(this.groups, groupIndexToAddress) ? 1 : 0;
        } else {
        }
        int i2 = 0;
        if (i == 0) {
            int i3 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            ComposerKt.composeImmediateRuntimeError(stringBuilder.append("Updating the node of a group at ").append(index).append(" that was not created with as a node group").toString());
        }
        this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))] = value;
    }

    public final void advanceBy(int amount) {
        int i2;
        int i3;
        int i;
        int $i$a$RuntimeCheckSlotWriter$advanceBy$3;
        String $i$a$RuntimeCheckSlotWriter$advanceBy$1;
        int i4;
        i2 = 1;
        int i5 = 0;
        i3 = amount >= 0 ? i2 : i5;
        int i8 = 0;
        if (i3 == 0) {
            int i11 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot seek backwards");
        }
        i = this.insertCount <= 0 ? i2 : i5;
        int i9 = 0;
        if (i == 0) {
            int i12 = 0;
            PreconditionsKt.throwIllegalStateException("Cannot call seek() while inserting");
        }
        if (amount == 0) {
        }
        currentGroup += amount;
        if (i7 >= this.parent && i7 <= this.currentGroupEnd) {
            if (i7 <= this.currentGroupEnd) {
            } else {
                i2 = i5;
            }
        } else {
        }
        int i6 = 0;
        if (i2 == 0) {
            int i10 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            ComposerKt.composeImmediateRuntimeError(stringBuilder.append("Cannot seek outside the current group (").append(this.parent).append('-').append(this.currentGroupEnd).append(')').toString());
        }
        this.currentGroup = i7;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i7));
        this.currentSlot = dataIndex;
        this.currentSlotEnd = dataIndex;
    }

    public final androidx.compose.runtime.Anchor anchor(int index) {
        Object obj;
        Object anchor;
        int i;
        final ArrayList anchors = this.anchors;
        final int i2 = 0;
        final int i3 = SlotTableKt.access$search(anchors, index, getSize$runtime_release());
        if (i3 < 0) {
            int i4 = 0;
            if (index <= this.groupGapStart) {
                i = index;
            } else {
                i = -i6;
            }
            anchor = new Anchor(i);
            anchors.add(-i5, anchor);
        } else {
            anchor = obj;
        }
        return anchor;
    }

    public final int anchorIndex(androidx.compose.runtime.Anchor anchor) {
        int it;
        int i;
        it = anchor.getLocation$runtime_release();
        final int i2 = 0;
        if (it < 0) {
            it = i;
        }
        return it;
    }

    public final void appendSlot(androidx.compose.runtime.Anchor anchor, Object value) {
        int i;
        int value$iv;
        int previousCurrentSlotEnd;
        String $i$a$RuntimeCheckSlotWriter$appendSlot$1;
        int i2 = 1;
        i = this.insertCount == 0 ? i2 : 0;
        int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
        }
        value$iv = this.currentSlot;
        int anchorIndex = anchorIndex(anchor);
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(anchorIndex + 1));
        this.currentSlot = dataIndex;
        this.currentSlotEnd = dataIndex;
        insertSlots(i2, anchorIndex);
        if (value$iv >= dataIndex) {
            value$iv++;
            previousCurrentSlotEnd++;
        }
        this.slots[dataIndex] = value;
        this.currentSlot = value$iv;
        this.currentSlotEnd = previousCurrentSlotEnd;
    }

    public final void bashCurrentGroup() {
        SlotTableKt.access$updateGroupKey(this.groups, this.currentGroup, -3);
    }

    public final void beginInsert() {
        final int insertCount = this.insertCount;
        this.insertCount = insertCount + 1;
        if (insertCount == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void close(boolean normalClose) {
        int empty;
        int groupGapStart;
        this.closed = true;
        if (normalClose && this.startStack.isEmpty()) {
            if (this.startStack.isEmpty()) {
                moveGroupGapTo(getSize$runtime_release());
                moveSlotGapTo(length -= slotsGapLen, this.groupGapStart);
                clearSlotGap();
                recalculateMarks();
            }
        }
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors, this.sourceInformationMap, this.calledByMap);
    }

    public final int endGroup() {
        int currentAddress;
        int i2;
        int groupIndexToAddress;
        int nodesDelta;
        int parent;
        String $i$a$RuntimeCheckSlotWriter$endGroup$1;
        int i3;
        int parent2;
        int i4;
        int current;
        int inserting;
        int i5;
        int oldGroupSize;
        int i;
        final Object obj = this;
        i2 = 1;
        nodesDelta = 0;
        currentAddress = obj.insertCount > 0 ? i2 : nodesDelta;
        final int currentGroup = obj.currentGroup;
        final int parent3 = obj.parent;
        final int groupIndexToAddress3 = obj.groupIndexToAddress(parent3);
        final int nodeCount2 = obj.nodeCount;
        final int i8 = currentGroup - parent3;
        boolean z2 = SlotTableKt.access$isNode(obj.groups, groupIndexToAddress3);
        if (currentAddress != 0) {
            SlotTableKt.access$updateGroupSize(obj.groups, groupIndexToAddress3, i8);
            SlotTableKt.access$updateNodeCount(obj.groups, groupIndexToAddress3, nodeCount2);
            i3 = z2 ? i2 : nodeCount2;
            obj.nodeCount = i10 += i3;
            obj.parent = obj.parent(obj.groups, parent3);
            if (obj.parent < 0) {
                groupIndexToAddress = obj.getSize$runtime_release();
            } else {
                groupIndexToAddress = obj.groupIndexToAddress(parent5 += i2);
            }
            if (groupIndexToAddress < 0) {
            } else {
                nodesDelta = obj.dataIndex(obj.groups, groupIndexToAddress);
            }
            obj.currentSlot = nodesDelta;
            obj.currentSlotEnd = nodesDelta;
            inserting = currentAddress;
        } else {
            if (currentGroup == obj.currentGroupEnd) {
            } else {
                i2 = nodesDelta;
            }
            int i9 = 0;
            if (i2 == 0) {
                int i12 = 0;
                ComposerKt.composeImmediateRuntimeError("Expected to be at the end of a group");
            }
            groupIndexToAddress = SlotTableKt.access$groupSize(obj.groups, groupIndexToAddress3);
            parent = SlotTableKt.access$nodeCount(obj.groups, groupIndexToAddress3);
            SlotTableKt.access$updateGroupSize(obj.groups, groupIndexToAddress3, i8);
            SlotTableKt.access$updateNodeCount(obj.groups, groupIndexToAddress3, nodeCount2);
            i3 = obj.startStack.pop();
            obj.restoreCurrentGroupEnd();
            obj.parent = i3;
            parent2 = obj.parent(obj.groups, parent3);
            obj.nodeCount = obj.nodeCountStack.pop();
            if (parent2 == i3) {
                if (z2) {
                } else {
                    nodesDelta = nodeCount2 - parent;
                }
                obj.nodeCount = nodeCount3 += nodesDelta;
                inserting = currentAddress;
            } else {
                i4 = i8 - groupIndexToAddress;
                if (z2) {
                } else {
                    nodesDelta = nodeCount2 - parent;
                }
                if (i4 == 0) {
                    if (nodesDelta != 0) {
                        current = parent2;
                        while (current != 0) {
                            int groupIndexToAddress2 = obj.groupIndexToAddress(current);
                            if (i4 != 0) {
                            } else {
                            }
                            oldGroupSize = groupIndexToAddress;
                            i = nodesDelta;
                            if (i != 0) {
                            }
                            if (SlotTableKt.access$isNode(obj.groups, groupIndexToAddress2)) {
                            } else {
                            }
                            nodesDelta = i;
                            current = obj.parent(obj.groups, current);
                            currentAddress = i5;
                            groupIndexToAddress = oldGroupSize;
                            nodesDelta = 0;
                            SlotTableKt.access$updateNodeCount(obj.groups, groupIndexToAddress2, i7 += i);
                            oldGroupSize = groupIndexToAddress;
                            i = nodesDelta;
                            SlotTableKt.access$updateGroupSize(obj.groups, groupIndexToAddress2, i6 += i4);
                        }
                        inserting = currentAddress;
                        oldGroupSize = groupIndexToAddress;
                        i = nodesDelta;
                        nodesDelta = i;
                    } else {
                        inserting = currentAddress;
                        oldGroupSize = groupIndexToAddress;
                    }
                } else {
                }
                obj.nodeCount = nodeCount += nodesDelta;
            }
        }
        return nodeCount2;
    }

    public final void endInsert() {
        int i2;
        int insertCount;
        int i;
        int $i$a$RuntimeCheckSlotWriter$endInsert$2;
        int size;
        String $i$a$CheckPreconditionSlotWriter$endInsert$1;
        $i$a$RuntimeCheckSlotWriter$endInsert$2 = 0;
        i2 = this.insertCount > 0 ? i : $i$a$RuntimeCheckSlotWriter$endInsert$2;
        size = 0;
        if (i2 == 0) {
            int i5 = 0;
            PreconditionsKt.throwIllegalStateException("Unbalanced begin/end insert");
        }
        this.insertCount = value$iv--;
        if (this.insertCount == 0) {
            if (this.nodeCountStack.getSize() == this.startStack.getSize()) {
            } else {
                i = $i$a$RuntimeCheckSlotWriter$endInsert$2;
            }
            insertCount = 0;
            if (i == 0) {
                int i4 = 0;
                ComposerKt.composeImmediateRuntimeError("startGroup/endGroup mismatch while inserting");
            }
            restoreCurrentGroupEnd();
        }
    }

    public final void ensureStarted(int index) {
        int i;
        int value$iv;
        int currentSlot;
        int $i$a$RuntimeCheckSlotWriter$ensureStarted$2;
        String $i$a$RuntimeCheckSlotWriter$ensureStarted$1;
        String str;
        currentSlot = 0;
        i = this.insertCount <= 0 ? value$iv : currentSlot;
        $i$a$RuntimeCheckSlotWriter$ensureStarted$2 = 0;
        if (i == 0) {
            int i4 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot call ensureStarted() while inserting");
        }
        int value$iv2 = this.parent;
        if (value$iv2 != index) {
            if (index >= value$iv2 && index < this.currentGroupEnd) {
                if (index < this.currentGroupEnd) {
                } else {
                    value$iv = currentSlot;
                }
            } else {
            }
            int i2 = 0;
            if (value$iv == 0) {
                int i3 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                ComposerKt.composeImmediateRuntimeError(stringBuilder.append("Started group at ").append(index).append(" must be a subgroup of the group at ").append(value$iv2).toString());
            }
            this.currentGroup = index;
            startGroup();
            this.currentGroup = this.currentGroup;
            this.currentSlot = this.currentSlot;
            this.currentSlotEnd = this.currentSlotEnd;
        }
    }

    public final void ensureStarted(androidx.compose.runtime.Anchor anchor) {
        ensureStarted(anchor.toIndexFor(this));
    }

    public final void forAllData(int group, Function2<? super Integer, Object, Unit> block) {
        int slot;
        int groupSize;
        Object obj;
        int i;
        final int i2 = 0;
        slot = i4;
        while (slot < SlotWriter.access$dataIndex(this, SlotWriter.access$getGroups$p(this), SlotWriter.access$groupIndexToAddress(this, currentGroup += groupSize))) {
            block.invoke(Integer.valueOf(slot), SlotWriter.access$getSlots$p(this)[SlotWriter.access$dataIndexToDataAddress(this, slot)]);
            slot++;
        }
    }

    public final void forEachData(int group, Function2<? super Integer, Object, Unit> block) {
        int slot;
        Integer valueOf;
        Object obj;
        int i;
        final int i2 = 0;
        int i4 = SlotWriter.access$slotIndex(this, SlotWriter.access$getGroups$p(this), SlotWriter.access$groupIndexToAddress(this, group));
        slot = i4;
        while (slot < SlotWriter.access$dataIndex(this, SlotWriter.access$getGroups$p(this), SlotWriter.access$groupIndexToAddress(this, group + 1))) {
            block.invoke(Integer.valueOf(slot - i4), SlotWriter.access$getSlots$p(this)[SlotWriter.access$dataIndexToDataAddress(this, slot)]);
            slot++;
        }
    }

    public final void forEachTailSlot(int groupIndex, int count, Function2<? super Integer, Object, Unit> block) {
        int slotIndex;
        Integer valueOf;
        Object obj;
        int i;
        final int i2 = 0;
        final int slotsEndIndex$runtime_release = slotsEndIndex$runtime_release(groupIndex);
        slotIndex = Math.max(slotsStartIndex$runtime_release(groupIndex), slotsEndIndex$runtime_release - count);
        while (slotIndex < slotsEndIndex$runtime_release) {
            block.invoke(Integer.valueOf(slotIndex), SlotWriter.access$getSlots$p(this)[SlotWriter.access$dataIndexToDataAddress(this, slotIndex)]);
            slotIndex++;
        }
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final boolean getCollectingCalledInformation() {
        int i;
        i = this.calledByMap != null ? 1 : 0;
        return i;
    }

    public final boolean getCollectingSourceInformation() {
        int i;
        i = this.sourceInformationMap != null ? 1 : 0;
        return i;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentGroupEnd() {
        return this.currentGroupEnd;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getSize$runtime_release() {
        return capacity -= groupGapLen;
    }

    public final int getSlotsSize() {
        return length -= slotsGapLen;
    }

    public final androidx.compose.runtime.SlotTable getTable$runtime_release() {
        return this.table;
    }

    public final Object groupAux(int index) {
        Object empty;
        int auxIndex;
        final int groupIndexToAddress = groupIndexToAddress(index);
        if (SlotTableKt.access$hasAux(this.groups, groupIndexToAddress)) {
            empty = this.slots[auxIndex(this.groups, groupIndexToAddress)];
        } else {
            empty = Composer.Companion.getEmpty();
        }
        return empty;
    }

    public final int groupKey(int index) {
        return SlotTableKt.access$key(this.groups, groupIndexToAddress(index));
    }

    public final Object groupObjectKey(int index) {
        Object obj;
        int i;
        final int groupIndexToAddress = groupIndexToAddress(index);
        if (SlotTableKt.access$hasObjectKey(this.groups, groupIndexToAddress)) {
            obj = this.slots[SlotTableKt.access$objectKeyIndex(this.groups, groupIndexToAddress)];
        } else {
            obj = 0;
        }
        return obj;
    }

    public final int groupSize(int index) {
        return SlotTableKt.access$groupSize(this.groups, groupIndexToAddress(index));
    }

    public final Iterator<Object> groupSlots() {
        SlotWriter.groupSlots.1 anon = new SlotWriter.groupSlots.1(dataIndex(this.groups, groupIndexToAddress(this.currentGroup)), dataIndex(this.groups, groupIndexToAddress(currentGroup2 += groupSize)), this);
        return (Iterator)anon;
    }

    public final boolean indexInCurrentGroup(int index) {
        return indexInGroup(index, this.currentGroup);
    }

    public final boolean indexInGroup(int index, int group) {
        int openIndex;
        int i2;
        int i;
        int peek;
        if (group == this.parent) {
            openIndex = this.currentGroupEnd;
        } else {
            if (group > this.startStack.peekOr(0)) {
                groupSize += group;
            } else {
                int indexOf = this.startStack.indexOf(group);
                if (indexOf < 0) {
                    openIndex = i;
                } else {
                    openIndex = i;
                }
            }
        }
        if (index > group && index < openIndex) {
            if (index < openIndex) {
                i2 = 1;
            }
        }
        return i2;
    }

    public final boolean indexInParent(int index) {
        int i;
        int currentGroupEnd;
        if (index > this.parent) {
            if (index >= this.currentGroupEnd) {
                if (this.parent == 0 && index == 0) {
                    i = index == 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final void insertAux(Object value) {
        int i3;
        int slots;
        String $i$a$RuntimeCheckSlotWriter$insertAux$1;
        String $i$a$RuntimeCheckSlotWriter$insertAux$2;
        int currentSlot;
        int i2;
        int i4;
        Object $i$a$CheckPreconditionSlotWriter$insertAux$3;
        int i;
        final int i6 = 1;
        i3 = this.insertCount >= 0 ? i6 : slots;
        int i7 = 0;
        if (i3 == 0) {
            int i8 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot insert auxiliary data when not inserting");
        }
        int value$iv = this.parent;
        int groupIndexToAddress = groupIndexToAddress(value$iv);
        int i10 = 0;
        if (z ^= i6 == 0) {
            int i11 = 0;
            ComposerKt.composeImmediateRuntimeError("Group already has auxiliary data");
        }
        insertSlots(i6, value$iv);
        int auxIndex = auxIndex(this.groups, groupIndexToAddress);
        int dataIndexToDataAddress = dataIndexToDataAddress(auxIndex);
        currentSlot3 -= auxIndex;
        if (this.currentSlot > auxIndex && currentSlot < 3) {
            currentSlot3 -= auxIndex;
            if (currentSlot < 3) {
                slots = i6;
            }
            i4 = 0;
            if (slots == 0) {
                int i13 = 0;
                PreconditionsKt.throwIllegalStateException("Moving more than two slot not supported");
            }
            if (currentSlot > i6) {
                this.slots[dataIndexToDataAddress + 2] = this.slots[dataIndexToDataAddress + 1];
            }
            this.slots[dataIndexToDataAddress + 1] = this.slots[dataIndexToDataAddress];
        }
        SlotTableKt.access$addAux(this.groups, groupIndexToAddress);
        this.slots[dataIndexToDataAddress] = value;
        this.currentSlot = currentSlot2 += i6;
    }

    public final boolean isGroupEnd() {
        int i;
        i = this.currentGroup == this.currentGroupEnd ? 1 : 0;
        return i;
    }

    public final boolean isNode() {
        int currentGroup;
        int i;
        int groupIndexToAddress;
        if (this.currentGroup < this.currentGroupEnd && SlotTableKt.access$isNode(this.groups, groupIndexToAddress(this.currentGroup))) {
            i = SlotTableKt.access$isNode(this.groups, groupIndexToAddress(this.currentGroup)) ? 1 : 0;
        } else {
        }
        return i;
    }

    public final boolean isNode(int index) {
        return SlotTableKt.access$isNode(this.groups, groupIndexToAddress(index));
    }

    public final void markGroup(int group) {
        boolean parent;
        int i;
        final int groupIndexToAddress = groupIndexToAddress(group);
        SlotTableKt.access$updateMark(this.groups, groupIndexToAddress, true);
        if (!SlotTableKt.access$hasMark(this.groups, groupIndexToAddress) && !SlotTableKt.access$containsMark(this.groups, groupIndexToAddress)) {
            SlotTableKt.access$updateMark(this.groups, groupIndexToAddress, true);
            if (!SlotTableKt.access$containsMark(this.groups, groupIndexToAddress)) {
                updateContainsMark(parent(group));
            }
        }
    }

    public final List<androidx.compose.runtime.Anchor> moveFrom(androidx.compose.runtime.SlotTable table, int index, boolean removeSourceGroup) {
        int currentGroup;
        int groupsSize;
        final Object obj = this;
        int i = index;
        currentGroup = obj.insertCount > 0 ? 1 : 0;
        ComposerKt.runtimeCheck(currentGroup);
        if (i == 0 && obj.currentGroup == 0 && obj.table.getGroupsSize() == 0 && SlotTableKt.access$groupSize(table.getGroups(), i) == table.getGroupsSize()) {
            if (obj.currentGroup == 0) {
                if (obj.table.getGroupsSize() == 0) {
                    if (SlotTableKt.access$groupSize(table.getGroups(), i) == table.getGroupsSize()) {
                        int[] groups2 = table.getGroups();
                        int groupsSize2 = table.getGroupsSize();
                        Object[] slots2 = table.getSlots();
                        final int slotsSize = table.getSlotsSize();
                        obj.groups = groups2;
                        obj.slots = slots2;
                        obj.anchors = table.getAnchors$runtime_release();
                        obj.groupGapStart = groupsSize2;
                        obj.groupGapLen = i4 -= groupsSize2;
                        obj.slotsGapStart = slotsSize;
                        obj.slotsGapLen = length2 -= slotsSize;
                        obj.slotsGapOwner = groupsSize2;
                        obj.sourceInformationMap = table.getSourceInformationMap$runtime_release();
                        obj.calledByMap = table.getCalledByMap$runtime_release();
                        table.setTo$runtime_release(obj.groups, 0, obj.slots, 0, obj.anchors, obj.sourceInformationMap, obj.calledByMap);
                        return (List)obj.anchors;
                    }
                }
            }
        }
        int i9 = 0;
        androidx.compose.runtime.SlotWriter writer3 = writer;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        List list = SlotWriter.Companion.access$moveGroup(SlotWriter.Companion, writer3, i, obj, true, true, removeSourceGroup);
        List tableWriter = list;
        int i2 = 0;
        writer3.close(true);
        return list;
    }

    public final void moveGroup(int offset) {
        int i4;
        int i5;
        int slots;
        int dataIndexToDataAddress;
        int slotsGapStart;
        int slotsGapOwner;
        String $i$a$RuntimeCheckSlotWriter$moveGroup$1;
        int i10;
        int dataIndexToDataAddress2;
        int count2;
        int count;
        int value$iv;
        int groupToMove2;
        int groupToMove;
        int i6;
        int i7;
        int i9;
        int i2;
        String $i$a$RuntimeCheckSlotWriter$moveGroup$4;
        int parentEnd;
        int i3;
        int dataIndex;
        int i8;
        int i;
        final Object obj = this;
        int i11 = 0;
        int i14 = 1;
        i4 = obj.insertCount == 0 ? i14 : i11;
        int i16 = 0;
        if (i4 == 0) {
            int i19 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
        }
        i5 = offset >= 0 ? i14 : i11;
        int i17 = 0;
        String str = "Parameter offset is out of bounds";
        if (i5 == 0) {
            i10 = 0;
            ComposerKt.composeImmediateRuntimeError(str);
        }
        if (offset == null) {
        }
        int currentGroup = obj.currentGroup;
        dataIndexToDataAddress2 = obj.currentGroupEnd;
        count2 = offset;
        groupToMove2 = currentGroup;
        while (count2 > 0) {
            if (groupToMove2 += i23 <= dataIndexToDataAddress2) {
            } else {
            }
            i7 = i11;
            i9 = 0;
            if (i7 == 0) {
            }
            count2--;
            i2 = 0;
            ComposerKt.composeImmediateRuntimeError(str);
            i7 = i14;
        }
        int i18 = SlotTableKt.access$groupSize(obj.groups, obj.groupIndexToAddress(groupToMove2));
        int dataIndex2 = obj.dataIndex(obj.groups, obj.groupIndexToAddress(obj.currentGroup));
        int dataIndex3 = obj.dataIndex(obj.groups, obj.groupIndexToAddress(groupToMove2));
        int dataIndex4 = obj.dataIndex(obj.groups, obj.groupIndexToAddress(groupToMove2 + i18));
        int i25 = dataIndex4 - dataIndex3;
        obj.insertSlots(i25, Math.max(currentGroup3 -= i14, i11));
        obj.insertGroups(i18);
        int[] groups7 = obj.groups;
        final int i29 = groupIndexToAddress7 * 5;
        final int i32 = i14;
        ArraysKt.copyInto(groups7, groups7, groupIndexToAddress8 * 5, i29, i29 + i31);
        if (i25 > 0) {
            slots = obj.slots;
            parentEnd = dataIndexToDataAddress2;
            ArraysKt.copyInto(slots, slots, dataIndex2, obj.dataIndexToDataAddress(dataIndex3 + i25), obj.dataIndexToDataAddress(dataIndex4 + i25));
        } else {
            parentEnd = dataIndexToDataAddress2;
        }
        slotsGapStart = obj.slotsGapOwner;
        final int i35 = count2;
        count = currentGroup + i18;
        final int i36 = groupToMove2;
        groupToMove = i3;
        while (groupToMove < count) {
            int groupIndexToAddress = obj.groupIndexToAddress(groupToMove);
            if (slotsGapStart < groupIndexToAddress) {
            } else {
            }
            slotsGapOwner = i34;
            obj.updateDataIndex(groups7, groupIndexToAddress, obj.dataIndexToDataAnchor(dataIndex - i33, slotsGapOwner, obj.slotsGapLen, dataMoveDistance.length));
            groupToMove = i8 + 1;
            count = i3;
            slotsGapStart = i;
            slotsGapOwner = 0;
        }
        int slotsGapOwner2 = slotsGapStart;
        int i37 = groupToMove;
        obj.moveAnchors(i36 + i18, currentGroup, i18);
        i6 = 0;
        if (groups ^ 1 == 0) {
            int i30 = 0;
            ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
        }
        obj.fixParentAnchorsFor(obj.parent, obj.currentGroupEnd, currentGroup);
        if (i25 > 0) {
            obj.removeSlots(dataIndex3 + i25, i25, i22--);
        }
    }

    public final List<androidx.compose.runtime.Anchor> moveIntoGroupFrom(int offset, androidx.compose.runtime.SlotTable table, int index) {
        int insertCount;
        int i;
        boolean this_$iv;
        boolean z;
        final Object obj = this;
        if (obj.insertCount <= 0 && obj.groupSize(currentGroup += offset) == 1) {
            if (obj.groupSize(currentGroup += offset) == 1) {
            } else {
                i = 0;
            }
        } else {
        }
        ComposerKt.runtimeCheck(i);
        advanceBy(offset);
        obj.startGroup();
        obj.beginInsert();
        boolean obj2 = table;
        final int i11 = 0;
        final androidx.compose.runtime.SlotWriter writer2 = writer;
        final int i12 = 0;
        final int i13 = 0;
        final boolean obj3 = obj2;
        int this_$iv2 = i4;
        List moveGroup$default = SlotWriter.Companion.moveGroup$default(SlotWriter.Companion, writer2, index, obj, false, true, false, 32, 0);
        List tableWriter = moveGroup$default;
        int i5 = 0;
        writer2.close(true);
        obj.endInsert();
        obj.endGroup();
        obj.currentGroup = obj.currentGroup;
        obj.currentSlot = obj.currentSlot;
        obj.currentSlotEnd = obj.currentSlotEnd;
        return moveGroup$default;
    }

    public final List<androidx.compose.runtime.Anchor> moveTo(androidx.compose.runtime.Anchor anchor, int offset, androidx.compose.runtime.SlotWriter writer) {
        int i5;
        int i4;
        int currentGroupEnd;
        int i;
        int nodeCount;
        int current;
        int updatingNodes;
        int groupIndexToAddress;
        int groups;
        int i2;
        int i3;
        Object obj2 = writer;
        i3 = 1;
        final int i11 = 0;
        i5 = obj2.insertCount > 0 ? i3 : i11;
        ComposerKt.runtimeCheck(i5);
        i4 = this.insertCount == 0 ? i3 : i11;
        ComposerKt.runtimeCheck(i4);
        ComposerKt.runtimeCheck(anchor.getValid());
        final int i6 = currentGroupEnd + offset;
        final int currentGroup = this.currentGroup;
        if (currentGroup <= i6 && i6 < this.currentGroupEnd) {
            i = i6 < this.currentGroupEnd ? i3 : i11;
        } else {
        }
        ComposerKt.runtimeCheck(i);
        final int parent = parent(i6);
        if (isNode(i6)) {
            nodeCount = i3;
        } else {
            nodeCount = nodeCount(i6);
        }
        final int i12 = nodeCount;
        updateContainsMark(parent);
        current = parent;
        updatingNodes = i12 > 0 ? i3 : i11;
        while (current >= currentGroup) {
            groupIndexToAddress = groupIndexToAddress(current);
            SlotTableKt.access$updateGroupSize(this.groups, groupIndexToAddress, i8 -= groupSize);
            if (updatingNodes != 0) {
            }
            current = parent(current);
            if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress)) {
            } else {
            }
            SlotTableKt.access$updateNodeCount(this.groups, groupIndexToAddress, i9 -= i12);
            updatingNodes = 0;
        }
        if (updatingNodes != 0) {
            if (this.nodeCount >= i12) {
            } else {
                i3 = i11;
            }
            ComposerKt.runtimeCheck(i3);
            this.nodeCount = nodeCount3 -= i12;
        }
        return SlotWriter.Companion.moveGroup$default(SlotWriter.Companion, this, i6, obj2, false, false, false, 32, 0);
    }

    public final Object node(int index) {
        Object obj;
        int dataIndexToDataAddress;
        final int groupIndexToAddress = groupIndexToAddress(index);
        if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress)) {
            obj = this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))];
        } else {
            obj = 0;
        }
        return obj;
    }

    public final Object node(androidx.compose.runtime.Anchor anchor) {
        return node(anchor.toIndexFor(this));
    }

    public final int nodeCount(int index) {
        return SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress(index));
    }

    public final int parent(int index) {
        return parent(this.groups, index);
    }

    public final int parent(androidx.compose.runtime.Anchor anchor) {
        int parent;
        int anchorIndex;
        if (anchor.getValid()) {
            parent = parent(this.groups, anchorIndex(anchor));
        } else {
            parent = -1;
        }
        return parent;
    }

    public final void recordGroupSourceInformation(String sourceInformation) {
        int insertCount;
        if (this.insertCount > 0) {
            groupSourceInformationFor(this.parent, sourceInformation);
        }
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        int groupSourceInformationFor;
        int currentGroupSlotIndex;
        groupSourceInformationFor = groupSourceInformationFor(this.parent, 0);
        if (this.insertCount > 0 && groupSourceInformationFor != null) {
            groupSourceInformationFor = groupSourceInformationFor(this.parent, 0);
            if (groupSourceInformationFor != null) {
                groupSourceInformationFor.endGrouplessCall(getCurrentGroupSlotIndex());
            }
        }
    }

    public final void recordGrouplessCallSourceInformationStart(int key, String value) {
        int groupSourceInformationFor;
        int currentGroupSlotIndex;
        MutableIntObjectMap calledByMap = this.calledByMap;
        if (this.insertCount > 0 && calledByMap != null) {
            calledByMap = this.calledByMap;
            if (calledByMap != null) {
                SlotTableKt.access$add(calledByMap, key, groupKey(this.parent));
            }
            groupSourceInformationFor = groupSourceInformationFor(this.parent, 0);
            if (groupSourceInformationFor != null) {
                groupSourceInformationFor.startGrouplessCall(key, value, getCurrentGroupSlotIndex());
            }
        }
    }

    public final boolean removeGroup() {
        int i;
        String $i$a$RuntimeCheckSlotWriter$removeGroup$1;
        int i3;
        androidx.compose.runtime.Anchor tryAnchor$runtime_release;
        int i2;
        i = this.insertCount == 0 ? 1 : 0;
        int i4 = 0;
        if (i == 0) {
            int i5 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot remove group while inserting");
        }
        int value$iv = this.currentGroup;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(value$iv));
        androidx.compose.runtime.GroupSourceInformation sourceInformationOf = sourceInformationOf(this.parent);
        i3 = 0;
        tryAnchor$runtime_release = tryAnchor$runtime_release(value$iv);
        if (sourceInformationOf != null && tryAnchor$runtime_release != null) {
            i3 = 0;
            tryAnchor$runtime_release = tryAnchor$runtime_release(value$iv);
            if (tryAnchor$runtime_release != null) {
                i2 = 0;
                sourceInformationOf.removeAnchor(tryAnchor$runtime_release);
            }
        }
        androidx.compose.runtime.PrioritySet pendingRecalculateMarks = this.pendingRecalculateMarks;
        if (pendingRecalculateMarks != null) {
            i3 = 0;
            while (pendingRecalculateMarks.isNotEmpty()) {
                if (pendingRecalculateMarks.peek() >= value$iv) {
                }
                pendingRecalculateMarks.takeMax();
            }
        }
        removeSlots(dataIndex, currentSlot2 -= dataIndex, value$iv + -1);
        this.currentGroup = value$iv;
        this.currentSlot = this.currentSlot;
        this.nodeCount = nodeCount -= skipGroup;
        return removeGroups(value$iv, currentGroup -= value$iv);
    }

    public final void reset() {
        int i;
        String $i$a$RuntimeCheckSlotWriter$reset$1;
        final int i3 = 0;
        i = this.insertCount == 0 ? 1 : i3;
        int i4 = 0;
        if (i == 0) {
            int i5 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
        }
        recalculateMarks();
        this.currentGroup = i3;
        this.currentGroupEnd = capacity -= groupGapLen;
        this.currentSlot = i3;
        this.currentSlotEnd = i3;
        this.nodeCount = i3;
    }

    public final void seek(androidx.compose.runtime.Anchor anchor) {
        advanceBy(indexFor -= currentGroup);
    }

    public final Object set(int group, int index, Object value) {
        final int dataIndexToDataAddress = dataIndexToDataAddress(slotIndexOfGroupSlotIndex(group, index));
        this.slots[dataIndexToDataAddress] = value;
        return this.slots[dataIndexToDataAddress];
    }

    public final Object set(int index, Object value) {
        return set(this.currentGroup, index, value);
    }

    public final void set(Object value) {
        int i;
        String $i$a$RuntimeCheckSlotWriter$set$1;
        final int i4 = 1;
        i = this.currentSlot <= this.currentSlotEnd ? i4 : 0;
        int i2 = 0;
        if (i == 0) {
            int i5 = 0;
            ComposerKt.composeImmediateRuntimeError("Writing to an invalid slot");
        }
        this.slots[dataIndexToDataAddress(currentSlot2 -= i4)] = value;
    }

    public final Object skip() {
        int insertCount;
        int i;
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        int currentSlot = this.currentSlot;
        this.currentSlot = currentSlot + 1;
        return this.slots[dataIndexToDataAddress(currentSlot)];
    }

    public final int skipGroup() {
        int i;
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        currentGroup2 += i3;
        this.currentGroup = i2;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i2));
        if (SlotTableKt.access$isNode(this.groups, groupIndexToAddress)) {
            i = 1;
        } else {
            i = SlotTableKt.access$nodeCount(this.groups, groupIndexToAddress);
        }
        return i;
    }

    public final void skipToGroupEnd() {
        final int currentGroupEnd = this.currentGroupEnd;
        this.currentGroup = currentGroupEnd;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(currentGroupEnd));
    }

    public final Object slot(int groupIndex, int index) {
        int i;
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(groupIndex));
        int i3 = slotIndex + index;
        i = 0;
        if (slotIndex <= i3 && i3 < dataIndex(this.groups, groupIndexToAddress(groupIndex + 1))) {
            if (i3 < dataIndex(this.groups, groupIndexToAddress(groupIndex + 1))) {
                i = 1;
            }
        }
        if (i == 0) {
            return Composer.Companion.getEmpty();
        }
        return this.slots[dataIndexToDataAddress(i3)];
    }

    public final Object slot(androidx.compose.runtime.Anchor anchor, int index) {
        return slot(anchorIndex(anchor), index);
    }

    public final int slotIndexOfGroupSlotIndex(int group, int index) {
        int i;
        String $i$a$RuntimeCheckSlotWriter$slotIndexOfGroupSlotIndex$1;
        StringBuilder append;
        String str;
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(group));
        int i3 = slotIndex + index;
        if (i3 >= slotIndex && i3 < dataIndex(this.groups, groupIndexToAddress(group + 1))) {
            i = i3 < dataIndex(this.groups, groupIndexToAddress(group + 1)) ? 1 : 0;
        } else {
        }
        final int i4 = 0;
        if (i == 0) {
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            ComposerKt.composeImmediateRuntimeError(stringBuilder.append("Write to an invalid slot index ").append(index).append(" for group ").append(group).toString());
        }
        return i3;
    }

    public final int slotsEndAllIndex$runtime_release(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupSize += groupIndex));
    }

    public final int slotsEndIndex$runtime_release(int groupIndex) {
        return dataIndex(this.groups, groupIndexToAddress(groupIndex + 1));
    }

    public final int slotsStartIndex$runtime_release(int groupIndex) {
        return slotIndex(this.groups, groupIndexToAddress(groupIndex));
    }

    public final void startData(int key, Object aux) {
        startGroup(key, Composer.Companion.getEmpty(), false, aux);
    }

    public final void startData(int key, Object objectKey, Object aux) {
        startGroup(key, objectKey, false, aux);
    }

    public final void startGroup() {
        int i;
        String $i$a$RuntimeCheckSlotWriter$startGroup$1;
        final int i2 = 0;
        i = this.insertCount == 0 ? 1 : i2;
        int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            ComposerKt.composeImmediateRuntimeError("Key must be supplied when inserting");
        }
        startGroup(i2, Composer.Companion.getEmpty(), i2, Composer.Companion.getEmpty());
    }

    public final void startGroup(int key) {
        startGroup(key, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
    }

    public final void startGroup(int key, Object dataKey) {
        startGroup(key, dataKey, false, Composer.Companion.getEmpty());
    }

    public final void startNode(int key, Object objectKey) {
        startGroup(key, objectKey, true, Composer.Companion.getEmpty());
    }

    public final void startNode(int key, Object objectKey, Object node) {
        startGroup(key, objectKey, true, node);
    }

    public final String toDebugString() {
        int index;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i = 0;
        StringBuilder append = sb.append(toString());
        String str2 = "append(value)";
        Intrinsics.checkNotNullExpressionValue(append, str2);
        final int i2 = 10;
        final String str3 = "append('\\n')";
        Intrinsics.checkNotNullExpressionValue(append.append(i2), str3);
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder append5 = sb.append(stringBuilder2.append("  parent:    ").append(this.parent).toString());
        Intrinsics.checkNotNullExpressionValue(append5, str2);
        Intrinsics.checkNotNullExpressionValue(append5.append(i2), str3);
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder append9 = sb.append(stringBuilder3.append("  current:   ").append(this.currentGroup).toString());
        Intrinsics.checkNotNullExpressionValue(append9, str2);
        Intrinsics.checkNotNullExpressionValue(append9.append(i2), str3);
        StringBuilder stringBuilder4 = new StringBuilder();
        int i3 = 45;
        int i6 = 40;
        int i7 = 41;
        StringBuilder append18 = sb.append(stringBuilder4.append("  group gap: ").append(this.groupGapStart).append(i3).append(groupGapStart2 += groupGapLen).append(i6).append(this.groupGapLen).append(i7).toString());
        Intrinsics.checkNotNullExpressionValue(append18, str2);
        Intrinsics.checkNotNullExpressionValue(append18.append(i2), str3);
        StringBuilder stringBuilder5 = new StringBuilder();
        StringBuilder append27 = sb.append(stringBuilder5.append("  slots gap: ").append(this.slotsGapStart).append(i3).append(slotsGapStart += slotsGapLen2).append(i6).append(this.slotsGapLen).append(i7).toString());
        Intrinsics.checkNotNullExpressionValue(append27, str2);
        Intrinsics.checkNotNullExpressionValue(append27.append(i2), str3);
        StringBuilder stringBuilder6 = new StringBuilder();
        StringBuilder append31 = sb.append(stringBuilder6.append("  gap owner: ").append(this.slotsGapOwner).toString());
        Intrinsics.checkNotNullExpressionValue(append31, str2);
        Intrinsics.checkNotNullExpressionValue(append31.append(i2), str3);
        index = 0;
        while (index < getSize$runtime_release()) {
            groupAsString(sb, index);
            sb.append(i2);
            index++;
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SlotWriter(current = ").append(this.currentGroup).append(" end=").append(this.currentGroupEnd).append(" size = ").append(getSize$runtime_release()).append(" gap=").append(this.groupGapStart).append('-').append(groupGapStart2 += groupGapLen).append(')').toString();
    }

    public final void trimTailSlots(int count) {
        int i3;
        int i;
        int i2;
        i = 1;
        i2 = count > 0 ? i : i3;
        ComposerKt.runtimeCheck(i2);
        int parent = this.parent;
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(parent));
        int i5 = dataIndex - count;
        if (i5 >= slotIndex) {
            i3 = i;
        }
        ComposerKt.runtimeCheck(i3);
        removeSlots(i5, count, parent);
        int currentSlot = this.currentSlot;
        if (currentSlot >= slotIndex) {
            this.currentSlot = currentSlot - count;
        }
    }

    public final androidx.compose.runtime.Anchor tryAnchor$runtime_release(int group) {
        int i;
        int i2;
        int size$runtime_release;
        i = 0;
        if (group >= 0 && group < getSize$runtime_release()) {
            if (group < getSize$runtime_release()) {
                i = 1;
            }
        }
        if (i != 0) {
            i2 = SlotTableKt.access$find(this.anchors, group, getSize$runtime_release());
        } else {
            i2 = 0;
        }
        return i2;
    }

    public final Object update(Object value) {
        set(value);
        return skip();
    }

    public final void updateAux(Object value) {
        String $i$a$RuntimeCheckSlotWriter$updateAux$1;
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int i = 0;
        if (!SlotTableKt.access$hasAux(this.groups, groupIndexToAddress)) {
            int i2 = 0;
            ComposerKt.composeImmediateRuntimeError("Updating the data of a group that was not created with a data slot");
        }
        this.slots[dataIndexToDataAddress(auxIndex(this.groups, groupIndexToAddress))] = value;
    }

    public final void updateNode(androidx.compose.runtime.Anchor anchor, Object value) {
        updateNodeOfGroup(anchor.toIndexFor(this), value);
    }

    public final void updateNode(Object value) {
        updateNodeOfGroup(this.currentGroup, value);
    }

    public final void updateParentNode(Object value) {
        updateNodeOfGroup(this.parent, value);
    }

    public final void updateToTableMaps() {
        this.sourceInformationMap = this.table.getSourceInformationMap$runtime_release();
        this.calledByMap = this.table.getCalledByMap$runtime_release();
    }

    public final void verifyDataAnchors$runtime_release() {
        int previousDataIndex;
        int ownerFound;
        int index;
        int groupIndexToAddress;
        int i3;
        int dataIndex;
        int string;
        int i2;
        int $i$a$CheckPreconditionSlotWriter$verifyDataAnchors$3;
        int i;
        int $i$a$CheckPreconditionSlotWriter$verifyDataAnchors$2;
        int append;
        String str;
        final Object obj = this;
        previousDataIndex = 0;
        final int slotsGapOwner = obj.slotsGapOwner;
        ownerFound = 0;
        index = 0;
        while (index < obj.getSize$runtime_release()) {
            groupIndexToAddress = obj.groupIndexToAddress(index);
            dataIndex = obj.dataIndex(obj.groups, groupIndexToAddress);
            i2 = 1;
            if (dataIndex >= previousDataIndex) {
            } else {
            }
            i = 0;
            $i$a$CheckPreconditionSlotWriter$verifyDataAnchors$2 = 0;
            if (i == 0) {
            }
            if (dataIndex <= length -= slotsGapLen) {
            } else {
            }
            string = 0;
            $i$a$CheckPreconditionSlotWriter$verifyDataAnchors$3 = 0;
            if (string == null) {
            }
            if (SlotTableKt.access$dataAnchor(obj.groups, groupIndexToAddress) < 0 && ownerFound == 0) {
            }
            previousDataIndex = dataIndex;
            index++;
            if (ownerFound == 0) {
            }
            if (slotsGapOwner == index) {
            } else {
            }
            string = 0;
            i2 = 0;
            if (string == null) {
            }
            ownerFound = 1;
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder.append("Expected the slot gap owner to be ").append(slotsGapOwner).append(" found gap at ").append(index).toString());
            string = i2;
            int i6 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Data index, ").append(dataIndex).append(", out of bound at ").append(index).toString());
            string = i2;
            append = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder3.append("Data index out of order at ").append(index).append(", previous = ").append(previousDataIndex).append(", current = ").append(dataIndex).toString());
            i = i2;
        }
    }

    public final void verifyParentAnchors$runtime_release() {
        int groupAddress2;
        int groupAddress;
        String string;
        int i;
        int i6;
        int i4;
        int i3;
        StringBuilder parentAnchorToIndex;
        int i2;
        int i5;
        String $i$a$CheckPreconditionSlotWriter$verifyParentAnchors$2;
        StringBuilder append;
        String str;
        final int groupGapStart = this.groupGapStart;
        groupAddress2 = 0;
        string = "Expected a start relative anchor at ";
        i = 0;
        int i7 = -2;
        i4 = 1;
        while (groupAddress2 < groupGapStart) {
            if (SlotTableKt.access$parentAnchor(this.groups, groupAddress2) > i7) {
            }
            i6 = 0;
            if (i == 0) {
            }
            groupAddress2++;
            string = "Expected a start relative anchor at ";
            i = 0;
            i7 = -2;
            i4 = 1;
            i4 = 0;
            parentAnchorToIndex = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(parentAnchorToIndex.append(string).append(groupAddress2).toString());
            i = i4;
        }
        groupAddress = groupGapStart + groupGapLen;
        while (groupAddress < getCapacity()) {
            i3 = SlotTableKt.access$parentAnchor(this.groups, groupAddress);
            if (parentAnchorToIndex(i3) < groupGapStart) {
            } else {
            }
            if (i3 <= i7) {
            } else {
            }
            i2 = i;
            i5 = 0;
            if (i2 == 0) {
            }
            groupAddress++;
            int i9 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Expected an end relative anchor at ").append(groupAddress).toString());
            i2 = i4;
            if (i3 > i7) {
            } else {
            }
            i2 = i;
            i5 = 0;
            if (i2 == 0) {
            }
            int i8 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder.append(string).append(groupAddress).toString());
            i2 = i4;
        }
    }
}
