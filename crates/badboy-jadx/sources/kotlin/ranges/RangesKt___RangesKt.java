package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000t\n\u0002\u0008\u0002\n\u0002\u0010\u000f\n\u0002\u0008\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\u0008\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u001d\u001a'\u0010\u0000\u001a\u0002H\u0001\"\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u0008*\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u0008\u001a\u0012\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t\u001a\u0012\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n\u001a'\u0010\u000b\u001a\u0002H\u0001\"\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u000c\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000c\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u0007\u001a\u0012\u0010\u000b\u001a\u00020\u0008*\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u0008\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\u000c\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\u000c\u001a\u00020\n\u001a3\u0010\r\u001a\u0002H\u0001\"\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0008\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\u0008\u0010\u000c\u001a\u0004\u0018\u0001H\u0001¢\u0006\u0002\u0010\u000e\u001a/\u0010\r\u001a\u0002H\u0001\"\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\r\u001a\u0002H\u0001\"\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0012¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\u0005\u001a\u001a\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0006\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u0007\u001a\u001a\u0010\r\u001a\u00020\u0008*\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u0008\u001a\u0018\u0010\r\u001a\u00020\u0008*\u00020\u00082\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0012\u001a\u001a\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\t\u001a\u0018\u0010\r\u001a\u00020\t*\u00020\t2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0012\u001a\u001a\u0010\r\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0087\n¢\u0006\u0002\u0010\u0019\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\u0008\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\u0008\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0008H\u0087\u0002¢\u0006\u0002\u0008\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\u0008\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\u0008\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\u0008\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\u0008\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0008H\u0087\u0002¢\u0006\u0002\u0008\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\u0008\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\u0008\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\u0008\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\u0008\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0008H\u0087\u0002¢\u0006\u0002\u0008\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\u0008\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\u0008\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00080\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\u0008\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00080\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\u0008\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00080\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\u0008\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00080\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\u0008\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00080\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\u0008\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\u0008\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\u0008\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\u0008\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0008H\u0087\u0002¢\u0006\u0002\u0008\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\u0008\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\u0008 \u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\u0008 \u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\u0008 \u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0008H\u0087\u0002¢\u0006\u0002\u0008 \u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\u0008 \u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0008H\u0087\n¢\u0006\u0002\u0010\"\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\tH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\u0008H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0087\n¢\u0006\u0002\u0010$\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\u0008H\u0087\u0002¢\u0006\u0002\u0008\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\u0008\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\u0008\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\u0008\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00080%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\u0008\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00080%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\u0008\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\u00080%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\u0008\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\u0008\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\u0008H\u0087\u0002¢\u0006\u0002\u0008\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\u0008\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\u0008 \u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\u0008H\u0087\u0002¢\u0006\u0002\u0008 \u001a \u0010\u0014\u001a\u00020\u0015*\u0008\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\u0008 \u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\u0008H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020**\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00082\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00082\u0006\u0010(\u001a\u00020\u0008H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\u00082\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00082\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\u0008H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\u0008H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u000c\u0010+\u001a\u00020\u0018*\u00020*H\u0007\u001a\u000c\u0010+\u001a\u00020\u0008*\u00020'H\u0007\u001a\u000c\u0010+\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\u0008*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\u000c\u00100\u001a\u00020\u0018*\u00020*H\u0007\u001a\u000c\u00100\u001a\u00020\u0008*\u00020'H\u0007\u001a\u000c\u00100\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u00101\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u00101\u001a\u0004\u0018\u00010\u0008*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u00101\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\r\u00102\u001a\u00020\u0018*\u00020\u0016H\u0087\u0008\u001a\u0014\u00102\u001a\u00020\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\u0008*\u00020!H\u0087\u0008\u001a\u0014\u00102\u001a\u00020\u0008*\u00020!2\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\t*\u00020#H\u0087\u0008\u001a\u0014\u00102\u001a\u00020\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007\u001a\u0014\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u0016H\u0087\u0008¢\u0006\u0002\u00105\u001a\u001b\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00106\u001a\u0014\u00104\u001a\u0004\u0018\u00010\u0008*\u00020!H\u0087\u0008¢\u0006\u0002\u00107\u001a\u001b\u00104\u001a\u0004\u0018\u00010\u0008*\u00020!2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00108\u001a\u0014\u00104\u001a\u0004\u0018\u00010\t*\u00020#H\u0087\u0008¢\u0006\u0002\u00109\u001a\u001b\u00104\u001a\u0004\u0018\u00010\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u0010:\u001a\n\u0010;\u001a\u00020**\u00020*\u001a\n\u0010;\u001a\u00020'*\u00020'\u001a\n\u0010;\u001a\u00020)*\u00020)\u001a\u0015\u0010<\u001a\u00020**\u00020*2\u0006\u0010<\u001a\u00020\u0008H\u0086\u0004\u001a\u0015\u0010<\u001a\u00020'*\u00020'2\u0006\u0010<\u001a\u00020\u0008H\u0086\u0004\u001a\u0015\u0010<\u001a\u00020)*\u00020)2\u0006\u0010<\u001a\u00020\tH\u0086\u0004\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000¢\u0006\u0002\u0010>\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000¢\u0006\u0002\u0010?\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\u0008H\u0000¢\u0006\u0002\u0010@\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0000¢\u0006\u0002\u0010A\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\nH\u0000¢\u0006\u0002\u0010B\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\u0008*\u00020\u0006H\u0000¢\u0006\u0002\u0010D\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\u0008*\u00020\u0007H\u0000¢\u0006\u0002\u0010E\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\u0008*\u00020\tH\u0000¢\u0006\u0002\u0010F\u001a\u0013\u0010G\u001a\u0004\u0018\u00010\t*\u00020\u0006H\u0000¢\u0006\u0002\u0010H\u001a\u0013\u0010G\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0000¢\u0006\u0002\u0010I\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\u0006H\u0000¢\u0006\u0002\u0010K\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\u0007H\u0000¢\u0006\u0002\u0010L\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\u0008H\u0000¢\u0006\u0002\u0010M\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\tH\u0000¢\u0006\u0002\u0010N\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\u0008H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020\u0016*\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00082\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00082\u0006\u0010(\u001a\u00020\u0008H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\u00082\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00082\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\u0008H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\u0008H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004¨\u0006P", d2 = {"coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "Lkotlin/ranges/OpenEndRange;", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "first", "firstOrNull", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "last", "lastOrNull", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
class RangesKt___RangesKt extends kotlin.ranges.RangesKt__RangesKt {
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean byteRangeContains(kotlin.ranges.ClosedRange $this$contains, double value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(value);
        final int i = 0;
        if (byteExactOrNull != null) {
            contains = $this$contains.contains((Comparable)byteExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean byteRangeContains(kotlin.ranges.ClosedRange $this$contains, float value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(value);
        final int i = 0;
        if (byteExactOrNull != null) {
            contains = $this$contains.contains((Comparable)byteExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean byteRangeContains(kotlin.ranges.ClosedRange<Byte> $this$contains, int value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(value);
        final int i = 0;
        if (byteExactOrNull != null) {
            contains = $this$contains.contains((Comparable)byteExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean byteRangeContains(kotlin.ranges.ClosedRange<Byte> $this$contains, long value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(value);
        final int i = 0;
        if (byteExactOrNull != null) {
            contains = $this$contains.contains((Comparable)byteExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean byteRangeContains(kotlin.ranges.ClosedRange<Byte> $this$contains, short value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(value);
        final int i = 0;
        if (byteExactOrNull != null) {
            contains = $this$contains.contains((Comparable)byteExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean byteRangeContains(kotlin.ranges.OpenEndRange<Byte> $this$contains, int value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(value);
        final int i = 0;
        if (byteExactOrNull != null) {
            contains = $this$contains.contains((Comparable)byteExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean byteRangeContains(kotlin.ranges.OpenEndRange<Byte> $this$contains, long value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(value);
        final int i = 0;
        if (byteExactOrNull != null) {
            contains = $this$contains.contains((Comparable)byteExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean byteRangeContains(kotlin.ranges.OpenEndRange<Byte> $this$contains, short value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(value);
        final int i = 0;
        if (byteExactOrNull != null) {
            contains = $this$contains.contains((Comparable)byteExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final byte coerceAtLeast(byte $this$coerceAtLeast, byte minimumValue) {
        Object obj;
        obj = $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
        return obj;
    }

    public static final double coerceAtLeast(double $this$coerceAtLeast, double minimumValue) {
        double d;
        d = Double.compare($this$coerceAtLeast, obj4) < 0 ? obj4 : $this$coerceAtLeast;
        return d;
    }

    public static final float coerceAtLeast(float $this$coerceAtLeast, float minimumValue) {
        float f;
        f = Float.compare($this$coerceAtLeast, minimumValue) < 0 ? minimumValue : $this$coerceAtLeast;
        return f;
    }

    public static final int coerceAtLeast(int $this$coerceAtLeast, int minimumValue) {
        Object obj;
        obj = $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
        return obj;
    }

    public static final long coerceAtLeast(long $this$coerceAtLeast, long minimumValue) {
        long l;
        l = Long.compare($this$coerceAtLeast, obj4) < 0 ? obj4 : $this$coerceAtLeast;
        return l;
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T $this$coerceAtLeast, T minimumValue) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$coerceAtLeast, "<this>");
        Intrinsics.checkNotNullParameter(minimumValue, "minimumValue");
        obj = $this$coerceAtLeast.compareTo(minimumValue) < 0 ? minimumValue : $this$coerceAtLeast;
        return obj;
    }

    public static final short coerceAtLeast(short $this$coerceAtLeast, short minimumValue) {
        Object obj;
        obj = $this$coerceAtLeast < minimumValue ? minimumValue : $this$coerceAtLeast;
        return obj;
    }

    public static final byte coerceAtMost(byte $this$coerceAtMost, byte maximumValue) {
        Object obj;
        obj = $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
        return obj;
    }

    public static final double coerceAtMost(double $this$coerceAtMost, double maximumValue) {
        double d;
        d = Double.compare($this$coerceAtMost, obj4) > 0 ? obj4 : $this$coerceAtMost;
        return d;
    }

    public static final float coerceAtMost(float $this$coerceAtMost, float maximumValue) {
        float f;
        f = Float.compare($this$coerceAtMost, maximumValue) > 0 ? maximumValue : $this$coerceAtMost;
        return f;
    }

    public static final int coerceAtMost(int $this$coerceAtMost, int maximumValue) {
        Object obj;
        obj = $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
        return obj;
    }

    public static final long coerceAtMost(long $this$coerceAtMost, long maximumValue) {
        long l;
        l = Long.compare($this$coerceAtMost, obj4) > 0 ? obj4 : $this$coerceAtMost;
        return l;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T $this$coerceAtMost, T maximumValue) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$coerceAtMost, "<this>");
        Intrinsics.checkNotNullParameter(maximumValue, "maximumValue");
        obj = $this$coerceAtMost.compareTo(maximumValue) > 0 ? maximumValue : $this$coerceAtMost;
        return obj;
    }

    public static final short coerceAtMost(short $this$coerceAtMost, short maximumValue) {
        Object obj;
        obj = $this$coerceAtMost > maximumValue ? maximumValue : $this$coerceAtMost;
        return obj;
    }

    public static final byte coerceIn(byte $this$coerceIn, byte minimumValue, byte maximumValue) {
        if (minimumValue > maximumValue) {
        } else {
            if ($this$coerceIn < minimumValue) {
                return minimumValue;
            }
            if ($this$coerceIn > maximumValue) {
                return maximumValue;
            }
            return $this$coerceIn;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: maximum ").append(maximumValue).append(" is less than minimum ").append(minimumValue).append('.').toString());
        throw illegalArgumentException;
    }

    public static final double coerceIn(double $this$coerceIn, double minimumValue, double maximumValue) {
        if (Double.compare(maximumValue, obj7) > 0) {
        } else {
            if (Double.compare($this$coerceIn, maximumValue) < 0) {
                return maximumValue;
            }
            if (Double.compare($this$coerceIn, obj7) > 0) {
                return obj7;
            }
            return $this$coerceIn;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: maximum ").append(obj7).append(" is less than minimum ").append(maximumValue).append('.').toString());
        throw illegalArgumentException;
    }

    public static final float coerceIn(float $this$coerceIn, float minimumValue, float maximumValue) {
        if (Float.compare(minimumValue, maximumValue) > 0) {
        } else {
            if (Float.compare($this$coerceIn, minimumValue) < 0) {
                return minimumValue;
            }
            if (Float.compare($this$coerceIn, maximumValue) > 0) {
                return maximumValue;
            }
            return $this$coerceIn;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: maximum ").append(maximumValue).append(" is less than minimum ").append(minimumValue).append('.').toString());
        throw illegalArgumentException;
    }

    public static final int coerceIn(int $this$coerceIn, int minimumValue, int maximumValue) {
        if (minimumValue > maximumValue) {
        } else {
            if ($this$coerceIn < minimumValue) {
                return minimumValue;
            }
            if ($this$coerceIn > maximumValue) {
                return maximumValue;
            }
            return $this$coerceIn;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: maximum ").append(maximumValue).append(" is less than minimum ").append(minimumValue).append('.').toString());
        throw illegalArgumentException;
    }

    public static final int coerceIn(int $this$coerceIn, kotlin.ranges.ClosedRange<Integer> range) {
        int intValue;
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return (Number)RangesKt.coerceIn((Comparable)Integer.valueOf($this$coerceIn), (ClosedFloatingPointRange)range).intValue();
        }
        if (range.isEmpty()) {
        } else {
            if ($this$coerceIn < (Number)range.getStart().intValue()) {
                intValue = (Number)range.getStart().intValue();
            } else {
                if ($this$coerceIn > (Number)range.getEndInclusive().intValue()) {
                    intValue = (Number)range.getEndInclusive().intValue();
                } else {
                    intValue = $this$coerceIn;
                }
            }
            return intValue;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: ").append(range).append('.').toString());
        throw illegalArgumentException;
    }

    public static final long coerceIn(long $this$coerceIn, long minimumValue, long maximumValue) {
        if (Long.compare(maximumValue, obj7) > 0) {
        } else {
            if (Long.compare($this$coerceIn, maximumValue) < 0) {
                return maximumValue;
            }
            if (Long.compare($this$coerceIn, obj7) > 0) {
                return obj7;
            }
            return $this$coerceIn;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: maximum ").append(obj7).append(" is less than minimum ").append(maximumValue).append('.').toString());
        throw illegalArgumentException;
    }

    public static final long coerceIn(long $this$coerceIn, kotlin.ranges.ClosedRange<Long> range) {
        long longValue;
        Intrinsics.checkNotNullParameter(obj5, "range");
        if (obj5 instanceof ClosedFloatingPointRange) {
            return (Number)RangesKt.coerceIn((Comparable)Long.valueOf($this$coerceIn), (ClosedFloatingPointRange)obj5).longValue();
        }
        if (obj5.isEmpty()) {
        } else {
            if (Long.compare($this$coerceIn, longValue2) < 0) {
                longValue = (Number)obj5.getStart().longValue();
            } else {
                if (Long.compare($this$coerceIn, longValue3) > 0) {
                    longValue = (Number)obj5.getEndInclusive().longValue();
                } else {
                    longValue = $this$coerceIn;
                }
            }
            return longValue;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: ").append(obj5).append('.').toString());
        throw illegalArgumentException;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T $this$coerceIn, T minimumValue, T maximumValue) {
        int compareTo;
        Intrinsics.checkNotNullParameter($this$coerceIn, "<this>");
        if (minimumValue != null && maximumValue != null) {
            if (maximumValue != null) {
                if (minimumValue.compareTo(maximumValue) > 0) {
                } else {
                    if ($this$coerceIn.compareTo(minimumValue) < 0) {
                        return minimumValue;
                    }
                    if ($this$coerceIn.compareTo(maximumValue) > 0) {
                        return maximumValue;
                    }
                    return $this$coerceIn;
                }
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: maximum ").append(maximumValue).append(" is less than minimum ").append(minimumValue).append('.').toString());
                throw illegalArgumentException;
            }
        }
        if (minimumValue != null && $this$coerceIn.compareTo(minimumValue) < 0) {
            if ($this$coerceIn.compareTo(minimumValue) < 0) {
                return minimumValue;
            }
        }
        if (maximumValue != null && $this$coerceIn.compareTo(maximumValue) > 0) {
            if ($this$coerceIn.compareTo(maximumValue) > 0) {
                return maximumValue;
            }
        }
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T $this$coerceIn, kotlin.ranges.ClosedFloatingPointRange<T> range) {
        Object endInclusive;
        boolean lessThanOrEquals;
        boolean lessThanOrEquals2;
        Intrinsics.checkNotNullParameter($this$coerceIn, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
        } else {
            if (range.lessThanOrEquals($this$coerceIn, range.getStart()) && !range.lessThanOrEquals(range.getStart(), $this$coerceIn)) {
                if (!range.lessThanOrEquals(range.getStart(), $this$coerceIn)) {
                    endInclusive = range.getStart();
                } else {
                    if (range.lessThanOrEquals(range.getEndInclusive(), $this$coerceIn) && !range.lessThanOrEquals($this$coerceIn, range.getEndInclusive())) {
                        if (!range.lessThanOrEquals($this$coerceIn, range.getEndInclusive())) {
                            endInclusive = range.getEndInclusive();
                        } else {
                            endInclusive = $this$coerceIn;
                        }
                    } else {
                    }
                }
            } else {
            }
            return endInclusive;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: ").append(range).append('.').toString());
        throw illegalArgumentException;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T $this$coerceIn, kotlin.ranges.ClosedRange<T> range) {
        Object endInclusive;
        Intrinsics.checkNotNullParameter($this$coerceIn, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return RangesKt.coerceIn($this$coerceIn, (ClosedFloatingPointRange)range);
        }
        if (range.isEmpty()) {
        } else {
            if ($this$coerceIn.compareTo(range.getStart()) < 0) {
                endInclusive = range.getStart();
            } else {
                if ($this$coerceIn.compareTo(range.getEndInclusive()) > 0) {
                    endInclusive = range.getEndInclusive();
                } else {
                    endInclusive = $this$coerceIn;
                }
            }
            return endInclusive;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: ").append(range).append('.').toString());
        throw illegalArgumentException;
    }

    public static final short coerceIn(short $this$coerceIn, short minimumValue, short maximumValue) {
        if (minimumValue > maximumValue) {
        } else {
            if ($this$coerceIn < minimumValue) {
                return minimumValue;
            }
            if ($this$coerceIn > maximumValue) {
                return maximumValue;
            }
            return $this$coerceIn;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: maximum ").append(maximumValue).append(" is less than minimum ").append(minimumValue).append('.').toString());
        throw illegalArgumentException;
    }

    private static final boolean contains(kotlin.ranges.CharRange $this$contains, Character element) {
        String contains;
        int i;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        if (element != null && $this$contains.contains(element.charValue())) {
            i = $this$contains.contains(element.charValue()) ? 1 : 0;
        } else {
        }
        return i;
    }

    private static final boolean contains(kotlin.ranges.IntRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.intRangeContains((ClosedRange)$this$contains, value);
    }

    private static final boolean contains(kotlin.ranges.IntRange $this$contains, long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.intRangeContains((ClosedRange)$this$contains, value);
    }

    private static final boolean contains(kotlin.ranges.IntRange $this$contains, Integer element) {
        String contains;
        int i;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        if (element != null && $this$contains.contains(element.intValue())) {
            i = $this$contains.contains(element.intValue()) ? 1 : 0;
        } else {
        }
        return i;
    }

    private static final boolean contains(kotlin.ranges.IntRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.intRangeContains((ClosedRange)$this$contains, value);
    }

    private static final boolean contains(kotlin.ranges.LongRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.longRangeContains((ClosedRange)$this$contains, value);
    }

    private static final boolean contains(kotlin.ranges.LongRange $this$contains, int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.longRangeContains((ClosedRange)$this$contains, value);
    }

    private static final boolean contains(kotlin.ranges.LongRange $this$contains, Long element) {
        String contains;
        int i;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        if (element != null && $this$contains.contains(element.longValue())) {
            i = $this$contains.contains(element.longValue()) ? 1 : 0;
        } else {
        }
        return i;
    }

    private static final boolean contains(kotlin.ranges.LongRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return RangesKt.longRangeContains((ClosedRange)$this$contains, value);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean doubleRangeContains(kotlin.ranges.ClosedRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Double.valueOf((double)value));
    }

    public static final boolean doubleRangeContains(kotlin.ranges.ClosedRange<Double> $this$contains, float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Double.valueOf((double)value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean doubleRangeContains(kotlin.ranges.ClosedRange $this$contains, int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Double.valueOf((double)value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean doubleRangeContains(kotlin.ranges.ClosedRange $this$contains, long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Double.valueOf((double)value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean doubleRangeContains(kotlin.ranges.ClosedRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Double.valueOf((double)value));
    }

    public static final boolean doubleRangeContains(kotlin.ranges.OpenEndRange<Double> $this$contains, float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Double.valueOf((double)value));
    }

    public static final kotlin.ranges.CharProgression downTo(char $this$downTo, char to) {
        return CharProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final kotlin.ranges.IntProgression downTo(byte $this$downTo, byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final kotlin.ranges.IntProgression downTo(byte $this$downTo, int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final kotlin.ranges.IntProgression downTo(byte $this$downTo, short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final kotlin.ranges.IntProgression downTo(int $this$downTo, byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final kotlin.ranges.IntProgression downTo(int $this$downTo, int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final kotlin.ranges.IntProgression downTo(int $this$downTo, short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final kotlin.ranges.IntProgression downTo(short $this$downTo, byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final kotlin.ranges.IntProgression downTo(short $this$downTo, int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final kotlin.ranges.IntProgression downTo(short $this$downTo, short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }

    public static final kotlin.ranges.LongProgression downTo(byte $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange((long)$this$downTo, obj2, to);
    }

    public static final kotlin.ranges.LongProgression downTo(int $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange((long)$this$downTo, obj2, to);
    }

    public static final kotlin.ranges.LongProgression downTo(long $this$downTo, byte to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, obj2, (long)obj9);
    }

    public static final kotlin.ranges.LongProgression downTo(long $this$downTo, int to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, obj2, (long)obj9);
    }

    public static final kotlin.ranges.LongProgression downTo(long $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, obj2, obj9);
    }

    public static final kotlin.ranges.LongProgression downTo(long $this$downTo, short to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, obj2, (long)obj9);
    }

    public static final kotlin.ranges.LongProgression downTo(short $this$downTo, long to) {
        return LongProgression.Companion.fromClosedRange((long)$this$downTo, obj2, to);
    }

    public static final char first(kotlin.ranges.CharProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
        } else {
            return $this$first.getFirst();
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Progression ").append($this$first).append(" is empty.").toString());
        throw noSuchElementException;
    }

    public static final int first(kotlin.ranges.IntProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
        } else {
            return $this$first.getFirst();
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Progression ").append($this$first).append(" is empty.").toString());
        throw noSuchElementException;
    }

    public static final long first(kotlin.ranges.LongProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
        } else {
            return $this$first.getFirst();
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Progression ").append($this$first).append(" is empty.").toString());
        throw noSuchElementException;
    }

    public static final Character firstOrNull(kotlin.ranges.CharProgression $this$firstOrNull) {
        int valueOf;
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            valueOf = 0;
        } else {
            valueOf = Character.valueOf($this$firstOrNull.getFirst());
        }
        return valueOf;
    }

    public static final Integer firstOrNull(kotlin.ranges.IntProgression $this$firstOrNull) {
        int valueOf;
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            valueOf = 0;
        } else {
            valueOf = Integer.valueOf($this$firstOrNull.getFirst());
        }
        return valueOf;
    }

    public static final Long firstOrNull(kotlin.ranges.LongProgression $this$firstOrNull) {
        int valueOf;
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            valueOf = 0;
        } else {
            valueOf = Long.valueOf($this$firstOrNull.getFirst());
        }
        return valueOf;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean floatRangeContains(kotlin.ranges.ClosedRange $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Float.valueOf((float)value));
    }

    public static final boolean floatRangeContains(kotlin.ranges.ClosedRange<Float> $this$contains, double value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Float.valueOf((float)value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean floatRangeContains(kotlin.ranges.ClosedRange $this$contains, int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Float.valueOf((float)value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean floatRangeContains(kotlin.ranges.ClosedRange $this$contains, long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Float.valueOf((float)value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean floatRangeContains(kotlin.ranges.ClosedRange $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Float.valueOf((float)value));
    }

    public static final boolean intRangeContains(kotlin.ranges.ClosedRange<Integer> $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Integer.valueOf(value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean intRangeContains(kotlin.ranges.ClosedRange $this$contains, double value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Integer intExactOrNull = RangesKt.toIntExactOrNull(value);
        final int i = 0;
        if (intExactOrNull != null) {
            contains = $this$contains.contains((Comparable)intExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean intRangeContains(kotlin.ranges.ClosedRange $this$contains, float value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Integer intExactOrNull = RangesKt.toIntExactOrNull(value);
        final int i = 0;
        if (intExactOrNull != null) {
            contains = $this$contains.contains((Comparable)intExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean intRangeContains(kotlin.ranges.ClosedRange<Integer> $this$contains, long value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Integer intExactOrNull = RangesKt.toIntExactOrNull(value);
        final int i = 0;
        if (intExactOrNull != null) {
            contains = $this$contains.contains((Comparable)intExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean intRangeContains(kotlin.ranges.ClosedRange<Integer> $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Integer.valueOf(value));
    }

    public static final boolean intRangeContains(kotlin.ranges.OpenEndRange<Integer> $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Integer.valueOf(value));
    }

    public static final boolean intRangeContains(kotlin.ranges.OpenEndRange<Integer> $this$contains, long value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Integer intExactOrNull = RangesKt.toIntExactOrNull(value);
        final int i = 0;
        if (intExactOrNull != null) {
            contains = $this$contains.contains((Comparable)intExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean intRangeContains(kotlin.ranges.OpenEndRange<Integer> $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Integer.valueOf(value));
    }

    public static final char last(kotlin.ranges.CharProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
        } else {
            return $this$last.getLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Progression ").append($this$last).append(" is empty.").toString());
        throw noSuchElementException;
    }

    public static final int last(kotlin.ranges.IntProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
        } else {
            return $this$last.getLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Progression ").append($this$last).append(" is empty.").toString());
        throw noSuchElementException;
    }

    public static final long last(kotlin.ranges.LongProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
        } else {
            return $this$last.getLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Progression ").append($this$last).append(" is empty.").toString());
        throw noSuchElementException;
    }

    public static final Character lastOrNull(kotlin.ranges.CharProgression $this$lastOrNull) {
        int valueOf;
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            valueOf = 0;
        } else {
            valueOf = Character.valueOf($this$lastOrNull.getLast());
        }
        return valueOf;
    }

    public static final Integer lastOrNull(kotlin.ranges.IntProgression $this$lastOrNull) {
        int valueOf;
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            valueOf = 0;
        } else {
            valueOf = Integer.valueOf($this$lastOrNull.getLast());
        }
        return valueOf;
    }

    public static final Long lastOrNull(kotlin.ranges.LongProgression $this$lastOrNull) {
        int valueOf;
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            valueOf = 0;
        } else {
            valueOf = Long.valueOf($this$lastOrNull.getLast());
        }
        return valueOf;
    }

    public static final boolean longRangeContains(kotlin.ranges.ClosedRange<Long> $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Long.valueOf((long)value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean longRangeContains(kotlin.ranges.ClosedRange $this$contains, double value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Long longExactOrNull = RangesKt.toLongExactOrNull(value);
        final int i = 0;
        if (longExactOrNull != null) {
            contains = $this$contains.contains((Comparable)longExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean longRangeContains(kotlin.ranges.ClosedRange $this$contains, float value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Long longExactOrNull = RangesKt.toLongExactOrNull(value);
        final int i = 0;
        if (longExactOrNull != null) {
            contains = $this$contains.contains((Comparable)longExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean longRangeContains(kotlin.ranges.ClosedRange<Long> $this$contains, int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Long.valueOf((long)value));
    }

    public static final boolean longRangeContains(kotlin.ranges.ClosedRange<Long> $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Long.valueOf((long)value));
    }

    public static final boolean longRangeContains(kotlin.ranges.OpenEndRange<Long> $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Long.valueOf((long)value));
    }

    public static final boolean longRangeContains(kotlin.ranges.OpenEndRange<Long> $this$contains, int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Long.valueOf((long)value));
    }

    public static final boolean longRangeContains(kotlin.ranges.OpenEndRange<Long> $this$contains, short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Long.valueOf((long)value));
    }

    private static final char random(kotlin.ranges.CharRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return RangesKt.random($this$random, (Random)Random.Default);
    }

    public static final char random(kotlin.ranges.CharRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return (char)nextInt;
    }

    private static final int random(kotlin.ranges.IntRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return RangesKt.random($this$random, (Random)Random.Default);
    }

    public static final int random(kotlin.ranges.IntRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return RandomKt.nextInt(random, $this$random);
    }

    private static final long random(kotlin.ranges.LongRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return RangesKt.random($this$random, (Random)Random.Default);
    }

    public static final long random(kotlin.ranges.LongRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return RandomKt.nextLong(random, $this$random);
    }

    private static final Character randomOrNull(kotlin.ranges.CharRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return RangesKt.randomOrNull($this$randomOrNull, (Random)Random.Default);
    }

    public static final Character randomOrNull(kotlin.ranges.CharRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return Character.valueOf((char)nextInt);
    }

    private static final Integer randomOrNull(kotlin.ranges.IntRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return RangesKt.randomOrNull($this$randomOrNull, (Random)Random.Default);
    }

    public static final Integer randomOrNull(kotlin.ranges.IntRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return Integer.valueOf(RandomKt.nextInt(random, $this$randomOrNull));
    }

    private static final Long randomOrNull(kotlin.ranges.LongRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return RangesKt.randomOrNull($this$randomOrNull, (Random)Random.Default);
    }

    public static final Long randomOrNull(kotlin.ranges.LongRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return Long.valueOf(RandomKt.nextLong(random, $this$randomOrNull));
    }

    public static final kotlin.ranges.CharProgression reversed(kotlin.ranges.CharProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return CharProgression.Companion.fromClosedRange($this$reversed.getLast(), $this$reversed.getFirst(), -step);
    }

    public static final kotlin.ranges.IntProgression reversed(kotlin.ranges.IntProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return IntProgression.Companion.fromClosedRange($this$reversed.getLast(), $this$reversed.getFirst(), -step);
    }

    public static final kotlin.ranges.LongProgression reversed(kotlin.ranges.LongProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return LongProgression.Companion.fromClosedRange($this$reversed.getLast(), obj3, $this$reversed.getFirst());
    }

    public static final boolean shortRangeContains(kotlin.ranges.ClosedRange<Short> $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Short.valueOf((short)value));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean shortRangeContains(kotlin.ranges.ClosedRange $this$contains, double value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Short shortExactOrNull = RangesKt.toShortExactOrNull(value);
        final int i = 0;
        if (shortExactOrNull != null) {
            contains = $this$contains.contains((Comparable)shortExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final boolean shortRangeContains(kotlin.ranges.ClosedRange $this$contains, float value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Short shortExactOrNull = RangesKt.toShortExactOrNull(value);
        final int i = 0;
        if (shortExactOrNull != null) {
            contains = $this$contains.contains((Comparable)shortExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean shortRangeContains(kotlin.ranges.ClosedRange<Short> $this$contains, int value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Short shortExactOrNull = RangesKt.toShortExactOrNull(value);
        final int i = 0;
        if (shortExactOrNull != null) {
            contains = $this$contains.contains((Comparable)shortExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean shortRangeContains(kotlin.ranges.ClosedRange<Short> $this$contains, long value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Short shortExactOrNull = RangesKt.toShortExactOrNull(value);
        final int i = 0;
        if (shortExactOrNull != null) {
            contains = $this$contains.contains((Comparable)shortExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean shortRangeContains(kotlin.ranges.OpenEndRange<Short> $this$contains, byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((Comparable)Short.valueOf((short)value));
    }

    public static final boolean shortRangeContains(kotlin.ranges.OpenEndRange<Short> $this$contains, int value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Short shortExactOrNull = RangesKt.toShortExactOrNull(value);
        final int i = 0;
        if (shortExactOrNull != null) {
            contains = $this$contains.contains((Comparable)shortExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final boolean shortRangeContains(kotlin.ranges.OpenEndRange<Short> $this$contains, long value) {
        boolean contains;
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Short shortExactOrNull = RangesKt.toShortExactOrNull(value);
        final int i = 0;
        if (shortExactOrNull != null) {
            contains = $this$contains.contains((Comparable)shortExactOrNull);
        } else {
            contains = 0;
        }
        return contains;
    }

    public static final kotlin.ranges.CharProgression step(kotlin.ranges.CharProgression $this$step, int step) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        i = step > 0 ? 1 : 0;
        RangesKt.checkStepIsPositive(i, (Number)Integer.valueOf(step));
        i2 = $this$step.getStep() > 0 ? step : -step;
        return CharProgression.Companion.fromClosedRange($this$step.getFirst(), $this$step.getLast(), i2);
    }

    public static final kotlin.ranges.IntProgression step(kotlin.ranges.IntProgression $this$step, int step) {
        int i2;
        int i;
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        i2 = step > 0 ? 1 : 0;
        RangesKt.checkStepIsPositive(i2, (Number)Integer.valueOf(step));
        i = $this$step.getStep() > 0 ? step : -step;
        return IntProgression.Companion.fromClosedRange($this$step.getFirst(), $this$step.getLast(), i);
    }

    public static final kotlin.ranges.LongProgression step(kotlin.ranges.LongProgression $this$step, long step) {
        int cmp;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        int i3 = 0;
        i = Long.compare(step, i3) > 0 ? 1 : 0;
        RangesKt.checkStepIsPositive(i, (Number)Long.valueOf(step));
        i2 = Long.compare(step2, i3) > 0 ? step : cmp;
        return LongProgression.Companion.fromClosedRange($this$step.getFirst(), obj6, $this$step.getLast());
    }

    public static final Byte toByteExactOrNull(double $this$toByteExactOrNull) {
        int cmp;
        int valueOf;
        int i;
        long l;
        i = 0;
        if (Double.compare(l2, $this$toByteExactOrNull) <= 0 && Double.compare($this$toByteExactOrNull, l) <= 0) {
            if (Double.compare($this$toByteExactOrNull, l) <= 0) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Byte.valueOf((byte)i2);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Byte toByteExactOrNull(float $this$toByteExactOrNull) {
        int cmp;
        int valueOf;
        int i;
        i = 0;
        if (Float.compare(i2, $this$toByteExactOrNull) <= 0 && Float.compare($this$toByteExactOrNull, i4) <= 0) {
            if (Float.compare($this$toByteExactOrNull, i4) <= 0) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Byte.valueOf((byte)i3);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Byte toByteExactOrNull(int $this$toByteExactOrNull) {
        int i;
        int valueOf;
        int i2;
        i2 = 0;
        if (-128 <= $this$toByteExactOrNull && $this$toByteExactOrNull < 128) {
            if ($this$toByteExactOrNull < 128) {
                i2 = 1;
            }
        }
        if (i2 != 0) {
            valueOf = Byte.valueOf((byte)$this$toByteExactOrNull);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Byte toByteExactOrNull(long $this$toByteExactOrNull) {
        int cmp;
        int valueOf;
        int i2;
        int i;
        i2 = 0;
        if (Long.compare(i3, $this$toByteExactOrNull) <= 0 && Long.compare($this$toByteExactOrNull, i) < 0) {
            if (Long.compare($this$toByteExactOrNull, i) < 0) {
                i2 = 1;
            }
        }
        if (i2 != 0) {
            valueOf = Byte.valueOf((byte)i4);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Byte toByteExactOrNull(short $this$toByteExactOrNull) {
        int i2;
        int valueOf;
        int i;
        i = 0;
        if (-128 <= $this$toByteExactOrNull && $this$toByteExactOrNull < 128) {
            if ($this$toByteExactOrNull < 128) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Byte.valueOf((byte)$this$toByteExactOrNull);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Integer toIntExactOrNull(double $this$toIntExactOrNull) {
        int cmp;
        int valueOf;
        int i;
        long l;
        i = 0;
        if (Double.compare(l2, $this$toIntExactOrNull) <= 0 && Double.compare($this$toIntExactOrNull, l) <= 0) {
            if (Double.compare($this$toIntExactOrNull, l) <= 0) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Integer.valueOf((int)$this$toIntExactOrNull);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Integer toIntExactOrNull(float $this$toIntExactOrNull) {
        int cmp;
        int valueOf;
        int i;
        i = 0;
        if (Float.compare(i2, $this$toIntExactOrNull) <= 0 && Float.compare($this$toIntExactOrNull, i4) <= 0) {
            if (Float.compare($this$toIntExactOrNull, i4) <= 0) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Integer.valueOf((int)$this$toIntExactOrNull);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Integer toIntExactOrNull(long $this$toIntExactOrNull) {
        int cmp;
        int valueOf;
        int i;
        long l;
        i = 0;
        if (Long.compare(i2, $this$toIntExactOrNull) <= 0 && Long.compare($this$toIntExactOrNull, l) < 0) {
            if (Long.compare($this$toIntExactOrNull, l) < 0) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Integer.valueOf((int)$this$toIntExactOrNull);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Long toLongExactOrNull(double $this$toLongExactOrNull) {
        int cmp;
        int valueOf;
        int i;
        long l;
        i = 0;
        if (Double.compare(l2, $this$toLongExactOrNull) <= 0 && Double.compare($this$toLongExactOrNull, l) <= 0) {
            if (Double.compare($this$toLongExactOrNull, l) <= 0) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Long.valueOf((long)$this$toLongExactOrNull);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Long toLongExactOrNull(float $this$toLongExactOrNull) {
        int cmp;
        int valueOf;
        int i;
        i = 0;
        if (Float.compare(i2, $this$toLongExactOrNull) <= 0 && Float.compare($this$toLongExactOrNull, i3) <= 0) {
            if (Float.compare($this$toLongExactOrNull, i3) <= 0) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Long.valueOf((long)$this$toLongExactOrNull);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Short toShortExactOrNull(double $this$toShortExactOrNull) {
        int cmp;
        int valueOf;
        int i;
        long l;
        i = 0;
        if (Double.compare(l2, $this$toShortExactOrNull) <= 0 && Double.compare($this$toShortExactOrNull, l) <= 0) {
            if (Double.compare($this$toShortExactOrNull, l) <= 0) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Short.valueOf((short)i2);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Short toShortExactOrNull(float $this$toShortExactOrNull) {
        int cmp;
        int valueOf;
        int i;
        i = 0;
        if (Float.compare(i2, $this$toShortExactOrNull) <= 0 && Float.compare($this$toShortExactOrNull, i4) <= 0) {
            if (Float.compare($this$toShortExactOrNull, i4) <= 0) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Short.valueOf((short)i3);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Short toShortExactOrNull(int $this$toShortExactOrNull) {
        int i2;
        int valueOf;
        int i;
        i = 0;
        if (-32768 <= $this$toShortExactOrNull && $this$toShortExactOrNull < 32768) {
            if ($this$toShortExactOrNull < 32768) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Short.valueOf((short)$this$toShortExactOrNull);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Short toShortExactOrNull(long $this$toShortExactOrNull) {
        int cmp;
        int valueOf;
        int i;
        int i2;
        i = 0;
        if (Long.compare(i3, $this$toShortExactOrNull) <= 0 && Long.compare($this$toShortExactOrNull, i2) < 0) {
            if (Long.compare($this$toShortExactOrNull, i2) < 0) {
                i = 1;
            }
        }
        if (i != 0) {
            valueOf = Short.valueOf((short)i4);
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final kotlin.ranges.CharRange until(char $this$until, char to) {
        if (Intrinsics.compare(to, 0) <= 0) {
            return CharRange.Companion.getEMPTY();
        }
        CharRange charRange = new CharRange($this$until, (char)i2);
        return charRange;
    }

    public static final kotlin.ranges.IntRange until(byte $this$until, byte to) {
        IntRange intRange = new IntRange($this$until, to + -1);
        return intRange;
    }

    public static final kotlin.ranges.IntRange until(byte $this$until, int to) {
        if (to <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        IntRange intRange = new IntRange($this$until, to + -1);
        return intRange;
    }

    public static final kotlin.ranges.IntRange until(byte $this$until, short to) {
        IntRange intRange = new IntRange($this$until, to + -1);
        return intRange;
    }

    public static final kotlin.ranges.IntRange until(int $this$until, byte to) {
        IntRange intRange = new IntRange($this$until, to + -1);
        return intRange;
    }

    public static final kotlin.ranges.IntRange until(int $this$until, int to) {
        if (to <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        IntRange intRange = new IntRange($this$until, to + -1);
        return intRange;
    }

    public static final kotlin.ranges.IntRange until(int $this$until, short to) {
        IntRange intRange = new IntRange($this$until, to + -1);
        return intRange;
    }

    public static final kotlin.ranges.IntRange until(short $this$until, byte to) {
        IntRange intRange = new IntRange($this$until, to + -1);
        return intRange;
    }

    public static final kotlin.ranges.IntRange until(short $this$until, int to) {
        if (to <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        IntRange intRange = new IntRange($this$until, to + -1);
        return intRange;
    }

    public static final kotlin.ranges.IntRange until(short $this$until, short to) {
        IntRange intRange = new IntRange($this$until, to + -1);
        return intRange;
    }

    public static final kotlin.ranges.LongRange until(byte $this$until, long to) {
        if (Long.compare(to, l) <= 0) {
            return LongRange.Companion.getEMPTY();
        }
        LongRange longRange = new LongRange((long)$this$until, obj2, to - i, obj4);
        return longRange;
    }

    public static final kotlin.ranges.LongRange until(int $this$until, long to) {
        if (Long.compare(to, l) <= 0) {
            return LongRange.Companion.getEMPTY();
        }
        LongRange longRange = new LongRange((long)$this$until, obj2, to - i, obj4);
        return longRange;
    }

    public static final kotlin.ranges.LongRange until(long $this$until, byte to) {
        LongRange longRange = new LongRange($this$until, to, l -= i2, obj2);
        return longRange;
    }

    public static final kotlin.ranges.LongRange until(long $this$until, int to) {
        LongRange longRange = new LongRange($this$until, to, l -= i2, obj2);
        return longRange;
    }

    public static final kotlin.ranges.LongRange until(long $this$until, long to) {
        if (Long.compare(obj5, l) <= 0) {
            return LongRange.Companion.getEMPTY();
        }
        LongRange longRange = new LongRange($this$until, to, obj5 - i, obj2);
        return longRange;
    }

    public static final kotlin.ranges.LongRange until(long $this$until, short to) {
        LongRange longRange = new LongRange($this$until, to, l -= i2, obj2);
        return longRange;
    }

    public static final kotlin.ranges.LongRange until(short $this$until, long to) {
        if (Long.compare(to, l) <= 0) {
            return LongRange.Companion.getEMPTY();
        }
        LongRange longRange = new LongRange((long)$this$until, obj2, to - i, obj4);
        return longRange;
    }
}
