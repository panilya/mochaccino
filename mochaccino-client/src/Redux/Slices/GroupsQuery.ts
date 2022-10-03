import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import { IFakeData } from "../../Service/Interfaces";

// Define a service using a base URL and expected endpoints
export const groupsApi = createApi({
  reducerPath: "groupsApi",
  baseQuery: fetchBaseQuery({
    baseUrl: "https://mochaccino-server.herokuapp.com/info/groups",
  }),
  endpoints: (builder) => ({
    getGroups: builder.query<IFakeData[], string>({
      query: () => ``,
    }),
  }),
});

export const { useGetGroupsQuery } = groupsApi;
