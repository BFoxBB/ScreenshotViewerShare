package com.novacommittee.screenshotviewershare.mixin;

import com.novacommittee.screenshotviewershare.ScreenshotViewerShareClient;
import com.novacommittee.screenshotviewershare.util.ShareToChatUtil;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

/**
 * 在 Screenshot Viewer 放大查看截图界面右侧按钮列的“打开”上方加入“分享到聊天”。
 */
@Mixin(targets = "io.github.lgatodu47.screenshot_viewer.screen.manage_screenshots.EnlargedScreenshotScreen")
public abstract class EnlargedScreenshotScreenMixin extends Screen {

    @Unique
    private AbstractWidget screenshotViewerShare$shareBtn;

    protected EnlargedScreenshotScreenMixin() {
        super(Component.empty());
    }

    @Shadow
    private AbstractWidget makeIconWidget(Identifier texture, Component description, Consumer<Object> action) {
        throw new AssertionError();
    }

    @Shadow
    private AbstractWidget openBtn;

    @Shadow
    private AbstractWidget copyBtn;

    @Shadow
    private AbstractWidget deleteBtn;

    @Shadow
    private AbstractWidget renameBtn;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void screenshotViewerShare$createShareButton(CallbackInfo ci) {
        this.screenshotViewerShare$shareBtn = makeIconWidget(
                ScreenshotViewerShareClient.SHARE_TO_CHAT_ICON,
                Component.translatable("gui." + ScreenshotViewerShareClient.MOD_ID + ".share_to_chat"),
                ShareToChatUtil::shareToChat);
    }

    /**
     * 原有四个按钮从底部向上排布（打开在最上面），分享按钮放在“打开”正上方一格。
     * 窗口高度不足时整列下移，避免盖住垂直居中的“下一张”切换箭头。
     */
    @Inject(method = "init", at = @At("TAIL"))
    private void screenshotViewerShare$placeShareButton(CallbackInfo ci) {
        final int spacing = 4;
        AbstractWidget share = this.screenshotViewerShare$shareBtn;
        int y = this.height - 20 * 6 - spacing * 7;
        int nextArrowBottom = (this.height - 20) / 2 + 20;
        if (y < nextArrowBottom + spacing) {
            int delta = nextArrowBottom + spacing - y;
            y += delta;
            this.openBtn.setY(this.openBtn.getY() + delta);
            this.copyBtn.setY(this.copyBtn.getY() + delta);
            this.deleteBtn.setY(this.deleteBtn.getY() + delta);
            this.renameBtn.setY(this.renameBtn.getY() + delta);
        }
        share.setX(this.width - spacing * 2 - 20);
        share.setY(y);
        this.addRenderableWidget(share);
    }
}
