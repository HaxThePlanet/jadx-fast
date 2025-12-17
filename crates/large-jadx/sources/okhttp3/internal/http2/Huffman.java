package okhttp3.internal.http2;

import android.app.ActivityManager.MemoryInfo;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.i;
import l.g;
import l.h;
import l.i;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0012\n\u0002\u0008\u0006\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\u0008\u0002¢\u0006\u0004\u0008 \u0010!J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\u000b¢\u0006\u0004\u0008\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\u0008\u0010\u0010\u0011J%\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000c\u001a\u00020\u000b¢\u0006\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001e\u0010\u001f¨\u0006#", d2 = {"Lokhttp3/internal/http2/Huffman;", "", "", "symbol", "code", "codeBitCount", "Lkotlin/w;", "addCode", "(III)V", "Ll/i;", "source", "Ll/g;", "sink", "encode", "(Ll/i;Ll/g;)V", "bytes", "encodedLength", "(Ll/i;)I", "Ll/h;", "", "byteCount", "decode", "(Ll/h;JLl/g;)V", "", "CODES", "[I", "Lokhttp3/internal/http2/Huffman$Node;", "root", "Lokhttp3/internal/http2/Huffman$Node;", "", "CODE_BIT_COUNTS", "[B", "<init>", "()V", "Node", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Huffman {

    private static final int[] CODES;
    private static final byte[] CODE_BIT_COUNTS;
    public static final okhttp3.internal.http2.Huffman INSTANCE;
    private static final okhttp3.internal.http2.Huffman.Node root;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u000b\u0008\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0016¢\u0006\u0004\u0008\u000e\u0010\u000fB\u0019\u0008\u0016\u0012\u0006\u0010\u000c\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\u0008\u000e\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006R#\u0010\u0008\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\u000c\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000c\u0010\u0004\u001a\u0004\u0008\r\u0010\u0006¨\u0006\u0012", d2 = {"Lokhttp3/internal/http2/Huffman$Node;", "", "", "terminalBitCount", "I", "getTerminalBitCount", "()I", "", "children", "[Lokhttp3/internal/http2/Huffman$Node;", "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", "symbol", "getSymbol", "<init>", "()V", "bits", "(II)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private static final class Node {

        private final okhttp3.internal.http2.Huffman.Node[] children;
        private final int symbol;
        private final int terminalBitCount;
        public Node() {
            super();
            this.children = new Huffman.Node[256];
            int i2 = 0;
            this.symbol = i2;
            this.terminalBitCount = i2;
        }

        public Node(int i, int i2) {
            int obj2;
            super();
            this.children = 0;
            this.symbol = i;
            obj2 = i2 & 7 == 0 ? 8 : obj2;
            this.terminalBitCount = obj2;
        }

        public final okhttp3.internal.http2.Huffman.Node[] getChildren() {
            return this.children;
        }

        public final int getSymbol() {
            return this.symbol;
        }

        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }
    }
    static {
        int i;
        int i3;
        byte b;
        Huffman huffman = new Huffman();
        Huffman.INSTANCE = huffman;
        int i5 = 256;
        int[] iArr = new int[i5];
        iArr = new int[]{
            8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194,
            1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440,
            268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449,
            268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042,
            1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1,
            2, 25, 26, 27, 28, 29, 30, 31, 92, 251,
            32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96,
            97, 98, 99, 100, 101, 102, 103, 104, 105, 106,
            107, 108, 109, 110, 111, 112, 113, 114, 252, 115,
            253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4,
            36, 5, 37, 38, 39, 6, 116, 117, 40, 41,
            42, 7, 43, 118, 44, 8, 9, 45, 119, 120,
            121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258,
            1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572,
            8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577,
            8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199,
            4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269,
            4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122,
            8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277,
            4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412,
            67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123,
            67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841,
            268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127,
            2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596,
            67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454,
            134217708, 134217709, 134217710, 134217711, 134217712, 67108846
        };
        Huffman.CODES = iArr;
        byte[] bArr = new byte[i5];
        bArr = new byte[]{
            13, 23, 28, 28, 28, 28, 28, 28, 28, 24,
            30, 28, 28, 30, 28, 28, 28, 28, 28, 28,
            28, 28, 30, 28, 28, 28, 28, 28, 28, 28,
            28, 28, 6, 10, 10, 12, 13, 6, 8, 11,
            10, 10, 8, 11, 8, 6, 6, 6, 5, 5,
            5, 6, 6, 6, 6, 6, 6, 6, 7, 8,
            15, 6, 12, 10, 13, 6, 7, 7, 7, 7,
            7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
            7, 7, 7, 7, 7, 7, 7, 7, 8, 7,
            8, 13, 19, 13, 14, 6, 15, 5, 6, 5,
            6, 5, 6, 6, 6, 5, 7, 7, 6, 6,
            6, 5, 6, 7, 6, 5, 5, 6, 7, 7,
            7, 7, 7, 15, 11, 14, 13, 28, 20, 22,
            20, 20, 22, 22, 22, 23, 22, 23, 23, 23,
            23, 23, 24, 23, 24, 24, 22, 23, 24, 23,
            23, 23, 23, 21, 22, 23, 22, 23, 23, 24,
            22, 21, 20, 22, 22, 23, 23, 21, 23, 22,
            22, 24, 21, 22, 23, 23, 21, 21, 22, 21,
            23, 22, 23, 23, 20, 22, 22, 22, 23, 22,
            22, 23, 26, 26, 20, 19, 22, 23, 22, 25,
            26, 26, 26, 27, 27, 26, 24, 25, 19, 21,
            26, 27, 27, 26, 27, 24, 21, 21, 26, 26,
            28, 27, 27, 27, 20, 24, 20, 21, 22, 21,
            21, 23, 22, 22, 25, 25, 24, 24, 26, 23,
            26, 27, 26, 26, 27, 27, 27, 27, 27, 28,
            27, 27, 27, 27, 27, 26
        };
        Huffman.CODE_BIT_COUNTS = bArr;
        Huffman.Node node = new Huffman.Node();
        Huffman.root = node;
        i = 0;
        while (i < bArr.length) {
            huffman.addCode(i, Huffman.CODES[i], Huffman.CODE_BIT_COUNTS[i]);
            i++;
        }
    }

    private final void addCode(int i, int i2, int i3) {
        int i4;
        okhttp3.internal.http2.Huffman.Node node;
        okhttp3.internal.http2.Huffman.Node obj4;
        int obj6;
        Huffman.Node node2 = new Huffman.Node(i, i3);
        obj4 = Huffman.root;
        int i5 = 8;
        while (obj6 > i5) {
            i7 &= 255;
            obj4 = obj4.getChildren();
            n.d(obj4);
            if (obj4[i4] == null) {
            }
            obj4 = node;
            i5 = 8;
            node = new Huffman.Node();
            obj4[i4] = node;
        }
        i5 -= obj6;
        obj5 &= 255;
        obj4 = obj4.getChildren();
        n.d(obj4);
        i.l(obj4, node2, obj5, obj6 += obj5);
    }

    public final void decode(h h, long l2, g g3) {
        okhttp3.internal.http2.Huffman.Node root;
        int i2;
        int i5;
        int i3;
        int i;
        int symbol;
        int i4;
        okhttp3.internal.http2.Huffman.Node[] children;
        Object obj9;
        int obj10;
        n.f(h, "source");
        n.f(obj12, "sink");
        root = Huffman.root;
        i3 = i7;
        i5 = i2;
        i4 = 255;
        while (Long.compare(i3, l2) < 0) {
            i5 += 8;
            while (i5 >= 8) {
                symbol = i5 + -8;
                okhttp3.internal.http2.Huffman.Node[] children2 = root.getChildren();
                n.d(children2);
                root = children2[i9 &= i4];
                n.d(root);
                if (root.getChildren() == null) {
                } else {
                }
                i5 = symbol;
                obj12.c0(root.getSymbol());
                i5 -= terminalBitCount;
                root = Huffman.root;
            }
            i3 += i;
            i4 = 255;
            symbol = i5 + -8;
            children2 = root.getChildren();
            n.d(children2);
            root = children2[i9 &= i4];
            n.d(root);
            if (root.getChildren() == null) {
            } else {
            }
            i5 = symbol;
            obj12.c0(root.getSymbol());
            i5 -= terminalBitCount;
            root = Huffman.root;
        }
        while (i5 > 0) {
            obj10 = root.getChildren();
            n.d(obj10);
            obj9 = obj10[obj9 &= i4];
            n.d(obj9);
            if (obj9.getChildren() == null) {
                break;
            }
            if (obj9.getTerminalBitCount() > i5) {
                break;
            } else {
            }
            obj12.c0(obj9.getSymbol());
            i5 -= obj9;
            root = Huffman.root;
        }
    }

    public final void encode(i i, g g2) {
        int i2;
        int i4;
        int i5;
        int i6;
        int i3;
        byte b;
        long l;
        byte[] cODE_BIT_COUNTS;
        Object obj9;
        n.f(i, "source");
        n.f(g2, "sink");
        i6 = i8;
        i5 = i4;
        while (i4 < i.A()) {
            int i10 = Util.and(i.j(i4), 255);
            b = Huffman.CODE_BIT_COUNTS[i10];
            i5 += b;
            while (i5 >= 8) {
                g2.c0((int)i11);
            }
            i4++;
            g2.c0((int)i11);
        }
        if (i5 > 0) {
            g2.c0((int)i2);
        }
    }

    public final int encodedLength(i i) {
        int i2;
        int i3;
        long l;
        byte[] cODE_BIT_COUNTS;
        n.f(i, "bytes");
        i2 = 0;
        i3 = 0;
        while (i3 < i.A()) {
            i2 += l;
            i3++;
        }
        return (int)i5;
    }
}
