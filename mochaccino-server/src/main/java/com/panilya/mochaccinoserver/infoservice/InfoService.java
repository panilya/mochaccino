package com.panilya.mochaccinoserver.infoservice;

import com.panilya.mochaccinoserver.model.GroupInfoEntity;
import com.panilya.mochaccinoserver.model.ProviderInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    private final static List<ProviderInfo> NAME_GROUP_PROVIDERS_INFO = List.of(
            new ProviderInfo("firstName", "Freddy"),
            new ProviderInfo("lastName", "Doyle"),
            new ProviderInfo("fullName", "Bennie Howell")
    );

    private final static List<ProviderInfo> ADDRESS_GROUP_PROVIDERS_INFO = List.of(
            new ProviderInfo("address", "2337 Mraz Drives, Stantonfort, FL 87105"),
            new ProviderInfo("country", "Australia"),
            new ProviderInfo("city", "Grahamtown"),
            new ProviderInfo("zipCode", "85656"),
            new ProviderInfo("timeZone", "Europe/Kyiv")
    );

    private final static List<ProviderInfo> BUSINESS_GROUP_PROVIDERS_INFO = List.of(
            new ProviderInfo("creditCardNumber", "1234-2121-1221-1211"),
            new ProviderInfo("creditCardType", "american_express"),
            new ProviderInfo("creditCardExpire", "2022-11-11")
    );

    private final static List<ProviderInfo> COMMERCE_GROUP_PROVIDERS_INFO = List.of(
            new ProviderInfo("commerceDepartment", "Garden"),
            new ProviderInfo("commerceVendor", "Walmart"),
            new ProviderInfo("productName", "Small Cotton Hat"),
            new ProviderInfo("commerceBrand", "Dell"),
            new ProviderInfo("commerceMaterial", "Bronze")
    );

    private final static List<ProviderInfo> INTERNET_GROUP_PROVIDERS_INFO = List.of(
            new ProviderInfo("email", "richard.mills@hotmail.com"),
            new ProviderInfo("domainName", "hettinger.com"),
            new ProviderInfo("domainSuffix", "com"),
            new ProviderInfo("url", "www.damien-emmerich.io"),
            new ProviderInfo("password", "fv4cn64w66"),
            new ProviderInfo("macAddress", "6f:0e:8f:09:b2:45"),
            new ProviderInfo("publicIpV4Address", "137.50.163.112"),
            new ProviderInfo("privateIpV4Address", "127.159.16.111"),
            new ProviderInfo("ipV6Address", "68a:da7b:e10b:fc08:9b6f:1c9b:1358:cf82"),
            new ProviderInfo("uuidv3", "2028648a-0985-3b75-a1a1-34b619f65d55"),
            new ProviderInfo("uuid", "4c7c6767-469a-411d-a776-fd47f9adf778"),
            new ProviderInfo("userAgent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0")
    );

    private final static List<ProviderInfo> PHONE_NUMBER_PROVIDERS_INFO = List.of(
            new ProviderInfo("phoneNumberNational", "(980) 636-4539"),
            new ProviderInfo("phoneNumberInternational", "+1 814-606-3102"),
            new ProviderInfo("cellPhone", "(973) 415-1746")
    );

    private final static List<ProviderInfo> COMPANY_PROVIDERS_INFO = List.of(
            new ProviderInfo("companyName", "Kuhn-Ortiz"),
            new ProviderInfo("companySuffix", "Group"),
            new ProviderInfo("companyIndustry", "Consumer Electronics"),
            new ProviderInfo("companyProfession", "lawyer"),
            new ProviderInfo("companyURL", "www.schummllc.info")
    );

    private final static List<ProviderInfo> VEHICLE_PROVIDERS_INFO = List.of(
            new ProviderInfo("vehicleVIN", "DP5P03ZDA8AJ91242"),
            new ProviderInfo("vehicleManufacturer", "Hyundai"),
            new ProviderInfo("vehicleMaker", "Peugeot"),
            new ProviderInfo("vehicleModel", "Corolla"),
            new ProviderInfo("vehicleMakeAndModel", "Toyota Camry"),
            new ProviderInfo("vehicleStyle", "XL"),
            new ProviderInfo("vehicleColor", "Blue"),
            new ProviderInfo("vehicleUpholsteryColor", "Brown"),
            new ProviderInfo("vehicleUpholsteryFabric", "Cloth"),
            new ProviderInfo("vehicleUpholstery", "Brown Leather"),
            new ProviderInfo("vehicleTransmission", "Automatic"),
            new ProviderInfo("vehicleDriveType", "RWD"),
            new ProviderInfo("vehicleFuelType", "Gasoline"),
            new ProviderInfo("vehicleCarType", "Minivan"),
            new ProviderInfo("vehicleEngine", "8 Cylinder Engine"),
            new ProviderInfo("vehicleNumberOfDoors", "4"),
            new ProviderInfo("vehicleLicensePlate", "pow-3971")
    );

    private final static List<ProviderInfo> WEATHER_PROVIDERS_INFO = List.of(
            new ProviderInfo("weatherDescription", "Partly cloudy"),
            new ProviderInfo("weatherTemperatureCelsius", "-7°C"),
            new ProviderInfo("weatherTemperatureFahrenheit", "89°F")
    );

    private final static List<ProviderInfo> STOCK_PROVIDERS_INFO = List.of(
            new ProviderInfo("stockNSDQsymbol", "MERC"),
            new ProviderInfo("stockNYSEsymbol", "JFR")
    );

    private final static List<ProviderInfo> GENDER_PROVIDERS_INFO = List.of(
            new ProviderInfo("genderBinaryType", "Female"),
            new ProviderInfo("genderShortBinaryType", "f"),
            new ProviderInfo("genderType", "NonBinary")
    );

    private final static List<ProviderInfo> COMPUTER_PROVIDERS_INFO = List.of(
            new ProviderInfo("computerOperatingSystem", "Windows 11"),
            new ProviderInfo("computerPlatform", "macOS"),
            new ProviderInfo("computerType", "workstation")
    );

    public enum ProviderGroupInfo {
        NAME_GROUP(new GroupInfoEntity(NAME_GROUP_PROVIDERS_INFO, "Name", "A common group", 1L)),
        ADDRESS_GROUP(new GroupInfoEntity(ADDRESS_GROUP_PROVIDERS_INFO, "Address", "Address group", 2L)),
        PHONE_NUMBER_GROUP(new GroupInfoEntity(PHONE_NUMBER_PROVIDERS_INFO, "Phone Number", "Phone number group", 3L)),
        BUSINESS_GROUP(new GroupInfoEntity(BUSINESS_GROUP_PROVIDERS_INFO, "Business", "Business group", 4L)),
        COMMERCE_GROUP(new GroupInfoEntity(COMMERCE_GROUP_PROVIDERS_INFO, "Commerce", "Commerce group", 5L)),
        INTERNET_GROUP(new GroupInfoEntity(INTERNET_GROUP_PROVIDERS_INFO, "Internet", "Internet group", 6L)),
        COMPANY_GROUP(new GroupInfoEntity(COMPANY_PROVIDERS_INFO, "Company", "Company group", 7L)),
        VEHICLE_GROUP(new GroupInfoEntity(VEHICLE_PROVIDERS_INFO, "Vehicle", "Vehicle group", 8L)),
        WEATHER_GROUP(new GroupInfoEntity(WEATHER_PROVIDERS_INFO, "Weather", "Weather group", 9L)),
        STOCK_GROUP(new GroupInfoEntity(STOCK_PROVIDERS_INFO, "Stock", "Stock group", 10L)),
        GENDER_GROUP(new GroupInfoEntity(GENDER_PROVIDERS_INFO, "Gender", "Gender group", 11L)),
        COMPUTER_GROUP(new GroupInfoEntity(COMPUTER_PROVIDERS_INFO, "Computer", "Computer group", 12L));

        private final GroupInfoEntity groupInfo;

        ProviderGroupInfo(GroupInfoEntity groupInfo) {
            this.groupInfo = groupInfo;
        }

        public GroupInfoEntity getGroupInfo() {
            return groupInfo;
        }
    }

}
