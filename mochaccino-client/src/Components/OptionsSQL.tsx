import { Form } from "react-bootstrap";
import { useAppDispatch, useAppSelector } from "../Hooks/useRedux";
import { setTableName, setDialect } from "../Redux/Slices/OptionSlice";

interface OptionsSQLProps {}

const OptionsSQL: React.FC<OptionsSQLProps> = () => {
  const { tableName, dialect } = useAppSelector(
    (state) => state.options.presets
  );
  const dispatch = useAppDispatch();

  const handleTableName = (event: React.ChangeEvent<HTMLInputElement>) => {
    dispatch(setTableName(event.target.value));
  };
  const handleDialectChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    dispatch(setDialect(event.target.value));
  };
  const dialects: string[] = [
    "ANSI",
    "BigQuery",
    "Calcite",
    "ClickHouse",
    "Exasol",
    "Firebolt",
    "H2",
    "Infobright",
    "LucidDB",
    "MariaDB",
    "MSSQL",
    "MySQL",
    "Netezza",
    "Oracle",
    "ParAccel",
    "Phoenix",
    "Postgres",
    "Presto",
    "RedShift",
    "Snowflake",
    "Teradata",
    "Vertica",
  ];
  return (
    <div>
      <Form>
        <Form.Label htmlFor="inputPassword5">Table name:</Form.Label>
        <Form.Control
          onChange={handleTableName}
          value={tableName}
          placeholder="Table name goes here..."
          aria-label="Table name input"
        />

        <Form.Label htmlFor="inputPassword5">Choose dialect:</Form.Label>
        <Form.Select
          className="select"
          value={dialect}
          onChange={handleDialectChange}
          aria-label="Dialect Select"
        >
          {dialects.map((database,id) => (
            <option key={id} value={database}>{database}</option>
          ))}
        </Form.Select>
      </Form>
    </div>
  );
};

export default OptionsSQL;
