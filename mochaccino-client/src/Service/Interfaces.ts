export interface DataTypes {
  fakeData: IFakeData[];
}
export interface IFakeData {
  value: IOption[];
  description: string;
  name: string;
  id: number;
}
export interface IOption {
  option: string;
  example: string;
}
