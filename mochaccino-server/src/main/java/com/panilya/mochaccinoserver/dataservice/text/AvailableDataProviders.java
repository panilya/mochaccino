package com.panilya.mochaccinoserver.dataservice.text;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum AvailableDataProviders {
    // Name
    FULL_NAME("fullName", () -> "full_name", faker -> faker.name().fullName()),
    FIRST_NAME("firstName", () -> "first_name", faker -> faker.name().firstName()),
    LAST_NAME("lastName", () -> "last_name", faker -> faker.name().lastName()),

    // Address
    ADDRESS("address", () -> "address", faker -> faker.address().fullAddress()),
    COUNTRY("country", () -> "country", faker -> faker.address().country()),
    CITY("city", () -> "city", faker -> faker.address().city()),
    STREET_ADDRESS("streetAddress", () -> "street_address", faker -> faker.address().streetAddress()),
    ZIP_CODE("zipCode", () -> "zip_code", faker -> faker.address().zipCode()),
    TIME_ZONE("timeZone", () -> "time_zone", faker -> faker.address().timeZone()),

    // Credit card
    CREDIT_CARD_NUMBER("creditCardNumber", () -> "credit_card_number", faker -> faker.business().creditCardNumber()),
    CREDIT_CARD_TYPE("creditCardType", () -> "credit_card_type", faker -> faker.business().creditCardType()),
    CREDIT_CARD_EXPIRE("creditCardExpire", () -> "credit_card_expire", faker -> faker.business().creditCardExpiry()),

    // Commerce
    COMMERCE_DEPARTMENT("commerceDepartment", () -> "commerce_department", faker -> faker.commerce().department()),
    COMMERCE_VENDOR("commerceVendor", () -> "commerce_vendor", faker -> faker.commerce().vendor()),
    COMMERCE_PRODUCT_NAME("productName", () -> "product_name", faker -> faker.commerce().productName()),
    COMMERCE_BRAND("commerceBrand", () -> "brand", faker -> faker.commerce().brand()),
    COMMERCE_MATERIAL("commerceMaterial", () -> "material", faker -> faker.commerce().material()),

    // Internet
    INTERNET_EMAIL_ADDRESS("email", () -> "email", faker -> faker.internet().emailAddress()),
    INTERNET_DOMAIN_NAME("domainName", () -> "domain_name", faker -> faker.internet().domainName()),
    INTERNET_DOMAIN_SUFFIX("domainSuffix", () -> "domain_suffix", faker -> faker.internet().domainSuffix()),
    INTERNET_URL("url", () -> "url", faker -> faker.internet().url()),
    INTERNET_PASSWORD("password", () -> "password", faker -> faker.internet().password()),
    INTERNET_MAC_ADDRESS("macAddress", () -> "mac_address", faker -> faker.internet().macAddress()),
    INTERNET_PUBLIC_IP_V4_ADDRESS("publicIpV4Address", () -> "public_ip_v4_address", faker -> faker.internet().publicIpV4Address()),
    INTERNET_PRIVATE_IP_V4_ADDRESS("privateIpV4Address", () -> "private_ip_v4_address", faker -> faker.internet().privateIpV4Address()),
    INTERNET_IP_V6_ADDRESS("ipV6Address", () -> "ip_v6_address", faker -> faker.internet().ipV6Address()),
    INTERNET_UUID_V3("uuidv3", () -> "uuidv3", faker -> faker.internet().uuidv3()),
    INTERNET_UUID("uuid", () -> "uuid", faker -> faker.internet().uuid()),
    INTERNET_USERAGENT("userAgent", () -> "user_agent", faker -> faker.internet().userAgent()),

    // Phone Number
    PHONE_NUMBER_NATIONAL("phoneNumberNational", () -> "phone_number_national", faker -> faker.phoneNumber().phoneNumber()),
    PHONE_NUMBER_INTERNATIONAL("phoneNumberInternational", () -> "phone_number_international", faker -> faker.phoneNumber().phoneNumberInternational()),
    CELL_PHONE("cellPhone", () -> "cell_phone", faker -> faker.phoneNumber().cellPhone()),

    // Company
    COMPANY_NAME("companyName", () -> "company_name", faker -> faker.company().name()),
    COMPANY_SUFFIX("companySuffix", () -> "company_suffix", faker -> faker.company().suffix()),
    COMPANY_INDUSTRY("companyIndustry", () -> "company_industry", faker -> faker.company().industry()),
    COMPANY_PROFESSION("companyProfession", () -> "company_profession", faker -> faker.company().profession()),
    COMPANY_URL("companyURL", () -> "company_url", faker -> faker.company().url()),

    // Vehicle
    VEHICLE_VIN("vehicleVIN", () -> "vehicle_vin", faker -> faker.vehicle().vin()),
    VEHICLE_MANUFACTURER("vehicleManufacturer", () -> "vehicle_manufacturer", faker -> faker.vehicle().manufacturer()),
    VEHICLE_MAKE("vehicleMaker", () -> "vehicle_make", faker -> faker.vehicle().make()),
    VEHICLE_MODEL("vehicleModel", () -> "vehicle_model", faker -> faker.vehicle().model()),
    VEHICLE_MAKE_AND_MODEL("vehicleMakeAndModel", () -> "vehicle_make_and_model", faker -> faker.vehicle().makeAndModel()),
    VEHICLE_STYLE("vehicleStyle", () -> "vehicle_style", faker -> faker.vehicle().style()),
    VEHICLE_COLOR("vehicleColor", () -> "vehicle_color", faker -> faker.vehicle().color()),
    VEHICLE_UPHOLSTERY_COLOR("vehicleUpholsteryColor", () -> "vehicle_upholstery_color", faker -> faker.vehicle().upholsteryColor()),
    VEHICLE_UPHOLSTERY_FABRIC("vehicleUpholsteryFabric", () -> "vehicle_upholstery_fabric", faker -> faker.vehicle().upholsteryFabric()),
    VEHICLE_UPHOLSTERY("vehicleUpholstery", () -> "vehicle_upholstery", faker -> faker.vehicle().upholstery()),
    VEHICLE_TRANSMISSION("vehicleTransmission", () -> "vehicle_transmission", faker -> faker.vehicle().transmission()),
    VEHICLE_DRIVE_TYPE("vehicleDriveType", () -> "vehicle_drive_type", faker -> faker.vehicle().driveType()),
    VEHICLE_FUEL_TYPE("vehicleFuelType", () -> "vehicle_fuel_type", faker -> faker.vehicle().fuelType()),
    VEHICLE_CAR_TYPE("vehicleCarType", () -> "vehicle_car_type", faker -> faker.vehicle().carType()),
    VEHICLE_ENGINE("vehicleEngine", () -> "vehicle_engine", faker -> faker.vehicle().engine()),
    VEHICLE_NUMBER_OF_DOORS("vehicleNumberOfDoors", () -> "vehicle_number_of_doors", faker -> faker.vehicle().doors()),
    VEHICLE_LICENSE_PLATE("vehicleLicensePlate", () -> "vehicle_license_plate", faker -> faker.vehicle().licensePlate()),

    // Weather
    WEATHER_DESCRIPTION("weatherDescription", () -> "weather_description", faker -> faker.weather().description()),
    WEATHER_TEMPERATURE_CELSIUS("weatherTemperatureCelsius", () -> "weather_temperature_celsius", faker -> faker.weather().temperatureCelsius()),
    WEATHER_TEMPERATURE_FAHRENHEIT("weatherTemperatureFahrenheit", () -> "weather_temperature_fahrenheit", faker -> faker.weather().temperatureFahrenheit()),

    // Stock
    STOCK_NSDQ("stockNSDQsymbol", () -> "stock_nsdq_symbol", faker -> faker.stock().nsdqSymbol()),
    STOCK_NYSE("stockNYSEsymbol", () -> "stock_nyse_symbol", faker -> faker.stock().nyseSymbol()),

    // Gender
    GENDER_BINARY_TYPE("genderBinaryType", () -> "gender_binary_type", faker -> faker.gender().binaryTypes()),
    GENDER_SHORT_BINARY_TYPE("genderShortBinaryType", () -> "gender_short_binary_type", faker -> faker.gender().shortBinaryTypes()),
    GENDER_TYPE("genderType", () -> "gender_type", faker -> faker.gender().types()),

    // Computer
    COMPUTER_OPERATING_SYSTEM("computerOperatingSystem", () -> "computer_operating_system", faker -> faker.computer().operatingSystem()),
    COMPUTER_PLATFORM("computerPlatform", () -> "computer_platform", faker -> faker.computer().platform()),
    COMPUTER_TYPE("computerType", () -> "computer_type", faker -> faker.computer().type());

    private final String name;
    private final Supplier<String> header; // Header of CSV file
    private final Function<Faker, String> provider;

    AvailableDataProviders(String name, Supplier<String> header, Function<Faker, String> provider) {
        this.name = name;
        this.header = header;
        this.provider = provider;
    }

    private static final Map<String, AvailableDataProviders> CSV_PROVIDER_MAP = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(t -> t.name, Function.identity())));

    public static AvailableDataProviders of(String name) {
        return CSV_PROVIDER_MAP.get(name);
    }

    public String getName() {
        return name;
    }

    public Supplier<String> getHeader() {
        return header;
    }

    public Function<Faker, String> getProvider() {
        return provider;
    }
}
