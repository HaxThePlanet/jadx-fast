package kotlin.k0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h0.d;
import kotlin.h0.f;
import kotlin.h0.g;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.o;
import kotlin.u;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0019\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0010\u0011\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u000c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\u0008!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001a7\u0010%\u001a\u0002H&\"\u000c\u0008\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\u0008\u0001\u0010&*\u0002H'2\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H&0)H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010*\u001a7\u0010+\u001a\u0002H&\"\u000c\u0008\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\u0008\u0001\u0010&*\u0002H'2\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H&0)H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\u0008.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\r\u00103\u001a\u00020\u0010*\u00020\u0002H\u0087\u0008\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\u0087\u0008\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\u0087\u0008\u001a \u00106\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\u0008\u0082\u0002\u000e\n\u000c\u0008\u0000\u0012\u0002\u0018\u0001\u001a\u0004\u0008\u0003\u0010\u0000\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\u0008\u0082\u0002\u000e\n\u000c\u0008\u0000\u0012\u0002\u0018\u0001\u001a\u0004\u0008\u0003\u0010\u0000\u001a\r\u00108\u001a\u000209*\u00020\u0002H\u0086\u0002\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010;\u001a\u00020\u0006*\u00020\u00022\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\r0\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010<\u001a\u0008\u0012\u0004\u0012\u00020\r0=*\u00020\u0002\u001a\u0010\u0010>\u001a\u0008\u0012\u0004\u0012\u00020\r0?*\u00020\u0002\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\u000c\u001a\u000f\u0010A\u001a\u00020\r*\u0004\u0018\u00010\rH\u0087\u0008\u001a\u001c\u0010B\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\u0008\u0008\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010B\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\u0008\u0008\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\u0008\u0008\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\u0008\u0008\u0002\u0010D\u001a\u00020\u0014\u001aG\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u000e\u0010G\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0H2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008I\u0010J\u001a=\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u0006\u0010G\u001a\u0002022\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0008I\u001a4\u0010K\u001a\u00020\u0010*\u00020\u00022\u0006\u0010L\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u0002\u001a\u001a\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0087\u0008\u001a\u0015\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001H\u0087\u0008\u001a\u0012\u0010R\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010R\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0008\u0008\u0010V\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00020WH\u0087\u0008ø\u0001\u0000\u001a\u001d\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\u0008\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a\u001d\u0010_\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\u0008\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140WH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008a\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020WH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008b\u001a\"\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002\u001a\u001a\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002\u001a%\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002H\u0087\u0008\u001a\u001d\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002H\u0087\u0008\u001a=\u0010d\u001a\u0008\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0H\"\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010e\u001a0\u0010d\u001a\u0008\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010d\u001a\u0008\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010T\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0008f\u001a%\u0010d\u001a\u0008\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\u0008\u001a=\u0010g\u001a\u0008\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0H\"\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010h\u001a0\u0010g\u001a\u0008\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010g\u001a\u0008\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\u0008\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010j\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010j\u001a\u00020\u0002*\u00020\r2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006H\u0087\u0008\u001a\u001f\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0008\u0008\u0002\u0010-\u001a\u00020\u0006H\u0087\u0008\u001a\u0012\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u0012\u0010m\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0008\u0008\u0002\u0010[\u001a\u00020\r\u001a\u000c\u0010r\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010s\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007¢\u0006\u0002\u0010t\u001a\n\u0010u\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010u\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010u\u001a\u00020\r*\u00020\rH\u0087\u0008\u001a$\u0010u\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010w\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010w\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010w\u001a\u00020\r*\u00020\rH\u0087\u0008\u001a$\u0010w\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\u0087\u0008\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\u0008ø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006y", d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", "limit", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
class v extends kotlin.k0.u {

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0010\r\n\u0002\u0008\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\u0008\u0005", d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k = 3, mv = {1, 5, 1})
    static final class a extends p implements p<java.lang.CharSequence, Integer, o<? extends Integer, ? extends Integer>> {

        final char[] $delimiters;
        final boolean $ignoreCase;
        a(char[] cArr, boolean z2) {
            this.$delimiters = cArr;
            this.$ignoreCase = z2;
            super(2);
        }

