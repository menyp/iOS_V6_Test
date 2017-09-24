package Native;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import jdk.internal.org.xml.sax.SAXException;

public class IosElements {
	
	
	//Buttons1
	
	
	String BTNloginID;
	String BTNAddEnvironment;
	String BTNadd;
	String BTNfillFromBarcode;
	String BTNenvironmentType;
	
	
	String BTNforgotPasswordID;
	String BTNsettingsLoginScreenID;
	String BTNsampleAccountID;
	String BTNweeklyOperationsID;
	String BTNokName;
	String BTNcancelForgotPasswordID;
	String BTNrecoverPasswordID;
	String BTNresetPasswordID;
	String BTNdone;
	String BTNlogout;
	String BTNBackName;
	String BTNClearName;
	String BTNSlicer;
	String BTNmapphoneiconID;
	String BTNCancel;
	String BTNdirection;
	String BTNpriority_Name;
	String BTNnewServiceCallId;
	String BTNsubmit_ID;
	String BTNaddContact_Name;
	String BTNdeleteDraft;
	String BTNclearText;
	String BTNdelete;
	String BTNrefresh_Name;
	String BTNsend;
	String BTNseeAll_ID;
	String BTNkeyboardDelete;
	String BtnkeyboardMoreNumbers;
	String BTNsave;
	
	
	
	
	//TextFields	
	String TEXTFIELDemailID;
	String TEXTFIELDpasswordID;
	String TEXTFIELDendpointURL;
	
	
	
	
	
	//STRINGS
	String scrollDown;
	String scrollUp;
	String DashboardName;
	String SalesName;
	String ReturnsName;
	String NetSalesName;
	
	String DailySalesBarID;
	String DailysalesPieID;
	String DestinyUSAID;
	String Last12hoursID;
	String BranchID;
	String DailySalesID;
	String ServiceCallsID;
	String ServiceCallsMapID;
	String MallOfAmerica_Id;
	
	String CameraPemissions_ID;
	String ContactsPermissionsName;
	String OrderLookup_ID;
	
	
	//Checkbox
	
	
	//Icons
	
	String IconLoginSettings;
	String IconCancelENV;
	
	
	String Iconaction_icon_green_Name;
	String Icon_AllApps_Name;
	String IconBack;
	String IconBack_Nav_Name;
	String IconApplicationInfo_Name;
	String Icon_Map_Navigation;
	String Icon_PieChart_Navigation;
	String Icon_BarChart_Navigation;
	
	
	
	
	//General Info
	String ConnectionAIRPLANE_MODE;
	String ConnectionWIFI;
	String CoonectionDATA;
	String ConnectionALL;
	String TabBarTitle_Name;
	
