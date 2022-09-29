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

    public enum ProviderGroupInfo {
        NAME_GROUP(new GroupInfoEntity(NAME_GROUP_PROVIDERS_INFO, "Name", "A common group", 1L)),
        ADDRESS_GROUP(new GroupInfoEntity(ADDRESS_GROUP_PROVIDERS_INFO, "Address", "Address group", 2L)),
        BUSINESS_GROUP(new GroupInfoEntity(BUSINESS_GROUP_PROVIDERS_INFO, "Business", "Business group", 3L)),
        COMMERCE_GROUP(new GroupInfoEntity(COMMERCE_GROUP_PROVIDERS_INFO, "Commerce", "Commerce group", 4L)),
        INTERNET_GROUP(new GroupInfoEntity(INTERNET_GROUP_PROVIDERS_INFO, "Internet", "Internet group", 5L));

        private final GroupInfoEntity groupInfo;

        ProviderGroupInfo(GroupInfoEntity groupInfo) {
            this.groupInfo = groupInfo;
        }

        public GroupInfoEntity getGroupInfo() {
            return groupInfo;
        }
    }

}
