package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.i;
import kotlin.y.p;
import l.d0;
import l.f;
import l.h;
import l.i;
import l.q;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\t\u0008\u0002¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0015\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\u0008\u0008\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\n\u0010\u000bR\u0016\u0010\u000c\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u000bR\u001f\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u0012R%\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0006R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0016\u0010\u000bR\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u000bR\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u000bR\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0019\u0010\u000b¨\u0006\u001e", d2 = {"Lokhttp3/internal/http2/Hpack;", "", "", "Ll/i;", "", "nameToFirstIndex", "()Ljava/util/Map;", "name", "checkLowercase", "(Ll/i;)Ll/i;", "SETTINGS_HEADER_TABLE_SIZE", "I", "PREFIX_5_BITS", "", "Lokhttp3/internal/http2/Header;", "STATIC_HEADER_TABLE", "[Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "NAME_TO_FIRST_INDEX", "Ljava/util/Map;", "getNAME_TO_FIRST_INDEX", "PREFIX_4_BITS", "PREFIX_7_BITS", "PREFIX_6_BITS", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "<init>", "()V", "Reader", "Writer", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Hpack {

    public static final okhttp3.internal.http2.Hpack INSTANCE = null;
    private static final Map<i, Integer> NAME_TO_FIRST_INDEX = null;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final okhttp3.internal.http2.Header[] STATIC_HEADER_TABLE;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0008\u000b\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B#\u0008\u0007\u0012\u0006\u00105\u001a\u000208\u0012\u0006\u00103\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\"\u001a\u00020\u0006¢\u0006\u0004\u00089\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0004J\u0017\u0010\u0008\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\r\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\u000e\u0010\u000cJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u000f\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\u0011\u0010\u000cJ\u000f\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0012\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0013\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00190\u001f¢\u0006\u0004\u0008 \u0010!J\r\u0010\"\u001a\u00020\u0006¢\u0006\u0004\u0008\"\u0010\u001eJ\r\u0010#\u001a\u00020\u0002¢\u0006\u0004\u0008#\u0010\u0004J\u001d\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006¢\u0006\u0004\u0008&\u0010'J\r\u0010(\u001a\u00020\u0013¢\u0006\u0004\u0008(\u0010)R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\"\u0010*R\u001e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190+8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\u0008,\u0010-R\u0016\u0010.\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\u0008.\u0010*R\u001c\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00190/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00080\u00101R\u0016\u00102\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\u00082\u0010*R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00083\u0010*R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00085\u00106R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00087\u0010*¨\u0006;", d2 = {"Lokhttp3/internal/http2/Hpack$Reader;", "", "Lkotlin/w;", "adjustDynamicTableByteCount", "()V", "clearDynamicTable", "", "bytesToRecover", "evictToRecoverBytes", "(I)I", "index", "readIndexedHeader", "(I)V", "dynamicTableIndex", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "nameIndex", "readLiteralHeaderWithIncrementalIndexingIndexedName", "readLiteralHeaderWithIncrementalIndexingNewName", "Ll/i;", "getName", "(I)Ll/i;", "", "isStaticHeader", "(I)Z", "Lokhttp3/internal/http2/Header;", "entry", "insertIntoDynamicTable", "(ILokhttp3/internal/http2/Header;)V", "readByte", "()I", "", "getAndResetHeaderList", "()Ljava/util/List;", "maxDynamicTableByteCount", "readHeaders", "firstByte", "prefixMask", "readInt", "(II)I", "readByteString", "()Ll/i;", "I", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "", "headerList", "Ljava/util/List;", "headerCount", "headerTableSizeSetting", "Ll/h;", "source", "Ll/h;", "nextHeaderIndex", "Ll/d0;", "<init>", "(Ll/d0;II)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Reader {

        public okhttp3.internal.http2.Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<okhttp3.internal.http2.Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final h source;
        public Reader(d0 d0, int i2) {
            super(d0, i2, 0, 4, 0);
        }

        public Reader(d0 d0, int i2, int i3) {
            n.f(d0, "source");
            super();
            this.headerTableSizeSetting = i2;
            this.maxDynamicTableByteCount = i3;
            ArrayList obj3 = new ArrayList();
            this.headerList = obj3;
            this.source = q.d(d0);
            okhttp3.internal.http2.Header[] obj2 = new Header[8];
            this.dynamicTable = obj2;
            this.nextHeaderIndex = obj2--;
        }

        public Reader(d0 d0, int i2, int i3, int i4, g g5) {
            int obj3;
            obj3 = i4 &= 4 != 0 ? i2 : obj3;
            super(d0, i2, obj3);
        }

        private final void adjustDynamicTableByteCount() {
            int dynamicTableByteCount;
            final int maxDynamicTableByteCount = this.maxDynamicTableByteCount;
            dynamicTableByteCount = this.dynamicTableByteCount;
            if (maxDynamicTableByteCount < dynamicTableByteCount) {
                if (maxDynamicTableByteCount == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(dynamicTableByteCount -= maxDynamicTableByteCount);
                }
            }
        }

        private final void clearDynamicTable() {
            i.n(this.dynamicTable, 0, 0, 0, 6, 0);
            this.nextHeaderIndex = length--;
            int i2 = 0;
            this.headerCount = i2;
            this.dynamicTableByteCount = i2;
        }

        private final int dynamicTableIndex(int i) {
            return i2 += i;
        }

        private final int evictToRecoverBytes(int i) {
            int i5;
            int i2;
            int i4;
            int i3;
            int headerCount;
            int obj5;
            i5 = 0;
            if (i > 0) {
                length--;
                int nextHeaderIndex = this.nextHeaderIndex;
                while (i2 >= nextHeaderIndex) {
                    if (obj5 > 0) {
                    }
                    okhttp3.internal.http2.Header header = this.dynamicTable[i2];
                    n.d(header);
                    int hpackSize = header.hpackSize;
                    obj5 -= hpackSize;
                    this.dynamicTableByteCount = dynamicTableByteCount -= hpackSize;
                    this.headerCount = headerCount2--;
                    i5++;
                    i2--;
                    nextHeaderIndex = this.nextHeaderIndex;
                }
                obj5 = this.dynamicTable;
                System.arraycopy(obj5, nextHeaderIndex + 1, obj5, i6 += i5, this.headerCount);
                this.nextHeaderIndex = obj5 += i5;
            }
            return i5;
        }

        private final i getName(int i) {
            okhttp3.internal.http2.Header[] sTATIC_HEADER_TABLE;
            okhttp3.internal.http2.Header[] dynamicTable;
            int length;
            i obj4;
            if (isStaticHeader(i)) {
                obj4 = obj4.name;
                return obj4;
            } else {
                sTATIC_HEADER_TABLE = dynamicTableIndex(i - length2);
                if (sTATIC_HEADER_TABLE < 0) {
                } else {
                    dynamicTable = this.dynamicTable;
                    if (sTATIC_HEADER_TABLE >= dynamicTable.length) {
                    } else {
                        obj4 = dynamicTable[sTATIC_HEADER_TABLE];
                        n.d(obj4);
                        obj4 = obj4.name;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Header index too large ");
            stringBuilder.append(i++);
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }

        private final void insertIntoDynamicTable(int i, okhttp3.internal.http2.Header header2) {
            int hpackSize2;
            okhttp3.internal.http2.Header[] dynamicTable;
            okhttp3.internal.http2.Header[] dynamicTable2;
            int hpackSize;
            int evictToRecoverBytes;
            int dynamicTableIndex;
            int length2;
            int length;
            int obj6;
            this.headerList.add(header2);
            int i2 = -1;
            if (i != i2) {
                okhttp3.internal.http2.Header header = this.dynamicTable[dynamicTableIndex(i)];
                n.d(header);
                hpackSize2 -= hpackSize;
            }
            int maxDynamicTableByteCount = this.maxDynamicTableByteCount;
            if (hpackSize2 > maxDynamicTableByteCount) {
                clearDynamicTable();
            }
            if (i == i2) {
                dynamicTable2 = this.dynamicTable;
                if (obj6++ > dynamicTable2.length) {
                    obj6 = new Header[obj6 *= 2];
                    System.arraycopy(dynamicTable2, 0, obj6, dynamicTable2.length, dynamicTable2.length);
                    this.nextHeaderIndex = length3--;
                    this.dynamicTable = obj6;
                }
                obj6 = this.nextHeaderIndex;
                this.nextHeaderIndex = obj6 + -1;
                this.dynamicTable[obj6] = header2;
                this.headerCount = obj6++;
            } else {
                this.dynamicTable[i += i4] = header2;
            }
            this.dynamicTableByteCount = obj6 += hpackSize2;
        }

        private final boolean isStaticHeader(int i) {
            int i2;
            int i3;
            if (i >= 0 && i <= length -= i2) {
                if (i <= length -= i2) {
                } else {
                    i2 = 0;
                }
            } else {
            }
            return i2;
        }

        private final int readByte() {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i) {
            Object headerList;
            okhttp3.internal.http2.Header[] dynamicTable;
            int length;
            Object obj4;
            if (isStaticHeader(i)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i]);
            } else {
                int dynamicTableIndex = dynamicTableIndex(i - length2);
                if (dynamicTableIndex < 0) {
                } else {
                    dynamicTable = this.dynamicTable;
                    if (dynamicTableIndex >= dynamicTable.length) {
                    } else {
                        headerList = dynamicTable[dynamicTableIndex];
                        n.d(headerList);
                        this.headerList.add(headerList);
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Header index too large ");
            stringBuilder.append(i++);
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) {
            Header header = new Header(getName(i), readByteString());
            insertIntoDynamicTable(-1, header);
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() {
            Header header = new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString());
            insertIntoDynamicTable(-1, header);
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i) {
            Header header = new Header(getName(i), readByteString());
            this.headerList.add(header);
        }

        private final void readLiteralHeaderWithoutIndexingNewName() {
            Header header = new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString());
            this.headerList.add(header);
        }

        public final List<okhttp3.internal.http2.Header> getAndResetHeaderList() {
            this.headerList.clear();
            return p.L0(this.headerList);
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final i readByteString() {
            i iVar;
            int iNSTANCE;
            h source;
            int byte = readByte();
            iNSTANCE = byte & 128 == 128 ? 1 : 0;
            long l = (long)int;
            if (iNSTANCE != null) {
                f fVar = new f();
                Huffman.INSTANCE.decode(this.source, l, obj3);
                iVar = fVar.Y0();
            } else {
                iVar = this.source.B(l);
            }
            return iVar;
        }

        public final void readHeaders() {
            int int;
            int headerTableSizeSetting;
            int i;
            while (!this.source.b0()) {
                int = Util.and(this.source.readByte(), 255);
                int i3 = 128;
                headerTableSizeSetting = 64;
                if (int != 16) {
                } else {
                }
                readLiteralHeaderWithoutIndexingNewName();
                if (int == 0) {
                } else {
                }
                readLiteralHeaderWithoutIndexingIndexedName(int4--);
                int = readInt(int, 31);
                this.maxDynamicTableByteCount = int;
                adjustDynamicTableByteCount();
                readLiteralHeaderWithIncrementalIndexingIndexedName(int3--);
                readLiteralHeaderWithIncrementalIndexingNewName();
                readIndexedHeader(int2--);
            }
        }

        public final int readInt(int i, int i2) {
            int i3;
            int i4;
            int obj3;
            int obj4;
            i &= i2;
            if (obj3 < i2) {
                return obj3;
            }
            obj3 = 0;
            int byte = readByte();
            while (byte & 128 != 0) {
                obj4 += i3;
                obj3 += 7;
                byte = readByte();
            }
            return obj4 += obj3;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B%\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010-\u001a\u00020*\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\u0008.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\r\u0010\u0004J\u001b\u0010\u0010\u001a\u00020\u00022\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0004\u0008\u0010\u0010\u0011J%\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\u0008\u001c\u0010\u001dR\u0016\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\u0008\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\u0008 \u0010\u001eR\u0016\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\u0008!\u0010\u001eR\u001e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\u0008#\u0010$R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008%\u0010\u001eR\u0016\u0010&\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008&\u0010\u001eR\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008+\u0010,R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008-\u0010,¨\u00060", d2 = {"Lokhttp3/internal/http2/Hpack$Writer;", "", "Lkotlin/w;", "clearDynamicTable", "()V", "", "bytesToRecover", "evictToRecoverBytes", "(I)I", "Lokhttp3/internal/http2/Header;", "entry", "insertIntoDynamicTable", "(Lokhttp3/internal/http2/Header;)V", "adjustDynamicTableByteCount", "", "headerBlock", "writeHeaders", "(Ljava/util/List;)V", "value", "prefixMask", "bits", "writeInt", "(III)V", "Ll/i;", "data", "writeByteString", "(Ll/i;)V", "headerTableSizeSetting", "resizeHeaderTable", "(I)V", "I", "maxDynamicTableByteCount", "headerCount", "dynamicTableByteCount", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "smallestHeaderTableSizeSetting", "nextHeaderIndex", "Ll/f;", "out", "Ll/f;", "", "emitDynamicTableSizeUpdate", "Z", "useCompression", "<init>", "(IZLl/f;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Writer {

        public okhttp3.internal.http2.Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final f out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;
        public Writer(int i, f f2) {
            super(i, 0, f2, 2, 0);
        }

        public Writer(int i, boolean z2, f f3) {
            n.f(f3, "out");
            super();
            this.headerTableSizeSetting = i;
            this.useCompression = z2;
            this.out = f3;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i;
            okhttp3.internal.http2.Header[] obj2 = new Header[8];
            this.dynamicTable = obj2;
            this.nextHeaderIndex = obj2--;
        }

        public Writer(int i, boolean z2, f f3, int i4, g g5) {
            int obj1;
            int obj2;
            obj1 = i4 & 1 != 0 ? 4096 : obj1;
            obj2 = i4 &= 2 != 0 ? 1 : obj2;
            super(obj1, obj2, f3);
        }

        public Writer(f f) {
            super(0, 0, f, 3, 0);
        }

        private final void adjustDynamicTableByteCount() {
            int dynamicTableByteCount;
            final int maxDynamicTableByteCount = this.maxDynamicTableByteCount;
            dynamicTableByteCount = this.dynamicTableByteCount;
            if (maxDynamicTableByteCount < dynamicTableByteCount) {
                if (maxDynamicTableByteCount == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(dynamicTableByteCount -= maxDynamicTableByteCount);
                }
            }
        }

        private final void clearDynamicTable() {
            i.n(this.dynamicTable, 0, 0, 0, 6, 0);
            this.nextHeaderIndex = length--;
            int i2 = 0;
            this.headerCount = i2;
            this.dynamicTableByteCount = i2;
        }

        private final int evictToRecoverBytes(int i) {
            int i3;
            int i4;
            int i5;
            int i2;
            int hpackSize;
            int obj5;
            i3 = 0;
            if (i > 0) {
                length--;
                int nextHeaderIndex2 = this.nextHeaderIndex;
                while (i4 >= nextHeaderIndex2) {
                    if (obj5 > 0) {
                    }
                    okhttp3.internal.http2.Header header = this.dynamicTable[i4];
                    n.d(header);
                    obj5 -= hpackSize2;
                    okhttp3.internal.http2.Header header2 = this.dynamicTable[i4];
                    n.d(header2);
                    this.dynamicTableByteCount = dynamicTableByteCount -= hpackSize;
                    this.headerCount = headerCount--;
                    i3++;
                    i4--;
                    nextHeaderIndex2 = this.nextHeaderIndex;
                }
                obj5 = this.dynamicTable;
                System.arraycopy(obj5, nextHeaderIndex2 + 1, obj5, i9 += i3, this.headerCount);
                int nextHeaderIndex = this.nextHeaderIndex;
                Arrays.fill(this.dynamicTable, nextHeaderIndex + 1, i7 += i3, 0);
                this.nextHeaderIndex = obj5 += i3;
            }
            return i3;
        }

        private final void insertIntoDynamicTable(okhttp3.internal.http2.Header header) {
            int arr;
            okhttp3.internal.http2.Header[] dynamicTable;
            int length;
            int length2;
            int length3;
            final int hpackSize = header.hpackSize;
            int maxDynamicTableByteCount = this.maxDynamicTableByteCount;
            if (hpackSize > maxDynamicTableByteCount) {
                clearDynamicTable();
            }
            evictToRecoverBytes(i2 -= maxDynamicTableByteCount);
            dynamicTable = this.dynamicTable;
            if (headerCount++ > dynamicTable.length) {
                arr = new Header[length4 *= 2];
                System.arraycopy(dynamicTable, 0, arr, dynamicTable.length, dynamicTable.length);
                this.nextHeaderIndex = length5--;
                this.dynamicTable = arr;
            }
            int nextHeaderIndex = this.nextHeaderIndex;
            this.nextHeaderIndex = nextHeaderIndex + -1;
            this.dynamicTable[nextHeaderIndex] = header;
            this.headerCount = obj7++;
            this.dynamicTableByteCount = obj7 += hpackSize;
        }

        public final void resizeHeaderTable(int i) {
            int maxDynamicTableByteCount;
            this.headerTableSizeSetting = i;
            final int obj2 = Math.min(i, 16384);
            maxDynamicTableByteCount = this.maxDynamicTableByteCount;
            if (maxDynamicTableByteCount == obj2) {
            }
            if (obj2 < maxDynamicTableByteCount) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, obj2);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = obj2;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(i i) {
            boolean useCompression;
            f out;
            int encodedLength;
            int i3;
            int i2;
            Object obj5;
            n.f(i, "data");
            final int i6 = 127;
            useCompression = Huffman.INSTANCE;
            if (this.useCompression && useCompression.encodedLength(i) < i.A()) {
                useCompression = Huffman.INSTANCE;
                if (useCompression.encodedLength(i) < i.A()) {
                    f fVar = new f();
                    useCompression.encode(i, fVar);
                    obj5 = fVar.Y0();
                    writeInt(obj5.A(), i6, 128);
                    this.out.e0(obj5);
                } else {
                    writeInt(i.A(), i6, 0);
                    this.out.e0(i);
                }
            } else {
            }
        }

        public final void writeHeaders(List<okhttp3.internal.http2.Header> list) {
            boolean emitDynamicTableSizeUpdate;
            int maxDynamicTableByteCount;
            int i;
            int i5;
            int i3;
            i value;
            f out;
            okhttp3.internal.http2.Hpack iNSTANCE;
            int i4;
            int tARGET_AUTHORITY;
            boolean z;
            int length;
            boolean length2;
            int i2;
            n.f(list, "headerBlock");
            final int i7 = 0;
            int smallestHeaderTableSizeSetting = this.smallestHeaderTableSizeSetting;
            i5 = 32;
            i3 = 31;
            if (this.emitDynamicTableSizeUpdate && smallestHeaderTableSizeSetting < this.maxDynamicTableByteCount) {
                smallestHeaderTableSizeSetting = this.smallestHeaderTableSizeSetting;
                i5 = 32;
                i3 = 31;
                if (smallestHeaderTableSizeSetting < this.maxDynamicTableByteCount) {
                    writeInt(smallestHeaderTableSizeSetting, i3, i5);
                }
                this.emitDynamicTableSizeUpdate = i7;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, i3, i5);
            }
            i = i7;
            while (i < list.size()) {
                i5 = list.get(i);
                i3 = i5.name.C();
                value = i5.value;
                iNSTANCE = Hpack.INSTANCE;
                Object obj = iNSTANCE.getNAME_TO_FIRST_INDEX().get(i3);
                tARGET_AUTHORITY = -1;
                if ((Integer)obj != null) {
                } else {
                }
                i4 = out;
                if (i4 == tARGET_AUTHORITY) {
                }
                if (i4 != tARGET_AUTHORITY) {
                } else {
                }
                i4 = 64;
                if (out == tARGET_AUTHORITY) {
                } else {
                }
                if (i3.B(Header.PSEUDO_PREFIX) && z2 ^= 1 != 0) {
                } else {
                }
                writeInt(out, 63, i4);
                writeByteString(value);
                insertIntoDynamicTable((Header)i5);
                i++;
                if (z2 ^= 1 != 0) {
                } else {
                }
                writeInt(out, 15, i7);
                writeByteString(value);
                this.out.z0(i4);
                writeByteString(i3);
                writeByteString(value);
                insertIntoDynamicTable(i5);
                writeInt(i4, 127, 128);
                nextHeaderIndex3++;
                while (z < dynamicTable.length) {
                    okhttp3.internal.http2.Header header3 = this.dynamicTable[z];
                    n.d(header3);
                    if (n.b(header3.name, i3)) {
                        break loop_18;
                    } else {
                    }
                    z++;
                    okhttp3.internal.http2.Header header4 = this.dynamicTable[z];
                    n.d(header4);
                    if (n.b(header4.value, value)) {
                        break loop_18;
                    } else {
                    }
                    if (out == tARGET_AUTHORITY) {
                    }
                    i9 += length2;
                }
                header3 = this.dynamicTable[z];
                n.d(header3);
                if (n.b(header3.name, i3)) {
                } else {
                }
                z++;
                header4 = this.dynamicTable[z];
                n.d(header4);
                if (n.b(header4.value, value)) {
                } else {
                }
                if (out == tARGET_AUTHORITY) {
                }
                i9 += length2;
                length3 += z;
                intValue++;
                if (2 > i4) {
                } else {
                }
                if (7 >= i4) {
                } else {
                }
                out = i4;
                i4 = tARGET_AUTHORITY;
                if (n.b(header2.value, value)) {
                } else {
                }
                if (n.b(header.value, value)) {
                } else {
                }
                i4 = i8;
                out = i2;
                out = i4;
            }
        }

        public final void writeInt(int i, int i2, int i3) {
            f out;
            int obj2;
            int obj3;
            int obj4;
            if (i < i2) {
                this.out.z0(i |= i3);
            }
            this.out.z0(i3 |= i2);
            i -= i2;
            obj3 = 128;
            while (obj2 >= obj3) {
                this.out.z0(obj3 |= obj4);
                obj2 >>>= 7;
                obj3 = 128;
            }
            this.out.z0(obj2);
        }
    }
    static {
        Hpack hpack = new Hpack();
        Hpack.INSTANCE = hpack;
        okhttp3.internal.http2.Header[] arr = new Header[61];
        final String str48 = "";
        Header header = new Header(Header.TARGET_AUTHORITY, str48);
        i tARGET_METHOD = Header.TARGET_METHOD;
        Header header2 = new Header(tARGET_METHOD, "GET");
        Header header3 = new Header(tARGET_METHOD, "POST");
        i tARGET_PATH = Header.TARGET_PATH;
        Header header4 = new Header(tARGET_PATH, "/");
        Header header5 = new Header(tARGET_PATH, "/index.html");
        i tARGET_SCHEME = Header.TARGET_SCHEME;
        Header header6 = new Header(tARGET_SCHEME, "http");
        Header header7 = new Header(tARGET_SCHEME, "https");
        i rESPONSE_STATUS = Header.RESPONSE_STATUS;
        Header header8 = new Header(rESPONSE_STATUS, "200");
        Header header9 = new Header(rESPONSE_STATUS, "204");
        Header header10 = new Header(rESPONSE_STATUS, "206");
        Header header11 = new Header(rESPONSE_STATUS, "304");
        Header header12 = new Header(rESPONSE_STATUS, "400");
        Header header13 = new Header(rESPONSE_STATUS, "404");
        Header header14 = new Header(rESPONSE_STATUS, "500");
        Header header15 = new Header("accept-charset", str48);
        Header header16 = new Header("accept-encoding", "gzip, deflate");
        Header header17 = new Header("accept-language", str48);
        Header header18 = new Header("accept-ranges", str48);
        Header header19 = new Header("accept", str48);
        Header header20 = new Header("access-control-allow-origin", str48);
        Header header21 = new Header("age", str48);
        Header header22 = new Header("allow", str48);
        Header header23 = new Header("authorization", str48);
        Header header24 = new Header("cache-control", str48);
        Header header25 = new Header("content-disposition", str48);
        Header header26 = new Header("content-encoding", str48);
        Header header27 = new Header("content-language", str48);
        Header header28 = new Header("content-length", str48);
        Header header29 = new Header("content-location", str48);
        Header header30 = new Header("content-range", str48);
        Header header31 = new Header("content-type", str48);
        Header header32 = new Header("cookie", str48);
        Header header33 = new Header("date", str48);
        Header header34 = new Header("etag", str48);
        Header header35 = new Header("expect", str48);
        Header header36 = new Header("expires", str48);
        Header header37 = new Header("from", str48);
        Header header38 = new Header("host", str48);
        Header header39 = new Header("if-match", str48);
        Header header40 = new Header("if-modified-since", str48);
        Header header41 = new Header("if-none-match", str48);
        Header header42 = new Header("if-range", str48);
        Header header43 = new Header("if-unmodified-since", str48);
        Header header44 = new Header("last-modified", str48);
        Header header45 = new Header("link", str48);
        Header header46 = new Header("location", str48);
        Header header47 = new Header("max-forwards", str48);
        Header header48 = new Header("proxy-authenticate", str48);
        Header header49 = new Header("proxy-authorization", str48);
        Header header50 = new Header("range", str48);
        Header header51 = new Header("referer", str48);
        Header header52 = new Header("refresh", str48);
        Header header53 = new Header("retry-after", str48);
        Header header54 = new Header("server", str48);
        Header header55 = new Header("set-cookie", str48);
        Header header56 = new Header("strict-transport-security", str48);
        Header header57 = new Header("transfer-encoding", str48);
        Header header58 = new Header("user-agent", str48);
        Header header59 = new Header("vary", str48);
        Header header60 = new Header("via", str48);
        Header header61 = new Header("www-authenticate", str48);
        Hpack.STATIC_HEADER_TABLE = arr;
        Hpack.NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private final Map<i, Integer> nameToFirstIndex() {
        int i;
        okhttp3.internal.http2.Header[] sTATIC_HEADER_TABLE;
        boolean valueOf;
        okhttp3.internal.http2.Header[] sTATIC_HEADER_TABLE2 = Hpack.STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(sTATIC_HEADER_TABLE2.length);
        i = 0;
        while (i < sTATIC_HEADER_TABLE2.length) {
            sTATIC_HEADER_TABLE = Hpack.STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(header2.name)) {
            }
            i++;
            linkedHashMap.put(header.name, Integer.valueOf(i));
        }
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        n.e(unmodifiableMap, "Collections.unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final i checkLowercase(i i) {
        int i2;
        byte b;
        byte b2;
        byte b3;
        n.f(i, "name");
        i2 = 0;
        while (i2 < i.A()) {
            b3 = i.j(i2);
            i2++;
        }
        return i;
    }

    public final Map<i, Integer> getNAME_TO_FIRST_INDEX() {
        return Hpack.NAME_TO_FIRST_INDEX;
    }

    public final okhttp3.internal.http2.Header[] getSTATIC_HEADER_TABLE() {
        return Hpack.STATIC_HEADER_TABLE;
    }
}
