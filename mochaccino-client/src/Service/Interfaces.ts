export interface DataTypes {
  fakeData: IFakeData[];
}
export interface IFakeData {
  providers: IProvider[];
  description: string;
  name: string;
  id: number;
}
export interface IPresets {
  limit: string;
  format: string;
  header: boolean;
  dialect: string;
  tableName: string;
  separator: string;
}
export interface IProvider {
  provider: string;
  example: string;
  id: string;
  locale: string;
}
