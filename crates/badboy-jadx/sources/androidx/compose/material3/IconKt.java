package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorFilter.Companion;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale.Companion;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00012\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\t\u001a\u0004\u0018\u00010\u000f2\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00012\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u0011\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00012\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/ColorProducer;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "defaultSizeForColorProducer", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IconKt {

    private static final Modifier DefaultIconSizeModifier;
    static {
        IconKt.DefaultIconSizeModifier = SizeKt.size-3ABfNKs((Modifier)Modifier.Companion, IconButtonTokens.INSTANCE.getIconSize-D9Ej5fM());
    }

    public static final void Icon(Painter painter, ColorProducer tint, String contentDescription, Modifier modifier, Composer $composer, int $changed, int i7) {
        int traceInProgress2;
        int $dirty2;
        Object semantics;
        int $dirty;
        boolean traceInProgress;
        Modifier semantics$default;
        int i;
        int i5;
        int i3;
        int defaultSizeForColorProducer;
        int i8;
        int i4;
        Object obj;
        int i6;
        int i2;
        Object rememberedValue2;
        int i9;
        Object rememberedValue;
        Object anon;
        Composer.Companion companion;
        final Object obj2 = painter;
        final Object obj3 = tint;
        final Object obj4 = contentDescription;
        final int i13 = $changed;
        traceInProgress2 = 1755070997;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Icon)P(2,3)206@9303L163,202@9171L330:Icon.kt#uh7d8r");
        $dirty2 = $changed;
        if (i7 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i13 & 6 == 0) {
                i = restartGroup.changedInstance(obj2) ? 4 : 2;
                $dirty2 |= i;
            }
        }
        if (i7 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i13 & 48 == 0) {
                i5 = restartGroup.changedInstance(obj3) ? 32 : 16;
                $dirty2 |= i5;
            }
        }
        i8 = 256;
        if (i7 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (i13 & 384 == 0) {
                i3 = restartGroup.changed(obj4) ? i8 : 128;
                $dirty2 |= i3;
            }
        }
        defaultSizeForColorProducer = i7 & 8;
        if (defaultSizeForColorProducer != 0) {
            $dirty2 |= 3072;
            obj = modifier;
        } else {
            if (i13 & 3072 == 0) {
                i6 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty2 |= i6;
            } else {
                obj = modifier;
            }
        }
        int i16 = $dirty2;
        if (i16 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (defaultSizeForColorProducer != 0) {
                    obj = $dirty;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i16, -1, "androidx.compose.material3.Icon (Icon.kt:191)");
                }
                restartGroup.startReplaceGroup(-2144829472);
                ComposerKt.sourceInformation(restartGroup, "194@9002L115");
                String str2 = "CC(remember):Icon.kt#9igjgp";
                if (obj4 != null) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -2144827505, str2);
                    i4 = i16 & 896 == i8 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    i9 = 0;
                    rememberedValue = composer2.rememberedValue();
                    anon = 0;
                    if (i4 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            traceInProgress = 0;
                            rememberedValue2 = new IconKt.Icon.semantics.2.1(obj4);
                            composer2.updateRememberedValue((Function1)rememberedValue2);
                        } else {
                            rememberedValue2 = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    semantics$default = SemanticsModifierKt.semantics$default((Modifier)Modifier.Companion, false, (Function1)rememberedValue2, 1, 0);
                } else {
                    semantics$default = Modifier.Companion;
                }
                restartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2144817825, str2);
                Composer composer = restartGroup;
                i2 = 0;
                rememberedValue2 = composer.rememberedValue();
                i9 = 0;
                if (changedInstance |= changedInstance4 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue = 0;
                        anon = new IconKt.Icon.4.1(obj2, obj3);
                        composer.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                BoxKt.Box(DrawModifierKt.drawBehind(IconKt.defaultSizeForColorProducer(GraphicsLayerModifierKt.toolingGraphicsLayer(obj), obj2), (Function1)anon).then(semantics$default), restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                semantics = obj;
            } else {
                restartGroup.skipToGroupEnd();
                semantics = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new IconKt.Icon.5(obj2, obj3, obj4, semantics, i13, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void Icon-ww6aTOc(ImageBitmap bitmap, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i7) {
        Object $this$cache$iv;
        Object anon;
        boolean traceInProgress2;
        int $dirty;
        boolean traceInProgress;
        Object rememberedValue;
        int i6;
        int i9;
        Object modifier2;
        Object obj2;
        Object $this$cache$iv2;
        long l;
        int i;
        long l2;
        int i2;
        int changed;
        int defaultsInvalid;
        Composer composer;
        Composer composer2;
        int i10;
        int i11;
        Object obj4;
        Object obj;
        long l3;
        int i3;
        int i5;
        int i4;
        int i8;
        Composer composer3;
        Object obj3;
        traceInProgress2 = bitmap;
        int i21 = i7;
        anon = -1092052280;
        final Composer restartGroup = $changed.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(Icon)P(!,3:c#ui.graphics.Color)105@5106L7,107@5136L42,108@5183L136:Icon.kt#uh7d8r");
        $dirty = i7;
        if (obj28 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i21 & 6 == 0) {
                i6 = restartGroup.changedInstance(traceInProgress2) ? 4 : 2;
                $dirty |= i6;
            }
        }
        if (obj28 & 2 != 0) {
            $dirty |= 48;
            obj4 = contentDescription;
        } else {
            if (i21 & 48 == 0) {
                i9 = restartGroup.changed(contentDescription) ? 32 : 16;
                $dirty |= i9;
            } else {
                obj4 = contentDescription;
            }
        }
        int i15 = obj28 & 4;
        if (i15 != 0) {
            $dirty |= 384;
            $this$cache$iv2 = modifier;
        } else {
            if (i21 & 384 == 0) {
                i = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i;
            } else {
                $this$cache$iv2 = modifier;
            }
        }
        if (i21 & 3072 == 0) {
            if (obj28 & 8 == 0) {
                changed = restartGroup.changed(tint) ? 2048 : 1024;
            } else {
                l2 = tint;
            }
            $dirty |= changed;
        } else {
            l2 = tint;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i21 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = $this$cache$iv2;
                        }
                        if (obj28 & 8 != 0) {
                            defaultsInvalid = 6;
                            int i23 = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            i10 = $dirty;
                            obj = modifier2;
                            l3 = $this$cache$iv2;
                        } else {
                            i10 = $dirty;
                            obj = modifier2;
                            l3 = l2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj28 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        i10 = $dirty;
                        obj = $this$cache$iv2;
                        l3 = l2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, i10, -1, "androidx.compose.material3.Icon (Icon.kt:106)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2144951290, "CC(remember):Icon.kt#9igjgp");
                $this$cache$iv = restartGroup;
                int i25 = 0;
                rememberedValue = $this$cache$iv.rememberedValue();
                i4 = 0;
                if (!restartGroup.changed(traceInProgress2)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        i8 = 0;
                        modifier2 = $this$cache$iv;
                        l2 = rememberedValue;
                        obj3 = l2;
                        $this$cache$iv = new BitmapPainter(traceInProgress2, 0, modifier2, 0, l2, 6, 0);
                        modifier2.updateRememberedValue($this$cache$iv);
                    } else {
                        composer = $this$cache$iv;
                        obj3 = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                IconKt.Icon-ww6aTOc((Painter)(BitmapPainter)rememberedValue, obj4, obj, l3, obj13, restartGroup, i14 | i17);
                composer2 = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj;
                l = l3;
                i11 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = $this$cache$iv2;
                l = l2;
                composer2 = restartGroup;
                i11 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new IconKt.Icon.2(bitmap, contentDescription, obj2, l, l2, i7, obj28);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    public static final void Icon-ww6aTOc(Painter painter, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i7) {
        int traceInProgress2;
        int changed2;
        int i8;
        Modifier semantics$default;
        Object obj2;
        int $dirty2;
        int i14;
        int i;
        Object obj3;
        Object modifier2;
        boolean traceInProgress;
        int i9;
        int str;
        long l;
        Object obj4;
        int i2;
        Object semantics;
        int i11;
        int i10;
        boolean skipping;
        int defaultsInvalid;
        boolean changed;
        int i3;
        Object rememberedValue;
        int i6;
        int i12;
        Object obj;
        long l2;
        Modifier colorFilter;
        Object it$iv;
        long l3;
        String str2;
        int $dirty;
        Composer.Companion companion;
        int i13;
        int i4;
        int i5;
        int obj24;
        obj2 = painter;
        obj = contentDescription;
        final int i27 = i7;
        traceInProgress2 = -2142239481;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Icon)P(2!,3:c#ui.graphics.Color)142@6849L7,145@6891L82,155@7235L217:Icon.kt#uh7d8r");
        $dirty2 = i7;
        if (obj27 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i27 & 6 == 0) {
                i14 = restartGroup.changedInstance(obj2) ? 4 : 2;
                $dirty2 |= i14;
            }
        }
        if (obj27 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i27 & 48 == 0) {
                i = restartGroup.changed(obj) ? 32 : 16;
                $dirty2 |= i;
            }
        }
        int i18 = obj27 & 4;
        if (i18 != 0) {
            $dirty2 |= 384;
            semantics = modifier;
        } else {
            if (i27 & 384 == 0) {
                i11 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i11;
            } else {
                semantics = modifier;
            }
        }
        i3 = 2048;
        if (i27 & 3072 == 0) {
            if (obj27 & 8 == 0) {
                i10 = restartGroup.changed(tint) ? i3 : 1024;
            } else {
                l2 = tint;
            }
            $dirty2 |= i10;
        } else {
            l2 = tint;
        }
        if ($dirty2 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i27 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = semantics;
                        }
                        if (obj27 & 8 != 0) {
                            defaultsInvalid = 6;
                            i6 = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty2 &= -7169;
                            l2 = modifier2;
                            l3 = semantics;
                        } else {
                            l3 = l2;
                            l2 = modifier2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj27 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        l3 = l2;
                        l2 = semantics;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.Icon (Icon.kt:143)");
                }
                str = "CC(remember):Icon.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2144895090, str);
                if (i16 ^= 3072 > i3) {
                    if (!restartGroup.changed(l3)) {
                        i8 = $dirty2 & 3072 == i3 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                rememberedValue = restartGroup;
                i12 = 0;
                it$iv = rememberedValue.rememberedValue();
                i5 = 0;
                if (i8 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        int i25 = 0;
                        obj24 = i25;
                        if (Color.equals-impl0(l3, str2)) {
                            obj4 = it$iv;
                            semantics = 0;
                        } else {
                            obj4 = it$iv;
                            semantics = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, l3, str2, 0, 2);
                        }
                        rememberedValue.updateRememberedValue(semantics);
                    } else {
                        obj4 = it$iv;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                restartGroup.startReplaceGroup(-2144891392);
                ComposerKt.sourceInformation(restartGroup, "148@7067L115");
                if (obj != null) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -2144889425, str);
                    i9 = $dirty2 & 112 == 32 ? 1 : 0;
                    Composer composer = restartGroup;
                    int i24 = 0;
                    rememberedValue = composer.rememberedValue();
                    i12 = 0;
                    if (i9 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            defaultsInvalid = 0;
                            $dirty = $dirty2;
                            $dirty2 = new IconKt.Icon.semantics.1.1(obj);
                            composer.updateRememberedValue((Function1)$dirty2);
                        } else {
                            $dirty = $dirty2;
                            $dirty2 = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    semantics$default = SemanticsModifierKt.semantics$default((Modifier)Modifier.Companion, false, (Function1)$dirty2, 1, 0);
                } else {
                    $dirty = $dirty2;
                    i2 = 0;
                    semantics$default = Modifier.Companion;
                }
                restartGroup.endReplaceGroup();
                BoxKt.Box(PainterModifierKt.paint$default(IconKt.defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(l2), obj2), obj2, false, 0, ContentScale.Companion.getFit(), 0, (ColorFilter)it$iv, 22, 0).then(semantics$default), restartGroup, i2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = l2;
                l = l3;
            } else {
                restartGroup.skipToGroupEnd();
                $dirty = $dirty2;
                obj3 = semantics;
                l = l2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new IconKt.Icon.3(painter, contentDescription, obj3, l, semantics, i27, obj27);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void Icon-ww6aTOc(ImageVector imageVector, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i7) {
        int traceInProgress;
        int $dirty;
        int i6;
        int i2;
        int i4;
        int modifier2;
        boolean traceInProgress2;
        Object unbox-impl;
        int i8;
        long l2;
        int changed;
        boolean skipping;
        boolean defaultsInvalid;
        Object obj;
        int i5;
        int i9;
        long l;
        String str;
        int i;
        int i3;
        final int i18 = i7;
        traceInProgress = -126890956;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Icon)P(1!,3:c#ui.graphics.Color)69@3394L7,72@3434L34,71@3410L163:Icon.kt#uh7d8r");
        $dirty = i7;
        if (obj22 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i18 & 6 == 0) {
                i6 = restartGroup.changed(imageVector) ? 4 : 2;
                $dirty |= i6;
            }
        }
        if (obj22 & 2 != 0) {
            $dirty |= 48;
            obj = contentDescription;
        } else {
            if (i18 & 48 == 0) {
                i2 = restartGroup.changed(contentDescription) ? 32 : 16;
                $dirty |= i2;
            } else {
                obj = contentDescription;
            }
        }
        i4 = obj22 & 4;
        if (i4 != 0) {
            $dirty |= 384;
            unbox-impl = modifier;
        } else {
            if (i18 & 384 == 0) {
                i8 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i8;
            } else {
                unbox-impl = modifier;
            }
        }
        if (i18 & 3072 == 0) {
            if (obj22 & 8 == 0) {
                changed = restartGroup.changed(tint) ? 2048 : 1024;
            } else {
                l2 = tint;
            }
            $dirty |= changed;
        } else {
            l2 = tint;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i18 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i4 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = unbox-impl;
                        }
                        if (obj22 & 8 != 0) {
                            defaultsInvalid = 6;
                            int i19 = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty &= -7169;
                            i9 = modifier2;
                            l = unbox-impl;
                        } else {
                            i9 = modifier2;
                            l = l2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj22 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        i9 = unbox-impl;
                        l = l2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.Icon (Icon.kt:70)");
                }
                IconKt.Icon-ww6aTOc((Painter)VectorPainterKt.rememberVectorPainter(imageVector, restartGroup, $dirty & 14), obj, i9, l, str, restartGroup, i12 | i4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                unbox-impl = i9;
                l2 = l;
                i5 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                i5 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new IconKt.Icon.1(imageVector, contentDescription, unbox-impl, l2, obj5, i18, obj22);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final Modifier defaultSizeFor(Modifier $this$defaultSizeFor, Painter painter) {
        Modifier defaultIconSizeModifier;
        boolean infinite-uvyYCjk;
        if (!Size.equals-impl0(painter.getIntrinsicSize-NH-jbRc(), obj1)) {
            if (IconKt.isInfinite-uvyYCjk(painter.getIntrinsicSize-NH-jbRc())) {
                defaultIconSizeModifier = IconKt.DefaultIconSizeModifier;
            } else {
                defaultIconSizeModifier = Modifier.Companion;
            }
        } else {
        }
        return $this$defaultSizeFor.then(defaultIconSizeModifier);
    }

    private static final Modifier defaultSizeForColorProducer(Modifier $this$defaultSizeForColorProducer, Painter painter) {
        long intrinsicSize-NH-jbRc;
        float unspecified-NH-jbRc;
        float height-impl;
        Modifier defaultIconSizeModifier;
        androidx.compose.material3.IconKt.defaultSizeForColorProducer.1 anon;
        if (!Size.equals-impl0(painter.getIntrinsicSize-NH-jbRc(), obj1)) {
            if (IconKt.isInfinite-uvyYCjk(painter.getIntrinsicSize-NH-jbRc())) {
                defaultIconSizeModifier = IconKt.DefaultIconSizeModifier;
            } else {
                intrinsicSize-NH-jbRc = painter.getIntrinsicSize-NH-jbRc();
                anon = new IconKt.defaultSizeForColorProducer.1(Size.getWidth-impl(intrinsicSize-NH-jbRc), Size.getHeight-impl(intrinsicSize-NH-jbRc));
                defaultIconSizeModifier = LayoutModifierKt.layout((Modifier)Modifier.Companion, (Function3)anon);
            }
        } else {
        }
        return $this$defaultSizeForColorProducer.then(defaultIconSizeModifier);
    }

    private static final boolean isInfinite-uvyYCjk(long $this$isInfinite_u2duvyYCjk) {
        boolean infinite;
        int i;
        if (Float.isInfinite(Size.getWidth-impl($this$isInfinite_u2duvyYCjk)) && Float.isInfinite(Size.getHeight-impl($this$isInfinite_u2duvyYCjk))) {
            i = Float.isInfinite(Size.getHeight-impl($this$isInfinite_u2duvyYCjk)) ? 1 : 0;
        } else {
        }
        return i;
    }
}
