package common;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Config {

    // Environment & URLs
    // Changed https to http only for local test
    public static final String ENVIRONMENT_NAME = "qastable.com"; //Choose the environment on which you want to run automated tests (qadevelop.doublemap.com or qastable.doublemap.com)
    public static final String BASE_URL = "https://" + ENVIRONMENT_NAME + "/admin/users/login";
    public static final String BASE_URL_FOR_STOP = "https://" + ENVIRONMENT_NAME + "/admin/stops/view/";
    public static final String SUPER_ADMIN_SETTING_URL = "https://" + ENVIRONMENT_NAME + "/admin/settings";
    public static final String SUPER_ADMIN_USERS_URL = "https://" + ENVIRONMENT_NAME + "/admin/users";
    public static final String SUPER_ADMIN_SEASONS_URL = "https://" + ENVIRONMENT_NAME + "/admin/seasons/add";
    public static final String SUPER_ADMIN_BUSES_URL = "https://" + ENVIRONMENT_NAME + "/admin/buses/add";
    public static final String SUPER_ADMIN_DRIVERS_URL = "https://" + ENVIRONMENT_NAME + "/admin/drivers/add";
    public static final String SUPER_ADMIN_STOPS_URL = "https://" + ENVIRONMENT_NAME + "/admin/stops/add";
    public static final String SUPER_ADMIN_ROUTES_URL = "https://" + ENVIRONMENT_NAME + "/admin/routes/add";
    public static String PUBLIC_SITE_URL = "https://" + ENVIRONMENT_NAME + "/map";
    public static String PUBLIC_SITE_STOP_BOARD_URL = PUBLIC_SITE_URL + "/stop_board";

    // Credentials for exists users
    public static final String SUPERADMINNAME = "superAdmin";
    public static final String SUPERADMINPASSWORD = "pa$$woRd";
    public static final String USERNAME = "autouser"; //for qadevelop use autouser; for qastable use autoUser
    public static final String PASSWORD = "p@sst3st";
    public static final String VENDORNAME = "autovendor";
    public static final String VENDORPASS = "p@sst3st";


    // Credentials for users which will be created during auto-tests
    public static String NEW_ADMIN_USERNAME = "";
    public static String NEW_ADMIN_PASSWORD = "";
    public static String NEW_DISPATCHER_USERNAME = "";
    public static String NEW_DISPATCHER_PASSWORD = "";
    public static String NEW_USER_USERNAME = "";
    public static String NEW_USER_PASSWORD = "";
    public static String NEW_VIEWER_USERNAME = "";
    public static String NEW_VIEWER_PASSWORD = "";
    public static String NEW_VENDOR_USERNAME = "";
    public static String NEW_VENDOR_PASSWORD = "";

    //Hard data which created during Configuration Auto Tests
    public static String HARD_STOP_NAME = "Config_Stop_1";
    public static String HARD_ROUTE_NAME = "Config_Winter_Route";
    public static String SEASON_NAME = "Winter_Season";
    public static String HARD_DRIVER_NAME = "Config_Driver";
    public static String HARD_DELETED_DRIVER_NAME = "Config_Deleted_Driver";
    public static String CONFIG_ROUTE_NAME = "Config_Route";
    public static String CONFIG_BUS_NAME = "Config_Bus";

    // Other variables
    public static String NEW_DRIVER_NAME = "";
    public static String NEW_DRIVER_PIN = "";
    public static String ROUTE_NAME = "";
    public static String CHANGED_ROUTE_NAME = "";
    public static String CHANGED_ROUTE_DISPLAY_NAME = "";
    public static String CHANGED_ROUTE_ABBREVIATION = "";
    public static String CHANGED_ROUTE_PRONUNCIATION = "";
    public static String CHANGED_ROUTE_COLOR = "";
    public static String ROUTE_VIEW_URL = "";
    public static String RECEIVED_DELETING_ALERT_TEXT = "";
    public static String DELETING_ROUTE_ALERT_TEXT = "";
    public static String ROUTE_ID = "";
    public static String STOP_NAME = "";
    public static String SELECTED_ROUTE_NAME = "";
    public static String SELECTED_BUS_NAME = "";
    public static String SELECTED_NONE_ROUTE = "";
    public static String BUS_NAME_WITH_NONE_ROUTE = "";
    public static String BUS_NAME = "";
    public static String BUS_NAME_WITH_UNDERSCORE = "";
    public static String BUS_NAME_STATUS_ACTIVE = "";
    public static String BUS_NAME_STATUS_INACTIVE = "";
    public static String SIGN_NAME = "";
    public static String LINK_TITLE = "";
    public static String BUS_DRIVER_NAME = "";
    public static String SELECTED_DRIVER_NAME = "";
    public static String MAP_BUS_NAME = "";
    public static String MAP_ROUTE_NAME = "";
    public static String BUS_ROUTE_NAME_IN_DROPDOWN = "";
    public static ArrayList<String> LIST_ROUTES = new ArrayList<String>();
    public static ArrayList<String> LIST_ROUTES_FROM_BUSES = new ArrayList<String>();
    public static String DEVICE_BUS_NAME = "";
    public static String BUSES_TOTAL_COUNT = "";
    public static String EDITED_DEVICE_ID = "";
    public static String EDITED_DEVICE_BUS = "";
    public static String EDITED_DEVICE_NOTE = "";

    public static final String DOCTOR_NAME = "hr.doctor@hospitalrun.io";
    public static final String DOCTOR_PASS = "HRt3st12";
    public static final String NURSE_NAME = "hr.nurse@hospitalrun.io";
    public static final String NURSE_PASS = "HRt3st12";
    public static final String NURSE_MANAGER_NAME = "hr.nurse.manager@hospitalrun.io";
    public static final String NURSE_MANAGER_PASS = "HRt3st12";
    public static final String HOSPITAL_ADMINISTRATOR_NAME = "hr.hospital.admin@hospitalrun.io";
    public static final String HOSPITAL_ADMINISTRATOR_PASS = "HRt3st12";
    public static final String BUSINESS_OFFICE_NAME = "hr.hospital.office@hospitalrun.io";
    public static final String BUSINESS_OFFICE_PASS = "HRt3st12";
    public static final String PHARMACIST_NAME = "hr.pharmacist@hospitalrun.io";
    public static final String PHARMACIST_PASS = "HRt3st12";
    public static final String WRONG_NAME = "Katya";
    public static final String WRONG_PASS = "147852";

}

