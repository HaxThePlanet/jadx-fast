package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u0006\u0010\u0002\u001a\u0004\u0008\u0007\u0010\u0008R'\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u000b\u0010\u0002\u001a\u0004\u0008\u000c\u0010\u0008R'\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u000f\u0010\u0002\u001a\u0004\u0008\u0010\u0010\u0008R'\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u0013\u0010\u0002\u001a\u0004\u0008\u0014\u0010\u0008R'\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u0017\u0010\u0002\u001a\u0004\u0008\u0018\u0010\u0008R'\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\u0002\u001a\u0004\u0008\u001c\u0010\u0008R'\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\u0002\u001a\u0004\u0008 \u0010\u0008R'\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\"0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008#\u0010\u0002\u001a\u0004\u0008$\u0010\u0008R'\u0010%\u001a\u0008\u0012\u0004\u0012\u00020&0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008'\u0010\u0002\u001a\u0004\u0008(\u0010\u0008R'\u0010)\u001a\u0008\u0012\u0004\u0012\u00020*0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008+\u0010\u0002\u001a\u0004\u0008,\u0010\u0008R'\u0010-\u001a\u0008\u0012\u0004\u0012\u00020.0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008/\u0010\u0002\u001a\u0004\u00080\u0010\u0008R'\u00101\u001a\u0008\u0012\u0004\u0012\u0002020\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u00083\u0010\u0002\u001a\u0004\u00084\u0010\u0008R'\u00105\u001a\u0008\u0012\u0004\u0012\u0002060\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u00087\u0010\u0002\u001a\u0004\u00088\u0010\u0008R'\u00109\u001a\u0008\u0012\u0004\u0012\u00020:0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008;\u0010\u0002\u001a\u0004\u0008<\u0010\u0008R'\u0010=\u001a\u0008\u0012\u0004\u0012\u00020>0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008?\u0010\u0002\u001a\u0004\u0008@\u0010\u0008R'\u0010A\u001a\u0008\u0012\u0004\u0012\u00020B0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008C\u0010\u0002\u001a\u0004\u0008D\u0010\u0008R'\u0010E\u001a\u0008\u0012\u0004\u0012\u00020F0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008G\u0010\u0002\u001a\u0004\u0008H\u0010\u0008R'\u0010I\u001a\u0008\u0012\u0004\u0012\u00020J0\u00048Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008K\u0010\u0002\u001a\u0004\u0008L\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006M", d2 = {"Landroidx/compose/ui/node/Nodes;", "", "()V", "Any", "Landroidx/compose/ui/node/NodeKind;", "Landroidx/compose/ui/Modifier$Node;", "getAny-OLwlOKw$annotations", "getAny-OLwlOKw", "()I", "ApproachMeasure", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "getApproachMeasure-OLwlOKw$annotations", "getApproachMeasure-OLwlOKw", "CompositionLocalConsumer", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "getCompositionLocalConsumer-OLwlOKw$annotations", "getCompositionLocalConsumer-OLwlOKw", "Draw", "Landroidx/compose/ui/node/DrawModifierNode;", "getDraw-OLwlOKw$annotations", "getDraw-OLwlOKw", "FocusEvent", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "getFocusEvent-OLwlOKw$annotations", "getFocusEvent-OLwlOKw", "FocusProperties", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "getFocusProperties-OLwlOKw$annotations", "getFocusProperties-OLwlOKw", "FocusTarget", "Landroidx/compose/ui/focus/FocusTargetNode;", "getFocusTarget-OLwlOKw$annotations", "getFocusTarget-OLwlOKw", "GlobalPositionAware", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "getGlobalPositionAware-OLwlOKw$annotations", "getGlobalPositionAware-OLwlOKw", "KeyInput", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "getKeyInput-OLwlOKw$annotations", "getKeyInput-OLwlOKw", "Layout", "Landroidx/compose/ui/node/LayoutModifierNode;", "getLayout-OLwlOKw$annotations", "getLayout-OLwlOKw", "LayoutAware", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "getLayoutAware-OLwlOKw$annotations", "getLayoutAware-OLwlOKw", "Locals", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "getLocals-OLwlOKw$annotations", "getLocals-OLwlOKw", "ParentData", "Landroidx/compose/ui/node/ParentDataModifierNode;", "getParentData-OLwlOKw$annotations", "getParentData-OLwlOKw", "PointerInput", "Landroidx/compose/ui/node/PointerInputModifierNode;", "getPointerInput-OLwlOKw$annotations", "getPointerInput-OLwlOKw", "RotaryInput", "Landroidx/compose/ui/input/rotary/RotaryInputModifierNode;", "getRotaryInput-OLwlOKw$annotations", "getRotaryInput-OLwlOKw", "Semantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getSemantics-OLwlOKw$annotations", "getSemantics-OLwlOKw", "SoftKeyboardKeyInput", "Landroidx/compose/ui/input/key/SoftKeyboardInterceptionModifierNode;", "getSoftKeyboardKeyInput-OLwlOKw$annotations", "getSoftKeyboardKeyInput-OLwlOKw", "Traversable", "Landroidx/compose/ui/node/TraversableNode;", "getTraversable-OLwlOKw$annotations", "getTraversable-OLwlOKw", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Nodes {

    public static final int $stable;
    public static final androidx.compose.ui.node.Nodes INSTANCE;
    static {
        Nodes nodes = new Nodes();
        Nodes.INSTANCE = nodes;
    }

    public static final int getAny-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(1);
    }

    @JvmStatic
    public static void getAny-OLwlOKw$annotations() {
    }

    public static final int getApproachMeasure-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(512);
    }

    @JvmStatic
    public static void getApproachMeasure-OLwlOKw$annotations() {
    }

    public static final int getCompositionLocalConsumer-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(32768);
    }

    @JvmStatic
    public static void getCompositionLocalConsumer-OLwlOKw$annotations() {
    }

    public static final int getDraw-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(4);
    }

    @JvmStatic
    public static void getDraw-OLwlOKw$annotations() {
    }

    public static final int getFocusEvent-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(4096);
    }

    @JvmStatic
    public static void getFocusEvent-OLwlOKw$annotations() {
    }

    public static final int getFocusProperties-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(2048);
    }

    @JvmStatic
    public static void getFocusProperties-OLwlOKw$annotations() {
    }

    public static final int getFocusTarget-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(1024);
    }

    @JvmStatic
    public static void getFocusTarget-OLwlOKw$annotations() {
    }

    public static final int getGlobalPositionAware-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(256);
    }

    @JvmStatic
    public static void getGlobalPositionAware-OLwlOKw$annotations() {
    }

    public static final int getKeyInput-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(8192);
    }

    @JvmStatic
    public static void getKeyInput-OLwlOKw$annotations() {
    }

    public static final int getLayout-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(2);
    }

    @JvmStatic
    public static void getLayout-OLwlOKw$annotations() {
    }

    public static final int getLayoutAware-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(128);
    }

    @JvmStatic
    public static void getLayoutAware-OLwlOKw$annotations() {
    }

    public static final int getLocals-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(32);
    }

    @JvmStatic
    public static void getLocals-OLwlOKw$annotations() {
    }

    public static final int getParentData-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(64);
    }

    @JvmStatic
    public static void getParentData-OLwlOKw$annotations() {
    }

    public static final int getPointerInput-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(16);
    }

    @JvmStatic
    public static void getPointerInput-OLwlOKw$annotations() {
    }

    public static final int getRotaryInput-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(16384);
    }

    @JvmStatic
    public static void getRotaryInput-OLwlOKw$annotations() {
    }

    public static final int getSemantics-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(8);
    }

    @JvmStatic
    public static void getSemantics-OLwlOKw$annotations() {
    }

    public static final int getSoftKeyboardKeyInput-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(131072);
    }

    @JvmStatic
    public static void getSoftKeyboardKeyInput-OLwlOKw$annotations() {
    }

    public static final int getTraversable-OLwlOKw() {
        final int i = 0;
        return NodeKind.constructor-impl(262144);
    }

    @JvmStatic
    public static void getTraversable-OLwlOKw$annotations() {
    }
}
