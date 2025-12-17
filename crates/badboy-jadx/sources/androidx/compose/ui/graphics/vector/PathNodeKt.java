package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u001f\u001a\u00020 2\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0008H\u0002\u001ai\u0010'\u001a\u00020 2\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00082\u0006\u0010(\u001a\u00020\u000828\u0008\u0004\u0010)\u001a2\u0012\u0013\u0012\u00110%¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(-\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(.\u0012\u0004\u0012\u00020#0*H\u0082\u0008\u001a&\u0010/\u001a\u00020 2\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0008H\u0002\u001a4\u00100\u001a\u00020 *\u00020\u00012\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#01j\u0008\u0012\u0004\u0012\u00020#`22\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0008H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u00063", d2 = {"ArcToKey", "", "CloseKey", "CurveToKey", "HorizontalToKey", "LineToKey", "MoveToKey", "NUM_ARC_TO_ARGS", "", "NUM_CURVE_TO_ARGS", "NUM_HORIZONTAL_TO_ARGS", "NUM_LINE_TO_ARGS", "NUM_MOVE_TO_ARGS", "NUM_QUAD_TO_ARGS", "NUM_REFLECTIVE_CURVE_TO_ARGS", "NUM_REFLECTIVE_QUAD_TO_ARGS", "NUM_VERTICAL_TO_ARGS", "QuadToKey", "ReflectiveCurveToKey", "ReflectiveQuadToKey", "RelativeArcToKey", "RelativeCloseKey", "RelativeCurveToKey", "RelativeHorizontalToKey", "RelativeLineToKey", "RelativeMoveToKey", "RelativeQuadToKey", "RelativeReflectiveCurveToKey", "RelativeReflectiveQuadToKey", "RelativeVerticalToKey", "VerticalToKey", "pathMoveNodeFromArgs", "", "nodes", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "args", "", "count", "pathNodesFromArgs", "numArgs", "nodeFor", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "subArray", "start", "pathRelativeMoveNodeFromArgs", "addPathNodes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathNodeKt {

    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';
    public static final void addPathNodes(char $this$addPathNodes, ArrayList<androidx.compose.ui.graphics.vector.PathNode> nodes, float[] args, int count) {
        int i8;
        int i4;
        androidx.compose.ui.graphics.vector.PathNode.Close iNSTANCE;
        int i6;
        int index$iv4;
        int index$iv3;
        int index$iv2;
        int index$iv;
        int index$iv5;
        int i5;
        int relativeReflectiveQuadTo;
        androidx.compose.ui.graphics.vector.PathNode.RelativeLineTo relativeHorizontalTo;
        int arcTo;
        int relativeArcTo;
        int i9;
        int i;
        int i11;
        int i2;
        int i10;
        int i3;
        int i7;
        final int i12 = $this$addPathNodes;
        i8 = nodes;
        final float[] fArr = args;
        final int i21 = count;
        index$iv3 = 1;
        if (i12 == 122) {
            i4 = index$iv3;
        } else {
        }
        if (i4 != 0) {
            i8.add(PathNode.Close.INSTANCE);
        } else {
            if (i12 == 109) {
                PathNodeKt.pathRelativeMoveNodeFromArgs((List)i8, fArr, i21);
            } else {
                if (i12 == 77) {
                    PathNodeKt.pathMoveNodeFromArgs((List)i8, fArr, i21);
                } else {
                    index$iv2 = 2;
                    if (i12 == 108) {
                        iNSTANCE = 0;
                        index$iv3 = 0;
                        while (index$iv3 <= i21 - index$iv2) {
                            index$iv5 = index$iv3;
                            i5 = args;
                            relativeReflectiveQuadTo = 0;
                            relativeHorizontalTo = new PathNode.RelativeLineTo(i5[index$iv5], i5[index$iv5 + 1]);
                            (List)i8.add((PathNode)relativeHorizontalTo);
                            index$iv3 += index$iv2;
                        }
                    } else {
                        if (i12 == 76) {
                            iNSTANCE = 2;
                            index$iv4 = 0;
                            index$iv2 = 0;
                            while (index$iv2 <= i21 - iNSTANCE) {
                                index$iv5 = index$iv2;
                                i5 = args;
                                relativeReflectiveQuadTo = 0;
                                relativeHorizontalTo = new PathNode.LineTo(i5[index$iv5], i5[index$iv5 + 1]);
                                (List)i8.add((PathNode)relativeHorizontalTo);
                                index$iv2 += iNSTANCE;
                            }
                        } else {
                            if (i12 == 104) {
                                iNSTANCE = 0;
                                index$iv2 = 0;
                                while (index$iv2 <= i21 - index$iv3) {
                                    relativeReflectiveQuadTo = 0;
                                    relativeHorizontalTo = new PathNode.RelativeHorizontalTo(args[index$iv2]);
                                    (List)i8.add((PathNode)relativeHorizontalTo);
                                    index$iv2 += index$iv3;
                                }
                            } else {
                                if (i12 == 72) {
                                    iNSTANCE = 0;
                                    index$iv2 = 0;
                                    while (index$iv2 <= i21 - index$iv3) {
                                        relativeReflectiveQuadTo = 0;
                                        relativeHorizontalTo = new PathNode.HorizontalTo(args[index$iv2]);
                                        (List)i8.add((PathNode)relativeHorizontalTo);
                                        index$iv2 += index$iv3;
                                    }
                                } else {
                                    if (i12 == 118) {
                                        iNSTANCE = 0;
                                        index$iv2 = 0;
                                        while (index$iv2 <= i21 - index$iv3) {
                                            relativeReflectiveQuadTo = 0;
                                            relativeHorizontalTo = new PathNode.RelativeVerticalTo(args[index$iv2]);
                                            (List)i8.add((PathNode)relativeHorizontalTo);
                                            index$iv2 += index$iv3;
                                        }
                                    } else {
                                        if (i12 == 86) {
                                            iNSTANCE = 0;
                                            index$iv2 = 0;
                                            while (index$iv2 <= i21 - index$iv3) {
                                                relativeReflectiveQuadTo = 0;
                                                relativeHorizontalTo = new PathNode.VerticalTo(args[index$iv2]);
                                                (List)i8.add((PathNode)relativeHorizontalTo);
                                                index$iv2 += index$iv3;
                                            }
                                        } else {
                                            if (i12 == 99) {
                                                iNSTANCE = 6;
                                                index$iv4 = 0;
                                                index$iv2 = 0;
                                                while (index$iv2 <= i21 - iNSTANCE) {
                                                    index$iv5 = index$iv2;
                                                    i5 = args;
                                                    relativeReflectiveQuadTo = 0;
                                                    relativeHorizontalTo = new PathNode.RelativeCurveTo(i5[index$iv5], i5[index$iv5 + 1], i5[index$iv5 + 2], i5[index$iv5 + 3], i5[index$iv5 + 4], i5[index$iv5 + 5]);
                                                    (List)i8.add((PathNode)relativeHorizontalTo);
                                                    index$iv2 += iNSTANCE;
                                                }
                                            } else {
                                                if (i12 == 67) {
                                                    iNSTANCE = 6;
                                                    index$iv4 = 0;
                                                    index$iv2 = 0;
                                                    while (index$iv2 <= i21 - iNSTANCE) {
                                                        index$iv5 = index$iv2;
                                                        i5 = args;
                                                        relativeReflectiveQuadTo = 0;
                                                        relativeHorizontalTo = new PathNode.CurveTo(i5[index$iv5], i5[index$iv5 + 1], i5[index$iv5 + 2], i5[index$iv5 + 3], i5[index$iv5 + 4], i5[index$iv5 + 5]);
                                                        (List)i8.add((PathNode)relativeHorizontalTo);
                                                        index$iv2 += iNSTANCE;
                                                    }
                                                } else {
                                                    index$iv = 4;
                                                    if (i12 == 115) {
                                                        iNSTANCE = 0;
                                                        index$iv3 = 0;
                                                        while (index$iv3 <= i21 - index$iv) {
                                                            index$iv5 = index$iv3;
                                                            i5 = args;
                                                            relativeReflectiveQuadTo = 0;
                                                            relativeHorizontalTo = new PathNode.RelativeReflectiveCurveTo(i5[index$iv5], i5[index$iv5 + 1], i5[index$iv5 + 2], i5[index$iv5 + 3]);
                                                            (List)i8.add((PathNode)relativeHorizontalTo);
                                                            index$iv3 += index$iv;
                                                            i8 = nodes;
                                                        }
                                                    } else {
                                                        if (i12 == 83) {
                                                            i8 = 0;
                                                            index$iv4 = 0;
                                                            while (index$iv4 <= i21 - index$iv) {
                                                                index$iv2 = index$iv4;
                                                                index$iv5 = args;
                                                                i5 = 0;
                                                                relativeReflectiveQuadTo = new PathNode.ReflectiveCurveTo(index$iv5[index$iv2], index$iv5[index$iv2 + 1], index$iv5[index$iv2 + 2], index$iv5[index$iv2 + 3]);
                                                                (List)nodes.add((PathNode)relativeReflectiveQuadTo);
                                                                index$iv4 += index$iv;
                                                            }
                                                        } else {
                                                            if (i12 == 113) {
                                                                i8 = 0;
                                                                index$iv4 = 0;
                                                                while (index$iv4 <= i21 - index$iv) {
                                                                    index$iv2 = index$iv4;
                                                                    index$iv5 = args;
                                                                    i5 = 0;
                                                                    relativeReflectiveQuadTo = new PathNode.RelativeQuadTo(index$iv5[index$iv2], index$iv5[index$iv2 + 1], index$iv5[index$iv2 + 2], index$iv5[index$iv2 + 3]);
                                                                    (List)nodes.add((PathNode)relativeReflectiveQuadTo);
                                                                    index$iv4 += index$iv;
                                                                }
                                                            } else {
                                                                if (i12 == 81) {
                                                                    i8 = 4;
                                                                    iNSTANCE = 0;
                                                                    index$iv3 = 0;
                                                                    while (index$iv3 <= i21 - i8) {
                                                                        index$iv = index$iv3;
                                                                        index$iv5 = args;
                                                                        i5 = 0;
                                                                        relativeReflectiveQuadTo = new PathNode.QuadTo(index$iv5[index$iv], index$iv5[index$iv + 1], index$iv5[index$iv + 2], index$iv5[index$iv + 3]);
                                                                        (List)nodes.add((PathNode)relativeReflectiveQuadTo);
                                                                        index$iv3 += i8;
                                                                    }
                                                                } else {
                                                                    if (i12 == 116) {
                                                                        i8 = 0;
                                                                        index$iv4 = 0;
                                                                        while (index$iv4 <= i21 - index$iv2) {
                                                                            index$iv = index$iv4;
                                                                            index$iv5 = args;
                                                                            i5 = 0;
                                                                            relativeReflectiveQuadTo = new PathNode.RelativeReflectiveQuadTo(index$iv5[index$iv], index$iv5[index$iv + 1]);
                                                                            (List)nodes.add((PathNode)relativeReflectiveQuadTo);
                                                                            index$iv4 += index$iv2;
                                                                        }
                                                                    } else {
                                                                        if (i12 == 84) {
                                                                            i8 = 0;
                                                                            index$iv4 = 0;
                                                                            while (index$iv4 <= i21 - index$iv2) {
                                                                                index$iv = index$iv4;
                                                                                index$iv5 = args;
                                                                                i5 = 0;
                                                                                relativeReflectiveQuadTo = new PathNode.ReflectiveQuadTo(index$iv5[index$iv], index$iv5[index$iv + 1]);
                                                                                (List)nodes.add((PathNode)relativeReflectiveQuadTo);
                                                                                index$iv4 += index$iv2;
                                                                            }
                                                                        } else {
                                                                            iNSTANCE = 0;
                                                                            if (i12 == 97) {
                                                                                i8 = 7;
                                                                                index$iv2 = 0;
                                                                                index$iv5 = 0;
                                                                                while (index$iv5 <= i21 - i8) {
                                                                                    relativeReflectiveQuadTo = index$iv5;
                                                                                    relativeHorizontalTo = args;
                                                                                    arcTo = 0;
                                                                                    if (Float.compare(relativeHorizontalTo[relativeReflectiveQuadTo + 3], iNSTANCE) != 0) {
                                                                                    } else {
                                                                                    }
                                                                                    i2 = 0;
                                                                                    if (Float.compare(relativeHorizontalTo[relativeReflectiveQuadTo + 4], iNSTANCE) != 0) {
                                                                                    } else {
                                                                                    }
                                                                                    i10 = 0;
                                                                                    relativeArcTo = new PathNode.RelativeArcTo(relativeHorizontalTo[relativeReflectiveQuadTo], relativeHorizontalTo[relativeReflectiveQuadTo + 1], relativeHorizontalTo[relativeReflectiveQuadTo + 2], i2, i10, relativeHorizontalTo[relativeReflectiveQuadTo + 5], relativeHorizontalTo[relativeReflectiveQuadTo + 6]);
                                                                                    (List)nodes.add((PathNode)relativeArcTo);
                                                                                    index$iv5 += i8;
                                                                                    i10 = index$iv3;
                                                                                    i2 = index$iv3;
                                                                                }
                                                                            } else {
                                                                                if (i12 != 65) {
                                                                                } else {
                                                                                    i8 = 7;
                                                                                    index$iv4 = 0;
                                                                                    index$iv = 0;
                                                                                    while (index$iv <= i21 - i8) {
                                                                                        i5 = index$iv;
                                                                                        relativeReflectiveQuadTo = args;
                                                                                        relativeHorizontalTo = 0;
                                                                                        if (Float.compare(relativeReflectiveQuadTo[i5 + 3], iNSTANCE) != 0) {
                                                                                        } else {
                                                                                        }
                                                                                        i11 = 0;
                                                                                        if (Float.compare(relativeReflectiveQuadTo[i5 + 4], iNSTANCE) != 0) {
                                                                                        } else {
                                                                                        }
                                                                                        i2 = 0;
                                                                                        arcTo = new PathNode.ArcTo(relativeReflectiveQuadTo[i5], relativeReflectiveQuadTo[i5 + 1], relativeReflectiveQuadTo[i5 + 2], i11, i2, relativeReflectiveQuadTo[i5 + 5], relativeReflectiveQuadTo[i5 + 6]);
                                                                                        (List)nodes.add((PathNode)arcTo);
                                                                                        index$iv += i8;
                                                                                        index$iv3 = 1;
                                                                                        i2 = 1;
                                                                                        i11 = 1;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unknown command for: ").append(i12).toString());
        throw illegalArgumentException;
    }

    private static final void pathMoveNodeFromArgs(List<androidx.compose.ui.graphics.vector.PathNode> nodes, float[] args, int count) {
        int index;
        int lineTo;
        int i;
        int i2;
        final int i3 = count + -2;
        if (i3 >= 0) {
            PathNode.MoveTo moveTo = new PathNode.MoveTo(args[0], args[1]);
            nodes.add(moveTo);
            index = 2;
            while (index <= i3) {
                lineTo = new PathNode.LineTo(args[index], args[index + 1]);
                nodes.add(lineTo);
                index += 2;
            }
        }
    }

    private static final void pathNodesFromArgs(List<androidx.compose.ui.graphics.vector.PathNode> nodes, float[] args, int count, int numArgs, Function2<? super float[], ? super Integer, ? extends androidx.compose.ui.graphics.vector.PathNode> nodeFor) {
        int index;
        Object invoke;
        final int i = 0;
        index = 0;
        while (index <= count - numArgs) {
            nodes.add(nodeFor.invoke(args, Integer.valueOf(index)));
            index += numArgs;
        }
    }

    private static final void pathRelativeMoveNodeFromArgs(List<androidx.compose.ui.graphics.vector.PathNode> nodes, float[] args, int count) {
        int index;
        int relativeLineTo;
        int i2;
        int i;
        final int i3 = count + -2;
        if (i3 >= 0) {
            PathNode.RelativeMoveTo relativeMoveTo = new PathNode.RelativeMoveTo(args[0], args[1]);
            nodes.add(relativeMoveTo);
            index = 2;
            while (index <= i3) {
                relativeLineTo = new PathNode.RelativeLineTo(args[index], args[index + 1]);
                nodes.add(relativeLineTo);
                index += 2;
            }
        }
    }
}
