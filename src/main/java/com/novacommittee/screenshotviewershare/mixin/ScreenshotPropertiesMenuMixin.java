package com.novacommittee.screenshotviewershare.mixin;

import com.novacommittee.screenshotviewershare.ScreenshotViewerShareClient;
import com.novacommittee.screenshotviewershare.util.ShareToChatUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 在 Screenshot Viewer 截图详细菜单的按钮列表最前面插入“分享到聊天”。
 */
@Mixin(targets = "io.github.lgatodu47.screenshot_viewer.screen.manage_screenshots.ScreenshotPropertiesMenu")
public class ScreenshotPropertiesMenuMixin {

    @Shadow
    private List<AbstractWidget> buttons;

    @Shadow
    private void addButton(Identifier texture, Component description, Consumer<Object> action) {
        throw new AssertionError();
    }

    @Inject(method = "<init>(Ljava/util/function/Supplier;)V", at = @At("TAIL"))
    private void screenshotViewerShare$addShareButton(Supplier<Minecraft> mcSupplier, CallbackInfo ci) {
        addButton(ScreenshotViewerShareClient.SHARE_TO_CHAT_ICON,
                Component.translatable("gui." + ScreenshotViewerShareClient.MOD_ID + ".share_to_chat"),
                ShareToChatUtil::shareToChat);
        AbstractWidget shareButton = buttons.remove(buttons.size() - 1);
        buttons.add(0, shareButton);
    }
}
