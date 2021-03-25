package com.wps.api.tree.et;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import com.wps.api.tree.et.*;
import com.wps.api.tree.kso.CommandBars;
import com.wps.api.tree.kso.CustomXMLParts;
import com.wps.api.tree.kso.DocumentInspector;
import com.wps.api.tree.kso.DocumentInspectors;
import com.wps.api.tree.kso.DocumentLibraryVersion;
import com.wps.api.tree.kso.DocumentLibraryVersions;
import com.wps.api.tree.kso.HTMLProject;
import com.wps.api.tree.kso.MetaProperties;
import com.wps.api.tree.kso.MetaProperty;
import com.wps.api.tree.kso.MsoEncoding;
import com.wps.api.tree.kso.OfficeTheme;
import com.wps.api.tree.kso.Permission;
import com.wps.api.tree.kso.PolicyItem;
import com.wps.api.tree.kso.ServerPolicy;
import com.wps.api.tree.kso.SharedWorkspace;
import com.wps.api.tree.kso.Signature;
import com.wps.api.tree.kso.SignatureSet;
import com.wps.api.tree.kso.SmartDocument;
import com.wps.api.tree.kso.Sync;
import com.wps.api.tree.kso.UserPermission;
import com.wps.api.tree.kso.WorkflowTask;
import com.wps.api.tree.kso.WorkflowTasks;
import com.wps.api.tree.kso.WorkflowTemplate;
import com.wps.api.tree.kso.WorkflowTemplates;
import com.wps.api.tree.vbide.VBProject;
import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.Holder;
import com4j.IID;
import com4j.LCID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{000208DA-0000-0000-C000-000000000046}")
public interface Workbook extends Com4jObject {
    @DISPID(148)
    @VTID(7)
    Application get_Application();

    @DISPID(149)
    @VTID(8)
    XlCreator get_Creator();

    @DISPID(150)
    @VTID(9)
    @ReturnValue(
            type = NativeType.Dispatch
    )
    Com4jObject get_Parent();

    @DISPID(1441)
    @VTID(10)
    boolean get_AcceptLabelsInFormulas();

    @DISPID(1441)
    @VTID(11)
    void put_AcceptLabelsInFormulas(boolean var1);

    @DISPID(304)
    @VTID(12)
    void Activate(@LCID int var1);

    @DISPID(183)
    @VTID(13)
    Chart get_ActiveChart();

    @DISPID(307)
    @VTID(14)
    @ReturnValue(
            type = NativeType.Dispatch
    )
    Worksheet get_ActiveSheet();

    @DISPID(574)
    @VTID(15)
    String get_Author(@LCID int var1);

    @DISPID(574)
    @VTID(16)
    void put_Author(@LCID int var1, String var2);

    @DISPID(1442)
    @VTID(17)
    int get_AutoUpdateFrequency();

    @DISPID(1442)
    @VTID(18)
    void put_AutoUpdateFrequency(int var1);

    @DISPID(1443)
    @VTID(19)
    boolean get_AutoUpdateSaveChanges();

    @DISPID(1443)
    @VTID(20)
    void put_AutoUpdateSaveChanges(boolean var1);

    @DISPID(1444)
    @VTID(21)
    int get_ChangeHistoryDuration();

    @DISPID(1444)
    @VTID(22)
    void put_ChangeHistoryDuration(int var1);

    @DISPID(1176)
    @VTID(23)
    @ReturnValue(
            type = NativeType.Dispatch
    )
    Com4jObject get_BuiltinDocumentProperties();

    @DISPID(989)
    @VTID(24)
    void ChangeFileAccess(XlFileAccess var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @LCID int var4);

    @DISPID(802)
    @VTID(25)
    void ChangeLink(String var1, String var2, @Optional @DefaultValue("1") XlLinkType var3, @LCID int var4);

    @DISPID(121)
    @VTID(26)
    Sheets get_Charts();

