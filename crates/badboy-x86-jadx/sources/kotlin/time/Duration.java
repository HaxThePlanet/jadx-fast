package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0006\n\u0002\u0008-\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0002\u0008\u0012\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0087@\u0018\u0000 ¦\u00012\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¦\u0001B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\"\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\u0008G\u0010HJ\u0018\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\u0008K\u0010LJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008O\u0010PJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008O\u0010QJ\u0018\u0010M\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\u0008R\u0010SJ\u001a\u0010T\u001a\u00020U2\u0008\u0010J\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\u0008W\u0010XJ\u0010\u0010Y\u001a\u00020\tHÖ\u0001¢\u0006\u0004\u0008Z\u0010\rJ\r\u0010[\u001a\u00020U¢\u0006\u0004\u0008\\\u0010]J\u000f\u0010^\u001a\u00020UH\u0002¢\u0006\u0004\u0008_\u0010]J\u000f\u0010`\u001a\u00020UH\u0002¢\u0006\u0004\u0008a\u0010]J\r\u0010b\u001a\u00020U¢\u0006\u0004\u0008c\u0010]J\r\u0010d\u001a\u00020U¢\u0006\u0004\u0008e\u0010]J\r\u0010f\u001a\u00020U¢\u0006\u0004\u0008g\u0010]J\u0018\u0010h\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\u0008i\u0010jJ\u0018\u0010k\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\u0008l\u0010jJ\u001b\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008n\u0010PJ\u001b\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008n\u0010QJ\u009d\u0001\u0010o\u001a\u0002Hp\"\u0004\u0008\u0000\u0010p2u\u0010q\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(u\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(v\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(w\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(x\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(y\u0012\u0004\u0012\u0002Hp0rH\u0086\u0008ø\u0001\u0001\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\u0008z\u0010{J\u0088\u0001\u0010o\u001a\u0002Hp\"\u0004\u0008\u0000\u0010p2`\u0010q\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(v\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(w\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(x\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(y\u0012\u0004\u0012\u0002Hp0|H\u0086\u0008ø\u0001\u0001\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\u0008z\u0010}Js\u0010o\u001a\u0002Hp\"\u0004\u0008\u0000\u0010p2K\u0010q\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(w\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(x\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(y\u0012\u0004\u0012\u0002Hp0~H\u0086\u0008ø\u0001\u0001\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\u0008z\u0010\u007fJ`\u0010o\u001a\u0002Hp\"\u0004\u0008\u0000\u0010p27\u0010q\u001a3\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(x\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008s\u0012\u0008\u0008t\u0012\u0004\u0008\u0008(y\u0012\u0004\u0012\u0002Hp0\u0080\u0001H\u0086\u0008ø\u0001\u0001\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0005\u0008z\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\u0008\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\u0008\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\u0008\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008d\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\u0008\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\u0008\u0091\u0001\u0010\u0005J\u0011\u0010\u0092\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\u0008\u0093\u0001\u0010\u0005J\u0013\u0010\u0094\u0001\u001a\u00030\u008a\u0001H\u0016¢\u0006\u0006\u0008\u0095\u0001\u0010\u008c\u0001J%\u0010\u0094\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0083\u0001\u001a\u00020=2\t\u0008\u0002\u0010\u0096\u0001\u001a\u00020\t¢\u0006\u0006\u0008\u0095\u0001\u0010\u0097\u0001J\u001e\u0010\u0098\u0001\u001a\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020=H\u0000ø\u0001\u0000¢\u0006\u0006\u0008\u0099\u0001\u0010\u008f\u0001J\u0015\u0010\u009a\u0001\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0005\u0008\u009b\u0001\u0010\u0005JK\u0010\u009c\u0001\u001a\u00030\u009d\u0001*\u00080\u009e\u0001j\u0003`\u009f\u00012\u0007\u0010 \u0001\u001a\u00020\t2\u0007\u0010¡\u0001\u001a\u00020\t2\u0007\u0010¢\u0001\u001a\u00020\t2\u0008\u0010\u0083\u0001\u001a\u00030\u008a\u00012\u0007\u0010£\u0001\u001a\u00020UH\u0002¢\u0006\u0006\u0008¤\u0001\u0010¥\u0001R\u0014\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005R\u001a\u0010\u0008\u001a\u00020\t8@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\u000b\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0014\u0010\u000b\u001a\u0004\u0008\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0017\u0010\u000b\u001a\u0004\u0008\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001a\u0010\u000b\u001a\u0004\u0008\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001d\u0010\u000b\u001a\u0004\u0008\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008 \u0010\u000b\u001a\u0004\u0008!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008#\u0010\u000b\u001a\u0004\u0008$\u0010\u0012R\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008&\u0010\u0005R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008(\u0010\u0005R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008*\u0010\u0005R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008,\u0010\u0005R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008.\u0010\u0005R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u00080\u0010\u0005R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u00082\u0010\u0005R\u001a\u00103\u001a\u00020\t8@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u00084\u0010\u000b\u001a\u0004\u00085\u0010\rR\u001a\u00106\u001a\u00020\t8@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u00087\u0010\u000b\u001a\u0004\u00088\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\t8@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008:\u0010\u000b\u001a\u0004\u0008;\u0010\rR\u0014\u0010<\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008>\u0010?R\u0015\u0010@\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008A\u0010\rR\u0014\u0010B\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008C\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008\u009920\u0001¨\u0006§\u0001", d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "truncateTo", "truncateTo-UwyO8pc$kotlin_stdlib", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class Duration implements Comparable<kotlin.time.Duration> {

    public static final kotlin.time.Duration.Companion Companion;
    private static final long INFINITE;
    private static final long NEG_INFINITE;
    private static final long ZERO;
    private final long rawValue;

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0006\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0007J\u001a\u0010\u000c\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008/\u0010\u0011J\u001a\u0010\u000c\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008/\u0010\u0014J\u001a\u0010\u000c\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u0008/\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u00080\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u00080\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u00080\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u00081\u0010\u0011J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u00081\u0010\u0014J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u00081\u0010\u0017J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u0010\u0014J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u0010\u0017J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u00083\u0010\u0011J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u00083\u0010\u0014J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u00083\u0010\u0017J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u00084\u0010\u0011J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u00084\u0010\u0014J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u00084\u0010\u0017J\u0018\u00105\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0004\u00087\u00108J\u0018\u00109\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0004\u0008:\u00108J\u0018\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0002\u0008<J\u0018\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000¢\u0006\u0002\u0008>J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008?\u0010\u0011J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008?\u0010\u0014J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u0008?\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0016\u0010\n\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\"\u0010\u000c\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u0011R\"\u0010\u000c\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u0013\u001a\u0004\u0008\u0010\u0010\u0014R\"\u0010\u000c\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u0016\u001a\u0004\u0008\u0010\u0010\u0017R\"\u0010\u0018\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0019\u0010\u000f\u001a\u0004\u0008\u001a\u0010\u0011R\"\u0010\u0018\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0019\u0010\u0013\u001a\u0004\u0008\u001a\u0010\u0014R\"\u0010\u0018\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0019\u0010\u0016\u001a\u0004\u0008\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001c\u0010\u000f\u001a\u0004\u0008\u001d\u0010\u0011R\"\u0010\u001b\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001c\u0010\u0013\u001a\u0004\u0008\u001d\u0010\u0014R\"\u0010\u001b\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001c\u0010\u0016\u001a\u0004\u0008\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\u000f\u001a\u0004\u0008 \u0010\u0011R\"\u0010\u001e\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\u0013\u001a\u0004\u0008 \u0010\u0014R\"\u0010\u001e\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\u0016\u001a\u0004\u0008 \u0010\u0017R\"\u0010!\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\"\u0010\u000f\u001a\u0004\u0008#\u0010\u0011R\"\u0010!\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\"\u0010\u0013\u001a\u0004\u0008#\u0010\u0014R\"\u0010!\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\"\u0010\u0016\u001a\u0004\u0008#\u0010\u0017R\"\u0010$\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008%\u0010\u000f\u001a\u0004\u0008&\u0010\u0011R\"\u0010$\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008%\u0010\u0013\u001a\u0004\u0008&\u0010\u0014R\"\u0010$\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008%\u0010\u0016\u001a\u0004\u0008&\u0010\u0017R\"\u0010'\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008(\u0010\u000f\u001a\u0004\u0008)\u0010\u0011R\"\u0010'\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008(\u0010\u0013\u001a\u0004\u0008)\u0010\u0014R\"\u0010'\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008(\u0010\u0016\u001a\u0004\u0008)\u0010\u0017\u0082\u0002\u0004\n\u0002\u0008!¨\u0006@", d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "days", "", "getDays-UwyO8pc$annotations", "(D)V", "getDays-UwyO8pc", "(D)J", "", "(I)V", "(I)J", "", "(J)V", "(J)J", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "nanoseconds", "getNanoseconds-UwyO8pc$annotations", "getNanoseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "convert", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "days-UwyO8pc", "hours-UwyO8pc", "microseconds-UwyO8pc", "milliseconds-UwyO8pc", "minutes-UwyO8pc", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        private final long getDays-UwyO8pc(double $this$days) {
            return DurationKt.toDuration($this$days, obj4);
        }

        private final long getDays-UwyO8pc(int $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }

        private final long getDays-UwyO8pc(long $this$days) {
            return DurationKt.toDuration($this$days, obj4);
        }

        public static void getDays-UwyO8pc$annotations(double d) {
        }

        public static void getDays-UwyO8pc$annotations(int i) {
        }

        public static void getDays-UwyO8pc$annotations(long l) {
        }

        private final long getHours-UwyO8pc(double $this$hours) {
            return DurationKt.toDuration($this$hours, obj4);
        }

        private final long getHours-UwyO8pc(int $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }

        private final long getHours-UwyO8pc(long $this$hours) {
            return DurationKt.toDuration($this$hours, obj4);
        }

        public static void getHours-UwyO8pc$annotations(double d) {
        }

        public static void getHours-UwyO8pc$annotations(int i) {
        }

        public static void getHours-UwyO8pc$annotations(long l) {
        }

        private final long getMicroseconds-UwyO8pc(double $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, obj4);
        }

        private final long getMicroseconds-UwyO8pc(int $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }

        private final long getMicroseconds-UwyO8pc(long $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, obj4);
        }

        public static void getMicroseconds-UwyO8pc$annotations(double d) {
        }

        public static void getMicroseconds-UwyO8pc$annotations(int i) {
        }

        public static void getMicroseconds-UwyO8pc$annotations(long l) {
        }

        private final long getMilliseconds-UwyO8pc(double $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, obj4);
        }

        private final long getMilliseconds-UwyO8pc(int $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }

        private final long getMilliseconds-UwyO8pc(long $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, obj4);
        }

        public static void getMilliseconds-UwyO8pc$annotations(double d) {
        }

        public static void getMilliseconds-UwyO8pc$annotations(int i) {
        }

        public static void getMilliseconds-UwyO8pc$annotations(long l) {
        }

        private final long getMinutes-UwyO8pc(double $this$minutes) {
            return DurationKt.toDuration($this$minutes, obj4);
        }

        private final long getMinutes-UwyO8pc(int $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }

        private final long getMinutes-UwyO8pc(long $this$minutes) {
            return DurationKt.toDuration($this$minutes, obj4);
        }

        public static void getMinutes-UwyO8pc$annotations(double d) {
        }

        public static void getMinutes-UwyO8pc$annotations(int i) {
        }

        public static void getMinutes-UwyO8pc$annotations(long l) {
        }

        private final long getNanoseconds-UwyO8pc(double $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, obj4);
        }

        private final long getNanoseconds-UwyO8pc(int $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }

        private final long getNanoseconds-UwyO8pc(long $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, obj4);
        }

        public static void getNanoseconds-UwyO8pc$annotations(double d) {
        }

        public static void getNanoseconds-UwyO8pc$annotations(int i) {
        }

        public static void getNanoseconds-UwyO8pc$annotations(long l) {
        }

        private final long getSeconds-UwyO8pc(double $this$seconds) {
            return DurationKt.toDuration($this$seconds, obj4);
        }

        private final long getSeconds-UwyO8pc(int $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }

        private final long getSeconds-UwyO8pc(long $this$seconds) {
            return DurationKt.toDuration($this$seconds, obj4);
        }

        public static void getSeconds-UwyO8pc$annotations(double d) {
        }

        public static void getSeconds-UwyO8pc$annotations(int i) {
        }

        public static void getSeconds-UwyO8pc$annotations(long l) {
        }

        public final double convert(double value, kotlin.time.DurationUnit sourceUnit, kotlin.time.DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(targetUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(obj6, "targetUnit");
            return DurationUnitKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long days-UwyO8pc(double value) {
            return DurationKt.toDuration(value, obj4);
        }

        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long days-UwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long days-UwyO8pc(long value) {
            return DurationKt.toDuration(value, obj4);
        }

        public final long getINFINITE-UwyO8pc() {
            return Duration.access$getINFINITE$cp();
        }

        public final long getNEG_INFINITE-UwyO8pc$kotlin_stdlib() {
            return Duration.access$getNEG_INFINITE$cp();
        }

        public final long getZERO-UwyO8pc() {
            return Duration.access$getZERO$cp();
        }

        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long hours-UwyO8pc(double value) {
            return DurationKt.toDuration(value, obj4);
        }

        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long hours-UwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long hours-UwyO8pc(long value) {
            return DurationKt.toDuration(value, obj4);
        }

        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long microseconds-UwyO8pc(double value) {
            return DurationKt.toDuration(value, obj4);
        }

        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long microseconds-UwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long microseconds-UwyO8pc(long value) {
            return DurationKt.toDuration(value, obj4);
        }

        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long milliseconds-UwyO8pc(double value) {
            return DurationKt.toDuration(value, obj4);
        }

        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long milliseconds-UwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long milliseconds-UwyO8pc(long value) {
            return DurationKt.toDuration(value, obj4);
        }

        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long minutes-UwyO8pc(double value) {
            return DurationKt.toDuration(value, obj4);
        }

        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long minutes-UwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long minutes-UwyO8pc(long value) {
            return DurationKt.toDuration(value, obj4);
        }

        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long nanoseconds-UwyO8pc(double value) {
            return DurationKt.toDuration(value, obj4);
        }

        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long nanoseconds-UwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long nanoseconds-UwyO8pc(long value) {
            return DurationKt.toDuration(value, obj4);
        }

        public final long parse-UwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return DurationKt.access$parseDuration(value, false);
        }

        public final long parseIsoString-UwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return DurationKt.access$parseDuration(value, true);
        }

        public final kotlin.time.Duration parseIsoStringOrNull-FghU774(String value) {
            kotlin.time.Duration box-impl;
            long l;
            Intrinsics.checkNotNullParameter(value, "value");
            box-impl = Duration.box-impl(DurationKt.access$parseDuration(value, true));
            return box-impl;
        }

        public final kotlin.time.Duration parseOrNull-FghU774(String value) {
            kotlin.time.Duration box-impl;
            long l;
            Intrinsics.checkNotNullParameter(value, "value");
            box-impl = Duration.box-impl(DurationKt.access$parseDuration(value, false));
            return box-impl;
        }

        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long seconds-UwyO8pc(double value) {
            return DurationKt.toDuration(value, obj4);
        }

        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long seconds-UwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final long seconds-UwyO8pc(long value) {
            return DurationKt.toDuration(value, obj4);
        }
    }
    static {
        final int i2 = 0;
        Duration.Companion companion = new Duration.Companion(i2);
        Duration.Companion = companion;
        Duration.ZERO = Duration.constructor-impl(0);
        Duration.INFINITE = DurationKt.access$durationOfMillis(4611686018427387903L);
        Duration.NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);
    }

    private Duration(long rawValue) {
        super();
        this.rawValue = rawValue;
    }

    public static final long access$getINFINITE$cp() {
        return Duration.INFINITE;
    }

    public static final long access$getNEG_INFINITE$cp() {
        return Duration.NEG_INFINITE;
    }

    public static final long access$getZERO$cp() {
        return Duration.ZERO;
    }

    private static final long addValuesMixedRanges-UwyO8pc(long arg0, long thisMillis, long otherNanos) {
        int cmp;
        long otherNanoRemainder;
        int i;
        long l;
        long l2;
        final long l3 = DurationKt.access$nanosToMillis(obj12);
        final int i2 = otherNanos + l3;
        i = 0;
        if (Long.compare(l4, i2) <= 0 && Long.compare(i2, l) < 0) {
            if (Long.compare(i2, l) < 0) {
                i = 1;
            }
        }
        if (i != 0) {
            otherNanoRemainder = DurationKt.access$durationOfNanos(l7 += i3);
        } else {
            otherNanoRemainder = DurationKt.access$durationOfMillis(RangesKt.coerceIn(i2, obj3, -4611686018427387903L));
        }
        return otherNanoRemainder;
    }

    private static final void appendFractional-impl(long arg0, StringBuilder $this$appendFractional, int whole, int fractional, int fractionalSize, String unit, boolean isoZeroes) {
        String padStart;
        String str2;
        int i7;
        StringBuilder append;
        String str;
        int i4;
        int i3;
        int i;
        int i8;
        int i5;
        int i6;
        int it;
        int i2;
        whole.append(fractional);
        if (fractionalSize != 0) {
            whole.append('.');
            int i10 = 48;
            padStart = StringsKt.padStart(String.valueOf(fractionalSize), unit, i10);
            String str4 = padStart;
            str = 0;
            i = -1;
            i8 = 1;
            i5 = 0;
            if (length += i >= 0) {
            } else {
            }
            i += i8;
            str2 = "append(...)";
            int i11 = 3;
            if (obj19 == null && i3 < i11) {
                if (i3 < i11) {
                    Intrinsics.checkNotNullExpressionValue(whole.append((CharSequence)padStart, i5, i3), str2);
                } else {
                    Intrinsics.checkNotNullExpressionValue(whole.append((CharSequence)padStart, i5, i13 *= i11), str2);
                }
            } else {
            }
        } else {
            i7 = unit;
        }
        whole.append(isoZeroes);
    }

    public static final kotlin.time.Duration box-impl(long l) {
        Duration duration = new Duration(l, obj2);
        return duration;
    }

    public static int compareTo-LRDsOJo(long arg0, long other) {
        int cmp;
        int i;
        final int i2 = arg0 ^ obj7;
        if (Long.compare(i2, i3) >= 0) {
            if (i4 &= 1 == 0) {
            } else {
                int i5 = 0;
                int i9 = 0;
                i6 -= i10;
                i = Duration.isNegative-impl(arg0) ? -i7 : i7;
            }
            return i;
        }
        return Intrinsics.compare(arg0, other);
    }

    public static long constructor-impl(long rawValue) {
        boolean durationAssertionsEnabled;
        int cmp;
        int i3;
        int i;
        int i2;
        long value-impl;
        long l;
        long l2;
        i2 = 0;
        if (DurationJvmKt.getDurationAssertionsEnabled() && Duration.isInNanos-impl(rawValue)) {
            i2 = 0;
            if (Duration.isInNanos-impl(rawValue)) {
                value-impl = Duration.getValue-impl(rawValue);
                if (Long.compare(l, value-impl) <= 0 && Long.compare(value-impl, l) < 0) {
                    if (Long.compare(value-impl, l) < 0) {
                    } else {
                        i = i2;
                    }
                } else {
                }
                if (i == 0) {
                } else {
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                AssertionError assertionError3 = new AssertionError(stringBuilder3.append(Duration.getValue-impl(rawValue)).append(" ns is out of nanoseconds range").toString());
                throw assertionError3;
            }
            long value-impl5 = Duration.getValue-impl(rawValue);
            if (Long.compare(l2, value-impl5) <= 0 && Long.compare(value-impl5, l2) < 0) {
                i3 = Long.compare(value-impl5, l2) < 0 ? i : i2;
            } else {
            }
            if (i3 == 0) {
            } else {
                value-impl = Duration.getValue-impl(rawValue);
                if (Long.compare(l, value-impl) <= 0 && Long.compare(value-impl, l) < 0) {
                    if (Long.compare(value-impl, l) < 0) {
                    } else {
                        i = i2;
                    }
                } else {
                }
                if (i != 0) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                AssertionError assertionError = new AssertionError(stringBuilder.append(Duration.getValue-impl(rawValue)).append(" ms is denormalized").toString());
                throw assertionError;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            AssertionError assertionError2 = new AssertionError(stringBuilder2.append(Duration.getValue-impl(rawValue)).append(" ms is out of milliseconds range").toString());
            throw assertionError2;
        }
        return rawValue;
    }

    public static final double div-LRDsOJo(long arg0, long other) {
        Comparable maxOf = ComparisonsKt.maxOf((Comparable)Duration.getStorageUnit-impl(arg0), (Comparable)Duration.getStorageUnit-impl(obj7));
        return double-impl /= double-impl2;
    }

    public static final long div-UwyO8pc(long arg0, double scale) {
        int i;
        final int roundToInt = MathKt.roundToInt(obj8);
        i = Double.compare(d, obj8) == 0 ? 1 : 0;
        if (i != 0 && roundToInt != 0) {
            if (roundToInt != 0) {
                return Duration.div-UwyO8pc(arg0, scale);
            }
        }
        kotlin.time.DurationUnit storageUnit-impl = Duration.getStorageUnit-impl(arg0);
        return DurationKt.toDuration(double-impl /= obj8, obj3);
    }

    public static final long div-UwyO8pc(long arg0, int scale) {
        long nEG_INFINITE;
        int cmp;
        int i;
        long l;
        if (obj8 == null) {
            if (Duration.isPositive-impl(arg0)) {
                nEG_INFINITE = Duration.INFINITE;
                return nEG_INFINITE;
            } else {
                if (!Duration.isNegative-impl(arg0)) {
                } else {
                    nEG_INFINITE = Duration.NEG_INFINITE;
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
            throw illegalArgumentException;
        }
        if (Duration.isInNanos-impl(arg0)) {
            return DurationKt.access$durationOfNanos(value-impl2 /= l7);
        }
        if (Duration.isInfinite-impl(arg0)) {
            return Duration.times-UwyO8pc(arg0, scale);
        }
        value-impl /= l3;
        i = 0;
        if (Long.compare(l4, i2) <= 0 && Long.compare(i2, l) < 0) {
            if (Long.compare(i2, l) < 0) {
                i = 1;
            }
        }
        if (i != 0) {
            return DurationKt.access$durationOfNanos(l10 += i5);
        }
        return DurationKt.access$durationOfMillis(i2);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof Duration) {
            return i2;
        }
        if (Long.compare(l, unbox-impl) != 0) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(long l, long l2) {
        int i;
        i = Long.compare(l, obj3) == 0 ? 1 : 0;
        return i;
    }

    public static final long getAbsoluteValue-UwyO8pc(long arg0) {
        long unaryMinus-UwyO8pc;
        if (Duration.isNegative-impl(arg0)) {
            unaryMinus-UwyO8pc = Duration.unaryMinus-UwyO8pc(arg0);
        } else {
            unaryMinus-UwyO8pc = arg0;
        }
        return unaryMinus-UwyO8pc;
    }

    public static void getHoursComponent$annotations() {
    }

    public static final int getHoursComponent-impl(long arg0) {
        int i;
        long l;
        if (Duration.isInfinite-impl(arg0)) {
            i = 0;
        } else {
            i = (int)i2;
        }
        return i;
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getInDays$annotations() {
    }

    public static final double getInDays-impl(long arg0) {
        return Duration.toDouble-impl(arg0, obj3);
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getInHours$annotations() {
    }

    public static final double getInHours-impl(long arg0) {
        return Duration.toDouble-impl(arg0, obj3);
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getInMicroseconds$annotations() {
    }

    public static final double getInMicroseconds-impl(long arg0) {
        return Duration.toDouble-impl(arg0, obj3);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getInMilliseconds$annotations() {
    }

    public static final double getInMilliseconds-impl(long arg0) {
        return Duration.toDouble-impl(arg0, obj3);
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getInMinutes$annotations() {
    }

    public static final double getInMinutes-impl(long arg0) {
        return Duration.toDouble-impl(arg0, obj3);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getInNanoseconds$annotations() {
    }

    public static final double getInNanoseconds-impl(long arg0) {
        return Duration.toDouble-impl(arg0, obj3);
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getInSeconds$annotations() {
    }

    public static final double getInSeconds-impl(long arg0) {
        return Duration.toDouble-impl(arg0, obj3);
    }

    public static final long getInWholeDays-impl(long arg0) {
        return Duration.toLong-impl(arg0, obj3);
    }

    public static final long getInWholeHours-impl(long arg0) {
        return Duration.toLong-impl(arg0, obj3);
    }

    public static final long getInWholeMicroseconds-impl(long arg0) {
        return Duration.toLong-impl(arg0, obj3);
    }

    public static final long getInWholeMilliseconds-impl(long arg0) {
        boolean inMillis-impl;
        long value-impl;
        if (Duration.isInMillis-impl(arg0) && Duration.isFinite-impl(arg0)) {
            if (Duration.isFinite-impl(arg0)) {
                value-impl = Duration.getValue-impl(arg0);
            } else {
                value-impl = Duration.toLong-impl(arg0, obj3);
            }
        } else {
        }
        return value-impl;
    }

    public static final long getInWholeMinutes-impl(long arg0) {
        return Duration.toLong-impl(arg0, obj3);
    }

    public static final long getInWholeNanoseconds-impl(long arg0) {
        long l;
        final long value-impl = Duration.getValue-impl(arg0);
        if (Duration.isInNanos-impl(arg0)) {
            l = value-impl;
        } else {
            if (Long.compare(value-impl, l2) > 0) {
                l = Long.MAX_VALUE;
            } else {
                if (Long.compare(value-impl, l3) < 0) {
                    l = Long.MIN_VALUE;
                } else {
                    l = DurationKt.access$millisToNanos(value-impl);
                }
            }
        }
        return l;
    }

    public static final long getInWholeSeconds-impl(long arg0) {
        return Duration.toLong-impl(arg0, obj3);
    }

    public static void getMinutesComponent$annotations() {
    }

    public static final int getMinutesComponent-impl(long arg0) {
        int i;
        long l;
        if (Duration.isInfinite-impl(arg0)) {
            i = 0;
        } else {
            i = (int)i2;
        }
        return i;
    }

    public static void getNanosecondsComponent$annotations() {
    }

    public static final int getNanosecondsComponent-impl(long arg0) {
        int i;
        long l;
        if (Duration.isInfinite-impl(arg0)) {
            i = 0;
        } else {
            if (Duration.isInMillis-impl(arg0)) {
                i = (int)l2;
            } else {
                i = (int)i3;
            }
        }
        return i;
    }

    public static void getSecondsComponent$annotations() {
    }

    public static final int getSecondsComponent-impl(long arg0) {
        int i;
        long l;
        if (Duration.isInfinite-impl(arg0)) {
            i = 0;
        } else {
            i = (int)i2;
        }
        return i;
    }

    private static final kotlin.time.DurationUnit getStorageUnit-impl(long arg0) {
        kotlin.time.DurationUnit mILLISECONDS;
        mILLISECONDS = Duration.isInNanos-impl(arg0) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
        return mILLISECONDS;
    }

    private static final int getUnitDiscriminator-impl(long arg0) {
        final int i = 0;
        return i2 &= 1;
    }

    private static final long getValue-impl(long arg0) {
        return arg0 >> i;
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static final boolean isFinite-impl(long arg0) {
        return infinite-impl ^= 1;
    }

    private static final boolean isInMillis-impl(long arg0) {
        int i;
        int i2 = 0;
        if (i4 & 1 == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    private static final boolean isInNanos-impl(long arg0) {
        int i;
        int i2 = 0;
        i = 1;
        if (i4 & 1 == 0) {
        } else {
            i = 0;
        }
        return i;
    }

    public static final boolean isInfinite-impl(long arg0) {
        int i;
        int cmp;
        if (Long.compare(arg0, iNFINITE) != 0) {
            if (Long.compare(arg0, nEG_INFINITE) == 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final boolean isNegative-impl(long arg0) {
        int i;
        i = Long.compare(arg0, i2) < 0 ? 1 : 0;
        return i;
    }

    public static final boolean isPositive-impl(long arg0) {
        int i;
        i = Long.compare(arg0, i2) > 0 ? 1 : 0;
        return i;
    }

    public static final long minus-LRDsOJo(long arg0, long other) {
        return Duration.plus-LRDsOJo(arg0, other);
    }

    public static final long plus-LRDsOJo(long arg0, long other) {
        int result;
        boolean finite-impl;
        int i;
        long valuesMixedRanges-UwyO8pc;
        int i2;
        long value-impl3;
        long value-impl2;
        long value-impl;
        int obj7;
        if (Duration.isInfinite-impl(arg0) && !Duration.isFinite-impl(obj9)) {
            if (!Duration.isFinite-impl(obj9)) {
                if (Long.compare(i6, i2) < 0) {
                } else {
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
                throw illegalArgumentException;
            }
            return arg0;
        }
        if (Duration.isInfinite-impl(obj9)) {
            return obj9;
        }
        int i3 = 0;
        int i8 = 0;
        int i9 = (int)obj9;
        i = i9 & 1;
        if (i7 & 1 == i) {
            value-impl4 += value-impl5;
            if (Duration.isInNanos-impl(arg0)) {
                valuesMixedRanges-UwyO8pc = DurationKt.access$durationOfNanosNormalized(i5);
                result = arg0;
            } else {
                valuesMixedRanges-UwyO8pc = DurationKt.access$durationOfMillisNormalized(i5);
                result = arg0;
            }
        } else {
            if (Duration.isInMillis-impl(arg0)) {
                i = arg0;
                result = i;
                valuesMixedRanges-UwyO8pc = obj7;
            } else {
                result = arg0;
                valuesMixedRanges-UwyO8pc = Duration.addValuesMixedRanges-UwyO8pc(result, i, Duration.getValue-impl(obj9));
            }
        }
        return valuesMixedRanges-UwyO8pc;
    }

    public static final long times-UwyO8pc(long arg0, double scale) {
        int i;
        final int roundToInt = MathKt.roundToInt(obj8);
        i = Double.compare(d, obj8) == 0 ? 1 : 0;
        if (i != 0) {
            return Duration.times-UwyO8pc(arg0, scale);
        }
        kotlin.time.DurationUnit storageUnit-impl = Duration.getStorageUnit-impl(arg0);
        return DurationKt.toDuration(double-impl *= obj8, obj3);
    }

    public static final long times-UwyO8pc(long arg0, int scale) {
        long unaryMinus-UwyO8pc;
        int coerceIn;
        int sign;
        long totalMillis;
        int cmp;
        long l2;
        long longRange;
        long l;
        long l4;
        long l3;
        int i3;
        int i2;
        long value;
        int i;
        final int i4 = obj20;
        if (Duration.isInfinite-impl(arg0)) {
            if (i4 == 0) {
            } else {
                if (i4 > 0) {
                    unaryMinus-UwyO8pc = arg0;
                } else {
                    unaryMinus-UwyO8pc = Duration.unaryMinus-UwyO8pc(arg0);
                }
                return unaryMinus-UwyO8pc;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
            throw illegalArgumentException;
        }
        if (i4 == 0) {
            return Duration.ZERO;
        }
        coerceIn = Duration.getValue-impl(arg0);
        l5 *= coerceIn;
        if (Duration.isInNanos-impl(arg0)) {
            l4 = 0;
            if (Long.compare(i10, coerceIn) <= 0 && Long.compare(coerceIn, l3) < 0) {
                if (Long.compare(coerceIn, l3) < 0) {
                    l4 = 1;
                }
            }
            if (l4 != 0) {
                totalMillis = DurationKt.access$durationOfNanos(i6);
                value = coerceIn;
            } else {
                if (Long.compare(l4, coerceIn) == 0) {
                    totalMillis = DurationKt.access$durationOfNanosNormalized(i6);
                    value = coerceIn;
                } else {
                    l4 = DurationKt.access$nanosToMillis(coerceIn);
                    l11 *= l4;
                    l8 *= i3;
                    l7 += i2;
                    if (Long.compare(i8, l4) == 0 && Long.compare(i9, i) >= 0) {
                        if (Long.compare(i9, i) >= 0) {
                            value = coerceIn;
                            longRange = new LongRange(-4611686018427387903L, obj2, 4611686018427387903L, obj9);
                            totalMillis = coerceIn;
                        } else {
                            totalMillis = sign3 *= sign > 0 ? coerceIn : Duration.NEG_INFINITE;
                        }
                    } else {
                    }
                }
            }
        } else {
            value = coerceIn;
            if (Long.compare(i5, value) == 0) {
                LongRange longRange2 = new LongRange(-4611686018427387903L, obj6, 4611686018427387903L, obj9);
                totalMillis = DurationKt.access$durationOfMillis(RangesKt.coerceIn(i6, obj4));
            } else {
                totalMillis = sign2 *= sign > 0 ? Duration.INFINITE : Duration.NEG_INFINITE;
            }
        }
        return totalMillis;
    }

    public static final <T> T toComponents-impl(long arg0, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(obj5, "action");
        int i = 0;
        return obj5.invoke(Long.valueOf(Duration.getInWholeSeconds-impl(arg0)), Integer.valueOf(Duration.getNanosecondsComponent-impl(arg0)));
    }

    public static final <T> T toComponents-impl(long arg0, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(obj6, "action");
        int i = 0;
        return obj6.invoke(Long.valueOf(Duration.getInWholeMinutes-impl(arg0)), Integer.valueOf(Duration.getSecondsComponent-impl(arg0)), Integer.valueOf(Duration.getNanosecondsComponent-impl(arg0)));
    }

    public static final <T> T toComponents-impl(long arg0, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(obj7, "action");
        int i = 0;
        return obj7.invoke(Long.valueOf(Duration.getInWholeHours-impl(arg0)), Integer.valueOf(Duration.getMinutesComponent-impl(arg0)), Integer.valueOf(Duration.getSecondsComponent-impl(arg0)), Integer.valueOf(Duration.getNanosecondsComponent-impl(arg0)));
    }

    public static final <T> T toComponents-impl(long arg0, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(obj11, "action");
        int i = 0;
        return obj11.invoke(Long.valueOf(Duration.getInWholeDays-impl(arg0)), Integer.valueOf(Duration.getHoursComponent-impl(arg0)), Integer.valueOf(Duration.getMinutesComponent-impl(arg0)), Integer.valueOf(Duration.getSecondsComponent-impl(arg0)), Integer.valueOf(Duration.getNanosecondsComponent-impl(arg0)));
    }

    public static final double toDouble-impl(long arg0, kotlin.time.DurationUnit unit) {
        long convertDurationUnit;
        kotlin.time.DurationUnit storageUnit-impl;
        Intrinsics.checkNotNullParameter(obj5, "unit");
        if (Long.compare(arg0, iNFINITE) == 0) {
            convertDurationUnit = 9218868437227405312L;
        } else {
            if (Long.compare(arg0, nEG_INFINITE) == 0) {
                convertDurationUnit = -4503599627370496L;
            } else {
                convertDurationUnit = DurationUnitKt.convertDurationUnit((double)value-impl, obj1, Duration.getStorageUnit-impl(arg0));
            }
        }
        return convertDurationUnit;
    }

    public static final int toInt-impl(long arg0, kotlin.time.DurationUnit unit) {
        Intrinsics.checkNotNullParameter(obj9, "unit");
        return (int)coerceIn;
    }

    public static final String toIsoString-impl(long arg0) {
        boolean negative-impl;
        long hours;
        int i;
        int append;
        int str;
        int i2;
        long l;
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        final int i4 = 0;
        if (Duration.isNegative-impl(arg0)) {
            sb.append('-');
        }
        sb.append("PT");
        final long absoluteValue-UwyO8pc = Duration.getAbsoluteValue-UwyO8pc(arg0);
        final int i5 = 0;
        final int minutesComponent-impl = Duration.getMinutesComponent-impl(absoluteValue-UwyO8pc);
        final int secondsComponent-impl = Duration.getSecondsComponent-impl(absoluteValue-UwyO8pc);
        final int nanosecondsComponent-impl = Duration.getNanosecondsComponent-impl(absoluteValue-UwyO8pc);
        final long l2 = hours;
        final int i6 = 0;
        if (Duration.isInfinite-impl(arg0)) {
            hours = 9999999999999L;
        }
        str = 1;
        i2 = 0;
        i = Long.compare(hours, i3) != 0 ? str : i2;
        final int i7 = i;
        if (secondsComponent-impl == 0) {
            if (nanosecondsComponent-impl != 0) {
                append = str;
            } else {
                append = i2;
            }
        } else {
        }
        final int i8 = append;
        if (minutesComponent-impl == 0) {
            if (i8 != 0 && i7 != 0) {
                if (i7 != 0) {
                } else {
                    str = i2;
                }
            } else {
            }
        }
        final int i9 = str;
        if (i7 != 0) {
            sb.append(hours).append('H');
        }
        if (i9 != 0) {
            sb.append(minutesComponent-impl).append('M');
        }
        if (i8 == 0) {
            if (i7 == 0 && i9 == 0) {
                if (i9 == 0) {
                    l = hours;
                    Duration.appendFractional-impl(arg0, obj2, sb, secondsComponent-impl, nanosecondsComponent-impl, 9, "S");
                } else {
                    l = hours;
                }
            } else {
            }
        } else {
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final long toLong-impl(long arg0, kotlin.time.DurationUnit unit) {
        long convertDurationUnit;
        kotlin.time.DurationUnit storageUnit-impl;
        Intrinsics.checkNotNullParameter(obj5, "unit");
        if (Long.compare(arg0, iNFINITE) == 0) {
            convertDurationUnit = Long.MAX_VALUE;
        } else {
            if (Long.compare(arg0, nEG_INFINITE) == 0) {
                convertDurationUnit = Long.MIN_VALUE;
            } else {
                convertDurationUnit = DurationUnitKt.convertDurationUnit(Duration.getValue-impl(arg0), obj1, Duration.getStorageUnit-impl(arg0));
            }
        }
        return convertDurationUnit;
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static final long toLongMilliseconds-impl(long arg0) {
        return Duration.getInWholeMilliseconds-impl(arg0);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static final long toLongNanoseconds-impl(long arg0) {
        return Duration.getInWholeNanoseconds-impl(arg0);
    }

    public static String toString-impl(long arg0) {
        int hasDays;
        int hasDays2;
        int components;
        String string;
        int i8;
        int hasSeconds2;
        String str;
        boolean negative-impl;
        StringBuilder stringBuilder;
        int days;
        long str2;
        StringBuilder sb;
        int hours;
        int minutes;
        int nanoseconds2;
        StringBuilder append;
        int i4;
        int i9;
        int hours2;
        int i10;
        long absoluteValue-UwyO8pc;
        int i2;
        int secondsComponent-impl;
        int i7;
        int i6;
        int i3;
        int i;
        int hasDays3;
        long minutes2;
        int i5;
        int nanoseconds;
        int components2;
        int hasSeconds;
        int i11 = 0;
        if (Long.compare(arg0, i11) == 0) {
            string = "0s";
        } else {
            if (Long.compare(arg0, iNFINITE) == 0) {
                string = "Infinity";
            } else {
                if (Long.compare(arg0, nEG_INFINITE) == 0) {
                    string = "-Infinity";
                } else {
                    negative-impl = Duration.isNegative-impl(arg0);
                    stringBuilder = new StringBuilder();
                    sb = stringBuilder;
                    i10 = 0;
                    if (negative-impl) {
                        sb.append('-');
                    }
                    absoluteValue-UwyO8pc = Duration.getAbsoluteValue-UwyO8pc(arg0);
                    i2 = 0;
                    days = Duration.getInWholeDays-impl(absoluteValue-UwyO8pc);
                    int hoursComponent-impl = Duration.getHoursComponent-impl(absoluteValue-UwyO8pc);
                    minutes = Duration.getMinutesComponent-impl(absoluteValue-UwyO8pc);
                    secondsComponent-impl = Duration.getSecondsComponent-impl(absoluteValue-UwyO8pc);
                    nanoseconds2 = Duration.getNanosecondsComponent-impl(absoluteValue-UwyO8pc);
                    i7 = 0;
                    i8 = 0;
                    hasDays = Long.compare(days, i11) != 0 ? 1 : i8;
                    i4 = hoursComponent-impl != 0 ? 1 : i8;
                    i6 = i4;
                    i9 = minutes != 0 ? 1 : i8;
                    i3 = i9;
                    if (secondsComponent-impl == 0) {
                        if (nanoseconds2 != 0) {
                            i8 = 1;
                        }
                    } else {
                    }
                    if (hasDays != 0) {
                        hasDays3 = hasDays;
                        sb.append(days).append('d');
                        hours2++;
                    } else {
                        hasDays3 = hasDays;
                    }
                    if (i6 == 0) {
                        if (hasDays3 != 0) {
                            if (i3 == 0) {
                                if (i8 != 0 && hours2 > 0) {
                                    if (hours2 > 0) {
                                        sb.append(' ');
                                    }
                                    sb.append(hoursComponent-impl).append('h');
                                    hours2 = append;
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                    if (i3 == 0) {
                        if (i8 != 0) {
                            if (i6 == 0) {
                                if (hasDays3 != 0 && hours2 > 0) {
                                    if (hours2 > 0) {
                                        sb.append(' ');
                                    }
                                    sb.append(minutes).append('m');
                                    hours2 = hasDays2;
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                    if (i8 != 0) {
                        int i12 = hours2 + 1;
                        if (hours2 > 0) {
                            sb.append(' ');
                        }
                        if (secondsComponent-impl == 0 && hasDays3 == 0 && i6 == 0) {
                            if (hasDays3 == 0) {
                                if (i6 == 0) {
                                    if (i3 != 0) {
                                        components2 = i12;
                                        hasSeconds = i8;
                                        minutes2 = days;
                                        i = hoursComponent-impl;
                                        nanoseconds = minutes;
                                        components = nanoseconds2;
                                        hasSeconds2 = 1;
                                        Duration.appendFractional-impl(arg0, obj5, sb, secondsComponent-impl, components, 9, "s");
                                    } else {
                                        append = 1000000;
                                        if (nanoseconds2 >= append) {
                                            components2 = i12;
                                            hasSeconds = i8;
                                            i = i5;
                                            components = i19;
                                            hasSeconds2 = 1;
                                            nanoseconds = i18;
                                            minutes2 = days;
                                            Duration.appendFractional-impl(arg0, obj5, sb, nanoseconds2 / append, nanoseconds2 % append, 6, "ms");
                                            hours = secondsComponent-impl;
                                        } else {
                                            components2 = i12;
                                            hasSeconds = i8;
                                            minutes2 = days;
                                            i = hoursComponent-impl;
                                            nanoseconds = minutes;
                                            components = nanoseconds2;
                                            hasSeconds2 = 1;
                                            if (components >= 1000) {
                                                Duration.appendFractional-impl(arg0, obj5, sb, components / 1000, components % 1000, 3, "us");
                                                hours = secondsComponent-impl;
                                            } else {
                                                sb.append(components).append("ns");
                                                hours = secondsComponent-impl;
                                            }
                                        }
                                    }
                                } else {
                                    components2 = i12;
                                    hasSeconds = i8;
                                    minutes2 = days;
                                    i = hoursComponent-impl;
                                    nanoseconds = minutes;
                                    components = nanoseconds2;
                                    hasSeconds2 = 1;
                                }
                            } else {
                            }
                        } else {
                        }
                        hours2 = components2;
                    } else {
                        hasSeconds = i8;
                        minutes2 = days;
                        i = hoursComponent-impl;
                        nanoseconds = minutes;
                        components = nanoseconds2;
                        hours = secondsComponent-impl;
                        hasSeconds2 = 1;
                    }
                    if (negative-impl && hours2 > hasSeconds2) {
                        if (hours2 > hasSeconds2) {
                            sb.insert(hasSeconds2, '(').append(')');
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(stringBuilder.toString(), "toString(...)");
                }
            }
        }
        return string;
    }

    public static final String toString-impl(long arg0, kotlin.time.DurationUnit unit, int decimals) {
        int i;
        Intrinsics.checkNotNullParameter(decimals, "unit");
        i = obj7 >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            double double-impl = Duration.toDouble-impl(arg0, unit);
            if (Double.isInfinite(double-impl)) {
                return String.valueOf(double-impl);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            return stringBuilder2.append(DurationJvmKt.formatToExactDecimals(double-impl, obj1)).append(DurationUnitKt.shortName(decimals)).toString();
        }
        int number = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("decimals must be not negative, but was ").append(obj7).toString().toString());
        throw illegalArgumentException;
    }

    public static String toString-impl$default(long l, kotlin.time.DurationUnit durationUnit2, int i3, int i4, Object object5) {
        int obj3;
        if (object5 &= 2 != 0) {
            obj3 = 0;
        }
        return Duration.toString-impl(l, durationUnit2, i3);
    }

    public static final long truncateTo-UwyO8pc$kotlin_stdlib(long arg0, kotlin.time.DurationUnit unit) {
        int compareTo;
        Intrinsics.checkNotNullParameter(obj9, "unit");
        kotlin.time.DurationUnit storageUnit-impl = Duration.getStorageUnit-impl(arg0);
        if (obj9.compareTo((Enum)storageUnit-impl) > 0 && Duration.isInfinite-impl(arg0)) {
            if (Duration.isInfinite-impl(arg0)) {
            }
            return DurationKt.toDuration(value-impl -= i3, obj4);
        }
        return arg0;
    }

    public static final long unaryMinus-UwyO8pc(long arg0) {
        int i2 = 0;
        return DurationKt.access$durationOf(-value-impl, obj1);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        return compareTo-LRDsOJo((Duration)other.unbox-impl());
    }

    @Override // java.lang.Comparable
    public int compareTo-LRDsOJo(long other) {
        return Duration.compareTo-LRDsOJo(this.rawValue, obj1);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        return Duration.equals-impl(this.rawValue, obj1);
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return Duration.hashCode-impl(this.rawValue);
    }

    @Override // java.lang.Comparable
    public String toString() {
        return Duration.toString-impl(this.rawValue);
    }

    @Override // java.lang.Comparable
    public final long unbox-impl() {
        return this.rawValue;
    }
}