        public final o<Integer, Integer> a(java.lang.CharSequence charSequence, int i2) {
            int obj3;
            int obj4;
            n.f(charSequence, "$receiver");
            obj3 = v.f0(charSequence, this.$delimiters, i2, this.$ignoreCase);
            if (obj3 < 0) {
                obj3 = 0;
            } else {
                obj3 = u.a(Integer.valueOf(obj3), 1);
            }
            return obj3;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return a((CharSequence)object, (Number)object2.intValue());
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0010\r\n\u0002\u0008\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\u0008\u0005", d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k = 3, mv = {1, 5, 1})
    static final class b extends p implements p<java.lang.CharSequence, Integer, o<? extends Integer, ? extends Integer>> {

        final List $delimitersList;
        final boolean $ignoreCase;
        b(List list, boolean z2) {
            this.$delimitersList = list;
            this.$ignoreCase = z2;
            super(2);
        }

        public final o<Integer, Integer> a(java.lang.CharSequence charSequence, int i2) {
            o obj4;
            Object obj5;
            n.f(charSequence, "$receiver");
            obj4 = v.N(charSequence, this.$delimitersList, i2, this.$ignoreCase, false);
            if (obj4 != null) {
                obj4 = u.a(obj4.c(), Integer.valueOf((String)obj4.d().length()));
            } else {
                obj4 = 0;
            }
            return obj4;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return a((CharSequence)object, (Number)object2.intValue());
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"}, k = 3, mv = {1, 5, 1})
    static final class c extends p implements l<f, String> {

        final java.lang.CharSequence $this_splitToSequence;
        c(java.lang.CharSequence charSequence) {
            this.$this_splitToSequence = charSequence;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final String a(f f) {
            n.f(f, "it");
            return v.L0(this.$this_splitToSequence, f);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((f)object);
        }
    }
    public static final List<String> A0(java.lang.CharSequence charSequence, char[] c2Arr2, boolean z3, int i4) {
        int obj10;
        n.f(charSequence, "$this$split");
        n.f(c2Arr2, "delimiters");
        if (c2Arr2.length == 1) {
            return v.C0(charSequence, String.valueOf(c2Arr2[0]), z3, i4);
        }
        Iterable obj8 = i.i(v.r0(charSequence, c2Arr2, 0, z3, i4, 2, 0));
        ArrayList obj9 = new ArrayList(p.r(obj8, 10));
        obj8 = obj8.iterator();
        for (f obj10 : obj8) {
            obj9.add(v.L0(charSequence, obj10));
        }
        return obj9;
    }

    public static final List<String> B0(java.lang.CharSequence charSequence, String[] string2Arr2, boolean z3, int i4) {
        int length;
        int i;
        Object obj;
        int length2;
        int obj10;
        n.f(charSequence, "$this$split");
        n.f(string2Arr2, "delimiters");
        if (string2Arr2.length == 1) {
            length = 0;
            obj = string2Arr2[length];
            if (obj.length() == 0) {
            } else {
                i = length;
            }
            if (i == 0) {
                return v.C0(charSequence, obj, z3, i4);
            }
        }
        Iterable obj8 = i.i(v.s0(charSequence, string2Arr2, 0, z3, i4, 2, 0));
        ArrayList obj9 = new ArrayList(p.r(obj8, 10));
        obj8 = obj8.iterator();
        for (f obj10 : obj8) {
            obj9.add(v.L0(charSequence, obj10));
        }
        return obj9;
    }

    private static final List<String> C0(java.lang.CharSequence charSequence, String string2, boolean z3, int i4) {
        int i3;
        int size;
        int i5;
        int i;
        int i2;
        v.z0(i4);
        i3 = 0;
        final int i6 = -1;
        if (v.a0(charSequence, string2, i3, z3) != i6) {
            i5 = 1;
            if (i4 == i5) {
            } else {
                i = i4 > 0 ? i5 : i3;
                if (i != 0) {
                    i2 = g.e(i4, 10);
                }
                ArrayList arrayList = new ArrayList(i2);
                arrayList.add(charSequence.subSequence(i3, size).toString());
                length += size;
                while (i != 0) {
                    if (arrayList.size() == i4 + -1) {
                        break;
                    } else {
                    }
                    if (v.a0(charSequence, string2, i3, z3) != i6) {
                        break;
                    }
                    arrayList.add(charSequence.subSequence(i3, size).toString());
                    length += size;
                }
            }
            arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
            return arrayList;
        }
        return p.b(charSequence.toString());
    }

    public static List D0(java.lang.CharSequence charSequence, char[] c2Arr2, boolean z3, int i4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return v.A0(charSequence, c2Arr2, obj3, obj4);
    }

    public static List E0(java.lang.CharSequence charSequence, String[] string2Arr2, boolean z3, int i4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return v.B0(charSequence, string2Arr2, obj3, obj4);
    }

    public static final h<String> F0(java.lang.CharSequence charSequence, String[] string2Arr2, boolean z3, int i4) {
        n.f(charSequence, "$this$splitToSequence");
        n.f(string2Arr2, "delimiters");
        v.c obj10 = new v.c(charSequence);
        return i.u(v.s0(charSequence, string2Arr2, 0, z3, i4, 2, 0), obj10);
    }

    public static h G0(java.lang.CharSequence charSequence, String[] string2Arr2, boolean z3, int i4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return v.F0(charSequence, string2Arr2, obj3, obj4);
    }

    public static final boolean H0(java.lang.CharSequence charSequence, char c2, boolean z3) {
        int i;
        Object obj2;
        n.f(charSequence, "$this$startsWith");
        if (charSequence.length() > 0 && c.e(charSequence.charAt(0), c2, z3)) {
            if (c.e(charSequence.charAt(i), c2, z3)) {
                i = 1;
            }
        }
        return i;
    }

    public static final boolean I0(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z3) {
        String str;
        n.f(charSequence, "$this$startsWith");
        n.f(charSequence2, "prefix");
        if (!z3 && charSequence instanceof String != null && charSequence2 instanceof String != null) {
            if (charSequence instanceof String != null) {
                if (charSequence2 instanceof String != null) {
                    return l.M((String)charSequence, (String)charSequence2, false, 2, 0);
                }
            }
        }
        return v.t0(charSequence, 0, charSequence2, 0, charSequence2.length(), z3);
    }

    public static boolean J0(java.lang.CharSequence charSequence, char c2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return v.H0(charSequence, c2, obj2);
    }

    public static boolean K0(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return v.I0(charSequence, charSequence2, obj2);
    }

    public static final String L0(java.lang.CharSequence charSequence, f f2) {
        n.f(charSequence, "$this$substring");
        n.f(f2, "range");
        return charSequence.subSequence(f2.q().intValue(), obj2++).toString();
    }

    public static final String M0(String string, char c2, String string3) {
        Object obj7;
        int obj8;
        Object obj9;
        n.f(string, "$this$substringAfter");
        n.f(string3, "missingDelimiterValue");
        obj8 = l.d0(string, c2, 0, false, 6, 0);
        if (obj8 == -1) {
        } else {
            n.e(string.substring(obj8++, string.length()), "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return obj9;
    }

    public static final o N(java.lang.CharSequence charSequence, Collection collection2, int i3, boolean z4, boolean z5) {
        return v.W(charSequence, collection2, i3, z4, z5);
    }

    public static String N0(String string, String string2, String string3) {
        int i;
        Object obj7;
        Object obj8;
        Object obj9;
        n.f(string, "$this$substringAfter");
        n.f(string2, "delimiter");
        n.f(string3, "missingDelimiterValue");
        i = l.e0(string, string2, 0, false, 6, 0);
        if (i == -1) {
        } else {
            n.e(string.substring(i += obj8, string.length()), "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return obj9;
    }

    public static final boolean O(java.lang.CharSequence charSequence, char c2, boolean z3) {
        int obj7;
        n.f(charSequence, "$this$contains");
        obj7 = l.d0(charSequence, c2, 0, z3, 2, 0) >= 0 ? 1 : 0;
        return obj7;
    }

    public static String O0(String string, char c2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return v.M0(string, c2, obj2);
    }

    public static final boolean P(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z3) {
        int i3;
        Object obj2;
        Object obj;
        int i2;
        int length;
        boolean z;
        int i;
        int i4;
        int i5;
        int obj11;
        n.f(charSequence, "$this$contains");
        n.f(charSequence2, "other");
        i3 = 1;
        if (charSequence2 instanceof String != null) {
            if (l.e0(charSequence, (String)charSequence2, 0, z3, 2, 0) >= 0) {
            } else {
                i3 = i6;
            }
        } else {
            if (v.c0(charSequence, charSequence2, 0, charSequence.length(), z3, false, 16, 0) >= 0) {
            } else {
            }
        }
        return i3;
    }

    public static String P0(String string, String string2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return l.N0(string, string2, obj2);
    }

    public static boolean Q(java.lang.CharSequence charSequence, char c2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return v.O(charSequence, c2, obj2);
    }

    public static String Q0(String string, char c2, String string3) {
        Object obj7;
        int obj8;
        Object obj9;
        n.f(string, "$this$substringAfterLast");
        n.f(string3, "missingDelimiterValue");
        obj8 = l.i0(string, c2, 0, false, 6, 0);
        if (obj8 == -1) {
        } else {
            n.e(string.substring(obj8++, string.length()), "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return obj9;
    }

    public static boolean R(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return v.P(charSequence, charSequence2, obj2);
    }

    public static final String R0(String string, String string2, String string3) {
        int i;
        Object obj7;
        Object obj8;
        Object obj9;
        n.f(string, "$this$substringAfterLast");
        n.f(string2, "delimiter");
        n.f(string3, "missingDelimiterValue");
        i = l.j0(string, string2, 0, false, 6, 0);
        if (i == -1) {
        } else {
            n.e(string.substring(i += obj8, string.length()), "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return obj9;
    }

    public static final boolean S(java.lang.CharSequence charSequence, char c2, boolean z3) {
        int length;
        Object obj1;
        n.f(charSequence, "$this$endsWith");
        if (charSequence.length() > 0 && c.e(charSequence.charAt(l.Y(charSequence)), c2, z3)) {
            obj1 = c.e(charSequence.charAt(l.Y(charSequence)), c2, z3) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static String S0(String string, char c2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return l.Q0(string, c2, obj2);
    }

    public static final boolean T(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z3) {
        String str;
        n.f(charSequence, "$this$endsWith");
        n.f(charSequence2, "suffix");
        if (!z3 && charSequence instanceof String != null && charSequence2 instanceof String != null) {
            if (charSequence instanceof String != null) {
                if (charSequence2 instanceof String != null) {
                    return l.w((String)charSequence, (String)charSequence2, false, 2, 0);
                }
            }
        }
        return v.t0(charSequence, length - length2, charSequence2, 0, charSequence2.length(), z3);
    }

    public static String T0(String string, String string2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return v.R0(string, string2, obj2);
    }

    public static boolean U(java.lang.CharSequence charSequence, char c2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return v.S(charSequence, c2, obj2);
    }

    public static final String U0(String string, char c2, String string3) {
        Object obj7;
        Object obj9;
        n.f(string, "$this$substringBefore");
        n.f(string3, "missingDelimiterValue");
        final int obj8 = l.d0(string, c2, 0, false, 6, 0);
        if (obj8 == -1) {
        } else {
            n.e(string.substring(0, obj8), "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return obj9;
    }

    public static boolean V(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return v.T(charSequence, charSequence2, obj2);
    }

    public static final String V0(String string, String string2, String string3) {
        Object obj7;
        Object obj9;
        n.f(string, "$this$substringBefore");
        n.f(string2, "delimiter");
        n.f(string3, "missingDelimiterValue");
        final int obj8 = l.e0(string, string2, 0, false, 6, 0);
        if (obj8 == -1) {
        } else {
            n.e(string.substring(0, obj8), "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return obj9;
    }

    private static final o<Integer, String> W(java.lang.CharSequence charSequence, Collection<String> collection2, int i3, boolean z4, boolean z5) {
        int i4;
        int size;
        int length2;
        int i5;
        int next2;
        int i;
        java.lang.CharSequence charSequence2;
        int i2;
        int length;
        boolean z;
        Iterator iterator;
        int next;
        int obj10;
        int obj12;
        d obj14;
        i4 = 0;
        if (!z4 && collection2.size() == 1) {
            if (collection2.size() == 1) {
                final Object obj11 = p.y0(collection2);
                int i7 = 0;
                int i8 = 4;
                int i9 = 0;
                java.lang.CharSequence charSequence3 = charSequence;
                Object obj3 = obj11;
                int i6 = i3;
                if (!z5) {
                    obj10 = l.e0(charSequence3, obj3, i6, i7, i8, i9);
                } else {
                    obj10 = l.j0(charSequence3, obj3, i6, i7, i8, i9);
                }
                if (obj10 < 0) {
                } else {
                    i4 = u.a(Integer.valueOf(obj10), (String)obj11);
                }
                return i4;
            }
        }
        length2 = 0;
        if (!z5) {
            obj14 = new f(g.b(i3, length2), charSequence.length());
        } else {
            obj14 = g.i(g.e(i3, l.Y(charSequence)), length2);
        }
        if (charSequence instanceof String != null) {
            obj12 = obj14.d();
            i5 = obj14.g();
            obj14 = obj14.h();
            if (obj14 >= 0) {
                if (obj12 <= i5) {
                    while (/* condition */) {
                        for (Object next : iterator) {
                            Object obj2 = next;
                        }
                        next = i4;
                        if (obj12 != i5) {
                        }
                        obj12 += obj14;
                        iterator = collection2.iterator();
                        obj2 = next;
                        if (u.A(obj2, 0, (String)charSequence, obj12, (String)obj2.length(), z4) != 0) {
                        } else {
                        }
                    }
                    return u.a(Integer.valueOf(obj12), (String)next);
                }
            } else {
                if (obj12 >= i5) {
                }
            }
        } else {
            obj12 = obj14.d();
            i5 = obj14.g();
            obj14 = obj14.h();
            if (obj14 >= 0) {
                if (obj12 <= i5) {
                    while (/* condition */) {
                        for (Object next : iterator) {
                            Object obj = next;
                        }
                        next = i4;
                        if (obj12 != i5) {
                        }
                        obj12 += obj14;
                        iterator = collection2.iterator();
                        obj = next;
                        if (v.t0(obj, 0, charSequence, obj12, (String)obj.length(), z4) != 0) {
                        } else {
                        }
                    }
                    return u.a(Integer.valueOf(obj12), (String)next);
                }
            } else {
                if (obj12 >= i5) {
                }
            }
        }
        return i4;
    }

    public static String W0(String string, char c2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return v.U0(string, c2, obj2);
    }

    public static f X(java.lang.CharSequence charSequence) {
        n.f(charSequence, "$this$indices");
        f fVar = new f(0, obj2--);
        return fVar;
    }

    public static String X0(String string, String string2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = string;
        }
        return v.V0(string, string2, obj2);
    }

    public static int Y(java.lang.CharSequence charSequence) {
        n.f(charSequence, "$this$lastIndex");
        return obj1--;
    }

    public static String Y0(String string, char c2, String string3) {
        Object obj7;
        Object obj9;
        n.f(string, "$this$substringBeforeLast");
        n.f(string3, "missingDelimiterValue");
        final int obj8 = l.i0(string, c2, 0, false, 6, 0);
        if (obj8 == -1) {
        } else {
            n.e(string.substring(0, obj8), "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return obj9;
    }

    public static final int Z(java.lang.CharSequence charSequence, char c2, int i3, boolean z4) {
        boolean cArr;
        int i;
        int obj2;
        n.f(charSequence, "$this$indexOf");
        if (!z4) {
            if (charSequence instanceof String == null) {
                cArr = new char[1];
                obj2 = v.f0(charSequence, cArr, i3, z4);
            } else {
                obj2 = (String)charSequence.indexOf(c2, i3);
            }
        } else {
        }
        return obj2;
    }

    public static String Z0(String string, String string2, String string3) {
        Object obj7;
        Object obj9;
        n.f(string, "$this$substringBeforeLast");
        n.f(string2, "delimiter");
        n.f(string3, "missingDelimiterValue");
        final int obj8 = l.j0(string, string2, 0, false, 6, 0);
        if (obj8 == -1) {
        } else {
            n.e(string.substring(0, obj8), "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return obj9;
    }

    public static final int a0(java.lang.CharSequence charSequence, String string2, int i3, boolean z4) {
        boolean str;
        Object obj;
        int i4;
        int length;
        boolean z;
        int i2;
        int i;
        int i5;
        int obj8;
        n.f(charSequence, "$this$indexOf");
        n.f(string2, "string");
        if (!z4) {
            if (charSequence instanceof String == null) {
                obj8 = v.c0(charSequence, string2, i3, charSequence.length(), z4, false, 16, 0);
            } else {
                obj8 = (String)charSequence.indexOf(string2, i3);
            }
        } else {
        }
        return obj8;
    }

    public static java.lang.CharSequence a1(java.lang.CharSequence charSequence) {
        int i2;
        int i4;
        int i;
        boolean z;
        int i3;
        n.f(charSequence, "$this$trim");
        final int i6 = 1;
        length -= i6;
        i = i4;
        while (i4 <= i2) {
            if (i == 0) {
            } else {
            }
            i3 = i2;
            z = b.c(charSequence.charAt(i3));
            if (i != 0) {
                break;
            } else {
            }
            if (!z) {
                break;
            } else {
            }
            i2--;
            if (!z) {
            } else {
            }
            i4++;
            i = i6;
            i3 = i4;
        }
        return charSequence.subSequence(i4, i2 += i6);
    }

    private static final int b0(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, int i3, int i4, boolean z5, boolean z6) {
        int length;
        int i;
        java.lang.CharSequence charSequence3;
        int i2;
        int length2;
        boolean z;
        int obj8;
        int obj9;
        d obj11;
        length = 0;
        if (!z6) {
            obj11 = new f(g.b(i3, length), g.e(i4, charSequence.length()));
        } else {
            obj11 = g.i(g.e(i3, l.Y(charSequence)), g.b(i4, length));
        }
        if (charSequence instanceof String != null && charSequence2 instanceof String != null) {
            if (charSequence2 instanceof String != null) {
                obj8 = obj11.d();
                obj9 = obj11.g();
                obj11 = obj11.h();
                if (obj11 >= 0) {
                    if (obj8 <= obj9) {
                        while (u.A((String)charSequence2, 0, (String)charSequence, obj8, charSequence2.length(), z5) != 0) {
                            obj8 += obj11;
                        }
                        return obj8;
                    }
                } else {
                    if (obj8 >= obj9) {
                    }
                }
            } else {
                obj8 = obj11.d();
                obj9 = obj11.g();
                obj11 = obj11.h();
                if (obj11 >= 0) {
                    if (obj8 <= obj9) {
                        while (v.t0(charSequence2, 0, charSequence, obj8, charSequence2.length(), z5) != 0) {
                            obj8 += obj11;
                        }
                        return obj8;
                    }
                } else {
                    if (obj8 >= obj9) {
                    }
                }
            }
        } else {
        }
        return -1;
    }

    static int c0(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, int i3, int i4, boolean z5, boolean z6, int i7, Object object8) {
        int obj11;
        if (i7 &= 16 != 0) {
            obj11 = 0;
        }
        return v.b0(charSequence, charSequence2, i3, i4, z5, obj11);
    }

    public static int d0(java.lang.CharSequence charSequence, char c2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return v.Z(charSequence, c2, obj3, obj4);
    }

    public static int e0(java.lang.CharSequence charSequence, String string2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return v.a0(charSequence, string2, obj3, obj4);
    }

    public static final int f0(java.lang.CharSequence charSequence, char[] c2Arr2, int i3, boolean z4) {
        int length;
        int i;
        int length2;
        int i2;
        boolean z;
        int obj9;
        n.f(charSequence, "$this$indexOfAny");
        n.f(c2Arr2, "chars");
        int i4 = 1;
        if (!z4 && c2Arr2.length == i4 && charSequence instanceof String != null) {
            if (c2Arr2.length == i4) {
                if (charSequence instanceof String != null) {
                    return (String)charSequence.indexOf(i.M(c2Arr2), i3);
                }
            }
        }
        int i5 = 0;
        final int i6 = l.Y(charSequence);
        if (g.b(i3, i5) <= i6) {
        }
        return -1;
    }

    public static final int g0(java.lang.CharSequence charSequence, char c2, int i3, boolean z4) {
        boolean cArr;
        int i;
        int obj2;
        n.f(charSequence, "$this$lastIndexOf");
        if (!z4) {
            if (charSequence instanceof String == null) {
                cArr = new char[1];
                obj2 = v.k0(charSequence, cArr, i3, z4);
            } else {
                obj2 = (String)charSequence.lastIndexOf(c2, i3);
            }
        } else {
        }
        return obj2;
    }

    public static final int h0(java.lang.CharSequence charSequence, String string2, int i3, boolean z4) {
        boolean str;
        Object obj;
        int i4;
        int i2;
        boolean z;
        int i;
        int obj6;
        n.f(charSequence, "$this$lastIndexOf");
        n.f(string2, "string");
        if (!z4) {
            if (charSequence instanceof String == null) {
                obj6 = v.b0(charSequence, string2, i3, 0, z4, true);
            } else {
                obj6 = (String)charSequence.lastIndexOf(string2, i3);
            }
        } else {
        }
        return obj6;
    }

    public static int i0(java.lang.CharSequence charSequence, char c2, int i3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = l.Y(charSequence);
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return v.g0(charSequence, c2, obj2, obj3);
    }

    public static int j0(java.lang.CharSequence charSequence, String string2, int i3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = l.Y(charSequence);
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return v.h0(charSequence, string2, obj2, obj3);
    }

    public static final int k0(java.lang.CharSequence charSequence, char[] c2Arr2, int i3, boolean z4) {
        int length;
        int charAt;
        int length2;
        int i;
        int i2;
        boolean z;
        int obj8;
        n.f(charSequence, "$this$lastIndexOfAny");
        n.f(c2Arr2, "chars");
        int i4 = 1;
        if (!z4 && c2Arr2.length == i4 && charSequence instanceof String != null) {
            if (c2Arr2.length == i4) {
                if (charSequence instanceof String != null) {
                    return (String)charSequence.lastIndexOf(i.M(c2Arr2), i3);
                }
            }
        }
        obj8 = g.e(i3, l.Y(charSequence));
        while (obj8 >= 0) {
            i2 = i;
            while (i2 < c2Arr2.length) {
                if (c.e(c2Arr2[i2], charSequence.charAt(obj8), z4)) {
                    break loop_7;
                } else {
                }
                i2++;
            }
            obj8--;
            if (c.e(c2Arr2[i2], charAt, z4)) {
            } else {
            }
            i2++;
            i = i4;
        }
        return -1;
    }

    public static final h<String> l0(java.lang.CharSequence charSequence) {
        n.f(charSequence, "$this$lineSequence");
        return v.G0(charSequence, /* result */, false, 0, 6, 0);
    }

    public static final List<String> m0(java.lang.CharSequence charSequence) {
        n.f(charSequence, "$this$lines");
        return i.A(v.l0(charSequence));
    }

    public static final java.lang.CharSequence n0(java.lang.CharSequence charSequence, int i2, char c3) {
        int i;
        n.f(charSequence, "$this$padStart");
        if (i2 < 0) {
        } else {
            if (i2 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder stringBuilder = new StringBuilder(i2);
            i2 -= length2;
            if (1 <= obj3) {
            }
            stringBuilder.append(charSequence);
            return stringBuilder;
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Desired length ");
        obj4.append(i2);
        obj4.append(" is less than zero.");
        IllegalArgumentException obj2 = new IllegalArgumentException(obj4.toString());
        throw obj2;
    }

    public static String o0(String string, int i2, char c3) {
        n.f(string, "$this$padStart");
        return v.n0(string, i2, c3).toString();
    }

    private static final h<f> p0(java.lang.CharSequence charSequence, char[] c2Arr2, int i3, boolean z4, int i5) {
        v.z0(i5);
        v.a aVar = new v.a(c2Arr2, z4);
        e eVar = new e(charSequence, i3, i5, aVar);
        return eVar;
    }

    private static final h<f> q0(java.lang.CharSequence charSequence, String[] string2Arr2, int i3, boolean z4, int i5) {
        v.z0(i5);
        v.b bVar = new v.b(i.d(string2Arr2), z4);
        e eVar = new e(charSequence, i3, i5, bVar);
        return eVar;
    }

    static h r0(java.lang.CharSequence charSequence, char[] c2Arr2, int i3, boolean z4, int i5, int i6, Object object7) {
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
        return v.p0(charSequence, c2Arr2, obj3, obj4, obj5);
    }

    static h s0(java.lang.CharSequence charSequence, String[] string2Arr2, int i3, boolean z4, int i5, int i6, Object object7) {
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
        return v.q0(charSequence, string2Arr2, obj3, obj4, obj5);
    }

    public static final boolean t0(java.lang.CharSequence charSequence, int i2, java.lang.CharSequence charSequence3, int i4, int i5, boolean z6) {
        int i3;
        int i;
        boolean z;
        char charAt;
        n.f(charSequence, "$this$regionMatchesImpl");
        n.f(charSequence3, "other");
        int i6 = 0;
        if (i4 >= 0 && i2 >= 0 && i2 <= length -= i5) {
            if (i2 >= 0) {
                if (i2 <= length -= i5) {
                    if (i4 > length2 -= i5) {
                    } else {
                        i = i6;
                        while (i < i5) {
                            i++;
                        }
                    }
                    return 1;
                }
            }
        }
        return i6;
    }

    public static String u0(String string, java.lang.CharSequence charSequence2) {
        Object obj3;
        Object obj4;
        n.f(string, "$this$removePrefix");
        n.f(charSequence2, "prefix");
        if (v.K0(string, charSequence2, false, 2, 0)) {
            n.e(string.substring(charSequence2.length()), "(this as java.lang.String).substring(startIndex)");
        }
        return obj3;
    }

    public static String v0(String string, java.lang.CharSequence charSequence2) {
        boolean z;
        Object obj3;
        Object obj4;
        n.f(string, "$this$removeSuffix");
        n.f(charSequence2, "suffix");
        int i = 0;
        if (v.V(string, charSequence2, i, 2, 0)) {
            n.e(string.substring(i, length -= obj4), "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return obj3;
    }

    public static String w0(String string, java.lang.CharSequence charSequence2) {
        n.f(string, "$this$removeSurrounding");
        n.f(charSequence2, "delimiter");
        return v.x0(string, charSequence2, charSequence2);
    }

    public static final String x0(String string, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        int length;
        int i;
        int length2;
        boolean z;
        Object obj4;
        Object obj5;
        Object obj6;
        n.f(string, "$this$removeSurrounding");
        n.f(charSequence2, "prefix");
        n.f(charSequence3, "suffix");
        length = 0;
        i = 2;
        length2 = 0;
        if (string.length() >= length4 += length2 && v.K0(string, charSequence2, length, i, length2) && v.V(string, charSequence3, length, i, length2)) {
            length = 0;
            i = 2;
            length2 = 0;
            if (v.K0(string, charSequence2, length, i, length2)) {
                if (v.V(string, charSequence3, length, i, length2)) {
                    n.e(string.substring(charSequence2.length(), length3 -= obj6), "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        return obj4;
    }

    public static final java.lang.CharSequence y0(java.lang.CharSequence charSequence, int i2, int i3, java.lang.CharSequence charSequence4) {
        n.f(charSequence, "$this$replaceRange");
        n.f(charSequence4, "replacement");
        if (i3 < i2) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(charSequence, 0, i2);
            String obj3 = "this.append(value, startIndex, endIndex)";
            n.e(stringBuilder, obj3);
            stringBuilder.append(charSequence4);
            stringBuilder.append(charSequence, i3, charSequence.length());
            n.e(stringBuilder, obj3);
            return stringBuilder;
        }
        StringBuilder obj5 = new StringBuilder();
        obj5.append("End index (");
        obj5.append(i3);
        obj5.append(") is less than start index (");
        obj5.append(i2);
        obj5.append(").");
        IndexOutOfBoundsException obj2 = new IndexOutOfBoundsException(obj5.toString());
        throw obj2;
    }

    public static final void z0(int i) {
        int i2;
        i2 = i >= 0 ? 1 : 0;
        if (i2 == 0) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Limit must be non-negative, but was ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
        throw illegalArgumentException;
    }
}
