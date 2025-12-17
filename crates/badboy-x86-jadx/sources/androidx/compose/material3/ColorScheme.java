package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008)\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\"\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u00082\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001Bï\u0001\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003¢\u0006\u0002\u0010 B¥\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0002\u0010(J·\u0002\u0010\u008f\u0002\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0006\u0008\u0090\u0002\u0010\u0091\u0002Jû\u0002\u0010\u008f\u0002\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00032\u0008\u0008\u0002\u0010!\u001a\u00020\u00032\u0008\u0008\u0002\u0010\"\u001a\u00020\u00032\u0008\u0008\u0002\u0010#\u001a\u00020\u00032\u0008\u0008\u0002\u0010$\u001a\u00020\u00032\u0008\u0008\u0002\u0010%\u001a\u00020\u00032\u0008\u0008\u0002\u0010&\u001a\u00020\u00032\u0008\u0008\u0002\u0010'\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0006\u0008\u0092\u0002\u0010\u0093\u0002J\n\u0010\u0094\u0002\u001a\u00030\u0095\u0002H\u0016R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010+\u001a\u0004\u0008)\u0010*R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008.\u0010/\"\u0004\u00080\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008:\u0010;\"\u0004\u0008<\u0010=R\"\u0010>\u001a\u0004\u0018\u00010?X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008@\u0010A\u001a\u0004\u0008B\u0010C\"\u0004\u0008D\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008H\u0010I\"\u0004\u0008J\u0010KR\"\u0010L\u001a\u0004\u0018\u00010MX\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008N\u0010A\u001a\u0004\u0008O\u0010P\"\u0004\u0008Q\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008T\u0010/\"\u0004\u0008U\u00101R\u001c\u0010V\u001a\u0004\u0018\u000103X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008W\u00105\"\u0004\u0008X\u00107R\u001c\u0010Y\u001a\u0004\u0018\u000109X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Z\u0010;\"\u0004\u0008[\u0010=R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008^\u0010_\"\u0004\u0008`\u0010aR\u001c\u0010b\u001a\u0004\u0018\u00010-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008c\u0010/\"\u0004\u0008d\u00101R\u001c\u0010e\u001a\u0004\u0018\u00010fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008g\u0010h\"\u0004\u0008i\u0010jR\u001c\u0010k\u001a\u0004\u0018\u00010lX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008m\u0010n\"\u0004\u0008o\u0010pR\u001c\u0010q\u001a\u0004\u0018\u00010rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008s\u0010t\"\u0004\u0008u\u0010vR\u001c\u0010w\u001a\u0004\u0018\u000103X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008x\u00105\"\u0004\u0008y\u00107R\u001c\u0010z\u001a\u0004\u0018\u00010lX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008{\u0010n\"\u0004\u0008|\u0010pR\u001c\u0010}\u001a\u0004\u0018\u00010rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008~\u0010t\"\u0004\u0008\u007f\u0010vR\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010]X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008\u0081\u0001\u0010_\"\u0005\u0008\u0082\u0001\u0010aR\u001f\u0010\u0083\u0001\u001a\u0004\u0018\u00010lX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008\u0084\u0001\u0010n\"\u0005\u0008\u0085\u0001\u0010pR\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010rX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008\u0087\u0001\u0010t\"\u0005\u0008\u0088\u0001\u0010vR\u001f\u0010\u0089\u0001\u001a\u0004\u0018\u00010]X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008\u008a\u0001\u0010_\"\u0005\u0008\u008b\u0001\u0010aR&\u0010\u008c\u0001\u001a\u0004\u0018\u00010?X\u0080\u000e¢\u0006\u0017\n\u0000\u0012\u0005\u0008\u008d\u0001\u0010A\u001a\u0005\u0008\u008e\u0001\u0010C\"\u0005\u0008\u008f\u0001\u0010ER&\u0010\u0090\u0001\u001a\u0004\u0018\u00010?X\u0080\u000e¢\u0006\u0017\n\u0000\u0012\u0005\u0008\u0091\u0001\u0010A\u001a\u0005\u0008\u0092\u0001\u0010C\"\u0005\u0008\u0093\u0001\u0010ER\"\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008\u0096\u0001\u0010\u0097\u0001\"\u0006\u0008\u0098\u0001\u0010\u0099\u0001R\"\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008\u009c\u0001\u0010\u009d\u0001\"\u0006\u0008\u009e\u0001\u0010\u009f\u0001R\"\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008¢\u0001\u0010£\u0001\"\u0006\u0008¤\u0001\u0010¥\u0001R\u001f\u0010¦\u0001\u001a\u0004\u0018\u000103X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008§\u0001\u00105\"\u0005\u0008¨\u0001\u00107R\u001f\u0010©\u0001\u001a\u0004\u0018\u000109X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008ª\u0001\u0010;\"\u0005\u0008«\u0001\u0010=R\u001f\u0010¬\u0001\u001a\u0004\u0018\u00010lX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008­\u0001\u0010n\"\u0005\u0008®\u0001\u0010pR\u001f\u0010¯\u0001\u001a\u0004\u0018\u00010rX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008°\u0001\u0010t\"\u0005\u0008±\u0001\u0010vR\"\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008´\u0001\u0010µ\u0001\"\u0006\u0008¶\u0001\u0010·\u0001R\"\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008º\u0001\u0010»\u0001\"\u0006\u0008¼\u0001\u0010½\u0001R)\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001X\u0080\u000e¢\u0006\u0019\n\u0000\u0012\u0005\u0008À\u0001\u0010A\u001a\u0006\u0008Á\u0001\u0010Â\u0001\"\u0006\u0008Ã\u0001\u0010Ä\u0001R)\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001X\u0080\u000e¢\u0006\u0019\n\u0000\u0012\u0005\u0008Ç\u0001\u0010A\u001a\u0006\u0008È\u0001\u0010É\u0001\"\u0006\u0008Ê\u0001\u0010Ë\u0001R\"\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008Î\u0001\u0010Ï\u0001\"\u0006\u0008Ð\u0001\u0010Ñ\u0001R\u001f\u0010Ò\u0001\u001a\u0004\u0018\u00010-X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008Ó\u0001\u0010/\"\u0005\u0008Ô\u0001\u00101R\"\u0010Õ\u0001\u001a\u0005\u0018\u00010Ö\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008×\u0001\u0010Ø\u0001\"\u0006\u0008Ù\u0001\u0010Ú\u0001R\u001f\u0010Û\u0001\u001a\u0004\u0018\u000103X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008Ü\u0001\u00105\"\u0005\u0008Ý\u0001\u00107R\"\u0010Þ\u0001\u001a\u0005\u0018\u00010³\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008ß\u0001\u0010µ\u0001\"\u0006\u0008à\u0001\u0010·\u0001R)\u0010á\u0001\u001a\u0005\u0018\u00010â\u0001X\u0080\u000e¢\u0006\u0019\n\u0000\u0012\u0005\u0008ã\u0001\u0010A\u001a\u0006\u0008ä\u0001\u0010å\u0001\"\u0006\u0008æ\u0001\u0010ç\u0001R&\u0010è\u0001\u001a\u0004\u0018\u00010?X\u0080\u000e¢\u0006\u0017\n\u0000\u0012\u0005\u0008é\u0001\u0010A\u001a\u0005\u0008ê\u0001\u0010C\"\u0005\u0008ë\u0001\u0010ER\u001a\u0010\u0019\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ì\u0001\u0010*R\u001a\u0010\u001b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008í\u0001\u0010*R\u001a\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008î\u0001\u0010*R\u001a\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ï\u0001\u0010*R\u001a\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ð\u0001\u0010*R\u001a\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ñ\u0001\u0010*R\u001a\u0010\u001a\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ò\u0001\u0010*R\u001a\u0010\u001c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ó\u0001\u0010*R\u001a\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ô\u0001\u0010*R\u001a\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008õ\u0001\u0010*R\u001a\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ö\u0001\u0010*R\u001a\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008÷\u0001\u0010*R\u001a\u0010\u0013\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ø\u0001\u0010*R\u001a\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ù\u0001\u0010*R\u001a\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ú\u0001\u0010*R\u001a\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008û\u0001\u0010*R\u001a\u0010\u001d\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ü\u0001\u0010*R\u001a\u0010\u001e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ý\u0001\u0010*R\u001a\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008þ\u0001\u0010*R\u001a\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008ÿ\u0001\u0010*R\u001a\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u0080\u0002\u0010*R\u001a\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u0081\u0002\u0010*R\u001a\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u0082\u0002\u0010*R\u001a\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u0083\u0002\u0010*R\u001a\u0010!\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u0084\u0002\u0010*R\u001a\u0010#\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u0085\u0002\u0010*R\u001a\u0010$\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u0086\u0002\u0010*R\u001a\u0010%\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u0087\u0002\u0010*R\u001a\u0010&\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u0088\u0002\u0010*R\u001a\u0010'\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u0089\u0002\u0010*R\u001a\u0010\"\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u008a\u0002\u0010*R\u001a\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u008b\u0002\u0010*R\u001a\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u008c\u0002\u0010*R\u001a\u0010\u000c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u008d\u0002\u0010*R\u001a\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\u0008\u008e\u0002\u0010*\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0096\u0002", d2 = {"Landroidx/compose/material3/ColorScheme;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "surfaceBright", "surfaceDim", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackground-0d7_KjU", "()J", "J", "defaultAssistChipColorsCached", "Landroidx/compose/material3/ChipColors;", "getDefaultAssistChipColorsCached$material3_release", "()Landroidx/compose/material3/ChipColors;", "setDefaultAssistChipColorsCached$material3_release", "(Landroidx/compose/material3/ChipColors;)V", "defaultButtonColorsCached", "Landroidx/compose/material3/ButtonColors;", "getDefaultButtonColorsCached$material3_release", "()Landroidx/compose/material3/ButtonColors;", "setDefaultButtonColorsCached$material3_release", "(Landroidx/compose/material3/ButtonColors;)V", "defaultCardColorsCached", "Landroidx/compose/material3/CardColors;", "getDefaultCardColorsCached$material3_release", "()Landroidx/compose/material3/CardColors;", "setDefaultCardColorsCached$material3_release", "(Landroidx/compose/material3/CardColors;)V", "defaultCenterAlignedTopAppBarColorsCached", "Landroidx/compose/material3/TopAppBarColors;", "getDefaultCenterAlignedTopAppBarColorsCached$material3_release$annotations", "()V", "getDefaultCenterAlignedTopAppBarColorsCached$material3_release", "()Landroidx/compose/material3/TopAppBarColors;", "setDefaultCenterAlignedTopAppBarColorsCached$material3_release", "(Landroidx/compose/material3/TopAppBarColors;)V", "defaultCheckboxColorsCached", "Landroidx/compose/material3/CheckboxColors;", "getDefaultCheckboxColorsCached$material3_release", "()Landroidx/compose/material3/CheckboxColors;", "setDefaultCheckboxColorsCached$material3_release", "(Landroidx/compose/material3/CheckboxColors;)V", "defaultDatePickerColorsCached", "Landroidx/compose/material3/DatePickerColors;", "getDefaultDatePickerColorsCached$material3_release$annotations", "getDefaultDatePickerColorsCached$material3_release", "()Landroidx/compose/material3/DatePickerColors;", "setDefaultDatePickerColorsCached$material3_release", "(Landroidx/compose/material3/DatePickerColors;)V", "defaultElevatedAssistChipColorsCached", "getDefaultElevatedAssistChipColorsCached$material3_release", "setDefaultElevatedAssistChipColorsCached$material3_release", "defaultElevatedButtonColorsCached", "getDefaultElevatedButtonColorsCached$material3_release", "setDefaultElevatedButtonColorsCached$material3_release", "defaultElevatedCardColorsCached", "getDefaultElevatedCardColorsCached$material3_release", "setDefaultElevatedCardColorsCached$material3_release", "defaultElevatedFilterChipColorsCached", "Landroidx/compose/material3/SelectableChipColors;", "getDefaultElevatedFilterChipColorsCached$material3_release", "()Landroidx/compose/material3/SelectableChipColors;", "setDefaultElevatedFilterChipColorsCached$material3_release", "(Landroidx/compose/material3/SelectableChipColors;)V", "defaultElevatedSuggestionChipColorsCached", "getDefaultElevatedSuggestionChipColorsCached$material3_release", "setDefaultElevatedSuggestionChipColorsCached$material3_release", "defaultExpressiveNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationItemColors;", "getDefaultExpressiveNavigationBarItemColorsCached$material3_release", "()Landroidx/compose/material3/NavigationItemColors;", "setDefaultExpressiveNavigationBarItemColorsCached$material3_release", "(Landroidx/compose/material3/NavigationItemColors;)V", "defaultFilledIconButtonColorsCached", "Landroidx/compose/material3/IconButtonColors;", "getDefaultFilledIconButtonColorsCached$material3_release", "()Landroidx/compose/material3/IconButtonColors;", "setDefaultFilledIconButtonColorsCached$material3_release", "(Landroidx/compose/material3/IconButtonColors;)V", "defaultFilledIconToggleButtonColorsCached", "Landroidx/compose/material3/IconToggleButtonColors;", "getDefaultFilledIconToggleButtonColorsCached$material3_release", "()Landroidx/compose/material3/IconToggleButtonColors;", "setDefaultFilledIconToggleButtonColorsCached$material3_release", "(Landroidx/compose/material3/IconToggleButtonColors;)V", "defaultFilledTonalButtonColorsCached", "getDefaultFilledTonalButtonColorsCached$material3_release", "setDefaultFilledTonalButtonColorsCached$material3_release", "defaultFilledTonalIconButtonColorsCached", "getDefaultFilledTonalIconButtonColorsCached$material3_release", "setDefaultFilledTonalIconButtonColorsCached$material3_release", "defaultFilledTonalIconToggleButtonColorsCached", "getDefaultFilledTonalIconToggleButtonColorsCached$material3_release", "setDefaultFilledTonalIconToggleButtonColorsCached$material3_release", "defaultFilterChipColorsCached", "getDefaultFilterChipColorsCached$material3_release", "setDefaultFilterChipColorsCached$material3_release", "defaultIconButtonColorsCached", "getDefaultIconButtonColorsCached$material3_release", "setDefaultIconButtonColorsCached$material3_release", "defaultIconToggleButtonColorsCached", "getDefaultIconToggleButtonColorsCached$material3_release", "setDefaultIconToggleButtonColorsCached$material3_release", "defaultInputChipColorsCached", "getDefaultInputChipColorsCached$material3_release", "setDefaultInputChipColorsCached$material3_release", "defaultLargeTopAppBarColorsCached", "getDefaultLargeTopAppBarColorsCached$material3_release$annotations", "getDefaultLargeTopAppBarColorsCached$material3_release", "setDefaultLargeTopAppBarColorsCached$material3_release", "defaultMediumTopAppBarColorsCached", "getDefaultMediumTopAppBarColorsCached$material3_release$annotations", "getDefaultMediumTopAppBarColorsCached$material3_release", "setDefaultMediumTopAppBarColorsCached$material3_release", "defaultMenuItemColorsCached", "Landroidx/compose/material3/MenuItemColors;", "getDefaultMenuItemColorsCached$material3_release", "()Landroidx/compose/material3/MenuItemColors;", "setDefaultMenuItemColorsCached$material3_release", "(Landroidx/compose/material3/MenuItemColors;)V", "defaultNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationBarItemColors;", "getDefaultNavigationBarItemColorsCached$material3_release", "()Landroidx/compose/material3/NavigationBarItemColors;", "setDefaultNavigationBarItemColorsCached$material3_release", "(Landroidx/compose/material3/NavigationBarItemColors;)V", "defaultNavigationRailItemColorsCached", "Landroidx/compose/material3/NavigationRailItemColors;", "getDefaultNavigationRailItemColorsCached$material3_release", "()Landroidx/compose/material3/NavigationRailItemColors;", "setDefaultNavigationRailItemColorsCached$material3_release", "(Landroidx/compose/material3/NavigationRailItemColors;)V", "defaultOutlinedButtonColorsCached", "getDefaultOutlinedButtonColorsCached$material3_release", "setDefaultOutlinedButtonColorsCached$material3_release", "defaultOutlinedCardColorsCached", "getDefaultOutlinedCardColorsCached$material3_release", "setDefaultOutlinedCardColorsCached$material3_release", "defaultOutlinedIconButtonColorsCached", "getDefaultOutlinedIconButtonColorsCached$material3_release", "setDefaultOutlinedIconButtonColorsCached$material3_release", "defaultOutlinedIconToggleButtonColorsCached", "getDefaultOutlinedIconToggleButtonColorsCached$material3_release", "setDefaultOutlinedIconToggleButtonColorsCached$material3_release", "defaultOutlinedTextFieldColorsCached", "Landroidx/compose/material3/TextFieldColors;", "getDefaultOutlinedTextFieldColorsCached$material3_release", "()Landroidx/compose/material3/TextFieldColors;", "setDefaultOutlinedTextFieldColorsCached$material3_release", "(Landroidx/compose/material3/TextFieldColors;)V", "defaultRadioButtonColorsCached", "Landroidx/compose/material3/RadioButtonColors;", "getDefaultRadioButtonColorsCached$material3_release", "()Landroidx/compose/material3/RadioButtonColors;", "setDefaultRadioButtonColorsCached$material3_release", "(Landroidx/compose/material3/RadioButtonColors;)V", "defaultRichTooltipColorsCached", "Landroidx/compose/material3/RichTooltipColors;", "getDefaultRichTooltipColorsCached$material3_release$annotations", "getDefaultRichTooltipColorsCached$material3_release", "()Landroidx/compose/material3/RichTooltipColors;", "setDefaultRichTooltipColorsCached$material3_release", "(Landroidx/compose/material3/RichTooltipColors;)V", "defaultSegmentedButtonColorsCached", "Landroidx/compose/material3/SegmentedButtonColors;", "getDefaultSegmentedButtonColorsCached$material3_release$annotations", "getDefaultSegmentedButtonColorsCached$material3_release", "()Landroidx/compose/material3/SegmentedButtonColors;", "setDefaultSegmentedButtonColorsCached$material3_release", "(Landroidx/compose/material3/SegmentedButtonColors;)V", "defaultSliderColorsCached", "Landroidx/compose/material3/SliderColors;", "getDefaultSliderColorsCached$material3_release", "()Landroidx/compose/material3/SliderColors;", "setDefaultSliderColorsCached$material3_release", "(Landroidx/compose/material3/SliderColors;)V", "defaultSuggestionChipColorsCached", "getDefaultSuggestionChipColorsCached$material3_release", "setDefaultSuggestionChipColorsCached$material3_release", "defaultSwitchColorsCached", "Landroidx/compose/material3/SwitchColors;", "getDefaultSwitchColorsCached$material3_release", "()Landroidx/compose/material3/SwitchColors;", "setDefaultSwitchColorsCached$material3_release", "(Landroidx/compose/material3/SwitchColors;)V", "defaultTextButtonColorsCached", "getDefaultTextButtonColorsCached$material3_release", "setDefaultTextButtonColorsCached$material3_release", "defaultTextFieldColorsCached", "getDefaultTextFieldColorsCached$material3_release", "setDefaultTextFieldColorsCached$material3_release", "defaultTimePickerColorsCached", "Landroidx/compose/material3/TimePickerColors;", "getDefaultTimePickerColorsCached$material3_release$annotations", "getDefaultTimePickerColorsCached$material3_release", "()Landroidx/compose/material3/TimePickerColors;", "setDefaultTimePickerColorsCached$material3_release", "(Landroidx/compose/material3/TimePickerColors;)V", "defaultTopAppBarColorsCached", "getDefaultTopAppBarColorsCached$material3_release$annotations", "getDefaultTopAppBarColorsCached$material3_release", "setDefaultTopAppBarColorsCached$material3_release", "getError-0d7_KjU", "getErrorContainer-0d7_KjU", "getInverseOnSurface-0d7_KjU", "getInversePrimary-0d7_KjU", "getInverseSurface-0d7_KjU", "getOnBackground-0d7_KjU", "getOnError-0d7_KjU", "getOnErrorContainer-0d7_KjU", "getOnPrimary-0d7_KjU", "getOnPrimaryContainer-0d7_KjU", "getOnSecondary-0d7_KjU", "getOnSecondaryContainer-0d7_KjU", "getOnSurface-0d7_KjU", "getOnSurfaceVariant-0d7_KjU", "getOnTertiary-0d7_KjU", "getOnTertiaryContainer-0d7_KjU", "getOutline-0d7_KjU", "getOutlineVariant-0d7_KjU", "getPrimary-0d7_KjU", "getPrimaryContainer-0d7_KjU", "getScrim-0d7_KjU", "getSecondary-0d7_KjU", "getSecondaryContainer-0d7_KjU", "getSurface-0d7_KjU", "getSurfaceBright-0d7_KjU", "getSurfaceContainer-0d7_KjU", "getSurfaceContainerHigh-0d7_KjU", "getSurfaceContainerHighest-0d7_KjU", "getSurfaceContainerLow-0d7_KjU", "getSurfaceContainerLowest-0d7_KjU", "getSurfaceDim-0d7_KjU", "getSurfaceTint-0d7_KjU", "getSurfaceVariant-0d7_KjU", "getTertiary-0d7_KjU", "getTertiaryContainer-0d7_KjU", "copy", "copy-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "copy-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ColorScheme {

    public static final int $stable;
    private final long background;
    private androidx.compose.material3.ChipColors defaultAssistChipColorsCached;
    private androidx.compose.material3.ButtonColors defaultButtonColorsCached;
    private androidx.compose.material3.CardColors defaultCardColorsCached;
    private androidx.compose.material3.TopAppBarColors defaultCenterAlignedTopAppBarColorsCached;
    private androidx.compose.material3.CheckboxColors defaultCheckboxColorsCached;
    private androidx.compose.material3.DatePickerColors defaultDatePickerColorsCached;
    private androidx.compose.material3.ChipColors defaultElevatedAssistChipColorsCached;
    private androidx.compose.material3.ButtonColors defaultElevatedButtonColorsCached;
    private androidx.compose.material3.CardColors defaultElevatedCardColorsCached;
    private androidx.compose.material3.SelectableChipColors defaultElevatedFilterChipColorsCached;
    private androidx.compose.material3.ChipColors defaultElevatedSuggestionChipColorsCached;
    private androidx.compose.material3.NavigationItemColors defaultExpressiveNavigationBarItemColorsCached;
    private androidx.compose.material3.IconButtonColors defaultFilledIconButtonColorsCached;
    private androidx.compose.material3.IconToggleButtonColors defaultFilledIconToggleButtonColorsCached;
    private androidx.compose.material3.ButtonColors defaultFilledTonalButtonColorsCached;
    private androidx.compose.material3.IconButtonColors defaultFilledTonalIconButtonColorsCached;
    private androidx.compose.material3.IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached;
    private androidx.compose.material3.SelectableChipColors defaultFilterChipColorsCached;
    private androidx.compose.material3.IconButtonColors defaultIconButtonColorsCached;
    private androidx.compose.material3.IconToggleButtonColors defaultIconToggleButtonColorsCached;
    private androidx.compose.material3.SelectableChipColors defaultInputChipColorsCached;
    private androidx.compose.material3.TopAppBarColors defaultLargeTopAppBarColorsCached;
    private androidx.compose.material3.TopAppBarColors defaultMediumTopAppBarColorsCached;
    private androidx.compose.material3.MenuItemColors defaultMenuItemColorsCached;
    private androidx.compose.material3.NavigationBarItemColors defaultNavigationBarItemColorsCached;
    private androidx.compose.material3.NavigationRailItemColors defaultNavigationRailItemColorsCached;
    private androidx.compose.material3.ButtonColors defaultOutlinedButtonColorsCached;
    private androidx.compose.material3.CardColors defaultOutlinedCardColorsCached;
    private androidx.compose.material3.IconButtonColors defaultOutlinedIconButtonColorsCached;
    private androidx.compose.material3.IconToggleButtonColors defaultOutlinedIconToggleButtonColorsCached;
    private androidx.compose.material3.TextFieldColors defaultOutlinedTextFieldColorsCached;
    private androidx.compose.material3.RadioButtonColors defaultRadioButtonColorsCached;
    private androidx.compose.material3.RichTooltipColors defaultRichTooltipColorsCached;
    private androidx.compose.material3.SegmentedButtonColors defaultSegmentedButtonColorsCached;
    private androidx.compose.material3.SliderColors defaultSliderColorsCached;
    private androidx.compose.material3.ChipColors defaultSuggestionChipColorsCached;
    private androidx.compose.material3.SwitchColors defaultSwitchColorsCached;
    private androidx.compose.material3.ButtonColors defaultTextButtonColorsCached;
    private androidx.compose.material3.TextFieldColors defaultTextFieldColorsCached;
    private androidx.compose.material3.TimePickerColors defaultTimePickerColorsCached;
    private androidx.compose.material3.TopAppBarColors defaultTopAppBarColorsCached;
    private final long error;
    private final long errorContainer;
    private final long inverseOnSurface;
    private final long inversePrimary;
    private final long inverseSurface;
    private final long onBackground;
    private final long onError;
    private final long onErrorContainer;
    private final long onPrimary;
    private final long onPrimaryContainer;
    private final long onSecondary;
    private final long onSecondaryContainer;
    private final long onSurface;
    private final long onSurfaceVariant;
    private final long onTertiary;
    private final long onTertiaryContainer;
    private final long outline;
    private final long outlineVariant;
    private final long primary;
    private final long primaryContainer;
    private final long scrim;
    private final long secondary;
    private final long secondaryContainer;
    private final long surface;
    private final long surfaceBright;
    private final long surfaceContainer;
    private final long surfaceContainerHigh;
    private final long surfaceContainerHighest;
    private final long surfaceContainerLow;
    private final long surfaceContainerLowest;
    private final long surfaceDim;
    private final long surfaceTint;
    private final long surfaceVariant;
    private final long tertiary;
    private final long tertiaryContainer;
    static {
    }

    private ColorScheme(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        super(primary, obj3, primaryContainer, obj5, inversePrimary, obj7, onSecondary, obj9, onSecondaryContainer, obj11, onTertiary, obj13, onTertiaryContainer, obj15, onBackground, obj17, onSurface, obj19, onSurfaceVariant, obj21, inverseSurface, obj23, error, obj25, errorContainer, obj27, outline, obj29, scrim, obj31, obj106, obj33, obj108, obj35, obj110, obj37, obj112, obj39, obj114, obj41, obj116, obj43, obj118, obj45, obj120, obj47, obj122, obj49, obj124, obj51, obj126, obj53, obj128, obj55, obj130, obj57, obj132, obj59, Color.Companion.getUnspecified-0d7_KjU(), obj61, Color.Companion.getUnspecified-0d7_KjU(), obj63, Color.Companion.getUnspecified-0d7_KjU(), obj65, Color.Companion.getUnspecified-0d7_KjU(), obj67, Color.Companion.getUnspecified-0d7_KjU(), obj69, Color.Companion.getUnspecified-0d7_KjU(), obj71, Color.Companion.getUnspecified-0d7_KjU(), obj73, 0);
    }

    private ColorScheme(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim, long surfaceBright, long surfaceDim, long surfaceContainer, long surfaceContainerHigh, long surfaceContainerHighest, long surfaceContainerLow, long surfaceContainerLowest) {
        super();
        this.primary = primary;
        this.onPrimary = primaryContainer;
        this.primaryContainer = inversePrimary;
        this.onPrimaryContainer = onSecondary;
        this.inversePrimary = onSecondaryContainer;
        this.secondary = onTertiary;
        this.onSecondary = onTertiaryContainer;
        this.secondaryContainer = onBackground;
        this.onSecondaryContainer = onSurface;
        this.tertiary = onSurfaceVariant;
        this.onTertiary = inverseSurface;
        this.tertiaryContainer = error;
        this.onTertiaryContainer = errorContainer;
        this.background = outline;
        this.onBackground = scrim;
        this.surface = surfaceDim;
        this.onSurface = surfaceContainerHigh;
        this.surfaceVariant = surfaceContainerLow;
        this.onSurfaceVariant = obj51;
        this.surfaceTint = obj53;
        this.inverseSurface = obj55;
        this.inverseOnSurface = obj57;
        this.error = obj59;
        this.onError = obj61;
        this.errorContainer = obj63;
        this.onErrorContainer = obj65;
        this.outline = obj67;
        this.outlineVariant = obj69;
        this.scrim = obj71;
        this.surfaceBright = obj73;
        this.surfaceDim = obj75;
        this.surfaceContainer = obj77;
        this.surfaceContainerHigh = obj79;
        this.surfaceContainerHighest = obj81;
        this.surfaceContainerLow = obj83;
        this.surfaceContainerLowest = obj85;
    }

    public ColorScheme(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, long l26, long l27, long l28, long l29, long l30, long l31, long l32, long l33, long l34, long l35, long l36, DefaultConstructorMarker defaultConstructorMarker37) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35, l36, defaultConstructorMarker37, obj38, obj39, obj40, obj41, obj42, obj43, obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55, obj56, obj57, obj58, obj59, obj60, obj61, obj62, obj63, obj64, obj65, obj66, obj67, obj68, obj69, obj70, obj71, obj72);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use constructor with additional 'surfaceContainer' roles.", replaceWith = @ReplaceWith(...))
    public ColorScheme(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, long l26, long l27, long l28, long l29, DefaultConstructorMarker defaultConstructorMarker30) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, l29, defaultConstructorMarker30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43, obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55, obj56, obj57, obj58);
    }

    public static androidx.compose.material3.ColorScheme copy-C-Xl9yA$default(androidx.compose.material3.ColorScheme colorScheme, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, long l26, long l27, long l28, long l29, long l30, long l31, long l32, long l33, long l34, long l35, long l36, long l37, int i38, int i39, Object object40) {
        long surface;
        long onSurface;
        long surfaceVariant;
        long onSurfaceVariant;
        long surfaceTint;
        long inverseSurface;
        long inverseOnSurface;
        long error;
        long onError;
        long errorContainer;
        long onErrorContainer;
        long outline;
        long outlineVariant;
        long scrim;
        long surfaceBright;
        long surfaceDim;
        long surfaceContainer;
        long surfaceContainerHigh;
        long surfaceContainerHighest;
        long surfaceContainerLow;
        long surfaceContainerLowest;
        long primary;
        long secondaryContainer;
        long onSecondaryContainer;
        long tertiary;
        long onTertiary;
        long tertiaryContainer;
        long onTertiaryContainer;
        long background;
        long onBackground;
        long onPrimary;
        long primaryContainer;
        long onPrimaryContainer;
        long inversePrimary;
        long secondary;
        long onSecondary;
        long obj34;
        long obj36;
        long obj38;
        long obj40;
        long obj42;
        long obj44;
        long obj46;
        long obj48;
        long obj50;
        long obj52;
        long obj54;
        long obj56;
        long obj58;
        long obj60;
        long obj62;
        long obj64;
        long obj66;
        long obj68;
        long obj70;
        long obj72;
        long obj74;
        Object obj = colorScheme;
        int i = obj92;
        primary = i & 1 != 0 ? obj.primary : l2;
        onPrimary = i & 2 != 0 ? obj.onPrimary : l4;
        primaryContainer = i & 4 != 0 ? obj.primaryContainer : l6;
        onPrimaryContainer = i & 8 != 0 ? obj.onPrimaryContainer : l8;
        inversePrimary = i & 16 != 0 ? obj.inversePrimary : l10;
        secondary = i & 32 != 0 ? obj.secondary : l12;
        onSecondary = i & 64 != 0 ? obj.onSecondary : l14;
        secondaryContainer = i & 128 != 0 ? obj.secondaryContainer : l16;
        onSecondaryContainer = i & 256 != 0 ? obj.onSecondaryContainer : l18;
        final long obj22 = onSecondaryContainer;
        tertiary = i & 512 != 0 ? obj.tertiary : l20;
        final long obj24 = tertiary;
        onTertiary = i & 1024 != 0 ? obj.onTertiary : l22;
        final long obj26 = onTertiary;
        tertiaryContainer = i & 2048 != 0 ? obj.tertiaryContainer : l24;
        final long obj28 = tertiaryContainer;
        onTertiaryContainer = i & 4096 != 0 ? obj.onTertiaryContainer : l26;
        final long obj30 = onTertiaryContainer;
        background = i & 8192 != 0 ? obj.background : l28;
        final long obj32 = background;
        onBackground = i & 16384 != 0 ? obj.onBackground : l30;
        surface = i & i55 != 0 ? obj.surface : l32;
        onSurface = obj92 & i11 != 0 ? obj.onSurface : l34;
        surfaceVariant = obj92 & i13 != 0 ? obj.surfaceVariant : l36;
        onSurfaceVariant = obj92 & i15 != 0 ? obj.onSurfaceVariant : i38;
        surfaceTint = obj92 & i17 != 0 ? obj.surfaceTint : object40;
        inverseSurface = obj92 & i19 != 0 ? obj.inverseSurface : obj60;
        inverseOnSurface = obj92 & i21 != 0 ? obj.inverseOnSurface : obj62;
        error = obj92 & i23 != 0 ? obj.error : obj64;
        onError = obj92 & i25 != 0 ? obj.onError : obj66;
        errorContainer = obj92 & i27 != 0 ? obj.errorContainer : obj68;
        onErrorContainer = obj92 & i29 != 0 ? obj.onErrorContainer : obj70;
        outline = obj92 & i31 != 0 ? obj.outline : obj72;
        outlineVariant = obj92 & i33 != 0 ? obj.outlineVariant : obj74;
        scrim = obj92 & i35 != 0 ? obj.scrim : obj76;
        surfaceBright = obj92 & i37 != 0 ? obj.surfaceBright : obj78;
        surfaceDim = obj92 & i41 != 0 ? obj.surfaceDim : obj80;
        surfaceContainer = obj92 & i43 != 0 ? obj.surfaceContainer : obj82;
        surfaceContainerHigh = obj93 & 1 != 0 ? obj.surfaceContainerHigh : obj84;
        surfaceContainerHighest = obj93 & 2 != 0 ? obj.surfaceContainerHighest : obj86;
        surfaceContainerLow = obj93 & 4 != 0 ? obj.surfaceContainerLow : obj88;
        surfaceContainerLowest = obj93 & 8 != 0 ? obj.surfaceContainerLowest : obj90;
        return obj.copy-C-Xl9yA(primary, obj22, onPrimary, obj24, primaryContainer, obj26, onPrimaryContainer, obj28, inversePrimary, obj30, secondary, obj32, onSecondary, obj34, secondaryContainer, obj36, obj22, obj38, obj24, obj40, obj26, obj42, obj28, obj44, obj30, obj46, obj32, obj48, obj34, obj50, obj36, obj52, obj38, obj54, obj40, obj56);
    }

    public static androidx.compose.material3.ColorScheme copy-G1PFc-w$default(androidx.compose.material3.ColorScheme colorScheme, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, long l26, long l27, long l28, long l29, long l30, int i31, Object object32) {
        long surface;
        long onSurface;
        long surfaceVariant;
        long onSurfaceVariant;
        long surfaceTint;
        long inverseSurface;
        long inverseOnSurface;
        long error;
        long onError;
        long errorContainer;
        long onErrorContainer;
        long outline;
        long outlineVariant;
        long scrim;
        long primary;
        long secondaryContainer;
        long onSecondaryContainer;
        long tertiary;
        long onTertiary;
        long tertiaryContainer;
        long onTertiaryContainer;
        long background;
        long onBackground;
        long onPrimary;
        long primaryContainer;
        long onPrimaryContainer;
        long inversePrimary;
        long secondary;
        long onSecondary;
        long obj34;
        long obj36;
        long obj38;
        long obj40;
        long obj42;
        long obj44;
        long obj46;
        long obj48;
        long obj50;
        long obj52;
        long obj54;
        long obj56;
        long obj58;
        long obj60;
        Object obj = colorScheme;
        int i = obj78;
        primary = i & 1 != 0 ? obj.primary : l2;
        onPrimary = i & 2 != 0 ? obj.onPrimary : l4;
        primaryContainer = i & 4 != 0 ? obj.primaryContainer : l6;
        onPrimaryContainer = i & 8 != 0 ? obj.onPrimaryContainer : l8;
        inversePrimary = i & 16 != 0 ? obj.inversePrimary : l10;
        secondary = i & 32 != 0 ? obj.secondary : l12;
        onSecondary = i & 64 != 0 ? obj.onSecondary : l14;
        secondaryContainer = i & 128 != 0 ? obj.secondaryContainer : l16;
        onSecondaryContainer = i & 256 != 0 ? obj.onSecondaryContainer : l18;
        final long obj22 = onSecondaryContainer;
        tertiary = i & 512 != 0 ? obj.tertiary : l20;
        final long obj24 = tertiary;
        onTertiary = i & 1024 != 0 ? obj.onTertiary : l22;
        final long obj26 = onTertiary;
        tertiaryContainer = i & 2048 != 0 ? obj.tertiaryContainer : l24;
        final long obj28 = tertiaryContainer;
        onTertiaryContainer = i & 4096 != 0 ? obj.onTertiaryContainer : l26;
        final long obj30 = onTertiaryContainer;
        background = i & 8192 != 0 ? obj.background : l28;
        final long obj32 = background;
        onBackground = i & 16384 != 0 ? obj.onBackground : l30;
        surface = i & i44 != 0 ? obj.surface : object32;
        onSurface = obj78 & i11 != 0 ? obj.onSurface : obj52;
        surfaceVariant = obj78 & i13 != 0 ? obj.surfaceVariant : obj54;
        onSurfaceVariant = obj78 & i15 != 0 ? obj.onSurfaceVariant : obj56;
        surfaceTint = obj78 & i17 != 0 ? obj.surfaceTint : obj58;
        inverseSurface = obj78 & i19 != 0 ? obj.inverseSurface : obj60;
        inverseOnSurface = obj78 & i21 != 0 ? obj.inverseOnSurface : obj62;
        error = obj78 & i23 != 0 ? obj.error : obj64;
        onError = obj78 & i25 != 0 ? obj.onError : obj66;
        errorContainer = obj78 & i27 != 0 ? obj.errorContainer : obj68;
        onErrorContainer = obj78 & i29 != 0 ? obj.onErrorContainer : obj70;
        outline = obj78 & i32 != 0 ? obj.outline : obj72;
        outlineVariant = obj78 & i34 != 0 ? obj.outlineVariant : obj74;
        scrim = obj78 & i36 != 0 ? obj.scrim : obj76;
        return obj.copy-G1PFc-w(primary, obj22, onPrimary, obj24, primaryContainer, obj26, onPrimaryContainer, obj28, inversePrimary, obj30, secondary, obj32, onSecondary, obj34, secondaryContainer, obj36, obj22, obj38, obj24, obj40, obj26, obj42, obj28, obj44, obj30, obj46, obj32, obj48, obj34);
    }

    public static void getDefaultCenterAlignedTopAppBarColorsCached$material3_release$annotations() {
    }

    public static void getDefaultDatePickerColorsCached$material3_release$annotations() {
    }

    public static void getDefaultLargeTopAppBarColorsCached$material3_release$annotations() {
    }

    public static void getDefaultMediumTopAppBarColorsCached$material3_release$annotations() {
    }

    public static void getDefaultRichTooltipColorsCached$material3_release$annotations() {
    }

    public static void getDefaultSegmentedButtonColorsCached$material3_release$annotations() {
    }

    public static void getDefaultTimePickerColorsCached$material3_release$annotations() {
    }

    public static void getDefaultTopAppBarColorsCached$material3_release$annotations() {
    }

    public final androidx.compose.material3.ColorScheme copy-C-Xl9yA(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim, long surfaceBright, long surfaceDim, long surfaceContainer, long surfaceContainerHigh, long surfaceContainerHighest, long surfaceContainerLow, long surfaceContainerLowest) {
        ColorScheme colorScheme = new ColorScheme(primary, obj2, primaryContainer, obj4, inversePrimary, obj6, onSecondary, obj8, onSecondaryContainer, obj10, onTertiary, obj12, onTertiaryContainer, obj14, onBackground, obj16, onSurface, obj18, onSurfaceVariant, obj20, inverseSurface, obj22, error, obj24, errorContainer, obj26, outline, obj28, scrim, obj30, surfaceDim, obj32, surfaceContainerHigh, obj34, surfaceContainerLow, obj36, obj111, obj38, obj113, obj40, obj115, obj42, obj117, obj44, obj119, obj46, obj121, obj48, obj123, obj50, obj125, obj52, obj127, obj54, obj129, obj56, obj131, obj58, obj133, obj60, obj135, obj62, obj137, obj64, obj139, obj66, obj141, obj68, obj143, obj70, obj145, obj72, 0);
        return colorScheme;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    public final androidx.compose.material3.ColorScheme copy-G1PFc-w(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return ColorScheme.copy-C-Xl9yA$default(this, primary, obj3, primaryContainer, obj5, inversePrimary, obj7, onSecondary, obj9, onSecondaryContainer, obj11, onTertiary, obj13, onTertiaryContainer, obj15, onBackground, obj17, onSurface, obj19, onSurfaceVariant, obj21, inverseSurface, obj23, error, obj25, errorContainer, obj27, outline, obj29, scrim, obj31, obj108, obj33, obj110, obj35, obj112, obj37, obj114, obj39, obj116);
    }

    public final long getBackground-0d7_KjU() {
        return this.background;
    }

    public final androidx.compose.material3.ChipColors getDefaultAssistChipColorsCached$material3_release() {
        return this.defaultAssistChipColorsCached;
    }

    public final androidx.compose.material3.ButtonColors getDefaultButtonColorsCached$material3_release() {
        return this.defaultButtonColorsCached;
    }

    public final androidx.compose.material3.CardColors getDefaultCardColorsCached$material3_release() {
        return this.defaultCardColorsCached;
    }

    public final androidx.compose.material3.TopAppBarColors getDefaultCenterAlignedTopAppBarColorsCached$material3_release() {
        return this.defaultCenterAlignedTopAppBarColorsCached;
    }

    public final androidx.compose.material3.CheckboxColors getDefaultCheckboxColorsCached$material3_release() {
        return this.defaultCheckboxColorsCached;
    }

    public final androidx.compose.material3.DatePickerColors getDefaultDatePickerColorsCached$material3_release() {
        return this.defaultDatePickerColorsCached;
    }

    public final androidx.compose.material3.ChipColors getDefaultElevatedAssistChipColorsCached$material3_release() {
        return this.defaultElevatedAssistChipColorsCached;
    }

    public final androidx.compose.material3.ButtonColors getDefaultElevatedButtonColorsCached$material3_release() {
        return this.defaultElevatedButtonColorsCached;
    }

    public final androidx.compose.material3.CardColors getDefaultElevatedCardColorsCached$material3_release() {
        return this.defaultElevatedCardColorsCached;
    }

    public final androidx.compose.material3.SelectableChipColors getDefaultElevatedFilterChipColorsCached$material3_release() {
        return this.defaultElevatedFilterChipColorsCached;
    }

    public final androidx.compose.material3.ChipColors getDefaultElevatedSuggestionChipColorsCached$material3_release() {
        return this.defaultElevatedSuggestionChipColorsCached;
    }

    public final androidx.compose.material3.NavigationItemColors getDefaultExpressiveNavigationBarItemColorsCached$material3_release() {
        return this.defaultExpressiveNavigationBarItemColorsCached;
    }

    public final androidx.compose.material3.IconButtonColors getDefaultFilledIconButtonColorsCached$material3_release() {
        return this.defaultFilledIconButtonColorsCached;
    }

    public final androidx.compose.material3.IconToggleButtonColors getDefaultFilledIconToggleButtonColorsCached$material3_release() {
        return this.defaultFilledIconToggleButtonColorsCached;
    }

    public final androidx.compose.material3.ButtonColors getDefaultFilledTonalButtonColorsCached$material3_release() {
        return this.defaultFilledTonalButtonColorsCached;
    }

    public final androidx.compose.material3.IconButtonColors getDefaultFilledTonalIconButtonColorsCached$material3_release() {
        return this.defaultFilledTonalIconButtonColorsCached;
    }

    public final androidx.compose.material3.IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColorsCached$material3_release() {
        return this.defaultFilledTonalIconToggleButtonColorsCached;
    }

    public final androidx.compose.material3.SelectableChipColors getDefaultFilterChipColorsCached$material3_release() {
        return this.defaultFilterChipColorsCached;
    }

    public final androidx.compose.material3.IconButtonColors getDefaultIconButtonColorsCached$material3_release() {
        return this.defaultIconButtonColorsCached;
    }

    public final androidx.compose.material3.IconToggleButtonColors getDefaultIconToggleButtonColorsCached$material3_release() {
        return this.defaultIconToggleButtonColorsCached;
    }

    public final androidx.compose.material3.SelectableChipColors getDefaultInputChipColorsCached$material3_release() {
        return this.defaultInputChipColorsCached;
    }

    public final androidx.compose.material3.TopAppBarColors getDefaultLargeTopAppBarColorsCached$material3_release() {
        return this.defaultLargeTopAppBarColorsCached;
    }

    public final androidx.compose.material3.TopAppBarColors getDefaultMediumTopAppBarColorsCached$material3_release() {
        return this.defaultMediumTopAppBarColorsCached;
    }

    public final androidx.compose.material3.MenuItemColors getDefaultMenuItemColorsCached$material3_release() {
        return this.defaultMenuItemColorsCached;
    }

    public final androidx.compose.material3.NavigationBarItemColors getDefaultNavigationBarItemColorsCached$material3_release() {
        return this.defaultNavigationBarItemColorsCached;
    }

    public final androidx.compose.material3.NavigationRailItemColors getDefaultNavigationRailItemColorsCached$material3_release() {
        return this.defaultNavigationRailItemColorsCached;
    }

    public final androidx.compose.material3.ButtonColors getDefaultOutlinedButtonColorsCached$material3_release() {
        return this.defaultOutlinedButtonColorsCached;
    }

    public final androidx.compose.material3.CardColors getDefaultOutlinedCardColorsCached$material3_release() {
        return this.defaultOutlinedCardColorsCached;
    }

    public final androidx.compose.material3.IconButtonColors getDefaultOutlinedIconButtonColorsCached$material3_release() {
        return this.defaultOutlinedIconButtonColorsCached;
    }

    public final androidx.compose.material3.IconToggleButtonColors getDefaultOutlinedIconToggleButtonColorsCached$material3_release() {
        return this.defaultOutlinedIconToggleButtonColorsCached;
    }

    public final androidx.compose.material3.TextFieldColors getDefaultOutlinedTextFieldColorsCached$material3_release() {
        return this.defaultOutlinedTextFieldColorsCached;
    }

    public final androidx.compose.material3.RadioButtonColors getDefaultRadioButtonColorsCached$material3_release() {
        return this.defaultRadioButtonColorsCached;
    }

    public final androidx.compose.material3.RichTooltipColors getDefaultRichTooltipColorsCached$material3_release() {
        return this.defaultRichTooltipColorsCached;
    }

    public final androidx.compose.material3.SegmentedButtonColors getDefaultSegmentedButtonColorsCached$material3_release() {
        return this.defaultSegmentedButtonColorsCached;
    }

    public final androidx.compose.material3.SliderColors getDefaultSliderColorsCached$material3_release() {
        return this.defaultSliderColorsCached;
    }

    public final androidx.compose.material3.ChipColors getDefaultSuggestionChipColorsCached$material3_release() {
        return this.defaultSuggestionChipColorsCached;
    }

    public final androidx.compose.material3.SwitchColors getDefaultSwitchColorsCached$material3_release() {
        return this.defaultSwitchColorsCached;
    }

    public final androidx.compose.material3.ButtonColors getDefaultTextButtonColorsCached$material3_release() {
        return this.defaultTextButtonColorsCached;
    }

    public final androidx.compose.material3.TextFieldColors getDefaultTextFieldColorsCached$material3_release() {
        return this.defaultTextFieldColorsCached;
    }

    public final androidx.compose.material3.TimePickerColors getDefaultTimePickerColorsCached$material3_release() {
        return this.defaultTimePickerColorsCached;
    }

    public final androidx.compose.material3.TopAppBarColors getDefaultTopAppBarColorsCached$material3_release() {
        return this.defaultTopAppBarColorsCached;
    }

    public final long getError-0d7_KjU() {
        return this.error;
    }

    public final long getErrorContainer-0d7_KjU() {
        return this.errorContainer;
    }

    public final long getInverseOnSurface-0d7_KjU() {
        return this.inverseOnSurface;
    }

    public final long getInversePrimary-0d7_KjU() {
        return this.inversePrimary;
    }

    public final long getInverseSurface-0d7_KjU() {
        return this.inverseSurface;
    }

    public final long getOnBackground-0d7_KjU() {
        return this.onBackground;
    }

    public final long getOnError-0d7_KjU() {
        return this.onError;
    }

    public final long getOnErrorContainer-0d7_KjU() {
        return this.onErrorContainer;
    }

    public final long getOnPrimary-0d7_KjU() {
        return this.onPrimary;
    }

    public final long getOnPrimaryContainer-0d7_KjU() {
        return this.onPrimaryContainer;
    }

    public final long getOnSecondary-0d7_KjU() {
        return this.onSecondary;
    }

    public final long getOnSecondaryContainer-0d7_KjU() {
        return this.onSecondaryContainer;
    }

    public final long getOnSurface-0d7_KjU() {
        return this.onSurface;
    }

    public final long getOnSurfaceVariant-0d7_KjU() {
        return this.onSurfaceVariant;
    }

    public final long getOnTertiary-0d7_KjU() {
        return this.onTertiary;
    }

    public final long getOnTertiaryContainer-0d7_KjU() {
        return this.onTertiaryContainer;
    }

    public final long getOutline-0d7_KjU() {
        return this.outline;
    }

    public final long getOutlineVariant-0d7_KjU() {
        return this.outlineVariant;
    }

    public final long getPrimary-0d7_KjU() {
        return this.primary;
    }

    public final long getPrimaryContainer-0d7_KjU() {
        return this.primaryContainer;
    }

    public final long getScrim-0d7_KjU() {
        return this.scrim;
    }

    public final long getSecondary-0d7_KjU() {
        return this.secondary;
    }

    public final long getSecondaryContainer-0d7_KjU() {
        return this.secondaryContainer;
    }

    public final long getSurface-0d7_KjU() {
        return this.surface;
    }

    public final long getSurfaceBright-0d7_KjU() {
        return this.surfaceBright;
    }

    public final long getSurfaceContainer-0d7_KjU() {
        return this.surfaceContainer;
    }

    public final long getSurfaceContainerHigh-0d7_KjU() {
        return this.surfaceContainerHigh;
    }

    public final long getSurfaceContainerHighest-0d7_KjU() {
        return this.surfaceContainerHighest;
    }

    public final long getSurfaceContainerLow-0d7_KjU() {
        return this.surfaceContainerLow;
    }

    public final long getSurfaceContainerLowest-0d7_KjU() {
        return this.surfaceContainerLowest;
    }

    public final long getSurfaceDim-0d7_KjU() {
        return this.surfaceDim;
    }

    public final long getSurfaceTint-0d7_KjU() {
        return this.surfaceTint;
    }

    public final long getSurfaceVariant-0d7_KjU() {
        return this.surfaceVariant;
    }

    public final long getTertiary-0d7_KjU() {
        return this.tertiary;
    }

    public final long getTertiaryContainer-0d7_KjU() {
        return this.tertiaryContainer;
    }

    public final void setDefaultAssistChipColorsCached$material3_release(androidx.compose.material3.ChipColors <set-?>) {
        this.defaultAssistChipColorsCached = <set-?>;
    }

    public final void setDefaultButtonColorsCached$material3_release(androidx.compose.material3.ButtonColors <set-?>) {
        this.defaultButtonColorsCached = <set-?>;
    }

    public final void setDefaultCardColorsCached$material3_release(androidx.compose.material3.CardColors <set-?>) {
        this.defaultCardColorsCached = <set-?>;
    }

    public final void setDefaultCenterAlignedTopAppBarColorsCached$material3_release(androidx.compose.material3.TopAppBarColors <set-?>) {
        this.defaultCenterAlignedTopAppBarColorsCached = <set-?>;
    }

    public final void setDefaultCheckboxColorsCached$material3_release(androidx.compose.material3.CheckboxColors <set-?>) {
        this.defaultCheckboxColorsCached = <set-?>;
    }

    public final void setDefaultDatePickerColorsCached$material3_release(androidx.compose.material3.DatePickerColors <set-?>) {
        this.defaultDatePickerColorsCached = <set-?>;
    }

    public final void setDefaultElevatedAssistChipColorsCached$material3_release(androidx.compose.material3.ChipColors <set-?>) {
        this.defaultElevatedAssistChipColorsCached = <set-?>;
    }

    public final void setDefaultElevatedButtonColorsCached$material3_release(androidx.compose.material3.ButtonColors <set-?>) {
        this.defaultElevatedButtonColorsCached = <set-?>;
    }

    public final void setDefaultElevatedCardColorsCached$material3_release(androidx.compose.material3.CardColors <set-?>) {
        this.defaultElevatedCardColorsCached = <set-?>;
    }

    public final void setDefaultElevatedFilterChipColorsCached$material3_release(androidx.compose.material3.SelectableChipColors <set-?>) {
        this.defaultElevatedFilterChipColorsCached = <set-?>;
    }

    public final void setDefaultElevatedSuggestionChipColorsCached$material3_release(androidx.compose.material3.ChipColors <set-?>) {
        this.defaultElevatedSuggestionChipColorsCached = <set-?>;
    }

    public final void setDefaultExpressiveNavigationBarItemColorsCached$material3_release(androidx.compose.material3.NavigationItemColors <set-?>) {
        this.defaultExpressiveNavigationBarItemColorsCached = <set-?>;
    }

    public final void setDefaultFilledIconButtonColorsCached$material3_release(androidx.compose.material3.IconButtonColors <set-?>) {
        this.defaultFilledIconButtonColorsCached = <set-?>;
    }

    public final void setDefaultFilledIconToggleButtonColorsCached$material3_release(androidx.compose.material3.IconToggleButtonColors <set-?>) {
        this.defaultFilledIconToggleButtonColorsCached = <set-?>;
    }

    public final void setDefaultFilledTonalButtonColorsCached$material3_release(androidx.compose.material3.ButtonColors <set-?>) {
        this.defaultFilledTonalButtonColorsCached = <set-?>;
    }

    public final void setDefaultFilledTonalIconButtonColorsCached$material3_release(androidx.compose.material3.IconButtonColors <set-?>) {
        this.defaultFilledTonalIconButtonColorsCached = <set-?>;
    }

    public final void setDefaultFilledTonalIconToggleButtonColorsCached$material3_release(androidx.compose.material3.IconToggleButtonColors <set-?>) {
        this.defaultFilledTonalIconToggleButtonColorsCached = <set-?>;
    }

    public final void setDefaultFilterChipColorsCached$material3_release(androidx.compose.material3.SelectableChipColors <set-?>) {
        this.defaultFilterChipColorsCached = <set-?>;
    }

    public final void setDefaultIconButtonColorsCached$material3_release(androidx.compose.material3.IconButtonColors <set-?>) {
        this.defaultIconButtonColorsCached = <set-?>;
    }

    public final void setDefaultIconToggleButtonColorsCached$material3_release(androidx.compose.material3.IconToggleButtonColors <set-?>) {
        this.defaultIconToggleButtonColorsCached = <set-?>;
    }

    public final void setDefaultInputChipColorsCached$material3_release(androidx.compose.material3.SelectableChipColors <set-?>) {
        this.defaultInputChipColorsCached = <set-?>;
    }

    public final void setDefaultLargeTopAppBarColorsCached$material3_release(androidx.compose.material3.TopAppBarColors <set-?>) {
        this.defaultLargeTopAppBarColorsCached = <set-?>;
    }

    public final void setDefaultMediumTopAppBarColorsCached$material3_release(androidx.compose.material3.TopAppBarColors <set-?>) {
        this.defaultMediumTopAppBarColorsCached = <set-?>;
    }

    public final void setDefaultMenuItemColorsCached$material3_release(androidx.compose.material3.MenuItemColors <set-?>) {
        this.defaultMenuItemColorsCached = <set-?>;
    }

    public final void setDefaultNavigationBarItemColorsCached$material3_release(androidx.compose.material3.NavigationBarItemColors <set-?>) {
        this.defaultNavigationBarItemColorsCached = <set-?>;
    }

    public final void setDefaultNavigationRailItemColorsCached$material3_release(androidx.compose.material3.NavigationRailItemColors <set-?>) {
        this.defaultNavigationRailItemColorsCached = <set-?>;
    }

    public final void setDefaultOutlinedButtonColorsCached$material3_release(androidx.compose.material3.ButtonColors <set-?>) {
        this.defaultOutlinedButtonColorsCached = <set-?>;
    }

    public final void setDefaultOutlinedCardColorsCached$material3_release(androidx.compose.material3.CardColors <set-?>) {
        this.defaultOutlinedCardColorsCached = <set-?>;
    }

    public final void setDefaultOutlinedIconButtonColorsCached$material3_release(androidx.compose.material3.IconButtonColors <set-?>) {
        this.defaultOutlinedIconButtonColorsCached = <set-?>;
    }

    public final void setDefaultOutlinedIconToggleButtonColorsCached$material3_release(androidx.compose.material3.IconToggleButtonColors <set-?>) {
        this.defaultOutlinedIconToggleButtonColorsCached = <set-?>;
    }

    public final void setDefaultOutlinedTextFieldColorsCached$material3_release(androidx.compose.material3.TextFieldColors <set-?>) {
        this.defaultOutlinedTextFieldColorsCached = <set-?>;
    }

    public final void setDefaultRadioButtonColorsCached$material3_release(androidx.compose.material3.RadioButtonColors <set-?>) {
        this.defaultRadioButtonColorsCached = <set-?>;
    }

    public final void setDefaultRichTooltipColorsCached$material3_release(androidx.compose.material3.RichTooltipColors <set-?>) {
        this.defaultRichTooltipColorsCached = <set-?>;
    }

    public final void setDefaultSegmentedButtonColorsCached$material3_release(androidx.compose.material3.SegmentedButtonColors <set-?>) {
        this.defaultSegmentedButtonColorsCached = <set-?>;
    }

    public final void setDefaultSliderColorsCached$material3_release(androidx.compose.material3.SliderColors <set-?>) {
        this.defaultSliderColorsCached = <set-?>;
    }

    public final void setDefaultSuggestionChipColorsCached$material3_release(androidx.compose.material3.ChipColors <set-?>) {
        this.defaultSuggestionChipColorsCached = <set-?>;
    }

    public final void setDefaultSwitchColorsCached$material3_release(androidx.compose.material3.SwitchColors <set-?>) {
        this.defaultSwitchColorsCached = <set-?>;
    }

    public final void setDefaultTextButtonColorsCached$material3_release(androidx.compose.material3.ButtonColors <set-?>) {
        this.defaultTextButtonColorsCached = <set-?>;
    }

    public final void setDefaultTextFieldColorsCached$material3_release(androidx.compose.material3.TextFieldColors <set-?>) {
        this.defaultTextFieldColorsCached = <set-?>;
    }

    public final void setDefaultTimePickerColorsCached$material3_release(androidx.compose.material3.TimePickerColors <set-?>) {
        this.defaultTimePickerColorsCached = <set-?>;
    }

    public final void setDefaultTopAppBarColorsCached$material3_release(androidx.compose.material3.TopAppBarColors <set-?>) {
        this.defaultTopAppBarColorsCached = <set-?>;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str13 = "tertiaryContainer=";
        stringBuilder.append("ColorScheme(primary=").append(Color.toString-impl(this.primary)).append("onPrimary=").append(Color.toString-impl(this.onPrimary)).append("primaryContainer=").append(Color.toString-impl(this.primaryContainer)).append("onPrimaryContainer=").append(Color.toString-impl(this.onPrimaryContainer)).append("inversePrimary=").append(Color.toString-impl(this.inversePrimary)).append("secondary=").append(Color.toString-impl(this.secondary)).append("onSecondary=").append(Color.toString-impl(this.onSecondary)).append("secondaryContainer=").append(Color.toString-impl(this.secondaryContainer)).append("onSecondaryContainer=").append(Color.toString-impl(this.onSecondaryContainer)).append("tertiary=").append(Color.toString-impl(this.tertiary)).append("onTertiary=").append(Color.toString-impl(this.onTertiary)).append(str13);
        stringBuilder.append(Color.toString-impl(this.tertiaryContainer)).append("onTertiaryContainer=").append(Color.toString-impl(this.onTertiaryContainer)).append("background=").append(Color.toString-impl(this.background)).append("onBackground=").append(Color.toString-impl(this.onBackground)).append("surface=").append(Color.toString-impl(this.surface)).append("onSurface=").append(Color.toString-impl(this.onSurface)).append("surfaceVariant=").append(Color.toString-impl(this.surfaceVariant)).append("onSurfaceVariant=").append(Color.toString-impl(this.onSurfaceVariant)).append("surfaceTint=").append(Color.toString-impl(this.surfaceTint)).append("inverseSurface=").append(Color.toString-impl(this.inverseSurface)).append("inverseOnSurface=").append(Color.toString-impl(this.inverseOnSurface)).append("error=").append(Color.toString-impl(this.error));
        String str35 = "surfaceContainerLow=";
        stringBuilder.append("onError=").append(Color.toString-impl(this.onError)).append("errorContainer=").append(Color.toString-impl(this.errorContainer)).append("onErrorContainer=").append(Color.toString-impl(this.onErrorContainer)).append("outline=").append(Color.toString-impl(this.outline)).append("outlineVariant=").append(Color.toString-impl(this.outlineVariant)).append("scrim=").append(Color.toString-impl(this.scrim)).append("surfaceBright=").append(Color.toString-impl(this.surfaceBright)).append("surfaceDim=").append(Color.toString-impl(this.surfaceDim)).append("surfaceContainer=").append(Color.toString-impl(this.surfaceContainer)).append("surfaceContainerHigh=").append(Color.toString-impl(this.surfaceContainerHigh)).append("surfaceContainerHighest=").append(Color.toString-impl(this.surfaceContainerHighest)).append(str35);
        stringBuilder.append(Color.toString-impl(this.surfaceContainerLow)).append("surfaceContainerLowest=").append(Color.toString-impl(this.surfaceContainerLowest)).append(')');
        return stringBuilder.toString();
    }
}
