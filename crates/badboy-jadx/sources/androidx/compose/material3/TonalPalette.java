package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0003\u0008±\u0001\u0008\u0000\u0018\u00002\u00020\u0001B½\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u0003\u0012\u0006\u00105\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u00020\u0003\u0012\u0006\u00107\u001a\u00020\u0003\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u00109\u001a\u00020\u0003\u0012\u0006\u0010:\u001a\u00020\u0003\u0012\u0006\u0010;\u001a\u00020\u0003\u0012\u0006\u0010<\u001a\u00020\u0003\u0012\u0006\u0010=\u001a\u00020\u0003\u0012\u0006\u0010>\u001a\u00020\u0003\u0012\u0006\u0010?\u001a\u00020\u0003\u0012\u0006\u0010@\u001a\u00020\u0003\u0012\u0006\u0010A\u001a\u00020\u0003\u0012\u0006\u0010B\u001a\u00020\u0003\u0012\u0006\u0010C\u001a\u00020\u0003\u0012\u0006\u0010D\u001a\u00020\u0003\u0012\u0006\u0010E\u001a\u00020\u0003\u0012\u0006\u0010F\u001a\u00020\u0003\u0012\u0006\u0010G\u001a\u00020\u0003\u0012\u0006\u0010H\u001a\u00020\u0003\u0012\u0006\u0010I\u001a\u00020\u0003\u0012\u0006\u0010J\u001a\u00020\u0003\u0012\u0006\u0010K\u001a\u00020\u0003\u0012\u0006\u0010L\u001a\u00020\u0003\u0012\u0006\u0010M\u001a\u00020\u0003\u0012\u0006\u0010N\u001a\u00020\u0003\u0012\u0006\u0010O\u001a\u00020\u0003\u0012\u0006\u0010P\u001a\u00020\u0003\u0012\u0006\u0010Q\u001a\u00020\u0003\u0012\u0006\u0010R\u001a\u00020\u0003\u0012\u0006\u0010S\u001a\u00020\u0003\u0012\u0006\u0010T\u001a\u00020\u0003\u0012\u0006\u0010U\u001a\u00020\u0003\u0012\u0006\u0010V\u001a\u00020\u0003\u0012\u0006\u0010W\u001a\u00020\u0003\u0012\u0006\u0010X\u001a\u00020\u0003\u0012\u0006\u0010Y\u001a\u00020\u0003¢\u0006\u0002\u0010ZR\u0019\u0010\u001a\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008[\u0010\\R\u0019\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008^\u0010\\R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008_\u0010\\R\u0019\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008`\u0010\\R\u0019\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008a\u0010\\R\u0019\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008b\u0010\\R\u0019\u0010\u0013\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008c\u0010\\R\u0019\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008d\u0010\\R\u0019\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008e\u0010\\R\u0019\u0010\u0019\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008f\u0010\\R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008g\u0010\\R\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008h\u0010\\R\u0019\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008i\u0010\\R\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008j\u0010\\R\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008k\u0010\\R\u0019\u0010\u000c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008l\u0010\\R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008m\u0010\\R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008n\u0010\\R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008o\u0010\\R\u0019\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008p\u0010\\R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008q\u0010\\R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008r\u0010\\R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008s\u0010\\R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008t\u0010\\R\u0019\u00102\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008u\u0010\\R\u0019\u0010/\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008v\u0010\\R\u0019\u0010\u001b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008w\u0010\\R\u0019\u0010.\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008x\u0010\\R\u0019\u0010-\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008y\u0010\\R\u0019\u0010,\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008z\u0010\\R\u0019\u0010+\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008{\u0010\\R\u0019\u0010*\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008|\u0010\\R\u0019\u0010)\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008}\u0010\\R\u0019\u00101\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008~\u0010\\R\u0019\u0010(\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010]\u001a\u0004\u0008\u007f\u0010\\R\u001a\u0010'\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0080\u0001\u0010\\R\u001a\u00100\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0081\u0001\u0010\\R\u001a\u0010&\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0082\u0001\u0010\\R\u001a\u0010%\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0083\u0001\u0010\\R\u001a\u0010$\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0084\u0001\u0010\\R\u001a\u0010#\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0085\u0001\u0010\\R\u001a\u0010\"\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0086\u0001\u0010\\R\u001a\u0010!\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0087\u0001\u0010\\R\u001a\u0010 \u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0088\u0001\u0010\\R\u001a\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0089\u0001\u0010\\R\u001a\u0010\u001e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u008a\u0001\u0010\\R\u001a\u0010\u001d\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u008b\u0001\u0010\\R\u001a\u0010\u001c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u008c\u0001\u0010\\R\u001a\u0010?\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u008d\u0001\u0010\\R\u001a\u0010>\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u008e\u0001\u0010\\R\u001a\u00103\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u008f\u0001\u0010\\R\u001a\u0010=\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0090\u0001\u0010\\R\u001a\u0010<\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0091\u0001\u0010\\R\u001a\u0010;\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0092\u0001\u0010\\R\u001a\u0010:\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0093\u0001\u0010\\R\u001a\u00109\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0094\u0001\u0010\\R\u001a\u00108\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0095\u0001\u0010\\R\u001a\u00107\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0096\u0001\u0010\\R\u001a\u00106\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0097\u0001\u0010\\R\u001a\u00105\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0098\u0001\u0010\\R\u001a\u00104\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u0099\u0001\u0010\\R\u001a\u0010L\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u009a\u0001\u0010\\R\u001a\u0010K\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u009b\u0001\u0010\\R\u001a\u0010@\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u009c\u0001\u0010\\R\u001a\u0010J\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u009d\u0001\u0010\\R\u001a\u0010I\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u009e\u0001\u0010\\R\u001a\u0010H\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008\u009f\u0001\u0010\\R\u001a\u0010G\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008 \u0001\u0010\\R\u001a\u0010F\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008¡\u0001\u0010\\R\u001a\u0010E\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008¢\u0001\u0010\\R\u001a\u0010D\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008£\u0001\u0010\\R\u001a\u0010C\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008¤\u0001\u0010\\R\u001a\u0010B\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008¥\u0001\u0010\\R\u001a\u0010A\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008¦\u0001\u0010\\R\u001a\u0010Y\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008§\u0001\u0010\\R\u001a\u0010X\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008¨\u0001\u0010\\R\u001a\u0010M\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008©\u0001\u0010\\R\u001a\u0010W\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008ª\u0001\u0010\\R\u001a\u0010V\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008«\u0001\u0010\\R\u001a\u0010U\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008¬\u0001\u0010\\R\u001a\u0010T\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008­\u0001\u0010\\R\u001a\u0010S\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008®\u0001\u0010\\R\u001a\u0010R\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008¯\u0001\u0010\\R\u001a\u0010Q\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008°\u0001\u0010\\R\u001a\u0010P\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008±\u0001\u0010\\R\u001a\u0010O\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008²\u0001\u0010\\R\u001a\u0010N\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010]\u001a\u0005\u0008³\u0001\u0010\\\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006´\u0001", d2 = {"Landroidx/compose/material3/TonalPalette;", "", "neutral100", "Landroidx/compose/ui/graphics/Color;", "neutral99", "neutral98", "neutral96", "neutral95", "neutral94", "neutral92", "neutral90", "neutral87", "neutral80", "neutral70", "neutral60", "neutral50", "neutral40", "neutral30", "neutral24", "neutral22", "neutral20", "neutral17", "neutral12", "neutral10", "neutral6", "neutral4", "neutral0", "neutralVariant100", "neutralVariant99", "neutralVariant98", "neutralVariant96", "neutralVariant95", "neutralVariant94", "neutralVariant92", "neutralVariant90", "neutralVariant87", "neutralVariant80", "neutralVariant70", "neutralVariant60", "neutralVariant50", "neutralVariant40", "neutralVariant30", "neutralVariant24", "neutralVariant22", "neutralVariant20", "neutralVariant17", "neutralVariant12", "neutralVariant10", "neutralVariant6", "neutralVariant4", "neutralVariant0", "primary100", "primary99", "primary95", "primary90", "primary80", "primary70", "primary60", "primary50", "primary40", "primary30", "primary20", "primary10", "primary0", "secondary100", "secondary99", "secondary95", "secondary90", "secondary80", "secondary70", "secondary60", "secondary50", "secondary40", "secondary30", "secondary20", "secondary10", "secondary0", "tertiary100", "tertiary99", "tertiary95", "tertiary90", "tertiary80", "tertiary70", "tertiary60", "tertiary50", "tertiary40", "tertiary30", "tertiary20", "tertiary10", "tertiary0", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getNeutral0-0d7_KjU", "()J", "J", "getNeutral10-0d7_KjU", "getNeutral100-0d7_KjU", "getNeutral12-0d7_KjU", "getNeutral17-0d7_KjU", "getNeutral20-0d7_KjU", "getNeutral22-0d7_KjU", "getNeutral24-0d7_KjU", "getNeutral30-0d7_KjU", "getNeutral4-0d7_KjU", "getNeutral40-0d7_KjU", "getNeutral50-0d7_KjU", "getNeutral6-0d7_KjU", "getNeutral60-0d7_KjU", "getNeutral70-0d7_KjU", "getNeutral80-0d7_KjU", "getNeutral87-0d7_KjU", "getNeutral90-0d7_KjU", "getNeutral92-0d7_KjU", "getNeutral94-0d7_KjU", "getNeutral95-0d7_KjU", "getNeutral96-0d7_KjU", "getNeutral98-0d7_KjU", "getNeutral99-0d7_KjU", "getNeutralVariant0-0d7_KjU", "getNeutralVariant10-0d7_KjU", "getNeutralVariant100-0d7_KjU", "getNeutralVariant12-0d7_KjU", "getNeutralVariant17-0d7_KjU", "getNeutralVariant20-0d7_KjU", "getNeutralVariant22-0d7_KjU", "getNeutralVariant24-0d7_KjU", "getNeutralVariant30-0d7_KjU", "getNeutralVariant4-0d7_KjU", "getNeutralVariant40-0d7_KjU", "getNeutralVariant50-0d7_KjU", "getNeutralVariant6-0d7_KjU", "getNeutralVariant60-0d7_KjU", "getNeutralVariant70-0d7_KjU", "getNeutralVariant80-0d7_KjU", "getNeutralVariant87-0d7_KjU", "getNeutralVariant90-0d7_KjU", "getNeutralVariant92-0d7_KjU", "getNeutralVariant94-0d7_KjU", "getNeutralVariant95-0d7_KjU", "getNeutralVariant96-0d7_KjU", "getNeutralVariant98-0d7_KjU", "getNeutralVariant99-0d7_KjU", "getPrimary0-0d7_KjU", "getPrimary10-0d7_KjU", "getPrimary100-0d7_KjU", "getPrimary20-0d7_KjU", "getPrimary30-0d7_KjU", "getPrimary40-0d7_KjU", "getPrimary50-0d7_KjU", "getPrimary60-0d7_KjU", "getPrimary70-0d7_KjU", "getPrimary80-0d7_KjU", "getPrimary90-0d7_KjU", "getPrimary95-0d7_KjU", "getPrimary99-0d7_KjU", "getSecondary0-0d7_KjU", "getSecondary10-0d7_KjU", "getSecondary100-0d7_KjU", "getSecondary20-0d7_KjU", "getSecondary30-0d7_KjU", "getSecondary40-0d7_KjU", "getSecondary50-0d7_KjU", "getSecondary60-0d7_KjU", "getSecondary70-0d7_KjU", "getSecondary80-0d7_KjU", "getSecondary90-0d7_KjU", "getSecondary95-0d7_KjU", "getSecondary99-0d7_KjU", "getTertiary0-0d7_KjU", "getTertiary10-0d7_KjU", "getTertiary100-0d7_KjU", "getTertiary20-0d7_KjU", "getTertiary30-0d7_KjU", "getTertiary40-0d7_KjU", "getTertiary50-0d7_KjU", "getTertiary60-0d7_KjU", "getTertiary70-0d7_KjU", "getTertiary80-0d7_KjU", "getTertiary90-0d7_KjU", "getTertiary95-0d7_KjU", "getTertiary99-0d7_KjU", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TonalPalette {

    public static final int $stable;
    private final long neutral0;
    private final long neutral10;
    private final long neutral100;
    private final long neutral12;
    private final long neutral17;
    private final long neutral20;
    private final long neutral22;
    private final long neutral24;
    private final long neutral30;
    private final long neutral4;
    private final long neutral40;
    private final long neutral50;
    private final long neutral6;
    private final long neutral60;
    private final long neutral70;
    private final long neutral80;
    private final long neutral87;
    private final long neutral90;
    private final long neutral92;
    private final long neutral94;
    private final long neutral95;
    private final long neutral96;
    private final long neutral98;
    private final long neutral99;
    private final long neutralVariant0;
    private final long neutralVariant10;
    private final long neutralVariant100;
    private final long neutralVariant12;
    private final long neutralVariant17;
    private final long neutralVariant20;
    private final long neutralVariant22;
    private final long neutralVariant24;
    private final long neutralVariant30;
    private final long neutralVariant4;
    private final long neutralVariant40;
    private final long neutralVariant50;
    private final long neutralVariant6;
    private final long neutralVariant60;
    private final long neutralVariant70;
    private final long neutralVariant80;
    private final long neutralVariant87;
    private final long neutralVariant90;
    private final long neutralVariant92;
    private final long neutralVariant94;
    private final long neutralVariant95;
    private final long neutralVariant96;
    private final long neutralVariant98;
    private final long neutralVariant99;
    private final long primary0;
    private final long primary10;
    private final long primary100;
    private final long primary20;
    private final long primary30;
    private final long primary40;
    private final long primary50;
    private final long primary60;
    private final long primary70;
    private final long primary80;
    private final long primary90;
    private final long primary95;
    private final long primary99;
    private final long secondary0;
    private final long secondary10;
    private final long secondary100;
    private final long secondary20;
    private final long secondary30;
    private final long secondary40;
    private final long secondary50;
    private final long secondary60;
    private final long secondary70;
    private final long secondary80;
    private final long secondary90;
    private final long secondary95;
    private final long secondary99;
    private final long tertiary0;
    private final long tertiary10;
    private final long tertiary100;
    private final long tertiary20;
    private final long tertiary30;
    private final long tertiary40;
    private final long tertiary50;
    private final long tertiary60;
    private final long tertiary70;
    private final long tertiary80;
    private final long tertiary90;
    private final long tertiary95;
    private final long tertiary99;
    static {
    }

    private TonalPalette(long neutral100, long neutral99, long neutral98, long neutral96, long neutral95, long neutral94, long neutral92, long neutral90, long neutral87, long neutral80, long neutral70, long neutral60, long neutral50, long neutral40, long neutral30, long neutral24, long neutral22, long neutral20, long neutral17, long neutral12, long neutral10, long neutral6, long neutral4, long neutral0, long neutralVariant100, long neutralVariant99, long neutralVariant98, long neutralVariant96, long neutralVariant95, long neutralVariant94, long neutralVariant92, long neutralVariant90, long neutralVariant87, long neutralVariant80, long neutralVariant70, long neutralVariant60, long neutralVariant50, long neutralVariant40, long neutralVariant30, long neutralVariant24, long neutralVariant22, long neutralVariant20, long neutralVariant17, long neutralVariant12, long neutralVariant10, long neutralVariant6, long neutralVariant4, long neutralVariant0, long primary100, long primary99, long primary95, long primary90, long primary80, long primary70, long primary60, long primary50, long primary40, long primary30, long primary20, long primary10, long primary0, long secondary100, long secondary99, long secondary95, long secondary90, long secondary80, long secondary70, long secondary60, long secondary50, long secondary40, long secondary30, long secondary20, long secondary10, long secondary0, long tertiary100, long tertiary99, long tertiary95, long tertiary90, long tertiary80, long tertiary70, long tertiary60, long tertiary50, long tertiary40, long tertiary30, long tertiary20, long tertiary10, long tertiary0) {
        super();
        this.neutral100 = neutral100;
        this.neutral99 = neutral98;
        this.neutral98 = neutral95;
        this.neutral96 = neutral92;
        this.neutral95 = neutral87;
        this.neutral94 = neutral70;
        this.neutral92 = neutral50;
        this.neutral90 = neutral30;
        this.neutral87 = neutral22;
        this.neutral80 = neutral17;
        this.neutral70 = neutral10;
        this.neutral60 = neutral4;
        this.neutral50 = neutralVariant100;
        this.neutral40 = neutralVariant98;
        this.neutral30 = neutralVariant95;
        this.neutral24 = neutralVariant92;
        this.neutral22 = neutralVariant87;
        this.neutral20 = neutralVariant70;
        this.neutral17 = neutralVariant50;
        this.neutral12 = neutralVariant30;
        this.neutral10 = neutralVariant22;
        this.neutral6 = neutralVariant17;
        this.neutral4 = neutralVariant10;
        this.neutral0 = neutralVariant4;
        this.neutralVariant100 = primary100;
        this.neutralVariant99 = primary95;
        this.neutralVariant98 = primary80;
        this.neutralVariant96 = primary60;
        this.neutralVariant95 = primary40;
        this.neutralVariant94 = primary20;
        this.neutralVariant92 = primary0;
        this.neutralVariant90 = secondary99;
        this.neutralVariant87 = secondary90;
        this.neutralVariant80 = secondary70;
        this.neutralVariant70 = secondary50;
        this.neutralVariant60 = secondary30;
        this.neutralVariant50 = secondary10;
        this.neutralVariant40 = tertiary100;
        this.neutralVariant30 = tertiary95;
        this.neutralVariant24 = tertiary80;
        this.neutralVariant22 = tertiary60;
        this.neutralVariant20 = tertiary40;
        this.neutralVariant17 = tertiary20;
        this.neutralVariant12 = tertiary0;
        this.neutralVariant10 = obj103;
        this.neutralVariant6 = obj105;
        this.neutralVariant4 = obj107;
        this.neutralVariant0 = obj109;
        this.primary100 = obj111;
        this.primary99 = obj113;
        this.primary95 = obj115;
        this.primary90 = obj117;
        this.primary80 = obj119;
        this.primary70 = obj121;
        this.primary60 = obj123;
        this.primary50 = obj125;
        this.primary40 = obj127;
        this.primary30 = obj129;
        this.primary20 = obj131;
        this.primary10 = obj133;
        this.primary0 = obj135;
        this.secondary100 = obj137;
        this.secondary99 = obj139;
        this.secondary95 = obj141;
        this.secondary90 = obj143;
        this.secondary80 = obj145;
        this.secondary70 = obj147;
        this.secondary60 = obj149;
        this.secondary50 = obj151;
        this.secondary40 = obj153;
        this.secondary30 = obj155;
        this.secondary20 = obj157;
        this.secondary10 = obj159;
        this.secondary0 = obj161;
        this.tertiary100 = obj163;
        this.tertiary99 = obj165;
        this.tertiary95 = obj167;
        this.tertiary90 = obj169;
        this.tertiary80 = obj171;
        this.tertiary70 = obj173;
        this.tertiary60 = obj175;
        this.tertiary50 = obj177;
        this.tertiary40 = obj179;
        this.tertiary30 = obj181;
        this.tertiary20 = obj183;
        this.tertiary10 = obj185;
        this.tertiary0 = obj187;
    }

    public TonalPalette(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, long l26, long l27, long l28, long l29, long l30, long l31, long l32, long l33, long l34, long l35, long l36, long l37, long l38, long l39, long l40, long l41, long l42, long l43, long l44, long l45, long l46, long l47, long l48, long l49, long l50, long l51, long l52, long l53, long l54, long l55, long l56, long l57, long l58, long l59, long l60, long l61, long l62, long l63, long l64, long l65, long l66, long l67, long l68, long l69, long l70, long l71, long l72, long l73, long l74, long l75, long l76, long l77, long l78, long l79, long l80, long l81, long l82, long l83, long l84, long l85, long l86, long l87, DefaultConstructorMarker defaultConstructorMarker88) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35, l36, l37, l38, l39, l40, l41, l42, l43, l44, l45, l46, l47, l48, l49, l50, l51, l52, l53, l54, l55, l56, l57, l58, l59, l60, l61, l62, l63, l64, l65, l66, l67, l68, l69, l70, l71, l72, l73, l74, l75, l76, l77, l78, l79, l80, l81, l82, l83, l84, l85, l86, l87, defaultConstructorMarker88, obj89, obj90, obj91, obj92, obj93, obj94, obj95, obj96, obj97, obj98, obj99, obj100, obj101, obj102, obj103, obj104, obj105, obj106, obj107, obj108, obj109, obj110, obj111, obj112, obj113, obj114, obj115, obj116, obj117, obj118, obj119, obj120, obj121, obj122, obj123, obj124, obj125, obj126, obj127, obj128, obj129, obj130, obj131, obj132, obj133, obj134, obj135, obj136, obj137, obj138, obj139, obj140, obj141, obj142, obj143, obj144, obj145, obj146, obj147, obj148, obj149, obj150, obj151, obj152, obj153, obj154, obj155, obj156, obj157, obj158, obj159, obj160, obj161, obj162, obj163, obj164, obj165, obj166, obj167, obj168, obj169, obj170, obj171, obj172, obj173, obj174);
    }

    public final long getNeutral0-0d7_KjU() {
        return this.neutral0;
    }

    public final long getNeutral10-0d7_KjU() {
        return this.neutral10;
    }

    public final long getNeutral100-0d7_KjU() {
        return this.neutral100;
    }

    public final long getNeutral12-0d7_KjU() {
        return this.neutral12;
    }

    public final long getNeutral17-0d7_KjU() {
        return this.neutral17;
    }

    public final long getNeutral20-0d7_KjU() {
        return this.neutral20;
    }

    public final long getNeutral22-0d7_KjU() {
        return this.neutral22;
    }

    public final long getNeutral24-0d7_KjU() {
        return this.neutral24;
    }

    public final long getNeutral30-0d7_KjU() {
        return this.neutral30;
    }

    public final long getNeutral4-0d7_KjU() {
        return this.neutral4;
    }

    public final long getNeutral40-0d7_KjU() {
        return this.neutral40;
    }

    public final long getNeutral50-0d7_KjU() {
        return this.neutral50;
    }

    public final long getNeutral6-0d7_KjU() {
        return this.neutral6;
    }

    public final long getNeutral60-0d7_KjU() {
        return this.neutral60;
    }

    public final long getNeutral70-0d7_KjU() {
        return this.neutral70;
    }

    public final long getNeutral80-0d7_KjU() {
        return this.neutral80;
    }

    public final long getNeutral87-0d7_KjU() {
        return this.neutral87;
    }

    public final long getNeutral90-0d7_KjU() {
        return this.neutral90;
    }

    public final long getNeutral92-0d7_KjU() {
        return this.neutral92;
    }

    public final long getNeutral94-0d7_KjU() {
        return this.neutral94;
    }

    public final long getNeutral95-0d7_KjU() {
        return this.neutral95;
    }

    public final long getNeutral96-0d7_KjU() {
        return this.neutral96;
    }

    public final long getNeutral98-0d7_KjU() {
        return this.neutral98;
    }

    public final long getNeutral99-0d7_KjU() {
        return this.neutral99;
    }

    public final long getNeutralVariant0-0d7_KjU() {
        return this.neutralVariant0;
    }

    public final long getNeutralVariant10-0d7_KjU() {
        return this.neutralVariant10;
    }

    public final long getNeutralVariant100-0d7_KjU() {
        return this.neutralVariant100;
    }

    public final long getNeutralVariant12-0d7_KjU() {
        return this.neutralVariant12;
    }

    public final long getNeutralVariant17-0d7_KjU() {
        return this.neutralVariant17;
    }

    public final long getNeutralVariant20-0d7_KjU() {
        return this.neutralVariant20;
    }

    public final long getNeutralVariant22-0d7_KjU() {
        return this.neutralVariant22;
    }

    public final long getNeutralVariant24-0d7_KjU() {
        return this.neutralVariant24;
    }

    public final long getNeutralVariant30-0d7_KjU() {
        return this.neutralVariant30;
    }

    public final long getNeutralVariant4-0d7_KjU() {
        return this.neutralVariant4;
    }

    public final long getNeutralVariant40-0d7_KjU() {
        return this.neutralVariant40;
    }

    public final long getNeutralVariant50-0d7_KjU() {
        return this.neutralVariant50;
    }

    public final long getNeutralVariant6-0d7_KjU() {
        return this.neutralVariant6;
    }

    public final long getNeutralVariant60-0d7_KjU() {
        return this.neutralVariant60;
    }

    public final long getNeutralVariant70-0d7_KjU() {
        return this.neutralVariant70;
    }

    public final long getNeutralVariant80-0d7_KjU() {
        return this.neutralVariant80;
    }

    public final long getNeutralVariant87-0d7_KjU() {
        return this.neutralVariant87;
    }

    public final long getNeutralVariant90-0d7_KjU() {
        return this.neutralVariant90;
    }

    public final long getNeutralVariant92-0d7_KjU() {
        return this.neutralVariant92;
    }

    public final long getNeutralVariant94-0d7_KjU() {
        return this.neutralVariant94;
    }

    public final long getNeutralVariant95-0d7_KjU() {
        return this.neutralVariant95;
    }

    public final long getNeutralVariant96-0d7_KjU() {
        return this.neutralVariant96;
    }

    public final long getNeutralVariant98-0d7_KjU() {
        return this.neutralVariant98;
    }

    public final long getNeutralVariant99-0d7_KjU() {
        return this.neutralVariant99;
    }

    public final long getPrimary0-0d7_KjU() {
        return this.primary0;
    }

    public final long getPrimary10-0d7_KjU() {
        return this.primary10;
    }

    public final long getPrimary100-0d7_KjU() {
        return this.primary100;
    }

    public final long getPrimary20-0d7_KjU() {
        return this.primary20;
    }

    public final long getPrimary30-0d7_KjU() {
        return this.primary30;
    }

    public final long getPrimary40-0d7_KjU() {
        return this.primary40;
    }

    public final long getPrimary50-0d7_KjU() {
        return this.primary50;
    }

    public final long getPrimary60-0d7_KjU() {
        return this.primary60;
    }

    public final long getPrimary70-0d7_KjU() {
        return this.primary70;
    }

    public final long getPrimary80-0d7_KjU() {
        return this.primary80;
    }

    public final long getPrimary90-0d7_KjU() {
        return this.primary90;
    }

    public final long getPrimary95-0d7_KjU() {
        return this.primary95;
    }

    public final long getPrimary99-0d7_KjU() {
        return this.primary99;
    }

    public final long getSecondary0-0d7_KjU() {
        return this.secondary0;
    }

    public final long getSecondary10-0d7_KjU() {
        return this.secondary10;
    }

    public final long getSecondary100-0d7_KjU() {
        return this.secondary100;
    }

    public final long getSecondary20-0d7_KjU() {
        return this.secondary20;
    }

    public final long getSecondary30-0d7_KjU() {
        return this.secondary30;
    }

    public final long getSecondary40-0d7_KjU() {
        return this.secondary40;
    }

    public final long getSecondary50-0d7_KjU() {
        return this.secondary50;
    }

    public final long getSecondary60-0d7_KjU() {
        return this.secondary60;
    }

    public final long getSecondary70-0d7_KjU() {
        return this.secondary70;
    }

    public final long getSecondary80-0d7_KjU() {
        return this.secondary80;
    }

    public final long getSecondary90-0d7_KjU() {
        return this.secondary90;
    }

    public final long getSecondary95-0d7_KjU() {
        return this.secondary95;
    }

    public final long getSecondary99-0d7_KjU() {
        return this.secondary99;
    }

    public final long getTertiary0-0d7_KjU() {
        return this.tertiary0;
    }

    public final long getTertiary10-0d7_KjU() {
        return this.tertiary10;
    }

    public final long getTertiary100-0d7_KjU() {
        return this.tertiary100;
    }

    public final long getTertiary20-0d7_KjU() {
        return this.tertiary20;
    }

    public final long getTertiary30-0d7_KjU() {
        return this.tertiary30;
    }

    public final long getTertiary40-0d7_KjU() {
        return this.tertiary40;
    }

    public final long getTertiary50-0d7_KjU() {
        return this.tertiary50;
    }

    public final long getTertiary60-0d7_KjU() {
        return this.tertiary60;
    }

    public final long getTertiary70-0d7_KjU() {
        return this.tertiary70;
    }

    public final long getTertiary80-0d7_KjU() {
        return this.tertiary80;
    }

    public final long getTertiary90-0d7_KjU() {
        return this.tertiary90;
    }

    public final long getTertiary95-0d7_KjU() {
        return this.tertiary95;
    }

    public final long getTertiary99-0d7_KjU() {
        return this.tertiary99;
    }
}
