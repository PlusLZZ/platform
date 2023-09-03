/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
define("vs/editor/editor.main.nls.zh-tw", {
    "vs/base/browser/ui/actionbar/actionbar": ["{0} ({1})"],
    "vs/base/browser/ui/aria/aria": ["{0} (再次出現)"],
    "vs/base/browser/ui/findinput/findInput": ["輸入"],
    "vs/base/browser/ui/findinput/findInputCheckboxes": ["大小寫須相符", "全字拼寫須相符", "使用規則運算式"],
    "vs/base/browser/ui/inputbox/inputBox": ["錯誤: {0}", "警告: {0}", "資訊: {0}"],
    "vs/base/common/keybindingLabels": ["Ctrl", "Shift", "Alt", "Windows", "Control", "Shift", "Alt", "Command", "Control", "Shift", "Alt", "Windows"],
    "vs/base/common/severity": ["錯誤", "警告", "資訊"],
    "vs/base/parts/quickopen/browser/quickOpenModel": ["{0}，選擇器", "選擇器"],
    "vs/base/parts/quickopen/browser/quickOpenWidget": ["快速選擇器。輸入以縮小結果範圍。", "快速選擇器"],
    "vs/base/parts/tree/browser/treeDefaults": ["摺疊"],
    "vs/editor/browser/widget/diffEditorWidget": ["因其中一個檔案過大而無法比較。"],
    "vs/editor/browser/widget/diffReview": ["關閉", "差異 {0} / {1}: 原始 {2}，{3} 行，修改後 {4}，{5} 行", "空白", "原始 {0},修改後{1}: {2", "+ 修改後 {0}: {1}", "- 原始 {0}: {1}", "移至下一個差異", "移至上一個差異"],
    "vs/editor/common/config/commonEditorConfig": ["編輯器", "控制字型家族。", "控制字型寬度。", "控制字型大小 (以像素為單位)。", "控制行高。使用 0 會從 fontSize 計算 lineHeight。", "控制字元間距 (以像素為單位)", "控制行號顯示。可能的值有 'on'、'off' 及 'relative'。'relative' 會從目前的資料指標位置顯示行數。", "要在其中顯示垂直尺規的資料行", "執行文字相關導覽或作業時將作為文字分隔符號的字元", "與 Tab 相等的空格數量。當 `editor.detectIndentation` 已開啟時，會根據檔案內容覆寫此設定。", "必須是 'number'。請注意，值 \"auto\" 已由 `editor.detectIndentation` 設定取代。", "在按 Tab 時插入空格。當 `editor.detectIndentation` 已開啟時，會根據檔案內容覆寫此設定。", "必須是 'boolean'。請注意，值 \"auto\" 已由 `editor.detect Indentation` 設定取代。", "開啟檔案時，會依據檔案內容來偵測 `editor.tabSize` 及 `editor.insertSpaces`。", "控制選取範圍是否有圓角", "控制編輯器是否會捲動到最後一行之後", "控制是否會顯示迷你地圖", "自動隱藏迷你地圖滑桿", "呈現行內的實際字元 (而不是彩色區塊)", "限制迷你地圖的寬度，以呈現最多的資料行", "控制編譯器選取範圍是否預設為尋找工具的搜尋字串", "控制編譯器內選取多字元或多行內文是否開啟選取範圍尋找功能", "一律不換行。", "依檢視區寬度換行。", "於 'editor.wordWrapColumn' 換行。", "當檢視區縮至最小並設定 'editor.wordWrapColumn' 時換行。", "控制是否自動換行。可以是:\n - 'off' (停用換行),\n - 'on' (檢視區換行),\n - 'wordWrapColumn' (於 'editor.wordWrapColumn' 換行`) 或\n - 'bounded' (當檢視區縮至最小並設定 'editor.wordWrapColumn' 時換行).", "當 `editor.wordWrap` 為 [wordWrapColumn] 或 [bounded] 時，控制編輯器中的資料行換行。", "控制換行的縮排。可以是 [無]、[相同] 或 [縮排]。", "滑鼠滾輪捲動事件的 'deltaX' 與 'deltaY' 所使用的乘數", "對應Windows和Linux的'Control'與對應OSX的'Command'", "對應Windows和Linux的'Alt'與對應OSX的'Option'", "用於新增多個滑鼠游標的修改程式。`ctrlCmd` 會對應到 Windows 及 Linux 上的 `Control` 以及 OSX 上的 `Command`。[移至定義] 及 [開啟連結] 滑鼠手勢將會適應以避免和 multicursor 修改程式衝突。", "允許在字串內顯示即時建議。", "允許在註解中顯示即時建議。", "允許在字串與註解以外之處顯示即時建議。", "控制是否應在輸入時自動顯示建議", "控制延遲顯示快速建議的毫秒數", "當您輸入時啟用彈出視窗，顯示參數文件與類型資訊", "控制編輯器是否應在左括號後自動插入右括號", "控制編輯器是否應在輸入一行後自動格式化", "控制編輯器是否應自動設定貼上的內容格式。格式器必須可供使用，而且格式器應該能夠設定文件中一個範圍的格式。", "控制當使用者輸入, 貼上或移行時，編輯器必須自動調整縮排\n語言的縮排規則必須可用", "控制輸入觸發字元時，是否應自動顯示建議", "控制除了 'Tab' 外，是否也藉由按下 'Enter' 接受建議。如此可避免混淆要插入新行或接受建議。設定值'smart'表示在文字變更同時，只透過Enter接受建議。", "控制認可字元是否應接受建議。例如在 JavaScript 中，分號 (';') 可以是接受建議並鍵入該字元的認可字元。", "將程式碼片段建議顯示於其他建議的頂端。", "將程式碼片段建議顯示於其他建議的下方。", "將程式碼片段建議與其他建議一同顯示。", "不顯示程式碼片段建議。", "控制程式碼片段是否隨其他建議顯示，以及其排序方式。", "控制複製時不選取任何項目是否會複製目前程式行。", "控制是否應根據文件中的單字計算自動完成。", "建議小工具的字型大小", "建議小工具的行高", "控制編輯器是否應反白顯示與選取範圍相似的符合項", "控制編輯器是否應反白顯示出現的語意符號", "控制可在概觀尺規中相同位置顯示的裝飾項目數", "控制是否應在概觀尺規周圍繪製邊框。", "控制游標動畫樣式，可能的值為 'blink'、'smooth'、'phase'、'expand' 和 'solid'", "使用滑鼠滾輪並按住 Ctrl 時，縮放編輯器的字型", "控制游標樣式。接受的值為 'block'、'block-outline'、'line'、'line-thin'、'underline' 及 'underline-thin'", "啟用連字字型", "控制游標是否應隱藏在概觀尺規中。", "控制編輯器轉譯空白字元的方式，可能為 'none'、'boundary' 及 'all'。'boundary' 選項不會轉譯字組間的單一空格。", "控制編輯器是否應顯示控制字元", "控制編輯器是否應顯示縮排輔助線", "控制編輯器應如何轉譯目前反白的行，可能的值有 'none'、'gutter'、'line' 和 'all'。", "控制編輯器是否顯示程式碼濾鏡", "控制編輯器是否已啟用程式碼摺疊功能", "自動隱藏摺疊控制向", "當選取某側的括號時，強調顯示另一側的配對括號。", "控制編輯器是否應轉譯垂直字符邊界。字符邊界最常用來進行偵錯。", "插入和刪除接在定位停駐點後的空白字元", "移除尾端自動插入的空白字元", "讓預覽編輯器在使用者按兩下其內容或點擊 Escape 時保持開啟。", "控制編輯器是否允許透過拖放動作移動選取範圍。", "編輯器將使用平台 API 以偵測螢幕助讀程式附加。", "編輯器將會為螢幕助讀程式的使用方式永久地最佳化。", "編輯器不會為螢幕助讀程式的使用方式進行最佳化。", "控制編輯器是否應於已為螢幕助讀程式最佳化的模式中執行。", "控制編輯器是否應偵測連結且讓它可點擊", "控制 Diff 編輯器要並排或內嵌顯示差異", "控制 Diff 編輯器是否將開頭或尾端空白字元的變更顯示為差異", "控制 Diff 編輯器是否要為新增的/移除的變更顯示 +/- 標記", "控制是否應支援 Linux 主要剪貼簿。"],
    "vs/editor/common/config/editorOptions": ["編輯器現在無法存取。按Alt+F1尋求選項", "編輯器內容"],
    "vs/editor/common/controller/cursor": ["執行命令時發生未預期的例外狀況。"],
    "vs/editor/common/model/textModelWithTokens": ["將輸入語彙基元化時，模式失敗。"],
    "vs/editor/common/modes/modesRegistry": ["純文字"],
    "vs/editor/common/services/bulkEdit": ["這些檔案已同時變更: {0}", "未進行任何編輯", "在 {1} 個檔案中進行了 {0} 項文字編輯", "在一個檔案中進行了 {0} 項文字編輯"],
    "vs/editor/common/services/modelServiceImpl": ["[{0}]\n{1}", "[{0}] {1}"],
    "vs/editor/common/view/editorColorRegistry": ["目前游標位置行的反白顯示背景色彩。", "目前游標位置行之周圍框線的背景色彩。", "反白顯示範圍的背景色彩，例如 Quick Open 與尋找功能。", "編輯器游標的色彩。", "編輯器游標的背景色彩。允許自訂區塊游標重疊的字元色彩。", "編輯器中空白字元的色彩。", "編輯器縮排輔助線的色彩。", "編輯器行號的色彩。", "編輯器尺規的色彩", "編輯器程式碼濾鏡的前景色彩", "成對括號背景色彩", "成對括號邊框色彩", "預覽檢視編輯器尺規的邊框色彩.", "編輯器邊框的背景顏色,包含行號與字形圖示的邊框.", "編輯器內錯誤提示線的前景色彩.", "編輯器內錯誤提示線的邊框色彩.", "編輯器內警告提示線的前景色彩.", "編輯器內警告提示線的邊框色彩."],
    "vs/editor/contrib/bracketMatching/common/bracketMatching": ["移至方括弧"],
    "vs/editor/contrib/caretOperations/common/caretOperations": ["將插入點左移", "將插入點右移"],
    "vs/editor/contrib/caretOperations/common/transpose": ["調換字母"],
    "vs/editor/contrib/clipboard/browser/clipboard": ["剪下", "複製", "貼上", "隨語法醒目提示複製"],
    "vs/editor/contrib/comment/common/comment": ["切換行註解", "加入行註解", "移除行註解", "切換區塊註解"],
    "vs/editor/contrib/contextmenu/browser/contextmenu": ["顯示編輯器內容功能表"],
    "vs/editor/contrib/find/browser/findWidget": ["尋找", "尋找", "上一個符合項", "下一個相符項", "在選取範圍中尋找", "關閉", "取代", "取代", "取代", "全部取代", "切換取代模式", "只會將前 999 筆結果醒目提示，但所有尋找作業會在完整文字上執行。", "{0} / {1}", "沒有結果"],
    "vs/editor/contrib/find/common/findController": ["尋找", "尋找下一個", "尋找上一個", "尋找下一個選取項目", "尋找上一個選取項目", "取代", "將選取項目加入下一個找到的相符項", "將選取項目加入前一個找到的相符項中", "將最後一個選擇項目移至下一個找到的相符項", "將最後一個選擇項目移至前一個找到的相符項", "選取所有找到的相符項目", "變更所有發生次數", "顯示下一個尋找字詞", "顯示上一個尋找字詞"],
    "vs/editor/contrib/folding/browser/folding": ["展開", "以遞迴方式展開", "摺疊", "以遞迴方式摺疊", "全部摺疊", "全部展開", "摺疊層級 {0}"],
    "vs/editor/contrib/format/browser/formatActions": ["在行 {0} 編輯了 1 項格式", "在行 {1} 編輯了 {0} 項格式", "在行 {0} 與行 {1} 之間編輯了 1 項格式", "在行 {1} 與行 {2} 之間編輯了 {0} 項格式", "將文件格式化", "將選取項目格式化"],
    "vs/editor/contrib/goToDeclaration/browser/goToDeclarationCommands": ["找不到 '{0}' 的定義", "找不到任何定義", " - {0} 個定義", "移至定義", "在一側開啟定義", "預覽定義", "找不到 '{0}' 的任何實作", "找不到任何實作", " – {0} 個實作", "前往實作", "預覽實作", "找不到 '{0}' 的任何類型定義", "找不到任何類型定義", " – {0} 個定義", "移至類型定義", "預覽類型定義"],
    "vs/editor/contrib/goToDeclaration/browser/goToDeclarationMouse": ["按一下以顯示 {0} 項定義。"],
    "vs/editor/contrib/gotoError/browser/gotoError": ["({0}/{1})", "移至下一個錯誤或警告", "移至上一個錯誤或警告", "編輯器標記導覽小工具錯誤的色彩。", "編輯器標記導覽小工具警告的色彩。", "編輯器標記導覽小工具的背景。"],
    "vs/editor/contrib/hover/browser/hover": ["動態顯示"],
    "vs/editor/contrib/hover/browser/modesContentHover": ["正在載入..."],
    "vs/editor/contrib/inPlaceReplace/common/inPlaceReplace": ["以上一個值取代", "以下一個值取代"],
    "vs/editor/contrib/linesOperations/common/linesOperations": ["將行向上複製", "將行向下複製", "上移一行", "下移一行", "遞增排序行", "遞減排序行", "修剪尾端空白", "刪除行", "縮排行", "凸排行", "在上方插入行", "在下方插入行", "左邊全部刪除", "刪除所有右方項目", "連接線", "轉置游標周圍的字元數", "轉換到大寫", "轉換到小寫"],
    "vs/editor/contrib/links/browser/links": ["按住 Cmd 並按一下按鍵以追蹤連結", "按住 Ctrl 並按一下滑鼠按鈕可連入連結", "按住 Cmd 並按一下滑鼠以執行命令", "按住 Ctrl 並按一下滑鼠以執行命令", "按住Alt並點擊以追蹤連結", "按住 Alt 並按一下滑鼠以執行命令", "抱歉，因為此連結的語式不正確，所以無法加以開啟: {0}", "抱歉，因為此連結遺失目標，所以無法加以開啟。", "開啟連結"],
    "vs/editor/contrib/multicursor/common/multicursor": ["在上方加入游標", "在下方加入游標", "在行尾新增游標"],
    "vs/editor/contrib/parameterHints/browser/parameterHints": ["觸發參數提示"],
    "vs/editor/contrib/parameterHints/browser/parameterHintsWidget": ["{0}，提示"],
    "vs/editor/contrib/quickFix/browser/quickFixCommands": ["顯示修正 ({0})", "顯示修正", "Quick Fix"],
    "vs/editor/contrib/referenceSearch/browser/referenceSearch": [" - {0} 個參考", "尋找所有參考"],
    "vs/editor/contrib/referenceSearch/browser/referencesController": ["正在載入..."],
    "vs/editor/contrib/referenceSearch/browser/referencesModel": ["個符號位於 {0} 中的第 {1} 行第 {2} 欄", "1 個符號位於 {0}, 完整路徑 {1}", "{0} 個符號位於 {1}, 完整路徑 {2}", "找不到結果", "在 {0} 中找到 1 個符號", "在 {1} 中找到 {0} 個符號", "在 {1} 個檔案中找到 {0} 個符號"],
    "vs/editor/contrib/referenceSearch/browser/referencesWidget": ["無法解析檔案。", "{0} 個參考", "{0} 個參考", "無法預覽", "參考", "沒有結果", "參考", "預覽檢視標題區域的背景色彩。", "預覽檢視標題的色彩。", "預覽檢視標題資訊的色彩。", "預覽檢視之框線與箭頭的色彩。", "預覽檢視中結果清單的背景色彩。", "預覽檢視結果列表中行節點的前景色彩", "預覽檢視結果列表中檔案節點的前景色彩", "在預覽檢視之結果清單中選取項目時的背景色彩。", "在預覽檢視之結果清單中選取項目時的前景色彩。", "預覽檢視編輯器的背景色彩。", "預覽檢視編輯器邊框(含行號或字形圖示)的背景色彩。", "在預覽檢視編輯器中比對時的反白顯示色彩。", "預覽檢視編輯器中比對時的反白顯示色彩。"],
    "vs/editor/contrib/rename/browser/rename": ["沒有結果。", "已成功將 '{0}' 重新命名為 '{1}'。摘要: {2}", "抱歉，無法執行重新命名。", "重新命名符號"],
    "vs/editor/contrib/rename/browser/renameInputField": ["為輸入重新命名。請鍵入新名稱，然後按 Enter 以認可。"],
    "vs/editor/contrib/smartSelect/common/smartSelect": ["展開選取", "縮小選取"],
    "vs/editor/contrib/suggest/browser/suggestController": ["接受 '{0}' 時接受了插入下列文字: {1}", "觸發建議"],
    "vs/editor/contrib/suggest/browser/suggestWidget": ["建議小工具的背景色彩。", "建議小工具的邊界色彩。", "建議小工具的前景色彩。", "建議小工具中所選項目的背景色彩。", "建議小工具中相符醒目提示的色彩。", "進一步了解...{0}", "{0}，建議，有詳細資料", "{0}，建議", "簡易說明...{0}", "正在載入...", "無建議。", "{0}，接受", "{0}，建議，有詳細資料", "{0}，建議"],
    "vs/editor/contrib/toggleTabFocusMode/common/toggleTabFocusMode": ["切換 TAB 鍵移動焦點"],
    "vs/editor/contrib/wordHighlighter/common/wordHighlighter": ["讀取存取期間 (例如讀取變數時) 符號的背景色彩。", "寫入存取期間 (例如寫入變數時) 符號的背景色彩。"],
    "vs/editor/contrib/zoneWidget/browser/peekViewWidget": ["關閉"],
    "vs/editor/standalone/browser/inspectTokens/inspectTokens": ["Developer: Inspect Tokens"],
    "vs/editor/standalone/browser/quickOpen/gotoLine": ["Go to line {0} and character {1}", "Go to line {0}", "Type a line number between 1 and {0} to navigate to", "Type a character between 1 and {0} to navigate to", "Go to line {0}", "Type a line number, followed by an optional colon and a character number to navigate to", "Go to Line..."],
    "vs/editor/standalone/browser/quickOpen/quickCommand": ["{0}, commands", "Type the name of an action you want to execute", "Command Palette"],
    "vs/editor/standalone/browser/quickOpen/quickOutline": ["{0}, symbols", "Type the name of an identifier you wish to navigate to", "Go to Symbol...", "symbols ({0})", "modules ({0})", "classes ({0})", "interfaces ({0})", "methods ({0})", "functions ({0})", "properties ({0})", "variables ({0})", "variables ({0})", "constructors ({0})", "calls ({0})"],
    "vs/editor/standalone/browser/standaloneCodeEditor": ["Editor content", "Press Ctrl+F1 for Accessibility Options.", "Press Alt+F1 for Accessibility Options."],
    "vs/editor/standalone/browser/toggleHighContrast/toggleHighContrast": ["Toggle High Contrast Theme"],
    "vs/platform/configuration/common/configurationRegistry": ["預設組態覆寫", "設定要針對 {0} 語言覆寫的編輯器設定。", "設定要針對語言覆寫的編輯器設定。", "無法註冊 '{0}'。這符合用於描述語言專用編輯器設定的屬性模式 '\\\\[.*\\\\]$'。請使用 'configurationDefaults' 貢獻。", "無法註冊 '{0}'。此屬性已經註冊。"],
    "vs/platform/keybinding/common/abstractKeybindingService": ["已按下 ({0})。請等待第二個套索鍵...", "按鍵組合 ({0}, {1}) 不是命令。"],
    "vs/platform/message/common/message": ["關閉", "稍後", "取消"],
    "vs/platform/theme/common/colorRegistry": ["色彩格式無效。請使用 #RGB、#RGBA、#RRGGBB 或 #RRGGBBAA", "工作台中使用的色彩。", "整體的前景色彩。僅當未被任何元件覆疊時，才會使用此色彩。", "整體錯誤訊息的前景色彩。僅當未被任何元件覆蓋時，才會使用此色彩。", "提供附加訊息的前景顏色,例如標籤", "焦點項目的整體框線色彩。只在沒有任何元件覆寫此色彩時，才會加以使用。", "項目周圍的額外框線，可將項目從其他項目中區隔出來以提高對比。", "使用中項目周圍的額外邊界，可將項目從其他項目中區隔出來以提高對比。", "作業區域選取的背景顏色(例如輸入或文字區域)。請注意，這不適用於編輯器中的選取。", "文字分隔符號的顏色。", "內文連結的前景色彩", "內文使用連結的前景色彩", "提示及建議文字的前景色彩。", "文內引用區塊背景色彩。", "引用文字的框線顏色。", "文字區塊的背景顏色。", "小工具的陰影色彩，例如編輯器中的尋找/取代。", "輸入方塊的背景。", "輸入方塊的前景。", "輸入方塊的框線。", "輸入欄位中可使用之項目的框線色彩。", "文字輸入替代字符的前景顏色。", "資訊嚴重性的輸入驗證背景色彩。", "資訊嚴重性的輸入驗證邊界色彩。", "資訊警告的輸入驗證背景色彩。", "警告嚴重性的輸入驗證邊界色彩。", "錯誤嚴重性的輸入驗證背景色彩。", "錯誤嚴重性的輸入驗證邊界色彩。", "下拉式清單的背景。", "下拉式清單的前景。", "下拉式清單的框線。", "當清單/樹狀為使用中狀態時，焦點項目的清單/樹狀背景色彩。使用中的清單/樹狀有鍵盤焦點，非使用中者則沒有。", "當清單/樹狀為使用中狀態時，焦點項目的清單/樹狀前景色彩。使用中的清單/樹狀有鍵盤焦點，非使用中者則沒有。", "當清單/樹狀為使用中狀態時，所選項目的清單/樹狀背景色彩。使用中的清單/樹狀有鍵盤焦點，非使用中者則沒有。", "當清單/樹狀為使用中狀態時，所選項目的清單/樹狀前景色彩。使用中的清單/樹狀有鍵盤焦點，非使用中者則沒有。", "當清單/樹狀為非使用中狀態時，所選項目的清單/樹狀背景色彩。使用中的清單/樹狀有鍵盤焦點，非使用中者則沒有。", "當清單/樹狀為使用中狀態時，所選項目的清單/樹狀前景色彩。使用中的清單/樹狀有鍵盤焦點，非使用中則沒有。", "當清單/樹狀為非使用中狀態時，所選項目的清單/樹狀背景色彩。使用中的清單/樹狀有鍵盤焦點，非使用中者則沒有。", "當清單/樹狀為使用中狀態時，所選項目的清單/樹狀前景色彩。使用中的清單/樹狀有鍵盤焦點，非使用中則沒有。", "使用滑鼠暫留在項目時的清單/樹狀背景。", "滑鼠暫留在項目時的清單/樹狀前景。", "使用滑鼠四處移動項目時的清單/樹狀拖放背景。", "在清單/樹狀內搜尋時，相符醒目提示的清單/樹狀前景色彩。", "分組標籤的快速選擇器色彩。", "分組邊界的快速選擇器色彩。", "按鈕前景色彩。", "按鈕背景色彩。", "暫留時的按鈕背景色彩。", "標記的背景顏色。標記為小型的訊息標籤,例如搜尋結果的數量。", "標記的前景顏色。標記為小型的訊息標籤,例如搜尋結果的數量。", "指出在捲動該檢視的捲軸陰影。", "捲軸滑桿的背景顏色。", "動態顯示時捲軸滑桿的背景顏色。", "使用中狀態下捲軸滑桿的背景顏色。", "長時間運行進度條的背景色彩.", "編輯器的背景色彩。", "編輯器的預設前景色彩。", "編輯器小工具的背景色彩，例如尋找/取代。", "編輯器小工具的邊界色彩。小工具選擇擁有邊界或色彩未被小工具覆寫時，才會使用色彩。", "編輯器選取範圍的色彩。", "為選取的文字顏色高對比化", "非使用中之編輯器選取範圍的色彩。", "選取時，內容相同之區域的色彩。", "符合目前搜尋的色彩。", "符合其他搜尋的色彩。", "限制搜尋之範圍的色彩。", "在顯示了動態顯示的單字下方醒目提示。", "編輯器動態顯示的背景色彩。", "編輯器動態顯示的框線色彩。", "使用中之連結的色彩。", "插入文字的背景色彩。", "移除文字的背景色彩。", "插入的文字外框色彩。", "移除的文字外框色彩。", "目前內嵌合併衝突中的深色標題背景。", "目前內嵌合併衝突中的內容背景。", "傳入內嵌合併衝突中的深色標題背景。", "傳入內嵌合併衝突中的內容背景。", "內嵌合併衝突中的共同始祖標題背景", "內嵌合併衝突中的共同始祖內容背景。", "內嵌合併衝突中標頭及分隔器的邊界色彩。", "目前內嵌合併衝突的概觀尺規前景。", "傳入內嵌合併衝突的概觀尺規前景。", "內嵌合併衝突中的共同上階概觀尺規前景。"]
});
//# sourceMappingURL=../../../min-maps/vs/editor/editor.main.nls.zh-tw.js.map
