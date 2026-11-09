# Screenshot Viewer Share

[English](#english) | 中文

**Screenshot Viewer Share** 是一个 Minecraft Fabric 客户端联动模组，把 [Screenshot Viewer](https://github.com/LGatodu47/ScreenshotViewer) 的截图查看界面与 [ChatImage](https://github.com/kitUIN/ChatImage) 的图片发送功能连接起来：在截图详细界面的右侧按钮列中新增一个“**分享到聊天**”按钮，一键补全 ChatImage 发送命令，按回车即可把截图发到聊天栏。

本模组是 [ScreenshotSharing](https://github.com/Nova-Committee/ScreenshotSharing)（“截图后聊天提示中出现 [分享到聊天] 按钮”）的姊妹联动模组。

---

## 功能特性

- 在 Screenshot Viewer **放大查看截图界面**右侧按钮列的“打开”上方，新增“**分享到聊天**”按钮（从上到下：分享到聊天、打开、复制、删除、重命名）
- 在 Screenshot Viewer **右键截图弹出的属性菜单**中，同样在“打开”上方提供“分享到聊天”选项
- 按钮图标为贴合 Screenshot Viewer 原版 UI 风格绘制的 19×19 像素分享图标（白色线条 + 右下深灰投影）
- 点击按钮后**不会直接发送**，而是打开聊天栏并补全命令：
  ```
  /chatimage send "屏幕截图" file:///...截图文件路径...
  ```
  确认无误后按回车发送，与 ScreenshotSharing 的交互一致
- 小窗口自适应：窗口高度不足时整列按钮自动下移，不会遮挡“下一张 >”切换箭头
- 中英文双语支持（zh_cn / en_us）

## 运行环境

| 项目 | 版本 |
| --- | --- |
| Minecraft | 26.2 |
| Mod Loader | Fabric Loader ≥ 0.19.5 |
| Java | ≥ 25 |
| Fabric API | ≥ 0.161.0+26.2 |

## 依赖模组

**必须安装：**

- [Screenshot Viewer](https://modrinth.com/mod/screenshot-viewer)（开发基于 `screenshot_viewer 1.3.6-fabric-mc26.2`）
- [ChatImage](https://github.com/kitUIN/ChatImage)（提供 `/chatimage send` 命令与图片渲染）

**推荐搭配（可选）：**

- [ScreenshotSharing](https://github.com/Nova-Committee/ScreenshotSharing)：F2 截图后在聊天提示中直接点“[分享到聊天]”

## 安装方法

1. 安装 Minecraft 26.2 的 Fabric Loader（≥ 0.19.5）与 Fabric API
2. 安装上表中的 Screenshot Viewer 与 ChatImage
3. 从 [Releases](../../releases) 下载最新 `ScreenshotViewerShare-x.x.x+26.2-fabric.jar`，放入 `.minecraft/mods`（或对应版本隔离目录的 `mods` 文件夹）
4. 启动游戏

## 使用方法

1. 打开 Screenshot Viewer 的截图管理界面，点开任意一张截图进入放大查看界面
2. 在右侧按钮列最上方点击“**分享到聊天**”图标（一个左圆点连向右上方两个圆点的分享符号）
3. 聊天栏会自动打开并补全 `/chatimage send "屏幕截图" file:///...`，按需修改图片名称后按回车发送
4. 也可以在截图上点击右键，在弹出的属性菜单顶部找到同样的“分享到聊天”选项

## 从源码构建

```bash
git clone https://github.com/<你的用户名>/ScreenshotViewerShare.git
cd ScreenshotViewerShare
gradlew build
```

构建产物位于 `build/libs/ScreenshotViewerShare-<版本>+26.2-fabric.jar`（需要 JDK 25）。

## 版本日志

详见 [CHANGELOG.md](CHANGELOG.md)。当前最新版本：**1.0.1+26.2-fabric**。

## 致谢

- [Screenshot Viewer](https://github.com/LGatodu47/ScreenshotViewer) by LGatodu47（MIT）
- [ChatImage](https://github.com/kitUIN/ChatImage) by kitUIN（MIT）
- [ScreenshotSharing](https://github.com/Nova-Committee/ScreenshotSharing) by Nova-Committee / Rinko1231 / Tapio

## 许可证

本项目基于 [MIT License](LICENSE) 开源。

---

## English

**Screenshot Viewer Share** is a Fabric client mod that bridges [Screenshot Viewer](https://github.com/LGatodu47/ScreenshotViewer) and [ChatImage](https://github.com/kitUIN/ChatImage). It adds a **Share to Chat** button above the "Open" button in the right-hand column of Screenshot Viewer's enlarged screenshot screen (and in the right-click properties menu). Clicking it opens the chat box with a prefilled command:

```
/chatimage send "Screenshot" file:///...path-to-screenshot...
```

Press Enter to send — nothing is sent automatically, matching the interaction of [ScreenshotSharing](https://github.com/Nova-Committee/ScreenshotSharing).

- **Minecraft** 26.2 · **Fabric Loader** ≥ 0.19.5 · **Java** ≥ 25
- **Requires**: Screenshot Viewer (built against 1.3.6-fabric-mc26.2) and ChatImage; ScreenshotSharing is optional
- Custom 19×19 share icon drawn in Screenshot Viewer's native UI style
- On short windows the whole button column shifts down automatically so it never covers the "next screenshot" arrow
- Install: drop the jar from [Releases](../../releases) into your `mods` folder
- Build from source: `gradle build` (JDK 25), output in `build/libs/`
- Changelog: [CHANGELOG.md](CHANGELOG.md) · License: [MIT](LICENSE)
