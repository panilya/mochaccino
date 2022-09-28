import { DataTypes } from "./Interfaces";

export const dataTypes: DataTypes = {
  person: {
    value: [
      "firstName",
      "lastName",
      "fullName",
      "address",
      "country",
      "city",
      "zipCode",
      "timeZone",
    ],
    description:"A list of common, the most usable fake data"
  },
};
