package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0019\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0010\u0011\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u000c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\u0008!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001aD\u0010%\u001a\u0002H&\"\u000c\u0008\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\u0008\u0001\u0010&*\u0002H'2\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H&0)H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010*\u001aD\u0010+\u001a\u0002H&\"\u000c\u0008\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\u0008\u0001\u0010&*\u0002H'2\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H&0)H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\u0008.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\n\u00103\u001a\u00020\u0010*\u00020\u0002\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\u0087\u0008\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\u0087\u0008\u001a\r\u00106\u001a\u00020\u0010*\u00020\u0002H\u0087\u0008\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\u0008\u0082\u0002\u000e\n\u000c\u0008\u0000\u0012\u0002\u0018\u0001\u001a\u0004\u0008\u0003\u0010\u0000\u001a \u00108\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\u0008\u0082\u0002\u000e\n\u000c\u0008\u0000\u0012\u0002\u0018\u0001\u001a\u0004\u0008\u0003\u0010\u0000\u001a\r\u00109\u001a\u00020:*\u00020\u0002H\u0086\u0002\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010<\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010<\u001a\u00020\u0006*\u00020\u00022\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\r0>*\u00020\u0002\u001a\u0010\u0010?\u001a\u0008\u0012\u0004\u0012\u00020\r0@*\u00020\u0002\u001a\u0015\u0010A\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\u000c\u001a\u000f\u0010B\u001a\u00020\r*\u0004\u0018\u00010\rH\u0087\u0008\u001a\u001c\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00062\u0008\u0008\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010C\u001a\u00020\r*\u00020\r2\u0006\u0010D\u001a\u00020\u00062\u0008\u0008\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010F\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00062\u0008\u0008\u0002\u0010E\u001a\u00020\u0014\u001a\u001c\u0010F\u001a\u00020\r*\u00020\r2\u0006\u0010D\u001a\u00020\u00062\u0008\u0008\u0002\u0010E\u001a\u00020\u0014\u001aG\u0010G\u001a\u0008\u0012\u0004\u0012\u00020\u00010>*\u00020\u00022\u000e\u0010H\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0I2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008J\u0010K\u001a=\u0010G\u001a\u0008\u0012\u0004\u0012\u00020\u00010>*\u00020\u00022\u0006\u0010H\u001a\u0002022\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0008J\u001a4\u0010L\u001a\u00020\u0010*\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\r*\u00020\r2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010Q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010Q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u001d\u0010Q\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0087\u0008\u001a\u0015\u0010Q\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u0001H\u0087\u0008\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010T\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010T\u001a\u00020\r*\u00020\r2\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010V\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0008\u0008\u0010W\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00020XH\u0087\u0008ø\u0001\u0000\u001a\u001d\u0010V\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020\rH\u0087\u0008\u001a$\u0010[\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a$\u0010[\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a$\u0010_\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a$\u0010_\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a\u001d\u0010`\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020\rH\u0087\u0008\u001a)\u0010a\u001a\u00020\r*\u00020\r2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140XH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008b\u001a)\u0010a\u001a\u00020\r*\u00020\r2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020XH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008c\u001a\"\u0010d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0002\u001a\u001a\u0010d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0002\u001a%\u0010d\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0002H\u0087\u0008\u001a\u001d\u0010d\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0002H\u0087\u0008\u001a=\u0010e\u001a\u0008\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0012\u0010H\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0I\"\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010f\u001a0\u0010e\u001a\u0008\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\n\u0010H\u001a\u000202\"\u00020\u00142\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010e\u001a\u0008\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0006\u0010U\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0008g\u001a%\u0010e\u001a\u0008\u0012\u0004\u0012\u00020\r0@*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\u0008\u001a=\u0010h\u001a\u0008\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\u0012\u0010H\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0I\"\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010i\u001a0\u0010h\u001a\u0008\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\n\u0010H\u001a\u000202\"\u00020\u00142\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010h\u001a\u0008\u0012\u0004\u0012\u00020\r0>*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\u0008\u001a\u001c\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010j\u001a\u00020\u0010*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010k\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u001d\u0010k\u001a\u00020\u0002*\u00020\r2\u0006\u0010l\u001a\u00020\u00062\u0006\u0010m\u001a\u00020\u0006H\u0087\u0008\u001a\u001f\u0010n\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010-\u001a\u00020\u0006H\u0087\u0008\u001a\u0012\u0010n\u001a\u00020\r*\u00020\u00022\u0006\u0010R\u001a\u00020\u0001\u001a\u0012\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010R\u001a\u00020\u0001\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010r\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00142\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a\u001c\u0010r\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0008\u0008\u0002\u0010\\\u001a\u00020\r\u001a\u000c\u0010s\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010t\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007¢\u0006\u0002\u0010u\u001a\n\u0010v\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010v\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010v\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010v\u001a\u00020\r*\u00020\rH\u0087\u0008\u001a$\u0010v\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010v\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\u0087\u0008\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010y\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010y\u001a\u00020\u0002*\u00020\u00022\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010y\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010y\u001a\u00020\r*\u00020\rH\u0087\u0008\u001a$\u0010y\u001a\u00020\r*\u00020\r2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100XH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010y\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006z", d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", "limit", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isBlank", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringsKt extends kotlin.text.StringsKt__StringsJVMKt {
    public static final Pair access$findAnyOf(java.lang.CharSequence $receiver, Collection strings, int startIndex, boolean ignoreCase, boolean last) {
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, strings, startIndex, ignoreCase, last);
    }

    public static final String commonPrefixWith(java.lang.CharSequence $this$commonPrefixWith, java.lang.CharSequence other, boolean ignoreCase) {
        int i;
        boolean equals;
        boolean surrogatePairAt;
        char charAt;
        Intrinsics.checkNotNullParameter($this$commonPrefixWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        i = 0;
        while (i < Math.min($this$commonPrefixWith.length(), other.length())) {
            if (CharsKt.equals($this$commonPrefixWith.charAt(i), other.charAt(i), ignoreCase)) {
            }
            i++;
        }
        if (!StringsKt.hasSurrogatePairAt($this$commonPrefixWith, i + -1)) {
            if (StringsKt.hasSurrogatePairAt(other, i + -1)) {
                i--;
            }
        } else {
        }
        return $this$commonPrefixWith.subSequence(0, i).toString();
    }

    public static String commonPrefixWith$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.commonPrefixWith(charSequence, charSequence2, obj2);
    }

    public static final String commonSuffixWith(java.lang.CharSequence $this$commonSuffixWith, java.lang.CharSequence other, boolean ignoreCase) {
        int i;
        boolean equals;
        boolean surrogatePairAt;
        char charAt;
        Intrinsics.checkNotNullParameter($this$commonSuffixWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = $this$commonSuffixWith.length();
        final int length2 = other.length();
        i = 0;
        while (i < Math.min(length, length2)) {
            if (CharsKt.equals($this$commonSuffixWith.charAt(i3--), other.charAt(i10--), ignoreCase)) {
            }
            i++;
        }
        if (!StringsKt.hasSurrogatePairAt($this$commonSuffixWith, i5--)) {
            if (StringsKt.hasSurrogatePairAt(other, i8--)) {
                i--;
            }
        } else {
        }
        return $this$commonSuffixWith.subSequence(length - i, length).toString();
    }

    public static String commonSuffixWith$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.commonSuffixWith(charSequence, charSequence2, obj2);
    }

    public static final boolean contains(java.lang.CharSequence $this$contains, char char, boolean ignoreCase) {
        int obj7;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        obj7 = StringsKt.indexOf$default($this$contains, char, 0, ignoreCase, 2, 0) >= 0 ? 1 : 0;
        return obj7;
    }

    public static final boolean contains(java.lang.CharSequence $this$contains, java.lang.CharSequence other, boolean ignoreCase) {
        int i3;
        Object $this$contains2;
        Object obj;
        int i4;
        boolean z;
        int i;
        int i5;
        int i2;
        int i6;
        int obj11;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        i3 = 1;
        final int i7 = 0;
        if (other instanceof String != null) {
            obj = other;
            if (StringsKt.indexOf$default($this$contains, (String)other, 0, ignoreCase, 2, 0) >= 0) {
            } else {
                i3 = i7;
            }
        } else {
            $this$contains2 = $this$contains;
            i = z3;
            z = i;
            if (StringsKt__StringsKt.indexOf$StringsKt__StringsKt$default($this$contains2, other, 0, $this$contains2.length(), i, false, 16, 0) >= 0) {
            } else {
                i3 = i7;
            }
        }
        return i3;
    }

    private static final boolean contains(java.lang.CharSequence $this$contains, kotlin.text.Regex regex) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.containsMatchIn($this$contains);
    }

    public static boolean contains$default(java.lang.CharSequence charSequence, char c2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.contains(charSequence, c2, obj2);
    }

    public static boolean contains$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.contains(charSequence, charSequence2, obj2);
    }

    public static final boolean contentEqualsIgnoreCaseImpl(java.lang.CharSequence $this$contentEqualsIgnoreCaseImpl, java.lang.CharSequence other) {
        boolean z;
        int i;
        int length;
        int length2;
        boolean equals;
        char charAt;
        final int i3 = 1;
        if ($this$contentEqualsIgnoreCaseImpl instanceof String != null && other instanceof String != null) {
            if (other instanceof String != null) {
                return StringsKt.equals((String)$this$contentEqualsIgnoreCaseImpl, (String)other, i3);
            }
        }
        if ($this$contentEqualsIgnoreCaseImpl == other) {
            return i3;
        }
        int i2 = 0;
        if ($this$contentEqualsIgnoreCaseImpl != null && other != null) {
            if (other != null) {
                if ($this$contentEqualsIgnoreCaseImpl.length() != other.length()) {
                } else {
                    i = 0;
                    while (i < $this$contentEqualsIgnoreCaseImpl.length()) {
                        i++;
                    }
                }
                return i3;
            }
        }
        return i2;
    }

    public static final boolean contentEqualsImpl(java.lang.CharSequence $this$contentEqualsImpl, java.lang.CharSequence other) {
        boolean z;
        int i;
        int length;
        int length2;
        char charAt;
        char charAt2;
        if ($this$contentEqualsImpl instanceof String != null && other instanceof String != null) {
            if (other instanceof String != null) {
                return Intrinsics.areEqual($this$contentEqualsImpl, other);
            }
        }
        int i2 = 1;
        if ($this$contentEqualsImpl == other) {
            return i2;
        }
        final int i3 = 0;
        if ($this$contentEqualsImpl != null && other != null) {
            if (other != null) {
                if ($this$contentEqualsImpl.length() != other.length()) {
                } else {
                    i = 0;
                    while (i < $this$contentEqualsImpl.length()) {
                        i++;
                    }
                }
                return i2;
            }
        }
        return i3;
    }

    public static final boolean endsWith(java.lang.CharSequence $this$endsWith, char char, boolean ignoreCase) {
        int length;
        int i;
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        if ($this$endsWith.length() > 0 && CharsKt.equals($this$endsWith.charAt(StringsKt.getLastIndex($this$endsWith)), char, ignoreCase)) {
            i = CharsKt.equals($this$endsWith.charAt(StringsKt.getLastIndex($this$endsWith)), char, ignoreCase) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final boolean endsWith(java.lang.CharSequence $this$endsWith, java.lang.CharSequence suffix, boolean ignoreCase) {
        String str;
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!ignoreCase && $this$endsWith instanceof String != null && suffix instanceof String != null) {
            if ($this$endsWith instanceof String != null) {
                if (suffix instanceof String != null) {
                    return StringsKt.endsWith$default((String)$this$endsWith, (String)suffix, false, 2, 0);
                }
            }
        }
        return StringsKt.regionMatchesImpl($this$endsWith, length - length2, suffix, 0, suffix.length(), ignoreCase);
    }

    public static boolean endsWith$default(java.lang.CharSequence charSequence, char c2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.endsWith(charSequence, c2, obj2);
    }

    public static boolean endsWith$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.endsWith(charSequence, charSequence2, obj2);
    }

    public static final Pair<Integer, String> findAnyOf(java.lang.CharSequence $this$findAnyOf, Collection<String> strings, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$findAnyOf, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($this$findAnyOf, strings, startIndex, ignoreCase, false);
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(java.lang.CharSequence $this$findAnyOf, Collection<String> strings, int startIndex, boolean ignoreCase, boolean last) {
        int size;
        java.lang.CharSequence regionMatchesImpl;
        int i2;
        int coerceAtLeast;
        int $this$firstOrNull$iv;
        IntProgression intRange;
        int valueOf;
        int index2;
        int lastIndexOf$default;
        int length;
        boolean iterator2;
        int i;
        int i4;
        int it;
        int step;
        Object obj;
        int index;
        Iterator iterator;
        Object element$iv;
        Object element$iv2;
        int i3;
        i = 0;
        if (!ignoreCase && strings.size() == 1) {
            if (strings.size() == 1) {
                Object obj3 = single;
                int i6 = 4;
                int i7 = 0;
                int i5 = 0;
                java.lang.CharSequence charSequence = $this$findAnyOf;
                valueOf = startIndex;
                if (!last) {
                    lastIndexOf$default = StringsKt.indexOf$default(charSequence, (String)obj3, valueOf, i5, i6, i7);
                    i4 = startIndex;
                } else {
                    lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, obj3, valueOf, i5, i6, i7);
                    i4 = valueOf;
                }
                if (lastIndexOf$default < 0) {
                } else {
                    i = TuplesKt.to(Integer.valueOf(lastIndexOf$default), obj3);
                }
                return i;
            }
        }
        regionMatchesImpl = $this$findAnyOf;
        int i8 = startIndex;
        coerceAtLeast = 0;
        if (!last) {
            intRange = new IntRange(RangesKt.coerceAtLeast(i8, coerceAtLeast), regionMatchesImpl.length());
        } else {
            intRange = RangesKt.downTo(RangesKt.coerceAtMost(i8, StringsKt.getLastIndex(regionMatchesImpl)), coerceAtLeast);
        }
        final IntProgression intProgression = intRange;
        if (regionMatchesImpl instanceof String != null) {
            $this$firstOrNull$iv = intProgression.getFirst();
            intRange = intProgression.getLast();
            index2 = intProgression.getStep();
            if (index2 > 0) {
                if ($this$firstOrNull$iv > intRange) {
                    if (index2 < 0 && intRange <= $this$firstOrNull$iv) {
                        if (intRange <= $this$firstOrNull$iv) {
                            index = $this$firstOrNull$iv;
                            while (/* condition */) {
                                for (Object element$iv2 : iterator2) {
                                    Object obj4 = element$iv2;
                                    i3 = 0;
                                }
                                element$iv2 = i;
                                $this$firstOrNull$iv = element$iv2;
                                if (index != intRange) {
                                }
                                index += index2;
                                length = 0;
                                iterator2 = (Iterable)strings.iterator();
                                obj4 = element$iv2;
                                i3 = 0;
                                if (StringsKt.regionMatches(obj4, 0, (String)regionMatchesImpl, index, (String)obj4.length(), ignoreCase)) {
                                } else {
                                }
                            }
                            return TuplesKt.to(Integer.valueOf(index), (String)$this$firstOrNull$iv);
                        }
                    }
                } else {
                }
            } else {
            }
        } else {
            $this$firstOrNull$iv = intProgression.getFirst();
            it = intProgression.getLast();
            step = intProgression.getStep();
            if (step > 0) {
                if ($this$firstOrNull$iv > it) {
                    if (step < 0 && it <= $this$firstOrNull$iv) {
                        if (it <= $this$firstOrNull$iv) {
                            index2 = $this$firstOrNull$iv;
                            while (/* condition */) {
                                for (Object element$iv : iterator) {
                                    element$iv2 = element$iv;
                                    i3 = 0;
                                    regionMatchesImpl = $this$findAnyOf;
                                }
                                element$iv = i;
                                regionMatchesImpl = element$iv;
                                if (index2 != it) {
                                }
                                index2 += step;
                                regionMatchesImpl = $this$findAnyOf;
                                index = 0;
                                iterator = (Iterable)strings.iterator();
                                element$iv2 = element$iv;
                                i3 = 0;
                                if (StringsKt.regionMatchesImpl((CharSequence)(String)element$iv2, 0, $this$findAnyOf, index2, element$iv2.length(), ignoreCase)) {
                                } else {
                                }
                                regionMatchesImpl = $this$findAnyOf;
                            }
                            return TuplesKt.to(Integer.valueOf(index2), (String)regionMatchesImpl);
                        }
                    }
                } else {
                }
            } else {
            }
        }
        return i;
    }

    public static Pair findAnyOf$default(java.lang.CharSequence charSequence, Collection collection2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return StringsKt.findAnyOf(charSequence, collection2, obj3, obj4);
    }

    public static final Pair<Integer, String> findLastAnyOf(java.lang.CharSequence $this$findLastAnyOf, Collection<String> strings, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$findLastAnyOf, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($this$findLastAnyOf, strings, startIndex, ignoreCase, true);
    }

    public static Pair findLastAnyOf$default(java.lang.CharSequence charSequence, Collection collection2, int i3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = StringsKt.getLastIndex(charSequence);
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return StringsKt.findLastAnyOf(charSequence, collection2, obj2, obj3);
    }

    public static final IntRange getIndices(java.lang.CharSequence $this$indices) {
        Intrinsics.checkNotNullParameter($this$indices, "<this>");
        IntRange intRange = new IntRange(0, length--);
        return intRange;
    }

    public static final int getLastIndex(java.lang.CharSequence $this$lastIndex) {
        Intrinsics.checkNotNullParameter($this$lastIndex, "<this>");
        return length--;
    }

    public static final boolean hasSurrogatePairAt(java.lang.CharSequence $this$hasSurrogatePairAt, int index) {
        int i;
        int i2;
        int highSurrogate;
        Intrinsics.checkNotNullParameter($this$hasSurrogatePairAt, "<this>");
        final int i3 = 0;
        if (index >= 0 && index <= length += -2) {
            highSurrogate = index <= length += -2 ? i : i3;
        } else {
        }
        if (highSurrogate != 0 && Character.isHighSurrogate($this$hasSurrogatePairAt.charAt(index)) && Character.isLowSurrogate($this$hasSurrogatePairAt.charAt(index + 1))) {
            if (Character.isHighSurrogate($this$hasSurrogatePairAt.charAt(index))) {
                if (Character.isLowSurrogate($this$hasSurrogatePairAt.charAt(index + 1))) {
                } else {
                    i = i3;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final <C extends java.lang.CharSequence & R, R> R ifBlank(C $this$ifBlank, Function0<? extends R> defaultValue) {
        Object invoke;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (StringsKt.isBlank($this$ifBlank)) {
            invoke = defaultValue.invoke();
        } else {
            invoke = $this$ifBlank;
        }
        return invoke;
    }

    private static final <C extends java.lang.CharSequence & R, R> R ifEmpty(C $this$ifEmpty, Function0<? extends R> defaultValue) {
        int i;
        Object invoke;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        i = $this$ifEmpty.length() == 0 ? 1 : 0;
        if (i != 0) {
            invoke = defaultValue.invoke();
        } else {
            invoke = $this$ifEmpty;
        }
        return invoke;
    }

    public static final int indexOf(java.lang.CharSequence $this$indexOf, char char, int startIndex, boolean ignoreCase) {
        int indexOfAny;
        String str;
        int i;
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        if (!ignoreCase) {
            if ($this$indexOf instanceof String == null) {
                char[] cArr = new char[1];
                indexOfAny = StringsKt.indexOfAny($this$indexOf, cArr, startIndex, ignoreCase);
            } else {
                indexOfAny = (String)$this$indexOf.indexOf(char, startIndex);
            }
        } else {
        }
        return indexOfAny;
    }

    public static final int indexOf(java.lang.CharSequence $this$indexOf, String string, int startIndex, boolean ignoreCase) {
        int indexOf$StringsKt__StringsKt$default;
        String str;
        Object obj;
        Object obj2;
        int i;
        int length;
        boolean z;
        int i4;
        int i3;
        int i2;
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!ignoreCase) {
            if ($this$indexOf instanceof String == null) {
                indexOf$StringsKt__StringsKt$default = StringsKt__StringsKt.indexOf$StringsKt__StringsKt$default($this$indexOf, (CharSequence)string, startIndex, $this$indexOf.length(), ignoreCase, false, 16, 0);
            } else {
                indexOf$StringsKt__StringsKt$default = (String)$this$indexOf.indexOf(string, startIndex);
                obj = $this$indexOf;
                i = startIndex;
                z = ignoreCase;
            }
        } else {
        }
        return indexOf$StringsKt__StringsKt$default;
    }

    private static final int indexOf$StringsKt__StringsKt(java.lang.CharSequence $this$indexOf, java.lang.CharSequence other, int startIndex, int endIndex, boolean ignoreCase, boolean last) {
        Object obj;
        int coerceAtLeast;
        boolean z;
        int regionMatchesImpl;
        IntProgression intRange;
        int index;
        int length;
        boolean z3;
        int last2;
        int step;
        java.lang.CharSequence charSequence;
        int index2;
        int length2;
        boolean z2;
        obj = other;
        final int i3 = startIndex;
        final int i4 = endIndex;
        int i2 = 0;
        if (!last) {
            intRange = new IntRange(RangesKt.coerceAtLeast(i3, i2), RangesKt.coerceAtMost(i4, $this$indexOf.length()));
        } else {
            intRange = RangesKt.downTo(RangesKt.coerceAtMost(i3, StringsKt.getLastIndex($this$indexOf)), RangesKt.coerceAtLeast(i4, i2));
        }
        final IntRange intRange2 = intRange;
        if ($this$indexOf instanceof String != null && obj instanceof String != null) {
            if (obj instanceof String != null) {
                regionMatchesImpl = intRange2.getFirst();
                intRange = intRange2.getLast();
                index = intRange2.getStep();
                if (index > 0) {
                    if (regionMatchesImpl > intRange) {
                        if (index < 0 && intRange <= regionMatchesImpl) {
                            if (intRange <= regionMatchesImpl) {
                                index2 = regionMatchesImpl;
                                while (StringsKt.regionMatches((String)obj, 0, (String)$this$indexOf, index2, obj.length(), ignoreCase) != 0) {
                                    index2 += index;
                                }
                                return index2;
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
                regionMatchesImpl = intRange2.getFirst();
                last2 = intRange2.getLast();
                step = intRange2.getStep();
                if (step > 0) {
                    if (regionMatchesImpl > last2) {
                        if (step < 0 && last2 <= regionMatchesImpl) {
                            if (last2 <= regionMatchesImpl) {
                                index = regionMatchesImpl;
                                while (StringsKt.regionMatchesImpl(obj, 0, $this$indexOf, index, obj.length(), ignoreCase) != 0) {
                                    index += step;
                                    obj = other;
                                }
                                return index;
                            }
                        }
                    } else {
                    }
                } else {
                }
            }
        } else {
        }
        return -1;
    }

    static int indexOf$StringsKt__StringsKt$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, int i3, int i4, boolean z5, boolean z6, int i7, Object object8) {
        int obj11;
        if (i7 &= 16 != 0) {
            obj11 = 0;
        }
        return StringsKt__StringsKt.indexOf$StringsKt__StringsKt(charSequence, charSequence2, i3, i4, z5, obj11);
    }

    public static int indexOf$default(java.lang.CharSequence charSequence, char c2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return StringsKt.indexOf(charSequence, c2, obj3, obj4);
    }

    public static int indexOf$default(java.lang.CharSequence charSequence, String string2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return StringsKt.indexOf(charSequence, string2, obj3, obj4);
    }

    public static final int indexOfAny(java.lang.CharSequence $this$indexOfAny, Collection<String> strings, int startIndex, boolean ignoreCase) {
        int intValue;
        Intrinsics.checkNotNullParameter($this$indexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Pair anyOf$StringsKt__StringsKt = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($this$indexOfAny, strings, startIndex, ignoreCase, false);
        if (anyOf$StringsKt__StringsKt != null) {
            intValue = (Number)anyOf$StringsKt__StringsKt.getFirst().intValue();
        } else {
            intValue = -1;
        }
        return intValue;
    }

    public static final int indexOfAny(java.lang.CharSequence $this$indexOfAny, char[] chars, int startIndex, boolean ignoreCase) {
        int length;
        int index;
        char charAt;
        int $this$any$iv;
        int i3;
        int length2;
        int i;
        char c;
        boolean it;
        int i2;
        Intrinsics.checkNotNullParameter($this$indexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int i4 = 1;
        if (!ignoreCase && chars.length == i4 && $this$indexOfAny instanceof String != null) {
            if (chars.length == i4) {
                if ($this$indexOfAny instanceof String != null) {
                    return (String)$this$indexOfAny.indexOf(ArraysKt.single(chars), startIndex);
                }
            }
        }
        int i6 = 0;
        final int lastIndex = StringsKt.getLastIndex($this$indexOfAny);
        if (RangesKt.coerceAtLeast(startIndex, i6) <= lastIndex) {
        }
        return -1;
    }

    public static int indexOfAny$default(java.lang.CharSequence charSequence, Collection collection2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return StringsKt.indexOfAny(charSequence, collection2, obj3, obj4);
    }

    public static int indexOfAny$default(java.lang.CharSequence charSequence, char[] c2Arr2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return StringsKt.indexOfAny(charSequence, c2Arr2, obj3, obj4);
    }

    public static final boolean isBlank(java.lang.CharSequence $this$isBlank) {
        int i;
        int i2;
        char charAt;
        boolean it;
        int i3;
        Intrinsics.checkNotNullParameter($this$isBlank, "<this>");
        Object obj = $this$isBlank;
        final int i4 = 0;
        i2 = i;
        while (i2 < obj.length()) {
            i3 = 0;
            i2++;
        }
        i = 1;
        return i;
    }

    private static final boolean isEmpty(java.lang.CharSequence $this$isEmpty) {
        int i;
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        i = $this$isEmpty.length() == 0 ? 1 : 0;
        return i;
    }

    private static final boolean isNotBlank(java.lang.CharSequence $this$isNotBlank) {
        Intrinsics.checkNotNullParameter($this$isNotBlank, "<this>");
        return blank ^= 1;
    }

    private static final boolean isNotEmpty(java.lang.CharSequence $this$isNotEmpty) {
        int i;
        Intrinsics.checkNotNullParameter($this$isNotEmpty, "<this>");
        i = $this$isNotEmpty.length() > 0 ? 1 : 0;
        return i;
    }

    private static final boolean isNullOrBlank(java.lang.CharSequence $this$isNullOrBlank) {
        int i;
        boolean blank;
        if ($this$isNullOrBlank != null) {
            if (StringsKt.isBlank($this$isNullOrBlank)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final boolean isNullOrEmpty(java.lang.CharSequence $this$isNullOrEmpty) {
        int i;
        int length;
        if ($this$isNullOrEmpty != null) {
            if ($this$isNullOrEmpty.length() == 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final CharIterator iterator(java.lang.CharSequence $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        StringsKt__StringsKt.iterator.1 anon = new StringsKt__StringsKt.iterator.1($this$iterator);
        return (CharIterator)anon;
    }

    public static final int lastIndexOf(java.lang.CharSequence $this$lastIndexOf, char char, int startIndex, boolean ignoreCase) {
        int lastIndexOfAny;
        String str;
        int i;
        Intrinsics.checkNotNullParameter($this$lastIndexOf, "<this>");
        if (!ignoreCase) {
            if ($this$lastIndexOf instanceof String == null) {
                char[] cArr = new char[1];
                lastIndexOfAny = StringsKt.lastIndexOfAny($this$lastIndexOf, cArr, startIndex, ignoreCase);
            } else {
                lastIndexOfAny = (String)$this$lastIndexOf.lastIndexOf(char, startIndex);
            }
        } else {
        }
        return lastIndexOfAny;
    }

    public static final int lastIndexOf(java.lang.CharSequence $this$lastIndexOf, String string, int startIndex, boolean ignoreCase) {
        int indexOf$StringsKt__StringsKt;
        String str;
        Object obj2;
        Object obj;
        int i;
        int i3;
        boolean z;
        int i2;
        Intrinsics.checkNotNullParameter($this$lastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!ignoreCase) {
            if ($this$lastIndexOf instanceof String == null) {
                indexOf$StringsKt__StringsKt = StringsKt__StringsKt.indexOf$StringsKt__StringsKt($this$lastIndexOf, (CharSequence)string, startIndex, 0, ignoreCase, true);
            } else {
                indexOf$StringsKt__StringsKt = (String)$this$lastIndexOf.lastIndexOf(string, startIndex);
                obj2 = $this$lastIndexOf;
                i = startIndex;
                z = ignoreCase;
            }
        } else {
        }
        return indexOf$StringsKt__StringsKt;
    }

    public static int lastIndexOf$default(java.lang.CharSequence charSequence, char c2, int i3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = StringsKt.getLastIndex(charSequence);
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return StringsKt.lastIndexOf(charSequence, c2, obj2, obj3);
    }

    public static int lastIndexOf$default(java.lang.CharSequence charSequence, String string2, int i3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = StringsKt.getLastIndex(charSequence);
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return StringsKt.lastIndexOf(charSequence, string2, obj2, obj3);
    }

    public static final int lastIndexOfAny(java.lang.CharSequence $this$lastIndexOfAny, Collection<String> strings, int startIndex, boolean ignoreCase) {
        int intValue;
        Intrinsics.checkNotNullParameter($this$lastIndexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Pair anyOf$StringsKt__StringsKt = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($this$lastIndexOfAny, strings, startIndex, ignoreCase, true);
        if (anyOf$StringsKt__StringsKt != null) {
            intValue = (Number)anyOf$StringsKt__StringsKt.getFirst().intValue();
        } else {
            intValue = -1;
        }
        return intValue;
    }

    public static final int lastIndexOfAny(java.lang.CharSequence $this$lastIndexOfAny, char[] chars, int startIndex, boolean ignoreCase) {
        int length;
        int index;
        char charAt;
        Object obj;
        int i;
        int length2;
        int i2;
        int i4;
        char c;
        boolean it;
        int i3;
        Intrinsics.checkNotNullParameter($this$lastIndexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int i5 = 1;
        if (!ignoreCase && chars.length == i5 && $this$lastIndexOfAny instanceof String != null) {
            if (chars.length == i5) {
                if ($this$lastIndexOfAny instanceof String != null) {
                    return (String)$this$lastIndexOfAny.lastIndexOf(ArraysKt.single(chars), startIndex);
                }
            }
        }
        index = RangesKt.coerceAtMost(startIndex, StringsKt.getLastIndex($this$lastIndexOfAny));
        int i6 = -1;
        while (i6 < index) {
            obj = chars;
            i = 0;
            i4 = i2;
            while (i4 < obj.length) {
                i3 = 0;
                i4++;
            }
            index--;
            i6 = -1;
            i3 = 0;
            if (CharsKt.equals(obj[i4], charAt, ignoreCase)) {
            } else {
            }
            i4++;
            i2 = i5;
        }
        return i6;
    }

    public static int lastIndexOfAny$default(java.lang.CharSequence charSequence, Collection collection2, int i3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = StringsKt.getLastIndex(charSequence);
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return StringsKt.lastIndexOfAny(charSequence, collection2, obj2, obj3);
    }

    public static int lastIndexOfAny$default(java.lang.CharSequence charSequence, char[] c2Arr2, int i3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = StringsKt.getLastIndex(charSequence);
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return StringsKt.lastIndexOfAny(charSequence, c2Arr2, obj2, obj3);
    }

    public static final Sequence<String> lineSequence(java.lang.CharSequence $this$lineSequence) {
        Intrinsics.checkNotNullParameter($this$lineSequence, "<this>");
        final String[] strArr = new String[3];
        return StringsKt.splitToSequence$default($this$lineSequence, strArr, false, 0, 6, 0);
    }

    public static final List<String> lines(java.lang.CharSequence $this$lines) {
        Intrinsics.checkNotNullParameter($this$lines, "<this>");
        return SequencesKt.toList(StringsKt.lineSequence($this$lines));
    }

    private static final boolean matches(java.lang.CharSequence $this$matches, kotlin.text.Regex regex) {
        Intrinsics.checkNotNullParameter($this$matches, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.matches($this$matches);
    }

    private static final String orEmpty(String $this$orEmpty) {
        String str;
        str = $this$orEmpty == null ? "" : $this$orEmpty;
        return str;
    }

    public static final java.lang.CharSequence padEnd(java.lang.CharSequence $this$padEnd, int length, char padChar) {
        int i;
        Intrinsics.checkNotNullParameter($this$padEnd, "<this>");
        if (length < 0) {
        } else {
            if (length <= $this$padEnd.length()) {
                return $this$padEnd.subSequence(0, $this$padEnd.length());
            }
            StringBuilder stringBuilder = new StringBuilder(length);
            stringBuilder.append($this$padEnd);
            int i4 = length - length4;
            if (1 <= i4) {
            }
            return (CharSequence)stringBuilder;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalArgumentException sb = new IllegalArgumentException(stringBuilder2.append("Desired length ").append(length).append(" is less than zero.").toString());
        throw sb;
    }

    public static final String padEnd(String $this$padEnd, int length, char padChar) {
        Intrinsics.checkNotNullParameter($this$padEnd, "<this>");
        return StringsKt.padEnd((CharSequence)$this$padEnd, length, padChar).toString();
    }

    public static java.lang.CharSequence padEnd$default(java.lang.CharSequence charSequence, int i2, char c3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 32;
        }
        return StringsKt.padEnd(charSequence, i2, obj2);
    }

    public static String padEnd$default(String string, int i2, char c3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 32;
        }
        return StringsKt.padEnd(string, i2, obj2);
    }

    public static final java.lang.CharSequence padStart(java.lang.CharSequence $this$padStart, int length, char padChar) {
        int i;
        Intrinsics.checkNotNullParameter($this$padStart, "<this>");
        if (length < 0) {
        } else {
            if (length <= $this$padStart.length()) {
                return $this$padStart.subSequence(0, $this$padStart.length());
            }
            StringBuilder stringBuilder = new StringBuilder(length);
            int i3 = length - length4;
            if (1 <= i3) {
            }
            stringBuilder.append($this$padStart);
            return (CharSequence)stringBuilder;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalArgumentException sb = new IllegalArgumentException(stringBuilder2.append("Desired length ").append(length).append(" is less than zero.").toString());
        throw sb;
    }

    public static final String padStart(String $this$padStart, int length, char padChar) {
        Intrinsics.checkNotNullParameter($this$padStart, "<this>");
        return StringsKt.padStart((CharSequence)$this$padStart, length, padChar).toString();
    }

    public static java.lang.CharSequence padStart$default(java.lang.CharSequence charSequence, int i2, char c3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 32;
        }
        return StringsKt.padStart(charSequence, i2, obj2);
    }

    public static String padStart$default(String string, int i2, char c3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 32;
        }
        return StringsKt.padStart(string, i2, obj2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(java.lang.CharSequence $this$rangesDelimitedBy, char[] delimiters, int startIndex, boolean ignoreCase, int limit) {
        StringsKt.requireNonNegativeLimit(limit);
        StringsKt__StringsKt.rangesDelimitedBy.1 anon = new StringsKt__StringsKt.rangesDelimitedBy.1(delimiters, ignoreCase);
        DelimitedRangesSequence delimitedRangesSequence = new DelimitedRangesSequence($this$rangesDelimitedBy, startIndex, limit, (Function2)anon);
        return (Sequence)delimitedRangesSequence;
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(java.lang.CharSequence $this$rangesDelimitedBy, String[] delimiters, int startIndex, boolean ignoreCase, int limit) {
        StringsKt.requireNonNegativeLimit(limit);
        StringsKt__StringsKt.rangesDelimitedBy.2 anon = new StringsKt__StringsKt.rangesDelimitedBy.2(ArraysKt.asList(delimiters), ignoreCase);
        DelimitedRangesSequence delimitedRangesSequence = new DelimitedRangesSequence($this$rangesDelimitedBy, startIndex, limit, (Function2)anon);
        return (Sequence)delimitedRangesSequence;
    }

    static Sequence rangesDelimitedBy$StringsKt__StringsKt$default(java.lang.CharSequence charSequence, char[] c2Arr2, int i3, boolean z4, int i5, int i6, Object object7) {
        int obj3;
        int obj4;
        int obj5;
        final int i = 0;
        if (i6 & 2 != 0) {
            obj3 = i;
        }
        if (i6 & 4 != 0) {
            obj4 = i;
        }
        if (i6 &= 8 != 0) {
            obj5 = i;
        }
        return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(charSequence, c2Arr2, obj3, obj4, obj5);
    }

    static Sequence rangesDelimitedBy$StringsKt__StringsKt$default(java.lang.CharSequence charSequence, String[] string2Arr2, int i3, boolean z4, int i5, int i6, Object object7) {
        int obj3;
        int obj4;
        int obj5;
        final int i = 0;
        if (i6 & 2 != 0) {
            obj3 = i;
        }
        if (i6 & 4 != 0) {
            obj4 = i;
        }
        if (i6 &= 8 != 0) {
            obj5 = i;
        }
        return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(charSequence, string2Arr2, obj3, obj4, obj5);
    }

    public static final boolean regionMatchesImpl(java.lang.CharSequence $this$regionMatchesImpl, int thisOffset, java.lang.CharSequence other, int otherOffset, int length, boolean ignoreCase) {
        int i;
        int index;
        boolean equals;
        char charAt;
        Intrinsics.checkNotNullParameter($this$regionMatchesImpl, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int i2 = 0;
        if (otherOffset >= 0 && thisOffset >= 0 && thisOffset <= length2 -= length) {
            if (thisOffset >= 0) {
                if (thisOffset <= length2 -= length) {
                    if (otherOffset > length3 -= length) {
                    } else {
                        index = 0;
                        while (index < length) {
                            index++;
                        }
                    }
                    return 1;
                }
            }
        }
        return i2;
    }

    public static final java.lang.CharSequence removePrefix(java.lang.CharSequence $this$removePrefix, java.lang.CharSequence prefix) {
        Intrinsics.checkNotNullParameter($this$removePrefix, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        final int i3 = 0;
        if (StringsKt.startsWith$default($this$removePrefix, prefix, i3, 2, 0)) {
            return $this$removePrefix.subSequence(prefix.length(), $this$removePrefix.length());
        }
        return $this$removePrefix.subSequence(i3, $this$removePrefix.length());
    }

    public static final String removePrefix(String $this$removePrefix, java.lang.CharSequence prefix) {
        Intrinsics.checkNotNullParameter($this$removePrefix, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (StringsKt.startsWith$default((CharSequence)$this$removePrefix, prefix, false, 2, 0)) {
            String substring = $this$removePrefix.substring(prefix.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return $this$removePrefix;
    }

    public static final java.lang.CharSequence removeRange(java.lang.CharSequence $this$removeRange, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        if (endIndex < startIndex) {
        } else {
            int i = 0;
            if (endIndex == startIndex) {
                return $this$removeRange.subSequence(i, $this$removeRange.length());
            }
            StringBuilder stringBuilder = new StringBuilder(length3 -= i3);
            String str2 = "append(...)";
            Intrinsics.checkNotNullExpressionValue(stringBuilder.append($this$removeRange, i, startIndex), str2);
            Intrinsics.checkNotNullExpressionValue(stringBuilder.append($this$removeRange, endIndex, $this$removeRange.length()), str2);
            return (CharSequence)stringBuilder;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.append("End index (").append(endIndex).append(") is less than start index (").append(startIndex).append(").").toString());
        throw indexOutOfBoundsException;
    }

    public static final java.lang.CharSequence removeRange(java.lang.CharSequence $this$removeRange, IntRange range) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return StringsKt.removeRange($this$removeRange, range.getStart().intValue(), intValue2++);
    }

    private static final String removeRange(String $this$removeRange, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        return StringsKt.removeRange((CharSequence)$this$removeRange, startIndex, endIndex).toString();
    }

    private static final String removeRange(String $this$removeRange, IntRange range) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return StringsKt.removeRange((CharSequence)$this$removeRange, range).toString();
    }

    public static final java.lang.CharSequence removeSuffix(java.lang.CharSequence $this$removeSuffix, java.lang.CharSequence suffix) {
        Intrinsics.checkNotNullParameter($this$removeSuffix, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        final int i4 = 0;
        if (StringsKt.endsWith$default($this$removeSuffix, suffix, i4, 2, 0)) {
            return $this$removeSuffix.subSequence(i4, length -= length3);
        }
        return $this$removeSuffix.subSequence(i4, $this$removeSuffix.length());
    }

    public static final String removeSuffix(String $this$removeSuffix, java.lang.CharSequence suffix) {
        Intrinsics.checkNotNullParameter($this$removeSuffix, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        final int i4 = 0;
        if (StringsKt.endsWith$default((CharSequence)$this$removeSuffix, suffix, i4, 2, 0)) {
            String substring = $this$removeSuffix.substring(i4, length -= length2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return $this$removeSuffix;
    }

    public static final java.lang.CharSequence removeSurrounding(java.lang.CharSequence $this$removeSurrounding, java.lang.CharSequence delimiter) {
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return StringsKt.removeSurrounding($this$removeSurrounding, delimiter, delimiter);
    }

    public static final java.lang.CharSequence removeSurrounding(java.lang.CharSequence $this$removeSurrounding, java.lang.CharSequence prefix, java.lang.CharSequence suffix) {
        int endsWith$default;
        int i;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        int i3 = 0;
        endsWith$default = 2;
        i = 0;
        if ($this$removeSurrounding.length() >= length3 += length5 && StringsKt.startsWith$default($this$removeSurrounding, prefix, i3, endsWith$default, i) && StringsKt.endsWith$default($this$removeSurrounding, suffix, i3, endsWith$default, i)) {
            endsWith$default = 2;
            i = 0;
            if (StringsKt.startsWith$default($this$removeSurrounding, prefix, i3, endsWith$default, i)) {
                if (StringsKt.endsWith$default($this$removeSurrounding, suffix, i3, endsWith$default, i)) {
                    return $this$removeSurrounding.subSequence(prefix.length(), length4 -= length6);
                }
            }
        }
        return $this$removeSurrounding.subSequence(i3, $this$removeSurrounding.length());
    }

    public static final String removeSurrounding(String $this$removeSurrounding, java.lang.CharSequence delimiter) {
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return StringsKt.removeSurrounding($this$removeSurrounding, delimiter, delimiter);
    }

    public static final String removeSurrounding(String $this$removeSurrounding, java.lang.CharSequence prefix, java.lang.CharSequence suffix) {
        int startsWith$default;
        int i;
        int length;
        int i2;
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        i = 0;
        length = 2;
        i2 = 0;
        if ($this$removeSurrounding.length() >= length3 += length && StringsKt.startsWith$default((CharSequence)$this$removeSurrounding, prefix, i, length, i2) && StringsKt.endsWith$default((CharSequence)$this$removeSurrounding, suffix, i, length, i2)) {
            i = 0;
            length = 2;
            i2 = 0;
            if (StringsKt.startsWith$default((CharSequence)$this$removeSurrounding, prefix, i, length, i2)) {
                if (StringsKt.endsWith$default((CharSequence)$this$removeSurrounding, suffix, i, length, i2)) {
                    String substring = $this$removeSurrounding.substring(prefix.length(), length4 -= length5);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    return substring;
                }
            }
        }
        return $this$removeSurrounding;
    }

    private static final String replace(java.lang.CharSequence $this$replace, kotlin.text.Regex regex, String replacement) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return regex.replace($this$replace, replacement);
    }

    private static final String replace(java.lang.CharSequence $this$replace, kotlin.text.Regex regex, Function1<? super kotlin.text.MatchResult, ? extends java.lang.CharSequence> transform) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return regex.replace($this$replace, transform);
    }

    public static final String replaceAfter(String $this$replaceAfter, char delimiter, String replacement, String missingDelimiterValue) {
        Object string;
        Object length;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter($this$replaceAfter, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.indexOf$default((CharSequence)$this$replaceAfter, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            string = missingDelimiterValue;
        } else {
            string = StringsKt.replaceRange((CharSequence)$this$replaceAfter, obj8 + 1, $this$replaceAfter.length(), (CharSequence)replacement).toString();
        }
        return string;
    }

    public static final String replaceAfter(String $this$replaceAfter, String delimiter, String replacement, String missingDelimiterValue) {
        Object string;
        Object length;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$replaceAfter, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final Object obj = delimiter;
        final int obj8 = StringsKt.indexOf$default((CharSequence)$this$replaceAfter, obj, 0, false, 6, 0);
        if (obj8 == -1) {
            string = missingDelimiterValue;
        } else {
            string = StringsKt.replaceRange((CharSequence)$this$replaceAfter, length2 += obj8, $this$replaceAfter.length(), (CharSequence)replacement).toString();
        }
        return string;
    }

    public static String replaceAfter$default(String string, char c2, String string3, String string4, int i5, Object object6) {
        String obj3;
        if (i5 &= 4 != 0) {
            obj3 = string;
        }
        return StringsKt.replaceAfter(string, c2, string3, obj3);
    }

    public static String replaceAfter$default(String string, String string2, String string3, String string4, int i5, Object object6) {
        String obj3;
        if (i5 &= 4 != 0) {
            obj3 = string;
        }
        return StringsKt.replaceAfter(string, string2, string3, obj3);
    }

    public static final String replaceAfterLast(String $this$replaceAfterLast, char delimiter, String replacement, String missingDelimiterValue) {
        Object string;
        Object length;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter($this$replaceAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.lastIndexOf$default((CharSequence)$this$replaceAfterLast, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            string = missingDelimiterValue;
        } else {
            string = StringsKt.replaceRange((CharSequence)$this$replaceAfterLast, obj8 + 1, $this$replaceAfterLast.length(), (CharSequence)replacement).toString();
        }
        return string;
    }

    public static final String replaceAfterLast(String $this$replaceAfterLast, String delimiter, String replacement, String missingDelimiterValue) {
        Object string;
        Object length;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$replaceAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final Object obj = delimiter;
        final int obj8 = StringsKt.lastIndexOf$default((CharSequence)$this$replaceAfterLast, obj, 0, false, 6, 0);
        if (obj8 == -1) {
            string = missingDelimiterValue;
        } else {
            string = StringsKt.replaceRange((CharSequence)$this$replaceAfterLast, length2 += obj8, $this$replaceAfterLast.length(), (CharSequence)replacement).toString();
        }
        return string;
    }

    public static String replaceAfterLast$default(String string, char c2, String string3, String string4, int i5, Object object6) {
        String obj3;
        if (i5 &= 4 != 0) {
            obj3 = string;
        }
        return StringsKt.replaceAfterLast(string, c2, string3, obj3);
    }

    public static String replaceAfterLast$default(String string, String string2, String string3, String string4, int i5, Object object6) {
        String obj3;
        if (i5 &= 4 != 0) {
            obj3 = string;
        }
        return StringsKt.replaceAfterLast(string, string2, string3, obj3);
    }

    public static final String replaceBefore(String $this$replaceBefore, char delimiter, String replacement, String missingDelimiterValue) {
        Object string;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter($this$replaceBefore, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.indexOf$default((CharSequence)$this$replaceBefore, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            string = missingDelimiterValue;
        } else {
            string = StringsKt.replaceRange((CharSequence)$this$replaceBefore, 0, obj8, (CharSequence)replacement).toString();
        }
        return string;
    }

    public static final String replaceBefore(String $this$replaceBefore, String delimiter, String replacement, String missingDelimiterValue) {
        Object string;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter($this$replaceBefore, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.indexOf$default((CharSequence)$this$replaceBefore, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            string = missingDelimiterValue;
        } else {
            string = StringsKt.replaceRange((CharSequence)$this$replaceBefore, 0, obj8, (CharSequence)replacement).toString();
        }
        return string;
    }

    public static String replaceBefore$default(String string, char c2, String string3, String string4, int i5, Object object6) {
        String obj3;
        if (i5 &= 4 != 0) {
            obj3 = string;
        }
        return StringsKt.replaceBefore(string, c2, string3, obj3);
    }

    public static String replaceBefore$default(String string, String string2, String string3, String string4, int i5, Object object6) {
        String obj3;
        if (i5 &= 4 != 0) {
            obj3 = string;
        }
        return StringsKt.replaceBefore(string, string2, string3, obj3);
    }

    public static final String replaceBeforeLast(String $this$replaceBeforeLast, char delimiter, String replacement, String missingDelimiterValue) {
        Object string;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter($this$replaceBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.lastIndexOf$default((CharSequence)$this$replaceBeforeLast, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            string = missingDelimiterValue;
        } else {
            string = StringsKt.replaceRange((CharSequence)$this$replaceBeforeLast, 0, obj8, (CharSequence)replacement).toString();
        }
        return string;
    }

    public static final String replaceBeforeLast(String $this$replaceBeforeLast, String delimiter, String replacement, String missingDelimiterValue) {
        Object string;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter($this$replaceBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.lastIndexOf$default((CharSequence)$this$replaceBeforeLast, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            string = missingDelimiterValue;
        } else {
            string = StringsKt.replaceRange((CharSequence)$this$replaceBeforeLast, 0, obj8, (CharSequence)replacement).toString();
        }
        return string;
    }

    public static String replaceBeforeLast$default(String string, char c2, String string3, String string4, int i5, Object object6) {
        String obj3;
        if (i5 &= 4 != 0) {
            obj3 = string;
        }
        return StringsKt.replaceBeforeLast(string, c2, string3, obj3);
    }

    public static String replaceBeforeLast$default(String string, String string2, String string3, String string4, int i5, Object object6) {
        String obj3;
        if (i5 &= 4 != 0) {
            obj3 = string;
        }
        return StringsKt.replaceBeforeLast(string, string2, string3, obj3);
    }

    private static final String replaceFirst(java.lang.CharSequence $this$replaceFirst, kotlin.text.Regex regex, String replacement) {
        Intrinsics.checkNotNullParameter($this$replaceFirst, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return regex.replaceFirst($this$replaceFirst, replacement);
    }

    private static final String replaceFirstCharWithChar(String $this$replaceFirstChar, Function1<? super Character, Character> transform) {
        int i;
        Object string;
        int substring;
        int stringBuilder;
        Intrinsics.checkNotNullParameter($this$replaceFirstChar, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        substring = 1;
        stringBuilder = 0;
        i = (CharSequence)$this$replaceFirstChar.length() > 0 ? substring : stringBuilder;
        if (i != 0) {
            substring = $this$replaceFirstChar.substring(substring);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            stringBuilder = new StringBuilder();
            string = stringBuilder.append((Character)transform.invoke(Character.valueOf($this$replaceFirstChar.charAt(stringBuilder))).charValue()).append(substring).toString();
        } else {
            string = $this$replaceFirstChar;
        }
        return string;
    }

    private static final String replaceFirstCharWithCharSequence(String $this$replaceFirstChar, Function1<? super Character, ? extends java.lang.CharSequence> transform) {
        int i;
        Object string;
        int substring;
        int str;
        Intrinsics.checkNotNullParameter($this$replaceFirstChar, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        substring = 1;
        str = 0;
        i = (CharSequence)$this$replaceFirstChar.length() > 0 ? substring : str;
        if (i != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            substring = $this$replaceFirstChar.substring(substring);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            string = stringBuilder.append(transform.invoke(Character.valueOf($this$replaceFirstChar.charAt(str)))).append(substring).toString();
        } else {
            string = $this$replaceFirstChar;
        }
        return string;
    }

    public static final java.lang.CharSequence replaceRange(java.lang.CharSequence $this$replaceRange, int startIndex, int endIndex, java.lang.CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        if (endIndex < startIndex) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "append(...)";
            Intrinsics.checkNotNullExpressionValue(stringBuilder.append($this$replaceRange, 0, startIndex), str3);
            stringBuilder.append(replacement);
            Intrinsics.checkNotNullExpressionValue(stringBuilder.append($this$replaceRange, endIndex, $this$replaceRange.length()), str3);
            return (CharSequence)stringBuilder;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IndexOutOfBoundsException sb = new IndexOutOfBoundsException(stringBuilder2.append("End index (").append(endIndex).append(") is less than start index (").append(startIndex).append(").").toString());
        throw sb;
    }

    public static final java.lang.CharSequence replaceRange(java.lang.CharSequence $this$replaceRange, IntRange range, java.lang.CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return StringsKt.replaceRange($this$replaceRange, range.getStart().intValue(), intValue2++, replacement);
    }

    private static final String replaceRange(String $this$replaceRange, int startIndex, int endIndex, java.lang.CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return StringsKt.replaceRange((CharSequence)$this$replaceRange, startIndex, endIndex, replacement).toString();
    }

    private static final String replaceRange(String $this$replaceRange, IntRange range, java.lang.CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return StringsKt.replaceRange((CharSequence)$this$replaceRange, range, replacement).toString();
    }

    public static final void requireNonNegativeLimit(int limit) {
        int i;
        i = limit >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Limit must be non-negative, but was ").append(limit).toString().toString());
        throw illegalArgumentException;
    }

    private static final List<String> split(java.lang.CharSequence $this$split, kotlin.text.Regex regex, int limit) {
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.split($this$split, limit);
    }

    public static final List<String> split(java.lang.CharSequence $this$split, char[] delimiters, boolean ignoreCase, int limit) {
        int next;
        int it;
        int i;
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return StringsKt__StringsKt.split$StringsKt__StringsKt($this$split, String.valueOf(delimiters[0]), ignoreCase, limit);
        }
        Object obj = $this$split;
        Iterable obj9 = SequencesKt.asIterable(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(obj, delimiters, 0, ignoreCase, limit, 2, 0));
        final int obj10 = 0;
        ArrayList obj11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(obj9, 10));
        int i3 = 0;
        Iterator iterator = obj9.iterator();
        for (Object next : iterator) {
            i = 0;
            (Collection)obj11.add(StringsKt.substring(obj, (IntRange)next));
        }
        return (List)obj11;
    }

    public static final List<String> split(java.lang.CharSequence $this$split, String[] delimiters, boolean ignoreCase, int limit) {
        int length;
        int i2;
        Object next;
        int length2;
        int it;
        int i;
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            length = 0;
            next = delimiters[length];
            if ((CharSequence)next.length() == 0) {
            } else {
                i2 = length;
            }
            if (i2 == 0) {
                return StringsKt__StringsKt.split$StringsKt__StringsKt($this$split, next, ignoreCase, limit);
            }
        }
        Object obj = $this$split;
        Iterable obj10 = SequencesKt.asIterable(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(obj, delimiters, 0, ignoreCase, limit, 2, 0));
        final int obj11 = 0;
        ArrayList obj12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(obj10, 10));
        int i3 = 0;
        Iterator iterator = obj10.iterator();
        for (Object next : iterator) {
            i = 0;
            (Collection)obj12.add(StringsKt.substring(obj, (IntRange)next));
        }
        return (List)obj12;
    }

    private static final List<String> split$StringsKt__StringsKt(java.lang.CharSequence $this$split, String delimiter, boolean ignoreCase, int limit) {
        int currentOffset;
        int nextIndex;
        int i;
        int coerceAtMost;
        int i2;
        StringsKt.requireNonNegativeLimit(limit);
        int i3 = -1;
        if (StringsKt.indexOf($this$split, delimiter, 0, ignoreCase) != i3) {
            if (limit == 1) {
            } else {
                if (limit > 0) {
                } else {
                    i = 0;
                }
                if (i != 0) {
                    coerceAtMost = RangesKt.coerceAtMost(limit, 10);
                }
                ArrayList arrayList = new ArrayList(coerceAtMost);
                arrayList.add($this$split.subSequence(currentOffset, nextIndex).toString());
                currentOffset = nextIndex + coerceAtMost;
                while (i != 0) {
                    if (arrayList.size() != limit + -1) {
                    }
                    if (StringsKt.indexOf($this$split, delimiter, currentOffset, ignoreCase) != i3) {
                    }
                    arrayList.add($this$split.subSequence(currentOffset, nextIndex).toString());
                    currentOffset = nextIndex + coerceAtMost;
                }
            }
            arrayList.add($this$split.subSequence(currentOffset, $this$split.length()).toString());
            return (List)arrayList;
        }
        return CollectionsKt.listOf($this$split.toString());
    }

    static List split$default(java.lang.CharSequence $this$split_u24default, kotlin.text.Regex regex, int limit, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        Intrinsics.checkNotNullParameter($this$split_u24default, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.split($this$split_u24default, obj2);
    }

    public static List split$default(java.lang.CharSequence charSequence, char[] c2Arr2, boolean z3, int i4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return StringsKt.split(charSequence, c2Arr2, obj3, obj4);
    }

    public static List split$default(java.lang.CharSequence charSequence, String[] string2Arr2, boolean z3, int i4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return StringsKt.split(charSequence, string2Arr2, obj3, obj4);
    }

    private static final Sequence<String> splitToSequence(java.lang.CharSequence $this$splitToSequence, kotlin.text.Regex regex, int limit) {
        Intrinsics.checkNotNullParameter($this$splitToSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.splitToSequence($this$splitToSequence, limit);
    }

    public static final Sequence<String> splitToSequence(java.lang.CharSequence $this$splitToSequence, char[] delimiters, boolean ignoreCase, int limit) {
        Intrinsics.checkNotNullParameter($this$splitToSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        final Object obj = $this$splitToSequence;
        StringsKt__StringsKt.splitToSequence.2 obj9 = new StringsKt__StringsKt.splitToSequence.2(obj);
        return SequencesKt.map(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(obj, delimiters, 0, ignoreCase, limit, 2, 0), (Function1)obj9);
    }

    public static final Sequence<String> splitToSequence(java.lang.CharSequence $this$splitToSequence, String[] delimiters, boolean ignoreCase, int limit) {
        Intrinsics.checkNotNullParameter($this$splitToSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        final Object obj = $this$splitToSequence;
        StringsKt__StringsKt.splitToSequence.1 obj9 = new StringsKt__StringsKt.splitToSequence.1(obj);
        return SequencesKt.map(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(obj, delimiters, 0, ignoreCase, limit, 2, 0), (Function1)obj9);
    }

    static Sequence splitToSequence$default(java.lang.CharSequence $this$splitToSequence_u24default, kotlin.text.Regex regex, int limit, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        Intrinsics.checkNotNullParameter($this$splitToSequence_u24default, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.splitToSequence($this$splitToSequence_u24default, obj2);
    }

    public static Sequence splitToSequence$default(java.lang.CharSequence charSequence, char[] c2Arr2, boolean z3, int i4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return StringsKt.splitToSequence(charSequence, c2Arr2, obj3, obj4);
    }

    public static Sequence splitToSequence$default(java.lang.CharSequence charSequence, String[] string2Arr2, boolean z3, int i4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return StringsKt.splitToSequence(charSequence, string2Arr2, obj3, obj4);
    }

    public static final boolean startsWith(java.lang.CharSequence $this$startsWith, char char, boolean ignoreCase) {
        int length;
        int i;
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        if ($this$startsWith.length() > 0 && CharsKt.equals($this$startsWith.charAt(0), char, ignoreCase)) {
            if (CharsKt.equals($this$startsWith.charAt(i), char, ignoreCase)) {
                i = 1;
            }
        }
        return i;
    }

    public static final boolean startsWith(java.lang.CharSequence $this$startsWith, java.lang.CharSequence prefix, int startIndex, boolean ignoreCase) {
        String str;
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!ignoreCase && $this$startsWith instanceof String != null && prefix instanceof String != null) {
            if ($this$startsWith instanceof String != null) {
                if (prefix instanceof String != null) {
                    int i2 = startIndex;
                    int i = i2;
                    return StringsKt.startsWith$default((String)$this$startsWith, (String)prefix, i2, false, 4, 0);
                }
            }
        }
        return StringsKt.regionMatchesImpl($this$startsWith, startIndex, prefix, 0, prefix.length(), ignoreCase);
    }

    public static final boolean startsWith(java.lang.CharSequence $this$startsWith, java.lang.CharSequence prefix, boolean ignoreCase) {
        String str;
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!ignoreCase && $this$startsWith instanceof String != null && prefix instanceof String != null) {
            if ($this$startsWith instanceof String != null) {
                if (prefix instanceof String != null) {
                    return StringsKt.startsWith$default((String)$this$startsWith, (String)prefix, false, 2, 0);
                }
            }
        }
        return StringsKt.regionMatchesImpl($this$startsWith, 0, prefix, 0, prefix.length(), ignoreCase);
    }

    public static boolean startsWith$default(java.lang.CharSequence charSequence, char c2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.startsWith(charSequence, c2, obj2);
    }

    public static boolean startsWith$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return StringsKt.startsWith(charSequence, charSequence2, i3, obj3);
    }

    public static boolean startsWith$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return StringsKt.startsWith(charSequence, charSequence2, obj2);
    }

    public static final java.lang.CharSequence subSequence(java.lang.CharSequence $this$subSequence, IntRange range) {
        Intrinsics.checkNotNullParameter($this$subSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return $this$subSequence.subSequence(range.getStart().intValue(), intValue2++);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(...))
    private static final java.lang.CharSequence subSequence(String $this$subSequence, int start, int end) {
        Intrinsics.checkNotNullParameter($this$subSequence, "<this>");
        return $this$subSequence.subSequence(start, end);
    }

    private static final String substring(java.lang.CharSequence $this$substring, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        return $this$substring.subSequence(startIndex, endIndex).toString();
    }

    public static final String substring(java.lang.CharSequence $this$substring, IntRange range) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return $this$substring.subSequence(range.getStart().intValue(), intValue2++).toString();
    }

    public static final String substring(String $this$substring, IntRange range) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        String substring = $this$substring.substring(range.getStart().intValue(), intValue2++);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    static String substring$default(java.lang.CharSequence $this$substring_u24default, int startIndex, int endIndex, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = $this$substring_u24default.length();
        }
        Intrinsics.checkNotNullParameter($this$substring_u24default, "<this>");
        return $this$substring_u24default.subSequence(startIndex, obj2).toString();
    }

    public static final String substringAfter(String $this$substringAfter, char delimiter, String missingDelimiterValue) {
        Object substring;
        Object str;
        Intrinsics.checkNotNullParameter($this$substringAfter, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.indexOf$default((CharSequence)$this$substringAfter, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            substring = missingDelimiterValue;
        } else {
            Intrinsics.checkNotNullExpressionValue($this$substringAfter.substring(obj8 + 1, $this$substringAfter.length()), "substring(...)");
        }
        return substring;
    }

    public static final String substringAfter(String $this$substringAfter, String delimiter, String missingDelimiterValue) {
        Object substring;
        Object str;
        Intrinsics.checkNotNullParameter($this$substringAfter, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final Object obj = delimiter;
        final int obj8 = StringsKt.indexOf$default((CharSequence)$this$substringAfter, obj, 0, false, 6, 0);
        if (obj8 == -1) {
            substring = missingDelimiterValue;
        } else {
            Intrinsics.checkNotNullExpressionValue($this$substringAfter.substring(length += obj8, $this$substringAfter.length()), "substring(...)");
        }
        return substring;
    }

    public static String substringAfter$default(String string, char c2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return StringsKt.substringAfter(string, c2, obj2);
    }

    public static String substringAfter$default(String string, String string2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return StringsKt.substringAfter(string, string2, obj2);
    }

    public static final String substringAfterLast(String $this$substringAfterLast, char delimiter, String missingDelimiterValue) {
        Object substring;
        Object str;
        Intrinsics.checkNotNullParameter($this$substringAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.lastIndexOf$default((CharSequence)$this$substringAfterLast, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            substring = missingDelimiterValue;
        } else {
            Intrinsics.checkNotNullExpressionValue($this$substringAfterLast.substring(obj8 + 1, $this$substringAfterLast.length()), "substring(...)");
        }
        return substring;
    }

    public static final String substringAfterLast(String $this$substringAfterLast, String delimiter, String missingDelimiterValue) {
        Object substring;
        Object str;
        Intrinsics.checkNotNullParameter($this$substringAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final Object obj = delimiter;
        final int obj8 = StringsKt.lastIndexOf$default((CharSequence)$this$substringAfterLast, obj, 0, false, 6, 0);
        if (obj8 == -1) {
            substring = missingDelimiterValue;
        } else {
            Intrinsics.checkNotNullExpressionValue($this$substringAfterLast.substring(length += obj8, $this$substringAfterLast.length()), "substring(...)");
        }
        return substring;
    }

    public static String substringAfterLast$default(String string, char c2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return StringsKt.substringAfterLast(string, c2, obj2);
    }

    public static String substringAfterLast$default(String string, String string2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return StringsKt.substringAfterLast(string, string2, obj2);
    }

    public static final String substringBefore(String $this$substringBefore, char delimiter, String missingDelimiterValue) {
        Object substring;
        Object str;
        Intrinsics.checkNotNullParameter($this$substringBefore, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.indexOf$default((CharSequence)$this$substringBefore, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            substring = missingDelimiterValue;
        } else {
            Intrinsics.checkNotNullExpressionValue($this$substringBefore.substring(0, obj8), "substring(...)");
        }
        return substring;
    }

    public static final String substringBefore(String $this$substringBefore, String delimiter, String missingDelimiterValue) {
        Object substring;
        Object str;
        Intrinsics.checkNotNullParameter($this$substringBefore, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.indexOf$default((CharSequence)$this$substringBefore, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            substring = missingDelimiterValue;
        } else {
            Intrinsics.checkNotNullExpressionValue($this$substringBefore.substring(0, obj8), "substring(...)");
        }
        return substring;
    }

    public static String substringBefore$default(String string, char c2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return StringsKt.substringBefore(string, c2, obj2);
    }

    public static String substringBefore$default(String string, String string2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return StringsKt.substringBefore(string, string2, obj2);
    }

    public static final String substringBeforeLast(String $this$substringBeforeLast, char delimiter, String missingDelimiterValue) {
        Object substring;
        Object str;
        Intrinsics.checkNotNullParameter($this$substringBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.lastIndexOf$default((CharSequence)$this$substringBeforeLast, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            substring = missingDelimiterValue;
        } else {
            Intrinsics.checkNotNullExpressionValue($this$substringBeforeLast.substring(0, obj8), "substring(...)");
        }
        return substring;
    }

    public static final String substringBeforeLast(String $this$substringBeforeLast, String delimiter, String missingDelimiterValue) {
        Object substring;
        Object str;
        Intrinsics.checkNotNullParameter($this$substringBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        final int obj8 = StringsKt.lastIndexOf$default((CharSequence)$this$substringBeforeLast, delimiter, 0, false, 6, 0);
        if (obj8 == -1) {
            substring = missingDelimiterValue;
        } else {
            Intrinsics.checkNotNullExpressionValue($this$substringBeforeLast.substring(0, obj8), "substring(...)");
        }
        return substring;
    }

    public static String substringBeforeLast$default(String string, char c2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return StringsKt.substringBeforeLast(string, c2, obj2);
    }

    public static String substringBeforeLast$default(String string, String string2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return StringsKt.substringBeforeLast(string, string2, obj2);
    }

    public static final boolean toBooleanStrict(String $this$toBooleanStrict) {
        int i;
        Intrinsics.checkNotNullParameter($this$toBooleanStrict, "<this>");
        if (Intrinsics.areEqual($this$toBooleanStrict, "true")) {
            i = 1;
            return i;
        } else {
            if (!Intrinsics.areEqual($this$toBooleanStrict, "false")) {
            } else {
                i = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The string doesn't represent a boolean value: ").append($this$toBooleanStrict).toString());
        throw illegalArgumentException;
    }

    public static final Boolean toBooleanStrictOrNull(String $this$toBooleanStrictOrNull) {
        Boolean valueOf;
        Intrinsics.checkNotNullParameter($this$toBooleanStrictOrNull, "<this>");
        if (Intrinsics.areEqual($this$toBooleanStrictOrNull, "true")) {
            valueOf = true;
        } else {
            if (Intrinsics.areEqual($this$toBooleanStrictOrNull, "false")) {
                valueOf = false;
            } else {
                valueOf = 0;
            }
        }
        return valueOf;
    }

    public static final java.lang.CharSequence trim(java.lang.CharSequence $this$trim) {
        int startIndex$iv;
        int endIndex$iv;
        int startFound$iv;
        int i;
        boolean p0;
        int i2;
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Object obj = $this$trim;
        final int i3 = 0;
        startIndex$iv = 0;
        length--;
        startFound$iv = 0;
        while (startIndex$iv <= endIndex$iv) {
            if (startFound$iv == 0) {
            } else {
            }
            i = endIndex$iv;
            i2 = 0;
            p0 = CharsKt.isWhitespace(obj.charAt(i));
            if (startFound$iv != 0) {
                break;
            } else {
            }
            if (!p0) {
                break;
            } else {
            }
            endIndex$iv--;
            if (!p0) {
            } else {
            }
            startIndex$iv++;
            startFound$iv = 1;
            i = startIndex$iv;
        }
        return obj.subSequence(startIndex$iv, endIndex$iv + 1);
    }

    public static final java.lang.CharSequence trim(java.lang.CharSequence $this$trim, Function1<? super Character, Boolean> predicate) {
        int startIndex;
        int endIndex;
        int startFound;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        startIndex = 0;
        length--;
        startFound = 0;
        while (startIndex <= endIndex) {
            if (startFound == 0) {
            } else {
            }
            i = endIndex;
            booleanValue = (Boolean)predicate.invoke(Character.valueOf($this$trim.charAt(i))).booleanValue();
            if (startFound != 0) {
                break;
            } else {
            }
            if (!booleanValue) {
                break;
            } else {
            }
            endIndex--;
            if (!booleanValue) {
            } else {
            }
            startIndex++;
            startFound = 1;
            i = startIndex;
        }
        return $this$trim.subSequence(startIndex, endIndex + 1);
    }

    public static final java.lang.CharSequence trim(java.lang.CharSequence $this$trim, char... chars) {
        int startIndex$iv;
        int endIndex$iv;
        int startFound$iv;
        int i2;
        boolean it;
        int i;
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        Object obj = $this$trim;
        final int i3 = 0;
        startIndex$iv = 0;
        length--;
        startFound$iv = 0;
        while (startIndex$iv <= endIndex$iv) {
            if (startFound$iv == 0) {
            } else {
            }
            i2 = endIndex$iv;
            i = 0;
            it = ArraysKt.contains(chars, obj.charAt(i2));
            if (startFound$iv != 0) {
                break;
            } else {
            }
            if (!it) {
                break;
            } else {
            }
            endIndex$iv--;
            if (!it) {
            } else {
            }
            startIndex$iv++;
            startFound$iv = 1;
            i2 = startIndex$iv;
        }
        return obj.subSequence(startIndex$iv, endIndex$iv + 1);
    }

    private static final String trim(String $this$trim) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        return StringsKt.trim((CharSequence)$this$trim).toString();
    }

    public static final String trim(String $this$trim, Function1<? super Character, Boolean> predicate) {
        int startIndex$iv;
        int endIndex$iv;
        int startFound$iv;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        Object obj = $this$trim;
        final int i3 = 0;
        startIndex$iv = 0;
        length--;
        startFound$iv = 0;
        while (startIndex$iv <= endIndex$iv) {
            if (startFound$iv == 0) {
            } else {
            }
            i = endIndex$iv;
            booleanValue = (Boolean)predicate.invoke(Character.valueOf(obj.charAt(i))).booleanValue();
            if (startFound$iv != 0) {
                break;
            } else {
            }
            if (!booleanValue) {
                break;
            } else {
            }
            endIndex$iv--;
            if (!booleanValue) {
            } else {
            }
            startIndex$iv++;
            startFound$iv = 1;
            i = startIndex$iv;
        }
        return obj.subSequence(startIndex$iv, endIndex$iv + 1).toString();
    }

    public static final String trim(String $this$trim, char... chars) {
        int startIndex$iv$iv;
        int endIndex$iv$iv;
        int startFound$iv$iv;
        int i2;
        boolean it;
        int i;
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        final int i3 = 0;
        Object obj2 = obj;
        final int i4 = 0;
        startIndex$iv$iv = 0;
        length--;
        startFound$iv$iv = 0;
        while (startIndex$iv$iv <= endIndex$iv$iv) {
            if (startFound$iv$iv == 0) {
            } else {
            }
            i2 = endIndex$iv$iv;
            i = 0;
            it = ArraysKt.contains(chars, obj2.charAt(i2));
            if (startFound$iv$iv != 0) {
                break;
            } else {
            }
            if (!it) {
                break;
            } else {
            }
            endIndex$iv$iv--;
            if (!it) {
            } else {
            }
            startIndex$iv$iv++;
            startFound$iv$iv = 1;
            i2 = startIndex$iv$iv;
        }
        return obj2.subSequence(startIndex$iv$iv, endIndex$iv$iv + 1).toString();
    }

    public static final java.lang.CharSequence trimEnd(java.lang.CharSequence $this$trimEnd) {
        int i3;
        Object subSequence;
        int i2;
        boolean p0;
        int i;
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        Object obj = $this$trimEnd;
        final int i4 = 0;
        if (length-- >= 0) {
        } else {
            subSequence = "";
        }
        return subSequence;
    }

    public static final java.lang.CharSequence trimEnd(java.lang.CharSequence $this$trimEnd, Function1<? super Character, Boolean> predicate) {
        int i;
        int i2;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        if (length-- >= 0) {
        }
        return (CharSequence)"";
    }

    public static final java.lang.CharSequence trimEnd(java.lang.CharSequence $this$trimEnd, char... chars) {
        int i3;
        Object subSequence;
        int i2;
        boolean it;
        int i;
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        Object obj = $this$trimEnd;
        final int i4 = 0;
        if (length-- >= 0) {
        } else {
            subSequence = "";
        }
        return subSequence;
    }

    private static final String trimEnd(String $this$trimEnd) {
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        return StringsKt.trimEnd((CharSequence)$this$trimEnd).toString();
    }

    public static final String trimEnd(String $this$trimEnd, Function1<? super Character, Boolean> predicate) {
        int i2;
        Object subSequence;
        int i;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i3 = 0;
        Object obj = $this$trimEnd;
        final int i4 = 0;
        if (length-- >= 0) {
        } else {
            subSequence = "";
        }
        return subSequence.toString();
    }

    public static final String trimEnd(String $this$trimEnd, char... chars) {
        int i;
        Object subSequence;
        int i3;
        boolean it;
        int i2;
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        final int i4 = 0;
        final Object obj2 = obj;
        final int i5 = 0;
        if (length-- >= 0) {
        } else {
            subSequence = "";
        }
        return subSequence.toString();
    }

    public static final java.lang.CharSequence trimStart(java.lang.CharSequence $this$trimStart) {
        int index$iv;
        Object subSequence;
        boolean p0;
        int i;
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        Object obj = $this$trimStart;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < obj.length()) {
            i = 0;
            index$iv++;
        }
        subSequence = index$iv;
        return subSequence;
    }

    public static final java.lang.CharSequence trimStart(java.lang.CharSequence $this$trimStart, Function1<? super Character, Boolean> predicate) {
        int index;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        index = 0;
        while (index < $this$trimStart.length()) {
            index++;
        }
        return (CharSequence)"";
    }

    public static final java.lang.CharSequence trimStart(java.lang.CharSequence $this$trimStart, char... chars) {
        int index$iv;
        Object subSequence;
        boolean it;
        int i;
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        Object obj = $this$trimStart;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < obj.length()) {
            i = 0;
            index$iv++;
        }
        subSequence = index$iv;
        return subSequence;
    }

    private static final String trimStart(String $this$trimStart) {
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        return StringsKt.trimStart((CharSequence)$this$trimStart).toString();
    }

    public static final String trimStart(String $this$trimStart, Function1<? super Character, Boolean> predicate) {
        int index$iv;
        Object subSequence;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        Object obj = $this$trimStart;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < (CharSequence)obj.length()) {
            index$iv++;
        }
        subSequence = index$iv;
        return subSequence.toString();
    }

    public static final String trimStart(String $this$trimStart, char... chars) {
        int index$iv$iv;
        Object subSequence;
        boolean it;
        int i;
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        final int i2 = 0;
        final Object obj2 = obj;
        final int i3 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < (CharSequence)obj2.length()) {
            i = 0;
            index$iv$iv++;
        }
        subSequence = index$iv$iv;
        return subSequence.toString();
    }
}