    @VTID(26)
    @ReturnValue(
            type = NativeType.Dispatch,
            defaultPropertyThrough = {Sheets.class}
    )
    Com4jObject get_Charts(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(277)
    @VTID(27)
    void Close(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @LCID int var4);

    @DISPID(1373)
    @VTID(28)
    String get_CodeName();

    @DISPID(-2147418112)
    @VTID(29)
    String get__CodeName();

    @DISPID(-2147418112)
    @VTID(30)
    void put__CodeName(String var1);

    @DISPID(286)
    @VTID(31)
    @ReturnValue(
            type = NativeType.VARIANT
    )
    Object get_Colors(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @LCID int var2);

    @DISPID(286)
    @VTID(32)
    void put_Colors(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @LCID int var2, @MarshalAs(NativeType.VARIANT) Object var3);

    @DISPID(1439)
    @VTID(33)
    CommandBars get_CommandBars();

    @DISPID(575)
    @VTID(34)
    String get_Comments(@LCID int var1);

    @DISPID(575)
    @VTID(35)
    void put_Comments(@LCID int var1, String var2);

    @DISPID(1175)
    @VTID(36)
    XlSaveConflictResolution get_ConflictResolution();

    @DISPID(1175)
    @VTID(37)
    void put_ConflictResolution(XlSaveConflictResolution var1);

    @DISPID(1190)
    @VTID(38)
    @ReturnValue(
            type = NativeType.Dispatch
    )
    Com4jObject get_Container();

    @DISPID(287)
    @VTID(39)
    boolean get_CreateBackup(@LCID int var1);

    @DISPID(1177)
    @VTID(40)
    @ReturnValue(
            type = NativeType.Dispatch
    )
    Com4jObject get_CustomDocumentProperties();

    @DISPID(403)
    @VTID(41)
    boolean get_Date1904(@LCID int var1);

    @DISPID(403)
    @VTID(42)
    void put_Date1904(@LCID int var1, boolean var2);

    @DISPID(397)
    @VTID(43)
    void DeleteNumberFormat(String var1, @LCID int var2);

    @DISPID(764)
    @VTID(44)
    Sheets get_DialogSheets();

    @VTID(44)
    @ReturnValue(
            type = NativeType.Dispatch,
            defaultPropertyThrough = {Sheets.class}
    )
    Com4jObject get_DialogSheets(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(404)
    @VTID(45)
    XlDisplayDrawingObjects get_DisplayDrawingObjects(@LCID int var1);

    @DISPID(404)
    @VTID(46)
    void put_DisplayDrawingObjects(@LCID int var1, XlDisplayDrawingObjects var2);

    @DISPID(1168)
    @VTID(47)
    boolean ExclusiveAccess(@LCID int var1);

    @DISPID(288)
    @VTID(48)
    XlFileFormat get_FileFormat(@LCID int var1);

    @DISPID(973)
    @VTID(49)
    void ForwardMailer(@LCID int var1);

    @DISPID(289)
    @VTID(50)
    String get_FullName(@LCID int var1);

    @DISPID(976)
    @VTID(51)
    boolean get_HasMailer(@LCID int var1);

    @DISPID(976)
    @VTID(52)
    void put_HasMailer(@LCID int var1, boolean var2);

    @DISPID(290)
    @VTID(53)
    boolean get_HasPassword(@LCID int var1);

    @DISPID(950)
    @VTID(54)
    boolean get_HasRoutingSlip(@LCID int var1);

    @DISPID(950)
    @VTID(55)
    void put_HasRoutingSlip(@LCID int var1, boolean var2);

    @DISPID(1445)
    @VTID(56)
    boolean get_IsAddin();

    @DISPID(1445)
    @VTID(57)
    void put_IsAddin(boolean var1);

    @DISPID(577)
    @VTID(58)
    String get_Keywords(@LCID int var1);

    @DISPID(577)
    @VTID(59)
    void put_Keywords(@LCID int var1, String var2);

    @DISPID(807)
    @VTID(60)
    @ReturnValue(
            type = NativeType.VARIANT
    )
    Object LinkInfo(String var1, XlLinkInfo var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4, @LCID int var5);

    @DISPID(808)
    @VTID(61)
    @ReturnValue(
            type = NativeType.VARIANT
    )
    Object LinkSources(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @LCID int var2);

    @DISPID(979)
    @VTID(62)
    Mailer get_Mailer();

    @DISPID(1446)
    @VTID(63)
    void MergeWorkbook(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(582)
    @VTID(64)
    Sheets get_Modules();

    @VTID(64)
    @ReturnValue(
            type = NativeType.Dispatch,
            defaultPropertyThrough = {Sheets.class}
    )
    Com4jObject get_Modules(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(1169)
    @VTID(65)
    boolean get_MultiUserEditing(@LCID int var1);

    @DISPID(110)
    @VTID(66)
    String get_Name();

    @DISPID(442)
    @VTID(67)
    Names get_Names();

    @DISPID(280)
    @VTID(68)
    Window NewWindow(@LCID int var1);

    @DISPID(1178)
    @VTID(69)
    String get_OnSave(@LCID int var1);

    @DISPID(1178)
    @VTID(70)
    void put_OnSave(@LCID int var1, String var2);

    @DISPID(1031)
    @VTID(71)
    String get_OnSheetActivate(@LCID int var1);

    @DISPID(1031)
    @VTID(72)
    void put_OnSheetActivate(@LCID int var1, String var2);

    @DISPID(1081)
    @VTID(73)
    String get_OnSheetDeactivate(@LCID int var1);

    @DISPID(1081)
    @VTID(74)
    void put_OnSheetDeactivate(@LCID int var1, String var2);

    @DISPID(803)
    @VTID(75)
    void OpenLinks(String var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @LCID int var4);

    @DISPID(291)
    @VTID(76)
    String get_Path(@LCID int var1);

    @DISPID(1447)
    @VTID(77)
    boolean get_PersonalViewListSettings();

    @DISPID(1447)
    @VTID(78)
    void put_PersonalViewListSettings(boolean var1);

    @DISPID(1448)
    @VTID(79)
    boolean get_PersonalViewPrintSettings();

    @DISPID(1448)
    @VTID(80)
    void put_PersonalViewPrintSettings(boolean var1);

    @DISPID(1449)
    @VTID(81)
    PivotCaches PivotCaches();

    @DISPID(1166)
    @VTID(82)
    void Post(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @LCID int var2);

    @DISPID(405)
    @VTID(83)
    boolean get_PrecisionAsDisplayed(@LCID int var1);

    @DISPID(405)
    @VTID(84)
    void put_PrecisionAsDisplayed(@LCID int var1, boolean var2);

    @DISPID(905)
    @VTID(85)
    void __PrintOut(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4, @Optional @MarshalAs(NativeType.VARIANT) Object var5, @Optional @MarshalAs(NativeType.VARIANT) Object var6, @Optional @MarshalAs(NativeType.VARIANT) Object var7, @LCID int var8);

    @DISPID(281)
    @VTID(86)
    void PrintPreview(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @LCID int var2);

    @DISPID(282)
    @VTID(87)
    void _Protect(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3);

    @DISPID(1450)
    @VTID(88)
    void _ProtectSharing(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4, @Optional @MarshalAs(NativeType.VARIANT) Object var5, @Optional @MarshalAs(NativeType.VARIANT) Object var6);

    @DISPID(588)
    @VTID(89)
    boolean get_ProtectStructure();

    @DISPID(295)
    @VTID(90)
    boolean get_ProtectWindows();

    @DISPID(296)
    @VTID(91)
    boolean get_ReadOnly(@LCID int var1);

    @DISPID(297)
    @VTID(92)
    boolean get__ReadOnlyRecommended(@LCID int var1);

    @DISPID(1452)
    @VTID(93)
    void RefreshAll();

    @DISPID(977)
    @VTID(94)
    void Reply(@LCID int var1);

    @DISPID(978)
    @VTID(95)
    void ReplyAll(@LCID int var1);

    @DISPID(1453)
    @VTID(96)
    void RemoveUser(int var1);

    @DISPID(1172)
    @VTID(97)
    int get_RevisionNumber(@LCID int var1);

    @DISPID(946)
    @VTID(98)
    void Route(@LCID int var1);

    @DISPID(951)
    @VTID(99)
    boolean get_Routed(@LCID int var1);

    @DISPID(949)
    @VTID(100)
    RoutingSlip get_RoutingSlip();

    @DISPID(634)
    @VTID(101)
    void RunAutoMacros(XlRunAutoMacro var1, @LCID int var2);

    @DISPID(283)
    @VTID(102)
    void Save(@LCID int var1);

    @DISPID(284)
    @VTID(103)
    void _SaveAs(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4, @Optional @MarshalAs(NativeType.VARIANT) Object var5, @Optional @MarshalAs(NativeType.VARIANT) Object var6, @Optional @DefaultValue("1") XlSaveAsAccessMode var7, @Optional @MarshalAs(NativeType.VARIANT) Object var8, @Optional @MarshalAs(NativeType.VARIANT) Object var9, @Optional @MarshalAs(NativeType.VARIANT) Object var10, @Optional @MarshalAs(NativeType.VARIANT) Object var11, @LCID int var12);

    @DISPID(175)
    @VTID(104)
    void SaveCopyAs(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @LCID int var2);

    @DISPID(298)
    @VTID(105)
    boolean get_Saved(@LCID int var1);

    @DISPID(298)
    @VTID(106)
    void put_Saved(@LCID int var1, boolean var2);

    @DISPID(406)
    @VTID(107)
    boolean get_SaveLinkValues(@LCID int var1);

    @DISPID(406)
    @VTID(108)
    void put_SaveLinkValues(@LCID int var1, boolean var2);

    @DISPID(947)
    @VTID(109)
    void SendMail(@MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @LCID int var4);

    @DISPID(980)
    @VTID(110)
    void SendMailer(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @DefaultValue("-4143") XlPriority var2, @LCID int var3);

    @DISPID(809)
    @VTID(111)
    void SetLinkOnData(String var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @LCID int var3);

    @DISPID(485)
    @VTID(112)
    Sheets get_Sheets();

    @VTID(112)
    @ReturnValue(
            type = NativeType.Dispatch,
            defaultPropertyThrough = {Sheets.class}
    )
    Com4jObject get_Sheets(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(1171)
    @VTID(113)
    boolean get_ShowConflictHistory(@LCID int var1);

    @DISPID(1171)
    @VTID(114)
    void put_ShowConflictHistory(@LCID int var1, boolean var2);

    @DISPID(493)
    @VTID(115)
    Styles get_Styles();

    @DISPID(953)
    @VTID(116)
    String get_Subject(@LCID int var1);

    @DISPID(953)
    @VTID(117)
    void put_Subject(@LCID int var1, String var2);

    @DISPID(199)
    @VTID(118)
    String get_Title(@LCID int var1);

    @DISPID(199)
    @VTID(119)
    void put_Title(@LCID int var1, String var2);

    @DISPID(285)
    @VTID(120)
    void Unprotect(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @LCID int var2);

    @DISPID(1455)
    @VTID(121)
    void UnprotectSharing(@Optional @MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(995)
    @VTID(122)
    void UpdateFromFile(@LCID int var1);

    @DISPID(804)
    @VTID(123)
    void UpdateLink(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @LCID int var3);

    @DISPID(411)
    @VTID(124)
    boolean get_UpdateRemoteReferences(@LCID int var1);

    @DISPID(411)
    @VTID(125)
    void put_UpdateRemoteReferences(@LCID int var1, boolean var2);

    @DISPID(1210)
    @VTID(126)
    boolean get_UserControl();

    @DISPID(1210)
    @VTID(127)
    void put_UserControl(boolean var1);

    @DISPID(1173)
    @VTID(128)
    @ReturnValue(
            type = NativeType.VARIANT
    )
    Object get_UserStatus(@LCID int var1);

    @DISPID(1456)
    @VTID(129)
    CustomViews get_CustomViews();

    @DISPID(430)
    @VTID(130)
    Windows get_Windows();

    @DISPID(494)
    @VTID(131)
    Sheets get_Worksheets();

    @VTID(131)
    @ReturnValue(
            type = NativeType.Dispatch,
            defaultPropertyThrough = {Sheets.class}
    )
    Com4jObject get_Worksheets(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(299)
    @VTID(132)
    boolean get_WriteReserved(@LCID int var1);

    @DISPID(300)
    @VTID(133)
    String get_WriteReservedBy(@LCID int var1);

    @DISPID(581)
    @VTID(134)
    Sheets get_Excel4IntlMacroSheets();

    @VTID(134)
    @ReturnValue(
            type = NativeType.Dispatch,
            defaultPropertyThrough = {Sheets.class}
    )
    Com4jObject get_Excel4IntlMacroSheets(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(579)
    @VTID(135)
    Sheets get_Excel4MacroSheets();

    @VTID(135)
    @ReturnValue(
            type = NativeType.Dispatch,
            defaultPropertyThrough = {Sheets.class}
    )
    Com4jObject get_Excel4MacroSheets(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(1457)
    @VTID(136)
    boolean get_TemplateRemoveExtData();

    @DISPID(1457)
    @VTID(137)
    void put_TemplateRemoveExtData(boolean var1);

    @DISPID(1458)
    @VTID(138)
    void HighlightChangesOptions(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3);

    @DISPID(1461)
    @VTID(139)
    boolean get_HighlightChangesOnScreen();

    @DISPID(1461)
    @VTID(140)
    void put_HighlightChangesOnScreen(boolean var1);

    @DISPID(1462)
    @VTID(141)
    boolean get_KeepChangeHistory();

    @DISPID(1462)
    @VTID(142)
    void put_KeepChangeHistory(boolean var1);

    @DISPID(1463)
    @VTID(143)
    boolean get_ListChangesOnNewSheet();

    @DISPID(1463)
    @VTID(144)
    void put_ListChangesOnNewSheet(boolean var1);

    @DISPID(1464)
    @VTID(145)
    void PurgeChangeHistoryNow(int var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2);

    @DISPID(1466)
    @VTID(146)
    void AcceptAllChanges(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3);

    @DISPID(1467)
    @VTID(147)
    void RejectAllChanges(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3);

    @DISPID(684)
    @VTID(148)
    void PivotTableWizard(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4, @Optional @MarshalAs(NativeType.VARIANT) Object var5, @Optional @MarshalAs(NativeType.VARIANT) Object var6, @Optional @MarshalAs(NativeType.VARIANT) Object var7, @Optional @MarshalAs(NativeType.VARIANT) Object var8, @Optional @MarshalAs(NativeType.VARIANT) Object var9, @Optional @MarshalAs(NativeType.VARIANT) Object var10, @Optional @MarshalAs(NativeType.VARIANT) Object var11, @Optional @MarshalAs(NativeType.VARIANT) Object var12, @Optional @MarshalAs(NativeType.VARIANT) Object var13, @Optional @MarshalAs(NativeType.VARIANT) Object var14, @Optional @MarshalAs(NativeType.VARIANT) Object var15, @Optional @MarshalAs(NativeType.VARIANT) Object var16, @LCID int var17);

    @DISPID(1468)
    @VTID(149)
    void ResetColors();

    @DISPID(1469)
    @VTID(150)
    VBProject get_VBProject();

    @DISPID(1470)
    @VTID(151)
    void FollowHyperlink(String var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4, @Optional @MarshalAs(NativeType.VARIANT) Object var5, @Optional @MarshalAs(NativeType.VARIANT) Object var6, @Optional @MarshalAs(NativeType.VARIANT) Object var7);

    @DISPID(1476)
    @VTID(152)
    void AddToFavorites();

    @DISPID(1769)
    @VTID(153)
    boolean get_IsInplace();

    @DISPID(1772)
    @VTID(154)
    void _PrintOut(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4, @Optional @MarshalAs(NativeType.VARIANT) Object var5, @Optional @MarshalAs(NativeType.VARIANT) Object var6, @Optional @MarshalAs(NativeType.VARIANT) Object var7, @Optional @MarshalAs(NativeType.VARIANT) Object var8, @LCID int var9);

    @DISPID(1818)
    @VTID(155)
    void WebPagePreview();

    @DISPID(1819)
    @VTID(156)
    PublishObjects get_PublishObjects();

    @DISPID(1820)
    @VTID(157)
    WebOptions get_WebOptions();

    @DISPID(1821)
    @VTID(158)
    void ReloadAs(MsoEncoding var1);

    @DISPID(1823)
    @VTID(159)
    HTMLProject get_HTMLProject();

    @DISPID(1824)
    @VTID(160)
    boolean get_EnvelopeVisible();

    @DISPID(1824)
    @VTID(161)
    void put_EnvelopeVisible(boolean var1);

    @DISPID(1806)
    @VTID(162)
    int get_CalculationVersion();

    @DISPID(2044)
    @VTID(163)
    void Dummy17(int var1);

    @DISPID(1826)
    @VTID(164)
    void sblt(String var1);

    @DISPID(1828)
    @VTID(165)
    boolean get_VBASigned();

    @DISPID(2046)
    @VTID(166)
    boolean get_ShowPivotTableFieldList();

    @DISPID(2046)
    @VTID(167)
    void put_ShowPivotTableFieldList(boolean var1);

    @DISPID(864)
    @VTID(168)
    XlUpdateLinks get_UpdateLinks();

    @DISPID(864)
    @VTID(169)
    void put_UpdateLinks(XlUpdateLinks var1);

    @DISPID(2047)
    @VTID(170)
    void BreakLink(String var1, XlLinkType var2);

    @DISPID(2048)
    @VTID(171)
    void Dummy16();

    @DISPID(1925)
    @VTID(172)
    void SaveAs(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4, @Optional @MarshalAs(NativeType.VARIANT) Object var5, @Optional @MarshalAs(NativeType.VARIANT) Object var6, @Optional @DefaultValue("1") XlSaveAsAccessMode var7, @Optional @MarshalAs(NativeType.VARIANT) Object var8, @Optional @MarshalAs(NativeType.VARIANT) Object var9, @Optional @MarshalAs(NativeType.VARIANT) Object var10, @Optional @MarshalAs(NativeType.VARIANT) Object var11, @Optional @MarshalAs(NativeType.VARIANT) Object var12, @LCID int var13);

    @DISPID(2049)
    @VTID(173)
    boolean get_EnableAutoRecover();

    @DISPID(2049)
    @VTID(174)
    void put_EnableAutoRecover(boolean var1);

    @DISPID(2050)
    @VTID(175)
    boolean get_RemovePersonalInformation();

    @DISPID(2050)
    @VTID(176)
    void put_RemovePersonalInformation(boolean var1);

    @DISPID(1927)
    @VTID(177)
    String get_FullNameURLEncoded(@LCID int var1);

    @DISPID(2051)
    @VTID(178)
    void CheckIn(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3);

    @DISPID(2053)
    @VTID(179)
    boolean CanCheckIn();

    @DISPID(2054)
    @VTID(180)
    void SendForReview(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4);

    @DISPID(2057)
    @VTID(181)
    void ReplyWithChanges(@Optional @MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(2058)
    @VTID(182)
    void EndReview();

    @DISPID(429)
    @VTID(183)
    String get_Password();

    @DISPID(429)
    @VTID(184)
    void put_Password(String var1);

    @DISPID(1128)
    @VTID(185)
    String get_WritePassword();

    @DISPID(1128)
    @VTID(186)
    void put_WritePassword(String var1);

    @DISPID(2059)
    @VTID(187)
    String get_PasswordEncryptionProvider();

    @DISPID(2060)
    @VTID(188)
    String get_PasswordEncryptionAlgorithm();

    @DISPID(2061)
    @VTID(189)
    int get_PasswordEncryptionKeyLength();

    @DISPID(2062)
    @VTID(190)
    void SetPasswordEncryptionOptions(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4);

    @DISPID(2063)
    @VTID(191)
    boolean get_PasswordEncryptionFileProperties();

    @DISPID(2005)
    @VTID(192)
    boolean get_ReadOnlyRecommended();

    @DISPID(2005)
    @VTID(193)
    void put_ReadOnlyRecommended(boolean var1);

    @DISPID(2029)
    @VTID(194)
    void Protect(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3);

    @DISPID(2064)
    @VTID(195)
    SmartTagOptions get_SmartTagOptions();

    @DISPID(2065)
    @VTID(196)
    void RecheckSmartTags();

    @DISPID(2264)
    @VTID(197)
    Permission get_Permission();

    @VTID(197)
    @ReturnValue(
            defaultPropertyThrough = {Permission.class}
    )
    UserPermission get_Permission(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(2265)
    @VTID(198)
    SharedWorkspace get_SharedWorkspace();

    @DISPID(2266)
    @VTID(199)
    Sync get_Sync();

    @DISPID(2267)
    @VTID(200)
    void SendFaxOverInternet(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3);

    @DISPID(2268)
    @VTID(201)
    XmlNamespaces get_XmlNamespaces();

    @DISPID(2269)
    @VTID(202)
    XmlMaps get_XmlMaps();

    @DISPID(2270)
    @VTID(203)
    XlXmlImportResult XmlImport(String var1, Holder<XmlMap> var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4);

    @DISPID(2273)
    @VTID(204)
    SmartDocument get_SmartDocument();

    @DISPID(2274)
    @VTID(205)
    DocumentLibraryVersions get_DocumentLibraryVersions();

    @VTID(205)
    @ReturnValue(
            defaultPropertyThrough = {DocumentLibraryVersions.class}
    )
    DocumentLibraryVersion get_DocumentLibraryVersions(int var1);

    @DISPID(2275)
    @VTID(206)
    boolean get_InactiveListBorderVisible();

    @DISPID(2275)
    @VTID(207)
    void put_InactiveListBorderVisible(boolean var1);

    @DISPID(2276)
    @VTID(208)
    boolean get_DisplayInkComments();

    @DISPID(2276)
    @VTID(209)
    void put_DisplayInkComments(boolean var1);

    @DISPID(2277)
    @VTID(210)
    XlXmlImportResult XmlImportXml(String var1, Holder<XmlMap> var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4);

    @DISPID(2278)
    @VTID(211)
    void SaveAsXMLData(String var1, XmlMap var2);

    @DISPID(2279)
    @VTID(212)
    void ToggleFormsDesign();

    @DISPID(2512)
    @VTID(213)
    MetaProperties get_ContentTypeProperties();

    @VTID(213)
    @ReturnValue(
            defaultPropertyThrough = {MetaProperties.class}
    )
    MetaProperty get_ContentTypeProperties(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(2513)
    @VTID(214)
    Connections get_Connections();

    @DISPID(2514)
    @VTID(215)
    void RemoveDocumentInformation(XlRemoveDocInfoType var1);

    @DISPID(2516)
    @VTID(216)
    SignatureSet get_Signatures();

    @VTID(216)
    @ReturnValue(
            defaultPropertyThrough = {SignatureSet.class}
    )
    Signature get_Signatures(int var1);

    @DISPID(2517)
    @VTID(217)
    void CheckInWithVersion(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4);

    @DISPID(2519)
    @VTID(218)
    ServerPolicy get_ServerPolicy();

    @VTID(218)
    @ReturnValue(
            defaultPropertyThrough = {ServerPolicy.class}
    )
    PolicyItem get_ServerPolicy(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(2520)
    @VTID(219)
    void LockServerFile();

    @DISPID(2521)
    @VTID(220)
    DocumentInspectors get_DocumentInspectors();

    @VTID(220)
    @ReturnValue(
            defaultPropertyThrough = {DocumentInspectors.class}
    )
    DocumentInspector get_DocumentInspectors(int var1);

    @DISPID(2522)
    @VTID(221)
    WorkflowTasks GetWorkflowTasks();

    @VTID(221)
    @ReturnValue(
            defaultPropertyThrough = {WorkflowTasks.class}
    )
    WorkflowTask GetWorkflowTasks(int var1);

    @DISPID(2523)
    @VTID(222)
    WorkflowTemplates GetWorkflowTemplates();

    @VTID(222)
    @ReturnValue(
            defaultPropertyThrough = {WorkflowTemplates.class}
    )
    WorkflowTemplate GetWorkflowTemplates(int var1);

    @DISPID(2361)
    @VTID(223)
    void PrintOut(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4, @Optional @MarshalAs(NativeType.VARIANT) Object var5, @Optional @MarshalAs(NativeType.VARIANT) Object var6, @Optional @MarshalAs(NativeType.VARIANT) Object var7, @Optional @MarshalAs(NativeType.VARIANT) Object var8, @Optional @MarshalAs(NativeType.VARIANT) Object var9, @LCID int var10);

    @DISPID(2524)
    @VTID(224)
    ServerViewableItems get_ServerViewableItems();

    @DISPID(2525)
    @VTID(225)
    TableStyles get_TableStyles();

    @DISPID(2526)
    @VTID(226)
    @ReturnValue(
            type = NativeType.VARIANT
    )
    Object get_DefaultTableStyle();

    @DISPID(2526)
    @VTID(227)
    void put_DefaultTableStyle(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(2527)
    @VTID(228)
    @ReturnValue(
            type = NativeType.VARIANT
    )
    Object get_DefaultPivotTableStyle();

    @DISPID(2527)
    @VTID(229)
    void put_DefaultPivotTableStyle(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(2528)
    @VTID(230)
    boolean get_CheckCompatibility();

    @DISPID(2528)
    @VTID(231)
    void put_CheckCompatibility(boolean var1);

    @DISPID(2529)
    @VTID(232)
    boolean get_HasVBProject();

    @DISPID(2530)
    @VTID(233)
    CustomXMLParts get_CustomXMLParts();

    @DISPID(2531)
    @VTID(234)
    boolean get_Final();

    @DISPID(2531)
    @VTID(235)
    void put_Final(boolean var1);

    @DISPID(2532)
    @VTID(236)
    Research get_Research();

    @DISPID(2533)
    @VTID(237)
    OfficeTheme get_Theme();

    @DISPID(2534)
    @VTID(238)
    void ApplyTheme(String var1);

    @DISPID(2535)
    @VTID(239)
    boolean get_Excel8CompatibilityMode();

    @DISPID(2536)
    @VTID(240)
    boolean get_ConnectionsDisabled();

    @DISPID(2537)
    @VTID(241)
    void EnableConnections();

    @DISPID(2538)
    @VTID(242)
    boolean get_ShowPivotChartActiveFields();

    @DISPID(2538)
    @VTID(243)
    void put_ShowPivotChartActiveFields(boolean var1);

    @DISPID(2493)
    @VTID(244)
    void ExportAsFixedFormat(XlFixedFormatType var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4, @Optional @MarshalAs(NativeType.VARIANT) Object var5, @Optional @MarshalAs(NativeType.VARIANT) Object var6, @Optional @MarshalAs(NativeType.VARIANT) Object var7, @Optional @MarshalAs(NativeType.VARIANT) Object var8, @Optional @MarshalAs(NativeType.VARIANT) Object var9);

    @DISPID(2539)
    @VTID(245)
    IconSets get_IconSets();

    @DISPID(2540)
    @VTID(246)
    String get_EncryptionProvider();

    @DISPID(2540)
    @VTID(247)
    void put_EncryptionProvider(String var1);

    @DISPID(2541)
    @VTID(248)
    boolean get_DoNotPromptForConvert();

    @DISPID(2541)
    @VTID(249)
    void put_DoNotPromptForConvert(boolean var1);

    @DISPID(2542)
    @VTID(250)
    boolean get_ForceFullCalculation();

    @DISPID(2542)
    @VTID(251)
    void put_ForceFullCalculation(boolean var1);

    @DISPID(2543)
    @VTID(252)
    void ProtectSharing(@Optional @MarshalAs(NativeType.VARIANT) Object var1, @Optional @MarshalAs(NativeType.VARIANT) Object var2, @Optional @MarshalAs(NativeType.VARIANT) Object var3, @Optional @MarshalAs(NativeType.VARIANT) Object var4, @Optional @MarshalAs(NativeType.VARIANT) Object var5, @Optional @MarshalAs(NativeType.VARIANT) Object var6, @Optional @MarshalAs(NativeType.VARIANT) Object var7);

    @DISPID(2866)
    @VTID(253)
    SlicerCaches get_SlicerCaches();

    @DISPID(2867)
    @VTID(254)
    Slicer get_ActiveSlicer();

    @DISPID(2868)
    @VTID(255)
    @ReturnValue(
            type = NativeType.VARIANT
    )
    Object get_DefaultSlicerStyle();

    @DISPID(2868)
    @VTID(256)
    void put_DefaultSlicerStyle(@MarshalAs(NativeType.VARIANT) Object var1);

    @DISPID(2869)
    @VTID(257)
    void Dummy26();

    @DISPID(2870)
    @VTID(258)
    void Dummy27();

    @DISPID(2871)
    @VTID(259)
    int get_AccuracyVersion();

    @DISPID(2871)
    @VTID(260)
    void put_AccuracyVersion(int var1);

    @DISPID(3056)
    @VTID(261)
    boolean get_CaseSensitive();

    @DISPID(3057)
    @VTID(262)
    boolean get_UseWholeCellCriteria();

    @DISPID(3058)
    @VTID(263)
    boolean get_UseWildcards();

    @DISPID(690)
    @VTID(264)
    @ReturnValue(
            type = NativeType.Dispatch
    )
    Com4jObject get_PivotTables();

    @DISPID(3059)
    @VTID(265)
    Model get_Model();

    @DISPID(2998)
    @VTID(266)
    boolean get_ChartDataPointTrack();

    @DISPID(2998)
    @VTID(267)
    void put_ChartDataPointTrack(boolean var1);

    @DISPID(3060)
    @VTID(268)
    @ReturnValue(
            type = NativeType.VARIANT
    )
    Object get_DefaultTimelineStyle();

    @DISPID(3060)
    @VTID(269)
    void put_DefaultTimelineStyle(@MarshalAs(NativeType.VARIANT) Object var1);
}

