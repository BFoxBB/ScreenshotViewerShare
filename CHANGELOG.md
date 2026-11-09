# 版本日志 / Changelog

本项目的所有重要变更都会记录在此文件中。

## [1.0.1+26.2-fabric] - 2026-11-05

### 修复 / Fixed

- 修复小窗口（低 GUI 高度）下，右侧按钮列最上方的“分享到聊天”按钮会遮挡“下一张 >”切换箭头的问题：窗口高度不足时整列按钮（分享到聊天、打开、复制、删除、重命名）现在会自动下移，始终位于切换箭头下方
- Fixed an issue where the "Share to Chat" button at the top of the right-hand column could cover the vertically-centered "next screenshot" arrow on short windows. The whole button column (Share to Chat, Open, Copy, Delete, Rename) now shifts down automatically when the window is too short.

## [1.0.0+26.2-fabric] - 2026-11-05

### 新增 / Added

- 首个发布版本 / Initial release
- 在 Screenshot Viewer 放大查看截图界面右侧按钮列的“打开”上方新增“分享到聊天”按钮
- 在 Screenshot Viewer 右键截图弹出的属性菜单中同样新增“分享到聊天”选项（位于“打开”上方）
- 点击按钮后打开聊天栏并补全 `/chatimage send "屏幕截图" file:///...` 命令，按回车发送（不自动发送）
- 按 Screenshot Viewer 原版 UI 风格绘制的 19×19 分享图标（左侧一个圆点，右侧两个圆点相连，构成指向左侧的三角形）
- 中英文双语语言文件（zh_cn / en_us）
- Added a "Share to Chat" button above "Open" in the right-hand button column of Screenshot Viewer's enlarged screenshot screen, and in the right-click properties menu
- Clicking opens the chat box with a prefilled `/chatimage send "Screenshot" file:///...` command; press Enter to send (never sends automatically)
- Custom 19×19 share icon drawn in Screenshot Viewer's native UI style
- zh_cn / en_us translations
