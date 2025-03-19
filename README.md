# DentalAppointmentSystem 牙醫掛號系統
大一下 Java物件導向程式設計專題_牙醫掛號系統

## 目錄
- [專案介紹](#專案介紹)
- [功能特色](#功能特色)
- [系統架構](#系統架構)
- [安裝與使用](#安裝與使用)
- [類別設計](#類別設計)
- [參考資料](#參考資料)
- [作者](#作者)

## 專案介紹
牙醫掛號系統是一個 Java Swing 應用程式，提供患者掛號、修改、刪除預約的功能，並區分一般患者與特殊患者（如榮民、身障人士）。

## 功能特色
- **患者註冊與登入**
- **掛號管理**（新增、修改、刪除掛號資訊）
- **醫生管理**（指定預約醫生或現場掛號醫生）
- **病歷資料管理**（病患詳細資訊）

## 系統架構
```
📁 DentalAppointmentSystem
├── 📁 src
│   ├── StartPage.java  # 起始頁面
│   ├── SignUpPage.java  # 註冊頁面
│   ├── SearchPage.java  # 搜尋頁面
│   ├── ReviewPage.java  #查詢預約資料
│   ├── On_sitePage.java  #
│   ├── On_siteInfoPage.java  #
│   ├── AppointedPage.java  #
│   ├── AppointedInfoPage.java  #
│   ├── BasicInfoPage.java  #
│   ├── AuthenticationPage.java  #
│   ├── AppointmentSystem.java  # 掛號管理類別
│   ├── Dentist.java  # 牙醫抽象類別
│   ├── AppointedDentist.java  # 指定預約醫生
│   ├── On_siteDentist.java  # 現場掛號醫生
│   ├── Patient.java  # 病患抽象類別
│   ├── SpecialPatient.java  # 特殊病患（榮民、身障）
│   ├── NormalPatient.java  # 一般病患
│   ├── Verification.java # 驗證
│   ├── Detail.java  # 病歷詳細資訊
│   ├── Register.txt  # 註冊資料
│   ├── Patient.txt  # 病人資料
│   ├── Dentist.txt  # 醫師資料

└── 📁 resources
    ├── LOGO.png  # 應用程式圖示
    └── 資料.xlsx  # 儲存病患與醫生資料
```

## 安裝與使用
1. **下載專案**
   ```bash
   git clone https://github.com/your-username/DentalAppointmentSystem.git
   cd DentalAppointmentSystem
   ```
2. **開啟專案**
   - 使用 **Eclipse** 或 **IntelliJ IDEA** 載入專案。
   - 確保 JDK 17 或以上版本已安裝。
3. **執行程式**
   - 在 IDE 中執行 `StartPage.java`。
   - 進入登入或註冊頁面。

## 資料檔案
- `resources/資料.xlsx` - 儲存病患與醫生的初始資料


## 類別設計
### **病患 Patient (抽象類別)**
- `ID` (String) - 身分證號
- `name` (String) - 姓名
- `address` (String) - 住址
- `TEL` (String) - 電話
- `birth` (String) - 生日
- `charge` (int) - 掛號費
- `password` (String) - 登入密碼

### **牙醫 Dentist (抽象類別)**
- `name` (String) - 醫生姓名
- `TimeList` (TreeMap) - 約診時間
- `ID` (String) - 醫生編號

### **掛號系統 AppointmentSystem (控制類別)**
- `addAppointment()` - 新增掛號
- `editAppointment()` - 修改掛號
- `deleteAppointment()` - 刪除掛號

## 參考資料
- [Java Swing 日期選單](https://www.delftstack.com/zh-tw/howto/java/java-swing-date)
- [IT邦幫忙討論串](https://ithelp.ithome.com.tw/questions/10203960)

## 作者
- **傅珮茵 (4112029005)**
- **蔡侑容 (4112029008)**

