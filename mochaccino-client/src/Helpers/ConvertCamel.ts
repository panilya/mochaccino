export const exceptions = [
  {
    case: "url",
    default: "URL",
  },
  {
    case: "macAddress",
    default: "MAC Address",
  },
  {
    case: "publicIpV4Address",
    default: "Public IPv4 Address",
  },
  {
    case: "privateIpV4Address",
    default: "Private IPv4 Address",
  },
  {
    case: "ipV6Address",
    default: "IPv6 Address",
  },
  {
    case: "uuid",
    default: "UUID",
  },
  {
    case: "uuidv3",
    default: "UUIDv3",
  },
];

export const convertCamel = (camelString: string) => {
  let newStr = "";
  for (let i = 0; i < exceptions.length; i++) {
    if (exceptions[i].case === camelString) {
      return exceptions[i].default;
    }
  }
  for (let i = 0; i < camelString.length; i++) {
    if (camelString.charAt(i) === camelString.charAt(i).toUpperCase()) {
      newStr = newStr + " " + camelString.charAt(i);
    } else {
      i == 0
        ? (newStr += camelString.charAt(i).toUpperCase())
        : (newStr += camelString.charAt(i));
    }
  }
  return newStr;
};