	// Credentials
	String UserProd;
	String passwordProd;
	String userQA;
	String passwordQA;
	String badPassword;
	String StartupApplication;
	String UserNoAppsPermissions;
	String UserinActive;
	
	
	
	
	public IosElements(String langXml, String xmlPath ) throws ParserConfigurationException, SAXException, IOException, InterruptedException, org.xml.sax.SAXException{
		this.BTNloginID = XmlHandel.readAndroidXml("BTNloginID", langXml, xmlPath);
		this.BTNforgotPasswordID = XmlHandel.readAndroidXml("BTNforgotPasswordID", langXml, xmlPath);
		this.BTNsettingsLoginScreenID = XmlHandel.readAndroidXml("BTNsettingsLoginScreenID", langXml, xmlPath);
		this.BTNsampleAccountID = XmlHandel.readAndroidXml("BTNsampleAccountID", langXml, xmlPath);
		this.BTNcancelForgotPasswordID = XmlHandel.readAndroidXml("BTNcancelForgotPasswordID", langXml, xmlPath);
		this.BTNrecoverPasswordID = XmlHandel.readAndroidXml("BTNrecoverPasswordID", langXml, xmlPath);
		this.BTNresetPasswordID = XmlHandel.readAndroidXml("BTNresetPasswordID", langXml, xmlPath);
		this.BTNdone = XmlHandel.readAndroidXml("BTNdone", langXml, xmlPath);
		this.BTNlogout = XmlHandel.readAndroidXml("BTNlogout", langXml, xmlPath);
		this.BTNBackName = XmlHandel.readAndroidXml("BTNBackName", langXml, xmlPath);
		this.BTNClearName = XmlHandel.readAndroidXml("BTNClearName", langXml, xmlPath);
		this.BTNSlicer = XmlHandel.readAndroidXml("BTNSlicer", langXml, xmlPath);
		this.BTNmapphoneiconID = XmlHandel.readAndroidXml("BTNmapphoneiconID", langXml, xmlPath);
		this.BTNCancel = XmlHandel.readAndroidXml("BTNCancel", langXml, xmlPath);
		this.BTNdirection = XmlHandel.readAndroidXml("BTNdirection", langXml, xmlPath);
		this.BTNokName = XmlHandel.readAndroidXml("BTNokName", langXml, xmlPath);
		this.BTNpriority_Name = XmlHandel.readAndroidXml("BTNpriority_Name", langXml, xmlPath);
		this.BTNnewServiceCallId = XmlHandel.readAndroidXml("BTNnewServiceCallId", langXml, xmlPath);
		this.BTNsubmit_ID = XmlHandel.readAndroidXml("BTNsubmit_ID", langXml, xmlPath);
		this.BTNaddContact_Name = XmlHandel.readAndroidXml("BTNaddContact_Name", langXml, xmlPath);
		this.BTNdeleteDraft = XmlHandel.readAndroidXml("BTNdeleteDraft", langXml, xmlPath);
		this.BTNclearText = XmlHandel.readAndroidXml("BTNclearText", langXml, xmlPath);
		this.BTNdelete = XmlHandel.readAndroidXml("BTNdelete", langXml, xmlPath);
		this.BTNrefresh_Name = XmlHandel.readAndroidXml("BTNrefresh_Name", langXml, xmlPath);
		this.BTNsend = XmlHandel.readAndroidXml("BTNsend", langXml, xmlPath);
		this.BTNseeAll_ID = XmlHandel.readAndroidXml("BTNseeAll_ID", langXml, xmlPath);
		this.BTNkeyboardDelete = XmlHandel.readAndroidXml("BTNkeyboardDelete", langXml, xmlPath);
		this.BtnkeyboardMoreNumbers = XmlHandel.readAndroidXml("BtnkeyboardMoreNumbers", langXml, xmlPath);
		this.BTNsave = XmlHandel.readAndroidXml("BTNsave", langXml, xmlPath);
		this.BTNAddEnvironment = XmlHandel.readAndroidXml("BTNAddEnvironment", langXml, xmlPath);
		this.BTNadd = XmlHandel.readAndroidXml("BTNadd", langXml, xmlPath);
		this.BTNfillFromBarcode = XmlHandel.readAndroidXml("BTNfillFromBarcode", langXml, xmlPath);
		this.badPassword = XmlHandel.readAndroidXml("badPassword", langXml, xmlPath);

		

		

		
		
		
		
		
		this.TEXTFIELDemailID = XmlHandel.readAndroidXml("TEXTFIELDemailID", langXml, xmlPath);
		this.TEXTFIELDpasswordID = XmlHandel.readAndroidXml("TEXTFIELDpasswordID", langXml, xmlPath);
		this.TEXTFIELDendpointURL = XmlHandel.readAndroidXml("TEXTFIELDendpointURL", langXml, xmlPath);

		
		
		this.scrollDown = XmlHandel.readAndroidXml("scrollDown", langXml, xmlPath);
		this.scrollUp = XmlHandel.readAndroidXml("scrollUp", langXml, xmlPath);		
		this.ConnectionAIRPLANE_MODE = XmlHandel.readAndroidXml("ConnectionAIRPLANE_MODE", langXml, xmlPath);
		this.ConnectionWIFI = XmlHandel.readAndroidXml("ConnectionWIFI", langXml, xmlPath);
		this.CoonectionDATA = XmlHandel.readAndroidXml("CoonectionDATA", langXml, xmlPath);
		this.ConnectionALL = XmlHandel.readAndroidXml("ConnectionALL", langXml, xmlPath);
		this.UserProd = XmlHandel.readAndroidXml("UserProd", langXml, xmlPath);
		this.DashboardName = XmlHandel.readAndroidXml("DashboardName", langXml, xmlPath);
		this.SalesName = XmlHandel.readAndroidXml("SalesName", langXml, xmlPath);
		this.ReturnsName = XmlHandel.readAndroidXml("ReturnsName", langXml, xmlPath);
		this.NetSalesName = XmlHandel.readAndroidXml("NetSalesName", langXml, xmlPath);	
		this.DailySalesBarID = XmlHandel.readAndroidXml("DailySalesBarID", langXml, xmlPath);		
		this.DailysalesPieID = XmlHandel.readAndroidXml("DailysalesPieID", langXml, xmlPath);		
		this.DestinyUSAID = XmlHandel.readAndroidXml("DestinyUSAID", langXml, xmlPath);		
		this.Last12hoursID = XmlHandel.readAndroidXml("Last12hoursID", langXml, xmlPath);		
		this.BranchID = XmlHandel.readAndroidXml("BranchID", langXml, xmlPath);		
		this.DailySalesID = XmlHandel.readAndroidXml("DailySalesID", langXml, xmlPath);		
		this.ServiceCallsID = XmlHandel.readAndroidXml("ServiceCallsID", langXml, xmlPath);		
		this.ServiceCallsMapID = XmlHandel.readAndroidXml("ServiceCallsMapID", langXml, xmlPath);		
		this.ContactsPermissionsName = XmlHandel.readAndroidXml("ContactsPermissionsName", langXml, xmlPath);		
		this.MallOfAmerica_Id = XmlHandel.readAndroidXml("MallOfAmerica_Id", langXml, xmlPath);		
		this.OrderLookup_ID = XmlHandel.readAndroidXml("OrderLookup_ID", langXml, xmlPath);		
		
		
		
		
		this.IconCancelENV = XmlHandel.readAndroidXml("IconCancelENV", langXml, xmlPath);		

		
		this.Iconaction_icon_green_Name = XmlHandel.readAndroidXml("Iconaction_icon_green_Name", langXml, xmlPath);		
		this.Icon_AllApps_Name = XmlHandel.readAndroidXml("Icon_AllApps_Name", langXml, xmlPath);	
		this.IconBack = XmlHandel.readAndroidXml("IconBack", langXml, xmlPath);	
		this.IconBack_Nav_Name = XmlHandel.readAndroidXml("IconBack_Nav_Name", langXml, xmlPath);	
		this.IconApplicationInfo_Name = XmlHandel.readAndroidXml("IconApplicationInfo_Name", langXml, xmlPath);	
		this.Icon_Map_Navigation = XmlHandel.readAndroidXml("Icon_Map_Navigation", langXml, xmlPath);	
		this.Icon_PieChart_Navigation = XmlHandel.readAndroidXml("Icon_PieChart_Navigation", langXml, xmlPath);	
		this.Icon_BarChart_Navigation = XmlHandel.readAndroidXml("Icon_BarChart_Navigation", langXml, xmlPath);	

		this.IconLoginSettings = XmlHandel.readAndroidXml("IconLoginSettings", langXml, xmlPath);	


	
		


		this.passwordProd = XmlHandel.readAndroidXml("passwordProd", langXml, xmlPath);
		this.userQA = XmlHandel.readAndroidXml("userQA", langXml, xmlPath);
		this.passwordQA = XmlHandel.readAndroidXml("passwordQA", langXml, xmlPath);
		this.StartupApplication = XmlHandel.readAndroidXml("StartupApplication", langXml, xmlPath);
		this.TabBarTitle_Name = XmlHandel.readAndroidXml("TabBarTitle_Name", langXml, xmlPath);
		this.UserNoAppsPermissions = XmlHandel.readAndroidXml("UserNoAppsPermissions", langXml, xmlPath);
		this.UserinActive = XmlHandel.readAndroidXml("UserinActive", langXml, xmlPath);

		
		
		
		
		

	}
	
}
