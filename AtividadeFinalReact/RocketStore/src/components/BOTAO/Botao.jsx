import "./Styles/Botao.css";
export function Botao({ type, value, className }) {
  return (
    <>
      <button type={type} className={className}>
        {value}
      </button>
    </>
  );
}
