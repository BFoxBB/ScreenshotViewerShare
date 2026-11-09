package com.novacommittee.screenshotviewershare.util;

import com.novacommittee.screenshotviewershare.ScreenshotViewerShareClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.network.chat.Component;

import java.io.File;
import java.lang.reflect.Method;

/**
 * 把 Screenshot Viewer 选中的截图补全为 ChatImage 发送命令。
 */
public class ShareToChatUtil {

    private ShareToChatUtil() {
    }

    /**
     * 接收 Screenshot Viewer 的 {@code ScreenshotImageHolder}，在聊天栏补全分享命令。
     * 参数使用 Object 以避免在编译期依赖 Screenshot Viewer 的类型。
     */
    public static void shareToChat(Object holder) {
        File file = screenshotFile(holder);
        if (file == null) {
            return;
        }
        Minecraft client = Minecraft.getInstance();
        if (client.player == null) {
            return;
        }
        String name = Component.translatable("name." + ScreenshotViewerShareClient.MOD_ID + ".screenshot").getString();
        String command = "chatimage send \"" + name + "\" " + fileUrl(file);
        client.gui.openChatAndAddText(ChatComponent.ChatMethod.COMMAND, command);
    }

    private static File screenshotFile(Object holder) {
        try {
            Method method = holder.getClass().getMethod("getScreenshotFile");
            method.setAccessible(true);
            return (File) method.invoke(holder);
        } catch (ReflectiveOperationException | RuntimeException e) {
            ScreenshotViewerShareClient.LOGGER.error(
                    "Failed to read screenshot file from {}", holder.getClass().getName(), e);
            return null;
        }
    }

    private static String fileUrl(File file) {
        String path = file.getAbsolutePath().replace('\\', '/');
        return "file:///" + (path.startsWith("/") ? path.substring(1) : path);
    }
}
