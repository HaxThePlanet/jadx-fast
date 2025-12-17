package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u00020\u00002\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\nJ\u0006\u0010\u000b\u001a\u00020\u000cJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ8\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u00082\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0008\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u0008J\u0011\u0010\u0011\u001a\u00020\u000c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082\u0008J\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00070\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Landroidx/compose/ui/graphics/vector/PathParser;", "", "()V", "nodeData", "", "nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "addPathNodes", "", "clear", "", "parsePathString", "pathData", "", "pathStringToNodes", "resizeNodeData", "dataCount", "", "toNodes", "toPath", "Landroidx/compose/ui/graphics/Path;", "target", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathParser {

    private float[] nodeData;
    private ArrayList<androidx.compose.ui.graphics.vector.PathNode> nodes;
    public PathParser() {
        super();
        this.nodeData = new float[64];
    }

    public static ArrayList pathStringToNodes$default(androidx.compose.ui.graphics.vector.PathParser pathParser, String string2, ArrayList arrayList3, int i4, Object object5) {
        ArrayList obj2;
        if (i4 &= 2 != 0) {
            obj2 = new ArrayList();
        }
        return pathParser.pathStringToNodes(string2, obj2);
    }

    private final void resizeNodeData(int dataCount) {
        int nodeData;
        float[] nodeData2;
        int length;
        int i;
        final int i2 = 0;
        if (dataCount >= nodeData3.length) {
            nodeData = this.nodeData;
            this.nodeData = new float[dataCount * 2];
            i = 0;
            ArraysKt.copyInto(nodeData, this.nodeData, i, i, nodeData.length);
        }
    }

    public static Path toPath$default(androidx.compose.ui.graphics.vector.PathParser pathParser, Path path2, int i3, Object object4) {
        Path obj1;
        if (i3 &= 1 != 0) {
            obj1 = AndroidPath_androidKt.Path();
        }
        return pathParser.toPath(obj1);
    }

    public final androidx.compose.ui.graphics.vector.PathParser addPathNodes(List<? extends androidx.compose.ui.graphics.vector.PathNode> nodes) {
        ArrayList dstNodes;
        ArrayList arrayList;
        if (this.nodes == null) {
            arrayList = new ArrayList();
            this.nodes = arrayList;
        }
        dstNodes.addAll((Collection)nodes);
        return this;
    }

    public final void clear() {
        final ArrayList nodes = this.nodes;
        if (nodes != null) {
            nodes.clear();
        }
    }

    public final androidx.compose.ui.graphics.vector.PathParser parsePathString(String pathData) {
        ArrayList dstNodes;
        ArrayList arrayList;
        dstNodes = this.nodes;
        if (dstNodes == null) {
            arrayList = new ArrayList();
            this.nodes = arrayList;
        } else {
            dstNodes.clear();
        }
        pathStringToNodes(pathData, dstNodes);
        return this;
    }

    public final ArrayList<androidx.compose.ui.graphics.vector.PathNode> pathStringToNodes(String pathData, ArrayList<androidx.compose.ui.graphics.vector.PathNode> nodes) {
        int start2;
        int end;
        int value;
        int dataCount;
        int naN;
        int compare2;
        int dataCount2;
        int compare;
        int c;
        int command;
        int index;
        int nextFloat;
        int i2;
        int nodeData2;
        float[] nodeData;
        int length;
        long l;
        int start;
        int i;
        final Object obj = this;
        final String str = pathData;
        final ArrayList list = nodes;
        start2 = 0;
        value = 0;
        naN = 32;
        while (start2 < str.length()) {
            if (Intrinsics.compare(str.charAt(start2), naN) <= 0) {
            }
            start2++;
            naN = 32;
        }
        while (end > start2) {
            if (Intrinsics.compare(str.charAt(end + -1), naN) <= 0) {
            }
            end--;
        }
        dataCount2 = start2;
        while (dataCount2 < end) {
            c = 0;
            command = 0;
            index = dataCount2 + 1;
            c = str.charAt(dataCount2);
            int i8 = c | 32;
            while (i13 *= i2 <= 0) {
                if (i8 != 101) {
                    break loop_10;
                } else {
                }
                if (index < end) {
                    break loop_10;
                }
                start = start2;
                dataCount2 = index;
                naN = 32;
                index = dataCount2 + 1;
                c = str.charAt(dataCount2);
                i8 = c | 32;
            }
            if (index < end) {
            }
            start = start2;
            dataCount2 = index;
            naN = 32;
            if (command != 0) {
            } else {
            }
            start = start2;
            dataCount2 = index;
            naN = 32;
            if (command | 32 != 122) {
            } else {
            }
            start = start2;
            dataCount2 = index;
            PathNodeKt.addPathNodes(command, list, obj.nodeData, value);
            start2 = start;
            naN = 32;
            dataCount = 0;
            while (index < end) {
                if (Intrinsics.compare(str.charAt(index), naN) <= 0) {
                }
                nodeData2 = nextFloat;
                int i15 = i9;
                int i10 = 0;
                int i11 = dataCount;
                i = i5;
                int i6 = 0;
                float bits$iv$iv = Float.intBitsToFloat((int)dataCount3);
                if (!Float.isNaN(bits$iv$iv)) {
                } else {
                }
                start = start2;
                compare = i11;
                index = i;
                while (index < end) {
                    if (str.charAt(index) == true) {
                    }
                    index++;
                }
                if (index < end) {
                    break loop_17;
                }
                if (Float.isNaN(bits$iv$iv)) {
                    break loop_17;
                } else {
                }
                dataCount = compare;
                start2 = start;
                naN = 32;
                if (str.charAt(index) == true) {
                }
                index++;
                compare = i11 + 1;
                obj.nodeData[i11] = bits$iv$iv;
                naN = this;
                int i12 = 0;
                if (compare >= nodeData5.length) {
                } else {
                }
                start = start2;
                index = i;
                nodeData2 = naN.nodeData;
                naN.nodeData = new float[compare * 2];
                start = start2;
                start2 = 0;
                ArraysKt.copyInto(nodeData2, naN.nodeData, start2, start2, nodeData2.length);
                index++;
            }
            nodeData2 = nextFloat;
            i15 = i9;
            i10 = 0;
            i11 = dataCount;
            i = i5;
            i6 = 0;
            bits$iv$iv = Float.intBitsToFloat((int)dataCount3);
            if (!Float.isNaN(bits$iv$iv)) {
            } else {
            }
            start = start2;
            compare = i11;
            index = i;
            while (index < end) {
                if (str.charAt(index) == true) {
                }
                index++;
            }
            if (index < end) {
            }
            value = compare;
            dataCount2 = index;
            if (Float.isNaN(bits$iv$iv)) {
            } else {
            }
            dataCount = compare;
            start2 = start;
            naN = 32;
            if (str.charAt(index) == true) {
            }
            index++;
            compare = i11 + 1;
            obj.nodeData[i11] = bits$iv$iv;
            naN = this;
            i12 = 0;
            if (compare >= nodeData5.length) {
            } else {
            }
            start = start2;
            index = i;
            nodeData2 = naN.nodeData;
            naN.nodeData = new float[compare * 2];
            start = start2;
            start2 = 0;
            ArraysKt.copyInto(nodeData2, naN.nodeData, start2, start2, nodeData2.length);
            if (Intrinsics.compare(str.charAt(index), naN) <= 0) {
            }
            index++;
            if (i8 != 101) {
            } else {
            }
            command = c;
        }
        return list;
    }

    public final List<androidx.compose.ui.graphics.vector.PathNode> toNodes() {
        Object emptyList;
        if (this.nodes != null) {
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        return emptyList;
    }

    public final Path toPath(Path target) {
        Path nodes;
        nodes = this.nodes;
        if (nodes != null) {
            if (PathParserKt.toPath((List)nodes, target) == null) {
                nodes = AndroidPath_androidKt.Path();
            }
        } else {
        }
        return nodes;
    }
}
