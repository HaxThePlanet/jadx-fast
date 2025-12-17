package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class TrackLoadSettingsAtom extends AbstractBox {

    public static final String TYPE = "load";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    int defaultHints;
    int preloadDuration;
    int preloadFlags;
    int preloadStartTime;
    static {
        TrackLoadSettingsAtom.ajc$preClinit();
    }

    public TrackLoadSettingsAtom() {
        super("load");
    }

    private static void ajc$preClinit() {
        b bVar9 = new b("TrackLoadSettingsAtom.java", TrackLoadSettingsAtom.class);
        final String str58 = "method-execution";
        TrackLoadSettingsAtom.ajc$tjp_0 = bVar9.h(str58, bVar9.g("1", "getPreloadStartTime", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 49);
        TrackLoadSettingsAtom.ajc$tjp_1 = bVar9.h(str58, bVar9.g("1", "setPreloadStartTime", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadStartTime", "", "void"), 53);
        TrackLoadSettingsAtom.ajc$tjp_2 = bVar9.h(str58, bVar9.g("1", "getPreloadDuration", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 57);
        TrackLoadSettingsAtom.ajc$tjp_3 = bVar9.h(str58, bVar9.g("1", "setPreloadDuration", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadDuration", "", "void"), 61);
        TrackLoadSettingsAtom.ajc$tjp_4 = bVar9.h(str58, bVar9.g("1", "getPreloadFlags", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 65);
        TrackLoadSettingsAtom.ajc$tjp_5 = bVar9.h(str58, bVar9.g("1", "setPreloadFlags", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "preloadFlags", "", "void"), 69);
        TrackLoadSettingsAtom.ajc$tjp_6 = bVar9.h(str58, bVar9.g("1", "getDefaultHints", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "", "", "", "int"), 73);
        TrackLoadSettingsAtom.ajc$tjp_7 = bVar9.h(str58, bVar9.g("1", "setDefaultHints", "com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom", "int", "defaultHints", "", "void"), 77);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.preloadStartTime = byteBuffer.getInt();
        this.preloadDuration = byteBuffer.getInt();
        this.preloadFlags = byteBuffer.getInt();
        this.defaultHints = byteBuffer.getInt();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.preloadStartTime);
        byteBuffer.putInt(this.preloadDuration);
        byteBuffer.putInt(this.preloadFlags);
        byteBuffer.putInt(this.defaultHints);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 16;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getDefaultHints() {
        d.b().c(b.c(TrackLoadSettingsAtom.ajc$tjp_6, this, this));
        return this.defaultHints;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getPreloadDuration() {
        d.b().c(b.c(TrackLoadSettingsAtom.ajc$tjp_2, this, this));
        return this.preloadDuration;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getPreloadFlags() {
        d.b().c(b.c(TrackLoadSettingsAtom.ajc$tjp_4, this, this));
        return this.preloadFlags;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getPreloadStartTime() {
        d.b().c(b.c(TrackLoadSettingsAtom.ajc$tjp_0, this, this));
        return this.preloadStartTime;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setDefaultHints(int i) {
        d.b().c(b.d(TrackLoadSettingsAtom.ajc$tjp_7, this, this, a.e(i)));
        this.defaultHints = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setPreloadDuration(int i) {
        d.b().c(b.d(TrackLoadSettingsAtom.ajc$tjp_3, this, this, a.e(i)));
        this.preloadDuration = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setPreloadFlags(int i) {
        d.b().c(b.d(TrackLoadSettingsAtom.ajc$tjp_5, this, this, a.e(i)));
        this.preloadFlags = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setPreloadStartTime(int i) {
        d.b().c(b.d(TrackLoadSettingsAtom.ajc$tjp_1, this, this, a.e(i)));
        this.preloadStartTime = i;
    }
}
