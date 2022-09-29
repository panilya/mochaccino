import { DataTypes } from "./Interfaces";

export const dataTypes: DataTypes = {
  fakeData: [
    {
      value: [
        { option: "firstName", example: "John" },
        { option: "lastName", example: " Sins" },
        { option: "fullName", example: "Johnatan Sins el-pochino" },
        { option: "address", example: "Street 1 , ohiys " },
        { option: "country", example: "Ukraine" },
        { option: "city", example: "Kyiv" },
        { option: "zipCode", example: "60427" },
        { option: "timeZone", example: "Asia/Singapore" },
      ],
      name: "Person",
      description: "A list of common, the most usable fake data",
      id: 1,
    },
  ],
};
