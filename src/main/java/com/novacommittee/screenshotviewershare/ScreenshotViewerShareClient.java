package com.novacommittee.screenshotviewershare;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Screenshot Viewer Share 客户端入口。
 *
 * <p>把 Screenshot Viewer 的截图详细菜单与 ChatImage 的发送命令连接起来。</p>
 */
public class ScreenshotViewerShareClient implements ClientModInitializer {

    public static final String MOD_ID = "screenshot_viewer_share";

    public static final Logger LOGGER = LoggerFactory.getLogger("ScreenshotViewerShare");

    public static final Identifier SHARE_TO_CHAT_ICON =
            Identifier.fromNamespaceAndPath(MOD_ID, "widget/icons/share_to_chat");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Screenshot Viewer Share loaded");
    }
}
