import { createSlice } from "@reduxjs/toolkit";
import type { PayloadAction } from "@reduxjs/toolkit";
import type { RootState } from "../Store";
import { IOption } from "../../Service/Interfaces";

// Define a type for the slice state
interface OptionState {
  value: IOption[];
}

// Define the initial state using that type
const initialState: OptionState = {
  value: [],
};

export const optionSlice = createSlice({
  name: "option",
  // `createSlice` will infer the state type from the `initialState` argument
  initialState,
  reducers: {
    // Use the PayloadAction type to declare the contents of `action.payload`
    addOption: (state, action: PayloadAction<IOption>) => {
      state.value.push(action.payload);
    },
    deleteOption: (state, action: PayloadAction<string>) => {
      state.value = state.value.filter((el) => el.option !== action.payload);
    },
  },
});

export const { addOption, deleteOption } = optionSlice.actions;

// Other code such as selectors can use the imported `RootState` type
export const selectCount = (state: RootState) => state.options;

export default optionSlice.reducer;
