package androidx.compose.ui.text.android;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Canvas.EdgeType;
import android.graphics.Canvas.VertexMode;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.RenderNode;
import android.graphics.fonts.Font;
import android.graphics.text.MeasuredText;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u000b\n\u0002\u0010\u0014\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0019\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\r\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0017\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u001a\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0010\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000bH\u0017J(\u0010\u0008\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0017J(\u0010\u0008\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J(\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J0\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J(\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u0017H\u0017J(\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J0\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0016JH\u0010 \u001a\u00020\u00172\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0016J\"\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J,\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0008\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020\n2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J,\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0008\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020\u000b2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J*\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016JR\u0010'\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00052\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0017JR\u0010'\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00052\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0017JL\u00105\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00112\u0008\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010;\u001a\u00020\u00112\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J(\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u0011H\u0016J\u0018\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020CH\u0017J\u0018\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020DH\u0016J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020EH\u0017J\u0018\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020E2\u0006\u0010B\u001a\u00020CH\u0017J@\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0017J0\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010M\u001a\u0002092\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010N\u001a\u0002092\u0006\u0010%\u001a\u00020&H\u0017J@\u0010O\u001a\u00020\u00172\u0006\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u0002092\u0006\u0010S\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\u00112\u0006\u0010U\u001a\u00020V2\u0006\u0010%\u001a\u00020&H\u0017J0\u0010W\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\u0006\u0010[\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010\\\u001a\u00020\u00172\u0006\u0010]\u001a\u0002092\u0006\u0010%\u001a\u00020&H\u0016J(\u0010\\\u001a\u00020\u00172\u0006\u0010]\u001a\u0002092\u0006\u0010.\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010_\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0016J0\u0010_\u001a\u00020\u00172\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010`\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0016J\"\u0010a\u001a\u00020\u00172\u0006\u0010b\u001a\u00020c2\u0006\u0010+\u001a\u00020\n2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0017J\"\u0010a\u001a\u00020\u00172\u0006\u0010b\u001a\u00020c2\u0006\u0010+\u001a\u00020\u000b2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0017J\u0018\u0010d\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010e\u001a\u00020\u00172\u0006\u0010f\u001a\u00020gH\u0016J\u0018\u0010e\u001a\u00020\u00172\u0006\u0010f\u001a\u00020g2\u0006\u0010+\u001a\u00020\nH\u0016J\u0018\u0010e\u001a\u00020\u00172\u0006\u0010f\u001a\u00020g2\u0006\u0010+\u001a\u00020\u000bH\u0016J \u0010h\u001a\u00020\u00172\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010i\u001a\u00020\u00172\u0006\u0010]\u001a\u0002092\u0006\u0010%\u001a\u00020&H\u0016J*\u0010i\u001a\u00020\u00172\u0008\u0010]\u001a\u0004\u0018\u0001092\u0006\u0010.\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0016J0\u0010j\u001a\u00020\u00172\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0006\u0010n\u001a\u0002092\u0006\u0010%\u001a\u00020&H\u0017J \u0010j\u001a\u00020\u00172\u0006\u0010k\u001a\u00020o2\u0006\u0010n\u001a\u0002092\u0006\u0010%\u001a\u00020&H\u0017J \u0010p\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\u0018\u0010q\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010q\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0016J0\u0010q\u001a\u00020\u00172\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010r\u001a\u00020\u00172\u0006\u0010s\u001a\u00020tH\u0017J(\u0010u\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010v\u001a\u00020\r2\u0006\u0010w\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J@\u0010u\u001a\u00020\u00172\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010v\u001a\u00020\r2\u0006\u0010w\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J8\u0010x\u001a\u00020\u00172\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J8\u0010x\u001a\u00020\u00172\u0006\u0010k\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J(\u0010x\u001a\u00020\u00172\u0006\u0010k\u001a\u00020o2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J8\u0010x\u001a\u00020\u00172\u0006\u0010k\u001a\u00020o2\u0006\u0010z\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J@\u0010|\u001a\u00020\u00172\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J0\u0010|\u001a\u00020\u00172\u0006\u0010k\u001a\u00020o2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016JT\u0010\u007f\u001a\u00020\u00172\u0007\u0010k\u001a\u00030\u0080\u00012\u0006\u0010z\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\u00112\u0007\u0010\u0081\u0001\u001a\u00020\u00112\u0007\u0010\u0082\u0001\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0017JS\u0010\u007f\u001a\u00020\u00172\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0007\u0010\u0084\u0001\u001a\u00020\u00112\u0007\u0010\u0085\u0001\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0017JS\u0010\u007f\u001a\u00020\u00172\u0006\u0010k\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\u00112\u0007\u0010\u0081\u0001\u001a\u00020\u00112\u0007\u0010\u0082\u0001\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0017Jw\u0010\u0086\u0001\u001a\u00020\u00172\u0007\u0010B\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\u00112\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00112\t\u0010\u0089\u0001\u001a\u0004\u0018\u0001092\u0007\u0010\u008a\u0001\u001a\u00020\u00112\u0008\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010;\u001a\u00020\u00112\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u00112\u0007\u0010\u008e\u0001\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0016J\t\u0010\u008f\u0001\u001a\u00020\u0017H\u0017J\u0012\u0010\u0090\u0001\u001a\u00020\u00052\u0007\u0010\u0091\u0001\u001a\u00020\nH\u0016J\t\u0010\u0092\u0001\u001a\u00020\u0011H\u0016J\u000c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0016J\t\u0010\u0095\u0001\u001a\u00020\u0011H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020\u00172\u0007\u0010\u0097\u0001\u001a\u00020\u0019H\u0017J\t\u0010\u0098\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0099\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u009a\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u009b\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u009c\u0001\u001a\u00020\u0005H\u0016J\u0011\u0010\u009d\u0001\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u001b\u0010\u009d\u0001\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0017J\u0011\u0010\u009d\u0001\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000bH\u0017J\u001b\u0010\u009d\u0001\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000b2\u0008\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0017J)\u0010\u009d\u0001\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0017J3\u0010\u009d\u0001\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0008\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0017J\t\u0010 \u0001\u001a\u00020\u0017H\u0016J\u0012\u0010¡\u0001\u001a\u00020\u00172\u0007\u0010¢\u0001\u001a\u00020\u0011H\u0016J\u0012\u0010£\u0001\u001a\u00020\u00172\u0007\u0010¤\u0001\u001a\u00020\rH\u0016J\t\u0010¥\u0001\u001a\u00020\u0011H\u0016J\u001e\u0010¦\u0001\u001a\u00020\u00112\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u000b2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J'\u0010¦\u0001\u001a\u00020\u00112\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u000b2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0007\u0010§\u0001\u001a\u00020\u0011H\u0017J3\u0010¦\u0001\u001a\u00020\u00112\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J<\u0010¦\u0001\u001a\u00020\u00112\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0007\u0010§\u0001\u001a\u00020\u0011H\u0017J\u001d\u0010¨\u0001\u001a\u00020\u00112\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010©\u0001\u001a\u00020\u0011H\u0016J&\u0010¨\u0001\u001a\u00020\u00112\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010©\u0001\u001a\u00020\u00112\u0007\u0010§\u0001\u001a\u00020\u0011H\u0017J2\u0010¨\u0001\u001a\u00020\u00112\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0007\u0010©\u0001\u001a\u00020\u0011H\u0016J;\u0010¨\u0001\u001a\u00020\u00112\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0007\u0010©\u0001\u001a\u00020\u00112\u0007\u0010§\u0001\u001a\u00020\u0011H\u0017J\u001b\u0010ª\u0001\u001a\u00020\u00172\u0007\u0010«\u0001\u001a\u00020\r2\u0007\u0010¬\u0001\u001a\u00020\rH\u0016J\u0013\u0010­\u0001\u001a\u00020\u00172\u0008\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010®\u0001\u001a\u00020\u00172\u0007\u0010¯\u0001\u001a\u00020\u0001J\u0012\u0010°\u0001\u001a\u00020\u00172\u0007\u0010±\u0001\u001a\u00020\u0011H\u0016J\u0015\u0010²\u0001\u001a\u00020\u00172\n\u0010³\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0016J\u0013\u0010´\u0001\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001b\u0010µ\u0001\u001a\u00020\u00172\u0007\u0010«\u0001\u001a\u00020\r2\u0007\u0010¬\u0001\u001a\u00020\rH\u0016J\u001b\u0010¶\u0001\u001a\u00020\u00172\u0007\u0010·\u0001\u001a\u00020\r2\u0007\u0010¸\u0001\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000¨\u0006¹\u0001", d2 = {"Landroidx/compose/ui/text/android/TextAndroidCanvas;", "Landroid/graphics/Canvas;", "()V", "nativeCanvas", "clipOutPath", "", "path", "Landroid/graphics/Path;", "clipOutRect", "rect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "", "clipPath", "op", "Landroid/graphics/Region$Op;", "clipRect", "concat", "", "matrix", "Landroid/graphics/Matrix;", "disableZ", "drawARGB", "a", "r", "g", "b", "drawArc", "oval", "startAngle", "sweepAngle", "useCenter", "paint", "Landroid/graphics/Paint;", "drawBitmap", "bitmap", "Landroid/graphics/Bitmap;", "src", "dst", "colors", "", "offset", "stride", "x", "y", "width", "height", "hasAlpha", "drawBitmapMesh", "meshWidth", "meshHeight", "verts", "", "vertOffset", "colorOffset", "drawCircle", "cx", "cy", "radius", "drawColor", "color", "mode", "Landroid/graphics/BlendMode;", "Landroid/graphics/PorterDuff$Mode;", "", "drawDoubleRoundRect", "outer", "outerRx", "outerRy", "inner", "innerRx", "innerRy", "outerRadii", "innerRadii", "drawGlyphs", "glyphIds", "glyphIdOffset", "positions", "positionOffset", "glyphCount", "font", "Landroid/graphics/fonts/Font;", "drawLine", "startX", "startY", "stopX", "stopY", "drawLines", "pts", "count", "drawOval", "drawPaint", "drawPatch", "patch", "Landroid/graphics/NinePatch;", "drawPath", "drawPicture", "picture", "Landroid/graphics/Picture;", "drawPoint", "drawPoints", "drawPosText", "text", "", "index", "pos", "", "drawRGB", "drawRect", "drawRenderNode", "renderNode", "Landroid/graphics/RenderNode;", "drawRoundRect", "rx", "ry", "drawText", "", "start", "end", "drawTextOnPath", "hOffset", "vOffset", "drawTextRun", "Landroid/graphics/text/MeasuredText;", "contextStart", "contextEnd", "isRtl", "contextIndex", "contextCount", "drawVertices", "Landroid/graphics/Canvas$VertexMode;", "vertexCount", "texs", "texOffset", "indices", "", "indexOffset", "indexCount", "enableZ", "getClipBounds", "bounds", "getDensity", "getDrawFilter", "Landroid/graphics/DrawFilter;", "getHeight", "getMatrix", "ctm", "getMaximumBitmapHeight", "getMaximumBitmapWidth", "getSaveCount", "getWidth", "isOpaque", "quickReject", "type", "Landroid/graphics/Canvas$EdgeType;", "restore", "restoreToCount", "saveCount", "rotate", "degrees", "save", "saveLayer", "saveFlags", "saveLayerAlpha", "alpha", "scale", "sx", "sy", "setBitmap", "setCanvas", "canvas", "setDensity", "density", "setDrawFilter", "filter", "setMatrix", "skew", "translate", "dx", "dy", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextAndroidCanvas extends Canvas {

    public static final int $stable = 8;
    private Canvas nativeCanvas;
    static {
        final int i = 8;
    }

    @Override // android.graphics.Canvas
    public boolean clipOutPath(Path path) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return CanvasCompatO.INSTANCE.clipOutPath(nativeCanvas, path);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(float left, float top, float right, float bottom) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return CanvasCompatO.INSTANCE.clipOutRect(nativeCanvas, left, top, right, bottom);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(int left, int top, int right, int bottom) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return CanvasCompatO.INSTANCE.clipOutRect(nativeCanvas, left, top, right, bottom);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(Rect rect) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return CanvasCompatO.INSTANCE.clipOutRect(nativeCanvas, rect);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(RectF rect) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return CanvasCompatO.INSTANCE.clipOutRect(nativeCanvas, rect);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.clipPath(path);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean clipPath(Path path, Region.Op op) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.clipPath(path, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float left, float top, float right, float bottom) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.clipRect(left, top, right, bottom);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(float left, float top, float right, float bottom, Region.Op op) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.clipRect(left, top, right, bottom, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(int left, int top, int right, int bottom) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.clipRect(left, top, right, bottom);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.clipRect(rect);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(Rect rect, Region.Op op) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.clipRect(rect, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rect) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.clipRect(rect);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(RectF rect, Region.Op op) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.clipRect(rect, op);
    }

    @Override // android.graphics.Canvas
    public void concat(Matrix matrix) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.concat(matrix);
    }

    @Override // android.graphics.Canvas
    public void disableZ() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatQ.INSTANCE.disableZ(nativeCanvas);
    }

    @Override // android.graphics.Canvas
    public void drawARGB(int a, int r, int g, int b) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawARGB(a, r, g, b);
    }

    @Override // android.graphics.Canvas
    public void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, useCenter, paint);
    }

    @Override // android.graphics.Canvas
    public void drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawArc(oval, startAngle, sweepAngle, useCenter, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawBitmap(bitmap, left, top, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawBitmap(bitmap, matrix, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawBitmap(bitmap, src, dst, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawBitmap(bitmap, src, dst, paint);
    }

    @Deprecated(message = "Deprecated in Java")
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y, int width, int height, boolean hasAlpha, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
    }

    @Deprecated(message = "Deprecated in Java")
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y, int width, int height, boolean hasAlpha, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts, int vertOffset, int[] colors, int colorOffset, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset, paint);
    }

    @Override // android.graphics.Canvas
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawCircle(cx, cy, radius, paint);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int color) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawColor(color);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int color, BlendMode mode) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatQ.INSTANCE.drawColor(nativeCanvas, color, mode);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int color, PorterDuff.Mode mode) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawColor(color, mode);
    }

    @Override // android.graphics.Canvas
    public void drawColor(long color) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatQ.INSTANCE.drawColor(nativeCanvas, color);
    }

    @Override // android.graphics.Canvas
    public void drawColor(long color, BlendMode mode) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatQ.INSTANCE.drawColor(nativeCanvas, color, mode);
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF outer, float outerRx, float outerRy, RectF inner, float innerRx, float innerRy, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatQ.INSTANCE.drawDoubleRoundRect(nativeCanvas, outer, outerRx, outerRy, inner, innerRx, innerRy, paint);
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF outer, float[] outerRadii, RectF inner, float[] innerRadii, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatQ.INSTANCE.drawDoubleRoundRect(nativeCanvas, outer, outerRadii, inner, innerRadii, paint);
    }

    @Override // android.graphics.Canvas
    public void drawGlyphs(int[] glyphIds, int glyphIdOffset, float[] positions, int positionOffset, int glyphCount, Font font, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatS.INSTANCE.drawGlyphs(nativeCanvas, glyphIds, glyphIdOffset, positions, positionOffset, glyphCount, font, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawLine(startX, startY, stopX, stopY, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawLines(pts, offset, count, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] pts, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawLines(pts, paint);
    }

    @Override // android.graphics.Canvas
    public void drawOval(float left, float top, float right, float bottom, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawOval(left, top, right, bottom, paint);
    }

    @Override // android.graphics.Canvas
    public void drawOval(RectF oval, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawOval(oval, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPaint(Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawPaint(paint);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch patch, Rect dst, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatS.INSTANCE.drawPatch(nativeCanvas, patch, dst, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch patch, RectF dst, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatS.INSTANCE.drawPatch(nativeCanvas, patch, dst, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawPath(path, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawPicture(picture);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, Rect dst) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawPicture(picture, dst);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, RectF dst) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawPicture(picture, dst);
    }

    @Override // android.graphics.Canvas
    public void drawPoint(float x, float y, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawPoint(x, y, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawPoints(pts, offset, count, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] pts, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawPoints(pts, paint);
    }

    @Deprecated(message = "Deprecated in Java")
    public void drawPosText(String text, float[] pos, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawPosText(text, pos, paint);
    }

    @Deprecated(message = "Deprecated in Java")
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawPosText(text, index, count, pos, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRGB(int r, int g, int b) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawRGB(r, g, b);
    }

    @Override // android.graphics.Canvas
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawRect(left, top, right, bottom, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRect(Rect r, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawRect(r, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRect(RectF rect, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawRect(rect, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRenderNode(RenderNode renderNode) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatQ.INSTANCE.drawRenderNode(nativeCanvas, renderNode);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawRoundRect(left, top, right, bottom, rx, ry, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawRoundRect(rect, rx, ry, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(java.lang.CharSequence text, int start, int end, float x, float y, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawText(text, start, end, x, y, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(String text, float x, float y, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawText(text, x, y, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawText(text, start, end, x, y, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawText(text, index, count, x, y, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawTextOnPath(text, path, hOffset, vOffset, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset, float vOffset, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(MeasuredText text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatQ.INSTANCE.drawTextRun(nativeCanvas, text, start, end, contextStart, contextEnd, x, y, isRtl, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(java.lang.CharSequence text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatM.INSTANCE.drawTextRun(nativeCanvas, text, start, end, contextStart, contextEnd, x, y, isRtl, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(char[] text, int index, int count, int contextIndex, int contextCount, float x, float y, boolean isRtl, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatM.INSTANCE.drawTextRun(nativeCanvas, text, index, count, contextIndex, contextCount, x, y, isRtl, paint);
    }

    @Override // android.graphics.Canvas
    public void drawVertices(Canvas.VertexMode mode, int vertexCount, float[] verts, int vertOffset, float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices, int indexOffset, int indexCount, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors, colorOffset, indices, indexOffset, indexCount, paint);
    }

    @Override // android.graphics.Canvas
    public void enableZ() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        CanvasCompatQ.INSTANCE.enableZ(nativeCanvas);
    }

    @Override // android.graphics.Canvas
    public boolean getClipBounds(Rect bounds) {
        Canvas nativeCanvas;
        int width;
        int i2;
        int i;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        boolean clipBounds = nativeCanvas.getClipBounds(bounds);
        if (clipBounds) {
            i = 0;
            bounds.set(i, i, bounds.width(), Integer.MAX_VALUE);
        }
        return clipBounds;
    }

    @Override // android.graphics.Canvas
    public int getDensity() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.getDensity();
    }

    @Override // android.graphics.Canvas
    public DrawFilter getDrawFilter() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.getDrawFilter();
    }

    @Override // android.graphics.Canvas
    public int getHeight() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.getHeight();
    }

    @Deprecated(message = "Deprecated in Java")
    public void getMatrix(Matrix ctm) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.getMatrix(ctm);
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapHeight() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.getMaximumBitmapHeight();
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapWidth() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.getMaximumBitmapWidth();
    }

    @Override // android.graphics.Canvas
    public int getSaveCount() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.getSaveCount();
    }

    @Override // android.graphics.Canvas
    public int getWidth() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.getWidth();
    }

    @Override // android.graphics.Canvas
    public boolean isOpaque() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.isOpaque();
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(float left, float top, float right, float bottom) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return CanvasCompatR.INSTANCE.quickReject(nativeCanvas, left, top, right, bottom);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(float left, float top, float right, float bottom, Canvas.EdgeType type) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.quickReject(left, top, right, bottom, type);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(Path path) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return CanvasCompatR.INSTANCE.quickReject(nativeCanvas, path);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(Path path, Canvas.EdgeType type) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.quickReject(path, type);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(RectF rect) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return CanvasCompatR.INSTANCE.quickReject(nativeCanvas, rect);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(RectF rect, Canvas.EdgeType type) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.quickReject(rect, type);
    }

    @Override // android.graphics.Canvas
    public void restore() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.restore();
    }

    @Override // android.graphics.Canvas
    public void restoreToCount(int saveCount) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.restoreToCount(saveCount);
    }

    @Override // android.graphics.Canvas
    public void rotate(float degrees) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.rotate(degrees);
    }

    @Override // android.graphics.Canvas
    public int save() {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.save();
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float left, float top, float right, float bottom, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.saveLayer(left, top, right, bottom, paint);
    }

    @Deprecated(message = "Deprecated in Java")
    public int saveLayer(float left, float top, float right, float bottom, Paint paint, int saveFlags) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.saveLayer(left, top, right, bottom, paint, saveFlags);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(RectF bounds, Paint paint) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.saveLayer(bounds, paint);
    }

    @Deprecated(message = "Deprecated in Java")
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.saveLayer(bounds, paint, saveFlags);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(float left, float top, float right, float bottom, int alpha) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.saveLayerAlpha(left, top, right, bottom, alpha);
    }

    @Deprecated(message = "Deprecated in Java")
    public int saveLayerAlpha(float left, float top, float right, float bottom, int alpha, int saveFlags) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.saveLayerAlpha(left, top, right, bottom, alpha, saveFlags);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(RectF bounds, int alpha) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.saveLayerAlpha(bounds, alpha);
    }

    @Deprecated(message = "Deprecated in Java")
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        return nativeCanvas.saveLayerAlpha(bounds, alpha, saveFlags);
    }

    @Override // android.graphics.Canvas
    public void scale(float sx, float sy) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.scale(sx, sy);
    }

    @Override // android.graphics.Canvas
    public void setBitmap(Bitmap bitmap) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.setBitmap(bitmap);
    }

    @Override // android.graphics.Canvas
    public final void setCanvas(Canvas canvas) {
        this.nativeCanvas = canvas;
    }

    @Override // android.graphics.Canvas
    public void setDensity(int density) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.setDensity(density);
    }

    @Override // android.graphics.Canvas
    public void setDrawFilter(DrawFilter filter) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.setDrawFilter(filter);
    }

    @Override // android.graphics.Canvas
    public void setMatrix(Matrix matrix) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.setMatrix(matrix);
    }

    @Override // android.graphics.Canvas
    public void skew(float sx, float sy) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.skew(sx, sy);
    }

    @Override // android.graphics.Canvas
    public void translate(float dx, float dy) {
        Canvas nativeCanvas;
        if (this.nativeCanvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            nativeCanvas = 0;
        }
        nativeCanvas.translate(dx, dy);
    }
}
