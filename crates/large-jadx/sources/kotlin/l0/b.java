package kotlin.l0;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.k0.l;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0006\n\u0002\u00084\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0087@\u0018\u0000 ¬\u00012\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¬\u0001B\u0014\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005J%\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008N\u0010OJ\u001b\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\u0008R\u0010SJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008V\u0010WJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008V\u0010XJ\u001b\u0010T\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008Y\u0010ZJ\u001a\u0010[\u001a\u00020\\2\u0008\u0010Q\u001a\u0004\u0018\u00010]HÖ\u0003¢\u0006\u0004\u0008^\u0010_J\u0010\u0010`\u001a\u00020\tHÖ\u0001¢\u0006\u0004\u0008a\u0010\rJ\r\u0010b\u001a\u00020\\¢\u0006\u0004\u0008c\u0010dJ\u000f\u0010e\u001a\u00020\\H\u0002¢\u0006\u0004\u0008f\u0010dJ\u000f\u0010g\u001a\u00020\\H\u0002¢\u0006\u0004\u0008h\u0010dJ\r\u0010i\u001a\u00020\\¢\u0006\u0004\u0008j\u0010dJ\r\u0010k\u001a\u00020\\¢\u0006\u0004\u0008l\u0010dJ\r\u0010m\u001a\u00020\\¢\u0006\u0004\u0008n\u0010dJ\u001b\u0010o\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008p\u0010qJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008s\u0010qJ\u001e\u0010t\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008u\u0010WJ\u001e\u0010t\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008u\u0010XJ \u0001\u0010v\u001a\u0002Hw\"\u0004\u0008\u0000\u0010w2v\u0010x\u001ar\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008z\u0012\u0008\u0008{\u0012\u0004\u0008\u0008(|\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008z\u0012\u0008\u0008{\u0012\u0004\u0008\u0008(}\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008z\u0012\u0008\u0008{\u0012\u0004\u0008\u0008(~\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008z\u0012\u0008\u0008{\u0012\u0004\u0008\u0008(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\u0008z\u0012\t\u0008{\u0012\u0005\u0008\u0008(\u0080\u0001\u0012\u0004\u0012\u0002Hw0yH\u0086\u0008ø\u0001\u0002\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\u0008\u0081\u0001\u0010\u0082\u0001J\u008c\u0001\u0010v\u001a\u0002Hw\"\u0004\u0008\u0000\u0010w2b\u0010x\u001a^\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008z\u0012\u0008\u0008{\u0012\u0004\u0008\u0008(}\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008z\u0012\u0008\u0008{\u0012\u0004\u0008\u0008(~\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008z\u0012\u0008\u0008{\u0012\u0004\u0008\u0008(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\u0008z\u0012\t\u0008{\u0012\u0005\u0008\u0008(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0083\u0001H\u0086\u0008ø\u0001\u0002\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\u0008\u0081\u0001\u0010\u0084\u0001Jw\u0010v\u001a\u0002Hw\"\u0004\u0008\u0000\u0010w2M\u0010x\u001aI\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008z\u0012\u0008\u0008{\u0012\u0004\u0008\u0008(~\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008z\u0012\u0008\u0008{\u0012\u0004\u0008\u0008(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\u0008z\u0012\t\u0008{\u0012\u0005\u0008\u0008(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0085\u0001H\u0086\u0008ø\u0001\u0002\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\u0008\u0081\u0001\u0010\u0086\u0001Jb\u0010v\u001a\u0002Hw\"\u0004\u0008\u0000\u0010w28\u0010x\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008z\u0012\u0008\u0008{\u0012\u0004\u0008\u0008(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\u0008z\u0012\t\u0008{\u0012\u0005\u0008\u0008(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0087\u0001H\u0086\u0008ø\u0001\u0002\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\u0008\u0081\u0001\u0010\u0088\u0001J\u001e\u0010\u0089\u0001\u001a\u00020\u000f2\u000c\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001¢\u0006\u0006\u0008\u008c\u0001\u0010\u008d\u0001J\u001e\u0010\u008e\u0001\u001a\u00020\t2\u000c\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001¢\u0006\u0006\u0008\u008f\u0001\u0010\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u00030\u0092\u0001¢\u0006\u0006\u0008\u0093\u0001\u0010\u0094\u0001J\u001e\u0010\u0095\u0001\u001a\u00020\u00032\u000c\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001¢\u0006\u0006\u0008\u0096\u0001\u0010\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\u0008\u0099\u0001\u0010\u0005J\u0011\u0010\u009a\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\u0008\u009b\u0001\u0010\u0005J\u0013\u0010\u009c\u0001\u001a\u00030\u0092\u0001H\u0016¢\u0006\u0006\u0008\u009d\u0001\u0010\u0094\u0001J*\u0010\u009c\u0001\u001a\u00030\u0092\u00012\u000c\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u00012\t\u0008\u0002\u0010\u009e\u0001\u001a\u00020\t¢\u0006\u0006\u0008\u009d\u0001\u0010\u009f\u0001J\u0018\u0010 \u0001\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\u0008¡\u0001\u0010\u0005JK\u0010¢\u0001\u001a\u00030£\u0001*\u00080¤\u0001j\u0003`¥\u00012\u0007\u0010¦\u0001\u001a\u00020\t2\u0007\u0010§\u0001\u001a\u00020\t2\u0007\u0010¨\u0001\u001a\u00020\t2\u0008\u0010\u008a\u0001\u001a\u00030\u0092\u00012\u0007\u0010©\u0001\u001a\u00020\\H\u0002¢\u0006\u0006\u0008ª\u0001\u0010«\u0001R\u0017\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005R\u001a\u0010\u0008\u001a\u00020\t8@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\u000b\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0014\u0010\u000b\u001a\u0004\u0008\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0017\u0010\u000b\u001a\u0004\u0008\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001a\u0010\u000b\u001a\u0004\u0008\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001d\u0010\u000b\u001a\u0004\u0008\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008 \u0010\u000b\u001a\u0004\u0008!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008#\u0010\u000b\u001a\u0004\u0008$\u0010\u0012R\u001a\u0010%\u001a\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008&\u0010\u000b\u001a\u0004\u0008'\u0010\u0005R\u001a\u0010(\u001a\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008)\u0010\u000b\u001a\u0004\u0008*\u0010\u0005R\u001a\u0010+\u001a\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008,\u0010\u000b\u001a\u0004\u0008-\u0010\u0005R\u001a\u0010.\u001a\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008/\u0010\u000b\u001a\u0004\u00080\u0010\u0005R\u001a\u00101\u001a\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u00082\u0010\u000b\u001a\u0004\u00083\u0010\u0005R\u001a\u00104\u001a\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u00085\u0010\u000b\u001a\u0004\u00086\u0010\u0005R\u001a\u00107\u001a\u00020\u00038FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u00088\u0010\u000b\u001a\u0004\u00089\u0010\u0005R\u001a\u0010:\u001a\u00020\t8@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008;\u0010\u000b\u001a\u0004\u0008<\u0010\rR\u001a\u0010=\u001a\u00020\t8@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008>\u0010\u000b\u001a\u0004\u0008?\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\t8@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008A\u0010\u000b\u001a\u0004\u0008B\u0010\rR\u0014\u0010C\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008E\u0010FR\u0015\u0010G\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008H\u0010\rR\u0014\u0010I\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008J\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0002\u0008!\n\u0005\u0008\u009920\u0001¨\u0006­\u0001", d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays$annotations", "getInWholeDays-impl", "inWholeHours", "getInWholeHours$annotations", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds$annotations", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds$annotations", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes$annotations", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds$annotations", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds$annotations", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Ljava/util/concurrent/TimeUnit;", "getStorageUnit-impl", "(J)Ljava/util/concurrent/TimeUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(JLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(JLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class b implements Comparable<kotlin.l0.b> {

    private static final long a = 0;
    private static final long b;
    private static final long c;
    public static final kotlin.l0.b.a v;

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0014\u0010\u0017J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0014\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001b\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001b\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001b\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001d\u0010\u0015J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001d\u0010\u0017J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001d\u0010\u0019J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001f\u0010\u0015J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001f\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001f\u0010\u0019J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008!\u0010\u0015J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008!\u0010\u0017J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008!\u0010\u0019J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008#\u0010\u0015J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008#\u0010\u0017J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008#\u0010\u0019J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008&\u0010'J\u001d\u0010(\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008)\u0010'J\u001d\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0008+J\u001d\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0008-J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008/\u0010\u0015J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008/\u0010\u0017J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008/\u0010\u0019R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u001c\u0010\u0008\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006\u0082\u0002\u0008\n\u0002\u0008\u0019\n\u0002\u0008!¨\u00060", d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "days", "days-UwyO8pc", "(D)J", "", "(I)J", "", "(J)J", "hours", "hours-UwyO8pc", "microseconds", "microseconds-UwyO8pc", "milliseconds", "milliseconds-UwyO8pc", "minutes", "minutes-UwyO8pc", "nanoseconds", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final long a() {
            return b.a();
        }
    }
    static {
        final int i2 = 0;
        b.a aVar = new b.a(i2);
        b.v = aVar;
        b.f(0);
        b.b = c.b(4611686018427387903L);
        b.c = c.b(-4611686018427387903L);
    }

    public static final long A(long l, long l2) {
        int i2;
        boolean z;
        int i;
        long l5;
        long l3;
        long l4;
        long l6;
        long obj7;
        long obj9;
        if (b.x(l) && !b.u(obj9)) {
            if (!b.u(obj9)) {
                if (Long.compare(obj9, z) < 0) {
                } else {
                }
                obj7 = new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
                throw obj7;
            }
            return l;
        }
        if (b.x(obj9)) {
            return obj9;
        }
        i5 &= 1;
        if (i3 &= 1 == i) {
            l7 += obj9;
            if (b.w(l)) {
                obj7 = c.e(i2);
            } else {
                obj7 = c.c(i2);
            }
        } else {
            if (b.v(l)) {
                obj7 = b.c(l, obj2, b.t(l));
            } else {
                obj7 = b.c(l, i, b.t(obj9));
            }
        }
        return obj7;
    }

    public static final double B(long l, TimeUnit timeUnit2) {
        int cmp;
        long obj2;
        n.f(obj4, "unit");
        if (Long.compare(l, l2) == 0) {
            obj2 = 9218868437227405312L;
        } else {
            if (Long.compare(l, l3) == 0) {
                obj2 = -4503599627370496L;
            } else {
                obj2 = d.a((double)l4, obj1, b.s(l));
            }
        }
        return obj2;
    }

    public static final int C(long l, TimeUnit timeUnit2) {
        n.f(obj9, "unit");
        return (int)obj7;
    }

    public static final long D(long l, TimeUnit timeUnit2) {
        int cmp;
        long obj2;
        n.f(obj4, "unit");
        if (Long.compare(l, l2) == 0) {
            obj2 = Long.MAX_VALUE;
        } else {
            if (Long.compare(l, l3) == 0) {
                obj2 = Long.MIN_VALUE;
            } else {
                obj2 = d.b(b.t(l), obj1, b.s(l));
            }
        }
        return obj2;
    }

    public static String E(long l) {
        int i6;
        int i8;
        boolean cmp;
        int i;
        int i3;
        int i10;
        int i7;
        int i2;
        int str;
        int i4;
        StringBuilder stringBuilder;
        int i9;
        int i5;
        int obj14;
        int obj15;
        i6 = 0;
        if (Long.compare(l, i6) == 0) {
            obj14 = "0s";
        } else {
            if (Long.compare(l, l2) == 0) {
                obj14 = "Infinity";
            } else {
                if (Long.compare(l, l3) == 0) {
                    obj14 = "-Infinity";
                } else {
                    cmp = b.y(l);
                    stringBuilder = new StringBuilder();
                    if (cmp) {
                        stringBuilder.append('-');
                    }
                    i = b.i(l);
                    b.C(i, obj4);
                    obj14 = b.j(i);
                    obj15 = b.p(i);
                    i10 = b.r(i);
                    i7 = b.q(i);
                    long l4 = b.k(i);
                    i8 = 0;
                    i9 = 1;
                    i6 = Long.compare(l4, i6) != 0 ? i9 : i8;
                    i3 = obj14 != null ? i9 : i8;
                    i4 = obj15 != null ? i9 : i8;
                    if (i10 == 0) {
                        if (i7 != 0) {
                            i5 = i9;
                        } else {
                            i5 = i8;
                        }
                    } else {
                    }
                    if (i6 != 0) {
                        stringBuilder.append(l4);
                        stringBuilder.append('d');
                        i8 = i9;
                    }
                    i2 = 32;
                    if (i3 == 0) {
                        if (i6 != 0) {
                            if (i4 == 0) {
                                if (i5 != 0 && i8 > 0) {
                                    if (i8 > 0) {
                                        stringBuilder.append(i2);
                                    }
                                    stringBuilder.append(obj14);
                                    stringBuilder.append('h');
                                    i8 = str;
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                    if (i4 == 0) {
                        if (i5 != 0) {
                            if (i3 == 0) {
                                if (i6 != 0 && i8 > 0) {
                                    if (i8 > 0) {
                                        stringBuilder.append(i2);
                                    }
                                    stringBuilder.append(obj15);
                                    stringBuilder.append('m');
                                    i8 = obj14;
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                    if (i5 != 0 && i8 > 0) {
                        if (i8 > 0) {
                            stringBuilder.append(i2);
                        }
                        if (i10 == 0 && i6 == 0 && i3 == 0) {
                            if (i6 == 0) {
                                if (i3 == 0) {
                                    if (i4 != 0) {
                                        b.e(i, obj4, stringBuilder, i10, i7, 9, "s");
                                    } else {
                                        obj15 = 1000000;
                                        if (i7 >= obj15) {
                                            b.e(i, obj4, stringBuilder, i7 / obj15, i7 %= obj15, 6, "ms");
                                        } else {
                                            obj15 = 1000;
                                            if (i7 >= obj15) {
                                                b.e(i, obj4, stringBuilder, i7 / 1000, i7 %= obj15, 3, "us");
                                            } else {
                                                stringBuilder.append(i7);
                                                stringBuilder.append("ns");
                                            }
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                        i8 = obj14;
                    }
                    if (cmp && i8 > i9) {
                        if (i8 > i9) {
                            stringBuilder.insert(i9, '(').append(')');
                        }
                    }
                    n.e(stringBuilder.toString(), "StringBuilder().apply(builderAction).toString()");
                }
            }
        }
        return obj14;
    }

    public static final long F(long l) {
        return c.a(-l2, obj1);
    }

    public static final long a() {
        return b.a;
    }

    private static final long c(long l, long l2, long l3) {
        long l4;
        long l5;
        long obj6;
        int obj8;
        int obj10;
        obj6 = c.g(obj10);
        final int i = l3 + obj6;
        if (Long.compare(obj8, i) > 0) {
            obj6 = c.b(g.h(i, obj1, -4611686018427387903L));
        } else {
            if (Long.compare(obj8, i) >= 0) {
                obj6 = c.d(obj6 += obj10);
            } else {
            }
        }
        return obj6;
    }

    private static final void e(long l, StringBuilder stringBuilder2, int i3, int i4, int i5, String string6, boolean z7) {
        int i;
        int i2;
        String obj2;
        String obj3;
        int obj5;
        int obj6;
        int obj7;
        i3.append(i4);
        if (i5 != 0) {
            i3.append('.');
            obj3 = 48;
            obj2 = l.o0(String.valueOf(i5), string6, obj3);
            obj5 += obj6;
            obj7 = 1;
            i = 0;
            while (obj5 >= 0) {
                if (obj2.charAt(obj5) != obj3) {
                } else {
                }
                i2 = i;
                if (i2 != 0) {
                    break;
                } else {
                }
                obj5--;
                obj7 = 1;
                i = 0;
                i2 = obj7;
            }
            obj6 += obj7;
            obj3 = "this.append(value, startIndex, endIndex)";
            obj5 = 3;
            if (obj9 == null && obj6 < obj5) {
                if (obj6 < obj5) {
                    i3.append(obj2, i, obj6);
                    n.e(i3, obj3);
                } else {
                    i3.append(obj2, i, obj6 *= obj5);
                    n.e(i3, obj3);
                }
            } else {
            }
        }
        i3.append(z7);
    }

    public static long f(long l) {
        int cmp2;
        long cmp3;
        int cmp;
        long l2;
        if (b.w(l)) {
            l2 = b.t(l);
            if (Long.compare(l5, l2) > 0) {
            } else {
                if (Long.compare(cmp2, l2) < 0) {
                } else {
                    return l;
                }
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(b.t(l));
            stringBuilder3.append(" ns is out of nanoseconds range");
            AssertionError assertionError3 = new AssertionError(stringBuilder3.toString());
            throw assertionError3;
        }
        long l6 = b.t(l);
        if (Long.compare(l3, l6) > 0) {
        } else {
            if (Long.compare(cmp3, l6) < 0) {
            } else {
                l2 = b.t(l);
                if (Long.compare(l4, l2) > 0) {
                } else {
                    if (Long.compare(cmp2, l2) >= 0) {
                    } else {
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(b.t(l));
                stringBuilder.append(" ms is denormalized");
                AssertionError assertionError = new AssertionError(stringBuilder.toString());
                throw assertionError;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(b.t(l));
        stringBuilder2.append(" ms is out of milliseconds range");
        AssertionError assertionError2 = new AssertionError(stringBuilder2.toString());
        throw assertionError2;
    }

    public static final long i(long l) {
        long obj1;
        if (b.y(l)) {
            obj1 = b.F(l);
        }
        return obj1;
    }

    public static final int j(long l) {
        boolean z;
        int obj2;
        if (b.x(l)) {
            obj2 = 0;
        } else {
            obj2 = (int)obj2;
        }
        return obj2;
    }

    public static final long k(long l) {
        return b.D(l, obj2);
    }

    public static final long m(long l) {
        return b.D(l, obj2);
    }

    public static final long n(long l) {
        return b.D(l, obj2);
    }

    public static final long o(long l) {
        return b.D(l, obj2);
    }

    public static final int p(long l) {
        boolean z;
        int obj2;
        if (b.x(l)) {
            obj2 = 0;
        } else {
            obj2 = (int)obj2;
        }
        return obj2;
    }

    public static final int q(long l) {
        boolean z;
        int obj2;
        if (b.x(l)) {
            obj2 = 0;
        } else {
            if (b.v(l)) {
                obj2 = c.f(obj2 %= z);
            } else {
                obj2 %= z;
            }
            obj2 = (int)obj2;
        }
        return obj2;
    }

    public static final int r(long l) {
        boolean z;
        int obj2;
        if (b.x(l)) {
            obj2 = 0;
        } else {
            obj2 = (int)obj2;
        }
        return obj2;
    }

    private static final TimeUnit s(long l) {
        TimeUnit obj0;
        obj0 = b.w(l) ? TimeUnit.NANOSECONDS : TimeUnit.MILLISECONDS;
        return obj0;
    }

    private static final long t(long l) {
        return l >>= i;
    }

    public static final boolean u(long l) {
        return obj0 ^= 1;
    }

    private static final boolean v(long l) {
        int obj1;
        obj1 = 1;
        if (obj0 &= obj1 == obj1) {
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    private static final boolean w(long l) {
        int obj1;
        if (obj0 &= obj1 == 0) {
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static final boolean x(long l) {
        long cmp;
        int obj2;
        if (Long.compare(l, l2) != 0) {
            if (Long.compare(l, cmp) == 0) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public static final boolean y(long l) {
        int obj2;
        obj2 = Long.compare(l, i) < 0 ? 1 : 0;
        return obj2;
    }

    public static final long z(long l, long l2) {
        return b.A(l, l2);
    }
}
