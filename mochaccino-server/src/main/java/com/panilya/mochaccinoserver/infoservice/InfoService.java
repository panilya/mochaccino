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

    public enum ProviderGroupInfo {
        NAME_GROUP(new GroupInfoEntity(NAME_GROUP_PROVIDERS_INFO, "Name", "A common group", 1L)),
        ADDRESS_GROUP(new GroupInfoEntity(ADDRESS_GROUP_PROVIDERS_INFO, "Address", "Address group", 2L)),
        BUSINESS_GROUP(new GroupInfoEntity(BUSINESS_GROUP_PROVIDERS_INFO, "Business", "Business group", 3L)),
        COMMERCE_GROUP(new GroupInfoEntity(COMMERCE_GROUP_PROVIDERS_INFO, "Commerce", "Commerce group", 4L));

        private final GroupInfoEntity groupInfo;

        ProviderGroupInfo(GroupInfoEntity groupInfo) {
            this.groupInfo = groupInfo;
        }

        public GroupInfoEntity getGroupInfo() {
            return groupInfo;
        }
    }

}
