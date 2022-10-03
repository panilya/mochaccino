export interface DataTypes {
  fakeData: IFakeData[];
}
export interface IFakeData {
  providers: IProvider[];
  description: string;
  name: string;
  id: number;
}
export interface IProvider {
  provider: string;
  example: string;
}
