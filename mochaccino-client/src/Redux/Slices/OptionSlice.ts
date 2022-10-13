import { createSlice, nanoid } from "@reduxjs/toolkit";
import type { PayloadAction } from "@reduxjs/toolkit";
import type { RootState } from "../Store";
import { IProvider } from "../../Service/Interfaces";

interface OptionState {
  defaultLocale: string;
  value: IProvider[];
}
export interface ISetLocale {
  id: string;
  locale: string;
}
const initialState: OptionState = {
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
        id: nanoid(),
        locale: state.defaultLocale,
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
  },
});

export const { addOption, deleteOption, setLocale, setDefaultLocale } =
  optionSlice.actions;

export const selectCount = (state: RootState) => state.options;

export default optionSlice.reducer;
