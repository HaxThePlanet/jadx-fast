package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.b;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.g.b;
import kotlin.b0.g.c;
import kotlin.b0.j.b;
import kotlin.b0.k.a.h;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.w;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.o.b;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.internal.y;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0001\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0012\u0008\u0017\u0018\u00002\u00020X2\u00020\u00172\u00020\u007f2\u00030Ã\u0001:\u0006Ò\u0001Ó\u0001Ô\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\u0008\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00112\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010\u001dJ\u0019\u0010!\u001a\u00020\u00012\u0008\u0010 \u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\u0008!\u0010\"J\u001f\u0010!\u001a\u00020\u00112\u000e\u0010 \u001a\n\u0018\u00010#j\u0004\u0018\u0001`$H\u0016¢\u0006\u0004\u0008!\u0010%J\u0017\u0010&\u001a\u00020\u00012\u0008\u0010 \u001a\u0004\u0018\u00010\r¢\u0006\u0004\u0008&\u0010\"J\u0019\u0010)\u001a\u00020\u00012\u0008\u0010 \u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\u0008'\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\u0008*\u0010+J\u001b\u0010,\u001a\u0004\u0018\u00010\u00052\u0008\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\u0008,\u0010-J\u0017\u0010.\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\u0008.\u0010\"J\u000f\u00100\u001a\u00020/H\u0014¢\u0006\u0004\u00080\u00101J\u0017\u00102\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\u00082\u0010\"J!\u00105\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002032\u0008\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\u00085\u00106J)\u0010;\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002072\u0006\u00109\u001a\u0002082\u0008\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\u0008;\u0010<J\u0019\u0010=\u001a\u00020\r2\u0008\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\u0008=\u0010>J(\u0010C\u001a\u00020@2\n\u0008\u0002\u0010?\u001a\u0004\u0018\u00010/2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010\rH\u0080\u0008¢\u0006\u0004\u0008A\u0010BJ#\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002072\u0008\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\u0008D\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u0001082\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\u0008F\u0010GJ\u0011\u0010H\u001a\u00060#j\u0002`$¢\u0006\u0004\u0008H\u0010IJ\u0013\u0010J\u001a\u00060#j\u0002`$H\u0016¢\u0006\u0004\u0008J\u0010IJ\u0011\u0010M\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\u0008K\u0010LJ\u000f\u0010N\u001a\u0004\u0018\u00010\r¢\u0006\u0004\u0008N\u0010OJ'\u0010P\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u0002072\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\u0008P\u0010QJ\u0019\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\u0008R\u0010SJ\u0017\u0010U\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\rH\u0014¢\u0006\u0004\u0008U\u0010\"J\u0017\u0010W\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0010¢\u0006\u0004\u0008V\u0010+J\u0019\u0010Z\u001a\u00020\u00112\u0008\u0010Y\u001a\u0004\u0018\u00010XH\u0004¢\u0006\u0004\u0008Z\u0010[JF\u0010d\u001a\u00020c2\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010]\u001a\u00020\u00012'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\u000c\u0008_\u0012\u0008\u0008`\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\u0008d\u0010eJ6\u0010d\u001a\u00020c2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\u000c\u0008_\u0012\u0008\u0008`\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\u0008d\u0010fJ\u0013\u0010g\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\u0008g\u0010\u001dJ\u000f\u0010h\u001a\u00020\u0001H\u0002¢\u0006\u0004\u0008h\u0010iJ\u0013\u0010j\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\u0008j\u0010\u001dJ&\u0010m\u001a\u00020l2\u0014\u0010k\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110^H\u0082\u0008¢\u0006\u0004\u0008m\u0010nJ\u001b\u0010o\u001a\u0004\u0018\u00010\u00052\u0008\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\u0008o\u0010-J\u0019\u0010q\u001a\u00020\u00012\u0008\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\u0008p\u0010(J\u001b\u0010s\u001a\u0004\u0018\u00010\u00052\u0008\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\u0008r\u0010-J@\u0010t\u001a\u00020\t2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\u000c\u0008_\u0012\u0008\u0008`\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00020\u00110^j\u0002`a2\u0006\u0010\\\u001a\u00020\u0001H\u0002¢\u0006\u0004\u0008t\u0010uJ\u000f\u0010w\u001a\u00020/H\u0010¢\u0006\u0004\u0008v\u00101J\u001f\u0010x\u001a\u00020\u00112\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\u0008x\u0010yJ.\u0010{\u001a\u00020\u0011\"\n\u0008\u0000\u0010z\u0018\u0001*\u00020\t2\u0006\u0010\u0008\u001a\u00020\u00072\u0008\u0010 \u001a\u0004\u0018\u00010\rH\u0082\u0008¢\u0006\u0004\u0008{\u0010yJ\u0019\u0010\\\u001a\u00020\u00112\u0008\u0010 \u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\u0008\\\u0010+J\u0019\u0010|\u001a\u00020\u00112\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\u0008|\u0010\u0016J\u000f\u0010}\u001a\u00020\u0011H\u0014¢\u0006\u0004\u0008}\u0010~J\u0019\u0010\u0081\u0001\u001a\u00020\u00112\u0007\u0010\u0080\u0001\u001a\u00020\u007f¢\u0006\u0006\u0008\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0084\u0001\u001a\u00020\u00112\u0007\u0010\u0014\u001a\u00030\u0083\u0001H\u0002¢\u0006\u0006\u0008\u0084\u0001\u0010\u0085\u0001J\u001a\u0010\u0086\u0001\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0006\u0008\u0086\u0001\u0010\u0087\u0001JI\u0010\u008c\u0001\u001a\u00020\u0011\"\u0005\u0008\u0000\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0089\u00012\u001d\u0010k\u001a\u0019\u0008\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050^ø\u0001\u0000¢\u0006\u0006\u0008\u008c\u0001\u0010\u008d\u0001JX\u0010\u0091\u0001\u001a\u00020\u0011\"\u0004\u0008\u0000\u0010z\"\u0005\u0008\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \u0008\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\u0008\u008f\u0001\u0010\u0090\u0001J\u001a\u0010\u0093\u0001\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0006\u0008\u0092\u0001\u0010\u0087\u0001JX\u0010\u0095\u0001\u001a\u00020\u0011\"\u0004\u0008\u0000\u0010z\"\u0005\u0008\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \u0008\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\u0008\u0094\u0001\u0010\u0090\u0001J\u000f\u0010\u0096\u0001\u001a\u00020\u0001¢\u0006\u0005\u0008\u0096\u0001\u0010iJ\u001d\u0010\u0098\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\u0008\u0098\u0001\u0010\u0099\u0001J\u001c\u0010\u009a\u0001\u001a\u00020/2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\u0008\u009a\u0001\u0010\u009b\u0001J\u0011\u0010\u009c\u0001\u001a\u00020/H\u0007¢\u0006\u0005\u0008\u009c\u0001\u00101J\u0011\u0010\u009d\u0001\u001a\u00020/H\u0016¢\u0006\u0005\u0008\u009d\u0001\u00101J$\u0010\u009e\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\u0008\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\u0008\u009e\u0001\u0010\u009f\u0001J\"\u0010 \u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0006\u0008 \u0001\u0010¡\u0001J(\u0010¢\u0001\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0008\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\u0008¢\u0001\u0010£\u0001J&\u0010¤\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002032\u0008\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\u0008¤\u0001\u0010¥\u0001J-\u0010¦\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002072\u0006\u0010\u0018\u001a\u0002082\u0008\u0010:\u001a\u0004\u0018\u00010\u0005H\u0082\u0010¢\u0006\u0006\u0008¦\u0001\u0010§\u0001J\u0019\u0010©\u0001\u001a\u0004\u0018\u000108*\u00030¨\u0001H\u0002¢\u0006\u0006\u0008©\u0001\u0010ª\u0001J\u001f\u0010«\u0001\u001a\u00020\u0011*\u00020\u00072\u0008\u0010 \u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0005\u0008«\u0001\u0010yJ&\u0010¬\u0001\u001a\u00060#j\u0002`$*\u00020\r2\n\u0008\u0002\u0010?\u001a\u0004\u0018\u00010/H\u0004¢\u0006\u0006\u0008¬\u0001\u0010­\u0001R\u001b\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020X0®\u00018F¢\u0006\u0008\u001a\u0006\u0008¯\u0001\u0010°\u0001R\u0018\u0010³\u0001\u001a\u0004\u0018\u00010\r8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\u0008²\u0001\u0010OR\u0016\u0010µ\u0001\u001a\u00020\u00018DX\u0084\u0004¢\u0006\u0007\u001a\u0005\u0008´\u0001\u0010iR\u0016\u0010·\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\u0008¶\u0001\u0010iR\u0016\u0010¸\u0001\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\u0008¸\u0001\u0010iR\u0013\u0010¹\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\u0008¹\u0001\u0010iR\u0013\u0010º\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\u0008º\u0001\u0010iR\u0013\u0010»\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\u0008»\u0001\u0010iR\u0016\u0010¼\u0001\u001a\u00020\u00018TX\u0094\u0004¢\u0006\u0007\u001a\u0005\u0008¼\u0001\u0010iR\u0019\u0010À\u0001\u001a\u0007\u0012\u0002\u0008\u00030½\u00018F¢\u0006\u0008\u001a\u0006\u0008¾\u0001\u0010¿\u0001R\u0016\u0010Â\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\u0008Á\u0001\u0010iR\u0015\u0010Æ\u0001\u001a\u00030Ã\u00018F¢\u0006\u0008\u001a\u0006\u0008Ä\u0001\u0010Å\u0001R.\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00192\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00198@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\u0008È\u0001\u0010É\u0001\"\u0006\u0008Ê\u0001\u0010Ë\u0001R\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008Í\u0001\u0010LR\u001e\u0010Ï\u0001\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0007\u001a\u0005\u0008Î\u0001\u0010>R\u001b\u0010Ð\u0001\u001a\u00020\u0001*\u0002038BX\u0082\u0004¢\u0006\u0008\u001a\u0006\u0008Ð\u0001\u0010Ñ\u0001\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006Õ\u0001", d2 = {"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStart", "()V", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class f2 implements kotlinx.coroutines.y1, kotlinx.coroutines.x, kotlinx.coroutines.n2 {

    private static final AtomicReferenceFieldUpdater a;
    private volatile Object _parentHandle = null;
    private volatile Object _state;

    @Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0008\u0002\u0018\u00002\u00060\u0018j\u0002`,2\u00020-B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\u0008\u0012\u0004\u0012\u00020\u0005`\u000eH\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00122\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\u0008\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00188B@BX\u0082\u000e¢\u0006\u000c\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008!\u0010 R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0004\u0010 \"\u0004\u0008\"\u0010#R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008$\u0010 R\u001a\u0010\u0002\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\u000c\n\u0004\u0008\u0002\u0010%\u001a\u0004\u0008&\u0010'R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008(\u0010)\"\u0004\u0008*\u0010\u000c¨\u0006+", d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class c implements kotlinx.coroutines.t1 {

        private volatile Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        private final kotlinx.coroutines.k2 a;
        public c(kotlinx.coroutines.k2 k2, boolean z2, Throwable throwable3) {
            super();
            this.a = k2;
            this._isCompleting = z2;
            this._rootCause = throwable3;
            final int obj1 = 0;
        }

        private final ArrayList<Throwable> c() {
            ArrayList arrayList = new ArrayList(4);
            return arrayList;
        }

        private final Object d() {
            return this._exceptionsHolder;
        }

        private final void l(Object object) {
            this._exceptionsHolder = object;
        }

        @Override // kotlinx.coroutines.t1
        public boolean a() {
            int i;
            i = f() == null ? 1 : 0;
            return i;
        }

        @Override // kotlinx.coroutines.t1
        public final void b(Throwable throwable) {
            ArrayList list;
            Object obj3;
            Throwable th = f();
            if (th == null) {
                m(throwable);
            }
            if (throwable == th) {
            }
            Object obj = d();
            if (obj == null) {
                l(throwable);
            } else {
                if (obj instanceof Throwable) {
                    if (throwable == obj) {
                    }
                    list = c();
                    list.add(obj);
                    list.add(throwable);
                    obj3 = w.a;
                    l(list);
                } else {
                    if (obj instanceof ArrayList == null) {
                    } else {
                        (ArrayList)obj.add(throwable);
                    }
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException(n.o("State is ", obj).toString());
            throw illegalStateException;
        }

        @Override // kotlinx.coroutines.t1
        public kotlinx.coroutines.k2 e() {
            return this.a;
        }

        @Override // kotlinx.coroutines.t1
        public final Throwable f() {
            return (Throwable)this._rootCause;
        }

        @Override // kotlinx.coroutines.t1
        public final boolean g() {
            int i;
            i = f() != null ? 1 : 0;
            return i;
        }

        @Override // kotlinx.coroutines.t1
        public final boolean h() {
            return this._isCompleting;
        }

        @Override // kotlinx.coroutines.t1
        public final boolean i() {
            int i;
            i = d() == g2.e() ? 1 : 0;
            return i;
        }

        public final List<Throwable> j(Throwable throwable) {
            Object obj;
            ArrayList list;
            Throwable th;
            int i;
            obj = d();
            if (obj == null) {
                obj = c();
                th = f();
                if (th == null) {
                } else {
                    obj.add(0, th);
                }
                if (throwable != null && !n.b(throwable, th)) {
                    if (!n.b(throwable, th)) {
                        obj.add(throwable);
                    }
                }
                l(g2.e());
                return obj;
            } else {
                if (obj instanceof Throwable) {
                    list = c();
                    list.add(obj);
                    obj = list;
                } else {
                    if (obj instanceof ArrayList == null) {
                    } else {
                    }
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException(n.o("State is ", (ArrayList)obj).toString());
            throw illegalStateException;
        }

        @Override // kotlinx.coroutines.t1
        public final void k(boolean z) {
            this._isCompleting = z;
        }

        @Override // kotlinx.coroutines.t1
        public final void m(Throwable throwable) {
            this._rootCause = throwable;
        }

        @Override // kotlinx.coroutines.t1
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Finishing[cancelling=");
            stringBuilder.append(g());
            stringBuilder.append(", completing=");
            stringBuilder.append(h());
            stringBuilder.append(", rootCause=");
            stringBuilder.append(f());
            stringBuilder.append(", exceptions=");
            stringBuilder.append(d());
            stringBuilder.append(", list=");
            stringBuilder.append(e());
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class a extends kotlinx.coroutines.q<T> {

        private final kotlinx.coroutines.f2 A;
        public a(d<? super T> d, kotlinx.coroutines.f2 f22) {
            super(d, 1);
            this.A = f22;
        }

        @Override // kotlinx.coroutines.q
        protected String G() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.q
        public Throwable w(kotlinx.coroutines.y1 y1) {
            boolean th;
            Object obj = this.A.c0();
            th = (f2.c)obj.f();
            if (obj instanceof f2.c && th == null) {
                th = (f2.c)obj.f();
                if (th == null) {
                }
                return th;
            }
            if (obj instanceof b0) {
                return obj.a;
            }
            return y1.n();
        }
    }

    @Metadata(d1 = "\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000", d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends o.b {

        final kotlinx.coroutines.f2 d;
        final Object e;
        public d(o o, kotlinx.coroutines.f2 f22, Object object3) {
            this.d = f22;
            this.e = object3;
            super(o);
        }

        @Override // kotlinx.coroutines.internal.o$b
        public Object g(Object object) {
            return i((o)object);
        }

        @Override // kotlinx.coroutines.internal.o$b
        public Object i(o o) {
            int obj2;
            obj2 = this.d.c0() == this.e ? 1 : 0;
            if (obj2 != null) {
                obj2 = 0;
            } else {
                obj2 = n.a();
            }
            return obj2;
        }
    }

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class b extends kotlinx.coroutines.e2 {

        private final kotlinx.coroutines.f2 w;
        private final kotlinx.coroutines.f2.c x;
        private final kotlinx.coroutines.w y;
        private final Object z;
        public b(kotlinx.coroutines.f2 f2, kotlinx.coroutines.f2.c f2$c2, kotlinx.coroutines.w w3, Object object4) {
            super();
            this.w = f2;
            this.x = c2;
            this.y = w3;
            this.z = object4;
        }

        @Override // kotlinx.coroutines.e2
        public Object invoke(Object object) {
            y((Throwable)object);
            return w.a;
        }

        @Override // kotlinx.coroutines.e2
        public void y(Throwable throwable) {
            f2.z(this.w, this.x, this.y, this.z);
        }
    }
    static {
        f2.a = AtomicReferenceFieldUpdater.newUpdater(f2.class, Object.class, "_state");
    }

    public f2(boolean z) {
        kotlinx.coroutines.h1 obj1;
        super();
        if (z) {
            obj1 = g2.c();
        } else {
            obj1 = g2.d();
        }
        this._state = obj1;
        obj1 = 0;
    }

    private final boolean A(Object object, kotlinx.coroutines.k2 k22, kotlinx.coroutines.e2 e23) {
        int i;
        int i2;
        Object obj3;
        f2.d dVar = new f2.d(e23, this, object);
        obj3 = k22.q().x(e23, k22, dVar);
        while (obj3 != 1) {
            if (obj3 == 2) {
                break;
            } else {
            }
            obj3 = k22.q().x(e23, k22, dVar);
        }
        return i2;
    }

    private final void B(Throwable throwable, List<? extends Throwable> list2) {
        Throwable th;
        Throwable next;
        boolean z;
        if (list2.size() <= 1) {
        }
        IdentityHashMap identityHashMap = new IdentityHashMap(list2.size());
        if (!q0.d()) {
            th = throwable;
        } else {
            th = y.l(throwable);
        }
        final Iterator obj6 = list2.iterator();
        while (obj6.hasNext()) {
            if (!q0.d()) {
            } else {
            }
            next = y.l((Throwable)obj6.next());
            if (next != throwable && next != th && next instanceof CancellationException == null && Collections.newSetFromMap(identityHashMap).add(next)) {
            }
            if (next != th) {
            }
            if (next instanceof CancellationException == null) {
            }
            if (setFromMap.add(next)) {
            }
            b.a(throwable, next);
        }
    }

    private final boolean B0(kotlinx.coroutines.t1 t1, Object object2) {
        boolean z2;
        boolean z;
        boolean z3;
        final int i2 = 0;
        final int i3 = 1;
        if (q0.a()) {
            if (!t1 instanceof h1) {
                if (t1 instanceof e2) {
                    z2 = i3;
                } else {
                    z2 = i2;
                }
            } else {
            }
            if (z2 == 0) {
            } else {
            }
            AssertionError obj5 = new AssertionError();
            throw obj5;
        }
        if (q0.a()) {
            if (z4 ^= i3 == 0) {
            } else {
            }
            obj5 = new AssertionError();
            throw obj5;
        }
        if (!f2.a.compareAndSet(this, t1, g2.g(object2))) {
            return i2;
        }
        p0(0);
        q0(object2);
        Q(t1, object2);
        return i3;
    }

    private final boolean C0(kotlinx.coroutines.t1 t1, Throwable throwable2) {
        boolean z;
        boolean z2;
        final int i = 1;
        if (q0.a()) {
            if (z3 ^= i == 0) {
            } else {
            }
            AssertionError obj6 = new AssertionError();
            throw obj6;
        }
        if (q0.a()) {
            if (!t1.a()) {
            } else {
            }
            obj6 = new AssertionError();
            throw obj6;
        }
        kotlinx.coroutines.k2 k2Var = a0(t1);
        final int i2 = 0;
        if (k2Var == null) {
            return i2;
        }
        f2.c cVar = new f2.c(k2Var, i2, throwable2);
        if (!f2.a.compareAndSet(this, t1, cVar)) {
            return i2;
        }
        n0(k2Var, throwable2);
        return i;
    }

    private final Object D0(Object object, Object object2) {
        boolean z;
        if (!object instanceof t1) {
            return g2.a();
        }
        if (!object instanceof h1) {
            if (object instanceof e2 && !object instanceof w && !object2 instanceof b0 && B0((t1)object, object2)) {
                if (!object instanceof w) {
                    if (!object2 instanceof b0) {
                        if (B0((t1)object, object2)) {
                            return object2;
                        }
                        return g2.b();
                    }
                }
            }
        } else {
        }
        return E0((t1)object, object2);
    }

    private final Object E0(kotlinx.coroutines.t1 t1, Object object2) {
        kotlinx.coroutines.t1 cVar;
        int i3;
        int i2;
        boolean compareAndSet;
        boolean z;
        int i;
        kotlinx.coroutines.w obj7;
        final kotlinx.coroutines.k2 k2Var = a0(t1);
        if (k2Var == null) {
            return g2.b();
        }
        i3 = 0;
        if (t1 instanceof f2.c) {
            cVar = t1;
        } else {
            cVar = i3;
        }
        if (cVar == null) {
            cVar = new f2.c(k2Var, 0, i3);
        }
        synchronized (cVar) {
            return g2.a();
        }
        obj7 = U(t1);
        if (obj7 != null && F0(cVar, obj7, object2)) {
            if (F0(cVar, obj7, object2)) {
                return g2.b;
            }
        }
        try {
            return T(cVar, object2);
            throw t1;
        }
    }

    private final boolean F0(kotlinx.coroutines.f2.c f2$c, kotlinx.coroutines.w w2, Object object3) {
        f2.b bVar = new f2.b(this, c, w2, object3);
        while (y1.a.d(w2.w, false, false, bVar, 1, 0) != l2.a) {
            bVar = new f2.b(this, c, w2, object3);
        }
        return 1;
    }

    private final Object G(d<Object> d) {
        f2.a aVar = new f2.a(b.c(d), this);
        aVar.B();
        o2 o2Var = new o2(aVar);
        s.a(aVar, w(o2Var));
        Object obj = aVar.y();
        if (obj == b.d()) {
            h.c(d);
        }
        return obj;
    }

    private final Object M(Object object) {
        boolean z;
        Object obj = c0();
        while (obj instanceof t1) {
            b0 b0Var = new b0(S(object), 0, 2, 0);
            Object obj2 = D0(obj, b0Var);
            obj = c0();
        }
        return g2.a();
    }

    private final boolean N(Throwable throwable) {
        int i;
        kotlinx.coroutines.l2 l2Var;
        if (h0()) {
            return 1;
        }
        boolean z2 = throwable instanceof CancellationException;
        final kotlinx.coroutines.v vVar = b0();
        if (vVar != null) {
            if (vVar == l2.a) {
            } else {
                if (!vVar.c(throwable)) {
                    if (z2) {
                    } else {
                        i = 0;
                    }
                }
            }
            return i;
        }
        return z2;
    }

    private final void Q(kotlinx.coroutines.t1 t1, Object object2) {
        kotlinx.coroutines.v vVar;
        boolean z;
        int i;
        String str;
        Object obj4;
        Object obj5;
        vVar = b0();
        if (vVar == null) {
        } else {
            vVar.dispose();
            v0(l2.a);
        }
        if (object2 instanceof b0) {
        } else {
            obj5 = i;
        }
        if (obj5 == null) {
        } else {
            i = obj5.a;
        }
        if (t1 instanceof e2) {
            (e2)t1.y(i);
        } else {
            obj4 = t1.e();
            if (obj4 == null) {
            } else {
                o0(obj4, i);
            }
        }
    }

    private final void R(kotlinx.coroutines.f2.c f2$c, kotlinx.coroutines.w w2, Object object3) {
        boolean z;
        kotlinx.coroutines.w obj3;
        if (q0.a()) {
            z = c0() == c ? 1 : 0;
            if (z == 0) {
            } else {
            }
            AssertionError obj2 = new AssertionError();
            throw obj2;
        }
        obj3 = m0(w2);
        if (obj3 != null && F0(c, obj3, object3)) {
            if (F0(c, obj3, object3)) {
            }
        }
        C(T(c, object3));
    }

    private final Throwable S(Object object) {
        boolean jobCancellationException;
        String str;
        Object obj3;
        jobCancellationException = object == null ? 1 : object instanceof Throwable;
        if (jobCancellationException != null) {
            if ((Throwable)object == null) {
                jobCancellationException = new JobCancellationException(f2.y(this), 0, this);
                obj3 = jobCancellationException;
            }
        } else {
            Objects.requireNonNull((Throwable)object, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            obj3 = (n2)object.F();
        }
        return obj3;
    }

    private final Object T(kotlinx.coroutines.f2.c f2$c, Object object2) {
        int z2;
        boolean z;
        boolean z3;
        int i2;
        Throwable th;
        int i;
        Object obj9;
        i = 1;
        final int i3 = 0;
        if (q0.a()) {
            z2 = c0() == c ? i : i3;
            if (z2 == 0) {
            } else {
            }
            AssertionError obj8 = new AssertionError();
            throw obj8;
        }
        if (q0.a()) {
            if (z4 ^= i == 0) {
            } else {
            }
            obj8 = new AssertionError();
            throw obj8;
        }
        if (q0.a()) {
            if (!c.h()) {
            } else {
            }
            obj8 = new AssertionError();
            throw obj8;
        }
        final int i4 = 0;
        if (object2 instanceof b0) {
            i2 = object2;
        } else {
            i2 = i4;
        }
        th = i2 == 0 ? i4 : i2.a;
        final List list = c.j(th);
        final Throwable th2 = X(c, list);
        synchronized (c) {
            B(th2, list);
            if (th2 == null) {
            } else {
                if (th2 == th) {
                } else {
                    obj9 = new b0(th2, i3, 2, i4);
                }
            }
            if (th2 != null && !N(th2)) {
                if (!N(th2)) {
                    if (d0(th2)) {
                    } else {
                        i = i3;
                    }
                }
                if (i != 0) {
                    Objects.requireNonNull(obj9, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    (b0)obj9.b();
                }
            }
            if (!c.g()) {
                p0(th2);
            }
            q0(obj9);
            if (q0.a()) {
                if (!f2.a.compareAndSet(this, c, g2.g(obj9))) {
                } else {
                }
                obj8 = new AssertionError();
                throw obj8;
            }
            Q(c, obj9);
            return obj9;
        }
    }

    private final kotlinx.coroutines.w U(kotlinx.coroutines.t1 t1) {
        int i;
        int i2;
        Object obj3;
        if (t1 instanceof w) {
            i = t1;
        } else {
            i = i2;
        }
        if (i == 0) {
            obj3 = t1.e();
            if (obj3 == null) {
            } else {
                i2 = m0(obj3);
            }
        } else {
            i2 = i;
        }
        return i2;
    }

    private final Throwable W(Object object) {
        Throwable i;
        Object obj3;
        if (object instanceof b0) {
        } else {
            obj3 = i;
        }
        if (obj3 == null) {
        } else {
            i = obj3.a;
        }
        return i;
    }

    private final Throwable X(kotlinx.coroutines.f2.c f2$c, List<? extends Throwable> list2) {
        boolean empty;
        int i2;
        int i;
        int i3;
        boolean next;
        int i4;
        boolean z;
        Iterator obj7;
        i2 = 0;
        if (list2.isEmpty() && c.g()) {
            if (c.g()) {
                JobCancellationException obj6 = new JobCancellationException(f2.y(this), i2, this);
                return obj6;
            }
            return i2;
        }
        obj6 = list2.iterator();
        i = 1;
        for (Object empty : obj6) {
            i = 1;
        }
        empty = i2;
        if ((Throwable)empty) {
            return (Throwable)empty;
        }
        obj6 = 0;
        Object obj = list2.get(obj6);
        if (obj instanceof TimeoutCancellationException != null) {
            obj7 = list2.iterator();
            while (obj7.hasNext()) {
                next = obj7.next();
                z = next;
                if ((Throwable)z != (Throwable)obj && z instanceof TimeoutCancellationException != null) {
                } else {
                }
                i4 = obj6;
                if (i4 != 0) {
                    break;
                } else {
                }
                if (z instanceof TimeoutCancellationException != null) {
                } else {
                }
                i4 = i;
            }
            if ((Throwable)i2 != 0) {
                return (Throwable)i2;
            }
        }
        return (Throwable)obj;
    }

    private final kotlinx.coroutines.k2 a0(kotlinx.coroutines.t1 t1) {
        kotlinx.coroutines.k2 k2Var;
        if (t1.e() == null) {
            if (t1 instanceof h1) {
                k2Var = new k2();
            } else {
                if (!t1 instanceof e2) {
                } else {
                    t0((e2)t1);
                    k2Var = 0;
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException(n.o("State should have list: ", t1).toString());
            throw illegalStateException;
        }
        return k2Var;
    }

    private final Object i0(Object object) {
        int i3;
        int i;
        kotlinx.coroutines.internal.z zVar2;
        Object obj;
        kotlinx.coroutines.internal.z zVar;
        int i2;
        Object obj7;
        i3 = 0;
        i = i3;
        Object obj2 = c0();
        while (obj2 instanceof f2.c) {
            if (i == 0) {
            }
            obj = obj2;
            b0 b0Var = new b0(i, 0, 2, i3);
            obj = D0(obj2, b0Var);
            obj2 = c0();
            i = S(object);
        }
        synchronized (obj2) {
            return g2.f();
        }
        return g2.a();
    }

    private final kotlinx.coroutines.e2 k0(l<? super Throwable, w> l, boolean z2) {
        int w1Var;
        boolean z;
        boolean obj3;
        if (z2) {
            if (l instanceof z1) {
                w1Var = l;
            }
            if (w1Var == 0) {
                w1Var = new w1(l);
            }
        } else {
            if (l instanceof e2) {
                obj3 = l;
            } else {
                obj3 = w1Var;
            }
            if (obj3 == null) {
            } else {
                if (q0.a()) {
                    if (z3 ^= 1 == 0) {
                    } else {
                    }
                    AssertionError obj2 = new AssertionError();
                    throw obj2;
                }
                w1Var = obj3;
            }
            if (w1Var == 0) {
                w1Var = new x1(l);
            }
        }
        w1Var.A(this);
        return w1Var;
    }

    private final kotlinx.coroutines.w m0(o o) {
        boolean z;
        o obj2;
        while (o.t()) {
            obj2 = o.q();
        }
        obj2 = obj2.p();
        while (obj2.t()) {
            obj2 = obj2.p();
        }
        return (w)obj2;
    }

    private final void n0(kotlinx.coroutines.k2 k2, Throwable throwable2) {
        Object obj;
        int i;
        Object string;
        Throwable stringBuilder;
        String str;
        p0(throwable2);
        obj = k2.o();
        i = i2;
        while (!n.b(obj, k2)) {
            if (obj instanceof z1) {
            }
            obj = obj.p();
            (e2)obj.y(throwable2);
            if (completionHandlerException == null) {
            } else {
            }
            stringBuilder = obj1;
            b.a(completionHandlerException, th);
            stringBuilder = completionHandlerException;
            if (stringBuilder == null) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Exception in completion handler ");
            stringBuilder.append(string);
            string = " for ";
            stringBuilder.append(string);
            stringBuilder.append(this);
            string = stringBuilder.toString();
            CompletionHandlerException completionHandlerException = new CompletionHandlerException(string, th);
        }
        if (i == 0) {
        } else {
            e0(i);
        }
        N(throwable2);
    }

    private final void o0(kotlinx.coroutines.k2 k2, Throwable throwable2) {
        Object obj;
        int i;
        Object string;
        Throwable stringBuilder;
        String str;
        obj = k2.o();
        i = i2;
        while (!n.b(obj, k2)) {
            if (obj instanceof e2) {
            }
            obj = obj.p();
            (e2)obj.y(throwable2);
            if (completionHandlerException == null) {
            } else {
            }
            stringBuilder = obj1;
            b.a(completionHandlerException, th);
            stringBuilder = completionHandlerException;
            if (stringBuilder == null) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Exception in completion handler ");
            stringBuilder.append(string);
            string = " for ";
            stringBuilder.append(string);
            stringBuilder.append(this);
            string = stringBuilder.toString();
            CompletionHandlerException completionHandlerException = new CompletionHandlerException(string, th);
        }
        if (i == 0) {
        } else {
            e0(i);
        }
    }

    private final void s0(kotlinx.coroutines.h1 h1) {
        Object k2Var;
        boolean s1Var;
        k2Var = new k2();
        if (h1.a()) {
        } else {
            s1Var = new s1(k2Var);
            k2Var = s1Var;
        }
        f2.a.compareAndSet(this, h1, k2Var);
    }

    private final void t0(kotlinx.coroutines.e2 e2) {
        k2 k2Var = new k2();
        e2.k(k2Var);
        f2.a.compareAndSet(this, e2, e2.p());
    }

    private final int w0(Object object) {
        final int i = -1;
        final int i2 = 1;
        int i3 = 0;
        if (object instanceof h1 && (h1)object.a()) {
            if ((h1)object.a()) {
                return i3;
            }
            if (!f2.a.compareAndSet(this, object, g2.c())) {
                return i;
            }
            r0();
            return i2;
        }
        if (object instanceof s1 && !f2.a.compareAndSet(this, object, (s1)object.e())) {
            if (!f2.a.compareAndSet(this, object, (s1)object.e())) {
                return i;
            }
            r0();
            return i2;
        }
        return i3;
    }

    private final String x0(Object object) {
        boolean z;
        String str;
        boolean obj3;
        str = "Active";
        if (object instanceof f2.c) {
            if ((f2.c)object.g()) {
                str = "Cancelling";
            } else {
                if (object.h()) {
                    str = "Completing";
                }
            }
        } else {
            if (object instanceof t1) {
                if ((t1)object.a()) {
                } else {
                    str = "New";
                }
            } else {
                str = object instanceof b0 ? "Cancelled" : "Completed";
            }
        }
        return str;
    }

    public static final String y(kotlinx.coroutines.f2 f2) {
        return f2.O();
    }

    public static final void z(kotlinx.coroutines.f2 f2, kotlinx.coroutines.f2.c f2$c2, kotlinx.coroutines.w w3, Object object4) {
        f2.R(c2, w3, object4);
    }

    public static CancellationException z0(kotlinx.coroutines.f2 f2, Throwable throwable2, String string3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj2 = 0;
            }
            return f2.y0(throwable2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        throw obj0;
    }

    @Override // kotlinx.coroutines.y1
    public final String A0() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l0());
        stringBuilder.append('{');
        stringBuilder.append(x0(c0()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override // kotlinx.coroutines.y1
    protected void C(Object object) {
    }

    public final Object D(d<Object> d) {
        Object obj = c0();
        while (!obj instanceof t1) {
            obj = c0();
        }
        if (obj instanceof b0) {
            Throwable th = obj.a;
            if (!q0.d()) {
            } else {
                if (!d instanceof e) {
                    throw th;
                }
                throw y.a(th, (e)d);
            }
            throw th;
        }
        return g2.h((b0)obj);
    }

    @Override // kotlinx.coroutines.y1
    public CancellationException F() {
        Object obj;
        Throwable th;
        int jobCancellationException;
        boolean str;
        obj = c0();
        if (obj instanceof f2.c) {
            th = (f2.c)obj.f();
            if (th instanceof CancellationException != null) {
                jobCancellationException = th;
            }
            if (jobCancellationException == null) {
                jobCancellationException = new JobCancellationException(n.o("Parent job is ", x0(obj)), th, this);
            }
            return jobCancellationException;
        } else {
            if (obj instanceof b0) {
                th = obj2.a;
            } else {
                if (obj instanceof t1) {
                } else {
                    th = jobCancellationException;
                }
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException(n.o("Cannot be cancelling child in this state: ", obj).toString());
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.y1
    public final boolean I(Throwable throwable) {
        return K(throwable);
    }

    @Override // kotlinx.coroutines.y1
    public final kotlinx.coroutines.v J(kotlinx.coroutines.x x) {
        w wVar = new w(x);
        return (v)y1.a.d(this, true, false, wVar, 2, 0);
    }

    @Override // kotlinx.coroutines.y1
    public final boolean K(Object object) {
        Object zVar;
        boolean z;
        int i;
        kotlinx.coroutines.internal.z obj4;
        zVar = g2.a();
        if (Z() && M(object) == g2.b) {
            if (M(object) == g2.b) {
                return 1;
            }
        }
        if (zVar == g2.a()) {
            zVar = i0(object);
        }
        if (zVar == g2.a()) {
        } else {
            if (zVar == g2.b) {
            } else {
                if (zVar == g2.f()) {
                    i = 0;
                } else {
                    C(zVar);
                }
            }
        }
        return i;
    }

    @Override // kotlinx.coroutines.y1
    public void L(Throwable throwable) {
        K(throwable);
    }

    @Override // kotlinx.coroutines.y1
    protected String O() {
        return "Job was cancelled";
    }

    @Override // kotlinx.coroutines.y1
    public boolean P(Throwable throwable) {
        int i;
        boolean obj3;
        if (throwable instanceof CancellationException != null) {
            return 1;
        }
        if (K(throwable) && Y()) {
            if (Y()) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.y1
    public final Object V() {
        Object obj = c0();
        if (z ^= 1 == 0) {
        } else {
            if (obj instanceof b0) {
            } else {
                return g2.h(obj);
            }
            throw obj.a;
        }
        IllegalStateException illegalStateException = new IllegalStateException("This job has not completed yet".toString());
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.y1
    public boolean Y() {
        return 1;
    }

    @Override // kotlinx.coroutines.y1
    public boolean Z() {
        return 0;
    }

    @Override // kotlinx.coroutines.y1
    public boolean a() {
        Object obj;
        int i;
        obj = c0();
        if (obj instanceof t1 && (t1)obj.a()) {
            i = (t1)obj.a() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.y1
    public final kotlinx.coroutines.v b0() {
        return (v)this._parentHandle;
    }

    @Override // kotlinx.coroutines.y1
    public void c(CancellationException cancellationException) {
        kotlinx.coroutines.JobCancellationException jobCancellationException;
        String str;
        kotlinx.coroutines.JobCancellationException obj3;
        if (cancellationException == null) {
            jobCancellationException = new JobCancellationException(f2.y(this), 0, this);
            obj3 = jobCancellationException;
        }
        L(obj3);
    }

    @Override // kotlinx.coroutines.y1
    public final Object c0() {
        final Object _state = this._state;
        while (!_state instanceof v) {
            (v)_state.c(this);
            _state = this._state;
        }
        return _state;
    }

    @Override // kotlinx.coroutines.y1
    protected boolean d0(Throwable throwable) {
        return 0;
    }

    @Override // kotlinx.coroutines.y1
    public void e0(Throwable throwable) {
        throw throwable;
    }

    @Override // kotlinx.coroutines.y1
    protected final void f0(kotlinx.coroutines.y1 y1) {
        boolean z;
        kotlinx.coroutines.v obj2;
        if (q0.a()) {
            z = b0() == null ? 1 : 0;
            if (z == 0) {
            } else {
            }
            obj2 = new AssertionError();
            throw obj2;
        }
        if (y1 == null) {
            v0(l2.a);
        }
        y1.start();
        obj2 = y1.J(this);
        v0(obj2);
        if (t()) {
            obj2.dispose();
            v0(l2.a);
        }
    }

    public <R> R fold(R r, p<? super R, ? super g.b, ? extends R> p2) {
        return y1.a.b(this, r, p2);
    }

    @Override // kotlinx.coroutines.y1
    public final boolean g0() {
        Object obj;
        int i;
        boolean z;
        obj = c0();
        if (!obj instanceof b0) {
            if (obj instanceof f2.c && (f2.c)obj.g()) {
                if ((f2.c)obj.g()) {
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

    public <E extends g.b> E get(g.c<E> g$c) {
        return y1.a.c(this, c);
    }

    public final g.c<?> getKey() {
        return y1.s;
    }

    @Override // kotlinx.coroutines.y1
    protected boolean h0() {
        return 0;
    }

    @Override // kotlinx.coroutines.y1
    public final Object j0(Object object) {
        Object obj2 = D0(c0(), object);
        while (obj2 != g2.a()) {
            obj2 = D0(c0(), object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Job ");
        stringBuilder.append(this);
        stringBuilder.append(" is already complete or completing, but is being completed with ");
        stringBuilder.append(object);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString(), W(object));
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.y1
    public String l0() {
        return r0.a(this);
    }

    public final kotlinx.coroutines.e1 m(boolean z, boolean z2, l<? super Throwable, w> l3) {
        boolean compareAndSet;
        Object str;
        int i;
        kotlinx.coroutines.l2 l2Var;
        boolean z3;
        boolean obj7;
        final kotlinx.coroutines.e2 e2Var = k0(l3, z);
        compareAndSet = c0();
        while (compareAndSet instanceof h1) {
            str = compareAndSet;
            s0(str);
            compareAndSet = c0();
            str = (t1)compareAndSet.e();
            l2Var = l2.a;
            i = (f2.c)compareAndSet.f();
            l2Var = e2Var;
            z3 = w.a;
            Objects.requireNonNull(compareAndSet, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
            t0((e2)compareAndSet);
        }
        return e2Var;
    }

    public g minusKey(g.c<?> g$c) {
        return y1.a.e(this, c);
    }

    @Override // kotlinx.coroutines.y1
    public final CancellationException n() {
        CancellationException jobCancellationException;
        String str;
        String str3;
        String str2;
        Object obj = c0();
        String str8 = "Job is still new or active: ";
        if (obj instanceof f2.c) {
            Throwable th = (f2.c)obj.f();
            if (th == null) {
            } else {
                jobCancellationException = y0(th, n.o(r0.a(this), " is cancelling"));
                return jobCancellationException;
            }
            IllegalStateException illegalStateException = new IllegalStateException(n.o(str8, this).toString());
            throw illegalStateException;
        }
        if (obj instanceof t1) {
        } else {
            str3 = 0;
            if (obj instanceof b0) {
                jobCancellationException = f2.z0(this, obj.a, str3, 1, str3);
            } else {
                jobCancellationException = new JobCancellationException(n.o(r0.a(this), " has completed normally"), str3, this);
            }
        }
        IllegalStateException illegalStateException2 = new IllegalStateException(n.o(str8, this).toString());
        throw illegalStateException2;
    }

    @Override // kotlinx.coroutines.y1
    protected void p0(Throwable throwable) {
    }

    @Override // kotlinx.coroutines.y1
    public g plus(g g) {
        return y1.a.f(this, g);
    }

    @Override // kotlinx.coroutines.y1
    public final void q(kotlinx.coroutines.n2 n2) {
        K(n2);
    }

    @Override // kotlinx.coroutines.y1
    protected void q0(Object object) {
    }

    @Override // kotlinx.coroutines.y1
    protected void r0() {
    }

    @Override // kotlinx.coroutines.y1
    public final boolean start() {
        int i = w0(c0());
        while (i != 0) {
            final int i3 = 1;
            i = w0(c0());
        }
        return 0;
    }

    @Override // kotlinx.coroutines.y1
    public final boolean t() {
        return z ^= 1;
    }

    @Override // kotlinx.coroutines.y1
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(A0());
        stringBuilder.append('@');
        stringBuilder.append(r0.b(this));
        return stringBuilder.toString();
    }

    @Override // kotlinx.coroutines.y1
    public final void u0(kotlinx.coroutines.e2 e2) {
        Object obj;
        obj = c0();
        while (obj instanceof e2) {
            obj = c0();
        }
        if (obj instanceof t1 && (t1)obj.e() != null) {
            if ((t1)obj.e() != null) {
                e2.u();
            }
        }
    }

    @Override // kotlinx.coroutines.y1
    public final void v0(kotlinx.coroutines.v v) {
        this._parentHandle = v;
    }

    public final kotlinx.coroutines.e1 w(l<? super Throwable, w> l) {
        return m(false, true, l);
    }

    @Override // kotlinx.coroutines.y1
    protected final CancellationException y0(Throwable throwable, String string2) {
        int jobCancellationException;
        String obj3;
        if (throwable instanceof CancellationException != null) {
            jobCancellationException = throwable;
        } else {
            jobCancellationException = 0;
        }
        if (jobCancellationException == null && string2 == null) {
            if (string2 == null) {
                obj3 = f2.y(this);
            }
            jobCancellationException = new JobCancellationException(obj3, throwable, this);
        }
        return jobCancellationException;
    }
}
