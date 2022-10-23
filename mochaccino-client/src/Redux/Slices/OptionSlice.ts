import { createSlice, nanoid } from "@reduxjs/toolkit";
import type { PayloadAction } from "@reduxjs/toolkit";
import type { RootState } from "../Store";
import { IPresets, IProvider } from "../../Service/Interfaces";

interface OptionState {
  defaultLocale: string;
  presets: IPresets;
  value: IProvider[];
}
export interface ISetLocale {
  id: string;
  locale: string;
}
export interface IChangeProvider {
  id: string;
  provider: string;
}
const initialState: OptionState = {
  presets: {
    limit: "1000",
    dialect: "MySQL",
    header: true,
    format: "csv",
    tableName: "",
    separator: ",",
  },
  defaultLocale: "us",
  value: [],
};

export const optionSlice = createSlice({
  name: "option",
  initialState,
  reducers: {
    addOption: (state, action: PayloadAction<IProvider>) => {
      state.value.push({
        ...action.payload,
        providerName:action.payload.provider,
        id: nanoid(),
        locale: state.defaultLocale,
      });
    },
    changeOption: (state, action: PayloadAction<IChangeProvider>) => {
      state.value.map((el) => {
        if (el.id === action.payload.id) {
          return (el["provider"] = action.payload.provider);
        }
      });
    },

    setDefaultLocale: (state, action: PayloadAction<string>) => {
      state.defaultLocale = action.payload;
      if (state.defaultLocale !== "custom") {
        state.value.map((el) => (el["locale"] = state.defaultLocale));
      }
    },
    setLocale: (state, action: PayloadAction<ISetLocale>) => {
      state.defaultLocale = "custom";
      state.value.map((el) => {
        if (el.id === action.payload.id) {
          return (el["locale"] = action.payload.locale);
        }
      });
    },
    deleteOption: (state, action: PayloadAction<string>) => {
      state.value = state.value.filter((el) => el.id !== action.payload);
    },

    setLimit: (state, action: PayloadAction<string>) => {
      if (action.payload.charAt(0) === "-") {
        state.presets["limit"] = "";
      } else if (action.payload.charAt(0) === "0") {
        state.presets["limit"] = action.payload.substring(1);
      } else if (Number(action.payload) > 1000001) {
        state.presets["limit"] = "1000000";
      } else if (Number(action.payload) < 0) {
        state.presets["limit"] = "1";
      } else {
        state.presets["limit"] = action.payload;
      }
    },
    setDialect: (state, action: PayloadAction<string>) => {
      state.presets["dialect"] = action.payload;
    },
    setFormat: (state, action: PayloadAction<string>) => {
      state.presets["format"] = action.payload;
    },
    setTableName: (state, action: PayloadAction<string>) => {
      state.presets["tableName"] = action.payload;
    },
    setHeaders: (state, action: PayloadAction<boolean>) => {
      state.presets["header"] = action.payload;
    },
    setSeparator: (state, action: PayloadAction<string>) => {
      state.presets["separator"] = action.payload;
    },
  },
});

export const {
  addOption,
  deleteOption,
  setLocale,
  setDefaultLocale,
  setDialect,
  setFormat,
  setHeaders,
  setLimit,
  setSeparator,
  setTableName,
  changeOption,
} = optionSlice.actions;

export const selectCount = (state: RootState) => state.options;

export default optionSlice.reducer;
